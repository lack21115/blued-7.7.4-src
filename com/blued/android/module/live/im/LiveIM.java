package com.blued.android.module.live.im;

import android.content.Context;
import android.text.TextUtils;
import cn.irisgw.live.LiveChatOuterClass;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.blued.android.module.live.im.biz.LiveChat;
import com.blued.android.module.live.im.biz.LiveConnector;
import com.qiniu.android.dns.DnsManager;

public class LiveIM {
  private static ChannelManager a;
  
  private static LiveConnector b;
  
  private static LiveChat c;
  
  private static IMThreadManager d = new IMThreadManager(3, 10);
  
  public static void a(Context paramContext, String paramString, DnsManager paramDnsManager) {
    LiveConnector liveConnector = b;
    if (liveConnector != null) {
      liveConnector.f();
      b = null;
    } 
    ChannelManager channelManager = a;
    if (channelManager != null) {
      channelManager.c();
      a = null;
    } 
    a = new ChannelManager(paramContext, paramString, 443, paramDnsManager);
    b = new LiveConnector(a);
    b.a("blued-grpc-live-im");
    b.a(false);
    b.b(false);
    c = null;
  }
  
  public static void a(LiveChatOuterClass.LiveLikeRequest paramLiveLikeRequest, OnSendLikeFinishListener paramOnSendLikeFinishListener) {
    d();
    LiveChat liveChat = c;
    if (liveChat != null)
      liveChat.a(paramLiveLikeRequest, paramOnSendLikeFinishListener); 
  }
  
  public static void a(LiveChatOuterClass.LiveMsgRequest paramLiveMsgRequest, OnSendMessageFinishListener paramOnSendMessageFinishListener) {
    d();
    LiveChat liveChat = c;
    if (liveChat != null)
      liveChat.a(paramLiveMsgRequest, paramOnSendMessageFinishListener); 
  }
  
  public static void a(OnConnectStateListener paramOnConnectStateListener) {
    LiveConnector liveConnector = b;
    if (liveConnector != null)
      liveConnector.a(paramOnConnectStateListener); 
  }
  
  public static void a(String paramString) {
    ChannelManager channelManager = a;
    if (channelManager != null) {
      if (TextUtils.isEmpty(paramString)) {
        paramString = "";
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bearer ");
        stringBuilder.append(paramString);
        paramString = stringBuilder.toString();
      } 
      channelManager.a("Authorization", paramString);
    } 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    LiveConnector liveConnector = b;
    if (liveConnector != null)
      liveConnector.a(paramString1, paramString2, paramString3, paramString4); 
  }
  
  public static void a(boolean paramBoolean) {
    LiveIMConfig.a(paramBoolean);
  }
  
  public static boolean a() {
    return (a != null);
  }
  
  public static void b() {
    LiveConnector liveConnector = b;
    if (liveConnector != null)
      liveConnector.e(); 
  }
  
  public static void b(OnConnectStateListener paramOnConnectStateListener) {
    LiveConnector liveConnector = b;
    if (liveConnector != null)
      liveConnector.b(paramOnConnectStateListener); 
  }
  
  public static void c() {
    LiveConnector liveConnector = b;
    if (liveConnector != null)
      liveConnector.f(); 
  }
  
  private static void d() {
    ChannelManager channelManager = a;
    if (channelManager != null && c == null)
      c = new LiveChat(channelManager, d); 
  }
  
  public static interface OnSendLikeFinishListener {
    void onFinish(LiveChatOuterClass.LiveLikeResponse param1LiveLikeResponse);
  }
  
  public static interface OnSendMessageFinishListener {
    void onFinish(LiveChatOuterClass.LiveMsgResponse param1LiveMsgResponse);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\im\LiveIM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */