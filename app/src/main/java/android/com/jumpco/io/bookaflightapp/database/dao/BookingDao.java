package android.com.jumpco.io.bookaflightapp.database.dao;

import android.com.jumpco.io.bookaflightapp.model.Booking;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface BookingDao {

    @Query("SELECT * FROM Booking WHERE id =:id")
    LiveData<List<Booking>> getBookings(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    int insertBooking(Booking booking);

    @Update
    int updateBooking(Booking booking);

    @Query("DELETE FROM Booking WHERE id = :id")
    int deleteBooking(int id);
}
