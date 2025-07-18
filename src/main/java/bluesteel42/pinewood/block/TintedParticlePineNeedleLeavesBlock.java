package bluesteel42.pinewood.block;

import bluesteel42.pinewood.particle.ModParticles;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class TintedParticlePineNeedleLeavesBlock extends LeavesBlock {
    public static final MapCodec<TintedParticlePineNeedleLeavesBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            Codecs.rangedInclusiveFloat(0.0F, 1.0F)
                                    .fieldOf("leaf_particle_chance")
                                    .forGetter(tintedParticleLeavesBlock -> tintedParticleLeavesBlock.leafParticleChance),
                            createSettingsCodec()
                    )
                    .apply(instance, TintedParticlePineNeedleLeavesBlock::new)
    );

    public TintedParticlePineNeedleLeavesBlock(float f, Settings settings) {
        super(f, settings);
    }

    @Override
    protected void spawnLeafParticle(World world, BlockPos pos, Random random) {
        EntityEffectParticleEffect entityEffectParticleEffect = EntityEffectParticleEffect.create(ModParticles.PINE_NEEDLES, world.getBlockColor(pos));
        ParticleUtil.spawnParticle(world, pos, random, entityEffectParticleEffect);
    }

    @Override
    public MapCodec<? extends TintedParticlePineNeedleLeavesBlock> getCodec() {
        return CODEC;
    }
}
