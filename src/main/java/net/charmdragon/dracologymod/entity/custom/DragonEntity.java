package net.charmdragon.dracologymod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeMod;

public class DragonEntity extends PathfinderMob implements PlayerRideableJumping {

    protected float playerJumpPendingScale;
    protected boolean isJumping;

    public DragonEntity(EntityType<? extends DragonEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        setMaxUpStep(0.6f);
        xpReward = 0;
        setNoAi(false);

        setPersistenceRequired();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.0, Ingredient.of(Items.BEETROOT_SOUP), false));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0));
    }

    public static AttributeSupplier.Builder createAttribute()
    {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_DAMAGE, 5f)
                .add(Attributes.FOLLOW_RANGE, 1d);
    }

    // set Persistence Required
    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    // detects when player interacts with the mod and makes the player ride the mob
    @Override
    public InteractionResult mobInteract(Player sourceEntity, InteractionHand hand) {

        super.mobInteract(sourceEntity, hand);

        sourceEntity.startRiding(this);

        return InteractionResult.sidedSuccess(this.level().isClientSide());
    }

    // Allows the riding mob to control this mob
    @Override
    public void travel(Vec3 pTravelVector) {
        if (this.isControlledByLocalInstance()) {
            if (this.isVehicle()) {
                Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
                this.setYRot(entity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(entity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = entity.getYRot();
                this.yHeadRot = entity.getYRot();

                if (entity instanceof LivingEntity passenger) {
                    this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));

                    float longitudinal = passenger.zza;

                    float vertical = passenger.yya;

                    float lateral = passenger.xxa;

                    //System.out.println("z:"+longitudinal+" y:"+vertical+" x:"+lateral);

                    travel2(new Vec3(lateral, vertical, longitudinal));
                }
                return;
            }
            travel2(pTravelVector);
        }
        this.calculateEntityAnimation(false);
    }

    public void travel2(Vec3 pTravelVector) {
        AttributeInstance gravity = this.getAttribute(ForgeMod.ENTITY_GRAVITY.get());
        double d0 = gravity.getValue();
        float f4;

        BlockPos blockpos = this.getBlockPosBelowThatAffectsMyMovement();
        float f2 = this.level().getBlockState(this.getBlockPosBelowThatAffectsMyMovement()).getFriction(this.level(), this.getBlockPosBelowThatAffectsMyMovement(), this);
        f4 = this.onGround() ? f2 * 0.91F : 0.91F;
        Vec3 vec35 = this.handleRelativeFrictionAndCalculateMovement(pTravelVector, f2);
        double d2 = vec35.y;

        if (this.hasEffect(MobEffects.LEVITATION)) {
            d2 += (0.05 * (double)(this.getEffect(MobEffects.LEVITATION).getAmplifier() + 1) - vec35.y) * 0.2;
        }
        else if (this.level().isClientSide && !this.level().hasChunkAt(blockpos)) {
            if (this.getY() > (double)this.level().getMinBuildHeight()) {
                d2 = -0.1;
            }
            else {
                d2 = 0.0;
            }
        }
        else if (!this.isNoGravity()) {
            d2 -= d0;
        }

        if (this.shouldDiscardFriction()) {
            this.setDeltaMovement(vec35.x, d2, vec35.z);
        }
        else {
            this.setDeltaMovement(vec35.x * (double)f4, d2 * 0.9800000190734863, vec35.z * (double)f4);
        }
    }

    /*
    JUMPING:
     */

    protected void tickRidden(Player pPlayer, Vec3 pTravelVector) {
        super.tickRidden(pPlayer, pTravelVector);
        Vec2 vec2 = this.getRiddenRotation(pPlayer);
        this.setRot(vec2.y, vec2.x);
        this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();
        if (this.isControlledByLocalInstance()) {
            if (pTravelVector.z <= 0.0) {
                //this.gallopSoundCounter = 0;
            }

            if (this.onGround()) {
                this.setIsJumping(false);
                if (this.playerJumpPendingScale > 0.0F && !this.isJumping()) {
                    this.executeRidersJump(this.playerJumpPendingScale, pTravelVector);
                }

                this.playerJumpPendingScale = 0.0F;
            }
        }

    }

    protected Vec3 getRiddenInput(Player pPlayer, Vec3 pTravelVector) {
        System.out.println("ran getRiddenInput");
        if (this.onGround() && this.playerJumpPendingScale == 0.0F /*&& this.isStanding() && !this.allowStandSliding*/) {
            return Vec3.ZERO;
        } else {
            float f = pPlayer.xxa * 0.5F;
            float f1 = pPlayer.zza;
            if (f1 <= 0.0F) {
                f1 *= 0.25F;
            }

            return new Vec3((double)f, 0.0, (double)f1);
        }
    }

    protected void executeRidersJump(float pPlayerJumpPendingScale, Vec3 pTravelVector) {
        System.out.println("ran executeRidersJump");
        double d0 = this.getCustomJump() * (double)pPlayerJumpPendingScale * (double)this.getBlockJumpFactor();
        double d1 = d0 + (double)this.getJumpBoostPower();
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x, d1, vec3.z);
        this.setIsJumping(true);
        this.hasImpulse = true;
        ForgeHooks.onLivingJump(this);
        if (pTravelVector.z > 0.0) {
            float f = Mth.sin(this.getYRot() * 0.017453292F);
            float f1 = Mth.cos(this.getYRot() * 0.017453292F);
            this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f * pPlayerJumpPendingScale), 0.0, (double)(0.4F * f1 * pPlayerJumpPendingScale)));
        }
    }

    protected Vec2 getRiddenRotation(LivingEntity pEntity) {
        return new Vec2(pEntity.getXRot() * 0.5F, pEntity.getYRot());
    }

    @Override
    public void onPlayerJump(int pJumpPower) {
        System.out.println("ran onPlayerJump");
        if (true/*this.isSaddled()*/) {
            if (pJumpPower < 0) {
                pJumpPower = 0;
            } else {
                //this.allowStandSliding = true;
                //this.standIfPossible();
            }

            if (pJumpPower >= 90) {
                this.playerJumpPendingScale = 1.0F;
            } else {
                this.playerJumpPendingScale = 0.4F + 0.4F * (float)pJumpPower / 90.0F;
            }
        }

    }

    @Override
    public boolean canJump() {
        System.out.println("ran canJump");
        return false;
    }

    @Override
    public void handleStartJump(int i) {
        System.out.println("ran handleStartJump");
    }

    @Override
    public void handleStopJump() {
        System.out.println("ran handleStopJump");
    }

    public boolean isJumping() {
        return this.isJumping;
    }

    public void setIsJumping(boolean pJumping) {
        this.isJumping = pJumping;
    }

    public double getCustomJump() {
        return this.getAttributeValue(Attributes.JUMP_STRENGTH);
    }
}
