package com.example.service;

import com.example.bean.Employee;
import com.example.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @user KyZhang
 * @date
 */
@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employee> findAll() {
        List<Employee> all = employeeDAO.findAll();
        return all;
    }

    @Override
    public void save(Employee emp) {
        String s = UUID.randomUUID().toString();
        emp.setId(Integer.valueOf(s.substring(0,5),16));
        employeeDAO.save(emp);
    }

    @Override
    public void delete(Integer id) {
            employeeDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Employee find(Integer id) {
        return employeeDAO.find(id);
    }

    @Override
    public void update(Employee emp) {
        employeeDAO.update(emp);
    }
}
