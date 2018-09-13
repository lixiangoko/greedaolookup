package scrollview.com.cn.myproject.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

@Entity
public class CodeBean implements Serializable {
    @Id
    private Long id;
    private String content; //码数
    private String stage;//期数
    private static final long serialVersionUID = 1L;

    @Generated(hash = 1587485775)
    public CodeBean(Long id, String content, String stage) {
        this.id = id;
        this.content = content;
        this.stage = stage;
    }

    @Generated(hash = 544591002)
    public CodeBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}
