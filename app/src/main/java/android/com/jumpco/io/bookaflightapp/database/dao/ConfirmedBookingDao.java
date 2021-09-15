package android.com.jumpco.io.bookaflightapp.database.dao;

import android.com.jumpco.io.bookaflightapp.model.Airline;
import android.com.jumpco.io.bookaflightapp.model.ConfirmedBooking;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ConfirmedBookingDao {

    //get list of airlines
    @Query("SELECT * FROM ConfirmedBooking WHERE id = :id")
    LiveData<List<ConfirmedBooking>> getBooking(int id);

    @Insert
        // insert an airline
    int insertBooking(ConfirmedBooking booking);

    @Update
        // update airline details
    int updateBooking(ConfirmedBooking booking);

    // delete the selected airline
    @Query("DELETE FROM ConfirmedBooking WHERE id = :id")
    int deleteBooking(int airlineItem);


}
