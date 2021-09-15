package android.com.jumpco.io.bookaflightapp.repositories;

import android.com.jumpco.io.bookaflightapp.database.dao.AirlineDao;
import android.com.jumpco.io.bookaflightapp.model.Airline;

import java.util.List;

import androidx.lifecycle.LiveData;

public class AirlineDataRepository {

    private final AirlineDao airlineDao;

    private LiveData<List<Airline>> mAllData;


    public AirlineDataRepository(AirlineDao airlineDao) {
        this.airlineDao = airlineDao;
    }


    // --- GET AIRLINES ---

    public LiveData<List<Airline>> getAirline() {
        return mAllData;
    }
}
