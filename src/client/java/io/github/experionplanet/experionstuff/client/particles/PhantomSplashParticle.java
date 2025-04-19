package io.github.experionplanet.experionstuff.client.particles;

import io.github.experionplanet.experionstuff.ModInit;
import io.github.experionplanet.experionstuff.utils.EasingService;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class PhantomSplashParticle extends SpriteBillboardParticle {
    //NOTE: NOT PREPARED YET

    private final SpriteProvider spriteProvider;
    private static final Quaternionf QUATERNION = new Quaternionf(0F, -0.7F, 0.7F, 0F);
    private static final float maxScale = 0.5f;
    private static final float startScale = 1f;

    private static final float startAlpha = 1f;
    private static final float maxAlpha = 0f;

    private final boolean side;

    public PhantomSplashParticle(ClientWorld clientWorld, double x, double y, double z, double velX, double velY, double velZ, SpriteProvider spr, boolean sideways) {
        super(clientWorld, x,y,z,velX,velY,velZ);
        this.spriteProvider = spr;
        this.scale = startScale;
        this.setVelocity(0, 0, 0);
        this.maxAge = 60;
        this.setSpriteForAge(spriteProvider);
        this.side = sideways;
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            float age_alpha = Math.min((float)this.age/(float)this.maxAge, 1);

            //this.alpha = startAlpha + (maxAlpha - startAlpha) * age_alpha;
            //this.scale = startScale + (maxScale - startScale) * ((float) EasingService.OutExponent2(age_alpha));

            //ModInit.LOGGER.info("ALPHA: " + this.alpha);
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void buildGeometry(VertexConsumer buffer, Camera camera, float ticks) {
        Vec3d vec3 = camera.getPos();
        float x = (float) (MathHelper.lerp(ticks, this.prevPosX, this.x) - vec3.getX());
        float y = (float) (MathHelper.lerp(ticks, this.prevPosY, this.y) - vec3.getY());
        float z = (float) (MathHelper.lerp(ticks, this.prevPosZ, this.z) - vec3.getZ());
        Vector3f[] vector3fs, vector3fsBottom;

        if (this.side) {
            vector3fs = new Vector3f[]{
                    new Vector3f(0F, -1.0F, -1.0F),
                    new Vector3f(0F, 1.0F, -1.0F),
                    new Vector3f(0.0F, 1.0F, 1.0F),
                    new Vector3f(0.0F, -1.0F, 1.0F)
            };
            vector3fsBottom = new Vector3f[]{
                    new Vector3f(0F, -1.0F, -1.0F),
                    new Vector3f(0F, -1.0F, 1.0F),
                    new Vector3f(0.0F, -1.0F, 1.0F),
                    new Vector3f(0.0F, -1.0F, -1.0F)
            };
        }else {
            vector3fs = new Vector3f[]{
                    new Vector3f(-1.0F, -1.0F, 0.0F),
                    new Vector3f(-1.0F, 1.0F, 0.0F),
                    new Vector3f(1.0F, 1.0F, 0.0F),
                    new Vector3f(1.0F, -1.0F, 0.0F)
            };
            vector3fsBottom = new Vector3f[]{
                    new Vector3f(-1.0F, -1.0F, 0.0F),
                    new Vector3f(1.0F, -1.0F, 0.0F),
                    new Vector3f(1.0F, -1.0F, 0.0F), 
                    new Vector3f(-1.0F, -1.0F, 0.0F)
            };
        }


        float f4 = this.getSize(ticks);

        for (int i = 0; i < 4; ++i) {
            Vector3f vector3f = vector3fs[i];
            vector3f.rotate(QUATERNION);
            vector3f.mul(f4);
            vector3f.add(x, y + 0.01f, z);

            Vector3f vector3fBottom = vector3fsBottom[i];
            vector3fBottom.rotate(QUATERNION);
            vector3fBottom.mul(f4);
            vector3fBottom.add(x, y, z);

        }

        float f7 = this.getMinU();
        float f8 = this.getMaxU();
        float f5 = this.getMinV();
        float f6 = this.getMaxV();
        int light = this.getBrightness(ticks);

        buffer.vertex(vector3fs[0].x(), vector3fs[0].y(), vector3fs[0].z()).texture(f8, f6).color(this.red, this.green, this.blue, this.alpha).light(light);
        buffer.vertex(vector3fs[1].x(), vector3fs[1].y(), vector3fs[1].z()).texture(f8, f5).color(this.red, this.green, this.blue, this.alpha).light(light);
        buffer.vertex(vector3fs[2].x(), vector3fs[2].y(), vector3fs[2].z()).texture(f7, f5).color(this.red, this.green, this.blue, this.alpha).light(light);
        buffer.vertex(vector3fs[3].x(), vector3fs[3].y(), vector3fs[3].z()).texture(f7, f6).color(this.red, this.green, this.blue, this.alpha).light(light);

        buffer.vertex(vector3fs[3].x(), vector3fs[3].y(), vector3fs[3].z()).texture(f7, f6).color(this.red, this.green, this.blue, this.alpha).light(light);
        buffer.vertex(vector3fs[2].x(), vector3fs[2].y(), vector3fs[2].z()).texture(f7, f5).color(this.red, this.green, this.blue, this.alpha).light(light);
        buffer.vertex(vector3fs[1].x(), vector3fs[1].y(), vector3fs[1].z()).texture(f8, f5).color(this.red, this.green, this.blue, this.alpha).light(light);
        buffer.vertex(vector3fs[0].x(), vector3fs[0].y(), vector3fs[0].z()).texture(f8, f6).color(this.red, this.green, this.blue, this.alpha).light(light);

    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientWorld world, double x, double y, double z, double dx, double dy, double dz) {
            return new PhantomSplashParticle(world, x, y, z, dx, dy, dz, spriteProvider, false);
        }
    }
}
