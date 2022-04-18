import java.util.*;

public class Queue<T> {
    ArrayList<T> array;

    public Queue() {
        // инициализация внутреннего хранилища очереди
        array = new ArrayList<>();
    }


    public void enqueue(T item) {
        // вставка в хвост
        array.add((T) item);
        for (int i = 1; i < array.size(); i++) {
            array.set(array.size() - i, array.get(array.size() - i - 1));
        }

        if (array.size() > 1) {
            array.set(0, (T) item);
        }
    }

    public T dequeue() {
        T result;
        // выдача из головы
        if (array.size() > 0) {
            result = array.get(array.size() - 1);
            array.remove(array.size() - 1);
        } else {
            result = null;
        }
        return result; // null если очередь пустая
    }

    public int size() {
        return array.size(); // размер очереди
    }

    @Override
    public String toString() {
        return "Queue{" +
                "array=" + array +
                '}';
    }
}