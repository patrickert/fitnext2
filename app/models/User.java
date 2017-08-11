package models;

import io.ebean.Finder;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.Constraint;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( unique = true)
    public int ID;

    @Constraints.Required
    public String firstName;

    @Constraints.Required
    public String lastName;

    @Constraints.Required
    public String password;

    @Constraints.Required
    @Column(unique = true)
    public String mail;

    public int height;

    public double weight;

    @Constraints.Required
    public String authToken;

    public String fbToken;

    @Formats.DateTime(pattern="yyyy-MM-dd")
    public LocalDate birthday;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="USER_RECORDS", joinColumns = @JoinColumn(name = "USER_ID"))
    public List<Record> records;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="USER_HISTORY", joinColumns = @JoinColumn(name = "USER_ID"))
    @OrderBy("date desc")
    public Set<Activity> history;

    @ElementCollection
    @CollectionTable(name="USER_FAVORITES", joinColumns = @JoinColumn(name = "USER_ID"))
    public List<Activity> favorites;

    public static Finder<Integer, User> find = new Finder<>(User.class);

}
