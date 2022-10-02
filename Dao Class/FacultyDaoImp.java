package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cms.bean.Batch;
import com.cms.bean.BatchAndCoursePlan;
import com.cms.bean.Course;
import com.cms.bean.CoursePlan;
import com.cms.bean.Faculty;
import com.cms.exceptions.FacultyException;
import com.cms.utility.DBUtil;

public class FacultyDaoImp implements FacultyDao {

	@Override
	public String createFaculty(Faculty faculty) {
		String message = "Not Inserted...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("insert into faculty values(?,?,?,?,?,?,?)");
		
		ps.setInt(1, faculty.getFacultyid());
	 	ps.setString(2, faculty.getFacultyname());
	 	ps.setString(3, faculty.getFacultyadd());
	 	ps.setString(4,faculty.getMobile());
	 	ps.setString(5,faculty.getEmail());
	 	ps.setString(6,faculty.getUsername());
	 	ps.setString(7,faculty.getPassword());
	 	
	 	int x = ps.executeUpdate();
	 	if(x > 0) {
	 		message = "Faculty registered sucessfully...";
	 	}
			}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	 
	}
	
	@Override
	public String updateFaculty(Faculty faculty, int id) throws SQLException {
		String message = "Not Updated...";
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE faculty SET facultyid=?,facultyname=?,facultyadd=?,mobile=?,email=?,username=?,password=? WHERE facultyid="+id+" ");
			ps.setInt(1, faculty.getFacultyid());
		 	ps.setString(2, faculty.getFacultyname());
		 	ps.setString(3, faculty.getFacultyadd());
		 	ps.setString(4,faculty.getMobile());
		 	ps.setString(5,faculty.getEmail());
		 	ps.setString(6,faculty.getUsername());
		 	ps.setString(7,faculty.getPassword());
		 	
			int y;
			try {
				y = ps.executeUpdate();

			 	if(y>0) {
			 		message = "Faculty updated sucessfully...";
			 		System.out.println(message);
			 	}
			 	else throw new FacultyException("Faculty does not exist with id "+id);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}catch( FacultyException e) {
			message = e.getMessage();
		}
			return message;
	}

	@Override
	public List<Faculty> viewAllFaculty() throws FacultyException {
		List<Faculty> facultylist = new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			
		   PreparedStatement ps= conn.prepareStatement("select * from faculty");
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   int id = rs.getInt("facultyid");
			   String nam = rs.getString("facultyname");
			   String add = rs.getString("facultyadd");
			   String mob = rs.getString("mobile");
			   String email = rs.getString("email");
			   String user = rs.getString("username");
			   String pass = rs.getString("password");
			   
			   Faculty faculty = new Faculty(id,nam,add,mob,email,user,pass);
			   facultylist.add(faculty);
		   }
		}catch(SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		if(facultylist.size()==0) {
			throw new FacultyException("No Faculty found...");
		}
		
		return facultylist;
	}

	@Override
	public String createCourse(Course course) {
        String message = "Not Inserted...";
		try(Connection conn = DBUtil.provideConnection()){
		PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?)");
		ps.setInt(1, course.getCourseid());
	 	ps.setString(2, course.getCoursename());
	 	ps.setInt(3, course.getFee());
	 	ps.setString(4, course.getCoursedesc());
	 	int x = ps.executeUpdate();
	 	if(x > 0) {
	 		message = "Course registered sucessfully...";
	 	}
			}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public String updateCourse(Course course, int id) throws FacultyException {
        String message = "Not Updated...";
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE course SET courseid=?,coursename=?,fee=?,coursedesc=? WHERE courseid="+id+" ");
			ps.setInt(1, course.getCourseid());
		 	ps.setString(2, course.getCoursename());
		 	ps.setInt(3, course.getFee());
		 	ps.setString(4,course.getCoursedesc());
		 	
		 	
			int y = ps.executeUpdate();
		 	if(y > 0) {
		 		message = "Course updated sucessfully...";
		 		System.out.println(message);
		 	}
		 	else throw new FacultyException("Course does not exist with id "+id);
			
		}catch(SQLException | FacultyException e) {
			message = e.getMessage();
		}
			return message;
	}

	@Override
	public List<Course> viewAllCourse() throws FacultyException {
        List<Course> courselist = new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			
		   PreparedStatement ps= conn.prepareStatement("select * from course");
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   int id = rs.getInt("courseid");
			   String nam = rs.getString("coursename");
			   int fee = rs.getInt("fee");
			   String cdesc = rs.getString("coursedesc");
			   
			   
			   Course course = new Course(id,nam,fee,cdesc);
			   courselist.add(course);
		   }
		}catch(SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		if(courselist.size()==0) {
			throw new FacultyException("No Faculty found...");
		}
		
		return courselist;
	}

	@Override
	public String createBatch(Batch batch) {
        String message = "Not Inserted...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("insert into batch values(?,?,?,?,?,?)");
		
		ps.setInt(1, batch.getBatchid());
	 	ps.setInt(2, batch.getCourseid());
	 	ps.setInt(3, batch.getFacultyid());
	 	ps.setInt(4,batch.getNumstud());
	 	ps.setLong(5,batch.getStartdate());
	 	ps.setInt(6,batch.getDuration());
	 	
	 	
	 	int x = ps.executeUpdate();
	 	if(x > 0) {
	 		message = "Batch registered sucessfully...";
	 	}
			}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public String updateBatch(Batch batch, int id) throws FacultyException, SQLException {
        String message = "Not Updated...";
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE batch SET batchid=?,courseid=?,facultyid=?,numstud=?,startdate=?,duration=? where batchid="+id+"");
			
			ps.setInt(1, batch.getBatchid());
		 	ps.setInt(2, batch.getCourseid());
		 	ps.setInt(3,batch.getFacultyid());
		 	ps.setInt(4,batch.getNumstud());
		 	ps.setLong(5,batch.getStartdate());
		 	ps.setInt(6,batch.getDuration());
		 	
			int y = ps.executeUpdate();
			
			if(y>0) {
			 		message = "Batch registered sucessfully...";
			 		System.out.println(message);
			 	}
		       }catch(SQLException e) {
					message = e.getMessage();
				}
				return message;
		

	}

	@Override
	public List<Batch> viewAllBatch() throws FacultyException {
		  List<Batch> batchlist = new ArrayList<>();
			
			try(Connection conn=DBUtil.provideConnection()){
				
			   PreparedStatement ps= conn.prepareStatement("select * from batch");
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   int bid = rs.getInt("batchid");
				   int cid = rs.getInt("courseid");
				   int fid = rs.getInt("facultyid");
				   int numstud = rs.getInt("numstud");
				   long dat = rs.getLong("startdate");
				   int duration = rs.getInt("duration");
				   
				   Batch batch = new Batch(bid,cid,fid,numstud,dat,duration);
				   batchlist.add(batch);
			   }
			}catch(SQLException e) {
				throw new FacultyException(e.getMessage());
			}
			if(batchlist.size()==0) {
				throw new FacultyException("No Faculty found...");
			}
			
			return batchlist;
	}

	@Override
	public String createCoursePlan(CoursePlan courseplan) {
        String message = "Not Inserted...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("insert into courseplan values(?,?,?,?,?)");
		
		ps.setInt(1, courseplan.getPlanid());
		ps.setInt(2, courseplan.getBatchid());
		ps.setInt(3, courseplan.getDaynumber());
	 	ps.setString(4, courseplan.getTopic());
	 	ps.setString(5, courseplan.getStatus());
	 	
	 	
	 	int x = ps.executeUpdate();
	 	if(x > 0) {
	 		message = "Courseplan registered sucessfully...";
	 	}
			}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public String updateCoursePlan(CoursePlan courseplan, int id) throws FacultyException {
		 String message = "Not Updated...";
			
			try(Connection conn = DBUtil.provideConnection()){
				PreparedStatement ps = conn.prepareStatement("UPDATE courseplan SET planid=?,batchid=?,daynumber=?,topic=?,status=? WHERE planid="+id+" ");
				ps.setInt(1, courseplan.getPlanid());
				ps.setInt(2, courseplan.getBatchid());
				ps.setInt(3, courseplan.getDaynumber());
			 	ps.setString(4, courseplan.getTopic());
			 	ps.setString(5,courseplan.getStatus());
			 	
			 	
				int y = ps.executeUpdate();
			 	if(y > 0) {
			 		message = "Courseplan updated sucessfully...";
			 		System.out.println(message);
			 	}
			 	else throw new FacultyException("Courseplan does not exist with id "+id);
				
			}catch(SQLException | FacultyException e) {
				message = e.getMessage();
			}
				return message;
	}

	@Override
	public List<CoursePlan> viewAllCoursePlan() throws FacultyException {
        List<CoursePlan> courseplanlist = new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			
		   PreparedStatement ps= conn.prepareStatement("select * from courseplan");
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   int pid = rs.getInt("planid");
			   int bid = rs.getInt("batchid");
			   int day = rs.getInt("daynumber");
			   String topic = rs.getString("topic");
			   String stat = rs.getString("status");
			   
			   
			   CoursePlan courseplan = new CoursePlan(pid,bid,day,topic,stat);
			   courseplanlist.add(courseplan);
		   }
		}catch(SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		if(courseplanlist.size()==0) {
			throw new FacultyException("No Faculty found...");
		}
		
		return courseplanlist;
	}

	@Override
	public int loginFaculty(String username, String Password) throws FacultyException {
		
		int present;
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from faculty where username=? and Password=?");
			ps.setString(1, username);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				present = 1;
			}
			else {
				present=0;
				throw new FacultyException("Invalid username or password..");
			}
			
		}catch(SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		return present;
	}

	@Override
	public List<CoursePlan> FacultyCoursePlan(String unam,String pass) throws FacultyException {
        List<CoursePlan> fcourseplanlist = new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			
		   PreparedStatement ps= conn.prepareStatement("select * from courseplan where batchid in (select batchid from batch where facultyid=(select facultyid from faculty where username=? and password=?));");
		   ps.setString(1,unam);
		   ps.setString(2, pass);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   int pid = rs.getInt("planid");
			   int bid = rs.getInt("batchid");
			   int day = rs.getInt("daynumber");
			   String topic = rs.getString("topic");
			   String stat = rs.getString("status");
			   
			   
			   CoursePlan courseplan = new CoursePlan(pid,bid,day,topic,stat);
			   fcourseplanlist.add(courseplan);
		   }
		}catch(SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		if(fcourseplanlist.size()==0) {
			throw new FacultyException("No course plan for you yet....");
		}
		
		return fcourseplanlist;
	}

	@Override
	public String fillPlanner(CoursePlan courseplan, int planid) throws FacultyException {
		 String message = "Not Updated...";
			
			try(Connection conn = DBUtil.provideConnection()){
				PreparedStatement ps = conn.prepareStatement("UPDATE courseplan SET status=? WHERE planid="+planid+" ");
			 	ps.setString(1,courseplan.getStatus());
			 	
			 	
				int y = ps.executeUpdate();
			 	if(y > 0) {
			 		message = "Planner status filled sucessfully...";
			 		System.out.println(message);
			 	}
			 	else throw new FacultyException("Courseplan does not exist with id "+planid);
				
			}catch(SQLException | FacultyException e) {
				message = e.getMessage();
			}
				return message;
	}

	@Override
	public String updatefacultyPassword(Faculty faculty,String username,String password) throws FacultyException {
		 String message = "Not Updated...";
			
			try(Connection conn = DBUtil.provideConnection()){
				PreparedStatement ps = conn.prepareStatement("UPDATE faculty SET password=? WHERE username='"+username+"' and password='"+password+"' ");
			 	ps.setString(1,faculty.getPassword());
			 	
			 	int y = ps.executeUpdate();
			 	System.out.println(y);
			 	if(y > 0) {
			 		message = "Password updated sucessfully...";
			 		System.out.println(message);
			 	}
			 	else throw new FacultyException("faculty does not exist with username "+username +"and password "+password);
				
			}catch(SQLException | FacultyException e) {
				message = e.getMessage();
			}
				return message;
	}

	@Override
	public List<CoursePlan> daywiseUpdate() throws FacultyException {
		 List<CoursePlan> fcourseplanlist = new ArrayList<>();
			
			try(Connection conn=DBUtil.provideConnection()){
				
			   PreparedStatement ps= conn.prepareStatement("SELECT daynumber,batchid,status FROM courseplan ORDER BY daynumber asc; ");
			  
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   int day = rs.getInt("daynumber");
				   int bid = rs.getInt("batchid");
				   String stat = rs.getString("status");
				   
				   
				   CoursePlan courseplan = new CoursePlan(bid,day,stat);
				   fcourseplanlist.add(courseplan);
			   }
			}catch(SQLException e) {
				throw new FacultyException(e.getMessage());
			}
			if(fcourseplanlist.size()==0) {
				throw new FacultyException("No course plan yet....");
			}
			
			return fcourseplanlist;
	}

	@Override
	public List<BatchAndCoursePlan> Report() throws FacultyException {
		
		List<BatchAndCoursePlan> bcplist = new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			
			   PreparedStatement ps= conn.prepareStatement("select batch.batchid,batch.courseid,batch.facultyid,batch.numstud,courseplan.topic,courseplan.status from batch inner join courseplan on batch.batchid = courseplan.batchid;");
			  
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   int bid = rs.getInt("batchid");
				   int cid = rs.getInt("courseid");
				   int fid = rs.getInt("facultyid");
				   int nums = rs.getInt("numstud");
				   String topic = rs.getString("topic");
				   String stat = rs.getString("status");
				   
				   BatchAndCoursePlan courseplan = new BatchAndCoursePlan(bid,cid,fid,nums,topic,stat);
				   bcplist.add(courseplan);
			   }
			}catch(SQLException e) {
				throw new FacultyException(e.getMessage());
			}
			if(bcplist.size()==0) {
				throw new FacultyException("No course plan yet....");
			}
			
			return bcplist;
	}


	
	}


