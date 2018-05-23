package com.example.administrator.thaythuoc.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.thaythuoc.R;
import com.example.administrator.thaythuoc.database.Database;

public class AdapterTenThuoc extends RecyclerView.Adapter<AdapterTenThuoc.ViewHolder> {
    private IGetAdapterA iGetAdapterA;

    public AdapterTenThuoc(IGetAdapterA iGetAdapterA) {
        this.iGetAdapterA = iGetAdapterA;
    }

    @NonNull
    @Override
    public AdapterTenThuoc.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.items_alph,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTenThuoc.ViewHolder holder, final int position) {
        Database database = iGetAdapterA.getItem(position);
        holder.tvName.setText(database.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                iGetAdapterA.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return iGetAdapterA.getCount();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_alpha);
        }

    }

    public interface IGetAdapterA{
        int getCount();
        Database getItem(int position);
//        void onClickItem (int position);


    }
}
