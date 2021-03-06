import java.util.*;

public class Deque<T> {
    ArrayList<T> deque;

    public Deque() {
        // инициализация внутреннего хранилища
        deque = new ArrayList<>();
    }

    public void addFront(T item) {
        // добавление в голову
        deque.add(item);
    }

    public void addTail(T item) {
        // добавление в хвост
        ArrayList<T> dequeCopy = new ArrayList<>();
        dequeCopy.add(0, item);
        dequeCopy.addAll(deque);
        deque = new ArrayList<>(dequeCopy);
        dequeCopy = null;

    }

   
    public T removeFront() {
        // удаление из головы
        if (deque.size() == 0)
            return null;

        return deque.remove(deque.size() - 1);
    }

    public T removeTail() {
        // удаление из хвоста
        if (deque.size() == 0)
            return null;

        return deque.remove(0);
    }

    public int size() {
        return deque.size();// размер очереди
    }
    
    @Override
    public String toString() {
        return "Deque{" +
                "deque=" + deque +
                '}';
    }
}