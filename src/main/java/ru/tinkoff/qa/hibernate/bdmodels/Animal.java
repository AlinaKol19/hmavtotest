package ru.tinkoff.qa.hibernate.bdmodels;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private int age;
    @JoinColumn(name = "\"type\"")
    @ManyToOne
    private Types types;
    @JoinColumn(name = "sex")
    @ManyToOne
    private Sex sex;
    @JoinColumn(name = "place")
    @ManyToOne
    private Places place;

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

    public final Types getTypes() {
        return types;
    }

    public final void setTypes(final Types types) {
        this.types = types;
    }

    public final Sex getSex() {
        return sex;
    }

    public final void setSex(final Sex sex) {
        this.sex = sex;
    }

    public final Places getPlace() {
        return place;
    }

    public final void setPlace(final Places place) {
        this.place = place;
    }
}
