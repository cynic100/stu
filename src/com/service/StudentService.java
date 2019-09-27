package com.service;

import java.sql.SQLException;

import com.domain.Student;

public interface StudentService {
	/**  
	* @Description: 查询所有学生(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param 空    参数  
	* @return 学生集合    返回类型  
	* @throws  
	*/
	java.util.List<Student> findall() throws SQLException;
	
	/**  
	* @Description: 添加学生(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param Student类    参数  
	* @return void    返回类型  
	* @throws  
	*/
	void insert(Student student) throws SQLException;
}
