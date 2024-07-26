package lawyer.sslaw.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Lawyer {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id; //변호사 식별번호
    private String name; //이름
    private String businessRegistrationNumber; //사업자 등록 번호

    @Embedded
    private Address address; //물리적 주소
    private ContactInfo contactInfo; //연락 수단

//    @OneToMany(mappedBy = "member")
//    private List<Profile> profiles = new ArrayList<>(); //약력
//    private List<Certificate> certificates = new ArrayList<>(); //자격증
}
