import java.util.HashMap;
import java.util.Map;

class Wallet {

    private Map<Cryptocurrency, Double> cryptos; //(nazwa, cena) , ilosc
    Wallet() {
        cryptos = new HashMap<>();
    }

    Map<Cryptocurrency, Double> getCryptos() {
        return cryptos;
    }

    boolean addCoinToWallet(Cryptocurrency cryptocurrency, Double amount){

        if(amount < 0.0000001 || amount > 10_000){
            return false;
        }

//        if(cryptos.keySet().forEach(i -> i.getName().equals(cryptocurrency.getName()) ? cryptos.get(i) += amount : cryptos.get(i) += 0) )

        boolean found = false;
        for(Cryptocurrency crypto : cryptos.keySet()) {
            if (crypto.getName().equals(cryptocurrency.getName())) {
                cryptos.put(crypto, cryptos.get(crypto) + amount);
                found = true;
            }
        }

        if(!found){
            cryptos.put(cryptocurrency, amount);
        }
        return true;

    }



}