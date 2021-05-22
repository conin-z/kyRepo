package com.example.controller;

import com.example.bean.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @user KyZhang
 * @date
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public String findAll(Model model){
        List<Employee> all = employeeService.findAll();
        model.addAttribute("list",all);
        return "ems/emplist"; //try redirect...
    }

    @PostMapping("/update")
    public String update(Employee emp){
        employeeService.update(emp);
        return "redirect:/emp/list";
    }

    @GetMapping("/find")
    public String find(Integer id, Model model){   //Model替代了HttpServletRequest...
        model.addAttribute("emp", employeeService.find(id));
        return "ems/updateEmp";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        employeeService.delete(id);
        return "redirect:/emp/list";
    }

    @PostMapping("/save")
    public String save(Employee emp){
        employeeService.save(emp);
        return "redirect:/emp/list";
    }

}
