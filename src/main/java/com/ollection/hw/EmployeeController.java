package com.ollection.hw;

import com.ollection.hw.exceptions.EmployeeAlreadyAddedException;
import com.ollection.hw.exceptions.EmployeeNotFoundException;
import com.ollection.hw.exceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping
    public String first() {
        return employeeService.first();
    }

    @GetMapping(path = "/employee/add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeService.add(firstName, lastName);
        } catch (EmployeeAlreadyAddedException r) {
            System.out.println("В коллекции уже есть такой сотрудник");
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Превышен лимит количества сотрудников в фирме");
        }
        return employeeService.add(firstName, lastName);


    }


    @GetMapping(path = "/employee/remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeService.remove(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
        }
        return employeeService.remove(firstName, lastName);
    }


    @GetMapping(path = "/employee/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeService.find(firstName, lastName);

        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
        }

        return employeeService.find(firstName, lastName);
    }


    @GetMapping(path = "/employee")
    public Collection <Employee> findAll  () {
        return employeeService.findAll();
    }




}
