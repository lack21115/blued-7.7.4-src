package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;

public class QzonePublish extends BaseApi {
  public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
  
  public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
  
  public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
  
  public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
  
  public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
  
  public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
  
  public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
  
  public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
  
  public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";
  
  public QzonePublish(Context paramContext, QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  private void a(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
    StringBuffer stringBuffer = new StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
    ArrayList<String> arrayList = paramBundle.getStringArrayList("imageUrl");
    String str3 = paramBundle.getString("summary");
    int i = paramBundle.getInt("req_type", 3);
    String str1 = paramBundle.getString("appName");
    String str5 = paramBundle.getString("videoPath");
    int j = paramBundle.getInt("videoDuration");
    long l = paramBundle.getLong("videoSize");
    String str4 = this.mToken.getAppId();
    String str2 = this.mToken.getOpenId();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("openId:");
    stringBuilder.append(str2);
    f.a("openSDK_LOG.QzonePublish", stringBuilder.toString());
    if (3 == i && arrayList != null) {
      StringBuffer stringBuffer1 = new StringBuffer();
      int m = arrayList.size();
      int k = 0;
      ArrayList<String> arrayList1 = arrayList;
      while (k < m) {
        stringBuffer1.append(URLEncoder.encode(arrayList1.get(k)));
        if (k != m - 1)
          stringBuffer1.append(";"); 
        k++;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("&image_url=");
      stringBuilder1.append(Base64.encodeToString(Util.getBytesUTF8(stringBuffer1.toString()), 2));
      stringBuffer.append(stringBuilder1.toString());
    } 
    if (4 == i) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&videoPath=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str5), 2));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("&videoDuration=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(String.valueOf(j)), 2));
      stringBuffer.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("&videoSize=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(String.valueOf(l)), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str3)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&description=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str3), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str4)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&share_id=");
      stringBuilder.append(str4);
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(str1)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&app_name=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str1), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    if (!Util.isEmpty(str2)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("&open_id=");
      stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(str2), 2));
      stringBuffer.append(stringBuilder.toString());
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append("&req_type=");
    stringBuilder.append(Base64.encodeToString(Util.getBytesUTF8(String.valueOf(i)), 2));
    stringBuffer.append(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("doPublishToQzone, url: ");
    stringBuilder.append(stringBuffer.toString());
    f.a("openSDK_LOG.QzonePublish", stringBuilder.toString());
    a.a(Global.getContext(), this.mToken, "requireApi", new String[] { "shareToNativeQQ" });
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.setData(Uri.parse(stringBuffer.toString()));
    intent.putExtra("pkg_name", paramActivity.getPackageName());
    if (hasActivityForIntent(intent)) {
      startAssistActivity(paramActivity, 10104, intent, false);
      d.a().a(0, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
    } else {
      f.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
    } 
    f.c("openSDK_LOG", "doPublishToQzone() --end");
  }
  
  public void publishToQzone(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    String str1;
    f.c("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
    if (paramBundle == null) {
      paramIUiListener.onError(new UiError(-6, "传入参数不可以为空", null));
      f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "传入参数不可以为空");
      return;
    } 
    if (SystemUtils.compareQQVersion((Context)paramActivity, "5.9.5") < 0) {
      paramIUiListener.onError(new UiError(-15, "手Q版本过低，请下载安装最新版手Q", null));
      f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
      (new TDialog((Context)paramActivity, "", getCommonDownloadQQUrl(""), null, this.mToken)).show();
      return;
    } 
    String str3 = paramBundle.getString("summary");
    ArrayList<String> arrayList = paramBundle.getStringArrayList("imageUrl");
    String str2 = Util.getApplicationLable((Context)paramActivity);
    int i = 0;
    if (str2 == null) {
      str1 = paramBundle.getString("appName");
    } else {
      str1 = str2;
      if (str2.length() > 20) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2.substring(0, 20));
        stringBuilder.append("...");
        str1 = stringBuilder.toString();
      } 
    } 
    if (!TextUtils.isEmpty(str1))
      paramBundle.putString("appName", str1); 
    paramBundle.putString("summary", str3);
    int j = paramBundle.getInt("req_type");
    if (j == 3) {
      if (arrayList != null && arrayList.size() > 0) {
        while (i < arrayList.size()) {
          if (!Util.isValidPath(arrayList.get(i)))
            arrayList.remove(i); 
          i++;
        } 
        paramBundle.putStringArrayList("imageUrl", arrayList);
      } 
      a(paramActivity, paramBundle, paramIUiListener);
      f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
      return;
    } 
    if (j == 4) {
      str1 = paramBundle.getString("videoPath");
      if (!Util.isValidPath(str1)) {
        f.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
        paramIUiListener.onError(new UiError(-5, "请选择有效的视频文件", null));
        return;
      } 
      MediaPlayer mediaPlayer = new MediaPlayer();
      mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this, str1, paramBundle, paramActivity, paramIUiListener) {
            public void onPrepared(MediaPlayer param1MediaPlayer) {
              long l = (new File(this.a)).length();
              int i = param1MediaPlayer.getDuration();
              this.b.putString("videoPath", this.a);
              this.b.putInt("videoDuration", i);
              this.b.putLong("videoSize", l);
              QzonePublish.a(this.e, this.c, this.b, this.d);
              f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            }
          });
      mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(this, paramIUiListener) {
            public boolean onError(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
              f.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
              this.a.onError(new UiError(-5, "请选择有效的视频文件", null));
              return false;
            }
          });
      try {
        mediaPlayer.setDataSource(str1);
        mediaPlayer.prepareAsync();
        return;
      } catch (Exception exception) {
        f.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
        paramIUiListener.onError(new UiError(-5, "请选择有效的视频文件", null));
        return;
      } 
    } 
    paramIUiListener.onError(new UiError(-5, "请选择支持的分享类型", null));
    f.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\share\QzonePublish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */