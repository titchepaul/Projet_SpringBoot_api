package com.openclassrooms.api.service;


import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(Long id){
        return  employeeRepository.findById(id);
    }
    public Iterable<Employee> getEmployees(){

        return employeeRepository.findAll();
    }
    public void deleteEmployee(Long id){

        employeeRepository.deleteById(id);
    }
    public Employee saveEmployee(Employee employee){
        Employee empl = employeeRepository.save(employee);
        return  empl;
    }
}
