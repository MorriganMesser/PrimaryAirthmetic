package edu.tju.goliath.entity;

public class Grade {
    private Integer gradeid;

    private String gradename;

    private String graderank;

    private String grade;

    private Integer gradestuid;

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
}