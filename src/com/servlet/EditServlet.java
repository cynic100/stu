package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

/**   
* @Description: 处理单个学生更新，跟进sid获取学生信息(用一句话描述该文件做什么)  
* @author xu_yuxin
* @date 2019年9月28日  
* @version V1.0  
*/
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid= Integer.parseInt(request.getParameter("sid"));
		StudentService service= new StudentServiceImpl();
		try {
			Student student = service.findStudentByid(sid);
			request.setAttribute("stu", student);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
