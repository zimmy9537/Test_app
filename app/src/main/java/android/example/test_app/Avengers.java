package android.example.test_app;

import java.io.Serializable;

public class Avengers implements Serializable {
    private String name;
    private String rating;
    private int imageResource;

    public Avengers(String name, String rating, int imageResource) {
        this.name = name;
        this.rating = rating;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
