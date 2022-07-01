package com.soft.blued.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.soft.blued.ui.login_register.model.BluedLoginResult;

@DatabaseTable(tableName = "UserAccountsModel")
public class UserAccountsModel {
  public static final String ACCOUNT_THREE_ONECLICK = "onclick";
  
  public static final String ACCOUNT_THREE_WEIXIN = "weixin";
  
  public static final int ACCOUNT_TYPE_EMAIL = 0;
  
  public static final int ACCOUNT_TYPE_PHONE = 1;
  
  public static final int ACCOUNT_TYPE_THREE = 2;
  
  @DatabaseField
  private String accessToken;
  
  @DatabaseField(defaultValue = "")
  private String aliasUserId;
  
  private BluedLoginResult bluedLoginResult;
  
  @DatabaseField
  private String extra;
  
  @DatabaseField(columnName = "id", generatedId = true)
  private int id;
  
  @DatabaseField
  private boolean isSycOk = false;
  
  @DatabaseField
  private long lastHandleTime;
  
  @DatabaseField(defaultValue = "0", index = true)
  private int loginType;
  
  @DatabaseField
  private String loginresult;
  
  @DatabaseField
  private String passwordSha;
  
  @DatabaseField(index = true)
  private String uid;
  
  @DatabaseField(index = true)
  private String username;
  
  public String getAccessToken() {
    return this.accessToken;
  }
  
  public String getAliasUserId() {
    return this.aliasUserId;
  }
  
  public BluedLoginResult getBluedLoginResult() {
    // Byte code:
    //   0: aload_0
    //   1: getfield bluedLoginResult : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   4: ifnonnull -> 30
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   13: aload_0
    //   14: invokevirtual a : (Lcom/soft/blued/db/model/UserAccountsModel;)Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   17: putfield bluedLoginResult : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   20: aload_0
    //   21: monitorexit
    //   22: goto -> 30
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: aload_0
    //   31: getfield bluedLoginResult : Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   34: areturn
    // Exception table:
    //   from	to	target	type
    //   9	22	25	finally
    //   26	28	25	finally
  }
  
  public String getExtra() {
    return this.extra;
  }
  
  public int getId() {
    return this.id;
  }
  
  public long getLastHandleTime() {
    return this.lastHandleTime;
  }
  
  public int getLoginType() {
    return this.loginType;
  }
  
  public String getLoginresult() {
    return this.loginresult;
  }
  
  public String getPasswordSha() {
    return this.passwordSha;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public boolean isSycOk() {
    return this.isSycOk;
  }
  
  public void setAccessToken(String paramString) {
    this.accessToken = paramString;
  }
  
  public void setAliasUserId(String paramString) {
    this.aliasUserId = paramString;
  }
  
  public void setBluedLoginResult(BluedLoginResult paramBluedLoginResult) {
    this.bluedLoginResult = paramBluedLoginResult;
  }
  
  public void setExtra(String paramString) {
    this.extra = paramString;
  }
  
  public void setId(int paramInt) {
    this.id = paramInt;
  }
  
  public void setLastHandleTime(long paramLong) {
    this.lastHandleTime = paramLong;
  }
  
  public void setLoginType(int paramInt) {
    this.loginType = paramInt;
  }
  
  public void setLoginresult(String paramString) {
    this.loginresult = paramString;
  }
  
  public void setPasswordSha(String paramString) {
    this.passwordSha = paramString;
  }
  
  public void setSycOk(boolean paramBoolean) {
    this.isSycOk = paramBoolean;
  }
  
  public void setUid(String paramString) {
    this.uid = paramString;
  }
  
  public void setUsername(String paramString) {
    this.username = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\model\UserAccountsModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */