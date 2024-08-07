package lawPage.lawyerPage.controller;

import jakarta.validation.Valid;
import lawPage.lawyerPage.domain.Address;
import lawPage.lawyerPage.domain.ContactInfo;
import lawPage.lawyerPage.domain.Lawyer;
import lawPage.lawyerPage.service.LawyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LawyerController {
    private final LawyerService lawyerService;
    @GetMapping(value = "/lawyers/new")
    public String createForm(Model model, LawyerForm form) {
        model.addAttribute("form");
        return "lawyers/addLawyerForm";
    }
    @PostMapping(value = "/lawyers/new")
    public String create(@Valid LawyerForm form) {
        Address address = new Address(form.getOfficeName(), form.getOfficeAddress());
        ContactInfo contactInfo = new ContactInfo(form.getPhoneNumber(), form.getFaxNumber(), form.getEmailAddress());
        Lawyer lawyer = Lawyer.builder()
                .name(form.getName())
                .businessRegistrationNumber(form.getBusinessRegistrationNumber())
                .address(address)
                .contactInfo(contactInfo)
                .build();
        lawyerService.saveLawyer(lawyer);
        return "redirect:/lawyers";
    }
    @GetMapping(value = "/lawyers")
    public String list(Model model) {
        List<Lawyer> lawyers = lawyerService.findLawyers();
        model.addAttribute("lawyers", lawyers);
        return "lawyers/lawyerList";
    }

    @GetMapping(value = "/lawyers/admin")
    public String listAd(Model model) {
        List<Lawyer> lawyers = lawyerService.findLawyers();
        model.addAttribute("lawyers", lawyers);
        return "lawyers/lawyerListAdmin";
    }
    @GetMapping(value = "/lawyers/{lawyerId}/edit")
    public String updateLawyerForm(@PathVariable("lawyerId") Long lawyerId, Model model) {
        Lawyer lawyer = (Lawyer) lawyerService.findOne(lawyerId);
        LawyerForm form = LawyerForm.builder()
                .name(lawyer.getName())
                .businessRegistrationNumber(lawyer.getBusinessRegistrationNumber())
                .officeName(lawyer.getAddress().getOfficeName())
                .officeAddress(lawyer.getAddress().getOfficeAddress())
                .phoneNumber(lawyer.getContactInfo().getPhoneNumber())
                .faxNumber(lawyer.getContactInfo().getFaxNumber())
                .emailAddress(lawyer.getContactInfo().getEmailAddress()).build();
        model.addAttribute("form", form);
        return "lawyers/updateLawyerForm";
    }
    /**
     * 상품 수정
     */
    @PostMapping(value = "/lawyers/{lawyerId}/edit")
    public String updateLawyer(@PathVariable Long lawyerId, @ModelAttribute("form") LawyerForm form) {
        lawyerService.updateLawyer(lawyerId, form);
        return "redirect:/lawyers/updateLawyerForm";
    }
    @GetMapping(value = "/lawyer/{lawyerId}")
    public String lawyerForm(@PathVariable("lawyerId") Long lawyerId, Model model) {
        Lawyer lawyer = (Lawyer) lawyerService.findOne(lawyerId);
        LawyerForm form = LawyerForm.builder()
                .name(lawyer.getName())
                .businessRegistrationNumber(lawyer.getBusinessRegistrationNumber())
                .officeName(lawyer.getAddress().getOfficeName())
                .officeAddress(lawyer.getAddress().getOfficeAddress())
                .phoneNumber(lawyer.getContactInfo().getPhoneNumber())
                .faxNumber(lawyer.getContactInfo().getFaxNumber())
                .emailAddress(lawyer.getContactInfo().getEmailAddress())
                .build();
        model.addAttribute("form", form);
        return "lawyers/lawyerForm";
    }
}