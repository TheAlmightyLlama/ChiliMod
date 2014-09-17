package net.chilimod.mod;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class registerSounds {
	
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event){
		event.manager.addSound(ChiliMod.modid + ":fart1.ogg");
		event.manager.addSound(ChiliMod.modid + ":fart2.ogg");
		event.manager.addSound(ChiliMod.modid + ":fart3.ogg");
		event.manager.addSound(ChiliMod.modid + ":activateSpecialChili.ogg");
		event.manager.addSound(ChiliMod.modid + ":disableSpecialChili.ogg");
	}
	
}
