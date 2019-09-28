package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.PageBean;
import com.domain.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

/**   
* @Description: 用于分页显示(用一句话描述该文件做什么)  
* @author xu_yuxin
* @date 2019年9月28日  
* @version V1.0  
*/
public class StudentListPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		StudentService service = new StudentServiceImpl();
		try {
			PageBean pageBean = service.findStudentByPage(currentPage);
			request.setAttribute("pageBean", pageBean);
			
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
