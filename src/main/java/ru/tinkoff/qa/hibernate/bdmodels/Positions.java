package ru.tinkoff.qa.hibernate.bdmodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "positions")
public class Positions {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "salary")
    private int salary;

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final int getSalary() {
        return salary;
    }

    public final void setSalary(final int salary) {
        this.salary = salary;
    }
}
