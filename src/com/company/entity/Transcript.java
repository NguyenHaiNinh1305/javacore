package com.company.entity;

import java.io.Serializable;

public class Transcript implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
