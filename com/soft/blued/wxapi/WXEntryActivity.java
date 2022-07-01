package com.soft.blued.wxapi;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.FailReason;
import com.blued.android.core.imagecache.ImageLoadingListener;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.view.AutoAttachRecyclingImageView;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module_share_china.R;
import com.blued.android.share.Constants;
import com.blued.android.share.ShareProvider;
import com.blued.android.share.Util;
import com.blued.android.share.msg.AbsShareMsg;
import com.blued.android.share.msg.MsgImage;
import com.blued.android.share.msg.MsgImageText;
import com.blued.android.share.msg.MsgWeixinVideoText;
import com.soft.blued.constant.ShareCoreConstants;
import com.soft.blued.utils.ShareBitmapUtils;
import com.soft.blued.utils.ShareDialogUtils;
import com.soft.blued.utils.UIUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.net.URL;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
  String a;
  
  private IWXAPI b;
  
  private int c;
  
  private boolean d;
  
  private boolean e = false;
  
  private Dialog f;
  
  private float a(Bitmap paramBitmap, int paramInt) {
    float f;
    if (paramBitmap == null || paramBitmap.getHeight() <= paramInt || paramBitmap.getWidth() <= paramInt)
      return 1.0F; 
    if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
      f = paramInt;
      paramInt = paramBitmap.getHeight();
    } else {
      f = paramInt;
      paramInt = paramBitmap.getWidth();
    } 
    return f / paramInt;
  }
  
  private String a(String paramString) {
    if (paramString == null)
      return String.valueOf(System.currentTimeMillis()); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(System.currentTimeMillis());
    return stringBuilder.toString();
  }
  
  private void a() {
    ShareDialogUtils.b(this.f);
    if (this.d) {
      if (!this.e && TextUtils.equals(this.a, "intent_mode_login"))
        WXProvider.a().a(1, null); 
      if (TextUtils.equals(this.a, "intent_mode_share")) {
        String str;
        ShareProvider shareProvider = ShareProvider.getInstance();
        if (this.c == 8) {
          str = Constants.WechatNAME;
        } else {
          str = Constants.WechatMomentsNAME;
        } 
        shareProvider.onResume(str);
      } 
      d();
    } 
  }
  
  private void a(AbsShareMsg paramAbsShareMsg) {
    Bitmap bitmap;
    if (paramAbsShareMsg instanceof MsgImageText) {
      ProgressDialog progressDialog;
      MsgImageText msgImageText = (MsgImageText)paramAbsShareMsg;
      String str = msgImageText.imageUrl;
      if (str != null && str.startsWith("http")) {
        progressDialog = Util.showProgressDialog((Context)this);
        ThreadManager.a().a(new ThreadExecutor(this, "WxEntryShareMsg", str, progressDialog, paramAbsShareMsg) {
              public void execute() {
                // Byte code:
                //   0: aconst_null
                //   1: astore_3
                //   2: aconst_null
                //   3: astore #5
                //   5: aconst_null
                //   6: astore #6
                //   8: aconst_null
                //   9: astore_2
                //   10: new java/net/URL
                //   13: dup
                //   14: aload_0
                //   15: getfield a : Ljava/lang/String;
                //   18: invokespecial <init> : (Ljava/lang/String;)V
                //   21: invokevirtual openConnection : ()Ljava/net/URLConnection;
                //   24: checkcast java/net/HttpURLConnection
                //   27: astore_1
                //   28: aload #5
                //   30: astore_3
                //   31: aload #6
                //   33: astore #4
                //   35: aload_1
                //   36: sipush #10000
                //   39: invokevirtual setConnectTimeout : (I)V
                //   42: aload #5
                //   44: astore_3
                //   45: aload #6
                //   47: astore #4
                //   49: aload_1
                //   50: sipush #10000
                //   53: invokevirtual setReadTimeout : (I)V
                //   56: aload #5
                //   58: astore_3
                //   59: aload #6
                //   61: astore #4
                //   63: aload_1
                //   64: invokevirtual connect : ()V
                //   67: aload #5
                //   69: astore_3
                //   70: aload #6
                //   72: astore #4
                //   74: aload_1
                //   75: invokevirtual getInputStream : ()Ljava/io/InputStream;
                //   78: astore #7
                //   80: aload #5
                //   82: astore_3
                //   83: aload #6
                //   85: astore #4
                //   87: aload #7
                //   89: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
                //   92: astore_2
                //   93: aload_2
                //   94: astore_3
                //   95: aload_2
                //   96: astore #4
                //   98: aload #7
                //   100: invokevirtual close : ()V
                //   103: aload_2
                //   104: astore_3
                //   105: aload_1
                //   106: ifnull -> 174
                //   109: aload_1
                //   110: invokevirtual disconnect : ()V
                //   113: aload_2
                //   114: astore_3
                //   115: goto -> 174
                //   118: astore_2
                //   119: aload_1
                //   120: astore_3
                //   121: goto -> 140
                //   124: aload #4
                //   126: astore_2
                //   127: goto -> 152
                //   130: aload_3
                //   131: astore_2
                //   132: goto -> 165
                //   135: astore_1
                //   136: aconst_null
                //   137: astore_3
                //   138: aload_1
                //   139: astore_2
                //   140: aload_3
                //   141: ifnull -> 148
                //   144: aload_3
                //   145: invokevirtual disconnect : ()V
                //   148: aload_2
                //   149: athrow
                //   150: aconst_null
                //   151: astore_1
                //   152: aload_2
                //   153: astore_3
                //   154: aload_1
                //   155: ifnull -> 174
                //   158: goto -> 109
                //   161: aconst_null
                //   162: astore_1
                //   163: aload_3
                //   164: astore_2
                //   165: aload_2
                //   166: astore_3
                //   167: aload_1
                //   168: ifnull -> 174
                //   171: goto -> 109
                //   174: aload_0
                //   175: getfield d : Lcom/soft/blued/wxapi/WXEntryActivity;
                //   178: invokestatic a : (Landroid/app/Activity;)Z
                //   181: ifeq -> 200
                //   184: aload_0
                //   185: getfield d : Lcom/soft/blued/wxapi/WXEntryActivity;
                //   188: new com/soft/blued/wxapi/WXEntryActivity$2$1
                //   191: dup
                //   192: aload_0
                //   193: aload_3
                //   194: invokespecial <init> : (Lcom/soft/blued/wxapi/WXEntryActivity$2;Landroid/graphics/Bitmap;)V
                //   197: invokevirtual runOnUiThread : (Ljava/lang/Runnable;)V
                //   200: return
                //   201: astore_1
                //   202: goto -> 161
                //   205: astore_1
                //   206: goto -> 150
                //   209: astore_2
                //   210: goto -> 130
                //   213: astore_2
                //   214: goto -> 124
                // Exception table:
                //   from	to	target	type
                //   10	28	201	java/net/MalformedURLException
                //   10	28	205	java/io/IOException
                //   10	28	135	finally
                //   35	42	209	java/net/MalformedURLException
                //   35	42	213	java/io/IOException
                //   35	42	118	finally
                //   49	56	209	java/net/MalformedURLException
                //   49	56	213	java/io/IOException
                //   49	56	118	finally
                //   63	67	209	java/net/MalformedURLException
                //   63	67	213	java/io/IOException
                //   63	67	118	finally
                //   74	80	209	java/net/MalformedURLException
                //   74	80	213	java/io/IOException
                //   74	80	118	finally
                //   87	93	209	java/net/MalformedURLException
                //   87	93	213	java/io/IOException
                //   87	93	118	finally
                //   98	103	209	java/net/MalformedURLException
                //   98	103	213	java/io/IOException
                //   98	103	118	finally
              }
            });
        return;
      } 
      Bitmap bitmap1 = Util.imageZoomToSize(((MsgImageText)progressDialog).imageUrl, 100);
      bitmap = bitmap1;
      if (bitmap1 == null)
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blued_logo_500); 
      ((MsgImageText)progressDialog).image = bitmap;
      a((MsgImageText)progressDialog);
      return;
    } 
    if (bitmap instanceof MsgImage) {
      a((MsgImage)bitmap);
      return;
    } 
    if (bitmap instanceof MsgWeixinVideoText) {
      MsgWeixinVideoText msgWeixinVideoText = (MsgWeixinVideoText)bitmap;
      a(msgWeixinVideoText, msgWeixinVideoText.title, msgWeixinVideoText.summary, msgWeixinVideoText.targetUrl);
    } 
  }
  
  private void a(MsgImage paramMsgImage, Bitmap paramBitmap) {
    byte[] arrayOfByte1;
    boolean bool;
    if (paramMsgImage == null)
      return; 
    if (paramMsgImage.pType == 16) {
      bool = true;
    } else {
      bool = false;
    } 
    WXImageObject wXImageObject = new WXImageObject(paramBitmap);
    WXMediaMessage wXMediaMessage = new WXMediaMessage();
    wXMediaMessage.mediaObject = (WXMediaMessage.IMediaObject)wXImageObject;
    Bitmap bitmap1 = Util.imageZoomToSize(paramBitmap, 20);
    float f = a(bitmap1, 60);
    Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap1, (int)(bitmap1.getWidth() * f), (int)(bitmap1.getHeight() * f), true);
    if (bitmap1 != null && !bitmap1.equals(bitmap2))
      bitmap1.recycle(); 
    byte[] arrayOfByte2 = Util.bmpToByteArray(bitmap2, false);
    Logger.b("xpf", new Object[] { "first image compress bitmap size:", Integer.valueOf(arrayOfByte2.length / 1024) });
    if (arrayOfByte2 != null && arrayOfByte2.length / 1024 >= 20) {
      f = a(bitmap2, 30);
      bitmap1 = Bitmap.createScaledBitmap(bitmap2, (int)(bitmap2.getWidth() * f), (int)(bitmap2.getHeight() * f), true);
      if (!bitmap2.equals(bitmap1))
        bitmap2.recycle(); 
      arrayOfByte1 = Util.bmpToByteArray(bitmap1, true);
      Logger.b("xpf", new Object[] { "second image compress bitmap size:", Integer.valueOf(arrayOfByte1.length / 1024) });
    } else {
      arrayOfByte1 = arrayOfByte2;
      if (bitmap2 != null) {
        bitmap2.recycle();
        arrayOfByte1 = arrayOfByte2;
      } 
    } 
    wXMediaMessage.thumbData = arrayOfByte1;
    SendMessageToWX.Req req = new SendMessageToWX.Req();
    req.transaction = a("img");
    req.message = wXMediaMessage;
    req.scene = bool;
    this.b.sendReq((BaseReq)req);
  }
  
  private void a(ShowMessageFromWX.Req paramReq) {
    WXMediaMessage wXMediaMessage = paramReq.message;
    WXAppExtendObject wXAppExtendObject = (WXAppExtendObject)wXMediaMessage.mediaObject;
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("description: ");
    stringBuffer.append(wXMediaMessage.description);
    stringBuffer.append("\n");
    stringBuffer.append("extInfo: ");
    stringBuffer.append(wXAppExtendObject.extInfo);
    stringBuffer.append("\n");
    stringBuffer.append("filePath: ");
    stringBuffer.append(wXAppExtendObject.filePath);
    d();
  }
  
  private void b() {
    SendAuth.Req req = new SendAuth.Req();
    req.scope = "snsapi_userinfo";
    req.state = "none";
    this.b.sendReq((BaseReq)req);
  }
  
  private void c() {}
  
  private void d() {
    ShareProvider.getInstance().unregisterCallback();
    WXProvider.a().b();
    finish();
  }
  
  public void a(MsgImage paramMsgImage) {
    if (paramMsgImage == null)
      return; 
    if (paramMsgImage.imageUrl.startsWith("http")) {
      AutoAttachRecyclingImageView.a(paramMsgImage.imageUrl, new LoadOptions(), new ImageLoadingListener(this, paramMsgImage) {
            public void a(int param1Int1, int param1Int2) {}
            
            public void a(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions) {}
            
            public void a(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions, Drawable param1Drawable, boolean param1Boolean) {
              Bitmap bitmap = ShareBitmapUtils.a(param1Drawable);
              WXEntryActivity.a(this.b, this.a, bitmap);
            }
            
            public void a(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions, FailReason param1FailReason) {
              AppMethods.d(R.string.common_net_error);
            }
            
            public boolean a() {
              return false;
            }
            
            public void b(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions) {}
          });
      return;
    } 
    a(paramMsgImage, BitmapFactory.decodeFile(paramMsgImage.imageUrl));
  }
  
  public void a(MsgImageText paramMsgImageText) {
    if (paramMsgImageText == null)
      return; 
    ThreadManager.a().a(new ThreadExecutor(this, "shareWebPage", paramMsgImageText) {
          public void execute() {
            boolean bool;
            if (this.a.pType == 16) {
              bool = true;
            } else {
              bool = false;
            } 
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = this.a.targetUrl;
            WXMediaMessage wXMediaMessage = new WXMediaMessage((WXMediaMessage.IMediaObject)wXWebpageObject);
            wXMediaMessage.title = this.a.title;
            wXMediaMessage.description = this.a.summary;
            if (this.a.image != null) {
              byte[] arrayOfByte1;
              Bitmap bitmap1 = Util.imageZoomToSize(this.a.image, 20);
              float f = WXEntryActivity.a(this.b, bitmap1, 60);
              Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap1, (int)(bitmap1.getWidth() * f), (int)(bitmap1.getHeight() * f), true);
              if (!this.a.image.equals(bitmap2))
                this.a.image.recycle(); 
              byte[] arrayOfByte2 = Util.bmpToByteArray(bitmap2, false);
              Logger.b("xpf", new Object[] { "first link compress bitmap size:", Integer.valueOf(arrayOfByte2.length / 1024) });
              if (arrayOfByte2 != null && arrayOfByte2.length / 1024 >= 20) {
                f = WXEntryActivity.a(this.b, bitmap2, 30);
                bitmap1 = Bitmap.createScaledBitmap(bitmap2, (int)(bitmap2.getWidth() * f), (int)(bitmap2.getHeight() * f), true);
                if (!bitmap2.equals(bitmap1))
                  bitmap2.recycle(); 
                arrayOfByte1 = Util.bmpToByteArray(bitmap1, true);
                Logger.b("xpf", new Object[] { "second link compress bitmap size:", Integer.valueOf(arrayOfByte1.length / 1024) });
              } else {
                arrayOfByte1 = arrayOfByte2;
                if (bitmap2 != null) {
                  bitmap2.recycle();
                  arrayOfByte1 = arrayOfByte2;
                } 
              } 
              wXMediaMessage.thumbData = arrayOfByte1;
            } else if (this.a.imageUrl != null) {
              try {
                byte[] arrayOfByte1;
                Bitmap bitmap1 = BitmapFactory.decodeStream((new URL(this.a.imageUrl)).openStream());
                Bitmap bitmap2 = Util.imageZoomToSize(bitmap1, 20);
                float f = WXEntryActivity.a(this.b, bitmap2, 60);
                Bitmap bitmap3 = Bitmap.createScaledBitmap(bitmap2, (int)(bitmap2.getWidth() * f), (int)(bitmap2.getHeight() * f), true);
                if (!bitmap1.equals(bitmap3))
                  bitmap1.recycle(); 
                byte[] arrayOfByte2 = Util.bmpToByteArray(bitmap3, false);
                Logger.b("xpf", new Object[] { "first link url compress bitmap size:", Integer.valueOf(arrayOfByte2.length / 1024) });
                if (arrayOfByte2 != null && arrayOfByte2.length / 1024 >= 20) {
                  f = WXEntryActivity.a(this.b, bitmap3, 30);
                  bitmap1 = Bitmap.createScaledBitmap(bitmap3, (int)(bitmap3.getWidth() * f), (int)(bitmap3.getHeight() * f), true);
                  if (!bitmap3.equals(bitmap1))
                    bitmap3.recycle(); 
                  arrayOfByte1 = Util.bmpToByteArray(bitmap1, true);
                  Logger.b("xpf", new Object[] { "second link url compress bitmap size:", Integer.valueOf(arrayOfByte1.length / 1024) });
                } else {
                  arrayOfByte1 = arrayOfByte2;
                  if (bitmap3 != null) {
                    bitmap3.recycle();
                    arrayOfByte1 = arrayOfByte2;
                  } 
                } 
                wXMediaMessage.thumbData = arrayOfByte1;
              } catch (Exception exception) {
                exception.printStackTrace();
              } 
            } 
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = WXEntryActivity.a(this.b, "webpage");
            req.message = wXMediaMessage;
            req.scene = bool;
            WXEntryActivity.b(this.b).sendReq((BaseReq)req);
          }
        });
  }
  
  public void a(MsgWeixinVideoText paramMsgWeixinVideoText, String paramString1, String paramString2, String paramString3) {
    boolean bool;
    WXVideoObject wXVideoObject = new WXVideoObject();
    wXVideoObject.videoUrl = paramString3;
    if (paramMsgWeixinVideoText.pType == 16) {
      bool = true;
    } else {
      bool = false;
    } 
    WXMediaMessage wXMediaMessage = new WXMediaMessage((WXMediaMessage.IMediaObject)wXVideoObject);
    if (paramMsgWeixinVideoText.image != null) {
      wXMediaMessage.thumbData = Util.bmpToByteArray(paramMsgWeixinVideoText.image, true);
    } else if (paramMsgWeixinVideoText.imageUrl != null) {
      try {
        Bitmap bitmap1 = Util.imageZoomToSize(paramMsgWeixinVideoText.imageUrl, 20);
        Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap1, 60, 60, true);
        if (bitmap1 != null && !bitmap1.equals(bitmap2))
          bitmap1.recycle(); 
        wXMediaMessage.thumbData = Util.bmpToByteArray(bitmap2, true);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    wXMediaMessage.title = paramString1;
    wXMediaMessage.description = paramString2;
    SendMessageToWX.Req req = new SendMessageToWX.Req();
    req.transaction = a("video");
    req.message = wXMediaMessage;
    req.scene = bool;
    this.b.sendReq((BaseReq)req);
  }
  
  public void onBackPressed() {
    d();
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle) {
    if (Build.VERSION.SDK_INT == 26 && UIUtils.a((Context)this)) {
      boolean bool = UIUtils.a(this);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onCreate fixOrientation when Oreo, result = ");
      stringBuilder.append(bool);
      Log.c("WXEntryActivity", stringBuilder.toString());
    } 
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_empty_share);
    this.f = ShareDialogUtils.a((Context)this);
    this.b = WXAPIFactory.createWXAPI((Context)this, ShareCoreConstants.a(), false);
    this.b.registerApp(ShareCoreConstants.a());
    this.b.handleIntent(getIntent(), this);
    this.a = getIntent().getStringExtra("intent_mode");
    AbsShareMsg absShareMsg = (AbsShareMsg)getIntent().getParcelableExtra("WXEnetry_jrj_show");
    if (absShareMsg != null)
      this.c = absShareMsg.pType; 
    if (paramBundle == null) {
      if (this.b.isWXAppInstalled()) {
        if (TextUtils.equals(this.a, "intent_mode_login")) {
          b();
          return;
        } 
        if (TextUtils.equals(this.a, "intent_mode_share")) {
          a(absShareMsg);
          return;
        } 
        d();
        return;
      } 
      AppMethods.d(R.string.we_chat_uninstall);
      d();
      return;
    } 
    this.d = paramBundle.getBoolean("task_running");
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.b.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq) {
    int i = paramBaseReq.getType();
    if (i != 3) {
      if (i != 4)
        return; 
      a((ShowMessageFromWX.Req)paramBaseReq);
      return;
    } 
    c();
  }
  
  public void onResp(BaseResp paramBaseResp) {
    int i = paramBaseResp.errCode;
    if (i != -4) {
      if (i != -2) {
        if (i != 0)
          return; 
        this.e = true;
        if (TextUtils.equals(this.a, "intent_mode_login")) {
          WXLoginBean wXLoginBean = new WXLoginBean();
          SendAuth.Resp resp = (SendAuth.Resp)paramBaseResp;
          wXLoginBean.code = resp.code;
          wXLoginBean.state = resp.state;
          WXProvider.a().a(0, wXLoginBean);
          return;
        } 
        if (TextUtils.equals(this.a, "intent_mode_share")) {
          String str;
          ShareProvider shareProvider = ShareProvider.getInstance();
          if (this.c == 8) {
            str = Constants.WechatNAME;
          } else {
            str = Constants.WechatMomentsNAME;
          } 
          shareProvider.onSuccess(str);
          return;
        } 
      } else {
        this.e = true;
        if (TextUtils.equals(this.a, "intent_mode_login")) {
          WXProvider.a().a(1, null);
          return;
        } 
        if (TextUtils.equals(this.a, "intent_mode_share")) {
          String str;
          ShareProvider shareProvider = ShareProvider.getInstance();
          if (this.c == 8) {
            str = Constants.WechatNAME;
          } else {
            str = Constants.WechatMomentsNAME;
          } 
          shareProvider.onCancel(str);
          return;
        } 
      } 
    } else {
      this.e = true;
      if (TextUtils.equals(this.a, "intent_mode_login")) {
        WXProvider.a().a(-1, null);
        return;
      } 
      if (TextUtils.equals(this.a, "intent_mode_share")) {
        String str;
        ShareProvider shareProvider = ShareProvider.getInstance();
        if (this.c == 8) {
          str = Constants.WechatNAME;
        } else {
          str = Constants.WechatMomentsNAME;
        } 
        shareProvider.onFailure(str);
      } 
    } 
  }
  
  protected void onResume() {
    super.onResume();
    if (!this.d) {
      this.d = true;
      return;
    } 
    if (!this.e && TextUtils.equals(this.a, "intent_mode_login")) {
      ShareDialogUtils.a(this.f);
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              if (UiUtils.a(this.a))
                WXEntryActivity.a(this.a); 
            }
          },  3000L);
      return;
    } 
    a();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("task_running", this.d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\wxapi\WXEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */