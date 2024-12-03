package com.main.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.main.ConnectionDB.Connection1;
import com.main.model.Student;

public class StudDao {
	
	int i = 0;
	PreparedStatement pstat=null;
	Connection conn = null;
	Connection1 connes = new Connection1();
	List<Student> studlist = null;
	ResultSet res = null;
	
	public int insert(Student stud) {
		
		try {
			conn = connes.getConnection();
			pstat = conn.prepareStatement("insert into student values (?,?,?)");
			pstat.setInt(1, stud.getId());
			pstat.setString(2, stud.getName());
			pstat.setDouble(3, stud.getPerc());
			i = pstat.executeUpdate();
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public List<Student> displyAll() {
		conn = connes.getConnection();
		studlist = new ArrayList<Student>();
		try {
			String str = "select * from student";
			Statement st = conn.createStatement();
			res =st.executeQuery(str);
			while(res.next()) {
				Student s = new Student(res.getInt(1),res.getString(2),res.getDouble(3));
				studlist.add(s);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studlist;
	}
	
	public void update(Student stud)  {
		
		try {
			conn = connes.getConnection();
			pstat = conn.prepareStatement("update student set perc=? where id=?");
			pstat.setDouble(1, stud.getPerc());
			pstat.setInt(2, stud.getId());
			i =pstat.executeUpdate();
			if(i>0) {
				System.out.println("Student details updated");
			}
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delRecord(int id) {
		try {
			conn=connes.getConnection();
			pstat = conn.prepareStatement("delete from student where id=?");
			pstat.setInt(1, id);
			i = pstat.executeUpdate();
			if(i>0) {
				System.out.println("Student record deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
