package com.developer.employeemanagement.controller;


import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.developer.employeemanagement.constants.NameSpaceConstants;

@Slf4j
@CrossOrigin("http://localhost:3016/employee")
@RestController
@RequestMapping(value = NameSpaceConstants.BASE_URL)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value=NameSpaceConstants.GET_EMPLOYEE)
    public List<EmployeeEntity> findAllEmployee() {
        //log.debug("All employees are found.");
        return employeeService.findAllEmployee();
    }

    @GetMapping(value = NameSpaceConstants.GET_EMPLOYEEID)
    public Optional<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id) {
        //log.debug("Employee found with ID"+id);
        return employeeService.findById(id);
    }

    @DeleteMapping(value = NameSpaceConstants.DELETE_EMPLOYEE)
    public void deleteEmployee(@PathVariable("id") Long id) {
        //log.debug("Employee deleted with ID"+id);
        employeeService.deleteEmployee(id);
    }

    @PostMapping(value = NameSpaceConstants.ADD_EMPLOYEE)
    public EmployeeResponse saveEmpResponse(@RequestBody EmployeeRequest employeeRequest) {
        //log.debug("Employee saved.");
        return employeeService.saveEmployee(employeeRequest);
    }

    @PutMapping(value = NameSpaceConstants.UPDATE_EMPLOYEE)
    public EmployeeResponse updateEmpResponse(@RequestBody EmployeeRequest employeeRequest, @PathVariable("id") Long id) {
        //log.debug("Employee Updated."+id);
        return employeeService.updateEmployee(employeeRequest, id);
    }


    /*@PostMapping(value = NameSpaceConstants.ADD_EMPLOYEE)
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }

    @PutMapping(value = NameSpaceConstants.UPDATE_EMPLOYEE)
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.updateEmployee(employeeEntity);
    }*/


}
