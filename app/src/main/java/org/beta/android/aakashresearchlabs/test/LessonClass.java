package org.beta.android.aakashresearchlabs.test;

/**
 * Created by Kevin on 6/14/2017.
 */

public class LessonClass {
    private String LHeading;
    private int totalChapters;
    private Class lClass;

    LessonClass(String a,int b,Class c)
    {
        LHeading=a;
        totalChapters=b;
        lClass=c;
    }

    public String getLHeading() {
        return LHeading;
    }

    public void setLHeading(String LHeading) {
        this.LHeading = LHeading;
    }

    public int getTotalChapters() {
        return totalChapters;
    }

    public void setTotalChapters(int totalChapters) {
        this.totalChapters = totalChapters;
    }

    public Class getlClass() {
        return lClass;
    }

    public void setlClass(Class lClass) {
        this.lClass = lClass;
    }
}
