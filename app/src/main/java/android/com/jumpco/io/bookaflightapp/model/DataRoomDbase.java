package android.com.jumpco.io.bookaflightapp.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Airline.class},version = 1, exportSchema = false)
public abstract class DataRoomDbase extends RoomDatabase {

    private static DataRoomDbase INSTANCE;

    public abstract DataDAO dataDAO();

    public static DataRoomDbase getDatabase(Context context){
        if(INSTANCE == null){

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    DataRoomDbase.class, DataRoomDbase.class.getName())
                    //if you want to create db only in memory, not in file
                    //Room.inMemoryDatabaseBuilder
                    //(context.getApplicationContext(), DataRoomDbase.class)

                    .build();

        }
        return INSTANCE;
    }
    public static void destroyInstance(){
        INSTANCE = null;
    }
}
