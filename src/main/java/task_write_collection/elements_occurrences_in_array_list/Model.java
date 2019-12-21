package task_write_collection.elements_occurrences_in_array_list;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class demonstrates following Stream API functionality:
 * generating an Integer ArrayList and defining number
 * of this ArrayList elements occurrences.
 * Created by Bilous M. 20.12.2019
 */
public class Model {
    private int minBarrier;
    private int maxBarrier;
    private int listCapacity;
    private ArrayList<Integer> list;

    public Model(int minBarrier, int maxBarrier, int listCapacity) {
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
        this.listCapacity = listCapacity;
        list = getRandomIntList();
    }

    public Model() {
    }

    private ArrayList<Integer> getRandomIntList() {
        return Stream
                .generate(() -> minBarrier + (int) (Math.random() * (maxBarrier - minBarrier + 1)))
                .limit(listCapacity)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<Integer, Long> getNumberOfElementsOccurrences(ArrayList<Integer> input) {
        return input
                .stream()
                .collect(Collectors.groupingBy(m -> m, Collectors.counting()));
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}
