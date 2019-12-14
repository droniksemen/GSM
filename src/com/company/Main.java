package com.company;

public class Main {

    public static void main(String[] args) {
        String[]  strName = {            //входные данные
                "C100_1-100",
                "C200_1-120-1200",
                "C300_1-120-30",
                "C400_1-80-20",
                "C100_2-50",
                "C200_2-40-1000",
                "C300_2-200-45",
                "C400_2-10-20",
                "C100_3-10",
                "C200_3-170-1100",
                "C300_3-150-29",
                "C400_3-100-28",
                "C100_1-300",
                "C200_1-100-750",
                "C300_1-32-15"
        };
//=====================================================================================
        Calculation[] cal = new Calculation[strName.length]; // разбиваем строки вводных данных
        int count = 0;
        for (String s : strName) {

            String[] params = s.split("-");
            String[] params2 = params[0].split("_");

            double price = 0;
            double consumption = 0;

            switch (params2[0]) {
                case "C100":
                    price = 46.10;
                    consumption = 12.5;
                    break;
                case "C200":
                    price = 48.90;
                    consumption = 12;
                    break;
                case "C300":
                    price = 47.50;
                    consumption = 11.5;
                    break;
                case "C400":
                    price = 48.90;
                    consumption = 20;
                    break;
            }

            if (params.length > 2) {
                cal[count] = new Calculation(params2[0], Integer.valueOf(params2[1]), Integer.valueOf(params[1]), Integer.valueOf(params[2]), consumption, price);
            } else {
                cal[count] = new Calculation(params2[0], Integer.valueOf(params2[1]), Integer.valueOf(params[1]), consumption, price);
            }
            count++;
        }
//====================================================================================
        //вычисление расходов по каждой марке авто

        double c100 = 0;
        double c200 = 0;
        double c300 = 0;
        double c400 = 0;
        double[] masC = {c100, c200, c300, c400};

        for (int i = 0; i < strName.length; i++) {
            cal[i].calcExpend(cal[i].marker, cal[i].probeg, cal[i].consumption, cal[i].price, masC);
        }
        //вывод суммы затрат и по отдельности на каждый тип авто

        int lenMark = 0;
        for (int i = 0; i < cal[i].marker.length(); i++) {
            lenMark++;
        }
        String[] masMarker = new String[lenMark];
        for (int i = 0; i < cal[i].marker.length(); i++) {
            masMarker[i] = cal[i].marker;
        }
        Calculation cal2 = new Calculation(masMarker, masC);
        cal2.calcSum(masC);
        cal2.concl(masMarker, masC);

        //максимальный и минимальный
        cal2.minSort(masMarker, masC);
        cal2.maxSort(masMarker,masC);
        //========================================================================
        //сортировка
        Object tmp;

        for (int i = strName.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(cal[j].probeg > cal[j + 1].probeg){
                    tmp = cal[j];
                    cal[j] = cal[j+1];
                    cal[j+1] = (Calculation) tmp;
                }
            }
        }
        for (int i = strName.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (cal[j].probeg == cal[j+1].probeg){
                    if(cal[j].dopParametr > cal[j + 1].dopParametr){
                        tmp = cal[j];
                        cal[j] = cal[j+1];
                        cal[j+1] = (Calculation) tmp;
                    }
                }

            }
        }

        for (int i = 0; i < strName.length; i++) {
            cal[i].print(cal[i].dopParametr);
        }

    }
}