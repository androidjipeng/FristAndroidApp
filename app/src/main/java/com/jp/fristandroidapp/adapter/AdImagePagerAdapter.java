package com.jp.fristandroidapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jp.fristandroidapp.R;
import com.jp.fristandroidapp.bean.AdvertisementModel;

import java.util.List;

/**
 * **********************************************************
 * <p/>
 * 说明：
 * <p/>
 * 作者：cailin
 * <p/>
 * 创建日期：2016/1/29
 * <p/>
 * 描述：
 * **********************************************************
 */
public class AdImagePagerAdapter extends BaseAdapter{

    private Context context;
    private List<AdvertisementModel> mAdData;
    private boolean isInfiniteLoop=true;

    public AdImagePagerAdapter(Context context, List<AdvertisementModel> mAdData) {
        this.mAdData = mAdData;
        this.context=context;
        isInfiniteLoop = true;

    }

    @Override
    public int getCount() {
        return isInfiniteLoop ? Integer.MAX_VALUE : (mAdData!=null? mAdData.size(): 0);
    }

    private int getPosition(int position) {
        int number=mAdData!=null? mAdData.size(): 0;
        if (number>0){
            return isInfiniteLoop ? position % number : position;
        }else{
            return 0;
        }

    }

    @Override
    public View getView(final int position, View view, ViewGroup container) {
        final ViewHolderAd holder;
        if (view == null) {
            holder = new ViewHolderAd();
            view = LayoutInflater.from(context).inflate(R.layout.advistment_layout, container,false);
            holder.imageView = (ImageView) view.findViewById(R.id.iv_ad_pic);

            view.setTag(holder);
        } else {
            holder = (ViewHolderAd) view.getTag();
        }
        try {
            AdvertisementModel item=mAdData.get(getPosition(position));
            if (item!=null){
                Glide.with(context)
                        .load(item.getImgurl())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .fitCenter()
                        .centerCrop()
                        .into(holder.imageView);//加载网络图片
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    private class ViewHolderAd {
        private ImageView imageView;
    }

    public AdImagePagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        return this;
    }

    @Override
    public Object getItem(int arg0) {
        return arg0;
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

}
