package com.company.entity;

public class Transcript {
    private float mark;
    private Subject subject;

    public Transcript() {
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return
                ", mark=" + mark +
                ", "+ subject;
    }
}
