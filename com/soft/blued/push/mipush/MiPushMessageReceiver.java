package com.soft.blued.push.mipush;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.soft.blued.push.PushCommonUtils;
import com.soft.blued.push.PushManager;
import com.soft.blued.push.PushMsgModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.net.URLDecoder;
import java.util.List;

public class MiPushMessageReceiver extends PushMessageReceiver {
  public static final String TAG = "MiPushMessageReceiver";
  
  private String mAlias;
  
  private String mCommand;
  
  private String mEndTime;
  
  private String mMessage;
  
  private String mReason;
  
  private String mRegId;
  
  private long mResultCode = -1L;
  
  private String mStartTime;
  
  private String mTopic;
  
  private void updateToken(String paramString) {
    PushManager.a().a(paramString);
  }
  
  public void onCommandResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage) {
    StringBuilder stringBuilder;
    String str3 = paramMiPushCommandMessage.a();
    Logger.b("MiPushMessageReceiver", new Object[] { "onCommandResult:", str3 });
    List<String> list = paramMiPushCommandMessage.b();
    String str2 = null;
    if (list != null && list.size() > 0) {
      String str = list.get(0);
    } else {
      paramContext = null;
    } 
    String str1 = str2;
    if (list != null) {
      str1 = str2;
      if (list.size() > 1)
        str1 = list.get(1); 
    } 
    if ("register".equals(str3)) {
      if (paramMiPushCommandMessage.c() == 0L) {
        this.mRegId = (String)paramContext;
        stringBuilder = new StringBuilder();
        stringBuilder.append("MIPUSH:");
        stringBuilder.append(this.mRegId);
        updateToken(stringBuilder.toString());
        return;
      } 
    } else if ("set-alias".equals(str3)) {
      if (paramMiPushCommandMessage.c() == 0L) {
        this.mAlias = (String)stringBuilder;
        return;
      } 
    } else if ("unset-alias".equals(str3)) {
      if (paramMiPushCommandMessage.c() == 0L) {
        this.mAlias = (String)stringBuilder;
        return;
      } 
    } else if ("subscribe-topic".equals(str3)) {
      if (paramMiPushCommandMessage.c() == 0L) {
        this.mTopic = (String)stringBuilder;
        return;
      } 
    } else if ("unsubscibe-topic".equals(str3)) {
      if (paramMiPushCommandMessage.c() == 0L) {
        this.mTopic = (String)stringBuilder;
        return;
      } 
    } else if ("accept-time".equals(str3) && paramMiPushCommandMessage.c() == 0L) {
      this.mStartTime = (String)stringBuilder;
      this.mEndTime = str1;
      stringBuilder = new StringBuilder();
      stringBuilder.append("onCommandResult: mStartTime:");
      stringBuilder.append(this.mStartTime);
      stringBuilder.append(" | mEndTime:");
      stringBuilder.append(this.mEndTime);
      Logger.b("MiPushMessageReceiver", new Object[] { stringBuilder.toString() });
    } 
  }
  
  public void onNotificationMessageArrived(Context paramContext, MiPushMessage paramMiPushMessage) {
    this.mMessage = paramMiPushMessage.c();
    Logger.b("MiPushMessageReceiver", new Object[] { "onNotificationMessageArrived:", this.mMessage });
    if (!TextUtils.isEmpty(paramMiPushMessage.e())) {
      this.mTopic = paramMiPushMessage.e();
      return;
    } 
    if (!TextUtils.isEmpty(paramMiPushMessage.d()))
      this.mAlias = paramMiPushMessage.d(); 
  }
  
  public void onNotificationMessageClicked(Context paramContext, MiPushMessage paramMiPushMessage) {
    String str;
    this.mMessage = paramMiPushMessage.c();
    Logger.b("MiPushMessageReceiver", new Object[] { "onNotificationMessageClicked:", this.mMessage });
    if (!TextUtils.isEmpty(paramMiPushMessage.e())) {
      this.mTopic = paramMiPushMessage.e();
    } else if (!TextUtils.isEmpty(paramMiPushMessage.d())) {
      this.mAlias = paramMiPushMessage.d();
    } 
    try {
      str = URLDecoder.decode(paramMiPushMessage.c(), "utf-8");
    } catch (Exception exception) {
      str = "";
    } 
    PushMsgModel pushMsgModel = new PushMsgModel();
    if (!TextUtils.isEmpty(str)) {
      PushMsgModel pushMsgModel1;
      try {
        pushMsgModel1 = (PushMsgModel)AppInfo.f().fromJson(str, PushMsgModel.class);
      } catch (Exception exception) {
        exception.printStackTrace();
        pushMsgModel1 = pushMsgModel;
      } 
      if (pushMsgModel1 != null) {
        UserRelationshipUtils.a(Short.valueOf(pushMsgModel1.session_type), pushMsgModel1.session_id);
        PushCommonUtils.a(paramContext, pushMsgModel1);
      } 
    } 
  }
  
  public void onReceivePassThroughMessage(Context paramContext, MiPushMessage paramMiPushMessage) {
    this.mMessage = paramMiPushMessage.c();
    Logger.b("MiPushMessageReceiver", new Object[] { "onReceivePassThroughMessage:", this.mMessage });
    if (!TextUtils.isEmpty(paramMiPushMessage.e())) {
      this.mTopic = paramMiPushMessage.e();
      return;
    } 
    if (!TextUtils.isEmpty(paramMiPushMessage.d()))
      this.mAlias = paramMiPushMessage.d(); 
  }
  
  public void onReceiveRegisterResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage) {
    String str = paramMiPushCommandMessage.a();
    Logger.b("MiPushMessageReceiver", new Object[] { "onReceiveRegisterResult:", str });
    List<String> list = paramMiPushCommandMessage.b();
    if (list != null && list.size() > 0) {
      String str1 = list.get(0);
    } else {
      paramContext = null;
    } 
    if (list != null && list.size() > 1)
      String str1 = list.get(1); 
    if ("register".equals(str) && paramMiPushCommandMessage.c() == 0L) {
      this.mRegId = (String)paramContext;
      BluedPreferences.X(this.mRegId);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("MIPUSH:");
      stringBuilder.append(this.mRegId);
      updateToken(stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\push\mipush\MiPushMessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */