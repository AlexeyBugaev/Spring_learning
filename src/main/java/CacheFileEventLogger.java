import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abugaev on 04.01.2018.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache=new ArrayList<Event>();

    public CacheFileEventLogger(String filename, int cacheSize) throws IOException {
                super(filename);
                this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event){
        cache.add(event);

        if(cache.size()==cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
}
public void writeEventsFromCache(){
    for (Event ev:cache) {
        super.logEvent(ev);
    }
}

public void destroy(){
    if(!cache.isEmpty()) writeEventsFromCache();
}
}
