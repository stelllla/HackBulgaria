package problem8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsList implements Statistics {

    private List<Integer> list = new ArrayList<>();
    private int size = 0,indexMode = 0,minElem = Integer.MAX_VALUE,maxElem = Integer.MIN_VALUE,
                sumElements = 0;

    public void add(int number) {
        list.add(number);
        size ++;
        sumElements+=number;
        
        if (minElem > number) {
            minElem = number;
        }
        else {
            if (maxElem < number) {
                maxElem = number;
            }
        }
        
        if (Collections.frequency(list, list.get(indexMode)) < Collections.frequency(list, number)) {
            indexMode = list.indexOf(number);
        }
    }

    @Override
    public double getMean() {
        return (double) sumElements / size;
    }

    @Override
    public double getMedian() {
        double res = Double.MIN_VALUE;
        if ( size % 2 == 0) {
            int after = size/2;
            res = (list.get(after -1) + list.get(after))/2 ;
            
        } else 
        {
            res = list.get(size/2);
        }
        
       return res;
    }

    @Override
    public int getMode() {
        return list.get(indexMode);
    }

    @Override
    public int getRange() {
       return maxElem - minElem;
    }

}
