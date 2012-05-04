package ie.cit.cloudapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calculateDays {
private Date startdate;
private Date enddate;
private Date date;
private Integer days;

public Date StrToDate(String strDate) throws ParseException{

    SimpleDateFormat sdFormat = new SimpleDateFormat("dd/mm/yyyy");  
	Date date = sdFormat.parse(strDate); 
    return date;
}


    public Calendar DateToCalendar(Date date){ 
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(date);
	  return cal;
	 }
    
	public Integer daysBetween(Calendar startDate, Calendar endDate) {  
		
		  Calendar date = (Calendar) startDate.clone();  
		  Integer daysBetween = 0;  
		  while (date.before(endDate)) {  
		    date.add(Calendar.DAY_OF_MONTH, 1);  
		    daysBetween++;  
		  }  
		  return daysBetween;  
		  
		} 
}
	