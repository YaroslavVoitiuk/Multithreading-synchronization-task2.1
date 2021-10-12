package org.example;


public class Main {
    public static void main( String[] args ) {
        final CarShop carShop = new CarShop();
        int currCar = 0;
        final int CAR_QUANTITY = 9;
        while (currCar < CAR_QUANTITY){
            new Thread(carShop::sellCar, "1").start();
            new Thread(carShop::sellCar, "2").start();
            new Thread(carShop::sellCar, "3").start();
            new Thread(carShop::receiveCar, "factory1").start();
            new Thread(carShop::receiveCar, "factory2").start();
            new Thread(carShop::receiveCar, "factory3").start();
            currCar+=3;
        }
    }
}
