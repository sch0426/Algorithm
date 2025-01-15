import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[][] lines) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int[] line : lines) {
            for (int i = line[0]; i < line[1]; i++) {
                if (!set1.add(i)) {
                    set2.add(i);
                }
            }
        }

        return set2.size();
    }
}
