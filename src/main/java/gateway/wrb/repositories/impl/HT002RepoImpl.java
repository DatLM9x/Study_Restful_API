package gateway.wrb.repositories.impl;

import gateway.wrb.domain.HT002Info;
import gateway.wrb.repositories.HT002Repo;
import gateway.wrb.util.Validator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class HT002RepoImpl implements HT002Repo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HT002Info> getAllHT002() {
        return null;
    }

    @Override
    public List<HT002Info> filterHT002(String orgCd, String bankCd, String bankCoNo, String outActNo, String InqSdt, String InqEdt) {
        List<HT002Info> ht002InfoList = new ArrayList<>();
        if (Validator.validateStrings(orgCd, bankCd, bankCoNo, outActNo)) {
            String hql = "FROM HT002Info WHERE actno=:actno ";
            ht002InfoList = entityManager.createQuery(hql).setParameter("actno", outActNo).getResultList();
        } else {
            String hql = "FROM HT002Info";
            ht002InfoList = entityManager.createQuery(hql).getResultList();
        }
        return ht002InfoList;
    }

    @Override
    public void addHT002(HT002Info ht002Info) {
        entityManager.persist(ht002Info);
    }

    @Override
    public void updateHT002(HT002Info ht002Info) {

    }

    @Override
    public void deleteHT002(long id) {

    }

    @Override
    public boolean isHT002Exist(String msgDscd, String trnDt, String trnTm, String msgNo, String wrdacNo, String rcvacNo, String amount) {
        return false;
    }
}

