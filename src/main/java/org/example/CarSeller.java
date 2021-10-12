package org.example;


public class CarSeller {

    private static final int THREAD_SHORT_SLEEP = 1000;
    private static final int THREAD_LONG_SLEEP = 2000;
    private static final int ZERO = 0;
    private final CarShop carShop;
    public CarSeller(CarShop carShop){
        this.carShop = carShop;
    }

    public void printBorder(){
        System.out.println("------------------");
    }

    public synchronized Car sellCar(){
        try {
            System.out.println("Покупатель " + Thread.currentThread().getName() + " хочет купить автомобиль");
            while (carShop.getCars().size() == ZERO){
                System.out.println("Машин нет в наличии...\nОжидаем поставку...");
                printBorder();
                wait();
            }
            Thread.sleep(THREAD_SHORT_SLEEP);
            System.out.println("Покупатель " + Thread.currentThread().getName() + " купил новую машину");
            printBorder();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return carShop.getCars().remove(ZERO);
    }

    public synchronized void receiveCar(){
        try {
            System.out.println("С завода пришла поставка, розгружаем....");
            Thread.sleep(THREAD_LONG_SLEEP);
            carShop.getCars().add(new Car());
            System.out.println("Автосалон получил машину ");
            printBorder();
            notify();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
