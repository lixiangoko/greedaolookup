package scrollview.com.cn.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @Author Li XS
 * @Data 2018/9/11
 * @Description:
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    public abstract void initView();

    public abstract void initData();

    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * 没带参数的跳转
     *
     * @param tClass
     */
    public void goIntent(Class tClass) {
        Intent intent = new Intent(this, tClass);
        startActivity(intent);
    }

    /**
     * 没带参数的跳转
     *
     * @param tClass
     */
    public void goIntentBundle(Bundle bundle, Class tClass) {
        Intent intent = new Intent(this, tClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
