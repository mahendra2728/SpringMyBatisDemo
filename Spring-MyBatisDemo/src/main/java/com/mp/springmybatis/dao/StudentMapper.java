package com.mp.springmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mp.springmybatis.model.Student;
import com.mp.springmybatis.utility.MyBatisUtility;

@Repository
public class StudentMapper {
	
	
	public List<Student> getAllStudents()
	{
		SqlSession theSqlSession=MyBatisUtility.getSqlSessionFactory().openSession();
		List<Student> listStudent=theSqlSession.selectList("getAllStudent");
		theSqlSession.commit();
		theSqlSession.close();
		return listStudent;
	}
	
	public Student getStudent(Integer theStudent)
	{
		SqlSession theSqlSession=MyBatisUtility.getSqlSessionFactory().openSession();
		Student listStudent=theSqlSession.selectOne("getStudent",theStudent);
		theSqlSession.commit();
		theSqlSession.close();
		return listStudent;
		
	}
	
	public void saveStudent(Student theStudent)
	{
		SqlSession theSqlSession=MyBatisUtility.getSqlSessionFactory().openSession();
		theSqlSession.insert("insertStudent",theStudent);
		theSqlSession.commit();
	}
	
	public void deleteStudent(Integer studentId)
	{
		SqlSession theSqlSession=MyBatisUtility.getSqlSessionFactory().openSession();
		theSqlSession.delete("deletStudent",studentId);
		theSqlSession.commit();
	}
	
	public void updateStudent(Student student)
	{
		SqlSession theSqlSession=MyBatisUtility.getSqlSessionFactory().openSession();
		theSqlSession.update("updateStudent",student);
		theSqlSession.commit();
	}
	
	
	

}
