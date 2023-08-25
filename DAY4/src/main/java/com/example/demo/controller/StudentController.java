package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;

	@PostMapping("postStu")
	public boolean addStu(@RequestBody List<Student> lst)
	{
		try {
			ss.postServ(lst);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@GetMapping("getStu")
	public List<Student> showStu()
	{
		return ss.getServ();
	}

	@GetMapping("/getStuWithId")
	public Optional<Student> showStuById(@RequestParam(value = "id") int id)
	{
		return ss.getServById(id);
	}

	@PutMapping("/putStu")
	public Student putStu(@RequestParam(value = "id")int id, @RequestBody Student s)
	{
		return ss.putServ(id, s);
	}

	@DeleteMapping("/delStu")
	public boolean delStu(@RequestParam(value = "id")int id)
	{
		try {
			ss.deleteServ(id);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}