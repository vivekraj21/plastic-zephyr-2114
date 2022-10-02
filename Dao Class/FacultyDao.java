package com.cms.dao;

import java.sql.SQLException;
import java.util.List;
import com.cms.bean.Batch;
import com.cms.bean.BatchAndCoursePlan;
import com.cms.bean.Course;
import com.cms.bean.CoursePlan;
import com.cms.bean.Faculty;
import com.cms.exceptions.FacultyException;

public interface FacultyDao {


		public String createFaculty(Faculty faculty);

		public String updateFaculty(Faculty faculty, int id) throws FacultyException, SQLException;
		
		public List<Faculty> viewAllFaculty() throws FacultyException;
		
		public String createCourse(Course course);
		
		public String updateCourse(Course course, int id) throws FacultyException;
		
		public List<Course> viewAllCourse() throws FacultyException;
		
		public String createBatch(Batch batch);
		
		public String updateBatch(Batch batch, int id) throws FacultyException, SQLException;
		
		public List<Batch> viewAllBatch() throws FacultyException;
		
		public String createCoursePlan(CoursePlan courseplan);
		
		public String updateCoursePlan(CoursePlan courseplan, int id) throws FacultyException;

		public List<CoursePlan> viewAllCoursePlan() throws FacultyException;
		
		public int loginFaculty(String username , String Password) throws FacultyException;
		
		public List<CoursePlan> FacultyCoursePlan(String unam,String Pass) throws FacultyException;
		
		public String fillPlanner(CoursePlan courseplan, int planid) throws FacultyException;

		public String updatefacultyPassword(Faculty faculty,String username,String password) throws FacultyException;
		
		public List<CoursePlan> daywiseUpdate() throws FacultyException;
		
		public List<BatchAndCoursePlan> Report() throws FacultyException;
		

	}

