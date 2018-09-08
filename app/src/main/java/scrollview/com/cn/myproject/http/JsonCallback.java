package scrollview.com.cn.myproject.http;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;

import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class JsonCallback<T> extends AbsCallback<T> {
    private Type type;
    private Class<T> tClass;

    public JsonCallback(Type type) {
        this.type = type;
    }

    public JsonCallback(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T convertResponse(Response response) {
        ResponseBody responseBody = response.body();
        if (responseBody == null) return null;

        T date = null;
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(responseBody.charStream());
        if (type != null) date = gson.fromJson(jsonReader, type);
        if (tClass != null) date = gson.fromJson(jsonReader, tClass);
        return date;
    }
}
