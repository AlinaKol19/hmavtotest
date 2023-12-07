package ru.tinkoff.qa.hibernate.bdmodels;

import jakarta.persistence.*;

import java.time.LocalDate;

@Embeddable
@Table(name = "zoo_animal")
public class ZooAnimal {
    @JoinColumn(name = "zoo_id")
    @ManyToOne
    private Zoo zooId;
    @JoinColumn(name = "animal_id")
    @ManyToOne
    private Animal animal;
    @Column(name = "time_apperance")
    private LocalDate timeApperance;
    @JoinColumn(name = "workman")
    @ManyToOne
    private Workman workman;

    public final Zoo getZooId() {
        return zooId;
    }

    public final void setZooId(final Zoo zooId) {
        this.zooId = zooId;
    }

    public final Animal getAnimal() {
        return animal;
    }

    public final void setAnimal(final Animal animal) {
        this.animal = animal;
    }

    public final LocalDate getTimeApperance() {
        return timeApperance;
    }

    public final void setTimeApperance(final LocalDate timeApperance) {
        this.timeApperance = timeApperance;
    }

    public final Workman getWorkman() {
        return workman;
    }

    public final void setWorkman(final Workman workman) {
        this.workman = workman;
    }
}
