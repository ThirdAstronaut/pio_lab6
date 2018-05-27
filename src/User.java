import java.util.Date;

public class User {

    private String surname;
    private String name;
    private String IDCardNo;
    private String PESELno;
    private int role;
    private Date registerDate;
    private String phoneNo;
    private String email;
    private int age;

    public User() {

    }

    User(String surname, String name, String IDCardNo, String PESELno, int role, Date registerDate, int age) {
        this.surname = surname;
        this.name = name;
        this.IDCardNo = IDCardNo;
        this.PESELno = PESELno;
        this.role = role;
        this.registerDate = registerDate;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname.length() > 0 && surname.length() < 150)
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDCardNo() {
        return IDCardNo;
    }

    public void setIDCardNo(String IDCardNo) {

        if(IDCardNo.length() == 8)
        this.IDCardNo = IDCardNo;
    }

    public String getPESELno() {
        return PESELno;
    }

    public void setPESELno(String PESELno) {

        if(PESELno.matches("\\d{11}"))
        this.PESELno = PESELno;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        if(phoneNo.matches("\\d{9}"))
            this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0 && age < 150)
            this.age = age;
        else
            throw new IllegalArgumentException();
    }
}
