package lawyer.sslaw.domain.law;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lawyer.sslaw.domain.Address;
import lawyer.sslaw.domain.ContactInfo;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class SLawyer extends Law{
    private String author;
    private String isbn;
}
