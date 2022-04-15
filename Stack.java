
import java.util.*;

public class Stack<T> {

    ArrayList<T> array;

    public Stack() {
        array = new ArrayList<>();
    }

    public int size() {
        return array.size();
    }

    public T pop() {
        T result;
        if (array.size() > 0) {
            result = array.get(0);
            array.remove(result);
        } else {
            result = null;
        }
        return result;
    }

    public void push(T val) {
        if (array.size() == 0) {
            array.add(val);
        } else {
            array.add(val);
            int j = array.size();
            for (int i = 1; i < j; i++) {
                array.set(array.size() - i, array.get(array.size() - i - 1));
            }
            array.set(0, val);
        }
    }

    public T peek() {
        T result;
        if (array.size() > 0) {
            result = array.get(0);
        } else {
            result = null;
        }
        return result;
    }
}