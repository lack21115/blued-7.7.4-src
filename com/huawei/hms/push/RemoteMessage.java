package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.api.push.utils.CommFun;
import com.huawei.hms.support.api.push.utils.common.base.BaseUtil;
import com.huawei.hms.support.api.push.utils.common.base.PushConst;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteMessage implements Parcelable {
  public static final Parcelable.Creator<RemoteMessage> CREATOR;
  
  public static final int PRIORITY_HIGH = 1;
  
  public static final int PRIORITY_NORMAL = 2;
  
  public static final int PRIORITY_UNKNOWN = 0;
  
  public static final String[] a = new String[0];
  
  public static final int[] b = new int[0];
  
  public static final long[] c = new long[0];
  
  public static final HashMap<String, Object> d = new HashMap<String, Object>(6);
  
  public static final HashMap<String, Object> e = new HashMap<String, Object>(8);
  
  public static final HashMap<String, Object> f = new HashMap<String, Object>(8);
  
  public static final HashMap<String, Object> g = new HashMap<String, Object>(8);
  
  public static final HashMap<String, Object> h = new HashMap<String, Object>(3);
  
  public Bundle i;
  
  public Notification j;
  
  static {
    h.put("acn", "");
    h.put("intentUri", "");
    h.put("url", "");
    CREATOR = new b();
  }
  
  public RemoteMessage(Bundle paramBundle) {
    this.i = a(paramBundle);
  }
  
  public RemoteMessage(Parcel paramParcel) {
    this.i = paramParcel.readBundle();
    this.j = (Notification)paramParcel.readSerializable();
  }
  
  public static JSONObject a(JSONObject paramJSONObject) {
    return (paramJSONObject != null) ? paramJSONObject.optJSONObject("msgContent") : null;
  }
  
  public static JSONObject b(Bundle paramBundle) {
    try {
      return new JSONObject(BaseUtil.byte2Str(paramBundle.getByteArray("message_body")));
    } catch (JSONException jSONException) {
      HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
      return null;
    } 
  }
  
  public static JSONObject b(JSONObject paramJSONObject) {
    return (paramJSONObject != null) ? paramJSONObject.optJSONObject("notifyDetail") : null;
  }
  
  public static JSONObject c(JSONObject paramJSONObject) {
    return (paramJSONObject != null) ? paramJSONObject.optJSONObject("param") : null;
  }
  
  public static JSONObject d(JSONObject paramJSONObject) {
    return (paramJSONObject != null) ? paramJSONObject.optJSONObject("psContent") : null;
  }
  
  public final Bundle a(Bundle paramBundle) {
    Bundle bundle = new Bundle();
    JSONObject jSONObject1 = b(paramBundle);
    JSONObject jSONObject2 = a(jSONObject1);
    String str2 = JsonUtil.getString(jSONObject2, "data", null);
    bundle.putString("device_token", paramBundle.getString("device_token"));
    JSONObject jSONObject3 = d(jSONObject2);
    JSONObject jSONObject4 = b(jSONObject3);
    JSONObject jSONObject5 = c(jSONObject3);
    if (paramBundle.getInt("inputType") == 1 && CommFun.isOldMsg(jSONObject2, jSONObject3, str2)) {
      bundle.putString("data", BaseUtil.byte2Str(paramBundle.getByteArray("message_body")));
      return bundle;
    } 
    String str3 = paramBundle.getString("to");
    String str1 = paramBundle.getString("message_type");
    String str4 = JsonUtil.getString(jSONObject2, "msgId", null);
    bundle.putString("to", str3);
    bundle.putString("data", str2);
    bundle.putString("msgId", str4);
    bundle.putString("message_type", str1);
    JsonUtil.transferJsonObjectToBundle(jSONObject1, bundle, d);
    bundle.putBundle("notification", a(jSONObject1, jSONObject2, jSONObject3, jSONObject4, jSONObject5));
    return bundle;
  }
  
  public final Bundle a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3, JSONObject paramJSONObject4, JSONObject paramJSONObject5) {
    Bundle bundle = new Bundle();
    JsonUtil.transferJsonObjectToBundle(paramJSONObject3, bundle, e);
    JsonUtil.transferJsonObjectToBundle(paramJSONObject4, bundle, f);
    JsonUtil.transferJsonObjectToBundle(paramJSONObject1, bundle, g);
    JsonUtil.transferJsonObjectToBundle(paramJSONObject5, bundle, h);
    bundle.putInt("notifyId", JsonUtil.getInt(paramJSONObject2, "notifyId", 0));
    return bundle;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public String getCollapseKey() {
    return this.i.getString("collapseKey");
  }
  
  public String getData() {
    return this.i.getString("data");
  }
  
  public Map<String, String> getDataOfMap() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    String str = this.i.getString("data");
    if (str != null && !str.trim().isEmpty())
      try {
        JSONObject jSONObject = new JSONObject(str);
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
          String str1 = String.valueOf(iterator.next());
          hashMap.put(str1, String.valueOf(jSONObject.get(str1)));
        } 
      } catch (JSONException jSONException) {
        HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
      }  
    return (Map)hashMap;
  }
  
  public String getFrom() {
    return this.i.getString("from");
  }
  
  public String getMessageId() {
    return this.i.getString("msgId");
  }
  
  public String getMessageType() {
    return this.i.getString("message_type");
  }
  
  public Notification getNotification() {
    Bundle bundle = this.i.getBundle("notification");
    if (this.j == null && bundle != null)
      this.j = new Notification(bundle, null); 
    if (this.j == null)
      this.j = new Notification(new Bundle(), null); 
    return this.j;
  }
  
  public int getOriginalUrgency() {
    int j = this.i.getInt("oriUrgency");
    int i = j;
    if (j != 1) {
      i = j;
      if (j != 2)
        i = 0; 
    } 
    return i;
  }
  
  public int getReceiptMode() {
    return this.i.getInt("receiptMode");
  }
  
  public int getSendMode() {
    return this.i.getInt("sendMode");
  }
  
  public long getSentTime() {
    long l = 0L;
    try {
      Bundle bundle = this.i;
      String str = bundle.getString("sendTime");
      if (!TextUtils.isEmpty(str))
        l = Long.parseLong(str); 
      return l;
    } catch (NumberFormatException numberFormatException) {
      HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
      return 0L;
    } 
  }
  
  public String getTo() {
    return this.i.getString("to");
  }
  
  public String getToken() {
    return this.i.getString("device_token");
  }
  
  public int getTtl() {
    return this.i.getInt("ttl");
  }
  
  public int getUrgency() {
    int j = this.i.getInt("urgency");
    int i = j;
    if (j != 1) {
      i = j;
      if (j != 2)
        i = 0; 
    } 
    return i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeBundle(this.i);
    paramParcel.writeSerializable(this.j);
  }
  
  static {
    Integer integer1 = Integer.valueOf(0);
  }
  
  static {
    d.put("from", "");
    d.put("collapseKey", "");
    d.put("sendTime", "");
    d.put("ttl", Integer.valueOf(86400));
    HashMap<String, Object> hashMap2 = d;
    Integer integer3 = Integer.valueOf(2);
    hashMap2.put("urgency", integer3);
    d.put("oriUrgency", integer3);
    d.put("sendMode", integer1);
    d.put("receiptMode", integer1);
  }
  
  static {
    e.put("title_loc_key", "");
    e.put("body_loc_key", "");
    e.put("notifyIcon", "");
    e.put("title_loc_args", a);
    e.put("body_loc_args", a);
    e.put("ticker", "");
    e.put("notifyTitle", "");
    e.put("content", "");
  }
  
  static {
    f.put("icon", "");
    f.put("color", "");
    f.put("sound", "");
    HashMap<String, Object> hashMap1 = f;
    Integer integer2 = Integer.valueOf(1);
    hashMap1.put("defaultLightSettings", integer2);
    f.put("lightSettings", b);
    f.put("defaultSound", integer2);
    f.put("defaultVibrateTimings", integer2);
    f.put("vibrateTimings", c);
  }
  
  static {
    g.put("tag", "");
    g.put("when", "");
    g.put("localOnly", integer2);
    g.put("badgeSetNum", "");
    g.put("priority", "");
    g.put("autoCancel", integer2);
    g.put("visibility", "");
    g.put("channelId", "");
  }
  
  public static class Builder {
    public final Bundle a = new Bundle();
    
    public final Map<String, String> b = new HashMap<String, String>();
    
    public Builder(String param1String) {
      this.a.putString("to", param1String);
    }
    
    public Builder addData(String param1String1, String param1String2) {
      if (param1String1 != null) {
        this.b.put(param1String1, param1String2);
        return this;
      } 
      throw new IllegalArgumentException("add data failed, key is null.");
    }
    
    public RemoteMessage build() {
      Bundle bundle = new Bundle();
      JSONObject jSONObject = new JSONObject();
      try {
        for (Map.Entry<String, String> entry : this.b.entrySet())
          jSONObject.put((String)entry.getKey(), entry.getValue()); 
        try {
          String str = jSONObject.toString();
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put("collapseKey", this.a.getString("collapseKey"));
          jSONObject1.put("ttl", this.a.getInt("ttl"));
          jSONObject1.put("sendMode", this.a.getInt("sendMode"));
          jSONObject1.put("receiptMode", this.a.getInt("receiptMode"));
          JSONObject jSONObject2 = new JSONObject();
          int i = jSONObject.length();
          if (i != 0)
            jSONObject2.put("data", str); 
          jSONObject2.put("msgId", this.a.getString("msgId"));
          jSONObject1.put("msgContent", jSONObject2);
          byte[] arrayOfByte = jSONObject1.toString().getBytes(PushConst.UTF_8);
          bundle.putByteArray("message_body", arrayOfByte);
          bundle.putString("to", this.a.getString("to"));
          bundle.putString("message_type", this.a.getString("message_type"));
          return new RemoteMessage(bundle);
        } catch (JSONException jSONException) {}
        HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
        throw new PushException("send message failed");
      } catch (JSONException jSONException) {
        HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
        throw new PushException("send message failed");
      } 
    }
    
    public Builder clearData() {
      this.b.clear();
      return this;
    }
    
    public Builder setCollapseKey(String param1String) {
      this.a.putString("collapseKey", param1String);
      return this;
    }
    
    public Builder setData(Map<String, String> param1Map) {
      this.b.clear();
      for (Map.Entry<String, String> entry : param1Map.entrySet())
        this.b.put((String)entry.getKey(), (String)entry.getValue()); 
      return this;
    }
    
    public Builder setMessageId(String param1String) {
      this.a.putString("msgId", param1String);
      return this;
    }
    
    public Builder setMessageType(String param1String) {
      this.a.putString("message_type", param1String);
      return this;
    }
    
    public Builder setReceiptMode(int param1Int) {
      if (param1Int == 1 || param1Int == 0) {
        this.a.putInt("receiptMode", param1Int);
        return this;
      } 
      throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
    }
    
    public Builder setSendMode(int param1Int) {
      if (param1Int == 0 || param1Int == 1) {
        this.a.putInt("sendMode", param1Int);
        return this;
      } 
      throw new IllegalArgumentException("send mode can only be 0 or 1.");
    }
    
    public Builder setTtl(int param1Int) {
      if (param1Int >= 1 && param1Int <= 1296000) {
        this.a.putInt("ttl", param1Int);
        return this;
      } 
      throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MessagePriority {}
  
  public static class Notification implements Serializable {
    public final long[] A;
    
    public final String B;
    
    public final String a;
    
    public final String b;
    
    public final String[] c;
    
    public final String d;
    
    public final String e;
    
    public final String[] f;
    
    public final String g;
    
    public final String h;
    
    public final String i;
    
    public final String j;
    
    public final String k;
    
    public final String l;
    
    public final String m;
    
    public final Uri n;
    
    public final int o;
    
    public final String p;
    
    public final int q;
    
    public final int r;
    
    public final int s;
    
    public final int[] t;
    
    public final String u;
    
    public final int v;
    
    public final String w;
    
    public final int x;
    
    public final String y;
    
    public final String z;
    
    public Notification(Bundle param1Bundle) {
      this.a = param1Bundle.getString("notifyTitle");
      this.d = param1Bundle.getString("content");
      this.b = param1Bundle.getString("title_loc_key");
      this.e = param1Bundle.getString("body_loc_key");
      this.c = param1Bundle.getStringArray("title_loc_args");
      this.f = param1Bundle.getStringArray("body_loc_args");
      this.g = param1Bundle.getString("icon");
      this.j = param1Bundle.getString("color");
      this.h = param1Bundle.getString("sound");
      this.i = param1Bundle.getString("tag");
      this.m = param1Bundle.getString("channelId");
      this.k = param1Bundle.getString("acn");
      this.l = param1Bundle.getString("intentUri");
      this.o = param1Bundle.getInt("notifyId");
      String str = param1Bundle.getString("url");
      if (!TextUtils.isEmpty(str)) {
        Uri uri = Uri.parse(str);
      } else {
        str = null;
      } 
      this.n = (Uri)str;
      this.p = param1Bundle.getString("notifyIcon");
      this.q = param1Bundle.getInt("defaultLightSettings");
      this.r = param1Bundle.getInt("defaultSound");
      this.s = param1Bundle.getInt("defaultVibrateTimings");
      this.t = param1Bundle.getIntArray("lightSettings");
      this.u = param1Bundle.getString("when");
      this.v = param1Bundle.getInt("localOnly");
      this.w = param1Bundle.getString("badgeSetNum", null);
      this.x = param1Bundle.getInt("autoCancel");
      this.y = param1Bundle.getString("priority", null);
      this.z = param1Bundle.getString("ticker");
      this.A = param1Bundle.getLongArray("vibrateTimings");
      this.B = param1Bundle.getString("visibility", null);
    }
    
    public final Integer a(String param1String) {
      if (param1String != null)
        try {
          return Integer.valueOf(param1String);
        } catch (NumberFormatException numberFormatException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("NumberFormatException: get ");
          stringBuilder.append(param1String);
          stringBuilder.append(" failed.");
          HMSLog.w("RemoteMessage", stringBuilder.toString());
        }  
      return null;
    }
    
    public Integer getBadgeNumber() {
      return a(this.w);
    }
    
    public String getBody() {
      return this.d;
    }
    
    public String[] getBodyLocalizationArgs() {
      String[] arrayOfString = this.f;
      return (arrayOfString == null) ? new String[0] : (String[])arrayOfString.clone();
    }
    
    public String getBodyLocalizationKey() {
      return this.e;
    }
    
    public String getChannelId() {
      return this.m;
    }
    
    public String getClickAction() {
      return this.k;
    }
    
    public String getColor() {
      return this.j;
    }
    
    public String getIcon() {
      return this.g;
    }
    
    public Uri getImageUrl() {
      String str = this.p;
      return (str == null) ? null : Uri.parse(str);
    }
    
    public Integer getImportance() {
      return a(this.y);
    }
    
    public String getIntentUri() {
      return this.l;
    }
    
    public int[] getLightSettings() {
      int[] arrayOfInt = this.t;
      return (arrayOfInt == null) ? new int[0] : (int[])arrayOfInt.clone();
    }
    
    public Uri getLink() {
      return this.n;
    }
    
    public int getNotifyId() {
      return this.o;
    }
    
    public String getSound() {
      return this.h;
    }
    
    public String getTag() {
      return this.i;
    }
    
    public String getTicker() {
      return this.z;
    }
    
    public String getTitle() {
      return this.a;
    }
    
    public String[] getTitleLocalizationArgs() {
      String[] arrayOfString = this.c;
      return (arrayOfString == null) ? new String[0] : (String[])arrayOfString.clone();
    }
    
    public String getTitleLocalizationKey() {
      return this.b;
    }
    
    public long[] getVibrateConfig() {
      long[] arrayOfLong = this.A;
      return (arrayOfLong == null) ? new long[0] : (long[])arrayOfLong.clone();
    }
    
    public Integer getVisibility() {
      return a(this.B);
    }
    
    public Long getWhen() {
      if (!TextUtils.isEmpty(this.u))
        try {
          long l = DateUtil.parseUtcToMillisecond(this.u);
          return Long.valueOf(l);
        } catch (ParseException parseException) {
          HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
          HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
        }  
      return null;
    }
    
    public boolean isAutoCancel() {
      return (this.x == 1);
    }
    
    public boolean isDefaultLight() {
      return (this.q == 1);
    }
    
    public boolean isDefaultSound() {
      return (this.r == 1);
    }
    
    public boolean isDefaultVibrate() {
      return (this.s == 1);
    }
    
    public boolean isLocalOnly() {
      return (this.v == 1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\RemoteMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */