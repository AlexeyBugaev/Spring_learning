

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by abugaev on 03.01.2018.
 */
public class App {

    private Client client;
    private eventLogger eventLogger;
    private LinkedHashMap<EventType,eventLogger> loggers;

    public void logEvent(String msg, EventType type){
        eventLogger logger=loggers.get(type);
        if(logger==null)logger=eventLogger;
        String message=msg.replaceAll(client.getId(),client.getFullName());
        Event event=(Event)new ClassPathXmlApplicationContext("Spring.xml").getBean("event");
        event.setMsg(message);
        logger.logEvent(event);
    }

    public App(Client client, eventLogger eventLogger, LinkedHashMap<EventType, eventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers=loggers;
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx= new ClassPathXmlApplicationContext("Spring.xml");
        App app=(App)ctx.getBean("app");
        app.logEvent("Some event for user 1", EventType.ERROR);
        app.logEvent("Some event for user 2", EventType.INFO);
        Thread.sleep(5000);
        app.logEvent("Some event for user 3", null);
        app.logEvent("Some event for user 4", EventType.ERROR);
        ctx.close();
    }

}
