package com.example.photosearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Model> list;
    private Context context;
    private RequestOptions requestOptions;

    public Adapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
        requestOptions = new RequestOptions()
                .centerCrop()
                .dontTransform()
                .placeholder(R.drawable.finding)
                .error(R.drawable.finding);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = list.get(position);
        Glide.with(context).load(list.get(position).getImage()).apply(requestOptions).into(holder.viewHolderImageView);
        holder.viewHolderTextView.setText(model.getTitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView viewHolderImageView;
        TextView viewHolderTextView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.edtCardView);
            viewHolderImageView = itemView.findViewById(R.id.edtImage);
            viewHolderTextView = itemView.findViewById(R.id.edtTitle);
        }
    }
}
