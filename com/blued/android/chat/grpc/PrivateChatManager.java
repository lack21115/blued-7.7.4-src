package com.blued.android.chat.grpc;

import android.content.Context;
import android.os.SystemClock;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.grpc.core.chat.a;
import com.blued.android.chat.grpc.core.link.a;
import com.blued.android.chat.grpc.info.ChatAppInfo;
import com.blued.android.chat.grpc.info.ChatConnectInfo;
import com.blued.android.chat.grpc.info.ChatUserInfo;
import com.blued.android.chat.grpc.listener.ChatTipsListener;
import com.blued.android.chat.grpc.listener.ConnectListener;
import com.blued.android.chat.grpc.listener.ReceiveMsgListener;
import com.blued.android.chat.grpc.utils.ChatLog;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.module.im.IM;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrivateChatManager {
  public static final String TAG = "PrivateChatManager";
  
  private static volatile PrivateChatManager instance;
  
  private ChatAppInfo appInfo;
  
  private a chat = new a(this.connector);
  
  private a connector = new a();
  
  private final ExecutorService executor = Executors.newSingleThreadExecutor();
  
  private Gson gson = new Gson();
  
  private boolean isDebug = true;
  
  private ChatUserInfo userInfo;
  
  private File getDebugLogFile(Context paramContext) {
    File file = new File(paramContext.getFilesDir(), "blued_debug_log");
    if (!file.exists())
      file.mkdirs(); 
    file = new File(file, "blued_chat_grpc.txt");
    if (file.exists() && file.length() > 1024000L && !file.delete()) {
      ChatLog.e(TAG, "文件大小超过限制, 但删除失败");
      return null;
    } 
    try {
      file.createNewFile();
      return file;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return null;
    } 
  }
  
  public static PrivateChatManager getInstance() {
    // Byte code:
    //   0: getstatic com/blued/android/chat/grpc/PrivateChatManager.instance : Lcom/blued/android/chat/grpc/PrivateChatManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/chat/grpc/PrivateChatManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/chat/grpc/PrivateChatManager.instance : Lcom/blued/android/chat/grpc/PrivateChatManager;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/chat/grpc/PrivateChatManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/chat/grpc/PrivateChatManager.instance : Lcom/blued/android/chat/grpc/PrivateChatManager;
    //   25: ldc com/blued/android/chat/grpc/PrivateChatManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/chat/grpc/PrivateChatManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/chat/grpc/PrivateChatManager.instance : Lcom/blued/android/chat/grpc/PrivateChatManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public ChatAppInfo getChatAppInfo() {
    ChatAppInfo chatAppInfo2 = this.appInfo;
    ChatAppInfo chatAppInfo1 = chatAppInfo2;
    if (chatAppInfo2 == null)
      chatAppInfo1 = new ChatAppInfo(); 
    return chatAppInfo1;
  }
  
  public Gson getGson() {
    return this.gson;
  }
  
  public ChatUserInfo getUserInfo() {
    ChatUserInfo chatUserInfo2 = this.userInfo;
    ChatUserInfo chatUserInfo1 = chatUserInfo2;
    if (chatUserInfo2 == null)
      chatUserInfo1 = new ChatUserInfo(); 
    return chatUserInfo1;
  }
  
  public void init(ChatAppInfo paramChatAppInfo, ChatConnectInfo paramChatConnectInfo, DBOper paramDBOper, boolean paramBoolean) {
    this.isDebug = paramBoolean;
    this.appInfo = paramChatAppInfo;
    IM.a(paramBoolean);
    this.connector.a(paramChatConnectInfo);
    a a1 = this.chat;
    DBOper dBOper = paramDBOper;
    if (paramDBOper == null)
      dBOper = DBOper.EmptyDBOper; 
    a1.a(dBOper);
    if (paramBoolean)
      try {
        return;
      } finally {
        paramChatAppInfo = null;
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatLog init error :");
        stringBuilder.append(paramChatAppInfo);
        ChatLog.e(str, stringBuilder.toString());
      }  
    ChatLog.init(paramChatAppInfo.context, false, null);
  }
  
  public boolean isDebug() {
    return this.isDebug;
  }
  
  public boolean isInit() {
    return (this.appInfo != null);
  }
  
  public void pause() {
    ChatLog.d(TAG, "pause()");
    this.executor.execute(new Runnable() {
          public void run() {
            ChatLog.d(PrivateChatManager.TAG, "pause() running");
            long l = SystemClock.uptimeMillis();
            if (PrivateChatManager.this.connector != null)
              PrivateChatManager.this.connector.f(); 
            String str = PrivateChatManager.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pause() takes ");
            stringBuilder.append(SystemClock.uptimeMillis() - l);
            ChatLog.d(str, stringBuilder.toString());
          }
        });
  }
  
  public void registerChatTipsListener(final ChatTipsListener listener) {
    ChatLog.d(TAG, "ChatTipsListener");
    this.executor.execute(new Runnable() {
          public void run() {
            if (PrivateChatManager.this.chat != null)
              PrivateChatManager.this.chat.a(listener); 
          }
        });
  }
  
  public void registerConnectListener(final ConnectListener listener) {
    ChatLog.d(TAG, "registerConnectListener");
    this.executor.execute(new Runnable() {
          public void run() {
            if (PrivateChatManager.this.connector != null)
              PrivateChatManager.this.connector.a(listener); 
          }
        });
  }
  
  public void registerExternalMsgListener(final ReceiveMsgListener listener) {
    ChatLog.d(TAG, "registerExternalMsgListener");
    this.executor.execute(new Runnable() {
          public void run() {
            if (PrivateChatManager.this.connector != null)
              PrivateChatManager.this.connector.a(listener); 
          }
        });
  }
  
  public void resume() {
    ChatLog.d(TAG, "resume()");
    this.executor.execute(new Runnable() {
          public void run() {
            ChatLog.d(PrivateChatManager.TAG, "resume() running");
            long l = SystemClock.uptimeMillis();
            if (PrivateChatManager.this.connector != null)
              PrivateChatManager.this.connector.g(); 
            String str = PrivateChatManager.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("resume() takes ");
            stringBuilder.append(SystemClock.uptimeMillis() - l);
            ChatLog.d(str, stringBuilder.toString());
          }
        });
  }
  
  public void sendMsg(final ChattingModel msg) {
    this.executor.execute(new Runnable() {
          public void run() {
            long l = SystemClock.uptimeMillis();
            if (PrivateChatManager.this.chat != null)
              PrivateChatManager.this.chat.a(msg); 
            String str = PrivateChatManager.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sendMsg() takes ");
            stringBuilder.append(SystemClock.uptimeMillis() - l);
            ChatLog.v(str, stringBuilder.toString());
          }
        });
  }
  
  public void start(ChatUserInfo paramChatUserInfo) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start---");
    stringBuilder.append(paramChatUserInfo.token);
    ChatLog.d(str, stringBuilder.toString());
    this.userInfo = paramChatUserInfo;
    this.executor.execute(new Runnable() {
          public void run() {
            long l = SystemClock.uptimeMillis();
            if (PrivateChatManager.this.chat != null)
              PrivateChatManager.this.chat.h(); 
            if (PrivateChatManager.this.connector != null)
              PrivateChatManager.this.connector.h(); 
            String str = PrivateChatManager.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("start() takes ");
            stringBuilder.append(SystemClock.uptimeMillis() - l);
            ChatLog.v(str, stringBuilder.toString());
          }
        });
  }
  
  public void stop() {
    this.appInfo = null;
    ChatLog.d(TAG, "stop-----");
    this.executor.execute(new Runnable() {
          public void run() {
            long l = SystemClock.uptimeMillis();
            if (PrivateChatManager.this.chat != null)
              PrivateChatManager.this.chat.i(); 
            if (PrivateChatManager.this.connector != null)
              PrivateChatManager.this.connector.i(); 
            String str = PrivateChatManager.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("stop() takes ");
            stringBuilder.append(SystemClock.uptimeMillis() - l);
            ChatLog.v(str, stringBuilder.toString());
          }
        });
  }
  
  public void unregisterConnectListener(final ConnectListener listener) {
    ChatLog.d(TAG, "unregisterConnectListener");
    this.executor.execute(new Runnable() {
          public void run() {
            if (PrivateChatManager.this.connector != null)
              PrivateChatManager.this.connector.b(listener); 
          }
        });
  }
  
  public void unregisterExternalMsgListener(final ReceiveMsgListener listener) {
    ChatLog.d(TAG, "unregisterExternalMsgListener");
    this.executor.execute(new Runnable() {
          public void run() {
            if (PrivateChatManager.this.connector != null)
              PrivateChatManager.this.connector.b(listener); 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grpc\PrivateChatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */