package com.studentcrud.controllers;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentcrud.daoimpl.StudentDAOImpl;
import com.studentcrud.models.Student;


public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    StudentDAOImpl studentDAOImpl;
	
    public UpdateController() {
        super();
       studentDAOImpl = new StudentDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Student student = studentDAOImpl.getById(id);
			if (student != null) {
				student.setName(request.getParameter("name"));
				student.setPhone(request.getParameter("phone"));
				student.setCity(request.getParameter("city"));
				student.setGender(request.getParameter("gender"));
				student.setMarks(Float.parseFloat(request.getParameter("marks")));

				int result = studentDAOImpl.update(student);
				if (result > 0) {
					printWriter.println("<h3>Student updated successfully</h3>");
				} else {
					printWriter.println("<h3>Failed to update student</h3>");
				}
			} else {
				printWriter.println("<h3>Student not found</h3>");
			}
		} catch (Exception e) {
			System.out.println(e);
			printWriter.println("<h3>Something went wrong...</h3>");
		}
	}

}
