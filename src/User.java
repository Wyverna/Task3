import java.util.Scanner;

public class User {
    public int move;
	String[] movs;
	public User(String[] args)
	{
		movs=args;
	}
    public void getMove() {
        try {
			do
			{
				if(move!=0)
					System.out.println("Invalid move");
				System.out.println("Available moves");
				for (int i = 0; i < movs.length; i++) {
					System.out.println(i + 1 + "-" + movs[i]);
				}
				System.out.println("0 - exit");
				move= new Scanner(System.in).nextInt();
			} while(move<=0 && move>=movs.length);
			move=move-1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	public void equals(Computer computer)
	{
		System.out.println("Your move: "+movs[move]);
		System.out.println("Computer move: "+movs[computer.move]);
		int p = (movs.length-1)/2;
		for(int f=1;f<=p;f++) {
			if (computer.move == (move+f)%movs.length) {
				System.out.println("You win");
				return;
			}
		}
		if(computer.move==move)
			System.out.println("Draw");
		else
			System.out.println("You lose");
	}
}

