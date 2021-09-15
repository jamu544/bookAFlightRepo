package android.com.jumpco.io.bookaflightapp.injections;

import android.com.jumpco.io.bookaflightapp.repositories.AirlineDataRepository;
import android.com.jumpco.io.bookaflightapp.repositories.BookingDataRepository;
import android.com.jumpco.io.bookaflightapp.viewmodels.ItemViewModel;

import java.util.concurrent.Executor;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {


    private final AirlineDataRepository airlineDataSource;
    private final BookingDataRepository bookingDataSource;
    private final Executor executor;

    public ViewModelFactory(AirlineDataRepository airlineDataSource, BookingDataRepository bookingDataSource, Executor executor) {

        this.airlineDataSource = airlineDataSource;

        this.bookingDataSource = bookingDataSource;

        this.executor = executor;

    }
    /**
     * Creates a new instance of the given {@code Class}.
     * <p>
     *
     * @param modelClass a {@code Class} whose instance is requested
     * @return a newly created ViewModel
     */
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ItemViewModel.class)) {

            return (T) new ItemViewModel(airlineDataSource,bookingDataSource, executor);

        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
