package constants;

public interface JpaConst {

    String PERSISTENCE_UNIT_NAME = "daily_report_system2";

    int ROW_PER_PAGE = 15;

    String TABLE_EMP = "employees";

    String EMP_COL_ID = "id";
    String EMP_COL_CODE = "code";
    String EMP_COL_NAME = "name";
    String EMP_COL_PASS = "password";
    String EMP_COL_ADMIN_FLAG = "admin_flag";
    String EMP_COL_CREATED_AT = "created_at";
    String EMP_COL_UPDATED_AT = "updated_at";
    String EMP_COL_DELETE_FLAG = "delete_flag";

    int ROLE_ADMIN = 1;
    int ROLE_GENERAL = 0;
    int EMP_DEL_TRUE = 1;
    int EMP_DEL_FALSE = 0;

    String TABLE_REP = "reports";

    String REP_COL_ID = "id";
    String REP_COL_EMP = "employee_id";
    String REP_COL_REP_DATE = "report_date";
    String REP_COL_TITLE = "title";
    String REP_COL_CONTENT = "content";
    String REP_COL_CREATED_AT = "created_at";
    String REP_COL_UPDATED_AT = "updated_at";

    String ENTITY_EMP = "employee";
    String ENTITY_REP = "report";

    String JPQL_PARM_CODE = "code";
    String JPQL_PARM_PASSWORD = "password";
    String JPQL_PARM_EMPLOYEE = "employee";
    String JPQL_PARM_FOLLOW_LOGIN_ID = "follow_login_id";

    //全フォロー取得に変更
        String Q_EMP_GET_ALL = ENTITY_EMP + ".getAll";
    //ここまで

    String Q_EMP_GET_ALL_DEF = "SELECT e FROM Employee AS e WHERE e.deleteFlag != 1 AND e.id  !=:" + JPQL_PARM_FOLLOW_LOGIN_ID
            + " ORDER BY e.id DESC";

//    データベースから取得ではなく、取得したリストのサイズを表示とするため必要なし
//    String Q_EMP_COUNT = ENTITY_EMP + ".count";
//    String Q_EMP_COUNT_DEF = "SELECT COUNT(e) FROM Employee AS e";

    String Q_EMP_GET_BY_CODE_AND_PASS = ENTITY_EMP + ".getByCodeAndPass";
    String Q_EMP_GET_BY_CODE_AND_PASS_DEF = "SELECT e FROM Employee AS e WHERE e.deleteFlag = 0 AND e.code =:"
            + JPQL_PARM_CODE + " AND e.password = :" + JPQL_PARM_PASSWORD;

    String Q_EMP_COUNT_REGISTERED_BY_CODE = ENTITY_EMP + ".countRegisteredByCode";
    String Q_EMP_COUNT_REGISTERED_BY_CODE_DEF = "SELECT COUNT(e) FROM Employee AS e WHERE e.code =:" + JPQL_PARM_CODE;

    String Q_REP_GET_ALL = ENTITY_REP + ".getAll";
    String Q_REP_GET_ALL_DEF = "SELECT r FROM Report r JOIN Follow f ON r.employee.id = f.followed_id WHERE f.employee_id = :" + JPQL_PARM_FOLLOW_LOGIN_ID;

//    データベースから取得ではなく、取得したリストのサイズを表示とするため必要なし
//    String Q_REP_COUNT = ENTITY_REP + ".count";
//    String Q_REP_COUNT_DEF = "SELECT COUNT(r) FROM Report AS r";

    String Q_REP_GET_ALL_MINE = ENTITY_REP + ".getAllMine";
    String Q_REP_GET_ALL_MINE_DEF = "SELECT r FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE
            + " ORDER BY r.id DESC";

    String Q_REP_COUNT_ALL_MINE = ENTITY_REP + ".countAllMine";
    String Q_REP_COUNT_ALL_MINE_DEF = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE;

    //追加　フォロワー機能

    String TABLE_FOLLOW = "follow";

    String FOLLOW_COL_EMP_ID = "employee_id";
    String FOLLOW_COL_FOLLOW_ID = "followed_id";
    String FOLLOW_CREATED_AT = "created_at";

    String Q_FOLLOW_GET_BY_ID = TABLE_FOLLOW + ".getAllFollowById"; //フォロー

    String Q_FOLLOW_GET_BY_ID_DEF = "SELECT f FROM Follow AS f WHERE f.employee_id = :" + JPQL_PARM_FOLLOW_LOGIN_ID; //フォロー実行SQL

    String Q_UNFOLLOW_BY_ID = TABLE_FOLLOW + ".unfollowById"; //アンフォロー実行
    String Q_UNFOLLOW_BY_ID_DEF = "SELECT f FROM Follow AS f WHERE f.employee_id = :" + JPQL_PARM_FOLLOW_LOGIN_ID + " AND f.followed_id = :" + FOLLOW_COL_FOLLOW_ID; //アンフォロー実行SQL

}
