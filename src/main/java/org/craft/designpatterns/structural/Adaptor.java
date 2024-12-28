package org.craft.designpatterns.structural;

/**
 * The Adapter pattern lets you to adapt what an object or a class exposes to what another object or class expects.
 * It converts the interface of a class into another interface the client expects.
 */
public class Adaptor implements PayD {
    private String custCardNo;
    private String cardOwnerName;
    private String cardExpMonthDate;
    private Integer cVVNo;
    private Double totalAmount;

    private Xpay adapted;

    Adaptor( Xpay adapted){
        this.adapted = adapted;
        initialise();
    }

    @Override
    public String getCustCardNo() {
        return custCardNo;
    }
    @Override
    public String getCardOwnerName() {
        return cardOwnerName;
    }
    @Override
    public String getCardExpMonthDate() {
        return cardExpMonthDate;
    }
    @Override
    public Integer getCVVNo() {
        return cVVNo;
    }
    @Override
    public Double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public void setCustCardNo(String custCardNo) {
        this.custCardNo = custCardNo;
    }
    @Override
    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    @Override
    public void setCardExpMonthDate(String cardExpMonthDate) {
        this.cardExpMonthDate = cardExpMonthDate;
    }
    @Override
    public void setCVVNo(Integer cVVNo) {
        this.cVVNo = cVVNo;
    }
    @Override
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private void initialise(){
        this.setCardExpMonthDate(adapted.getCardExpMonth());
        this.setCardOwnerName(adapted.getCustomerName());
        this.setCVVNo(Integer.valueOf(adapted.getCardCVVNo()));
        this.setTotalAmount(adapted.getAmount());
        this.setCustCardNo(this.getCustCardNo());
    }
}

interface Xpay{

    public String getCreditCardNo();
    public String getCustomerName();
    public String getCardExpMonth();
    public String getCardExpYear();
    public Short getCardCVVNo();
    public Double getAmount();

    //setters(mutators)
    public void setCreditCardNo(String creditCardNo);
    public void setCustomerName(String customerName);
    public void setCardExpMonth(String cardExpMonth);
    public void setCardExpYear(String cardExpYear);
    public void setCardCVVNo(Short cardCVVNo);
    public void setAmount(Double amount);
}

interface PayD{
    public String getCustCardNo();
    public String getCardOwnerName();
    public String getCardExpMonthDate();
    public Integer getCVVNo();
    public Double getTotalAmount();

    //setters(mutators)
    public void setCustCardNo(String custCardNo);
    public void setCardOwnerName(String cardOwnerName);
    public void setCardExpMonthDate(String cardExpMonthDate);
    public void setCVVNo(Integer cVVNo);
    public void setTotalAmount(Double totalAmount);
}

class XpayImpl implements Xpay {
    private String creditCardNo;
    private String customerName;
    private String cardExpMonth;
    private String cardExpYear;
    private Short cardCVVNo;
    private Double amount;


    @Override
    public String getCreditCardNo() {
        return  creditCardNo;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String getCardExpMonth() {
        return cardExpMonth;
    }

    @Override
    public String getCardExpYear() {
        return cardExpYear;
    }

    @Override
    public Short getCardCVVNo() {
        return cardCVVNo;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void setCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }

    @Override
    public void setCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
    }

    @Override
    public void setCardCVVNo(Short cardCVVNo) {
        this.cardCVVNo = cardCVVNo;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}