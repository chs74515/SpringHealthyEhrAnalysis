package com.calebogb.ehr.data;

public class PercentageEHRNotes {

    public static final String LABEL_REGION = "region";

    public static final String LABEL_NATIONAL = "National";

    public static final String LABEL_REGION_CODE = "region_code";

    public static final String LABEL_PCT_EHR_NOTES = "pct_hospitals_basic_ehr_notes";

    private String state;

    private String stateAbbr;

    private double percentage;

    public PercentageEHRNotes(String state, String stateAbbr, double percentage) {
        this.state = state;
        this.stateAbbr = stateAbbr;
        this.percentage = percentage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
