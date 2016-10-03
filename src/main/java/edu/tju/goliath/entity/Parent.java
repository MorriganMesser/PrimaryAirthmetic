package edu.tju.goliath.entity;

public class Parent {
    private Integer parentid;

    private String parentname;

    private String parentnick;

    private String parentemail;

    private String parentpwd;

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname == null ? null : parentname.trim();
    }

    public String getParentnick() {
        return parentnick;
    }

    public void setParentnick(String parentnick) {
        this.parentnick = parentnick == null ? null : parentnick.trim();
    }

    public String getParentemail() {
        return parentemail;
    }

    public void setParentemail(String parentemail) {
        this.parentemail = parentemail == null ? null : parentemail.trim();
    }

    public String getParentpwd() {
        return parentpwd;
    }

    public void setParentpwd(String parentpwd) {
        this.parentpwd = parentpwd == null ? null : parentpwd.trim();
    }
}