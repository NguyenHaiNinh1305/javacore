package com.company.entity;

public class GpaManagement {

    private Student student;
    private Transcript[] transcripts;

    public GpaManagement(Student student, Transcript[] transcripts) {
        this.student = student;
        this.transcripts = transcripts;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Transcript[] getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(Transcript[] transcripts) {
        this.transcripts = transcripts;
    }

    public float getAveragemark() {
        float sum = 0;
        for (int i = 0; i < transcripts.length; i++) {
            sum += transcripts[i].getMark();
        }
        float avg = sum / transcripts.length;
        return avg;
    }

    @Override
    public String toString() {
        return  student.toString() + toStringTrans();
    }

    public String toStringTrans() {
        String str = null;
        for (int i = 0; i < transcripts.length; i++) {
            str += transcripts[i].toString();
        }
        return str;
    }
}
