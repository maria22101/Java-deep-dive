package reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * The class checks the default capacity of java.util.ArrayList class
 * and how the capacity is increased
 */
public class SimpleArrayListCapacity {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(getArrayCapacity(arrayList)); // zero when ArrayList object has just been created

        arrayList.add(1);
        System.out.println(getArrayCapacity(arrayList)); // once an element is added to the ArrayList -> capacity becomes 10

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println(getArrayCapacity(arrayList)); // when number of the array elements exceeds the capacity -> capacity gets increased *1.5 => 15
    }

    static int getArrayCapacity(ArrayList<?> al) throws NoSuchFieldException, IllegalAccessException {
        // Object[] elementData - a field of ArrayList class.
        // This field is responsible for the array buffer in which the elements of the ArrayList are stored.
        // The capacity of the ArrayList is the length of this array buffer

        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true); // setting this field's modifier to "public"

        return ((Object[]) dataField.get(al)).length;
    }
}
