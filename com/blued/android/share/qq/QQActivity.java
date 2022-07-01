package com.blued.android.share.qq;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module_share_china.R;
import com.blued.android.share.Constants;
import com.blued.android.share.ShareProvider;
import com.blued.android.share.Util;
import com.blued.android.share.msg.AbsShareMsg;
import com.blued.android.share.msg.MsgImageText;
import com.soft.blued.utils.UIUtils;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class QQActivity extends Activity {
  private BaseUiListener callbackListener;
  
  private int flag;
  
  private Activity mActivity;
  
  private boolean mIsCompleteTask;
  
  private QQAuth mQQAuth;
  
  private Tencent mTencent;
  
  MsgImageText mt = null;
  
  private int type;
  
  private void doFinish() {
    ShareProvider.getInstance().unregisterCallback();
    finish();
  }
  
  public String getAppId() {
    return TextUtils.equals("a0300a", AppInfo.c) ? "1106192727" : "1101054119";
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.mTencent != null)
      Tencent.onActivityResultData(paramInt1, paramInt2, paramIntent, this.callbackListener); 
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
    String str = getAppId();
    this.mQQAuth = QQAuth.createInstance(str, (Context)this);
    this.mTencent = Tencent.createInstance(str, (Context)this);
    AbsShareMsg absShareMsg = (AbsShareMsg)getIntent().getParcelableExtra("QQEnetry_jrj_show");
    this.type = getIntent().getIntExtra("type", 0);
    this.flag = getIntent().getIntExtra("flag", 0);
    this.mActivity = this;
    this.callbackListener = new BaseUiListener();
    if (Util.isClientAvailable((Context)this, "com.tencent.mobileqq")) {
      shareMsg(absShareMsg);
      return;
    } 
    AppMethods.d(R.string.qq_uninstall);
    doFinish();
  }
  
  protected void onResume() {
    if (this.mIsCompleteTask)
      getWindow().getDecorView().postDelayed(new Runnable() {
            public void run() {
              ShareProvider.getInstance().onResume(Constants.QQNAME);
              QQActivity.this.doFinish();
            }
          },  300L); 
    if (!this.mIsCompleteTask)
      this.mIsCompleteTask = true; 
    super.onResume();
  }
  
  public void shareMsg(AbsShareMsg paramAbsShareMsg) {
    if (paramAbsShareMsg instanceof MsgImageText) {
      byte b;
      this.mt = (MsgImageText)paramAbsShareMsg;
      final Bundle params = new Bundle();
      if (this.type == 0) {
        b = 1;
      } else {
        b = 5;
      } 
      bundle.putInt("req_type", b);
      bundle.putString("title", this.mt.title);
      bundle.putString("summary", this.mt.summary);
      bundle.putString("targetUrl", this.mt.targetUrl);
      bundle.putInt("cflag", 0);
      bundle.putString("appName", this.mt.appName);
      if (this.flag == 0) {
        bundle.putString("imageLocalUrl", this.mt.imageUrl);
        this.mTencent.shareToQQ(this, bundle, this.callbackListener);
        return;
      } 
      if (this.type == 1) {
        final ProgressDialog pDialog = Util.showProgressDialog((Context)this);
        ThreadManager.a().a(new ThreadExecutor("QQActShareMsg") {
              public void execute() {
                // Byte code:
                //   0: aconst_null
                //   1: astore_3
                //   2: aconst_null
                //   3: astore_2
                //   4: aconst_null
                //   5: astore #4
                //   7: aconst_null
                //   8: astore #5
                //   10: aconst_null
                //   11: astore #6
                //   13: new java/net/URL
                //   16: dup
                //   17: aload_0
                //   18: getfield this$0 : Lcom/blued/android/share/qq/QQActivity;
                //   21: getfield mt : Lcom/blued/android/share/msg/MsgImageText;
                //   24: getfield imageUrl : Ljava/lang/String;
                //   27: invokespecial <init> : (Ljava/lang/String;)V
                //   30: invokevirtual openConnection : ()Ljava/net/URLConnection;
                //   33: checkcast java/net/HttpURLConnection
                //   36: astore_1
                //   37: aload #4
                //   39: astore_2
                //   40: aload #5
                //   42: astore_3
                //   43: aload_1
                //   44: sipush #10000
                //   47: invokevirtual setConnectTimeout : (I)V
                //   50: aload #4
                //   52: astore_2
                //   53: aload #5
                //   55: astore_3
                //   56: aload_1
                //   57: sipush #10000
                //   60: invokevirtual setReadTimeout : (I)V
                //   63: aload #4
                //   65: astore_2
                //   66: aload #5
                //   68: astore_3
                //   69: aload_1
                //   70: invokevirtual connect : ()V
                //   73: aload #4
                //   75: astore_2
                //   76: aload #5
                //   78: astore_3
                //   79: aload_1
                //   80: invokevirtual getInputStream : ()Ljava/io/InputStream;
                //   83: astore #6
                //   85: aload #4
                //   87: astore_2
                //   88: aload #5
                //   90: astore_3
                //   91: aload #6
                //   93: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
                //   96: astore #4
                //   98: aload #4
                //   100: astore_2
                //   101: aload #4
                //   103: astore_3
                //   104: aload #6
                //   106: invokevirtual close : ()V
                //   109: aload_1
                //   110: ifnull -> 117
                //   113: aload_1
                //   114: invokevirtual disconnect : ()V
                //   117: aload #4
                //   119: astore_2
                //   120: goto -> 187
                //   123: astore_2
                //   124: goto -> 147
                //   127: aload_3
                //   128: astore_2
                //   129: aload_1
                //   130: astore_3
                //   131: aload_2
                //   132: astore_1
                //   133: goto -> 159
                //   136: aload_1
                //   137: astore_3
                //   138: aload_2
                //   139: astore_1
                //   140: goto -> 178
                //   143: astore_2
                //   144: aload #6
                //   146: astore_1
                //   147: aload_1
                //   148: ifnull -> 155
                //   151: aload_1
                //   152: invokevirtual disconnect : ()V
                //   155: aload_2
                //   156: athrow
                //   157: aconst_null
                //   158: astore_1
                //   159: aload_1
                //   160: astore_2
                //   161: aload_3
                //   162: ifnull -> 187
                //   165: aload_3
                //   166: invokevirtual disconnect : ()V
                //   169: aload_1
                //   170: astore_2
                //   171: goto -> 187
                //   174: aconst_null
                //   175: astore_1
                //   176: aload_2
                //   177: astore_3
                //   178: aload_1
                //   179: astore_2
                //   180: aload_3
                //   181: ifnull -> 187
                //   184: goto -> 165
                //   187: aload_0
                //   188: getfield this$0 : Lcom/blued/android/share/qq/QQActivity;
                //   191: invokestatic a : (Landroid/app/Activity;)Z
                //   194: ifeq -> 213
                //   197: aload_0
                //   198: getfield this$0 : Lcom/blued/android/share/qq/QQActivity;
                //   201: new com/blued/android/share/qq/QQActivity$2$1
                //   204: dup
                //   205: aload_0
                //   206: aload_2
                //   207: invokespecial <init> : (Lcom/blued/android/share/qq/QQActivity$2;Landroid/graphics/Bitmap;)V
                //   210: invokevirtual runOnUiThread : (Ljava/lang/Runnable;)V
                //   213: return
                //   214: astore_1
                //   215: goto -> 174
                //   218: astore_1
                //   219: goto -> 157
                //   222: astore_3
                //   223: goto -> 136
                //   226: astore_2
                //   227: goto -> 127
                // Exception table:
                //   from	to	target	type
                //   13	37	214	java/net/MalformedURLException
                //   13	37	218	java/io/IOException
                //   13	37	143	finally
                //   43	50	222	java/net/MalformedURLException
                //   43	50	226	java/io/IOException
                //   43	50	123	finally
                //   56	63	222	java/net/MalformedURLException
                //   56	63	226	java/io/IOException
                //   56	63	123	finally
                //   69	73	222	java/net/MalformedURLException
                //   69	73	226	java/io/IOException
                //   69	73	123	finally
                //   79	85	222	java/net/MalformedURLException
                //   79	85	226	java/io/IOException
                //   79	85	123	finally
                //   91	98	222	java/net/MalformedURLException
                //   91	98	226	java/io/IOException
                //   91	98	123	finally
                //   104	109	222	java/net/MalformedURLException
                //   104	109	226	java/io/IOException
                //   104	109	123	finally
              }
            });
        return;
      } 
      bundle.putString("imageUrl", this.mt.imageUrl);
      this.mTencent.shareToQQ(this, bundle, this.callbackListener);
    } 
  }
  
  class BaseUiListener implements IUiListener {
    private BaseUiListener() {}
    
    public void onCancel() {
      ShareProvider.getInstance().onCancel(Constants.QQNAME);
    }
    
    public void onComplete(Object param1Object) {
      ShareProvider.getInstance().onSuccess(Constants.QQNAME);
    }
    
    public void onError(UiError param1UiError) {
      ShareProvider.getInstance().onFailure(Constants.QQNAME);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\qq\QQActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */