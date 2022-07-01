package com.blued.android.chat;

import android.content.Context;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.statistics.BluedStatistics;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.service.AutoStartService;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.msg.controller.tools.IMManager;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.ServiceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.tencent.bugly.crashreport.CrashReport;

public class BluedChat {
  private static final String TAG = "BluedChat";
  
  private static BluedChat instance;
  
  private IMTipsListener imTipsListener = new IMTipsListener();
  
  private boolean started = false;
  
  public static BluedChat getInstance() {
    // Byte code:
    //   0: getstatic com/blued/android/chat/BluedChat.instance : Lcom/blued/android/chat/BluedChat;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/chat/BluedChat
    //   8: monitorenter
    //   9: getstatic com/blued/android/chat/BluedChat.instance : Lcom/blued/android/chat/BluedChat;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/chat/BluedChat
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/chat/BluedChat.instance : Lcom/blued/android/chat/BluedChat;
    //   25: ldc com/blued/android/chat/BluedChat
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/chat/BluedChat
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/chat/BluedChat.instance : Lcom/blued/android/chat/BluedChat;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void pauseIMService() {
    ChatManager.getInstance().pause();
    IMManager.a().h();
  }
  
  public void resumeIMService() {
    ChatManager.getInstance().resume();
    IMManager.a().g();
  }
  
  public void startIMService(Context paramContext) {
    startIMService(paramContext, true);
  }
  
  public void startIMService(Context paramContext, boolean paramBoolean) {
    if (!this.started) {
      if (!UserInfo.a().j())
        return; 
      if (!BluedApplicationLike.isMainApplication(paramContext))
        return; 
      if (ServiceUtils.a())
        AutoStartService.a(paramContext); 
      this.started = true;
      CrashReport.setUserId(UserInfo.a().i().getUid());
      BluedStatistics.a().f(UserInfo.a().i().getUid());
      BluedConfig.b().e();
      FlexDebugSevConfig.a().c();
      if (paramBoolean) {
        Logger.c("loginInBackground", new Object[0]);
        UserRelationshipUtils.b();
      } 
      EmotionManager.c();
      ChatManager.getInstance().setServerInfo(BluedHttpUrl.q(), BluedHttpUrl.r(), BluedHttpUrl.s(), HappyDnsUtils.d(), HappyDnsUtils.a(), BluedHttpUrl.h());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("IM=token=ChatManager.getInstance().start==");
      stringBuilder.append(UserInfo.a().d());
      Logger.c("BluedChat", new Object[] { stringBuilder.toString() });
      IMManager.a().e();
      ChatManager.getInstance().start(CommonTools.e(UserInfo.a().i().getUid()), EncryptTool.b(UserInfo.a().i().getUid()), UserInfo.a().d());
      ChatManager.getInstance().registerTipsListener(this.imTipsListener);
      LiveMsgSendManager.a().b();
      LiveMsgSendManager.a().c();
      if (BluedPreferences.da()) {
        LoginRegisterTools.e();
        BluedPreferences.J(false);
      } 
      GroupUtil.a();
    } 
  }
  
  public void stopIMService(Context paramContext) {
    Logger.a("BluedChat", new Object[] { "stopIMService()" });
    this.started = false;
    if (ServiceUtils.a())
      AutoStartService.b(paramContext); 
    ChatManager.getInstance().unregisterTipsListener(this.imTipsListener);
    ChatManager.getInstance().stop();
    IMManager.a().f();
    LiveMsgSendManager.a().d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\BluedChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */