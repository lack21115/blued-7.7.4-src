package com.sina.weibo.sdk.cmd;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.AesEncrypt;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class WbAppActivator {
  private static final String TAG = WbAppActivator.class.getName();
  
  private static WbAppActivator mInstance;
  
  private String mAppkey;
  
  private Context mContext;
  
  private AppInstallCmdExecutor mInstallExecutor;
  
  private AppInvokeCmdExecutor mInvokeExecutor;
  
  private volatile ReentrantLock mLock = new ReentrantLock(true);
  
  private WbAppActivator(Context paramContext, String paramString) {
    this.mContext = paramContext.getApplicationContext();
    this.mInvokeExecutor = new AppInvokeCmdExecutor(this.mContext);
    this.mInstallExecutor = new AppInstallCmdExecutor(this.mContext);
    this.mAppkey = paramString;
  }
  
  public static WbAppActivator getInstance(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/cmd/WbAppActivator
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/cmd/WbAppActivator.mInstance : Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   6: ifnonnull -> 21
    //   9: new com/sina/weibo/sdk/cmd/WbAppActivator
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   18: putstatic com/sina/weibo/sdk/cmd/WbAppActivator.mInstance : Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   21: getstatic com/sina/weibo/sdk/cmd/WbAppActivator.mInstance : Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   24: astore_0
    //   25: ldc com/sina/weibo/sdk/cmd/WbAppActivator
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/sina/weibo/sdk/cmd/WbAppActivator
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  private void handleInstallCmd(List<AppInstallCmd> paramList) {
    if (paramList != null) {
      this.mInstallExecutor.start();
      Iterator<AppInstallCmd> iterator = paramList.iterator();
      while (true) {
        if (!iterator.hasNext()) {
          this.mInstallExecutor.stop();
          return;
        } 
        AppInstallCmd appInstallCmd = iterator.next();
        this.mInstallExecutor.doExecutor(appInstallCmd);
      } 
    } 
  }
  
  private void handleInvokeCmd(List<AppInvokeCmd> paramList) {
    if (paramList != null) {
      Iterator<AppInvokeCmd> iterator = paramList.iterator();
      while (true) {
        if (!iterator.hasNext())
          return; 
        AppInvokeCmd appInvokeCmd = iterator.next();
        this.mInvokeExecutor.doExecutor(appInvokeCmd);
      } 
    } 
  }
  
  private static String requestCmdInfo(Context paramContext, String paramString) {
    String str1 = paramContext.getPackageName();
    String str2 = Utility.getSign(paramContext, str1);
    WeiboParameters weiboParameters = new WeiboParameters(paramString);
    weiboParameters.put("appkey", paramString);
    weiboParameters.put("packagename", str1);
    weiboParameters.put("key_hash", str2);
    weiboParameters.put("version", "0031405000");
    return NetUtils.internalHttpRequest(paramContext, "http://api.weibo.cn/2/client/common_config", "GET", weiboParameters);
  }
  
  public void activateApp() {
    final SharedPreferences sdkSp = FrequencyHelper.getWeiboSdkSp(this.mContext);
    long l1 = FrequencyHelper.getFrequency(this.mContext, sharedPreferences);
    long l2 = FrequencyHelper.getLastTime(this.mContext, sharedPreferences);
    l2 = System.currentTimeMillis() - l2;
    if (l2 < l1) {
      LogUtil.v(TAG, String.format("it's only %d ms from last time get cmd", new Object[] { Long.valueOf(l2) }));
      return;
    } 
    (new Thread(new Runnable() {
          public void run() {
            String str1;
            StringBuilder stringBuilder1;
            String str3;
            String str2 = WbAppActivator.TAG;
            StringBuilder stringBuilder3 = new StringBuilder("mLock.isLocked()--->");
            stringBuilder3.append(WbAppActivator.this.mLock.isLocked());
            LogUtil.v(str2, stringBuilder3.toString());
            if (!WbAppActivator.this.mLock.tryLock())
              return; 
            stringBuilder3 = null;
            StringBuilder stringBuilder5 = null;
            StringBuilder stringBuilder4 = null;
            StringBuilder stringBuilder2 = stringBuilder3;
            try {
              String str = WbAppActivator.requestCmdInfo(WbAppActivator.this.mContext, WbAppActivator.this.mAppkey);
              stringBuilder2 = stringBuilder4;
              if (str != null) {
                stringBuilder2 = stringBuilder3;
                CmdInfo cmdInfo = new CmdInfo(AesEncrypt.Decrypt(str));
                try {
                  WbAppActivator.this.handleInstallCmd(cmdInfo.getInstallCmds());
                  WbAppActivator.this.handleInvokeCmd(cmdInfo.getInvokeCmds());
                  CmdInfo cmdInfo1 = cmdInfo;
                } catch (WeiboException weiboException1) {
                  WeiboException weiboException2 = weiboException1;
                } finally {}
              } 
              WbAppActivator.this.mLock.unlock();
              if (stringBuilder2 != null) {
                WbAppActivator.FrequencyHelper.saveFrequency(WbAppActivator.this.mContext, sdkSp, stringBuilder2.getFrequency());
                WbAppActivator.FrequencyHelper.saveLastTime(WbAppActivator.this.mContext, sdkSp, System.currentTimeMillis());
              } 
            } catch (WeiboException weiboException) {
              stringBuilder3 = stringBuilder5;
              stringBuilder2 = stringBuilder3;
              LogUtil.e(WbAppActivator.TAG, weiboException.getMessage());
              WbAppActivator.this.mLock.unlock();
              if (stringBuilder3 != null) {
                WbAppActivator.FrequencyHelper.saveFrequency(WbAppActivator.this.mContext, sdkSp, stringBuilder3.getFrequency());
                WbAppActivator.FrequencyHelper.saveLastTime(WbAppActivator.this.mContext, sdkSp, System.currentTimeMillis());
              } 
            } finally {
              stringBuilder4 = null;
              str3 = str1;
            } 
            str3.append(WbAppActivator.this.mLock.isLocked());
            LogUtil.v((String)stringBuilder1, str3.toString());
          }
        })).start();
  }
  
  static class FrequencyHelper {
    private static final int DEFAULT_FREQUENCY = 3600000;
    
    private static final String KEY_FREQUENCY = "frequency_get_cmd";
    
    private static final String KEY_LAST_TIME_GET_CMD = "last_time_get_cmd";
    
    private static final String WEIBO_SDK_PREFERENCES_NAME = "com_sina_weibo_sdk";
    
    public static long getFrequency(Context param1Context, SharedPreferences param1SharedPreferences) {
      return (param1SharedPreferences != null) ? param1SharedPreferences.getLong("frequency_get_cmd", 3600000L) : 3600000L;
    }
    
    public static long getLastTime(Context param1Context, SharedPreferences param1SharedPreferences) {
      return (param1SharedPreferences != null) ? param1SharedPreferences.getLong("last_time_get_cmd", 0L) : 0L;
    }
    
    public static SharedPreferences getWeiboSdkSp(Context param1Context) {
      return param1Context.getSharedPreferences("com_sina_weibo_sdk", 0);
    }
    
    public static void saveFrequency(Context param1Context, SharedPreferences param1SharedPreferences, long param1Long) {
      if (param1SharedPreferences != null && param1Long > 0L) {
        SharedPreferences.Editor editor = param1SharedPreferences.edit();
        editor.putLong("frequency_get_cmd", param1Long);
        editor.commit();
      } 
    }
    
    public static void saveLastTime(Context param1Context, SharedPreferences param1SharedPreferences, long param1Long) {
      if (param1SharedPreferences != null) {
        SharedPreferences.Editor editor = param1SharedPreferences.edit();
        editor.putLong("last_time_get_cmd", param1Long);
        editor.commit();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\cmd\WbAppActivator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */