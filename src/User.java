import java.util.Scanner;

public class User {
    public int move;
	String[] moves;
	public User(String[] moves)
	{
		this.moves=moves;
	}
    public void getMove() {
        try {
			do
			{
				if(move!=0)
					System.out.println("Invalid move");
				System.out.println("Available moves");
				for (int i = 0; i < moves.length; i++) {
					System.out.println(i + 1 + "-" + moves[i]);
				}
				System.out.println("0 - exit");
				move= new Scanner(System.in).nextInt();
			} while(move<=0 && move>=moves.length-1);
			move=move-1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	public void equals(Computer computer)
	{
		System.out.println("Your move: "+moves[move]);
		System.out.println("Computer move: "+moves[computer.move]);
		int p = (moves.length-1)/2;
		for(int f=1;f<=p;f++) {
			if (computer.move == (move+f)%moves.length) {
				System.out.println("You lose");
				return;
			}
		}
		if(computer.move==move)
			System.out.println("Draw");
		else
			System.out.println("You win");
	}
}

