package com.jdsfoods.Adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jdsfoods.R;
import com.jdsfoods.Response.ShopResponse;

import java.util.List;

/**
 * Created by dikhong on 01-08-2018.
 */

public class SubCateAdapter  extends RecyclerView.Adapter<SubCateAdapter.ViewHolder> {
    private List<ShopResponse.ShopData> shopData;
    private Context context;
    int row_index=-1;
    private OnItemClick mCallback;

    public SubCateAdapter(Context context, List<ShopResponse.ShopData> shopData,OnItemClick listener) {
        this.shopData = shopData;
        this.context = context;
        this.mCallback = listener;
    }

    @Override
    public SubCateAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_cate_list, viewGroup, false);
        return new SubCateAdapter.ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(final SubCateAdapter.ViewHolder viewHolder, final int i) {
        final ShopResponse.ShopData shopData1 =shopData.get(i);
        viewHolder.tvSub.setText(shopData1.getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=i;
                notifyDataSetChanged();
                mCallback.onClick(shopData1.getId());
            }
        });
        if(row_index==i){
            viewHolder.tvSub.setBackgroundResource(R.drawable.under_big);
        }
        else
        {
            viewHolder.tvSub.setBackgroundResource(R.drawable.under_white);
        }
    }

    @Override
    public int getItemCount() {
        return shopData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvSub;
        public ViewHolder(View view) {
            super(view);
            tvSub= (TextView)view.findViewById(R.id.tv_sub);
        }
    }

    public interface OnItemClick {
        void onClick (String value);
    }

}
