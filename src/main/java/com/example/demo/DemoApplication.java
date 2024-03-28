package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@Controller
class EmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String index(Model model) {
        List<Map<String, Object>> employees = jdbcTemplate.queryForList("SELECT * FROM emp");
        model.addAttribute("employees", employees);
        return "index";
    }

	@GetMapping("/add")
    public String addEmployee() {
        return "add";
    }

	@PostMapping("/add")
	public String addEmp(@RequestParam String id,@RequestParam String name){
		String postQuery="insert into emp(id,name) values(?,?);";
		jdbcTemplate.update(postQuery,id,name);
		return "redirect:/add";
	}
}
