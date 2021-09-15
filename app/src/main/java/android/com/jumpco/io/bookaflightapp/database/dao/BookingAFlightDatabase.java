package android.com.jumpco.io.bookaflightapp.database.dao;

import android.com.jumpco.io.bookaflightapp.model.Airline;
import android.com.jumpco.io.bookaflightapp.model.Booking;
import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.OnConflictStrategy;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Airline.class, Booking.class}, version = 1, exportSchema = false)
public abstract class BookingAFlightDatabase extends RoomDatabase {

    //---Singleton --
    private static volatile BookingAFlightDatabase INSTANCE;

    //---DAO --
    public abstract AirlineDao airlineDao();
    public abstract BookingDao bookingDao();

    // --- INSTANCE --
    public static BookingAFlightDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (BookingAFlightDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BookingAFlightDatabase.class,BookingAFlightDatabase.class.getName())
                            .addCallback(prepopulateDatabase())
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback prepopulateDatabase(){
        return new Callback() {
            /**
             * Called when the database is created for the first time. This is called after all the
             * tables are created.
             *
             * @param db The database.
             */
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                ContentValues contentValues = new ContentValues();
                contentValues.put("id",1);
                contentValues.put("nameOfAirline","Qatar Airways");
                contentValues.put("basePriceForPerson","533");
                contentValues.put("isBooked",true);
                contentValues.put("isDeleted", false);


                db.insert("Airline", OnConflictStrategy.IGNORE, contentValues);
            }
        };


    }
}
