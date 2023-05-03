package com.learnJava.streams;

import java.util.*;
import java.util.stream.*;

class Staff
{
    String name;
    int id;

    public Staff(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
public class Test2 {
    public static void main(String[] args) {
        List<Staff> staff=Arrays.asList(new Staff("Kamal",5),new Staff("Raj",1),new Staff("temp",7));
        List<String> staffNames1=new ArrayList<>();
        for(Staff s:staff)
            staffNames1.add(s.getName());

        System.out.println(staffNames1);

        List<String> staffNames2=staff.stream().map(x->x.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println(staffNames2);


    }
  


}
