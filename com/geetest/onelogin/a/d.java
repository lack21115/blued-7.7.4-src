package com.geetest.onelogin.a;

import com.geetest.onelogin.listener.SecurityPhoneListener;

public class d extends a {
  private String accessCode;
  
  private String apiServer;
  
  private String appId;
  
  private String ctPreResult;
  
  private String cuPreResult;
  
  private Object cuccResult;
  
  private b dataSimBean;
  
  private String gwAuth;
  
  private volatile boolean isCanceled = false;
  
  private volatile boolean isPreGetTokenComplete = false;
  
  private volatile boolean isPreTokenSuccess = false;
  
  private volatile boolean isPreTokenValidate = false;
  
  private volatile boolean isRequestTokenComplete = false;
  
  private volatile boolean isRequestTokenSuccess = false;
  
  private boolean isSimChanged;
  
  private volatile boolean isState = false;
  
  private volatile boolean isTimeout = false;
  
  private String message;
  
  private volatile String number;
  
  private e opBean;
  
  private String opToken;
  
  private String operator;
  
  private long preGetTokenTime;
  
  private String processId;
  
  private String random;
  
  private int requestTimeout;
  
  private long requestTokenTime;
  
  private int sdkTimeout;
  
  private SecurityPhoneListener securityPhoneListener;
  
  private long startTime;
  
  private String token;
  
  public String getAccessCode() {
    return this.accessCode;
  }
  
  public String getApiServer() {
    return this.apiServer;
  }
  
  public String getAppId() {
    return this.appId;
  }
  
  public String getCtPreResult() {
    return this.ctPreResult;
  }
  
  public String getCuPreResult() {
    return this.cuPreResult;
  }
  
  public Object getCuccResult() {
    return this.cuccResult;
  }
  
  public b getDataSimBean() {
    return this.dataSimBean;
  }
  
  public int getExpireTime() {
    return this.opBean.d();
  }
  
  public String getGwAuth() {
    return this.gwAuth;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getNumber() {
    return this.number;
  }
  
  public e getOpBean() {
    return this.opBean;
  }
  
  public String getOpToken() {
    return this.opToken;
  }
  
  public String getOperator() {
    return this.operator;
  }
  
  public long getPreGetTokenTime() {
    return this.preGetTokenTime;
  }
  
  public String getProcessId() {
    return this.processId;
  }
  
  public String getRandom() {
    return this.random;
  }
  
  public int getRequestTimeout() {
    return this.requestTimeout;
  }
  
  public long getRequestTokenTime() {
    return this.requestTokenTime;
  }
  
  public int getSdkTimeout() {
    return this.sdkTimeout;
  }
  
  public SecurityPhoneListener getSecurityPhoneListener() {
    return this.securityPhoneListener;
  }
  
  public long getStartTime() {
    return this.startTime;
  }
  
  public String getToken() {
    return this.token;
  }
  
  public String getTokenId() {
    return this.opBean.b();
  }
  
  public String getTokenKey() {
    return this.opBean.c();
  }
  
  public boolean isAccessCodeExpired() {
    if (this.isPreTokenSuccess) {
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = this.startTime;
      if (l1 < l2)
        return true; 
      if (l1 - l2 <= this.opBean.d())
        return false; 
    } 
    return true;
  }
  
  public boolean isCanceled() {
    return this.isCanceled;
  }
  
  public boolean isPreGetTokenComplete() {
    return this.isPreGetTokenComplete;
  }
  
  public boolean isPreTokenSuccess() {
    return this.isPreTokenSuccess;
  }
  
  public boolean isPreTokenValidate() {
    return this.isPreTokenValidate;
  }
  
  public boolean isRequestTokenComplete() {
    return this.isRequestTokenComplete;
  }
  
  public boolean isRequestTokenSuccess() {
    return this.isRequestTokenSuccess;
  }
  
  public boolean isSimChanged() {
    return this.isSimChanged;
  }
  
  public boolean isState() {
    return this.isState;
  }
  
  public boolean isTimeout() {
    return this.isTimeout;
  }
  
  public void setAccessCode(String paramString) {
    this.accessCode = paramString;
  }
  
  public void setApiServer(String paramString) {
    this.apiServer = paramString;
  }
  
  public void setAppId(String paramString) {
    this.appId = paramString;
  }
  
  public void setCanceled(boolean paramBoolean) {
    this.isCanceled = paramBoolean;
  }
  
  public void setCtPreResult(String paramString) {
    this.ctPreResult = paramString;
  }
  
  public void setCuPreResult(String paramString) {
    this.cuPreResult = paramString;
  }
  
  public void setCuccResult(Object paramObject) {
    this.cuccResult = paramObject;
  }
  
  public void setDataSimBean(b paramb) {
    this.dataSimBean = paramb;
    this.isSimChanged = false;
  }
  
  public void setGwAuth(String paramString) {
    this.gwAuth = paramString;
  }
  
  public void setMessage(String paramString) {
    this.message = paramString;
  }
  
  public void setNumber(String paramString) {
    this.number = paramString;
  }
  
  public void setOpBean(e parame) {
    this.opBean = parame;
  }
  
  public void setOpToken(String paramString) {
    this.opToken = paramString;
  }
  
  public void setOperator(String paramString) {
    this.operator = paramString;
  }
  
  public void setPreGetTokenComplete(boolean paramBoolean) {
    this.isPreGetTokenComplete = paramBoolean;
  }
  
  public void setPreGetTokenTime(long paramLong) {
    this.preGetTokenTime = paramLong;
  }
  
  public void setPreTokenSuccess(boolean paramBoolean) {
    this.isPreTokenSuccess = paramBoolean;
  }
  
  public void setPreTokenValidate(boolean paramBoolean) {
    this.isPreTokenValidate = paramBoolean;
  }
  
  public void setProcessId(String paramString) {
    this.processId = paramString;
  }
  
  public void setRandom(String paramString) {
    this.random = paramString;
  }
  
  public void setRequestTimeout(int paramInt) {
    this.requestTimeout = paramInt;
  }
  
  public void setRequestTokenComplete(boolean paramBoolean) {
    this.isRequestTokenComplete = paramBoolean;
  }
  
  public void setRequestTokenSuccess(boolean paramBoolean) {
    this.isRequestTokenSuccess = paramBoolean;
  }
  
  public void setRequestTokenTime(long paramLong) {
    this.requestTokenTime = paramLong;
  }
  
  public void setSdkTimeout(int paramInt) {
    this.sdkTimeout = paramInt;
  }
  
  public void setSecurityPhoneListener(SecurityPhoneListener paramSecurityPhoneListener) {
    this.securityPhoneListener = paramSecurityPhoneListener;
  }
  
  public void setSimChanged(boolean paramBoolean) {
    this.isSimChanged = paramBoolean;
  }
  
  public void setStartTime(long paramLong) {
    this.startTime = paramLong;
  }
  
  public void setState(boolean paramBoolean) {
    this.isState = paramBoolean;
  }
  
  public void setTimeout(boolean paramBoolean) {
    this.isTimeout = paramBoolean;
  }
  
  public void setToken(String paramString) {
    this.token = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("OneLoginBean{isPreTokenSuccess=");
    stringBuilder.append(this.isPreTokenSuccess);
    stringBuilder.append(", isPreTokenValidate=");
    stringBuilder.append(this.isPreTokenValidate);
    stringBuilder.append(", isRequestTokenSuccess=");
    stringBuilder.append(this.isRequestTokenSuccess);
    stringBuilder.append(", isRequestTokenComplete=");
    stringBuilder.append(this.isRequestTokenComplete);
    stringBuilder.append(", isPreGetTokenComplete=");
    stringBuilder.append(this.isPreGetTokenComplete);
    stringBuilder.append(", startTime=");
    stringBuilder.append(this.startTime);
    stringBuilder.append(", preGetTokenTime=");
    stringBuilder.append(this.preGetTokenTime);
    stringBuilder.append(", requestTokenTime=");
    stringBuilder.append(this.requestTokenTime);
    stringBuilder.append(", isCanceled=");
    stringBuilder.append(this.isCanceled);
    stringBuilder.append(", isTimeout=");
    stringBuilder.append(this.isTimeout);
    stringBuilder.append(", appId='");
    stringBuilder.append(this.appId);
    stringBuilder.append('\'');
    stringBuilder.append(", ctPreResult='");
    stringBuilder.append(this.ctPreResult);
    stringBuilder.append('\'');
    stringBuilder.append(", gwAuth='");
    stringBuilder.append(this.gwAuth);
    stringBuilder.append('\'');
    stringBuilder.append(", cuccResult='");
    stringBuilder.append(this.cuccResult);
    stringBuilder.append('\'');
    stringBuilder.append(", operator='");
    stringBuilder.append(this.operator);
    stringBuilder.append('\'');
    stringBuilder.append(", opBean='");
    stringBuilder.append(this.opBean);
    stringBuilder.append('\'');
    stringBuilder.append(", dataSimBean=");
    stringBuilder.append(this.dataSimBean);
    stringBuilder.append(", isSimChanged=");
    stringBuilder.append(this.isSimChanged);
    stringBuilder.append(", sdkTimeout=");
    stringBuilder.append(this.sdkTimeout);
    stringBuilder.append(", requestTimeout=");
    stringBuilder.append(this.requestTimeout);
    stringBuilder.append(", random='");
    stringBuilder.append(this.random);
    stringBuilder.append('\'');
    stringBuilder.append(", processId='");
    stringBuilder.append(this.processId);
    stringBuilder.append('\'');
    stringBuilder.append(", number='");
    stringBuilder.append(this.number);
    stringBuilder.append('\'');
    stringBuilder.append(", token='");
    stringBuilder.append(this.token);
    stringBuilder.append('\'');
    stringBuilder.append(", message='");
    stringBuilder.append(this.message);
    stringBuilder.append('\'');
    stringBuilder.append(", accessCode='");
    stringBuilder.append(this.accessCode);
    stringBuilder.append('\'');
    stringBuilder.append(", isState=");
    stringBuilder.append(this.isState);
    stringBuilder.append(", apiServer='");
    stringBuilder.append(this.apiServer);
    stringBuilder.append('\'');
    stringBuilder.append(", securityPhoneListener=");
    stringBuilder.append(this.securityPhoneListener);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */