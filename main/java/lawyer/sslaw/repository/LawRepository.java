package lawyer.sslaw.repository;

import jakarta.persistence.EntityManager;
import lawyer.sslaw.domain.law.Law;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LawRepository {
    private final EntityManager em;
    public void save(Law law) {
        if (law.getId() == null) {
            em.persist(law);
        } else {
            em.merge(law);
        }
    }
    public Law findOne(Long id) {
        return em.find(Law.class, id);
    }
    public List<Law> findAll() {
        return em.createQuery("select i from Law i",Law.class).getResultList();
    }
}