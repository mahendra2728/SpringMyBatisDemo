package com.springboot.mybatis.schedular;

import java.io.IOException;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//@Component("callSchedularMethod")
public class MySchedular {
	
	@Scheduled(cron = "*/5 * * * *")
	public void getTodaysBirthdayEmployees() throws IOException
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
	}

	@Scheduled(cron = "*/5 * * * * *")
	public void printMessage() {
		
		
		System.out.println("I am called by Spring scheduler "+new Date());
	}
	
	@Scheduled(cron = "*/1 * * * * *")
	public void printMessage2() {
		System.out.println("Hey Mahendra "+new Date());
	}
}
