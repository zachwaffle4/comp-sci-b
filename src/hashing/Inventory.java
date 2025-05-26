/**
 * Name: Zach Harel
 * Project: Hashing Inventory Lab
 * File: Inventory
 */

package hashing;

import java.util.*;
import java.util.stream.Collectors;

public class Inventory {
    private final ArrayList<LinkedList<InventoryEntry>> arr;

    public Inventory() {
        arr = new ArrayList<>(400);

        for (int i = 0; i < 400; i++) {
            arr.add(null);
        }
    }

    static class InventoryEntry {
        public final int key;
        public final int value;

        public InventoryEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return STR."\{key}: \{value}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InventoryEntry that = (InventoryEntry) o;
            return key == that.key;
        }
    }

    @Override
    public String toString() {
        return arr.stream()
                .filter(Objects::nonNull)
                .map(AbstractCollection::toString)
                .collect(Collectors.joining(", "));
    }

    public String toStringWithKeys() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int index = 0; index < arr.size(); index++) {
            LinkedList<InventoryEntry> values = arr.get(index);
            result.append(index).append(": ").append(values).append(", ");
        }
        return result.append("]").toString();
    }

    public int get(int id) {
        int hash = hashId(id);
        if (arr.get(hash) == null) return -1;
        return search(hash, id);
    }

    public int search(int hash, int key) {
        for (InventoryEntry entry: arr.get(hash)) {
            if (entry.key == key) return entry.value;
        }
        return -1;
    }

    public void put(int id, int value) {
        int hash = hashId(id);
        if (arr.get(hash) == null) {
            arr.set(hash, new LinkedList<>());
        }

        arr.get(hash).add(new InventoryEntry(id, value));
    }

    public static int hashId(int id) {
        String lnd = String.valueOf(Math.log(id));
        return Integer.parseInt(lnd.substring(lnd.indexOf(".") + 1).substring(0, 4)) % 400;
    }

    public double percentNulls() {
        return (arr.stream().filter(Objects::isNull).count() / 400.0) * 100;
    }

    public double averageLength() {
        return (double) (arr.stream()
                .filter(Objects::nonNull)
                .map(LinkedList::size)
                .mapToInt(Integer::valueOf)
                .sum()) / arr.stream()
                .filter(Objects::nonNull)
                .count();
    }

    public int longestLength() {
        return arr.stream()
                .filter(Objects::nonNull)
                .map(LinkedList::size)
                .sorted()
                .toList()
                .getLast();
    }

    public int usedKeys() {
        return (int) arr.stream().filter(Objects::nonNull).count();
    }
}
