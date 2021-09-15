package android.com.jumpco.io.bookaflightapp.viewmodels;

import android.com.jumpco.io.bookaflightapp.model.Airline;
import android.com.jumpco.io.bookaflightapp.model.Booking;
import android.com.jumpco.io.bookaflightapp.repositories.AirlineDataRepository;
import android.com.jumpco.io.bookaflightapp.repositories.BookingDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

    // REPOSITORIES

    private final BookingDataRepository bookingDataSource;

    private final AirlineDataRepository airlineDataSource;

    private final Executor executor;




    // DATA

    @Nullable

    private LiveData<List<Airline>> airlineLiveData;


    public ItemViewModel(AirlineDataRepository airlineDataSource, BookingDataRepository bookingDataSource, Executor executor) {

        this.airlineDataSource = airlineDataSource;

        this.bookingDataSource = bookingDataSource;

        this.executor = executor;

    }


    public void init(int airlineId) {

        if (this.airlineLiveData != null) {

            return;

        }

    //    airlineLiveData = airlineDataSource.getAirline(airlineId);

    }


    // -------------

    // FOR AIRLINES

    // -------------


    public LiveData<List<Airline>> getAirlines() {
        return airlineLiveData;

    }


    // -------------

    // FOR BOOKING

    // -------------


    public LiveData<List<Booking>> getBookings(int bookingId) {

        return bookingDataSource.getBookings(bookingId);

    }


    public void createBooking(Booking item) {

        executor.execute(() -> {

            bookingDataSource.createBooking(item);

        });

    }


    public void deleteBooking(int bookingId) {

        executor.execute(() -> {

            bookingDataSource.deleteBooking(bookingId);

        });

    }


    public void updateBooking(Booking booking) {

        executor.execute(() -> {

            bookingDataSource.updateBooking(booking);

        });

    }
}
