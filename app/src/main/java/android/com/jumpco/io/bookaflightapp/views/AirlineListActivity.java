package android.com.jumpco.io.bookaflightapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.com.jumpco.io.bookaflightapp.R;
import android.com.jumpco.io.bookaflightapp.databinding.ActivityMainBinding;
import android.com.jumpco.io.bookaflightapp.model.Airline;
import android.com.jumpco.io.bookaflightapp.viewmodels.AirlineRecyclerViewAdapter;
import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class AirlineListActivity extends AppCompatActivity {

    private ArrayList<Airline> airlines;
    private Context context;
    private AirlineRecyclerViewAdapter airlineAdapter;
    private RecyclerView recyclerView;
    AirlineRecyclerViewAdapter itemArrayAdapter;
    ArrayList <Airline> itemList;



    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        // Initializing list view with the custom adapter
            context = this;
//         itemList = new ArrayList<Airline>();
//
//        itemArrayAdapter = new AirlineRecyclerViewAdapter(context,R.layout.item_row, initArlines());
//        recyclerView = (RecyclerView) findViewById(R.id.airlineRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(itemArrayAdapter);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        populateAirlines();
    }
    // Populating list items
    private ArrayList<Airline> populateAirlines() {
        ArrayList<Airline> list = new ArrayList<>();

        list.add(new Airline("3","Fly Emirates","500",false,false));
        list.add(new Airline( "1","Qatar Airlines","632",false,false));
        list.add(new Airline( "2","British Airlines","633",false,false));
        list.add(new Airline( "4","Kulula.com","400",false,false));

        AirlineRecyclerViewAdapter itemArrayAdapter = new AirlineRecyclerViewAdapter(this, list);
        binding.setMyAdapter(itemArrayAdapter);


        return list;
    }
}