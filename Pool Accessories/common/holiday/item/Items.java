package holiday.item;

import holiday.Config;
import holiday.HolidayMod;
import holiday.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
	
	public static String[] iceCreamNames = {"Strawberry", "Chocolate", "Vanilla", "Blueberry", "Mint", "RumRaisin"};
	
	public static int fossils = 8;
	
	public static Item iceCream, cone, iceCreamBall, fishAndChips, snorkel, fossil, chisel, coolBag;
	
	private static void define() {
		iceCream = new ItemIceCream(Config.iceCream);
		cone = new ItemBasic(Config.cone, HolidayMod.tabFood, "Cone");
		iceCreamBall = new ItemIceCreamBall(Config.iceCreamBall);
		fishAndChips = new ItemFishAndChips(Config.fishAndChips);
		snorkel = new ItemSnorkel(Config.snorkel);
		fossil = new ItemFossil(Config.fossil);
		chisel = new ItemChisel(Config.chisel);
	}
	
	private static void name() {
		for(int i = 0; i < iceCreamNames.length; i++) {
			if(iceCreamNames[i] == "RumRaisin") {
				LanguageRegistry.addName(new ItemStack(iceCream, 1, i), "Rum & Raisin" + " Ice Cream");
			}
			else {
				LanguageRegistry.addName(new ItemStack(iceCream, 1, i), iceCreamNames[i] + " Ice Cream");
			}
		}
		
		for(int i = 0; i < iceCreamNames.length; i++) {
			if(iceCreamNames[i] == "RumRaisin") {
				LanguageRegistry.addName(new ItemStack(iceCreamBall, 1, i), "Rum & Raisin" + " Ice Cream Ball");
			}
			else {
				LanguageRegistry.addName(new ItemStack(iceCreamBall, 1, i), iceCreamNames[i] + " Ice Cream Ball");
			}
		}
		
		for(int i = 0; i < fossils; i++) {
			LanguageRegistry.addName(new ItemStack(fossil, 1, i), "Fossil");
		}
		
		LanguageRegistry.addName(cone, "Ice Cream Cone");
		LanguageRegistry.addName(fishAndChips, "Fish & Chips");
		LanguageRegistry.addName(snorkel, "Snorkel");
		LanguageRegistry.addName(chisel, "Chisel");
	}
	
	private static void addRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(cone, 1), new ItemStack(Item.sugar), new ItemStack(Item.dyePowder, 1, 3));
		
		for(int i = 0; i < iceCreamNames.length; i++) {
			GameRegistry.addShapelessRecipe(new ItemStack(iceCream, 1, i), new ItemStack(iceCreamBall, 1, i), new ItemStack(cone));
		}
		
		GameRegistry.addShapelessRecipe(new ItemStack(fishAndChips, 1), new ItemStack(Item.fishCooked), new ItemStack(Item.potato));

	}
	
	public static void init() {
		Items.define();
		Items.name();
		Items.addRecipes();
	}
}
