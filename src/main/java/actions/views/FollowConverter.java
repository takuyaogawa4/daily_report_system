package actions.views;

import models.Follow;

public class FollowConverter {
    public static Follow toModel(FollowView fv) {

        return new Follow(
                fv.getId(),
                fv.getEmployee_id(),
                fv.getFollowed_id(),
                fv.getCreated_at());

    }
}

//    public static FollowView toView(Follow e) {
//
//        if (e == null) {
//
//            return null;
//        }
//
//        return new FollowView(
//                e.getId(),
//                e.getCode(),
//                e.getName(),
//                e.getPassword(),
//                e.getAdminFlag() == null
//                        ? null
//                        : e.getAdminFlag() == JpaConst.ROLE_ADMIN
//                                ? AttributeConst.ROLE_ADMIN.getIntegerValue()
//                                : AttributeConst.ROLE_GENERAL.getIntegerValue(),
//                e.getCreatedAt(),
//                e.getUpdatedAt(),
//                e.getDeleteFlag() == null
//                        ? null
//                        : e.getDeleteFlag() == JpaConst.EMP_DEL_TRUE
//                                ? AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
//                                : AttributeConst.DEL_FLAG_FALSE.getIntegerValue());
//
//    }
//
//    public static List<FollowView> toViewList(List<Follow> list) {
//
//        List<FollowView> fvs = new ArrayList<>();
//
//        for (Follow e : list) {
//            fvs.add(toView(e));
//        }
//        return fvs;
//
//    }
//
//    public static void copyViewToModel(Follow e, FollowView fv) {
//        e.setId(fv.getId());
//        e.setCode(fv.getCode());
//        e.setName(fv.getName());
//        e.setPassword(fv.getPassword());
//        e.setAdminFlag(fv.getAdminFlag());
//        e.setCreatedAt(fv.getCreatedAt());
//        e.setUpdatedAt(fv.getUpdatedAt());
//        e.setDeleteFlag(fv.getDeleteFlag());
//    }
//}
