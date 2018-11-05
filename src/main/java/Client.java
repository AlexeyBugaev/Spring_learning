/**
 * Created by abugaev on 03.01.2018.
 */
public class Client {
    private String id;
    private String fullName;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    private String greeting;

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {

        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
