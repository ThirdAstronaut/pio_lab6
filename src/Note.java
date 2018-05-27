import java.util.Date;

public class Note {

    private String title;
    private String content;

    Note(String title, String content) {
        this.title = title;
        this.content = content;
        Date creationDate = new Date();
    }

    String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
