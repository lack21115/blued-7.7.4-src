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
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.AsynLoadImg;
import com.tencent.open.utils.AsynLoadImgBack;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;

public class QQShare extends BaseApi {
  public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 60;
  
  public static final int QQ_SHARE_TITLE_MAX_LENGTH = 45;
  
  public static final String SHARE_TO_QQ_APP_NAME = "appName";
  
  public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
  
  public static final String SHARE_TO_QQ_EXT_INT = "cflag";
  
  public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
  
  public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
  
  public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
  
  public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
  
  public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
  
  public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
  
  public static final String SHARE_TO_QQ_SITE = "site";
  
  public static final String SHARE_TO_QQ_SUMMARY = "summary";
  
  public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
  
  public static final String SHARE_TO_QQ_TITLE = "title";
  
  public static final int SHARE_TO_QQ_TYPE_APP = 6;
  
  public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
  
  public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
  
  public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
  
  public String mViaShareQQType = "";
  
  public QQShare(Context paramContext, QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  private void a(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
    String str1 = paramBundle.getString("imageUrl");
    String str2 = paramBundle.getString("title");
    String str3 = paramBundle.getString("summary");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shareToMobileQQ -- imageUrl: ");
    stringBuilder.append(str1);
    f.a("openSDK_LOG.QQShare", stringBuilder.toString());
    if (!TextUtils.isEmpty(str1)) {
      if (Util.isValidUrl(str1)) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
          if (paramIUiListener != null) {
            paramIUiListener.onError(new UiError(-6, "分享图片失败，检测不到SD卡!", null));
            f.e("openSDK_LOG.QQShare", "分享图片失败，检测不到SD卡!");
          } 
          d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享图片失败，检测不到SD卡!");
          return;
        } 
        if (SystemUtils.compareQQVersion((Context)paramActivity, "4.3.0") >= 0) {
          b(paramActivity, paramBundle, paramIUiListener);
        } else {
          (new AsynLoadImg(paramActivity)).save(str1, new AsynLoadImgBack(this, paramBundle, str2, str3, paramIUiListener, paramActivity) {
                public void batchSaved(int param1Int, ArrayList<String> param1ArrayList) {}
                
                public void saved(int param1Int, String param1String) {
                  if (param1Int == 0) {
                    this.a.putString("imageLocalUrl", param1String);
                  } else if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c)) {
                    IUiListener iUiListener = this.d;
                    if (iUiListener != null) {
                      iUiListener.onError(new UiError(-6, "获取分享图片失败!", null));
                      f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                    } 
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", QQShare.a(this.f).getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "获取分享图片失败!");
                    return;
                  } 
                  QQShare.a(this.f, this.e, this.a, this.d);
                }
              });
        } 
      } else {
        paramBundle.putString("imageUrl", null);
        if (SystemUtils.compareQQVersion((Context)paramActivity, "4.3.0") < 0) {
          f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
          b(paramActivity, paramBundle, paramIUiListener);
        } else {
          f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0 ");
          a.a((Context)paramActivity, str1, new AsynLoadImgBack(this, paramBundle, str2, str3, paramIUiListener, paramActivity) {
                public void batchSaved(int param1Int, ArrayList<String> param1ArrayList) {}
                
                public void saved(int param1Int, String param1String) {
                  if (param1Int == 0) {
                    this.a.putString("imageLocalUrl", param1String);
                  } else if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c)) {
                    IUiListener iUiListener = this.d;
                    if (iUiListener != null) {
                      iUiListener.onError(new UiError(-6, "获取分享图片失败!", null));
                      f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                    } 
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", QQShare.b(this.f).getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "获取分享图片失败!");
                    return;
                  } 
                  QQShare.a(this.f, this.e, this.a, this.d);
                }
              });
        } 
      } 
    } else {
      b(paramActivity, paramBundle, paramIUiListener);
    } 
    f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
  }
  
  private void b(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QQShare", "doShareToQQ() -- start");
    StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
    String str9 = paramBundle.getString("imageUrl");
    String str8 = paramBundle.getString("title");
    String str7 = paramBundle.getString("summary");
    String str6 = paramBundle.getString("targetUrl");
    String str5 = paramBundle.getString("audio_url");
    int i = paramBundle.getInt("req_type", 1);
    int j = paramBundle.getInt("cflag", 0);
    String str4 = paramBundle.getString("share_qq_ext_str");
    String str3 = Util.getApplicationLable((Context)paramActivity);
    String str2 = str3;
    if (str3 == null)
      str2 = paramBundle.getString("appName"); 
    String str10 = paramBundle.getString("imageLocalUrl");
    String str1 = this.mToken.getAppId();
    str3 = this.mToken.getOpenId();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("doShareToQQ -- openid: ");
    stringBuilder2.append(str3);
    f.a("openSDK_LOG.QQShare", stringBuilder2.toString());
    if (!TextUtils.isEmpty(str9)) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&image_url=");
      stringBuilder2.append(Base64.encodeToString(Util.getBytesUTF8(str9), 2));
      stringBuffer.append(stringBuilder2.toString());
    } 
    if (!TextUtils.isEmpty(str10)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("&file_data=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str10), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str8)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("&title=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str8), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str7)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("&description=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str7), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("&share_id=");
      stringBuilder.append(str1);
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str6)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("&url=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str6), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str2)) {
      String str;
      str1 = str2;
      if (str2.length() > 20) {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str2.substring(0, 20));
        stringBuilder3.append("...");
        str = stringBuilder3.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("&app_name=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str3)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("&open_id=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str3), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str5)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("&audioUrl=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str5), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("&req_type=");
    stringBuilder1.append(Base64.encodeToString(Util.getBytesUTF8(String.valueOf(i)), 2));
    stringBuffer.append(stringBuilder1.toString());
    if (!TextUtils.isEmpty(str4)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("&share_qq_ext_str=");
      stringBuilder1.append(Base64.encodeToString(Util.getBytesUTF8(str4), 2));
      stringBuffer.append(stringBuilder1.toString());
    } 
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("&cflag=");
    stringBuilder1.append(Base64.encodeToString(Util.getBytesUTF8(String.valueOf(j)), 2));
    stringBuffer.append(stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("doShareToQQ -- url: ");
    stringBuilder1.append(stringBuffer.toString());
    f.a("openSDK_LOG.QQShare", stringBuilder1.toString());
    a.a(Global.getContext(), this.mToken, "requireApi", new String[] { "shareToNativeQQ" });
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.setData(Uri.parse(stringBuffer.toString()));
    intent.putExtra("pkg_name", paramActivity.getPackageName());
    if (SystemUtils.compareQQVersion((Context)paramActivity, "4.6.0") < 0) {
      f.c("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
      if (hasActivityForIntent(intent)) {
        UIListenerManager.getInstance().setListenerWithRequestcode(11103, paramIUiListener);
        startAssitActivity(paramActivity, intent, 11103);
      } 
    } else {
      f.c("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
      if (UIListenerManager.getInstance().setListnerWithAction("shareToQQ", paramIUiListener) != null)
        f.c("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it."); 
      if (hasActivityForIntent(intent))
        startAssistActivity(paramActivity, 10103, intent, true); 
    } 
    if (hasActivityForIntent(intent)) {
      d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "ANDROIDQQ.SHARETOQQ.XX", "10", "3", "0", this.mViaShareQQType, "0", "1", "0");
      d.a().a(0, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
    } else {
      d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "ANDROIDQQ.SHARETOQQ.XX", "10", "3", "1", this.mViaShareQQType, "0", "1", "0");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
    } 
    f.c("openSDK_LOG.QQShare", "doShareToQQ() --end");
  }
  
  public void releaseResource() {}
  
  public void shareToQQ(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QQShare", "shareToQQ() -- start.");
    String str2 = paramBundle.getString("imageUrl");
    String str3 = paramBundle.getString("title");
    String str4 = paramBundle.getString("summary");
    String str1 = paramBundle.getString("targetUrl");
    String str5 = paramBundle.getString("imageLocalUrl");
    int i = paramBundle.getInt("req_type", 1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shareToQQ -- type: ");
    stringBuilder.append(i);
    f.c("openSDK_LOG.QQShare", stringBuilder.toString());
    if (i != 1) {
      if (i != 2) {
        if (i != 5) {
          if (i == 6)
            this.mViaShareQQType = "4"; 
        } else {
          this.mViaShareQQType = "2";
        } 
      } else {
        this.mViaShareQQType = "3";
      } 
    } else {
      this.mViaShareQQType = "1";
    } 
    if (i == 6) {
      if (SystemUtils.compareQQVersion((Context)paramActivity, "5.0.0") < 0) {
        paramIUiListener.onError(new UiError(-15, "手Q版本过低，应用分享只支持手Q5.0及其以上版本", null));
        f.e("openSDK_LOG.QQShare", "shareToQQ, app share is not support below qq5.0.");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, app share is not support below qq5.0.");
        return;
      } 
      str1 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", new Object[] { this.mToken.getAppId(), "mqq" });
      paramBundle.putString("targetUrl", str1);
    } 
    if (!Util.hasSDCard() && SystemUtils.compareQQVersion((Context)paramActivity, "4.5.0") < 0) {
      paramIUiListener.onError(new UiError(-6, "分享图片失败，检测不到SD卡!", null));
      f.e("openSDK_LOG.QQShare", "shareToQQ sdcard is null--end");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
      return;
    } 
    if (i == 5) {
      if (SystemUtils.compareQQVersion((Context)paramActivity, "4.3.0") < 0) {
        paramIUiListener.onError(new UiError(-6, "低版本手Q不支持该项功能!", null));
        f.e("openSDK_LOG.QQShare", "shareToQQ, version below 4.3 is not support.");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
        return;
      } 
      if (!Util.fileExists(str5)) {
        paramIUiListener.onError(new UiError(-6, "非法的图片地址!", null));
        f.e("openSDK_LOG.QQShare", "shareToQQ -- error: 非法的图片地址!");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "非法的图片地址!");
        return;
      } 
    } 
    if (i != 5) {
      if (TextUtils.isEmpty(str1) || (!str1.startsWith("http://") && !str1.startsWith("https://"))) {
        paramIUiListener.onError(new UiError(-6, "传入参数有误!", null));
        f.e("openSDK_LOG.QQShare", "shareToQQ, targetUrl is empty or illegal..");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
        return;
      } 
      if (TextUtils.isEmpty(str3)) {
        paramIUiListener.onError(new UiError(-6, "title不能为空!", null));
        f.e("openSDK_LOG.QQShare", "shareToQQ, title is empty.");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
        return;
      } 
    } 
    if (!TextUtils.isEmpty(str2) && !str2.startsWith("http://") && !str2.startsWith("https://") && !(new File(str2)).exists()) {
      paramIUiListener.onError(new UiError(-6, "非法的图片地址!", null));
      f.e("openSDK_LOG.QQShare", "shareToQQ, image url is emprty or illegal.");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
      return;
    } 
    if (!TextUtils.isEmpty(str3) && str3.length() > 45)
      paramBundle.putString("title", Util.subString(str3, 45, null, null)); 
    if (!TextUtils.isEmpty(str4) && str4.length() > 60)
      paramBundle.putString("summary", Util.subString(str4, 60, null, null)); 
    if (Util.isMobileQQSupportShare((Context)paramActivity)) {
      f.c("openSDK_LOG.QQShare", "shareToQQ, support share");
      a(paramActivity, paramBundle, paramIUiListener);
    } else {
      try {
        f.d("openSDK_LOG.QQShare", "shareToQQ, don't support share, will show download dialog");
        (new TDialog((Context)paramActivity, "", getCommonDownloadQQUrl(""), null, this.mToken)).show();
      } catch (RuntimeException runtimeException) {
        f.b("openSDK_LOG.QQShare", " shareToQQ, TDialog.show not in main thread", runtimeException);
        runtimeException.printStackTrace();
        paramIUiListener.onError(new UiError(-6, "没有在主线程调用！", null));
      } 
    } 
    f.c("openSDK_LOG.QQShare", "shareToQQ() -- end.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\share\QQShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */