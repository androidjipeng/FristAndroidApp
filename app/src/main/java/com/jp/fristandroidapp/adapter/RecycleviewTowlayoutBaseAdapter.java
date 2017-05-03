package com.jp.fristandroidapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jp.fristandroidapp.R;

import java.util.ArrayList;

/**
 * Created by jipeng on 2017/5/3.
 */

public class RecycleviewTowlayoutBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    private LayoutInflater mLayoutInflater;
    private Context context;
    private ArrayList<String> list = null;

    /**
     * 测试888 555
     */

    public RecycleviewTowlayoutBaseAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public enum ITEM_TYPE {
        ITEM1,
        ITEM2
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM1.ordinal()) {
            return new ViewHodler1(mLayoutInflater.inflate(R.layout.recycleview_one_item_layout, parent, false));
        } else {
            return new ViewHodler2(mLayoutInflater.inflate(R.layout.recycleview_tow_item_layout, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHodler1)
        {    Glide.with(context)
                    .load(list.get(position))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .centerCrop()
                    .into(((ViewHodler1) holder).image1);//加载网络图片
        }else if (holder instanceof ViewHodler2)
        {

              Glide.with(context)
                      .load(list.get(position))
                      .diskCacheStrategy(DiskCacheStrategy.ALL)
                      .fitCenter()
                      .centerCrop()
                      .into(((ViewHodler2) holder).imageView);

        }
    }

    @Override
    public int getItemViewType(int position) {
        //Enum类提供了一个ordinal()方法，返回枚举类型的序数，这里ITEM_TYPE.ITEM1.ordinal()代表0， ITEM_TYPE.ITEM2.ordinal()代表1
        return position % 2 == 0 ? ITEM_TYPE.ITEM1.ordinal() : ITEM_TYPE.ITEM2.ordinal();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    class ViewHodler1 extends RecyclerView.ViewHolder {

        private ImageView image1;

        public ViewHodler1(View itemView) {
            super(itemView);
            image1 = (ImageView) itemView.findViewById(R.id.img_one);
        }
    }

    class ViewHodler2 extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHodler2(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_tow);

        }
    }


}
