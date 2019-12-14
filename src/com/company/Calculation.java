package com.company;
    //создаем класс расчетов
public class Calculation {

    public String marker;
    public int nomer, probeg, dopParametr;
    public double consumption, price;

    //конструктор для авто с доп параметрами
    public Calculation(String marker, int nomer, int probeg, int dopParametr, double consumption, double price){
        this.marker = marker;
        this.nomer = nomer;
        this.probeg = probeg;
        this.dopParametr = dopParametr;
        this.consumption = consumption;
        this.price = price;
    }
    // конструктор для авто без доп параметров
    public Calculation(String marker, int nomer, int probeg, double consumption, double price){
        this.marker = marker;
        this.nomer = nomer;
        this.probeg = probeg;
        this.consumption = consumption;
        this.price = price;
    }

    //вычисление расходов
    public void calcExpend(String marker, int probeg, double consumption, double price, double[] masC){

        if (probeg != 0) {
            switch (marker) {
                case "C100":
                    masC[0] += (probeg * consumption / 100) * price;
                    break;
                case "C200":
                    masC[1] += (probeg * consumption / 100) * price;
                    break;
                case "C300":
                    masC[2] += (probeg * consumption / 100) * price;
                    break;
                case "C400":
                    masC[3] += (probeg * consumption / 100) * price;
                    break;
            }
        }
    }
    //=====================================================================
    //передали массив с расходами
    public double[] masC;
    public String[] masMarker;

    public Calculation(String[] masMarker, double[] masC){
        this.masC = masC;
        this.masMarker = masMarker;
    }

    //вычисление суммы
    public void calcSum(double[] masC){
        double a = 0;
        for (int i = 0; i < masC.length; i++) {
            a += masC[i];
        }
        System.out.println("Общая сумма затрат на все типы авто = " + a);
    }

    public void concl(String[] marker, double[] v){
        for (int i = 0; i < marker.length; i++) {
            System.out.println("Затраты на авто класса " + marker[i] + " составляют = " + v[i]);
        }
    }

    //вывод авто с минимальный расходом
    public void minSort(String[] marker,double[] masC){

        for (int i = 0; i < masC.length; i++) {
            if (masC[i] < masC[0]){
                masC[0] = masC[i];
                marker[0] = marker[i];
            }
        }
        System.out.println("Минимальный тип авто " + marker[0] + " и он = " + masC[0]);
    }
    //максимальный
    public void maxSort(String[] marker,double[] masC){

        for (int i = 0; i < masC.length; i++) {
            if (masC[i] > masC[0]){
                masC[0] = masC[i];
                marker[0] = marker[i];
            }
        }
        System.out.println("Максимальный тип авто " + marker[0] + " и он = " + masC[0]);
    }
//сортировка


    public void print(int dopParametr){
        if (dopParametr != 0){
            System.out.println(marker + " " + nomer + " " + probeg + " " + dopParametr);
        }else {
            System.out.println(marker + " " + nomer + " " + probeg);
        }
    }
}