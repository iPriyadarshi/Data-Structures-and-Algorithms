import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.AbstractMap.SimpleEntry;

/**
 * Time Complexity:
 * - Constructor: O(n log n) where n is the length of input arrays (due to
 * TreeSet operations)
 * - changeRating: O(log n) for TreeSet removal and insertion
 * - highestRated: O(1) as we're just getting the first element from TreeSet
 *
 * Space Complexity:
 * - O(n) where n is the number of foods
 * - Uses three maps:
 * - food_rating: O(n)
 * - food_cuisine: O(n)
 * - cuisine_ratings_food: O(n)
 */
class FoodRatings {
    // Map to store food name and its rating
    private Map<String, Integer> food_rating = new HashMap<>();

    // Map to store food name and its cuisine type
    private Map<String, String> food_cuisine = new HashMap<>();

    // Map to store cuisine and its foods sorted by ratings (TreeSet)
    // Using SimpleEntry where Key = -rating (negative for descending order), Value
    // = food name
    private Map<String, TreeSet<SimpleEntry<Integer, String>>> cuisine_ratings_food = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; ++i) {
            // Store food-rating mapping
            food_rating.put(foods[i], ratings[i]);
            // Store food-cuisine mapping
            food_cuisine.put(foods[i], cuisines[i]);

            // For each cuisine, maintain a sorted set of foods based on ratings
            cuisine_ratings_food
                    .computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                        // Custom comparator for TreeSet
                        // First compare by rating (stored as negative for descending order)
                        int compareByRating = Integer.compare(a.getKey(), b.getKey());
                        if (compareByRating == 0) {
                            // If ratings are equal, compare by food name lexicographically
                            return a.getValue().compareTo(b.getValue());
                        }
                        return compareByRating;
                    }))
                    // Add entry with negative rating (for descending order) and food name
                    .add(new SimpleEntry<>(-ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        // Get the cuisine of the food
        String cuisineName = food_cuisine.get(food);
        // Get the TreeSet for that cuisine
        TreeSet<SimpleEntry<Integer, String>> cuisineSet = cuisine_ratings_food.get(cuisineName);

        // Create entry with old rating to remove from TreeSet
        SimpleEntry<Integer, String> oldElement = new SimpleEntry<>(-food_rating.get(food), food);
        cuisineSet.remove(oldElement);

        // Update food rating in the map
        food_rating.put(food, newRating);
        // Add new entry with updated rating to TreeSet
        cuisineSet.add(new SimpleEntry<>(-newRating, food));
    }

    public String highestRated(String cuisine) {
        // Get first element from TreeSet (highest rated due to negative rating storage)
        SimpleEntry<Integer, String> highestRated = cuisine_ratings_food.get(cuisine).first();
        // Return the food name
        return highestRated.getValue();
    }
}