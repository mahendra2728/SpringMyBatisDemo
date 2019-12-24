package com.springboot.mybatis.schedular;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class MyTaskSchedular {
	
	@Scheduled(cron = "*/1 * * * * *")
	public void myMethod()
	{
		System.out.println("in fixedDelay 1...");
		for(int i=0;i<=1000;i++)
		{
			System.out.println("Hey "+i+ " Time : "+LocalDateTime.now());
		}
	}
	
	/*@Scheduled(fixedDelay = 1000)
	public void myMethod2()
	{
		System.out.println("in fixedDelay 2...");
		for(int i=0;i<=1000;i++)
		{
			System.out.println("Hey "+i+ " Time : "+LocalDateTime.now());
		}
	}*/
	
	//@Scheduled(fixedDelay = 60000, initialDelay = 10000)
	/*public void fixedRateSch() throws IOException 
	{
		System.out.println("I am called getTodaysBirthdayEmployees"+new Date());
		  
		OkHttpClient client = new OkHttpClient();

		   Request request = new Request.Builder()
		  .url("http://localhost:8080/NextEmpPortal/api/sendEmail")
		  .get()
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "7099282a-f398-de0a-1ed6-9b1f3ea9a401")
		  .build();

		  Response response = client.newCall(request).execute();
	   }*/
}
