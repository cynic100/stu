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

	
}
