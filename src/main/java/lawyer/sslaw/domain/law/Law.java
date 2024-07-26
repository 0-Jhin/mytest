package lawyer.sslaw.domain.law;

import jakarta.persistence.*;
import lawyer.sslaw.domain.Address;
import lawyer.sslaw.domain.ContactInfo;
import lawyer.sslaw.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Law {
    @Id
    @GeneratedValue
    @Column(name = "law_id")
    private Long id;
    private String name;
    private int stockQuantity;
    private String businessRegistrationNumber; //사업자 등록 번호

    @Embedded
    private Address address; //물리적 주소
    private ContactInfo contactInfo; //연락 수단

    //==비즈니스 로직==//
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}