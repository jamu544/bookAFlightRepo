package android.com.jumpco.io.bookaflightapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.com.jumpco.io.bookaflightapp.R;
import android.com.jumpco.io.bookaflightapp.model.Airline;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    private void prepareItem(){
//        for(int i = 0; i < 50; i++){
//            Airline items = new Airline("Items"+i,20+i);
//            items.add(items)
//        }
//    }
}