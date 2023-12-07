package ru.tinkoff.qa.hibernate.bdmodels;

import jakarta.persistence.*;

@Entity
@Table(name = "places")
public class Places {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"row\"")
    private int row;
    @Column(name = "place_num")
    private int placeNum;

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getRow() {
        return row;
    }

    public final void setRow(final int row) {
        this.row = row;
    }

    public final int getPlaceNum() {
        return placeNum;
    }

    public final void setPlaceNum(final int placeNum) {
        this.placeNum = placeNum;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }
}
