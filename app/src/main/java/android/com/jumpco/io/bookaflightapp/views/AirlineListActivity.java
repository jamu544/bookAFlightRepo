package android.com.jumpco.io.bookaflightapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.com.jumpco.io.bookaflightapp.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing list view with the custom adapter
        context = this;
         itemList = new ArrayList<Airline>();

        itemArrayAdapter = new AirlineRecyclerViewAdapter(context,R.layout.item_row, initArlines());
        recyclerView = (RecyclerView) findViewById(R.id.airlineRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);


//
//        recyclerView = (RecyclerView)findViewById(R.id.airlineRecyclerView);
//
//        ArrayList<Airline> itemList = new ArrayList<Airline>();
//
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//
//
//        airlineAdapter = new AirlineAdapter(R.layout.item_row,itemList);
//       recyclerView.setAdapter(airlineAdapter);

    }
    // Populating list items
    private ArrayList<Airline> initArlines() {
        ArrayList<Airline> list = new ArrayList<>();

        list.add(new Airline(3,"Fly Emirates",500));
        list.add(new Airline( 1,"Qatar Airlines",632));
        list.add(new Airline( 2,"British Airlines",633));
        list.add(new Airline( 4,"Kulula.com",400));

        return list;
    }
}