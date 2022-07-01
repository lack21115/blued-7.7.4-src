package com.baidu.mobads.production.g;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.b.f;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.r;
import com.baidu.mobads.vo.XAdInstanceInfo;
import com.baidu.mobads.vo.b;
import com.baidu.mobads.vo.d;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b {
  private static boolean F = false;
  
  private static int G;
  
  private Context A;
  
  private boolean B;
  
  private String C;
  
  private String D;
  
  private int E;
  
  private Observer H;
  
  protected final IXAdLogger y;
  
  private d z;
  
  public a(Context paramContext, RelativeLayout paramRelativeLayout, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramContext);
    String str;
    this.B = false;
    this.y = XAdSDKFoundationFacade.getInstance().getAdLogger();
    this.H = new b(this);
    setId(paramString);
    setActivity(paramContext);
    setAdSlotBase(paramRelativeLayout);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_SPLASH;
    this.A = paramContext;
    this.m = paramInt4;
    this.E = paramInt3;
    this.z = new d(getApplicationContext(), this.o);
    this.z.a(paramBoolean);
    l l = XAdSDKFoundationFacade.getInstance().getAdConstants();
    if (paramBoolean) {
      ArrayList<String> arrayList = new ArrayList();
      arrayList.add(l.getSupportedActionType4RequestingNone());
      arrayList.add(l.getSupportedActionType4RequestingLandingPage());
      arrayList.add(l.a());
      XAdSDKFoundationFacade.getInstance().getPackageUtils();
      if (r.b(paramContext))
        arrayList.add(l.getSupportedActionType4RequestingDownload()); 
      str = XAdSDKFoundationFacade.getInstance().getCommonUtils().a(arrayList);
    } else {
      str = l.getSupportedActionType4RequestingNone();
    } 
    this.z.b(str);
    this.z.d(paramInt1);
    this.z.e(paramInt2);
    this.z.d(paramString);
    f(paramString);
  }
  
  public static void a(int paramInt) {
    G = paramInt;
  }
  
  private void a(Handler paramHandler) {}
  
  private boolean a(File paramFile, URL paramURL) {
    if (paramFile.exists())
      try {
        HttpURLConnection httpURLConnection = (HttpURLConnection)paramURL.openConnection();
        httpURLConnection.setRequestMethod("HEAD");
        int i = Integer.parseInt(httpURLConnection.getHeaderField("content-length"));
        XAdSDKFoundationFacade.getInstance().getURIUitls().closeHttpURLConnection(httpURLConnection);
        if (i > 0) {
          long l = paramFile.length();
          if (l == i)
            return false; 
        } 
      } catch (Exception exception) {} 
    return true;
  }
  
  public static boolean b() {
    return F;
  }
  
  private void g(String paramString) {
    ((XAdInstanceInfo)this.d).setSplash3DLocalUrl(paramString);
    if (i() && TextUtils.isEmpty(((XAdInstanceInfo)this.d).getLocalCreativeURL())) {
      this.y.e("zip pic no download");
      return;
    } 
    b("splash back pic ready");
  }
  
  public d a() {
    return this.z;
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    com.baidu.mobads.constants.a.r = System.currentTimeMillis();
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("m_new_rsplash", String.valueOf(com.baidu.mobads.constants.a.l));
      hashMap.put("m_start_request", String.valueOf(com.baidu.mobads.constants.a.m));
      hashMap.put("m_end_request", String.valueOf(com.baidu.mobads.constants.a.n));
      hashMap.put("m_start_dex", String.valueOf(com.baidu.mobads.constants.a.o));
      hashMap.put("m_end_dex", String.valueOf(com.baidu.mobads.constants.a.p));
      hashMap.put("m_start_load", String.valueOf(com.baidu.mobads.constants.a.q));
      hashMap.put("m_end_load", String.valueOf(com.baidu.mobads.constants.a.r));
      hashMap.put("isRequestAndLoadAdTimeout", String.valueOf(this.B));
      IXAdResponseInfo iXAdResponseInfo = getAdResponseInfo();
      if (iXAdResponseInfo != null) {
        IXAdInstanceInfo iXAdInstanceInfo1 = iXAdResponseInfo.getPrimaryAdInstanceInfo();
      } else {
        iXAdResponseInfo = null;
      } 
      JSONObject jSONObject2 = this.z.d().getAttribute();
      JSONObject jSONObject1 = jSONObject2;
      if (jSONObject2 == null)
        jSONObject1 = new JSONObject(); 
      try {
        jSONObject1.put("splashTipStyle", this.E);
      } catch (JSONException jSONException) {}
      ((b)this.z.d()).a(jSONObject1);
      com.baidu.mobads.b.a.a().a(this.A, "386", (IXAdInstanceInfo)iXAdResponseInfo, this.z.d(), hashMap);
    } catch (Exception null) {}
    if (this.B)
      return; 
    start();
    Handler handler = new Handler(this.A.getMainLooper());
    dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdLoaded"));
    if (paramHashMap == null)
      try {
        a(handler);
        return;
      } catch (Exception exception) {
        return;
      }  
    IXAdInstanceInfo iXAdInstanceInfo = (IXAdInstanceInfo)paramHashMap.get("AdInstance");
    IXAdInstanceInfo.CreativeType creativeType = iXAdInstanceInfo.getCreativeType();
    if (creativeType != IXAdInstanceInfo.CreativeType.VIDEO && creativeType != IXAdInstanceInfo.CreativeType.RM) {
      a((Handler)exception);
      return;
    } 
    com.baidu.mobads.b.a.a().a(this.A, "383", iXAdInstanceInfo, this.z.d(), new Object[] { "processAdLoaded" });
  }
  
  public void a(b paramb, u paramu, int paramInt) {
    b b1 = (b)this.k.d();
    JSONObject jSONObject2 = b1.getAttribute();
    JSONObject jSONObject1 = jSONObject2;
    if (jSONObject2 == null)
      jSONObject1 = new JSONObject(); 
    try {
      jSONObject1.put("needRequestVR", F);
      jSONObject1.put("bitmapDisplayMode", G);
      jSONObject1.put("countDownNew", true);
    } catch (JSONException jSONException) {}
    b1.a(jSONObject1);
    paramu.a(paramb, paramInt);
  }
  
  public void a(boolean paramBoolean, IXAdInstanceInfo paramIXAdInstanceInfo) {
    if (d(paramIXAdInstanceInfo)) {
      com.baidu.mobads.b.a a1 = com.baidu.mobads.b.a.a();
      Context context = this.A;
      IXAdProdInfo iXAdProdInfo = this.z.d();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("file_exist_");
      stringBuilder.append(paramBoolean);
      a1.a(context, "383", paramIXAdInstanceInfo, iXAdProdInfo, new Object[] { stringBuilder.toString() });
      if (!paramBoolean)
        a("开屏因为请求到未在wifi下缓存的视频广告跳过"); 
    } 
  }
  
  public boolean a(IXAdInstanceInfo paramIXAdInstanceInfo) {
    return d(paramIXAdInstanceInfo);
  }
  
  public String b(IXAdInstanceInfo paramIXAdInstanceInfo) {
    return c(paramIXAdInstanceInfo) ? paramIXAdInstanceInfo.getMainPictureUrl() : super.b(paramIXAdInstanceInfo);
  }
  
  public void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    if (paramHashMap != null) {
      IXAdInstanceInfo iXAdInstanceInfo = (IXAdInstanceInfo)paramHashMap.get("AdInstance");
      IXAdInstanceInfo.CreativeType creativeType = iXAdInstanceInfo.getCreativeType();
      if (creativeType == IXAdInstanceInfo.CreativeType.VIDEO || creativeType == IXAdInstanceInfo.CreativeType.RM)
        com.baidu.mobads.b.a.a().a(this.A, "383", iXAdInstanceInfo, this.z.d(), new Object[] { "processAdStart" }); 
    } 
  }
  
  public void b(IXAdResponseInfo paramIXAdResponseInfo) {}
  
  public void c() {
    com.baidu.mobads.constants.a.q = System.currentTimeMillis();
    if (this.h != null) {
      this.h.load();
      return;
    } 
    this.y.e("container is null");
  }
  
  public void d() {}
  
  public void e() {
    if (!i())
      return; 
    IXAdURIUitls iXAdURIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
    this.C = XAdSDKFoundationFacade.getInstance().getIoUtils().getStoreagePath(this.A);
    this.D = XAdSDKFoundationFacade.getInstance().getCommonUtils().md5("http://mobads.baidu.com/ads/img/3d_bg.jpg");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.C);
    stringBuilder.append(this.D);
    File file = new File(stringBuilder.toString());
    try {
      URL uRL = new URL(iXAdURIUitls.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/img/3d_bg.jpg"));
      if (a(file, uRL)) {
        ((XAdInstanceInfo)this.d).setSplash3DLocalUrl(null);
        f f = new f(this.A, uRL, this.C, this.D, false);
        f.addObserver(this.H);
        f.start();
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.C);
      stringBuilder1.append(this.D);
      g(stringBuilder1.toString());
      return;
    } catch (MalformedURLException malformedURLException) {
      return;
    } 
  }
  
  public void e(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    super.e(paramIXAdContainer, paramHashMap);
    if (paramHashMap != null)
      try {
        String str = (String)paramHashMap.get("video_close_reason");
        if (!TextUtils.isEmpty(str))
          com.baidu.mobads.b.a.a().a(this.A, "383", null, this.z.d(), new Object[] { "closead", str }); 
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public boolean e(IXAdInstanceInfo paramIXAdInstanceInfo) {
    return (c(paramIXAdInstanceInfo) || i());
  }
  
  public void f() {
    this.B = true;
    try {
      IXAdResponseInfo iXAdResponseInfo = getAdResponseInfo();
      IXAdInstanceInfo iXAdInstanceInfo = null;
      if (iXAdResponseInfo != null)
        iXAdInstanceInfo = iXAdResponseInfo.getPrimaryAdInstanceInfo(); 
      com.baidu.mobads.b.a.a().a(this.A, "382", iXAdInstanceInfo, this.z.d(), null);
      return;
    } catch (Exception exception) {
      this.y.e(exception);
      return;
    } 
  }
  
  public boolean h() {
    return true;
  }
  
  public void request() {
    com.baidu.mobads.constants.a.m = System.currentTimeMillis();
    o();
    a(this.z);
    try {
      e.a(getActivity(), getActivity().getBaseContext()).loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */