package br.com.bb.ditec.gesit.capacidade.api.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * https://stackoverflow.com/questions/33942544/how-to-skip-weekends-while-adding-days-to-localdate-in-java-8
 **/
public class DataUtils {
    
	 private static final int DIAS_UTEIS = 15;
  
	public static Calendar getProximos15DiasUteis(Calendar localDate) {
		return LocalDateToCalendar( getAdicionarDiasUteis( calendarTOlocalDate(localDate) , DIAS_UTEIS) );
	}
	
	

	public static String getUltimaDataUtil(Calendar calendar) {

		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
			cal.add(Calendar.DATE, -2);
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == 2) {
			cal.add(Calendar.DATE, -3);
		} else {
			cal.add(Calendar.DATE, -1);
		}

		return df.format(cal.getTime());
	}

	private static long getActualNumberOfDaysToAdd(long workdays, int dayOfWeek) {
		if (dayOfWeek < 6) { // date é um dia de trabalho
			return workdays + (workdays + dayOfWeek - 1) / 5 * 2;
		} else { // a data é um fim de semana
			return workdays + (workdays - 1) / 5 * 2 + (7 - dayOfWeek);
		}
	}

	private static LocalDate getAdicionarDiasUteis(LocalDate date, long workdays) {
		if (workdays < 1) {
			return date;
		}
		return date.plusDays(getActualNumberOfDaysToAdd(workdays, date.getDayOfWeek().getValue()));
	}
	
	public static LocalDate calendarTOlocalDate(Calendar date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static Calendar LocalDateToCalendar(LocalDate date) {
		return  GregorianCalendar.from(  date.atStartOfDay( ZoneId.systemDefault() )  );
	}



	public static String format(Calendar dataFim) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return f.format( dataFim.getTime());
	}
	
	public static String formatStr(Calendar dataFim) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format( dataFim.getTime());
	}
	
	public static Calendar ToCalendar(String data) {
		  try {
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				 cal.setTime( sdf.parse(data));
				return cal;
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	


	
}
