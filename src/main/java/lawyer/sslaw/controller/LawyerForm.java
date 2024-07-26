package lawyer.sslaw.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LawyerForm {
    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;
    private String businessRegistrationNumber;
    private String officeName;
    private String officeAddress;
    private String phoneNumber;
    private String faxNumber;
    private String emailAddress;

}
