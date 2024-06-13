package com.studentmvc.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentmvc.dao.StudentDAO;
import com.studentmvc.model.Student;
import com.studentmvc.util.SqlUtil;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int save(Student student) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("INSERT INTO student VALUES((?,?,?,?,?,?)");
			SqlUtil.stmt.setInt(1, student.getId());
			SqlUtil.stmt.setString(2, student.getName());
			SqlUtil.stmt.setString(3, student.getPhone());
			SqlUtil.stmt.setFloat(4, student.getMarks());
			SqlUtil.stmt.setString(5, student.getCity());
			SqlUtil.stmt.setString(6, student.getGender());
			result = SqlUtil.insert();
			
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> getAll() {
		List<Student> students = new ArrayList <>();
		try {
			SqlUtil.connectDb();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("SELECT * FROM student");
			ResultSet rs = SqlUtil.fetch();
			if(rs!=null) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					float marks = rs.getFloat("marks");
					String city = rs.getString("city");
					String gender = rs.getString("gender");
					Student student =  new Student(id, name, phone, marks,city,gender);
					students.add(student);
				}
			}
			SqlUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getById(int id) {
		Student student = null;
		try {
			
			SqlUtil.connectDb();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("SELECT * FROM student WHERE id=?");
			SqlUtil.stmt.setInt(1, id);
			ResultSet rs = SqlUtil.fetch();
			if(rs!=null) {
				if(rs.next()) {
					student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getString("phone"));
					student.setMarks(rs.getFloat("marks"));
					student.setCity(rs.getString("city"));
					student.setGender(rs.getString("gender"));
				}
			}
			SqlUtil.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public int remove(int id) {
		int result = -1;
		try {
			
			SqlUtil.connectDb();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("DELETE FROM student where id=?");
			SqlUtil.stmt.setInt(1, id);
			result = SqlUtil.delete();
			SqlUtil.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(int id, Student student) {
		int result = -1;
		try {
			
			SqlUtil.connectDb();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("UPDATE student SET name=?,city=?,marks=?,phone=? where id=?");
			SqlUtil.stmt.setString(1, student.getName());
			SqlUtil.stmt.setString(2, student.getPhone());
			SqlUtil.stmt.setString(3, student.getCity());
			SqlUtil.stmt.setFloat(4, student.getMarks());
			SqlUtil.stmt.setInt(5, student.getId());
			SqlUtil.stmt.setString(6, student.getGender());
			SqlUtil.update();
			
			SqlUtil.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
