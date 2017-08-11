package models;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Activity implements Comparable<Activity> {
    private String title;
    private String description;
    private int duration;
    private LocalDate date;

    @Override
    public int compareTo(@NotNull Activity o) {
        return -date.compareTo(o.date);
    }
}
