package lawyer.sslaw.service;

import lawyer.sslaw.domain.Lawyer;
import lawyer.sslaw.repository.LawyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LawyerService {
    private final LawyerRepository lawyerRepository;
    /**
     * 회원가입
     */
    @Transactional //변경
    public Long join(Lawyer lawyer) {
        validateDuplicateMember(lawyer); //중복 회원 검증
        lawyerRepository.save(lawyer);
        return lawyer.getId();
    }
    private void validateDuplicateMember(Lawyer lawyer) {
        List<Lawyer> findLawyers =lawyerRepository.findByName(lawyer.getName());
        if (!findLawyers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    /**
     * 전체 회원 조회
     */
    public List<Lawyer> findLawyers() {
        return lawyerRepository.findAll();
    }
    public Lawyer findOne(Long lawyerId) {
        return lawyerRepository.findOne(lawyerId);
    }
}