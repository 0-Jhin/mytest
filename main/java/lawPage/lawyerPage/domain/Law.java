//package lawPage.lawyerPage.domain;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "dtype")
//@Getter
//@Setter
//public abstract class Law {
//    @Id
//    @GeneratedValue
//    @Column(name = "lawyer_id")
//    private Long id;
//    private String name;
//    private String businessRegistrationNumber; //사업자 등록 번호
//
//    @Embedded
//    private Address address; //물리적 주소
//    private ContactInfo contactInfo; //연락 수단
//
//}