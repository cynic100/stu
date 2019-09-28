package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.domain.Student;
import com.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findall() throws SQLException {
		StudentDao dao= new StudentDaoImpl();
		return dao.findall();
	}

	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao= new StudentDaoImpl();
		dao.insert(student);
	}

	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao= new StudentDaoImpl();
		dao.delete(sid);
	}

	@Override
	public Student findStudentByid(int sid) throws SQLException {
		StudentDao dao= new StudentDaoImpl();
		return dao.findStudentByid(sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao= new StudentDaoImpl();
		dao.update(student);
		
	}

	@Override
	public List<Student> SearchStudent(String sname, String sgender) throws SQLException {
		StudentDao dao= new StudentDaoImpl();
		return dao.SearchStudent(sname, sgender);
	}

	
}
