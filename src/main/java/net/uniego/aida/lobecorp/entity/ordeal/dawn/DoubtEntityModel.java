package net.uniego.aida.lobecorp.entity.ordeal.dawn;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

//疑问实体模型
public class DoubtEntityModel extends EntityModel<DoubtEntity> {
    private final ModelPart body;
    private final ModelPart pi_feng;
    private final ModelPart frontpi_feng1;
    private final ModelPart frontpi_feng2;
    private final ModelPart backpi_feng;
    private final ModelPart backpi_feng2;
    private final ModelPart bozi;
    private final ModelPart head;
    private final ModelPart eye3;
    private final ModelPart eye1;
    private final ModelPart eye2;
    private final ModelPart arm;
    private final ModelPart jian;
    private final ModelPart ji_zhu2;
    private final ModelPart ji_zhu3;
    private final ModelPart ji_zhu4;
    private final ModelPart ji_zhu5;
    private final ModelPart gu_pen;
    private final ModelPart left_leg;
    private final ModelPart left_leg2;
    private final ModelPart left_leg3;
    private final ModelPart right_leg;
    private final ModelPart right_leg2;
    private final ModelPart right_leg3;

    public DoubtEntityModel(ModelPart root) {
        super();
        this.body = root.getChild("body");
        this.pi_feng = this.body.getChild("pi_feng");
        this.frontpi_feng1 = this.pi_feng.getChild("frontpi_feng1");
        this.frontpi_feng2 = this.frontpi_feng1.getChild("frontpi_feng2");
        this.backpi_feng = this.pi_feng.getChild("backpi_feng");
        this.backpi_feng2 = this.backpi_feng.getChild("backpi_feng2");
        this.bozi = this.body.getChild("bozi");
        this.head = this.bozi.getChild("head");
        this.eye3 = this.head.getChild("eye3");
        this.eye1 = this.head.getChild("eye1");
        this.eye2 = this.head.getChild("eye2");
        this.arm = this.body.getChild("arm");
        this.jian = this.arm.getChild("jian");
        this.ji_zhu2 = this.body.getChild("ji_zhu2");
        this.ji_zhu3 = this.ji_zhu2.getChild("ji_zhu3");
        this.ji_zhu4 = this.ji_zhu3.getChild("ji_zhu4");
        this.ji_zhu5 = this.ji_zhu4.getChild("ji_zhu5");
        this.gu_pen = this.ji_zhu5.getChild("gu_pen");
        this.left_leg = this.gu_pen.getChild("left_leg");
        this.left_leg2 = this.left_leg.getChild("left_leg2");
        this.left_leg3 = this.left_leg2.getChild("left_leg3");
        this.right_leg = this.gu_pen.getChild("right_leg");
        this.right_leg2 = this.right_leg.getChild("right_leg2");
        this.right_leg3 = this.right_leg2.getChild("right_leg3");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.of(0.0F, -21.2F, 0.0F, -0.1745F, 3.1416F, 0.0F));

        ModelPartData body_r1 = body.addChild("body_r1", ModelPartBuilder.create().uv(54, 80).cuboid(5.8F, -7.5F, -2.2F, 2.4F, 9.0F, 6.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.4F, 0.5F, -0.1744F, 0.0076F, 0.043F));

        ModelPartData body_r2 = body.addChild("body_r2", ModelPartBuilder.create().uv(34, 107).cuboid(-2.7F, -2.5F, -2.2F, 5.4F, 7.0F, 3.4F, new Dilation(0.0F)), ModelTransform.of(4.4992F, 0.1723F, 6.4274F, -0.1438F, 0.3344F, -0.0948F));

        ModelPartData body_r3 = body.addChild("body_r3", ModelPartBuilder.create().uv(31, 83).cuboid(0.8F, -2.5F, 3.8F, 5.4F, 4.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.4F, 0.5F, -0.3568F, 0.2048F, -0.0757F));

        ModelPartData body_r4 = body.addChild("body_r4", ModelPartBuilder.create().uv(23, 42).cuboid(-2.7F, -2.5F, -2.2F, 5.4F, 7.0F, 3.4F, new Dilation(0.0F)), ModelTransform.of(-4.3151F, 0.2381F, 6.6081F, -0.14F, -0.2936F, 0.0787F));

        ModelPartData body_r5 = body.addChild("body_r5", ModelPartBuilder.create().uv(27, 5).cuboid(-6.2F, -2.5F, 3.8F, 5.4F, 4.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.4F, 0.5F, -0.354F, -0.1639F, 0.0602F));

        ModelPartData body_r6 = body.addChild("body_r6", ModelPartBuilder.create().uv(65, 62).cuboid(-2.2F, -2.5F, -1.2F, 4.4F, 6.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.4719F, 7.2506F, -0.1745F, 0.0F, 0.0F));

        ModelPartData body_r7 = body.addChild("body_r7", ModelPartBuilder.create().uv(0, 103).cuboid(-2.2F, -2.5F, 3.8F, 4.4F, 4.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.4F, 0.5F, -0.3491F, 0.0F, 0.0F));

        ModelPartData body_r8 = body.addChild("body_r8", ModelPartBuilder.create().uv(55, 98).cuboid(-8.2F, -7.5F, -2.2F, 2.4F, 9.0F, 6.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.4F, 0.5F, -0.1739F, -0.0151F, -0.0859F));

        ModelPartData body_r9 = body.addChild("body_r9", ModelPartBuilder.create().uv(88, 75).cuboid(-7.2F, -7.5F, -2.2F, 14.4F, 9.0F, 6.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.4F, 0.5F, -0.1745F, 0.0F, 0.0F));

        ModelPartData pi_feng = body.addChild("pi_feng", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.4F, 0.5F));

        ModelPartData pi_feng_r1 = pi_feng.addChild("pi_feng_r1", ModelPartBuilder.create().uv(218, 0).cuboid(-7.2F, -7.5F, -2.5F, 14.4F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        ModelPartData frontpi_feng1 = pi_feng.addChild("frontpi_feng1", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.0318F, 8.7216F, 0.3054F, 0.0F, 0.0F));

        ModelPartData frontpi_feng1_r1 = frontpi_feng1.addChild("frontpi_feng1_r1", ModelPartBuilder.create().uv(228, 0).cuboid(-7.2F, -7.5F, -2.8F, 14.4F, 21.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.8454F, 1.4417F, -0.1745F, 0.0F, 0.0F));

        ModelPartData frontpi_feng2 = frontpi_feng1.addChild("frontpi_feng2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 20.7446F, -3.7334F, 0.1309F, 0.0F, 0.0F));

        ModelPartData frontpi_feng2_r1 = frontpi_feng2.addChild("frontpi_feng2_r1", ModelPartBuilder.create().uv(228, 21).cuboid(-7.2F, 13.5F, -2.8F, 14.4F, 21.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.8687F, 5.1402F, -0.1745F, 0.0F, 0.0F));

        ModelPartData backpi_feng = pi_feng.addChild("backpi_feng", ModelPartBuilder.create(), ModelTransform.of(0.0F, -7.7818F, -1.0784F, 0.0436F, 0.0F, 0.0F));

        ModelPartData backpi_feng_r1 = backpi_feng.addChild("backpi_feng_r1", ModelPartBuilder.create().uv(228, 0).cuboid(-7.2F, -7.475F, -2.8F, 14.4F, 21.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.787F, 1.3924F, -0.1745F, 0.0F, 0.0F));

        ModelPartData backpi_feng2 = backpi_feng.addChild("backpi_feng2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 20.6862F, -3.7826F));

        ModelPartData backpi_feng2_r1 = backpi_feng2.addChild("backpi_feng2_r1", ModelPartBuilder.create().uv(228, 21).cuboid(-7.2F, 13.5F, -2.8F, 14.4F, 21.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.851F, 5.115F, -0.1745F, 0.0F, 0.0F));

        ModelPartData bozi = body.addChild("bozi", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.9575F, 4.8436F));

        ModelPartData bozi_r1 = bozi.addChild("bozi_r1", ModelPartBuilder.create().uv(82, 186).cuboid(0.8F, -6.4696F, -1.5473F, 1.4F, 6.0F, 2.4F, new Dilation(0.0F))
                .uv(82, 165).cuboid(-1.2F, -7.4696F, -2.5473F, 2.4F, 7.0F, 2.4F, new Dilation(0.0F))
                .uv(82, 186).cuboid(-2.2F, -6.4696F, -1.5473F, 1.4F, 6.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData bozi_r2 = bozi.addChild("bozi_r2", ModelPartBuilder.create().uv(62, 154).cuboid(-1.2F, -6.4696F, -1.5473F, 2.4F, 6.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));

        ModelPartData head = bozi.addChild("head", ModelPartBuilder.create().uv(185, 99).cuboid(-0.2F, -7.7723F, -7.4488F, 0.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0533F, 1.2828F));

        ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(42, 217).cuboid(-4.0F, -0.5F, -5.2F, 8.0F, 7.0F, 6.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.3182F, 4.3871F, -0.5236F, 0.0F, 0.0F));

        ModelPartData head_r2 = head.addChild("head_r2", ModelPartBuilder.create().uv(58, 186).cuboid(-3.2F, -10.5F, -3.7F, 6.4F, 12.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.3027F, 9.2525F, 0.829F, 0.0F, 0.0F));

        ModelPartData head_r3 = head.addChild("head_r3", ModelPartBuilder.create().uv(58, 247).cuboid(-2.2F, -2.5F, -0.7F, 4.4F, 7.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.7712F, 7.1394F, -0.4363F, 0.0F, 0.0F));

        ModelPartData head_r4 = head.addChild("head_r4", ModelPartBuilder.create().uv(27, 195).cuboid(-5.2F, -2.5F, -8.2F, 3.4F, 6.0F, 9.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.1901F, 4.851F, -0.7854F, 0.3054F, 0.0F));

        ModelPartData head_r5 = head.addChild("head_r5", ModelPartBuilder.create().uv(16, 236).cuboid(3.017F, -7.7082F, -7.5629F, 3.4F, 6.0F, 9.4F, new Dilation(0.0F)), ModelTransform.of(0.0822F, 1.0421F, 0.5431F, -0.7854F, -0.3054F, 0.0F));

        ModelPartData head_r6 = head.addChild("head_r6", ModelPartBuilder.create().uv(62, 202).cuboid(-4.2F, -1.5F, -4.2F, 8.4F, 6.0F, 6.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.1901F, 4.851F, -0.1745F, 0.0F, 0.0F));

        ModelPartData eye3 = head.addChild("eye3", ModelPartBuilder.create(), ModelTransform.pivot(1.5F, 0.4264F, 8.567F));

        ModelPartData eye3_r1 = eye3.addChild("eye3_r1", ModelPartBuilder.create().uv(0, 247).cuboid(-0.5F, -1.2156F, -0.6935F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData eye1 = head.addChild("eye1", ModelPartBuilder.create(), ModelTransform.pivot(3.2F, -1.6191F, 7.7941F));

        ModelPartData eye1_r1 = eye1.addChild("eye1_r1", ModelPartBuilder.create().uv(0, 224).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.5444F, 0.2635F, -0.1564F));

        ModelPartData eye2 = head.addChild("eye2", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, 1.5439F, 6.7254F));

        ModelPartData eye2_r1 = eye2.addChild("eye2_r1", ModelPartBuilder.create().uv(22, 218).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3124F, 0.2079F, -0.0666F));

        ModelPartData arm = body.addChild("arm", ModelPartBuilder.create(), ModelTransform.of(-8.0F, -1.6F, 1.5F, 0.0F, 0.0F, 0.3054F));

        ModelPartData arm_r1 = arm.addChild("arm_r1", ModelPartBuilder.create().uv(20, 61).cuboid(-1.2F, -2.0F, -4.7F, 2.4F, 4.0F, 1.4F, new Dilation(0.0F))
                .uv(33, 62).cuboid(-1.2F, -2.0F, -1.7F, 2.4F, 4.0F, 1.4F, new Dilation(0.0F)), ModelTransform.of(-1.4275F, 3.8191F, 2.4096F, -0.1687F, -0.045F, -0.258F));

        ModelPartData arm_r2 = arm.addChild("arm_r2", ModelPartBuilder.create().uv(18, 69).cuboid(-0.7F, -2.0F, -1.7F, 2.4F, 5.0F, 3.4F, new Dilation(0.0F)), ModelTransform.of(-2.9637F, 3.9439F, 0.3491F, -0.0379F, -0.0886F, -0.2563F));

        ModelPartData arm_r3 = arm.addChild("arm_r3", ModelPartBuilder.create().uv(35, 64).cuboid(-5.2F, -4.1831F, -3.8223F, 6.4F, 4.0F, 6.4F, new Dilation(0.0F)), ModelTransform.of(1.0F, 1.0F, 1.0F, -0.1687F, -0.045F, -0.258F));

        ModelPartData arm_r4 = arm.addChild("arm_r4", ModelPartBuilder.create().uv(185, 99).cuboid(0.0F, -4.0F, -4.0F, 0.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-0.017F, -2.6407F, -2.2393F, -0.1687F, -0.045F, -0.258F));

        ModelPartData arm_r5 = arm.addChild("arm_r5", ModelPartBuilder.create().uv(110, 245).cuboid(4.6235F, 2.8F, -9.2F, 0.0F, 7.4F, 3.0F, new Dilation(0.0F))
                .uv(0, 109).cuboid(4.0F, -1.2F, -6.2F, 1.4F, 11.4F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-6.1235F, 2.0587F, 5.0F, 0.0F, 0.0F, -0.1309F));

        ModelPartData arm_r6 = arm.addChild("arm_r6", ModelPartBuilder.create().uv(0, 134).cuboid(4.0F, 10.2F, -6.2F, 3.4F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-7.115F, 2.1892F, 5.0F, 0.0F, 0.0F, -0.1309F));

        ModelPartData jian = arm.addChild("jian", ModelPartBuilder.create().uv(0, 111).cuboid(0.0F, -1.7122F, 1.0995F, 1.2F, 3.0F, 14.0F, new Dilation(0.0F))
                .uv(29, 94).cuboid(-0.6F, -2.9122F, 0.0996F, 2.6F, 5.4F, 2.0F, new Dilation(0.0F))
                .uv(18, 102).cuboid(-0.3F, -1.9122F, -0.9004F, 2.0F, 3.4F, 2.0F, new Dilation(0.0F))
                .uv(185, 18).cuboid(0.7F, -5.5122F, -7.9004F, 0.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 18.1686F, -0.3005F, -0.0434F, 0.0815F, -0.1346F));

        ModelPartData jian_r1 = jian.addChild("jian_r1", ModelPartBuilder.create().uv(0, 139).cuboid(0.0F, -1.0F, -17.2F, 1.2F, 2.0F, 34.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.9664F, 18.4797F, -0.0436F, 0.0F, 0.0F));

        ModelPartData jian_r2 = jian.addChild("jian_r2", ModelPartBuilder.create().uv(58, 92).cuboid(0.0F, -1.0F, -17.2F, 1.2F, 2.0F, 34.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5477F, 18.2179F, 0.0436F, 0.0F, 0.0F));

        ModelPartData ji_zhu2 = body.addChild("ji_zhu2", ModelPartBuilder.create().uv(12, 80).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(13, 93).cuboid(-1.2F, 0.5F, -1.2F, 2.4F, 3.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.4F, 0.5F, 0.0436F, 0.0F, 0.0F));

        ModelPartData ji_zhu3 = ji_zhu2.addChild("ji_zhu3", ModelPartBuilder.create().uv(12, 80).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(13, 93).cuboid(-1.2F, 0.5F, -1.2F, 2.4F, 3.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        ModelPartData ji_zhu4 = ji_zhu3.addChild("ji_zhu4", ModelPartBuilder.create().uv(12, 80).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(13, 93).cuboid(-1.2F, 0.5F, -1.2F, 2.4F, 3.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData ji_zhu5 = ji_zhu4.addChild("ji_zhu5", ModelPartBuilder.create().uv(12, 80).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(13, 93).cuboid(-1.2F, 0.5F, -1.2F, 2.4F, 3.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        ModelPartData gu_pen = ji_zhu5.addChild("gu_pen", ModelPartBuilder.create().uv(0, 40).cuboid(-2.0F, 0.2F, -1.5F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.3F, 0.0F, 0.0873F, 0.0F, 0.0F));

        ModelPartData gu_pen_r1 = gu_pen.addChild("gu_pen_r1", ModelPartBuilder.create().uv(0, 72).cuboid(0.1F, -2.5F, -2.5F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(4.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData gu_pen_r2 = gu_pen.addChild("gu_pen_r2", ModelPartBuilder.create().uv(0, 72).cuboid(-1.1F, -2.5F, -2.5F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData gu_pen_r3 = gu_pen.addChild("gu_pen_r3", ModelPartBuilder.create().uv(1, 12).cuboid(-3.0F, -2.5F, -2.5F, 3.0F, 3.0F, 4.99F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.3963F));

        ModelPartData gu_pen_r4 = gu_pen.addChild("gu_pen_r4", ModelPartBuilder.create().uv(2, 49).cuboid(0.0F, -2.5F, -2.5F, 3.0F, 3.0F, 4.99F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, -1.3963F));

        ModelPartData gu_pen_r5 = gu_pen.addChild("gu_pen_r5", ModelPartBuilder.create().uv(22, 25).cuboid(-1.0F, -2.5F, -2.5F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData gu_pen_r6 = gu_pen.addChild("gu_pen_r6", ModelPartBuilder.create().uv(55, 38).cuboid(-3.0F, -2.5F, -2.5F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

        ModelPartData left_leg = gu_pen.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.of(-5.5F, 1.8423F, 0.6936F, -0.3927F, 0.0F, 0.0F));

        ModelPartData left_leg_r1 = left_leg.addChild("left_leg_r1", ModelPartBuilder.create().uv(94, 0).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0568F, -1.5385F, 0.8727F, 0.0F, 0.0F));

        ModelPartData left_leg_r2 = left_leg.addChild("left_leg_r2", ModelPartBuilder.create().uv(250, 61).cuboid(0.0F, -7.0F, -4.4936F, 0.0F, 9.0F, 3.0F, new Dilation(0.0F))
                .uv(87, 0).cuboid(-0.5F, -7.0F, -1.4936F, 1.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 4.0F, 0.6545F, 0.0F, 0.0F));

        ModelPartData left_leg2 = left_leg.addChild("left_leg2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.1089F, 5.2816F));

        ModelPartData left_leg2_r1 = left_leg2.addChild("left_leg2_r1", ModelPartBuilder.create().uv(45, 12).cuboid(-0.5F, -0.5F, -6.5F, 1.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.4453F, -3.5284F, 0.3927F, 0.0F, 0.0F));

        ModelPartData left_leg2_r2 = left_leg2.addChild("left_leg2_r2", ModelPartBuilder.create().uv(132, 8).cuboid(-0.4F, -0.5F, 1.0F, 0.8F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.3387F, -1.839F, 0.1745F, 0.0F, 0.0F));

        ModelPartData left_leg2_r3 = left_leg2.addChild("left_leg2_r3", ModelPartBuilder.create().uv(94, 13).cuboid(-0.5F, 1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.18F, -4.083F, 0.3491F, 0.0F, 0.0F));

        ModelPartData left_leg3 = left_leg2.addChild("left_leg3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 4.4135F, -9.633F, 0.3054F, 0.0F, 0.0F));

        ModelPartData left_leg3_r1 = left_leg3.addChild("left_leg3_r1", ModelPartBuilder.create().uv(122, 0).cuboid(-0.85F, -1.0F, -1.0F, 1.6F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.4881F, 0.0071F, 0.6981F, 0.0F, 0.0F));

        ModelPartData left_leg3_r2 = left_leg3.addChild("left_leg3_r2", ModelPartBuilder.create().uv(115, 18).cuboid(-0.4F, -6.0F, -0.5F, 0.8F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.4293F, -0.1462F, 0.2618F, 0.0F, 0.0F));

        ModelPartData left_leg3_r3 = left_leg3.addChild("left_leg3_r3", ModelPartBuilder.create().uv(132, 54).cuboid(-0.4F, -4.5F, -0.5F, 0.8F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0184F, -0.1859F, 0.0873F, 0.0F, 0.0F));

        ModelPartData left_leg3_r4 = left_leg3.addChild("left_leg3_r4", ModelPartBuilder.create().uv(117, 0).cuboid(-4.0F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 9.5184F, 0.3141F, 0.1309F, 0.0F, 0.0F));

        ModelPartData right_leg = gu_pen.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.of(5.5F, 1.8423F, 0.6936F, -0.3927F, 0.0F, 0.0F));

        ModelPartData right_leg_r1 = right_leg.addChild("right_leg_r1", ModelPartBuilder.create().uv(250, 61).cuboid(0.0F, -5.0F, -4.0F, 0.0F, 9.0F, 3.0F, new Dilation(0.0F))
                .uv(78, 35).cuboid(-0.5F, -5.0F, -1.0F, 1.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.7138F, 2.3909F, 0.6545F, 0.0F, 0.0F));

        ModelPartData right_leg_r2 = right_leg.addChild("right_leg_r2", ModelPartBuilder.create().uv(72, 3).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.021F, -0.3895F, 0.8727F, 0.0F, 0.0F));

        ModelPartData right_leg2 = right_leg.addChild("right_leg2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.1089F, 5.2816F));

        ModelPartData right_leg2_r1 = right_leg2.addChild("right_leg2_r1", ModelPartBuilder.create().uv(102, 0).cuboid(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.5895F, -3.57F, 0.3491F, 0.0F, 0.0F));

        ModelPartData right_leg2_r2 = right_leg2.addChild("right_leg2_r2", ModelPartBuilder.create().uv(89, 33).cuboid(-0.5F, -0.8105F, -10.6566F, 1.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5242F, -0.4933F, 0.3927F, 0.0F, 0.0F));

        ModelPartData right_leg2_r3 = right_leg2.addChild("right_leg2_r3", ModelPartBuilder.create().uv(127, 10).cuboid(-0.4F, -0.5F, -1.0F, 0.8F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.9914F, 0.1305F, 0.1745F, 0.0F, 0.0F));

        ModelPartData right_leg3 = right_leg2.addChild("right_leg3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 4.544F, -10.6245F, 0.3054F, 0.0F, 0.0F));

        ModelPartData right_leg3_r1 = right_leg3.addChild("right_leg3_r1", ModelPartBuilder.create().uv(122, 0).cuboid(-0.85F, -1.0F, -1.0F, 1.6F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.4881F, 0.0071F, 0.6981F, 0.0F, 0.0F));

        ModelPartData right_leg3_r2 = right_leg3.addChild("right_leg3_r2", ModelPartBuilder.create().uv(128, 16).cuboid(-0.4F, -6.0F, -0.5F, 0.8F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.4293F, -0.1462F, 0.2618F, 0.0F, 0.0F));

        ModelPartData right_leg3_r3 = right_leg3.addChild("right_leg3_r3", ModelPartBuilder.create().uv(114, 40).cuboid(-0.4F, -4.5F, -0.5F, 0.8F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0184F, -0.1859F, 0.0873F, 0.0F, 0.0F));

        ModelPartData right_leg3_r4 = right_leg3.addChild("right_leg3_r4", ModelPartBuilder.create().uv(124, 39).cuboid(-4.0F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 9.5184F, 0.3141F, 0.1309F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(DoubtEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
