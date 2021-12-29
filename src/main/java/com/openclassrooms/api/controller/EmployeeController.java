package com.openclassrooms.api.controller;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees(){

        return employeeService.getEmployees();
    }
    /**
     * Create - Add a new employee
     * @param employee An object employee
     * @return The employee object saved
     */
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
            Employee empl = employeeService.saveEmployee(employee);
            return  empl;
    }
    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        Optional<Employee> employee = employeeService.getEmployee(id);
        if(employee.isPresent()){
            return  employee.get();
        }else{
            return  null;
        }
    }
    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param employee - The employee object updated
     * @return
     */
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){

        Optional<Employee> currentEmployee = employeeService.getEmployee(id);
        if(currentEmployee.isPresent()){
            //Employee savedEmployee = currentEmployee.get().;
            String firstName = employee.getFirstName();
            if(firstName != null){
                currentEmployee.get().setFirstName(firstName);
            }
            String lastName = employee.getLastName();
            if(lastName != null){
                currentEmployee.get().setLastName(lastName);
            }
            String mail = employee.getMail();
            if(mail != null){
                currentEmployee.get().setMail(mail);
            }
            String password = employee.getPassword();
            if(password != null){
                currentEmployee.get().setPassword(password);
            }
            employeeService.saveEmployee(currentEmployee.get());
            return  currentEmployee.get();
        }else{
            return  null;
        }
    }
    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id){

        employeeService.deleteEmployee(id);
    }


}
