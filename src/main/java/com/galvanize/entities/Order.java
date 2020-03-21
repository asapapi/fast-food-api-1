package com.galvanize.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="customerName")
    private String customerName;
    @Column(name="createAt")
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private LocalDate createdAt;
    @Column(name="status")
    private Status status;
    @Column(name="description")
    private String description;
    @Column(name="note")
    private String note;
    @Column(name="lastUpdated")
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private LocalDate lastUpdated;

    public Order(String customerName, String description) {
        this.customerName = customerName;
        this.description = description;
    }

    public Order() {
    }

    public Order(LocalDate createdAt, Status status, String note, LocalDate lastUpdated) {
        this.createdAt = createdAt;
        this.status = status;
        this.note = note;
        this.lastUpdated = lastUpdated;
    }

    public Order(Long id, String customerName, LocalDate createdAt, Status status, String description, String note, LocalDate lastUpdated) {
        this.id = id;
        this.customerName = customerName;
        this.createdAt = createdAt;
        this.status = status;
        this.description = description;
        this.note = note;
        this.lastUpdated = lastUpdated;
    }

    public Order(String customerName, LocalDate createdAt, Status status, String description, String note, LocalDate lastUpdated) {
        this.customerName = customerName;
        this.createdAt = createdAt;
        this.status = status;
        this.description = description;
        this.note = note;
        this.lastUpdated = lastUpdated;
    }

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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(customerName, order.customerName) &&
                Objects.equals(createdAt, order.createdAt) &&
                status == order.status &&
                Objects.equals(description, order.description) &&
                Objects.equals(note, order.note) &&
                Objects.equals(lastUpdated, order.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, createdAt, status, description, note, lastUpdated);
    }
}
