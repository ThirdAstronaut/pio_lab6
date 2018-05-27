public class AccountSettings {

    private Languages language;
    private Font font;

    AccountSettings(Languages language, Font font) {
        this.language = language;
        this.font = font;
    }

    boolean changeFontSize(int newSize) {
        if (!(newSize > 0 && newSize <= 150)) {
            return false;
        }
        font.setSize(newSize);
        return true;
    }

    public boolean changeFontStyle(Fonts newStyle) {
        font.setFonts(newStyle);
        return true;
    }

    public int[] getDefaultFontsSizes(){
        return new int[]{14,25};
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }
}
