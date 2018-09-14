package scrollview.com.cn.myproject;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import scrollview.com.cn.myproject.adapter.AddListAdapter;
import scrollview.com.cn.myproject.entity.CodeBean;
import scrollview.com.cn.myproject.gen.DaoSession;

/**
 * @Author Li XS
 * @Data 2018/9/11
 * @Description: 添加界面
 */
public class AddListActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView recyclerview;
    private AddListAdapter addListAdapter;
    private EditText input_et;
    private DaoSession daoSession;

    @Override
    public void initView() {
        setContentView(R.layout.activity_add_list);
        recyclerview = findViewById(R.id.recyclerview);
        input_et = findViewById(R.id.input_et);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        TextView title = findViewById(R.id.title_name);
        title.setText("添加");
        daoSession = MyApplication.getInstances().getDaoSession();
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void initData() {
        addListAdapter = new AddListAdapter(daoSession.loadAll(CodeBean.class));
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(addListAdapter);
        findViewById(R.id.add_bt).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_bt:
                try {
                    String ebt = input_et.getText().toString().trim();
                    int index = ebt.indexOf(",");
                    String stage = ebt.substring(0, index);
                    String content = ebt.substring(index + 1, ebt.length());
                    CodeBean codeBean = new CodeBean(null, content, stage);
                    daoSession.insert(codeBean);
                    addListAdapter.setNewData(daoSession.loadAll(CodeBean.class));
                } catch (Exception e) {
                    input_et.setText("");
                    showToast("输入错误");
                }

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
