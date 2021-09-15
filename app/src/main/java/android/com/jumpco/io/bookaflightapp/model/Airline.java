package android.com.jumpco.io.bookaflightapp.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Airline {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String nameOfAirline;
    public int basePriceForPerson;
    public boolean isBooked;
    public boolean isDeleted;

    @Ignore
    public Airline(int id, String nameOfAirline, int basePriceForPerson, boolean isBooked, boolean isDeleted) {
        this.id = id;
        this.nameOfAirline = nameOfAirline;
        this.basePriceForPerson = basePriceForPerson;
        this.isBooked = isBooked;
        this.isDeleted = isDeleted;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfAirline() {
        return nameOfAirline;
    }

    public void setNameOfAirline(String nameOfAirline) {
        this.nameOfAirline = nameOfAirline;
    }

    public int getBasePriceForPerson() {
        return basePriceForPerson;
    }

    public void setBasePriceForPerson(int basePriceForPerson) {
        this.basePriceForPerson = basePriceForPerson;
    }
}
