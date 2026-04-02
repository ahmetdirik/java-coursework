
import java.util.Objects;

public class LinearProbingHashTable<K, V> {
    static class Entry<K, V> {
        K key; V value;
        boolean isOccupied = false;
        boolean isDeleted = false;
    }

    private Entry<K, V>[] table;
    private int size = 0;
    private int capacity;
    public long totalPutProbes = 0;
    public int maxProbeLength = 0;

    @SuppressWarnings("unchecked")
    public LinearProbingHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        for (int i = 0; i < capacity; i++) table[i] = new Entry<>();
    }

    private int hash(K key) { return Math.abs(key.hashCode()) % capacity; }

    public void put(K key, V value) {
        int pos = hash(key);
        int currentProbes = 0;
        int firstDeleted = -1;

        while (table[pos].isOccupied) {
            if (table[pos].isDeleted) {
                if (firstDeleted == -1) firstDeleted = pos;
            } else if (Objects.equals(table[pos].key, key)) {
                table[pos].value = value;
                return;
            }
            pos = (pos + 1) % capacity;
            currentProbes++;
            if (currentProbes >= capacity) return;
        }
        int targetPos = (firstDeleted != -1) ? firstDeleted : pos;
        table[targetPos].key = key; 
        table[targetPos].value = value;
        table[targetPos].isOccupied = true; 
        table[targetPos].isDeleted = false;
        size++;
        
        totalPutProbes += currentProbes;
        if (currentProbes > maxProbeLength) maxProbeLength = currentProbes;
    }

    public V get(K key) {
        int pos = hash(key);
        int start = pos;
        while (table[pos].isOccupied) {
            if (!table[pos].isDeleted && Objects.equals(table[pos].key, key)) return table[pos].value;
            pos = (pos + 1) % capacity;
            if (pos == start) break;
        }
        return null;
    }

    public boolean contains(K key) { return get(key) != null; }

    public void remove(K key) {
        int pos = hash(key);
        while (table[pos].isOccupied) {
            if (!table[pos].isDeleted && Objects.equals(table[pos].key, key)) {
                table[pos].isDeleted = true;
                size--; return;
            }
            pos = (pos + 1) % capacity;
        }
    }

    public int size() { return size; }
}