
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;
public class Computer {
    public int move;
	public byte[] key;
	public String[] moves;
	private byte[] digest(byte[] input) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA3-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = messageDigest.digest(input);
        return result;
    }
	
	public Computer(String[] moves)
	{
		SecureRandom random = new SecureRandom();
		key=new byte[32];
		this.moves = moves;
		random.nextBytes(key);
	}
	
    public void getMove()
    {
      move =  ThreadLocalRandom.current().nextInt(0, moves.length);
      byte[] message = ByteBuffer.allocate(moves[move].getBytes().length+key.length).put(moves[move].getBytes())
              .put(key).array();
	  byte[] result = digest(message);
      System.out.println("HMAC "+Main.ByteToHex(result));
    }
}
