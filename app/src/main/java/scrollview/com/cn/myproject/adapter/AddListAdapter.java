package scrollview.com.cn.myproject.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import scrollview.com.cn.myproject.R;
import scrollview.com.cn.myproject.entity.CodeBean;

public class AddListAdapter extends BaseQuickAdapter<CodeBean, BaseViewHolder> {
    public AddListAdapter(List<CodeBean> data) {
        super(R.layout.add_list_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CodeBean item) {

    }
}
