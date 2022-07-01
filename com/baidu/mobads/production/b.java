package com.baidu.mobads.production;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.f.q;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.download.activate.IXActivateListener;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.c.c;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.ac;
import com.baidu.mobads.utils.m;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.XAdInstanceInfo;
import com.baidu.mobads.vo.c;
import com.baidu.mobads.vo.d;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b extends c implements IXNonLinearAdSlot {
  public static IXAdContainerFactory a;
  
  private static final String[] y = new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE" };
  
  private IXAdResponseInfo A;
  
  private String B;
  
  private Handler C = new Handler(Looper.getMainLooper());
  
  private Runnable D = null;
  
  private IOAdEventListener E = new c(this);
  
  protected Boolean b = Boolean.valueOf(false);
  
  public IXAdInstanceInfo d = null;
  
  public RelativeLayout e;
  
  public Context f;
  
  protected int g = 0;
  
  public IXAdContainer h;
  
  protected String i;
  
  protected u j;
  
  protected d k;
  
  protected IXAdConstants4PDK.SlotState l = IXAdConstants4PDK.SlotState.IDEL;
  
  public int m = 5000;
  
  protected int n = 0;
  
  protected IXAdConstants4PDK.SlotType o;
  
  protected boolean p = false;
  
  protected HashMap<String, String> q = new HashMap<String, String>();
  
  public AtomicBoolean r = new AtomicBoolean();
  
  protected String s = "";
  
  protected IXAdFeedsRequestParameters t = null;
  
  protected final IXAdLogger u = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  protected long v;
  
  protected long w;
  
  protected long x;
  
  private AtomicBoolean z = new AtomicBoolean(true);
  
  public b(Context paramContext) {}
  
  private void a() {
    com.baidu.mobads.constants.a.n = System.currentTimeMillis();
    c(this.A);
    a(this.A.getAdInstanceList());
    if (!h()) {
      b("XAdMouldeLoader ad-server requesting success");
      return;
    } 
    IXAdInstanceInfo iXAdInstanceInfo = this.A.getPrimaryAdInstanceInfo();
    String str = b(iXAdInstanceInfo);
    if (TextUtils.isEmpty(str)) {
      b("XAdMouldeLoader ad-server requesting success");
      return;
    } 
    boolean bool = a(str, iXAdInstanceInfo);
    a(bool, iXAdInstanceInfo);
    if (bool) {
      if (i() && TextUtils.isEmpty(((XAdInstanceInfo)this.d).getSplash3DLocalUrl())) {
        this.u.i("XAbstractAdProdTemplate", "背景图片没有缓存完成");
        return;
      } 
      b("download the splash picture successfully");
      return;
    } 
    if (a(iXAdInstanceInfo)) {
      h(iXAdInstanceInfo);
      return;
    } 
    if (!e(iXAdInstanceInfo))
      b("XAdMouldeLoader ad-server requesting success"); 
    h(iXAdInstanceInfo);
  }
  
  private void a(Message paramMessage, IXAdInstanceInfo paramIXAdInstanceInfo) {
    if (paramMessage.getData().getBoolean("caching_result")) {
      String str = paramMessage.getData().getString("local_creative_url");
      paramIXAdInstanceInfo.setLocalCreativeURL(str);
      if (paramIXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.RM)
        if (i()) {
          IXAdLogger iXAdLogger = this.u;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("processDlResult: ");
          stringBuilder.append(str);
          iXAdLogger.d("XAbstractAdProdTemplate", stringBuilder.toString());
          try {
            ac.a(str, m.a(getApplicationContext(), paramIXAdInstanceInfo.getMainPictureUrl()));
            c(paramIXAdInstanceInfo, m.a(getApplicationContext(), paramIXAdInstanceInfo.getMainPictureUrl()));
          } catch (IOException iOException) {}
        } else if (this.s.endsWith("vr")) {
          Uri uri = Uri.parse((String)iOException);
          a(XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(paramIXAdInstanceInfo.getMainPictureUrl()), uri);
        }  
      if (e(paramIXAdInstanceInfo))
        if (i() && TextUtils.isEmpty(((XAdInstanceInfo)this.d).getSplash3DLocalUrl())) {
          this.u.i("XAbstractAdProdTemplate", "背景图片没有缓存完成");
        } else {
          b("download the splash picture successfully");
        }  
      if (g(paramIXAdInstanceInfo))
        dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("vdieoCacheSucc")); 
    } else {
      if (g(paramIXAdInstanceInfo))
        dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("vdieoCacheFailed")); 
      paramIXAdInstanceInfo.setLocalCreativeURL(null);
      if (e(paramIXAdInstanceInfo))
        b("download the splash picture successfully"); 
    } 
    b(paramMessage, paramIXAdInstanceInfo);
  }
  
  private void a(IXAdInstanceInfo paramIXAdInstanceInfo, String paramString1, String paramString2, String paramString3) {
    try {
      if (!f(paramIXAdInstanceInfo))
        return; 
      m m = XAdSDKFoundationFacade.getInstance().getAdCreativeCacheManager();
      m.a(paramString2);
      return;
    } finally {
      paramIXAdInstanceInfo = null;
    } 
  }
  
  private void a(String paramString, Uri paramUri) {
    (new Thread(new l(this, paramString, paramUri))).start();
  }
  
  private void a(ArrayList<IXAdInstanceInfo> paramArrayList) {
    if (paramArrayList != null && paramArrayList.size() > 0)
      for (IXAdInstanceInfo iXAdInstanceInfo : paramArrayList) {
        if (g(iXAdInstanceInfo) && s())
          h(iXAdInstanceInfo); 
      }  
  }
  
  private boolean a(com.baidu.mobads.c.a parama, IXAdInstanceInfo.CreativeType paramCreativeType, String paramString) {
    try {
      if (paramCreativeType == IXAdInstanceInfo.CreativeType.VIDEO && this.o != null && IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS.getValue().equals(this.o.getValue()) && parama != null) {
        boolean bool = parama.a(paramString);
        if (bool)
          return true; 
      } 
    } finally {
      parama = null;
    } 
  }
  
  private boolean a(IXAdInstanceInfo paramIXAdInstanceInfo, String paramString) {
    boolean bool = XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getApplicationContext()).booleanValue();
    return (g(paramIXAdInstanceInfo) || bool || c(paramIXAdInstanceInfo) || i());
  }
  
  private IXAdContainer b(IXAdContainerContext paramIXAdContainerContext) {
    this.u.d("XAbstractAdProdTemplate", "createAdContainer");
    IXAdContainerFactory iXAdContainerFactory = a;
    IXAdContainer iXAdContainer = null;
    if (iXAdContainerFactory != null) {
      IXAdContainer iXAdContainer1 = iXAdContainerFactory.createXAdContainer(paramIXAdContainerContext, null);
      iXAdContainer = iXAdContainer1;
      if (iXAdContainer1 != null) {
        IXAdLogger iXAdLogger = this.u;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createAdContainer() apk.version=");
        stringBuilder.append(a.getRemoteVersion());
        iXAdLogger.d("XAbstractAdProdTemplate", stringBuilder.toString());
        iXAdContainer = iXAdContainer1;
      } 
    } 
    return iXAdContainer;
  }
  
  private void b() {
    BaiduXAdSDKContext.isRemoteLoadSuccess = Boolean.valueOf(true);
    c("XAdMouldeLoader load success");
  }
  
  private void b(Context paramContext) {
    (new Handler(Looper.getMainLooper())).postDelayed(new f(this, paramContext), 2000L);
  }
  
  private void b(Message paramMessage, IXAdInstanceInfo paramIXAdInstanceInfo) {
    String str1;
    if (!d(paramIXAdInstanceInfo))
      return; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("");
    stringBuilder1.append(paramMessage.getData().getLong("caching_time_consume", 0L));
    String str2 = stringBuilder1.toString();
    String str3 = b(paramIXAdInstanceInfo);
    if (paramMessage.getData().getBoolean("caching_result")) {
      str1 = "success";
    } else {
      str1 = "failed";
    } 
    com.baidu.mobads.b.a a = com.baidu.mobads.b.a.a();
    Context context = this.f;
    IXAdProdInfo iXAdProdInfo = this.k.d();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("file_dl_");
    stringBuilder2.append(str1);
    a.a(context, "383", paramIXAdInstanceInfo, iXAdProdInfo, new Object[] { stringBuilder2.toString(), str3, str2 });
  }
  
  private void b(IXAdInstanceInfo paramIXAdInstanceInfo, String paramString) {
    if (d(paramIXAdInstanceInfo))
      com.baidu.mobads.b.a.a().a(this.f, "383", paramIXAdInstanceInfo, this.k.d(), new Object[] { "file_dl_failed_not_wifi", paramString }); 
  }
  
  private void c(IXAdInstanceInfo paramIXAdInstanceInfo, String paramString) {
    File[] arrayOfFile = (new File(paramString)).listFiles();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "jpg";
    arrayOfString[1] = "png";
    arrayOfString[2] = "jpeg";
    if (arrayOfFile != null && arrayOfFile.length > 0)
      for (int i = 0; i < arrayOfFile.length; i++) {
        File[] arrayOfFile1 = arrayOfFile[i].listFiles();
        if (arrayOfFile1 != null && arrayOfFile1.length > 0) {
          int j;
          for (j = 0; j < arrayOfFile1.length; j++) {
            if (arrayOfFile1[j].getName().endsWith(".mp4")) {
              paramIXAdInstanceInfo.setLocalCreativeURL(arrayOfFile[i].getAbsolutePath());
              return;
            } 
            int m = arrayOfString.length;
            int k;
            for (k = 0; k < m; k++) {
              String str = arrayOfString[k];
              if (arrayOfFile1[j].getName().toLowerCase().endsWith(str)) {
                paramIXAdInstanceInfo.setLocalCreativeURL(arrayOfFile[i].getAbsolutePath());
                return;
              } 
            } 
          } 
        } 
      }  
  }
  
  private boolean f(IXAdInstanceInfo paramIXAdInstanceInfo) {
    if (paramIXAdInstanceInfo != null)
      try {
        if (paramIXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO && this.p)
          return XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getApplicationContext()).booleanValue(); 
      } finally {
        paramIXAdInstanceInfo = null;
      }  
    return true;
  }
  
  private boolean g(IXAdInstanceInfo paramIXAdInstanceInfo) {
    return (paramIXAdInstanceInfo != null && this.o != null && IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS.getValue().equals(this.o.getValue()) && paramIXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO);
  }
  
  private void h(IXAdInstanceInfo paramIXAdInstanceInfo) {
    this.u.d("XAbstractAdProdTemplate", "cacheCreativeAsset");
    String str1 = b(paramIXAdInstanceInfo);
    if (TextUtils.isEmpty(str1))
      return; 
    if (!a(paramIXAdInstanceInfo, str1)) {
      b(paramIXAdInstanceInfo, str1);
      return;
    } 
    paramIXAdInstanceInfo.setLocalCreativeURL(null);
    String str2 = m.a(getApplicationContext());
    String str3 = m.b(str1);
    com.baidu.mobads.c.a a = com.baidu.mobads.c.a.a();
    String str4 = paramIXAdInstanceInfo.getMainPictureUrl();
    if (a != null && a(a, paramIXAdInstanceInfo.getCreativeType(), str4)) {
      a.a(paramIXAdInstanceInfo.getMainPictureUrl(), new j(this, paramIXAdInstanceInfo, str1, str2, str3));
      return;
    } 
    a(paramIXAdInstanceInfo, str1, str2, str3);
  }
  
  public static IXAdContainerFactory j() {
    return a;
  }
  
  protected void a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/baidu/mobads/production/BaiduXAdSDKContext.mApkLoader : Lcom/baidu/mobads/f/g;
    //   3: ifnonnull -> 44
    //   6: ldc_w com/baidu/mobads/f/g
    //   9: monitorenter
    //   10: getstatic com/baidu/mobads/production/BaiduXAdSDKContext.mApkLoader : Lcom/baidu/mobads/f/g;
    //   13: ifnonnull -> 30
    //   16: new com/baidu/mobads/f/g
    //   19: dup
    //   20: aload_1
    //   21: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   24: invokespecial <init> : (Landroid/content/Context;)V
    //   27: putstatic com/baidu/mobads/production/BaiduXAdSDKContext.mApkLoader : Lcom/baidu/mobads/f/g;
    //   30: ldc_w com/baidu/mobads/f/g
    //   33: monitorexit
    //   34: goto -> 44
    //   37: astore_1
    //   38: ldc_w com/baidu/mobads/f/g
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: getstatic com/baidu/mobads/production/b.a : Lcom/baidu/mobads/interfaces/IXAdContainerFactory;
    //   47: ifnull -> 55
    //   50: aload_0
    //   51: invokespecial b : ()V
    //   54: return
    //   55: getstatic com/baidu/mobads/production/BaiduXAdSDKContext.mApkLoader : Lcom/baidu/mobads/f/g;
    //   58: ifnull -> 91
    //   61: aload_0
    //   62: getfield u : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   65: ldc 'XAbstractAdProdTemplate'
    //   67: ldc_w 'BaiduXAdSDKContext.mApkLoader != null,load apk'
    //   70: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   75: pop
    //   76: getstatic com/baidu/mobads/production/BaiduXAdSDKContext.mApkLoader : Lcom/baidu/mobads/f/g;
    //   79: new com/baidu/mobads/production/i
    //   82: dup
    //   83: aload_0
    //   84: invokespecial <init> : (Lcom/baidu/mobads/production/b;)V
    //   87: invokevirtual a : (Lcom/baidu/mobads/f/g$c;)V
    //   90: return
    //   91: aload_0
    //   92: getfield u : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   95: ldc 'XAbstractAdProdTemplate'
    //   97: ldc_w 'BaiduXAdSDKContext.mApkLoader == null,not load apk'
    //   100: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   105: pop
    //   106: return
    // Exception table:
    //   from	to	target	type
    //   10	30	37	finally
    //   30	34	37	finally
    //   38	42	37	finally
  }
  
  public void a(RequestParameters paramRequestParameters) {
    this.t = (IXAdFeedsRequestParameters)paramRequestParameters;
  }
  
  protected abstract void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap);
  
  protected void a(IXAdContainerContext paramIXAdContainerContext) {
    try {
      this.u.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread()");
      this.w = System.currentTimeMillis();
      this.h = b(paramIXAdContainerContext);
      this.x = System.currentTimeMillis();
      if (this.h == null) {
        this.u.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer is null");
        dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdError"));
        return;
      } 
      this.u.d("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created");
      HashMap<String, String> hashMap = this.q;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.v);
      hashMap.put("start", stringBuilder.toString());
      hashMap = this.q;
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.w);
      hashMap.put("container_before_created", stringBuilder.toString());
      hashMap = this.q;
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.x);
      hashMap.put("container_after_created", stringBuilder.toString());
      this.h.setParameters(this.q);
      com.baidu.mobads.constants.a.c = this.h.getRemoteVersion();
      IXAdLogger iXAdLogger = this.u;
      stringBuilder = new StringBuilder();
      stringBuilder.append("processAllReadyOnUIThread(), mAdContainer be created, hasCalledLoadAtAppSide=");
      stringBuilder.append(this.r.get());
      iXAdLogger.d("XAbstractAdProdTemplate", stringBuilder.toString());
      if (this.r.get())
        this.h.load(); 
      c();
      b(this.f);
      return;
    } catch (Exception exception) {
      this.u.e(XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage(XAdErrorCode.PERMISSION_PROBLEM, exception.getMessage()));
      com.baidu.mobads.b.a a = com.baidu.mobads.b.a.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("process all ready on UI Thread exception: ");
      stringBuilder.append(exception.toString());
      a.a(stringBuilder.toString());
      dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdError"));
      return;
    } 
  }
  
  protected void a(IXAdResponseInfo paramIXAdResponseInfo) {
    this.u.d("XAbstractAdProdTemplate", "handleAllReady");
    this.g++;
    this.d = paramIXAdResponseInfo.getPrimaryAdInstanceInfo();
    Context context = getApplicationContext();
    Activity activity = getActivity();
    IXAdProdInfo iXAdProdInfo = this.k.d();
    p p = new p(context, this);
    o o = new o(context, activity, iXAdProdInfo, this.e, p, paramIXAdResponseInfo, null);
    if (Looper.myLooper() == Looper.getMainLooper()) {
      a(o);
      return;
    } 
    (new Handler(Looper.getMainLooper())).post(new m(this, o));
  }
  
  protected void a(IXAdResponseInfo paramIXAdResponseInfo, IXAdInstanceInfo paramIXAdInstanceInfo) {
    this.d = paramIXAdInstanceInfo;
  }
  
  protected void a(XAdErrorCode paramXAdErrorCode, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("msg", paramXAdErrorCode);
    dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdError", hashMap));
    XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage(paramXAdErrorCode, paramString);
  }
  
  protected abstract void a(com.baidu.mobads.openad.d.b paramb, u paramu, int paramInt);
  
  protected void a(IOAdEvent paramIOAdEvent, String paramString) {
    String str = (String)paramIOAdEvent.getData().get("message");
    try {
      setAdResponseInfo((IXAdResponseInfo)new c(str));
      if (this.A != null && this.A.getAdInstanceList().size() > 0) {
        this.d = this.A.getPrimaryAdInstanceInfo();
        this.s = this.d.getOriginJsonObject().optString("mimetype");
        a();
        e();
        return;
      } 
      if (this.A != null) {
        str = this.A.getErrorCode();
      } else {
        str = "";
      } 
      if (this.A != null) {
        paramString = this.A.getErrorMessage();
      } else {
        paramString = "";
      } 
      XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage(str, paramString, "");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("response ad list empty: ");
      stringBuilder.append(paramString);
      e(stringBuilder.toString());
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", "response json parsing error", "");
      d("response json parsing error");
      com.baidu.mobads.b.a.a().a("response json parsing error");
      return;
    } 
  }
  
  public void a(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("error_message", paramString);
    dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdError", hashMap));
    XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", paramString, "");
  }
  
  public void a(boolean paramBoolean) {
    IXAdContainer iXAdContainer = this.h;
    if (iXAdContainer != null)
      iXAdContainer.onWindowFocusChanged(paramBoolean); 
  }
  
  public void a(boolean paramBoolean, IXAdInstanceInfo paramIXAdInstanceInfo) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    IXAdContainer iXAdContainer = this.h;
    return (iXAdContainer != null) ? iXAdContainer.processKeyEvent(paramInt, paramKeyEvent).booleanValue() : false;
  }
  
  public boolean a(IXAdInstanceInfo paramIXAdInstanceInfo) {
    return false;
  }
  
  public boolean a(d paramd) {
    this.u.d("XAbstractAdProdTemplate", "doRequest()");
    a(this.f);
    b(paramd);
    return true;
  }
  
  boolean a(String paramString, IXAdInstanceInfo paramIXAdInstanceInfo) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    try {
      paramString = m.b(getApplicationContext(), paramString);
      if ((new File(paramString)).exists()) {
        XAdSDKFoundationFacade.getInstance().getAdCreativeCacheManager().c(paramString);
        if (i()) {
          paramString = m.a(getApplicationContext(), paramIXAdInstanceInfo.getMainPictureUrl());
          if ((new File(paramString)).exists()) {
            XAdSDKFoundationFacade.getInstance().getAdCreativeCacheManager().c(paramString);
            c(paramIXAdInstanceInfo, m.a(getApplicationContext(), paramIXAdInstanceInfo.getMainPictureUrl()));
            return true;
          } 
        } else {
          paramIXAdInstanceInfo.setLocalCreativeURL(paramString);
          return true;
        } 
      } 
    } catch (Exception exception) {
      q.a().e(exception);
    } 
    return false;
  }
  
  public String b(IXAdInstanceInfo paramIXAdInstanceInfo) {
    String str = "";
    if (paramIXAdInstanceInfo == null)
      return ""; 
    if (paramIXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO)
      return paramIXAdInstanceInfo.getVideoUrl(); 
    if (paramIXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.RM)
      str = paramIXAdInstanceInfo.getMainPictureUrl(); 
    return str;
  }
  
  public void b(int paramInt) {
    IXAdContainer iXAdContainer = this.h;
    if (iXAdContainer != null)
      iXAdContainer.onWindowVisibilityChanged(paramInt); 
  }
  
  protected abstract void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap);
  
  public abstract void b(IXAdResponseInfo paramIXAdResponseInfo);
  
  protected void b(d paramd) {
    this.k = paramd;
    m();
    this.b = Boolean.valueOf(false);
    String str2 = this.i;
    String str1 = str2;
    if (str2 == null)
      str1 = paramd.b(); 
    this.j = new u();
    com.baidu.mobads.b.a.b = str1;
    com.baidu.mobads.openad.d.b b1 = new com.baidu.mobads.openad.d.b(str1, "");
    b1.e = 1;
    this.j.addEventListener("URLLoader.Load.Complete", this.E);
    this.j.addEventListener("URLLoader.Load.Error", this.E);
    a(b1, this.j, this.m);
  }
  
  protected void b(String paramString) {
    this.b = Boolean.valueOf(true);
    this.z.set(false);
    c(paramString);
  }
  
  public void b(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  public abstract void c();
  
  protected void c(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    n();
    a(paramIXAdContainer, paramHashMap);
    dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdLoaded"));
  }
  
  protected void c(IXAdResponseInfo paramIXAdResponseInfo) {
    b(paramIXAdResponseInfo);
  }
  
  protected void c(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield u : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   6: astore_3
    //   7: new java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore #4
    //   16: aload #4
    //   18: ldc_w 'doubleCheck:'
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #4
    //   27: aload_1
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload #4
    //   34: ldc_w ', bfp='
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload #4
    //   43: aload_0
    //   44: getfield b : Ljava/lang/Boolean;
    //   47: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #4
    //   53: ldc_w ', apk='
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload #4
    //   62: getstatic com/baidu/mobads/production/BaiduXAdSDKContext.isRemoteLoadSuccess : Ljava/lang/Boolean;
    //   65: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: ldc 'XAbstractAdProdTemplate'
    //   72: aload #4
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aload_0
    //   84: getfield z : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   87: invokevirtual get : ()Z
    //   90: istore_2
    //   91: iload_2
    //   92: ifeq -> 98
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: getstatic com/baidu/mobads/production/BaiduXAdSDKContext.isRemoteLoadSuccess : Ljava/lang/Boolean;
    //   101: invokevirtual booleanValue : ()Z
    //   104: ifeq -> 117
    //   107: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   110: aload_0
    //   111: invokevirtual getAdContainerFactory : ()Lcom/baidu/mobads/interfaces/IXAdContainerFactory;
    //   114: invokevirtual initializeAdContainerFactory : (Lcom/baidu/mobads/interfaces/IXAdContainerFactory;)V
    //   117: getstatic com/baidu/mobads/production/BaiduXAdSDKContext.isRemoteLoadSuccess : Ljava/lang/Boolean;
    //   120: invokevirtual booleanValue : ()Z
    //   123: ifeq -> 247
    //   126: aload_0
    //   127: getfield b : Ljava/lang/Boolean;
    //   130: invokevirtual booleanValue : ()Z
    //   133: istore_2
    //   134: iload_2
    //   135: ifeq -> 247
    //   138: aload_0
    //   139: invokevirtual getAdResponseInfo : ()Lcom/baidu/mobads/interfaces/IXAdResponseInfo;
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull -> 155
    //   147: aload_0
    //   148: aload_1
    //   149: invokevirtual a : (Lcom/baidu/mobads/interfaces/IXAdResponseInfo;)V
    //   152: goto -> 184
    //   155: aload_0
    //   156: new com/baidu/mobads/e/a
    //   159: dup
    //   160: ldc_w 'AdError'
    //   163: invokespecial <init> : (Ljava/lang/String;)V
    //   166: invokevirtual dispatchEvent : (Lcom/baidu/mobads/openad/interfaces/event/IOAdEvent;)V
    //   169: aload_0
    //   170: getfield u : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   173: ldc 'XAbstractAdProdTemplate'
    //   175: ldc_w 'doubleCheck IXAdResponseInfo is null, but isBFP4APPRequestSuccess is true'
    //   178: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   183: pop
    //   184: aload_0
    //   185: getfield z : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   188: astore_1
    //   189: aload_1
    //   190: iconst_1
    //   191: invokevirtual set : (Z)V
    //   194: goto -> 247
    //   197: astore_1
    //   198: goto -> 237
    //   201: astore_1
    //   202: aload_0
    //   203: getfield u : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   206: ldc 'XAbstractAdProdTemplate'
    //   208: aload_1
    //   209: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   214: pop
    //   215: aload_0
    //   216: new com/baidu/mobads/e/a
    //   219: dup
    //   220: ldc_w 'AdError'
    //   223: invokespecial <init> : (Ljava/lang/String;)V
    //   226: invokevirtual dispatchEvent : (Lcom/baidu/mobads/openad/interfaces/event/IOAdEvent;)V
    //   229: aload_0
    //   230: getfield z : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   233: astore_1
    //   234: goto -> 189
    //   237: aload_0
    //   238: getfield z : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   241: iconst_1
    //   242: invokevirtual set : (Z)V
    //   245: aload_1
    //   246: athrow
    //   247: aload_0
    //   248: monitorexit
    //   249: return
    //   250: astore_1
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_1
    //   254: athrow
    // Exception table:
    //   from	to	target	type
    //   2	91	250	finally
    //   98	117	250	finally
    //   117	134	250	finally
    //   138	143	201	java/lang/Exception
    //   138	143	197	finally
    //   147	152	201	java/lang/Exception
    //   147	152	197	finally
    //   155	184	201	java/lang/Exception
    //   155	184	197	finally
    //   184	189	250	finally
    //   189	194	250	finally
    //   202	229	197	finally
    //   229	234	250	finally
    //   237	247	250	finally
  }
  
  public boolean c(IXAdInstanceInfo paramIXAdInstanceInfo) {
    return (paramIXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.STATIC_IMAGE || paramIXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.GIF);
  }
  
  protected abstract void d();
  
  protected void d(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    this.l = IXAdConstants4PDK.SlotState.PLAYING;
    b(paramIXAdContainer, paramHashMap);
    dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdStarted"));
  }
  
  protected void d(String paramString) {
    com.baidu.mobads.b.a.a().a(paramString);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("error_message", paramString);
    dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdError", hashMap));
  }
  
  public boolean d(IXAdInstanceInfo paramIXAdInstanceInfo) {
    return ((paramIXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.RM && this.s.endsWith("vr")) || paramIXAdInstanceInfo.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO);
  }
  
  protected void e() {}
  
  public void e(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {}
  
  protected void e(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("error_message", paramString);
    dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdError", hashMap));
  }
  
  public boolean e(IXAdInstanceInfo paramIXAdInstanceInfo) {
    return false;
  }
  
  public void f() {}
  
  protected void f(String paramString) {
    if (TextUtils.isEmpty(paramString))
      this.u.e("代码位id(adPlaceId)不可以为空"); 
  }
  
  protected void g() {}
  
  public Activity getActivity() {
    Context context = this.f;
    if (context instanceof Activity)
      return (Activity)context; 
    RelativeLayout relativeLayout = this.e;
    return (relativeLayout != null && relativeLayout.getContext() instanceof Activity) ? (Activity)this.e.getContext() : null;
  }
  
  public IXAdContainerFactory getAdContainerFactory() {
    return a;
  }
  
  public IXAdResponseInfo getAdResponseInfo() {
    return this.A;
  }
  
  public Context getApplicationContext() {
    Activity activity = getActivity();
    return (activity == null) ? this.f : activity.getApplicationContext();
  }
  
  public IXAdInstanceInfo getCurrentAdInstance() {
    return this.d;
  }
  
  public IXAdContainer getCurrentXAdContainer() {
    return this.h;
  }
  
  public int getDuration() {
    return -1;
  }
  
  public String getId() {
    return this.B;
  }
  
  public HashMap<String, String> getParameter() {
    return this.q;
  }
  
  public int getPlayheadTime() {
    return -1;
  }
  
  public ViewGroup getProdBase() {
    return (ViewGroup)this.e;
  }
  
  public IXAdProdInfo getProdInfo() {
    return this.k.d();
  }
  
  public IXAdFeedsRequestParameters getRequestParameters() {
    if (this.t == null)
      this.t = (IXAdFeedsRequestParameters)(new RequestParameters.Builder()).build(); 
    return this.t;
  }
  
  public IXAdConstants4PDK.SlotState getSlotState() {
    return this.l;
  }
  
  public IXAdConstants4PDK.SlotType getType() {
    return this.o;
  }
  
  public boolean h() {
    return false;
  }
  
  public boolean i() {
    return !TextUtils.isEmpty(this.s) ? this.s.endsWith("3d") : false;
  }
  
  public Boolean isAdServerRequestingSuccess() {
    return this.b;
  }
  
  protected void k() {
    if (this.h != null && getApplicationContext() != null) {
      this.l = IXAdConstants4PDK.SlotState.PAUSED;
      (new Handler(getApplicationContext().getMainLooper())).post(new d(this));
    } 
  }
  
  protected void l() {
    if (this.h != null && getApplicationContext() != null) {
      this.l = IXAdConstants4PDK.SlotState.PLAYING;
      (new Handler(getApplicationContext().getMainLooper())).post(new e(this));
    } 
  }
  
  public void load() {
    IXAdContainer iXAdContainer = this.h;
    if (iXAdContainer != null) {
      iXAdContainer.load();
      return;
    } 
    this.r.set(true);
  }
  
  protected void m() {
    u u1 = this.j;
    if (u1 != null) {
      u1.removeAllListeners();
      this.j.a();
    } 
  }
  
  protected void n() {
    Runnable runnable = this.D;
    if (runnable != null)
      this.C.removeCallbacks(runnable); 
    this.D = null;
  }
  
  protected void o() {
    Runnable runnable = this.D;
    if (runnable != null)
      this.C.postDelayed(runnable, this.m); 
  }
  
  public void p() {
    IXAdContainer iXAdContainer = this.h;
    if (iXAdContainer != null)
      iXAdContainer.onAttachedToWindow(); 
  }
  
  public void pause() {
    k();
  }
  
  public void q() {
    IXAdContainer iXAdContainer = this.h;
    if (iXAdContainer != null)
      iXAdContainer.onDetachedFromWindow(); 
  }
  
  public void r() {
    IXAdContainer iXAdContainer = this.h;
    if (iXAdContainer != null)
      iXAdContainer.destroy(); 
    BaiduXAdSDKContext.exit();
  }
  
  public void resize() {
    if (this.h != null && getApplicationContext() != null)
      (new Handler(getApplicationContext().getMainLooper())).post(new n(this)); 
  }
  
  public void resume() {
    l();
  }
  
  public boolean s() {
    return false;
  }
  
  public void setActivity(Context paramContext) {
    this.f = paramContext;
    g();
    this.r.set(false);
    d();
    com.baidu.mobads.b.a.a().a(getApplicationContext());
    XAdSDKFoundationFacade.getInstance().initializeApplicationContext(getApplicationContext());
    this.D = new h(this);
    q.a(this.f).a();
  }
  
  public void setAdResponseInfo(IXAdResponseInfo paramIXAdResponseInfo) {
    this.A = paramIXAdResponseInfo;
  }
  
  public void setAdSlotBase(RelativeLayout paramRelativeLayout) {
    this.e = paramRelativeLayout;
  }
  
  public void setId(String paramString) {
    this.B = paramString;
  }
  
  public void setParameter(HashMap<String, String> paramHashMap) {
    this.q = paramHashMap;
  }
  
  public void start() {
    IXAdContainer iXAdContainer = this.h;
    if (iXAdContainer != null)
      iXAdContainer.start(); 
  }
  
  public void stop() {
    XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAbstractAdProdTemplate", "stop");
    IXAdContainer iXAdContainer = this.h;
    if (iXAdContainer != null) {
      iXAdContainer.stop();
      this.h = null;
    } 
  }
  
  static class a implements IXActivateListener {
    private Context a;
    
    public a(Context param1Context) {
      this.a = param1Context.getApplicationContext();
    }
    
    public void onAppActivation(IXAppInfo param1IXAppInfo) {
      com.baidu.mobads.b.a.a().b(this.a, param1IXAppInfo);
    }
    
    public void onAppInstalled(IXAppInfo param1IXAppInfo) {
      com.baidu.mobads.b.a.a().a(this.a, param1IXAppInfo);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */