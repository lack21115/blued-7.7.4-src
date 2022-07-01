package com.huawei.hms.support.api.push.pushselfshow.entity;

import android.text.TextUtils;
import com.huawei.hms.support.api.push.pushselfshow.prepare.NotifyStyle;
import com.huawei.hms.support.api.push.utils.common.base.PushConst;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PushSelfShowMessage {
  public static final String ANALYTIC_INFO = "analyticInfo";
  
  public static final String APP_INTENT = "acn";
  
  public static final String APP_INTENT_URI = "intentUri";
  
  public static final String APP_PACKAGE_NAME = "appPackageName";
  
  public static final String AUTO_CANCEL = "autoCancel";
  
  public static final String AUTO_CLEAR = "autoClear";
  
  public static final String BIG_CONTENT = "bigContent";
  
  public static final String BIG_PIC = "bigPic";
  
  public static final String BIG_TITLE = "bigTitle";
  
  public static final String CMD = "cmd";
  
  public static final String CONTENT = "content";
  
  public static final String DATA = "data";
  
  public static final String DISP_PKG_NAME = "dispPkgName";
  
  public static final String ICON = "icon";
  
  public static final int INTEGER_FOR_TRUE = 1;
  
  public static final String MSG_AP = "ap";
  
  public static final String MSG_CONTENT = "msgContent";
  
  public static final String MSG_ID = "msgId";
  
  public static final String MSG_TAG = "tag";
  
  public static final String NOTIFY_DETAIL = "notifyDetail";
  
  public static final String NOTIFY_GROUP = "group";
  
  public static final String NOTIFY_ICON = "notifyIcon";
  
  public static final String NOTIFY_ID = "notifyId";
  
  public static final String NOTIFY_SUMMARY = "notifySummary";
  
  public static final String NOTIFY_TITLE = "notifyTitle";
  
  public static final String PARAM = "param";
  
  public static final String PS_CONTENT = "psContent";
  
  public static final String RP_CONTENT_TYPE = "rpct";
  
  public static final String RP_TYPE = "rpt";
  
  public static final String RP_URL = "rpl";
  
  public static final String STYLE = "style";
  
  public static final String TAG = "PushSelfShowLog";
  
  public static final String TICKER = "ticker";
  
  public static final String URL = "url";
  
  public static final String VISIBILITY = "visibility";
  
  public static final int VISIBILITY_PRIVATE = 0;
  
  public static final String WHEN = "when";
  
  public String acn;
  
  public String analyticInfo = "";
  
  public String ap;
  
  public String appPackageName;
  
  public int autoCancel = 0;
  
  public int autoClear;
  
  public String bigContent = "";
  
  public String bigPicUrl = "";
  
  public String bigTitle = "";
  
  public String cmd = "";
  
  public String content = "";
  
  public String data = "";
  
  public String dispPkgName = "";
  
  public String group = "";
  
  public String icon = "";
  
  public String intentUri;
  
  public String msg;
  
  public String msgId = "";
  
  public String msgTag = "";
  
  public String notifyIcon = "";
  
  public int notifyId;
  
  public String notifySummary = "";
  
  public String notifyTitle = "";
  
  public String rpct = "";
  
  public String rpl;
  
  public String rpt;
  
  public int style = NotifyStyle.STYLE_DEFAULT.ordinal();
  
  public String ticker;
  
  public String token;
  
  public String url;
  
  public int visibility = 0;
  
  public String when;
  
  public PushSelfShowMessage(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    this.msg = new String(paramArrayOfbyte1, PushConst.UTF_8);
    this.token = new String(paramArrayOfbyte2, PushConst.UTF_8);
  }
  
  private JSONObject getAdMsg(JSONObject paramJSONObject) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("msgContent", paramJSONObject);
    jSONObject.put("group", this.group);
    jSONObject.put("tag", this.msgTag);
    jSONObject.put("autoCancel", this.autoCancel);
    jSONObject.put("visibility", this.visibility);
    jSONObject.put("when", this.when);
    return jSONObject;
  }
  
  private JSONObject getMsgContent(JSONObject paramJSONObject1, JSONObject paramJSONObject2) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("dispPkgName", this.dispPkgName);
    jSONObject.put("msgId", this.msgId);
    jSONObject.put("ap", this.ap);
    jSONObject.put("notifyId", this.notifyId);
    jSONObject.put("psContent", paramJSONObject1);
    jSONObject.put("notifyDetail", paramJSONObject2);
    jSONObject.put("ticker", this.ticker);
    jSONObject.put("data", this.data);
    return jSONObject;
  }
  
  private JSONObject getNotifyDetail() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("style", this.style);
    jSONObject.put("bigTitle", this.bigTitle);
    jSONObject.put("bigContent", this.bigContent);
    jSONObject.put("bigPic", this.bigPicUrl);
    return jSONObject;
  }
  
  private JSONObject getParam() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("autoClear", this.autoClear);
    jSONObject.put("url", this.url);
    jSONObject.put("rpl", this.rpl);
    jSONObject.put("rpt", this.rpt);
    jSONObject.put("rpct", this.rpct);
    jSONObject.put("appPackageName", this.appPackageName);
    jSONObject.put("acn", this.acn);
    jSONObject.put("intentUri", this.intentUri);
    return jSONObject;
  }
  
  private JSONObject getPsContentObject(JSONObject paramJSONObject) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("cmd", this.cmd);
    jSONObject.put("content", this.content);
    jSONObject.put("notifyIcon", this.notifyIcon);
    jSONObject.put("notifyTitle", this.notifyTitle);
    jSONObject.put("notifySummary", this.notifySummary);
    jSONObject.put("param", paramJSONObject);
    return jSONObject;
  }
  
  private void parseAp(JSONObject paramJSONObject) throws JSONException {
    if (paramJSONObject.has("ap")) {
      String str = paramJSONObject.getString("ap");
      StringBuilder stringBuilder = new StringBuilder();
      boolean bool = TextUtils.isEmpty(str);
      int i = 0;
      if (!bool && str.length() < 48) {
        int j = str.length();
        while (i < 48 - j) {
          stringBuilder.append("0");
          i++;
        } 
        stringBuilder.append(str);
        this.ap = stringBuilder.toString();
        return;
      } 
      this.ap = str.substring(0, 48);
    } 
  }
  
  private boolean parseApp(JSONObject paramJSONObject) throws JSONException {
    if (paramJSONObject == null)
      return false; 
    if (paramJSONObject.has("acn"))
      this.acn = paramJSONObject.getString("acn"); 
    if (paramJSONObject.has("intentUri"))
      this.intentUri = paramJSONObject.getString("intentUri"); 
    if (paramJSONObject.has("appPackageName")) {
      this.appPackageName = paramJSONObject.getString("appPackageName");
      return true;
    } 
    HMSLog.d("PushSelfShowLog", "appPackageName is null");
    return false;
  }
  
  private boolean parseMsgId(JSONObject paramJSONObject) throws JSONException {
    if (paramJSONObject.has("msgId")) {
      Object object = paramJSONObject.get("msgId");
      if (object instanceof String) {
        this.msgId = (String)object;
      } else if (object instanceof Integer) {
        this.msgId = String.valueOf(((Integer)object).intValue());
      } 
      return true;
    } 
    HMSLog.i("PushSelfShowLog", "msgId == null");
    return false;
  }
  
  private boolean parseNotifyDetail(JSONObject paramJSONObject) {
    HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
    try {
      paramJSONObject = paramJSONObject.getJSONObject("notifyDetail");
      if (paramJSONObject == null)
        return false; 
      if (paramJSONObject.has("style"))
        this.style = paramJSONObject.getInt("style"); 
      this.bigTitle = paramJSONObject.optString("bigTitle");
      this.bigContent = paramJSONObject.optString("bigContent");
      this.icon = paramJSONObject.optString("icon");
      return true;
    } catch (JSONException jSONException) {
      HMSLog.i("PushSelfShowLog", jSONException.toString());
      return false;
    } 
  }
  
  private void parseOther(JSONObject paramJSONObject) {
    this.group = paramJSONObject.optString("group");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NOTIFY_GROUP:");
    stringBuilder.append(this.group);
    HMSLog.d("PushSelfShowLog", stringBuilder.toString());
    this.autoCancel = paramJSONObject.optInt("autoCancel", 1);
    stringBuilder = new StringBuilder();
    stringBuilder.append("autoCancel: ");
    stringBuilder.append(this.autoCancel);
    HMSLog.d("PushSelfShowLog", stringBuilder.toString());
    this.visibility = paramJSONObject.optInt("visibility", 0);
    this.when = paramJSONObject.optString("when");
    this.msgTag = paramJSONObject.optString("tag");
  }
  
  private boolean parseParam(JSONObject paramJSONObject) {
    try {
      paramJSONObject = paramJSONObject.getJSONObject("param");
      if (paramJSONObject.has("autoClear")) {
        this.autoClear = paramJSONObject.getInt("autoClear");
      } else {
        this.autoClear = 0;
      } 
      boolean bool = "app".equals(this.cmd);
      if (!bool) {
        bool = "cosa".equals(this.cmd);
        if (bool) {
          parseApp(paramJSONObject);
          return true;
        } 
        if ("url".equals(this.cmd)) {
          parseUrl(paramJSONObject);
        } else if ("rp".equals(this.cmd)) {
          parseRp(paramJSONObject);
        } 
        return true;
      } 
      parseApp(paramJSONObject);
      return true;
    } catch (Exception exception) {
      HMSLog.e("PushSelfShowLog", "ParseParam error ", exception);
      return false;
    } 
  }
  
  private boolean parsePsContent(JSONObject paramJSONObject) throws JSONException {
    if (paramJSONObject.has("psContent")) {
      paramJSONObject = paramJSONObject.getJSONObject("psContent");
      if (paramJSONObject == null)
        return false; 
      this.cmd = paramJSONObject.getString("cmd");
      this.content = paramJSONObject.optString("content");
      this.notifyIcon = paramJSONObject.optString("notifyIcon");
      this.notifyTitle = paramJSONObject.optString("notifyTitle");
      this.notifySummary = paramJSONObject.optString("notifySummary");
      this.ticker = paramJSONObject.optString("ticker");
      if (paramJSONObject.has("notifyDetail") && !parseNotifyDetail(paramJSONObject))
        return false; 
      if (paramJSONObject.has("param"))
        return parseParam(paramJSONObject); 
    } 
    return false;
  }
  
  private boolean parseRp(JSONObject paramJSONObject) throws JSONException {
    if (paramJSONObject == null)
      return false; 
    if (paramJSONObject.has("appPackageName"))
      this.appPackageName = paramJSONObject.getString("appPackageName"); 
    if (paramJSONObject.has("rpt") && paramJSONObject.has("rpl")) {
      this.rpl = paramJSONObject.getString("rpl");
      this.rpt = paramJSONObject.getString("rpt");
      if (paramJSONObject.has("rpct"))
        this.rpct = paramJSONObject.getString("rpct"); 
      return true;
    } 
    HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
    return false;
  }
  
  private boolean parseUrl(JSONObject paramJSONObject) throws JSONException {
    if (paramJSONObject == null)
      return false; 
    if (paramJSONObject.has("url")) {
      this.url = paramJSONObject.getString("url");
      if (paramJSONObject.has("appPackageName"))
        this.appPackageName = paramJSONObject.getString("appPackageName"); 
      if (paramJSONObject.has("rpt") && paramJSONObject.has("rpl")) {
        this.rpl = paramJSONObject.getString("rpl");
        this.rpt = paramJSONObject.getString("rpt");
        if (paramJSONObject.has("rpct"))
          this.rpct = paramJSONObject.getString("rpct"); 
      } 
      return true;
    } 
    HMSLog.d("PushSelfShowLog", "url is null");
    return false;
  }
  
  public String getAcn() {
    return this.acn;
  }
  
  public String getAnalyticInfo() {
    return this.analyticInfo;
  }
  
  public String getAp() {
    return this.ap;
  }
  
  public String getAppPackageName() {
    return this.appPackageName;
  }
  
  public int getAutoCancel() {
    return this.autoCancel;
  }
  
  public int getAutoClear() {
    return this.autoClear;
  }
  
  public String getBigContent() {
    return this.bigContent;
  }
  
  public String getBigPicUrl() {
    return this.bigPicUrl;
  }
  
  public String getBigTitle() {
    return this.bigTitle;
  }
  
  public String getCmd() {
    return this.cmd;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public String getData() {
    return this.data;
  }
  
  public String getDispPkgName() {
    return this.dispPkgName;
  }
  
  public String getGroup() {
    return this.group;
  }
  
  public String getIcon() {
    return this.icon;
  }
  
  public String getIntentUri() {
    return this.intentUri;
  }
  
  public String getMsg() {
    return this.msg;
  }
  
  public String getMsgCmd() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cmd =");
    stringBuilder.append(this.cmd);
    HMSLog.d("PushSelfShowLog", stringBuilder.toString());
    return this.cmd;
  }
  
  public byte[] getMsgData() {
    try {
      return getAdMsg(getMsgContent(getPsContentObject(getParam()), getNotifyDetail())).toString().getBytes(PushConst.UTF_8);
    } catch (JSONException jSONException) {
      HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", (Throwable)jSONException);
      return new byte[0];
    } 
  }
  
  public String getMsgId() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("msgId =");
    stringBuilder.append(this.msgId);
    HMSLog.d("PushSelfShowLog", stringBuilder.toString());
    return this.msgId;
  }
  
  public String getMsgTag() {
    return this.msgTag;
  }
  
  public String getNotifyIcon() {
    return this.notifyIcon;
  }
  
  public int getNotifyId() {
    return this.notifyId;
  }
  
  public String getNotifySummary() {
    return this.notifySummary;
  }
  
  public String getNotifyTitle() {
    return this.notifyTitle;
  }
  
  public String getRpct() {
    return this.rpct;
  }
  
  public String getRpl() {
    return this.rpl;
  }
  
  public String getRpt() {
    return this.rpt;
  }
  
  public int getStyle() {
    return this.style;
  }
  
  public String getTicker() {
    return this.ticker;
  }
  
  public byte[] getToken() {
    return this.token.getBytes(PushConst.UTF_8);
  }
  
  public String getUeid() {
    return (this.autoCancel == 1) ? getMsgId() : String.valueOf(System.currentTimeMillis());
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public int getVisibility() {
    return this.visibility;
  }
  
  public String getWhen() {
    return this.when;
  }
  
  public boolean parseMessage() {
    try {
      null = TextUtils.isEmpty(this.msg);
      if (null) {
        HMSLog.d("PushSelfShowLog", "msg is null");
        return false;
      } 
      JSONObject jSONObject = new JSONObject(this.msg);
      parseOther(jSONObject);
      jSONObject = jSONObject.getJSONObject("msgContent");
      if (jSONObject == null) {
        HMSLog.i("PushSelfShowLog", "msgObj == null");
        return false;
      } 
      null = parseMsgId(jSONObject);
      if (!null)
        return false; 
      this.dispPkgName = jSONObject.optString("dispPkgName");
      parseAp(jSONObject);
      this.notifyId = jSONObject.optInt("notifyId", -1);
      this.data = jSONObject.optString("data");
      this.analyticInfo = jSONObject.optString("analyticInfo");
      return parsePsContent(jSONObject);
    } catch (JSONException jSONException) {
      HMSLog.d("PushSelfShowLog", "parse message exception.");
      return false;
    } catch (Exception exception) {
      HMSLog.d("PushSelfShowLog", exception.toString());
      return false;
    } 
  }
  
  public void setContent(String paramString) {
    this.content = paramString;
  }
  
  public void setMsg(String paramString) {
    this.msg = paramString;
  }
  
  public void setMsgId(String paramString) {
    this.msgId = paramString;
  }
  
  public void setNotifyId(int paramInt) {
    this.notifyId = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfshow\entity\PushSelfShowMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */