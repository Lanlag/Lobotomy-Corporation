package net.uniego.aida.lobecorp.item.ego.gift.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;

//忏悔饰品模型
@Environment(EnvType.CLIENT)
public class PenitenceGiftModel extends LobeCorpItemModel {
    private final ModelPart hat;
    private final ModelPart head;
    private final ModelPart SS;
    private final ModelPart body;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;

    public PenitenceGiftModel(ModelPart root) {
        super(root);
        this.hat = root.getChild("hat");
        this.head = root.getChild("head");
        this.SS = this.head.getChild("SS");
        this.body = root.getChild("body");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(92, 22).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(20, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.4631F, -5.7331F, 4.5125F, -3.1416F, 0.0F, 2.5656F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(96, 3).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.4631F, -5.7331F, 4.5125F, -3.1416F, 0.0F, 1.9984F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(21, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(15, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-1.6119F, -7.0331F, 4.5125F, -3.1416F, 0.0F, 1.4748F));

        ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(21, 95).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-1.6119F, -7.0331F, 4.5125F, -3.1416F, 0.0F, 0.9076F));

        ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(7, 95).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(10, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-0.1744F, -6.8706F, 4.5125F, -3.1416F, 0.0F, 2.3475F));

        ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(63, 96).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-0.1744F, -6.8706F, 4.5125F, -3.1416F, 0.0F, 1.7802F));

        ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(99, 24).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(56, 96).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(56, 96).cuboid(-0.9869F, -0.6733F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(99, 24).cuboid(-0.5119F, -0.5233F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-1.1994F, -5.7206F, 4.775F, 0.0F, 0.0F, -1.1912F));

        ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(77, 96).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(77, 96).cuboid(-0.918F, -0.3468F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-1.1994F, -5.7206F, 4.775F, 0.0F, 0.0F, -0.624F));

        ModelPartData cube_r9 = head.addChild("cube_r9", ModelPartBuilder.create().uv(0, 95).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(0, 95).cuboid(-0.918F, -0.3468F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.0131F, -4.1456F, 4.775F, 0.0F, 0.0F, -1.2392F));

        ModelPartData cube_r10 = head.addChild("cube_r10", ModelPartBuilder.create().uv(35, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(98, 80).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(98, 80).cuboid(-0.5119F, -0.5233F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(35, 92).cuboid(-0.9869F, -0.6733F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.0131F, -4.1456F, 4.775F, 0.0F, 0.0F, -1.8064F));

        ModelPartData cube_r11 = head.addChild("cube_r11", ModelPartBuilder.create().uv(96, 12).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(96, 12).cuboid(-0.918F, -0.3468F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(0.9506F, -4.8956F, 4.775F, 0.0F, 0.0F, -0.8814F));

        ModelPartData cube_r12 = head.addChild("cube_r12", ModelPartBuilder.create().uv(49, 95).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(50, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(50, 98).cuboid(-0.5119F, -0.5233F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(49, 95).cuboid(-0.9869F, -0.6733F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(0.9506F, -4.8956F, 4.775F, 0.0F, 0.0F, -1.4486F));

        ModelPartData cube_r13 = head.addChild("cube_r13", ModelPartBuilder.create().uv(90, 91).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(96, 97).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-3.0119F, -4.4206F, 4.6375F, -3.1416F, 0.0F, -1.7104F));

        ModelPartData cube_r14 = head.addChild("cube_r14", ModelPartBuilder.create().uv(90, 88).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-3.0119F, -4.4206F, 4.6375F, -3.1416F, 0.0F, -2.2777F));

        ModelPartData cube_r15 = head.addChild("cube_r15", ModelPartBuilder.create().uv(7, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(97, 94).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-4.0369F, -4.5831F, 4.6375F, -3.1416F, 0.0F, 2.042F));

        ModelPartData cube_r16 = head.addChild("cube_r16", ModelPartBuilder.create().uv(14, 92).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-4.0369F, -4.5831F, 4.6375F, -3.1416F, 0.0F, 1.4748F));

        ModelPartData cube_r17 = head.addChild("cube_r17", ModelPartBuilder.create().uv(92, 28).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(5, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-2.4619F, -5.2956F, 4.6375F, -3.1416F, 0.0F, 1.0385F));

        ModelPartData cube_r18 = head.addChild("cube_r18", ModelPartBuilder.create().uv(90, 94).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-2.4619F, -5.2956F, 4.6375F, -3.1416F, 0.0F, 0.4712F));

        ModelPartData cube_r19 = head.addChild("cube_r19", ModelPartBuilder.create().uv(49, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(25, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(0.4131F, -6.5956F, 4.6375F, -3.1416F, 0.0F, 1.0385F));

        ModelPartData cube_r20 = head.addChild("cube_r20", ModelPartBuilder.create().uv(42, 95).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(0.4131F, -6.5956F, 4.6375F, -3.1416F, 0.0F, 0.4712F));

        ModelPartData cube_r21 = head.addChild("cube_r21", ModelPartBuilder.create().uv(42, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(0, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.0631F, -7.2581F, 4.6375F, -3.1416F, 0.0F, 1.3003F));

        ModelPartData cube_r22 = head.addChild("cube_r22", ModelPartBuilder.create().uv(96, 0).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.0631F, -7.2581F, 4.6375F, -3.1416F, 0.0F, 0.733F));

        ModelPartData cube_r23 = head.addChild("cube_r23", ModelPartBuilder.create().uv(35, 95).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(4.5881F, -7.1331F, 4.6375F, -3.1416F, 0.0F, 1.7977F));

        ModelPartData cube_r24 = head.addChild("cube_r24", ModelPartBuilder.create().uv(30, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(28, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(4.5881F, -7.1331F, 4.6375F, -3.1416F, 0.0F, 2.3649F));

        ModelPartData cube_r25 = head.addChild("cube_r25", ModelPartBuilder.create().uv(35, 98).cuboid(-0.6494F, -0.3483F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(99, 21).cuboid(-0.7744F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(99, 18).cuboid(-0.6119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(35, 98).cuboid(-0.6494F, -0.3483F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(99, 21).cuboid(-0.7744F, -0.5233F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(99, 18).cuboid(-0.6119F, -0.5233F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(4.0506F, -4.9956F, 4.775F, 0.0F, 0.0F, 1.3003F));

        ModelPartData cube_r26 = head.addChild("cube_r26", ModelPartBuilder.create().uv(70, 96).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(70, 96).cuboid(-0.9869F, -0.6733F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(4.0506F, -4.9956F, 4.775F, 0.0F, 0.0F, 1.1956F));

        ModelPartData cube_r27 = head.addChild("cube_r27", ModelPartBuilder.create().uv(84, 97).cuboid(-1.018F, -0.1593F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(84, 97).cuboid(-1.018F, -0.1593F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(4.0506F, -4.9956F, 4.775F, 0.0F, 0.0F, 1.9766F));

        ModelPartData cube_r28 = head.addChild("cube_r28", ModelPartBuilder.create().uv(14, 95).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(45, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(45, 98).cuboid(-0.5119F, -0.5233F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(14, 95).cuboid(-0.9869F, -0.6733F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(0.4631F, -5.9456F, 4.775F, 0.0F, 0.0F, 1.9984F));

        ModelPartData cube_r29 = head.addChild("cube_r29", ModelPartBuilder.create().uv(96, 9).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(96, 9).cuboid(-0.918F, -0.3468F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(0.4631F, -5.9456F, 4.775F, 0.0F, 0.0F, 2.5656F));

        ModelPartData cube_r30 = head.addChild("cube_r30", ModelPartBuilder.create().uv(28, 95).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(99, 15).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(99, 15).cuboid(-0.5119F, -0.5233F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(28, 95).cuboid(-0.9869F, -0.6733F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-2.9869F, -6.8706F, 4.775F, 0.0F, 0.0F, 1.789F));

        ModelPartData cube_r31 = head.addChild("cube_r31", ModelPartBuilder.create().uv(96, 6).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(96, 6).cuboid(-0.918F, -0.3468F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-2.9869F, -6.8706F, 4.775F, 0.0F, 0.0F, 2.3562F));

        ModelPartData cube_r32 = head.addChild("cube_r32", ModelPartBuilder.create().uv(98, 83).cuboid(-0.85F, 0.0875F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(0, 92).cuboid(-1.325F, -0.0625F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(98, 83).cuboid(-0.85F, 0.0875F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(0, 92).cuboid(-1.325F, -0.0625F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-3.9888F, -7.0706F, 4.775F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r33 = head.addChild("cube_r33", ModelPartBuilder.create().uv(97, 91).cuboid(-0.1375F, -0.3125F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(97, 91).cuboid(-0.1375F, -0.3125F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-4.5801F, -6.2196F, 4.775F, 0.0F, 0.0F, 3.0543F));

        ModelPartData cube_r34 = head.addChild("cube_r34", ModelPartBuilder.create().uv(91, 97).cuboid(-0.625F, -0.4375F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(91, 97).cuboid(-0.625F, -0.4375F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-5.128F, -6.1716F, 4.775F, 0.0F, 0.0F, -2.9234F));

        ModelPartData cube_r35 = head.addChild("cube_r35", ModelPartBuilder.create().uv(97, 88).cuboid(-0.5375F, -0.6625F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(97, 88).cuboid(-0.5375F, -0.6625F, -10.1375F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-5.1487F, -6.4082F, 4.775F, 0.0F, 0.0F, 2.8536F));

        ModelPartData cube_r36 = head.addChild("cube_r36", ModelPartBuilder.create().uv(60, 84).cuboid(-1.0F, -1.25F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(60, 84).cuboid(-1.0F, -1.25F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-4.8763F, -7.3104F, 4.775F, 0.0F, 0.0F, 2.8362F));

        ModelPartData cube_r37 = head.addChild("cube_r37", ModelPartBuilder.create().uv(92, 19).cuboid(-0.875F, 0.35F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(92, 19).cuboid(-0.875F, 0.35F, -10.1375F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-3.9888F, -7.0706F, 4.775F, 0.0F, 0.0F, 1.6144F));

        ModelPartData cube_r38 = head.addChild("cube_r38", ModelPartBuilder.create().uv(40, 98).cuboid(-1.125F, -0.725F, -0.875F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(92, 25).cuboid(-1.5375F, -0.875F, -0.875F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(40, 98).cuboid(-1.125F, -0.725F, -10.225F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(92, 25).cuboid(-1.5375F, -0.875F, -10.225F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-4.0617F, -4.2478F, 5.0125F, 0.0F, 0.0F, -0.685F));

        ModelPartData cube_r39 = head.addChild("cube_r39", ModelPartBuilder.create().uv(92, 16).cuboid(-1.6375F, -0.25F, -0.875F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(92, 16).cuboid(-1.6375F, -0.25F, -10.225F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-4.0617F, -4.2478F, 5.0125F, 0.0F, 0.0F, -0.1745F));

        ModelPartData cube_r40 = head.addChild("cube_r40", ModelPartBuilder.create().uv(90, 88).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-3.0119F, -4.4206F, -4.7125F, -3.1416F, 0.0F, -2.2777F));

        ModelPartData cube_r41 = head.addChild("cube_r41", ModelPartBuilder.create().uv(96, 97).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(90, 91).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-3.0119F, -4.4206F, -4.7125F, -3.1416F, 0.0F, -1.7104F));

        ModelPartData cube_r42 = head.addChild("cube_r42", ModelPartBuilder.create().uv(14, 92).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-4.0369F, -4.5831F, -4.7125F, -3.1416F, 0.0F, 1.4748F));

        ModelPartData cube_r43 = head.addChild("cube_r43", ModelPartBuilder.create().uv(97, 94).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(7, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-4.0369F, -4.5831F, -4.7125F, -3.1416F, 0.0F, 2.042F));

        ModelPartData cube_r44 = head.addChild("cube_r44", ModelPartBuilder.create().uv(90, 94).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-2.4619F, -5.2956F, -4.7125F, -3.1416F, 0.0F, 0.4712F));

        ModelPartData cube_r45 = head.addChild("cube_r45", ModelPartBuilder.create().uv(5, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(92, 28).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-2.4619F, -5.2956F, -4.7125F, -3.1416F, 0.0F, 1.0385F));

        ModelPartData cube_r46 = head.addChild("cube_r46", ModelPartBuilder.create().uv(42, 95).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(0.4131F, -6.5956F, -4.7125F, -3.1416F, 0.0F, 0.4712F));

        ModelPartData cube_r47 = head.addChild("cube_r47", ModelPartBuilder.create().uv(25, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(49, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(0.4131F, -6.5956F, -4.7125F, -3.1416F, 0.0F, 1.0385F));

        ModelPartData cube_r48 = head.addChild("cube_r48", ModelPartBuilder.create().uv(20, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(92, 22).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.4631F, -5.7331F, -4.55F, -3.1416F, 0.0F, 2.5656F));

        ModelPartData cube_r49 = head.addChild("cube_r49", ModelPartBuilder.create().uv(96, 3).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.4631F, -5.7331F, -4.55F, -3.1416F, 0.0F, 1.9984F));

        ModelPartData cube_r50 = head.addChild("cube_r50", ModelPartBuilder.create().uv(15, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(21, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-1.6119F, -7.0331F, -4.55F, -3.1416F, 0.0F, 1.4748F));

        ModelPartData cube_r51 = head.addChild("cube_r51", ModelPartBuilder.create().uv(21, 95).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-1.6119F, -7.0331F, -4.55F, -3.1416F, 0.0F, 0.9076F));

        ModelPartData cube_r52 = head.addChild("cube_r52", ModelPartBuilder.create().uv(10, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(7, 95).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-0.1744F, -6.8706F, -4.55F, -3.1416F, 0.0F, 2.3475F));

        ModelPartData cube_r53 = head.addChild("cube_r53", ModelPartBuilder.create().uv(63, 96).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(-0.1744F, -6.8706F, -4.55F, -3.1416F, 0.0F, 1.7802F));

        ModelPartData cube_r54 = head.addChild("cube_r54", ModelPartBuilder.create().uv(96, 0).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.0631F, -7.2581F, -4.7125F, -3.1416F, 0.0F, 0.733F));

        ModelPartData cube_r55 = head.addChild("cube_r55", ModelPartBuilder.create().uv(0, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(42, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(3.0631F, -7.2581F, -4.7125F, -3.1416F, 0.0F, 1.3003F));

        ModelPartData cube_r56 = head.addChild("cube_r56", ModelPartBuilder.create().uv(28, 92).cuboid(-0.9869F, -0.6733F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F))
                .uv(30, 98).cuboid(-0.5119F, -0.5233F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(4.5881F, -7.1331F, -4.7125F, -3.1416F, 0.0F, 2.3649F));

        ModelPartData cube_r57 = head.addChild("cube_r57", ModelPartBuilder.create().uv(35, 95).cuboid(-0.918F, -0.3468F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(-0.375F)), ModelTransform.of(4.5881F, -7.1331F, -4.7125F, -3.1416F, 0.0F, 1.7977F));

        ModelPartData SS = head.addChild("SS", ModelPartBuilder.create().uv(68, 56).cuboid(-1.0F, 0.2875F, -0.8125F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(68, 48).cuboid(-8.7593F, -1.7697F, -0.8125F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(85, 40).cuboid(-5.45F, -1.975F, -0.5F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(38, 68).cuboid(-8.7593F, -1.7697F, 3.15F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(68, 40).cuboid(-1.0F, 0.2875F, 3.15F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(89, 64).cuboid(-5.45F, -1.975F, 2.875F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(3.8593F, -5.2928F, -4.225F));

        ModelPartData cube_r58 = SS.addChild("cube_r58", ModelPartBuilder.create().uv(51, 76).cuboid(-2.7625F, -0.475F, -0.5F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 76).cuboid(-2.7625F, -0.475F, -3.875F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -1.475F, 3.375F, 0.0F, 0.0F, -0.4014F));

        ModelPartData cube_r59 = SS.addChild("cube_r59", ModelPartBuilder.create().uv(75, 88).cuboid(-0.325F, -0.35F, -0.5F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(99, 27).cuboid(-0.8375F, -0.35F, -3.875F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(85, 48).cuboid(-0.325F, -0.35F, -3.875F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -1.475F, 3.375F, 0.0F, 0.0F, -0.2531F));

        ModelPartData cube_r60 = SS.addChild("cube_r60", ModelPartBuilder.create().uv(19, 68).cuboid(-3.9375F, -0.2125F, -0.5F, 3.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 68).cuboid(-3.9375F, -0.2125F, -3.875F, 3.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 3.375F, 0.0F, 0.0F, 0.4014F));

        ModelPartData cube_r61 = SS.addChild("cube_r61", ModelPartBuilder.create().uv(89, 72).cuboid(-4.825F, -0.8F, -0.5F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(85, 32).cuboid(-4.825F, -0.8F, -3.875F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 3.375F, 0.0F, 0.0F, 0.2531F));

        ModelPartData cube_r62 = SS.addChild("cube_r62", ModelPartBuilder.create().uv(34, 76).cuboid(-1.0F, -0.275F, -0.5F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(72, 72).cuboid(-1.0F, -0.275F, -3.875F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 3.375F, 0.0F, 0.0F, 0.3403F));

        ModelPartData cube_r63 = SS.addChild("cube_r63", ModelPartBuilder.create().uv(77, 24).cuboid(0.325F, -0.5125F, -0.5F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(77, 16).cuboid(-0.25F, -0.5125F, -0.5F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(30, 84).cuboid(-0.25F, -0.5125F, -4.4625F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(45, 84).cuboid(0.325F, -0.5125F, -4.4625F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.1337F, 0.4378F, 3.65F, 0.0F, 0.0F, 0.2923F));

        ModelPartData cube_r64 = SS.addChild("cube_r64", ModelPartBuilder.create().uv(85, 56).cuboid(-0.6125F, -0.5875F, -0.5F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(60, 88).cuboid(-0.6125F, -0.5875F, -4.2F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-7.921F, 1.0449F, 3.5375F, 0.0F, 0.0F, -0.1178F));

        ModelPartData cube_r65 = SS.addChild("cube_r65", ModelPartBuilder.create().uv(81, 8).cuboid(1.025F, -0.4625F, -0.5F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(17, 76).cuboid(-0.3125F, -0.4625F, -0.5F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(15, 84).cuboid(1.025F, -0.4625F, -4.2F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(72, 64).cuboid(-0.3125F, -0.4625F, -4.2F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-1.1099F, -1.5857F, 3.5375F, 0.0F, 0.0F, -0.0262F));

        ModelPartData cube_r66 = SS.addChild("cube_r66", ModelPartBuilder.create().uv(68, 80).cuboid(-0.4625F, -0.4F, -0.5F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(81, 0).cuboid(-0.4625F, -0.4F, -4.2F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-1.8913F, -1.5768F, 3.5375F, 0.0F, 0.0F, -0.1396F));

        ModelPartData cube_r67 = SS.addChild("cube_r67", ModelPartBuilder.create().uv(83, 80).cuboid(3.18F, -0.9355F, -0.5F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(58, 0).cuboid(-1.8075F, -0.9355F, -0.5F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(58, 8).cuboid(-1.8075F, -0.9355F, -4.2F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 84).cuboid(3.18F, -0.9355F, -4.2F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-5.849F, 0.6189F, 3.5375F, 0.0F, 0.0F, -0.4102F));

        ModelPartData cube_r68 = SS.addChild("cube_r68", ModelPartBuilder.create().uv(68, 32).cuboid(-4.0444F, -0.5956F, -0.5F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(55, 68).cuboid(-4.0444F, -0.5956F, -4.4625F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.9789F, -0.2358F, 3.65F, 0.0F, 0.0F, 0.2356F));

        ModelPartData cube_r69 = SS.addChild("cube_r69", ModelPartBuilder.create().uv(58, 16).cuboid(-2.1177F, -0.2238F, -0.5F, 3.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(58, 24).cuboid(-2.1177F, -0.2238F, -4.4625F, 3.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.9789F, -0.2358F, 3.65F, 0.0F, 0.0F, 0.4145F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        hat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}