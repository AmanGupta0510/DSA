// Question_Name - Design Twitter
// Problem_Link  - https://leetcode.com/problems/design-twitter/
// PlatForm - LeetCode


class Twitter {
    private class Pair{
        int tweet;
        int day;
        public Pair(int tweet,int day){
            this.tweet = tweet;
            this.day = day;
        }  
    }
    HashMap<Integer,Set<Integer>> followerList;
    HashMap<Integer,List<Pair>> tweetPosted; 
    int days; 
    public Twitter() {
        this.followerList = new HashMap<>();
        this. tweetPosted = new HashMap<>();
        this.days = 0;
        Pair p = new Pair(0,0);
    }
    
    public void postTweet(int userId, int tweetId) {
        
        // here, we put every tweet of user in a key:value pair where,value contains the list of tweet done by specific user with day like ex: 1:[<5,1>,<6,2>,<3,9>] -> (<tweetId,day>)
        days+=1;
        if(tweetPosted.containsKey(userId)){
            List<Pair> temp = tweetPosted.get(userId);
            temp.add(new Pair(tweetId,days));
            tweetPosted.put(userId,temp);
        }
        else{
            List<Pair> temp = new ArrayList<>();
            temp.add(new Pair(tweetId,days));
            tweetPosted.put(userId,temp);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.day-a.day);
        // get all the tweet of user first 
        if(tweetPosted.containsKey(userId)){
            for(Pair p : tweetPosted.get(userId)){
                pq.offer(p);
            }

        }
        // get all the tweet of user's followee
        if(followerList.containsKey(userId)){
            for(Integer i: followerList.get(userId)){
                if(tweetPosted.containsKey(i)){
                    for(Pair p : tweetPosted.get(i)){
                        pq.offer(p);
                    }  
                }     
            }

        }
        int k = 10;
        List<Integer> res = new ArrayList<>();
        // fetch atmost 10 days recent tweet of user.
        while(!pq.isEmpty() && k-->0){
            res.add(pq.poll().tweet);
        }
        return res;
       
    }
       
    public void follow(int followerId, int followeeId) {
        // here, we put user and its following in a key:value pair where value contains Set of distinct following user owned. 
        if(!followerList.containsKey(followerId)){
            Set<Integer> temp = new HashSet<>();
            temp.add(followeeId);
            followerList.put(followerId,temp);
        }
        else{
            Set<Integer> temp = followerList.get(followerId);
            temp.add(followeeId);
            followerList.put(followerId,temp);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if(followerList.containsKey(followerId)){
            Set<Integer> temp = followerList.get(followerId);
            temp.remove(Integer.valueOf(followeeId));
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */