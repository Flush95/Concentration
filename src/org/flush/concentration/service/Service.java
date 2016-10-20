package org.flush.concentration.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Admin on 18.10.2016.
 */
public class Service {

    public void printAccordanceTable(List<Double> cList, List<Double> avgList) {

        for (int i = 0; i < cList.size(); i++) {
            System.out.println("|" + cList.get(i) + "|" + "\t" + "|" + avgList.get(i) + "|");
        }

    }

    public Double getApproximateNumber(List<Integer> array) {

        Collections.sort(array);
        List<Integer> minList = new ArrayList<>();

        for (int i = 1; i < array.size(); i++)
            minList.add(array.get(i) - array.get(i - 1));

        int min = Collections.min(minList);
        int index = minList.indexOf(min);

        double h1 = array.get(index);
        double h2 = array.get(index +1);

        return (h1 + h2) / 2;
    }

    public Double calculateK(double h1, double h2, double C1, double C2) {
        return 0.5 * ((h1 / C1) + (h2 / C2));
    }
    public double calculateCx(double Hx, double K) {
        return Hx / K;
    }
}

