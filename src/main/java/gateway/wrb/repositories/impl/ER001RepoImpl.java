package gateway.wrb.repositories.impl;

import gateway.wrb.domain.ER001Info;
import gateway.wrb.repositories.ER001Repo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class ER001RepoImpl implements ER001Repo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ER001Info er001Info) {
        entityManager.persist(er001Info);
    }

    @Override
    public Integer isER001Exist(String msgdscd, String noticeDt, Integer noticeCnt, String fromCcy, String toCcy
            , BigDecimal baseRate, BigDecimal cashBuying, BigDecimal cashSelling, BigDecimal ttBuying
            , BigDecimal ttSelling, String orderDscd, String status, String filler) {
        String hql = "FROM ER001Info a where a.msgdscd = :msgdscd " +
                "and a.noticeDt = :noticeDt and a.noticeCnt = :noticeCnt " +
                "and a.fromCcy = :fromCcy and a.toCcy = :toCcy " +
                "and a.baseRate = :baseRate and a.cashBuying = :cashBuying " +
                "and a.cashSelling = :cashSelling and a.ttBuying = :ttBuying " +
                "and a.ttSelling = :ttSelling and a.orderDscd = :orderDscd " +
                "and a.status = :status and a.filler = :filler";
        List<ER001Info> er001Infos = entityManager.createQuery(hql)
                .setParameter("msgdscd", msgdscd)
                .setParameter("noticeDt", noticeDt)
                .setParameter("noticeCnt", noticeCnt)
                .setParameter("fromCcy", fromCcy)
                .setParameter("toCcy", toCcy)
                .setParameter("baseRate", baseRate)
                .setParameter("cashBuying", cashBuying)
                .setParameter("cashSelling", cashSelling)
                .setParameter("ttBuying", ttBuying)
                .setParameter("ttSelling", ttSelling)
                .setParameter("orderDscd", orderDscd)
                .setParameter("status", status)
                .setParameter("filler", filler)
                .getResultList();
        return er001Infos.size();
    }

    @Override
    public List<ER001Info> filterER001(String orgCd, String bankCd, String bankCoNo, String noticeSdt, String noticeEdt) {
        List<ER001Info> er001Infos = new ArrayList<>();
        String hql = "FROM ER001Info";
        er001Infos = entityManager.createQuery(hql).getResultList();
        return er001Infos;
    }
}

