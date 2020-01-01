package gateway.wrb.repositorie_TungBenSong.Implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gateway.wrb.entity_TungBenSong.User;
import gateway.wrb.repositorie_TungBenSong.UserRepo;

@Repository //lớp truy cập database thì có annotation @Repository, lên mạng tìm hiểu thêm
@Transactional
public class UserRepoImpl implements UserRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
	}

	@Override
	public User selectUserById(Long id) {
		// TODO Auto-generated method stub
		 String sqlQuery = "FROM User WHERE id =:ID";
		 Query query = (Query) entityManager.createQuery(sqlQuery);
			query.setParameter("ID", id);
			return (User) query.getResultList().get(0);
	}

	@Override
	public List<User> selectUserByName(String name) {
		// TODO Auto-generated method stub
		String sqlQuery = "FROM User WHERE userName =:name";
		//Query<User> query = entityManager.createQuery(sqlQuery);
		Query query = (Query) entityManager.createQuery(sqlQuery);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		String sqlQuery = "FROM User";
		return entityManager.createQuery(sqlQuery).getResultList();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		entityManager.detach(user);
	}

	@Override
	public void deleteUserById(Long ID) {
		// TODO Auto-generated method stub
//		User user = this.selectUserById(id);
//		this.deleteUser(user);
		String sqlExecute =" DELETE FROM User WHERE id =:Id";
		Query query = (Query) entityManager.createQuery(sqlExecute).setParameter("Id", ID);
		query.executeUpdate();
	}
	
}
