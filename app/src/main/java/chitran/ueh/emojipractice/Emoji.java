package chitran.ueh.emojipractice;

public class Emoji {
    public String name;
    public int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Emoji(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public Emoji() {
    }
}
