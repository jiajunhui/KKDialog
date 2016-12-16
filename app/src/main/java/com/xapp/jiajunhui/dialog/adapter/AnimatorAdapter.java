package com.xapp.jiajunhui.dialog.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xapp.jiajunhui.dialog.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taurus on 2016/12/13.
 */

public class AnimatorAdapter extends RecyclerView.Adapter<AnimatorAdapter.ItemHolder>{

    private Context mContext;
    private List<Class> mList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AnimatorAdapter(Context context, List<Class> list){
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemHolder(View.inflate(mContext,R.layout.item_animator,null));
    }

    @Override
    public void onBindViewHolder(final ItemHolder itemHolder, final int i) {
        itemHolder.mTvAnimator.setText(mList.get(i).getSimpleName());
        itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick(itemHolder, i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(ItemHolder holder,int position);
    }

    public static class ItemHolder extends RecyclerView.ViewHolder{

        TextView mTvAnimator;

        public ItemHolder(View itemView) {
            super(itemView);
            mTvAnimator = (TextView) itemView.findViewById(R.id.tv_animator);
        }
    }

}
