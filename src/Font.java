public class Font {

    private Fonts fonts ;
    private int size;

    Font(Fonts fonts, int size) {
        this.fonts = fonts;
        this.size = size;
    }

    public Fonts getFonts() {
        return fonts;
    }

    void setFonts(Fonts fonts) {
        this.fonts = fonts;
    }

    public int getSize() {
        return size;
    }

    void setSize(int size) {
        this.size = size;
    }
}
