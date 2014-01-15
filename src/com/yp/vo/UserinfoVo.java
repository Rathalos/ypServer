/**
 * 用户信息
 */

package com.yp.vo;

public class UserinfoVo {

    public UserinfoVo(){}

    // 用户ID
    private int userId = 0;
    
    // 昵称
    private String nickName = "";
    
    // 年龄
    private int age = 0;
    
    // 性别
    private String gender = "";
    
    // 学校ID
    private String compus = "";
    
    // 照片URL
    private String photoUrl = "";
    
    // 证件URL
    private String documentUrl = "";
    
    // 邮箱
    private String email = "";
    
    // 创建时间
    private int createAt = 0;
    
    // 更新时间
    private int updateAt = 0;
    
    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the compus
     */
    public String getCompus() {
        return compus;
    }

    /**
     * @param compus the compus to set
     */
    public void setCompus(String compus) {
        this.compus = compus;
    }

    /**
     * @return the photoUrl
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * @param photoUrl the photoUrl to set
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    /**
     * @return the documentUrl
     */
    public String getDocumentUrl() {
        return documentUrl;
    }

    /**
     * @param documentUrl the documentUrl to set
     */
    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the createAt
     */
    public int getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt the createAt to set
     */
    public void setCreateAt(int createAt) {
        this.createAt = createAt;
    }

    /**
     * @return the updateAt
     */
    public int getUpdateAt() {
        return updateAt;
    }

    /**
     * @param updateAt the updateAt to set
     */
    public void setUpdateAt(int updateAt) {
        this.updateAt = updateAt;
    }
}
