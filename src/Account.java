import java.util.*;

public class Account {

    private Long id;
    private char status;
    private String password;
    private String login;
    private AccountSettings accountSettings;
    private Wallet wallet;
    private Map<String, List<Note>> notes;

    Account(Long id, char status, String password, String login, AccountSettings accountSettings) {
        this.id = id;
        this.status = status;
        this.password = password;
        this.login = login;
        this.accountSettings = accountSettings;
        wallet = new Wallet();
        notes = new HashMap<>();
    }


    boolean addNote(String cryptoName, String content, String title) {
        if (content.length() <= 0 || content.length() > 1000 || title.length() <= 0 || title.length() > 150) {
            throw new IllegalArgumentException("Wrong arguments");
        }

        boolean isValidName = false;
        for (Cryptos c : Cryptos.values()) {
            if (c.name().equals(cryptoName)) {
                isValidName = true;
            }
        }

        if (!isValidName) {
            throw new NoSuchElementException();
        }


        Note note = new Note(title, content);
        boolean found = false;
        for (String name : notes.keySet()) {
            if (name.equals(cryptoName)) {
                notes.get(name).add(note);
                found = true;
            }
        }

        if (!found) {
            notes.put(cryptoName, new ArrayList<>());
            notes.get(cryptoName).add(note);
        }

        return true;
    }

    Map<String, List<Note>> getNotes() {
        return notes;
    }


    Wallet getWallet() {
        return wallet;
    }

    public AccountSettings getAccountSettings() {
        return accountSettings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
