package org.example;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        final CarShop carShop = new CarShop();
        int currCar = 0;
        final int CAR_QUANTITY = 6;
        final int CARS_SOLD = 3;
        while (currCar < CAR_QUANTITY) {
            Thread thread1 = new Thread(carShop::sellCar, "1");
            Thread thread2 = new Thread(carShop::sellCar, "2");
            Thread thread3 = new Thread(carShop::sellCar, "3");
            Thread thread = new Thread(carShop::receiveCar, "factory1");
            thread.start();
            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();
            currCar += CARS_SOLD;
        }
    }
}
