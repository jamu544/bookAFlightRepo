package android.com.jumpco.io.bookaflightapp.database.dao;

import android.app.Application;
import android.com.jumpco.io.bookaflightapp.model.Airline;

import java.util.List;

import androidx.lifecycle.LiveData;

public class DataRepository {

    private Airline airlineDao;
    private LiveData<List<Airline>> listLiveData;

    public DataRepository(Application application) {
        this.airlineDao = airlineDao;
    }
}
