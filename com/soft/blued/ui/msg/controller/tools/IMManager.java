package com.soft.blued.ui.msg.controller.tools;

import com.blued.android.chat.ChatDBImpl;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.grpc.ClientType;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.info.ChatAppInfo;
import com.blued.android.chat.grpc.info.ChatConnectInfo;
import com.blued.android.chat.grpc.info.ChatUserInfo;
import com.blued.android.chat.grpc.listener.ConnectListener;
import com.blued.android.chat.grpc.listener.ReceiveMsgListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.im.IM;
import com.blued.android.module.yy_china.manager.YYIMManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.im.audio_chatroom.AudioChatroomOuterClass;
import com.google.protobuf.Any;
import com.soft.blued.http.Host;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;

public class IMManager implements ConnectListener, ReceiveMsgListener {
  private static final String a = IMManager.class.getSimpleName();
  
  private IMManager() {}
  
  public static IMManager a() {
    return SingletonCreator.a;
  }
  
  public void a(ChattingModel paramChattingModel) {
    PrivateChatManager.getInstance().sendMsg(paramChattingModel);
  }
  
  public void b() {
    Logger.c(a, new Object[] { "initIM ======" });
    ChatAppInfo chatAppInfo = new ChatAppInfo();
    chatAppInfo.platform = "android_china";
    chatAppInfo.appVersionName = AppInfo.g;
    chatAppInfo.appVersionCode = AppInfo.h;
    chatAppInfo.channel = AppInfo.c;
    chatAppInfo.clientType = ClientType.CHINA;
    chatAppInfo.language = LocaleUtils.b();
    chatAppInfo.context = AppInfo.d();
    ChatConnectInfo chatConnectInfo = new ChatConnectInfo();
    chatConnectInfo.dnsManager = HappyDnsUtils.d();
    chatConnectInfo.host = Host.a("GRPC_CHAT");
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("host ====== ");
    stringBuilder.append(chatConnectInfo.host);
    Logger.c(str, new Object[] { stringBuilder.toString() });
    PrivateChatManager.getInstance().init(chatAppInfo, chatConnectInfo, (DBOper)new ChatDBImpl(), false);
    PrivateChatManager.getInstance().registerConnectListener(this);
    PrivateChatManager.getInstance().registerExternalMsgListener(this);
  }
  
  public boolean b(ChattingModel paramChattingModel) {
    short s = paramChattingModel.msgType;
    return (s != 32 && s != 210) ? ((paramChattingModel.sessionType == 3) ? true : FlexDebugSevConfig.a().d()) : true;
  }
  
  public void c() {
    IM.c().d(LocaleUtils.b());
  }
  
  public void d() {
    IM.c().a(AppInfo.c);
  }
  
  public void e() {
    if (!PrivateChatManager.getInstance().isInit())
      b(); 
    ChatUserInfo chatUserInfo = new ChatUserInfo();
    chatUserInfo.token = LoginRegisterTools.g(UserInfo.a().d());
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startIM ====token==");
    stringBuilder.append(chatUserInfo.token);
    Logger.c(str, new Object[] { stringBuilder.toString() });
    chatUserInfo.uid = (UserInfo.a().i()).uid;
    PrivateChatManager.getInstance().start(chatUserInfo);
  }
  
  public void f() {
    PrivateChatManager.getInstance().stop();
    PrivateChatManager.getInstance().unregisterConnectListener(this);
    PrivateChatManager.getInstance().unregisterExternalMsgListener(this);
  }
  
  public void g() {
    PrivateChatManager.getInstance().resume();
  }
  
  public void h() {
    PrivateChatManager.getInstance().pause();
  }
  
  public void onConnected() {
    if (YYRoomInfoManager.d().b() != null)
      YYIMManager.a().onConnected(); 
    Logger.c(a, new Object[] { "grpc-链接成功，sync_msg" });
    ChatManager.getInstance().syncMsg();
  }
  
  public void onConnecting() {}
  
  public void onDisconnected(int paramInt, String paramString) {
    if (YYRoomInfoManager.d().b() != null)
      YYIMManager.a().onDisconnected(); 
  }
  
  public void onReceiveMsg(Any paramAny) {
    if (paramAny != null)
      try {
        if (paramAny.is(AudioChatroomOuterClass.Receive.class)) {
          Logger.e("onMessage", new Object[] { "IMManager AudioChatroomOuterClass Receive ..." });
          YYIMManager.a().onReceive(paramAny);
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  static class SingletonCreator {
    public static final IMManager a = new IMManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\controller\tools\IMManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */