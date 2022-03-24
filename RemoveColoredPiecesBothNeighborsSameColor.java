
public class RemoveColoredPiecesBothNeighborsSameColor {

	public boolean winnerOfGame(String colors) {
		int alice = 0, bob = 0;
		for(int i=0;i<colors.length()-2;i++){
			String sub = colors.substring(i,i+3);
			if(sub.equals("AAA"))
				alice++;
			if(sub.equals("BBB"))
				bob++;
		}
		if(alice>bob)
			return true;
		return false;
	}

	public static void main(String []args) {
		RemoveColoredPiecesBothNeighborsSameColor r = new RemoveColoredPiecesBothNeighborsSameColor();
		System.out.println(r.winnerOfGame("AAABABB"));
		System.out.println(r.winnerOfGame("AA"));
		System.out.println(r.winnerOfGame("ABBBBBBBAAA"));
	}

}
