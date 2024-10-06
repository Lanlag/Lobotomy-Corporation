package net.uniego.aida.lobecorp.entity.abnormality.beautyandtheBeast;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

//美女与野兽实体模型
@Environment(EnvType.CLIENT)
public class BeautyAndTheBeastEntityModel extends EntityModel<BeautyAndTheBeastEntity> {
    private final ModelPart Head;
    private final ModelPart Eye;
    private final ModelPart Body;
    private final ModelPart RightArm;
    private final ModelPart RightHand;
    private final ModelPart LeftArm;
    private final ModelPart LeftHand;
    private final ModelPart RightLeg;
    private final ModelPart RightLowerLeg;
    private final ModelPart LeftLeg;
    private final ModelPart LeftLowerLeg;

    public BeautyAndTheBeastEntityModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.Eye = this.Head.getChild("Eye");
        this.Body = root.getChild("Body");
        this.RightArm = root.getChild("RightArm");
        this.RightHand = this.RightArm.getChild("RightHand");
        this.LeftArm = root.getChild("LeftArm");
        this.LeftHand = this.LeftArm.getChild("LeftHand");
        this.RightLeg = root.getChild("RightLeg");
        this.RightLowerLeg = this.RightLeg.getChild("RightLowerLeg");
        this.LeftLeg = root.getChild("LeftLeg");
        this.LeftLowerLeg = this.LeftLeg.getChild("LeftLowerLeg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Head = modelPartData.addChild("Head", ModelPartBuilder.create().uv(1584, 215).cuboid(-3.0F, -26.95F, 6.5F, 6.0F, 8.0F, 6.0F, new Dilation(0.0F))
                .uv(1527, 581).cuboid(-56.5914F, -74.6455F, -39.4025F, 100.0F, 100.0F, 100.0F, new Dilation(-49.1875F))
                .uv(1527, 581).mirrored().cuboid(-41.9961F, -76.958F, -39.5275F, 100.0F, 100.0F, 100.0F, new Dilation(-49.3375F)).mirrored(false)
                .uv(1527, 581).mirrored().cuboid(-43.4086F, -74.6455F, -39.4025F, 100.0F, 100.0F, 100.0F, new Dilation(-49.5375F)).mirrored(false)
                .uv(1527, 581).cuboid(-58.8039F, -76.0955F, -39.5275F, 100.0F, 100.0F, 100.0F, new Dilation(-49.2F))
                .uv(1527, 581).cuboid(-57.3164F, -77.2955F, -39.5275F, 100.0F, 100.0F, 100.0F, new Dilation(-49.4625F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r1 = Head.addChild("cube_r1", ModelPartBuilder.create().uv(1584, 199).cuboid(-0.65F, -1.875F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1584, 199).cuboid(-0.5F, -1.675F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1584, 199).cuboid(-0.3375F, -1.425F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1584, 199).cuboid(-0.175F, -1.175F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F)), ModelTransform.of(-0.7652F, -16.7712F, 13.5849F, 0.3863F, 0.2444F, -0.5367F));

        ModelPartData cube_r2 = Head.addChild("cube_r2", ModelPartBuilder.create().uv(1584, 199).cuboid(-1.2F, -0.325F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F)), ModelTransform.of(-1.2398F, -17.5341F, 13.2128F, 0.1235F, 0.4378F, -1.2858F));

        ModelPartData cube_r3 = Head.addChild("cube_r3", ModelPartBuilder.create().uv(1584, 199).cuboid(-1.4375F, 0.4625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1584, 199).cuboid(-1.2875F, 0.4625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1584, 199).cuboid(-1.125F, 0.4625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1584, 199).cuboid(-1.575F, 0.4625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1584, 199).cuboid(-1.7F, 0.4625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1584, 199).cuboid(-1.8375F, 0.4625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4125F)), ModelTransform.of(-1.4875F, -19.0324F, 12.482F, 0.3658F, 0.2748F, -0.6164F));

        ModelPartData cube_r4 = Head.addChild("cube_r4", ModelPartBuilder.create().uv(1536, 128).cuboid(-0.8125F, -4.5F, -1.4F, 1.0F, 8.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1536, 128).cuboid(-0.75F, -4.5F, -1.4F, 1.0F, 8.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1536, 128).cuboid(-0.6F, -4.5F, -1.4F, 1.0F, 8.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1536, 128).cuboid(-0.4625F, -4.5F, -1.4F, 1.0F, 8.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1536, 128).cuboid(-0.325F, -4.5F, -1.4F, 1.0F, 8.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1536, 128).cuboid(-0.175F, -4.5F, -1.4F, 1.0F, 8.0F, 1.0F, new Dilation(-0.4125F))
                .uv(1584, 199).cuboid(-0.8875F, -4.5F, -1.4625F, 2.0F, 4.0F, 1.0F, new Dilation(-0.4125F)), ModelTransform.of(-1.6F, -17.2073F, 14.4431F, 0.4538F, 0.0F, 0.0F));

        ModelPartData cube_r5 = Head.addChild("cube_r5", ModelPartBuilder.create().uv(1527, 581).cuboid(-51.125F, -48.5875F, -50.0625F, 100.0F, 100.0F, 100.0F, new Dilation(-48.825F)), ModelTransform.of(-9.016F, -25.7664F, 10.326F, -0.0145F, -0.3124F, -0.7783F));

        ModelPartData cube_r6 = Head.addChild("cube_r6", ModelPartBuilder.create().uv(1527, 581).cuboid(-48.6875F, -49.7125F, -51.5375F, 100.0F, 100.0F, 100.0F, new Dilation(-48.325F)), ModelTransform.of(-5.9125F, -28.65F, 11.425F, 0.0785F, 0.0F, 0.0F));

        ModelPartData cube_r7 = Head.addChild("cube_r7", ModelPartBuilder.create().uv(1527, 581).mirrored().cuboid(-48.875F, -48.5875F, -50.0625F, 100.0F, 100.0F, 100.0F, new Dilation(-48.825F)).mirrored(false), ModelTransform.of(9.016F, -25.7664F, 10.326F, -0.0145F, 0.3124F, 0.7783F));

        ModelPartData cube_r8 = Head.addChild("cube_r8", ModelPartBuilder.create().uv(1527, 581).mirrored().cuboid(-50.6375F, -49.7125F, -51.5375F, 100.0F, 100.0F, 100.0F, new Dilation(-48.9375F)).mirrored(false), ModelTransform.of(5.9125F, -28.65F, 11.425F, 0.5192F, 0.0F, 0.0F));

        ModelPartData cube_r9 = Head.addChild("cube_r9", ModelPartBuilder.create().uv(1615, 182).mirrored().cuboid(-1.325F, -4.0125F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(-0.675F)).mirrored(false)
                .uv(1615, 182).mirrored().cuboid(-1.3875F, -2.425F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(-0.475F)).mirrored(false)
                .uv(1616, 183).mirrored().cuboid(-0.7875F, -5.5125F, -1.0125F, 2.0F, 3.0F, 2.0F, new Dilation(-0.5125F)).mirrored(false), ModelTransform.of(-8.2728F, -24.8231F, 9.5F, 0.0F, 0.0F, 3.0412F));

        ModelPartData cube_r10 = Head.addChild("cube_r10", ModelPartBuilder.create().uv(1615, 182).mirrored().cuboid(-1.375F, -1.775F, -1.5F, 3.0F, 2.0F, 3.0F, new Dilation(-0.1875F)).mirrored(false), ModelTransform.of(-7.6111F, -25.71F, 9.5F, 0.0F, 0.0F, -2.7402F));

        ModelPartData cube_r11 = Head.addChild("cube_r11", ModelPartBuilder.create().uv(1615, 182).mirrored().cuboid(1.95F, -5.375F, -1.5F, 3.0F, 2.0F, 3.0F, new Dilation(-0.125F)).mirrored(false), ModelTransform.of(-1.9309F, -25.6952F, 9.5F, 0.0F, 0.0F, -2.2209F));

        ModelPartData cube_r12 = Head.addChild("cube_r12", ModelPartBuilder.create().uv(1615, 182).mirrored().cuboid(-0.05F, -5.3125F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(-0.0375F)).mirrored(false), ModelTransform.of(-1.9309F, -25.6952F, 9.5F, 0.0F, 0.0F, -1.7715F));

        ModelPartData cube_r13 = Head.addChild("cube_r13", ModelPartBuilder.create().uv(1615, 182).mirrored().cuboid(-1.5F, -3.0F, -1.5F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.4103F, -25.8372F, 9.5F, 0.0F, 0.0F, -1.2828F));

        ModelPartData cube_r14 = Head.addChild("cube_r14", ModelPartBuilder.create().uv(1583, 229).cuboid(-3.5F, -2.5F, 1.4375F, 7.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -16.775F, 9.5F, 0.2313F, 0.0F, 0.0F));

        ModelPartData cube_r15 = Head.addChild("cube_r15", ModelPartBuilder.create().uv(1616, 183).cuboid(-1.2125F, -5.5125F, -1.0125F, 2.0F, 3.0F, 2.0F, new Dilation(-0.5125F))
                .uv(1615, 182).cuboid(-1.675F, -4.0125F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(-0.675F))
                .uv(1615, 182).cuboid(-1.6125F, -2.425F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(-0.475F)), ModelTransform.of(8.2728F, -24.8231F, 9.5F, 0.0F, 0.0F, -3.0412F));

        ModelPartData cube_r16 = Head.addChild("cube_r16", ModelPartBuilder.create().uv(1615, 182).cuboid(-1.625F, -1.775F, -1.5F, 3.0F, 2.0F, 3.0F, new Dilation(-0.1875F)), ModelTransform.of(7.6111F, -25.71F, 9.5F, 0.0F, 0.0F, 2.7402F));

        ModelPartData cube_r17 = Head.addChild("cube_r17", ModelPartBuilder.create().uv(1615, 182).cuboid(-4.95F, -5.375F, -1.5F, 3.0F, 2.0F, 3.0F, new Dilation(-0.125F)), ModelTransform.of(1.9309F, -25.6952F, 9.5F, 0.0F, 0.0F, 2.2209F));

        ModelPartData cube_r18 = Head.addChild("cube_r18", ModelPartBuilder.create().uv(1615, 182).cuboid(-2.95F, -5.3125F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(-0.0375F)), ModelTransform.of(1.9309F, -25.6952F, 9.5F, 0.0F, 0.0F, 1.7715F));

        ModelPartData cube_r19 = Head.addChild("cube_r19", ModelPartBuilder.create().uv(1615, 182).cuboid(-1.5F, -3.0F, -1.5F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.4103F, -25.8372F, 9.5F, 0.0F, 0.0F, 1.2828F));

        ModelPartData Eye = Head.addChild("Eye", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3875F, -273.9375F, -237.05F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).mirrored().cuboid(-250.7125F, -273.5125F, -236.9625F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r20 = Eye.addChild("cube_r20", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.65F, -250.5914F, -249.4706F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7625F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.6125F, -250.9414F, -249.5206F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).cuboid(-250.2875F, -250.5164F, -249.6706F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.3125F, -250.8539F, -249.4581F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r21 = Eye.addChild("cube_r21", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.725F, -249.6625F, -250.45F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, -0.2182F, 0.2182F, 0.0F));

        ModelPartData cube_r22 = Eye.addChild("cube_r22", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.1625F, -250.5F, -250.0F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.8F, -22.8F, 12.95F, -0.1309F, -0.1309F, 0.0F));

        ModelPartData cube_r23 = Eye.addChild("cube_r23", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.8584F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.8584F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.8584F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.5672F, 0.2618F, 0.0F));

        ModelPartData cube_r24 = Eye.addChild("cube_r24", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-249.825F, -250.9625F, -250.6F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, 0.1309F, -0.1309F, 0.0F));

        ModelPartData cube_r25 = Eye.addChild("cube_r25", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3448F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.3448F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.3448F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.5672F, 0.0873F, 0.0F));

        ModelPartData cube_r26 = Eye.addChild("cube_r26", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-249.5625F, -249.7625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, -0.1745F, -0.1309F, 0.0F));

        ModelPartData cube_r27 = Eye.addChild("cube_r27", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-249.55F, -250.2375F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).cuboid(-249.075F, -250.2375F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-1.1875F, -22.8F, 13.5F, -0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r28 = Eye.addChild("cube_r28", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8772F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.8772F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.8772F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.6545F, -0.1745F, 0.0F));

        ModelPartData cube_r29 = Eye.addChild("cube_r29", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-249.9375F, -249.975F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, -0.1745F, -0.1745F, 0.0F));

        ModelPartData cube_r30 = Eye.addChild("cube_r30", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.2375F, -250.5F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, 0.0F, 0.2618F, 0.0F));

        ModelPartData cube_r31 = Eye.addChild("cube_r31", ModelPartBuilder.create().uv(-170, -225).cuboid(-251.4375F, -251.5125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).mirrored().cuboid(-251.925F, -251.9625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.9375F, -251.5125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).cuboid(-251.45F, -251.9625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r32 = Eye.addChild("cube_r32", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.95F, -251.7F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.5125F, -251.7F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.95F, -252.125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.3875F, 0.2618F, 0.2182F, 0.0F));

        ModelPartData cube_r33 = Eye.addChild("cube_r33", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.6552F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.6552F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.6552F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.5672F, -0.0873F, 0.0F));

        ModelPartData cube_r34 = Eye.addChild("cube_r34", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.4045F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4045F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4045F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.6894F, -0.384F, 0.0F));

        ModelPartData cube_r35 = Eye.addChild("cube_r35", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.5642F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.5642F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.5642F, -250.5046F, -248.6812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.5585F, -0.5585F, 0.0F));

        ModelPartData cube_r36 = Eye.addChild("cube_r36", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7898F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.7898F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.7898F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.3054F, -0.9163F, 0.0F));

        ModelPartData cube_r37 = Eye.addChild("cube_r37", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6177F, -250.4224F, -248.5893F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6177F, -250.4224F, -248.5893F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6177F, -250.4224F, -248.6393F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.3054F, -0.7854F, 0.0F));

        ModelPartData cube_r38 = Eye.addChild("cube_r38", ModelPartBuilder.create().uv(-170, -225).cuboid(-251.4375F, -249.7625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, -0.1745F, 0.1309F, 0.0F));

        ModelPartData cube_r39 = Eye.addChild("cube_r39", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1228F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.1228F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.1228F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.6545F, 0.1745F, 0.0F));

        ModelPartData cube_r40 = Eye.addChild("cube_r40", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.8375F, -250.5F, -250.0F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.8F, -22.8F, 12.95F, -0.1309F, 0.1309F, 0.0F));

        ModelPartData cube_r41 = Eye.addChild("cube_r41", ModelPartBuilder.create().uv(-170, -225).cuboid(-251.4375F, -252.4F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).mirrored().cuboid(-251.9375F, -252.4F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(1.1875F, -22.8F, 13.5F, 0.3491F, 0.0F, 0.0F));

        ModelPartData cube_r42 = Eye.addChild("cube_r42", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.3375F, -251.3F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.8125F, -251.3125F, -250.45F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, 0.3054F, -0.2618F, 0.0F));

        ModelPartData cube_r43 = Eye.addChild("cube_r43", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-249.825F, -251.3625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, 0.2182F, -0.0873F, 0.0F));

        ModelPartData cube_r44 = Eye.addChild("cube_r44", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.9505F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.9505F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.9505F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.0873F, -1.0472F, 0.0F));

        ModelPartData cube_r45 = Eye.addChild("cube_r45", ModelPartBuilder.create().uv(-170, -225).cuboid(-251.175F, -250.9625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, 0.1309F, 0.1309F, 0.0F));

        ModelPartData cube_r46 = Eye.addChild("cube_r46", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.6875F, -250.8875F, -250.6F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, 0.1745F, 0.1745F, 0.0F));

        ModelPartData cube_r47 = Eye.addChild("cube_r47", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8125F, -251.3125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-2.2875F, -22.8F, 12.925F, 0.3054F, -0.9163F, 0.0F));

        ModelPartData cube_r48 = Eye.addChild("cube_r48", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8875F, -252.525F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.3875F, 0.3665F, -0.3229F, 0.0F));

        ModelPartData cube_r49 = Eye.addChild("cube_r49", ModelPartBuilder.create().uv(-170, -225).cuboid(-251.175F, -251.3625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, 0.2182F, 0.0873F, 0.0F));

        ModelPartData cube_r50 = Eye.addChild("cube_r50", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.05F, -252.525F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.4875F, -252.125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.8875F, -251.7F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.3875F, 0.2967F, -0.2531F, 0.0F));

        ModelPartData cube_r51 = Eye.addChild("cube_r51", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1125F, -251.7F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.5125F, -252.125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.95F, -252.525F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.3875F, 0.2967F, 0.2531F, 0.0F));

        ModelPartData cube_r52 = Eye.addChild("cube_r52", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.4875F, -252.525F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.8875F, -252.125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.3875F, 0.3316F, -0.288F, 0.0F));

        ModelPartData cube_r53 = Eye.addChild("cube_r53", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1125F, -252.125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.5125F, -252.525F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.3875F, 0.3316F, 0.288F, 0.0F));

        ModelPartData cube_r54 = Eye.addChild("cube_r54", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8875F, -251.7F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-2.0F, -22.8F, 13.125F, 0.2967F, -0.7767F, 0.0F));

        ModelPartData cube_r55 = Eye.addChild("cube_r55", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.4875F, -251.7F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.05F, -251.7F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.05F, -252.125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.3875F, 0.2618F, -0.2182F, 0.0F));

        ModelPartData cube_r56 = Eye.addChild("cube_r56", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1125F, -252.525F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.3875F, 0.3665F, 0.3229F, 0.0F));

        ModelPartData cube_r57 = Eye.addChild("cube_r57", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8875F, -252.125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.65F, -22.8F, 13.3F, 0.3316F, -0.5934F, 0.0F));

        ModelPartData cube_r58 = Eye.addChild("cube_r58", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.5955F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.5955F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.5955F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.6894F, 0.384F, 0.0F));

        ModelPartData cube_r59 = Eye.addChild("cube_r59", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.1416F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.1416F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.1416F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.5672F, -0.2618F, 0.0F));

        ModelPartData cube_r60 = Eye.addChild("cube_r60", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.4358F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.4358F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.4358F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.5585F, 0.5585F, 0.0F));

        ModelPartData cube_r61 = Eye.addChild("cube_r61", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.2375F, -250.5F, -250.5F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.25F, -250.05F, -250.6F, 501.0F, 501.0F, 500.0F, new Dilation(-250.75F)), ModelTransform.of(1.65F, -22.8F, 13.4125F, 0.0F, 0.5672F, 0.0F));

        ModelPartData cube_r62 = Eye.addChild("cube_r62", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.225F, -250.9375F, -250.6125F, 501.0F, 501.0F, 500.0F, new Dilation(-250.675F)), ModelTransform.of(1.65F, -22.8F, 13.4125F, 0.2182F, 0.5236F, 0.0F));

        ModelPartData cube_r63 = Eye.addChild("cube_r63", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1875F, -251.3125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.775F)), ModelTransform.of(1.65F, -22.8F, 13.4125F, 0.3054F, 0.5672F, 0.0F));

        ModelPartData cube_r64 = Eye.addChild("cube_r64", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1125F, -251.7F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.65F, -22.8F, 13.3F, 0.2967F, 0.5585F, 0.0F));

        ModelPartData cube_r65 = Eye.addChild("cube_r65", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1125F, -252.125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.65F, -22.8F, 13.3F, 0.3316F, 0.5934F, 0.0F));

        ModelPartData cube_r66 = Eye.addChild("cube_r66", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.275F, -249.6625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.65F, -22.8F, 13.5F, -0.2531F, -0.2531F, 0.0F));

        ModelPartData cube_r67 = Eye.addChild("cube_r67", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.75F, -250.05F, -250.6F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, 0.0F, -0.2618F, 0.0F));

        ModelPartData cube_r68 = Eye.addChild("cube_r68", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.775F, -250.9375F, -250.6F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, 0.2182F, -0.2182F, 0.0F));

        ModelPartData cube_r69 = Eye.addChild("cube_r69", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3823F, -250.4224F, -248.5893F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.3823F, -250.4224F, -248.5893F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.3823F, -250.4224F, -248.5893F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.3054F, 0.7854F, 0.0F));

        ModelPartData cube_r70 = Eye.addChild("cube_r70", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.2375F, -250.5F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.25F, -250.05F, -250.45F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(2.0F, -22.8F, 13.2375F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r71 = Eye.addChild("cube_r71", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.225F, -250.9375F, -250.5625F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(2.0F, -22.8F, 13.2375F, 0.2182F, 0.7418F, 0.0F));

        ModelPartData cube_r72 = Eye.addChild("cube_r72", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1875F, -251.3125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)), ModelTransform.of(2.0F, -22.8F, 13.2375F, 0.3054F, 0.7854F, 0.0F));

        ModelPartData cube_r73 = Eye.addChild("cube_r73", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1125F, -251.7F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(2.0F, -22.8F, 13.125F, 0.2967F, 0.7767F, 0.0F));

        ModelPartData cube_r74 = Eye.addChild("cube_r74", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.75F, -250.05F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.7625F, -250.5F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.65F, -22.8F, 13.4125F, 0.0F, -0.5672F, 0.0F));

        ModelPartData cube_r75 = Eye.addChild("cube_r75", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.775F, -250.9375F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)).mirrored(false), ModelTransform.of(-1.65F, -22.8F, 13.4125F, 0.2182F, -0.5236F, 0.0F));

        ModelPartData cube_r76 = Eye.addChild("cube_r76", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8125F, -251.3125F, -250.45F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(-1.65F, -22.8F, 13.4125F, 0.3054F, -0.5672F, 0.0F));

        ModelPartData cube_r77 = Eye.addChild("cube_r77", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2102F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.2102F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.2102F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.3054F, 0.9163F, 0.0F));

        ModelPartData cube_r78 = Eye.addChild("cube_r78", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.225F, -250.9375F, -250.6F, 501.0F, 501.0F, 500.0F, new Dilation(-250.675F)), ModelTransform.of(2.2875F, -22.8F, 12.925F, 0.2182F, 0.8727F, 0.0F));

        ModelPartData cube_r79 = Eye.addChild("cube_r79", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1875F, -251.3125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(2.2875F, -22.8F, 12.925F, 0.3054F, 0.9163F, 0.0F));

        ModelPartData cube_r80 = Eye.addChild("cube_r80", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.7625F, -250.5F, -250.6F, 501.0F, 501.0F, 500.0F, new Dilation(-250.75F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.75F, -250.05F, -250.45F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(-2.0F, -22.8F, 13.2375F, 0.0F, -0.7854F, 0.0F));

        ModelPartData cube_r81 = Eye.addChild("cube_r81", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.775F, -250.9375F, -250.45F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(-2.0F, -22.8F, 13.2375F, 0.2182F, -0.7418F, 0.0F));

        ModelPartData cube_r82 = Eye.addChild("cube_r82", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8125F, -251.3125F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-2.0F, -22.8F, 13.2375F, 0.3054F, -0.7854F, 0.0F));

        ModelPartData cube_r83 = Eye.addChild("cube_r83", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.0495F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.0495F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.0495F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2026F, 12.2646F, -0.0873F, 1.0472F, 0.0F));

        ModelPartData cube_r84 = Eye.addChild("cube_r84", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.775F, -250.9375F, -250.6F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false), ModelTransform.of(-2.2875F, -22.8F, 12.925F, 0.2182F, -0.8727F, 0.0F));

        ModelPartData cube_r85 = Eye.addChild("cube_r85", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.0495F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.0495F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2776F, 12.3646F, 0.0873F, 1.0472F, 0.0F));

        ModelPartData cube_r86 = Eye.addChild("cube_r86", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2102F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.2102F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F))
                .uv(-170, -225).cuboid(-249.2102F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.1309F, 0.9163F, 0.0F));

        ModelPartData cube_r87 = Eye.addChild("cube_r87", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3823F, -250.4224F, -248.6393F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F))
                .uv(-170, -225).cuboid(-249.3823F, -250.4224F, -248.4893F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.3823F, -250.4224F, -248.5893F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.1309F, 0.7854F, 0.0F));

        ModelPartData cube_r88 = Eye.addChild("cube_r88", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.4358F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.4358F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.4358F, -250.5046F, -248.8312F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.384F, 0.5585F, 0.0F));

        ModelPartData cube_r89 = Eye.addChild("cube_r89", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.5955F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.5955F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.5955F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.5149F, 0.384F, 0.0F));

        ModelPartData cube_r90 = Eye.addChild("cube_r90", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.8584F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.8584F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.8584F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.3927F, 0.2618F, 0.0F));

        ModelPartData cube_r91 = Eye.addChild("cube_r91", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1228F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.1228F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.1228F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.48F, 0.1745F, 0.0F));

        ModelPartData cube_r92 = Eye.addChild("cube_r92", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3448F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.3448F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.3448F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.3927F, 0.0873F, 0.0F));

        ModelPartData cube_r93 = Eye.addChild("cube_r93", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.6552F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.6552F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.6552F, -250.0285F, -249.5501F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.3927F, -0.0873F, 0.0F));

        ModelPartData cube_r94 = Eye.addChild("cube_r94", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8772F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.8772F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.8772F, -250.2193F, -249.5254F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.48F, -0.1745F, 0.0F));

        ModelPartData cube_r95 = Eye.addChild("cube_r95", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.1416F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.1416F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.1416F, -249.9607F, -249.3835F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.3927F, -0.2618F, 0.0F));

        ModelPartData cube_r96 = Eye.addChild("cube_r96", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.4045F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4045F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4045F, -250.199F, -249.2263F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.5149F, -0.384F, 0.0F));

        ModelPartData cube_r97 = Eye.addChild("cube_r97", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.5642F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.5642F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.5642F, -250.5046F, -248.7812F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.384F, -0.5585F, 0.0F));

        ModelPartData cube_r98 = Eye.addChild("cube_r98", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6177F, -250.4224F, -248.5893F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6177F, -250.4224F, -248.5893F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6177F, -250.4224F, -248.6393F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.1309F, -0.7854F, 0.0F));

        ModelPartData cube_r99 = Eye.addChild("cube_r99", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7898F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.7898F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.7898F, -250.8724F, -248.4549F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2776F, 12.3646F, -0.1309F, -0.9163F, 0.0F));

        ModelPartData cube_r100 = Eye.addChild("cube_r100", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.9505F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.9505F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.9505F, -250.8101F, -248.2546F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0F, -22.2776F, 12.3646F, 0.0873F, -1.0472F, 0.0F));

        ModelPartData cube_r101 = Eye.addChild("cube_r101", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.825F, -250.5F, -250.0F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.9804F, -23.1081F, 12.3083F, 0.2182F, -1.0472F, 0.0F));

        ModelPartData cube_r102 = Eye.addChild("cube_r102", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.7625F, -250.5F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-2.2875F, -22.8F, 12.925F, 0.0F, -0.9163F, 0.0F));

        ModelPartData cube_r103 = Eye.addChild("cube_r103", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.275F, -249.6625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)).mirrored(false), ModelTransform.of(-2.1125F, -22.8F, 13.4125F, -0.2531F, -0.5585F, 0.0F));

        ModelPartData cube_r104 = Eye.addChild("cube_r104", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.2625F, -249.2625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.65F, -22.8F, 13.5F, -0.384F, -0.384F, 0.0F));

        ModelPartData cube_r105 = Eye.addChild("cube_r105", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.2625F, -249.2625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, -0.2618F, -0.2618F, 0.0F));

        ModelPartData cube_r106 = Eye.addChild("cube_r106", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-249.8875F, -249.45F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, -0.3491F, -0.1745F, 0.0F));

        ModelPartData cube_r107 = Eye.addChild("cube_r107", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-249.5625F, -249.375F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-1.1875F, -22.8F, 13.5F, -0.2618F, -0.0873F, 0.0F));

        ModelPartData cube_r108 = Eye.addChild("cube_r108", ModelPartBuilder.create().uv(-170, -225).cuboid(-251.4375F, -249.375F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, -0.2618F, 0.0873F, 0.0F));

        ModelPartData cube_r109 = Eye.addChild("cube_r109", ModelPartBuilder.create().uv(-170, -225).cuboid(-251.1125F, -249.45F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, -0.3491F, 0.1745F, 0.0F));

        ModelPartData cube_r110 = Eye.addChild("cube_r110", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.7375F, -249.2625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.1875F, -22.8F, 13.5F, -0.2618F, 0.2618F, 0.0F));

        ModelPartData cube_r111 = Eye.addChild("cube_r111", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.7375F, -249.2625F, -250.6F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)), ModelTransform.of(1.65F, -22.8F, 13.5F, -0.384F, 0.384F, 0.0F));

        ModelPartData cube_r112 = Eye.addChild("cube_r112", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.725F, -249.6625F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(2.1125F, -22.8F, 13.4125F, -0.2531F, 0.5585F, 0.0F));

        ModelPartData cube_r113 = Eye.addChild("cube_r113", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.2375F, -250.5F, -250.55F, 501.0F, 501.0F, 500.0F, new Dilation(-250.775F)), ModelTransform.of(2.2875F, -22.8F, 12.925F, 0.0F, 0.9163F, 0.0F));

        ModelPartData cube_r114 = Eye.addChild("cube_r114", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.175F, -250.5F, -250.0F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(1.9804F, -23.1081F, 12.3083F, 0.2182F, 1.0472F, 0.0F));

        ModelPartData cube_r115 = Eye.addChild("cube_r115", ModelPartBuilder.create().uv(-170, -225).cuboid(-248.9576F, -250.099F, -248.37F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.2125F, -22.9086F, 12.1956F, 0.0873F, 1.0472F, -1.5708F));

        ModelPartData cube_r116 = Eye.addChild("cube_r116", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1261F, -250.1517F, -248.4252F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.2125F, -22.9086F, 12.1956F, -0.1309F, 0.9163F, -1.5708F));

        ModelPartData cube_r117 = Eye.addChild("cube_r117", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3073F, -249.7003F, -248.5698F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.2125F, -22.9086F, 12.1956F, -0.1309F, 0.7854F, -1.5708F));

        ModelPartData cube_r118 = Eye.addChild("cube_r118", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3796F, -249.8048F, -248.6954F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0375F, -22.9086F, 12.1956F, -0.384F, 0.5585F, -1.5708F));

        ModelPartData cube_r119 = Eye.addChild("cube_r119", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.5558F, -249.5252F, -248.9581F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.5558F, -249.5252F, -248.9581F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.5149F, 0.384F, -1.5708F));

        ModelPartData cube_r120 = Eye.addChild("cube_r120", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.831F, -249.2576F, -249.2532F, 501.0F, 501.0F, 500.0F, new Dilation(-250.75F))
                .uv(-170, -225).cuboid(-249.831F, -249.2576F, -249.2032F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.3927F, 0.2618F, -1.5708F));

        ModelPartData cube_r121 = Eye.addChild("cube_r121", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1044F, -249.5337F, -249.2863F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.1044F, -249.5337F, -249.2863F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.48F, 0.1745F, -1.5708F));

        ModelPartData cube_r122 = Eye.addChild("cube_r122", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3355F, -249.3243F, -249.3728F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.3355F, -249.3243F, -249.3728F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.3927F, 0.0873F, -1.5708F));

        ModelPartData cube_r123 = Eye.addChild("cube_r123", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.6645F, -249.3243F, -249.3728F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.6645F, -249.3243F, -249.3728F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.3927F, -0.0873F, -1.5708F));

        ModelPartData cube_r124 = Eye.addChild("cube_r124", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8956F, -249.5337F, -249.2863F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.8956F, -249.5337F, -249.2863F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.48F, -0.1745F, -1.5708F));

        ModelPartData cube_r125 = Eye.addChild("cube_r125", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.169F, -249.2576F, -249.2032F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.169F, -249.2576F, -249.2032F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.3927F, -0.2618F, -1.5708F));

        ModelPartData cube_r126 = Eye.addChild("cube_r126", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.4442F, -249.5252F, -248.9581F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4442F, -249.5252F, -248.9581F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.5149F, -0.384F, -1.5708F));

        ModelPartData cube_r127 = Eye.addChild("cube_r127", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6204F, -249.8048F, -248.5954F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6204F, -249.8048F, -248.5954F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.384F, -0.5585F, -1.5708F));

        ModelPartData cube_r128 = Eye.addChild("cube_r128", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6927F, -249.7003F, -248.4698F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6927F, -249.7003F, -248.5698F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.1309F, -0.7854F, -1.5708F));

        ModelPartData cube_r129 = Eye.addChild("cube_r129", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8739F, -250.1517F, -248.4252F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.8739F, -250.1517F, -248.4252F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.1309F, -0.9163F, -1.5708F));

        ModelPartData cube_r130 = Eye.addChild("cube_r130", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-252.0424F, -250.099F, -248.37F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-252.0424F, -250.099F, -248.37F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.0873F, -1.0472F, -1.5708F));

        ModelPartData cube_r131 = Eye.addChild("cube_r131", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-252.129F, -250.0106F, -248.2881F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-252.129F, -250.0106F, -248.2881F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.0873F, -1.0472F, -1.5708F));

        ModelPartData cube_r132 = Eye.addChild("cube_r132", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.9533F, -250.0779F, -248.3359F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.9533F, -250.0779F, -248.3359F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.3054F, -0.9163F, -1.5708F));

        ModelPartData cube_r133 = Eye.addChild("cube_r133", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7634F, -249.6218F, -248.5396F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.7634F, -249.6218F, -248.4896F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.3054F, -0.7854F, -1.5708F));

        ModelPartData cube_r134 = Eye.addChild("cube_r134", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6734F, -249.7391F, -248.5089F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6734F, -249.7391F, -248.5089F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.5585F, -0.5585F, -1.5708F));

        ModelPartData cube_r135 = Eye.addChild("cube_r135", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.4817F, -249.4652F, -248.869F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4817F, -249.4652F, -248.869F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.6894F, -0.384F, -1.5708F));

        ModelPartData cube_r136 = Eye.addChild("cube_r136", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.1949F, -249.1845F, -249.125F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.1949F, -249.1845F, -249.125F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.5672F, -0.2618F, -1.5708F));

        ModelPartData cube_r137 = Eye.addChild("cube_r137", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.9129F, -249.4662F, -249.2034F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.9129F, -249.4662F, -249.2034F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.6545F, -0.1745F, -1.5708F));

        ModelPartData cube_r138 = Eye.addChild("cube_r138", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.6732F, -249.249F, -249.2969F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.6732F, -249.249F, -249.2969F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.5672F, -0.0873F, -1.5708F));

        ModelPartData cube_r139 = Eye.addChild("cube_r139", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3268F, -249.249F, -249.2969F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.3268F, -249.249F, -249.2969F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.5672F, 0.0873F, -1.5708F));

        ModelPartData cube_r140 = Eye.addChild("cube_r140", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.0871F, -249.4662F, -249.2034F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.0871F, -249.4662F, -249.2034F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.6545F, 0.1745F, -1.5708F));

        ModelPartData cube_r141 = Eye.addChild("cube_r141", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.8051F, -249.1845F, -249.125F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.8051F, -249.1845F, -249.125F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.5672F, 0.2618F, -1.5708F));

        ModelPartData cube_r142 = Eye.addChild("cube_r142", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.5183F, -249.4652F, -248.869F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.5183F, -249.4652F, -248.869F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.6894F, 0.384F, -1.5708F));

        ModelPartData cube_r143 = Eye.addChild("cube_r143", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3266F, -249.7391F, -248.5089F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0375F, -22.9086F, 12.1956F, -0.5585F, 0.5585F, -1.5708F));

        ModelPartData cube_r144 = Eye.addChild("cube_r144", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2366F, -249.6218F, -248.5896F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0375F, -22.9086F, 12.1956F, -0.3054F, 0.7854F, -1.5708F));

        ModelPartData cube_r145 = Eye.addChild("cube_r145", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.0467F, -250.0779F, -248.3359F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.2125F, -22.9086F, 12.1956F, -0.3054F, 0.9163F, -1.5708F));

        ModelPartData cube_r146 = Eye.addChild("cube_r146", ModelPartBuilder.create().uv(-170, -225).cuboid(-248.871F, -250.0106F, -248.2881F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0375F, -22.9086F, 12.1956F, -0.0873F, 1.0472F, -1.5708F));

        ModelPartData cube_r147 = Eye.addChild("cube_r147", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.9558F, -250.2557F, -248.3806F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2182F, -1.0472F, -1.5708F));

        ModelPartData cube_r148 = Eye.addChild("cube_r148", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7946F, -250.3039F, -248.4586F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.0F, -0.9163F, -1.5708F));

        ModelPartData cube_r149 = Eye.addChild("cube_r149", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.622F, -249.8539F, -248.4935F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6345F, -250.3039F, -248.5935F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.0F, -0.7854F, -1.5708F));

        ModelPartData cube_r150 = Eye.addChild("cube_r150", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.5674F, -249.953F, -248.6438F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.2531F, -0.5585F, -1.5708F));

        ModelPartData cube_r151 = Eye.addChild("cube_r151", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.4068F, -249.6698F, -249.0186F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.384F, -0.384F, -1.5708F));

        ModelPartData cube_r152 = Eye.addChild("cube_r152", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.1431F, -249.41F, -249.242F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.2618F, -0.2618F, -1.5708F));

        ModelPartData cube_r153 = Eye.addChild("cube_r153", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8782F, -249.683F, -249.2366F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.3491F, -0.1745F, -1.5708F));

        ModelPartData cube_r154 = Eye.addChild("cube_r154", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.6558F, -249.4778F, -249.4088F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.2618F, -0.0873F, -1.5708F));

        ModelPartData cube_r155 = Eye.addChild("cube_r155", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3442F, -249.4778F, -249.3088F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.2618F, 0.0873F, -1.5708F));

        ModelPartData cube_r156 = Eye.addChild("cube_r156", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1218F, -249.683F, -249.3366F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.3491F, 0.1745F, -1.5708F));

        ModelPartData cube_r157 = Eye.addChild("cube_r157", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.5932F, -249.6698F, -249.1686F, 501.0F, 501.0F, 500.0F, new Dilation(-250.75F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.384F, 0.384F, -1.5708F));

        ModelPartData cube_r158 = Eye.addChild("cube_r158", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.4326F, -249.953F, -248.7438F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)), ModelTransform.of(0.0375F, -22.9086F, 12.1956F, -0.2531F, 0.5585F, -1.5708F));

        ModelPartData cube_r159 = Eye.addChild("cube_r159", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.378F, -249.8539F, -248.5935F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.3655F, -250.3039F, -248.5935F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.2125F, -22.9086F, 12.1956F, 0.0F, 0.7854F, -1.5708F));

        ModelPartData cube_r160 = Eye.addChild("cube_r160", ModelPartBuilder.create().uv(-170, -225).cuboid(-248.9576F, -250.099F, -248.37F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.0873F, 1.0472F, -1.5708F));

        ModelPartData cube_r161 = Eye.addChild("cube_r161", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3155F, -250.5372F, -248.743F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3054F, 0.7854F, -1.5708F));

        ModelPartData cube_r162 = Eye.addChild("cube_r162", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2685F, -250.3313F, -248.8713F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2182F, 0.7418F, -1.5708F));

        ModelPartData cube_r163 = Eye.addChild("cube_r163", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8446F, -250.4966F, -248.6144F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3054F, -0.9163F, -1.5708F));

        ModelPartData cube_r164 = Eye.addChild("cube_r164", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8973F, -250.3036F, -248.5965F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2182F, -0.8727F, -1.5708F));

        ModelPartData cube_r165 = Eye.addChild("cube_r165", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1527F, -251.0512F, -249.0986F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2967F, 0.5585F, -1.5708F));

        ModelPartData cube_r166 = Eye.addChild("cube_r166", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.302F, -250.6201F, -249.0059F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3054F, 0.5672F, -1.5708F));

        ModelPartData cube_r167 = Eye.addChild("cube_r167", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.352F, -250.3039F, -248.8691F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.3645F, -249.8539F, -248.8191F, 501.0F, 501.0F, 500.0F, new Dilation(-250.675F)), ModelTransform.of(0.0375F, -22.9086F, 12.1956F, 0.0F, 0.5672F, -1.5708F));

        ModelPartData cube_r168 = Eye.addChild("cube_r168", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8554F, -250.9662F, -248.8204F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2967F, -0.7767F, -1.5708F));

        ModelPartData cube_r169 = Eye.addChild("cube_r169", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6845F, -250.5372F, -248.743F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3054F, -0.7854F, -1.5708F));

        ModelPartData cube_r170 = Eye.addChild("cube_r170", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7315F, -250.3313F, -248.7213F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2182F, -0.7418F, -1.5708F));

        ModelPartData cube_r171 = Eye.addChild("cube_r171", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2343F, -251.5436F, -249.4637F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.6343F, -251.9436F, -249.5137F, 501.0F, 501.0F, 500.0F, new Dilation(-250.75F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3316F, 0.288F, -1.5708F));

        ModelPartData cube_r172 = Eye.addChild("cube_r172", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1924F, -251.1661F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.5924F, -251.5911F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.0299F, -251.9911F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2967F, 0.2531F, -1.5708F));

        ModelPartData cube_r173 = Eye.addChild("cube_r173", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3069F, -250.7341F, -249.3676F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.7819F, -250.7216F, -249.4176F, 501.0F, 501.0F, 500.0F, new Dilation(-250.75F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3054F, 0.2618F, -1.5708F));

        ModelPartData cube_r174 = Eye.addChild("cube_r174", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3694F, -249.8539F, -249.3484F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.3569F, -250.3039F, -249.2484F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.0F, 0.2618F, -1.5708F));

        ModelPartData cube_r175 = Eye.addChild("cube_r175", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7916F, -251.4154F, -249.0913F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3316F, -0.5934F, -1.5708F));

        ModelPartData cube_r176 = Eye.addChild("cube_r176", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8473F, -251.0512F, -249.0986F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2967F, -0.5585F, -1.5708F));

        ModelPartData cube_r177 = Eye.addChild("cube_r177", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.698F, -250.6201F, -249.0059F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3054F, -0.5672F, -1.5708F));

        ModelPartData cube_r178 = Eye.addChild("cube_r178", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.733F, -250.391F, -248.9907F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2182F, -0.5236F, -1.5708F));

        ModelPartData cube_r179 = Eye.addChild("cube_r179", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6355F, -249.8539F, -248.8691F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.648F, -250.3039F, -248.8691F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.0F, -0.5672F, -1.5708F));

        ModelPartData cube_r180 = Eye.addChild("cube_r180", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6147F, -249.8256F, -249.1861F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.2531F, -0.2531F, -1.5708F));

        ModelPartData cube_r181 = Eye.addChild("cube_r181", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.9891F, -251.6374F, -249.4879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.9891F, -251.2124F, -249.4879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F))
                .uv(-170, -225).cuboid(-249.5516F, -251.2124F, -249.4879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2618F, 0.2182F, -1.5708F));

        ModelPartData cube_r182 = Eye.addChild("cube_r182", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2084F, -251.4154F, -249.0913F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3316F, 0.5934F, -1.5708F));

        ModelPartData cube_r183 = Eye.addChild("cube_r183", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.9701F, -251.9911F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4076F, -251.5911F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.8076F, -251.1661F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2967F, -0.2531F, -1.5708F));

        ModelPartData cube_r184 = Eye.addChild("cube_r184", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.3657F, -251.9436F, -249.4637F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.7657F, -251.5436F, -249.4637F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3316F, -0.288F, -1.5708F));

        ModelPartData cube_r185 = Eye.addChild("cube_r185", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7227F, -251.8953F, -249.4568F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3665F, -0.3229F, -1.5708F));

        ModelPartData cube_r186 = Eye.addChild("cube_r186", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1446F, -250.9662F, -248.8204F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2967F, 0.7767F, -1.5708F));

        ModelPartData cube_r187 = Eye.addChild("cube_r187", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.0109F, -251.6374F, -249.4879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4484F, -251.2124F, -249.4879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.0109F, -251.0374F, -249.2504F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2618F, -0.2182F, -1.5708F));

        ModelPartData cube_r188 = Eye.addChild("cube_r188", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7116F, -250.4729F, -249.3604F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2182F, -0.2182F, -1.5708F));

        ModelPartData cube_r189 = Eye.addChild("cube_r189", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.9183F, -250.9267F, -249.3903F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2182F, -0.0873F, -1.5708F));

        ModelPartData cube_r190 = Eye.addChild("cube_r190", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.2181F, -250.7216F, -249.2676F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6931F, -250.7341F, -249.3676F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3054F, -0.2618F, -1.5708F));

        ModelPartData cube_r191 = Eye.addChild("cube_r191", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.7375F, -251.3942F, -249.294F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).cuboid(-250.25F, -251.0567F, -249.369F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.2625F, -251.5067F, -249.6065F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).mirrored().cuboid(-250.75F, -251.0567F, -249.6065F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2618F, 0.0F, -1.5708F));

        ModelPartData cube_r192 = Eye.addChild("cube_r192", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2773F, -251.8953F, -249.4568F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3665F, 0.3229F, -1.5708F));

        ModelPartData cube_r193 = Eye.addChild("cube_r193", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1554F, -250.4966F, -248.6144F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3054F, 0.9163F, -1.5708F));

        ModelPartData cube_r194 = Eye.addChild("cube_r194", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.25F, -251.8637F, -249.6498F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).mirrored().cuboid(-250.75F, -251.8637F, -249.6498F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.3491F, 0.0F, -1.5708F));

        ModelPartData cube_r195 = Eye.addChild("cube_r195", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.3032F, -250.4826F, -249.3827F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.1745F, -0.1745F, -1.5708F));

        ModelPartData cube_r196 = Eye.addChild("cube_r196", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.868F, -250.6147F, -249.4101F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.1309F, -0.1309F, -1.5708F));

        ModelPartData cube_r197 = Eye.addChild("cube_r197", ModelPartBuilder.create().uv(-170, -225).cuboid(-248.871F, -250.0106F, -248.2881F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.0873F, 1.0472F, -1.5708F));

        ModelPartData cube_r198 = Eye.addChild("cube_r198", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.0817F, -250.9267F, -249.4903F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.2182F, 0.0873F, -1.5708F));

        ModelPartData cube_r199 = Eye.addChild("cube_r199", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8931F, -250.3813F, -249.3997F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.1309F, -0.1309F, -1.5708F));

        ModelPartData cube_r200 = Eye.addChild("cube_r200", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.7125F, -250.5164F, -249.6706F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r201 = Eye.addChild("cube_r201", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.9282F, -249.9938F, -249.2146F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.1745F, -0.1745F, -1.5708F));

        ModelPartData cube_r202 = Eye.addChild("cube_r202", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.7375F, -250.1775F, -249.5039F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).cuboid(-250.2625F, -250.1775F, -249.5039F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.1309F, 0.0F, -1.5708F));

        ModelPartData cube_r203 = Eye.addChild("cube_r203", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.6055F, -249.7735F, -249.2583F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.1745F, -0.1309F, -1.5708F));

        ModelPartData cube_r204 = Eye.addChild("cube_r204", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.6968F, -250.4826F, -249.3827F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.1745F, 0.1745F, -1.5708F));

        ModelPartData cube_r205 = Eye.addChild("cube_r205", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.6843F, -250.3039F, -249.3801F, 501.0F, 501.0F, 500.0F, new Dilation(-250.75F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.0F, 0.1745F, -1.5708F));

        ModelPartData cube_r206 = Eye.addChild("cube_r206", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.3157F, -250.3039F, -249.2801F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.0F, -0.1745F, -1.5708F));

        ModelPartData cube_r207 = Eye.addChild("cube_r207", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.0718F, -249.9938F, -249.3646F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.1745F, 0.1745F, -1.5708F));

        ModelPartData cube_r208 = Eye.addChild("cube_r208", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3945F, -249.7735F, -249.3583F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.1745F, 0.1309F, -1.5708F));

        ModelPartData cube_r209 = Eye.addChild("cube_r209", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.132F, -250.6147F, -249.4101F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, 0.1309F, 0.1309F, -1.5708F));

        ModelPartData cube_r210 = Eye.addChild("cube_r210", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1069F, -250.3813F, -249.2997F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.1309F, 0.1309F, -1.5708F));

        ModelPartData cube_r211 = Eye.addChild("cube_r211", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.2116F, -249.7442F, -249.2755F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0875F, -22.9961F, 12.4706F, -0.2182F, -0.2182F, -1.5708F));

        ModelPartData cube_r212 = Eye.addChild("cube_r212", ModelPartBuilder.create().uv(-170, -225).cuboid(-248.9576F, -250.099F, -248.37F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0375F, -22.9961F, 12.1956F, 0.0873F, 1.0472F, -1.5708F));

        ModelPartData cube_r213 = Eye.addChild("cube_r213", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7946F, -250.3039F, -248.4586F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.0F, -0.9163F, 1.5708F));

        ModelPartData cube_r214 = Eye.addChild("cube_r214", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.622F, -249.8539F, -248.5935F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6345F, -250.3039F, -248.5935F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.2125F, -22.9086F, 12.1956F, 0.0F, -0.7854F, 1.5708F));

        ModelPartData cube_r215 = Eye.addChild("cube_r215", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.5674F, -249.953F, -248.6938F, 501.0F, 501.0F, 500.0F, new Dilation(-250.675F)).mirrored(false), ModelTransform.of(-0.0375F, -22.9086F, 12.1956F, -0.2531F, -0.5585F, 1.5708F));

        ModelPartData cube_r216 = Eye.addChild("cube_r216", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.4068F, -249.6698F, -249.1061F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.384F, -0.384F, 1.5708F));

        ModelPartData cube_r217 = Eye.addChild("cube_r217", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8782F, -249.683F, -249.3366F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.3491F, -0.1745F, 1.5708F));

        ModelPartData cube_r218 = Eye.addChild("cube_r218", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.6558F, -249.4778F, -249.4088F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.2618F, -0.0873F, 1.5708F));

        ModelPartData cube_r219 = Eye.addChild("cube_r219", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1218F, -249.683F, -249.3366F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.3491F, 0.1745F, 1.5708F));

        ModelPartData cube_r220 = Eye.addChild("cube_r220", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.8569F, -249.41F, -249.242F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.2618F, 0.2618F, 1.5708F));

        ModelPartData cube_r221 = Eye.addChild("cube_r221", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.5932F, -249.6698F, -249.0186F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.384F, 0.384F, 1.5708F));

        ModelPartData cube_r222 = Eye.addChild("cube_r222", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.4326F, -249.953F, -248.6438F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.2531F, 0.5585F, 1.5708F));

        ModelPartData cube_r223 = Eye.addChild("cube_r223", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.378F, -249.8539F, -248.5935F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.3655F, -250.3039F, -248.5935F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.0F, 0.7854F, 1.5708F));

        ModelPartData cube_r224 = Eye.addChild("cube_r224", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2054F, -250.3039F, -248.3586F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.0F, 0.9163F, 1.5708F));

        ModelPartData cube_r225 = Eye.addChild("cube_r225", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.0442F, -250.2557F, -248.3806F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2182F, 1.0472F, 1.5708F));

        ModelPartData cube_r226 = Eye.addChild("cube_r226", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1027F, -250.3036F, -248.6465F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2182F, 0.8727F, 1.5708F));

        ModelPartData cube_r227 = Eye.addChild("cube_r227", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3155F, -250.5372F, -248.743F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3054F, 0.7854F, 1.5708F));

        ModelPartData cube_r228 = Eye.addChild("cube_r228", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2685F, -250.3313F, -248.7213F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2182F, 0.7418F, 1.5708F));

        ModelPartData cube_r229 = Eye.addChild("cube_r229", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1527F, -251.0512F, -249.0986F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2967F, 0.5585F, 1.5708F));

        ModelPartData cube_r230 = Eye.addChild("cube_r230", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.302F, -250.6201F, -249.0059F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3054F, 0.5672F, 1.5708F));

        ModelPartData cube_r231 = Eye.addChild("cube_r231", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.267F, -250.391F, -248.9907F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2182F, 0.5236F, 1.5708F));

        ModelPartData cube_r232 = Eye.addChild("cube_r232", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.352F, -250.3039F, -248.8691F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.3645F, -249.8539F, -248.9191F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.0F, 0.5672F, 1.5708F));

        ModelPartData cube_r233 = Eye.addChild("cube_r233", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2343F, -251.5436F, -249.4637F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.6343F, -251.9436F, -249.4637F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3316F, 0.288F, 1.5708F));

        ModelPartData cube_r234 = Eye.addChild("cube_r234", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1924F, -251.1661F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.5924F, -251.5911F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.0299F, -251.9911F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2967F, 0.2531F, 1.5708F));

        ModelPartData cube_r235 = Eye.addChild("cube_r235", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3069F, -250.7341F, -249.3676F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.7819F, -250.7216F, -249.1801F, 501.0F, 501.0F, 500.0F, new Dilation(-250.725F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3054F, 0.2618F, 1.5708F));

        ModelPartData cube_r236 = Eye.addChild("cube_r236", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2884F, -250.4729F, -249.4104F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2182F, 0.2182F, 1.5708F));

        ModelPartData cube_r237 = Eye.addChild("cube_r237", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3569F, -250.3039F, -249.2484F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.0F, 0.2618F, 1.5708F));

        ModelPartData cube_r238 = Eye.addChild("cube_r238", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3853F, -249.8256F, -249.1361F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.2531F, 0.2531F, 1.5708F));

        ModelPartData cube_r239 = Eye.addChild("cube_r239", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-252.0424F, -250.099F, -248.37F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.2125F, -22.9086F, 12.1956F, 0.0873F, -1.0472F, 1.5708F));

        ModelPartData cube_r240 = Eye.addChild("cube_r240", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8739F, -250.1517F, -248.4252F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.2125F, -22.9086F, 12.1956F, -0.1309F, -0.9163F, 1.5708F));

        ModelPartData cube_r241 = Eye.addChild("cube_r241", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6927F, -249.7003F, -248.5698F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.2125F, -22.9086F, 12.1956F, -0.1309F, -0.7854F, 1.5708F));

        ModelPartData cube_r242 = Eye.addChild("cube_r242", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6204F, -249.8048F, -248.5954F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(-0.0375F, -22.9086F, 12.1956F, -0.384F, -0.5585F, 1.5708F));

        ModelPartData cube_r243 = Eye.addChild("cube_r243", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.4442F, -249.5252F, -248.9581F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.5149F, -0.384F, 1.5708F));

        ModelPartData cube_r244 = Eye.addChild("cube_r244", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.169F, -249.2576F, -249.2032F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.3927F, -0.2618F, 1.5708F));

        ModelPartData cube_r245 = Eye.addChild("cube_r245", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8956F, -249.5337F, -249.2863F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.48F, -0.1745F, 1.5708F));

        ModelPartData cube_r246 = Eye.addChild("cube_r246", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.6645F, -249.3243F, -249.3728F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.3927F, -0.0873F, 1.5708F));

        ModelPartData cube_r247 = Eye.addChild("cube_r247", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3355F, -249.3243F, -249.0603F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.3927F, 0.0873F, 1.5708F));

        ModelPartData cube_r248 = Eye.addChild("cube_r248", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1044F, -249.5337F, -249.2863F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.48F, 0.1745F, 1.5708F));

        ModelPartData cube_r249 = Eye.addChild("cube_r249", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.831F, -249.2576F, -249.2032F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.3927F, 0.2618F, 1.5708F));

        ModelPartData cube_r250 = Eye.addChild("cube_r250", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.5558F, -249.5252F, -248.9581F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.5149F, 0.384F, 1.5708F));

        ModelPartData cube_r251 = Eye.addChild("cube_r251", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3796F, -249.8048F, -248.5454F, 501.0F, 501.0F, 500.0F, new Dilation(-250.675F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.384F, 0.5585F, 1.5708F));

        ModelPartData cube_r252 = Eye.addChild("cube_r252", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3073F, -249.7003F, -248.5698F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.1309F, 0.7854F, 1.5708F));

        ModelPartData cube_r253 = Eye.addChild("cube_r253", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1261F, -250.1517F, -248.4252F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.1309F, 0.9163F, 1.5708F));

        ModelPartData cube_r254 = Eye.addChild("cube_r254", ModelPartBuilder.create().uv(-170, -225).cuboid(-248.9576F, -250.099F, -248.37F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.0873F, 1.0472F, 1.5708F));

        ModelPartData cube_r255 = Eye.addChild("cube_r255", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.8051F, -249.1845F, -249.125F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.5672F, 0.2618F, 1.5708F));

        ModelPartData cube_r256 = Eye.addChild("cube_r256", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.9891F, -251.6374F, -249.4879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.9891F, -251.2124F, -249.4879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-249.5516F, -251.2124F, -249.4879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2618F, 0.2182F, 1.5708F));

        ModelPartData cube_r257 = Eye.addChild("cube_r257", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2084F, -251.4154F, -249.0913F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3316F, 0.5934F, 1.5708F));

        ModelPartData cube_r258 = Eye.addChild("cube_r258", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1446F, -250.9662F, -248.8204F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2967F, 0.7767F, 1.5708F));

        ModelPartData cube_r259 = Eye.addChild("cube_r259", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6734F, -249.7391F, -248.6089F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0375F, -22.9086F, 12.1956F, -0.5585F, -0.5585F, 1.5708F));

        ModelPartData cube_r260 = Eye.addChild("cube_r260", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7634F, -249.6218F, -248.5021F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0375F, -22.9086F, 12.1956F, -0.3054F, -0.7854F, 1.5708F));

        ModelPartData cube_r261 = Eye.addChild("cube_r261", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.9533F, -250.0779F, -248.3359F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.2125F, -22.9086F, 12.1956F, -0.3054F, -0.9163F, 1.5708F));

        ModelPartData cube_r262 = Eye.addChild("cube_r262", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-252.129F, -250.0106F, -248.2881F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0375F, -22.9086F, 12.1956F, -0.0873F, -1.0472F, 1.5708F));

        ModelPartData cube_r263 = Eye.addChild("cube_r263", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8973F, -250.3036F, -248.6965F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2182F, -0.8727F, 1.5708F));

        ModelPartData cube_r264 = Eye.addChild("cube_r264", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8446F, -250.4966F, -248.6144F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3054F, -0.9163F, 1.5708F));

        ModelPartData cube_r265 = Eye.addChild("cube_r265", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6845F, -250.5372F, -248.743F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3054F, -0.7854F, 1.5708F));

        ModelPartData cube_r266 = Eye.addChild("cube_r266", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8554F, -250.9662F, -248.8204F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2967F, -0.7767F, 1.5708F));

        ModelPartData cube_r267 = Eye.addChild("cube_r267", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.648F, -250.3039F, -248.8691F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7375F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6355F, -249.8539F, -248.8691F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(-0.0375F, -22.9086F, 12.1956F, 0.0F, -0.5672F, 1.5708F));

        ModelPartData cube_r268 = Eye.addChild("cube_r268", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.698F, -250.6201F, -249.0059F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3054F, -0.5672F, 1.5708F));

        ModelPartData cube_r269 = Eye.addChild("cube_r269", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.8473F, -251.0512F, -249.0986F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2967F, -0.5585F, 1.5708F));

        ModelPartData cube_r270 = Eye.addChild("cube_r270", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7916F, -251.4154F, -249.0913F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3316F, -0.5934F, 1.5708F));

        ModelPartData cube_r271 = Eye.addChild("cube_r271", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7116F, -250.4729F, -249.2604F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2182F, -0.2182F, 1.5708F));

        ModelPartData cube_r272 = Eye.addChild("cube_r272", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.9183F, -250.9267F, -249.4903F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2182F, -0.0873F, 1.5708F));

        ModelPartData cube_r273 = Eye.addChild("cube_r273", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.2181F, -250.7216F, -249.3676F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.6931F, -250.7341F, -249.3676F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3054F, -0.2618F, 1.5708F));

        ModelPartData cube_r274 = Eye.addChild("cube_r274", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.7375F, -251.5067F, -249.6065F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-250.75F, -251.0567F, -249.6065F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).cuboid(-250.25F, -251.0567F, -249.6065F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F))
                .uv(-170, -225).cuboid(-250.2625F, -251.5067F, -249.6065F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2618F, 0.0F, 1.5708F));

        ModelPartData cube_r275 = Eye.addChild("cube_r275", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.6306F, -249.8539F, -249.3484F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.0F, -0.2618F, 1.5708F));

        ModelPartData cube_r276 = Eye.addChild("cube_r276", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.3032F, -250.4826F, -249.3827F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.1745F, -0.1745F, 1.5708F));

        ModelPartData cube_r277 = Eye.addChild("cube_r277", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.75F, -251.8637F, -249.6498F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).cuboid(-250.25F, -251.8637F, -249.6498F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3491F, 0.0F, 1.5708F));

        ModelPartData cube_r278 = Eye.addChild("cube_r278", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.8931F, -250.3813F, -249.3997F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.1309F, -0.1309F, 1.5708F));

        ModelPartData cube_r279 = Eye.addChild("cube_r279", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.7375F, -250.1775F, -249.5039F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).cuboid(-250.2625F, -250.1775F, -249.3789F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.1309F, 0.0F, 1.5708F));

        ModelPartData cube_r280 = Eye.addChild("cube_r280", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.9129F, -249.4662F, -249.2034F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.6545F, -0.1745F, 1.5708F));

        ModelPartData cube_r281 = Eye.addChild("cube_r281", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.7227F, -251.8953F, -249.4568F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3665F, -0.3229F, 1.5708F));

        ModelPartData cube_r282 = Eye.addChild("cube_r282", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.3657F, -251.9436F, -249.3637F, 501.0F, 501.0F, 500.0F, new Dilation(-250.625F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.7657F, -251.5436F, -249.4637F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3316F, -0.288F, 1.5708F));

        ModelPartData cube_r283 = Eye.addChild("cube_r283", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.9701F, -251.9911F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4076F, -251.5911F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.8076F, -251.1661F, -249.4741F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2967F, -0.2531F, 1.5708F));

        ModelPartData cube_r284 = Eye.addChild("cube_r284", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.0109F, -251.6374F, -249.5379F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.4484F, -251.2124F, -249.4879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false)
                .uv(-170, -225).mirrored().cuboid(-251.0109F, -251.2124F, -249.3879F, 501.0F, 501.0F, 500.0F, new Dilation(-250.6625F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2618F, -0.2182F, 1.5708F));

        ModelPartData cube_r285 = Eye.addChild("cube_r285", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-250.6732F, -249.249F, -249.2969F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.5672F, -0.0873F, 1.5708F));

        ModelPartData cube_r286 = Eye.addChild("cube_r286", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.4817F, -249.4652F, -248.869F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.6894F, -0.384F, 1.5708F));

        ModelPartData cube_r287 = Eye.addChild("cube_r287", ModelPartBuilder.create().uv(-170, -225).mirrored().cuboid(-251.1949F, -249.1845F, -249.125F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)).mirrored(false), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.5672F, -0.2618F, 1.5708F));

        ModelPartData cube_r288 = Eye.addChild("cube_r288", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3268F, -249.249F, -249.2969F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.5672F, 0.0873F, 1.5708F));

        ModelPartData cube_r289 = Eye.addChild("cube_r289", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.5183F, -249.4652F, -248.869F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.6894F, 0.384F, 1.5708F));

        ModelPartData cube_r290 = Eye.addChild("cube_r290", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.3266F, -249.7391F, -248.5089F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.5585F, 0.5585F, 1.5708F));

        ModelPartData cube_r291 = Eye.addChild("cube_r291", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.6843F, -249.8664F, -249.3301F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.0F, 0.1745F, 1.5708F));

        ModelPartData cube_r292 = Eye.addChild("cube_r292", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.0467F, -250.0779F, -248.3359F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.3054F, 0.9163F, 1.5708F));

        ModelPartData cube_r293 = Eye.addChild("cube_r293", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.1554F, -250.4966F, -248.6144F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3054F, 0.9163F, 1.5708F));

        ModelPartData cube_r294 = Eye.addChild("cube_r294", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2773F, -251.8953F, -249.4568F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.3665F, 0.3229F, 1.5708F));

        ModelPartData cube_r295 = Eye.addChild("cube_r295", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.0817F, -250.9267F, -249.4903F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.2182F, 0.0873F, 1.5708F));

        ModelPartData cube_r296 = Eye.addChild("cube_r296", ModelPartBuilder.create().uv(-170, -225).cuboid(-248.871F, -250.0106F, -248.2881F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.0873F, 1.0472F, 1.5708F));

        ModelPartData cube_r297 = Eye.addChild("cube_r297", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.6968F, -250.4826F, -249.3827F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.1745F, 0.1745F, 1.5708F));

        ModelPartData cube_r298 = Eye.addChild("cube_r298", ModelPartBuilder.create().uv(-170, -225).cuboid(-249.2366F, -249.6218F, -248.5396F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7125F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.3054F, 0.7854F, 1.5708F));

        ModelPartData cube_r299 = Eye.addChild("cube_r299", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.3945F, -249.7735F, -249.3583F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.1745F, 0.1309F, 1.5708F));

        ModelPartData cube_r300 = Eye.addChild("cube_r300", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.0871F, -249.4662F, -249.2034F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.6545F, 0.1745F, 1.5708F));

        ModelPartData cube_r301 = Eye.addChild("cube_r301", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.0718F, -249.9938F, -249.2646F, 501.0F, 501.0F, 500.0F, new Dilation(-250.675F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.1745F, 0.1745F, 1.5708F));

        ModelPartData cube_r302 = Eye.addChild("cube_r302", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.132F, -250.6147F, -249.4101F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, 0.1309F, 0.1309F, 1.5708F));

        ModelPartData cube_r303 = Eye.addChild("cube_r303", ModelPartBuilder.create().uv(-170, -225).cuboid(-250.1069F, -250.3813F, -249.3997F, 501.0F, 501.0F, 500.0F, new Dilation(-250.7F)), ModelTransform.of(0.0875F, -22.9961F, 12.4706F, -0.1309F, 0.1309F, 1.5708F));

        ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(1584, 211).cuboid(-4.0F, -19.0F, -3.0F, 8.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(1619, 290).cuboid(-4.0F, -16.0F, 4.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F))
                .uv(1584, 228).cuboid(-4.0F, -13.0F, -12.0F, 8.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r304 = Body.addChild("cube_r304", ModelPartBuilder.create().uv(1632, 221).mirrored().cuboid(-0.1F, -1.0F, -0.8375F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.6F, -18.5371F, 4.8554F, 0.2967F, 0.2967F, 0.0F));

        ModelPartData cube_r305 = Body.addChild("cube_r305", ModelPartBuilder.create().uv(1626, 266).mirrored().cuboid(-3.225F, -5.8375F, -3.0875F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -13.0F, 6.0F, 0.0F, 0.2967F, 0.0F));

        ModelPartData cube_r306 = Body.addChild("cube_r306", ModelPartBuilder.create().uv(1632, 221).mirrored().cuboid(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.3624F, -18.877F, 5.3337F, 0.2834F, 0.0122F, -0.0856F));

        ModelPartData cube_r307 = Body.addChild("cube_r307", ModelPartBuilder.create().uv(1619, 239).cuboid(-4.0F, -3.6125F, -5.5375F, 8.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.7166F, -4.9793F, 0.7548F, 0.0F, 0.0F));

        ModelPartData cube_r308 = Body.addChild("cube_r308", ModelPartBuilder.create().uv(1630, 256).cuboid(-4.0F, -4.125F, -3.125F, 8.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -15.4374F, -2.9723F, 0.6239F, 0.0F, 0.0F));

        ModelPartData cube_r309 = Body.addChild("cube_r309", ModelPartBuilder.create().uv(1586, 221).cuboid(-4.0F, -5.8875F, -7.5125F, 8.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.5F, 2.5F, 0.2749F, 0.0F, 0.0F));

        ModelPartData cube_r310 = Body.addChild("cube_r310", ModelPartBuilder.create().uv(1604, 254).cuboid(-4.0F, -1.1375F, -2.9125F, 8.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.2315F, -0.3806F, 0.5847F, 0.0F, 0.0F));

        ModelPartData cube_r311 = Body.addChild("cube_r311", ModelPartBuilder.create().uv(1608, 213).cuboid(-4.0F, -1.55F, -2.6125F, 8.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -18.7835F, 1.7558F, 0.048F, 0.0F, 0.0F));

        ModelPartData cube_r312 = Body.addChild("cube_r312", ModelPartBuilder.create().uv(1630, 249).cuboid(-4.0F, -0.4625F, -5.0625F, 8.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -18.5371F, 4.8554F, -0.2531F, 0.0F, 0.0F));

        ModelPartData cube_r313 = Body.addChild("cube_r313", ModelPartBuilder.create().uv(1632, 221).cuboid(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.3624F, -18.877F, 5.3337F, 0.2834F, -0.0122F, 0.0856F));

        ModelPartData cube_r314 = Body.addChild("cube_r314", ModelPartBuilder.create().uv(1632, 221).cuboid(-2.9F, -1.0F, -0.8375F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(3.6F, -18.5371F, 4.8554F, 0.2967F, -0.2967F, 0.0F));

        ModelPartData cube_r315 = Body.addChild("cube_r315", ModelPartBuilder.create().uv(1646, 227).cuboid(-3.0F, -1.175F, -2.9125F, 6.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -18.6365F, 5.7791F, 0.2967F, 0.0F, 0.0F));

        ModelPartData cube_r316 = Body.addChild("cube_r316", ModelPartBuilder.create().uv(1646, 234).cuboid(-3.0F, -2.95F, -2.9375F, 6.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.0547F, 9.0229F, 0.8901F, 0.0F, 0.0F));

        ModelPartData cube_r317 = Body.addChild("cube_r317", ModelPartBuilder.create().uv(1583, 221).cuboid(-3.0F, 1.425F, 1.025F, 6.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.5F, 5.6375F, 1.5795F, 0.0F, 0.0F));

        ModelPartData cube_r318 = Body.addChild("cube_r318", ModelPartBuilder.create().uv(1609, 249).cuboid(-3.0F, -1.7375F, -2.2875F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.5F, 5.6375F, 1.4486F, 0.0F, 0.0F));

        ModelPartData cube_r319 = Body.addChild("cube_r319", ModelPartBuilder.create().uv(1605, 298).cuboid(-4.0F, 0.0375F, -0.25F, 8.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.5F, 5.6375F, 0.5323F, 0.0F, 0.0F));

        ModelPartData cube_r320 = Body.addChild("cube_r320", ModelPartBuilder.create().uv(1648, 199).cuboid(-4.0F, -1.55F, -0.1875F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(1584, 199).cuboid(-4.0F, -1.875F, -0.8875F, 8.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.8563F, -12.819F, 0.0087F, 0.0F, 0.0F));

        ModelPartData cube_r321 = Body.addChild("cube_r321", ModelPartBuilder.create().uv(1642, 211).cuboid(-4.0F, 0.4625F, -3.2125F, 8.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.5F, -11.3125F, -0.9032F, 0.0F, 0.0F));

        ModelPartData cube_r322 = Body.addChild("cube_r322", ModelPartBuilder.create().uv(1626, 266).cuboid(0.225F, -5.8375F, -3.0875F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -13.0F, 6.0F, 0.0F, -0.2967F, 0.0F));

        ModelPartData RightArm = modelPartData.addChild("RightArm", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, 20.7558F, 9.1888F));

        ModelPartData cube_r323 = RightArm.addChild("cube_r323", ModelPartBuilder.create().uv(1655, 172).cuboid(-1.0F, -0.8625F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -3.663F, -1.5898F, -1.2566F, 0.0F, 0.0F));

        ModelPartData cube_r324 = RightArm.addChild("cube_r324", ModelPartBuilder.create().uv(1624, 157).cuboid(-1.0F, -1.4125F, -11.7875F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F))
                .uv(1672, 128).cuboid(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 0.0F, 0.0F, -1.0821F, 0.0F, 0.0F));

        ModelPartData RightHand = RightArm.addChild("RightHand", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.6488F, 1.4084F));

        ModelPartData cube_r325 = RightHand.addChild("cube_r325", ModelPartBuilder.create().uv(1624, 226).cuboid(-1.125F, -2.775F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1875F))
                .uv(1584, 276).cuboid(-0.475F, -2.775F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1875F))
                .uv(1636, 239).cuboid(0.1625F, -2.775F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1875F))
                .uv(1596, 229).cuboid(-1.0F, -1.325F, -0.1375F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 0.0F, 0.0F, -1.5272F, 0.0F, 0.0F));

        ModelPartData LeftArm = modelPartData.addChild("LeftArm", ModelPartBuilder.create(), ModelTransform.pivot(-7.0F, 20.7558F, 9.1888F));

        ModelPartData cube_r326 = LeftArm.addChild("cube_r326", ModelPartBuilder.create().uv(1672, 128).mirrored().cuboid(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
                .uv(1624, 157).mirrored().cuboid(-1.0F, -1.4125F, -11.7875F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, 0.0F, 0.0F, -1.0821F, 0.0F, 0.0F));

        ModelPartData cube_r327 = LeftArm.addChild("cube_r327", ModelPartBuilder.create().uv(1655, 172).mirrored().cuboid(-1.0F, -0.8625F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, -3.663F, -1.5898F, -1.2566F, 0.0F, 0.0F));

        ModelPartData LeftHand = LeftArm.addChild("LeftHand", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.6488F, 1.4084F));

        ModelPartData cube_r328 = LeftHand.addChild("cube_r328", ModelPartBuilder.create().uv(1584, 276).mirrored().cuboid(-0.525F, -2.775F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1875F)).mirrored(false)
                .uv(1636, 239).mirrored().cuboid(-1.1625F, -2.775F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1875F)).mirrored(false)
                .uv(1597, 233).mirrored().cuboid(-1.0F, -1.325F, -0.1375F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(1624, 226).mirrored().cuboid(0.125F, -2.775F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1875F)).mirrored(false), ModelTransform.of(3.0F, 0.0F, 0.0F, -1.5272F, 0.0F, 0.0F));

        ModelPartData RightLeg = modelPartData.addChild("RightLeg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 1.8625F));

        ModelPartData cube_r329 = RightLeg.addChild("cube_r329", ModelPartBuilder.create().uv(1584, 199).cuboid(-1.0F, -1.8125F, -0.675F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(1655, 247).cuboid(-1.0F, -1.6F, -0.675F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -11.1961F, -4.2869F, 1.0603F, 0.0F, 0.0F));

        ModelPartData cube_r330 = RightLeg.addChild("cube_r330", ModelPartBuilder.create().uv(1652, 268).cuboid(-1.0F, -2.0125F, 1.2F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -10.2125F, -6.5F, -0.0131F, 0.0F, 0.0F));

        ModelPartData cube_r331 = RightLeg.addChild("cube_r331", ModelPartBuilder.create().uv(1652, 263).cuboid(-1.0F, -2.0625F, 0.425F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -10.2125F, -6.5F, -0.7112F, 0.0F, 0.0F));

        ModelPartData cube_r332 = RightLeg.addChild("cube_r332", ModelPartBuilder.create().uv(1655, 252).cuboid(-1.0F, 2.85F, 1.875F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -10.2125F, -6.5F, -1.5795F, 0.0F, 0.0F));

        ModelPartData cube_r333 = RightLeg.addChild("cube_r333", ModelPartBuilder.create().uv(1608, 267).cuboid(-1.0F, 1.2875F, 0.35F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -10.2125F, -6.5F, -1.4137F, 0.0F, 0.0F));

        ModelPartData cube_r334 = RightLeg.addChild("cube_r334", ModelPartBuilder.create().uv(1609, 241).cuboid(-1.0F, -1.275F, 0.075F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -10.2125F, -6.5F, -1.2217F, 0.0F, 0.0F));

        ModelPartData cube_r335 = RightLeg.addChild("cube_r335", ModelPartBuilder.create().uv(1584, 199).cuboid(-1.0F, 1.2F, -1.2F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1615, 272).cuboid(-1.0F, 0.7125F, -1.2F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -9.6643F, -7.9538F, -0.7461F, 0.0F, 0.0F));

        ModelPartData cube_r336 = RightLeg.addChild("cube_r336", ModelPartBuilder.create().uv(1593, 271).cuboid(-1.0F, -2.2625F, -1.5125F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -8.5469F, -8.7335F, -0.9948F, 0.0F, 0.0F));

        ModelPartData cube_r337 = RightLeg.addChild("cube_r337", ModelPartBuilder.create().uv(1641, 266).cuboid(-1.0F, -2.925F, -1.5F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -10.2125F, -6.5F, -0.8727F, 0.0F, 0.0F));

        ModelPartData RightLowerLeg = RightLeg.addChild("RightLowerLeg", ModelPartBuilder.create(), ModelTransform.of(4.0F, -3.7644F, -6.2313F, -0.0262F, 0.0F, 0.0F));

        ModelPartData cube_r338 = RightLowerLeg.addChild("cube_r338", ModelPartBuilder.create().uv(1585, 200).cuboid(-0.5F, 2.8751F, -3.7937F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r339 = RightLowerLeg.addChild("cube_r339", ModelPartBuilder.create().uv(1648, 208).cuboid(-0.5F, 3.5735F, -2.2562F, 1.0F, 1.0F, 1.0F, new Dilation(-0.225F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.1737F, 0.0F, 0.0F));

        ModelPartData cube_r340 = RightLowerLeg.addChild("cube_r340", ModelPartBuilder.create().uv(1658, 208).cuboid(-0.5F, 3.164F, -1.6322F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1375F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.0341F, 0.0F, 0.0F));

        ModelPartData cube_r341 = RightLowerLeg.addChild("cube_r341", ModelPartBuilder.create().uv(1594, 276).cuboid(-0.5F, 2.7425F, -0.9222F, 1.0F, 1.0F, 1.0F, new Dilation(-0.0375F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.8508F, 0.0F, 0.0F));

        ModelPartData cube_r342 = RightLowerLeg.addChild("cube_r342", ModelPartBuilder.create().uv(1653, 208).cuboid(-0.5F, 2.0391F, -0.2638F, 1.0F, 1.0F, 1.0F, new Dilation(0.1875F))
                .uv(1641, 274).cuboid(-0.5F, -5.9984F, -1.4388F, 1.0F, 2.0F, 1.0F, new Dilation(0.1875F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.6807F, 0.0F, 0.0F));

        ModelPartData cube_r343 = RightLowerLeg.addChild("cube_r343", ModelPartBuilder.create().uv(1585, 199).cuboid(-0.5F, -6.2384F, -0.6481F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.8639F, 0.0F, 0.0F));

        ModelPartData LeftLeg = modelPartData.addChild("LeftLeg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 1.8625F));

        ModelPartData cube_r344 = LeftLeg.addChild("cube_r344", ModelPartBuilder.create().uv(1655, 252).mirrored().cuboid(-1.0F, 2.85F, 1.875F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -10.2125F, -6.5F, -1.5795F, 0.0F, 0.0F));

        ModelPartData cube_r345 = LeftLeg.addChild("cube_r345", ModelPartBuilder.create().uv(1615, 272).mirrored().cuboid(-1.0F, 0.7125F, -1.2F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(1584, 199).mirrored().cuboid(-1.0F, 1.2F, -1.2F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -9.6643F, -7.9538F, -0.7461F, 0.0F, 0.0F));

        ModelPartData cube_r346 = LeftLeg.addChild("cube_r346", ModelPartBuilder.create().uv(1608, 267).mirrored().cuboid(-1.0F, 1.2875F, 0.35F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -10.2125F, -6.5F, -1.4137F, 0.0F, 0.0F));

        ModelPartData cube_r347 = LeftLeg.addChild("cube_r347", ModelPartBuilder.create().uv(1593, 271).mirrored().cuboid(-1.0F, -2.2625F, -1.5125F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -8.5469F, -8.7335F, -0.9948F, 0.0F, 0.0F));

        ModelPartData cube_r348 = LeftLeg.addChild("cube_r348", ModelPartBuilder.create().uv(1609, 241).mirrored().cuboid(-1.0F, -1.275F, 0.075F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -10.2125F, -6.5F, -1.2217F, 0.0F, 0.0F));

        ModelPartData cube_r349 = LeftLeg.addChild("cube_r349", ModelPartBuilder.create().uv(1641, 266).mirrored().cuboid(-1.0F, -2.925F, -1.5F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -10.2125F, -6.5F, -0.8727F, 0.0F, 0.0F));

        ModelPartData cube_r350 = LeftLeg.addChild("cube_r350", ModelPartBuilder.create().uv(1655, 247).mirrored().cuboid(-1.0F, -1.6F, -0.675F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(1584, 199).mirrored().cuboid(-1.0F, -1.8125F, -0.675F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -11.1961F, -4.2869F, 1.0603F, 0.0F, 0.0F));

        ModelPartData cube_r351 = LeftLeg.addChild("cube_r351", ModelPartBuilder.create().uv(1652, 268).mirrored().cuboid(-1.0F, -2.0125F, 1.2F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -10.2125F, -6.5F, -0.0131F, 0.0F, 0.0F));

        ModelPartData cube_r352 = LeftLeg.addChild("cube_r352", ModelPartBuilder.create().uv(1652, 263).mirrored().cuboid(-1.0F, -2.0625F, 0.425F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -10.2125F, -6.5F, -0.7112F, 0.0F, 0.0F));

        ModelPartData LeftLowerLeg = LeftLeg.addChild("LeftLowerLeg", ModelPartBuilder.create(), ModelTransform.of(-4.0F, -3.7644F, -6.2313F, -0.0262F, 0.0F, 0.0F));

        ModelPartData cube_r353 = LeftLowerLeg.addChild("cube_r353", ModelPartBuilder.create().uv(1648, 208).mirrored().cuboid(-0.5F, 3.5735F, -2.2562F, 1.0F, 1.0F, 1.0F, new Dilation(-0.225F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.1737F, 0.0F, 0.0F));

        ModelPartData cube_r354 = LeftLowerLeg.addChild("cube_r354", ModelPartBuilder.create().uv(1658, 208).mirrored().cuboid(-0.5F, 3.164F, -1.6322F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1375F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.0341F, 0.0F, 0.0F));

        ModelPartData cube_r355 = LeftLowerLeg.addChild("cube_r355", ModelPartBuilder.create().uv(1594, 276).mirrored().cuboid(-0.5F, 2.7425F, -0.9222F, 1.0F, 1.0F, 1.0F, new Dilation(-0.0375F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.8508F, 0.0F, 0.0F));

        ModelPartData cube_r356 = LeftLowerLeg.addChild("cube_r356", ModelPartBuilder.create().uv(1653, 208).mirrored().cuboid(-0.5F, 2.0391F, -0.2638F, 1.0F, 1.0F, 1.0F, new Dilation(0.1875F)).mirrored(false)
                .uv(1641, 274).mirrored().cuboid(-0.5F, -5.9984F, -1.4388F, 1.0F, 2.0F, 1.0F, new Dilation(0.1875F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.6807F, 0.0F, 0.0F));

        ModelPartData cube_r357 = LeftLowerLeg.addChild("cube_r357", ModelPartBuilder.create().uv(1585, 200).mirrored().cuboid(-0.5F, 2.8751F, -3.7937F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData cube_r358 = LeftLowerLeg.addChild("cube_r358", ModelPartBuilder.create().uv(1585, 199).mirrored().cuboid(-0.5F, -6.2384F, -0.6481F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.8639F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 2000, 781);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        RightArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        LeftArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        RightLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        LeftLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(BeautyAndTheBeastEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
