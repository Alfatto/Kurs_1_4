import java.lang.reflect.Array;
import java.util.*;

public class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        byte [] hash = key.getBytes();
        int ind = 0;
        for(byte b : hash) {
            ind += b;
        }
        return ind % size;
    }

    public boolean isKey(String key)
    {
        int ind = hashFun(key);
        if (slots[ind] != null) {
            return slots[ind].equals(key);
        }
        return false;
    }

    public void put(String key, T value)
    {
        int ind = hashFun(key);
        slots[ind] = key;
        values[ind] = value;
    }

    public T get(String key)
    {
        int ind = hashFun(key);
        if (slots[ind] != null) {
            if (slots[ind].equals(key)) {
                return values[ind];
            }
        }
        return null;
    }
}