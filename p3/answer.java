import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Kadane's MCS algo repurposed (probably pretty good because O(n))
        //Keep an array of seen characters and a max
        //if the char never seen, add to sum and keep going.
        //if we ever find a char we've seen, then the sum is ruined and we have to start
        //at the letter right after the first index of that found letter.
        int max = 0;
        int sum = 0;
        int pointer = 0;
        int preIndex = 0;
        String str = s;
        Hashtable<String, Integer> seen = new Hashtable<String, Integer>();
        while (pointer < str.length()){
            //not in our max contig. length
            if (seen.containsKey(str.substring(pointer, pointer+1)) == false){
                seen.put(str.substring(pointer, pointer+1), pointer);
                pointer++;
                sum++;
                if(sum > max){max = sum;}
            }
            else{
                //if seen, go to where it was first seen and restart from the letter after.
                preIndex = seen.get(str.substring(pointer, pointer+1));
                seen.clear();
                pointer = preIndex+1;
                str = str.substring(pointer);
                seen.put(str.substring(0, 1), 0);
                sum = 1;
                pointer = 1;
            }
        }
        return max;
    }
}
