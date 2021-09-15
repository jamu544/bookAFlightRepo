package android.com.jumpco.io.bookaflightapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ConfirmedBooking {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String bookingReference;
    private int forBook;
    private int forUser;

    //calculate the flight price
    public void calculateBookingPrice(){

    }

}
