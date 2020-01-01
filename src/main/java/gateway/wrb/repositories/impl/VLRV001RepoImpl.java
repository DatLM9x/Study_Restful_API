package gateway.wrb.repositories.impl;

import gateway.wrb.domain.VLR001Info;
import gateway.wrb.repositories.VLR001Repo;
import gateway.wrb.util.Validator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class VLRV001RepoImpl implements VLR001Repo {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addVLR001(VLR001Info vlr001Info) {
        entityManager.persist(vlr001Info);
    }

    @Override
    public List<VLR001Info> filterVLRV001(String orgCd, String bankCd, String bankCoNo, String outActNo, String rgsTrnSdt, String rgsTrnEdt) {
        List<VLR001Info> vlr001InfoList = new ArrayList<>();
        if (Validator.validateStrings(orgCd, bankCd, bankCoNo, outActNo)) {
            String hql = "FROM VLR001Info WHERE virActNo=:virActNo ";
            vlr001InfoList = entityManager.createQuery(hql).setParameter("virActNo", outActNo).getResultList();
        } else {
            String hql = "FROM VLR001Info";
            vlr001InfoList = entityManager.createQuery(hql).getResultList();
        }
        return vlr001InfoList;
    }

    @Override
    public Integer isVLR001exist(String msgdscd, String virActNo, String aplDscd, String trnAvlSdt, String trnAvlEdt, String trnAvlStm, String trnAvlEtm, String rgsTrnDt, String stsDscd) {
        String hql = "FROM VLR001Info WHERE msgdscd=:msgdscd and virActNo=:virActNo and aplDscd=:aplDscd and trnAvlSdt=:trnAvlSdt and trnAvlEdt=:trnAvlEdt and trnAvlStm=:trnAvlStm and trnAvlEtm=:trnAvlEtm and rgsTrnDt=:rgsTrnDt and stsDscd=:stsDscd";
        List<VLR001Info> vlr001InfoList = entityManager.createQuery(hql).setParameter("msgdscd", msgdscd)
                .setParameter("virActNo", virActNo)
                .setParameter("aplDscd", aplDscd)
                .setParameter("trnAvlSdt", trnAvlSdt)
                .setParameter("trnAvlEdt", trnAvlEdt)
                .setParameter("trnAvlStm", trnAvlStm)
                .setParameter("trnAvlEtm", trnAvlEtm)
                .setParameter("rgsTrnDt", rgsTrnDt)
                .setParameter("stsDscd", stsDscd)
                .getResultList();
        return vlr001InfoList.size();
    }
}

