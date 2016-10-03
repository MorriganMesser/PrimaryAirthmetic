package edu.tju.goliath.entity;

public class Teacher {
    private Integer teacherid;

    private String teachername;

    private String teachernick;

    private String teacheremail;

    private String teacherpwd;

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public String getTeachernick() {
        return teachernick;
    }

    public void setTeachernick(String teachernick) {
        this.teachernick = teachernick == null ? null : teachernick.trim();
    }

    public String getTeacheremail() {
        return teacheremail;
    }

    public void setTeacheremail(String teacheremail) {
        this.teacheremail = teacheremail == null ? null : teacheremail.trim();
    }

    public String getTeacherpwd() {
        return teacherpwd;
    }

    public void setTeacherpwd(String teacherpwd) {
        this.teacherpwd = teacherpwd == null ? null : teacherpwd.trim();
    }
}