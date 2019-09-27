package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
/**
 * @Title: 用于处理学生添加请求
 * @Package package_name
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xu_yuxin
 * @date 2019年9月27日
 * @version V1.0
 */
public class AddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		try {
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			String[] h = request.getParameterValues("hobby");
			System.out.println(h);
			String hobby = Arrays.toString(h);
			System.out.println(hobby);
			hobby = hobby.substring(1, hobby.length() - 1);
			System.out.println(hobby);
			String info = request.getParameter("info");
			Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
			Student student = new Student(0, sname, gender, phone, date, hobby, info);
			System.out.println(student.toString());
			StudentService service = new StudentServiceImpl();
			service.insert(student);
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
		;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
