package com.baidu.mobad.feeds;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.b.a;
import com.baidu.mobads.component.AdLogInfo;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.c;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.XAdInstanceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class XAdNativeResponse implements NativeResponse {
  private IXAdInstanceInfo a;
  
  private BaiduNative b;
  
  private boolean c = false;
  
  private IXAdFeedsRequestParameters d;
  
  private IXAdContainer e;
  
  private NativeResponse.AdInteractionListener f;
  
  public XAdNativeResponse(IXAdInstanceInfo paramIXAdInstanceInfo, BaiduNative paramBaiduNative, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters, IXAdContainer paramIXAdContainer) {
    this.a = paramIXAdInstanceInfo;
    this.b = paramBaiduNative;
    this.e = paramIXAdContainer;
    l l = XAdSDKFoundationFacade.getInstance().getAdConstants();
    if (this.a.getActionType() == l.getActTypeDownload())
      this.c = true; 
    this.d = paramIXAdFeedsRequestParameters;
  }
  
  private void a(Context paramContext) {
    if (!XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(paramContext).booleanValue()) {
      this.a.setActionOnlyWifi(false);
      return;
    } 
    this.a.setActionOnlyWifi(true);
  }
  
  private void a(Context paramContext, String paramString, int paramInt, IXAdInstanceInfo paramIXAdInstanceInfo) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("msg", paramString);
    hashMap.put("prod", "feed");
    hashMap.put("downType", String.valueOf(paramInt));
    hashMap.put("dl_type", "ac_feed");
    IXAdFeedsRequestParameters iXAdFeedsRequestParameters = this.d;
    if (iXAdFeedsRequestParameters != null) {
      hashMap.put("apid", iXAdFeedsRequestParameters.getAdPlacementId());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.d.getAPPConfirmPolicy());
      hashMap.put("confirmPolicy", stringBuilder.toString());
    } 
    a.a().a(paramContext.getApplicationContext(), 1046, paramIXAdInstanceInfo, hashMap);
  }
  
  private void a(View paramView, int paramInt) {
    try {
      Context context = paramView.getContext();
      if (context == null)
        return; 
      AlertDialog.Builder builder = new AlertDialog.Builder(context);
      builder.setMessage("当前是移动网络,是否继续下载?");
      builder.setTitle("温馨提示");
      builder.setPositiveButton("确认", new XAdNativeResponse$1(this, context, paramView, paramInt));
      return;
    } catch (Exception exception) {
      return;
    } finally {
      paramView = null;
      q.a().e(paramView.getMessage());
    } 
  }
  
  private void a(View paramView, int paramInt, IXAdInstanceInfo paramIXAdInstanceInfo) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isDownloadApp : ()Z
    //   4: ifeq -> 335
    //   7: aload_1
    //   8: invokevirtual getContext : ()Landroid/content/Context;
    //   11: astore #7
    //   13: aload_3
    //   14: invokeinterface getOriginJsonObject : ()Lorg/json/JSONObject;
    //   19: ldc 'notice_dl_non_wifi'
    //   21: iconst_0
    //   22: invokevirtual optInt : (Ljava/lang/String;I)I
    //   25: istore #4
    //   27: iload #4
    //   29: iconst_1
    //   30: if_icmpne -> 39
    //   33: iconst_1
    //   34: istore #4
    //   36: goto -> 42
    //   39: iconst_0
    //   40: istore #4
    //   42: goto -> 48
    //   45: iconst_0
    //   46: istore #4
    //   48: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   51: invokevirtual getPackageUtils : ()Lcom/baidu/mobads/utils/r;
    //   54: astore #8
    //   56: aload #8
    //   58: aload #7
    //   60: aload_3
    //   61: invokeinterface getAppPackageName : ()Ljava/lang/String;
    //   66: invokevirtual isInstalled : (Landroid/content/Context;Ljava/lang/String;)Z
    //   69: ifne -> 123
    //   72: aload_3
    //   73: invokeinterface getOriginJsonObject : ()Lorg/json/JSONObject;
    //   78: astore #9
    //   80: aload #9
    //   82: ifnull -> 132
    //   85: aload #8
    //   87: aload #7
    //   89: aload #9
    //   91: ldc 'app_store_link'
    //   93: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   96: aload_3
    //   97: invokeinterface getAppPackageName : ()Ljava/lang/String;
    //   102: sipush #366
    //   105: iconst_2
    //   106: iconst_0
    //   107: invokevirtual sendAPOInfo : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;III)Z
    //   110: istore #6
    //   112: iload #6
    //   114: ifeq -> 132
    //   117: iconst_1
    //   118: istore #5
    //   120: goto -> 135
    //   123: iconst_0
    //   124: istore #5
    //   126: iconst_0
    //   127: istore #4
    //   129: goto -> 135
    //   132: iconst_0
    //   133: istore #5
    //   135: aload_0
    //   136: getfield d : Lcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;
    //   139: invokeinterface getAPPConfirmPolicy : ()I
    //   144: iconst_3
    //   145: if_icmpne -> 170
    //   148: aload_3
    //   149: iconst_0
    //   150: invokeinterface setActionOnlyWifi : (Z)V
    //   155: aload_0
    //   156: getfield b : Lcom/baidu/mobad/feeds/BaiduNative;
    //   159: aload_1
    //   160: aload_3
    //   161: iload_2
    //   162: aload_0
    //   163: getfield d : Lcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;
    //   166: invokevirtual handleClick : (Landroid/view/View;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;ILcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;)V
    //   169: return
    //   170: aload_0
    //   171: getfield d : Lcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;
    //   174: invokeinterface getAPPConfirmPolicy : ()I
    //   179: iconst_4
    //   180: if_icmpne -> 208
    //   183: aload_0
    //   184: getfield a : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   187: iconst_0
    //   188: invokeinterface setActionOnlyWifi : (Z)V
    //   193: aload_0
    //   194: getfield b : Lcom/baidu/mobad/feeds/BaiduNative;
    //   197: aload_1
    //   198: aload_3
    //   199: iload_2
    //   200: aload_0
    //   201: getfield d : Lcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;
    //   204: invokevirtual handleClick : (Landroid/view/View;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;ILcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;)V
    //   207: return
    //   208: aload_0
    //   209: getfield d : Lcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;
    //   212: invokeinterface getAPPConfirmPolicy : ()I
    //   217: iconst_2
    //   218: if_icmpne -> 261
    //   221: iload #5
    //   223: ifeq -> 254
    //   226: aload_0
    //   227: getfield a : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   230: iconst_0
    //   231: invokeinterface setActionOnlyWifi : (Z)V
    //   236: aload_0
    //   237: getfield b : Lcom/baidu/mobad/feeds/BaiduNative;
    //   240: aload_1
    //   241: aload_0
    //   242: getfield a : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   245: iload_2
    //   246: aload_0
    //   247: getfield d : Lcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;
    //   250: invokevirtual handleClick : (Landroid/view/View;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;ILcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;)V
    //   253: return
    //   254: aload_0
    //   255: aload_1
    //   256: iload_2
    //   257: invokespecial a : (Landroid/view/View;I)V
    //   260: return
    //   261: aload_0
    //   262: getfield d : Lcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;
    //   265: invokeinterface getAPPConfirmPolicy : ()I
    //   270: iconst_1
    //   271: if_icmpne -> 352
    //   274: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   277: invokevirtual getSystemUtils : ()Lcom/baidu/mobads/interfaces/utils/IXAdSystemUtils;
    //   280: aload #7
    //   282: invokeinterface isWifiConnected : (Landroid/content/Context;)Ljava/lang/Boolean;
    //   287: invokevirtual booleanValue : ()Z
    //   290: ifne -> 310
    //   293: iload #4
    //   295: ifeq -> 310
    //   298: iload #5
    //   300: ifne -> 310
    //   303: aload_0
    //   304: aload_1
    //   305: iload_2
    //   306: invokespecial a : (Landroid/view/View;I)V
    //   309: return
    //   310: aload_0
    //   311: getfield a : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   314: iconst_0
    //   315: invokeinterface setActionOnlyWifi : (Z)V
    //   320: aload_0
    //   321: getfield b : Lcom/baidu/mobad/feeds/BaiduNative;
    //   324: aload_1
    //   325: aload_3
    //   326: iload_2
    //   327: aload_0
    //   328: getfield d : Lcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;
    //   331: invokevirtual handleClick : (Landroid/view/View;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;ILcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;)V
    //   334: return
    //   335: aload_0
    //   336: getfield b : Lcom/baidu/mobad/feeds/BaiduNative;
    //   339: aload_1
    //   340: aload_0
    //   341: getfield a : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   344: iload_2
    //   345: aload_0
    //   346: getfield d : Lcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;
    //   349: invokevirtual handleClick : (Landroid/view/View;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;ILcom/baidu/mobads/interfaces/feeds/IXAdFeedsRequestParameters;)V
    //   352: return
    //   353: astore #8
    //   355: goto -> 45
    //   358: astore #8
    //   360: goto -> 132
    // Exception table:
    //   from	to	target	type
    //   13	27	353	finally
    //   48	80	358	finally
    //   85	112	358	finally
  }
  
  public AdLogInfo getAdLogInfo() {
    AdLogInfo adLogInfo = new AdLogInfo();
    IXAdFeedsRequestParameters iXAdFeedsRequestParameters = this.d;
    if (iXAdFeedsRequestParameters != null)
      adLogInfo.setAdPlaceId(iXAdFeedsRequestParameters.getAdPlacementId()); 
    IXAdInstanceInfo iXAdInstanceInfo = this.a;
    if (iXAdInstanceInfo != null) {
      adLogInfo.setQk(iXAdInstanceInfo.getQueryKey());
      adLogInfo.setVideoUrl(this.a.getVideoUrl());
    } 
    return adLogInfo;
  }
  
  public String getAdLogoUrl() {
    return "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
  }
  
  public String getAdMaterialType() {
    return (this.a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) ? NativeResponse.MaterialType.VIDEO.getValue() : ((this.a.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML) ? NativeResponse.MaterialType.HTML.getValue() : NativeResponse.MaterialType.NORMAL.getValue());
  }
  
  public String getAppPackage() {
    return this.a.getAppPackageName();
  }
  
  public long getAppSize() {
    return this.a.getAppSize();
  }
  
  public String getBaiduLogoUrl() {
    return "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
  }
  
  public String getBrandName() {
    return this.a.getAppName();
  }
  
  public int getContainerHeight() {
    return this.a.getAdContainerHeight();
  }
  
  public int getContainerSizeType() {
    return this.a.getAdContainerSizeType();
  }
  
  public int getContainerWidth() {
    return this.a.getAdContainerWidth();
  }
  
  public String getDesc() {
    return this.a.getDescription();
  }
  
  public int getDownloadStatus() {
    if (this.c) {
      IXAdContainer iXAdContainer = this.e;
      if (iXAdContainer != null && iXAdContainer.getAdContainerContext() != null)
        return c.a(this.e.getAdContainerContext().getApplicationContext()).a(this.e.getAdContainerContext().getApplicationContext(), getAppPackage()); 
    } 
    return -1;
  }
  
  public int getDuration() {
    return this.a.getVideoDuration();
  }
  
  public String getECPMLevel() {
    IXAdInstanceInfo iXAdInstanceInfo = this.a;
    if (iXAdInstanceInfo != null) {
      JSONObject jSONObject = iXAdInstanceInfo.getOriginJsonObject();
      if (jSONObject != null)
        return jSONObject.optString("bidlayer", ""); 
    } 
    return "";
  }
  
  public Map<String, String> getExtras() {
    return null;
  }
  
  public String getHtmlSnippet() {
    return this.a.getHtmlSnippet();
  }
  
  public String getIconUrl() {
    String str = this.a.getIconUrl();
    if (str != null) {
      String str1 = str;
      return str.equals("") ? this.a.getMainPictureUrl() : str1;
    } 
    return this.a.getMainPictureUrl();
  }
  
  public String getImageUrl() {
    return this.a.getMainPictureUrl();
  }
  
  public int getMainPicHeight() {
    return this.a.getMainMaterialHeight();
  }
  
  public int getMainPicWidth() {
    return this.a.getMainMaterialWidth();
  }
  
  public NativeResponse.MaterialType getMaterialType() {
    return (this.a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) ? NativeResponse.MaterialType.VIDEO : ((this.a.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML) ? NativeResponse.MaterialType.HTML : NativeResponse.MaterialType.NORMAL);
  }
  
  public List<String> getMultiPicUrls() {
    ArrayList<String> arrayList = null;
    try {
      JSONArray jSONArray = this.a.getOriginJsonObject().optJSONArray("morepics");
      ArrayList<String> arrayList1 = arrayList;
      if (jSONArray != null) {
        arrayList1 = arrayList;
        if (jSONArray.length() > 0) {
          arrayList1 = new ArrayList();
          int i = 0;
          try {
            while (i < jSONArray.length()) {
              arrayList1.add(jSONArray.getString(i));
              i++;
            } 
          } catch (Exception exception) {}
        } 
      } 
      return arrayList1;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public String getMute() {
    return this.a.getMute();
  }
  
  public int getStyleType() {
    return this.a.getFeedAdStyleType();
  }
  
  public String getTitle() {
    return this.a.getTitle();
  }
  
  public String getUniqueId() {
    return this.a.getUniqueId();
  }
  
  public String getVideoUrl() {
    return this.a.getVideoUrl();
  }
  
  public WebView getWebView() {
    return (WebView)this.e.getAdView();
  }
  
  public void handleClick(View paramView) {
    handleClick(paramView, -1);
  }
  
  public void handleClick(View paramView, int paramInt) {
    a(paramView, paramInt, this.a);
  }
  
  protected void handleClickDownloadDirect(View paramView) {
    if (!supportDownloadDirect())
      return; 
    try {
      XAdInstanceInfo xAdInstanceInfo = (XAdInstanceInfo)((XAdInstanceInfo)this.a).clone();
      xAdInstanceInfo.setAction("");
      a(paramView, -1, (IXAdInstanceInfo)xAdInstanceInfo);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public boolean isAdAvailable(Context paramContext) {
    return this.b.isAdAvailable(paramContext, this.a, this.d);
  }
  
  public boolean isAutoPlay() {
    JSONObject jSONObject = this.a.getOriginJsonObject();
    boolean bool = false;
    if (jSONObject.optInt("auto_play", 0) == 1)
      bool = true; 
    return bool;
  }
  
  public boolean isDownloadApp() {
    return this.c;
  }
  
  public boolean isNonWifiAutoPlay() {
    try {
      return (i == 1);
    } finally {
      Exception exception = null;
    } 
  }
  
  public boolean isVideoMuted() {
    return this.a.isVideoMuted();
  }
  
  public void onADExposed() {
    NativeResponse.AdInteractionListener adInteractionListener = this.f;
    if (adInteractionListener != null)
      adInteractionListener.onADExposed(); 
  }
  
  public void onADStatusChanged() {
    NativeResponse.AdInteractionListener adInteractionListener = this.f;
    if (adInteractionListener != null)
      adInteractionListener.onADStatusChanged(); 
  }
  
  public void onAdClick() {
    NativeResponse.AdInteractionListener adInteractionListener = this.f;
    if (adInteractionListener != null)
      adInteractionListener.onAdClick(); 
  }
  
  public void onClickAd(Context paramContext) {
    this.b.handleOnClickAd(paramContext, this.a, this.d);
  }
  
  public void onClose(Context paramContext, int paramInt) {
    this.b.handleOnClose(paramContext, paramInt, this.a, this.d);
  }
  
  public void onComplete(Context paramContext) {
    this.b.handleOnComplete(paramContext, this.a, this.d);
  }
  
  public void onError(Context paramContext, int paramInt1, int paramInt2) {
    this.b.handleOnError(paramContext, paramInt1, paramInt2, this.a);
  }
  
  public void onFullScreen(Context paramContext, int paramInt) {
    this.b.handleOnFullScreen(paramContext, paramInt, this.a, this.d);
  }
  
  public void onStart(Context paramContext) {
    this.b.handleOnStart(paramContext, this.a, this.d);
  }
  
  public void pauseAppDownload() {
    if (this.c) {
      IXAdContainer iXAdContainer = this.e;
      if (iXAdContainer != null && iXAdContainer.getAdContainerContext() != null)
        c.a(this.e.getAdContainerContext().getApplicationContext()).a(getAppPackage()); 
    } 
  }
  
  public void recordImpression(View paramView) {
    this.b.recordImpression(paramView, this.a, this.d);
  }
  
  public void registerViewForInteraction(View paramView, NativeResponse.AdInteractionListener paramAdInteractionListener) {
    recordImpression(paramView);
    this.f = paramAdInteractionListener;
  }
  
  public void resumeAppDownload() {
    if (this.c) {
      IXAdContainer iXAdContainer = this.e;
      if (iXAdContainer != null && iXAdContainer.getAdContainerContext() != null) {
        String str;
        Context context = this.e.getAdContainerContext().getApplicationContext();
        if (this.e.getAdContainerContext().getAdProdInfo() != null) {
          str = this.e.getAdContainerContext().getAdProdInfo().getProdType();
        } else {
          str = "";
        } 
        c c = c.a(context);
        IXAdInstanceInfo iXAdInstanceInfo = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ac_");
        stringBuilder.append(str);
        c.a(context, iXAdInstanceInfo, str, stringBuilder.toString());
      } 
    } 
  }
  
  public void setIsDownloadApp(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  protected boolean supportDownloadDirect() {
    int i = this.a.getActionType();
    IXAdInstanceInfo.CreativeType creativeType = this.a.getCreativeType();
    return (this.a.getAction().equals("video") && i == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload() && creativeType == IXAdInstanceInfo.CreativeType.VIDEO);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\feeds\XAdNativeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */