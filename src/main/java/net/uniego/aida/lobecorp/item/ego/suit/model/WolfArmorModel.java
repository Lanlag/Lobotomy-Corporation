package net.uniego.aida.lobecorp.item.ego.suit.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class WolfArmorModel extends BipedEntityModel<AbstractClientPlayerEntity> {
    private final ModelPart head;
    private final ModelPart bone3;
    private final ModelPart bone4;
    private final ModelPart bone5;
    private final ModelPart bone9;
    private final ModelPart bone10;
    private final ModelPart bone11;
    private final ModelPart bone12;
    private final ModelPart bone6;
    private final ModelPart bone14;
    private final ModelPart bone13;
    private final ModelPart bone15;
    private final ModelPart bone16;
    private final ModelPart bone28;
    private final ModelPart bone8;
    private final ModelPart bone7;
    private final ModelPart body;
    private final ModelPart bone46;
    private final ModelPart bone47;
    private final ModelPart bone36;
    private final ModelPart bone38;
    private final ModelPart bone18;
    private final ModelPart bone26;
    private final ModelPart left_leg;
    private final ModelPart bone19;
    private final ModelPart bone20;
    private final ModelPart bone21;
    private final ModelPart bone27;
    private final ModelPart bone31;
    private final ModelPart bone33;
    private final ModelPart bone34;
    private final ModelPart right_leg;
    private final ModelPart bone57;
    private final ModelPart bone58;
    private final ModelPart bone59;
    private final ModelPart bone60;
    private final ModelPart bone61;
    private final ModelPart bone63;
    private final ModelPart bone64;
    private final ModelPart right_arm;
    private final ModelPart bone77;
    private final ModelPart bone78;
    private final ModelPart bone79;
    private final ModelPart bone80;
    private final ModelPart bone81;
    private final ModelPart bone82;
    private final ModelPart bone83;
    private final ModelPart bone84;
    private final ModelPart bone85;
    private final ModelPart left_arm;
    private final ModelPart bone67;
    private final ModelPart bone68;
    private final ModelPart bone69;
    private final ModelPart bone70;
    private final ModelPart bone71;
    private final ModelPart bone72;
    private final ModelPart bone73;
    private final ModelPart bone74;
    private final ModelPart bone75;
    private final ModelPart hat;

    public WolfArmorModel(ModelPart root) {
        super(root);
        //
        this.head = root.getChild("head");
        this.bone3 = this.head.getChild("bone3");
        this.bone4 = this.bone3.getChild("bone4");
        this.bone5 = this.bone4.getChild("bone5");
        this.bone9 = this.head.getChild("bone9");
        this.bone10 = this.bone9.getChild("bone10");
        this.bone11 = this.bone10.getChild("bone11");
        this.bone12 = this.head.getChild("bone12");
        this.bone6 = this.head.getChild("bone6");
        this.bone14 = this.head.getChild("bone14");
        this.bone13 = this.bone14.getChild("bone13");
        this.bone15 = this.bone13.getChild("bone15");
        this.bone16 = this.bone15.getChild("bone16");
        this.bone28 = this.bone16.getChild("bone28");
        this.bone8 = this.head.getChild("bone8");
        this.bone7 = this.head.getChild("bone7");
        //
        this.body = root.getChild("body");
        this.bone46 = this.body.getChild("bone46");
        this.bone47 = this.bone46.getChild("bone47");
        this.bone36 = this.body.getChild("bone36");
        this.bone38 = this.bone36.getChild("bone38");
        this.bone18 = this.bone38.getChild("bone18");
        this.bone26 = this.body.getChild("bone26");
        //
        this.left_leg = root.getChild("left_leg");
        this.bone19 = this.left_leg.getChild("bone19");
        this.bone20 = this.bone19.getChild("bone20");
        this.bone21 = this.bone20.getChild("bone21");
        this.bone27 = this.left_leg.getChild("bone27");
        this.bone31 = this.left_leg.getChild("bone31");
        this.bone33 = this.left_leg.getChild("bone33");
        this.bone34 = this.bone33.getChild("bone34");
        this.right_leg = root.getChild("right_leg");
        this.bone57 = this.right_leg.getChild("bone57");
        this.bone58 = this.bone57.getChild("bone58");
        this.bone59 = this.bone58.getChild("bone59");
        this.bone60 = this.right_leg.getChild("bone60");
        this.bone61 = this.right_leg.getChild("bone61");
        this.bone63 = this.right_leg.getChild("bone63");
        this.bone64 = this.bone63.getChild("bone64");
        //
        this.right_arm = root.getChild("right_arm");
        this.bone77 = this.right_arm.getChild("bone77");
        this.bone78 = this.right_arm.getChild("bone78");
        this.bone79 = this.right_arm.getChild("bone79");
        this.bone80 = this.right_arm.getChild("bone80");
        this.bone81 = this.bone80.getChild("bone81");
        this.bone82 = this.bone80.getChild("bone82");
        this.bone83 = this.bone82.getChild("bone83");
        this.bone84 = this.bone83.getChild("bone84");
        this.bone85 = this.right_arm.getChild("bone85");
        this.left_arm = root.getChild("left_arm");
        this.bone67 = this.left_arm.getChild("bone67");
        this.bone68 = this.left_arm.getChild("bone68");
        this.bone69 = this.left_arm.getChild("bone69");
        this.bone70 = this.left_arm.getChild("bone70");
        this.bone71 = this.bone70.getChild("bone71");
        this.bone72 = this.bone70.getChild("bone72");
        this.bone73 = this.bone72.getChild("bone73");
        this.bone74 = this.bone73.getChild("bone74");
        this.bone75 = this.left_arm.getChild("bone75");
        //
        this.hat = root.getChild("hat");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        //
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create()
                .uv(0, 55).cuboid(-5.0F, -9.7544F, -5.9209F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(39, 25).cuboid(4.0F, -9.7544F, -5.9209F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(15, 46).cuboid(-5.0F, -10.3544F, -4.9209F, 1.0F, 7.0F, 9.0F, new Dilation(0.0F))
                .uv(86, 86).cuboid(3.9F, -3.4239F, -1.527F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(85, 20).cuboid(-4.9F, -3.4239F, -1.527F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(61, 46).cuboid(-4.0F, -10.3544F, 3.0791F, 8.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 17).cuboid(-4.5F, -11.3544F, -3.9209F, 9.0F, 2.0F, 7.0F, new Dilation(0.0F))
                .uv(77, 16).cuboid(-4.0F, -10.7544F, -5.9209F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(44, 32).cuboid(-4.0F, -10.9544F, 3.0791F, 8.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(77, 8).cuboid(-4.0F, -9.7544F, -6.9209F, 8.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(50, 50).cuboid(4.0F, -10.3544F, -4.9209F, 1.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        ModelPartData bone3 = head.addChild("bone3", ModelPartBuilder.create().uv(35, 71).cuboid(-2.517F, -2.636F, 1.8477F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.4F, -10.5544F, -2.3209F, -0.2959F, 0.4953F, -0.2987F));

        ModelPartData bone4 = bone3.addChild("bone4", ModelPartBuilder.create().uv(80, 97).cuboid(-1.0347F, -0.5672F, 0.9999F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.017F, -3.3706F, 0.5F, 0.3054F, 0.0F, 0.0F));

        ModelPartData bone5 = bone4.addChild("bone5", ModelPartBuilder.create().uv(45, 22).cuboid(-2.0518F, -2.5892F, 1.4998F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5088F, 1.5074F, -0.2615F, 0.1745F, 0.0F, 0.0F));

        ModelPartData bone9 = head.addChild("bone9", ModelPartBuilder.create().uv(50, 0).cuboid(-1.483F, -2.636F, 1.8477F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.4F, -10.5544F, -2.3209F, -0.2959F, -0.4953F, 0.2987F));

        ModelPartData bone10 = bone9.addChild("bone10", ModelPartBuilder.create().uv(91, 34).cuboid(-1.9653F, -0.5672F, 0.9999F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.017F, -3.3706F, 0.5F, 0.3054F, 0.0F, 0.0F));

        ModelPartData bone11 = bone10.addChild("bone11", ModelPartBuilder.create().uv(18, 30).cuboid(0.0518F, -2.5892F, 1.4998F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5088F, 1.5074F, -0.2615F, 0.1745F, 0.0F, 0.0F));

        ModelPartData bone12 = head.addChild("bone12", ModelPartBuilder.create().uv(17, 42).cuboid(-1.8422F, 3.4654F, -1.2429F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(49, 77).cuboid(-1.5F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(99, 11).cuboid(-0.7929F, -1.5168F, 0.4373F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(5.5F, -6.8544F, -0.4209F, 0.2618F, 0.2182F, 0.0F));

        ModelPartData bone6 = head.addChild("bone6", ModelPartBuilder.create().uv(17, 42).mirrored().cuboid(-0.1578F, 3.4654F, -1.2429F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(49, 77).mirrored().cuboid(-0.5F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(99, 11).mirrored().cuboid(-1.2071F, -1.5168F, 0.4373F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.5F, -6.8544F, -0.4209F, 0.2618F, -0.2182F, 0.0F));

        ModelPartData bone14 = head.addChild("bone14", ModelPartBuilder.create().uv(16, 79).cuboid(-3.0F, -0.8847F, -1.7457F, 6.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.7666F, 4.5652F, 0.2182F, 0.0F, 0.0F));

        ModelPartData bone13 = bone14.addChild("bone13", ModelPartBuilder.create().uv(97, 5).cuboid(-7.0F, -3.0911F, -3.0419F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 8.1153F, 1.2543F, -0.2705F, 0.0F, 0.0F));

        ModelPartData bone15 = bone13.addChild("bone15", ModelPartBuilder.create().uv(91, 0).cuboid(-3.0F, -2.0F, -1.0F, 6.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 1.7208F, -1.3921F, 0.2618F, 0.0F, 0.0F));

        ModelPartData bone16 = bone15.addChild("bone16", ModelPartBuilder.create().uv(25, 19).cuboid(-7.0F, -6.054F, -2.5249F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 6.4712F, 2.1741F, 0.1134F, 0.0F, 0.0F));

        ModelPartData bone28 = bone16.addChild("bone28", ModelPartBuilder.create().uv(24, 23).cuboid(-1.0F, -2.4945F, -1.1045F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -1.8745F, -1.9128F, -0.1745F, 0.0F, 0.0F));

        ModelPartData bone8 = head.addChild("bone8", ModelPartBuilder.create().uv(65, 65).cuboid(-3.0F, -1.2098F, -4.2795F, 6.0F, 3.0F, 5.0F, new Dilation(0.0F))
                .uv(95, 59).cuboid(-2.5F, -1.2098F, -6.2795F, 5.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(45, 60).cuboid(-1.1F, 0.6665F, -5.8937F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(45, 57).cuboid(0.1F, 0.6665F, -5.8937F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(61, 18).cuboid(1.7F, 1.7032F, -4.0457F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(49, 57).cuboid(-2.7F, 1.7032F, -4.0457F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(59, 46).cuboid(1.7F, 1.5697F, -2.499F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 55).cuboid(-2.7F, 1.5697F, -2.499F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(53, 57).cuboid(1.7F, 1.5347F, -0.9697F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 55).cuboid(-2.7F, 1.5347F, -0.9697F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(45, 63).cuboid(1.3F, 1.2457F, -5.4882F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(54, 39).cuboid(-2.3F, 1.2457F, -5.4882F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(48, 103).cuboid(-1.5F, -1.4955F, -6.7158F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 105).cuboid(-1.0F, -1.843F, -6.9591F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.5544F, -5.9543F, 0.1745F, 0.0F, 0.0F));

        ModelPartData bone7 = head.addChild("bone7", ModelPartBuilder.create().uv(77, 77).cuboid(-2.0F, -0.8654F, -3.2997F, 4.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0544F, -7.3209F, 0.6807F, 0.0F, 0.0F));

        //
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bone46 = body.addChild("bone46", ModelPartBuilder.create(), ModelTransform.of(18.05F, 14.9667F, 1.4167F, 0.0F, 0.0F, -0.1745F));

        ModelPartData bone47 = bone46.addChild("bone47", ModelPartBuilder.create().uv(59, 32).cuboid(-3.4864F, -5.1835F, -1.5983F, 6.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(28, 0).cuboid(-4.4329F, -0.1835F, -4.0219F, 8.0F, 4.0F, 6.0F, new Dilation(0.0F))
                .uv(26, 44).cuboid(-1.4881F, -3.4835F, -1.1983F, 2.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-15.6919F, -12.4502F, -0.3948F, 0.0F, 0.0F, 0.1745F));

        ModelPartData bone36 = body.addChild("bone36", ModelPartBuilder.create(), ModelTransform.of(18.05F, 12.9667F, -1.4167F, 0.0F, 0.0F, -0.1745F));

        ModelPartData bone38 = bone36.addChild("bone38", ModelPartBuilder.create().uv(44, 19).cuboid(-5.8269F, -5.8835F, -2.4781F, 5.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(29, 60).mirrored().cuboid(-6.3345F, -6.3828F, -1.9781F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(29, 60).cuboid(0.4688F, -6.3828F, -1.9781F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 42).cuboid(-0.0389F, -5.8835F, -2.4781F, 5.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(97, 98).cuboid(4.0687F, -7.1828F, -0.4781F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(97, 98).mirrored().cuboid(-6.885F, -7.1828F, -0.4781F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(41, 85).cuboid(-1.4581F, -3.4835F, -2.8017F, 2.0F, 6.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-4.9329F, -5.0835F, -1.4781F, 9.0F, 12.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 42).cuboid(-1.4329F, 4.5165F, -2.2781F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(25, 11).cuboid(-5.4329F, 5.0165F, -1.9781F, 10.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-16.0392F, -10.4806F, 0.3948F, 0.0F, 0.0F, 0.1745F));

        ModelPartData bone18 = bone38.addChild("bone18", ModelPartBuilder.create().uv(0, 26).cuboid(-4.8717F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(1.4136F, -0.1835F, 0.5983F));

        ModelPartData bone26 = body.addChild("bone26", ModelPartBuilder.create().uv(0, 0).cuboid(-1.8534F, 0.0177F, -3.7111F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.6466F, 0.0177F, -3.0111F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.3097F, 1.6688F, -3.2111F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-0.714F, 3.7643F, -2.6111F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.1859F, 2.7687F, -2.5111F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-0.1141F, 4.7687F, -1.5111F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.8534F, 0.0177F, 2.6889F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-1.3097F, 1.6688F, 2.1889F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-0.714F, 3.7643F, 0.6889F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.9202F, 11.7705F, -0.0889F, 0.0F, 0.0F, -0.3054F));

        //
        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(0, 96).mirrored().cuboid(2.0F, 7.4F, -1.8F, 1.0F, 5.0F, 4.0F, new Dilation(0.2F)).mirrored(false)
                .uv(0, 96).cuboid(-2.8F, 7.3F, -1.8F, 1.0F, 5.0F, 4.0F, new Dilation(0.2F))
                .uv(94, 46).mirrored().cuboid(-1.9F, 9.0F, -3.9F, 4.0F, 2.0F, 3.0F, new Dilation(0.2F)).mirrored(false)
                .uv(91, 40).mirrored().cuboid(-1.4F, 9.4F, -5.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.2F)).mirrored(false)
                .uv(102, 51).mirrored().cuboid(-1.9F, 10.3F, -5.25F, 4.0F, 2.0F, 1.0F, new Dilation(0.2F)).mirrored(false)
                .uv(62, 88).mirrored().cuboid(-2.3F, 10.4F, -4.3F, 5.0F, 2.0F, 3.0F, new Dilation(0.2F)).mirrored(false)
                .uv(94, 85).mirrored().cuboid(-2.4F, 6.3F, -2.5F, 5.0F, 6.0F, 1.0F, new Dilation(0.2F)).mirrored(false)
                .uv(20, 62).mirrored().cuboid(-1.9F, 10.4F, 1.4F, 4.0F, 2.0F, 2.0F, new Dilation(0.2F)).mirrored(false)
                .uv(88, 94).mirrored().cuboid(-2.4F, 6.3F, 1.7F, 5.0F, 6.0F, 1.0F, new Dilation(0.2F)).mirrored(false)
                .uv(10, 79).mirrored().cuboid(-1.4F, 5.9F, -3.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.2F)).mirrored(false)
                .uv(0, 30).mirrored().cuboid(-0.9F, 8.1F, -2.8F, 2.0F, 1.0F, 1.0F, new Dilation(0.2F)).mirrored(false)
                .uv(83, 69).mirrored().cuboid(-1.9F, 9.5F, -1.8F, 4.0F, 3.0F, 4.0F, new Dilation(0.2F)).mirrored(false)
                .uv(18, 26).mirrored().cuboid(-1.4F, 8.3F, 1.2F, 3.0F, 2.0F, 2.0F, new Dilation(0.2F)).mirrored(false)
                .uv(24, 26).mirrored().cuboid(-2.4F, -0.5F, -2.5F, 5.0F, 13.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
                .uv(63, 73).cuboid(-2.4F, -0.4F, -2.5F, 5.0F, 3.0F, 5.0F, new Dilation(0.2F))
                .uv(10, 97).cuboid(2.1F, 2.7F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(10, 97).mirrored().cuboid(-2.9F, 2.7F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(27, 101).cuboid(2.0F, 1.7F, -1.5F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(27, 101).mirrored().cuboid(-2.8F, 1.7F, -1.5F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(75, 32).cuboid(-1.9F, 2.7F, -3.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(35, 57).cuboid(-1.9F, 2.7F, 2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(83, 20).cuboid(-1.4F, 1.7F, -2.9F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(71, 0).cuboid(-1.4F, 1.7F, 1.9F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, 12.0F, 0.0F));

        ModelPartData bone19 = left_leg.addChild("bone19", ModelPartBuilder.create().uv(90, 102).mirrored().cuboid(0.2984F, 0.2931F, -1.5F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.8F, 6.6F, 0.2F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone20 = bone19.addChild("bone20", ModelPartBuilder.create().uv(22, 66).mirrored().cuboid(-0.2259F, 1.082F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.2552F, -1.3317F, 0.0F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone21 = bone20.addChild("bone21", ModelPartBuilder.create().uv(54, 42).mirrored().cuboid(0.6258F, 0.15F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.3627F, -0.0434F, 0.0F, 0.0F, 0.0F, 0.9163F));

        ModelPartData bone27 = left_leg.addChild("bone27", ModelPartBuilder.create().uv(17, 46).mirrored().cuboid(-0.5F, -1.0341F, -0.9294F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, 9.4F, -3.8F, 1.0908F, 0.0F, 0.0F));

        ModelPartData bone31 = left_leg.addChild("bone31", ModelPartBuilder.create().uv(0, 26).mirrored().cuboid(-1.1F, -1.3693F, -0.5541F, 2.0F, 3.0F, 1.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(0.2F, 7.1F, 2.9F, -0.3927F, 0.0F, 0.0F));

        ModelPartData bone33 = left_leg.addChild("bone33", ModelPartBuilder.create().uv(63, 66).mirrored().cuboid(-1.0F, -0.8102F, -0.4737F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, 6.1F, -3.2F, 0.3927F, 0.0F, 0.0F));

        ModelPartData bone34 = bone33.addChild("bone34", ModelPartBuilder.create().uv(54, 35).mirrored().cuboid(-0.5F, 0.1083F, -0.4091F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -1.324F, -0.7538F, 0.6545F, 0.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0, 96).cuboid(-3.0F, 7.4F, -1.8F, 1.0F, 5.0F, 4.0F, new Dilation(0.2F))
                .uv(0, 96).mirrored().cuboid(1.8F, 7.3F, -1.8F, 1.0F, 5.0F, 4.0F, new Dilation(0.2F)).mirrored(false)
                .uv(94, 46).cuboid(-2.1F, 9.0F, -3.9F, 4.0F, 2.0F, 3.0F, new Dilation(0.2F))
                .uv(91, 40).cuboid(-1.6F, 9.4F, -5.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.2F))
                .uv(102, 51).cuboid(-2.1F, 10.3F, -5.25F, 4.0F, 2.0F, 1.0F, new Dilation(0.2F))
                .uv(62, 88).cuboid(-2.7F, 10.4F, -4.3F, 5.0F, 2.0F, 3.0F, new Dilation(0.2F))
                .uv(94, 85).cuboid(-2.6F, 6.3F, -2.5F, 5.0F, 6.0F, 1.0F, new Dilation(0.2F))
                .uv(20, 62).cuboid(-2.1F, 10.4F, 1.4F, 4.0F, 2.0F, 2.0F, new Dilation(0.2F))
                .uv(88, 94).cuboid(-2.6F, 6.3F, 1.7F, 5.0F, 6.0F, 1.0F, new Dilation(0.2F))
                .uv(10, 79).cuboid(-1.6F, 5.9F, -3.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.2F))
                .uv(0, 30).cuboid(-1.1F, 8.1F, -2.8F, 2.0F, 1.0F, 1.0F, new Dilation(0.2F))
                .uv(83, 69).cuboid(-2.1F, 9.5F, -1.8F, 4.0F, 3.0F, 4.0F, new Dilation(0.2F))
                .uv(18, 26).cuboid(-1.6F, 8.3F, 1.2F, 3.0F, 2.0F, 2.0F, new Dilation(0.2F))
                .uv(24, 26).cuboid(-2.6F, -0.5F, -2.5F, 5.0F, 13.0F, 5.0F, new Dilation(0.0F))
                .uv(63, 73).mirrored().cuboid(-2.6F, -0.4F, -2.5F, 5.0F, 3.0F, 5.0F, new Dilation(0.2F)).mirrored(false)
                .uv(10, 97).mirrored().cuboid(-3.1F, 2.7F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(10, 97).cuboid(1.9F, 2.7F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(27, 101).mirrored().cuboid(-3.0F, 1.7F, -1.5F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(27, 101).cuboid(1.8F, 1.7F, -1.5F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(75, 32).mirrored().cuboid(-2.1F, 2.7F, -3.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(35, 57).mirrored().cuboid(-2.1F, 2.7F, 2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(83, 20).mirrored().cuboid(-1.6F, 1.7F, -2.9F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(71, 0).mirrored().cuboid(-1.6F, 1.7F, 1.9F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        ModelPartData bone57 = right_leg.addChild("bone57", ModelPartBuilder.create().uv(90, 102).cuboid(-1.2984F, 0.2931F, -1.5F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.8F, 6.6F, 0.2F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone58 = bone57.addChild("bone58", ModelPartBuilder.create().uv(22, 66).cuboid(-0.7741F, 1.082F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.2552F, -1.3317F, 0.0F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone59 = bone58.addChild("bone59", ModelPartBuilder.create().uv(54, 42).cuboid(-1.6258F, 0.15F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.3627F, -0.0434F, 0.0F, 0.0F, 0.0F, -0.9163F));

        ModelPartData bone60 = right_leg.addChild("bone60", ModelPartBuilder.create().uv(17, 46).cuboid(-0.5F, -1.0341F, -0.9294F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, 9.4F, -3.8F, 1.0908F, 0.0F, 0.0F));

        ModelPartData bone61 = right_leg.addChild("bone61", ModelPartBuilder.create().uv(0, 26).cuboid(-0.9F, -1.3693F, -0.5541F, 2.0F, 3.0F, 1.0F, new Dilation(0.2F)), ModelTransform.of(-0.2F, 7.1F, 2.9F, -0.3927F, 0.0F, 0.0F));

        ModelPartData bone63 = right_leg.addChild("bone63", ModelPartBuilder.create().uv(63, 66).cuboid(-1.0F, -0.8102F, -0.4737F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, 6.1F, -3.2F, 0.3927F, 0.0F, 0.0F));

        ModelPartData bone64 = bone63.addChild("bone64", ModelPartBuilder.create().uv(54, 35).cuboid(-0.5F, 0.1083F, -0.4091F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.324F, -0.7538F, 0.6545F, 0.0F, 0.0F));

        //
        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        ModelPartData bone77 = right_arm.addChild("bone77", ModelPartBuilder.create().uv(97, 34).mirrored().cuboid(-0.5906F, -1.5423F, -1.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, 8.9F, 0.0F, 0.0F, 0.0F, -0.4363F));

        ModelPartData bone78 = right_arm.addChild("bone78", ModelPartBuilder.create().uv(8, 103).mirrored().cuboid(-0.907F, -0.4087F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.8F, 6.8F, 0.0F, 0.0F, 0.0F, -0.829F));

        ModelPartData bone79 = right_arm.addChild("bone79", ModelPartBuilder.create().uv(34, 44).mirrored().cuboid(-0.8396F, -0.203F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.3F, 5.1F, -0.5F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone80 = right_arm.addChild("bone80", ModelPartBuilder.create().uv(0, 57).mirrored().cuboid(-10.0F, -22.0F, -3.0F, 5.0F, 9.0F, 5.0F, new Dilation(-0.1F)).mirrored(false)
                .uv(20, 71).mirrored().cuboid(-10.0F, -14.0F, -3.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
                .uv(81, 48).mirrored().cuboid(-9.5F, -11.4F, -2.5F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                .uv(32, 19).mirrored().cuboid(-10.0F, -15.0F, -3.0F, 4.0F, 1.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
                .uv(29, 83).mirrored().cuboid(-10.0F, -16.0F, -3.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
                .uv(79, 32).mirrored().cuboid(-10.5F, -22.0F, -3.5F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 71).mirrored().cuboid(-10.0F, -24.0F, -3.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(6.5F, 21.7F, 0.5F));

        ModelPartData bone81 = bone80.addChild("bone81", ModelPartBuilder.create().uv(46, 68).mirrored().cuboid(-6.364F, 0.5336F, -2.5F, 6.0F, 2.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.9F, -18.6F, -0.5F, 0.0F, 0.0F, 0.2182F));

        ModelPartData bone82 = bone80.addChild("bone82", ModelPartBuilder.create().uv(95, 67).mirrored().cuboid(-4.1664F, -4.0992F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.5F, -22.8F, -0.5F, 0.0F, 0.0F, -0.6981F));

        ModelPartData bone83 = bone82.addChild("bone83", ModelPartBuilder.create().uv(6, 96).mirrored().cuboid(-0.9113F, -0.9538F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.6544F, -4.6426F, 0.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData bone84 = bone83.addChild("bone84", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-0.4009F, -0.987F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0445F, -1.6469F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData bone85 = right_arm.addChild("bone85", ModelPartBuilder.create().uv(74, 91).mirrored().cuboid(-6.8893F, -1.5652F, -2.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(4.1F, -2.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData bone67 = left_arm.addChild("bone67", ModelPartBuilder.create().uv(97, 34).cuboid(-1.4094F, -1.5423F, -1.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 8.9F, 0.0F, 0.0F, 0.0F, 0.4363F));

        ModelPartData bone68 = left_arm.addChild("bone68", ModelPartBuilder.create().uv(8, 103).cuboid(-1.093F, -0.4087F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.8F, 6.8F, 0.0F, 0.0F, 0.0F, 0.829F));

        ModelPartData bone69 = left_arm.addChild("bone69", ModelPartBuilder.create().uv(34, 44).cuboid(-0.1604F, -0.203F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.3F, 5.1F, -0.5F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone70 = left_arm.addChild("bone70", ModelPartBuilder.create().uv(0, 57).cuboid(5.0F, -22.0F, -3.0F, 5.0F, 9.0F, 5.0F, new Dilation(-0.1F))
                .uv(20, 71).cuboid(5.0F, -14.0F, -3.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F))
                .uv(81, 48).cuboid(5.5F, -11.4F, -2.5F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(32, 19).cuboid(6.0F, -15.0F, -3.0F, 4.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(29, 83).cuboid(7.0F, -16.0F, -3.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(79, 32).cuboid(7.5F, -22.0F, -3.5F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 71).cuboid(5.0F, -24.0F, -3.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.5F, 21.7F, 0.5F));

        ModelPartData bone71 = bone70.addChild("bone71", ModelPartBuilder.create().uv(46, 68).cuboid(0.364F, 0.5336F, -2.5F, 6.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(3.9F, -18.6F, -0.5F, 0.0F, 0.0F, -0.2182F));

        ModelPartData bone72 = bone70.addChild("bone72", ModelPartBuilder.create().uv(95, 67).cuboid(1.1664F, -4.0992F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(5.5F, -22.8F, -0.5F, 0.0F, 0.0F, 0.6981F));

        ModelPartData bone73 = bone72.addChild("bone73", ModelPartBuilder.create().uv(6, 96).cuboid(-1.0887F, -0.9538F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.6544F, -4.6426F, 0.0F, 0.0F, 0.0F, -0.2182F));

        ModelPartData bone74 = bone73.addChild("bone74", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5991F, -0.987F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0445F, -1.6469F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData bone75 = left_arm.addChild("bone75", ModelPartBuilder.create().uv(74, 91).cuboid(3.8893F, -1.5652F, -2.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.1F, -2.4F, 0.0F, 0.0F, 0.0F, 0.1745F));

        //
        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        hat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
