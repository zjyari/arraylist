import lombok.Data;

@Data
public class Attendee {
    private String name;

    public Attendee(String name) {
        this.name = name;
    }
}