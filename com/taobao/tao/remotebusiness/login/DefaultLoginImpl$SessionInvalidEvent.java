package com.taobao.tao.remotebusiness.login;

import com.alibaba.fastjson.JSON;
import com.taobao.tao.remotebusiness.listener.c;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;

class DefaultLoginImpl$SessionInvalidEvent {
  private static final String BUNDLE_KEY = "apiReferer";
  
  private static final String HEADER_KEY = "S";
  
  public String S_STATUS;
  
  public String apiName;
  
  public String eventName;
  
  public String long_nick;
  
  public String msgCode;
  
  public String v;
  
  public DefaultLoginImpl$SessionInvalidEvent(MtopRequest paramMtopRequest) {
    this.apiName = paramMtopRequest.a();
    this.v = paramMtopRequest.b();
  }
  
  public DefaultLoginImpl$SessionInvalidEvent(MtopResponse paramMtopResponse, String paramString) {
    this.eventName = "SESSION_INVALID";
    this.long_nick = paramString;
    this.apiName = paramMtopResponse.b();
    this.v = paramMtopResponse.c();
    this.msgCode = paramMtopResponse.a();
    this.S_STATUS = c.a(paramMtopResponse.e(), "S");
  }
  
  public String toJSONString() {
    return JSON.toJSONString(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\login\DefaultLoginImpl$SessionInvalidEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */