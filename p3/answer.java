import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //divide and conquer strategy
        //int lmax = lengthOfLongestSubstring(s.substring(0, s.length()/2));
        //int rmax = lengthOfLongestSubstring(s.substring(s.length()/2 + 1));

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
        //ArrayList<Character> seen = new ArrayList<Character>();
        Hashtable<String, Integer> seen = new Hashtable<String, Integer>();
        while (pointer < str.length()){
            //preIndex = seen.indexOf(str.substring(pointer, pointer+1).charAt(0));
            //not in our max contig. length
            if (/*preIndex != -1*/ seen.containsKey(str.substring(pointer, pointer+1)) == false){
                //seen.add(str.substring(pointer, pointer+1).charAt(0));
                seen.put(str.substring(pointer, pointer+1), pointer);
                pointer++;
                sum++;
                if(sum > max){max = sum;}
            }
            else{
                //if seen, go to where it was first seen and restart from the letter after.
                //seen.removeAll(seen);
                preIndex = seen.get(str.substring(pointer, pointer+1));
                seen.clear();
                pointer = preIndex+1;
                str = str.substring(pointer);
                //seen.add(str.substring(0, 1).charAt(0));
                seen.put(str.substring(0, 1), 0);
                sum = 1;
                pointer = 1;
            }
        }
        return max;
    }
}
