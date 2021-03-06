package eutros.metabotany.common.enchantment;

import eutros.metabotany.common.utils.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import static eutros.metabotany.common.item.MetaBotanyItems.register;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MOD_ID)
public class MetaBotanyEnchantments {

    @ObjectHolder(Reference.MOD_ID + ":sharper") public static Enchantment lensSharper;

    @SubscribeEvent
    public static void registerEnchantments(final RegistryEvent.Register<Enchantment> event) {
        IForgeRegistry<Enchantment> r = event.getRegistry();

        register(r, new EnchantmentSharper(), "sharper");
    }

}
