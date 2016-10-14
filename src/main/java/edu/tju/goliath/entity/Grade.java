package edu.tju.goliath.entity;

import java.util.Date;

public class Grade {
    private Integer gradeid;

    private String gradename;

    private String graderank;

    private String grade;

    private Integer gradestuid;

    private String grademodel;

    private Date gradedate;

    private String gradetime;

    private String gradeexps;

    private Integer graderightnum;

    private Integer gradeerrornum;

    private String graderate;

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename == null ? null : gradename.trim();
    }

    public String getGraderank() {
        return graderank;
    }

    public void setGraderank(String graderank) {
        this.graderank = graderank == null ? null : graderank.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Integer getGradestuid() {
        return gradestuid;
    }

    public void setGradestuid(Integer gradestuid) {
        this.gradestuid = gradestuid;
    }

    public String getGrademodel() {
        return grademodel;
    }

    public void setGrademodel(String grademodel) {
        this.grademodel = grademodel == null ? null : grademodel.trim();
    }

    public Date getGradedate() {
        return gradedate;
    }

    public void setGradedate(Date gradedate) {
        this.gradedate = gradedate;
    }

    public String getGradetime() {
        return gradetime;
    }

    public void setGradetime(String gradetime) {
        this.gradetime = gradetime == null ? null : gradetime.trim();
    }

    public String getGradeexps() {
        return gradeexps;
    }

    public void setGradeexps(String gradeexps) {
        this.gradeexps = gradeexps == null ? null : gradeexps.trim();
    }

    public Integer getGraderightnum() {
        return graderightnum;
    }

    public void setGraderightnum(Integer graderightnum) {
        this.graderightnum = graderightnum;
    }

    public Integer getGradeerrornum() {
        return gradeerrornum;
    }

    public void setGradeerrornum(Integer gradeerrornum) {
        this.gradeerrornum = gradeerrornum;
    }

    public String getGraderate() {
        return graderate;
    }

    public void setGraderate(String graderate) {
        this.graderate = graderate == null ? null : graderate.trim();
    }
}