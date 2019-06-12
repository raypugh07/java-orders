package com.lambdaschool.javaorders.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="agents")

public class Agents {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;


    @Column(unique = true,nullable = false)
    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    @OneToMany(mappedBy = "agent",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties({"agents"})
    private List<Customers> customers = new ArrayList<>();

    @OneToMany(mappedBy = "agent",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties({"agents"})
    private List<Orders> orders = new ArrayList<>();

    public Agents() {
    }

    public Agents(String agentname, String workingarea, double commission, String phone, String country) {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    public Agents(List<Customers> customers, List<Orders> orders) {
        this.customers = customers;
        this.orders = orders;
    }

    public long getAgentcode() {
        return agentcode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public List<Customers> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<Customers> customers)
    {
        this.customers = customers;
    }

    public List<Orders> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Orders> orders)
    {
        this.orders = orders;
    }

    /*@Override
    public String toString() {
        return "Agents{" +
                "agentcode=" + agentcode +
                ", agentname='" + agentname + '\'' +
                ", workingarea='" + workingarea + '\'' +
                ", commission=" + commission +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }*/
}
