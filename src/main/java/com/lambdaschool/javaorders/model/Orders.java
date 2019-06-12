package com.lambdaschool.javaorders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double ordamount;
    private double advanceamount;
    private String ordersescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custcode",
            nullable = false)
    @JsonIgnore
    private Customers customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentcode",
            nullable = false)
    @JsonIgnore
    private Agents agent;

    public Orders()
    {
    }

    public Orders(double ordamount, double advanceamount, Customers customer, Agents agents, String ordersescription)
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.ordersescription = ordersescription;
        this.customer = customer;
        this.agent = agents;
    }

    public long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount()
    {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    public String getOrdersescription()
    {
        return ordersescription;
    }

    public void setOrdersescription(String ordersescription)
    {
        this.ordersescription = ordersescription;
    }

    public Customers getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customers customer)
    {
        this.customer = customer;
    }

    public Agents getAgent()
    {
        return agent;
    }

    public void setAgent(Agents agent)
    {
        this.agent = agent;
    }
}

/*import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    private long ordnum;

    private double ordamount;
    private double advanceamount;

    private long agentcode;
    private String ordescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custcode",
            nullable = false)
    @JsonIgnore
    private Customers customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentcode",
            nullable = false)
    @JsonIgnore
    private Agents agent;

    public Orders() {
    }

    public Orders(double ordamount, double advanceamount, long custcode, long agentcode, String ordescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
       // this.custcode = custcode;
        this.agentcode = agentcode;
        this.ordescription = ordescription;
    }

    public Orders(Customers customer, Agents agent, long agentcode, String ordescription) {
        this.customer = customer;
        this.agent = agent;
        this.agentcode = agentcode;
        this.ordescription = ordescription;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Agents getAgent() {
        return agent;
    }

    public void setAgent(Agents agent) {
        this.agent = agent;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    /*public long getCustcode() {
        return custcode;
    }

    public void setCustcode(long custcode) {
        this.custcode = custcode;
    }

    public long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }

    public String getOrdescription() {
        return ordescription;
    }

    public void setOrdescription(String ordescription) {
        this.ordescription = ordescription;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ordnum=" + ordnum +
                ", ordamount=" + ordamount +
                ", advanceamount=" + advanceamount +
                //", custcode=" + custcode +
                ", agentcode=" + agentcode +
                ", ordescription='" + ordescription + '\'' +
                '}';
    }
}*/
