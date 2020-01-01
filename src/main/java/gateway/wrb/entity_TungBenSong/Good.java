package gateway.wrb.entity_TungBenSong;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "good")
@Getter
@Setter
public class Good implements Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)//tạo id tự động trong mysql 
	private Long id;
	@Column(name = "name")
	private String goodName;
	@Column(name = "user_id")
	private Long userId;
}