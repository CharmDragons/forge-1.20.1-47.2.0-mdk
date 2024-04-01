package net.charmdragon.dracologymod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class DragonEntity extends AbstractHorse {
    public DragonEntity(EntityType<? extends DragonEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.inventory.setItem(0, new ItemStack(Items.SADDLE)); // for making it ride-able
        setTamed(true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.0, Ingredient.of(Items.BEETROOT_SOUP), false));
        //this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0));
    }

    public static AttributeSupplier.Builder createAttribute()
    {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.MOVEMENT_SPEED, 1.0d)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_DAMAGE, 5f)
                .add(Attributes.FOLLOW_RANGE, 1d)
                .add(Attributes.JUMP_STRENGTH, 1.0);
    }

    //
    // Attempt to make it rideable
    //
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        return super.mobInteract(pPlayer, pHand);
    }

    // for making it rideable
//    protected void tickRidden(Player pPlayer, Vec3 pTravelVector) {
//        super.tickRidden(pPlayer, pTravelVector);
//        Vec2 vec2 = this.getRiddenRotation(pPlayer);
//        this.setRot(vec2.y, vec2.x);
//        this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();
//    }
//
//    protected Vec2 getRiddenRotation(LivingEntity pEntity) {
//        return new Vec2(pEntity.getXRot() * 0.5F, pEntity.getYRot());
//    }
//
//    protected Vec3 getRiddenInput(Player pPlayer, Vec3 pTravelVector) {
//        if (this.onGround()) {
//            return Vec3.ZERO;
//        } else {
//            float f = pPlayer.xxa * 0.5F;
//            float f1 = pPlayer.zza;
//            if (f1 <= 0.0F) {
//                f1 *= 0.25F;
//            }
//
//            return new Vec3((double)f, 0.0, (double)f1);
//        }
//    }
//
//    protected float getRiddenSpeed(Player pPlayer) {
//        return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED);
//    }
//
//    //
//    // ^ attempt ot make it rideable ^
//    //

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}
