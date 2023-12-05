package com.example.demoshoppingcart.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "order1")
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String customerName;
    private String customerAddress;

    @OneToMany
    private List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<OrderDetailEntity> getOrderDetailEntities() {
        return orderDetailEntities;
    }

    public void setOrderDetailEntities(List<OrderDetailEntity> orderDetailEntities) {
        this.orderDetailEntities = orderDetailEntities;
    }
}
// câu hỏi phỏng vâns
// vòng lặp for chi tiết
//Ioc là gì?
//sql injection
// hashmap có trùng key được không?
//hashset vì sao chỉ chứa phần tử unique
// so sánh array với list
// authentication va authorization
//@Controller, service, responsitory, component.
//bean scope
// Pathvariable vs request parram.
// spring security và spring boot là framework
// phân biệt cookie session