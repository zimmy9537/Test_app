package android.example.test_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Avengers> avengers;
    private RecyclerView avengerRecyclerView;
    private AvengersAdapter avengersAdapter;

    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String super_preference = "superKey";
    public static final String spider_preference = "spiderKey";
    public static final String hulk_preference = "hulkKey";
    private String ratingStringSuper;
    private String ratingStringSpider;
    private String ratingStringHulk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "called", Toast.LENGTH_SHORT).show();
        avengerRecyclerView = findViewById(R.id.avengersRv);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        ratingStringSuper = sharedPreferences.getString(super_preference, "Awesome");
        ratingStringSpider = sharedPreferences.getString(spider_preference, "Very Good");
        ratingStringHulk = sharedPreferences.getString(hulk_preference, "Normal");

        avengers = new ArrayList<>();

        avengers.add(new Avengers("SuperMan", ratingStringSuper, R.drawable.superman));
        avengers.add(new Avengers("SpiderMan", ratingStringSpider, R.drawable.spiderman));
        avengers.add(new Avengers("Hulk", ratingStringHulk, R.drawable.hulk));

        avengersAdapter = new AvengersAdapter(avengers, this);
        avengerRecyclerView.setAdapter(avengersAdapter);
        avengerRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        ratingStringSuper = sharedPreferences.getString(super_preference, "Awesome");
        ratingStringSpider = sharedPreferences.getString(spider_preference, "Very Good");
        ratingStringHulk = sharedPreferences.getString(hulk_preference, "Normal");

        avengers = new ArrayList<>();

        avengers.add(new Avengers("SuperMan", ratingStringSuper, R.drawable.superman));
        avengers.add(new Avengers("SpiderMan", ratingStringSpider, R.drawable.superman));
        avengers.add(new Avengers("Hulk", ratingStringHulk, R.drawable.hulk));

        avengersAdapter = new AvengersAdapter(avengers, this);
        avengerRecyclerView.setAdapter(avengersAdapter);
        avengerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}