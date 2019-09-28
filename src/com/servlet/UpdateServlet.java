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
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			int sid= Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			String[] h = request.getParameterValues("hobby");
			String hobby = Arrays.toString(h);
			hobby = hobby.substring(1, hobby.length() - 1);
			String info = request.getParameter("info");
			Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
			Student student = new Student(sid, sname, gender, phone, date, hobby, info);
			StudentService service = new StudentServiceImpl();
			service.update(student);
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getRequestDispatcher("StudentListServlet").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
