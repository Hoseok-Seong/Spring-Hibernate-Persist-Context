package shop.mtcoding.hiberpc.model.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public User findById(int id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else { // 더티체킹할 것이기 때문에 쓸 일이 없다.
            User userPS = em.find(User.class, user.getId());
            if (userPS != null) {
                em.merge(user);
            } else {
                System.out.println("잘못된 merge");
            }
        }
        return user;
    }

    public void delete(User user) {
        em.remove(user);
    }
}
