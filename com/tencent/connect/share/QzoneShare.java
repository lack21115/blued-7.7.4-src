package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.AsynLoadImgBack;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import java.net.URLEncoder;
import java.util.ArrayList;

public class QzoneShare extends BaseApi {
  public static final String SHARE_TO_QQ_APP_NAME = "appName";
  
  public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
  
  public static final String SHARE_TO_QQ_EXT_INT = "cflag";
  
  public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
  
  public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
  
  public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
  
  public static final String SHARE_TO_QQ_SITE = "site";
  
  public static final String SHARE_TO_QQ_SUMMARY = "summary";
  
  public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
  
  public static final String SHARE_TO_QQ_TITLE = "title";
  
  public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
  
  public static final int SHARE_TO_QZONE_TYPE_APP = 6;
  
  public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
  
  public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
  
  public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
  
  private boolean a = true;
  
  private boolean b = false;
  
  private boolean c = false;
  
  private boolean d = false;
  
  public String mViaShareQzoneType = "";
  
  public QzoneShare(Context paramContext, QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  private void a(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
    StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
    ArrayList<String> arrayList = paramBundle.getStringArrayList("imageUrl");
    String str8 = paramBundle.getString("title");
    String str6 = paramBundle.getString("summary");
    String str5 = paramBundle.getString("targetUrl");
    String str2 = paramBundle.getString("audio_url");
    int i = paramBundle.getInt("req_type", 1);
    String str3 = paramBundle.getString("appName");
    int j = paramBundle.getInt("cflag", 0);
    String str1 = paramBundle.getString("share_qq_ext_str");
    String str7 = this.mToken.getAppId();
    String str4 = this.mToken.getOpenId();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("openId:");
    stringBuilder.append(str4);
    f.a("openSDK_LOG.QzoneShare", stringBuilder.toString());
    if (arrayList != null) {
      StringBuffer stringBuffer1 = new StringBuffer();
      int m = arrayList.size();
      int k = 9;
      if (m <= 9)
        k = arrayList.size(); 
      m = 0;
      ArrayList<String> arrayList1 = arrayList;
      while (m < k) {
        stringBuffer1.append(URLEncoder.encode(arrayList1.get(m)));
        if (m != k - 1)
          stringBuffer1.append(";"); 
        m++;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("&image_url=");
      stringBuilder1.append(Base64.encodeToString(Util.getBytesUTF8(stringBuffer1.toString()), 2));
      stringBuffer.append(stringBuilder1.toString());
    } 
    if (!TextUtils.isEmpty(str8)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&title=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str8), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str6)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&description=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str6), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str7)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&share_id=");
      stringBuilder.append(str7);
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str5)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&url=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str5), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str3)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&app_name=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str3), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!Util.isEmpty(str4)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&open_id=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str4), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!Util.isEmpty(str2)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&audioUrl=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str2), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append("&req_type=");
    stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(String.valueOf(i)), 2));
    stringBuffer.append(stringBuilder.toString());
    if (!Util.isEmpty(str1)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&share_qq_ext_str=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str1), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append("&cflag=");
    stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(String.valueOf(j)), 2));
    stringBuffer.append(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("doshareToQzone, url: ");
    stringBuilder.append(stringBuffer.toString());
    f.a("openSDK_LOG.QzoneShare", stringBuilder.toString());
    a.a(Global.getContext(), this.mToken, "requireApi", new String[] { "shareToNativeQQ" });
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.setData(Uri.parse(stringBuffer.toString()));
    intent.putExtra("pkg_name", paramActivity.getPackageName());
    if (SystemUtils.compareQQVersion((Context)paramActivity, "4.6.0") < 0) {
      if (hasActivityForIntent(intent)) {
        UIListenerManager.getInstance().setListenerWithRequestcode(11104, paramIUiListener);
        startAssitActivity(paramActivity, intent, 11104);
      } 
      f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
    } else {
      f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
      if (UIListenerManager.getInstance().setListnerWithAction("shareToQzone", paramIUiListener) != null)
        f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()"); 
      if (hasActivityForIntent(intent))
        startAssistActivity(paramActivity, 10104, intent, false); 
    } 
    if (hasActivityForIntent(intent)) {
      d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "0", this.mViaShareQzoneType, "0", "1", "0");
      d.a().a(0, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
    } else {
      d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "1", this.mViaShareQzoneType, "0", "1", "0");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
    } 
    f.c("openSDK_LOG", "doShareToQzone() --end");
  }
  
  public void releaseResource() {}
  
  public void shareToQzone(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    // Byte code:
    //   0: ldc 'openSDK_LOG.QzoneShare'
    //   2: ldc_w 'shareToQzone() -- start'
    //   5: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_2
    //   9: ifnonnull -> 75
    //   12: aload_3
    //   13: new com/tencent/tauth/UiError
    //   16: dup
    //   17: bipush #-6
    //   19: ldc_w '传入参数不可以为空'
    //   22: aconst_null
    //   23: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   26: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   31: ldc 'openSDK_LOG.QzoneShare'
    //   33: ldc_w 'shareToQzone() params is null'
    //   36: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: invokestatic a : ()Lcom/tencent/open/b/d;
    //   42: iconst_1
    //   43: ldc_w 'SHARE_CHECK_SDK'
    //   46: ldc_w '1000'
    //   49: aload_0
    //   50: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   53: invokevirtual getAppId : ()Ljava/lang/String;
    //   56: iconst_4
    //   57: invokestatic valueOf : (I)Ljava/lang/String;
    //   60: invokestatic elapsedRealtime : ()J
    //   63: invokestatic valueOf : (J)Ljava/lang/Long;
    //   66: iconst_0
    //   67: iconst_1
    //   68: ldc_w '传入参数不可以为空'
    //   71: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   74: return
    //   75: aload_2
    //   76: ldc 'title'
    //   78: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore #7
    //   83: aload_2
    //   84: ldc 'summary'
    //   86: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   89: astore #11
    //   91: aload_2
    //   92: ldc 'targetUrl'
    //   94: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   97: astore #9
    //   99: aload_2
    //   100: ldc 'imageUrl'
    //   102: invokevirtual getStringArrayList : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   105: astore #10
    //   107: aload_1
    //   108: invokestatic getApplicationLable : (Landroid/content/Context;)Ljava/lang/String;
    //   111: astore #8
    //   113: aload #8
    //   115: ifnonnull -> 129
    //   118: aload_2
    //   119: ldc 'appName'
    //   121: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   124: astore #6
    //   126: goto -> 185
    //   129: aload #8
    //   131: astore #6
    //   133: aload #8
    //   135: invokevirtual length : ()I
    //   138: bipush #20
    //   140: if_icmple -> 185
    //   143: new java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial <init> : ()V
    //   150: astore #6
    //   152: aload #6
    //   154: aload #8
    //   156: iconst_0
    //   157: bipush #20
    //   159: invokevirtual substring : (II)Ljava/lang/String;
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #6
    //   168: ldc_w '...'
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload #6
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: astore #8
    //   182: goto -> 189
    //   185: aload #6
    //   187: astore #8
    //   189: aload_2
    //   190: ldc 'req_type'
    //   192: invokevirtual getInt : (Ljava/lang/String;)I
    //   195: istore #5
    //   197: iload #5
    //   199: iconst_1
    //   200: if_icmpeq -> 246
    //   203: iload #5
    //   205: iconst_5
    //   206: if_icmpeq -> 236
    //   209: iload #5
    //   211: bipush #6
    //   213: if_icmpeq -> 226
    //   216: aload_0
    //   217: ldc_w '1'
    //   220: putfield mViaShareQzoneType : Ljava/lang/String;
    //   223: goto -> 253
    //   226: aload_0
    //   227: ldc_w '4'
    //   230: putfield mViaShareQzoneType : Ljava/lang/String;
    //   233: goto -> 253
    //   236: aload_0
    //   237: ldc_w '2'
    //   240: putfield mViaShareQzoneType : Ljava/lang/String;
    //   243: goto -> 253
    //   246: aload_0
    //   247: ldc_w '1'
    //   250: putfield mViaShareQzoneType : Ljava/lang/String;
    //   253: iload #5
    //   255: iconst_1
    //   256: if_icmpeq -> 569
    //   259: iload #5
    //   261: iconst_5
    //   262: if_icmpeq -> 506
    //   265: iload #5
    //   267: bipush #6
    //   269: if_icmpeq -> 390
    //   272: aload #7
    //   274: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   277: ifeq -> 363
    //   280: aload #11
    //   282: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   285: ifeq -> 363
    //   288: aload #10
    //   290: ifnull -> 313
    //   293: aload #10
    //   295: invokevirtual size : ()I
    //   298: ifeq -> 313
    //   301: aload_0
    //   302: iconst_0
    //   303: putfield a : Z
    //   306: aload #7
    //   308: astore #6
    //   310: goto -> 372
    //   313: new java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial <init> : ()V
    //   320: astore #6
    //   322: aload #6
    //   324: ldc_w '来自'
    //   327: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload #6
    //   333: aload #8
    //   335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload #6
    //   341: ldc_w '的分享'
    //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload #6
    //   350: invokevirtual toString : ()Ljava/lang/String;
    //   353: astore #6
    //   355: aload_0
    //   356: iconst_1
    //   357: putfield a : Z
    //   360: goto -> 372
    //   363: aload_0
    //   364: iconst_1
    //   365: putfield a : Z
    //   368: aload #7
    //   370: astore #6
    //   372: aload_0
    //   373: iconst_0
    //   374: putfield b : Z
    //   377: aload_0
    //   378: iconst_1
    //   379: putfield c : Z
    //   382: aload_0
    //   383: iconst_0
    //   384: putfield d : Z
    //   387: goto -> 593
    //   390: aload_1
    //   391: ldc_w '5.0.0'
    //   394: invokestatic compareQQVersion : (Landroid/content/Context;Ljava/lang/String;)I
    //   397: ifge -> 463
    //   400: aload_3
    //   401: new com/tencent/tauth/UiError
    //   404: dup
    //   405: bipush #-15
    //   407: ldc_w '手Q版本过低，应用分享只支持手Q5.0及其以上版本'
    //   410: aconst_null
    //   411: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   414: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   419: ldc 'openSDK_LOG.QzoneShare'
    //   421: ldc_w '-->shareToQzone, app share is not support below qq5.0.'
    //   424: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   427: invokestatic a : ()Lcom/tencent/open/b/d;
    //   430: iconst_1
    //   431: ldc_w 'SHARE_CHECK_SDK'
    //   434: ldc_w '1000'
    //   437: aload_0
    //   438: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   441: invokevirtual getAppId : ()Ljava/lang/String;
    //   444: iconst_4
    //   445: invokestatic valueOf : (I)Ljava/lang/String;
    //   448: invokestatic elapsedRealtime : ()J
    //   451: invokestatic valueOf : (J)Ljava/lang/Long;
    //   454: iconst_0
    //   455: iconst_1
    //   456: ldc_w 'shareToQzone, app share is not support below qq5.0.'
    //   459: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   462: return
    //   463: ldc_w 'http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1'
    //   466: iconst_2
    //   467: anewarray java/lang/Object
    //   470: dup
    //   471: iconst_0
    //   472: aload_0
    //   473: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   476: invokevirtual getAppId : ()Ljava/lang/String;
    //   479: aastore
    //   480: dup
    //   481: iconst_1
    //   482: ldc_w 'mqq'
    //   485: aastore
    //   486: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   489: astore #9
    //   491: aload_2
    //   492: ldc 'targetUrl'
    //   494: aload #9
    //   496: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   499: aload #7
    //   501: astore #6
    //   503: goto -> 593
    //   506: aload_3
    //   507: new com/tencent/tauth/UiError
    //   510: dup
    //   511: bipush #-5
    //   513: ldc_w '请选择支持的分享类型'
    //   516: aconst_null
    //   517: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   520: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   525: ldc 'openSDK_LOG.QzoneShare'
    //   527: ldc_w 'shareToQzone() error--end请选择支持的分享类型'
    //   530: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   533: invokestatic a : ()Lcom/tencent/open/b/d;
    //   536: iconst_1
    //   537: ldc_w 'SHARE_CHECK_SDK'
    //   540: ldc_w '1000'
    //   543: aload_0
    //   544: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   547: invokevirtual getAppId : ()Ljava/lang/String;
    //   550: iconst_4
    //   551: invokestatic valueOf : (I)Ljava/lang/String;
    //   554: invokestatic elapsedRealtime : ()J
    //   557: invokestatic valueOf : (J)Ljava/lang/Long;
    //   560: iconst_0
    //   561: iconst_1
    //   562: ldc_w 'shareToQzone() 请选择支持的分享类型'
    //   565: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   568: return
    //   569: aload_0
    //   570: iconst_1
    //   571: putfield a : Z
    //   574: aload_0
    //   575: iconst_0
    //   576: putfield b : Z
    //   579: aload_0
    //   580: iconst_1
    //   581: putfield c : Z
    //   584: aload_0
    //   585: iconst_0
    //   586: putfield d : Z
    //   589: aload #7
    //   591: astore #6
    //   593: invokestatic hasSDCard : ()Z
    //   596: ifne -> 672
    //   599: aload_1
    //   600: ldc_w '4.5.0'
    //   603: invokestatic compareQQVersion : (Landroid/content/Context;Ljava/lang/String;)I
    //   606: ifge -> 672
    //   609: aload_3
    //   610: new com/tencent/tauth/UiError
    //   613: dup
    //   614: bipush #-6
    //   616: ldc_w '分享图片失败，检测不到SD卡!'
    //   619: aconst_null
    //   620: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   623: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   628: ldc 'openSDK_LOG.QzoneShare'
    //   630: ldc_w 'shareToQzone() sdcard is null--end'
    //   633: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   636: invokestatic a : ()Lcom/tencent/open/b/d;
    //   639: iconst_1
    //   640: ldc_w 'SHARE_CHECK_SDK'
    //   643: ldc_w '1000'
    //   646: aload_0
    //   647: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   650: invokevirtual getAppId : ()Ljava/lang/String;
    //   653: iconst_4
    //   654: invokestatic valueOf : (I)Ljava/lang/String;
    //   657: invokestatic elapsedRealtime : ()J
    //   660: invokestatic valueOf : (J)Ljava/lang/Long;
    //   663: iconst_0
    //   664: iconst_1
    //   665: ldc_w '分享图片失败，检测不到SD卡!'
    //   668: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   671: return
    //   672: aload_0
    //   673: getfield a : Z
    //   676: ifeq -> 821
    //   679: aload #9
    //   681: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   684: ifeq -> 750
    //   687: aload_3
    //   688: new com/tencent/tauth/UiError
    //   691: dup
    //   692: bipush #-5
    //   694: ldc_w 'targetUrl为必填项，请补充后分享'
    //   697: aconst_null
    //   698: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   701: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   706: ldc 'openSDK_LOG.QzoneShare'
    //   708: ldc_w 'shareToQzone() targetUrl null error--end'
    //   711: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   714: invokestatic a : ()Lcom/tencent/open/b/d;
    //   717: iconst_1
    //   718: ldc_w 'SHARE_CHECK_SDK'
    //   721: ldc_w '1000'
    //   724: aload_0
    //   725: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   728: invokevirtual getAppId : ()Ljava/lang/String;
    //   731: iconst_4
    //   732: invokestatic valueOf : (I)Ljava/lang/String;
    //   735: invokestatic elapsedRealtime : ()J
    //   738: invokestatic valueOf : (J)Ljava/lang/Long;
    //   741: iconst_0
    //   742: iconst_1
    //   743: ldc_w 'targetUrl为必填项，请补充后分享'
    //   746: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   749: return
    //   750: aload #9
    //   752: invokestatic isValidUrl : (Ljava/lang/String;)Z
    //   755: ifne -> 821
    //   758: aload_3
    //   759: new com/tencent/tauth/UiError
    //   762: dup
    //   763: bipush #-5
    //   765: ldc_w 'targetUrl有误'
    //   768: aconst_null
    //   769: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   772: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   777: ldc 'openSDK_LOG.QzoneShare'
    //   779: ldc_w 'shareToQzone() targetUrl error--end'
    //   782: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   785: invokestatic a : ()Lcom/tencent/open/b/d;
    //   788: iconst_1
    //   789: ldc_w 'SHARE_CHECK_SDK'
    //   792: ldc_w '1000'
    //   795: aload_0
    //   796: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   799: invokevirtual getAppId : ()Ljava/lang/String;
    //   802: iconst_4
    //   803: invokestatic valueOf : (I)Ljava/lang/String;
    //   806: invokestatic elapsedRealtime : ()J
    //   809: invokestatic valueOf : (J)Ljava/lang/Long;
    //   812: iconst_0
    //   813: iconst_1
    //   814: ldc_w 'targetUrl有误'
    //   817: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   820: return
    //   821: aload_0
    //   822: getfield b : Z
    //   825: ifeq -> 847
    //   828: aload_2
    //   829: ldc 'title'
    //   831: ldc ''
    //   833: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   836: aload_2
    //   837: ldc 'summary'
    //   839: ldc ''
    //   841: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   844: goto -> 998
    //   847: aload_0
    //   848: getfield c : Z
    //   851: ifeq -> 925
    //   854: aload #6
    //   856: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   859: ifeq -> 925
    //   862: aload_3
    //   863: new com/tencent/tauth/UiError
    //   866: dup
    //   867: bipush #-6
    //   869: ldc_w 'title不能为空!'
    //   872: aconst_null
    //   873: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   876: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   881: ldc 'openSDK_LOG.QzoneShare'
    //   883: ldc_w 'shareToQzone() title is null--end'
    //   886: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   889: invokestatic a : ()Lcom/tencent/open/b/d;
    //   892: iconst_1
    //   893: ldc_w 'SHARE_CHECK_SDK'
    //   896: ldc_w '1000'
    //   899: aload_0
    //   900: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   903: invokevirtual getAppId : ()Ljava/lang/String;
    //   906: iconst_4
    //   907: invokestatic valueOf : (I)Ljava/lang/String;
    //   910: invokestatic elapsedRealtime : ()J
    //   913: invokestatic valueOf : (J)Ljava/lang/Long;
    //   916: iconst_0
    //   917: iconst_1
    //   918: ldc_w 'shareToQzone() title is null'
    //   921: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   924: return
    //   925: aload #6
    //   927: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   930: ifne -> 963
    //   933: aload #6
    //   935: invokevirtual length : ()I
    //   938: sipush #200
    //   941: if_icmple -> 963
    //   944: aload_2
    //   945: ldc 'title'
    //   947: aload #6
    //   949: sipush #200
    //   952: aconst_null
    //   953: aconst_null
    //   954: invokestatic subString : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   957: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   960: goto -> 963
    //   963: aload #11
    //   965: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   968: ifne -> 998
    //   971: aload #11
    //   973: invokevirtual length : ()I
    //   976: sipush #600
    //   979: if_icmple -> 998
    //   982: aload_2
    //   983: ldc 'summary'
    //   985: aload #11
    //   987: sipush #600
    //   990: aconst_null
    //   991: aconst_null
    //   992: invokestatic subString : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   995: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   998: aload #8
    //   1000: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1003: ifne -> 1014
    //   1006: aload_2
    //   1007: ldc 'appName'
    //   1009: aload #8
    //   1011: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1014: aload #10
    //   1016: ifnull -> 1175
    //   1019: aload #10
    //   1021: ifnull -> 1035
    //   1024: aload #10
    //   1026: invokevirtual size : ()I
    //   1029: ifne -> 1035
    //   1032: goto -> 1175
    //   1035: iconst_0
    //   1036: istore #4
    //   1038: iload #4
    //   1040: aload #10
    //   1042: invokevirtual size : ()I
    //   1045: if_icmpge -> 1093
    //   1048: aload #10
    //   1050: iload #4
    //   1052: invokevirtual get : (I)Ljava/lang/Object;
    //   1055: checkcast java/lang/String
    //   1058: astore #6
    //   1060: aload #6
    //   1062: invokestatic isValidUrl : (Ljava/lang/String;)Z
    //   1065: ifne -> 1084
    //   1068: aload #6
    //   1070: invokestatic isValidPath : (Ljava/lang/String;)Z
    //   1073: ifne -> 1084
    //   1076: aload #10
    //   1078: iload #4
    //   1080: invokevirtual remove : (I)Ljava/lang/Object;
    //   1083: pop
    //   1084: iload #4
    //   1086: iconst_1
    //   1087: iadd
    //   1088: istore #4
    //   1090: goto -> 1038
    //   1093: aload #10
    //   1095: invokevirtual size : ()I
    //   1098: ifne -> 1164
    //   1101: aload_3
    //   1102: new com/tencent/tauth/UiError
    //   1105: dup
    //   1106: bipush #-6
    //   1108: ldc_w '非法的图片地址!'
    //   1111: aconst_null
    //   1112: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   1115: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   1120: ldc 'openSDK_LOG.QzoneShare'
    //   1122: ldc_w 'shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end'
    //   1125: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1128: invokestatic a : ()Lcom/tencent/open/b/d;
    //   1131: iconst_1
    //   1132: ldc_w 'SHARE_CHECK_SDK'
    //   1135: ldc_w '1000'
    //   1138: aload_0
    //   1139: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   1142: invokevirtual getAppId : ()Ljava/lang/String;
    //   1145: iconst_4
    //   1146: invokestatic valueOf : (I)Ljava/lang/String;
    //   1149: invokestatic elapsedRealtime : ()J
    //   1152: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1155: iconst_0
    //   1156: iconst_1
    //   1157: ldc_w 'shareToQzone() 非法的图片地址!'
    //   1160: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1163: return
    //   1164: aload_2
    //   1165: ldc 'imageUrl'
    //   1167: aload #10
    //   1169: invokevirtual putStringArrayList : (Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1172: goto -> 1245
    //   1175: aload_0
    //   1176: getfield d : Z
    //   1179: ifeq -> 1245
    //   1182: aload_3
    //   1183: new com/tencent/tauth/UiError
    //   1186: dup
    //   1187: bipush #-6
    //   1189: ldc_w '纯图分享，imageUrl 不能为空'
    //   1192: aconst_null
    //   1193: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   1196: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   1201: ldc 'openSDK_LOG.QzoneShare'
    //   1203: ldc_w 'shareToQzone() imageUrl is null -- end'
    //   1206: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1209: invokestatic a : ()Lcom/tencent/open/b/d;
    //   1212: iconst_1
    //   1213: ldc_w 'SHARE_CHECK_SDK'
    //   1216: ldc_w '1000'
    //   1219: aload_0
    //   1220: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   1223: invokevirtual getAppId : ()Ljava/lang/String;
    //   1226: iconst_4
    //   1227: invokestatic valueOf : (I)Ljava/lang/String;
    //   1230: invokestatic elapsedRealtime : ()J
    //   1233: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1236: iconst_0
    //   1237: iconst_1
    //   1238: ldc_w 'shareToQzone() imageUrl is null'
    //   1241: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1244: return
    //   1245: aload_1
    //   1246: ldc '4.6.0'
    //   1248: invokestatic compareQQVersion : (Landroid/content/Context;Ljava/lang/String;)I
    //   1251: iflt -> 1282
    //   1254: ldc 'openSDK_LOG.QzoneShare'
    //   1256: ldc_w 'shareToQzone() qqver greater than 4.6.0'
    //   1259: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1262: aload_1
    //   1263: aload #10
    //   1265: new com/tencent/connect/share/QzoneShare$1
    //   1268: dup
    //   1269: aload_0
    //   1270: aload_2
    //   1271: aload_1
    //   1272: aload_3
    //   1273: invokespecial <init> : (Lcom/tencent/connect/share/QzoneShare;Landroid/os/Bundle;Landroid/app/Activity;Lcom/tencent/tauth/IUiListener;)V
    //   1276: invokestatic a : (Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/open/utils/AsynLoadImgBack;)V
    //   1279: goto -> 1492
    //   1282: aload_1
    //   1283: ldc_w '4.2.0'
    //   1286: invokestatic compareQQVersion : (Landroid/content/Context;Ljava/lang/String;)I
    //   1289: iflt -> 1460
    //   1292: aload_1
    //   1293: ldc '4.6.0'
    //   1295: invokestatic compareQQVersion : (Landroid/content/Context;Ljava/lang/String;)I
    //   1298: ifge -> 1460
    //   1301: ldc 'openSDK_LOG.QzoneShare'
    //   1303: ldc_w 'shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare'
    //   1306: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1309: new com/tencent/connect/share/QQShare
    //   1312: dup
    //   1313: aload_1
    //   1314: aload_0
    //   1315: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   1318: invokespecial <init> : (Landroid/content/Context;Lcom/tencent/connect/auth/QQToken;)V
    //   1321: astore #6
    //   1323: aload #10
    //   1325: ifnull -> 1432
    //   1328: aload #10
    //   1330: invokevirtual size : ()I
    //   1333: ifle -> 1432
    //   1336: aload #10
    //   1338: iconst_0
    //   1339: invokevirtual get : (I)Ljava/lang/Object;
    //   1342: checkcast java/lang/String
    //   1345: astore #7
    //   1347: iload #5
    //   1349: iconst_5
    //   1350: if_icmpne -> 1424
    //   1353: aload #7
    //   1355: invokestatic fileExists : (Ljava/lang/String;)Z
    //   1358: ifne -> 1424
    //   1361: aload_3
    //   1362: new com/tencent/tauth/UiError
    //   1365: dup
    //   1366: bipush #-6
    //   1368: ldc_w '手Q版本过低，纯图分享不支持网路图片'
    //   1371: aconst_null
    //   1372: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   1375: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   1380: ldc 'openSDK_LOG.QzoneShare'
    //   1382: ldc_w 'shareToQzone()手Q版本过低，纯图分享不支持网路图片'
    //   1385: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1388: invokestatic a : ()Lcom/tencent/open/b/d;
    //   1391: iconst_1
    //   1392: ldc_w 'SHARE_CHECK_SDK'
    //   1395: ldc_w '1000'
    //   1398: aload_0
    //   1399: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   1402: invokevirtual getAppId : ()Ljava/lang/String;
    //   1405: iconst_4
    //   1406: invokestatic valueOf : (I)Ljava/lang/String;
    //   1409: invokestatic elapsedRealtime : ()J
    //   1412: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1415: iconst_0
    //   1416: iconst_1
    //   1417: ldc_w 'shareToQzone()手Q版本过低，纯图分享不支持网路图片'
    //   1420: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1423: return
    //   1424: aload_2
    //   1425: ldc 'imageLocalUrl'
    //   1427: aload #7
    //   1429: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1432: aload_1
    //   1433: ldc_w '4.5.0'
    //   1436: invokestatic compareQQVersion : (Landroid/content/Context;Ljava/lang/String;)I
    //   1439: iflt -> 1449
    //   1442: aload_2
    //   1443: ldc 'cflag'
    //   1445: iconst_1
    //   1446: invokevirtual putInt : (Ljava/lang/String;I)V
    //   1449: aload #6
    //   1451: aload_1
    //   1452: aload_2
    //   1453: aload_3
    //   1454: invokevirtual shareToQQ : (Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/tauth/IUiListener;)V
    //   1457: goto -> 1492
    //   1460: ldc 'openSDK_LOG.QzoneShare'
    //   1462: ldc_w 'shareToQzone() qqver below 4.2.0, will show download dialog'
    //   1465: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1468: new com/tencent/open/TDialog
    //   1471: dup
    //   1472: aload_1
    //   1473: ldc ''
    //   1475: aload_0
    //   1476: ldc ''
    //   1478: invokevirtual getCommonDownloadQQUrl : (Ljava/lang/String;)Ljava/lang/String;
    //   1481: aconst_null
    //   1482: aload_0
    //   1483: getfield mToken : Lcom/tencent/connect/auth/QQToken;
    //   1486: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tauth/IUiListener;Lcom/tencent/connect/auth/QQToken;)V
    //   1489: invokevirtual show : ()V
    //   1492: ldc 'openSDK_LOG.QzoneShare'
    //   1494: ldc_w 'shareToQzone() --end'
    //   1497: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1500: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\share\QzoneShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */