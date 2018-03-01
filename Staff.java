package com.example.a2theot10.fileio;

/**
 * Created by 2theot10 on 01/03/2018.
 */

public class Staff {

    String firstname;
    String secondname;
    String room;
    String phone;

     public Staff( String firstnmae, String secondname, String room, String phone){
        this.firstname=firstname;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", room='" + room + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
