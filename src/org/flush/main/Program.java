package org.flush.main;

import org.flush.concentration.input.InputC;
import org.flush.concentration.input.InputResearchedValues;
import org.flush.concentration.input.InputH;
import org.flush.concentration.service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.10.2016.
 */
public class Program {

    private static Service service = new Service();

    private double h1;
    private double h2;

    private double getH1() {
        return h1;
    }

    private void setH1(double h1) {
        this.h1 = h1;
    }

    private double getH2() {
        return h2;
    }

    private void setH2(double h2) {
        this.h2 = h2;
    }

    public static void main(String[] args) {
        Program program = new Program();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int quantityOfC = 0;
        int quantityOfh = 0;

        try {

            System.out.print("Input quantity of C: ");
            quantityOfC = Integer.parseInt(reader.readLine());

            System.out.print("Input quantity of h: ");
            quantityOfh = Integer.parseInt(reader.readLine());

        } catch (IOException e) {
            System.out.println("Written quantity isn't a Integer number");
            e.printStackTrace();
        }

        InputC cObj = new InputC(quantityOfC);
        InputH hObj = new InputH(quantityOfh * quantityOfC);
        InputResearchedValues inputResearchedValues = new InputResearchedValues();

        double hx = inputResearchedValues.calculateHx();


        List <Double> cList = new ArrayList<>();
        cList.addAll(cObj.getCList());

        List <Double> approxList = new ArrayList<>();
        approxList.addAll(hObj.getHiAvgList(hx, quantityOfh));

        for (int j = 1; j < approxList.size(); j++) {
            if (hx > approxList.get(j - 1) && hx < approxList.get(j)) {
                program.setH1(approxList.get(j - 1));
                cObj.setC1(cList.get(j - 1));
                program.setH2(approxList.get(j));
                cObj.setC2(cList.get(j));
            }
        }
        service.printAccordanceTable(cList, approxList);

        double K = service.calculateK(program.getH1(), program.getH2(), cObj.getC1(), cObj.getC2());

        //System.out.println("C1: " + cObj.getC1() + "\tC2: " + cObj.getC2() + "\th1: " + program.getH1() + "\th2: " + program.getH2());

        System.out.println();
        System.out.println("K value: " + K);
        System.out.println();
        System.out.println("Cx value: " + service.calculateCx(hx, K));

    }
}
/*
126
126
127
130
129
135
137
138
140
143
143
148
 */

/*
128
147
142
143
135
140
150
*/
