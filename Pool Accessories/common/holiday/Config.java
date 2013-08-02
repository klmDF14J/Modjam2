package holiday;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class Config {
	
	/**
	 * Item ID's
	 */
	public static int iceCream, cone, iceCreamBall, fishAndChips, snorkel, fossil, chisel;
	
	/**
	 * Block ID's
	 */
	public static int weed, fossilRock;
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		iceCream = config.getItem("Ice Cream", 8000).getInt() - 256;
		cone = config.getItem("Ice Cream Cone", 8001).getInt() - 256;
		iceCreamBall = config.getItem("Ice Cream Ball", 8002).getInt() - 256;
		fishAndChips = config.getItem("Fish And Chips", 8003).getInt() - 256;
		snorkel = config.getItem("Snorkel", 8004).getInt() - 256;
		fossil = config.getItem("Fossil", 8005).getInt() - 256;
		chisel = config.getItem("Chisel", 8006).getInt() - 256;
		
		weed = config.getBlock("Seaweed", 3000).getInt();
		fossilRock = config.getBlock("Fossil", 3001).getInt();
		
		config.save();
	}
}
