package com.jp.fristandroidapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jp.fristandroidapp.R;
import com.jp.fristandroidapp.adapter.AdImagePagerAdapter;
import com.jp.fristandroidapp.bean.AdvertisementModel;
import com.jp.fristandroidapp.widget.adview.AdViewFlow;
import com.jp.fristandroidapp.widget.adview.CircleFlowIndicator;

import java.util.ArrayList;
import java.util.List;

public class StationFragment extends Fragment {

    private AdViewFlow ad_shop_flow;
    private CircleFlowIndicator circle_flow_indicator;
    private AdImagePagerAdapter mAdPagerAdapter;

    private Context context;

    public static StationFragment newInstance() {
        StationFragment fragment = new StationFragment();
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            context=getActivity();
            View view=inflater.inflate(R.layout.fragment_station, container, false);
            ad_shop_flow= (AdViewFlow) view.findViewById(R.id.ad_shop_flow);
            circle_flow_indicator= (CircleFlowIndicator) view.findViewById(R.id.circle_flow_indicator);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        advistment();

    }

    private void advistment() {
        List<AdvertisementModel> mListAd=new ArrayList<>();
        AdvertisementModel model1=new AdvertisementModel();
        model1.setImgurl("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-22-17332868_1929305090624552_8918542166154805248_n.jpg");
        AdvertisementModel model2=new AdvertisementModel();
        model2.setImgurl("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-09-17127109_1652837611687612_1425055271046086656_n.jpg");
        AdvertisementModel model3=new AdvertisementModel();
        model3.setImgurl("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-10-17127037_231706780569079_1119464847537340416_n.jpg");
        AdvertisementModel model4=new AdvertisementModel();
        model4.setImgurl("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-13-17265708_396005157434387_3099040288153272320_n.jpg");
        mListAd.add(model1);
        mListAd.add(model2);
        mListAd.add(model3);
        mListAd.add(model4);
        showAdDataAdapter(mListAd);
    }


    /**
     * 广告 轮播图
     */
    private void showAdDataAdapter(List<AdvertisementModel> mListAd) {
        int number = mListAd != null ? mListAd.size() : 0;
        if (number > 0) {
            mAdPagerAdapter = new AdImagePagerAdapter(context, mListAd)
                    .setInfiniteLoop(true);
            ad_shop_flow.setAdapter(mAdPagerAdapter);
            ad_shop_flow.setmSideBuffer(number);
            if (number > 1) {
                circle_flow_indicator.setVisibility(View.VISIBLE);
                ad_shop_flow.setFlowIndicator(circle_flow_indicator);
            }
            ad_shop_flow.setTimeSpan(4500);
            ad_shop_flow.setSelection(number * 1000); // 设置初始位置
            ad_shop_flow.startAutoFlowTimer(); // 启动自动播放
            circle_flow_indicator.postInvalidate();
        }
    }

}
