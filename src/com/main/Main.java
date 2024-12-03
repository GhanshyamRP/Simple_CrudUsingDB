package com.main;

import java.util.List;
import java.util.Scanner;

import com.main.Dao.StudDao;
import com.main.model.Student;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StudDao dao = new StudDao();
		int ch , c ;
		Student stud ;
		do {
		
		System.out.println("1-Create Student Record\n2-Display all\n3-Update Student Record\n4-Delete Student record");
		c = s.nextInt();
			switch (c) {
			case 1:
				System.out.println("Enter Student id, name, percentage :");
				 stud = new Student(s.nextInt(),s.next(),s.nextDouble());
				int i = dao.insert(stud);
				if(i>0) {
					System.out.println("Student record inserted");
				}
				break;
			case 2:
				List<Student> studlist =null;
				studlist = dao.displyAll();
				for(Student stud1:studlist) {
					System.out.println(stud1.toString());
				}
					
				break;
			case 3:
				System.out.println("Enter id to update percentage and new percentage:");
				stud = new Student(s.nextInt(), s.nextDouble());
				 dao.update(stud);
				break;
			case 4:
				System.out.println("Enter id to delete Student record :");
				int k = s.nextInt();
				dao.delRecord(k);
				break;
		
			default:
				break;
			}
		
		System.out.println("Press 1 to continue :");
		ch = s.nextInt();
		
		}while(ch==1);
		
	}

}
