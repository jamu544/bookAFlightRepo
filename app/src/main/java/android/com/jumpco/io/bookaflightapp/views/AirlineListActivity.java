package android.com.jumpco.io.bookaflightapp.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.com.jumpco.io.bookaflightapp.R;
import android.com.jumpco.io.bookaflightapp.databinding.ActivityMainBinding;
import android.com.jumpco.io.bookaflightapp.injections.Injection;
import android.com.jumpco.io.bookaflightapp.injections.ViewModelFactory;
import android.com.jumpco.io.bookaflightapp.model.Airline;
import android.com.jumpco.io.bookaflightapp.viewmodels.AirlineRecyclerViewAdapter;
import android.com.jumpco.io.bookaflightapp.viewmodels.ItemViewModel;
import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AirlineListActivity extends AppCompatActivity {


    private Context context;
    private ActivityMainBinding binding;

    //1 --
    private ItemViewModel itemViewModel;
    private AirlineRecyclerViewAdapter itemArrayAdapter;
    private static int AIRLINE_ID = 1;


    private ItemViewModel mDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemArrayAdapter = new AirlineRecyclerViewAdapter(this, new ArrayList<Airline>());





        binding.setMyAdapter(itemArrayAdapter);

        mDataViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

     //   mDataViewModel = ViewModelProviders.of(this).get(ItemViewModel.class); depracted

        mDataViewModel.getAirlines().observe(AirlineListActivity.this, new Observer<List<Airline>>() {
            /**Vie
             * Called when the data is changed.
             *
             * @param airline The new data
             */
            @Override
            public void onChanged(@Nullable List<Airline> airline) {
                itemArrayAdapter.addItems(airline);
            }

            /**
             * Called when the data is changed.
             *
             * @param airlines The new data
             */


//            @Override
//            public void onChanged(@Nullable List<BorrowModel> itemAndPeople) {
//                recyclerViewAdapter.addItems(itemAndPeople);
//            }
        });


//        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        populateAirlines();
    }
    // Populating list items
    private ArrayList<Airline> populateAirlines() {
        ArrayList<Airline> list = new ArrayList<>();

        list.add(new Airline(3,"Fly Emirates",500,false,false));
        list.add(new Airline( 1,"Qatar Airlines",632,false,false));
        list.add(new Airline( 2,"British Airlines",633,false,false));
        list.add(new Airline( 4,"Kulula.com",400,false,false));

        itemArrayAdapter = new AirlineRecyclerViewAdapter(this, list);
        binding.setMyAdapter(itemArrayAdapter);


        return list;
    }


    // 2 - Configuring ViewModel

    private void configureViewModel(){

        ViewModelFactory mViewModelFactory = Injection.provideViewModelFactory(this);

        this.itemViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ItemViewModel.class);

        this.itemViewModel.init(AIRLINE_ID);

    }


    // ---


    // 3 - Get Current Airline

//    private void getCurrentAirline(int airlineId){
//
//        this.itemViewModel.getAirline(airlineId).observe(this, this::updateHeader);
//
//    }
//
//
//    // ---
//
//
//    // 3 - Get all items for a user
//
//    private void getItems(int airlineId){
//
//        this.itemViewModel.getItems(airlineId).observe(this, this::updateItemsList);
//
//    }
}