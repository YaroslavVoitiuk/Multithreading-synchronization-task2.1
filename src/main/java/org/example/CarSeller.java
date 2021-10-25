package org.example;


public class CarSeller extends Thread {

    private static final int THREAD_SHORT_SLEEP = 1000;
    private static final int THREAD_LONG_SLEEP = 2000;
    private static final int CARS_TO_SELL = 3;
    private final CarShop carShop;

    public CarSeller(CarShop carShop) {
        this.carShop = carShop;
    }

    public void printBorder() {
        System.out.println("------------------");
    }

    public Car sellCar() {
        try {
            synchronized (this) {
                System.out.println("Покупатель " + Thread.currentThread().getName() + " хочет купить автомобиль");
                while (carShop.getCars().isEmpty()) {
                    System.out.println("Машин нет в наличии...");
                    printBorder();
                    wait();
                }
                Thread.sleep(THREAD_SHORT_SLEEP);
                System.out.println("Покупатель " + Thread.currentThread().getName() + " купил новую машину");
                printBorder();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carShop.getCars().remove(0);
    }

    public void receiveCar() {
        int currCarVal = 0;
        try {
            while (currCarVal < CARS_TO_SELL) {
                Thread.sleep(THREAD_LONG_SLEEP);
                synchronized (this) {
                    carShop.getCars().add(new Car());
                    System.out.println("Автосалон получил машину ");
                    printBorder();
                    notify();
                    currCarVal++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
