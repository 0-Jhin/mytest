package lawPage.lawyerPage.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LawyerForm {
    private Long id;
    private String name;
    private String businessRegistrationNumber;
    private String officeName;
    private String officeAddress;
    private String phoneNumber;
    private String faxNumber;
    private String emailAddress;

    @Builder
    public LawyerForm(Long id, String name, String businessRegistrationNumber,
                      String officeName, String officeAddress, String phoneNumber,
                      String faxNumber, String emailAddress){
        this.id = id;
        this.name = name;
        this.businessRegistrationNumber = businessRegistrationNumber;
        this.officeName = officeName;
        this.officeAddress = officeAddress;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
    }
}