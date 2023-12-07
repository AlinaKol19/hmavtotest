package ru.tinkoff.qa.hibernate.bdmodels;


import jakarta.persistence.*;

@Entity
@Table(name = "workman")
public class Workman {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private int age;
    @JoinColumn(name = "\"position\"")
    @ManyToOne
    private Positions position;

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

    public final int getAge() {
        return age;
    }

    public final void setAge(final int age) {
        this.age = age;
    }

    public final Positions getPosition() {
        return position;
    }

    public final void setPosition(final Positions position) {
        this.position = position;
    }
}