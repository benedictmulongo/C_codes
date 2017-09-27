package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
	// write your code here
        population pop = new population();
        //pop.display();
        //get the individ to infect near in the individ in position
        // pop.getNear(X,Y)
        ArrayList<int[]> ob = pop.getNear(5,5);
        System.out.println("ob size = " + ob.size());
        //choose randomly N individ from the list of individ near
        // the sick individ with probility p
        ArrayList<int[]> chos = pop.random_choose(ob,0.5);
        for(int [] p : ob)
            System.out.println(" Universe = " + Arrays.toString(p));
        System.out.println(" ************** 1 ***************** ");
        System.out.println(" chos size  = " + chos.size());
        for(int [] p : chos)
            System.out.println(" choosed in Universe = " + Arrays.toString(p));
        System.out.println(" **************** 2 *************** ");


    }
}
