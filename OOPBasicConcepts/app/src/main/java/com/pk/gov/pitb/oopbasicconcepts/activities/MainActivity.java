package com.pk.gov.pitb.oopbasicconcepts.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pk.gov.pitb.oopbasicconcepts.R;
import com.pk.gov.pitb.oopbasicconcepts.dto.Animals;
import com.pk.gov.pitb.oopbasicconcepts.dto.BabyDog;
import com.pk.gov.pitb.oopbasicconcepts.dto.Dog;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "this is onstart", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(this,"this is onPause",Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this,"this is onRsume",Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this,"this is onStop",Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(this,"this is onRestart",Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this,"this is onDestroy",Toast.LENGTH_LONG).show();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   Animals animalss= new Animals(this);
        //polymorphism
       Animals animals = new Dog(this);
        animals.sound();
        ((Dog)animals).bark();


        //Single  inheritence
        Dog d= new Dog(this);
        d.bark();
        d.sound();
        d.eat();


        //Multi level inherhitence
        BabyDog babyDog= new BabyDog(this);
        babyDog.eat();
        babyDog.sound();
        babyDog.bark();
        babyDog.weep();

        // static methods call by their class name which is animal

        int count= Animals.count(5,6);// method overloading
        int counts= Animals.count(8,6);

       // final count method calling
        Animals animals1= new Animals(this);
        int countss=animals1.count();  // method overloading




    }
}
