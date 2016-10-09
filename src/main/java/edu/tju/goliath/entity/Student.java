package edu.tju.goliath.entity;

public class Student {
    private Integer stuid;

    private String stuname;

    private String stunick;

    private String stuemail;

    private String stupwd;

    private Integer stuparentid;

    private Integer stuteacherid;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStunick() {
        return stunick;
    }

    public void setStunick(String stunick) {
        this.stunick = stunick == null ? null : stunick.trim();
    }

    public String getStuemail() {
        return stuemail;
    }

    public void setStuemail(String stuemail) {
        this.stuemail = stuemail == null ? null : stuemail.trim();
    }

    public String getStupwd() {
        return stupwd;
    }

    public void setStupwd(String stupwd) {
        this.stupwd = stupwd == null ? null : stupwd.trim();
    }

    public Integer getStuparentid() {
        return stuparentid;
    }

    public void setStuparentid(Integer stuparentid) {
        this.stuparentid = stuparentid;
    }

    public Integer getStuteacherid() {
        return stuteacherid;
    }

    public void setStuteacherid(Integer stuteacherid) {
        this.stuteacherid = stuteacherid;
    }
}