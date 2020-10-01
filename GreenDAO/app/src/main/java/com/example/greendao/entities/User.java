package com.example.greendao.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "user")
public class User {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "dob")
    private String dob;

    @Property(nameInDb = "job")
    private String job;

    @Property(nameInDb = "employer")
    private String employer;

    @Generated(hash = 863415616)
    public User(Long id, String name, String dob, String job, String employer) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.job = job;
        this.employer = employer;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmployer() {
        return this.employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }
}