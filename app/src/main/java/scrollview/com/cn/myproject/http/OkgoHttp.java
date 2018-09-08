package scrollview.com.cn.myproject.http;

import android.content.Context;

import com.lzy.okgo.OkGo;

import scrollview.com.cn.myproject.ResultBean;

public class OkgoHttp {

    public static void postData(Context context, IStringData iStringData) {
        OkGo.<ResultBean>get("").tag(context);


    }
}
