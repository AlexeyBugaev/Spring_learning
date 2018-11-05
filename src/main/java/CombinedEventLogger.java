import java.util.Collection;
import java.util.List;

/**
 * Created by abugaev on 11.03.2018.
 */
public class CombinedEventLogger implements eventLogger {
    private List<eventLogger> loggers;

    public CombinedEventLogger(List<eventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for (eventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
