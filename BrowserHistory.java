

public class BrowserHistory {

	/**
	 * Double LinkList
	 * @author zia84
	 *
	 */
	class Node 
	{
		Node prev;
		Node next;

		String url;

		Node(String url){
			this.url = url;
		}
	}

	Node curr;

	public BrowserHistory(String homePage) {
		this.curr = new Node(homePage);
	}

	public void visit(String url) {
		Node newNode = new Node(url); //Create New Node
		this.curr.next = newNode; //Next
		newNode.prev = this.curr; //Previous
		this.curr = this.curr.next; //Advance Current Node
	}

	public String back(int steps) {
		while(this.curr!=null && this.curr.prev!=null && steps-- > 0) { //Go Back till steps are not reached zero 
			this.curr = this.curr.prev;
		}
		return this.curr.url;
	}

	public String forward(int steps) {
		while(this.curr!=null && this.curr.next!=null && steps-- > 0) { //Go Forward 
			this.curr = this.curr.next;
		}
		return this.curr.url;
	}

	public static void main(String []args) {
		int count = 10;
		while(count-- > 0) {
			System.out.println(count);
		}

		BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
		browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
		browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
		browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
		browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
		browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
		browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
		browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
		browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
		browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
		browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
	}

}
