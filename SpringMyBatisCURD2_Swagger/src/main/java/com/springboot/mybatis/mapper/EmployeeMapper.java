package com.springboot.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Results;

import com.springboot.mybatis.domain.Employee;

@Mapper
public interface EmployeeMapper {
	
	@Select("select * from emp ")
    List<Employee> findAll();

    @Insert("insert into emp (employee_fname, employee_lname,employee_address,department) values(#{employee_fname},#{employee_lname},#{employee_address},#{department})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "employee_id",
            before = false, resultType = Integer.class)
    void insert(Employee employee);
    
    @Update("UPDATE EMP SET employee_fname=#{employee_fname},employee_lname=#{employee_lname},employee_address=#{employee_address},department=#{department} WHERE employee_id=#{employee_id}")
    void updateEmployee(Employee employee);
    
    
    @Delete("DELETE from emp WHERE employee_id = #{employee_id}")
    boolean deleteEmployee(Integer employee_id);
   
    
    @Results({
        @Result(property = "employee_id", column = "employee_id"),
        @Result(property = "employee_fname", column = "employee_fname"),
        @Result(property = "employee_lname", column = "employee_lname")
      })
	@Select("SELECT employee_id,employee_fname, employee_lname from emp WHERE employee_id = #{employee_id}")
    Employee selectEmployee(Integer employee_id);
    
    
    @Results({
    	 @Result(property = "employee_fname", column = "employee_fname")
    })
    @Select("SELECT employee_fname from emp WHERE employee_id = #{employee_id}")
    Employee selectEmployeeFname(Integer employee_id);

}
