package com.ytl.recyclerviewonclicklistener;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Richard Yi-Te Lu on 10,December,2018
 */
public class greenAdapter extends RecyclerView.Adapter<greenAdapter.NumberItemViewHolder>{

    private int mNumberItems;
    itemClickListener mItemClickListener;

    public greenAdapter(int numberItems, itemClickListener listener){
        mNumberItems = numberItems;
        mItemClickListener = listener;
    }

    @NonNull
    @Override
    public NumberItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, viewGroup, false);
        NumberItemViewHolder viewHolder = new NumberItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberItemViewHolder numberItemViewHolder, int i) {
        numberItemViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class NumberItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemList;

        public NumberItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemList = itemView.findViewById(R.id.tv_item);

            itemList.setOnClickListener(this);
        }

        public void bind (int position){
            itemList.setText(Integer.toString(position));
        }

        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    interface itemClickListener{
        void onItemClick(int itemIndex);
    }
}
