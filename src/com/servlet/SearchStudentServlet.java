package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class SearchStudentServlet
 */
public class SearchStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sname = request.getParameter("sname");
		String sgender = request.getParameter("sgender");

		StudentService service = new StudentServiceImpl();
		try {
			List<Student> list = service.SearchStudent(sname, sgender);

			//2. 先把数据存储到作用域中
			request.setAttribute("list", list);
			//3. 跳转页面
			request.getRequestDispatcher("list.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
