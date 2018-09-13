package scrollview.com.cn.myproject;

import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);

    }

    @Override
    public void initData() {
        findViewById(R.id.add_list).setOnClickListener(this);
        findViewById(R.id.open_prize).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_list:
                goIntent(AddListActivity.class);
                break;
            case R.id.open_prize:
                goIntent(PriseOpenActivity.class);
                break;
        }
    }
}
