package com.example.dao;

import com.example.bean.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @user KyZhang
 * @date
 */
@Repository
public interface EmployeeDAO {

    List<Employee> findAll();

    void save(Employee emp);

    void delete(Integer id);

    Employee find(Integer id);

    void update(Employee emp);

}
