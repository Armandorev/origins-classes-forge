package limonblaze.originsclasses.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class NbtUtils {

    public static final String ORIGINS_CLASSES = "OriginsClasses";
    public static final String ENCHANTER = "Enchanter";
    public static final String FOOD_BONUS = "FoodBonus";
    public static final String POTION_BONUS = "PotionBonus";

    public static <T> Optional<T> getOriginsClassesData(ItemStack stack, String key, NbtType<T> nbtType) {
        return stack.hasTag() ? getOriginsClassesData(stack.getOrCreateTag(), key, nbtType) : Optional.empty();
    }

    public static <T> T getOriginsClassesData(ItemStack stack, String key, NbtType<T> nbtType, T defaultValue) {
        return stack.hasTag() ? getOriginsClassesData(stack.getOrCreateTag(), key, nbtType, defaultValue) : defaultValue;
    }

    public static <T> Optional<T> getOriginsClassesData(CompoundTag nbt, String key, NbtType<T> nbtType) {
        if(nbt.contains(ORIGINS_CLASSES, Tag.TAG_COMPOUND)) {
            CompoundTag ocNbt = nbt.getCompound(ORIGINS_CLASSES);
            if(nbtType.check(ocNbt, key)) {
                return Optional.of(nbtType.get(ocNbt, key));
            }
        }
        return Optional.empty();
    }

    public static <T> T getOriginsClassesData(CompoundTag nbt, String key, NbtType<T> nbtType, T defaultValue) {
        if(nbt.contains(ORIGINS_CLASSES, Tag.TAG_COMPOUND)) {
            CompoundTag ocNbt = nbt.getCompound(ORIGINS_CLASSES);
            if(nbtType.check(ocNbt, key)) {
                return nbtType.get(ocNbt, key);
            }
        }
        return defaultValue;
    }

}
