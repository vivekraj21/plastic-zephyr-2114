package com.cms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.cms.bean.Batch;
import com.cms.bean.BatchAndCoursePlan;
import com.cms.bean.Course;
import com.cms.bean.CoursePlan;
import com.cms.bean.Faculty;
import com.cms.exceptions.FacultyException;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void role() throws SQLException {
		System.out.println("----Welcome to Course Monitoring System----\n");
		System.out.println("What is your role :");
		System.out.println("\n1.Admin\n\n2.Faculty");
		int roletype = sc.nextInt();
//-----------------------------------------admin-----------------------------------------------------------------------
		if(roletype==1) {
			System.out.println("Please enter username :");
			String aname = sc.next();
			System.out.println("Please enter password :");
			String pass = sc.next();
			
			if(aname.equals("admin") && pass.equals("2022")) {
			System.out.println("\n----WELCOME ADMIN----");
			System.out.println("Select from the following where you want to make changes :");
			System.out.println("\n1.Faculty\n2.Course \n3.Batch\n4.CoursePlan\n5.Day-wise update of batches\n6.Generate Report");
			int cat = sc.nextInt();
//---------------------------------------category 1 started--------------------------------------------------------------			  
			    if(cat==1) {
			    	  int out = 2;
			    	  while(out==2) {
				   System.out.println("Enter the work :\n");
				   System.out.println("1.Create faculty.\n2.Update faculty.\n3.View faculty");
				   int work = sc.nextInt();
//----------------------------------admin creating faculty-------------------------------------------------------------				   
				      if(work==1) {
				    	
				    	  System.out.println("Enter faculty ID :");
				    	  int fid = sc.nextInt();
				    	  System.out.println("Enter faculty name :");
				    	  String fnam = sc.next();
				    	  System.out.println("Enter faculty address :");
				    	  String fadd = sc.next();
				    	  System.out.println("Enter faculty mobile :");
				    	  String fmob = sc.next();
				    	  System.out.println("Enter faculty email :");
				    	  String fmail = sc.next();
				    	  System.out.println("Enter faculty username :");
				    	  String fuser = sc.next();
				    	  System.out.println("Enter faculty password :");
				    	  String fpass = sc.next();
				    	  
				    	  Faculty f = new Faculty(fid, fnam,fadd,fmob,fmail,fuser,fpass);
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  String res = dao.createFaculty(f);
				    	  System.out.println(res);
				    	  System.out.println("Want to Exit :\n1.Yes\n2.No");
				    	  out = sc.nextInt();
				    	  if(out==1) {
				    		  role();
				    	  }
				    	  }
//---------------------------------admin updating faculty-----------------------------------------------------------------				      
				      else if(work==2) {
				    	  System.out.println("Enter faculty Id for update :");
				    	  int id = sc.nextInt();
				    	  System.out.println("You are updating...please enter details...");
				    	  System.out.println("Enter new faculty ID :");
				    	  int fid = sc.nextInt();
				    	  System.out.println("Enter new faculty name :");
				    	  String fnam = sc.next();
				    	  System.out.println("Ente new faculty address :");
				    	  String fadd = sc.next();
				    	  System.out.println("Enter new faculty mobile :");
				    	  String fmob = sc.next();
				    	  System.out.println("Enter new faculty email :");
				    	  String fmail = sc.next();
				    	  System.out.println("Enter new faculty username :");
				    	  String fuser = sc.next();
				    	  System.out.println("Enter new faculty password :");
				    	  String fpass = sc.next();
				    	  Faculty f = new Faculty(fid, fnam,fadd,fmob,fmail,fuser,fpass);
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  String res=null;
						try {
							res = dao.updateFaculty(f, id);
						} catch (FacultyException e) {
							e.printStackTrace();
							System.out.println(res);
						}
				    	  
				      }
//------------------------------------admin calling list of faculty----------------------------------------------------				      
				      else if(work==3) {
				    	  
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  List<Faculty> fac;
				    	  
						try {
							fac = dao.viewAllFaculty();
							fac.forEach(f -> {
							        System.out.println("Faculty ID :"+f.getFacultyid());
							        System.out.println("Faculty Name :"+f.getFacultyname());
							        System.out.println("Faculty Address :"+f.getFacultyadd());
							        System.out.println("Faculty Mobile No. :"+f.getMobile());
							        System.out.println("Faculty Email :"+f.getEmail());
							        System.out.println("Faculty Username :"+f.getUsername());
							        System.out.println("Faculty Password :"+f.getPassword());
							        System.out.println("=====================================================");
							});
						} catch (FacultyException e) {
							e.printStackTrace();
						}
				    	  
				    }
				      else {
				    	  System.out.println("Selected option is not available.....");
				      }
				      }
			    }
//----------------------------------------------category 1 ended ---------------------------------------------------------

//----------------------------------------------category 2 started--------------------------------------------------------			    
			    else if(cat==2) {
			    	int out = 2;
			    	  while(out==2) {
				   System.out.println("Enter the work :\n");
				   System.out.println("1.Create Course.\n2.Update Course.\n3.View Course");
				   int work = sc.nextInt();
				   
//-------------------------------------------------admin creating course------------------------------------------------------				   
				   if(work==1) {
				    	
				    	  System.out.println("Enter course ID :");
				    	  int cid = sc.nextInt();
				    	  System.out.println("Enter course name :");
				    	  String cnam = sc.next();
				    	  System.out.println("Enter course fee:");
				    	  int cfee = sc.nextInt();
				    	  System.out.println("Enter course description :");
				    	  String cdisc = sc.next();
				    	  
				    	  
				    	  Course c = new Course(cid, cnam,cfee,cdisc);
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  String res = dao.createCourse(c);
				    	  System.out.println(res);
				    	  System.out.println("Want to Exit :\n1.Yes\n2.No");
				    	  out = sc.nextInt();
				    	  if(out==1) {
				    		  role();
				    	  }
				    	  }
//------------------------------------------------admin updating course----------------------------------------------------
				   else if(work==2) {
					   System.out.println("Enter Course Id for update :");
				    	  int id = sc.nextInt();
				    	  System.out.println("You are updating...please enter details...");
				    	  System.out.println("Enter new Course ID :");
				    	  int cid = sc.nextInt();
				    	  System.out.println("Enter new Course name :");
				    	  String cnam = sc.next();
				    	  System.out.println("Enter new Course fee :");
				    	  int cfee = sc.nextInt();
				    	  System.out.println("Ente newr Course description :");
				    	  String cdisc = sc.next();
				    	  
				    	  Course c = new Course(cid, cnam,cfee,cdisc);
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  String res=null;
						try {
							res = dao.updateCourse(c, id);
						} catch (FacultyException e) {
							e.printStackTrace();
							System.out.println(res);
						}
				   }
//----------------------------------------------admin calling list of batches------------------------------------------------
				    else if(work==3) {
				    	  
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  List<Course> cor;
				    	  
						try {
							cor = dao.viewAllCourse();
							cor.forEach(c -> {
							        System.out.println("Course ID :"+c.getCourseid());
							        System.out.println("Course Name :"+c.getCoursename());
							        System.out.println("Course Fee :"+c.getFee());
							        System.out.println("Course Description :"+c.getCoursedesc());
							        System.out.println("=====================================================");
							});
						} catch (FacultyException e) {
							e.printStackTrace();
						}
				    	  
				    }
				      else {
				    	  System.out.println("Selected option is not available.....");
				      }
			    	  }
			    }
//----------------------------------category 3 started-----------------------------------------------------------
			    else if(cat==3) {
			    	int out = 2;
			    	  while(out==2) {
				   System.out.println("Enter the work :\n");
				   System.out.println("1.Create Batch.\n2.Update Batch.\n3.View Batch");
				   int work = sc.nextInt();
				   
//-------------------------------------------------admin creating batch------------------------------------------------------				   
				   if(work==1) {
				    	
				    	  System.out.println("Enter batch ID :");
				    	  int bid = sc.nextInt();
				    	  System.out.println("Enter course ID :");
				    	  int cid = sc.nextInt();
				    	  System.out.println("Enter faculty ID :");
				    	  int fid = sc.nextInt();
				    	  System.out.println("Enter number of students in batch :");
				    	  int numstud = sc.nextInt();
				    	  System.out.println("Enter starting date-time (yyyymmddhhmmss) :");
				    	  long sdate = sc.nextLong();
				    	  System.out.println("Enter duration in hours:");
				    	  int dur = sc.nextInt();

                          Batch b = new Batch(bid,cid,fid,numstud,sdate,dur);
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  String res = dao.createBatch(b);
				    	  System.out.println(res);
				    	  System.out.println("Want to Exit :\n1.Yes\n2.No");
				    	  out = sc.nextInt();
				    	  if(out==1) {
				    		  role();
				    	  }
				    	  }
//---------------------------------------------------admin updating batch----------------------------------------------------
				   else if(work==2) {
				    	  System.out.println("Enter Batch Id for update :");
				    	  int id = sc.nextInt();
				    	  System.out.println("You are updating...please enter details...");
				    	  System.out.println("Enter new Batch ID :");
				    	  int bid = sc.nextInt();
				    	  System.out.println("Enter new Course ID :");
				    	  int cid = sc.nextInt();
				    	  System.out.println("Ente new Faculty ID :");
				    	  int fid = sc.nextInt();
				    	  System.out.println("Enter new number of students :");
				    	  int numstud = sc.nextInt();
				    	  System.out.println("Enter new start date :");
				    	  long sdate = sc.nextLong();
				    	  System.out.println("Enter new duration :");
				    	  int dur = sc.nextInt();
				    	  Batch b = new Batch(bid,cid,fid,numstud,sdate,dur);
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  try {
							String res= dao.updateBatch(b,id);
						} catch (FacultyException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						};
						 
			        }
//---------------------------------------------------admin calling list of batch----------------------------------------
				    else if(work==3) {
				    	  
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  List<Batch> bat;
				    	  
						try {
							bat = dao.viewAllBatch();
							bat.forEach(c -> {
							        System.out.println("Batch ID :"+c.getBatchid());
							        System.out.println("Course ID :"+c.getCourseid());
							        System.out.println("Faculty ID :"+c.getFacultyid());
							        System.out.println("Number of student :"+c.getNumstud());
							    //    System.out.println("Starting Date :"+c.getStartdate());
							        System.out.println("Duration :"+c.getDuration());
							        System.out.println("=====================================================");
							});
						} catch (FacultyException e) {
							e.printStackTrace();
						}
				    	  
				    }
				      else {
				    	  System.out.println("Selected option is not available.....");
				      }
			    	  }
			    	  
			    }
//---------------------------------------------category 4 --------------------------------------------------------
			    if(cat==4) {
			    	  int out = 2;
			    	  while(out==2) {
				   System.out.println("Enter the work :\n");
				   System.out.println("1.Create Course Plan.\n2.Update Course Plan.\n3.View Course Plan");
				   int work = sc.nextInt();  
				   
				   if(work==1) {
				    	
				    	  System.out.println("Enter Plan ID :");
				    	  int pid = sc.nextInt();
				    	  System.out.println("Enter Batch ID :");
				    	  int bid = sc.nextInt();
				    	  System.out.println("Enter Day No. :");
				    	  int day = sc.nextInt();
				    	  System.out.println("Enter topic :");
				    	  String topic = sc.next();
				    	  System.out.println("Enter status (absent/present):");
				    	  String status = sc.next();

                       CoursePlan cp = new CoursePlan(pid,bid,day,topic,status);
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  String res = dao.createCoursePlan(cp);
				    	  System.out.println(res);
				    	  System.out.println("Want to Exit :\n1.Yes\n2.No");
				    	  out = sc.nextInt();
				    	  if(out==1) {
				    		  role();
				    	  }
				    	  }
//--------------------------------------courseplan update----------------------------------------------------------------
				   else if(work==2) {
					   System.out.println("Enter Plan Id for update :");
				    	  int id = sc.nextInt();
				    	  System.out.println("You are updating...please enter details...\n");
				    	  System.out.println("Enter new Plan ID :");
				    	  int pid = sc.nextInt();
				    	  System.out.println("Enter new Batch ID :");
				    	  int bid = sc.nextInt();
				    	  System.out.println("Enter new Day No. :");
				    	  int day = sc.nextInt();
				    	  System.out.println("Enter new Topic :");
				    	  String topic = sc.next();
				    	  System.out.println("Enter new Status :");
				    	  String stat = sc.next();
				    	  
				    	  CoursePlan cp = new CoursePlan(pid,bid,day, topic,stat);
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  String res=null;
						try {
							res = dao.updateCoursePlan(cp, id);
						} catch (FacultyException e) {
							e.printStackTrace();
							System.out.println(res);
						}
				   }
//-------------------------------------courseplan view list-------------------------------------------------------------
				   else if(work==3) {
				    	  
				    	  FacultyDao dao = new FacultyDaoImp();
				    	  List<CoursePlan> cp;
				    	  
						try {
							cp = dao.viewAllCoursePlan();
							cp.forEach(f -> {
							        System.out.println("Plan ID :"+f.getPlanid());
							        System.out.println("Batch ID :"+f.getBatchid());
							        System.out.println("Day Number :"+f.getDaynumber());
							        System.out.println("Topic :"+f.getTopic());
							        System.out.println("Status :"+f.getStatus());
							        System.out.println("=====================================================");
							});
						} catch (FacultyException e) {
							e.printStackTrace();
						}
				    	  
				    }
				      else {
				    	  System.out.println("Selected option is not available.....");
				      }
			    	  }
			    	  
			    }
//----------------------------------day-wise update--------------------------------------------------------
			    else if(cat==5) {
			    	 
			    	  FacultyDao dao = new FacultyDaoImp();
			    	  List<CoursePlan> cp;
			    	  
					try {
						cp = dao.daywiseUpdate();
						cp.forEach(f -> {
							    System.out.println("Day Number :"+f.getDaynumber());
						        System.out.println("Batch ID :"+f.getBatchid());
						        
						        System.out.println("Status :"+f.getStatus());
						        System.out.println("=====================================================");
						});
					} catch (FacultyException e) {
						e.printStackTrace();
					}
			    }
//---------------------------------------genertate report------------------------------------------------------
			    else if(cat==6) {
			    	FacultyDao dao = new FacultyDaoImp();
			    	List<BatchAndCoursePlan> bcp;
			    	try {
						bcp = dao.Report();
						bcp.forEach(f -> {
						        System.out.println("Batch ID :"+f.getBatchid());
						        System.out.println("Course ID :"+f.getCourseid());
						        System.out.println("Faculty ID :"+f.getFacultyid());
						        System.out.println("Number of Student :"+f.getNumstud());
						        System.out.println("Topic :"+f.getTopic());
						        System.out.println("Status :"+f.getStatus());
						        System.out.println("=====================================================");
						});
					} catch (FacultyException e) {
						e.printStackTrace();
					}
			    }
			   
			}
			else {
				System.out.println("Username and Password are wrong...\n");
				role();
			}
			
			}
//-----------------------------------------faculty starts------------------------------------------------------------------
		else if(roletype==2) {
			System.out.println("Welcome , you are at Faculty Login Page :");
			System.out.println("Enter your username :");
			String uname = sc.next();
			System.out.println("Enter your password :");
			String pass = sc.next();
			FacultyDao dao = new FacultyDaoImp();
			int yes = 0;
			try {
				int res = dao.loginFaculty(uname, pass);
				if(res==1) {
					yes=1;
					System.out.println("LogIn Succesful...");
				}
				else {
					yes=0;
					System.out.println("Wrong username or password...");
				}
			} catch (FacultyException e) {
				e.printStackTrace();
			}
//---------------------------------------------view course plan------------------------------------------------			
			if(yes==1) {
				System.out.println("\nEnter your choice :");
				System.out.println("\n1.View Course Plan.\n2.Fill up day wise planner.\n3.Update password.");
				int choice = sc.nextInt();
				if(choice==1) {
					FacultyDao fcp = new FacultyDaoImp();
					List<CoursePlan> lcp;
					try {
						lcp = fcp.FacultyCoursePlan(uname, pass);
						
						lcp.forEach(f -> {
					        System.out.println("Plan ID :"+f.getPlanid());
					        System.out.println("Batch ID :"+f.getBatchid());
					        System.out.println("Day Number :"+f.getDaynumber());
					        System.out.println("Topic :"+f.getTopic());
					        System.out.println("Status :"+f.getStatus());
					        System.out.println("=====================================================");
					});
					} catch (FacultyException e) {
						e.printStackTrace();
					}
				}
//----------------------------------------fill up day-wise planner-------------------------------------------------
				else if(choice==2) {
					System.out.println("Enter your Course Plan ID");
					int cid = sc.nextInt();
					System.out.println("Enter your status :\n1.Present\n2.Absent");
					int st = sc.nextInt();
					if(st==1) {
						String res = "Present";
						CoursePlan cp = new CoursePlan(res);
						FacultyDao daoo = new FacultyDaoImp();
						try {
							daoo.fillPlanner(cp,cid);
						} catch (FacultyException e) {
							e.printStackTrace();
						}
					}
					else {
						System.out.println("Status is Absent.");
					}
				}
//---------------------------------------Faculty update password-----------------------------------------------------
				else if(choice==3) {
					System.out.println("Enter your new Password");
					String passw = sc.next();
				
						Faculty f = new Faculty(passw);
						FacultyDao daoo = new FacultyDaoImp();
						try {
							daoo.updatefacultyPassword(f,uname,pass);
							
						} catch (FacultyException e) {
							e.printStackTrace();
						}
					
				}
				else {
					System.out.println("Wrong Input...");
				}
				
			}
			
			
		}
	}
	

	public static void main(String[] args) throws SQLException {
		
		role();
		


	}

}
