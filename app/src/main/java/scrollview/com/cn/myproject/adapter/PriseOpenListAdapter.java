package scrollview.com.cn.myproject.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import scrollview.com.cn.myproject.R;
import scrollview.com.cn.myproject.entity.CodeBean;
import scrollview.com.cn.myproject.interfaces.IUpdataAdd;
import scrollview.com.cn.myproject.utils.CommentUtlis;

/**
 * @Author Li XS
 * @Data 2018/9/14
 * @Description:
 */
public class PriseOpenListAdapter extends BaseQuickAdapter<CodeBean, BaseViewHolder> {
    public PriseOpenListAdapter(List<CodeBean> data) {
        super(R.layout.add_list_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, CodeBean item) {
        helper.setText(R.id.stage, item.getStage());
        helper.setText(R.id.content, item.getContent());

        helper.getView(R.id.open_prise_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommentUtlis.updata(helper.getAdapterPosition(), mContext, new IUpdataAdd() {
                    @Override
                    public void setList(List<?> list) {
                        mData = (List<CodeBean>) list;
                        notifyDataSetChanged();
                    }
                });
            }
        });
    }

}
