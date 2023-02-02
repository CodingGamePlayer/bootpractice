package kr.co.ahaproject.dto;

import lombok.Data;

@Data
public class YuriBoardDTO {

    private int bno;
    private String title;
    private String content;
    private String userid;

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    @Override
    public String toString() {
        return "YuriBoardDTO{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}
