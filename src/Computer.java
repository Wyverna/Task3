
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.nio.charset.StandardCharsets.US_ASCII;

public class Computer {
    public int move;
	public byte[] key;
	public String[] movs;
	private byte[] digest(byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA3-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }
	
	public Computer(String[] args)
	{
		SecureRandom random = new SecureRandom();
		key=new byte[32];
		movs = args;
		random.nextBytes(key);
	}
	
    public void getMove()
    {
      move =  ThreadLocalRandom.current().nextInt(0, movs.length);
      byte[] msg = ByteBuffer.allocate(movs[move].getBytes(US_ASCII).length+key.length).put(movs[move].getBytes(US_ASCII))
              .put(key).array();
	  byte[] result = digest(msg);
      System.out.println("HMAC "+Main.ByteToHex(result));
    }
}
