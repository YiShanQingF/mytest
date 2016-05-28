/**
 * Copyright 2003 (C) PANLAB ��All Rights Reserved.
 * ����         ���� 			����
 * 2003-10-20   ����                     ����
 */
package com.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeMap;

/**
 * <p>
 * Title: ������
 * </p>
 * <p>
 * Description: ����ת��
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author hbq
 * @version 1.0
 */
public class DateUtils {

	// static long now = System.currentTimeMillis();
	// public static Date CurrTime = new Date(now);

	public DateUtils() {
	}

	// ȡϵͳʱ��ʱһ��Ҫ������������������ڿ��ܲ���
	public static Date getCurrDateTime() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * ȡ�õ�ǰϵͳʱ��
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrTime() {
		Date date_time = new Date();
		return FormatDate(date_time, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * ȡ�õ�ǰϵͳʱ��
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrTime1() {
		Date date_time = new Date();
		return FormatDate(date_time, "yyyy-MM-ddHH:mm:ss");
	}
	/**
	 * ȡ�õ�ǰϵͳ����
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getCurrDate_1() {
		Date date_time = new Date();
		return FormatDate(date_time, "yyyyMMdd");
	}
	/**
	 * ȡ�õ�ǰϵͳʱ��
	 * 
	 * @return yyyyMMddHHmmss
	 */
	public static String getCurrTimeNoFormat() {
		Date date_time = new Date();
		return FormatDate(date_time, "yyyyMMddHHmmss");
	}

	/**
	 * ȡ�õ�ǰϵͳ����
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getCurrDate() {
		Date date_time = new Date();
		return FormatDate(date_time, "yyyy-MM-dd");
	}
	
	/**
	 * ȡ�õ�ǰϵͳ�����Զ����ʽ
	 * 
	 * @return 
	 */
	public static String getCurrDatebyFormat(String format) {
		Date date_time = new Date();
		return FormatDate(date_time, format);
	}

	/**
	 * ȡ�����ڵ����
	 * 
	 * @param date
	 *            ����
	 * @return yyyy ����ַ���
	 */
	public static String getYear(Date date) {
		return FormatDate(date, "yyyy");
	}

	/**
	 * ȡ�����ڵ���ݼ�ǰ20������
	 * 
	 * @param date
	 *            ����
	 * @return yyyy ����ַ���
	 */
	public static TreeMap<String, String> getCurrentYearCount() {
		int currYear = Integer.valueOf(DateUtils.getYear(new Date()));
		TreeMap<String, String> yearMap = new TreeMap<String, String>();
		for (int i = 2000; i <= currYear; i++) {
			yearMap.put(String.valueOf(i), String.valueOf(i));
		}
		return yearMap;
	}

	/**
	 * ȡ�����ڵ��·�
	 * 
	 * @param date
	 *            ����
	 * @return mm �·��ַ���
	 */
	public static String getMonth(Date date) {
		return FormatDate(date, "MM");
	}

	/**
	 * ȡ�����ڵ����
	 * 
	 * @param date
	 *            ����
	 * @return dd ���ַ���
	 */
	public static String getDay(Date date) {
		return FormatDate(date, "dd");
	}

	/**
	 * ȡ�����ڵ�Сʱ
	 * 
	 * @param date
	 *            ����
	 * @return hh Сʱ�ַ���
	 */
	public static String getHour(Date date) {
		return FormatDate(date, "HH");
	}

	/**
	 * ȡ�����ڵķ���
	 * 
	 * @param date
	 *            ʱ��
	 * @return mm �����ַ���
	 */
	public static String getMinute(Date date) {
		return FormatDate(date, "mm");
	}

	/**
	 * ȡ��ʱ�����
	 * 
	 * @param date
	 *            ʱ��
	 * @return ss ���ַ���
	 */
	public static String getSecond(Date date) {
		return FormatDate(date, "ss");
	}

	/**
	 * ȡ��������������ʼʱ��
	 * 
	 * @param granularity
	 *            ����
	 * @param statisticDate
	 *            ����ʱ��
	 * @return ��ʼʱ��
	 */
	public String getBeginDate(String granularity, String statisticDate) {
		String beginDate = "";
		Date date = DateUtils.stringToDateShort(statisticDate);
		Date beginDateTemp = null;
		if (granularity.equals("1")) {// ��
			beginDateTemp = date;
		}
		if (granularity.equals("2")) {// ��
			beginDateTemp = this.getWeekBegin(date);
		}
		if (granularity.equals("3")) {// Ѯ
			beginDateTemp = this.getPeriodBegin(date);
		} else if (granularity.equals("4")) {// ��
			beginDateTemp = this.getMonthBegin(date);
		} else if (granularity.equals("5")) {// ��
			beginDateTemp = this.getSeasonBegin(date);
		} else if (granularity.equals("6")) {// ����
			beginDateTemp = this.getHalfYearBegin(date);
		} else if (granularity.equals("7")) {// ��
			beginDateTemp = this.getYearBegin(date);
		}
		beginDate = DateUtils.dateToStringShort(beginDateTemp);
		return beginDate;
	}

	/**
	 * ȡ��������������ʼʱ��
	 * 
	 * @param granularity
	 *            ����
	 * @param statisticDate
	 *            ����ʱ��
	 * @return ��ʼʱ��
	 */
	public String getEndDate(String granularity, String statisticDate) {
		String beginDate = "";
		Date date = DateUtils.stringToDateShort(statisticDate);
		Date beginDateTemp = null;

		if (granularity.equals("1")) {// ��
			beginDateTemp = date;
		}
		if (granularity.equals("2")) {// ��
			beginDateTemp = this.getWeekEnd(date);
		}
		if (granularity.equals("3")) {// Ѯ
			beginDateTemp = this.getPeriodEnd(date);
		} else if (granularity.equals("4")) {// ��
			beginDateTemp = this.getMonthEnd(date);
		} else if (granularity.equals("5")) {// ��
			beginDateTemp = this.getSeasonEnd(date);
		} else if (granularity.equals("6")) {// ����
			beginDateTemp = this.getHalfYearEnd(date);
		} else if (granularity.equals("7")) {// ��
			beginDateTemp = this.getYearEnd(date);
		}

		beginDate = DateUtils.dateToStringShort(beginDateTemp);
		return beginDate;
	}

	/**
	 * ȡ��ʱ������ �� yyyy��mm��dd �� yyyy��mm�� �� yyyy��ڡ����� �� yyyy��
	 * 
	 * @param granularity
	 *            ����
	 * @param statisticDate
	 *            ʱ��
	 * @return ʱ���Ӧ���ȵ�����
	 */
	public String getTimedes(String granularity, String statisticDate) {
		String timedes = "";
		Date date = DateUtils.stringToDateShort(statisticDate);
		String year = "", month = "01", day = "01";
		year = DateUtils.getYear(date);
		month = DateUtils.getMonth(date);
		day = DateUtils.getDay(date);
		if (granularity.equals("1")) {// ��
			timedes = statisticDate;
		} else if (granularity.equals("4")) {// ��
			timedes = year + "��" + month + "��";

		} else if (granularity.equals("8")) {// ��
			String quarter = month + "-" + day;
			if (quarter.equals("03-31")) {
				timedes = year + "�� ��1����";
			} else if (quarter.equals("06-30")) {
				timedes = year + "�� ��2����";
			} else if (quarter.equals("09-30")) {
				timedes = year + "�� ��3����";
			} else if (quarter.equals("12-31")) {
				timedes = year + "�� ��4����";
			}
		} else if (granularity.equals("32")) {// ��
			timedes = year + "��";
		}
		return timedes;
	}

	/**
	 * ����ת��Ϊ�ַ���
	 * 
	 * @param date
	 *            ʱ��
	 * @return yyyy-MM-dd HH:mm:ss ��ʽ����ʱ���ַ���
	 */
	public static String dateToString(Date date) {
		if (date == null)
			return "";
		return FormatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * ����ת��Ϊ�ַ���
	 * 
	 * @param date
	 *            ʱ��
	 * @return yyyy-MM-dd ��ʽ����ʱ���ַ���
	 */
	public static String dateToStringShort(Date date) {
		if (date == null)
			return "";
		return FormatDate(date, "yyyy-MM-dd");
	}

	/**
	 * �ַ���ת��Ϊ����
	 * 
	 * @param dateString
	 *            yyyy-MM-dd HH:mm:ss
	 * @return ����
	 */
	public static Date stringToDate(String dateString) {
		String sf = "yyyy-MM-dd HH:mm:ss";
		Date dt = stringToDate(dateString, sf);
		return dt;
	}

	/**
	 * �ַ���ת��Ϊ����
	 * 
	 * @param dateString
	 *            yyyy-MM-dd
	 * @return ����
	 */
	public static Date stringToDateShort(String dateString) {
		String sf = "yyyy-MM-dd";
		Date dt = stringToDate(dateString, sf);
		return dt;
	}

	/**
	 * �����ڽ��и�ʽ��
	 * 
	 * @param date
	 *            ����
	 * @param sf
	 *            ���ڸ�ʽ
	 * @return �ַ���
	 */
	public static String FormatDate(Date date, String sf) {
		if (date == null)
			return "";
		SimpleDateFormat dateformat = new SimpleDateFormat(sf);
		return dateformat.format(date);
	}

	/**
	 * �ַ���ת��Ϊ����
	 * 
	 * @param dateString
	 *            ���ڸ�ʽ�ַ���
	 * @param sf
	 *            ���ڸ�ʽ������
	 * @return ת���������
	 */
	public static Date stringToDate(String dateString, String sf) {
		ParsePosition pos = new ParsePosition(0);
		SimpleDateFormat sdf = new SimpleDateFormat(sf);
		Date dt = sdf.parse(dateString, pos);
		return dt;
	}

	/**
	 * �����������ڲ���룩
	 * 
	 * @param date1
	 *            ʱ��1
	 * @param date2
	 *            ʱ��2
	 * @return ��������
	 */
	public static long diffTwoDate(Date date1, Date date2) {
		long l1 = date1.getTime();
		long l2 = date2.getTime();
		return (l1 - l2);
	}

	/**
	 * �����������ڲ�죩
	 * 
	 * @param date1
	 *            ʱ��1
	 * @param date2
	 *            ʱ��2
	 * @return �������
	 */
	public static int diffTwoDateDay(Date date1, Date date2) {
		long l1 = date1.getTime();
		long l2 = date2.getTime();
		int diff = Integer.parseInt("" + (l1 - l2) / 3600 / 24 / 1000);
		return diff;
	}
	
	/**
	 * �����������ڲ�£�
	 * 
	 * @param date1
	 *            ʱ��1
	 * @param date2
	 *            ʱ��2
	 * @return �������
	 */
	public static int diffTwoDateMonth(Date date1, Date date2) {
		int monthNum = 0;
		Calendar starCal = Calendar.getInstance();
        starCal.setTime(date1);
        int sYear = starCal.get(Calendar.YEAR);
        int sMonth = starCal.get(Calendar.MONTH);
        int sDay = starCal.get(Calendar.DATE);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(date2);
        int eYear = endCal.get(Calendar.YEAR);
        int eMonth = endCal.get(Calendar.MONTH);
        int eDay = endCal.get(Calendar.DATE);

        monthNum = ((eYear - sYear) * 12 + (eMonth - sMonth));

        if (sDay < eDay) {
        	monthNum = monthNum + 1;
        }
        
        return monthNum;
	}

	/**
	 * 
	 * @param currentTime
	 *            ���������
	 * @param type
	 *            ƫ�Ƶ����
	 * @param iQuantity
	 *            ƫ������
	 * @return ƫ�ƺ��ʱ�䴮
	 */
	public String getDateChangeTime(String currentTime, String type, int iQuantity) {
		Date curr = this.stringToDate(currentTime);
		curr = this.getDateChangeTime(curr, type, iQuantity);
		return this.dateToString(curr);
	}

	/**
	 * 
	 * @param currentTime
	 *            ���������
	 * @param type
	 *            ƫ�Ƶ����
	 * @param iQuantity
	 *            ƫ������
	 * @return ƫ�ƺ��ʱ��
	 */
	public Date getDateChangeTime(Date currentTime, String type, int iQuantity) {
		int year = Integer.parseInt(this.FormatDate(currentTime, "yyyy"));
		int month = Integer.parseInt(this.FormatDate(currentTime, "MM"));
		// �·�����
		month = month - 1;
		int day = Integer.parseInt(this.FormatDate(currentTime, "dd"));
		int hour = Integer.parseInt(this.FormatDate(currentTime, "HH"));
		int mi = Integer.parseInt(this.FormatDate(currentTime, "mm"));
		int ss = Integer.parseInt(this.FormatDate(currentTime, "ss"));
		GregorianCalendar gc = new GregorianCalendar(year, month, day, hour, mi, ss);
		// �·�����
		// gc.add(GregorianCalendar.MONTH, -1);
		if (type.equalsIgnoreCase("y")) {
			gc.add(GregorianCalendar.YEAR, iQuantity);
		} else if (type.equalsIgnoreCase("m")) {
			gc.add(GregorianCalendar.MONTH, iQuantity);
		} else if (type.equalsIgnoreCase("d")) {
			gc.add(GregorianCalendar.DATE, iQuantity);
		} else if (type.equalsIgnoreCase("h")) {
			gc.add(GregorianCalendar.HOUR, iQuantity);
		} else if (type.equalsIgnoreCase("mi")) {
			gc.add(GregorianCalendar.MINUTE, iQuantity);
		} else if (type.equalsIgnoreCase("s")) {
			gc.add(GregorianCalendar.SECOND, iQuantity);
		}
		return gc.getTime();
	}

	/**
	 * 
	 * @param currentTime
	 *            ��������
	 * @param type
	 *            ƫ�Ƶ����
	 * @param iQuantity
	 *            ƫ������
	 * @return ƫ�ƺ��ʱ�䴮
	 */
	public String getDateChangeALL(String currentTime, String type, int iQuantity) {
		Date curr = null;
		String newtype = "";
		if (currentTime.length() == 10) {
			curr = this.stringToDateShort(currentTime);
		}
		if (currentTime.length() > 10) {
			curr = this.stringToDate(currentTime);
		}

		// ��
		if (type.equals("1")) {
			iQuantity = iQuantity * 1;
			newtype = "d";
		}
		// �ܣ�����7�����
		else if (type.equals("2")) {
			iQuantity = iQuantity * 7;
			newtype = "d";
		}
		// Ѯ������10�����
		else if (type.equals("3")) {
			iQuantity = iQuantity * 10;
			newtype = "d";
		}
		// ��
		else if (type.equals("4")) {
			iQuantity = iQuantity;
			newtype = "m";
		}
		// Ѯ������3���¼���
		else if (type.equals("5")) {
			iQuantity = iQuantity * 3;
			newtype = "m";
		}
		// ���꣬���������¼���
		else if (type.equals("6")) {
			iQuantity = iQuantity * 6;
			newtype = "m";
		}
		// ��
		else if (type.equals("7")) {
			newtype = "y";
		} else {
			iQuantity = iQuantity * 1;
			newtype = "d";
		}

		Date change = this.getDateChangeTime(curr, newtype, iQuantity);

		// if(!type.equals("d")){
		// change = this.getMonthEnd(change);
		// }

		return this.dateToStringShort(change);
	}

	/**
	 * ������
	 * 
	 * @param args
	 *            ���Բ���
	 */
	public static void main(String[] args) {
		
	}

	/**
	 *�����ꡢ��ȡ����ĩ������
	 * 
	 * @param year
	 *            ��
	 * @parm month ��
	 * @return time �������ڸ�ʽ"yyyy-mm-dd"
	 */
	public static String getTime(String year, String month) {
		String time = "";
		int len = 31;
		int iYear = Integer.parseInt(year);
		int iMonth = Integer.parseInt(month);
		if (iMonth == 4 || iMonth == 6 || iMonth == 9 || iMonth == 11)
			len = 30;
		if (iMonth == 2) {
			len = 28;
			if ((iYear % 4 == 0 && iYear % 100 == 0 && iYear % 400 == 0) || (iYear % 4 == 0 && iYear % 100 != 0)) {
				len = 29;
			}
		}
		time = year + "-" + month + "-" + String.valueOf(len);
		return time;
	}

	/**
	 * ȡ�³�
	 * 
	 * @param date
	 * @return
	 */
	public Date getMonthBegin(Date date) {
		String newDateStr = this.FormatDate(date, "yyyy-MM") + "-01";
		// FormatDate(date, "yyyy-MM-dd");
		return this.stringToDateShort(newDateStr);
	}

	/**
	 * ȡ��ĩʱ��
	 * 
	 * @param date
	 *            ����
	 * @return date
	 */
	public static Date getMonthEnd(Date date) {
		int year = Integer.parseInt(FormatDate(date, "yyyy"));
		int month = Integer.parseInt(FormatDate(date, "MM"));
		int day = Integer.parseInt(FormatDate(date, "dd"));

		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, 0, 0, 0);
		int monthLength = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		String newDateStr = FormatDate(date, "yyyy") + "-" + FormatDate(date, "MM") + "-";
		if (monthLength < 10)
			newDateStr += "0" + monthLength;
		else
			newDateStr += "" + monthLength;
		return stringToDateShort(newDateStr);
	}

	/**
	 * ȡ����
	 * 
	 * @param date
	 * @return
	 */
	public Date getSeasonBegin(Date date) {
		int year = Integer.parseInt(this.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(this.FormatDate(date, "MM"));
		String newDateStr = this.FormatDate(date, "yyyy") + "-";
		if (month >= 1 && month <= 3) {
			newDateStr += "01-01";
		} else if (month >= 4 && month <= 6) {
			newDateStr += "04-01";
		} else if (month >= 7 && month <= 9) {
			newDateStr += "07-01";
		} else if (month >= 10 && month <= 12) {
			newDateStr += "10-01";
		}
		return this.stringToDateShort(newDateStr);
	}

	/**
	 * ȡ�����
	 * 
	 * @param date
	 * @return
	 */
	public Date getHalfYearBegin(Date date) {
		int year = Integer.parseInt(this.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(this.FormatDate(date, "MM"));
		String newDateStr = this.FormatDate(date, "yyyy") + "-";
		if (month <= 6) {
			newDateStr += "01-01";
		} else {
			newDateStr += "07-01";
		}
		return this.stringToDateShort(newDateStr);
	}

	/**
	 * ȡѮ��
	 * 
	 * @param date
	 * @return
	 */
	public Date getPeriodBegin(Date date) {
		int days = Integer.parseInt(this.FormatDate(date, "dd"));
		String newDateStr = this.FormatDate(date, "yyyy-MM") + "-";
		if (days <= 10) {
			newDateStr += "01";
		} else if (days <= 20) {
			newDateStr += "11";
		} else {
			newDateStr += "21";
		}
		return this.stringToDateShort(newDateStr);
	}

	/**
	 * ȡ�ܳ�
	 * 
	 * @param date
	 * @return
	 */
	public Date getWeekBegin(Date date) {

		int year = Integer.parseInt(this.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(this.FormatDate(date, "MM"));
		// �·�����
		month = month - 1;
		int day = Integer.parseInt(this.FormatDate(date, "dd"));

		GregorianCalendar gc = new GregorianCalendar(year, month, day);

		int week = GregorianCalendar.DAY_OF_WEEK - 1;

		if (week == 0) {
			week = 7;
		}

		gc.add(GregorianCalendar.DATE, 0 - week + 1);

		return gc.getTime();
	}

	/**
	 * ȡ��ĩ
	 * 
	 * @param date
	 * @return
	 */
	public Date getWeekEnd(Date date) {

		int year = Integer.parseInt(this.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(this.FormatDate(date, "MM"));
		// �·�����
		month = month - 1;
		int day = Integer.parseInt(this.FormatDate(date, "dd"));

		GregorianCalendar gc = new GregorianCalendar(year, month, day);

		int week = GregorianCalendar.DAY_OF_WEEK - 1;

		if (week == 0) {
			week = 7;
		}
		gc.add(GregorianCalendar.DATE, 7 - week);

		return gc.getTime();
	}

	/**
	 * ȡѮĩ
	 * 
	 * @param date
	 * @return
	 */
	public Date getPeriodEnd(Date date) {
		int days = Integer.parseInt(this.FormatDate(date, "dd"));
		String newDateStr = this.FormatDate(date, "yyyy-MM") + "-";
		if (days <= 10) {
			newDateStr += "10";
		} else if (days <= 20) {
			newDateStr += "20";
		} else {
			newDateStr = this.FormatDate(this.getMonthEnd(date), "yyyy-MM-dd");
		}
		return this.stringToDateShort(newDateStr);
	}

	/**
	 * ȡ����ĩ
	 * 
	 * @param date
	 * @return
	 */
	public Date getHalfYearEnd(Date date) {
		int year = Integer.parseInt(this.FormatDate(date, "yyyy"));
		int month = Integer.parseInt(this.FormatDate(date, "MM"));
		String newDateStr = this.FormatDate(date, "yyyy") + "-";
		if (month <= 6) {
			newDateStr += "06-30";
		} else {
			newDateStr += "12-31";
		}
		return this.stringToDateShort(newDateStr);
	}

	/**
	 * ȡ����ĩʱ��
	 * 
	 * @param date
	 *            ����
	 * @return date
	 */
	public static Date getSeasonEnd(Date date) {
		int year = Integer.parseInt(FormatDate(date, "yyyy"));
		int month = Integer.parseInt(FormatDate(date, "MM"));
		String newDateStr = FormatDate(date, "yyyy") + "-";
		if (month >= 1 && month <= 3) {
			newDateStr += "03-31";
		} else if (month >= 4 && month <= 6) {
			newDateStr += "06-30";
		} else if (month >= 7 && month <= 9) {
			newDateStr += "09-30";
		} else if (month >= 10 && month <= 12) {
			newDateStr += "12-31";
		}
		return stringToDateShort(newDateStr);
	}

	/**
	 * ȡ�����
	 * 
	 * @param date
	 * @return
	 */
	public Date getYearBegin(Date date) {
		String newDateStr = this.FormatDate(date, "yyyy") + "-01-01";
		return this.stringToDateShort(newDateStr);
	}

	/**
	 * �Ƿ�Ϊ��ĩ
	 * 
	 * @param date
	 *            ʱ��
	 * @return
	 */
	public static Date getYearEnd(Date date) {
		String newDateStr = FormatDate(date, "yyyy") + "-12-31";
		return stringToDateShort(newDateStr);
	}

	/**
	 * �Ƿ�ΪѮĩ
	 * 
	 * @param date
	 *            ʱ��
	 * @return �ǻ��
	 */
	public boolean IsXperiodEnd(Date date) {

		boolean flag = false;

		String day = this.getDay(date);
		String month = this.getMonth(date);

		if (day.equalsIgnoreCase("10")) {
			flag = true;
		} else if (day.equalsIgnoreCase("20")) {
			flag = true;
		}
		// ��ĩ����Ѯĩ
		// else if( this.getMonthEnd(date).compareTo(date)==0 ){
		// flag = true;
		// }

		return flag;
	}

	/**
	 * ��ȡһ���º��ͬһ���String��������
	 * 
	 * @return String
	 */
	public static String getDateAfterAMonth(String date) {
		Date iDate = stringToDateShort(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(iDate);
		calendar.add(Calendar.MONTH, 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s = df.format(calendar.getTime());
		return s;
	}

	/**
	 * �Ƚ����ڴ�С
	 * 
	 * @author gaofeng
	 * @param dateString1
	 * @param dateString2
	 * @return rslt
	 * 1��ʾ dateString1>dateString2
	 * 0��ʾdateString1=dateString2
	 * -1��ʾdateString1<dateString2
	 */
	public static int compareDateString(String dateString1, String dateString2) {
		int rslt = 0;
		java.util.Date date1 = DateUtils.stringToDate(dateString1, "yyyy-MM-dd");
		java.util.Date date2 = DateUtils.stringToDate(dateString2, "yyyy-MM-dd");

		int intdate1 = Integer.parseInt(DateUtils.FormatDate(date1, "yyyyMMdd"));
		int intdate2 = Integer.parseInt(DateUtils.FormatDate(date2, "yyyyMMdd"));
		if (intdate1 > intdate2) {
			rslt = 1;
		} else if (intdate1 < intdate2) {
			rslt = -1;
		} else {
			rslt = 0;
		}

		return rslt;
	}

	/**
	 * �Ƚ����ڴ�С
	 * 
	 * @author gaofeng
	 * @param dateString1
	 * @param dateString2
	 * @return
	 */
	public int compareDate(Date date1, Date date2) {
		int rslt = 0;

		int intdate1 = Integer.parseInt(DateUtils.FormatDate(date1, "yyyyMMdd"));
		int intdate2 = Integer.parseInt(DateUtils.FormatDate(date2, "yyyyMMdd"));
		if (intdate1 > intdate2) {
			rslt = 1;
		} else if (intdate1 < intdate2) {
			rslt = -1;
		} else {
			rslt = 0;
		}

		return rslt;
	}

	/**
	 * ȡ��ʱ������ �� mm��dd�� �� yy��mm�� �� yy�������(x=1/2/3/4) �� yy��
	 * 
	 * @param granularity
	 *            ����
	 * @param statisticDate
	 *            ʱ��
	 * @return ʱ���Ӧ���ȵ�����
	 */
	public String getTimedes2(String granularity, String statisticDate) {
		String timedes = "";
		Date date = DateUtils.stringToDateShort(statisticDate);
		String year = "", month = "01", day = "01";
		year = DateUtils.getYear(date).substring(2, 4);
		month = DateUtils.getMonth(date);
		day = DateUtils.getDay(date);
		if (granularity.equals("1")) {// ��
			timedes = month + "��" + day + "��";
			;
		} else if (granularity.equals("4")) {// ��
			timedes = year + "��" + month + "��";

		} else if (granularity.equals("8")) {// ��
			String quarter = month + "-" + day;
			if (quarter.equals("03-31")) {
				timedes = year + "��1����";
			} else if (quarter.equals("06-30")) {
				timedes = year + "��2����";
			} else if (quarter.equals("09-30")) {
				timedes = year + "��3����";
			} else if (quarter.equals("12-31")) {
				timedes = year + "��4����";
			}
		} else if (granularity.equals("32")) {// ��
			timedes = year + "��";
		}
		return timedes;
	}

	/**
	 * ȡ�������·�Map
	 * 
	 * @return
	 */
	public static TreeMap<String,String> getCurrentMonthCount() {
		 TreeMap<String,String> monthMap = new TreeMap<String,String>();
	        for(int i = 1; i <= 12;i++){
	        	String str ;
	        	if(i < 10){
	        		str = "0" + i;
	        	} else {
	        		str = i + "";
	        	}
	        	monthMap.put(str, str);
	        }
	        return monthMap;
	}
}
