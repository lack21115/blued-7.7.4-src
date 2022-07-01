package com.sina.weibo.sdk.cmd;

import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CmdInfo {
  private static final String TAG = BaseCmd.class.getName();
  
  private int frequency;
  
  private List<AppInstallCmd> mInstallCmds;
  
  private List<AppInvokeCmd> mInvokeCmds;
  
  public CmdInfo(String paramString) throws WeiboException {
    initFromJsonStr(paramString);
  }
  
  private void initFromJsonStr(String paramString) throws WeiboException {
    if (paramString == null)
      return; 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (!jSONObject.has("error") && !jSONObject.has("error_code")) {
        jSONObject = jSONObject.optJSONObject("cmd");
        if (jSONObject != null) {
          this.frequency = jSONObject.optInt("frequency");
          JSONArray jSONArray2 = jSONObject.optJSONArray("app_install");
          byte b = 0;
          if (jSONArray2 != null) {
            this.mInstallCmds = new ArrayList<AppInstallCmd>();
            for (int i = 0; i < jSONArray2.length(); i++) {
              JSONObject jSONObject1 = jSONArray2.getJSONObject(i);
              this.mInstallCmds.add(new AppInstallCmd(jSONObject1));
            } 
          } 
          JSONArray jSONArray1 = jSONObject.optJSONArray("app_invoke");
          if (jSONArray1 != null) {
            this.mInvokeCmds = new ArrayList<AppInvokeCmd>();
            for (int i = b;; i++) {
              if (i >= jSONArray1.length())
                return; 
              JSONObject jSONObject1 = jSONArray1.getJSONObject(i);
              this.mInvokeCmds.add(new AppInvokeCmd(jSONObject1));
            } 
          } 
        } 
      } else {
        LogUtil.w(TAG, "load cmd api has error !!!");
        throw new WeiboException("load cmd api has error !!!");
      } 
    } catch (JSONException jSONException) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder("parse NotificationInfo error: ");
      stringBuilder.append(jSONException.getMessage());
      LogUtil.d(str, stringBuilder.toString());
    } 
  }
  
  public int getFrequency() {
    return this.frequency;
  }
  
  public List<AppInstallCmd> getInstallCmds() {
    return this.mInstallCmds;
  }
  
  public List<AppInvokeCmd> getInvokeCmds() {
    return this.mInvokeCmds;
  }
  
  public void setFrequency(int paramInt) {
    this.frequency = paramInt;
  }
  
  public void setInstallCmds(List<AppInstallCmd> paramList) {
    this.mInstallCmds = paramList;
  }
  
  public void setInvokeCmds(List<AppInvokeCmd> paramList) {
    this.mInvokeCmds = paramList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\cmd\CmdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */