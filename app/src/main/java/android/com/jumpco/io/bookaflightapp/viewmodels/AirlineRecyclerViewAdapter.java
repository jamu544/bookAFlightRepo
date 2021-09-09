package android.com.jumpco.io.bookaflightapp.viewmodels;

import android.com.jumpco.io.bookaflightapp.R;
import android.com.jumpco.io.bookaflightapp.model.Airline;
import android.com.jumpco.io.bookaflightapp.views.AirlineListActivity;
import android.com.jumpco.io.bookaflightapp.views.BookingFormActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AirlineRecyclerViewAdapter extends RecyclerView.Adapter<AirlineRecyclerViewAdapter.ViewHolder>{

    private List<Airline> itemList;
  //  private ClickListener clickListener;
    private Context context;
    private int listLayout;

    public AirlineRecyclerViewAdapter(Context context,int layoutId, List<Airline>airlines){
       listLayout = layoutId;
        this.itemList = airlines;
        this.context = context;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override // specify the row layout file and click for each row
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_row,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  AirlineRecyclerViewAdapter.ViewHolder holder, int position) {
        final  Airline item = itemList.get(position);
        holder.name.setText(item.getNameOfAirline());
        holder.price.setText(String.valueOf(item.getBasePriceForPerson()));
        holder.id.setText(String.valueOf(item.getId()));
//        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(),
//                        "click on item: "+item.getNameOfAirline(),
//                        Toast.LENGTH_LONG).show();
//            }
//        });
    }


    // get the size of the List
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        public TextView name,price,id;
        private LinearLayout itemLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.tvAirlineName);
            price = itemView.findViewById(R.id.tvPrice);
            id = itemView.findViewById(R.id.tvID);
        }

        @Override
        public void onClick(View view) {

            Intent i = new Intent(context, BookingFormActivity.class);
            i.putExtra("nameOfAirline", "Qatar");
            i.putExtra("basePricePerPerson", 500);
            context.startActivity(i);



            Log.d("onclick", "onClick " + getLayoutPosition() + " " + name.getText()+" "+price.getText()+" "+id.getText());
        }
    }
}
