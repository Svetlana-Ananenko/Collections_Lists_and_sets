package com.ollection.hw;

import com.ollection.hw.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private final List<Employee> employeeList;

    public EmployeeService() {
        this.employeeList = new ArrayList<>();
    }


    int maxEmployee = 2;

    public String first() {
        return "<b> Пока у нас один сотрудник и это Алексей Кестнер </b> ";
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeList.add(employee);
        //  if (employeeList.contains(firstName) && employeeList.contains(lastName)) {
        //      throw new EmployeeAlreadyAddedException();
        //  }
        //  if (maxEmployee < employeeList.size()) {
        //      throw new EmployeeStorageIsFullException();
        //  }
//
        //      employeeList.add(0, firstName);
        //      employeeList.add(1, lastName);
//
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}
