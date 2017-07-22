package org.beta.android.aakashresearchlabs.test;

/**
 * Created by Kevin on 6/9/2017.
 */

public class ChapterClass {
    String Ctitle;
    String Ccontent;
    Class Cclass;
    String parentLesson;

    public String getParentLesson() {
        return parentLesson;
    }

    public void setParentLesson(String parentLesson) {
        this.parentLesson = parentLesson;
    }

    boolean isCompleted;

    public Class getCclass() {
        return Cclass;
    }

    public void setCclass(Class cclass) {
        Cclass = cclass;
    }

    public ChapterClass(String a, String b, Class c,String d)
    {
        Ctitle=a;
        Ccontent=b;
        Cclass=c;
        parentLesson=d;

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
