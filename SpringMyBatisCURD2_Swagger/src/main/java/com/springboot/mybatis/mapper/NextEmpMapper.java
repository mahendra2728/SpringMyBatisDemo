package com.springboot.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springboot.mybatis.domain.Next_Emp;

@Mapper
public interface NextEmpMapper {
	
	@Select("select * from next_emp ")
	public List<Next_Emp> getNextEmps();

	@Select("select * from next_emp where id=#{id}")
	public Next_Emp getNextEmp(int id);
	
	@Insert("INSERT INTO next_emp(first_name,last_name,birth_date,email) values(#{first_name},#{last_name},#{birth_date},#{email})")
	public void addNextEmp(Next_Emp student);
	
	@Select("select * from next_emp where birth_date=CURRENT_DATE()")
	public List<Next_Emp> getNextEmp_Birth();

}
