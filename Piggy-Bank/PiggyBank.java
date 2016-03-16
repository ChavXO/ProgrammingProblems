import java.util.HashMap;
import java.util.ArrayList;

// modelled as a graph problem?

public class PiggyBank {
    int totalweight; // weight of coins
    HashMap<Integer, Integer> coinWeights;
    
    public PiggyBank(int weight) {
        totalWeight  = weight;
        coinWeights = new HashMap<>();
    }

    public void addCoin(int value, int weight) {
        coinWeights.put(value, weight);
    }


}