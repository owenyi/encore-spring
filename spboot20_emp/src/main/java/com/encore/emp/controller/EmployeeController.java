package com.encore.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encore.emp.domain.EmployeeDto;
import com.encore.emp.service.EmpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = {" * "}, maxAge = 6000)
@Api(tags = {"Encore HRM"})
public class EmployeeController {

	@Autowired
	private EmpService service;
	
	// 1. findAllEmployees : 모든 사원의 정보를 반환한다.
	@ApiOperation(value="모든 사원의 정보를 반환한다.", response=List.class)
	@GetMapping("findAllEmployees")
	public ResponseEntity<List<EmployeeDto>> findAllEmployees() throws Exception {
		List<EmployeeDto> emps = service.findAllEmployees();
		if (emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emps, HttpStatus.OK);
	}
	
	// 2. getEmployeesTotal : 모든 사원의 총 인원수를 반환한다.
	@ApiOperation(value="모든 사원의 총 인원수를 반환한다.", response=Integer.class)
	@GetMapping("getEmployeesTotal")
	public ResponseEntity<Integer> getEmployeesTotal() throws Exception {
		Integer total = service.getEmployeesTotal();
		if (total == 0) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(total, HttpStatus.OK);
	}
	
	// 3. findEmployeeById : 사원 아이디로 사원의 정보를 찾는다.
	@ApiOperation(value="사원 아이디로 사원의 정보를 찾는다.", response=EmployeeDto.class)
	@GetMapping("findEmployeeById/{id}")
	public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable int id) throws Exception {
		EmployeeDto emp = service.findEmployeeById(id);
		if (emp == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emp, HttpStatus.OK);
	}
	
	// 4. findLikeEmployees : 특정한 이름이 들어간 사원을 찾는다.
	@ApiOperation(value="특정한 이름이 들어간 사원을 찾는다.", response=List.class)
	@GetMapping("findLikeEmployees/{name}")
	public ResponseEntity<List<EmployeeDto>> findLikeEmployees(@PathVariable String name) throws Exception {
		List<EmployeeDto> emps = service.findLikeEmployees(name);
		if (emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emps, HttpStatus.OK);
	}
	
	// 5. findEmployeesByManagerId : 특정한 매니저에 소속된 사원들을 찾는다.
	@ApiOperation(value="특정한 매니저에 소속된 사원들을 찾는다.", response=List.class)
	@GetMapping("findEmployeesByManagerId/{managerId}")
	public ResponseEntity<List<EmployeeDto>> findEmployeesByManagerId(@PathVariable int managerId) throws Exception {
		List<EmployeeDto> emps = service.findEmployeesByManagerId(managerId);
		if (emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emps, HttpStatus.OK);
	}
	
	// 6. addEmployee : 특정한 사원을 추가한다.
	@ApiOperation(value="특정한 사원을 추가한다.", response=EmployeeDto.class)
	@PostMapping("addEmployee")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto) throws Exception {
		service.addEmployee(dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	// 7. updateEmployee : 사원의 정보를 수정한다.
	@ApiOperation(value="사원의 정보를 수정한다.", response=EmployeeDto.class)
	@PutMapping("updateEmployee")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto) throws Exception {
		boolean result = service.updateEmployee(dto);
		if (!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK);
	}
	
	// 8. deleteEmployee : 해당 사원의 정보를 삭제한다.
	@ApiOperation(value="해당 사원의 정보를 삭제한다.", response=EmployeeDto.class)
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable int id) throws Exception {
		boolean result = service.deleteEmployee(id);
		if (!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK);
	}
	
}
