package vp.com.eventbustest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity {

    private LinearLayout mFragmentLeft;
    private LinearLayout mFragmentRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
