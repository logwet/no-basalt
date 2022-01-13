package me.logwet.no_basalt.mixin.common;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MultiNoiseBiomeSource.class)
public abstract class MultiNoiseBiomeSourceMixin {
    @Redirect(
            method = "defaultNether",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lcom/google/common/collect/ImmutableList;of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;"))
    private static ImmutableList<Biome> editList(
            Object NETHER_WASTES,
            Object SOUL_SAND_VALLEY,
            Object CRIMSON_FOREST,
            Object WARPED_FOREST,
            Object BASALT_DELTAS) {
        return ImmutableList.of(
                (Biome) NETHER_WASTES,
                (Biome) SOUL_SAND_VALLEY,
                (Biome) CRIMSON_FOREST,
                (Biome) WARPED_FOREST);
    }
}
