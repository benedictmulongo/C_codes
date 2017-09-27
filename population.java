package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ben on 2017-09-26.
 */
public class population
{
/*    //case 0
    final int [] X = {0,-1,-1,-1,0,1,1,1} ;
    final int [] Y = {1,1,0,-1,-1,-1,0,1};*/

    //****************** data input ************************
    //size of the population
    int N;
    //probability that a sick individ infects its neighbours
    double ps;
    //the lifetime of the disease for each individ
    int min;
    int max;
    //probability that an individ X die iff X is sick
    double ps_x;
    //number of sick individs and their position
    int Ns;
    int posX;
    int posY;
    Individ [][] pop;
    //*******************************************************

    ArrayList<Object> coord;
    population()
    {
        //Scanner in
        //****************** data input ************************
        //size of the population
        this.N = 11;
        //probability that a sick individ infects its neighbours
        this.ps = 0.4;
        //the lifetime of the disease for each individ
        this.min = 5;
        this.max = 10;
        //probability that an individ X die iff X is sick
        this.ps_x = 0.55;
        //number of sick individs and their position
        this.Ns = 1;
        this.posX = (int)(this.N/2);
        this.posY = (int)(this.N/2);
        //*******************************************************
        System.out.println("X = "  + this.posX);
        System.out.println("X = "  + this.posY);

        this.coord = new ArrayList<Object>();
        this.pop = new Individ[N][N];
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                pop[i][j] = new Individ( " " + i + "" + j, i,j);
                if( i == this.posX && j == this.posY)
                    pop[i][j] = new Individ( " " + i + "" + j, i,j,true);
            }
        }
    }


    public ArrayList<int[]> getNear(int x1, int y1)
    {
        return neighbours(x1,y1,this.pop);
    }

    public ArrayList<int[]> neighbours(int posX, int posY, Individ [][] P)
    {
        int dim = P[0].length;
        pos point = new pos(posX,posY);
        ArrayList<Object> cd = new ArrayList<Object>();
        ArrayList<int[]> par = new ArrayList<int[]>();
        pos [] back;
        //get the situation and postion of object individ
        // around the individ in index posX and posY
        int sit = situation(posX,posY,dim);
        System.out.println("case is = " + sit);
        //get the corresponding
//        int [] cord = (int[]) coord.get(sit);
        if((sit >= 0 ) && (sit <= 3)) {
            //case 1
            //back = new int[6];
            switch (sit)
            {
                case 0 :
                    par.add(point.getRight());
                    par.add(point.getQ4());
                    par.add(point.getDown());
                    break;
                case 1 :
                    par.add(point.getLeft());
                    par.add(point.getQ3());
                    par.add(point.getDown());
                    break;
                case 2 :
                    par.add(point.getUp());
                    par.add(point.getQ1());
                    par.add(point.getRight());
                    break;
                case 3 :
                    par.add(point.getUp());
                    par.add(point.getQ2());
                    par.add(point.getLeft());
                    break;
            }
        }
        else if((sit >= 4 ) && (sit <= 7)) {
            //case 2 or 1
            //back = new int[12];
            switch (sit)
            {
                case 4 :
                    par.add(point.getQ3());
                    par.add(point.getLeft());
                    par.add(point.getRight());
                    par.add(point.getQ4());
                    par.add(point.getDown());
                    break;
                case 5 :
                    par.add(point.getLeft());
                    par.add(point.getQ1());
                    par.add(point.getUp());
                    par.add(point.getRight());
                    par.add(point.getQ2());
                    break;
                case 6 :
                    par.add(point.getUp());
                    par.add(point.getQ1());
                    par.add(point.getRight());
                    par.add(point.getQ4());
                    par.add(point.getDown());
                    break;
                case 7 :
                    par.add(point.getUp());
                    par.add(point.getQ2());
                    par.add(point.getLeft());
                    par.add(point.getQ3());
                    par.add(point.getDown());
                    break;
            }
        }
        else {
            //back = new int[16];
            par.add(point.getUp());
            par.add(point.getRight());
            par.add(point.getDown());
            par.add(point.getLeft());
            par.add(point.getQ1());
            par.add(point.getQ2());
            par.add(point.getQ3());
            par.add(point.getQ4());
        }

        return par;
    }

    public int situation(int x, int y, int n)
    {
        int c = 0;
        //case 1 4 cases
        if( x == 0 && y == 0)
            return 0;
        else if(x == 0 && y == n -1)
            return 1;
        else if(x == n - 1 && y == 0)
            return 2;
        else if (x ==  n - 1 && y == n - 1)
            return 3;

        //case 2 2 cases
        if( x == 0)
            return 4;
        else if(x == n - 1)
            return 5;

        if( y == 0)
            return 6;
        else if(y == n - 1)
            return 7;
        return -1;
    }

    public void display()
    {
        for(int i = 0; i < this.N; i++)
        {
            for(int j = 0; j < this.N; j++)
            {

                System.out.print(" " + pop[i][j]);
            }
            System.out.println(" ");
        }

    }
    //select a.size() * random
    public ArrayList<int[]> random_choose(ArrayList<int[]> univ, double prob)
    {
        ArrayList<int[]> par = new ArrayList<int[]>();
        //choose no more than this number of element
        int limit = (int)(prob*univ.size());
        System.out.println("univ size = " + univ.size());
        System.out.println("limit = " + limit);
        boolean [] check = new boolean[univ.size()];
        int t,k;
        int count = 0;
        for(int i = 0; (par.size() <= limit); i++ )
        {
            t = (int)(univ.size() * Math.random());
            if(count < limit)
            {
                if(check[t] == false) {
                    check[t] = true;
                    par.add(univ.get(t));
                    count++;
                }
            }
            else if(count == limit) {
                break;
            }
            else
                break;
        }
        return par;
    }

    //infect will be called from another function
    // every call will constituetes an iteration and
    // represent one day in our model
    public void infect(Individ [][] peuples)
    {
        for(int i = 0; i < this.N; i++)
        {
            for(int j = 0; j < this.N; j++)
            {
                if(peuples[i][j].isInfect())
                {
                    ArrayList<int[]> ind_toInfect = neighbours(i,j,peuples);
                    ArrayList<int[]> ind_Infect = random_choose(ind_toInfect,this.ps);
                    for(int [] p : ind_Infect)
                        peuples[p[0]][p[1]].setInfect(true);
                    peuples[i][j].days_infection();
                    //handle different cases min och max set immun
                    //individ cannot infect each others the same day the infection occurs
                    //set two variable in the population class
                    //SM,X,F,S,AS,AX and update them for each iterations
                }
            }
        }
    }

}
