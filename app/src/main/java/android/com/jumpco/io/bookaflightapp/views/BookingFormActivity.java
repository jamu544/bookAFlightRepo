package android.com.jumpco.io.bookaflightapp.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.com.jumpco.io.bookaflightapp.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BookingFormActivity extends AppCompatActivity {

    private String airlineName;
    private int basePricePerPerson;
    private Context context;

    private TextView booKingTxtView;
    private TextView firstNameTxtView;
    private TextView lastNameTxtView;
    private TextView phoneTxtView;
    private TextView emailTxtView;
    private TextView numberOfAdultsTxtView;
    private TextView numberOfChildrenTxtView;
    private TextView departDateTxtView;
    private TextView returnDateTxtView;
    private TextView departTxtView;
    private TextView arrivalTxtView;
    private TextView priceTxtView;


    private EditText firstNameEditView;
    private EditText lastNameEditView;
    private EditText phoneEditView;
    private EditText emailEditView;
    private EditText numberOfAdultsEditView;
    private EditText numberOfChildrenEditView;
    private EditText departDateEditView;
    private EditText returnDateEditView;
    private EditText departEditView;
    private EditText arrivalEditView;
    private EditText priceEditView;

    private Button bookBtn;



    //ref

    private String firstName;
    private String destionation;
    private String date;
    private String price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        init();
        Bundle bundle = getIntent().getExtras();
        airlineName = bundle.getString("nameOfAirline");
        basePricePerPerson = bundle.getInt("basePricePerPerson");

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookingRefAlert();
            }
        });
    }

    //init
    public void init(){
        context = this;
        firstNameEditView  = findViewById(R.id.txtName);
        lastNameEditView  = findViewById(R.id.txtLastName);
        phoneEditView = findViewById(R.id.txtphoneNumber);
        emailEditView = findViewById(R.id.txtEmail);
        numberOfAdultsEditView  = findViewById(R.id.txtAdult);
        numberOfChildrenEditView  = findViewById(R.id.txtChildren);
        departDateEditView = findViewById(R.id.txtStartDate);
        returnDateEditView = findViewById(R.id.txtEndDate);
        departEditView = findViewById(R.id.txtDepart);
        arrivalEditView = findViewById(R.id.txtEndDate);
        priceEditView = findViewById(R.id.txtPrice);
        bookBtn = findViewById(R.id.btnBookings);
    }
    // booking ref
    public void bookingRefAlert(){

         firstName = firstNameEditView.getText().toString();
         destionation = departEditView.getText().toString();
         date = departDateEditView.getText().toString() ;
         price = "R 522";


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Confirm Booking");
        builder.setMessage("refName : "+firstName+ "\n"+ "ref "+destionation+ "\n"+ " date "+ date+ "\n"+" price "+price+" ");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(BookingFormActivity.this, AirlineListActivity.class);
                intent.putExtra("nameOfAirline", "Qatar");
                intent.putExtra("basePricePerPerson", 500);
                context.startActivity(intent);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alert11 = builder.create();
        alert11.show();


    }



}