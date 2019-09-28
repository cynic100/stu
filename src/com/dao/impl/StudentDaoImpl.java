package com.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.StudentDao;
import com.domain.Student;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.JDBCUtil02;
import com.util.TextUtils;

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

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "INSERT INTO dbo.stu ( sname ,gender,phone,birthday,hobby,info)  VALUES (?,?,?,?,?,?)";
		runner.update(sql, student.getSname(), student.getGender(), student.getPhone(), student.getBirthday(),
				student.getHobby(), student.getInfo());
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "delete from stu where sid=?";
		runner.update(sql, sid);
	}

	@Override
	public Student findStudentByid(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu where sid=?";
		return runner.query(sql, new BeanHandler<Student>(Student.class), sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set sname=? , gender=? , phone=? , birthday=? , hobby=? , info=? where sid = ?",
				student.getSname(), student.getGender(), student.getPhone(), student.getBirthday(), student.getHobby(),
				student.getInfo(), student.getSid());
	}

	@Override
	public List<Student> SearchStudent(String sname, String sgender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		StringBuilder sqlBuilder = new StringBuilder();
		List<String> list = new ArrayList<String>();
		sqlBuilder.append("select * from stu where 1=1 ");
		
		
		if (!TextUtils.isEmpty(sname)) {
			sqlBuilder.append(" and sname like ?");
			list.add("%"+sname+"%");
		}
		if (!TextUtils.isEmpty(sgender)) {
			sqlBuilder.append(" and gender like ?");
			list.add(sgender);
		}
		return runner.query(sqlBuilder.toString(), new BeanListHandler<Student>(Student.class),list.toArray());
		
		
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		StringBuilder sql = new StringBuilder();
		sql.append("EXEC P_GetInfoByPage ?");		
		
		return runner.query(sql.toString(), new BeanListHandler<Student>(Student.class),currentPage);

	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return (int) runner.query("select count(*) from stu", new ScalarHandler());
	}
	
	

}
