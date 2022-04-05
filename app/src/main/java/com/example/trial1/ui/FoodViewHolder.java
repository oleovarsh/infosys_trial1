package com.example.trial1.ui;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trial1.R;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView reqid;
    public TextView requser;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }

    public FoodViewHolder(View itemView){
        super(itemView);
        reqid=(TextView)itemView.findViewById(R.id.text_requestid);
        requser=(TextView) itemView.findViewById(R.id.text_requser);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        itemClickListener.onClick(view, getAdapterPosition(),false);
    }
}
