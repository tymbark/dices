package alx.dices;

import java.util.Random;

public class Rand {
	static Random r;
	public static Random get(){ 
		if(r == null)
			r = new Random();
		return r;
	}
}
