package scrollview.com.cn.myproject.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import scrollview.com.cn.myproject.R;
import scrollview.com.cn.myproject.entity.CodeBean;

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
    protected void convert(BaseViewHolder helper, CodeBean item) {
        helper.setText(R.id.stage, item.getStage());
        helper.setText(R.id.content, item.getContent());
    }
}
