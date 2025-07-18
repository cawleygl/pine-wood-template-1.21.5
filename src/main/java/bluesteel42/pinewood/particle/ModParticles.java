package bluesteel42.pinewood.particle;

import bluesteel42.pinewood.PineWood;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    // This DefaultParticleType gets called when you want to use your particle in code.
    public static final ParticleType<EntityEffectParticleEffect> PINE_NEEDLES = register("pine_needles",
            FabricParticleTypes.complex(EntityEffectParticleEffect::createCodec, EntityEffectParticleEffect::createPacketCodec)
    );
    public static final ParticleType<EntityEffectParticleEffect> SPRUCE_NEEDLES = register("spruce_needles",
            FabricParticleTypes.complex(EntityEffectParticleEffect::createCodec, EntityEffectParticleEffect::createPacketCodec)
    );

    public static <T extends ParticleEffect> ParticleType<T> register(String path, ParticleType<T> particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(PineWood.MOD_ID, path), particleType);
    }

    public static void initialize() {

    }
}
