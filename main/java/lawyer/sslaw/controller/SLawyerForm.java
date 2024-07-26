package lawyer.sslaw.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SLawyerForm {
    private Long id;
    private String name;
    private String businessRegistrationNumber;
    private String officeName;
    private String officeAddress;
    private String phoneNumber;
    private String faxNumber;
    private String emailAddress;
    private int stockQuantity;
    private String author;
    private String isbn;
}