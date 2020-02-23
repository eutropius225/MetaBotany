package eutros.botaniapp.common.sound;

import eutros.botaniapp.common.utils.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MOD_ID)
public class BotaniaPPSounds {

    public static SoundEvent BOTANIA_DING;
    public static SoundEvent BOTANIA_SPREADER_FIRE;

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> evt) {
        IForgeRegistry<SoundEvent> r = evt.getRegistry();

        setBotaniaSounds(r);
    }

    private static void setBotaniaSounds(IForgeRegistry<SoundEvent> r) {
        final String b = "botania";

        BOTANIA_DING = r.getValue(new ResourceLocation(b, "ding"));
        BOTANIA_SPREADER_FIRE = r.getValue(new ResourceLocation(b, "spreaderfire"));
    }
}
