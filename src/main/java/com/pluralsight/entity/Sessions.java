package com.pluralsight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sessions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;
    private String session_name;
    private String session_description;
    private Integer session_length;

    public Sessions(){

    }

    public Sessions(String session_name, String session_description, Integer session_length) {
        this.session_name = session_name;
        this.session_description = session_description;
        this.session_length = session_length;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }

    @Override
    public String toString(){
        return "Session{" +
                "session_id=" + session_id +
                ", session_name='" + session_name + '\'' +
                ", session_description=" + session_description +
                ", session_length='" + session_length + '\'' +
                '}';
    }
}
