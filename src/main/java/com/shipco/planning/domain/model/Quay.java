package com.shipco.planning.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Quay {

    private final UUID id;
    private final int number;

    public Quay(UUID id, int number) {
        this.id = id;
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quay quay = (Quay) o;
        return number == quay.number && Objects.equals(id, quay.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @Override
    public String toString() {
        return "Quay{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
