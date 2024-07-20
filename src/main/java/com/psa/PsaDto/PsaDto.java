package com.psa.PsaDto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

public class PsaDto {
    private Long id;
    @NotNull
    @Size(min=2,message="atleast two characters")
    private String name;
    @Size(min=4,max=11,message="no such course")
    private String course;
    @Email
    private String email;
    @Size(min=10,max=10,message="invalid mobile number")
    private String mobile;
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
