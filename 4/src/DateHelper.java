import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by KnightViral on 12.02.2017.
 */
public class DateHelper {
    GregorianCalendar currentDate;
    GregorianCalendar startDate;
    Integer skip=0;

    DateHelper(){
        startDate = new GregorianCalendar();
        currentDate = new GregorianCalendar();
        currentDate.add(Calendar.YEAR, -1500);
        startDate = currentDate;
    }

    public String getFormattedStartDate(){
        return String.valueOf(startDate.getTime());
    }

    public void skipTime(){
        currentDate.add(Calendar.MINUTE, 15);
        skip++;
    }

    public String getFormattedDiff(){
        return ("Дата окончания: "+currentDate.getTime()+"\nБой длился: "+(skip*15/60) + " часов "+ (skip*15%60)+" минут.");
    }


}
