import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(k <= 0) return false;

        Map<Integer, List<Integer>> pairs = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            List<Integer> l = pairs.get(nums[i]);

            if(l == null){
                l = new ArrayList<>();
                pairs.put(nums[i], l);
            } else {
                for(int j : l){
                    if(i - j <= k){
                        return true;
                    }
                }
            }

            l.add(i);
        }

        return false;
    }
}
