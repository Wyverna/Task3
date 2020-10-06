import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void checkQuantity(String[] args) throws Exception
	{
		if(args.length % 2 == 0 || args.length <=1)
		{
			throw new Exception("Wrong number parameters");
		}
	}
	public static void checkUnique(String[] args) throws Exception
	{
		Map<String, Integer> map = new HashMap<>();
		for (String arg : args)
		{
			if (!map.containsKey(arg)) map.put(arg, 1);
			else map.put(arg, map.get(arg) + 1);
		}
		List<String> duplicates = map.entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e -> e.getKey()).collect(Collectors.toList());
		if(duplicates.size()>0) throw new Exception("Params don't unique");
	}
	public static String ByteToHex(byte[] result)
	{

		StringBuilder s = new StringBuilder();
		for (byte b : result) {
			s.append(String.format("%02x", b));
		}
		return s.toString();
	}
    public static void main(String[] args) {
		try {
			checkQuantity(args);
			checkUnique(args);
			User user = new User(args);
			Computer computer = new Computer(args);
			computer.getMove();
			user.getMove();
			if(user.move!=-1) {
				user.equals(computer);

				System.out.println("HMAC key:"+Main.ByteToHex(computer.key));
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
    }
}
