package eutros.botaniapp.common;

import eutros.botaniapp.api.BotaniaPPAPI;
import eutros.botaniapp.client.core.proxy.ClientProxy;
import eutros.botaniapp.common.config.BotaniaPPConfig;
import eutros.botaniapp.common.core.network.PacketHandler;
import eutros.botaniapp.common.core.proxy.IProxy;
import eutros.botaniapp.common.core.proxy.ServerProxy;
import eutros.botaniapp.common.item.BotaniaPPItems;
import eutros.botaniapp.common.utils.Reference;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vazkii.botania.api.mana.ILens;

@Mod(Reference.MOD_ID)
public class BotaniaPP {

    public static BotaniaPP instance;
    public static IProxy proxy;

    public BotaniaPP() {
        instance = this;
        proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
        proxy.registerHandlers();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        ModLoadingContext ctx = ModLoadingContext.get();
        ctx.registerConfig(ModConfig.Type.COMMON, BotaniaPPConfig.COMMON_SPEC);
        ctx.registerConfig(ModConfig.Type.CLIENT, BotaniaPPConfig.CLIENT_SPEC);
        ctx.registerConfig(ModConfig.Type.SERVER, BotaniaPPConfig.SERVER_SPEC);

        BotaniaPPAPI.setInstance(EnchantmentType.create("MANA_LENS", ILens.class::isInstance));
    }

    private void commonSetup(FMLCommonSetupEvent evt) {
        BotaniaPPItems.addDispenserBehaviours();
        PacketHandler.init();
    }

}
