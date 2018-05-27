public class Cryptocurrency {

private Cryptos name;
private Double value;

    Cryptocurrency(Cryptos name, Double value) {
        this.name = name;
        this.value = value;
    }

    Cryptos getName() {
        return name;
    }

    public void setName(Cryptos name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
