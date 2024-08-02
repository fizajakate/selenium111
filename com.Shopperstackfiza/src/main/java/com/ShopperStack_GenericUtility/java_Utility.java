package com.ShopperStack_GenericUtility;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Random;

public class java_Utility {
	
 public int generateRandomNumber() {
	 Random r= new Random();
	 int num=r.nextInt(1000);
	 return num;
 }
  public String localDate() {
	  return LocalDateTime.now().toString().replace("-","");
  }
  public String localDateTime() {
	  return LocalDateTime.now().toString().replace("-", "").replace(".","").replace(":", "");
  }
	  
  
 }
