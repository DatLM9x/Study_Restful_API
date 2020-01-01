package gateway.wrb.repositories.impl;

import gateway.wrb.domain.RV002Info;
import gateway.wrb.repositories.RV002Repo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class RV002RepoImpl implements RV002Repo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RV002Info> getAllRV002() {
        String hql = "FROM RV001Info as u ORDER BY u.id";
        return (List<RV002Info>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public RV002Info getRV002byID(long id) {
        RV002Info obj = entityManager.find(RV002Info.class, id);
        return obj;
    }

    @Override
    public void addRV002(RV002Info rv002Info) {
        entityManager.persist(rv002Info);
    }

    @Override
    public void updateRV002(RV002Info rv002Info) {

    }

    @Override
    public void deleteRV002(long id) {
        entityManager.detach(getRV002byID(id));
    }

    @Override
    public boolean isRV002Exist(String msgDscd, String trnDt, String trnTm, String msgNo,
                                String wrdacNo, String rcvacNo, String amount) {
        String hql = "FROM RV001Info as u WHERE u.msgDscd=?";
        int count = entityManager.createQuery(hql).setParameter(1, msgDscd).getResultList().size();
        return count > 0 ? true : false;
    }
}

