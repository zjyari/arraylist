import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Slf4j
public class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private Date eventDate;
    private List<Attendee> eventAttendees;

    public Event(String eventID, String eventName, String eventVenue, String eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        try {
            this.eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(eventDate);
        } catch (ParseException e) {
            log.error("Error parsing event date: {}", e.getMessage());
            this.eventDate = null;
        }
        this.eventAttendees = new ArrayList<>();
    }

    public void organizeEvent() {
        Attendee attendee = new Attendee("John Doe");
        eventAttendees.add(attendee);
        for (Attendee a : eventAttendees) {
            if (a.getName().equals("John Doe")) {
                a.setName("Updated Name");
                break;
            }
        }
        eventAttendees.removeIf(a -> a.getName().equals("Updated Name"));
        Attendee foundAttendee = eventAttendees.stream()
                .filter(a -> a.getName().equals("John Doe"))
                .findFirst()
                .orElse(null);

        if (foundAttendee != null) {
            log.info("Found attendee: {}", foundAttendee.getName());
        } else {
            log.info("Attendee not found");
        }
        log.info("Total number of attendees: {}", eventAttendees.size());
    }
}