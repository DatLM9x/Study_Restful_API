package gateway.wrb.repositories.impl;

import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.repositories.FbkFilesRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class FbkFilesRepoImpl implements FbkFilesRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FbkFilesInfo getFbkFileInfo(String directoryPath) {
        return null;
    }

    @Override
    public List<FbkFilesInfo> getFbkFiles() {
        return null;
    }

    @Override
    public FbkFilesInfo getFbkInfo(long id) {
        return null;
    }

    @Override
    public void addFbkFile(FbkFilesInfo fbkFile) {
        entityManager.persist(fbkFile);
    }

    @Override
    public void updateFile(FbkFilesInfo fbkFile) {

    }

    @Override
    public void deleteFbkFile(String id) {

    }

    @Override
    public boolean isFileExist(FbkFilesInfo fbkFilesInfo) {
        String hql = "FROM FbkFilesInfo WHERE fbkname=:fbkname";
        int count = entityManager.createQuery(hql).setParameter("fbkname", fbkFilesInfo.getFbkname())
                .getResultList().size();
        return count > 0 ? true : false;
    }
}

