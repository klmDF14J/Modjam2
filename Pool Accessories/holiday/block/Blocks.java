package holiday.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import holiday.Config;
import holiday.item.Items;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

public class Blocks {
	
	public static Block weed, fossil;

	private static void define() {
		weed = new BlockWeed(Config.weed);
		fossil = new BlockFossil(Config.fossilRock);
	}
	
	private static void register() {
		GameRegistry.registerBlock(weed, "Weed");
		GameRegistry.registerBlock(fossil, "Fossil");
	}
	
	private static void name() {
		LanguageRegistry.addName(weed, "Seaweed");
		LanguageRegistry.addName(fossil, "Fossil Encrusted Stone");
	}
	
	private static void addRecipes() {
		
	}
	
	public static void init() {
		Blocks.define();
		Blocks.register();
		Blocks.name();
		Blocks.addRecipes();
	}
}
