package com.jp.fristandroidapp.childfragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jp.fristandroidapp.R;
import com.jp.fristandroidapp.activity.BaiduBaseMapActivity;
import com.jp.fristandroidapp.adapter.RecycleviewGridBaseAdapter;
import com.jp.fristandroidapp.recycleviewItemdecoration.DividerGridItemDecoration;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PagerFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PagerFragment1 extends Fragment {

    @BindView(R.id.recycleview)
    public RecyclerView recycleview;
    private Context context;
    private GridLayoutManager mLayoutManager;

    public static PagerFragment1 newInstance() {
        PagerFragment1 fragment = new PagerFragment1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("jp","git");
        Log.e("jp","git");
        Log.e("jp","new===========git");
        Log.e("jp","new===========git====2017416测试");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_fragment1, container, false);
        context=getActivity();
        ButterKnife.bind(this,view);
        mLayoutManager=new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false);
        recycleview.setLayoutManager(mLayoutManager);
        recycleview.addItemDecoration(new DividerGridItemDecoration(context));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        upLoadData();

    }

    private void upLoadData() {
        ArrayList<String> urls=new ArrayList<>();
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-22-17332868_1929305090624552_8918542166154805248_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-09-17127109_1652837611687612_1425055271046086656_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-10-17127037_231706780569079_1119464847537340416_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-13-17265708_396005157434387_3099040288153272320_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-13-17267506_264626920661300_5781854075880472576_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-15-17126482_115753765623699_4225645012014071808_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-16-17333221_108837802984751_2789267558635667456_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-17-17332809_1277469728986540_3201752429582352384_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-20-17333300_1680707251945881_2009298023053524992_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-21-17268102_763630507137257_3620762734536163328_n%20-1-.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-08-17126216_1253875034703554_7520300169779216384_n.jpg");

        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-06-tumblr_ombicf0KXi1vpybydo6_540.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-02-16906481_1495916493759925_5770648570629718016_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-02-17077393_314135475655975_7855162741030387712_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-27-tumblr_om1aowIoKa1qbw5qso1_540.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-27-002809.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-23-16906361_1846962082218545_7116720067412230144_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-22-16789541_749566998525174_1194252851069583360_n.jpg");

        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-16-16790004_607292222809583_5160406710837313536_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-15-16464434_414363458902323_3665858302006263808_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-14-16123260_755771577930478_8918176595718438912_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-13-16464498_1247940031909047_2763412151866490880_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-10-16465759_171779496648995_128281069584646144_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-09-16583339_172818256542563_353855393375453184_n.jpg");
        urls.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-08-16230686_191036801373876_4789664128824246272_n.jpg");

        RecycleviewGridBaseAdapter adapter=new RecycleviewGridBaseAdapter(getContext(),urls);
        recycleview.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecycleviewGridBaseAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view) {

                Intent intent=new Intent(context, BaiduBaseMapActivity.class);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view) {
                Toast.makeText(context,"onItemLongClick",Toast.LENGTH_SHORT).show();
            }
        });
//        OkHttpUtils.get().url("http://gank.io/api/data/福利/10/1")
//                .build()
//                .execute(new StringCallback() {
//            @Override
//            public void onError(Call call, Exception e, int id) {
//
//            }
//
//            @Override
//            public void onResponse(String response, int id) {
//                String data=response;
//                Log.e("jp","====response:"+data);
////                new Gson().fromJson(data,)
//            }
//        });
    }
}
