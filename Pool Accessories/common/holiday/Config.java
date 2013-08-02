package holiday;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class Config {
	
	public static int iceCream, cone, iceCreamBall, fishAndChips, snorkel;
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		iceCream = config.getItem("Ice Cream", 8000).getInt() - 256;
		cone = config.getItem("Ice Cream Cone", 8001).getInt() - 256;
		iceCreamBall = config.getItem("Ice Cream Ball", 8002).getInt() - 256;
		fishAndChips = config.getItem("Fish And Chips", 8003).getInt() - 256;
		snorkel = config.getItem("Snorkel", 8004).getInt() - 256;
		
		
		config.save();
	}
}
