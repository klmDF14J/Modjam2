package holiday.block;

import holiday.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static Block weed, fossil, palmLog, palmPlank;

	private static void define() {
		weed = new BlockWeed(Config.weed);
		fossil = new BlockFossil(Config.fossilRock);
		palmLog = new BlockPalmLog(Config.palmLog);
		palmPlank = new BlockBasic(Config.palmPlank, Material.wood, "PalmPlank");
	}
	
	private static void register() {
		GameRegistry.registerBlock(weed, "Weed");
		GameRegistry.registerBlock(fossil, "Fossil");
		GameRegistry.registerBlock(palmLog, "PalmLog");
		GameRegistry.registerBlock(palmPlank, "PalmPlank");
	}
	
	private static void name() {
		LanguageRegistry.addName(weed, "Seaweed");
		LanguageRegistry.addName(fossil, "Fossil Encrusted Stone");
		LanguageRegistry.addName(palmLog, "Palm Log");
		LanguageRegistry.addName(palmPlank, "Palm Wood Planks");
	}
	
	private static void addRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(palmPlank, 4), palmLog);
		
		OreDictionary.registerOre("plankWood", palmPlank);
		OreDictionary.registerOre("logWood", palmLog);
	}
	
	public static void init() {
		Blocks.define();
		Blocks.register();
		Blocks.name();
		Blocks.addRecipes();
	}
}
