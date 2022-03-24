import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class User {
	Set <Integer> following = new HashSet<Integer>();
	Map <Integer, Integer> post = new HashMap<Integer, Integer>();
}
public class Twitter {

	Map<Integer,Integer> tweets;
	Map<Integer,Set<Integer>> follows;
	List<Integer> tweetList;

	public Twitter() {
		this.tweets = new HashMap<Integer,Integer>();
		this.follows = new HashMap<Integer,Set<Integer>>();
		this.tweetList = new ArrayList<Integer>();
	}

	public void postTweet(int userId, int tweetId) {
		this.tweets.put(tweetId,userId);
		this.tweetList.add(tweetId);
		this.follows.putIfAbsent(userId, new HashSet<Integer>());
		Set<Integer> followerSet = this.follows.get(userId);
		followerSet.add(userId);
	}

	public List<Integer> getNewsFeed(int userId) {
		List<Integer> fetchTweets = new ArrayList<Integer>();
		Set<Integer> followerSet = this.follows.get(userId);
		for(int i=this.tweetList.size()-1; i>=0; i--)
		{
			if(followerSet.contains(tweets.get(this.tweetList.get(i))))
			{
				fetchTweets.add(this.tweetList.get(i));
				if(fetchTweets.size()==10)
				{
					break;
				}
			}
		}
		return fetchTweets;
	}

	public void follow(int followerId, int followeeId) {
		this.follows.putIfAbsent(followerId, new HashSet<Integer>());
		Set<Integer> followerSet = this.follows.get(followerId);
		followerSet.add(followeeId);
	}

	public void unfollow(int followerId, int followeeId) {
		if(!this.follows.containsKey(followerId))
		{
			return;
		}
		Set<Integer> followerSet = this.follows.get(followerId);
		followerSet.remove(followeeId);
	}

	public static void main(String []args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
		twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
		twitter.follow(1, 2);    // User 1 follows user 2.
		twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
		twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		twitter.unfollow(1, 2);  // User 1 unfollows user 2.
		twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
	}

}
