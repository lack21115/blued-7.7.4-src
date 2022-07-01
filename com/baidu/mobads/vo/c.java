package com.baidu.mobads.vo;

import android.text.TextUtils;
import com.baidu.mobads.d.a;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import java.util.ArrayList;

public class c implements IXAdResponseInfo {
  private int a;
  
  private Boolean b;
  
  private String c;
  
  private int d;
  
  private int e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private int i;
  
  private int j;
  
  private String k;
  
  private String l;
  
  private String m;
  
  private String n;
  
  private String o;
  
  private ArrayList<IXAdInstanceInfo> p;
  
  private long q;
  
  public c(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: iconst_0
    //   5: istore #4
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield a : I
    //   12: aload_0
    //   13: iconst_0
    //   14: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   17: putfield b : Ljava/lang/Boolean;
    //   20: aload_0
    //   21: iconst_m1
    //   22: putfield i : I
    //   25: aload_0
    //   26: iconst_m1
    //   27: putfield j : I
    //   30: aload_0
    //   31: new java/util/ArrayList
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: putfield p : Ljava/util/ArrayList;
    //   41: aload_0
    //   42: aload_1
    //   43: putfield o : Ljava/lang/String;
    //   46: aload_0
    //   47: invokestatic currentTimeMillis : ()J
    //   50: putfield q : J
    //   53: aload_1
    //   54: putstatic com/baidu/mobads/b/a.c : Ljava/lang/String;
    //   57: new org/json/JSONObject
    //   60: dup
    //   61: aload_1
    //   62: invokespecial <init> : (Ljava/lang/String;)V
    //   65: astore_1
    //   66: aload_1
    //   67: ldc 'ad'
    //   69: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   72: astore #5
    //   74: aload #5
    //   76: ifnull -> 135
    //   79: iconst_0
    //   80: istore_2
    //   81: aload #5
    //   83: invokevirtual length : ()I
    //   86: istore_3
    //   87: iload_2
    //   88: iload_3
    //   89: if_icmpge -> 135
    //   92: aload #5
    //   94: iload_2
    //   95: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   98: astore #6
    //   100: aload_0
    //   101: getfield p : Ljava/util/ArrayList;
    //   104: new com/baidu/mobads/vo/XAdInstanceInfo
    //   107: dup
    //   108: aload #6
    //   110: invokespecial <init> : (Lorg/json/JSONObject;)V
    //   113: invokevirtual add : (Ljava/lang/Object;)Z
    //   116: pop
    //   117: iload_2
    //   118: iconst_1
    //   119: iadd
    //   120: istore_2
    //   121: goto -> 81
    //   124: aload_0
    //   125: new java/util/ArrayList
    //   128: dup
    //   129: invokespecial <init> : ()V
    //   132: putfield p : Ljava/util/ArrayList;
    //   135: aload_0
    //   136: aload_1
    //   137: ldc 'n'
    //   139: iconst_0
    //   140: invokevirtual optInt : (Ljava/lang/String;I)I
    //   143: putfield a : I
    //   146: aload_0
    //   147: aload_1
    //   148: ldc 'x'
    //   150: iconst_0
    //   151: invokevirtual optInt : (Ljava/lang/String;I)I
    //   154: putfield d : I
    //   157: aload_0
    //   158: aload_1
    //   159: ldc 'y'
    //   161: iconst_0
    //   162: invokevirtual optInt : (Ljava/lang/String;I)I
    //   165: putfield e : I
    //   168: aload_1
    //   169: ldc 'm'
    //   171: iconst_0
    //   172: invokevirtual optInt : (Ljava/lang/String;I)I
    //   175: iconst_1
    //   176: if_icmpne -> 182
    //   179: iconst_1
    //   180: istore #4
    //   182: aload_0
    //   183: iload #4
    //   185: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   188: putfield b : Ljava/lang/Boolean;
    //   191: aload_0
    //   192: aload_1
    //   193: ldc 'u'
    //   195: ldc ''
    //   197: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: putfield c : Ljava/lang/String;
    //   203: aload_0
    //   204: aload_1
    //   205: ldc 'exp2'
    //   207: ldc '{}'
    //   209: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield f : Ljava/lang/String;
    //   215: aload_0
    //   216: aload_1
    //   217: ldc 'ext_act'
    //   219: ldc '{}'
    //   221: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: putfield g : Ljava/lang/String;
    //   227: aload_0
    //   228: aload_1
    //   229: ldc 'lunpan'
    //   231: iconst_m1
    //   232: invokevirtual optInt : (Ljava/lang/String;I)I
    //   235: putfield i : I
    //   238: aload_0
    //   239: aload_1
    //   240: ldc 'intIcon'
    //   242: iconst_m1
    //   243: invokevirtual optInt : (Ljava/lang/String;I)I
    //   246: putfield j : I
    //   249: aload_0
    //   250: aload_1
    //   251: ldc 'ck'
    //   253: ldc ''
    //   255: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   258: putfield k : Ljava/lang/String;
    //   261: aload_0
    //   262: aload_1
    //   263: ldc 'req_id'
    //   265: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   268: putfield l : Ljava/lang/String;
    //   271: aload_0
    //   272: aload_1
    //   273: ldc 'error_code'
    //   275: ldc ''
    //   277: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   280: putfield m : Ljava/lang/String;
    //   283: aload_0
    //   284: aload_1
    //   285: ldc 'error_msg'
    //   287: ldc ''
    //   289: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   292: putfield n : Ljava/lang/String;
    //   295: aload_0
    //   296: aload_1
    //   297: ldc 'theme'
    //   299: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   302: putfield h : Ljava/lang/String;
    //   305: return
    //   306: astore #5
    //   308: goto -> 124
    //   311: astore #6
    //   313: goto -> 117
    //   316: astore_1
    //   317: return
    // Exception table:
    //   from	to	target	type
    //   66	74	306	java/lang/Exception
    //   81	87	306	java/lang/Exception
    //   92	117	311	org/json/JSONException
    //   92	117	306	java/lang/Exception
    //   295	305	316	org/json/JSONException
  }
  
  public ArrayList<IXAdInstanceInfo> getAdInstanceList() {
    return this.p;
  }
  
  public int getAdsNum() {
    return this.a;
  }
  
  public String getBaiduidOfCookie() {
    return this.k;
  }
  
  public String getDefaultFillInThemeForStaticAds() {
    return this.h;
  }
  
  public String getErrorCode() {
    return a.b(this.m);
  }
  
  public String getErrorMessage() {
    if (!TextUtils.isEmpty(this.n))
      return this.n; 
    String str = a.a(this.m);
    if (str != null) {
      this.n = str;
    } else {
      this.n = "";
    } 
    return this.n;
  }
  
  public String getExp2() {
    return this.f;
  }
  
  public String getExtentionActionExp() {
    return this.g;
  }
  
  public int getIntIcon() {
    return this.j;
  }
  
  public int getLatitude() {
    return this.e;
  }
  
  public int getLongitude() {
    return this.d;
  }
  
  public int getLunpan() {
    return this.i;
  }
  
  public Boolean getOpenPointModeForWall() {
    return this.b;
  }
  
  public String getOriginResponseStr() {
    return this.o;
  }
  
  public String getPointUnitForWall() {
    return this.c;
  }
  
  public IXAdInstanceInfo getPrimaryAdInstanceInfo() {
    return (this.p.size() > 0) ? this.p.get(0) : null;
  }
  
  public String getRequestId() {
    return this.l;
  }
  
  public long getTimeStamp() {
    return this.q;
  }
  
  public void setAdInstanceList(ArrayList<IXAdInstanceInfo> paramArrayList) {
    this.p = paramArrayList;
  }
  
  public void setAdsNum(int paramInt) {
    this.a = paramInt;
  }
  
  public void setBaiduidOfCookie(String paramString) {
    this.k = paramString;
  }
  
  public void setDefaultFillInThemeForStaticAds(String paramString) {
    this.h = paramString;
  }
  
  public void setErrorCode(String paramString) {
    this.m = paramString;
  }
  
  public void setErrorMessage(String paramString) {
    this.n = paramString;
  }
  
  public void setExp2(String paramString) {
    this.f = paramString;
  }
  
  public void setExtentionActionExp(String paramString) {
    this.g = paramString;
  }
  
  public void setIntIcon(int paramInt) {
    this.j = paramInt;
  }
  
  public void setLatitude(int paramInt) {
    this.e = paramInt;
  }
  
  public void setLongitude(int paramInt) {
    this.d = paramInt;
  }
  
  public void setLunpan(int paramInt) {
    this.i = paramInt;
  }
  
  public void setOpenPointModeForWall(Boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public void setOriginResponseStr(String paramString) {
    this.o = paramString;
  }
  
  public void setPointUnitForWall(String paramString) {
    this.c = paramString;
  }
  
  public void setRequestId(String paramString) {
    this.l = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\vo\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */