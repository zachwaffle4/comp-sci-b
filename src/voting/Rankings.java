package voting;

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rankings {
    public final String[] categories;

    public final List<Map<String, Integer>> maleEntrants;
    public final List<Map<String, Integer>> femaleEntrants;

    private final List<List<String>> maleRankings;
    private final List<List<String>> femaleRankings;

    public Rankings(String[] categories, List<Map<String, Integer>> maleEntrants, List<Map<String, Integer>> femaleEntrants) {
        this.categories = categories;
        this.maleEntrants = maleEntrants;
        this.femaleEntrants = femaleEntrants;

        maleRankings = new ArrayList<>(categories.length);
        femaleRankings = new ArrayList<>(categories.length);

        for (int i = 0; i < categories.length; i++) {
            maleRankings.add(null);
            femaleRankings.add(null);
        }
    }

    public Rankings(String catPath, String malePath, String femalePath) throws FileNotFoundException {
        List<Map<String, Integer>> maleEntrants = new ArrayList<>();
        List<Map<String, Integer>> femaleEntrants = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(catPath));
        String[] categories = reader.lines()
                .map(line -> line.trim()
                        .replace("\"", "")
                        .replace(",", "")
                ).toArray(String[]::new);

        for (int i = 0; i < categories.length; i++) {
            maleEntrants.add(new HashMap<>());
            femaleEntrants.add(new HashMap<>());
        }

        reader = new BufferedReader(new FileReader(malePath));
        reader.lines().forEach(line -> {
            if (!line.isBlank()) {
                extractNamesFromLine(line, maleEntrants);
            }
        });

        reader = new BufferedReader(new FileReader(femalePath));
        reader.lines().forEach(line -> {
            if (!line.isBlank()) {
                extractNamesFromLine(line, femaleEntrants);
            }
        });

        this(categories, maleEntrants, femaleEntrants);
    }

    private static void extractNamesFromLine(String line, List<Map<String, Integer>> list) {
        String[] names = line.split(",");
        if (names.length >= 16) {
            addNamesToList(names, list);
        }
    }

    private static void addNamesToList(String[] names, List<Map<String, Integer>> list) {
        for (int i = 0; i < 16; i++) {
            if (!names[i].isBlank()) {
                names[i] = swapNames(names[i]);

                list.get(i).put(names[i], list.get(i).getOrDefault(names[i], 0) + 1);
            }
        }
    }

    @Contract(pure = true)
    private static String swapNames(String name) {
        String[] names = name.split(" ");
        if (names.length == 2) {
            return STR."\{names[1]} \{names[0]}";
        } else {
            return name;
        }
    }

    public List<String> getMaleRankings(int category) {
        return cacheAndSort(category, maleRankings, maleEntrants, categories);
    }

    public List<String> getFemaleRankings(int category) {
        return cacheAndSort(category, femaleRankings, femaleEntrants, categories);
    }

    public List<String> getMaleTop3(int category) {
        List<String> rankings = getMaleRankings(category);
        return rankings.subList(0, Math.min(3, rankings.size()));
    }

    public List<String> getFemaleTop3(int category) {
        List<String> rankings = getFemaleRankings(category);
        return rankings.subList(0, Math.min(3, rankings.size()));
    }

    private static List<String> cacheAndSort(int category, List<List<String>> resultList, List<Map<String, Integer>> entrantList, String[] categories) {
        if (category < 0 || category >= categories.length) {
            throw new IllegalArgumentException("Invalid category index");
        }

        if (resultList.get(category) == null) {
            resultList.set(category, entrantList.get(category).entrySet().stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .map(Map.Entry::getKey)
                    .toList());
        }

        return resultList.get(category);
    }
}
