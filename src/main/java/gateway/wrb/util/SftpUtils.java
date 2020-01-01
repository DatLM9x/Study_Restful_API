package gateway.wrb.util;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import gateway.wrb.controllers.FbkController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Vector;

public class SftpUtils {
    public static final Logger logger = LoggerFactory.getLogger(FbkController.class);

    public void getFilesSftp(String SFTPHOST, String SFTPPORT, String SFTPUSER, String SFTPPASS, String SFTPWORKINGDIR) {
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        try {
            System.out.println("------------- Get Files SFTP --------------");
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, Integer.parseInt(SFTPPORT));
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect(60000);
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            Vector filelist = channelSftp.ls(SFTPWORKINGDIR);
            for (int i = 0; i < filelist.size(); i++) {
                System.out.println(filelist.get(i).toString());
                logger.info(filelist.get(i).toString());
            }
            System.out.println("------------- End Files SFTP --------------");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("SFTP : " + ex.getMessage());
        }
    }
}
