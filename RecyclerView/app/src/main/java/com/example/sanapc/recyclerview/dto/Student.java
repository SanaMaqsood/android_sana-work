package com.example.sanapc.recyclerview.dto;

import java.io.Serializable;

/**
 * Created by Sana PC on 7/3/2017.
 */

public class Student implements Serializable{
   public int id,marks;
   public String name;

   public Student(int id, String name, int marks) {
      this.id = id;
      this.marks = marks;
      this.name = name;
   }
}
