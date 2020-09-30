package com.journaldev.firstandroidassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.journaldev.firstandroidassignment.entities.UI;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private int lastPosition = -1;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private List<UI> UIList;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);

    }

    public void setPersonsList(List<UI> list){
        UIList= list;
        notifyDataSetChanged();
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    // inflates the row layout from xml when needed
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycle_item, parent, false);
        return new MyViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewName.setText(UIList.get(position).getName());
        holder.textViewEmail.setText(UIList.get(position).getEmail());
        setAnimation(holder.parent, position);
    }

    @Override
    public int getItemCount() {
        if(UIList==null){
            return 0;
        }
        return UIList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewName, textViewEmail;
        CardView parent;

        /**
         * Caches the view references : smooth srcoll
         * @param itemView
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);

            textViewName= itemView.findViewById(R.id.title);
            textViewEmail= itemView.findViewById(R.id.secondary_text);
        }

    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}