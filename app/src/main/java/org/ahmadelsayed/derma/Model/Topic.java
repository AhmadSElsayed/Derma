package org.ahmadelsayed.derma.Model;

public class Topic {
    public Topic(int image, String name, String disease) {
        this.image = image;
        this.name = name;
        this.disease = disease;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int image;
    private String name;
    private String disease;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
