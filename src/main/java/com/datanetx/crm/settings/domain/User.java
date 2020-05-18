package com.datanetx.crm.settings.domain;

public class User {
    /**
     * 关于字符串中表现的日期及时间，我们在市场上常用用的有两种方式：
     * 1.日期：年月日。yyyy-MM-dd 10位字符串
     * 2.日期+时间：年月日时分秒。yyyy-MM-dd HH:mm:ss 19位字符串
     *
     * 关于登录：
     * 1.验证账号和密码。
     *   User user = 执行sql语句select * from tbl_user where loginAct=? and loginPwd=?
     *   user对象为null，说明账号密码错误。如果user对象不为null，表示账号、密码正确，需要向下验证其他字段信息
     *   从user中get到expireTime验证是否过期、lockState验证账号是否被锁定、allowIps验证是否是允许的IP
     */

    private java.lang.String id;//编号 主键
    private java.lang.String loginAct;//登录账号
    private java.lang.String name;//用户的真实姓名
    private java.lang.String loginPwd;//登录密码
    private java.lang.String email;//邮箱
    private java.lang.String expireTime;//失效时间 19位
    private java.lang.String lockState;//锁定状态 0：锁定  1：启用
    private java.lang.String deptno;//部门编号
    private java.lang.String allowIps;//允许访问的ip地址
    private java.lang.String createTime;//创建时间 19位
    private java.lang.String createBy;//创建人
    private java.lang.String editTime;//修改时间 19位
    private java.lang.String editBy;//修改人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getLockState() {
        return lockState;
    }

    public void setLockState(String lockState) {
        this.lockState = lockState;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getAllowIps() {
        return allowIps;
    }

    public void setAllowIps(String allowIps) {
        this.allowIps = allowIps;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}
