package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.hms.HiAnalyticsConf;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.stats.a;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class HMSBIInitializer {
  private static final String ADDRESS_GROUP = "ROOT";
  
  private static final String INNER_SERVICE_HA_ISSUE = "com.huawei.cloud.opensdkhianalytics";
  
  private static final Object LOCK_OBJECT = new Object();
  
  private static final String META_BI_SETTING = "com.huawei.hms.client.bi.setting";
  
  private static final String SERVICES_PACKAGE = "com.huawei.hwid";
  
  private static final String TAG = "HMSBIInitializer";
  
  private static HMSBIInitializer instance;
  
  private HiAnalyticsConf.Builder builder;
  
  private final Context context;
  
  private AtomicBoolean inInit = new AtomicBoolean(false);
  
  private HMSBIInitializer(Context paramContext) {
    this.context = paramContext;
    this.builder = new HiAnalyticsConf.Builder(this.context);
  }
  
  private void doInitBI(String paramString) {
    HMSLog.i("HMSBIInitializer", "Start to query GRS");
    GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
    grsBaseInfo.setIssueCountry(paramString);
    (new GrsClient(this.context, grsBaseInfo)).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOT", new IQueryUrlCallBack() {
          public void onCallBackFail(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get grs failed, the errorcode is ");
            stringBuilder.append(param1Int);
            HMSLog.e("HMSBIInitializer", stringBuilder.toString());
            HMSBIInitializer.this.inInit.set(false);
          }
          
          public void onCallBackSuccess(String param1String) {
            if (!TextUtils.isEmpty(param1String)) {
              HMSBIInitializer.this.builder.setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(0, param1String).setCollectURL(1, param1String).setAppID("com.huawei.hwid").create();
              HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
            } 
            HMSBIInitializer.this.inInit.set(false);
          }
        });
  }
  
  public static HMSBIInitializer getInstance(Context paramContext) {
    synchronized (LOCK_OBJECT) {
      if (instance == null) {
        Context context = paramContext.getApplicationContext();
        if (context != null) {
          instance = new HMSBIInitializer(context);
        } else {
          instance = new HMSBIInitializer(paramContext);
        } 
      } 
      return instance;
    } 
  }
  
  public void initBI() {
    boolean bool = a.b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Builder->biInitFlag :");
    stringBuilder.append(bool);
    HMSLog.i("HMSBIInitializer", stringBuilder.toString());
    if (bool)
      return; 
    if (AnalyticsSwitchHolder.isAnalyticsDisabled(this.context))
      return; 
    if (this.inInit.compareAndSet(false, true)) {
      String str2 = GrsApp.getInstance().getIssueCountryCode(this.context);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
        str1 = str2.toUpperCase(Locale.ENGLISH); 
      if ("UNKNOWN".equalsIgnoreCase(str1) || TextUtils.isEmpty(str1)) {
        HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
        this.inInit.set(false);
        return;
      } 
      (new GRSTask()).execute((Object[])new String[] { str1 });
      return;
    } 
  }
  
  public boolean isInit() {
    return a.b();
  }
  
  class GRSTask extends AsyncTask<String, Integer, Void> {
    private GRSTask() {}
    
    protected Void doInBackground(String... param1VarArgs) {
      HMSBIInitializer.this.doInitBI(param1VarArgs[0]);
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\HMSBIInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */