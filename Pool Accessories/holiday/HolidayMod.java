package holiday;

import net.minecraft.creativetab.CreativeTabs;
import holiday.block.Blocks;
import holiday.item.Items;
import holiday.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = HolidayMod.modid, name = HolidayMod.modname, version = HolidayMod.version)
@NetworkMod(channels = {HolidayMod.channel}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class HolidayMod {
	public static final String modid = "holiday";
	public static final String modname = "Holiday Mod";
	public static final String version = "0.1";
	public static final String channel = "holiday";
	
	public static CreativeTabs tabFood, tabFossils, tabMisc;
	
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
		
		Items.init();
		Blocks.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}	