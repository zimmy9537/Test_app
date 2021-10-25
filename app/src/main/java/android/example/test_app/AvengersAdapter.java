package android.example.test_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AvengersAdapter extends RecyclerView.Adapter<AvengersAdapter.AvengersViewHolder> {

    private ArrayList<Avengers> avengers;
    private Context context;

    public AvengersAdapter(ArrayList<Avengers> avengers, Context context) {
        this.avengers = avengers;
        this.context = context;
    }

    @NonNull
    @Override
    public AvengersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.avengers_item, parent, false);
        return new AvengersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvengersViewHolder holder, int position) {
        Avengers avenger = avengers.get(position);
        holder.avengerName.setText(avenger.getName());
        holder.avengerRating.setText(avenger.getRating());
        holder.avengerImageView.setImageResource(avenger.getImageResource());
        holder.avengerLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,RatingActivity.class);
                intent.putExtra("avenger",avenger);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return avengers.size();
    }

    class AvengersViewHolder extends RecyclerView.ViewHolder {

        ImageView avengerImageView;
        TextView avengerName;
        TextView avengerRating;
        LinearLayout avengerLinearLayout;

        public AvengersViewHolder(@NonNull View itemView) {
            super(itemView);

            avengerImageView = itemView.findViewById(R.id.avengerImage);
            avengerName = itemView.findViewById(R.id.avengerName);
            avengerRating = itemView.findViewById(R.id.avengerRating);
            avengerLinearLayout=itemView.findViewById(R.id.avengerLL);
        }
    }
}
