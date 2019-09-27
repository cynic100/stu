package com.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.StudentDao;
import com.domain.Student;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.JDBCUtil02;

/**
 * @Title: 接口实现
 * @Package package_name
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xu_yuxin
 * @date 2019年9月26日
 * @version V1.0
 */
public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findall() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "SELECT * FROM dbo.stu";
		return runner.query(sql, new BeanListHandler<Student>(Student.class));
	
	}

}
