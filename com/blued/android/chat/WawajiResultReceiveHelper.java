package com.blued.android.chat;

import android.os.Handler;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.chat.WawajiChat;
import com.blued.android.chat.data.ProfileData;

public class WawajiResultReceiveHelper implements WawajiChat.IWawajiResultCallback {
  private static final String TAG = "Chat_WawajiResultReceivet";
  
  private Handler callbackHandler;
  
  private IWawajiResultCallback resultCallback;
  
  private WawajiChat wawajiChat;
  
  public WawajiResultReceiveHelper(IWawajiResultCallback paramIWawajiResultCallback, Handler paramHandler) {
    this.resultCallback = paramIWawajiResultCallback;
    this.callbackHandler = paramHandler;
    if (ChatManager.debug)
      Log.v("Chat_WawajiResultReceivet", "初始化娃娃机结果接收监听"); 
  }
  
  private void notifyCallback(Runnable paramRunnable) {
    Handler handler = this.callbackHandler;
    if (handler != null) {
      handler.post(paramRunnable);
      return;
    } 
    paramRunnable.run();
  }
  
  public void destroy() {
    if (ChatManager.debug)
      Log.v("Chat_WawajiResultReceivet", "销毁娃娃机结果接收监听"); 
    ChatManager.getInstance().unregisterWawajiResultReceiveHelper(this);
    this.wawajiChat = null;
  }
  
  public final void onGameResultReceive(long paramLong, int paramInt, final ProfileData player, final String tipsViewer, String paramString2, final String wawaName) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("接收到娃娃机结果, result:");
      stringBuilder.append(paramInt);
      stringBuilder.append(", wawaName:");
      stringBuilder.append(wawaName);
      stringBuilder.append(", player:");
      stringBuilder.append(player);
      Log.v("Chat_WawajiResultReceivet", stringBuilder.toString());
    } 
    if (paramInt == 1)
      notifyCallback(new Runnable() {
            public void run() {
              WawajiResultReceiveHelper.this.resultCallback.onSuccess(player, tipsViewer, wawaName);
            }
          }); 
  }
  
  public void start() {
    if (ChatManager.debug)
      Log.v("Chat_WawajiResultReceivet", "开始娃娃机结果接收"); 
    this.wawajiChat = ChatManager.getInstance().registerWawajiResultReceiveHelper(this);
    this.wawajiChat.startReceiveAllGameResult();
  }
  
  public void stop() {
    if (ChatManager.debug)
      Log.v("Chat_WawajiResultReceivet", "停止娃娃机结果接收"); 
    WawajiChat wawajiChat = this.wawajiChat;
    if (wawajiChat != null)
      wawajiChat.stopReceiveAllGameResult(); 
    ChatManager.getInstance().unregisterWawajiResultReceiveHelper(this);
    this.wawajiChat = null;
  }
  
  public static interface IWawajiResultCallback {
    void onSuccess(ProfileData param1ProfileData, String param1String1, String param1String2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\WawajiResultReceiveHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */