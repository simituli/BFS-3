// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String curr = q.poll();
                if(isValid(curr))
                {
                    //set.add(curr);
                    result.add(curr);
                    flag = true;
                }
                else if(!flag)
                {
                    for(int k=0; k<curr.length();k++)
                    {
                        if(Character.isAlphabetic(curr.charAt(k)))
                        {
                            continue;
                        }
                        String baby = curr.substring(0,k)+curr.substring(k+1);
                        if(!set.contains(baby))
                        {
                            set.add(baby);
                            q.add(baby);
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String str)
    {
        int count =0;
        for(char s: str.toCharArray())
        {
            if(s=='(')
            {
                count++;
            }
            else if(s==')')
            {
                count--;
            }
            if(count==-1) return false;
        }
        return count==0;
    }
}
// Your code here along with comments explaining your approach
