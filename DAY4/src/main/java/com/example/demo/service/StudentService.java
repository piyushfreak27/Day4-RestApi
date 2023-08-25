package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo sr;

	public List<Student> postServ(List<Student> s)
	{
		return (List<Student>)sr.saveAll(s);
	}

	public List<Student> getServ()
	{
		return sr.findAll();
	}

	public Optional<Student> getServById(int id)
	{
		return sr.findById(id);
	}

	public Student putServ(int id,Student s)
	{
		Student exist = sr.findById(id).orElse(null);
		if(exist != null)
		{
			if(s.getId() != 0)
			{
				exist.setId(s.getId());				
			}
			if(s.getName() != null)
			{
				exist.setName(s.getName());
			}
			if(s.getDept() != null)
			{
				exist.setDept(s.getDept());				
			}
			if(s.getEmail() !=null)
			{
				exist.setEmail(s.getEmail());				
			}
			return sr.save(exist);
		}
		else {
			return null;
		}
	}

	public void deleteServ(int id)
	{
		sr.deleteById(id);
	}
}