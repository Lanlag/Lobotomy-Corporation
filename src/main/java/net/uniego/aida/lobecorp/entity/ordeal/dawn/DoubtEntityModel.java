package net.uniego.aida.lobecorp.entity.ordeal.dawn;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.uniego.aida.lobecorp.util.AnimationUtil;
import net.uniego.aida.lobecorp.util.MathUtil;

//疑问实体模型
@Environment(EnvType.CLIENT)
public class DoubtEntityModel<T extends DoubtEntity> extends SinglePartEntityModel<T> {
    private final ModelPart doubt;
    private final ModelPart waist;
    private final ModelPart leftLeg;
    private final ModelPart ll2;
    private final ModelPart ll3;
    private final ModelPart rightLeg;
    private final ModelPart rl2;
    private final ModelPart rl3;
    private final ModelPart body;
    private final ModelPart b1;
    private final ModelPart cloth1;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart gear1;
    private final ModelPart leftArm;
    private final ModelPart la2;
    private final ModelPart gear3;
    private final ModelPart cloth2;
    private final ModelPart gear2;

    public DoubtEntityModel(ModelPart root) {
        this.doubt = root.getChild("doubt");
        ModelPart height = doubt.getChild("height");
        this.waist = height.getChild("waist");
        this.leftLeg = waist.getChild("leftLeg");
        this.ll2 = leftLeg.getChild("ll2");
        this.ll3 = ll2.getChild("ll3");
        this.rightLeg = waist.getChild("rightLeg");
        this.rl2 = rightLeg.getChild("rl2");
        this.rl3 = rl2.getChild("rl3");
        this.body = waist.getChild("body");
        this.b1 = body.getChild("b1");
        this.cloth1 = b1.getChild("cloth1");
        this.neck = b1.getChild("neck");
        this.head = neck.getChild("head");
        this.gear1 = head.getChild("gear1");
        this.leftArm = b1.getChild("leftArm");
        this.la2 = leftArm.getChild("la2");
        this.gear3 = la2.getChild("gear3");
        this.cloth2 = b1.getChild("cloth2");
        this.gear2 = b1.getChild("gear2");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData doubt = modelPartData.addChild("doubt", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

        ModelPartData height = doubt.addChild("height", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData waist = height.addChild("waist", ModelPartBuilder.create().uv(32, 45).cuboid(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

        ModelPartData leftLeg = waist.addChild("leftLeg", ModelPartBuilder.create().uv(120, 0).cuboid(-1.25F, -1.0F, -1.25F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 1.0F, 0.0F));

        ModelPartData ll2 = leftLeg.addChild("ll2", ModelPartBuilder.create().uv(24, 65).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

        ModelPartData leftLeg_r1 = ll2.addChild("leftLeg_r1", ModelPartBuilder.create().uv(68, 37).cuboid(-1.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.75F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData ll3 = ll2.addChild("ll3", ModelPartBuilder.create().uv(25, 55).cuboid(-0.75F, 1.0F, -1.25F, 2.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData rl3_r1 = ll3.addChild("rl3_r1", ModelPartBuilder.create().uv(49, 58).cuboid(6.25F, -9.0F, -1.25F, 2.0F, 9.0F, 1.0F, new Dilation(0.01F)), ModelTransform.of(-6.5F, 10.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

        ModelPartData leftLeg_r2 = ll3.addChild("leftLeg_r2", ModelPartBuilder.create().uv(65, 69).cuboid(-1.25F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.25F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData ll3_r1 = ll3.addChild("ll3_r1", ModelPartBuilder.create().uv(71, 42).cuboid(-0.25F, 5.0F, -0.25F, 1.0F, 1.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 1.3868F, -0.6241F, -0.3491F, 0.0F, 0.0F));

        ModelPartData ll3_r2 = ll3.addChild("ll3_r2", ModelPartBuilder.create().uv(31, 72).cuboid(-0.25F, 0.0F, -0.25F, 1.0F, 6.0F, 0.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 1.25F, -1.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData rightLeg = waist.addChild("rightLeg", ModelPartBuilder.create().uv(120, 0).cuboid(-0.75F, -1.0F, -1.25F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 1.0F, 0.0F));

        ModelPartData rl2 = rightLeg.addChild("rl2", ModelPartBuilder.create().uv(0, 66).cuboid(-1.5F, -1.0F, 0.0F, 2.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 8.0F, 0.0F));

        ModelPartData leftLeg_r3 = rl2.addChild("leftLeg_r3", ModelPartBuilder.create().uv(46, 68).cuboid(-1.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.75F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData rl3 = rl2.addChild("rl3", ModelPartBuilder.create().uv(49, 58).cuboid(-1.75F, 1.0F, -1.25F, 2.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData leftLeg_r4 = rl3.addChild("leftLeg_r4", ModelPartBuilder.create().uv(70, 0).cuboid(-1.25F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 1.25F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData ll3_r3 = rl3.addChild("ll3_r3", ModelPartBuilder.create().uv(34, 71).cuboid(-0.25F, 0.0F, -0.25F, 1.0F, 6.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(-1.0F, 1.25F, -1.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData ll3_r4 = rl3.addChild("ll3_r4", ModelPartBuilder.create().uv(70, 45).cuboid(-0.25F, 5.0F, -0.25F, 1.0F, 1.0F, 3.0F, new Dilation(-0.3F)), ModelTransform.of(-1.0F, 1.3868F, -0.6241F, -0.3491F, 0.0F, 0.0F));

        ModelPartData rl3_r2 = rl3.addChild("rl3_r2", ModelPartBuilder.create().uv(49, 58).cuboid(-0.75F, -9.0F, -1.25F, 2.0F, 9.0F, 1.0F, new Dilation(0.01F)), ModelTransform.of(-1.0F, 10.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

        ModelPartData body = waist.addChild("body", ModelPartBuilder.create().uv(70, 4).cuboid(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(56, 67).cuboid(-0.75F, -7.0F, -0.25F, 1.5F, 7.0F, 1.5F, new Dilation(0.0F))
                .uv(70, 26).cuboid(-1.0F, -4.5F, -0.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(70, 30).cuboid(-1.0F, -7.25F, -0.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData b1 = body.addChild("b1", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -5.0F, -2.0F, 8.0F, 5.0F, 4.0F, new Dilation(0.0F))
                .uv(32, 9).cuboid(-3.99F, -5.3533F, -2.3543F, 8.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData b1_r1 = b1.addChild("b1_r1", ModelPartBuilder.create().uv(32, 41).cuboid(-3.99F, -12.5F, -0.5355F, 8.0F, 0.0F, 3.5355F, new Dilation(0.0F))
                .uv(32, 21).cuboid(-3.99F, -12.0F, -0.5355F, 8.0F, 3.5355F, 3.5355F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.6066F, 4.364F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cloth1 = b1.addChild("cloth1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.99F, 0.0F, 0.0F, 8.0F, 24.0F, 0.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, -2.8543F, -4.8543F));

        ModelPartData neck = b1.addChild("neck", ModelPartBuilder.create().uv(66, 8).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, -2.0F));

        ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(56, 20).cuboid(-1.99F, -6.3736F, -2.8508F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(32, 29).cuboid(-3.97F, -6.3736F, -0.8508F, 7.99F, 4.1122F, 3.0F, new Dilation(0.0F))
                .uv(32, 49).cuboid(-4.01F, -3.0F, -1.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(14, 66).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -3.0F, -2.0F, -0.1309F, 0.0F, 0.1745F));

        ModelPartData head_r2 = head.addChild("head_r2", ModelPartBuilder.create().uv(64, 61).cuboid(-1.3483F, -0.01F, 0.0052F, 2.8284F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.9571F, -3.0F, -4.0503F, 0.2182F, -0.7854F, 0.0F));

        ModelPartData head_r3 = head.addChild("head_r3", ModelPartBuilder.create().uv(64, 54).cuboid(-1.3483F, -0.01F, 0.0052F, 2.8284F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0503F, -3.0F, -3.9571F, 0.2182F, 0.7854F, 0.0F));

        ModelPartData head_r4 = head.addChild("head_r4", ModelPartBuilder.create().uv(6, 66).cuboid(0.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -3.0F, -2.0F, -0.1309F, 0.0F, -0.1745F));

        ModelPartData head_r5 = head.addChild("head_r5", ModelPartBuilder.create().uv(58, 8).cuboid(-1.99F, -3.9287F, -0.1676F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.9701F, -2.8203F, -0.5672F, 0.2618F, 0.0F));

        ModelPartData head_r6 = head.addChild("head_r6", ModelPartBuilder.create().uv(68, 20).cuboid(-0.01F, -3.9287F, -0.1676F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -2.9701F, -2.8203F, -0.5672F, -0.2618F, 0.0F));

        ModelPartData head_r7 = head.addChild("head_r7", ModelPartBuilder.create().uv(56, 37).cuboid(-2.0F, -5.0F, -5.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5299F, -1.3203F, -0.5672F, 0.0F, 0.0F));

        ModelPartData head_r8 = head.addChild("head_r8", ModelPartBuilder.create().uv(32, 36).cuboid(-3.98F, -1.5913F, 6.0F, 8.0F, 2.0F, 3.0F, new Dilation(0.03F))
                .uv(32, 14).cuboid(-3.98F, -1.5913F, 9.0F, 7.99F, 3.0F, 4.0F, new Dilation(0.03F)), ModelTransform.of(-0.01F, 3.9865F, -5.9179F, 0.7854F, 0.0F, 0.0F));

        ModelPartData head_r9 = head.addChild("head_r9", ModelPartBuilder.create().uv(56, 0).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, -5.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData gear1 = head.addChild("gear1", ModelPartBuilder.create().uv(52, 45).cuboid(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 3.0F));

        ModelPartData leftArm = b1.addChild("leftArm", ModelPartBuilder.create().uv(64, 43).cuboid(0.0F, 0.0F, 0.5F, 2.0F, 10.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.pivot(5.0F, -3.0F, 0.0F));

        ModelPartData leftArm_r1 = leftArm.addChild("leftArm_r1", ModelPartBuilder.create().uv(40, 61).cuboid(5.0F, 0.0F, 0.0F, 2.0F, 10.0F, 1.0F, new Dilation(0.2F)), ModelTransform.of(-5.0F, 0.0F, -1.5F, 0.0436F, 0.0F, 0.0F));

        ModelPartData leftArm_r2 = leftArm.addChild("leftArm_r2", ModelPartBuilder.create().uv(54, 29).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.7854F));

        ModelPartData leftArm_r3 = leftArm.addChild("leftArm_r3", ModelPartBuilder.create().uv(32, 53).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData la2 = leftArm.addChild("la2", ModelPartBuilder.create().uv(56, 14).cuboid(-1.0F, -1.0F, -2.25F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 10.0F, 0.0F));

        ModelPartData la2_r1 = la2.addChild("la2_r1", ModelPartBuilder.create().uv(24, 24).cuboid(-3.0F, 0.0F, 1.75F, 4.0F, 30.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.8475F, 0.0067F, -0.0663F, 0.0F, 0.0F));

        ModelPartData la2_r2 = la2.addChild("la2_r2", ModelPartBuilder.create().uv(16, 24).cuboid(0.0F, 0.0F, 0.0F, 4.0F, 30.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 1.0F, -2.25F, 0.0F, -1.5708F, -0.0663F));

        ModelPartData la2_r3 = la2.addChild("la2_r3", ModelPartBuilder.create().uv(8, 24).cuboid(-1.0F, 0.0F, -0.25F, 4.0F, 30.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.7509F, 0.9782F, -1.25F, 0.0663F, -1.5708F, 0.0F));

        ModelPartData la2_r4 = la2.addChild("la2_r4", ModelPartBuilder.create().uv(0, 24).cuboid(-2.0F, 0.0F, -0.25F, 4.0F, 30.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.9674F, -2.0021F, 0.0663F, 0.0F, 0.0F));

        ModelPartData gear3 = la2.addChild("gear3", ModelPartBuilder.create().uv(0, 54).cuboid(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 0.0F, 2.0F));

        ModelPartData cloth2 = b1.addChild("cloth2", ModelPartBuilder.create().uv(16, 0).cuboid(-3.99F, -0.1043F, 0.8947F, 8.0F, 24.0F, 0.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, -5.25F, 1.75F));

        ModelPartData gear2 = b1.addChild("gear2", ModelPartBuilder.create().uv(12, 54).cuboid(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -4.0F, 3.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        doubt.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return doubt;
    }

    @Override
    public void setAngles(DoubtEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        setDefaultPose();
        setDoubtPivot(entity);
        entity.gearAngle += MathUtil.degreeToRadians(1);
        setGearsAngle(limbAngle, limbDistance, entity.getGearAngle(), 2);
        if (entity.isAlive()) {
            AnimationUtil.rotateHead(headYaw, headPitch, head);
            walkAnimation(limbAngle, limbDistance, 0.8F);
        } else {
            AnimationUtil.rotateHead(0, 0, head);
            walkAnimation(0, 0, 0.0F);
        }
        this.updateAnimation(entity.attackingAnimationState, DoubtEntityAnimations.ATTACK, animationProgress);
        this.updateAnimation(entity.executeAnimationState, DoubtEntityAnimations.EXECUTE, animationProgress);
        this.updateAnimation(entity.dieAnimationState, DoubtEntityAnimations.DIE, animationProgress);
    }

    public void setDefaultPose() {
        waist.pitch = 0;
        body.yaw = 0;
        body.pitch = MathUtil.degreeToRadians(12.5F);
        head.pitch = MathUtil.degreeToRadians(-12.5F);
        neck.pitch = 0;
        leftArm.pitch = MathUtil.degreeToRadians(35F);
        la2.pitch = MathUtil.degreeToRadians(-97F);
        cloth1.pitch = MathUtil.degreeToRadians(-15F);
        cloth2.pitch = MathUtil.degreeToRadians(-2.5F);
        rightLeg.pitch = MathUtil.degreeToRadians(-5F);
        rl2.pitch = MathUtil.degreeToRadians(80F);
        rl3.pitch = MathUtil.degreeToRadians(-100F);
        leftLeg.pitch = MathUtil.degreeToRadians(-52.5F);
        ll2.pitch = MathUtil.degreeToRadians(92.5F);
        ll3.pitch = MathUtil.degreeToRadians(-67.5F);
        gear1.pitch = 0;
        gear2.pitch = 0;
        gear3.pitch = 0;
    }

    public void setDoubtPivot(DoubtEntity entity) {
        float pivotY = entity.deadPivotY;
        float pivotZ = entity.deadPivotZ;
        if (entity.isDead()) {
            if (pivotY < 25) {
                pivotY += 0.24F * 20 / 9;
                entity.setDeadPivotY(Math.min(pivotY, 25));
            }
            if (pivotZ > -6) {
                pivotZ += 0.24F * 20 / -6;
                entity.setDeadPivotZ(Math.max(pivotZ, -6));
            }
        }
        doubt.pivotY = pivotY;
        doubt.pivotZ = pivotZ;
    }

    public void setGearsAngle(float limbAngle, float limbDistance, float gearAngle, float speed) {
        gearAngle *= speed;
        gear1.pitch = MathHelper.cos(limbAngle * -0.7F) * limbDistance * 3 - gearAngle;
        gear2.pitch = MathHelper.cos(limbAngle * 0.4F + 60) * limbDistance * 3 + gearAngle;
        gear3.pitch = MathHelper.cos(limbAngle * 0.1F - 60) * limbDistance * 3 + gearAngle;
    }

    public void walkAnimation(float limbAngle, float limbDistance, float speed) {
        float amplitude = (float) MathHelper.clamp(limbDistance, 0, 0.33);
        amplitude = (float) (amplitude * (1 / 0.31));
        float i = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * 2 * speed) * 5F) * amplitude;
        float j = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * speed) * 25F - 25F) * amplitude;
        float k = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * speed) * -25F + 22.5F) * amplitude;

        float l = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * speed - 60) * -15F + 15F) * amplitude;
        float m = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * speed - 60) * 15F + 2.5F) * amplitude;

        float n = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * speed - 120) * -25F + 15F) * amplitude;
        float o = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * speed - 120) * 25F - 17.5F) * amplitude;

        float p = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * speed) * 5F) * amplitude;

        float q = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * 2 * speed + 30) * 5F) * amplitude;
        float r = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * 2 * speed + 45) * 3F) * amplitude;
        float s = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * 2 * speed + 45) * -6F - 6) * amplitude;
        float t = MathUtil.degreeToRadians(MathHelper.sin(limbAngle * 2 * speed + 60) * -3F + 3) * amplitude;

        doubt.pivotY += (MathHelper.sin(limbAngle * 2 * speed) - 0.5F) * amplitude;
        doubt.pivotZ -= (MathHelper.sin(limbAngle * 2 * speed) * 2 - 1F) * amplitude;

        waist.pitch += q;
        body.pitch += i;
        body.yaw += r;
        rightLeg.pitch += j;
        leftLeg.pitch += k;
        rl2.pitch += l;
        ll2.pitch += m;
        rl3.pitch += n;
        ll3.pitch += o;

        la2.pitch += p;

        cloth1.pitch += s;
        cloth2.pitch += t;
    }
}
