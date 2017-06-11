package member.profile;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by saikatgupta on 5/20/17.
 */
@Entity(name = "User_Registration")

public class User implements Serializable {
    private String userName;
    private String companyName;
    private String residentialAddress;
    private String mobileNumber;

    private String userId;
    private String emailId;
    private String webSiteAdress;
    private int pinNumber;
    private String landLine;
    private String panCardNo;
    private String declarationMsg;
    private String paymentMode;
    private String paymentAmountInWords;
    private Integer payAmount;
    private String bloodGroup;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWebSiteAdress() {
        return webSiteAdress;
    }

    public void setWebSiteAdress(String webSiteAdress) {
        this.webSiteAdress = webSiteAdress;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getPanCardNo() {
        return panCardNo;
    }

    public void setPanCardNo(String panCardNo) {
        this.panCardNo = panCardNo;
    }

    public String getDeclarationMsg() {
        return declarationMsg;
    }

    public void setDeclarationMsg(String declarationMsg) {
        this.declarationMsg = declarationMsg;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentAmountInWords() {
        return paymentAmountInWords;
    }

    public void setPaymentAmountInWords(String paymentAmountInWords) {
        this.paymentAmountInWords = paymentAmountInWords;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    @Id
    @GenericGenerator(name = "seq_id", strategy = "member.util.BVSUserIdGenerator")
    @GeneratedValue(generator = "seq_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.userId.hashCode();
        hash += 67 * hash + this.userName.hashCode();
        hash += 67 * hash + this.emailId.hashCode();
        hash += 67 * hash + this.residentialAddress.hashCode();
        hash += 67 * hash + this.landLine.hashCode();
        hash += 67 * hash + this.mobileNumber.hashCode();
        hash += 67 * hash + this.bloodGroup.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        final User other = (User) o;
        if (!this.userName.equals(other.userName)) {
            return false;
        }
        if (!this.mobileNumber.equals(other.mobileNumber)) {
            return false;
        }
        if (!this.landLine.equals(other.landLine)) {
            return false;
        }
        if (!this.emailId.equals(other.emailId)) {
            return false;
        }
        if (!this.residentialAddress.equals(other.residentialAddress)) {
            return false;
        }
        if (!this.bloodGroup.equals(other.bloodGroup)) {
            return false;
        }
        return this.userId.equals(other.userId);
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
}
