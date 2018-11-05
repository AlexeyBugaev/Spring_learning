import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by abugaev on 04.01.2018.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df=df;
        id=(int)Math.random();
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                ", df=" + df.format(date) +
                '}';
    }

    public void setMsg(String msg) {

        this.msg = msg;
    }

    public String getMsg() {

        return msg;
    }

    public static boolean isDay(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour>8&&hour<17) return true;
        else return false;
    }
}
