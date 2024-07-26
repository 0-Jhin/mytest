package lawyer.sslaw.controller;

import jakarta.validation.Valid;
import lawyer.sslaw.domain.Address;
import lawyer.sslaw.domain.ContactInfo;
import lawyer.sslaw.domain.Lawyer;
import lawyer.sslaw.service.LawyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LawyerController {
    private final LawyerService lawyerService;
    @GetMapping(value = "/lawyers/new")
    public String createForm(Model model) {
        model.addAttribute("lawyerForm", new LawyerForm());
        return "lawyers/addLawyerForm";
    }
    @PostMapping(value = "/lawyers/new")
    public String create(@Valid LawyerForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "lawyers/addLawyerForm";
        }
        Address address = new Address(form.getOfficeName(), form.getOfficeAddress());
        ContactInfo contactInfo = new ContactInfo(form.getPhoneNumber(), form.getFaxNumber(), form.getEmailAddress());
        Lawyer lawyer = new Lawyer();
        lawyer.setName(form.getName());
        lawyer.setBusinessRegistrationNumber(form.getBusinessRegistrationNumber());
        lawyer.setAddress(address);
        lawyer.setContactInfo(contactInfo);
        lawyerService.join(lawyer);
        return "redirect:/";
    }
    @GetMapping(value = "/lawyers")
    public String list(Model model) {
        List<Lawyer> lawyers = lawyerService.findLawyers();
        model.addAttribute("lawyers", lawyers);
        return "lawyers/lawyerList";
    }
}