package org.academy.api.pojo.karyna.chelpan;

import java.util.List;

public class Seller {
    private long id;
    private String name;
    private String email;
    private List<String> department;

    public Seller(long id, String name, String email, List<String> department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }
}
