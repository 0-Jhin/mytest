package lawyer.sslaw.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lawyer.sslaw.domain.Lawyer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LawyerRepository {
    @PersistenceContext
    private EntityManager em;
    public void save(Lawyer lawyer) {
        em.persist(lawyer);
    }
    public Lawyer findOne(Long id) {
        return em.find(Lawyer.class, id);
    }
    public List<Lawyer> findAll() {
        return em.createQuery("select m from Lawyer m", Lawyer.class)
                .getResultList();
    }
    public List<Lawyer> findByName(String name) {
        return em.createQuery("select m from Lawyer m where m.name = :name",
                        Lawyer.class)
                .setParameter("name", name)
                .getResultList();
    }
}