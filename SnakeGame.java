import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import javafx.util.*;

public class SnakeGame {

	int width;
	int height;
	int [][]food;
	int foodIndex;
	
	HashMap<Pair<Integer, Integer>, Boolean> snakeMap;
	Deque<Pair<Integer, Integer>> snake;

	public SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;

		this.snakeMap = new HashMap<Pair<Integer,Integer>, Boolean>();
		this.snakeMap.put(new Pair<Integer, Integer>(0,0), true);

		this.snake = new LinkedList<Pair<Integer,Integer>>();
		this.snake.offer(new Pair<Integer, Integer>(0, 0)); //Snake starting position

	}

	public int move(String direction) {

		Pair<Integer, Integer> snakeCell = this.snake.peekFirst(); //Peek in the queue to get the starting point
		int head    = snakeCell.getKey(); //Head 
		int tail = snakeCell.getValue(); //Tail

		switch(direction) {
		case "U":
			head--;
			break;
		case "D":
			head++;
			break;
		case "L":
			tail--;
			break;
		case "R":
			tail++;
			break;
		}

		Pair<Integer,Integer> newHead = new Pair<Integer, Integer>(head, tail);
		Pair<Integer,Integer> currentTail = this.snake.peekLast();

		//Boundary Conditions
		boolean crossBoundary1 = head < 0 || head >= this.height;
		boolean crossBoundary2 = tail < 0 || tail >= this.width;


		//Check if Snake Bite's itself
		boolean snakeBitesItself = this.snakeMap.containsKey(newHead) && 
				!(newHead.getKey() == currentTail.getKey() && newHead.getValue() == currentTail.getValue());

		// If any of the terminal conditions are satisfied, then we exit with rcode -1.
		if (crossBoundary1 || crossBoundary2 || snakeBitesItself) {
			return -1;
		}

		// If there's an available food item and it is on the cell occupied by the snake after the move,
		// eat it.
		if ((this.foodIndex < this.food.length)
				&& (this.food[this.foodIndex][0] == head)
				&& (this.food[this.foodIndex][1] == tail)) {
			this.foodIndex++;
		} 
		else 
		{
			this.snake.pollLast();
			this.snakeMap.remove(currentTail);
		}
		
		// A new head always gets added
	    this.snake.addFirst(newHead);

	    // Also add the head to the set
	    this.snakeMap.put(newHead, true);

	    return this.snake.size() - 1;
	}
	
	public static void main(String []args) {
		SnakeGame s = new SnakeGame(3, 2, new int[][] {{1, 2},{0,1}});
		s.move("R"); // return 0
		s.move("D"); // return 0
		s.move("R"); // return 1, snake eats the first piece of food. The second piece of food appears at (0, 1).
		s.move("U"); // return 1
		s.move("L"); // return 2, snake eats the second food. No more food appears.
		s.move("U"); // return -1, game over because snake collides with border
	}

}
