package vp.com.eventbustest.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import vp.com.eventbustest.R;
import vp.com.eventbustest.adapter.MyAdapter;
import vp.com.eventbustest.bean.ItemList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {


    private List<ItemList> datas;
    private RecyclerView recyclerView;

    public LeftFragment() {
        // Required empty public constructor
    }

    /**
     * 加上@Subscribe注解。。。。否则会报错
     * @param savedInstanceState
     */
    @Override
    @Subscribe
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        recyclerView = ((RecyclerView) view.findViewById(R.id.recycler_view));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //填充数据
        loadData();
    }

    private void loadData() {
        //模拟数据
        datas = new ArrayList<>();
        for (int i=1;i<=50;i++){
            datas.add(new ItemList(i,"item"+i));
        }
        MyAdapter myAdapter = new MyAdapter(datas,getContext());
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void setOnItemClick(View view, int position) {
                //点击时进行post传值
                EventBus.getDefault().post(datas.get(position).getName());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
