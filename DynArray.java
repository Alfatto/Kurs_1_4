import java.util.*;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        // array = (T[]) Array.newInstance(this.clazz, new_capacity);
        // ваш код
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
        //если new емкость больше чем 16 то создаем новый массив и копируем в него старый
         if ((new_capacity > capacity)){
            T[] myArray = (T[]) new Integer[new_capacity];
            System.arraycopy(array, 0, myArray,0,capacity);
            array = myArray.clone();
            capacity = new_capacity;
        } else {
            T[] myArray = (T[]) new Integer[new_capacity];
            System.arraycopy(array, 0, myArray, 0, new_capacity - 1);
            array = myArray.clone();
            capacity = new_capacity;
        }

        if (capacity == 0) {
            capacity = new_capacity;
        } else if (count + 1 % 16 == 0) {
            capacity = (capacity * 2);
        }
    }

    public T getItem(int index)
    {
        // ваш код
        //проверяем на исключение
        if (index >= 0 && index < count) {
            return array[index];
        }
        else {
            throw new IllegalArgumentException("");
        }
    }

    public void append(T itm)
    {
        if (capacity == count) {
            this.makeArray(2 * capacity);
        }
        this.array[count] = itm;
        count++;
    }

    public void insert(T itm, int index)
    {
        if (!(index >= 0 && index <= count)) {
            throw new IllegalArgumentException("Illegal Argument: " + index);
        }
        if (capacity == count) {
            this.makeArray(2 * capacity);
        }
        for (int i = count; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = itm;
        count++;
    }

    public void remove(int index)
    {
        // ваш код
        //проверяем на исключение
        if (index > count || index < 0)
            throw new IllegalArgumentException ("индекс вне диапазона");

        for (int i = index; i < array.length - 1; i++){
            array[i] = array[i + 1];
        }
        array[count - 1] = null;
        count --;
        //проверяем нужно ли уменьшить capacity
        int new_capacity = (int) ((capacity * 1.0)/1.5);
        if (new_capacity < 16) {
            new_capacity = 16;
        }
        if (count < (capacity * 1.0)/2) {
            this.makeArray(new_capacity);
        }
    }
}