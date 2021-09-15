package android.com.jumpco.io.bookaflightapp.database.dao;

import android.com.jumpco.io.bookaflightapp.model.Airline;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AirlineDao {
    //get list of airlines
    @Query("SELECT * FROM Airline WHERE id = :id")
    LiveData<Airline> getAirlines(int id);

    @Insert // insert an airline
    int insertAirline(Airline airline);

    @Update // update airline details
    int updateAirline(Airline airline);

    // delete the selected airline
    @Query("DELETE FROM Airline WHERE id = :airlineItem")
    int deleteAirline(int airlineItem);

    //Get all items
    @Query("SELECT * FROM Airline")
    LiveData<List<Airline>> getAllData();



}
