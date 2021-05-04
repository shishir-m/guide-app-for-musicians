package com.example.guide_appformusicians;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


class Pair
{
    String task;
    int dur;

    public Pair(String task, int dur)
    {
        this.task = task;
        this.dur = dur;
    }

}




class Compare
{
    ArrayList<com.example.guide_appformusicians.Cricketer> compare(Pair arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dur - o2.dur;
            }
        });





        ArrayList<com.example.guide_appformusicians.Cricketer> newcricketersList = new ArrayList<>();

        int max = 60;
        int cur = 0;
        for(int i = 0; i < n; i++)
        {
            cur = cur + arr[i].dur;
            if(cur > max) {
                break;
            }
            else {
                System.out.println("Cur : " + cur);
                System.out.println();
                Cricketer newcricketer = new com.example.guide_appformusicians.Cricketer();
                System.out.println(arr[i].task + " : " + arr[i].dur);
                newcricketer.setCricketerName(arr[i].task);
                String time = (Integer.toString(arr[i].dur)) + " Minutes";
                newcricketer.setTeamName(time);
                newcricketersList.add(newcricketer);
            }
        }

        System.out.println();

        return newcricketersList;
    }
}



public class ActivityCricketers extends AppCompatActivity {

    RecyclerView recyclerCricketers;
    ArrayList<com.example.guide_appformusicians.Cricketer> cricketersList = new ArrayList<>();
    ArrayList<com.example.guide_appformusicians.Cricketer> newcricketersList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /*EditText maxTime;
        maxTime = findViewById(R.id.time);

        String temp = maxTime.getText().toString();
        int max;
        if (!"".equals(temp))
        {
            max = Integer.parseInt(temp);
            System.out.println("Time : " + max);
            System.out.println();
        }

    */











        setContentView(R.layout.activity_cricketers);

        recyclerCricketers = findViewById(R.id.recycler_cricketers);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerCricketers.setLayoutManager(layoutManager);

        cricketersList = (ArrayList<com.example.guide_appformusicians.Cricketer>) getIntent().getExtras().getSerializable("list");

        int listsize = cricketersList.size();
        Pair arr[] = new Pair[listsize];


        for(int i = 0; i < cricketersList.size(); i++)
        {
            String taskname = cricketersList.get(i).cricketerName.replaceAll("\\s", "");
            String duration = cricketersList.get(i).teamName.substring(0,2).replaceAll("\\s", "");
            int time = Integer.parseInt(duration);
            arr[i] = new Pair(taskname, time);
        }

        Compare obj = new Compare();
        newcricketersList = obj.compare(arr, listsize);

        recyclerCricketers.setAdapter(new com.example.guide_appformusicians.CricketerAdapter(newcricketersList));

    }
}