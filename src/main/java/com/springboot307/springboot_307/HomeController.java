package com.springboot307.springboot_307;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @RequestMapping("/")
    public String index(Model model) {
        // 1st, let's create an Empoyee
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("55-12-1234");
        Laptop laptop = new Laptop();

        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL");
        employee.setLaptop(laptop);
        employeeRepository.save(employee);

        model.addAttribute("employee", employeeRepository.findAll());
        return "index";
    }
}
