package com.appmobiles.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class Model {
    private final ObservableList<String> names = FXCollections.observableArrayList();

    public ObservableList<String> getNames() {
        return names ;
    }

    public void next(){
        names.add("next_" + ThreadLocalRandom.current().nextInt());
    }

    public void addName(String name) {
        names.add(name);
    }
}
