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
	public static int[] dyes = {1, 3, 15, 4, 2};
	
	public static String[] lollyNames = {"Orange", "Blackcurrant"};
	public static int[] dyes2 = {14, 13};
	
	public static int fossils = 8;
	
	public static String[] glassesColours = {"Red", "Blue", "Green", "Yellow"};
	
	public static Item iceCream, cone, iceCreamBall, fishAndChips, snorkel, fossil, chisel, coolBag, lolly, sunCream, tintedGlasses;
	
	private static void define() {
		iceCream = new ItemIceCream(Config.iceCream);
		cone = new ItemBasic(Config.cone, HolidayMod.tabFood, "Cone");
		iceCreamBall = new ItemIceCreamBall(Config.iceCreamBall);
		fishAndChips = new ItemFishAndChips(Config.fishAndChips);
		snorkel = new ItemSnorkel(Config.snorkel);
		fossil = new ItemFossil(Config.fossil);
		chisel = new ItemChisel(Config.chisel);
		coolBag = new ItemBasic(Config.coolBag, HolidayMod.tabMisc, "CoolBag");
		lolly = new ItemLolly(Config.lolly);
		sunCream = new ItemBasic(Config.sunCream, HolidayMod.tabMisc, "SunCream");
		tintedGlasses = new ItemTintedGlasses(Config.tintedGlasses);
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
		
		for(int i = 0; i < lollyNames.length; i++) {
			LanguageRegistry.addName(new ItemStack(lolly, 1, i), lollyNames[i] + " Ice Lolly");
		}
		
		for(int i = 0; i < glassesColours.length; i++) {
			LanguageRegistry.addName(new ItemStack(tintedGlasses, 1, i), glassesColours[i] + " Tinted Glasses");
		}
		
		LanguageRegistry.addName(cone, "Ice Cream Cone");
		LanguageRegistry.addName(fishAndChips, "Fish & Chips");
		LanguageRegistry.addName(snorkel, "Snorkel");
		LanguageRegistry.addName(chisel, "Chisel");
		LanguageRegistry.addName(coolBag, "Cool Bag");
		LanguageRegistry.addName(lolly, "Ice Lolly");
		LanguageRegistry.addName(sunCream, "Sun Cream");
	}
	
	private static void addRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(cone, 1), new ItemStack(Item.sugar), new ItemStack(Item.dyePowder, 1, 3));
		
		for(int i = 0; i < iceCreamNames.length; i++) {
			GameRegistry.addRecipe(new ItemStack(iceCream, 1, i), new Object[] {
				"X", "Y", 'X', new ItemStack(iceCreamBall, 1, i), 'Y', cone
			});
		}
		
		for(int i = 0; i < iceCreamNames.length; i++) {
			if(i == 5) {
				GameRegistry.addShapelessRecipe(new ItemStack(iceCreamBall, 1, i), new ItemStack(Item.bucketMilk), new ItemStack(Item.sugar), new ItemStack(Item.egg), new ItemStack(Block.ice), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Item.dyePowder, 1, 3));
			}
			else {
				GameRegistry.addShapelessRecipe(new ItemStack(iceCreamBall, 1, i), new ItemStack(Item.bucketMilk), new ItemStack(Item.sugar), new ItemStack(Item.egg), new ItemStack(Block.ice), new ItemStack(Item.dyePowder, 1, dyes[i]));
			}
		}
		
		GameRegistry.addShapelessRecipe(new ItemStack(fishAndChips, 1), new ItemStack(Item.fishCooked), new ItemStack(Item.potato));
		
		GameRegistry.addShapelessRecipe(new ItemStack(coolBag, 1), new ItemStack(Block.cloth), new ItemStack(Item.bucketWater));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.ice, 1), new ItemStack(coolBag), new ItemStack(Item.bucketWater));
		
		for(int i = 0; i < lollyNames.length; i++) {
			GameRegistry.addRecipe(new ItemStack(lolly, 1, i),
					new Object[] {	"X",
									"Y",
									"/",
									
									'X', new ItemStack(Item.dyePowder, 1, dyes2[i]),
									'Y', Block.ice,
									'/', Item.stick
			});
		}

	}
	
	public static void init() {
		Items.define();
		Items.name();
		Items.addRecipes();
	}
}
