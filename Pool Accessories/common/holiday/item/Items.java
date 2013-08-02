package holiday.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import holiday.Config;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Items {
	
	public static String[] iceCreamNames = {"Strawberry", "Chocolate", "Vanilla", "Blueberry", "Mint", "RumRaisin"};
	
	public static Item iceCream, cone, iceCreamBall, fishAndChips, snorkel;
	
	private static void define() {
		iceCream = new ItemIceCream(Config.iceCream);
		cone = new ItemBasic(Config.cone, CreativeTabs.tabFood, "Cone");
		iceCreamBall = new ItemIceCreamBall(Config.iceCreamBall);
		fishAndChips = new ItemFishAndChips(Config.fishAndChips);
		snorkel = new ItemSnorkel(Config.snorkel);
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
		
		LanguageRegistry.addName(cone, "Ice Cream Cone");
		LanguageRegistry.addName(fishAndChips, "Fish & Chips");
		LanguageRegistry.addName(snorkel, "Snorkel");
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
