package ru.samsung.itschool.mdev.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

// lombok

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewRow> {

    private ArrayList<MainActivity.Block> arrayList;

    public MyAdapter(ArrayList<MainActivity.Block> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_row,parent,false);
        return new ViewRow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewRow holder, int position) {
        holder.textView.setText(arrayList.get(position).getName());
        Picasso.get().load(arrayList.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewRow extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewRow(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

}
