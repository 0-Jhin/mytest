package lawPage.lawyerPage.repository;

import jakarta.persistence.EntityManager;
import lawPage.lawyerPage.domain.Lawyer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LawyerRepository {
    private final EntityManager em;
    public void save(Lawyer lawyer) {
        if (lawyer.getId() == null) {
            em.persist(lawyer);
        } else {
           em.merge(lawyer);
        }
    }
    public Lawyer findOne(Long id) {
        return em.find(Lawyer.class, id);
    }
    public List<Lawyer> findAll() {
        return em.createQuery("select i from Lawyer i",Lawyer.class).getResultList();
    }
}