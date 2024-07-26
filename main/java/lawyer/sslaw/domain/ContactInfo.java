package lawyer.sslaw.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ContactInfo {
    private String phoneNumber;//핸드폰 번호
    private String faxNumber;//팩스 번호
    private String emailAddress;//이메일 주소
    protected ContactInfo() {
    }
    public ContactInfo(String phoneNumber, String faxNumber, String emailAddress) {
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
    }
}
