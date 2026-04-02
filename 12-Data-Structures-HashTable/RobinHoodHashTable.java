
import java.util.Objects;

public class RobinHoodHashTable<K, V> {
    static class Entry<K, V> {
        K key; V value;
        int psl = -1;
        boolean isOccupied = false;
    }

    private Entry<K, V>[] table;
    private int size = 0;
    private int capacity;
    public long totalPutProbes = 0;
    public int maxProbeLength = 0;

    @SuppressWarnings("unchecked")
    public RobinHoodHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        for (int i = 0; i < capacity; i++) table[i] = new Entry<>();
    }

    private int hash(K key) { return Math.abs(key.hashCode()) % capacity; }

    public void put(K key, V value) {
        int pos = hash(key);
        K currK = key; V currV = value;
        int currPsl = 0;

        while (true) {
            if (!table[pos].isOccupied) {
                table[pos].key = currK; table[pos].value = currV;
                table[pos].psl = currPsl; table[pos].isOccupied = true;
                size++;
                if (currPsl > maxProbeLength) maxProbeLength = currPsl;
                return;
            }
            if (Objects.equals(table[pos].key, currK)) {
                table[pos].value = currV; return;
            }
            if (currPsl > table[pos].psl) {
                K tempK = table[pos].key; V tempV = table[pos].value; int tempPsl = table[pos].psl;
                table[pos].key = currK; table[pos].value = currV; table[pos].psl = currPsl;
                currK = tempK; currV = tempV; currPsl = tempPsl;
            }
            pos = (pos + 1) % capacity;
            currPsl++;
            totalPutProbes++;
        }
    }

    public V get(K key) {
        int pos = hash(key);
        int currPsl = 0;
        while (table[pos].isOccupied) {
            if (currPsl > table[pos].psl) return null;
            if (Objects.equals(table[pos].key, key)) return table[pos].value;
            pos = (pos + 1) % capacity;
            currPsl++;
        }
        return null;
    }

    public boolean contains(K key) { return get(key) != null; }

    public void remove(K key) {
        int pos = hash(key);
        int currPsl = 0;
        while (table[pos].isOccupied) {
            if (currPsl > table[pos].psl) return;
            if (Objects.equals(table[pos].key, key)) {
                int next = (pos + 1) % capacity;
                while (table[next].isOccupied && table[next].psl > 0) {
                    table[pos].key = table[next].key;
                    table[pos].value = table[next].value;
                    table[pos].psl = table[next].psl - 1;
                    pos = next;
                    next = (next + 1) % capacity;
                }
                table[pos].isOccupied = false;
                table[pos].key = null; table[pos].psl = -1;
                size--; return;
            }
            pos = (pos + 1) % capacity;
            currPsl++;
        }
    }

    public int size() { return size; }
}