package com.xworkz.conditioner.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "conditioner_info")
@NoArgsConstructor
@NamedQuery(name = "updateNetQuantityByBrand",query = "update ConditionerEntity a set a.numberOfItems=:b where a.brand=:c")
@NamedQuery(name = "updateRecommendedForByBrand",query = "update ConditionerEntity d set d.rcmdUseforPro=:e where d.brand=:f")
@NamedQuery(name = "findAllByBrand",query = "select g from ConditionerEntity g where g.brand=:h")
@NamedQuery(name = "findAllByHairType",query = "select i from ConditionerEntity i where i.hairType=:j")
@NamedQuery(name = "findScentById",query = "select k.scent from ConditionerEntity k where k.id=:l")
@NamedQuery(name = "getAllSize",query = "select m.netQuantity from ConditionerEntity m  ")
@NamedQuery(name = "getAllBrand",query = "select i.brand from ConditionerEntity i")
public class ConditionerEntity {
    //    C_id, C_Brand, Item_Form, Material_feature, Hair_Type, Product_benefts, Age_Range,
//    RecommendedUsesForProduct, NetQuantity, NumberofItems, Scent

    @Id
    @Column(name = "C_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "C_Brand")
    @NotNull
    private String brand;

    @Column(name = "Item_Form")
    @NotNull
    private String itemform;

    @Column(name = "Material_feature")
    @NotNull
    private String materialFeature;

    @Column(name = "Hair_Type")
    @NotNull
    private String hairType;

    @Column(name = "Product_benefts")
    @NotNull
    private String productBenefits;

    @Column(name = "Age_Range")
    @NotNull
    private String ageRange;

    @Column(name = "RecommendedUsesForProduct")
    @NotNull
    private String rcmdUseforPro;

    @Column(name = "NetQuantity")
    @NotNull
    private String netQuantity;

    @Column(name = "NumberofItems")
    @NotNull
    private int numberOfItems;

    @Column(name = "Scent")
    @NotNull
    private String scent;

    @Override
    public String toString() {
        return "Conditioner -" +
                "\n---------------------"+
                "\nId :" + id +
                "\nBrand :" + brand +
                "\nItem Form :" + itemform +
                "\nMaterial Feature :" + materialFeature +
                "\nHair Type :" + hairType +
                "\nProduct Benefits :" + productBenefits +
                "\nAge Range :" + ageRange +
                "\nRecommended Uses For Product :" + rcmdUseforPro +
                "\nNet Quantity :" + netQuantity +
                "\nNumber Of Items  :" + numberOfItems +
                "\nScent :" + scent ;
    }
}
