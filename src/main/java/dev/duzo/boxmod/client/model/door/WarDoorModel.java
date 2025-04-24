package dev.duzo.boxmod.client.model.door;

import dev.amble.ait.AITMod;
import dev.amble.ait.api.tardis.link.v2.block.AbstractLinkableBlockEntity;
import dev.amble.ait.client.models.doors.DoorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.tardis.handler.DoorHandler;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.util.math.MatrixStack;

public class WarDoorModel extends DoorModel {
	private final ModelPart root;

	public WarDoorModel() {
		super();
		this.root = getTexturedModelData().createModel().getChild("bone");
	}

	@Override
	public void renderWithAnimations(ClientTardis tardis, AbstractLinkableBlockEntity linkableBlockEntity, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha) {
		DoorHandler door = tardis.door();

		if (!AITMod.CONFIG.CLIENT.ANIMATE_DOORS) {
			this.root.getChild("bone3").yaw = (door.isLeftOpen() || door.isOpen()) ? -5F : 0.0F;
			this.root.getChild("bone4").yaw = (door.isRightOpen() || door.areBothOpen())
					? 5F
					: 0.0F;
		} else {
			float maxRot = 90f;
			this.root.getChild("bone3").yaw =(float) Math.toRadians(maxRot*door.getLeftRot());
			this.root.getChild("bone4").yaw =(float) -Math.toRadians(maxRot*door.getRightRot());
		}

		super.renderWithAnimations(tardis, linkableBlockEntity, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(116, 237).cuboid(-24.5F, -1.1F, -14.9F, 49.0F, 1.0F, 6.0F, new Dilation(0.0F))
				.uv(102, 0).cuboid(-24.0F, -77.0F, -11.0F, 47.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(152, 116).cuboid(19.0F, -83.0F, -14.0F, 6.0F, 6.0F, 11.0F, new Dilation(0.0F))
				.uv(102, 104).cuboid(-19.0F, -78.0F, -14.0F, 38.0F, 1.0F, 11.0F, new Dilation(0.0F))
				.uv(112, 3).cuboid(-19.0F, -82.0F, -14.0F, 38.0F, 4.0F, 5.0F, new Dilation(0.0F))
				.uv(102, 92).cuboid(-19.0F, -83.0F, -14.0F, 38.0F, 1.0F, 11.0F, new Dilation(0.0F))
				.uv(8, 6).cuboid(13.0F, -82.0F, -5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(7, 4).cuboid(5.0F, -82.0F, -5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(6, 0).cuboid(-14.0F, -82.0F, -5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(6, 2).cuboid(-7.0F, -82.0F, -5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0F, -82.0F, -4.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(21, 0).cuboid(-25.0F, -83.0F, -14.0F, 6.0F, 6.0F, 11.0F, new Dilation(0.0F))
				.uv(31, 10).cuboid(-25.0F, -83.0F, -15.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F))
				.uv(162, 126).cuboid(19.0F, -83.0F, -15.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F))
				.uv(112, 102).cuboid(-19.0F, -83.0F, -15.0F, 38.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(80, 0).cuboid(-25.0F, -77.0F, -13.0F, 6.0F, 76.0F, 10.0F, new Dilation(0.0F))
				.uv(70, 86).cuboid(19.0F, -77.0F, -13.0F, 6.0F, 76.0F, 10.0F, new Dilation(0.0F))
				.uv(4, 94).cuboid(25.0F, -31.0F, -18.0F, 8.0F, 30.0F, 8.0F, new Dilation(0.0F))
				.uv(134, 116).cuboid(33.0F, -31.0F, -18.0F, 1.0F, 30.0F, 8.0F, new Dilation(0.0F))
				.uv(36, 94).cuboid(-33.0F, -31.0F, -18.0F, 8.0F, 30.0F, 8.0F, new Dilation(0.0F))
				.uv(36, 132).cuboid(-34.0F, -31.0F, -18.0F, 1.0F, 30.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 25.0F, -16.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(144, 12).cuboid(-5.0F, -26.0F, -8.0F, 1.0F, 28.0F, 8.0F, new Dilation(0.0F))
				.uv(112, 47).cuboid(-4.0F, -26.0F, -8.0F, 8.0F, 27.0F, 8.0F, new Dilation(0.0F))
				.uv(144, 48).cuboid(62.0F, -26.0F, -8.0F, 1.0F, 28.0F, 8.0F, new Dilation(0.0F))
				.uv(112, 12).cuboid(54.0F, -26.0F, -8.0F, 8.0F, 27.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-29.0F, -31.999F, -9.9564F, -0.0436F, 0.0F, 0.0F));

		ModelPartData cube_r2 = bone.addChild("cube_r2", ModelPartBuilder.create().uv(144, 146).cuboid(-5.0F, -49.0F, -8.0F, 1.0F, 26.0F, 8.0F, new Dilation(0.0F))
				.uv(102, 116).cuboid(-4.0F, -49.0F, -8.0F, 8.0F, 25.0F, 8.0F, new Dilation(0.0F))
				.uv(102, 149).cuboid(62.0F, -49.0F, -8.0F, 1.0F, 26.0F, 8.0F, new Dilation(0.0F))
				.uv(4, 132).cuboid(54.0F, -49.0F, -8.0F, 8.0F, 25.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-29.0F, -34.0656F, -10.914F, -0.0873F, 0.0F, 0.0F));

		ModelPartData bone3 = bone.addChild("bone3", ModelPartBuilder.create(), ModelTransform.pivot(-18.5F, -48.0F, -9.5F));

		ModelPartData cube_r3 = bone3.addChild("cube_r3", ModelPartBuilder.create().uv(4, 5).cuboid(16.5F, -39.5F, -18.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(32.5F, 38.5F, 16.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r4 = bone3.addChild("cube_r4", ModelPartBuilder.create().uv(0, 94).cuboid(15.5F, -66.0F, -0.5F, 1.0F, 75.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(18.5F, 38.0F, 15.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r5 = bone3.addChild("cube_r5", ModelPartBuilder.create().uv(216, 138).cuboid(15.25F, 5.5F, -2.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(201, 138).cuboid(15.0F, 5.0F, -3.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(40, 0).cuboid(15.5F, -66.0F, -19.0F, 1.0F, 75.0F, 19.0F, new Dilation(0.0F)), ModelTransform.of(18.5F, 38.0F, 16.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r6 = bone3.addChild("cube_r6", ModelPartBuilder.create().uv(197, 166).cuboid(15.25F, -29.5F, -1.25F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(18.5F, 38.0F, 16.1F, 0.0F, 1.5708F, 0.0F));

		ModelPartData bone2 = bone3.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, -6.0F, -3.8F));

		ModelPartData cube_r7 = bone2.addChild("cube_r7", ModelPartBuilder.create().uv(37, 209).cuboid(13.5F, -45.5F, -9.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(37, 209).cuboid(13.5F, -45.5F, -6.5F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(37, 178).cuboid(14.5F, -47.0F, -11.0F, 1.0F, 11.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(18.5F, 48.0F, 19.5F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r8 = bone2.addChild("cube_r8", ModelPartBuilder.create().uv(12, 228).cuboid(13.0F, -42.5F, -2.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(12, 228).cuboid(12.5F, -39.5F, -3.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(96, 225).cuboid(13.0F, -41.5F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(75, 193).cuboid(12.5F, -44.5F, -10.5F, 2.0F, 8.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(18.5F, 48.0F, 18.75F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r9 = bone2.addChild("cube_r9", ModelPartBuilder.create().uv(45, 239).cuboid(0.0F, -1.5F, -1.25F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(15.5F, 6.5F, 5.8F, 0.0F, 1.5708F, 0.0F));

		ModelPartData bone4 = bone.addChild("bone4", ModelPartBuilder.create(), ModelTransform.pivot(18.5F, -48.0F, -9.45F));

		ModelPartData cube_r10 = bone4.addChild("cube_r10", ModelPartBuilder.create().uv(130, 220).cuboid(15.65F, -29.5F, -12.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 5).cuboid(16.5F, -39.5F, -12.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(15.5F, -66.0F, -14.0F, 1.0F, 75.0F, 19.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, 38.0F, 15.95F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r11 = bone4.addChild("cube_r11", ModelPartBuilder.create().uv(223, 191).cuboid(15.4F, -29.0F, 0.25F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(221, 170).cuboid(15.25F, -29.5F, 0.75F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-18.5F, 38.0F, 16.05F, 0.0F, 1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}

	@Override
	public Animation getAnimationForDoorState(DoorHandler.AnimationDoorState animationDoorState) {
		return null;
	}

	@Override
	public ModelPart getPart() {
		return root;
	}
}
