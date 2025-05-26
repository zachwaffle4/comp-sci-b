/**
 * Name: Zach Harel
 * Project: Hashing Inventory Lab
 * File: Main
 */

import hashing.Inventory;

import java.io.*;
import java.util.Random;
import java.util.List;
import java.util.Scanner;

void main() {
    try {
        Inventory inventory = createInventory();
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID: ");
        int key = scanner.nextInt();
        int value = inventory.get(key);
        while (value < 0) {
            System.out.println("There is no such ID");
            System.out.print("ID: ");
            key = scanner.nextInt();
            value = inventory.get(key);
        }

        System.out.println(STR."Amount of ID \{key}: \{value}");

        System.out.println(STR."Percent nulls: \{inventory.percentNulls()}");
        System.out.println(STR."Average list length: \{inventory.averageLength()}");
        System.out.println(STR."Longest list length: \{inventory.longestLength()}");
    } catch (IOException e) {
        System.out.println(e);
    }
}

Inventory createInventory() throws FileNotFoundException {
    Inventory inventory = new Inventory();

    BufferedReader reader = new BufferedReader(new FileReader("src/hashing/file400.txt"));
    List<String> lines = reader.lines().limit(400).toList();

    for (String line : lines) {
        String[] split = line.split(" ");
        inventory.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    return inventory;
}

void generateRandomFile(int amt, int idRange, int valRange) throws IOException {
    List<Integer> ids = new Random().ints(0, idRange+1)
            .distinct()
            .limit(amt)
            .boxed()
            .toList();

    BufferedWriter writer = new BufferedWriter(new FileWriter("src/hashing/file400.txt"));

    for (int i : ids) {
        writer.write(STR."\{i} \{(int) (Math.random() * valRange) + 1}\n");
    }

    writer.close();
}

/* EXAMPLE OUTPUT
ID: 1234
There is no such ID
ID: 4321
There is no such ID
ID: 8911
Amount of ID 8911: 96
Percent nulls: 36.75
Average list length: 1.5810276679841897
Longest list length: 5
 */