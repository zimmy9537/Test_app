package android.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    private Avengers avengers;
    private ImageView imageView;
    private TextView textView;
    private RatingBar ratingBar;
    ImageView backImage;

    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String super_preference = "superKey";
    public static final String spider_preference = "spiderKey";
    public static final String hulk_preference = "hulkKey";
    SharedPreferences.Editor editor;
    private String ratingStringSuper;
    private String ratingStringSpider;
    private String ratingStringHulk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        imageView = findViewById(R.id.ratingImage);
        textView = findViewById(R.id.ratingName);
        ratingBar = findViewById(R.id.rating);
        backImage=findViewById(R.id.back);


        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        avengers = (Avengers) getIntent().getSerializableExtra("avenger");
        textView.setText(avengers.getName());
        imageView.setImageResource(avengers.getImageResource());
        switch (avengers.getRating()) {
            case "Very Good":
                ratingBar.setRating(2);
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
            case "Awesome":
                ratingBar.setRating(3);
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                break;
            case "Normal":
                ratingBar.setRating(1);
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
        }

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (avengers.getName().equals("SpiderMan")) {
                    editor.putString(spider_preference, getStringRating(rating));
                } else if (avengers.getName().equals("SuperMan")) {
                    editor.putString(super_preference, getStringRating(rating));
                } else {
                    editor.putString(hulk_preference, getStringRating(rating));
                }
                editor.apply();
            }
        });
    }

    String getStringRating(float rating) {
        if (rating == 3f) {
            return "Awesome";
        } else if (rating == 2f) {
            return "Very Good";
        } else {
            return "Normal";
        }
    }
}