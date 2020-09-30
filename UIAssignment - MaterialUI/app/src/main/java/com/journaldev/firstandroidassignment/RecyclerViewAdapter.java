package com.journaldev.firstandroidassignment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.journaldev.firstandroidassignment.entities.UI;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG ="RecyclerViewAdapter";

    private Context context;
    private List<UI> personList;
    private int lastPosition = -1;

    private ArrayList<String> UIList = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mtitles = new ArrayList<>();
    private ArrayList<String> msecondaryText = new ArrayList<>();
    private ArrayList<String> msupportingText = new ArrayList<>();
    private ArrayList<String> mbutton1 = new ArrayList<>();
    private ArrayList<String> mbutton2 = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext) {
        this.mImages = mImages;
        this.mtitles = mtitles;
        this.msecondaryText = msecondaryText;
        this.msupportingText = msupportingText;
        this.mbutton1 = mbutton1;
        this.mbutton2 = mbutton2;
        this.mContext = mContext;
    }
    public void setPersonsList(List<UI> list){
        personList= list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder");

    }

    @Override
    public int getItemCount() {
        if(UIList==null){
            return 0;
        }
        return UIList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
