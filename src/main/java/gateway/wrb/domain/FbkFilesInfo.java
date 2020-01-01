package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fbkfiles")
@Data
public class FbkFilesInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fbkid;
    private String fbkname;
    private String fullfbkpath;
    private String filetype;
    private String trndt;

    private String conos;
    private String mgscds;
    private String recmsgcds;
    private String tmsdts;
    private String tmstms;
    private String apldscd;


    private String other;    //20190909 anhtn ER001 file

}