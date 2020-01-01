package gateway.wrb.repositories;

import gateway.wrb.domain.PR001EInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface PR001ERepo extends JpaRepository<PR001EInfo, Long> {

}
