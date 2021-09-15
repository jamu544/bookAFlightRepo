package android.com.jumpco.io.bookaflightapp.viewmodels;

import android.com.jumpco.io.bookaflightapp.BR;
import android.com.jumpco.io.bookaflightapp.R;
import android.com.jumpco.io.bookaflightapp.databinding.ItemRowBinding;
import android.com.jumpco.io.bookaflightapp.handlers.CustomClickListener;
import android.com.jumpco.io.bookaflightapp.model.Airline;
import android.com.jumpco.io.bookaflightapp.views.BookingFormActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class AirlineRecyclerViewAdapter extends RecyclerView.Adapter<AirlineRecyclerViewAdapter.ViewHolder> implements CustomClickListener
{

    private List<Airline> itemList;
    private Context context;


    public AirlineRecyclerViewAdapter(Context context,List<Airline>airlines){

        this.itemList = airlines;
        this.context = context;
    }

    @NonNull
    @Override // specify the row layout file and click for each row
    public AirlineRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        ItemRowBinding binding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext())
               ,R.layout.item_row,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
         Airline dataModel = itemList.get(position);
         holder.bind(dataModel);
         holder.itemRowBinding.setItemClickListener(this);
    }
    public void addItems(List<Airline> borrowModelList) {
        this.itemList = borrowModelList;
        notifyDataSetChanged();
    }


    // get the size of the List
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public void buttonClicked(Airline f) {
        Toast.makeText(context,"Data Binding "+f.getNameOfAirline(),Toast.LENGTH_SHORT).show();
        Intent i = new Intent(context, BookingFormActivity.class);
            i.putExtra("nameOfAirline", "Qatar");
            i.putExtra("basePricePerPerson", 500);
            context.startActivity(i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemRowBinding itemRowBinding;

        public ViewHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
         }
         public void bind(Object o){
             itemRowBinding.setVariable(BR.airline, o);
             itemRowBinding.executePendingBindings();

         }

    }
}
