package com.huawei.hms.support.api.push.pushselfshow.click;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.push.pushselfshow.entity.PushSelfShowMessage;
import com.huawei.hms.support.api.push.pushselfshow.utils.CommFun;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;

public class SelfShowType {
  public static final String PUSH_CMD_APP = "app";
  
  public static final String PUSH_CMD_COSA = "cosa";
  
  public static final String PUSH_CMD_RP = "rp";
  
  public static final String PUSH_CMD_URL = "url";
  
  public static final String[] SUPPORT_TYPE = new String[] { "url", "app", "cosa", "rp" };
  
  public static final String TAG = "PushSelfShowLog";
  
  public Context context;
  
  public PushSelfShowMessage message;
  
  public SelfShowType(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage) {
    this.context = paramContext;
    this.message = paramPushSelfShowMessage;
  }
  
  private String delelteReferrer(String paramString) {
    int i;
    try {
      int j = paramString.indexOf('?');
      if (j == -1)
        return paramString; 
      int k = j + 1;
      String[] arrayOfString = paramString.substring(k).split("&");
      ArrayList<String> arrayList = new ArrayList();
      int m = arrayOfString.length;
      for (i = 0;; i++) {
        if (i < m) {
          String str = arrayOfString[i];
          boolean bool = str.startsWith("h_w_hiapp_referrer");
          if (!bool && !str.startsWith("h_w_gp_referrer"))
            arrayList.add(str); 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          m = arrayList.size();
          for (i = 0;; i++) {
            if (i < m) {
              stringBuilder.append(arrayList.get(i));
              if (i < arrayList.size() - 1)
                stringBuilder.append("&"); 
            } else {
              String str;
              if (arrayList.size() == 0) {
                str = paramString.substring(0, j);
              } else {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(paramString.substring(0, k));
                stringBuilder1.append(stringBuilder.toString());
                str = stringBuilder1.toString();
              } 
              stringBuilder = new StringBuilder();
              stringBuilder.append("after delete referrer, the new IntentUri is:");
              stringBuilder.append(str);
              HMSLog.d("PushSelfShowLog", stringBuilder.toString());
              return str;
            } 
          } 
        } 
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("delete referrer exception");
      stringBuilder.append(exception.toString());
      HMSLog.e("PushSelfShowLog", stringBuilder.toString());
      return paramString;
    } 
    i++;
    continue;
  }
  
  private void launchApp() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("enter launchApp, appPackageName =");
      stringBuilder.append(this.message.getAppPackageName());
      stringBuilder.append(",and msg.intentUri is ");
      stringBuilder.append(this.message.getIntentUri());
      HMSLog.i("PushSelfShowLog", stringBuilder.toString());
      if (CommFun.isInstalled(this.context, this.message.getAppPackageName())) {
        launchCosaApp();
        return;
      } 
      openAppDetail();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("launchApp error:");
      stringBuilder.append(exception.toString());
      HMSLog.e("PushSelfShowLog", stringBuilder.toString());
      return;
    } 
  }
  
  private void launchCosaApp() {
    HMSLog.i("PushSelfShowLog", "run into launchCosaApp ");
    try {
      Intent intent1;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("enter launchExistApp cosa, appPackageName =");
      stringBuilder1.append(this.message.getAppPackageName());
      stringBuilder1.append(",and msg.intentUri is ");
      stringBuilder1.append(this.message.getIntentUri());
      HMSLog.i("PushSelfShowLog", stringBuilder1.toString());
      Intent intent2 = CommFun.hasActivity(this.context, this.message.getAppPackageName());
      String str = this.message.getIntentUri();
      boolean bool1 = false;
      if (str != null) {
        try {
          Intent intent = Intent.parseUri(this.message.getIntentUri(), 0);
          intent.setSelector(null);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Intent.parseUri(msg.intentUri, 0),");
          stringBuilder.append(intent.getAction());
          HMSLog.i("PushSelfShowLog", stringBuilder.toString());
          boolean bool = CommFun.findActivityByIntent(this.context, this.message.getAppPackageName(), intent).booleanValue();
          intent1 = intent2;
          bool1 = bool;
          if (bool) {
            intent1 = intent;
            bool1 = bool;
          } 
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("intentUri error");
          stringBuilder.append(exception.toString());
          HMSLog.w("PushSelfShowLog", stringBuilder.toString());
          intent1 = intent2;
        } 
      } else {
        intent1 = intent2;
        if (this.message.getAcn() != null) {
          Intent intent = new Intent(this.message.getAcn());
          intent1 = intent2;
          if (CommFun.findActivityByIntent(this.context, this.message.getAppPackageName(), intent).booleanValue())
            intent1 = intent; 
        } 
        intent1.setPackage(this.message.getAppPackageName());
      } 
      if (intent1 == null) {
        HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
        return;
      } 
      boolean bool2 = CommFun.hasPermissionToStartActivity(this.context, intent1);
      if (!bool2) {
        HMSLog.w("PushSelfShowLog", "no permission to start Activity");
        return;
      } 
      if (bool1) {
        intent1.addFlags(268435456);
      } else {
        intent1.setFlags(805437440);
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("start ");
      stringBuilder2.append(intent1.toURI());
      HMSLog.i("PushSelfShowLog", stringBuilder2.toString());
      this.context.startActivity(intent1);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("launch Cosa App exception");
      stringBuilder.append(exception.toString());
      HMSLog.e("PushSelfShowLog", stringBuilder.toString());
      return;
    } 
  }
  
  private void openAppDetail() {
    try {
      StringBuilder stringBuilder1;
      StringBuilder stringBuilder2 = new StringBuilder();
      boolean bool = TextUtils.isEmpty(this.message.getIntentUri());
      if (!bool) {
        stringBuilder2.append("&referrer=");
        stringBuilder2.append(Uri.encode(delelteReferrer(this.message.getIntentUri())));
      } 
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("market://details?id=");
      stringBuilder3.append(this.message.getAppPackageName());
      stringBuilder3.append(stringBuilder2);
      String str = stringBuilder3.toString();
      Intent intent1 = new Intent("android.intent.action.VIEW");
      intent1.setData(Uri.parse(str));
      intent1.setPackage("com.huawei.appmarket");
      Intent intent2 = new Intent("android.intent.action.VIEW");
      intent2.setData(Uri.parse(str));
      intent2.setPackage("com.android.vending");
      if (CommFun.findActivityByIntent(this.context, "com.android.vending", intent2).booleanValue()) {
        intent2.setFlags(402653184);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("open google play store's app detail, IntentUrl is:");
        stringBuilder1.append(intent2.toURI());
        HMSLog.i("PushSelfShowLog", stringBuilder1.toString());
        this.context.startActivity(intent2);
        return;
      } 
      if (CommFun.findActivityByIntent(this.context, "com.huawei.appmarket", (Intent)stringBuilder1).booleanValue()) {
        stringBuilder1.setFlags(402653184);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("open HiApp's app detail, IntentUrl is:");
        stringBuilder.append(stringBuilder1.toURI());
        HMSLog.i("PushSelfShowLog", stringBuilder.toString());
        this.context.startActivity((Intent)stringBuilder1);
        return;
      } 
      HMSLog.i("PushSelfShowLog", "open app detail by browser.");
      openBrowserDetail();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("open market app detail failed,exception:");
      stringBuilder.append(exception);
      HMSLog.e("PushSelfShowLog", stringBuilder.toString());
      return;
    } 
  }
  
  private void openBrowserDetail() {
    String str2 = "";
    try {
      Uri uri = Uri.parse(Uri.decode(this.message.getIntentUri()));
      try {
        String str = uri.getQueryParameter("h_w_hiapp_referrer");
      } catch (Exception exception1) {
        HMSLog.i("PushSelfShowLog", "parse h_w_hiapp_referrer faied");
        String str = "";
      } 
      try {
        String str = uri.getQueryParameter("h_w_gp_referrer");
      } catch (Exception null) {
        try {
          HMSLog.i("PushSelfShowLog", "parse h_w_hiapp_referrer faied");
          String str = str2;
        } catch (Exception exception1) {}
      } 
    } catch (Exception exception) {
      String str = "";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("parse intentUri error");
    stringBuilder.append(exception.toString());
    HMSLog.w("PushSelfShowLog", stringBuilder.toString());
    String str1 = str2;
  }
  
  public static boolean supportCmd(String paramString) {
    String[] arrayOfString = SUPPORT_TYPE;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].equals(paramString))
        return true; 
    } 
    return false;
  }
  
  public void launchNotify() {
    HMSLog.d("PushSelfShowLog", "enter launchNotify()");
    if (this.context != null) {
      PushSelfShowMessage pushSelfShowMessage = this.message;
      if (pushSelfShowMessage != null) {
        if ("app".equals(pushSelfShowMessage.getCmd())) {
          launchApp();
          return;
        } 
        if ("cosa".equals(this.message.getCmd())) {
          launchCosaApp();
          return;
        } 
        if ("rp".equals(this.message.getCmd())) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.message.getCmd());
          stringBuilder1.append(" not support rich message.");
          HMSLog.w("PushSelfShowLog", stringBuilder1.toString());
          return;
        } 
        if ("url".equals(this.message.getCmd())) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.message.getCmd());
          stringBuilder1.append(" not support URL.");
          HMSLog.w("PushSelfShowLog", stringBuilder1.toString());
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.message.getCmd());
        stringBuilder.append(" is not exist in hShowType");
        HMSLog.d("PushSelfShowLog", stringBuilder.toString());
        return;
      } 
    } 
    HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfshow\click\SelfShowType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */