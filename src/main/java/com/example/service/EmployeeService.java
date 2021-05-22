package com.example.service;

import com.example.bean.Employee;

import java.util.List;

/**
 * @user KyZhang
 * @date
 */
public interface EmployeeService {
    List<Employee> findAll();

    void save(Employee emp);

    void delete(Integer id);

    Employee find(Integer id);

    void update(Employee emp);

}
