package android.com.jumpco.io.bookaflightapp.repositories;

import android.com.jumpco.io.bookaflightapp.database.dao.BookingDao;
import android.com.jumpco.io.bookaflightapp.model.Booking;

import java.util.List;

import androidx.lifecycle.LiveData;

public class BookingDataRepository {

    private final BookingDao bookingDao;


    public BookingDataRepository(BookingDao bookingDao) { this.bookingDao = bookingDao; }


    // --- GET ---


    public LiveData<List<Booking>> getBookings(int userId){ return this.bookingDao.getBookings(userId); }


    // --- CREATE ---


    public void createBooking(Booking item){ bookingDao.insertBooking(item); }


    // --- DELETE ---

    public void deleteBooking(int itemId){ bookingDao.deleteBooking(itemId); }


    // --- UPDATE ---

    public void updateBooking(Booking item){ bookingDao.updateBooking(item); }
}
