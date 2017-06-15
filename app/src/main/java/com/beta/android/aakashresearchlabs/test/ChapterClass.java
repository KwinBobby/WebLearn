package com.beta.android.aakashresearchlabs.test;

/**
 * Created by Kevin on 6/9/2017.
 */

public class ChapterClass {
    String Ctitle;
    String Ccontent;
    Class Cclass;
    boolean isCompleted;

    public Class getCclass() {
        return Cclass;
    }

    public void setCclass(Class cclass) {
        Cclass = cclass;
    }

    public ChapterClass(String a, String b, Class c)
    {
        Ctitle=a;
        Ccontent=b;
        Cclass=c;

    }

    public String getCtitle() {
        return Ctitle;
    }

    public void setCtitle(String ctitle) {
        Ctitle = ctitle;
    }

    public String getCcontent() {
        return Ccontent;
    }

    public void setCcontent(String ccontent) {
        Ccontent = ccontent;
    }

    public boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


}
