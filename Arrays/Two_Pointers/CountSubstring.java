package Arrays.Two_Pointers;

class Solution {
    public static int countSubstring(String s) {
        // code here
        int x = -1;
        int y = -1;
        int z = -1;
        int ans = 0;
        for(int i= 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a')x = i;
            else if(ch == 'b')y = i;
            else z = i;
            int min = Math.min(x,Math.min(y,z));
            if(min!=-1)ans+=min+1;
            
        }
        return ans;
    }
}

