package kr.co.apink;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


// @Service 이렇게 안 돼? 커넥션이라?
@Repository("server_db1")
public class server_db1 {
	String dbinfo = "";
	String dburl = "";
	String dbuser = "";
	String dbpass = "";
	Connection con = null;
	/*
	//localhost mysql
	public Connection dbinfo1() throws Exception{ 
		//static이면 클래스로드 해야됨 / this.안됨
		this.dbinfo = "com.mysql.cj.jdbc.Driver";
		this.dburl = "jdbc:mysql://192.168.90.3:3306/mrp";
		this.dbuser = "root";
		this.dbpass = "a12345";
		
		Class.forName(this.dbinfo);
		this.con = DriverManager.getConnection(this.dburl,this.dbuser,this.dbpass);
		System.out.println(con);
		
		return this.con;
	}
	
	*/
	//cloud db
	public  Connection dbinfo2() throws Exception{
		this.dbinfo = "com.mysql.cj.jdbc.Driver";
		//this.dburl = "jdbc:mysql://172.30.1.90:13306/webapi";
		this.dburl = "jdbc:mysql://localhost:13306/webapi";

		this.dbuser = "root";
		this.dbpass = "a12345";
		
		Class.forName(this.dbinfo);
		this.con = DriverManager.getConnection(this.dburl,this.dbuser,this.dbpass);
		System.out.println(con);

		return this.con;
	}
	

}
