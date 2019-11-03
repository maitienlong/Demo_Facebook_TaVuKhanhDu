package com.example.demotavukhanhdu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demotavukhanhdu.R;
import com.example.demotavukhanhdu.model.HoaDon;

import java.util.List;

public class RV2Adapter extends RecyclerView.Adapter<RV2Adapter.ItemHolder> {

    private Context context;

    private List<HoaDon> hoaDonList;

    public RV2Adapter(Context context, List<HoaDon> hoaDonList) {
        this.context = context;
        this.hoaDonList = hoaDonList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_hoadon, viewGroup, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        HoaDon hoaDon = hoaDonList.get(i);
        itemHolder.tvIdHD.setText(hoaDon.id);
        itemHolder.tvNameHD.setText(hoaDon.name);
    }

    @Override
    public int getItemCount() {
        if (hoaDonList == null) return 0;
        return hoaDonList.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        public TextView tvIdHD, tvNameHD;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tvIdHD = itemView.findViewById(R.id.tvIdHD);
            tvNameHD = itemView.findViewById(R.id.tvNameHD);

        }
    }
}
