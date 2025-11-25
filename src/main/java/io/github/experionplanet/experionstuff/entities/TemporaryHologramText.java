package io.github.experionplanet.experionstuff.entities;

import com.mojang.serialization.Codec;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.world.World;

public class TemporaryHologramText extends DisplayEntity.TextDisplayEntity {
    private static final int MAX_DUR = 100;
    public int duration = MAX_DUR;

    public TemporaryHologramText(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void writeCustomData(WriteView view) {
        super.writeCustomData(view);
        view.put("temp_duration", Codec.INT, this.duration);
    }

    @Override
    protected void readCustomData(ReadView view) {
        super.readCustomData(view);
        int a = MAX_DUR;

        if (view.contains("temp_duration")) {
            a = view.getInt("temp_duration", this.duration);
        }

        this.duration = a;
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getEntityWorld().isClient()) {
            if (this.duration-- <= 0) {
                this.discard();
            }

        }
    }
}
