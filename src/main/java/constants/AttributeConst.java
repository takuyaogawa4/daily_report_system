package constants;

public enum AttributeConst {



    FLUSH("flush"),

    MAX_ROW("maxRow"),
    PAGE("page"),

    TOKEN("token"),
    ERR("errors"),

    LOGIN_EMP("login_employee"),

    LOGIN_ERR("loginError"),

    EMPLOYEE("employee"),
    EMPLOYEES("employees"),
    EMP_COUNT("employees_count"),
    EMP_ID("id"),
    EMP_CODE("code"),
    EMP_PASS("password"),
    EMP_NAME("name"),
    EMP_ADMIN_FLG("admin_flag"),


    ROLE_ADMIN(1),
    DEL_GENERAL(0),

    DEL_FLAG_TRUE(1),
    DEL_FLAG_FALSE(0),

    REPORT("report"),
    REPORTS("reports"),
    REP_COUNT("reports_count"),
    REP_ID("id"),
    REP_DATE("report_date"),
    REP_TITLE("title"),
    REP_CONTENT("content_msg");


    private final String text;
    private final Integer i;

    private AttributeConst(final String text) {
        this.text = text;
        this.i = null;


    }
    private AttributeConst(final Integer i) {
        this.text = null;
        this.i = i;


    }
    private String getValue() {

        return this.text;

    }
    private Integer getIntegerValue() {
        return this.i;

    }






}
