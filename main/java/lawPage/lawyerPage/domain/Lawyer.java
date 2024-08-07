package lawPage.lawyerPage.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Lawyer {
    @Id
    @GeneratedValue
    @Column(name = "lawyer_id")
    private Long id;
    private String name;
    private String businessRegistrationNumber; //사업자 등록 번호

    @Embedded
    private Address address; //물리적 주소
    private ContactInfo contactInfo; //연락 수단

    @Builder
    public Lawyer(Long id, String name, String businessRegistrationNumber, Address address, ContactInfo contactInfo){
        this.id = id;
        this.name = name;
        this.businessRegistrationNumber = businessRegistrationNumber;
        this.address = address;
        this.contactInfo = contactInfo;
    }
}

