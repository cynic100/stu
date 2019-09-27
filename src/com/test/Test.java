package com.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.domain.Student;
import com.util.JDBCUtil02;

public class Test {

	@org.junit.Test
	public void test() throws SQLException {
		Connection conn = JDBCUtil02.getConn();
		System.out.println(conn);
		/*StudentDao dao= new StudentDaoImpl();
		List<Student> list = dao.findall();
		System.out.println(list.get(0).getName());
		*/
	}
}
