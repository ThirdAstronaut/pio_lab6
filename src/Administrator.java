import java.math.BigDecimal;
import java.util.Date;

public class Administrator extends User {

    private BigDecimal salary;

    public Administrator(String surname, String name, String IDCardNo, String PESELno, int role, Date registerDate, int age, BigDecimal salary) {
        super(surname, name, IDCardNo, PESELno, role, registerDate, age);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal giveBonus(int percentValue) throws IllegalArgumentException{
        if (percentValue < 0)
            throw new IllegalArgumentException("Percent can't be negative!");
            salary = salary.add(BigDecimal.valueOf(percentValue).multiply(salary).divide(BigDecimal.valueOf(100)));
        return salary;
    }
}
