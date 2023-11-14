package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.FollowView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.MessageConst;
import constants.PropertyConst;
import services.FollowService;

public class FollowAction extends ActionBase {
    private FollowService service;

    public void follow() throws ServletException, IOException {
        //putRequestScope(AttributeConst.TOKEN, getTokenId());//test
        //        if (checkToken()) {

        // 既にフォローしているか確認するためのIF
        //
        //        if(fv.getInt("count") > 0) {
        //            errorMsg.add("こちらの宛先は既に登録されています");
        //
        //
        ////        if (checkAdmin()) {
        //
        //            EmployeeView ev = service.findOne(toNumber(getRequestParam(AttributeConst.EMP_ID)));
        //
        //            if (ev == null || ev.getDeleteFlag() == AttributeConst.DEL_FLAG_TRUE.getIntegerValue()) {
        //
        //                forward(ForwardConst.FW_ERR_UNKNOWN);
        //                return;
        //            }

        FollowView fv = new FollowView(
                null,
               Integer.parseInt(getRequestParam(AttributeConst.LOGIN_EMP)) , //ログインemployeeにcodeが入っているログインする人のIDを取得するひつようがある
               Integer.parseInt(getRequestParam(AttributeConst.FOLLOW_ID)) , //社員番号は取得できている
                null);
        String pepper = getContextScope(PropertyConst.PEPPER);

        service.create(fv, pepper);

        putSessionScope(AttributeConst.FLUSH, MessageConst.I_FOLLOWED.getMessage());
        //forward(ForwardConst.FW_EMP_INDEX);

        redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);
    }
    //    }

    public void unFollow() throws ServletException, IOException {


            service.unFollow(Integer.parseInt(getRequestParam(AttributeConst.LOGIN_EMP)) , Integer.parseInt(getRequestParam(AttributeConst.FOLLOW_ID)));

            putSessionScope(AttributeConst.FLUSH, MessageConst.I_UNFOLLOWED.getMessage());

            redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);

//            FollowView fv = new FollowView(
//                    null,
//                    getRequestParam(AttributeConst.LOGIN_EMP), //ログインemployeeにcodeが入っているログインする人のIDを取得するひつようがある
//                    getRequestParam(AttributeConst.FOLLOW_CODE), //社員番号は取得できている
//                    null);
//            String pepper = getContextScope(PropertyConst.PEPPER);
//
//            service.create(fv, pepper);
//
//            putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());
//            forward(ForwardConst.FW_EMP_INDEX);

    }

    @Override
    public void process() throws ServletException, IOException {

        service = new FollowService();

        invoke();

        service.close();
    }

}
