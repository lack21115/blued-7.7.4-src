package com.blued.android.share.sina;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module_share_china.R;
import com.blued.android.share.Constants;
import com.blued.android.share.ShareProvider;
import com.blued.android.share.Util;
import com.sina.weibo.sdk.api.BaseMediaObject;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseRequest;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.utils.Utility;
import com.soft.blued.utils.UIUtils;
import java.io.File;

public class SinaShareActivity extends Activity implements IWeiboHandler.Response {
  private String des;
  
  private String fileUrl;
  
  private int flag;
  
  private String imgUrl;
  
  private boolean isInstalledWeibo;
  
  private String linkUrl;
  
  private Bitmap mBigBitmap;
  
  private Bitmap mBitmap;
  
  boolean mIsCompleteTask;
  
  private IWeiboShareAPI mWeiboShareAPI = null;
  
  private String title;
  
  private void doFinish() {
    ShareProvider.getInstance().unregisterCallback();
    finish();
  }
  
  private void downloadImage() {
    final StringBuilder finalPhotoPath;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("sina start download image:");
    stringBuilder2.append(this.imgUrl);
    Logger.c("module_share", new Object[] { stringBuilder2.toString() });
    String str = RecyclingUtils.d(this.imgUrl);
    if ((new File(str)).exists()) {
      this.fileUrl = str;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("download file exists:");
      stringBuilder1.append(this.fileUrl);
      Logger.c("module_share", new Object[] { stringBuilder1.toString() });
      zoomImage();
      return;
    } 
    Logger.c("module_share", new Object[] { "file not exists." });
    final ProgressDialog pDialog = Util.showProgressDialog((Context)this);
    FileDownloader.a(this.imgUrl, (String)stringBuilder1, new FileHttpResponseHandler() {
          public void onFailure(Throwable param1Throwable, int param1Int, File param1File) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("file download fail:");
            stringBuilder.append(SinaShareActivity.this.imgUrl);
            Logger.c("module_share", new Object[] { stringBuilder.toString() });
          }
          
          public void onFinish() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("file download finish:");
            stringBuilder.append(SinaShareActivity.this.imgUrl);
            Logger.c("module_share", new Object[] { stringBuilder.toString() });
            AppInfo.n().post(new Runnable() {
                  public void run() {
                    if (!SinaShareActivity.this.isFinishing())
                      Util.hideProgressDialog(pDialog); 
                    SinaShareActivity.this.zoomImage();
                  }
                });
          }
          
          public void onSuccess(File param1File) {
            SinaShareActivity.access$002(SinaShareActivity.this, finalPhotoPath);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("file download success:");
            stringBuilder.append(SinaShareActivity.this.imgUrl);
            Logger.c("module_share", new Object[] { stringBuilder.toString() });
          }
        }null);
  }
  
  private String getAppKey() {
    return TextUtils.equals("a0300a", AppInfo.c) ? "183873903" : "2677078813";
  }
  
  private ImageObject getImageObj() {
    ImageObject imageObject = new ImageObject();
    imageObject.setImageObject(this.mBigBitmap);
    return imageObject;
  }
  
  private TextObject getTextObj() {
    TextObject textObject = new TextObject();
    textObject.text = this.des;
    textObject.setThumbImage(this.mBitmap);
    return textObject;
  }
  
  private WebpageObject getWebpageObj() {
    WebpageObject webpageObject = new WebpageObject();
    webpageObject.identify = Utility.generateGUID();
    webpageObject.title = this.title;
    webpageObject.description = this.des;
    webpageObject.setThumbImage(this.mBitmap);
    webpageObject.actionUrl = this.linkUrl;
    webpageObject.defaultText = "web";
    return webpageObject;
  }
  
  private void sendMultiMessage(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
    if (paramBoolean1)
      weiboMultiMessage.textObject = getTextObj(); 
    if (paramBoolean2)
      weiboMultiMessage.imageObject = getImageObj(); 
    if (paramBoolean3)
      weiboMultiMessage.mediaObject = (BaseMediaObject)getWebpageObj(); 
    SendMultiMessageToWeiboRequest sendMultiMessageToWeiboRequest = new SendMultiMessageToWeiboRequest();
    sendMultiMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
    sendMultiMessageToWeiboRequest.multiMessage = weiboMultiMessage;
    this.mWeiboShareAPI.sendRequest(this, (BaseRequest)sendMultiMessageToWeiboRequest);
  }
  
  private void sendSingleMessage(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    WeiboMessage weiboMessage = new WeiboMessage();
    if (paramBoolean1)
      weiboMessage.mediaObject = (BaseMediaObject)getTextObj(); 
    if (paramBoolean2)
      weiboMessage.mediaObject = (BaseMediaObject)getImageObj(); 
    if (paramBoolean3)
      weiboMessage.mediaObject = (BaseMediaObject)getWebpageObj(); 
    SendMessageToWeiboRequest sendMessageToWeiboRequest = new SendMessageToWeiboRequest();
    sendMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
    sendMessageToWeiboRequest.message = weiboMessage;
    this.mWeiboShareAPI.sendRequest(this, (BaseRequest)sendMessageToWeiboRequest);
  }
  
  private void zoomImage() {
    Logger.c("module_share", new Object[] { "start zoom image" });
    if (!TextUtils.isEmpty(this.fileUrl)) {
      Logger.c("module_share", new Object[] { "!TextUtils.isEmpty(fileUrl)" });
      this.mBitmap = Util.imageZoomToSize(this.fileUrl, 20);
      this.mBigBitmap = Util.imageZoomToSize(this.fileUrl, 150);
    } 
    if (this.mBitmap == null) {
      Logger.c("module_share", new Object[] { "mBitmap == null" });
      this.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blued_logo_500);
      this.mBigBitmap = this.mBitmap;
    } 
    ThreadManager.a().a(new ThreadExecutor("zoomImage") {
          public void execute() {
            if (SinaShareActivity.this.mBitmap == null) {
              Logger.c("module_share", new Object[] { "sendmsg:true,false,false" });
              SinaShareActivity.this.sendMessage(true, false, false);
              return;
            } 
            Logger.c("module_share", new Object[] { "sendmsg:true,true,true" });
            SinaShareActivity.this.sendMessage(true, true, true);
          }
        });
  }
  
  public void onBackPressed() {
    doFinish();
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    if (Build.VERSION.SDK_INT == 26 && UIUtils.a((Context)this)) {
      boolean bool = UIUtils.a(this);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onCreate fixOrientation when Oreo, result = ");
      stringBuilder.append(bool);
      Log.c("WXEntryActivity", stringBuilder.toString());
    } 
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_empty_share);
    this.mWeiboShareAPI = WeiboShareSDK.createWeiboAPI((Context)this, getAppKey());
    this.mWeiboShareAPI.registerApp();
    if (paramBundle != null) {
      this.mWeiboShareAPI.handleWeiboResponse(getIntent(), this);
      return;
    } 
    this.isInstalledWeibo = this.mWeiboShareAPI.isWeiboAppInstalled();
    if (this.isInstalledWeibo) {
      this.title = getIntent().getStringExtra("title");
      this.des = getIntent().getStringExtra("des");
      this.flag = getIntent().getIntExtra("flag", 0);
      this.imgUrl = getIntent().getStringExtra("imgUrl");
      this.linkUrl = getIntent().getStringExtra("linkUrl");
      this.fileUrl = getIntent().getStringExtra("fileUrl");
      if (!TextUtils.isEmpty(this.imgUrl) && this.imgUrl.startsWith("http") && this.flag == 1) {
        downloadImage();
        return;
      } 
      zoomImage();
      return;
    } 
    AppMethods.d(R.string.weibo_uninstall);
    doFinish();
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    this.mWeiboShareAPI.handleWeiboResponse(paramIntent, this);
  }
  
  public void onResponse(BaseResponse paramBaseResponse) {
    if (paramBaseResponse != null) {
      int i = paramBaseResponse.errCode;
      if (i != 0) {
        if (i != 1) {
          if (i != 2)
            return; 
          ShareProvider.getInstance().onFailure(Constants.SinaWeiboNAME);
          return;
        } 
        if (this.isInstalledWeibo) {
          ShareProvider.getInstance().onCancel(Constants.SinaWeiboNAME);
          return;
        } 
      } else {
        ShareProvider.getInstance().onSuccess(Constants.SinaWeiboNAME);
      } 
    } 
  }
  
  protected void onResume() {
    if (this.mIsCompleteTask) {
      ShareProvider.getInstance().onResume(Constants.SinaWeiboNAME);
      doFinish();
    } 
    if (!this.mIsCompleteTask)
      this.mIsCompleteTask = true; 
    super.onResume();
  }
  
  public void sendMessage(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (this.isInstalledWeibo) {
      if (this.mWeiboShareAPI.isWeiboAppSupportAPI()) {
        if (this.mWeiboShareAPI.getWeiboAppSupportAPI() >= 10351) {
          Logger.c("module_share", new Object[] { "send multi msg" });
          sendMultiMessage(paramBoolean1, paramBoolean2, paramBoolean3);
          return;
        } 
        Logger.c("module_share", new Object[] { "send single msg" });
        sendSingleMessage(paramBoolean1, paramBoolean2, paramBoolean3);
        return;
      } 
      finish();
      return;
    } 
    finish();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\sina\SinaShareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */