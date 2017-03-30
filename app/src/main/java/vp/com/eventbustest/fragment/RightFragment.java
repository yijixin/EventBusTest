package vp.com.eventbustest.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import vp.com.eventbustest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RightFragment extends Fragment {


    private TextView tvName;

    public RightFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        tvName = ((TextView) view.findViewById(R.id.tv_name));
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //接收post传的值，注意参数类型要一致。。其中注解为在主线程中进行
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(String name) {
        if (name!=null){
            tvName.setText(name);
        }
    }

}
