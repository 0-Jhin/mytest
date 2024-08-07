package lawPage.lawyerPage.controller;

import jakarta.validation.Valid;
import lawPage.lawyerPage.domain.Address;
import lawPage.lawyerPage.domain.ContactInfo;
import lawPage.lawyerPage.domain.Lawyer;
import lawPage.lawyerPage.service.LawyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lawyers")
public class LawyerRestController2 {

    private final LawyerService lawyerService;

    // Create a new lawyer
    @PostMapping
    public ResponseEntity<Lawyer> createLawyer(@Valid @RequestBody LawyerForm form) {
        Address address = new Address(form.getOfficeName(), form.getOfficeAddress());
        ContactInfo contactInfo = new ContactInfo(form.getPhoneNumber(), form.getFaxNumber(), form.getEmailAddress());

        Lawyer lawyer = Lawyer.builder()
                .name(form.getName())
                .address(address)
                .contactInfo(contactInfo)
                .build();

        Lawyer savedLawyer = lawyerService.saveLawyer(lawyer);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedLawyer);
    }

    // List all lawyers
    @GetMapping
    public ResponseEntity<List<Lawyer>> listAllLawyers() {
        List<Lawyer> lawyers = lawyerService.findLawyers();
        return ResponseEntity.ok(lawyers);
    }

    // Get a specific lawyer
    @GetMapping("/{lawyerId}")
    public ResponseEntity<Lawyer> getLawyerById(@PathVariable Long lawyerId) {
        Lawyer lawyer = lawyerService.findOne(lawyerId);
        if (lawyer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(lawyer);
    }

    // Update a lawyer
    @PutMapping("/{lawyerId}")
    public ResponseEntity<Lawyer> updateLawyer(
            @PathVariable Long lawyerId,
            @Valid @RequestBody LawyerForm form) {
        Lawyer lawyer = lawyerService.findOne(lawyerId);
        if (lawyer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Address address = new Address(form.getOfficeName(), form.getOfficeAddress());
        ContactInfo contactInfo = new ContactInfo(form.getPhoneNumber(), form.getFaxNumber(), form.getEmailAddress());

//        lawyer.setName(form.getName());
//        lawyer.setAddress(address);
//        lawyer.setContactInfo(contactInfo);

        Lawyer updatedLawyer = lawyerService.saveLawyer(lawyer);
        return ResponseEntity.ok(updatedLawyer);
    }

    // List all lawyers for admin
    @GetMapping("/admin")
    public ResponseEntity<List<Lawyer>> listAllLawyersForAdmin() {
        List<Lawyer> lawyers = lawyerService.findLawyers();
        return ResponseEntity.ok(lawyers);
    }
}
