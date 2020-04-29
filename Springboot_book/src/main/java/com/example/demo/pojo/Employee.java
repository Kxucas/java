package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    public Integer id;
    public String lastName;
    public String email;
    public Integer gender;
    public Department department;
    public Data birth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Data getBirth() {
        return birth;
    }

    public void setBirth(Data birth) {
        this.birth = birth;
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }
}
