package lawyer.sslaw.controller;

import jakarta.validation.Valid;
import lawyer.sslaw.domain.Address;
import lawyer.sslaw.domain.ContactInfo;
import lawyer.sslaw.domain.law.Law;
import lawyer.sslaw.domain.law.SLawyer;
import lawyer.sslaw.service.LawService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LawController {
    private final LawService lawService;
    @GetMapping(value = "/laws/new")
    public String createForm(Model model) {
        model.addAttribute("form", new SLawyerForm());
        return "laws/addLawForm";
    }
    @PostMapping(value = "/laws/new")
    public String create(@Valid LawyerForm forml, SLawyerForm form) {
        Address address = new Address(forml.getOfficeName(), forml.getOfficeAddress());
        ContactInfo contactInfo = new ContactInfo(forml.getPhoneNumber(), forml.getFaxNumber(), forml.getEmailAddress());
        SLawyer sLawyer = new SLawyer();
        sLawyer.setName(form.getName());
        sLawyer.setBusinessRegistrationNumber(forml.getBusinessRegistrationNumber());
        sLawyer.setStockQuantity(form.getStockQuantity());
        sLawyer.setAuthor(form.getAuthor());
        sLawyer.setIsbn(form.getIsbn());
        lawService.saveLaw(sLawyer);
        return "redirect:/laws";
    }
    @GetMapping(value = "/laws")
    public String list(Model model) {
        List<Law> laws = lawService.findLaws();
        model.addAttribute("laws", laws);
        return "laws/lawList";
    }
    @GetMapping(value = "/laws/{lawId}/edit")
    public String updateLawForm(@PathVariable("lawId") Long lawId, Model model) {
        SLawyer law = (SLawyer) lawService.findOne(lawId);
        SLawyerForm form = new SLawyerForm();
        form.setId(law.getId());
        form.setName(law.getName());
        form.setStockQuantity(law.getStockQuantity());
        form.setAuthor(law.getAuthor());
        form.setIsbn(law.getIsbn());
        model.addAttribute("form", form);
        return "laws/updateLawForm";
    }
    /**
     * 상품 수정
     */
    @PostMapping(value = "/laws/{lawId}/edit")
    public String updateLaw(@PathVariable Long lawId, @ModelAttribute("form") SLawyerForm form) {
        lawService.updateLaw(lawId, form.getName(), form.getStockQuantity());
        return "redirect:/laws";
    }
}