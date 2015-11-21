package project;

import java.lang.*;
import java.util.*;


public class Membership {

    private Society society;
    private Student student;
    private boolean payFee;
    private String joiningDate;
    private Student membersCount;
    

   
    public Membership(Society society, Student student, Student membersCount){
        payFee = false;
        this.joiningDate = joiningDate;
        this.society = society;
        this.student = student;
        this.membersCOunt=membersCount;
    }

    public boolean isFeesPaid() {
        return payFee;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public Society getSociety() {
        return society;
    }

    public Student getName() {
        return student;
    }

    public void setFeesPaid(boolean payFee)
    {
        this.payFee = payFee;
    }

    public void setDateJoined(String joiningDate ){
        this.joiningDate = joiningDate;
    }

    public void setSociety(Society society) {
        this.society = society;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    // this will return the count of members in the society
    public Student getCount(){
        return membersCount;
    }

}
