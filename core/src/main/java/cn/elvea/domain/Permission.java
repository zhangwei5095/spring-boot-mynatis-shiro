package cn.elvea.domain;

import cn.elvea.commons.domain.BaseEntity;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;

/**
 * 权限实体类
 */
@Entity
@Table(name = "PERMISSION")
public class Permission extends BaseEntity {
    /**
     * SpringSecurity中默认的角色/授权名前缀.
     */
    public static final String AUTHORITY_PREFIX = "ROLE_";

    public static final int TYPE_TRAINER = 1;
    public static final int TYPE_LEARNER = 2;
    public static final int TYPE_TEACHER = 3;
    public static final int TYPE_SUPER = 4;

    public static final String REQ_MGT = "REQ_MGT";

    /**
     * 岗位管理
     */
    public static final String POS_MGT = "POS_MGT";
    public static final String VIEW_POS = "VIEW_POS";
    public static final String ADD_POS = "ADD_POS";
    public static final String EDIT_POS = "EDIT_POS";
    public static final String VIEW_POS_DEV_PATH = "VIEW_POS_DEV_PATH";
    public static final String ADD_POS_DEV_PATH = "ADD_POS_DEV_PATH";
    public static final String EDIT_POS_DEV_PATH = "EDIT_POS_DEV_PATH";

    /**
     * 项目banner管理
     */
    public static final String BANNER_MGT = "BANNER_MGT";
    public static final String VIEW_BANNER = "VIEW_BANNER";
    public static final String ADD_BANNER = "ADD_BANNER";
    public static final String EDIT_BANNER = "EDIT_BANNER";

    public static final String PLAN_MGT = "PLAN_MGT";
    public static final String YEAR_PLAN = "YEAR_PLAN";
    public static final String ADD_YEAR_PLAN = "ADD_YEAR_PLAN";
    public static final String EDIT_YEAR_PLAN = "EDIT_YEAR_PLAN";
    public static final String IMPORT_YEAR_PLAN = "IMPORT_YEAR_PLAN";
    public static final String EXPORT_YEAR_PLAN = "EXPORT_YEAR_PLAN";
    public static final String QUARTER_PLAN = "QUARTER_PLAN";
    public static final String ADD_QUARTER_PLAN = "ADD_QUARTER_PLAN";
    public static final String EDIT_QUARTER_PLAN = "EDIT_QUARTER_PLAN";
    public static final String IMPORT_QUARTER_PLAN = "IMPORT_QUARTER_PLAN";
    public static final String EXPORT_QUARTER_PLAN = "EXPORT_QUARTER_PLAN";
    public static final String CONFIG_QUARTER_PLAN_WORKFLOW = "CONFIG_QUARTER_PLAN_WORKFLOW";
    public static final String MONTH_PLAN = "MONTH_PLAN";
    public static final String ADD_MONTH_PLAN = "ADD_MONTH_PLAN";
    public static final String EDIT_MONTH_PLAN = "EDIT_MONTH_PLAN";
    public static final String IMPORT_MONTH_PLAN = "IMPORT_MONTH_PLAN";
    public static final String EXPORT_MONTH_PLAN = "EXPORT_MONTH_PLAN";
    public static final String CONFIG_MONTH_PLAN_WORKFLOW = "CONFIG_MONTH_PLAN_WORKFLOW";
    public static final String PLAN_CARRYOUT = "PLAN_CARRYOUT";

    /**
     * 计划审批
     */
    public static final String PLAN_APPROVAL = "PLAN_APPROVAL";
    public static final String VIEW_PLAN_APPROVAL = "VIEW_PLAN_APPROVAL";
    public static final String APPROVE_PLAN = "APPROVE_PLAN";
    public static final String REJECT_PLAN = "REJECT_PLAN";

    public static final String CONFIG_YEAR_PLAN_WORKFLOW = "CONFIG_YEAR_PLAN_WORKFLOW";

    public static final String ACTIVITY_MGT = "ACTIVITY_MGT";

    /**
     * 资源管理
     */
    public static final String RES_MGT = "RES_MGT";
    public static final String VIEW_RESCATA = "VIEW_RESCATA";
    public static final String ADD_RESCATA = "ADD_RESCATA";
    public static final String EDIT_RESCATA = "EDIT_RESCATA";
    public static final String ADD_RES = "ADD_RES";
    public static final String EDIT_RES = "EDIT_RES";
    public static final String RES_EXACT_SEARCH = "RES_EXACT_SEARCH";

    public static final String COS_MGT = "COS_MGT";
    public static final String COS_CLASS_MGT = "COS_CLASS_MGT";
    public static final String COS_ONLINE_MGT = "COS_ONLINE_MGT";
    public static final String COS_PROJECT_MGT = "COS_PROJECT_MGT";

    public static final String TEACHING_MGT = "TEACHING_MGT";
    public static final String TEACHING_RES_MGT = "TEACHING_RES_MGT";
    public static final String TEACHING_COURSE_MGT = "TEACHING_COURSE_MGT";

    /**
     * 考试管理
     */
    public static final String EXAM_MGT = "EXAM_MGT";

    /**
     * 题目管理
     */
    public static final String QUE_MGT = "QUE_MGT";
    public static final String VIRW_QUESTION = "VIRW_QUESTION";
    public static final String ADD_QUECATALOG = "ADD_QUECATALOG";
    public static final String EDIT_QUECATALOG = "EDIT_QUECATALOG";
    public static final String ADD_TEST_QUESTION = "ADD_TEST_QUESTION";
    public static final String EDIT_TEST_QUESTION = "EDIT_TEST_QUESTION";
    public static final String ADD_NAIRED_QUESTION = "ADD_NAIRED_QUESTION";
    public static final String EDIT_NAIRED_QUESTION = "EDIT_NAIRED_QUESTION";
    public static final String EDIT_QUESTION = "EDIT_QUESTION";
    public static final String IMPORT_QUESTION = "IMPORT_QUESTION";
    public static final String EXPORT_QUESTION = "EXPORT_QUESTION";

    /**
     * 试卷管理
     */
    public static final String TEST_MGT = "TEST_MGT";
    public static final String VIEW_TEST = "VIEW_TEST";
    public static final String ADD_TESTCATALOG = "ADD_TESTCATALOG";
    public static final String EDIT_TESTCATALOG = "EDIT_TESTCATALOG";
    public static final String ADD_TEST = "ADD_TEST";
    public static final String EDIT_TEST = "EDIT_TEST";
    public static final String EXPORT_TEST = "EXPORT_TEST";

    /**
     * 报名审批
     */
    public static final String ENROLL_APPROVAL = "ENROLL_APPROVAL";
    public static final String VIEW_ENROLL_APPROVAL = "VIEW_ENROLL_APPROVAL";

    /**
     * 组织架构管理
     */
    public static final String SYS_MGT = "SYS_MGT";
    public static final String ORG_STRUCT = "ORG_STRUCT";
    public static final String VIEW_ORG = "VIEW_ORG";
    public static final String ADD_ORG = "ADD_ORG";
    public static final String EDIT_ORG = "EDIT_ORG";
    public static final String ADD_USER = "ADD_USER";
    public static final String EDIT_USER = "EDIT_USER";
    public static final String INACTIVE_USER_MGT = "INACTIVE_USER_MGT";
    public static final String IMPORT_USER = "IMPORT_USER";
    public static final String EXPORT_USER = "EXPORT_USER";
    public static final String RESET_USER_PWD = "RESET_USER_PWD";
    public static final String USER_EXACT_SEARCH = "USER_EXACT_SEARCH";

    public static final String ROL_RIGTH = "ROL_RIGTH";
    public static final String ADD_ROLE = "ADD_ROLE";
    public static final String EDIT_ROLE = "EDIT_ROLE";

    /**
     * 工作流管理
     */
    public static final String WORKFLOW_MGT = "WORKFLOW_MGT";
    public static final String VIEW_WORKFLOW = "VIEW_WORKFLOW";
    public static final String ADD_WORKFLOW = "ADD_WORKFLOW";
    public static final String EDIT_WORKFLOW = "EDIT_WORKFLOW";

    public static final String ACTIVE_USER_MGT = "ACTIVE_USER_MGT";

    public static final String COURSE_SELECTION = "COURSE_SELECTION";
    public static final String COURSE_CATEGORY = "COURSE_CATEGORY";
    public static final String COURSE_KNOWLEDGE = "COURSE_KNOWLEDGE";

    public static final String PLANNING = "PLANNING";
    public static final String PERSONAL_PLANNING = "PERSONAL_PLANNING";
    public static final String POSITION_PLANNING = "POSITION_PLANNING";
    public static final String TRAINING_PLANNING = "TRAINING_PLANNING";
    public static final String TRAINING_PLANNING_YEAR = "TRAINING_PLANNING_YEAR";
    public static final String TRAINING_PLANNING_QUARTER = "TRAINING_PLANNING_QUARTER";
    public static final String TRAINING_PLANNING_MONTH = "TRAINING_PLANNING_MONTH";

    public static final String LEARNING = "LEARNING";
    public static final String RESOURCE = "RESOURCE";
    public static final String MYLEARNING = "MYLEARNING";
    public static final String MYCOURSE = "MYCOURSE";
    public static final String MYCLASS = "MYCLASS";
    public static final String MYPROJECT = "MYPROJECT";
    public static final String MYAPPROVAL = "MYAPPROVAL";
    public static final String CREDIT_RANK = "CREDIT_RANK";
    public static final String QUESTIONNAIRE_LRN = "QUESTIONNAIRE_LRN";
    public static final String SIMPLE_SEARCH = "SIMPLE_SEARCH";
    public static final String ADVANCE_SEARCH = "ADVANCE_SEARCH";
    public static final String POSITION_SKILL_LRN = "POSITION_SKILL_LRN";
    public static final String MYMOBILE = "MYMOBILE";

    public static final String EXAM = "EXAM";
    public static final String EXAM_CATETORY = "EXAM_CATETORY";
    public static final String EXAM_ONLINE = "EXAM_ONLINE";

    public static final String ZONE = "ZONE";
    public static final String NEWS = "NEWS";
    public static final String KNOWLEDGE = "KNOWLEDGE";
    public static final String FORUM = "FORUM";
    public static final String MY_SUBORDINATE = "MY_SUBORDINATE";
    public static final String MY_NOTE = "MY_NOTE";
    public static final String MY_COLLECT = "MY_COLLECT";
    public static final String MY_PHOTO = "USER_PHOTOALBUM";
    public static final String MY_GROUP = "MY_GROUP";
    public static final String MY_TASK = "MY_TASK";

    public static final String SKILL_GRADE = "SKILL_GRADE";
    public static final String SKILL = "SKILL";
    public static final String POSITION_SKILL = "POSITION_SKILL";

    /**
     * 需求调查问卷管理
     */
    public static final String REQUIRE_QUESTIONNAIRE = "REQUIRE_QUESTIONNAIRE";
    public static final String VIEW_REQUIRE_QUESTIONNAIRE = "VIEW_REQUIRE_QUESTIONNAIRE";
    public static final String ADD_REQUIRE_QUESTIONNAIRE = "ADD_REQUIRE_QUESTIONNAIRE";
    public static final String EDIT_REQUIRE_QUESTIONNAIRE = "EDIT_REQUIRE_QUESTIONNAIRE";
    public static final String EXPORT_REQUIRE_QUESTIONNAIRE = "EXPORT_REQUIRE_QUESTIONNAIRE";

    /**
     * 技能等级库
     */
    public static final String VIEW_GRADE = "VIEW_GRADE";
    public static final String ADD_GRADE = "ADD_GRADE";
    public static final String EDIT_GRADE = "EDIT_GRADE";

    /**
     * 技能要素
     */
    public static final String VIEW_SKILL = "VIEW_SKILL";
    public static final String ADD_SKILL = "ADD_SKILL";
    public static final String EDIT_SKILL = "EDIT_SKILL";
    public static final String ADD_SKILL_CATEGORY = "ADD_SKILL_CATEGORY";
    public static final String EDIT_SKILL_CATEGORY = "EDIT_SKILL_CATEGORY";

    /**
     * 讲师管理
     */
    public static final String TEACH_MGT = "TEACH_MGT";
    public static final String VIEW_TEACHER = "VIEW_TEACHER";
    public static final String ADD_TEACHER = "ADD_TEACHER";
    public static final String EDIT_TEACHER = "EDIT_TEACHER";

    /**
     * 积分管理
     */
    public static final String CREDIT_MGT = "CREDIT_MGT";
    public static final String VIEW_CREDIT = "VIEW_CREDIT";
    public static final String AUTO_CREDIT = "AUTO_CREDIT";
    public static final String MANUAL_CREDIT = "MANUAL_CREDIT";
    public static final String MANUAL_REDUCE_CREDIT = "MANUAL_REDUCE_CREDIT";

    public static final String ZONE_MGT = "ZONE_MGT";
    public static final String KNL_MGT = "KNL_MGT";
    public static final String ADD_KNL = "ADD_KNL";
    public static final String EDIT_KNL = "EDIT_KNL";
    public static final String EDIT_KNOWQUE = "EDIT_KNOWQUE";
    public static final String VIEW_KNOWQUE_LIST = "VIEW_KNOWQUE_LIST";

    /**
     * 学习动态管理
     */
    public static final String ANN_MGT = "ANN_MGT";
    public static final String VIEW_ANN = "VIEW_ANN";
    public static final String ADD_ANN = "ADD_ANN";
    public static final String EDIT_ANN = "EDIT_ANN";

    public static final String FORUM_MGT = "FORUM_MGT";
    public static final String ADD_FORUM = "ADD_FORUM";
    public static final String EDIT_FORUM = "EDIT_FORUM";

    public static final String RECOMMENDED = "RECOMMENDED";

    /**
     * 宣传栏管理
     */
    public static final String POSTER_MGT = "POSTER_MGT";
    public static final String VIEW_POSTER = "VIEW_POSTER";
    public static final String ADD_POSTER = "ADD_POSTER";
    public static final String EDIT_POSTER = "EDIT_POSTER";

    /**
     * 友情链接管理
     */
    public static final String FRIENDLINK_MGT = "FRIENDLINK_MGT";
    public static final String VIEW_FRIENDLINK = "VIEW_FRIENDLINK";
    public static final String ADD_FRIENDLINK = "ADD_FRIENDLINK";
    public static final String EDIT_FRIENDLINK = "EDIT_FRIENDLINK";
    public static final String FRIENDLINK_SHOW = "FRIENDLINK_SHOW";

    /**
     * 培训设施管理
     */
    public static final String FACILITY_MGT = "FACILITY_MGT";
    public static final String VIEW_FACILITY = "VIEW_FACILITY";
    public static final String ADD_FACILITY = "ADD_FACILITY";
    public static final String EDIT_FACILITY = "EDIT_FACILITY";

    // 课程体系管理
    public static final String COS_CAT_MGT = "COS_CAT_MGT";
    public static final String VIEW_COS_CAT = "VIEW_COS_CAT";
    public static final String ADD_COS_CAT = "ADD_COS_CAT";
    public static final String EDIT_COS_CAT = "EDIT_COS_CAT";

    // 在线课程管理
    public static final String VIEW_COS_ONLINE = "VIEW_COS_ONLINE";
    public static final String ADD_COS_ONLINE = "ADD_COS_ONLINE";
    public static final String DEL_COS_ONLINE = "DEL_COS_ONLINE";
    public static final String EDIT_COS_ONLINE = "EDIT_COS_ONLINE";
    public static final String IMPORT_COS_ONLINE = "IMPORT_COS_ONLINE";
    public static final String COPY_COS_ONLINE = "COPY_COS_ONLINE";
    public static final String COS_ONLINE_DEFINITION = "COS_ONLINE_DEFINITION";
    public static final String COS_ONLINE_BASIC = "COS_ONLINE_BASIC";
    public static final String COS_ONLINE_PUBLISH = "COS_ONLINE_PUBLISH";
    public static final String COS_ONLINE_SCORE_SETUP = "COS_ONLINE_SCORE_SETUP";
    public static final String COS_ONLINE_PREREQUISITE = "COS_ONLINE_PREREQUISITE";
    public static final String COS_ONLINE_CONTENT = "COS_ONLINE_CONTENT";
    public static final String COS_ONLINE_PRECOURSE = "COS_ONLINE_PRECOURSE";
    public static final String COS_ONLINE_CONTENT_LIST = "COS_ONLINE_CONTENT_LIST";
    public static final String COS_ONLINE_ASSIGNMENT = "COS_ONLINE_ASSIGNMENT";
    public static final String COS_ONLINE_AFCOURSE = "COS_ONLINE_AFCOURSE";
    public static final String COS_ONLINE_SURVEY = "COS_ONLINE_SURVEY";
    public static final String COS_ONLINE_SCORING = "COS_ONLINE_SCORING";
    public static final String COS_ONLINE_COMPLETED_CONDITION = "COS_ONLINE_COMPLETED_CONDITION";
    public static final String COS_ONLINE_ENROLL = "COS_ONLINE_ENROLL";
    public static final String COS_ONLINE_ENROLL_SETUP = "COS_ONLINE_ENROLL_SETUP";
    public static final String COS_ONLINE_ENROLL_LIST = "COS_ONLINE_ENROLL_LIST";
    public static final String COS_ONLINE_AUTO_ENROLL = "COS_ONLINE_AUTO_ENROLL";
    public static final String COS_ONLINE_STATE = "COS_ONLINE_STATE";
    public static final String COS_ONLINE_STATE_BYUSER = "COS_ONLINE_STATE_BYUSER";
    public static final String COS_ONLINE_STATE_BYMODULE = "COS_ONLINE_STATE_BYMODULE";

    // 培训班管理
    public static final String VIEW_COS_CLASS = "VIEW_COS_CLASS";
    public static final String ADD_COS_CLASS = "ADD_COS_CLASS";
    public static final String DEL_COS_CLASS = "DEL_COS_CLASS";
    public static final String EDIT_COS_CLASS = "EDIT_COS_CLASS";
    public static final String IMPORT_COS_CLASS = "IMPORT_COS_CLASS";
    public static final String COPY_COS_CLASS = "COPY_COS_CLASS";
    public static final String COS_CLASS_DEFINITION = "COS_CLASS_DEFINITION";
    public static final String COS_CLASS_BASIC = "COS_CLASS_BASIC";
    public static final String COS_CLASS_PUBLISH = "COS_CLASS_PUBLISH";
    public static final String COS_CLASS_SCORE_SETUP = "COS_CLASS_SCORE_SETUP";
    public static final String COS_CLASS_PREREQUISITE = "COS_CLASS_PREREQUISITE";
    public static final String COS_CLASS_CONTENT = "COS_CLASS_CONTENT";
    public static final String COS_CLASS_FACILITY = "COS_CLASS_FACILITY";
    public static final String COS_CLASS_COST = "COS_CLASS_COST";
    public static final String COS_CLASS_TRAIN_SCHEDULE = "COS_CLASS_TRAIN_SCHEDULE";
    public static final String COS_CLASS_CONTENT_LIST = "COS_CLASS_CONTENT_LIST";
    public static final String COS_CLASS_SURVEY = "COS_CLASS_SURVEY";
    public static final String COS_CLASS_ENROLL = "COS_CLASS_ENROLL";
    public static final String COS_CLASS_ENROLL_SETUP = "COS_CLASS_ENROLL_SETUP";
    public static final String COS_CLASS_ENROLL_LIST = "COS_CLASS_ENROLL_LIST";
    public static final String COS_CLASS_AUTO_ENROLL = "COS_CLASS_AUTO_ENROLL";
    public static final String COS_CLASS_STATE = "COS_CLASS_STATE";
    public static final String COS_CLASS_STATE_BYUSER = "COS_CLASS_STATE_BYUSER";
    public static final String COS_CLASS_STATE_BYMODULE = "COS_CLASS_STATE_BYMODULE";

    // 学习项目管理
    public static final String VIEW_COS_PROJECT = "VIEW_COS_PROJECT";
    public static final String ADD_COS_PROJECT = "ADD_COS_PROJECT";
    public static final String DEL_COS_PROJECT = "DEL_COS_PROJECT";
    public static final String EDIT_COS_PROJECT = "EDIT_COS_PROJECT";
    public static final String IMPORT_COS_PROJECT = "IMPORT_COS_PROJECT";
    public static final String COPY_COS_PROJECT = "COPY_COS_PROJECT";
    public static final String COS_PROJECT_DEFINITION = "COS_PROJECT_DEFINITION";
    public static final String COS_PROJECT_BASIC = "COS_PROJECT_BASIC";
    public static final String COS_PROJECT_PUBLISH = "COS_PROJECT_PUBLISH";
    public static final String COS_PROJECT_SCORE_SETUP = "COS_PROJECT_SCORE_SETUP";
    public static final String COS_PROJECT_PREREQUISITE = "COS_PROJECT_PREREQUISITE";
    public static final String COS_PROJECT_CONTENT = "COS_PROJECT_CONTENT";
    public static final String COS_PROJECT_COS_SETUP = "COS_PROJECT_COS_SETUP";
    public static final String COS_PROJECT_ENROLL = "COS_PROJECT_ENROLL";
    public static final String COS_PROJECT_ENROLL_SETUP = "COS_PROJECT_ENROLL_SETUP";
    public static final String COS_PROJECT_ENROLL_LIST = "COS_PROJECT_ENROLL_LIST";
    public static final String COS_PROJECT_AUTO_ENROLL = "COS_PROJECT_AUTO_ENROLL";
    public static final String COS_PROJECT_STATE = "COS_PROJECT_STATE";
    public static final String COS_PROJECT_STATE_BYUSER = "COS_PROJECT_STATE_BYUSER";

    // 在线考试管理
    public static final String ONLINE_EXAM_MGT = "ONLINE_EXAM_MGT";
    public static final String ADD_ONLINE_EXAM_CATALOG = "ADD_ONLINE_EXAM_CATALOG";
    public static final String EDIT_ONLINE_EXAM_CATALOG = "EDIT_ONLINE_EXAM_CATALOG";
    public static final String VIEW_ONLINE_EXAM = "VIEW_ONLINE_EXAM";
    public static final String ADD_ONLINE_EXAM = "ADD_ONLINE_EXAM";
    public static final String EDIT_ONLINE_EXAM = "EDIT_ONLINE_EXAM";
    public static final String DEL_ONLINE_EXAM = "DEL_ONLINE_EXAM";
    public static final String COPY_ONLINE_EXAM = "COPY_ONLINE_EXAM";
    public static final String EXAM_ONLINE_DEFINITION = "EXAM_ONLINE_DEFINITION";
    public static final String EXAM_ONLINE_BASIC = "EXAM_ONLINE_BASIC";
    public static final String EXAM_ONLINE_PUBLISH = "EXAM_ONLINE_PUBLISH";
    public static final String EXAM_ONLINE_SCORE_SETUP = "EXAM_ONLINE_SCORE_SETUP";
    public static final String EXAM_ONLINE_PREREQUISITE = "EXAM_ONLINE_PREREQUISITE";
    public static final String EXAM_ONLINE_CONTENT = "EXAM_ONLINE_CONTENT";
    public static final String EXAM_ONLINE_ENROLL = "EXAM_ONLINE_ENROLL";
    public static final String EXAM_ONLINE_ENROLL_SETUP = "EXAM_ONLINE_ENROLL_SETUP";
    public static final String EXAM_ONLINE_ENROLL_LIST = "EXAM_ONLINE_ENROLL_LIST";
    public static final String EXAM_ONLINE_AUTO_ENROLL = "EXAM_ONLINE_AUTO_ENROLL";
    public static final String EXAM_ONLINE_STATE = "EXAM_ONLINE_STATE";
    public static final String EXAM_ONLINE_STATE_BYUSER = "EXAM_ONLINE_STATE_BYUSER";
    public static final String EXAM_ONLINE_STATE_BYMODULE = "EXAM_ONLINE_STATE_BYMODULE";
    public static final String MONITOR_ONLINE_EXAM = "MONITOR_ONLINE_EXAM";

    //报表管理
    public static final String REPORT_MGT = "REPORT_MGT";
    public static final String REPORT_LIST = "REPORT_LIST";

    //外训申请与审批
    public static final String EXT_TRA_LRN = "EXT_TRA_LRN";
    public static final String EXT_TRA_MGT = "EXT_TRA_MGT";
    public static final String EXT_TRA_VIEW = "EXT_TRA_VIEW";
    public static final String EXT_TRA_EDIT = "EXT_TRA_EDIT";
    public static final String EXT_TRA_EXPORT = "EXT_TRA_EXPORT";
    public static final String CONFIG_EXT_TRA_WORKFLOW = "CONFIG_EXT_TRA_WORKFLOW";

    //讲师课程申报
    public static final String TEACHER_COURSE_APPLY_LRN = "TEACHER_COURSE_APPLY_LRN";

    //课程审批
    //管理员
    public static final String COURSE_APPLY_MGT = "COURSE_APPLY_MGT";
    public static final String COURSE_APPLY_VIRW = "COURSE_APPLY_VIRW";
    public static final String COURSE_APPLY_EDIT = "COURSE_APPLY_EDIT";
    public static final String COURSE_APPLY_EXPORT = "COURSE_APPLY_EXPORT";
    public static final String CONFIG_COURSE_APPLY_WORKFLOW = "CONFIG_COURSE_APPLY_WORKFLOW";
    //讲师
    public static final String TEACHER_COURSE_APPLY = "TEACHER_COURSE_APPLY";
    public static final String TEACHER_COURSE_APPLY_ADD = "TEACHER_COURSE_APPLY_ADD";
    public static final String TEACHER_COURSE_APPLY_EDIT = "TEACHER_COURSE_APPLY_EDIT";
    //供应商管理
    public static final String SUPPLIER_MGT = "SUPPLIER_MGT";
    public static final String SUPPLIER_ADD = "ADD_SUPPLIER";
    public static final String SUPPLIER_EDIT = "EDIT_SUPPLIER";
    // 定时任务管理
    public static final String SCHEDULER_MGT = "SCHEDULER_MGT";
    //问吧
    public static final String ASK_MGT = "ASK_MGT";
    public static final String ADD_FAQ = "ADD_FAQ";
    public static final String EDIT_FAQ = "EDIT_FAQ";

    //移动课程管理
    public static final String COS_MOBILE_MGT = "COS_MOBILE_MGT";
    public static final String VIEW_COS_MOBILE = "VIEW_COS_MOBILE";
    public static final String ADD_COS_MOBILE = "ADD_COS_MOBILE";
    public static final String EDIT_COS_MOBILE = "EDIT_COS_MOBILE";
    public static final String COS_MOBILE_DEFINITION = "COS_MOBILE_DEFINITION";
    public static final String COS_MOBILE_BASIC = "COS_MOBILE_BASIC";
    public static final String COS_MOBILE_PUBLISH = "COS_MOBILE_PUBLISH";
    public static final String COS_MOBILE_CONTENT = "COS_MOBILE_CONTENT";
    public static final String COS_MOBILE_CONTENT_LIST = "COS_MOBILE_CONTENT_LIST";
    public static final String COS_MOBILE_SCORING = "COS_MOBILE_SCORING";
    public static final String COS_MOBILE_COMPLETED_CONDITION = "COS_MOBILE_COMPLETED_CONDITION";
    public static final String COS_MOBILE_PREREQUISITE = "COS_MOBILE_PREREQUISITE";
    public static final String COS_MOBILE_ENROLL = "COS_MOBILE_ENROLL";
    public static final String COS_MOBILE_ENROLL_SETUP = "COS_MOBILE_ENROLL_SETUP";
    public static final String COS_MOBILE_ENROLL_LIST = "COS_MOBILE_ENROLL_LIST";
    public static final String COS_MOBILE_AUTO_ENROLL = "COS_MOBILE_AUTO_ENROLL";
    public static final String COS_MOBILE_STATE = "COS_MOBILE_STATE";
    public static final String COS_MOBILE_STATE_BYUSER = "COS_MOBILE_STATE_BYUSER";
    public static final String COS_MOBILE_STATE_BYMODULE = "COS_MOBILE_STATE_BYMODULE";
    public static final String DEL_COS_MOBILE = "DEL_COS_MOBILE";
    //达人管理
    public static final String TALENT_MGT = "TALENT_MGT";
    public static final String TALENT_ADD = "ADD_TALENT";
    public static final String TALENT_EDIT = "EDIT_TALENT";
    public static final String TALENT_CREIDT = "SET_TALENT_CREDIT";
    //专家管理
    public static final String EXPERTS_MGT = "EXPERTS_MGT";
    public static final String EXPERTS_ADD = "ADD_EXPERTS";
    public static final String EXPERTS_EDIT = "EDIT_EXPERTS";
    // 目标学员体系管理
    public static final String PAR_CAT_MGT = "PARTICIPANTSCATA_MGT";
    public static final String VIEW_PAR_CAT = "VIEW_PARTICIPANTSCATA";
    public static final String ADD_PAR_CAT = "ADD_PARTICIPANTSCATA";
    public static final String EDIT_PAR_CAT = "EDIT_PARTICIPANTSCATA";

    //目标学员管理
    public static final String PARTICIPANTS_MGT = "PARTICIPANTS_MGT";
    public static final String VIEW_PARTICIPANTS = "VIEW_PARTICIPANTS";
    public static final String ADD_PARTICIPANTS = "ADD_PARTICIPANTS";
    public static final String EDIT_PARTICIPANTS = "EDIT_PARTICIPANTS";

    //项目基本信息管理
    public static final String PROJECT_MGT = "PROJECT_MGT";
    public static final String VIEW_PROJECT = "VIEW_PROJECT";
    public static final String ADD_PROJECT = "ADD_PROJECT";
    public static final String EDIT_RROJECT = "EDIT_PROJECT";

    //专题
    public static final String PROJECT_ADD_SPECIAL_MGT = "PROJECT_ADD_SPECIAL_MGT";
    public static final String PROJECT_EDIT_SPECIAL_MGT = "PROJECT_EDIT_SPECIAL_MGT";
    public static final String SPECIAL_MGT = "SPECIAL_MGT";
    public static final String VIEW_SPECIAL = "VIEW_SPECIAL";
    public static final String ADD_SPECIAL = "ADD_SPECIAL";
    public static final String EDIT_SPECIAL = "EDIT_SPECIAL";

    //日志管理
    public static final String LOG_FILE_MGT = "LOG_FILE_MGT";
    /**
     * APP管理
     */
    public static final String APP_MGT = "APP_MGT";
    public static final String VIEW_APP = "VIEW_APP";
    public static final String ADD_APP = "ADD_APP";
    public static final String EDIT_APP = "EDIT_APP";

    private String code;
    private String labelname;
    private int parentid;
    private int orderid;
    private String url;
    private int menuind;
    private Timestamp lstupdated;
    private String imgname;
    private String iconname;
    private String name;
    private String lowiconname;

    private List<Permission> subPermissionLst = Lists.newArrayList();

    public Permission() {
    }

    public Permission(String code, int menuind, Timestamp lstupdated) {
        super();
        this.code = code;
        this.menuind = menuind;
        this.lstupdated = lstupdated;
    }

    @Column(nullable = false, unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(nullable = false)
    public int getMenuind() {
        return menuind;
    }

    public void setMenuind(int menuind) {
        this.menuind = menuind;
    }

    @Column(nullable = false)
    public Timestamp getLstupdated() {
        return lstupdated;
    }

    public void setLstupdated(Timestamp lstupdated) {
        this.lstupdated = lstupdated;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getIconname() {
        return iconname;
    }

    public void setIconname(String iconname) {
        this.iconname = iconname;
    }

    @Transient
    public List<Permission> getSubPermissionLst() {
        return subPermissionLst;
    }

    public void setSubPermissionLst(List<Permission> subPermissionLst) {
        this.subPermissionLst = subPermissionLst;
    }

    @Transient
    public String getPrefixedName() {
        return AUTHORITY_PREFIX + code;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Transient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public String getLowiconname() {
        return lowiconname;
    }

    public void setLowiconname(String lowiconname) {
        this.lowiconname = lowiconname;
    }

    public int compareTo(Permission arg0) {
        return Integer.valueOf(this.getOrderid()).compareTo(Integer.valueOf(arg0.getOrderid()));
    }
}
