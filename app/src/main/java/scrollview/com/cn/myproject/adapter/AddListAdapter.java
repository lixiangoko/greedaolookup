package scrollview.com.cn.myproject.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import scrollview.com.cn.myproject.MyApplication;
import scrollview.com.cn.myproject.R;
import scrollview.com.cn.myproject.entity.CodeBean;
import scrollview.com.cn.myproject.gen.CodeBeanDao;

public class AddListAdapter extends BaseQuickAdapter<CodeBean, BaseViewHolder> {
    public AddListAdapter(List<CodeBean> data) {
        super(R.layout.add_list_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, CodeBean item) {
        helper.setText(R.id.stage, item.getStage());
        helper.setText(R.id.content, item.getContent());
        helper.getView(R.id.add_ll).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                updata(helper.getAdapterPosition());
                return false;
            }
        });
    }

    private void updata(final int possion) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("请输入修改内容");
        //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_add_up, null);
        //    设置我们自己定义的布局文件作为弹出框的Content
        builder.setView(view);

        final EditText username = view.findViewById(R.id.username);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    //先查全部数据出来
                    List<CodeBean> codeBeanList = MyApplication.getInstances().getDaoSession().loadAll(CodeBean.class);
                    String ebt = username.getText().toString().trim();
                    //以道号分割两部分
                    int index = ebt.indexOf(",");
                    String stage = ebt.substring(0, index);
                    String content = ebt.substring(index + 1, ebt.length());
                    //替换更改的数据
                    codeBeanList.get(possion).setContent(content);
                    codeBeanList.get(possion).setStage(stage);
                    //删除表
                    MyApplication.getInstances().getDaoSession().getCodeBeanDao().deleteAll();

                    //------------------------真正的开发是不需要这样遍历数据的-------------------------------------------------
                    for (CodeBean a : codeBeanList) {
                        //再循环添加数据，，，，变态操作
                        MyApplication.getInstances().getDaoSession().insert(a);
                    }
                    Toast.makeText(mContext, "修改成功", Toast.LENGTH_SHORT).show();

                    mData = (List<CodeBean>) MyApplication.getInstances().getDaoSession();
                    notifyDataSetChanged();
                } catch (Exception e) {
                    Toast.makeText(mContext, "输入的格式不正确", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
