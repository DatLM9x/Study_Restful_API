package gateway.wrb.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class FbkConfig {
    @Value("${path.fbk}")
    private String fbkPath;

    @Value("${path.fbkbackup}")
    private String fbkPathBackup;

    @Value("${path.file.type}")
    private String fbkType;

    @Value("${path.file.header_snd}")
    private String headerSnd;

    @Value("${path.file.header_vir}")
    private String headerVir;

//    @Value("${server.host}")
//    private String sftphost;
//
//    @Value("${server.port}")
//    private String sftpport;
//
//    @Value("${server.user}")
//    private String sftuser;
//
//    @Value("${server.password}")
//    private String sftpassword;

    //anhtn 20190911
    @Value("${path.file.header_awa}")
    private String headerAwa;

    @Value("${path.fbksend}")
    private String fbkSend;
    //end

}
