package com.blued.android.module.im;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.im.biz.AudioChatroom;
import com.blued.android.module.im.biz.Common;
import com.blued.android.module.im.biz.IMConnector;
import com.blued.android.module.im.biz.IMConnectorDebuger;
import com.blued.android.module.im.biz.privatechat.GroupChat;
import com.blued.android.module.im.biz.privatechat.OnPrivateChatResponseListener;
import com.blued.android.module.im.biz.privatechat.PrivateChat;
import com.blued.android.module.im.biz.receipt.DeleteAllSession;
import com.blued.android.module.im.biz.receipt.DeleteSession;
import com.blued.android.module.im.biz.receipt.OnReceiptResponseListener;
import com.blued.android.module.im.biz.receipt.ReceiptGot;
import com.blued.android.module.im.biz.receipt.ReceiptRead;
import com.blued.android.module.im.biz.receipt.ReceiptRetract;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.blued.im.audio_chatroom.AudioChatroomOuterClass;
import com.google.protobuf.Any;
import com.qiniu.android.dns.DnsManager;

public final class IM {
  private static ChannelManager a;
  
  private static IMConnector b;
  
  private static IMThreadManager c = new IMThreadManager(3, 10);
  
  public static void a() {
    IMConnector iMConnector = b;
    if (iMConnector != null)
      iMConnector.e(); 
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Any paramAny, OnPrivateChatResponseListener paramOnPrivateChatResponseListener) {
    ChannelManager channelManager = a;
    if (channelManager != null)
      (new PrivateChat(channelManager, c)).a(paramInt1, paramInt2, paramInt3, paramInt4, paramAny, paramOnPrivateChatResponseListener); 
  }
  
  public static void a(int paramInt, boolean paramBoolean, OnReceiptResponseListener paramOnReceiptResponseListener) {
    ChannelManager channelManager = a;
    if (channelManager != null)
      (new DeleteAllSession(channelManager, c)).a(true, 0, paramInt, 0, 0, paramBoolean, paramOnReceiptResponseListener); 
  }
  
  public static void a(Context paramContext, String paramString, DnsManager paramDnsManager) {
    IMConnector iMConnector = b;
    if (iMConnector != null) {
      iMConnector.f();
      b = null;
    } 
    ChannelManager channelManager = a;
    if (channelManager != null) {
      channelManager.c();
      a = null;
    } 
    a = new ChannelManager(paramContext, paramString, 443, paramDnsManager);
    b = new IMConnector(a);
    b.a("blued-grpc-im");
    b.b(true);
    b.a(true);
    b.a(IMConnectorDebuger.a());
  }
  
  public static void a(OnConnectStateListener paramOnConnectStateListener) {
    IMConnector iMConnector = b;
    if (iMConnector != null)
      iMConnector.a(paramOnConnectStateListener); 
  }
  
  public static void a(AudioChatroomOuterClass.Request.Builder paramBuilder, AudioChatroom.OnAudioChatroomResponseListener paramOnAudioChatroomResponseListener) {
    ChannelManager channelManager = a;
    if (channelManager != null)
      (new AudioChatroom(channelManager, c)).a(paramBuilder, paramOnAudioChatroomResponseListener); 
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
  
  public static void a(boolean paramBoolean) {
    IMConfig.a(paramBoolean);
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, OnReceiptResponseListener paramOnReceiptResponseListener) {
    ChannelManager channelManager = a;
    if (channelManager != null)
      (new ReceiptGot(channelManager, c)).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, false, paramOnReceiptResponseListener); 
  }
  
  public static void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, OnReceiptResponseListener paramOnReceiptResponseListener) {
    ChannelManager channelManager = a;
    if (channelManager != null)
      (new DeleteSession(channelManager, c)).a(paramBoolean1, paramInt1, paramInt2, paramInt3, 0, paramBoolean2, paramOnReceiptResponseListener); 
  }
  
  public static void b() {
    IMConnector iMConnector = b;
    if (iMConnector != null)
      iMConnector.f(); 
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Any paramAny, OnPrivateChatResponseListener paramOnPrivateChatResponseListener) {
    ChannelManager channelManager = a;
    if (channelManager != null)
      (new GroupChat(channelManager, c)).a(paramInt1, paramInt2, paramInt3, paramInt4, paramAny, paramOnPrivateChatResponseListener); 
  }
  
  public static void b(OnConnectStateListener paramOnConnectStateListener) {
    IMConnector iMConnector = b;
    if (iMConnector != null)
      iMConnector.b(paramOnConnectStateListener); 
  }
  
  public static void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, OnReceiptResponseListener paramOnReceiptResponseListener) {
    ChannelManager channelManager = a;
    if (channelManager != null)
      (new ReceiptRead(channelManager, c)).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, false, paramOnReceiptResponseListener); 
  }
  
  public static Common c() {
    return Common.a();
  }
  
  public static void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, OnReceiptResponseListener paramOnReceiptResponseListener) {
    ChannelManager channelManager = a;
    if (channelManager != null)
      (new ReceiptRetract(channelManager, c)).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, false, paramOnReceiptResponseListener); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\IM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */