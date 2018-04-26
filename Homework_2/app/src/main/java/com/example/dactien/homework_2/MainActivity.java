package com.example.dactien.homework_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvDish;
    List<Dish> listDish;
    DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvDish = (ListView) findViewById(R.id.lvDish);
        listDish = new ArrayList<>();
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        listDish.add(new Dish(
                "Apple Spinach Salad", R.drawable.icon_dish1,
                R.drawable.high_dish1, R.drawable.dish1));
        dishAdapter = new DishAdapter(this, R.layout.custom_item_list, listDish);
        lvDish.setAdapter(dishAdapter);
    }
}
