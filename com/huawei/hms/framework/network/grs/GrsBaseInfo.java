package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.local.model.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GrsBaseInfo implements Cloneable {
  private static final String TAG = "GrsBaseInfo";
  
  private String androidVersion;
  
  private String appName;
  
  private String countrySource;
  
  private String deviceModel;
  
  private String issueCountry;
  
  private String regCountry;
  
  private String romVersion;
  
  private String serCountry;
  
  private String uid;
  
  private String versionName;
  
  public GrsBaseInfo() {}
  
  public GrsBaseInfo(Context paramContext) {
    this.issueCountry = GrsApp.getInstance().getIssueCountryCode(paramContext);
  }
  
  private StringBuffer getStringBuffer(StringBuffer paramStringBuffer, boolean paramBoolean, Context paramContext) {
    String str2 = getAndroidVersion();
    if (!TextUtils.isEmpty(str2)) {
      if (!TextUtils.isEmpty(paramStringBuffer.toString()))
        paramStringBuffer.append("&"); 
      paramStringBuffer.append("android_version");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str2);
    } 
    str2 = getRomVersion();
    if (!TextUtils.isEmpty(str2)) {
      if (!TextUtils.isEmpty(paramStringBuffer.toString()))
        paramStringBuffer.append("&"); 
      paramStringBuffer.append("rom_version");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str2);
    } 
    str2 = getDeviceModel();
    if (!TextUtils.isEmpty(str2)) {
      if (!TextUtils.isEmpty(paramStringBuffer.toString()))
        paramStringBuffer.append("&"); 
      paramStringBuffer.append("device_model");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str2);
    } 
    String str1 = (new c(paramContext)).b();
    if (!TextUtils.isEmpty(str1) && !paramBoolean)
      try {
        str1 = URLEncoder.encode(str1, "UTF-8");
        if (!TextUtils.isEmpty(paramStringBuffer.toString()))
          paramStringBuffer.append("&"); 
        paramStringBuffer.append("cp");
        paramStringBuffer.append("=");
        paramStringBuffer.append(str1);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        Logger.e(TAG, "cp UnsupportedEncodingException.", unsupportedEncodingException);
      }  
    str1 = getCountrySource();
    if (!TextUtils.isEmpty(str1)) {
      if (!TextUtils.isEmpty(paramStringBuffer.toString()))
        paramStringBuffer.append("&"); 
      paramStringBuffer.append("country_source");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str1);
    } 
    return paramStringBuffer;
  }
  
  private boolean isEqual(String paramString1, String paramString2) {
    if (paramString1 == null && paramString2 == null)
      return true; 
    if (paramString1 != null) {
      if (paramString2 == null)
        return false; 
      if (paramString1.equals(paramString2))
        return true; 
    } 
    return false;
  }
  
  public GrsBaseInfo clone() {
    return (GrsBaseInfo)super.clone();
  }
  
  public boolean compare(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (GrsBaseInfo.class != paramObject.getClass())
        return false; 
      if (paramObject instanceof GrsBaseInfo) {
        paramObject = paramObject;
        return (isEqual(this.serCountry, ((GrsBaseInfo)paramObject).serCountry) && isEqual(this.versionName, ((GrsBaseInfo)paramObject).versionName) && isEqual(this.appName, ((GrsBaseInfo)paramObject).appName) && isEqual(this.uid, ((GrsBaseInfo)paramObject).uid) && isEqual(this.regCountry, ((GrsBaseInfo)paramObject).regCountry) && isEqual(this.issueCountry, ((GrsBaseInfo)paramObject).issueCountry) && isEqual(this.androidVersion, ((GrsBaseInfo)paramObject).androidVersion) && isEqual(this.romVersion, ((GrsBaseInfo)paramObject).romVersion) && isEqual(this.deviceModel, ((GrsBaseInfo)paramObject).deviceModel) && isEqual(this.countrySource, ((GrsBaseInfo)paramObject).countrySource));
      } 
    } 
    return false;
  }
  
  public GrsBaseInfo copy() {
    GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
    grsBaseInfo.setAppName(this.appName);
    grsBaseInfo.setSerCountry(this.serCountry);
    grsBaseInfo.setRegCountry(this.regCountry);
    grsBaseInfo.setIssueCountry(this.issueCountry);
    grsBaseInfo.setCountrySource(this.countrySource);
    grsBaseInfo.setAndroidVersion(this.androidVersion);
    grsBaseInfo.setDeviceModel(this.deviceModel);
    grsBaseInfo.setRomVersion(this.romVersion);
    grsBaseInfo.setUid(this.uid);
    grsBaseInfo.setVersionName(this.versionName);
    return grsBaseInfo;
  }
  
  public String getAndroidVersion() {
    return this.androidVersion;
  }
  
  public String getAppName() {
    return this.appName;
  }
  
  public String getCountrySource() {
    return this.countrySource;
  }
  
  public String getDeviceModel() {
    return this.deviceModel;
  }
  
  public String getGrsParasKey(boolean paramBoolean1, boolean paramBoolean2, Context paramContext) {
    String str2;
    StringBuffer stringBuffer = new StringBuffer();
    a a = b.a(paramContext.getPackageName(), this).a();
    if (a != null) {
      str2 = a.a();
    } else {
      str2 = "";
    } 
    String str3 = getAppName();
    if (!TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
      stringBuffer.append("app_name");
      stringBuffer.append("=");
      stringBuffer.append(str3);
    } 
    String str1 = getGrsReqParamJoint(paramBoolean1, paramBoolean2, str2, paramContext);
    if (!TextUtils.isEmpty(str1)) {
      if (!TextUtils.isEmpty(stringBuffer.toString()))
        stringBuffer.append("&"); 
      stringBuffer.append(str1);
    } 
    return stringBuffer.toString();
  }
  
  public String getGrsReqParamJoint(boolean paramBoolean1, boolean paramBoolean2, String paramString, Context paramContext) {
    // Byte code:
    //   0: new java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: ldc '1.0'
    //   11: aload_3
    //   12: invokevirtual equals : (Ljava/lang/Object;)Z
    //   15: ifeq -> 29
    //   18: getstatic com/huawei/hms/framework/network/grs/GrsBaseInfo.TAG : Ljava/lang/String;
    //   21: ldc '1.0 interface has no query param appname'
    //   23: invokestatic v : (Ljava/lang/String;Ljava/lang/Object;)V
    //   26: goto -> 96
    //   29: aload_3
    //   30: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   33: ifne -> 62
    //   36: aload #5
    //   38: ldc 'app_name'
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   43: pop
    //   44: aload #5
    //   46: ldc '='
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload #5
    //   54: aload_3
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   58: pop
    //   59: goto -> 96
    //   62: aload_0
    //   63: invokevirtual getAppName : ()Ljava/lang/String;
    //   66: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   69: ifne -> 96
    //   72: aload #5
    //   74: ldc 'app_name'
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   79: pop
    //   80: aload #5
    //   82: ldc '='
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   87: pop
    //   88: aload_0
    //   89: invokevirtual getAppName : ()Ljava/lang/String;
    //   92: astore_3
    //   93: goto -> 52
    //   96: aload_0
    //   97: invokevirtual getVersionName : ()Ljava/lang/String;
    //   100: astore_3
    //   101: aload_3
    //   102: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   105: ifne -> 150
    //   108: aload #5
    //   110: invokevirtual toString : ()Ljava/lang/String;
    //   113: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   116: ifne -> 127
    //   119: aload #5
    //   121: ldc '&'
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   126: pop
    //   127: aload #5
    //   129: ldc 'app_version'
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   134: pop
    //   135: aload #5
    //   137: ldc '='
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload #5
    //   145: aload_3
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   149: pop
    //   150: aload_0
    //   151: invokevirtual getUid : ()Ljava/lang/String;
    //   154: astore_3
    //   155: aload_3
    //   156: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   159: ifne -> 235
    //   162: aload #5
    //   164: invokevirtual toString : ()Ljava/lang/String;
    //   167: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   170: ifne -> 181
    //   173: aload #5
    //   175: ldc '&'
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   180: pop
    //   181: aload #5
    //   183: ldc 'uid'
    //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   188: pop
    //   189: aload #5
    //   191: ldc '='
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   196: pop
    //   197: iload_1
    //   198: ifeq -> 216
    //   201: aload_3
    //   202: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   205: astore_3
    //   206: aload #5
    //   208: aload_3
    //   209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: goto -> 235
    //   216: iload_2
    //   217: ifeq -> 228
    //   220: aload_3
    //   221: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   224: astore_3
    //   225: goto -> 206
    //   228: aload #5
    //   230: aload_3
    //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   234: pop
    //   235: aload_0
    //   236: invokevirtual getRegCountry : ()Ljava/lang/String;
    //   239: astore_3
    //   240: aload_3
    //   241: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   244: ifne -> 298
    //   247: ldc 'UNKNOWN'
    //   249: aload_3
    //   250: invokevirtual equals : (Ljava/lang/Object;)Z
    //   253: ifne -> 298
    //   256: aload #5
    //   258: invokevirtual toString : ()Ljava/lang/String;
    //   261: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   264: ifne -> 275
    //   267: aload #5
    //   269: ldc '&'
    //   271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   274: pop
    //   275: aload #5
    //   277: ldc 'reg_country'
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   282: pop
    //   283: aload #5
    //   285: ldc '='
    //   287: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   290: pop
    //   291: aload #5
    //   293: aload_3
    //   294: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   297: pop
    //   298: aload_0
    //   299: invokevirtual getSerCountry : ()Ljava/lang/String;
    //   302: astore_3
    //   303: aload_3
    //   304: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   307: ifne -> 361
    //   310: ldc 'UNKNOWN'
    //   312: aload_3
    //   313: invokevirtual equals : (Ljava/lang/Object;)Z
    //   316: ifne -> 361
    //   319: aload #5
    //   321: invokevirtual toString : ()Ljava/lang/String;
    //   324: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   327: ifne -> 338
    //   330: aload #5
    //   332: ldc '&'
    //   334: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   337: pop
    //   338: aload #5
    //   340: ldc 'ser_country'
    //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   345: pop
    //   346: aload #5
    //   348: ldc '='
    //   350: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   353: pop
    //   354: aload #5
    //   356: aload_3
    //   357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   360: pop
    //   361: aload_0
    //   362: invokevirtual getIssueCountry : ()Ljava/lang/String;
    //   365: astore_3
    //   366: aload_3
    //   367: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   370: ifne -> 425
    //   373: ldc 'UNKNOWN'
    //   375: aload_3
    //   376: invokevirtual equals : (Ljava/lang/Object;)Z
    //   379: ifne -> 425
    //   382: aload #5
    //   384: invokevirtual toString : ()Ljava/lang/String;
    //   387: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   390: ifne -> 401
    //   393: aload #5
    //   395: ldc '&'
    //   397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   400: pop
    //   401: aload #5
    //   403: ldc_w 'issue_country'
    //   406: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   409: pop
    //   410: aload #5
    //   412: ldc '='
    //   414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   417: pop
    //   418: aload #5
    //   420: aload_3
    //   421: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   424: pop
    //   425: aload_0
    //   426: aload #5
    //   428: iload_2
    //   429: aload #4
    //   431: invokespecial getStringBuffer : (Ljava/lang/StringBuffer;ZLandroid/content/Context;)Ljava/lang/StringBuffer;
    //   434: invokevirtual toString : ()Ljava/lang/String;
    //   437: areturn
  }
  
  public String getIssueCountry() {
    return this.issueCountry;
  }
  
  public String getRegCountry() {
    return this.regCountry;
  }
  
  public String getRomVersion() {
    return this.romVersion;
  }
  
  public String getSerCountry() {
    return this.serCountry;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public String getVersionName() {
    return this.versionName;
  }
  
  public void setAndroidVersion(String paramString) {
    this.androidVersion = paramString;
  }
  
  public void setAppName(String paramString) {
    this.appName = paramString;
  }
  
  public void setCountrySource(String paramString) {
    this.countrySource = paramString;
  }
  
  public void setDeviceModel(String paramString) {
    this.deviceModel = paramString;
  }
  
  @Deprecated
  public void setIssueCountry(String paramString) {
    this.issueCountry = paramString;
  }
  
  public void setRegCountry(String paramString) {
    this.regCountry = paramString;
  }
  
  public void setRomVersion(String paramString) {
    this.romVersion = paramString;
  }
  
  public void setSerCountry(String paramString) {
    this.serCountry = paramString;
  }
  
  public void setUid(String paramString) {
    this.uid = paramString;
  }
  
  public void setVersionName(String paramString) {
    this.versionName = paramString;
  }
  
  public int uniqueCode() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.appName);
    stringBuilder.append("#");
    stringBuilder.append(this.serCountry);
    stringBuilder.append("#");
    stringBuilder.append(this.regCountry);
    stringBuilder.append("#");
    stringBuilder.append(this.issueCountry);
    return stringBuilder.toString().hashCode();
  }
  
  public static @interface CountryCodeSource {
    public static final String APP = "APP";
    
    public static final String LOCALE_INFO = "LOCALE_INFO";
    
    public static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
    
    public static final String SIM_COUNTRY = "SIM_COUNTRY";
    
    public static final String UNKNOWN = "UNKNOWN";
    
    public static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\GrsBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */