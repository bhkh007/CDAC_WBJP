package com.studentmvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studentmvc.daoimpl.StudentDAOImpl;
import com.studentmvc.model.Student;
import com.studentmvc.service.StudentService;
import com.studentmvc.serviceimpl.StudentServiceImpl;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	StudentServiceImpl studentserviceimpl;
	
    public StudentController() {
        
        studentserviceimpl = new StudentServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			float marks = Float.parseFloat(request.getParameter("marks"));
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String city = request.getParameter("city");
			String gender = request.getParameter("gender");
			Student student = new Student(id, name, phone, marks, city, gender);
			studentserviceimpl.save(student);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
