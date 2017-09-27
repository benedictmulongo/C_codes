package com.company;

/**
 * Created by ben on 2017-09-26.
 */
public class Individ
{
    String name;
    Boolean infect;
    Boolean islive;
    Boolean immun;
    int [] lifetime;
    pos position;
    int nb_days_sickness = 0;

    Individ(String n, int x,int y)
    {
        this.name = n;
        this.infect = false;
        this.islive = true;
        this.immun = false;
        this.lifetime = new int [2];
        lifetime[0] = 5;
        lifetime[1] = 10;
        this.position = new pos(x,y);
        //numbers of days elapsed since the individ were infected
        this.nb_days_sickness = 0;
    }

    Individ(String n, int x,int y, boolean inf)
    {
        this.name = n;
        this.infect = inf;
        this.islive = true;
        this.immun = false;
        this.lifetime = new int [2];
        lifetime[0] = 5;
        lifetime[1] = 10;
        this.position = new pos(x,y);
        //numbers of days elapsed since the individ were infected
        this.nb_days_sickness = 1;
    }

    Individ()
    {
        this.infect = false;
        this.islive = true;
        this.immun = false;
        this.lifetime = new int [2];
        lifetime[0] = 5;
        lifetime[1] = 10;
    }

    public void setInfect(Boolean f)
    {
        this.infect = f;
        this.nb_days_sickness++;
    }
    public void setIslive(Boolean l)
    {
        this.islive = l;
    }
    public void setLifetime(int min, int max)
    {
        this.lifetime[0] = min;
        this.lifetime[1] = max;
    }

    public void setImmun(Boolean i)
    {
        this.immun = i;
    }

    public boolean isLive()
    {
        return islive;
    }
    public boolean isInfect()
    {
        return infect;
    }
    public boolean isImmun()
    {
        return immun;
    }
    public void days_infection()
    {
        this.nb_days_sickness++;
    }

    public String toString()
    {
        return "[ Id = " + name + " , infect = " + infect + " , pos = " + position + " ] ";
    }
}
