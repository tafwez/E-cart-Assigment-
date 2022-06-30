package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.Products.Doc;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.R;

import java.util.ArrayList;

public class ProductAdapters extends RecyclerView.Adapter<ProductAdapters.ViewHolder> {

    private final ArrayList<Doc> courseModalArrayList;
    private final Context context;

    public ProductAdapters(ArrayList<Doc> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapters.ViewHolder holder, int position) {
        Doc modal = courseModalArrayList.get(position);
        holder.productname.setText(modal.getProductTitle());
        holder.shopname.setText(modal.getShopId().getShopTitle());
    }

    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private final TextView productname;
        private final TextView shopname;
        private final ImageView productimage;
        private final TextView addButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productname = itemView.findViewById(R.id.productname);
            shopname = itemView.findViewById(R.id.shopname);
            productimage = itemView.findViewById(R.id.productimage);
            addButton = itemView.findViewById(R.id.add);
        }
    }
}