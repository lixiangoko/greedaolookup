package scrollview.com.cn.myproject.interfaces;


import java.util.List;

/**
 * 更新修改数据回调
 * 需要时候合入 EventBus 3.0 回调更方便
 */
public interface IUpdataAdd {
    void setList(List<?> list);
}
