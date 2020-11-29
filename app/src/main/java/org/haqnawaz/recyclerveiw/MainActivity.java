package org.haqnawaz.recyclerveiw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int id;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    List<Friends> friendsList = new ArrayList<Friends>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter();

    }
    private void setListAdapter() {
        Friends f0 = new Friends(1,"Asad", 1980, "Giglgit");
        Friends f1 = new Friends(2,"Zubair", 1981, "Lahore");
        Friends f2 = new Friends(3,"Musa", 1980, "Quetta");
        Friends f3 = new Friends(4,"Nadeem",1987,"Peshawar");
        Friends f4 = new Friends(5,"Shahid", 1980, "Karachi");
        Friends f5 = new Friends(6,"Zia",1987,"Faisalabad ");
        Friends f6 = new Friends(7,"Badar", 1980, "Rawalpindi");
        Friends f7 = new Friends(8,"Hashim",1987,"Lahore");
        id = 8;
        friendsList.addAll(Arrays.asList(new Friends[]{f0,f1,f2,f3,f4,f5,f6,f7}));
        recyclerView = findViewById(R.id.recyclerView);

        //recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(friendsList,MainActivity.this) {

        };

        recyclerView.setAdapter(adapter);
    }

    public void AddFriend(View view)
    {
        EditText nameField = findViewById(R.id.nameField);
        EditText dobField = findViewById(R.id.dobField);
        EditText cityField = findViewById(R.id.cityField);

        String name = nameField.getText().toString();
        String city = cityField.getText().toString();
        int dob = 0;
        try {
            dob = Integer.parseInt(dobField.getText().toString());
        }
        catch (Exception e) {
            Toast.makeText(this, "Please enter a valid year.", Toast.LENGTH_SHORT).show();
        }

        if (!name.equals("") && !city.equals("") && dob > 1800)
        {
            Friends f = new Friends(++id, name, dob, city);
            friendsList.add(f);
            adapter.notifyDataSetChanged();

            nameField.getText().clear();
            dobField.getText().clear();
            cityField.getText().clear();
        }
        else
        {
            Toast.makeText(this, "Please enter valid values.", Toast.LENGTH_SHORT).show();
        }
    }
}
