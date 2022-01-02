
public class MyHashMap {

	ListNode[] entries;
	int len = 1000; //Assuming
	int size = 0;

	public MyHashMap() {
		this.entries = new ListNode[len];
		for(int i=0;i<len;i++) {
			this.entries[i] = new ListNode();
		}
	}

	private int getIndex(int key) {
		return key % len;
	}

	public void put(int key, int value) {
		int index = getIndex(key);
		ListNode temp = entries[index];

		while(temp!=null && temp.next!=null) { //Search the key in Linkedlist
			if(temp.key != null && temp.key == key){
				temp.val = value;
				return;
			}
			temp = temp.next; //Advance the pointer
		}

		temp.key = key;
		temp.val = value;
		temp.next = new ListNode();
		size++;
	}

	public int get(int key) {
		int index = getIndex(key);

		ListNode temp = entries[index];

		while(temp != null && temp.key != null){
			if(temp.key == key){
				return temp.val;
			}
			temp = temp.next;
		}

		return -1;
	}

	public void remove(int key) {
		int index = getIndex(key);

		ListNode dummy = new ListNode();
		dummy.next = entries[index];
		ListNode prev = dummy;
		ListNode cur = dummy.next;

		while(cur != null && cur.key != null){

			if(cur.key == key){
				prev.next = cur.next;
				entries[index] = dummy.next;
				return;
			}

			cur = cur.next;
			prev = prev.next;
		}
	}

	class ListNode
	{
		Integer key;
		Integer val;
		ListNode next;
	}

	public static void main(String []args) {
		MyHashMap myHashMap = new MyHashMap();
		System.out.println();
		myHashMap.put(1, 1); // The map is now [[1,1]]
		myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
		System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
		System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
		myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
		System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
		myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
		System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]

	}

}
