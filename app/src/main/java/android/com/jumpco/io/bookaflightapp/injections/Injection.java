package android.com.jumpco.io.bookaflightapp.injections;

import android.com.jumpco.io.bookaflightapp.database.dao.BookingAFlightDatabase;
import android.com.jumpco.io.bookaflightapp.repositories.AirlineDataRepository;
import android.com.jumpco.io.bookaflightapp.repositories.BookingDataRepository;
import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//Explanations: This class will be responsible for providing objects already built, in a centralized way.
public class Injection {

    public static BookingDataRepository provideBookingDataSource(Context context) {

        BookingAFlightDatabase database = BookingAFlightDatabase.getInstance(context);

        return new BookingDataRepository(database.bookingDao());

    }


    public static AirlineDataRepository provideAirlineDataSource(Context context) {

        BookingAFlightDatabase database = BookingAFlightDatabase.getInstance(context);

        return new AirlineDataRepository(database.airlineDao());

    }


    public static Executor provideExecutor(){ return Executors.newSingleThreadExecutor(); }


    public static ViewModelFactory provideViewModelFactory(Context context) {

        BookingDataRepository dataSourceBooking = provideBookingDataSource(context);

        AirlineDataRepository dataSourceAirline = provideAirlineDataSource(context);

        Executor executor = provideExecutor();

        return new ViewModelFactory(dataSourceAirline, dataSourceBooking, executor);

    }
}
