import java.util.Collection;
import java.util.HashMap;

public class ComparisonService {
    private HashMap<String, Comparison> comparisons;

    public ComparisonService(){
        this.comparisons = new HashMap<String, Comparison>();
    }

    public <T extends Comparable> void compare(Iterable<T> a1, Iterable<T> a2){
        for(T item : a1){
            Comparison conceptComparison = new Comparison();
            conceptComparison.setScoreA(item.getScore());
            this.getComparisons().put(item.getLabel(), conceptComparison);
        }
        for(T item : a2){
            Comparison conceptComparison = getComparisons().get(item.getLabel());
            if(conceptComparison == null)
                conceptComparison = new Comparison();
            conceptComparison.setScoreB(item.getScore());
        }
    }

    public void stringCompare(Collection<String> a1, Collection<String> a2) {
        for(String item : a1){
            Comparison comparison = new Comparison();
            comparison.setScoreA(1);
            comparisons.put(item, comparison);
        }
        for(String item : a2){
            Comparison comparison = comparisons.get(item);
            if(comparison == null)
                comparison = new Comparison();
            comparison.setScoreB(1);
        }
    }

    public void stringCompare(String a1, String a2) {

    }

    public HashMap<String, Comparison> getComparisons() {
        return comparisons;
    }
}
