package lawPage.lawyerPage.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {
    private String officeName;//사무실 이름
    private String officeAddress;//사무실 주소
    protected Address() {
    }
    public Address(String officeName, String officeAddress) {
        this.officeName = officeName;
        this.officeAddress = officeAddress;
    }
}