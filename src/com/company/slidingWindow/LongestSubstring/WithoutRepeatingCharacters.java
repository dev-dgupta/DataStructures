package com.company.slidingWindow.LongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class WithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty())
            return 0;
        int left=0,right=0,maxLen=0;
        Set<Character> uniqueSet=new HashSet<>();
        int len=0;
        while(left<=right && right<s.length()){
            if(uniqueSet.add(s.charAt(right))){
                len=right-left+1;
                right++;
            } else{
                uniqueSet.remove(s.charAt(left));
                left++;
            }
            maxLen=(maxLen>len)?maxLen:len;
        }

        return maxLen;
    }
}
