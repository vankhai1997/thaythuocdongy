package com.example.administrator.thaythuoc.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.thaythuoc.R;
import com.example.administrator.thaythuoc.database.ListAlpha;

public class AdapterListAlpha extends RecyclerView.Adapter<AdapterListAlpha.ViewHolderAlpha> {
    private IGetAdapterAlpha iGetA;

    public AdapterListAlpha(IGetAdapterAlpha iGetA) {
        this.iGetA = iGetA;
    }

    @NonNull
    @Override
    public ViewHolderAlpha onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolderAlpha(inflater.inflate(R.layout.items_alph,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAlpha holder, final int position) {
        ListAlpha listAlpha = iGetA.getItems(position);
        holder.tvAlpha.setText(listAlpha.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iGetA.onClickItem(position);
                Log.d("a", "onClick: "+position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return iGetA.getCount();
    }

    static final class ViewHolderAlpha extends RecyclerView.ViewHolder {
        private TextView tvAlpha;

        public ViewHolderAlpha(View itemView) {
            super(itemView);
            tvAlpha = itemView.findViewById(R.id.tv_alpha);
        }
    }
    public interface IGetAdapterAlpha{
        int getCount ();
        ListAlpha  getItems(int position);
        void onClickItem(int position);
    }
}
