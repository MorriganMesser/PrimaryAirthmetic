package edu.tju.goliath.entity;

import java.util.Date;

public class Test {
    private Integer testid;

    private String testname;

    private String testrank;

    private String testgrade;

    private Date testdate;

    private Integer teststuid;

    private String testexps;

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname == null ? null : testname.trim();
    }

    public String getTestrank() {
        return testrank;
    }

    public void setTestrank(String testrank) {
        this.testrank = testrank == null ? null : testrank.trim();
    }

    public String getTestgrade() {
        return testgrade;
    }

    public void setTestgrade(String testgrade) {
        this.testgrade = testgrade == null ? null : testgrade.trim();
    }

    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
    }

    public Integer getTeststuid() {
        return teststuid;
    }

    public void setTeststuid(Integer teststuid) {
        this.teststuid = teststuid;
    }

    public String getTestexps() {
        return testexps;
    }

    public void setTestexps(String testexps) {
        this.testexps = testexps == null ? null : testexps.trim();
    }
}