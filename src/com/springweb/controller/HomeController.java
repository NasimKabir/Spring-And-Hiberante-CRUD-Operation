package com.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springweb.model.Employee;
import com.springweb.service.EmployeeService;

@Controller
public class HomeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/")
	public String home(Model model) {
		List<Employee> view = employeeService.getEmployeeList();
		model.addAttribute("employee", view);
		return "home";
	}

	@RequestMapping(value = "/addEmployeeFrom")
	public String EmployeeFrom(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployeeFrom";
	}

	@PostMapping(value = "/EmployeeAdded")
	public String EmployeeAdded(@ModelAttribute("employee") Employee employee, BindingResult result) {
		employeeService.addEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/updateform")
	public String udpate(@RequestParam("id") int id, Model model) {
		Employee theemployee = employeeService.updateEmployee(id);
		model.addAttribute("employee", theemployee);
		return "addEmployeeFrom";
	}

	@RequestMapping("/deleteform")
	public String delete(@RequestParam("id") int id) {
		employeeService.delete(id);
		return "redirect:/";
	}
}
