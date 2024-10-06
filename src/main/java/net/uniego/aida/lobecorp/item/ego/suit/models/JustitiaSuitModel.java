package net.uniego.aida.lobecorp.item.ego.suit.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.uniego.aida.lobecorp.item.LobeCorpItemModel;

//正义裁决者护甲模型
@Environment(EnvType.CLIENT)
public class JustitiaSuitModel extends LobeCorpItemModel {
    private final ModelPart hat;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart RC;
    private final ModelPart LC;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;

    public JustitiaSuitModel(ModelPart root) {
        super(root);
        this.hat = root.getChild("hat");
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.RC = this.body.getChild("RC");
        this.LC = this.body.getChild("LC");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.8604F, 0.2686F, -2.095F, 8.0F, 12.0F, 4.0F, new Dilation(0.4F)), ModelTransform.pivot(-0.1396F, -0.3436F, 0.0825F));

        ModelPartData Chestplate_r1 = body.addChild("Chestplate_r1", ModelPartBuilder.create().uv(0, 83).cuboid(0.425F, -3.6875F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
                .uv(78, 61).cuboid(0.425F, -3.7F, 3.875F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
                .uv(24, 63).cuboid(0.425F, -3.3375F, 3.875F, 1.0F, 9.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(-0.8428F, 1.0323F, -2.27F, 0.0F, 0.0F, -1.5708F));

        ModelPartData Chestplate_r2 = body.addChild("Chestplate_r2", ModelPartBuilder.create().uv(16, 70).cuboid(0.425F, -4.7375F, 4.675F, 1.0F, 5.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(-0.8428F, 1.0323F, -2.27F, -1.5708F, 0.0F, -1.5708F));

        ModelPartData Chestplate_r3 = body.addChild("Chestplate_r3", ModelPartBuilder.create().uv(82, 81).cuboid(-1.425F, -3.6875F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
                .uv(74, 16).cuboid(-1.425F, -3.7F, 3.875F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
                .uv(32, 77).cuboid(-1.425F, -3.2875F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(1.1219F, 1.0323F, -2.27F, 0.0F, 0.0F, 1.5708F));

        ModelPartData Chestplate_r4 = body.addChild("Chestplate_r4", ModelPartBuilder.create().uv(36, 77).cuboid(-0.5F, -1.6875F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(1.0124F, 1.1845F, -2.27F, 0.0F, 0.0F, 0.624F));

        ModelPartData Chestplate_r5 = body.addChild("Chestplate_r5", ModelPartBuilder.create().uv(82, 3).cuboid(-0.4F, -1.825F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(-2.2107F, 0.2164F, -2.27F, 0.0F, 0.0F, -1.5708F));

        ModelPartData Chestplate_r6 = body.addChild("Chestplate_r6", ModelPartBuilder.create().uv(12, 83).cuboid(4.9125F, -6.5875F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
                .uv(12, 75).cuboid(4.9125F, -6.4125F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(-0.0874F, 8.0806F, -2.27F, 0.0F, 0.0F, -0.9905F));

        ModelPartData Chestplate_r7 = body.addChild("Chestplate_r7", ModelPartBuilder.create().uv(4, 85).cuboid(2.875F, 4.1F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(-0.25F))
                .uv(20, 63).cuboid(2.875F, -6.275F, -2.0F, 1.0F, 11.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(-3.4229F, 7.5186F, -0.77F, 0.0F, 0.0F, 0.1004F));

        ModelPartData Chestplate_r8 = body.addChild("Chestplate_r8", ModelPartBuilder.create().uv(50, 71).cuboid(-1.425F, -4.7375F, 4.675F, 1.0F, 5.0F, 1.0F, new Dilation(-0.25F)), ModelTransform.of(1.1219F, 1.0323F, -2.27F, -1.5708F, 0.0F, 1.5708F));

        ModelPartData RC = body.addChild("RC", ModelPartBuilder.create(), ModelTransform.pivot(-1.6221F, 6.7827F, -0.3393F));

        ModelPartData Chestplate_r9 = RC.addChild("Chestplate_r9", ModelPartBuilder.create().uv(51, 19).cuboid(-0.4875F, -1.0F, -2.0875F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(1.7186F, 0.7075F, 3.9929F, 0.0F, -1.4966F, -1.5708F));

        ModelPartData Chestplate_r10 = RC.addChild("Chestplate_r10", ModelPartBuilder.create().uv(36, 73).mirrored().cuboid(-4.6156F, -1.723F, -0.6231F, 1.0F, 2.0F, 2.0F, new Dilation(-0.4F)).mirrored(false), ModelTransform.of(-0.8834F, 0.0019F, 0.0F, 1.6244F, 1.4958F, 1.5172F));

        ModelPartData Chestplate_r11 = RC.addChild("Chestplate_r11", ModelPartBuilder.create().uv(0, 85).cuboid(3.4495F, -1.5878F, 0.5595F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.8858F, -1.4971F, -1.6908F));

        ModelPartData Chestplate_r12 = RC.addChild("Chestplate_r12", ModelPartBuilder.create().uv(82, 30).cuboid(-4.6133F, -2.1657F, -1.5064F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(74, 12).cuboid(-4.6133F, -1.7407F, -1.5064F, 1.0F, 2.0F, 2.0F, new Dilation(-0.4F))
                .uv(82, 18).cuboid(-4.6133F, 1.1343F, -1.5064F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(72, 0).cuboid(-4.6133F, 0.7343F, -1.5064F, 1.0F, 2.0F, 2.0F, new Dilation(-0.4F))
                .uv(60, 34).cuboid(-4.4383F, 5.0093F, -1.2939F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F))
                .uv(82, 9).cuboid(-4.6133F, 1.1343F, -1.3314F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(11, 33).cuboid(-3.8008F, -6.1282F, -0.6939F, 1.0F, 13.0F, 3.0F, new Dilation(0.4F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.6244F, 1.4958F, 1.5172F));

        ModelPartData Chestplate_r13 = RC.addChild("Chestplate_r13", ModelPartBuilder.create().uv(32, 16).cuboid(-2.8824F, -6.0976F, -1.7432F, 1.0F, 13.0F, 4.0F, new Dilation(0.4F))
                .uv(78, 81).cuboid(-3.7074F, 1.6399F, -2.3432F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(32, 81).cuboid(-3.7074F, 0.5899F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(40, 82).cuboid(-3.7074F, 0.5774F, 2.0318F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(82, 57).cuboid(-3.5315F, -1.0072F, 2.0318F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(12, 80).cuboid(-3.7074F, 0.9524F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(80, 69).cuboid(-3.7074F, 1.6274F, -2.5932F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(20, 80).cuboid(-3.7074F, 1.6399F, -2.5432F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(20, 56).cuboid(-3.5074F, 4.7524F, -2.3682F, 1.0F, 2.0F, 5.0F, new Dilation(-0.2F))
                .uv(4, 79).cuboid(-3.7074F, 1.2024F, -2.5932F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(8, 82).cuboid(-3.5074F, 4.7524F, 1.8693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData Chestplate_r14 = RC.addChild("Chestplate_r14", ModelPartBuilder.create().uv(40, 59).cuboid(-3.654F, -6.1282F, 0.1111F, 1.0F, 13.0F, 1.0F, new Dilation(0.4F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1309F, 0.9599F, 0.0F));

        ModelPartData Chestplate_r15 = RC.addChild("Chestplate_r15", ModelPartBuilder.create().uv(51, 18).cuboid(-4.4211F, 0.4488F, -1.694F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.8858F, 1.4971F, 1.429F));

        ModelPartData Chestplate_r16 = RC.addChild("Chestplate_r16", ModelPartBuilder.create().uv(84, 71).cuboid(-4.4277F, 1.3746F, -1.972F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.8858F, 1.4971F, 1.3417F));

        ModelPartData Chestplate_r17 = RC.addChild("Chestplate_r17", ModelPartBuilder.create().uv(78, 32).cuboid(-4.2915F, 0.9296F, 0.7172F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(40, 79).cuboid(-4.2665F, -1.9579F, 0.7172F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1309F, 0.9599F, 0.0F));

        ModelPartData Chestplate_r18 = RC.addChild("Chestplate_r18", ModelPartBuilder.create().uv(60, 75).cuboid(-4.2665F, -2.148F, -1.3709F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(68, 45).cuboid(-4.2915F, 0.777F, -1.3709F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F))
                .uv(74, 69).cuboid(-4.2665F, -2.148F, -0.5334F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.9599F, 0.0F));

        ModelPartData Chestplate_r19 = RC.addChild("Chestplate_r19", ModelPartBuilder.create().uv(32, 52).cuboid(-3.5074F, 1.1267F, -2.5297F, 1.0F, 2.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.144F, 0.0F, 0.0F));

        ModelPartData Chestplate_r20 = RC.addChild("Chestplate_r20", ModelPartBuilder.create().uv(72, 59).cuboid(-4.1189F, -2.9695F, -1.3472F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(44, 65).cuboid(-4.1439F, 4.7555F, -3.3472F, 1.0F, 2.0F, 4.0F, new Dilation(-0.2F))
                .uv(32, 84).cuboid(-4.1439F, 1.9055F, -0.3472F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(84, 69).cuboid(-4.1439F, 2.418F, -0.3472F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(82, 21).cuboid(-4.1439F, -2.9695F, -1.8097F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(36, 81).cuboid(-4.3439F, 1.2055F, -0.1472F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(40, 0).cuboid(-4.1064F, -6.7195F, -1.3472F, 1.0F, 14.0F, 2.0F, new Dilation(-0.2F))
                .uv(72, 8).cuboid(-4.1064F, 6.143F, -1.3472F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(76, 66).cuboid(-4.1064F, 5.493F, -1.3472F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

        ModelPartData Chestplate_r21 = RC.addChild("Chestplate_r21", ModelPartBuilder.create().uv(0, 49).cuboid(-4.1689F, -6.2865F, -2.6093F, 1.0F, 15.0F, 1.0F, new Dilation(-0.2F))
                .uv(72, 26).cuboid(-4.1064F, 6.7135F, -2.5718F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(36, 33).cuboid(-4.1064F, -6.449F, -2.5718F, 1.0F, 14.0F, 2.0F, new Dilation(-0.2F))
                .uv(76, 41).cuboid(-4.1064F, -6.7365F, -2.6093F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F))
                .uv(0, 76).cuboid(-4.1064F, 6.7135F, -2.5718F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, -0.6981F, 0.0F));

        ModelPartData Chestplate_r22 = RC.addChild("Chestplate_r22", ModelPartBuilder.create().uv(30, 73).cuboid(2.5165F, 0.5865F, 0.4821F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(8, 64).cuboid(2.5165F, 0.5865F, -2.4804F, 1.0F, 2.0F, 4.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 3.1416F));

        ModelPartData Chestplate_r23 = RC.addChild("Chestplate_r23", ModelPartBuilder.create().uv(82, 0).cuboid(2.7165F, 1.18F, -2.3432F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(56, 79).cuboid(2.7165F, 1.18F, -2.5932F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(80, 72).cuboid(2.7165F, 1.18F, -2.5432F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(44, 82).cuboid(2.7165F, 0.7675F, -2.5807F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(56, 82).cuboid(2.7165F, 0.355F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(82, 63).cuboid(2.7165F, -0.0325F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(82, 66).cuboid(2.7165F, -0.0325F, 1.9818F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

        ModelPartData Chestplate_r24 = RC.addChild("Chestplate_r24", ModelPartBuilder.create().uv(45, 47).cuboid(3.4427F, -1.4929F, -1.7214F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.8858F, -1.4971F, -1.6035F));

        ModelPartData Chestplate_r25 = RC.addChild("Chestplate_r25", ModelPartBuilder.create().uv(60, 70).cuboid(-4.2915F, 4.7524F, -1.3787F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F))
                .uv(32, 59).cuboid(-3.654F, -6.0976F, -0.7412F, 1.0F, 13.0F, 1.0F, new Dilation(0.4F))
                .uv(72, 18).cuboid(-4.2915F, 4.7524F, 0.5963F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.9599F, 0.0F));

        ModelPartData Chestplate_r26 = RC.addChild("Chestplate_r26", ModelPartBuilder.create().uv(82, 33).cuboid(2.5795F, -3.5299F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData Chestplate_r27 = RC.addChild("Chestplate_r27", ModelPartBuilder.create().uv(28, 84).cuboid(-4.1439F, 1.3717F, -1.2025F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(54, 76).cuboid(-4.1439F, 1.7717F, -4.0025F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F))
                .uv(76, 50).cuboid(-4.1439F, 2.3717F, -4.6025F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F))
                .uv(68, 50).cuboid(-4.1439F, 1.3717F, -3.6025F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3927F, -0.6981F, 0.0F));

        ModelPartData Chestplate_r28 = RC.addChild("Chestplate_r28", ModelPartBuilder.create().uv(56, 51).cuboid(-4.1064F, -0.0626F, 1.725F, 1.0F, 2.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.6799F, -0.6981F, 0.0F));

        ModelPartData Chestplate_r29 = RC.addChild("Chestplate_r29", ModelPartBuilder.create().uv(84, 77).cuboid(-3.4824F, 6.8006F, 0.9091F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(62, 12).cuboid(-3.4824F, 6.8006F, -3.3409F, 1.0F, 1.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1265F, 0.0F, 0.0F));

        ModelPartData Chestplate_r30 = RC.addChild("Chestplate_r30", ModelPartBuilder.create().uv(68, 39).cuboid(-4.1064F, 0.4152F, 5.1317F, 1.0F, 3.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.453F, -0.6981F, 0.0F));

        ModelPartData Chestplate_r31 = RC.addChild("Chestplate_r31", ModelPartBuilder.create().uv(0, 79).cuboid(6.5763F, 0.9042F, 0.7111F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F))
                .uv(70, 64).cuboid(6.5763F, 0.9042F, -0.5014F, 1.0F, 3.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7072F, -0.7256F, -2.3903F));

        ModelPartData Chestplate_r32 = RC.addChild("Chestplate_r32", ModelPartBuilder.create().uv(42, 38).cuboid(0.5708F, -7.8805F, -1.0624F, 3.0F, 1.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5817F, 0.6637F, -1.7286F));

        ModelPartData Chestplate_r33 = RC.addChild("Chestplate_r33", ModelPartBuilder.create().uv(52, 82).cuboid(6.5763F, 0.7422F, -1.741F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(82, 48).cuboid(6.5763F, 1.6047F, -1.741F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(76, 77).cuboid(6.5763F, 0.7422F, -1.4285F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.38F, -0.7256F, -2.3903F));

        ModelPartData Chestplate_r34 = RC.addChild("Chestplate_r34", ModelPartBuilder.create().uv(78, 28).cuboid(5.9492F, 1.0887F, 1.8693F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F))
                .uv(8, 49).cuboid(5.9492F, 1.0887F, -2.3807F, 1.0F, 3.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.5744F));

        ModelPartData Chestplate_r35 = RC.addChild("Chestplate_r35", ModelPartBuilder.create().uv(44, 71).cuboid(6.2411F, 1.0556F, -2.5644F, 1.0F, 3.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5246F, 0.5123F, -2.5413F));

        ModelPartData Chestplate_r36 = RC.addChild("Chestplate_r36", ModelPartBuilder.create().uv(60, 0).cuboid(-2.6527F, -8.2042F, -1.0602F, 1.0F, 1.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.6082F, 1.3748F, -1.7581F));

        ModelPartData Chestplate_r37 = RC.addChild("Chestplate_r37", ModelPartBuilder.create().uv(84, 75).cuboid(7.3002F, -1.7533F, 0.7111F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(76, 38).cuboid(7.3002F, -1.7533F, -0.5014F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.9466F, -0.2327F, -1.8947F));

        ModelPartData Chestplate_r38 = RC.addChild("Chestplate_r38", ModelPartBuilder.create().uv(76, 35).cuboid(7.1265F, -1.4291F, -2.5644F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7072F, 0.1234F, -1.9816F));

        ModelPartData Chestplate_r39 = RC.addChild("Chestplate_r39", ModelPartBuilder.create().uv(60, 24).cuboid(6.915F, -1.2252F, -2.3807F, 1.0F, 1.0F, 5.0F, new Dilation(-0.2F))
                .uv(48, 84).cuboid(6.915F, -1.2252F, 1.8693F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.9199F));

        ModelPartData Chestplate_r40 = RC.addChild("Chestplate_r40", ModelPartBuilder.create().uv(48, 77).cuboid(5.9492F, 0.5302F, -3.2392F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.24F, 0.0F, -2.5744F));

        ModelPartData Chestplate_r41 = RC.addChild("Chestplate_r41", ModelPartBuilder.create().uv(32, 49).cuboid(0.3581F, -7.8805F, -1.7806F, 3.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.4103F, 0.647F, -1.4484F));

        ModelPartData Chestplate_r42 = RC.addChild("Chestplate_r42", ModelPartBuilder.create().uv(78, 53).cuboid(6.5763F, 0.667F, 1.2752F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.86F, -0.7256F, -2.3903F));

        ModelPartData Chestplate_r43 = RC.addChild("Chestplate_r43", ModelPartBuilder.create().uv(78, 4).cuboid(5.9492F, 0.7323F, 2.4744F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, -2.5744F));

        ModelPartData Chestplate_r44 = RC.addChild("Chestplate_r44", ModelPartBuilder.create().uv(78, 16).cuboid(6.2411F, 1.2042F, -0.6497F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2846F, 0.5123F, -2.5413F));

        ModelPartData LC = body.addChild("LC", ModelPartBuilder.create().uv(44, 52).cuboid(2.5106F, 4.6773F, -2.3682F, 1.0F, 2.0F, 5.0F, new Dilation(-0.2F))
                .uv(82, 6).cuboid(2.5106F, 4.6773F, 1.8693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(82, 39).cuboid(2.7106F, 0.5023F, 2.0318F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(28, 81).cuboid(2.7106F, 0.5148F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(80, 12).cuboid(2.7106F, 0.8773F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(8, 79).cuboid(2.7106F, 1.1273F, -2.5932F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(24, 80).cuboid(2.7106F, 1.5648F, -2.5432F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(52, 79).cuboid(2.7106F, 1.5648F, -2.5932F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(74, 81).cuboid(2.7106F, 1.5648F, -2.3432F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(60, 82).cuboid(2.5348F, -1.0823F, 2.0318F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(20, 32).cuboid(1.8856F, -6.1727F, -1.7432F, 1.0F, 13.0F, 4.0F, new Dilation(0.4F)), ModelTransform.pivot(1.8887F, 6.7827F, -0.3393F));

        ModelPartData Chestplate_r45 = LC.addChild("Chestplate_r45", ModelPartBuilder.create().uv(51, 18).mirrored().cuboid(3.4211F, 0.4488F, -1.694F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.8858F, -1.4971F, -1.429F));

        ModelPartData Chestplate_r46 = LC.addChild("Chestplate_r46", ModelPartBuilder.create().uv(45, 47).mirrored().cuboid(-4.4427F, -1.4929F, -1.7214F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.8858F, 1.4971F, 1.6035F));

        ModelPartData Chestplate_r47 = LC.addChild("Chestplate_r47", ModelPartBuilder.create().uv(42, 16).cuboid(2.4322F, -6.7965F, -1.9129F, 1.0F, 14.0F, 2.0F, new Dilation(-0.2F))
                .uv(82, 24).cuboid(2.4697F, -3.0465F, -2.3754F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(72, 55).cuboid(2.4447F, -3.0465F, -1.9129F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(60, 64).cuboid(2.4697F, 4.6785F, -3.9129F, 1.0F, 2.0F, 4.0F, new Dilation(-0.2F))
                .uv(22, 77).cuboid(2.4322F, 5.416F, -1.9129F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F))
                .uv(48, 81).cuboid(2.6697F, 1.1285F, -0.7129F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(84, 12).cuboid(2.4697F, 1.8285F, -0.9129F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(68, 84).cuboid(2.4697F, 2.341F, -0.9129F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(72, 4).cuboid(2.4322F, 6.066F, -1.9129F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.0F, 0.6981F, 0.0F));

        ModelPartData Chestplate_r48 = LC.addChild("Chestplate_r48", ModelPartBuilder.create().uv(4, 49).cuboid(2.4947F, -6.264F, -3.1798F, 1.0F, 15.0F, 1.0F, new Dilation(-0.2F))
                .uv(76, 63).cuboid(2.4322F, 6.736F, -3.1423F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F))
                .uv(42, 76).cuboid(2.4322F, -6.714F, -3.1673F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F))
                .uv(72, 22).cuboid(2.4322F, 6.736F, -3.1423F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(30, 33).cuboid(2.4322F, -6.4265F, -3.1423F, 1.0F, 14.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -0.1745F, 0.6981F, 0.0F));

        ModelPartData Chestplate_r49 = LC.addChild("Chestplate_r49", ModelPartBuilder.create().uv(84, 79).cuboid(-0.5F, -0.5375F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.9197F, -1.5831F, 3.8417F, 1.9294F, 1.4971F, 1.6908F));

        ModelPartData Chestplate_r50 = LC.addChild("Chestplate_r50", ModelPartBuilder.create().uv(82, 27).cuboid(3.6156F, -2.148F, -0.6231F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(36, 73).cuboid(3.6156F, -1.723F, -0.6231F, 1.0F, 2.0F, 2.0F, new Dilation(-0.4F))
                .uv(16, 82).cuboid(3.6156F, 1.152F, -0.4481F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(82, 15).cuboid(3.6156F, 1.152F, -0.6231F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(70, 35).cuboid(3.6156F, 0.752F, -0.6231F, 1.0F, 2.0F, 2.0F, new Dilation(-0.4F))
                .uv(10, 59).cuboid(3.4406F, 5.027F, -0.4106F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F))
                .uv(1, 33).cuboid(2.8031F, -6.1105F, 0.1894F, 1.0F, 13.0F, 3.0F, new Dilation(0.4F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 1.6244F, -1.4958F, -1.5172F));

        ModelPartData Chestplate_r51 = LC.addChild("Chestplate_r51", ModelPartBuilder.create().uv(36, 59).cuboid(2.1492F, -6.1105F, 0.8359F, 1.0F, 13.0F, 1.0F, new Dilation(0.4F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.1309F, -0.9599F, 0.0F));

        ModelPartData Chestplate_r52 = LC.addChild("Chestplate_r52", ModelPartBuilder.create().uv(72, 84).cuboid(3.4185F, 1.764F, -1.179F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 1.8858F, -1.4971F, -1.3417F));

        ModelPartData Chestplate_r53 = LC.addChild("Chestplate_r53", ModelPartBuilder.create().uv(44, 79).cuboid(2.7617F, -1.9401F, 1.442F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(68, 55).cuboid(2.7867F, 0.9474F, 1.442F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.1309F, -0.9599F, 0.0F));

        ModelPartData Chestplate_r54 = LC.addChild("Chestplate_r54", ModelPartBuilder.create().uv(74, 73).cuboid(2.7617F, -2.225F, 0.1875F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(6, 75).cuboid(2.7617F, -2.225F, -0.65F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(58, 39).cuboid(2.7867F, 0.7F, -0.65F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.0F, -0.9599F, 0.0F));

        ModelPartData Chestplate_r55 = LC.addChild("Chestplate_r55", ModelPartBuilder.create().uv(20, 49).cuboid(1.6273F, 1.0505F, -2.5186F, 1.0F, 2.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.144F, 0.0F, 0.0F));

        ModelPartData Chestplate_r56 = LC.addChild("Chestplate_r56", ModelPartBuilder.create().uv(80, 75).cuboid(-2.8364F, 1.257F, -2.5432F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(60, 79).cuboid(-2.8364F, 1.257F, -2.5932F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(70, 81).cuboid(-2.8364F, 1.257F, -2.3432F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(82, 42).cuboid(-2.8364F, 0.8445F, -2.5807F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(82, 54).cuboid(-2.8364F, 0.432F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(82, 60).cuboid(-2.8364F, 0.0445F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F))
                .uv(64, 82).cuboid(-2.8364F, 0.0445F, 1.9818F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.0F, 0.0F, -3.1416F));

        ModelPartData Chestplate_r57 = LC.addChild("Chestplate_r57", ModelPartBuilder.create().uv(82, 36).cuboid(-2.6994F, -3.4529F, 2.0693F, 1.0F, 2.0F, 1.0F, new Dilation(-0.4F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.0F, 0.0F, 3.1416F));

        ModelPartData Chestplate_r58 = LC.addChild("Chestplate_r58", ModelPartBuilder.create().uv(62, 18).cuboid(-2.6364F, 0.6624F, -2.4938F, 1.0F, 2.0F, 4.0F, new Dilation(-0.2F))
                .uv(24, 73).cuboid(-2.6364F, 0.6624F, 0.4687F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.1745F, 0.0F, -3.1416F));

        ModelPartData Chestplate_r59 = LC.addChild("Chestplate_r59", ModelPartBuilder.create().uv(82, 83).cuboid(2.4697F, 1.0841F, -1.6956F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(76, 47).cuboid(2.4697F, 1.4841F, -4.4956F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F))
                .uv(76, 44).cuboid(2.4697F, 2.0841F, -5.0956F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F))
                .uv(8, 70).cuboid(2.4697F, 1.0841F, -4.0956F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.3927F, 0.6981F, 0.0F));

        ModelPartData Chestplate_r60 = LC.addChild("Chestplate_r60", ModelPartBuilder.create().uv(54, 72).cuboid(2.7867F, 4.6754F, 1.3172F, 1.0F, 2.0F, 2.0F, new Dilation(-0.2F))
                .uv(56, 58).cuboid(2.1492F, -6.1746F, -0.0203F, 1.0F, 13.0F, 1.0F, new Dilation(0.4F))
                .uv(70, 30).cuboid(2.7867F, 4.6754F, -0.6578F, 1.0F, 2.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.0F, -0.9599F, 0.0F));

        ModelPartData Chestplate_r61 = LC.addChild("Chestplate_r61", ModelPartBuilder.create().uv(76, 84).cuboid(1.6023F, 6.7242F, 0.9189F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(60, 58).cuboid(1.6023F, 6.7242F, -3.3311F, 1.0F, 1.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.1265F, 0.0F, 0.0F));

        ModelPartData Chestplate_r62 = LC.addChild("Chestplate_r62", ModelPartBuilder.create().uv(66, 78).cuboid(-7.1344F, 0.7986F, 2.0288F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -0.86F, 0.7256F, 2.3903F));

        ModelPartData Chestplate_r63 = LC.addChild("Chestplate_r63", ModelPartBuilder.create().uv(60, 30).cuboid(-3.5048F, -7.8518F, -0.9099F, 3.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -1.4103F, -0.647F, 1.4484F));

        ModelPartData Chestplate_r64 = LC.addChild("Chestplate_r64", ModelPartBuilder.create().uv(82, 51).cuboid(-7.1344F, 2.0695F, -1.1334F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(78, 0).cuboid(-7.1344F, 1.207F, -0.8209F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F))
                .uv(82, 45).cuboid(-7.1344F, 1.207F, -1.1334F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -0.38F, 0.7256F, 2.3903F));

        ModelPartData Chestplate_r65 = LC.addChild("Chestplate_r65", ModelPartBuilder.create().uv(78, 8).cuboid(-6.2483F, 1.2655F, 2.5446F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -0.1309F, 0.0F, 2.5744F));

        ModelPartData Chestplate_r66 = LC.addChild("Chestplate_r66", ModelPartBuilder.create().uv(68, 70).cuboid(-7.1344F, 1.1489F, 0.2234F, 1.0F, 3.0F, 2.0F, new Dilation(-0.2F))
                .uv(78, 57).cuboid(-7.1344F, 1.1489F, 1.4359F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -0.7072F, 0.7256F, 2.3903F));

        ModelPartData Chestplate_r67 = LC.addChild("Chestplate_r67", ModelPartBuilder.create().uv(78, 24).cuboid(-6.646F, 1.6484F, -1.1283F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.2846F, -0.5123F, 2.5413F));

        ModelPartData Chestplate_r68 = LC.addChild("Chestplate_r68", ModelPartBuilder.create().uv(72, 77).cuboid(-6.2483F, 1.0526F, -3.367F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.24F, 0.0F, 2.5744F));

        ModelPartData Chestplate_r69 = LC.addChild("Chestplate_r69", ModelPartBuilder.create().uv(42, 32).cuboid(-3.5217F, -7.8518F, -0.1808F, 3.0F, 1.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -1.5817F, -0.6637F, 1.7286F));

        ModelPartData Chestplate_r70 = LC.addChild("Chestplate_r70", ModelPartBuilder.create().uv(0, 71).cuboid(-6.646F, 1.3733F, -3.1349F, 1.0F, 3.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.5246F, -0.5123F, 2.5413F));

        ModelPartData Chestplate_r71 = LC.addChild("Chestplate_r71", ModelPartBuilder.create().uv(48, 24).cuboid(-6.2483F, 1.6265F, -2.3807F, 1.0F, 3.0F, 5.0F, new Dilation(-0.2F))
                .uv(78, 20).cuboid(-6.2483F, 1.6265F, 1.8693F, 1.0F, 3.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.0F, 0.0F, 2.5744F));

        ModelPartData Chestplate_r72 = LC.addChild("Chestplate_r72", ModelPartBuilder.create().uv(84, 73).cuboid(-8.0987F, -1.2901F, 1.4359F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -0.9466F, 0.2327F, 1.8947F));

        ModelPartData Chestplate_r73 = LC.addChild("Chestplate_r73", ModelPartBuilder.create().uv(36, 84).cuboid(-7.6864F, -0.3718F, 1.8693F, 1.0F, 1.0F, 1.0F, new Dilation(-0.2F))
                .uv(60, 6).cuboid(-7.6864F, -0.3718F, -2.3807F, 1.0F, 1.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.0F, 0.0F, 1.9199F));

        ModelPartData Chestplate_r74 = LC.addChild("Chestplate_r74", ModelPartBuilder.create().uv(16, 76).cuboid(-1.1625F, 0.7F, -1.1125F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(1.8864F, -6.1679F, 3.9303F, -0.9466F, 0.2327F, 1.7202F));

        ModelPartData Chestplate_r75 = LC.addChild("Chestplate_r75", ModelPartBuilder.create().uv(66, 75).cuboid(-7.8478F, -0.8148F, -3.1349F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, 0.7072F, -0.1234F, 1.9816F));

        ModelPartData Chestplate_r76 = LC.addChild("Chestplate_r76", ModelPartBuilder.create().uv(44, 59).cuboid(1.6699F, -8.1505F, -0.1785F, 1.0F, 1.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -1.6082F, -1.3748F, 1.7581F));

        ModelPartData Chestplate_r77 = LC.addChild("Chestplate_r77", ModelPartBuilder.create().uv(0, 65).cuboid(2.4322F, 0.9679F, 4.9887F, 1.0F, 3.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -1.453F, 0.6981F, 0.0F));

        ModelPartData Chestplate_r78 = LC.addChild("Chestplate_r78", ModelPartBuilder.create().uv(56, 44).cuboid(2.4322F, 0.5082F, 1.7101F, 1.0F, 2.0F, 5.0F, new Dilation(-0.2F)), ModelTransform.of(0.8834F, 0.0019F, 0.0F, -1.6799F, 0.6981F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.3F)).mirrored(false)
                .uv(15, 15).mirrored().cuboid(-3.5F, 6.5F, -2.5125F, 5.0F, 2.0F, 5.0F, new Dilation(-0.05F)).mirrored(false)
                .uv(19, 15).mirrored().cuboid(0.5204F, 7.1904F, -2.5125F, 1.0F, 2.0F, 5.0F, new Dilation(-0.1F)).mirrored(false)
                .uv(15, 15).mirrored().cuboid(-3.5F, 0.9625F, -2.5125F, 5.0F, 2.0F, 5.0F, new Dilation(-0.15F)).mirrored(false)
                .uv(15, 15).mirrored().cuboid(0.5F, 2.0875F, -2.5125F, 1.0F, 2.0F, 5.0F, new Dilation(-0.1F)).mirrored(false)
                .uv(15, 15).mirrored().cuboid(-3.55F, 0.3625F, -2.5125F, 1.0F, 2.0F, 5.0F, new Dilation(-0.1F)).mirrored(false)
                .uv(19, 15).mirrored().cuboid(-3.5421F, 5.8029F, -2.5125F, 1.0F, 2.0F, 5.0F, new Dilation(-0.1F)).mirrored(false), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        ModelPartData RightArmArmor_r1 = right_arm.addChild("RightArmArmor_r1", ModelPartBuilder.create().uv(16, 15).mirrored().cuboid(-2.375F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new Dilation(-0.1F)).mirrored(false)
                .uv(16, 15).mirrored().cuboid(-1.6375F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new Dilation(-0.1F)).mirrored(false), ModelTransform.of(-1.0F, 7.5F, -0.0125F, 0.0F, 0.0F, 0.3316F));

        ModelPartData RightArmArmor_r2 = right_arm.addChild("RightArmArmor_r2", ModelPartBuilder.create().uv(16, 15).mirrored().cuboid(-1.45F, -0.525F, -2.5F, 4.0F, 2.0F, 5.0F, new Dilation(-0.1F)).mirrored(false)
                .uv(16, 15).mirrored().cuboid(-2.125F, -0.525F, -2.5F, 4.0F, 2.0F, 5.0F, new Dilation(-0.1F)).mirrored(false), ModelTransform.of(-1.0F, 1.7F, -0.0125F, 0.0F, 0.0F, 0.4363F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.3F))
                .uv(15, 15).cuboid(-1.5F, 6.5F, -2.5125F, 5.0F, 2.0F, 5.0F, new Dilation(-0.05F))
                .uv(15, 15).cuboid(-1.5F, 0.9625F, -2.5125F, 5.0F, 2.0F, 5.0F, new Dilation(-0.15F))
                .uv(15, 15).cuboid(-1.5F, 2.0875F, -2.5125F, 1.0F, 2.0F, 5.0F, new Dilation(-0.1F))
                .uv(15, 15).cuboid(2.55F, 0.3625F, -2.5125F, 1.0F, 2.0F, 5.0F, new Dilation(-0.1F))
                .uv(19, 15).cuboid(2.5421F, 5.8029F, -2.5125F, 1.0F, 2.0F, 5.0F, new Dilation(-0.1F))
                .uv(19, 15).cuboid(-1.5204F, 7.1904F, -2.5125F, 1.0F, 2.0F, 5.0F, new Dilation(-0.1F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData LeftArmArmor_r1 = left_arm.addChild("LeftArmArmor_r1", ModelPartBuilder.create().uv(16, 15).cuboid(-1.625F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new Dilation(-0.1F))
                .uv(16, 15).cuboid(-2.3625F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new Dilation(-0.1F)), ModelTransform.of(1.0F, 7.5F, -0.0125F, 0.0F, 0.0F, -0.3316F));

        ModelPartData LeftArmArmor_r2 = left_arm.addChild("LeftArmArmor_r2", ModelPartBuilder.create().uv(16, 15).cuboid(-2.55F, -0.525F, -2.5F, 4.0F, 2.0F, 5.0F, new Dilation(-0.1F))
                .uv(16, 15).cuboid(-1.875F, -0.525F, -2.5F, 4.0F, 2.0F, 5.0F, new Dilation(-0.1F)), ModelTransform.of(1.0F, 1.7F, -0.0125F, 0.0F, 0.0F, -0.4363F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0, 112).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.4F)).mirrored(false), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(0, 112).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.4F)), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
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