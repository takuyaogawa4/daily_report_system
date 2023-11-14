package services;

import java.time.LocalDateTime;

import javax.persistence.NoResultException;

import actions.views.FollowConverter;
import actions.views.FollowView;
import constants.JpaConst;
import models.Follow;

public class FollowService extends ServiceBase {

    public void create(FollowView fv, String pepper) {

        LocalDateTime now = LocalDateTime.now();

        fv.setCreated_at(now);
        create(fv);

        //List<String> errors = FollowValidator.validate(this, fv, true, true);

        //        if (errors.size() == 0) {
        //            create(fv, pepper);
        //
        //        }
        // return errors;
    }

    private void create(FollowView fv) {

        em.getTransaction().begin();
        em.persist(FollowConverter.toModel(fv));
        em.getTransaction().commit();

    }

    public void unFollow(Integer loginId, Integer followId) {
        try {

            Follow follow = em.createNamedQuery(JpaConst.Q_UNFOLLOW_BY_ID, Follow.class)
                    .setParameter(JpaConst.JPQL_PARM_FOLLOW_LOGIN_ID, loginId)
                    .setParameter(JpaConst.FOLLOW_COL_FOLLOW_ID, followId)
                    .getSingleResult();
            em.getTransaction().begin();
            em.remove(follow);
            em.getTransaction().commit();
        } catch (NoResultException ex) {

        }

    }


}
