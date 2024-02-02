import java.util.*;

public class HasState {
	
	private int state;
	
	public HasState()
	{
		Random rand = new Random();
		state = rand.nextInt(1000)+1; // range [1, 1000]
	}
	
	public int getState()
	{
		return state;
	}
	
	public void changeState()
	{
		Random rand = new Random();
		state = rand.nextInt(1000)+1; // range [1, 1000]		
	}

}
