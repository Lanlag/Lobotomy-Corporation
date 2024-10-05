package net.uniego.aida.lobecorp.item.ego.gift.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;

//教学用EGO饰品模型
@Environment(EnvType.CLIENT)
public class StandardTrainingEGOGiftModel extends LobeCorpItemModel {
    private final ModelPart hat;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;

    public StandardTrainingEGOGiftModel(ModelPart root) {
        super(root);
        this.hat = root.getChild("hat");
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(10, 21).cuboid(2.19F, -9.3679F, -5.5875F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(5, 17).cuboid(2.51F, -9.3679F, -5.5875F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(20, 17).cuboid(-0.6625F, -1.7647F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(10, 17).cuboid(-0.3375F, -1.7647F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.6625F, -0.2397F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.975F, -1.7647F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.225F, -1.6147F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.3F, -1.4647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.3F, -1.1397F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.3F, -0.9647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.525F, -0.9647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.775F, -0.9647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.625F, -1.2397F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.4125F, -1.4022F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.6625F, -0.6647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.9875F, -0.2397F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.2125F, -0.3397F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.3875F, 0.4978F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.4875F, 0.2728F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.4875F, -0.0397F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.7625F, -0.0397F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.625F, 0.1853F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.6625F, -0.3397F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.425F, 0.3103F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F)), ModelTransform.of(2.8497F, -7.6054F, -4.8125F, 3.1416F, 0.0F, 1.5708F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(10, 21).cuboid(-0.6597F, -1.7625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(5, 17).cuboid(-0.3397F, -1.7625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F)), ModelTransform.of(2.8497F, -7.6054F, -4.8125F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(0, 21).cuboid(-0.6625F, -0.3347F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.625F, 0.1903F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.7625F, -0.0347F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.4875F, -0.0347F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.4875F, 0.2778F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.3875F, 0.5028F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.2125F, -0.3347F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.9875F, -0.2347F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.4375F, 0.3403F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.6625F, -0.6647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.4125F, -1.4022F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.625F, -1.2397F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.775F, -0.9647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.525F, -0.9647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.3F, -0.9647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.3F, -1.1397F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.3F, -1.4647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.225F, -1.6147F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.975F, -1.7647F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.6625F, -1.7647F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F)), ModelTransform.of(2.8497F, -7.6054F, -4.8125F, -3.1416F, 0.0F, -1.5708F));

        ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(10, 21).cuboid(-0.6647F, -1.7625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(5, 17).cuboid(-0.3397F, -1.7625F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F)), ModelTransform.of(2.8497F, -7.6054F, -4.8125F, -3.1416F, 0.0F, 0.0F));

        ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(20, 17).cuboid(0.0563F, -1.1272F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.2562F, -1.1272F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.5062F, -0.9772F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.5812F, -0.8272F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.5812F, -0.5022F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.5812F, -0.3272F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.8062F, -0.3272F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-1.0563F, -0.3272F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.9062F, -0.6022F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.6937F, -0.5897F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.7437F, -0.7647F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(0.0563F, -0.0272F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F)), ModelTransform.of(2.2122F, -6.8866F, -5.0875F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(5, 17).cuboid(-0.9772F, -1.0438F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F)), ModelTransform.of(2.2122F, -6.8866F, -5.0875F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(0, 21).cuboid(-0.3F, 0.625F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(0.4625F, -0.025F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.5F, 0.5F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.6375F, 0.275F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.3625F, 0.275F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.3625F, 0.5875F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.2625F, 0.8125F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.0875F, -0.025F, -0.6625F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(0.1375F, 0.075F, -0.6625F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(0.4625F, -0.35F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.2875F, -1.0875F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.5F, -0.925F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.65F, -0.65F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.4F, -0.65F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.175F, -0.65F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.175F, -0.825F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.35F, -1.0375F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.175F, -1.15F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(-0.1F, -1.3F, -0.6625F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(0.15F, -1.45F, -0.6625F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(0.4625F, 0.075F, -0.6625F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(10, 17).cuboid(0.7875F, -1.45F, -0.6625F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(20, 17).cuboid(0.4625F, -1.45F, -0.6625F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 25).cuboid(0.625F, -1.45F, -0.525F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(3.1644F, -8.7304F, -4.925F, 0.0F, 0.0F, 1.5708F));

        ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(0, 21).cuboid(-0.725F, -0.2434F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.275F, -0.8184F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.5F, -0.9184F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.675F, -0.0809F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.775F, -0.3059F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.775F, -0.6184F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-1.05F, -0.6184F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(-0.9125F, -0.3934F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F))
                .uv(0, 21).cuboid(0.05F, -0.9184F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.3375F)), ModelTransform.of(3.4334F, -6.8929F, -5.0875F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r9 = head.addChild("cube_r9", ModelPartBuilder.create().uv(10, 21).cuboid(-0.0809F, -1.05F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.3375F)), ModelTransform.of(3.4334F, -6.8929F, -5.0875F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r10 = head.addChild("cube_r10", ModelPartBuilder.create().uv(25, 17).cuboid(-0.7401F, -1.1761F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.8528F, -6.9714F, -4.95F, 3.1416F, 0.0F, 0.3927F));

        ModelPartData cube_r11 = head.addChild("cube_r11", ModelPartBuilder.create().uv(25, 23).cuboid(-0.9484F, -1.3115F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.8528F, -6.9714F, -4.95F, -3.1416F, 0.0F, 0.7854F));

        ModelPartData cube_r12 = head.addChild("cube_r12", ModelPartBuilder.create().uv(10, 28).cuboid(-1.0884F, -1.5219F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.8528F, -6.9714F, -4.95F, 3.1416F, 0.0F, 1.1781F));

        ModelPartData cube_r13 = head.addChild("cube_r13", ModelPartBuilder.create().uv(20, 21).cuboid(-0.5045F, -1.1322F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.8528F, -6.9714F, -4.95F, 3.1416F, 0.0F, 0.0F));

        ModelPartData cube_r14 = head.addChild("cube_r14", ModelPartBuilder.create().uv(0, 28).cuboid(-0.2646F, -1.1779F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.8528F, -6.9714F, -4.95F, 3.1416F, 0.0F, -0.3927F));

        ModelPartData cube_r15 = head.addChild("cube_r15", ModelPartBuilder.create().uv(15, 27).cuboid(-0.0557F, -1.3089F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.8528F, -6.9714F, -4.95F, 3.1416F, 0.0F, -0.7854F));

        ModelPartData cube_r16 = head.addChild("cube_r16", ModelPartBuilder.create().uv(5, 25).cuboid(0.0856F, -1.5154F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.8528F, -6.9714F, -4.95F, 3.1416F, 0.0F, -1.1781F));

        ModelPartData cube_r17 = head.addChild("cube_r17", ModelPartBuilder.create().uv(5, 28).cuboid(-0.8461F, -0.937F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.2197F, -8.2339F, -4.95F, 0.0F, 0.0F, -1.1781F));

        ModelPartData cube_r18 = head.addChild("cube_r18", ModelPartBuilder.create().uv(25, 20).cuboid(-0.5008F, -0.8638F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.2197F, -8.2339F, -4.95F, 0.0F, 0.0F, -0.7854F));

        ModelPartData cube_r19 = head.addChild("cube_r19", ModelPartBuilder.create().uv(10, 25).cuboid(-0.1553F, -0.9339F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.2197F, -8.2339F, -4.95F, 0.0F, 0.0F, -0.3927F));

        ModelPartData cube_r20 = head.addChild("cube_r20", ModelPartBuilder.create().uv(15, 21).cuboid(0.1286F, -1.1322F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.2197F, -8.2339F, -4.95F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r21 = head.addChild("cube_r21", ModelPartBuilder.create().uv(15, 24).cuboid(-1.1322F, -1.1286F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(2.2197F, -8.2339F, -4.95F, 0.0F, 0.0F, -1.5708F));

        ModelPartData cube_r22 = head.addChild("cube_r22", ModelPartBuilder.create().uv(20, 24).cuboid(0.0837F, -0.8887F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(3.4325F, -8.472F, -4.95F, 0.0F, 0.0F, 1.1781F));

        ModelPartData cube_r23 = head.addChild("cube_r23", ModelPartBuilder.create().uv(25, 26).cuboid(-0.2973F, -0.7306F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(3.4325F, -8.472F, -4.95F, 0.0F, 0.0F, 0.7854F));

        ModelPartData cube_r24 = head.addChild("cube_r24", ModelPartBuilder.create().uv(20, 27).cuboid(-0.7091F, -0.7361F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1875F)), ModelTransform.of(3.4325F, -8.472F, -4.95F, 0.0F, 0.0F, 0.3927F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
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