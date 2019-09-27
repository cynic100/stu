package com.dao;

import java.awt.List;
import java.sql.SQLException;

import com.domain.*;

public interface StudentDao {	
	java.util.List<Student> findall() throws SQLException;
}
