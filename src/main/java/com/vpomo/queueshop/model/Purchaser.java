package com.vpomo.queueshop.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple model purchaser
 *
 * @author Pomogalov Vladimir
 */
@Entity
@Table(name = "purchaser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchaser.findAll", query = "SELECT p FROM Purchaser p"),
    @NamedQuery(name = "Purchaser.findById", query = "SELECT p FROM Purchaser p WHERE p.id = :id"),
    @NamedQuery(name = "Purchaser.findByTypePurchaser", query = "SELECT p FROM Purchaser p WHERE p.typePurchaser = :typePurchaser"),
    @NamedQuery(name = "Purchaser.findByCashBox", query = "SELECT p FROM Purchaser p WHERE p.cashBox = :cashBox"),
    @NamedQuery(name = "Purchaser.findByQuantityGoods", query = "SELECT p FROM Purchaser p WHERE p.quantityGoods = :quantityGoods"),
    @NamedQuery(name = "Purchaser.findByWaitCashbox", query = "SELECT p FROM Purchaser p WHERE p.waitCashbox = :waitCashbox"),
    @NamedQuery(name = "Purchaser.findByStep1", query = "SELECT p FROM Purchaser p WHERE p.step1 = :step1"),
    @NamedQuery(name = "Purchaser.findByStep2", query = "SELECT p FROM Purchaser p WHERE p.step2 = :step2"),
    @NamedQuery(name = "Purchaser.findByStep3", query = "SELECT p FROM Purchaser p WHERE p.step3 = :step3"),
    @NamedQuery(name = "Purchaser.findByStep4", query = "SELECT p FROM Purchaser p WHERE p.step4 = :step4"),
    @NamedQuery(name = "Purchaser.findByStep5", query = "SELECT p FROM Purchaser p WHERE p.step5 = :step5"),
    @NamedQuery(name = "Purchaser.findByStep6", query = "SELECT p FROM Purchaser p WHERE p.step6 = :step6"),
    @NamedQuery(name = "Purchaser.findByStep7", query = "SELECT p FROM Purchaser p WHERE p.step7 = :step7"),
    @NamedQuery(name = "Purchaser.findByStep8", query = "SELECT p FROM Purchaser p WHERE p.step8 = :step8"),
    @NamedQuery(name = "Purchaser.findByStep9", query = "SELECT p FROM Purchaser p WHERE p.step9 = :step9"),
    @NamedQuery(name = "Purchaser.findByStep10", query = "SELECT p FROM Purchaser p WHERE p.step10 = :step10")})
public class Purchaser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    private int typePurchaser;
    @Basic(optional = false)
    @NotNull
    private int cashBox;
    @Basic(optional = false)
    @NotNull
    private int quantityGoods;
    @Basic(optional = false)
    @NotNull
    private int waitCashbox;
    @Basic(optional = false)
    @NotNull
    private int step1;
    @Basic(optional = false)
    @NotNull
    private int step2;
    @Basic(optional = false)
    @NotNull
    private int step3;
    @Basic(optional = false)
    @NotNull
    private int step4;
    @Basic(optional = false)
    @NotNull
    private int step5;
    @Basic(optional = false)
    @NotNull
    private int step6;
    @Basic(optional = false)
    @NotNull
    private int step7;
    @Basic(optional = false)
    @NotNull
    private int step8;
    @Basic(optional = false)
    @NotNull
    private int step9;
    @Basic(optional = false)
    @NotNull
    private int step10;
    @Basic(optional = false)
    @NotNull
    private int step11;
    @Basic(optional = false)
    @NotNull
    private int step12;
    @Basic(optional = false)
    @NotNull
    private int step13;
    @Basic(optional = false)
    @NotNull
    private int step14;
    @Basic(optional = false)
    @NotNull
    private int step15;
    @Basic(optional = false)
    @NotNull
    private int step16;
    @Basic(optional = false)
    @NotNull
    private int step17;
    @Basic(optional = false)
    @NotNull
    private int step18;
    @Basic(optional = false)
    @NotNull
    private int step19;
    @Basic(optional = false)
    @NotNull
    private int step20;
    @Basic(optional = false)
    @NotNull
    private int step21;
    @Basic(optional = false)
    @NotNull
    private int step22;
    @Basic(optional = false)
    @NotNull
    private int step23;
    @Basic(optional = false)
    @NotNull
    private int step24;
    @Basic(optional = false)
    @NotNull
    private int step25;
    @Basic(optional = false)
    @NotNull
    private int step26;
    @Basic(optional = false)
    @NotNull
    private int step27;
    @Basic(optional = false)
    @NotNull
    private int step28;
    @Basic(optional = false)
    @NotNull
    private int step29;
    @Basic(optional = false)
    @NotNull
    private int step30;

    public Purchaser() {
    }

    public Purchaser(Integer id) {
        this.id = id;
    }

    public Purchaser(Integer id, int typePurchaser, int cashBox, int quantityGoods, int waitCashbox, int step1, int step2, int step3, int step4, int step5, int step6, int step7, int step8, int step9, int step10) {
        this.id = id;
        this.typePurchaser = typePurchaser;
        this.cashBox = cashBox;
        this.quantityGoods = quantityGoods;
        this.waitCashbox = waitCashbox;
        this.step1 = step1;
        this.step2 = step2;
        this.step3 = step3;
        this.step4 = step4;
        this.step5 = step5;
        this.step6 = step6;
        this.step7 = step7;
        this.step8 = step8;
        this.step9 = step9;
        this.step10 = step10;
        this.step11 = step1;
        this.step12 = step2;
        this.step13 = step3;
        this.step14 = step4;
        this.step15 = step5;
        this.step16 = step6;
        this.step17 = step7;
        this.step18 = step8;
        this.step19 = step9;
        this.step20 = step10;
        this.step21 = step1;
        this.step22 = step2;
        this.step23 = step3;
        this.step24 = step4;
        this.step25 = step5;
        this.step26 = step6;
        this.step27 = step7;
        this.step28 = step8;
        this.step29 = step9;
        this.step30 = step10;
    }
    public Purchaser(int typePurchaser, int cashBox, int quantityGoods, int waitCashbox) {
        this.typePurchaser = typePurchaser;
        this.cashBox = cashBox;
        this.quantityGoods = quantityGoods;
        this.waitCashbox = waitCashbox;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTypePurchaser() {
        return typePurchaser;
    }

    public void setTypePurchaser(int typePurchaser) {
        this.typePurchaser = typePurchaser;
    }

    public int getCashBox() {
        return cashBox;
    }

    public void setCashBox(int cashBox) {
        this.cashBox = cashBox;
    }

    public int getQuantityGoods() {
        return quantityGoods;
    }

    public void setQuantityGoods(int quantityGoods) {
        this.quantityGoods = quantityGoods;
    }

    public int getWaitCashbox() {
        return waitCashbox;
    }

    public void setWaitCashbox(int waitCashbox) {
        this.waitCashbox = waitCashbox;
    }

    public int getStep1() {
        return step1;
    }

    public void setStep1(int step1) {
        this.step1 = step1;
    }

    public int getStep2() {
        return step2;
    }

    public void setStep2(int step2) {
        this.step2 = step2;
    }

    public int getStep3() {
        return step3;
    }

    public void setStep3(int step3) {
        this.step3 = step3;
    }

    public int getStep4() {
        return step4;
    }

    public void setStep4(int step4) {
        this.step4 = step4;
    }

    public int getStep5() {
        return step5;
    }

    public void setStep5(int step5) {
        this.step5 = step5;
    }

    public int getStep6() {
        return step6;
    }

    public void setStep6(int step6) {
        this.step6 = step6;
    }

    public int getStep7() {
        return step7;
    }

    public void setStep7(int step7) {
        this.step7 = step7;
    }

    public int getStep8() {
        return step8;
    }

    public void setStep8(int step8) {
        this.step8 = step8;
    }

    public int getStep9() {
        return step9;
    }

    public void setStep9(int step9) {
        this.step9 = step9;
    }

    public int getStep10() {
        return step10;
    }

    public void setStep10(int step10) {
        this.step10 = step10;
    }


    public int getStep11() {
        return step11;
    }

    public void setStep11(int step11) {
        this.step11 = step11;
    }

    public int getStep12() {
        return step12;
    }

    public void setStep12(int step12) {
        this.step12 = step12;
    }

    public int getStep13() {
        return step13;
    }

    public void setStep13(int step13) {
        this.step13 = step13;
    }

    public int getStep14() {
        return step14;
    }

    public void setStep14(int step14) {
        this.step14 = step14;
    }

    public int getStep15() {
        return step15;
    }

    public void setStep15(int step15) {
        this.step15 = step15;
    }

    public int getStep16() {
        return step16;
    }

    public void setStep16(int step16) {
        this.step16 = step16;
    }

    public int getStep17() {
        return step17;
    }

    public void setStep17(int step17) {
        this.step17 = step17;
    }

    public int getStep18() {
        return step18;
    }

    public void setStep18(int step18) {
        this.step18 = step18;
    }

    public int getStep19() {
        return step19;
    }

    public void setStep19(int step19) {
        this.step19 = step19;
    }

    public int getStep20() {
        return step20;
    }

    public void setStep20(int step20) {
        this.step20 = step20;
    }

    public int getStep21() {
        return step21;
    }

    public void setStep21(int step21) {
        this.step21 = step21;
    }

    public int getStep22() {
        return step22;
    }

    public void setStep22(int step22) {
        this.step22 = step22;
    }

    public int getStep23() {
        return step23;
    }

    public void setStep23(int step23) {
        this.step23 = step23;
    }

    public int getStep24() {
        return step24;
    }

    public void setStep24(int step24) {
        this.step24 = step24;
    }

    public int getStep25() {
        return step25;
    }

    public void setStep25(int step25) {
        this.step25 = step25;
    }

    public int getStep26() {
        return step26;
    }

    public void setStep26(int step26) {
        this.step26 = step26;
    }

    public int getStep27() {
        return step27;
    }

    public void setStep27(int step27) {
        this.step27 = step27;
    }

    public int getStep28() {
        return step28;
    }

    public void setStep28(int step28) {
        this.step28 = step28;
    }

    public int getStep29() {
        return step29;
    }

    public void setStep29(int step29) {
        this.step29 = step29;
    }

    public int getStep30() {
        return step30;
    }

    public void setStep30(int step30) {
        this.step30 = step30;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchaser)) {
            return false;
        }
        Purchaser other = (Purchaser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vpomo.queueshop.Model.Entity.Purchaser[ id=" + id + " ]";
    }
    
}
