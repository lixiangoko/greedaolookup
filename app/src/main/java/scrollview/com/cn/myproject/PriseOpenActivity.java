package scrollview.com.cn.myproject;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import scrollview.com.cn.myproject.adapter.PriseOpenListAdapter;
import scrollview.com.cn.myproject.entity.CodeBean;
import scrollview.com.cn.myproject.gen.DaoSession;

public class PriseOpenActivity extends BaseActivity {

    private RecyclerView prise_rv;
    private PriseOpenListAdapter priseOpenListAdapter;
    private DaoSession daoSession;

    @Override
    public void initView() {
        setContentView(R.layout.activity_prise_open);
        prise_rv = findViewById(R.id.prise_rv);
        prise_rv.setLayoutManager(new LinearLayoutManager(this));
        priseOpenListAdapter = new PriseOpenListAdapter(null);
        prise_rv.setHasFixedSize(true);
        prise_rv.setAdapter(priseOpenListAdapter);
        daoSession = MyApplication.getInstances().getDaoSession();
    }

    @Override
    public void initData() {
        List<CodeBean> codeBeanList = daoSession.loadAll(CodeBean.class);
        priseOpenListAdapter.setNewData(codeBeanList);

    }

}
