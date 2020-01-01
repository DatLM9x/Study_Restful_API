package gateway.wrb.services.impl;

import gateway.wrb.config.HT002Config;
import gateway.wrb.constant.FileType;
import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.domain.HT002Info;
import gateway.wrb.repositories.FbkFilesRepo;
import gateway.wrb.repositories.HT002Repo;
import gateway.wrb.services.HT002Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class HT002ServiceImpl implements HT002Service {
    public static final Logger logger = LoggerFactory.getLogger(HT002ServiceImpl.class);
    @Autowired
    HT002Config ht002Config;
    @Autowired
    HT002Repo ht002Repo;

    @Autowired
    FbkFilesRepo fbkFilesRepo;

    @Override
    public List<HT002Info> getAllHT002() {
        return null;
    }

    @Override
    public List<HT002Info> getHT002(String orgCd, String bankCd, String bankCoNo, String outActNo, String InqSdt, String InqEdt) {
        List<HT002Info> ht002InfoList = ht002Repo.filterHT002(orgCd, bankCd, bankCoNo, outActNo, InqSdt, InqEdt);
        return ht002InfoList;
    }

    @Override
    public void importHT002(FbkFilesInfo fbkFilesInfo) {
        Integer tmsDtLength = ht002Config.getTmsDtLength();
        Integer tmsTmLength = ht002Config.getTmsTmLength();
        Integer coNoLength = ht002Config.getCoNoLength();
        Integer mgscdLength = ht002Config.getMgscdLength();

        Integer msgDscdLength = ht002Config.getMsgDscdLength();
        Integer actNoLength = ht002Config.getActNoLength();
        Integer trnDtLength = ht002Config.getTrnDtLength();
        Integer trnTmLength = ht002Config.getTrnTmLength();
        Integer drCrLength = ht002Config.getDrCrLength();
        Integer trnAmtLength = ht002Config.getTrnAmtLength();
        Integer trnAfBlLength = ht002Config.getTrnAfBlLength();
        Integer brCdLength = ht002Config.getBrCdLength();
        Integer chkAmtLength = ht002Config.getChkAmtLength();
        Integer trnTypeLength = ht002Config.getTrnTypeLength();
        Integer particularLength = ht002Config.getParticularLength();
        Integer depSeqLength = ht002Config.getDepSeqLength();
        Integer statusLength = ht002Config.getStatusLength();
        Integer channelTypeLength = ht002Config.getChannelTypeLength();
        Integer trnSrnoLength = ht002Config.getTrnSrnoLength();
        Integer destAccountLength = ht002Config.getDestAccountLength();
        Integer recieveNameLength = ht002Config.getRecieveNameLength();
        Integer refTxtLength = ht002Config.getRefTxtLength();
        Integer depRmkLength = ht002Config.getDepRmkLength();
        Integer trmPrcSrnoLength = ht002Config.getTrmPrcSrnoLength();
        Integer virActNoLength = ht002Config.getVirActNoLength();

        try (Stream<String> stream = Files.lines(Paths.get(fbkFilesInfo.getFullfbkpath()))) {
            stream.forEach(line -> {
                try {
                    if (line.startsWith(FileType.PREFIX_START)) {
                        String msgDscdS = line.substring(0, msgDscdLength);
                        line = line.substring(msgDscdLength);
                        String tmsDt = line.substring(0, tmsDtLength);
                        line = line.substring(tmsDtLength);
                        String tmsTm = line.substring(0, tmsTmLength);
                        line = line.substring(tmsTmLength);
                        String coNo = line.substring(0, coNoLength);
                        line = line.substring(coNoLength);
                        String mgsCd = line.substring(0, mgscdLength);
                        line = line.substring(mgscdLength);

                        fbkFilesInfo.setTmsdts(tmsDt);
                        fbkFilesInfo.setTmstms(tmsTm);
                        fbkFilesInfo.setConos(coNo);
                        fbkFilesInfo.setMgscds(mgsCd);

                    } else if (line.startsWith(FileType.PREFIX_CONTENT)) {
                        String msgDscd = line.substring(0, msgDscdLength);
                        line = line.substring(msgDscdLength);
                        String actNo = line.substring(0, actNoLength);
                        line = line.substring(actNoLength);
                        String trnDt = line.substring(0, trnDtLength);
                        line = line.substring(trnDtLength);
                        String trnTm = line.substring(0, trnTmLength);
                        line = line.substring(trnTmLength);
                        String drCr = line.substring(0, drCrLength);
                        line = line.substring(drCrLength);
                        String trnAmt = line.substring(0, trnAmtLength);
                        line = line.substring(trnAmtLength);
                        String trnAfBl = line.substring(0, trnAfBlLength);
                        line = line.substring(trnAfBlLength);
                        String brCd = line.substring(0, brCdLength);
                        line = line.substring(brCdLength);
                        String chkAmt = line.substring(0, chkAmtLength);
                        line = line.substring(chkAmtLength);
                        String trnType = line.substring(0, trnTypeLength);
                        line = line.substring(trnTypeLength);
                        String particular = line.substring(0, particularLength);
                        line = line.substring(particularLength);
                        String depSep = line.substring(0, depSeqLength);
                        line = line.substring(depSeqLength);
                        String status = line.substring(0, statusLength);
                        line = line.substring(statusLength);
                        String channelType = line.substring(0, channelTypeLength);
                        line = line.substring(channelTypeLength);
                        String trnSrno = line.substring(0, trnSrnoLength);
                        line = line.substring(trnSrnoLength);
                        String destAccount = line.substring(0, destAccountLength);
                        line = line.substring(destAccountLength);
                        String recieveName = line.substring(0, recieveNameLength);
                        line = line.substring(recieveNameLength);
                        String refTxt = line.substring(0, refTxtLength);
                        line = line.substring(refTxtLength);
                        String depRmk = line.substring(0, depRmkLength);
                        line = line.substring(depRmkLength);
                        String trmPrcSrno = line.substring(0, trmPrcSrnoLength);
                        line = line.substring(trmPrcSrnoLength);
                        String virActNo = line.substring(0, virActNoLength);
                        line = line.substring(virActNoLength);

                        System.out.println("ht002Path : [" + fbkFilesInfo.getFullfbkpath() + ", msgDscd :" + msgDscd + ", actNo:" + actNo + ", trnDt :" + trnDt + ", trnTm :" + trnTm + ", drCr:" + drCr + ", trnAmt:" + trnAmt
                                + ", trnAfBl:" + trnAfBl + ", brCd:" + brCd + ", chkAmt:" + chkAmt + ", trnType:" + trnType + ", particular:" + particular + ", depSep:" + depSep + ", status:" + status + ", channelType:" + channelType
                                + ", trnSrno:" + trnSrno + ", destAccount:" + destAccount + ", recieveName:" + recieveName + ", refTxt:" + refTxt + ", depRmk:" + depRmk + ", trmPrcSrno:" + trmPrcSrno + ", virActNo:" + virActNo + "]");

                        // save to DB
                        HT002Info ht002Info = new HT002Info();
                        ht002Info.setFbkname(fbkFilesInfo.getFbkname());
                        ht002Info.setMsgdscd(msgDscd);
                        ht002Info.setActno(actNo);
                        ht002Info.setTrndt(trnDt);
                        ht002Info.setTrntm(trnTm);
                        ht002Info.setDrcr(drCr);
                        ht002Info.setTrnamt(trnAmt);
                        ht002Info.setTrnafbl(trnAfBl);
                        ht002Info.setBrcd(brCd);
                        ht002Info.setChkamt(chkAmt);
                        ht002Info.setTrntype(trnType);
                        ht002Info.setParticular(particular);
                        ht002Info.setDepseq(depSep);
                        ht002Info.setStatus(status);
                        ht002Info.setChanneltype(channelType);
                        ht002Info.setTrnsrno(trnSrno);
                        ht002Info.setDestaccount(destAccount);
                        ht002Info.setRecievename(recieveName);
                        ht002Info.setReftxt(refTxt);
                        ht002Info.setDeprmk(depRmk);
                        ht002Info.setTrmprcsrno(trmPrcSrno);
                        ht002Info.setViractno(virActNo);
                        ht002Repo.addHT002(ht002Info);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            });
            fbkFilesRepo.addFbkFile(fbkFilesInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateHT002(HT002Info rv001Info) {

    }

    @Override
    public void deleteHT002(long id) {

    }

    @Override
    public boolean isHT002exist(HT002Info rv001Info) {
        return false;
    }
}
