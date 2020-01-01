package gateway.wrb.repositories.impl;

import gateway.wrb.domain.RA001Info;
import gateway.wrb.repositories.RA001Repo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class RA001RepoImpl implements RA001Repo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(RA001Info ra001Info) {
        entityManager.persist(ra001Info);
    }

    @Override
    public Integer isRA001Exist(String msgdscd, String wdrActNo, String aplDscd, String trnStDt, String trnType, String curCd, String cusIdNo) {
        String hql = "FROM RA001Info WHERE msgdscd=:msgdscd and virActNo=:virActNo and aplDscd=:aplDscd and trnAvlSdt=:trnAvlSdt and trnAvlEdt=:trnAvlEdt and trnAvlStm=:trnAvlStm and trnAvlEtm=:trnAvlEtm and rgsTrnDt=:rgsTrnDt and stsDscd=:stsDscd";
        List<RA001Info> ra001InfoList = entityManager.createQuery(hql)
                .setParameter("msgdscd", msgdscd)
                .setParameter("wdrActNo", wdrActNo)
                .setParameter("aplDscd", aplDscd)
                .setParameter("trnStDt", trnStDt)
                .setParameter("trnType", trnType)
                .setParameter("curCd", curCd)
                .setParameter("cusIdNo", cusIdNo)
                .getResultList();
        return ra001InfoList.size();
    }

    @Override
    public List<RA001Info> filterRA001_2(String orgCd, String bankCd, String bankCoNo, String bankRsvSdt, String bankRsvEdt) {
        List<RA001Info> ra001InfoList = new ArrayList<>();
        String hql = "FROM RA001Info ";
        ra001InfoList = entityManager.createQuery(hql).getResultList();
        return ra001InfoList;
    }

    @Override
    public List<RA001Info> filterRA001(String orgCd, String bankCd, String bankCoNo) {
        List<RA001Info> ra001InfoList = new ArrayList<>();
        String hql = "FROM VLR001Info";
        ra001InfoList = entityManager.createQuery(hql).getResultList();
        return ra001InfoList;
    }
}

