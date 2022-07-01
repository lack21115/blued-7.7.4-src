package com.baidu.mobads.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class XAdInstanceInfo implements Parcelable, IXAdInstanceInfo, Cloneable {
  public static final Parcelable.Creator<XAdInstanceInfo> CREATOR = new a();
  
  public static final String TAG = "XAdInstanceInfo";
  
  private int A;
  
  private int B;
  
  @Deprecated
  private String C;
  
  private Set<String> D = new HashSet<String>();
  
  private Set<String> E = new HashSet<String>();
  
  private Set<String> F = new HashSet<String>();
  
  private Set<String> G = new HashSet<String>();
  
  private Set<String> H = new HashSet<String>();
  
  private Set<String> I = new HashSet<String>();
  
  private Set<String> J = new HashSet<String>();
  
  private Set<String> K = new HashSet<String>();
  
  private Set<String> L = new HashSet<String>();
  
  private Set<String> M = new HashSet<String>();
  
  private Set<String> N = new HashSet<String>();
  
  private Set<String> O = new HashSet<String>();
  
  private Set<String> P = new HashSet<String>();
  
  private int Q;
  
  private int R;
  
  private int S;
  
  private String T;
  
  private String U;
  
  private String V;
  
  private boolean W = true;
  
  private String X;
  
  private String Y;
  
  private String Z;
  
  private String a;
  
  private int aA;
  
  private int aB;
  
  private int aC;
  
  private int aD;
  
  private boolean aE = false;
  
  private String aF = null;
  
  private String aa;
  
  private String ab;
  
  private long ac;
  
  private int ad;
  
  private String ae;
  
  private int af;
  
  private boolean ag;
  
  private long ah;
  
  private IXAdInstanceInfo.CreativeType ai = IXAdInstanceInfo.CreativeType.NONE;
  
  private String aj;
  
  private int ak;
  
  private boolean al = true;
  
  private boolean am;
  
  private boolean an = true;
  
  private boolean ao = true;
  
  private boolean ap;
  
  private boolean aq;
  
  private boolean ar;
  
  private boolean as;
  
  private String at;
  
  private String au;
  
  private String av;
  
  private JSONArray aw;
  
  private boolean ax = false;
  
  private String ay;
  
  private boolean az;
  
  private String b = "-1";
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private int l;
  
  private String m;
  
  private String n;
  
  private boolean o;
  
  private int p;
  
  private String q = "";
  
  private String r = "";
  
  private int s = 0;
  
  private int t = 0;
  
  @Deprecated
  private boolean u;
  
  @Deprecated
  private int v;
  
  private String w;
  
  private String x;
  
  private JSONObject y;
  
  private String z;
  
  private XAdInstanceInfo(Parcel paramParcel) {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.ab = paramParcel.readString();
    this.ae = paramParcel.readString();
    this.aa = paramParcel.readString();
    this.w = paramParcel.readString();
    this.au = paramParcel.readString();
    this.X = paramParcel.readString();
    this.e = paramParcel.readString();
    this.d = paramParcel.readString();
    this.k = paramParcel.readString();
    this.a = paramParcel.readString();
    this.z = paramParcel.readString();
    this.j = paramParcel.readString();
    this.i = paramParcel.readString();
    this.g = paramParcel.readString();
    this.B = paramParcel.readInt();
    this.A = paramParcel.readInt();
    this.x = paramParcel.readString();
    this.C = paramParcel.readString();
    this.h = paramParcel.readString();
    this.Y = paramParcel.readString();
    this.f = paramParcel.readString();
    this.aj = paramParcel.readString();
    this.n = paramParcel.readString();
    this.p = paramParcel.readInt();
    this.at = paramParcel.readString();
    this.av = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.R = paramParcel.readInt();
    this.S = paramParcel.readInt();
    this.T = paramParcel.readString();
    this.U = paramParcel.readString();
    this.V = paramParcel.readString();
    ArrayList<String> arrayList = new ArrayList();
    paramParcel.readStringList(arrayList);
    setStartTrackers(arrayList);
    arrayList = new ArrayList<String>();
    paramParcel.readStringList(arrayList);
    setCloseTrackers(arrayList);
    try {
      this.y = new JSONObject(paramParcel.readString());
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(new Object[] { "XAdInstanceInfo", exception.getMessage() });
    } 
    this.Q = paramParcel.readInt();
    this.aA = paramParcel.readInt();
    this.aB = paramParcel.readInt();
    this.aC = paramParcel.readInt();
    this.aD = paramParcel.readInt();
  }
  
  public XAdInstanceInfo(JSONObject paramJSONObject) {
    this.y = paramJSONObject;
    try {
      boolean bool;
      this.ah = System.currentTimeMillis();
      this.Q = paramJSONObject.optInt("act");
      this.z = paramJSONObject.optString("html", null);
      this.b = paramJSONObject.optString("id", "-1");
      this.c = paramJSONObject.optString("src", "");
      this.d = paramJSONObject.optString("tit", "");
      this.e = paramJSONObject.optString("desc", "");
      this.f = paramJSONObject.optString("surl", "");
      this.h = paramJSONObject.optString("phone", "");
      this.i = paramJSONObject.optString("w_picurl", "");
      this.j = paramJSONObject.optString("icon", "");
      this.k = paramJSONObject.optString("exp2", "{}");
      this.l = paramJSONObject.optInt("anti_tag");
      this.n = paramJSONObject.optString("vurl", "");
      this.p = paramJSONObject.optInt("duration", 0);
      if (paramJSONObject.optInt("sound", 0) == 1) {
        bool = false;
      } else {
        bool = true;
      } 
      this.o = bool;
      if (paramJSONObject.optInt("iv", 0) == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      this.u = bool;
      this.v = paramJSONObject.optInt("dur", 0);
      this.w = paramJSONObject.optString("curl", "");
      this.x = paramJSONObject.optString("ori_curl", "");
      this.R = paramJSONObject.optInt("closetype");
      this.S = paramJSONObject.optInt("expiration");
      this.T = paramJSONObject.optString("mute");
      JSONObject jSONObject2 = paramJSONObject.optJSONObject("ad_html");
      if (jSONObject2 != null) {
        Iterator<String> iterator = jSONObject2.keys();
        while (iterator.hasNext()) {
          String str = iterator.next();
          if (str.equals("banner_snippet")) {
            this.U = jSONObject2.optString(str);
            continue;
          } 
          if (str.equals("int_snippet"))
            this.V = jSONObject2.optString(str); 
        } 
      } 
      this.g = paramJSONObject.optString("type");
      String str2 = this.z;
      if (str2 != null && this.z.length() > 0) {
        this.ai = IXAdInstanceInfo.CreativeType.HTML;
      } else if (this.g != null) {
        if (this.g.equals("text")) {
          this.ai = IXAdInstanceInfo.CreativeType.TEXT;
        } else if (this.g.equals("image")) {
          if (this.i != null && !this.i.equals("")) {
            int i = this.i.toLowerCase(Locale.getDefault()).lastIndexOf('.');
            if (i >= 0) {
              str2 = this.i.toLowerCase(Locale.getDefault()).substring(i);
            } else {
              str2 = "";
            } 
            if (str2.equals(".gif")) {
              this.ai = IXAdInstanceInfo.CreativeType.GIF;
            } else {
              this.ai = IXAdInstanceInfo.CreativeType.STATIC_IMAGE;
            } 
          } 
        } else if (this.g.equals("rm")) {
          this.ai = IXAdInstanceInfo.CreativeType.RM;
        } else if (this.g.equals("video")) {
          this.ai = IXAdInstanceInfo.CreativeType.VIDEO;
        } 
      } 
      this.A = paramJSONObject.optInt("w");
      this.B = paramJSONObject.optInt("h");
      this.C = paramJSONObject.optString("lb_phone", "");
      JSONArray jSONArray2 = paramJSONObject.optJSONArray("nwinurl");
      if (jSONArray2 != null && jSONArray2.length() > 0) {
        for (int i = 0; i < jSONArray2.length(); i++)
          this.D.add(jSONArray2.getString(i)); 
      } else {
        String str = paramJSONObject.optString("winurl", "");
        if (!str.equals(""))
          this.D.add(str); 
      } 
      String str1 = paramJSONObject.optString("clklogurl", "");
      if (!str1.equals(""))
        this.D.add(str1); 
      JSONArray jSONArray1 = paramJSONObject.optJSONArray("mon");
      if (jSONArray1 != null && jSONArray1.length() > 0)
        for (int i = 0; i < jSONArray1.length(); i++) {
          JSONObject jSONObject = jSONArray1.getJSONObject(i);
          String str3 = jSONObject.optString("s", "");
          String str4 = jSONObject.optString("c", "");
          a(str3);
          b(str4);
        }  
      JSONObject jSONObject1 = paramJSONObject.optJSONObject("monitors");
      if (jSONObject1 != null) {
        Iterator<String> iterator = jSONObject1.keys();
        while (iterator.hasNext()) {
          JSONArray jSONArray;
          String str = iterator.next();
          if (str.equals("s")) {
            jSONArray = jSONObject1.optJSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++)
              a(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("vskip")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              addSkipMonitorTrackers(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("scard")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              addScardMonitorTrackers(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("ccard")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              addCcardMonitorTrackers(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("vstart")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              addStartMonitorTrackers(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("vfullscreen")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              addFullScreenMonitorTrackers(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("vclose")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              addCloseMonitorTrackers(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("cstartcard")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              addCstartcardMonitorTrackers(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("c")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              b(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("vcache_succ")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              c(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("vcache_fail")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              d(jSONArray.optString(i)); 
            continue;
          } 
          if (jSONArray.equals("vcache_expire")) {
            jSONArray = jSONObject1.optJSONArray((String)jSONArray);
            for (int i = 0; i < jSONArray.length(); i++)
              e(jSONArray.optString(i)); 
          } 
        } 
      } 
      this.W = true;
      this.X = paramJSONObject.optString("cf", "");
      this.Y = paramJSONObject.optString("qk", "");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.Y);
      stringBuilder.append("_");
      stringBuilder.append((new Random()).nextLong());
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append("|");
      this.Z = stringBuilder.toString();
      this.ab = paramJSONObject.optString("appname", "");
      this.aa = paramJSONObject.optString("pk", "");
      this.ac = paramJSONObject.optLong("sz", 0L);
      this.ad = paramJSONObject.optInt("sb", 0);
      this.ae = paramJSONObject.optString("apo", "");
      this.af = paramJSONObject.optInt("po", 0);
      if (paramJSONObject.optInt("st", 0) == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      this.ag = bool;
      this.r = paramJSONObject.optString("murl", "");
      if (this.g.equals("video") && this.r.length() > 0) {
        this.s = paramJSONObject.optInt("w", 0);
        this.t = paramJSONObject.optInt("h", 0);
        this.q = "video";
        if (this.Q == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeLandingPage())
          this.r = this.w; 
      } 
      this.aA = paramJSONObject.optInt("container_width");
      this.aB = paramJSONObject.optInt("container_height");
      this.aC = paramJSONObject.optInt("size_type");
      this.aD = paramJSONObject.optInt("style_type");
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(new Object[] { "XAdInstanceInfo", exception.getMessage() });
      return;
    } 
  }
  
  final void a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.E.add(paramString); 
  }
  
  public void addCcardMonitorTrackers(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.J.add(paramString); 
  }
  
  public void addCloseMonitorTrackers(String paramString) {
    if (paramString != null && !paramString.equals(""))
      this.L.add(paramString); 
  }
  
  public void addCstartcardMonitorTrackers(String paramString) {
    if (paramString != null && !paramString.equals(""))
      this.M.add(paramString); 
  }
  
  public void addFullScreenMonitorTrackers(String paramString) {
    if (paramString != null && !paramString.equals(""))
      this.K.add(paramString); 
  }
  
  public void addScardMonitorTrackers(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.I.add(paramString); 
  }
  
  public void addSkipMonitorTrackers(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.H.add(paramString); 
  }
  
  public void addStartMonitorTrackers(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.G.add(paramString); 
  }
  
  final void b(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.F.add(paramString); 
  }
  
  final void c(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.N.add(paramString); 
  }
  
  public Object clone() {
    return super.clone();
  }
  
  final void d(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.O.add(paramString); 
  }
  
  public int describeContents() {
    return 0;
  }
  
  final void e(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.P.add(paramString); 
  }
  
  public boolean getAPOOpen() {
    return this.aE;
  }
  
  public String getAction() {
    return this.q;
  }
  
  public int getActionType() {
    return this.Q;
  }
  
  public int getAdContainerHeight() {
    return this.aB;
  }
  
  public int getAdContainerSizeType() {
    return this.aC;
  }
  
  public int getAdContainerWidth() {
    return this.aA;
  }
  
  public boolean getAdHasDisplayed() {
    return this.az;
  }
  
  public String getAdId() {
    return this.b;
  }
  
  public String getAdSource() {
    return this.c;
  }
  
  public int getAntiTag() {
    return this.l;
  }
  
  public String getAppName() {
    return this.ab;
  }
  
  public String getAppOpenStrs() {
    return this.ae;
  }
  
  public String getAppPackageName() {
    return this.aa;
  }
  
  public long getAppSize() {
    return this.ac;
  }
  
  public String getBannerHtmlSnippet() {
    return this.U;
  }
  
  public List<String> getCacheExpireTrackers() {
    return new ArrayList<String>(this.P);
  }
  
  public List<String> getCacheFailTrackers() {
    return new ArrayList<String>(this.O);
  }
  
  public List<String> getCacheSuccTrackers() {
    return new ArrayList<String>(this.N);
  }
  
  public List<String> getCcardTrackers() {
    return new ArrayList<String>(this.J);
  }
  
  public String getClickThroughUrl() {
    return this.w;
  }
  
  public String getClklogurl() {
    return this.au;
  }
  
  public List<String> getCloseTrackers() {
    return new ArrayList<String>(this.L);
  }
  
  public int getCloseType() {
    return this.R;
  }
  
  public String getConfirmBorderPercent() {
    return this.X;
  }
  
  public long getCreateTime() {
    return this.ah;
  }
  
  public IXAdInstanceInfo.CreativeType getCreativeType() {
    return this.ai;
  }
  
  public List<String> getCstartcardTrackers() {
    return new ArrayList<String>(this.M);
  }
  
  public String getDescription() {
    return this.e;
  }
  
  public int getDlTunnel() {
    return this.ak;
  }
  
  public String getExp2ForSingleAd() {
    return this.k;
  }
  
  public int getExpiration() {
    return this.S;
  }
  
  public int getFeedAdStyleType() {
    return this.aD;
  }
  
  public List<String> getFullScreenTrackers() {
    return new ArrayList<String>(this.K);
  }
  
  public String getFwt() {
    return this.a;
  }
  
  public int getHoursInADayToShowAd() {
    return this.v;
  }
  
  public String getHtmlSnippet() {
    return this.z;
  }
  
  public String getIconUrl() {
    return this.j;
  }
  
  public Set<String> getImpressionUrls() {
    return this.D;
  }
  
  public String getIntHtmlSnippet() {
    return this.V;
  }
  
  public String getLocalCreativeURL() {
    return this.m;
  }
  
  public int getMainMaterialHeight() {
    return this.B;
  }
  
  public int getMainMaterialWidth() {
    return this.A;
  }
  
  public String getMainPictureUrl() {
    return this.i;
  }
  
  public String getMaterialType() {
    return this.g;
  }
  
  public String getMute() {
    return this.T;
  }
  
  public JSONArray getNwinurl() {
    return this.aw;
  }
  
  public String getOriginClickUrl() {
    return this.x;
  }
  
  public JSONObject getOriginJsonObject() {
    return this.y;
  }
  
  public String getPage() {
    return this.aF;
  }
  
  public String getPhoneForLocalBranding() {
    return this.C;
  }
  
  public String getPhoneNumber() {
    return this.h;
  }
  
  public int getPointsForWall() {
    return this.af;
  }
  
  public String getQueryKey() {
    return this.Y;
  }
  
  public List<String> getScardTrackers() {
    return new ArrayList<String>(this.I);
  }
  
  public List<String> getSkipTrackers() {
    return new ArrayList<String>(this.H);
  }
  
  public String getSplash3DLocalUrl() {
    return this.ay;
  }
  
  public String getSponsorUrl() {
    return this.f;
  }
  
  public List<String> getStartTrackers() {
    return new ArrayList<String>(this.G);
  }
  
  public int getSwitchButton() {
    return this.ad;
  }
  
  public List<String> getThirdClickTrackingUrls() {
    return new ArrayList<String>(this.F);
  }
  
  public List<String> getThirdImpressionTrackingUrls() {
    return new ArrayList<String>(this.E);
  }
  
  public String getTitle() {
    return this.d;
  }
  
  public String getUniqueId() {
    return this.Z;
  }
  
  public String getUrl() {
    return this.aj;
  }
  
  public int getVideoDuration() {
    return this.p;
  }
  
  public int getVideoHeight() {
    return this.t;
  }
  
  public String getVideoUrl() {
    return this.n;
  }
  
  public int getVideoWidth() {
    return this.s;
  }
  
  public String getVurl() {
    return this.at;
  }
  
  public String getWebUrl() {
    return this.r;
  }
  
  public String getWinurl() {
    return this.av;
  }
  
  public boolean isActionOnlyWifi() {
    return this.W;
  }
  
  public boolean isAutoOpen() {
    return this.an;
  }
  
  public boolean isCanCancel() {
    return this.ar;
  }
  
  public boolean isCanDelete() {
    return this.as;
  }
  
  public boolean isClose() {
    return this.am;
  }
  
  public boolean isIconVisibleForImageType() {
    return this.u;
  }
  
  public boolean isInapp() {
    return this.al;
  }
  
  public boolean isPopNotif() {
    return this.ao;
  }
  
  public boolean isSecondConfirmed() {
    return this.ax;
  }
  
  public boolean isTaskDoneForWall() {
    return this.ag;
  }
  
  public boolean isTooLarge() {
    return this.aq;
  }
  
  public Boolean isValid() {
    return Boolean.valueOf("-1".equalsIgnoreCase(getAdId()) ^ true);
  }
  
  public boolean isVideoMuted() {
    return this.o;
  }
  
  public boolean isWifiTargeted() {
    return this.ap;
  }
  
  public void setAPOOpen(boolean paramBoolean) {
    this.aE = paramBoolean;
  }
  
  public void setAction(String paramString) {
    this.q = paramString;
  }
  
  public void setActionOnlyWifi(boolean paramBoolean) {
    this.W = paramBoolean;
  }
  
  public void setActionType(int paramInt) {
    this.Q = paramInt;
  }
  
  public void setAdContainerHeight(int paramInt) {
    this.aB = paramInt;
  }
  
  public void setAdContainerSizeType(int paramInt) {
    this.aC = paramInt;
  }
  
  public void setAdContainerWidth(int paramInt) {
    this.aA = paramInt;
  }
  
  public void setAdHasDisplayed(boolean paramBoolean) {
    this.az = paramBoolean;
  }
  
  public void setAdId(String paramString) {
    this.b = paramString;
  }
  
  public void setAdSource(String paramString) {
    this.c = paramString;
  }
  
  public void setAntiTag(int paramInt) {
    this.l = paramInt;
  }
  
  public void setAppName(String paramString) {
    this.ab = paramString;
  }
  
  public void setAppOpenStrs(String paramString) {
    this.ae = paramString;
  }
  
  public void setAppPackageName(String paramString) {
    this.aa = paramString;
  }
  
  public void setAppSize(long paramLong) {
    this.ac = paramLong;
  }
  
  public void setAutoOpen(boolean paramBoolean) {
    this.an = paramBoolean;
  }
  
  public void setBannerHtmlSnippet(String paramString) {
    this.U = paramString;
  }
  
  public void setCacheExpireTrackers(List<String> paramList) {
    try {
      this.P.clear();
      this.P.addAll(paramList);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(exception);
      return;
    } 
  }
  
  public void setCacheFailTrackers(List<String> paramList) {
    try {
      this.O.clear();
      this.O.addAll(paramList);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(exception);
      return;
    } 
  }
  
  public void setCacheSuccTrackers(List<String> paramList) {
    try {
      this.N.clear();
      this.N.addAll(paramList);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(exception);
      return;
    } 
  }
  
  public void setCanCancel(boolean paramBoolean) {
    this.ar = paramBoolean;
  }
  
  public void setCanDelete(boolean paramBoolean) {
    this.as = paramBoolean;
  }
  
  public void setCcardTrackers(List<String> paramList) {
    this.J.addAll(paramList);
  }
  
  public void setClickThroughUrl(String paramString) {
    this.w = paramString;
  }
  
  public void setClklogurl(String paramString) {
    this.au = paramString;
  }
  
  public void setClose(boolean paramBoolean) {
    this.am = paramBoolean;
  }
  
  public void setCloseTrackers(List<String> paramList) {
    try {
      this.L.clear();
      this.L.addAll(paramList);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(exception);
      return;
    } 
  }
  
  public void setCloseType(int paramInt) {
    this.R = paramInt;
  }
  
  public void setConfirmBorderPercent(String paramString) {
    this.X = paramString;
  }
  
  public void setCreateTime(long paramLong) {
    this.ah = paramLong;
  }
  
  public void setCreativeType(IXAdInstanceInfo.CreativeType paramCreativeType) {
    this.ai = paramCreativeType;
  }
  
  public void setCstartcardTrackers(List<String> paramList) {
    this.M.clear();
    this.M.addAll(paramList);
  }
  
  public void setDescription(String paramString) {
    this.e = paramString;
  }
  
  public void setDlTunnel(int paramInt) {
    this.ak = paramInt;
  }
  
  public void setExp2ForSingleAd(String paramString) {
    this.k = paramString;
  }
  
  public void setExpiration(int paramInt) {
    this.S = paramInt;
  }
  
  public void setFeedAdStyleType(int paramInt) {
    this.aD = paramInt;
  }
  
  public void setFullScreenTrackers(List<String> paramList) {
    this.K.addAll(paramList);
  }
  
  public void setFwt(String paramString) {
    this.a = paramString;
  }
  
  public void setHoursInADayToShowAd(int paramInt) {
    this.v = paramInt;
  }
  
  public void setHtmlSnippet(String paramString) {
    this.z = paramString;
  }
  
  public void setIconUrl(String paramString) {
    this.j = paramString;
  }
  
  public void setIconVisibleForImageType(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public void setImpressionUrls(Set<String> paramSet) {
    this.D = paramSet;
  }
  
  public void setInapp(boolean paramBoolean) {
    this.al = paramBoolean;
  }
  
  public void setIntHtmlSnippet(String paramString) {
    this.V = paramString;
  }
  
  public void setLocalCreativeURL(String paramString) {
    this.m = paramString;
  }
  
  public void setMainMaterialHeight(int paramInt) {
    this.B = paramInt;
  }
  
  public void setMainMaterialWidth(int paramInt) {
    this.A = paramInt;
  }
  
  public void setMainPictureUrl(String paramString) {
    this.i = paramString;
  }
  
  public void setMaterialType(String paramString) {
    this.g = paramString;
  }
  
  public void setMute(String paramString) {
    this.T = paramString;
  }
  
  public void setNwinurl(JSONArray paramJSONArray) {
    this.aw = paramJSONArray;
  }
  
  public void setOriginClickUrl(String paramString) {
    this.x = paramString;
  }
  
  public void setPage(String paramString) {
    this.aF = paramString;
  }
  
  public void setPhoneForLocalBranding(String paramString) {
    this.C = paramString;
  }
  
  public void setPhoneNumber(String paramString) {
    this.h = paramString;
  }
  
  public void setPointsForWall(int paramInt) {
    this.af = paramInt;
  }
  
  public void setPopNotif(boolean paramBoolean) {
    this.ao = paramBoolean;
  }
  
  public void setQueryKey(String paramString) {
    this.Y = paramString;
  }
  
  public void setScardTrackers(List<String> paramList) {
    this.I.addAll(paramList);
  }
  
  public void setSecondConfirmed(boolean paramBoolean) {
    this.ax = paramBoolean;
  }
  
  public void setSkipTrackers(List<String> paramList) {
    this.H.addAll(paramList);
  }
  
  public void setSplash3DLocalUrl(String paramString) {
    this.ay = paramString;
  }
  
  public void setSponsorUrl(String paramString) {
    this.f = paramString;
  }
  
  public void setStartTrackers(List<String> paramList) {
    try {
      this.G.clear();
      this.G.addAll(paramList);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(exception);
      return;
    } 
  }
  
  public void setSwitchButton(int paramInt) {
    this.ad = paramInt;
  }
  
  public void setTaskDoneForWall(boolean paramBoolean) {
    this.ag = paramBoolean;
  }
  
  public void setThirdClickTrackingUrls(Set<String> paramSet) {
    this.F = paramSet;
  }
  
  public void setThirdImpressionTrackingUrls(Set<String> paramSet) {
    this.E = paramSet;
  }
  
  public void setTitle(String paramString) {
    this.d = paramString;
  }
  
  public void setTooLarge(boolean paramBoolean) {
    this.aq = paramBoolean;
  }
  
  public void setUrl(String paramString) {
    this.aj = paramString;
  }
  
  public void setVideoDuration(int paramInt) {
    this.p = paramInt;
  }
  
  public void setVideoHeight(int paramInt) {
    this.t = paramInt;
  }
  
  public void setVideoMuted(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  public void setVideoUrl(String paramString) {
    this.n = paramString;
  }
  
  public void setVideoWidth(int paramInt) {
    this.s = paramInt;
  }
  
  public void setVurl(String paramString) {
    this.at = paramString;
  }
  
  public void setWebUrl(String paramString) {
    this.r = paramString;
  }
  
  public void setWifiTargeted(boolean paramBoolean) {
    this.ap = paramBoolean;
  }
  
  public void setWinurl(String paramString) {
    this.av = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.ab);
    paramParcel.writeString(this.ae);
    paramParcel.writeString(this.aa);
    paramParcel.writeString(this.w);
    paramParcel.writeString(this.au);
    paramParcel.writeString(this.X);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.z);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.B);
    paramParcel.writeInt(this.A);
    paramParcel.writeString(this.x);
    paramParcel.writeString(this.C);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.Y);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.aj);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.p);
    paramParcel.writeString(this.at);
    paramParcel.writeString(this.av);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeInt(this.R);
    paramParcel.writeInt(this.S);
    paramParcel.writeString(this.T);
    paramParcel.writeString(this.U);
    paramParcel.writeString(this.V);
    paramParcel.writeStringList(getStartTrackers());
    paramParcel.writeStringList(getCloseTrackers());
    paramParcel.writeString(this.y.toString());
    paramParcel.writeInt(this.Q);
    paramParcel.writeInt(this.aA);
    paramParcel.writeInt(this.aB);
    paramParcel.writeInt(this.aC);
    paramParcel.writeInt(this.aD);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\vo\XAdInstanceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */