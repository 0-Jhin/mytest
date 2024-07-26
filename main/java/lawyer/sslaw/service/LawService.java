package lawyer.sslaw.service;

import lawyer.sslaw.domain.law.Law;
import lawyer.sslaw.repository.LawRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LawService {
    private final LawRepository lawRepository;
    @Transactional
    public void saveLaw(Law law) {
        lawRepository.save(law);
    }

    @Transactional
    public void updateLaw(Long lawId, String name, int stockQuantity) { //itemParam: 파리미터로 넘어온 준영속 상태의 엔티티
        Law findLaw = lawRepository.findOne(lawId);
        findLaw.setName(name);
        findLaw.setStockQuantity(stockQuantity);
    }

    public List<Law> findLaws() {
        return lawRepository.findAll();
    }
    public Law findOne(Long lawId) {
        return lawRepository.findOne(lawId);
    }
}