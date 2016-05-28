package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import sun.text.resources.FormatData;

public class CalendarUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -1);
//		String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
//		System.out.println(yesterday);
		//今天是礼拜几
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK)-1);
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
//		cal.set(Calendar.DAY_OF_MONTH, 14);
		String aa = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(  aa );
		
		
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		aa =  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(  aa );
		cal.add(Calendar.DATE, -1);
		aa =  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(  aa );
		
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		aa =  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(  aa );
		
		System.out.println(  cal.get(Calendar.DAY_OF_MONTH) );
		
		
		
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -1);
		cal.add(Calendar.MONDAY, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DATE, -1);
		aa =  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(  aa );
		
		System.out.println(4%3);
		
		
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -0);
		cal.add(Calendar.MONTH, -3);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		aa =  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(  aa );
		cal.add(Calendar.MONTH, 3);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		aa =  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(  aa );
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DATE));
		
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(GregorianCalendar.DATE, -15);
		System.out.println(gc.getTime());
		System.out.println(FormatDate(gc.getTime(),"yyyy-MM-dd"));
		System.out.println(FormatDate(gc.getTime(),"yyyy-MM-dd HH:mm:ss"));
		System.out.println(FormatDate(gc.getTime(),"YYYY-MM-dd HH:mm:ss"));
		
		
	}

	public static String FormatDate(Date date , String sf){
		if(date == null)
			return "";
		SimpleDateFormat dateFormat = new SimpleDateFormat(sf);
		
		return dateFormat.format(date);
	}
	
	
}
