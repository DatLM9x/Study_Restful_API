package gateway.wrb.repositories.impl;

import gateway.wrb.domain.RV001Info;
import gateway.wrb.repositories.RV001Repo;
import gateway.wrb.util.Validator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class RV001RepoImpl implements RV001Repo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RV001Info> getAllRV001() {
        String hql = "FROM RV001Info as u ORDER BY u.id";
        return (List<RV001Info>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<RV001Info> filterRV001(String orgCd, String bankCd, String bankCoNo, String outActNo, String rgsTrnSdt, String rgsTrnEdt) {
        List<RV001Info> rv001InfoList = new ArrayList<>();
        if (Validator.validateStrings(orgCd, bankCd, bankCoNo, outActNo)) {
            String hql = "FROM RV001Info WHERE rcvviracno=:outActNo ";
            rv001InfoList = entityManager.createQuery(hql).setParameter("outActNo", outActNo).getResultList();
        }
        return rv001InfoList;
    }

    @Override
    public void addRV001(RV001Info rv001Info) {
        entityManager.persist(rv001Info);
    }

    @Override
    public void updateRV001(RV001Info rv001Info) {

    }

    @Override
    public void deleteRV001() {
    }

    @Override
    public boolean isRV001Exist(String msgDscd, String trnDt, String trnTm, String msgNo,
                                String wrdacNo, String rcvacNo, String amount) {
        String hql = "FROM RV001Info as u WHERE u.msgDscd=:msgDscd";
        int count = entityManager.createQuery(hql).setParameter("msgDscd", msgDscd).getResultList().size();
        return count > 0 ? true : false;
    }
}

