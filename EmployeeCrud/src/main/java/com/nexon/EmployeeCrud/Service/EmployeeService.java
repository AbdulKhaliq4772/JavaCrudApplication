package com.nexon.EmployeeCrud.Service;

import com.nexon.EmployeeCrud.Entity.Employee;
import com.nexon.EmployeeCrud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

//    List<Employee> AllEmployees = new ArrayList<>();
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int id){
        return employeeRepository.findById(id).get();
    }

    public Employee updateEmployee(Employee employee){
        Employee emp =  employeeRepository.findById(employee.getId()).get();
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        return employeeRepository.save(emp);
    }

    public String deleteEmployee(int id){
        employeeRepository.deleteById(id);
        return "deleted"+id;
    }

}
