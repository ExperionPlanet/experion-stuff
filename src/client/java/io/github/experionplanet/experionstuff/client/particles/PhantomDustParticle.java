package io.github.experionplanet.experionstuff.client.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

public class PhantomDustParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;

    public PhantomDustParticle(ClientWorld clientWorld, double x, double y, double z, double vx, double vy, double vz, SpriteProvider spr) {
        super(clientWorld, x,y,z,vx,vy,vz);

        this.spriteProvider = spr;
        this.setSpriteForAge(this.spriteProvider);

        Random rand = clientWorld.getRandom();

        this.setVelocity(getSPD(rand),getSPD(rand),getSPD(rand));
        this.gravityStrength = 0.3f;
    }

    private static double getSPD(Random rand) {

        double res = rand.nextDouble() * 0.2;

        if (rand.nextBoolean()) {
            res = -res;
        }

        return res;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isAlive()) {
            this.setSpriteForAge(this.spriteProvider);
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientWorld world, double x, double y, double z, double dx, double dy, double dz) {
            return new PhantomDustParticle(world, x, y, z, dx, dy, dz, spriteProvider);
        }
    }
}
