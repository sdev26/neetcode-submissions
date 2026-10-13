class Twitter {
    public static class Tweet{
        int tweetid,time;
        Tweet(int tweetid,int time){
            this.tweetid=tweetid;
            this.time=time;
        }

    }
    public static class FeedEntry{
        int userId,index;
        FeedEntry(int userId,int index){
            this.userId=userId;
            this.index=index;
        }
    }
    HashMap<Integer,List<Tweet>>tweetsByUser;
    HashMap<Integer,HashSet<Integer>>followingByUser;
    int timestamp;
    public Twitter() {
        tweetsByUser=new HashMap<>();
        followingByUser=new HashMap<>();
        timestamp=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetsByUser.containsKey(userId)){
            tweetsByUser.put(userId,new ArrayList<>() );
        }
        tweetsByUser.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

      Set<Integer> usersToCheck = new HashSet<>();

    if (followingByUser.containsKey(userId)) {
        usersToCheck.addAll(followingByUser.get(userId));
    }
        usersToCheck.add(userId);

        PriorityQueue<FeedEntry> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    Tweet tweetA = tweetsByUser.get(a.userId).get(a.index);
                    Tweet tweetB = tweetsByUser.get(b.userId).get(b.index);
                    return Integer.compare(tweetB.time, tweetA.time);
                }
        );
        for (int user : usersToCheck) {
            List<Tweet> tweets = tweetsByUser.get(user);

            if (tweets != null && !tweets.isEmpty()) {
                maxHeap.offer(new FeedEntry(user, tweets.size() - 1));
            }
        }
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            FeedEntry current = maxHeap.poll();
            List<Tweet> userTweets = tweetsByUser.get(current.userId);

            feed.add(userTweets.get(current.index).tweetid);
            if (current.index > 0) {
                maxHeap.offer(new FeedEntry(current.userId, current.index - 1));
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followingByUser.containsKey(followerId)){
            followingByUser.put(followerId, new HashSet<>());
        }
        followingByUser.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followingByUser.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    
    }
}
