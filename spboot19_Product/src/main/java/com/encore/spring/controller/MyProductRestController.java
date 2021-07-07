package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = {" * "}, maxAge = 6000)
@Api(tags = {"My Product Rest Service"})
public class MyProductRestController {

	@Autowired
	private MyProductService service;
	
	@ApiOperation(value="상품 추가", response=MyProduct.class)
	@PostMapping("product")
	public ResponseEntity<MyProduct> addProduct(@RequestBody MyProduct vo) throws Exception {
		service.addProduct(vo);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(value="상품 검색 - 이름", response=List.class)
	@GetMapping("findByProductName/{name}")
	public ResponseEntity<List<MyProduct>> findByProductName(@PathVariable String name) throws Exception {
		List<MyProduct> list = service.findByProductName(name);
		if (list.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@ApiOperation(value="상품 리스트", response=List.class)
	@GetMapping("product")
	public ResponseEntity<List<MyProduct>> findProducts() throws Exception {
		List<MyProduct> list = service.findProducts();
		if (list.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@ApiOperation(value="상품 검색 - 메이커", response=List.class)
	@GetMapping("findByProductMaker/{maker}")
	public ResponseEntity<List<MyProduct>> findByProductMaker(@PathVariable String maker) throws Exception {
		System.out.println(maker);
		List<MyProduct> list = service.findByProductMaker(maker);
		if (list.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
}
