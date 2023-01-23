package dev.rikumi.nohideflags.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

	@Shadow
	public abstract Item getItem();

	@Shadow
	public abstract NbtCompound getNbt();

	@SuppressWarnings("InvalidInjectorMethodSignature")
	@ModifyVariable(at = @At(value = "INVOKE_ASSIGN", target = "net.minecraft.item.ItemStack.getHideFlags()I"), method = "getTooltip")
	private int getHideFlags(int i) {
		return 0;
	}
}
