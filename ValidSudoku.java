import java.util.HashSet;

public class ValidSudoku {
	
	public boolean isValidSudoku(char[][] board) {
		boolean isValid = true;
		
		
		HashSet<Character>[] rows = new HashSet[9];
		HashSet<Character>[] cols = new HashSet[9];
		HashSet<Character>[] boxes = new HashSet[9];
		
		 for (int r = 0; r < 9; r++) {
	            rows[r] = new HashSet<Character>();
	            cols[r] = new HashSet<Character>();
	            boxes[r] = new HashSet<Character>();
	     }
		
		
		for(int i=0;i<board.length;i++) {
			
			
			for(int j=0;j<board.length;j++) {
				
				if(board[i][j] == '.') {
					continue;
				}
				
				
				if(!rows[i].contains(board[i][j])) {
					rows[i].add(board[i][j]);
				}
				else {
					return false;
				}
				
				if(!cols[j].contains(board[i][j])) {
					cols[j].add(board[i][j]);
				}
				else {
					return false;
				}
				
				int id = (i/3)*3 + j/3;
				if(!boxes[id].contains(board[i][j])) {
					boxes[id].add(board[i][j]);
				}
				else {
					return false;
				}
				
				
			}
		}
		
		return isValid;
    }
	
	public static void main(String []args) {
		ValidSudoku v = new ValidSudoku();
		char [][]board = {{'5','3','.','.','7','.','.','.','.'}
						,{'6','.','.','1','9','5','.','.','.'}
						,{'.','9','8','.','.','.','.','6','.'}
						,{'8','.','.','.','6','.','.','.','3'}
						,{'4','.','.','8','.','3','.','.','1'}
						,{'7','.','.','.','2','.','.','.','6'}
						,{'.','6','.','.','.','.','2','8','.'}
						,{'.','.','.','4','1','9','.','.','5'}
						,{'.','.','.','.','8','.','.','7','9'}};
		
		v.isValidSudoku(board);
	}
}
