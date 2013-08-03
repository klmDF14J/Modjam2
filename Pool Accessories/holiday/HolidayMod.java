package holiday;

import holiday.block.Blocks;
import holiday.item.Items;
import holiday.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = HolidayMod.modid, name = HolidayMod.modname, version = HolidayMod.version)
@NetworkMod(channels = {HolidayMod.channel}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class HolidayMod {
	public static final String modid = "holiday";
	public static final String modname = "Holiday Mod";
	public static final String version = "0.1";
	public static final String channel = "holiday";
	
	public static CreativeTabs tabFood, tabFossils, tabMisc, tabClothes;
	
	public static BiomeGenBase holidayBiome;
	
	@Instance
	public static HolidayMod instance;
	
	@SidedProxy(clientSide = "holiday.proxy.ClientProxy", serverSide = "holiday.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event.getSuggestedConfigurationFile());
		
		proxy.initRenderers();
		proxy.initSounds();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		tabFood = new HolidayTab("Holiday Food", 0);
		tabFossils = new HolidayTab("Holiday Fossils", 1);
		tabMisc = new HolidayTab("Holiday Misc", 2);
		tabClothes = new HolidayTab("Holiday Clothes", 3);
		
		Items.init();
		Blocks.init();
		
		holidayBiome = new HolidayBiome(24).setBiomeName("Holiday Land").setColor(-10);
		GameRegistry.addBiome(holidayBiome);
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		new GenerationHandler();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}	
