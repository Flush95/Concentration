package org.flush.concentration.input;

import org.flush.concentration.service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by Admin on 18.10.2016.
 */
public class InputResearchedValues {

    private List<Integer> investigatedIndicators = new ArrayList<>();

    private Service service = new Service();

    public List<Integer> getInvestigatedIndicators() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            boolean flag = false;
            System.out.println("Enter Investigated Values (for stop input - enter '-1'): ");
            while (!flag) {
                int value = Integer.parseInt(reader.readLine());
                if (value == -1) {
                    flag = true;
                }
                if (value != -1)
                    investigatedIndicators.add(value);

            }

        } catch(IOException e) {
            System.out.println("Not a double number");
            e.printStackTrace();
        }

        return investigatedIndicators;
    }

    public double calculateHx() {
        return service.getApproximateNumber(getInvestigatedIndicators());
    }

}
