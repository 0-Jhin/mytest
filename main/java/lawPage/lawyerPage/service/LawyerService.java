package lawPage.lawyerPage.service;

import jakarta.persistence.EntityManager;
import lawPage.lawyerPage.controller.LawyerForm;

import lawPage.lawyerPage.domain.Address;
import lawPage.lawyerPage.domain.ContactInfo;
import lawPage.lawyerPage.domain.Lawyer;
import lawPage.lawyerPage.repository.LawyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
public class LawyerService {
    private final LawyerRepository lawyerRepository;
    @Transactional
    public Lawyer saveLawyer(Lawyer lawyer) {
        lawyerRepository.save(lawyer);
        return lawyer;
    }

    @Transactional
    public void updateLawyer(Long lawyerId, LawyerForm form) { //Param: 파리미터로 넘어온 준영속 상태의 엔티티
        Lawyer findLawyer = lawyerRepository.findOne(lawyerId);
        Address address = new Address(form.getOfficeName(), form.getOfficeAddress());
        ContactInfo contactInfo = new ContactInfo(form.getPhoneNumber(), form.getFaxNumber(), form.getEmailAddress());
        form.builder()
                .name(findLawyer.getName())
                .businessRegistrationNumber(findLawyer.getBusinessRegistrationNumber())
                .officeName(form.getOfficeName())
                .officeAddress(form.getOfficeAddress())
                .phoneNumber(form.getPhoneNumber())
                .faxNumber(form.getFaxNumber())
                .emailAddress(form.getEmailAddress())
                .build();
    }

    public List<Lawyer> findLawyers() {
        return lawyerRepository.findAll();
    }
    public Lawyer findOne(Long lawyerId) {
        return lawyerRepository.findOne(lawyerId);
    }
}