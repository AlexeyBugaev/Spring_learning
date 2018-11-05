/**
 * Created by abugaev on 03.01.2018.
 */
public class ConsoleEventLogger implements eventLogger{

    public void logEvent(Event event) {
       System.out.println(event.toString());

    }
}
