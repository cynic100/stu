package com.service;

import java.sql.SQLException;

import com.domain.Student;

public interface StudentService {
	java.util.List<Student> findall() throws SQLException;
}
