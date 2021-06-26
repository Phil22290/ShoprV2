package com.vdab.Shopr.repos;

import com.vdab.Shopr.domain.Vinyl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class VinylRepo {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Vinyl> showVinyl() {
        return entityManager.createQuery("select v from Vinyl v", Vinyl.class).getResultList();
    }
    
    @Transactional
    public void addVinylDb(Vinyl newVinyl) {
        entityManager.persist(newVinyl);
    }
    
    public Vinyl findVinylById(Long articleId) {
        return entityManager.createQuery("select v from Vinyl v where v.articleId = :articleId", Vinyl.class).setParameter("articleId",articleId).getSingleResult();
    }
    
    @Transactional
    public void editVinylById(Vinyl editVinyl){
        entityManager.merge(editVinyl);
    }
    
    @Transactional
    public void deleteVinyl(long articleId) {
        Vinyl vin = findVinylById(articleId);
        entityManager.remove(vin);
    }
}
