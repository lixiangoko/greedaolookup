package scrollview.com.cn.myproject;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import scrollview.com.cn.myproject.adapter.AddListAdapter;

/**
 * @Author Li XS
 * @Data 2018/9/11
 * @Description: 添加界面
 */
public class AddListActivity extends BaseActivity {
    private RecyclerView recyclerview;
    private AddListAdapter addListAdapter;

    @Override
    public void initView() {
        setContentView(R.layout.activity_add_list);
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initData() {
        addListAdapter = new AddListAdapter(null);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(addListAdapter);
    }
}
