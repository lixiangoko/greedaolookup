package scrollview.com.cn.myproject;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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

    @Override
    public void initView() {
        setContentView(R.layout.activity_add_list);
        recyclerview = findViewById(R.id.recyclerview);
        input_et = findViewById(R.id.input_et);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initData() {
        addListAdapter = new AddListAdapter(null);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(addListAdapter);
        findViewById(R.id.add_bt).setOnClickListener(this);

        daoSession = MyApplication.getInstances().getDaoSession();
//        CodeBean codeBean = new CodeBean(null, "张三", "123");
//        daoSession.getCodeBeanDao().insert(codeBean);
//        CodeBean codeBean2 = new CodeBean(null, "张三2", "123");
//        daoSession.getCodeBeanDao().insert(codeBean2);
//        List<CodeBean> codeBean1 = daoSession.loadAll(CodeBean.class);
//
//        codeBean.setContent("李四");
//        daoSession.update(codeBean);

    }

    private DaoSession daoSession;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_bt:
                try {
                    String ebt = input_et.getText().toString().trim();
                    int index = ebt.indexOf(",");
                    String stage = ebt.substring(0, index);
                    String content = ebt.substring(index, ebt.length());
                    Log.d("----", "----------AddListActivity--方法--onClick:  " + stage);
                    Log.d("----", "----------AddListActivity--方法--onClick:  " + content);
                    CodeBean codeBean = new CodeBean(null, content, stage);
                    daoSession.insert(codeBean);
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
