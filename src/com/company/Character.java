package com.company;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private Roles role;
    private final List<Item> items = new ArrayList<>();
    private double health;
    private boolean hasDysentary;

    public Character(String name, Roles role) {
        this.name = name;
        this.role = role;
        this.health = 100;
        this.hasDysentary = false;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void reduceHealth(Integer deduction) {
        health -= hasDysentary ? deduction * 1.1 : deduction;
    }

    public void contractDysentary() {
        hasDysentary = true;
    }
}
