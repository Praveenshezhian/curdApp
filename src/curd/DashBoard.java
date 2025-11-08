package curd;

import java.util.Scanner;

public class DashBoard {
	Scanner input =new Scanner(System.in);
	Database db=new Database();
	DashBoard(){

		System.out.println("Welcome to dashboard");
		while(true) {
			System.out.printf("%n1 insert %n2 display %n3 update %n4 delete %n5 exit%n");
			System.out.println("Enter your choice : ");
			int ch=input.nextInt();
			switch(ch) {
				case 1:
					int res=db.insert();
					if(res>0)System.out.println("data inserted successfully");
					else System.out.println("insert failed");
					break;
				case 2:
					db.display();
					break;
				case 3:
					int up =db.update();
					if(up>0)System.out.println("Data Updated ");
					else System.out.println("Updtate Failed");
					break;
				case 4:
					int del=db.delete();
					if(del>0)System.out.println("Data Deleted ");
					else System.out.println("Deletion Failed");
					break;
				case 5:
					db.cleanResource();
					break;
			}
		}
}
}
