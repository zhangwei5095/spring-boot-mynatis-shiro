package cn.elvea.domain;

import cn.elvea.core.domain.BaseEntity;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 */
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_FREEZED = "FREEZED";
    public static final String STATUS_EXPIRED = "EXPIRED";
    public static final String STATUS_DELETED = "DELETED";
    public static final String STATUS_OK = "OK";
    private String employeeNumber;
    private String username;
    private String nickname;
    private String firstname;
    private String lastname;
    private String password;
    private String sex;
    private Timestamp birthday;
    private String email;
    private String mobilephone;
    private String telephone;
    private String fax;
    private Timestamp jobjoindate;
    private Timestamp jobformaldate;
    private String degree;
    private String msn;
    private String address;
    private String img;
    private String description;
    private Timestamp startdate;
    private Timestamp enddate;
    private int creditpoint;
    private int loginfailedcount;
    private int synind;
    private String status;
    private int active;
    private int creator;
    private Timestamp createdate;
    private int modifiedby;
    private Timestamp modifieddate;
    private int praisecount;
    private String signature;
    private String backgroundimg;
    private String openid;//微信用户id
    private Timestamp signtime; // 用户通过微信签到的时间
    private String wxnum; // 微信号
    private Date updatepwddate; // 用户修改密码的时间
    /**
     * 注册类型
     */
    private String registrtype;
    //组织架构
    private List<Organization> orglst = Lists.newArrayList();
    private String orgidlst;
    private String orgnamelst;
    //用户岗位
    private List<Position> posLst = Lists.newArrayList();
    private String posidlst;
    private String posnamelst;
    //角色
    private List<Role> rolelst = Lists.newArrayList();
    private String rolenamelst;
    //直属领导
    private List<User> supervisorlst = Lists.newArrayList();
    private String supervisoridlst;
    private String supervisornamelst;
    //下属机构
    private List<Organization> subsidiarylst = Lists.newArrayList();
    private String subsidiaryidlst;
    private String subsidiarynamelst;
    /**
     * 以下几个参数搜索条件用
     */
    private Timestamp birthday_start;
    private Timestamp birthday_end;
    private Timestamp jobjoindate_start;
    private Timestamp jobjoindate_end;
    private Timestamp jobformaldate_start;
    private Timestamp jobformaldate_end;
    //用户喜好
    private UserPreferences preferences;

    // 图标文件
    private String imgFullpath;
    private File[] fileImg;
    private String[] fileImgContentType;
    private String[] fileImgFileName;
    private String birthdayStr;
    private String jobjoindateStr;
    private String jobformaldateStr;
    private String startdateStr;
    private String enddateStr;

    private int agentUserId;
    private String agentUserName;
    private String agentEmployeeNumber;
    private Timestamp agentStartDate;
    private Timestamp agentEndDate;

    //背景图片
    private File[] fileBgImg;
    private String[] fileBgImgContentType;
    private String[] fileBgImgFileName;
    /**
     * 密码明文
     */
    private String originalPassword;

    public User() {
    }

    public User(int active, String status, String employeenumber,
                int synind, String username) {
        super();
        this.active = active;
        this.status = status;
        this.employeeNumber = employeenumber;
        this.synind = synind;
        this.username = username;
    }

    @Column(nullable = false)
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeenumber) {
        this.employeeNumber = employeenumber;
    }

    @Column(nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Timestamp getJobjoindate() {
        return jobjoindate;
    }

    public void setJobjoindate(Timestamp jobjoindate) {
        this.jobjoindate = jobjoindate;
    }

    public Timestamp getJobformaldate() {
        return jobformaldate;
    }

    public void setJobformaldate(Timestamp jobformaldate) {
        this.jobformaldate = jobformaldate;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    @Column(nullable = false)
    public int getSynind() {
        return synind;
    }

    public void setSynind(int synind) {
        this.synind = synind;
    }

    public int getCreditpoint() {
        return creditpoint;
    }

    public void setCreditpoint(int creditpoint) {
        this.creditpoint = creditpoint;
    }

    public int getLoginfailedcount() {
        return loginfailedcount;
    }

    public void setLoginfailedcount(int loginfailedcount) {
        this.loginfailedcount = loginfailedcount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(nullable = false)
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public int getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(int modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Timestamp getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }

    //多对多定义
    @ManyToMany(fetch = FetchType.LAZY)
    //中间表定义,表名采用默认命名规则
    @JoinTable(name = "USERROLES", joinColumns = {@JoinColumn(name = "userid")}, inverseJoinColumns = {@JoinColumn(name = "roleid")})
    //Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    //集合按id排序.
    @OrderBy("id")
    public List<Role> getRolelst() {
        return rolelst;
    }

    public void setRolelst(List<Role> rolelst) {
        this.rolelst = rolelst;
    }

    @Transient
    public String getRolenamelst() {
        return rolenamelst;
    }

    public void setRolenamelst(String rolenamelst) {
        this.rolenamelst = rolenamelst;
    }

    @Transient
    @SuppressWarnings("unchecked")
    public List<Long> getRoleidlst() {
        return Lists.newArrayList();
//        return ConvertUtils.convertElementPropertyToList(this.getRolelst(), "id");
    }

    @Transient
    public List<Organization> getOrglst() {
        return orglst;
    }

    public void setOrglst(List<Organization> orglst) {
        this.orglst = orglst;
    }

    @Transient
    public String getOrgidlst() {
        return orgidlst;
    }

    public void setOrgidlst(String orgidlst) {
        this.orgidlst = orgidlst;
    }

    @Transient
    public String getOrgnamelst() {
        return orgnamelst;
    }

    public void setOrgnamelst(String orgnamelst) {
        this.orgnamelst = orgnamelst;
    }

    @Transient
    public List<Position> getPosLst() {
        return posLst;
    }

    public void setPosLst(List<Position> posLst) {
        this.posLst = posLst;
    }

    @Transient
    public String getPosidlst() {
        return posidlst;
    }

    public void setPosidlst(String posidlst) {
        this.posidlst = posidlst;
    }

    @Transient
    public String getPosnamelst() {
        return posnamelst;
    }

    public void setPosnamelst(String posnamelst) {
        this.posnamelst = posnamelst;
    }

    //多对多定义
    @ManyToMany(fetch = FetchType.LAZY)
    //中间表定义,表名采用默认命名规则
    @JoinTable(name = "USERDIRECTSUPERVISOR", joinColumns = {@JoinColumn(name = "userid")}, inverseJoinColumns = {@JoinColumn(name = "supervisoruserid")})
    //Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    //集合按id排序.
    @OrderBy("id")
    public List<User> getSupervisorlst() {
        return supervisorlst;
    }

    public void setSupervisorlst(List<User> supervisorlst) {
        this.supervisorlst = supervisorlst;
    }

    @Transient
    public String getSupervisoridlst() {
        return supervisoridlst;
    }

    public void setSupervisoridlst(String supervisoridlst) {
        this.supervisoridlst = supervisoridlst;
    }

    @Transient
    public String getSupervisornamelst() {
        return supervisornamelst;
    }

    public void setSupervisornamelst(String supervisornamelst) {
        this.supervisornamelst = supervisornamelst;
    }

    //多对多定义
    @ManyToMany(fetch = FetchType.LAZY)
    //中间表定义,表名采用默认命名规则
    @JoinTable(name = "ORGUNITHEAD", joinColumns = {@JoinColumn(name = "headuserid")}, inverseJoinColumns = {@JoinColumn(name = "orgunitid")})
    //Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    //集合按id排序.
    @OrderBy("id")
    public List<Organization> getSubsidiarylst() {
        return subsidiarylst;
    }

    public void setSubsidiarylst(List<Organization> subsidiarylst) {
        this.subsidiarylst = subsidiarylst;
    }

    @Transient
    public String getSubsidiaryidlst() {
        return subsidiaryidlst;
    }

    public void setSubsidiaryidlst(String subsidiaryidlst) {
        this.subsidiaryidlst = subsidiaryidlst;
    }

    @Transient
    public String getSubsidiarynamelst() {
        return subsidiarynamelst;
    }

    public void setSubsidiarynamelst(String subsidiarynamelst) {
        this.subsidiarynamelst = subsidiarynamelst;
    }

    @Transient
    public Timestamp getBirthday_start() {
        return birthday_start;
    }

    public void setBirthday_start(Timestamp birthday_start) {
        this.birthday_start = birthday_start;
    }

    @Transient
    public Timestamp getBirthday_end() {
        return birthday_end;
    }

    public void setBirthday_end(Timestamp birthday_end) {
        this.birthday_end = birthday_end;
    }

    @Transient
    public Timestamp getJobjoindate_start() {
        return jobjoindate_start;
    }

    public void setJobjoindate_start(Timestamp jobjoindate_start) {
        this.jobjoindate_start = jobjoindate_start;
    }

    @Transient
    public Timestamp getJobjoindate_end() {
        return jobjoindate_end;
    }

    public void setJobjoindate_end(Timestamp jobjoindate_end) {
        this.jobjoindate_end = jobjoindate_end;
    }

    @Transient
    public Timestamp getJobformaldate_start() {
        return jobformaldate_start;
    }

    public void setJobformaldate_start(Timestamp jobformaldate_start) {
        this.jobformaldate_start = jobformaldate_start;
    }

    @Transient
    public Timestamp getJobformaldate_end() {
        return jobformaldate_end;
    }

    public void setJobformaldate_end(Timestamp jobformaldate_end) {
        this.jobformaldate_end = jobformaldate_end;
    }

    //一对一定义
    @OneToOne(fetch = FetchType.LAZY)
    //中间表定义,表名采用默认命名规则
    @PrimaryKeyJoinColumn
    //Fecth策略定义
    @Fetch(FetchMode.JOIN)
    //集合中对象id的缓存.
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    public UserPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(UserPreferences preferences) {
        this.preferences = preferences;
    }

    @Transient
    public File[] getFileImg() {
        return fileImg;
    }

    public void setFileImg(File[] fileImg) {
        this.fileImg = fileImg;
    }

    @Transient
    public String[] getFileImgContentType() {
        return fileImgContentType;
    }

    public void setFileImgContentType(String[] fileImgContentType) {
        this.fileImgContentType = fileImgContentType;
    }

    @Transient
    public String[] getFileImgFileName() {
        return fileImgFileName;
    }

    public void setFileImgFileName(String[] fileImgFileName) {
        this.fileImgFileName = fileImgFileName;
    }

    @Transient
    public String getImgFullpath() {
        return imgFullpath;
    }

    public void setImgFullpath(String imgFullpath) {
        this.imgFullpath = imgFullpath;
    }

    @Transient
    public String getOriginalPassword() {
        return originalPassword;
    }

    public void setOriginalPassword(String originalPassword) {
        this.originalPassword = originalPassword;
    }

    @Transient
    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    @Transient
    public String getJobjoindateStr() {
        return jobjoindateStr;
    }

    public void setJobjoindateStr(String jobjoindateStr) {
        this.jobjoindateStr = jobjoindateStr;
    }

    @Transient
    public String getJobformaldateStr() {
        return jobformaldateStr;
    }

    public void setJobformaldateStr(String jobformaldateStr) {
        this.jobformaldateStr = jobformaldateStr;
    }

    @Transient
    public String getStartdateStr() {
        return startdateStr;
    }

    public void setStartdateStr(String startdateStr) {
        this.startdateStr = startdateStr;
    }

    @Transient
    public String getEnddateStr() {
        return enddateStr;
    }

    public void setEnddateStr(String enddateStr) {
        this.enddateStr = enddateStr;
    }

    @Transient
    public int getAgentUserId() {
        return agentUserId;
    }

    public void setAgentUserId(int agentUserId) {
        this.agentUserId = agentUserId;
    }

    @Transient
    public String getAgentUserName() {
        return agentUserName;
    }

    public void setAgentUserName(String agentUserName) {
        this.agentUserName = agentUserName;
    }

    @Transient
    public String getAgentEmployeeNumber() {
        return agentEmployeeNumber;
    }

    public void setAgentEmployeeNumber(String agentEmployeeNumber) {
        this.agentEmployeeNumber = agentEmployeeNumber;
    }

    @Transient
    public Timestamp getAgentStartDate() {
        return agentStartDate;
    }

    public void setAgentStartDate(Timestamp agentStartDate) {
        this.agentStartDate = agentStartDate;
    }

    @Transient
    public Timestamp getAgentEndDate() {
        return agentEndDate;
    }

    public void setAgentEndDate(Timestamp agentEndDate) {
        this.agentEndDate = agentEndDate;
    }

    public int getPraisecount() {
        return praisecount;
    }

    public void setPraisecount(int praisecount) {
        this.praisecount = praisecount;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getBackgroundimg() {
        return backgroundimg;
    }

    public void setBackgroundimg(String backgroundimg) {
        this.backgroundimg = backgroundimg;
    }

    @Transient
    public File[] getFileBgImg() {
        return fileBgImg;
    }

    public void setFileBgImg(File[] fileBgImg) {
        this.fileBgImg = fileBgImg;
    }

    @Transient
    public String[] getFileBgImgContentType() {
        return fileBgImgContentType;
    }

    public void setFileBgImgContentType(String[] fileBgImgContentType) {
        this.fileBgImgContentType = fileBgImgContentType;
    }

    @Transient
    public String[] getFileBgImgFileName() {
        return fileBgImgFileName;
    }

    public void setFileBgImgFileName(String[] fileBgImgFileName) {
        this.fileBgImgFileName = fileBgImgFileName;
    }

    public String getRegistrtype() {
        return registrtype;
    }

    public void setRegistrtype(String registrtype) {
        this.registrtype = registrtype;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Timestamp getSigntime() {
        return signtime;
    }

    public void setSigntime(Timestamp signTime) {
        this.signtime = signTime;
    }

    public String getWxnum() {
        return wxnum;
    }

    public void setWxnum(String wxnum) {
        this.wxnum = wxnum;
    }

    public Date getUpdatepwddate() {
        return updatepwddate;
    }

    public void setUpdatepwddate(Date updatepwddate) {
        this.updatepwddate = updatepwddate;
    }
}
