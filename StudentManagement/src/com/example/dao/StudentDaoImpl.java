package com.example.dao;
import java.sql.*;

import com.example.beans.Student;
public class StudentDaoImpl implements StudentDao {
	private static Connection establishConnection() {
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.127:3306/dac78";
			con = DriverManager.getConnection(url, "dac78", "welcome");
			if(con!=null) {
				return con;
			}
			else {
				System.out.println("Something went wrong");
			}
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void InsertData(Student s) {
		PreparedStatement ps=null;
		try {
			ps = establishConnection().prepareStatement("insert into students values(?, ? ,?)");
			ps.setInt(1, s.getSid());
			ps.setString(2, s.getSname());
			ps.setDouble(3, s.getMarks());
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println("Data inserted");
			}
			else {
				System.out.println("Unable to insert");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void DeleteData(int id) {
		PreparedStatement ps=null;
		try {
			ps = establishConnection().prepareStatement("delete from students where id=?");
			ps.setInt(1, id);
			if(ps.executeUpdate()>0) {
				System.out.println("Student deleted");
			}
			else {
				System.out.println("Unable to delete");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void UpdateData(int id, String sname) {
		PreparedStatement ps = null;
		try {
			ps = establishConnection().prepareStatement("update students set sname=? where id=?");
			ps.setString(1, sname);
			ps.setInt(2, id);
			if(ps.executeUpdate()>0) {
				System.out.println("Name updated: ");
			}
			else
				System.out.println("Unable to update data");
		}catch(SQLException s) {
			s.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateMarks(int id, double marks) {
		PreparedStatement ps = null;
		try {
			ps = establishConnection().prepareStatement("update students set marks = ? where id=?");
			ps.setDouble(1, marks);
			ps.setInt(2, id);
			if(ps.executeUpdate()>0) {
				System.out.println("Marks updated: ");
			}
			else {
				System.out.println("unable to update: ");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void SelectData() {
		PreparedStatement ps = null;
		try {
			ps = establishConnection().prepareStatement("select * from students");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt("id"));
				System.out.println("Name: "+rs.getString("sname"));
				System.out.println("Marks: "+rs.getDouble("marks"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void Count() {
		CallableStatement cs=null;
		try {
			cs = establishConnection().prepareCall("call proc1(?)");
			cs.registerOutParameter(1, java.sql.Types.INTEGER);
			cs.execute();
			int count = cs.getInt(1);
			System.out.println("Total no of students are: " +count);
		} catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void sortByName() {
		PreparedStatement ps = null;
		try {
			ps = establishConnection().prepareStatement("select * from students order by sname");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id"));
				System.out.println("Id: "+rs.getString("sname"));
				System.out.println("Id: "+rs.getInt("marks"));
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				ps.close();
				establishConnection().close();
			}catch(SQLException sq) {
				sq.printStackTrace();
			}
			
		}
	}
	

}
