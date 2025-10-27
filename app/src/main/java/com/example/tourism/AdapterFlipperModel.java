package com.example.tourism;

/**
 * Model for the adapter flipper.
 * Constructor and getters match usage in MainActivity:
 * new AdapterFlipperModel("Title", "Description", R.drawable.some_image)
 */
public class AdapterFlipperModel {

    private String title;
    private String description;
    private int image; // drawable resource id

    // Constructor matching MainActivity usage: (title, description, image)
    public AdapterFlipperModel(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    // Optional convenience constructor (image, title) if you ever need it:
    public AdapterFlipperModel(int image, String title) {
        this.title = title;
        this.description = "";
        this.image = image;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    // Setters (optional)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
