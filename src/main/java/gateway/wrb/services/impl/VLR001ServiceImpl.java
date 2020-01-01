package gateway.wrb.services.impl;

import gateway.wrb.config.VLR001Config;
import gateway.wrb.constant.FileType;
import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.domain.VLR001Info;
import gateway.wrb.repositories.FbkFilesRepo;
import gateway.wrb.repositories.VLR001Repo;
import gateway.wrb.services.VLR001Service;
import gateway.wrb.util.NumberUtils;
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
public class VLR001ServiceImpl implements VLR001Service {
    public static final Logger logger = LoggerFactory.getLogger(VLR001ServiceImpl.class);

    @Autowired
    VLR001Config vlr001Config;

    @Autowired
    VLR001Repo vlr001Repo;

    @Autowired
    FbkFilesRepo fbkFilesRepo;

    @Override
    public void importVLR001(FbkFilesInfo fbkFilesInfo) {
        Integer msgDscdLength = vlr001Config.getMsgDscdLength();

        Integer tmsDtLength = vlr001Config.getTmsDtLength();
        Integer tmsTmLength = vlr001Config.getTmsTmLength();
        Integer coNoLength = vlr001Config.getCoNoLength();
        Integer outActNoLength = vlr001Config.getOutActNoLength();
        Integer dataCntLength = vlr001Config.getDataCntLength();
        Integer etcArLength = vlr001Config.getEtcLength();

        Integer virActNoLength = vlr001Config.getVirActNoLength();
        Integer aplDscdLength = vlr001Config.getAplDscdLength();
        Integer vractCusNmLength = vlr001Config.getVractCusNmLength();
        Integer trnAmLength = vlr001Config.getTrnAmLength();
        Integer irTrnYnLength = vlr001Config.getIrTrnYnLength();
        Integer lmtAmOvYnLength = vlr001Config.getLmtAmOvYnLength();
        Integer lmtAmBlwYnLength = vlr001Config.getLmtAmBlwYnLength();
        Integer dupRcvPrhbYnLength = vlr001Config.getDupRcvPrhbYnLength();
        Integer moacrvAvlYnLength = vlr001Config.getMoacrvAvlYnLength();
        Integer trnAvlSdtLength = vlr001Config.getTrnAvlSdtLength();
        Integer trnAvlEdtLength = vlr001Config.getTrnAvlEdtLength();
        Integer trnAvlStmLength = vlr001Config.getTrnAvlStmLength();
        Integer trnAvlEtmLength = vlr001Config.getTrnAvlEtmLength();
        Integer rgsTrnDtLength = vlr001Config.getRgsTrnDtLength();
        Integer docNoLength = vlr001Config.getDocNoLength();
        Integer stsDscdLength = vlr001Config.getStsDscdLength();
        Integer fillerLength = vlr001Config.getFillerLength();
        Integer lineFlagLength = vlr001Config.getLineFlagLength();


        try (Stream<String> stream = Files.lines(Paths.get(fbkFilesInfo.getFullfbkpath()))) {
            stream.forEach(line -> {
                try {
                    if (line.startsWith(FileType.PREFIX_START)) {
                        line = line.substring(msgDscdLength);

                        String tmsDt = line.substring(0, tmsDtLength);
                        line = line.substring(tmsDtLength);
                        String tmsTm = line.substring(0, tmsTmLength);
                        line = line.substring(tmsTmLength);
                        String coNo = line.substring(0, coNoLength);
                        line = line.substring(coNoLength);
                        //String outActNo = line.substring(0, outActNoLength);
                        line = line.substring(outActNoLength);
                        //String dataCnt = line.substring(0, dataCntLength);
                        line = line.substring(dataCntLength);
                        //String etcAr = line.substring(0, etcArLength);
                        line = line.substring(etcArLength);

                        fbkFilesInfo.setTmsdts(tmsDt);
                        fbkFilesInfo.setTmstms(tmsTm);
                        fbkFilesInfo.setConos(coNo);

                    } else if (line.startsWith(FileType.PREFIX_CONTENT)) {
                        String msgDscD = line.substring(0, msgDscdLength);
                        line = line.substring(msgDscdLength);

                        String virActNo = line.substring(0, virActNoLength);
                        line = line.substring(virActNoLength);
                        String aplDscd = line.substring(0, aplDscdLength);
                        line = line.substring(aplDscdLength);
                        String vractCusNm = line.substring(0, vractCusNmLength);
                        line = line.substring(vractCusNmLength);
                        String trnAm = line.substring(0, trnAmLength);
                        line = line.substring(trnAmLength);
                        String irTrnYn = line.substring(0, irTrnYnLength);
                        line = line.substring(irTrnYnLength);
                        String lmtAmOvYn = line.substring(0, lmtAmOvYnLength);
                        line = line.substring(lmtAmOvYnLength);
                        String lmtAmBlwYn = line.substring(0, lmtAmBlwYnLength);
                        line = line.substring(lmtAmBlwYnLength);
                        String dupRcvPrhbYn = line.substring(0, dupRcvPrhbYnLength);
                        line = line.substring(dupRcvPrhbYnLength);
                        String moacrvAvlYn = line.substring(0, moacrvAvlYnLength);
                        line = line.substring(moacrvAvlYnLength);
                        String trnAvlSdt = line.substring(0, trnAvlSdtLength);
                        line = line.substring(trnAvlSdtLength);
                        String trnAvlEdt = line.substring(0, trnAvlEdtLength);
                        line = line.substring(trnAvlEdtLength);
                        String trnAvlStm = line.substring(0, trnAvlStmLength);
                        line = line.substring(trnAvlStmLength);
                        String trnAvlEtm = line.substring(0, trnAvlEtmLength);
                        line = line.substring(trnAvlEtmLength);
                        String rgsTrnDt = line.substring(0, rgsTrnDtLength);
                        line = line.substring(rgsTrnDtLength);
                        String docNo = line.substring(0, docNoLength);
                        line = line.substring(docNoLength);
                        String stsDscd = line.substring(0, stsDscdLength);
                        line = line.substring(stsDscdLength);
                        String filler = line.substring(0, fillerLength);
                        line = line.substring(fillerLength);
                        String lineFlag = line.substring(0, lineFlagLength);
                        line = line.substring(lineFlagLength);


                        logger.info("vlrr001Path : [" + fbkFilesInfo.getFullfbkpath()
                                + ", msgDscd :" + msgDscD + ", virActNo:" + virActNo
                                + ", aplDscd :" + aplDscd + ", vractCusNm :" + vractCusNm
                                + ", trnAm:" + trnAm + ", irTrnYn:" + irTrnYn
                                + ", lmtAmOvYn:" + lmtAmOvYn + ", lmtAmBlwYn:" + lmtAmBlwYn
                                + ", dupRcvPrhbYn:" + dupRcvPrhbYn + ", moacrvAvlYn:" + moacrvAvlYn
                                + ", trnAvlSdt:" + trnAvlSdt + ", trnAvlEdt:" + trnAvlEdt
                                + ", trnAvlStm:" + trnAvlStm + ", trnAvlEtm:" + trnAvlEtm
                                + ", rgsTrnDt:" + rgsTrnDt + ", docNo:" + docNo + ", stsDscd:" + stsDscd
                                + ", filler:" + filler + ", lineFlag:" + lineFlag
                                + "]");

                        // save to DB
                        VLR001Info info = new VLR001Info();
                        info.setFbkname(fbkFilesInfo.getFbkname());
                        info.setMsgdscd(msgDscD);
                        info.setVirActNo(virActNo);
                        info.setAplDscd(aplDscd);
                        info.setVractCusNm(vractCusNm);
                        info.setTrnAm(NumberUtils.parseToDecimal(trnAm));
                        info.setIrTrnYn(irTrnYn);
                        info.setLmtAmOvYn(lmtAmOvYn);
                        info.setLmtAmBlwYn(lmtAmBlwYn);
                        info.setDupRcvPrhbYn(dupRcvPrhbYn);
                        info.setMoacrvAvlYn(moacrvAvlYn);
                        info.setTrnAvlSdt(trnAvlSdt);
                        info.setTrnAvlEdt(trnAvlEdt);
                        info.setTrnAvlStm(trnAvlStm);
                        info.setTrnAvlEtm(trnAvlEtm);
                        info.setRgsTrnDt(rgsTrnDt);
                        info.setDocNo(docNo);
                        info.setStsDscd(stsDscd);
                        info.setFiller(filler);
                        info.setLineFlag(lineFlag);

                        if (!isVLR001exist(info))
                            vlr001Repo.addVLR001(info);

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
    public List<VLR001Info> getAllVLR001() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<VLR001Info> getVLR001(String orgCd, String bankCd, String bankCoNo, String outActNo, String rgsTrnSdt, String rgsTrnEdt) {
        List<VLR001Info> rv001InfoList = vlr001Repo.filterVLRV001(orgCd, bankCd, bankCoNo, outActNo, rgsTrnSdt, rgsTrnEdt);
        return rv001InfoList;
    }

    @Override
    public void updateVLR001(VLR001Info info) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteVLR001(long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isVLR001exist(VLR001Info info) {
        try {
            Integer countEntity = vlr001Repo.isVLR001exist(info.getMsgdscd(), info.getVirActNo()
                    , info.getAplDscd(), info.getTrnAvlSdt()
                    , info.getTrnAvlEdt(), info.getTrnAvlStm()
                    , info.getTrnAvlEtm(), info.getRgsTrnDt()
                    , info.getStsDscd());
            logger.info("VLR001 " + info.getMsgdscd() + "," + info.getVirActNo() + " detail has count = " + countEntity);


            if (countEntity < 1)
                return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return true;
    }

}
