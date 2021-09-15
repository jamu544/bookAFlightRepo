package android.com.jumpco.io.bookaflightapp.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Airline.class,

        parentColumns = "id",

        childColumns = "airlineId"))

public class Booking {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private int numberOfAdults;
    private int numberOfChildren;
    private String flightName;
    private String basePriceForAdults;
    private long basePriceForChildren;
    private String departing;//date
    private String returning;//date
    private boolean isBooked;
    private boolean isDeleted;
    private String from;
    private String to;


    public Booking(int id, String title, int numberOfAdults, int numberOfChildren, String flightName,
                   String basePriceForAdults, long basePriceForChildren, String departing,
                   String returning, boolean isBooked, boolean isDeleted, String from, String to) {
        this.id = id;
        this.title = title;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.flightName = flightName;
        this.basePriceForAdults = basePriceForAdults;
        this.basePriceForChildren = basePriceForChildren;
        this.departing = departing;
        this.returning = returning;
        this.isBooked = isBooked;
        this.isDeleted = isDeleted;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberOfAdults=" + numberOfAdults +
                ", numberOfChildren=" + numberOfChildren +
                ", flightName='" + flightName + '\'' +
                ", basePriceForAdults='" + basePriceForAdults + '\'' +
                ", basePriceForChildren=" + basePriceForChildren +
                ", departing='" + departing + '\'' +
                ", returning='" + returning + '\'' +
                ", isBooked=" + isBooked +
                ", isDeleted=" + isDeleted +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getReturning() {
        return returning;
    }

    public void setReturning(String returning) {
        this.returning = returning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getBasePriceForAdults() {
        return basePriceForAdults;
    }

    public void setBasePriceForAdults(String basePriceForAdults) {
        this.basePriceForAdults = basePriceForAdults;
    }

    public long getBasePriceForChildren() {
        return basePriceForChildren;
    }

    public void setBasePriceForChildren(long basePriceForChildren) {
        this.basePriceForChildren = basePriceForChildren;
    }

    public String getDeparting() {
        return departing;
    }

    public void setDeparting(String departing) {
        this.departing = departing;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}