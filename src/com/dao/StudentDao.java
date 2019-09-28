package com.dao;

import java.awt.List;
import java.sql.SQLException;

import com.domain.*;
import com.servlet.DeleteServlet;
import com.servlet.SearchStudentServlet;

public interface StudentDao {	
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
	
	/**  
	* @Description: 跟进sid删除学生(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return return_type    返回类型  
	* @throws  
	*/
	void delete(int sid)throws SQLException;
	
	/**  
	* @Description: 跟进sid查询单个学生信息(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return return_type    返回类型  
	* @throws  
	*/
	Student findStudentByid(int sid) throws SQLException;
	/**  
	* @Description: 更新(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return return_type    返回类型  
	* @throws  
	*/
	void update (Student student )throws SQLException ;
	
	/**  
	* @Description: 跟进姓名获取性别模糊查询(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return return_type    返回类型  
	* @throws  
	*/
	java.util.List<Student> SearchStudent(String sname,String sgender)throws SQLException;
}
