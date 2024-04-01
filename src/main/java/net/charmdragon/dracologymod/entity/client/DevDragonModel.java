package net.charmdragon.dracologymod.entity.client;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class DevDragonModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart body;

	public DevDragonModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 88).addBox(-23.3823F, 4.9616F, -3.1469F, 20.0F, 21.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(13.3823F, -18.9616F, -21.8531F));

		PartDefinition Waist = body.addOrReplaceChild("Waist", CubeListBuilder.create().texOffs(0, 136).addBox(-7.0F, -41.0F, 2.0F, 14.0F, 17.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.3823F, 45.9616F, 21.8531F));

		PartDefinition Hip = Waist.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(94, 110).addBox(-8.0F, -41.0F, 19.0F, 16.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail = Hip.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(145, 129).addBox(-6.0F, -4.0F, 0.0F, 12.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -37.0F, 38.0F));

		PartDefinition bone3 = Tail.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(146, 91).addBox(-5.0F, -37.0F, 57.0F, 10.0F, 12.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 34.0F, -38.0F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(99, 158).addBox(-4.0F, -36.0F, 76.0F, 8.0F, 9.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone5 = bone4.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(185, 66).addBox(-3.0F, -36.0F, 95.0F, 6.0F, 7.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(185, 103).addBox(-2.0F, -36.0F, 114.0F, 4.0F, 5.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = Hip.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, -30.0F, 32.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition RightUpperLeg_r1 = RightLeg.addOrReplaceChild("RightUpperLeg_r1", CubeListBuilder.create().texOffs(150, 186).addBox(-3.0979F, -5.1388F, -7.0F, 8.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.0F, -2.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition bone7 = RightLeg.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(-1.0F, -2.0F, -2.0F));

		PartDefinition RightLowerLeg_r1 = bone7.addOrReplaceChild("RightLowerLeg_r1", CubeListBuilder.create().texOffs(0, 170).addBox(-1.0979F, -6.0668F, -17.717F, 6.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 7.0F, -6.0F, 2.4435F, 0.0F, 0.0F));

		PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(-1.0F, 7.0F, -6.0F));

		PartDefinition RightFoot_r1 = bone8.addOrReplaceChild("RightFoot_r1", CubeListBuilder.create().texOffs(187, 217).addBox(-2.8691F, 0.9971F, -4.0F, 7.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 18.0F, -5.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition bone9 = bone8.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(1.0F, 18.0F, -5.0F));

		PartDefinition RightAnkle_r1 = bone9.addOrReplaceChild("RightAnkle_r1", CubeListBuilder.create().texOffs(151, 217).addBox(-1.4221F, 0.7927F, -12.0F, 5.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 14.0F, 0.5742F, 0.147F, -0.1673F));

		PartDefinition LeftLeg = Hip.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(13.0F, -30.0F, 32.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition LeftUpperLeg_r1 = LeftLeg.addOrReplaceChild("LeftUpperLeg_r1", CubeListBuilder.create().texOffs(190, 186).addBox(-4.9021F, -5.1388F, -7.0F, 8.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, -2.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition bone10 = LeftLeg.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(1.0F, -2.0F, -2.0F));

		PartDefinition LeftLowerLeg_r1 = bone10.addOrReplaceChild("LeftLowerLeg_r1", CubeListBuilder.create().texOffs(50, 177).addBox(-4.9021F, -6.0668F, -17.717F, 6.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 7.0F, -6.0F, 2.4435F, 0.0F, 0.0F));

		PartDefinition bone11 = bone10.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(1.0F, 7.0F, -6.0F));

		PartDefinition LeftAnkle_r1 = bone11.addOrReplaceChild("LeftAnkle_r1", CubeListBuilder.create().texOffs(217, 204).addBox(-3.5779F, 0.7927F, -12.0F, 5.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 12.0F, 9.0F, 0.5742F, -0.147F, 0.1673F));

		PartDefinition bone12 = bone11.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset(-1.0F, 12.0F, 9.0F));

		PartDefinition LeftFoot_r1 = bone12.addOrReplaceChild("LeftFoot_r1", CubeListBuilder.create().texOffs(31, 170).addBox(-4.1309F, 0.9971F, -4.0F, 7.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -14.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Headandneck = body.addOrReplaceChild("Headandneck", CubeListBuilder.create().texOffs(62, 148).addBox(-7.0F, -41.0F, -39.0F, 14.0F, 15.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.3823F, 45.9616F, 21.8531F));

		PartDefinition bone = Headandneck.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(100, 186).addBox(-6.0F, -8.0F, -27.0F, 12.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -33.0F, -25.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(195, 149).addBox(-5.0F, -41.0F, -65.0F, 10.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 33.0F, 25.0F));

		PartDefinition Head = bone2.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -36.0F, -67.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 88).addBox(-1.0F, -12.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(12, 88).addBox(-14.0F, -12.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -6.0F, 0.0F, -1.2654F, 0.0F, 0.0F));

		PartDefinition jaw = Head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(188, 127).addBox(-6.0F, -35.0F, -78.0F, 12.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(216, 66).addBox(-4.0F, -35.0F, -90.0F, 8.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 36.0F, 67.0F));

		PartDefinition Upper = Head.addOrReplaceChild("Upper", CubeListBuilder.create().texOffs(153, 162).addBox(-7.0F, -45.0F, -79.0F, 14.0F, 10.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(75, 211).addBox(-5.0F, -43.0F, -91.0F, 10.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 36.0F, 67.0F));

		PartDefinition RightArm = body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(212, 92).addBox(-4.0979F, -2.1388F, -5.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.3823F, 15.9616F, 4.8531F, 0.0F, 0.0F, 0.3054F));

		PartDefinition RightClaw_r1 = RightArm.addOrReplaceChild("RightClaw_r1", CubeListBuilder.create().texOffs(0, 220).addBox(-2.8691F, 0.9971F, -9.0F, 6.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 23.0F, -13.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition RightForearm_r1 = RightArm.addOrReplaceChild("RightForearm_r1", CubeListBuilder.create().texOffs(29, 204).addBox(-1.0979F, -0.969F, -16.7434F, 6.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 11.0F, -2.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition LeftArm = body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(119, 211).addBox(-3.9021F, -2.1388F, -5.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3823F, 15.9616F, 4.8531F, 0.0F, 0.0F, -0.3054F));

		PartDefinition LeftClaw_r1 = LeftArm.addOrReplaceChild("LeftClaw_r1", CubeListBuilder.create().texOffs(218, 172).addBox(-3.1309F, 0.9971F, -9.0F, 6.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 23.0F, -13.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition LeftForearm_r1 = LeftArm.addOrReplaceChild("LeftForearm_r1", CubeListBuilder.create().texOffs(0, 197).addBox(-4.9021F, -0.969F, -16.7434F, 6.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 11.0F, -2.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition RightWing = body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(67, 99).addBox(-42.0F, -2.0F, -3.0F, 43.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.3823F, 4.9616F, -1.1469F, 0.0F, 1.1345F, 0.0F));

		PartDefinition LowerRightWing = RightWing.addOrReplaceChild("LowerRightWing", CubeListBuilder.create().texOffs(0, 77).addBox(-83.0F, -2.0F, -3.0F, 83.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-41.0F, 0.0F, 0.0F, 0.0F, -2.2253F, 0.0F));

		PartDefinition bone14 = LowerRightWing.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(0, 44).addBox(-120.0F, -2.0F, -3.0F, 120.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-83.0F, 0.0F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition bone16 = LowerRightWing.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(0, 22).addBox(-134.0F, -2.0F, -3.0F, 134.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-83.0F, 0.0F, 0.0F, 0.0F, 2.0071F, 0.0F));

		PartDefinition bone18 = LowerRightWing.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(0, 0).addBox(-144.0F, -2.0F, -3.0F, 144.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-83.0F, 0.0F, 0.0F, 0.0F, 1.3963F, 0.0F));

		PartDefinition LeftWing = body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(67, 88).addBox(-1.0F, -2.0F, -3.0F, 43.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3823F, 4.9616F, -1.1469F, 0.0F, -1.1345F, 0.0F));

		PartDefinition LowerLeftWing = LeftWing.addOrReplaceChild("LowerLeftWing", CubeListBuilder.create().texOffs(0, 66).addBox(0.0F, -2.0F, -3.0F, 83.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(41.0F, 0.0F, 0.0F, 0.0F, 2.2253F, 0.0F));

		PartDefinition bone13 = LowerLeftWing.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(0, 55).addBox(0.0F, -2.0F, -3.0F, 120.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(83.0F, 0.0F, 0.0F, 0.0F, -2.618F, 0.0F));

		PartDefinition bone15 = LowerLeftWing.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(0, 33).addBox(0.0F, -2.0F, -3.0F, 134.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(83.0F, 0.0F, 0.0F, 0.0F, -2.0071F, 0.0F));

		PartDefinition bone17 = LowerLeftWing.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -2.0F, -3.0F, 144.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(83.0F, 0.0F, 0.0F, 0.0F, -1.3963F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//TODO: setup animations
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return body;
	}
}