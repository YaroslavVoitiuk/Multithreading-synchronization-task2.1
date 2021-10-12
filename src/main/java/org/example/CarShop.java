package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CarShop {

    CarSeller carSeller = new CarSeller(this);
    List<Car> cars = new ArrayList<>();

    public Car sellCar(){
       return carSeller.sellCar();
    }

    public void receiveCar(){
        carSeller.receiveCar();
    }

    public List<Car> getCars() {
        return cars;
    }
}
