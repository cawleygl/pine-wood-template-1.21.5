package bluesteel42.pinewood.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.EntityEffectParticleEffect;

public class ModNeedlesParticle extends SpriteBillboardParticle {
    private static final float SPEED_SCALE = 0.0025F;
    private static final int field_43373 = 300;
    private static final int field_43366 = 300;
    private float angularVelocity;
    private final float field_43370;
    private final float angularAcceleration;
    private final float field_55127;
    private boolean field_55128;
    private boolean field_55129;
    private double field_55130;
    private double field_55131;
    private double field_55132;

    protected ModNeedlesParticle (
            ClientWorld world,
            double x,
            double y,
            double z,
            SpriteProvider spriteProvider,
            float gravity,
            float f,
            boolean bl,
            boolean bl2,
            float size,
            float initialYVelocity
    ) {
        super(world, x, y, z);
        this.setSprite(spriteProvider.getSprite(this.random.nextInt(12), 12));
        this.angularVelocity = (float)Math.toRadians(this.random.nextBoolean() ? -30.0 : 30.0);
        this.field_43370 = this.random.nextFloat();
        this.angularAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? -5.0 : 5.0);
        this.field_55127 = f;
        this.field_55128 = bl;
        this.field_55129 = bl2;
        this.maxAge = 300;
        this.gravityStrength = gravity * 1.2F * 0.0025F;
        float g = size * (this.random.nextBoolean() ? 0.05F : 0.075F);
        this.scale = g;
        this.setBoundingBoxSpacing(g, g);
        this.velocityMultiplier = 1.0F;
        this.velocityY = -initialYVelocity;
        this.field_55130 = Math.cos(Math.toRadians(this.field_43370 * 60.0F)) * this.field_55127;
        this.field_55131 = Math.sin(Math.toRadians(this.field_43370 * 60.0F)) * this.field_55127;
        this.field_55132 = Math.toRadians(1000.0F + this.field_43370 * 3000.0F);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        this.lastX = this.x;
        this.lastY = this.y;
        this.lastZ = this.z;
        if (this.maxAge-- <= 0) {
            this.markDead();
        }

        if (!this.dead) {
            float f = 300 - this.maxAge;
            float g = Math.min(f / 300.0F, 1.0F);
            double d = 0.0;
            double e = 0.0;
            if (this.field_55129) {
                d += this.field_55130 * Math.pow(g, 1.25);
                e += this.field_55131 * Math.pow(g, 1.25);
            }

            if (this.field_55128) {
                d += g * Math.cos(g * this.field_55132) * this.field_55127;
                e += g * Math.sin(g * this.field_55132) * this.field_55127;
            }

            this.velocityX += d * 0.0025F;
            this.velocityZ += e * 0.0025F;
            this.velocityY = this.velocityY - this.gravityStrength;
            this.angularVelocity = this.angularVelocity + this.angularAcceleration / 20.0F;
            this.lastAngle = this.angle;
            this.angle = this.angle + this.angularVelocity / 20.0F;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            if (this.onGround || this.maxAge < 299 && (this.velocityX == 0.0 || this.velocityZ == 0.0)) {
                this.markDead();
            }

            if (!this.dead) {
                this.velocityX = this.velocityX * this.velocityMultiplier;
                this.velocityY = this.velocityY * this.velocityMultiplier;
                this.velocityZ = this.velocityZ * this.velocityMultiplier;
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static class TintedNeedlesFactory implements ParticleFactory<EntityEffectParticleEffect> {
        private final SpriteProvider spriteProvider;

        public TintedNeedlesFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(
                EntityEffectParticleEffect entityEffectParticleEffect, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i
        ) {
            Particle particle = new ModNeedlesParticle(clientWorld, d, e, f, this.spriteProvider, 1.0F, 10.0F, true, false, 2.0F, 0.021F);
            particle.setColor(entityEffectParticleEffect.getRed(), entityEffectParticleEffect.getGreen(), entityEffectParticleEffect.getBlue());
            return particle;
        }
    }
}
