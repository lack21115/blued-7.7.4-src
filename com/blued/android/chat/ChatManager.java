package com.blued.android.chat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.chat.AudioRoomChat;
import com.blued.android.chat.core.worker.chat.Chat;
import com.blued.android.chat.core.worker.chat.FlashVideo;
import com.blued.android.chat.core.worker.chat.LiveChat;
import com.blued.android.chat.core.worker.chat.RoomChat;
import com.blued.android.chat.core.worker.chat.VideoChat;
import com.blued.android.chat.core.worker.chat.WawajiChat;
import com.blued.android.chat.core.worker.chat.WawajiControllerChat;
import com.blued.android.chat.core.worker.heart.Heart;
import com.blued.android.chat.data.UserInfoForChat;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.listener.AudioRoomChatInfoListener;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.DebugTipsListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.ILogCallback;
import com.blued.android.chat.listener.IMStatusListener;
import com.blued.android.chat.listener.LiveChatCreateListener;
import com.blued.android.chat.listener.LiveChatEnterListener;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.listener.LoadListener;
import com.blued.android.chat.listener.LoadMsgListener;
import com.blued.android.chat.listener.MsgContentListener;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.listener.RetractionListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.chat.utils.DeviceInfo;
import com.qiniu.android.dns.DnsManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatManager {
  private static final String TAG = "Chat_ChatManager";
  
  public static int chatBackupPort;
  
  public static String chatHostAddr;
  
  public static int chatHostPort;
  
  public static ClientType clientType;
  
  public static Context context;
  
  public static DBOper dbOperImpl;
  
  public static boolean debug;
  
  public static boolean debugByteData;
  
  public static DnsManager dnsManager;
  
  public static boolean isDnsManagerPrior;
  
  public static boolean isSSL;
  
  public static String language;
  
  public static String languageDetail;
  
  public static final UserInfoForChat userInfo = new UserInfoForChat();
  
  private boolean appActived = false;
  
  private AudioRoomChat audioRoomChat = new AudioRoomChat(this.connector, this.chat);
  
  private Chat chat = new Chat(this.connector);
  
  protected Connector connector = new Connector();
  
  public DebugTipsListener debugTipsListener;
  
  private final ExecutorService executor = Executors.newSingleThreadExecutor();
  
  private FlashVideo flashVideo = new FlashVideo(this.connector, this.chat);
  
  protected Heart heart = new Heart(this.connector);
  
  private LiveChat liveChat;
  
  private RoomChat roomChat = new RoomChat(this.chat);
  
  protected boolean stopped = true;
  
  private ChatTipsListener tipsListener;
  
  private VideoChat videoChat = new VideoChat(this.connector, this.chat);
  
  private WawajiChat wawajiChat = new WawajiChat(this.connector, this.chat);
  
  private WawajiControllerChat wawajiControllerChat = new WawajiControllerChat(this.connector, this.chat);
  
  static {
    context = null;
    debug = false;
    debugByteData = false;
    chatHostAddr = "h3.blued.cn";
    chatHostPort = 8080;
    chatBackupPort = 443;
    dnsManager = null;
    isDnsManagerPrior = false;
    isSSL = false;
    language = null;
    languageDetail = null;
  }
  
  private ChatManager() {}
  
  private String getAppVersion(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(packageInfo.versionName);
      stringBuilder.append("_");
      stringBuilder.append(packageInfo.versionCode);
      return stringBuilder.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  private File getDebugLogFile(Context paramContext) {
    File file = new File(paramContext.getFilesDir(), "blued_debug_log");
    if (!file.exists())
      file.mkdirs(); 
    file = new File(file, "blued_chat.txt");
    if (file.exists() && file.length() > 1024000L && !file.delete()) {
      Log.e("Chat_ChatManager", "文件大小超过限制, 但删除失败");
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
  
  public static ChatManager getInstance() {
    return SingletonCreator.instance;
  }
  
  public static boolean isInited() {
    return !(context == null);
  }
  
  public void appActiveChanged(final boolean actived) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("appActiveChanged(), actived:");
      stringBuilder.append(actived);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.appActived = actived;
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("appActiveChanged() running, actived:");
              stringBuilder.append(actived);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.heart != null)
              ChatManager.this.heart.appActiveChanged(actived); 
            if (ChatManager.this.connector != null)
              ChatManager.this.connector.appActiveChanged(actived); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("appActiveChanged() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void applyJoinLive(final short sessionType, final long sessionId, final long answerId) {
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.applyJoinLive(sessionType, sessionId, answerId); 
          }
        });
  }
  
  public void clearAllSecretLook() {
    if (debug)
      Log.v("Chat_ChatManager", "clearAllSecretLook()"); 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null)
                ChatManager.this.chat.clearAllSecretLook(); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("clearAllSecretLook() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                stringBuilder.append(" result: ");
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void closeLiveChat(short paramShort, long paramLong) {
    closeLiveChat(paramShort, paramLong, 0);
  }
  
  public void closeLiveChat(final short sessionType, final long sessionId, final int reason) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("closeLiveChat(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "closeLiveChat() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.closeLiveChat(sessionType, sessionId, reason); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("closeLiveChat() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void createGameLiveChat(final String liveDescription, final String liveCover, final int screenPattern, final int showNearby, final int privateFlag, final LiveChatCreateListener liveChatCreateListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createLiveChat(), liveDescription:");
      stringBuilder.append(liveDescription);
      stringBuilder.append(", liveCover:");
      stringBuilder.append(liveCover);
      stringBuilder.append(", screenPattern:");
      stringBuilder.append(screenPattern);
      stringBuilder.append(", showNearby:");
      stringBuilder.append(showNearby);
      stringBuilder.append(", privateFlag:");
      stringBuilder.append(privateFlag);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "createLiveChat() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat == null) {
              ChatManager chatManager = ChatManager.this;
              ChatManager.access$202(chatManager, new LiveChat(chatManager.connector, ChatManager.this.chat));
            } 
            ChatManager.this.liveChat.createLiveChat(0, 1, liveDescription, liveCover, screenPattern, showNearby, privateFlag, liveChatCreateListener);
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("createLiveChat() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void createLiveChat(final int liveType, final String liveDescription, final String liveCover, final int screenPattern, final int showNearby, final int privateFlag, final LiveChatCreateListener liveChatCreateListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createLiveChat(), liveDescription:");
      stringBuilder.append(liveDescription);
      stringBuilder.append(", liveCover:");
      stringBuilder.append(liveCover);
      stringBuilder.append(", screenPattern:");
      stringBuilder.append(screenPattern);
      stringBuilder.append(", showNearby:");
      stringBuilder.append(showNearby);
      stringBuilder.append(", privateFlag:");
      stringBuilder.append(privateFlag);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "createLiveChat() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat == null) {
              ChatManager chatManager = ChatManager.this;
              ChatManager.access$202(chatManager, new LiveChat(chatManager.connector, ChatManager.this.chat));
            } 
            ChatManager.this.liveChat.createLiveChat(0, liveType, liveDescription, liveCover, screenPattern, showNearby, privateFlag, liveChatCreateListener);
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("createLiveChat() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void createLiveChat(final String liveDescription, final String liveCover, final int screenPattern, final int showNearby, final int privateFlag, final LiveChatCreateListener liveChatCreateListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createLiveChat(), liveDescription:");
      stringBuilder.append(liveDescription);
      stringBuilder.append(", liveCover:");
      stringBuilder.append(liveCover);
      stringBuilder.append(", screenPattern:");
      stringBuilder.append(screenPattern);
      stringBuilder.append(", showNearby:");
      stringBuilder.append(showNearby);
      stringBuilder.append(", privateFlag:");
      stringBuilder.append(privateFlag);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "createLiveChat() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat == null) {
              ChatManager chatManager = ChatManager.this;
              ChatManager.access$202(chatManager, new LiveChat(chatManager.connector, ChatManager.this.chat));
            } 
            ChatManager.this.liveChat.createLiveChat(0, 0, liveDescription, liveCover, screenPattern, showNearby, privateFlag, liveChatCreateListener);
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("createLiveChat() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void createMirrorLiveChat(final String liveDescription, final String liveCover, final int screenPattern, final int showNearby, final int privateFlag, final LiveChatCreateListener liveChatCreateListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createLiveChat(), liveDescription:");
      stringBuilder.append(liveDescription);
      stringBuilder.append(", liveCover:");
      stringBuilder.append(liveCover);
      stringBuilder.append(", screenPattern:");
      stringBuilder.append(screenPattern);
      stringBuilder.append(", showNearby:");
      stringBuilder.append(showNearby);
      stringBuilder.append(", privateFlag:");
      stringBuilder.append(privateFlag);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "createLiveChat() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat == null) {
              ChatManager chatManager = ChatManager.this;
              ChatManager.access$202(chatManager, new LiveChat(chatManager.connector, ChatManager.this.chat));
            } 
            ChatManager.this.liveChat.createLiveChat(1, 0, liveDescription, liveCover, screenPattern, showNearby, privateFlag, liveChatCreateListener);
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("createLiveChat() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteAllChattings() {
    if (debug)
      Log.v("Chat_ChatManager", "deleteAllChattings()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "deleteAllChattings() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.deleteAllChattings(); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteAllChattings() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteAllSessionAndChatting() {
    if (debug)
      Log.v("Chat_ChatManager", "deleteAllSessionAndChatting()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "deleteAllSessionAndChatting() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.deleteAllSessions(true); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteAllSessionAndChatting() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteAllSessions() {
    if (debug)
      Log.v("Chat_ChatManager", "deleteAllSessions()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "deleteAllSessions() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.deleteAllSessions(false); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteAllSessions() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteChatting(final int sessionType, final long sessionId) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deleteChatting(), sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteChatting() running, sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.deleteChatting(sessionType, sessionId); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteChatting() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteLocalChatting(final int sessionType, final long sessionId) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deleteLocalChatting(), sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteLocalChatting() running, sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.deleteLocalChatting(sessionType, sessionId); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteLocalChatting() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteOneMessage(final short sessionType, final long sessionId, final long messageId, final long localId) {
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.deleteOneMessage(sessionType, sessionId, messageId, localId); 
          }
        });
  }
  
  public void deleteSession(final short sessionType, final long sessionId) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deleteSession(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteSession() running, sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null) {
              ArrayList<Pair> arrayList = new ArrayList();
              arrayList.add(new Pair(Short.valueOf(sessionType), Long.valueOf(sessionId)));
              ChatManager.this.chat.deleteSessions(arrayList, false);
            } 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteSession() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteSessionAndChatting(final Short sessionType, final long sessionId) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deleteSessionAndChattingForOne(), sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteSessionAndChattingForOne() running, sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null) {
              ArrayList<Pair> arrayList = new ArrayList();
              arrayList.add(new Pair(sessionType, Long.valueOf(sessionId)));
              ChatManager.this.chat.deleteSessions(arrayList, true);
            } 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteSessionAndChattingForOne() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteSessionAndChatting(final List<Pair<Short, Long>> sessionPairs) {
    if (debug)
      Log.v("Chat_ChatManager", "deleteSessionAndChatting()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "deleteSessionAndChatting() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.deleteSessions(sessionPairs, true); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteSessionAndChatting() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteSessionAndChattingWithSetting(final Short sessionType, final long sessionId) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deleteSessionAndChattingWithSetting(), sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteSessionAndChattingWithSetting() running, sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null) {
              ArrayList<Pair> arrayList = new ArrayList();
              arrayList.add(new Pair(sessionType, Long.valueOf(sessionId)));
              ChatManager.this.chat.deleteSessionsWithSetting(arrayList, true);
            } 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteSessionAndChattingWithSetting() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteSessionAndChattingWithSetting(final List<Pair<Short, Long>> sessionPairs) {
    if (debug)
      Log.v("Chat_ChatManager", "deleteSessionAndChattingWithSetting()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "deleteSessionAndChattingWithSetting() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.deleteSessionsWithSetting(sessionPairs, true); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteSessionAndChattingWithSetting() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void deleteSessions(final List<Pair<Short, Long>> sessionPairs) {
    if (debug)
      Log.v("Chat_ChatManager", "deleteSessions()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "deleteSessions() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.deleteSessions(sessionPairs, false); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("deleteSessions() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void destroyMsg(final short sessionType, final long sessionId, final ChattingModel msgData) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("destroyMsg(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", msgData:");
      stringBuilder.append(msgData);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("destroyMsg() running, msgData:");
              stringBuilder.append(msgData);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.destroyMsg(sessionType, sessionId, msgData); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("destroyMsg() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void enterLiveChat(final short sessionType, final long sessionId, final String from, final LiveChatEnterListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("enterLiveChat(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "enterLiveChat() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat == null) {
              ChatManager chatManager = ChatManager.this;
              ChatManager.access$202(chatManager, new LiveChat(chatManager.connector, ChatManager.this.chat));
            } 
            ChatManager.this.liveChat.enterLiveChat(sessionType, sessionId, from, listener);
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("enterLiveChat() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void findMessage(final short sessionType, final long sessionId, final long messageId, final long localId, final LoadMsgListener listener) {
    if (debug)
      Log.v("Chat_ChatManager", "findMessage()"); 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null)
                ChatManager.this.chat.findMessage(sessionType, sessionId, messageId, localId, listener); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("findMessage() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                stringBuilder.append(" result: ");
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void getSessionModel(final short sessionType, final long sessionId, final FetchDataListener<SessionModel> listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSessionModel(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getSessionModel() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.getSessionModel(sessionType, sessionId, listener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getSessionModel() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void getSessionModelList(final FetchDataListener<List<SessionModel>> listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSessionModelList(), listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getSessionModelList() running, listener:");
              stringBuilder.append(listener);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.getSessionModelList(listener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getSessionModelList() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void getSessionModelMap(final FetchDataListener<Map<String, SessionModel>> listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSessionModelMap(), listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getSessionModelMap() running, listener:");
              stringBuilder.append(listener);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.getSessionModelMap(listener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getSessionModelMap() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void getSessionSettingModel(final short sessionType, final long sessionId, final FetchDataListener<SessionSettingBaseModel> listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSessionSettingModel(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getSessionSettingModel() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.getSessionSettingModel(sessionType, sessionId, listener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("getSessionSettingModel() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public SessionModel getSnapSessionModel(short paramShort, long paramLong) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSnapSessionModel(), sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    Chat chat = this.chat;
    return (chat != null) ? chat.getSnapSessionModel(paramShort, paramLong) : null;
  }
  
  public ChatTipsListener getTipsListener() {
    return this.tipsListener;
  }
  
  public long getUid() {
    UserInfoForChat userInfoForChat = userInfo;
    return (userInfoForChat != null) ? userInfoForChat.uid : 0L;
  }
  
  public void ignoredNoReadNum(final List<Pair<Short, Long>> sessionPairs) {
    if (debug)
      Log.v("Chat_ChatManager", "ignoredNoReadNum()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "ignoredNoReadNum() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.ignoredNoReadNumForSessions(sessionPairs); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("appActiveChanged() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void ignoredNoReadNum(final short sessionType, final long sessionId) {
    if (debug)
      Log.v("Chat_ChatManager", "ignoredNoReadNum()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("ignoredNoReadNum() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null) {
              ArrayList<Pair> arrayList = new ArrayList();
              arrayList.add(new Pair(Short.valueOf(sessionType), Long.valueOf(sessionId)));
              ChatManager.this.chat.ignoredNoReadNumForSessions(arrayList);
            } 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("appActiveChanged() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void ignoredNoReadNumAll() {
    if (debug)
      Log.v("Chat_ChatManager", "ignoredNoReadNumAll()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "ignoredNoReadNumAll() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.ignoredNoReadNumAll(); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("appActiveChanged() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void init(Context paramContext, ClientType paramClientType, DBOper paramDBOper, boolean paramBoolean) {
    init(paramContext, paramClientType, paramDBOper, paramBoolean, null);
  }
  
  public void init(Context paramContext, ClientType paramClientType, DBOper paramDBOper, boolean paramBoolean, ILogCallback paramILogCallback) {
    if (context != null)
      return; 
    clientType = paramClientType;
    context = paramContext;
    debug = paramBoolean;
    if (paramDBOper != null) {
      dbOperImpl = paramDBOper;
    } else {
      dbOperImpl = DBOper.EmptyDBOper;
    } 
    initLanguage();
    if (paramILogCallback != null) {
      try {
        Log.init(paramContext, paramILogCallback);
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } else if (paramBoolean) {
      File file = getDebugLogFile(paramContext);
      if (file != null) {
        Log.init(paramContext, true, file);
      } else {
        Log.init(paramContext, false, null);
      } 
    } else {
      Log.init(paramContext, false, null);
    } 
    if (debug) {
      Log.v("Chat_ChatManager", "\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++\n++++++++++++++++++");
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("init(), debug:");
      stringBuilder2.append(paramBoolean);
      stringBuilder2.append(", version:");
      stringBuilder2.append(getAppVersion(paramContext));
      Log.v("Chat_ChatManager", stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("device info:");
      stringBuilder1.append(DeviceInfo.getDeviceInfo());
      Log.v("Chat_ChatManager", stringBuilder1.toString());
    } 
  }
  
  public void initLanguage() {
    // Byte code:
    //   0: invokestatic getDefault : ()Ljava/util/Locale;
    //   3: invokevirtual getLanguage : ()Ljava/lang/String;
    //   6: putstatic com/blued/android/chat/ChatManager.language : Ljava/lang/String;
    //   9: getstatic com/blued/android/chat/ChatManager.language : Ljava/lang/String;
    //   12: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   15: ifeq -> 27
    //   18: ldc_w ''
    //   21: putstatic com/blued/android/chat/ChatManager.language : Ljava/lang/String;
    //   24: goto -> 122
    //   27: getstatic com/blued/android/chat/ChatManager.language : Ljava/lang/String;
    //   30: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   33: invokevirtual trim : ()Ljava/lang/String;
    //   36: putstatic com/blued/android/chat/ChatManager.language : Ljava/lang/String;
    //   39: invokestatic getDefault : ()Ljava/util/Locale;
    //   42: invokevirtual getCountry : ()Ljava/lang/String;
    //   45: astore_2
    //   46: ldc_w 'tw'
    //   49: aload_2
    //   50: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   53: ifne -> 68
    //   56: aload_2
    //   57: astore_1
    //   58: ldc_w 'hk'
    //   61: aload_2
    //   62: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   65: ifeq -> 72
    //   68: ldc_w 'tw'
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: ifne -> 122
    //   79: new java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial <init> : ()V
    //   86: astore_2
    //   87: aload_2
    //   88: getstatic com/blued/android/chat/ChatManager.language : Ljava/lang/String;
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_2
    //   96: ldc_w '_'
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_2
    //   104: aload_1
    //   105: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   108: invokevirtual trim : ()Ljava/lang/String;
    //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: invokevirtual toString : ()Ljava/lang/String;
    //   119: putstatic com/blued/android/chat/ChatManager.languageDetail : Ljava/lang/String;
    //   122: getstatic com/blued/android/chat/ChatManager.languageDetail : Ljava/lang/String;
    //   125: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   128: ifeq -> 137
    //   131: getstatic com/blued/android/chat/ChatManager.language : Ljava/lang/String;
    //   134: putstatic com/blued/android/chat/ChatManager.languageDetail : Ljava/lang/String;
    //   137: return
  }
  
  public void initLiveChatInfo(final short sessionType, final long sessionId, final boolean useHttp) {
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.this.liveChat == null) {
              ChatManager chatManager = ChatManager.this;
              ChatManager.access$202(chatManager, new LiveChat(chatManager.connector, ChatManager.this.chat));
            } 
            ChatManager.this.liveChat.initLiveChatInfo(sessionType, sessionId, useHttp);
          }
        });
  }
  
  public void insertMsgListFromBackup(final List<ChattingModel> chattingModelList) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("insertMsgListFromBackup(), chattingModelList:");
      stringBuilder.append(chattingModelList.size());
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              byte b;
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null) {
                b = ChatManager.this.chat.insertMsgListFromBackup(chattingModelList);
              } else {
                b = -1;
              } 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("insertMsgListFromBackup() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                stringBuilder.append(" result: ");
                stringBuilder.append(b);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void insertSessionList(final List<SessionModel> sessionModels) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("insertSessionList(), sessionModels:");
      stringBuilder.append(sessionModels.size());
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              byte b;
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null) {
                b = ChatManager.this.chat.insertSessionList(sessionModels);
              } else {
                b = -1;
              } 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("insertSessionList() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                stringBuilder.append(" result: ");
                stringBuilder.append(b);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public boolean isAppActived() {
    return this.appActived;
  }
  
  public void leaveLiveChat(final short sessionType, final long sessionId, final String from) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("leaveLiveChat(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "leaveLiveChat() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.leaveLiveChat(sessionType, sessionId, from); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("leaveLiveChat() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void loadNewMsg(final short sessionType, final long sessionId, final int count, final LoadMsgListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadNewMsg(), sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", count:");
      stringBuilder.append(count);
      stringBuilder.append(", listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("loadNewMsg() running, sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", count:");
              stringBuilder.append(count);
              stringBuilder.append(", listener:");
              stringBuilder.append(listener);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.loadNewMsg(sessionType, sessionId, count, listener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("loadNewMsg() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void loadSessionDownMsgList(final short sessionType, final long sessionId, final int count, final long msgId, final long msgLocalId, final LoadListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadSessionMsgList(), sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", count:");
      stringBuilder.append(count);
      stringBuilder.append(", listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("loadSessionMsgList() running, sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", count:");
              stringBuilder.append(count);
              stringBuilder.append(", listener:");
              stringBuilder.append(listener);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.loadDownSessionMsgList(sessionType, sessionId, msgId, msgLocalId, count, listener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("loadSessionMsgList() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void loadSessionMsgList(final short sessionType, final long sessionId, final int count, final LoadListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadSessionMsgList(), sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", count:");
      stringBuilder.append(count);
      stringBuilder.append(", listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("loadSessionMsgList() running, sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", count:");
              stringBuilder.append(count);
              stringBuilder.append(", listener:");
              stringBuilder.append(listener);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.loadSessionMsgList(sessionType, sessionId, count, listener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("loadSessionMsgList() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void networkChanged() {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("networkChanged(), stopped:");
      stringBuilder.append(this.stopped);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("networkChanged() running, stopped:");
                stringBuilder.append(ChatManager.this.stopped);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.connector != null)
                ChatManager.this.connector.checkNet(); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("networkChanged() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void notifyJoinLiveEnd(final short sessionType, final long sessionId, final long uid, final long endTime) {
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.notifyJoinLiveEnd(sessionType, sessionId, uid, endTime); 
          }
        });
  }
  
  public void notifyJoinLiveStart(final short sessionType, final long sessionId, final long uid, final String name, final long startTime) {
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.notifyJoinLiveStart(sessionType, sessionId, uid, name, startTime); 
          }
        });
  }
  
  public void notifySendStateForGRPC(final int sendResult, final short sessionType, final long sessionId, final long msgId, final long localId, final long msgTime) {
    if (debug)
      Log.v("Chat_ChatManager", "notifySendStateForGRPC()"); 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null)
                ChatManager.this.chat.notifySendStateForGRPC(sendResult, sessionType, sessionId, msgId, localId, msgTime); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("notifySendStateForGRPC() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                stringBuilder.append(" result: ");
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void onReceiveMsgFromGRPC(final ChattingModel msg, final boolean isRead, final boolean isDelete) {
    if (debug)
      Log.v("Chat_ChatManager", "onReceiveMsgFromGRPC()"); 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null)
                ChatManager.this.chat.onReceiveMsgFromGRPC(msg, isRead, isDelete); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onReceiveMsgFromGRPC() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                stringBuilder.append(" result: ");
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void pause() {
    if (debug)
      Log.v("Chat_ChatManager", "pause()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "pause() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.connector != null)
              ChatManager.this.connector.pause(); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("pause() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void pauseLive(final short sessionType, final long sessionId) {
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.pauseLive(sessionType, sessionId); 
          }
        });
  }
  
  public void registerAudioRoomChatListener(final AudioRoomChatInfoListener audioChatInfoListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerAudioRoomChatListener(), audioChatInfoListener:");
      stringBuilder.append(audioChatInfoListener.hashCode());
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "registerAudioRoomChatListener() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.audioRoomChat == null) {
              ChatManager chatManager = ChatManager.this;
              ChatManager.access$302(chatManager, new AudioRoomChat(chatManager.connector, ChatManager.this.chat));
            } 
            ChatManager.this.audioRoomChat.registerAudioRoomChatListener(audioChatInfoListener);
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("registerLiveChatListener() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void registerDebugTipsListener(DebugTipsListener paramDebugTipsListener) {
    this.debugTipsListener = paramDebugTipsListener;
  }
  
  protected FlashVideo registerFlashVideoHelper(FlashVideoHelper paramFlashVideoHelper) {
    FlashVideo flashVideo = this.flashVideo;
    if (flashVideo != null)
      flashVideo.attach(paramFlashVideoHelper); 
    return this.flashVideo;
  }
  
  public void registerIMStatusListener(final IMStatusListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerIMStatusListener(), listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.registerIMStatusListener(listener);
          }
        });
  }
  
  public void registerLiveChatListener(final short sessionType, final long sessionId, final LiveChatInfoListener liveChatInfoListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerLiveChatListener(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "registerLiveChatListener() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat == null) {
              ChatManager chatManager = ChatManager.this;
              ChatManager.access$202(chatManager, new LiveChat(chatManager.connector, ChatManager.this.chat));
            } 
            ChatManager.this.liveChat.registerLiveChatListener(sessionType, sessionId, liveChatInfoListener);
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("registerLiveChatListener() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void registerMsgContentListener(final short sessionType, final long sessionId, final MsgContentListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerMsgContentListener(), sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.registerMsgContentListener(sessionType, sessionId, listener, false);
          }
        });
  }
  
  public void registerMsgContentListenerSecret(final short sessionType, final long sessionId, final MsgContentListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerMsgContentListenerSecret(), sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.registerMsgContentListener(sessionType, sessionId, listener, true);
          }
        });
  }
  
  public void registerSessionListener(final SessionListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerSessionListener(), listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.registerSessionListener(listener);
          }
        });
  }
  
  public void registerSessionListener(final short sessionType, final long sessionId, final SingleSessionListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerSessionListener, sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.registerSessionListener(sessionType, sessionId, listener);
          }
        });
  }
  
  public void registerTipsListener(ChatTipsListener paramChatTipsListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerTipsListener(), listener:");
      stringBuilder.append(paramChatTipsListener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.tipsListener = paramChatTipsListener;
  }
  
  protected VideoChat registerVideoChatHelper(VideoChatHelper paramVideoChatHelper) {
    VideoChat videoChat = this.videoChat;
    if (videoChat != null)
      videoChat.attach(paramVideoChatHelper); 
    return this.videoChat;
  }
  
  protected WawajiControllerChat registerWawajiControllerHelper(WawajiControllerHelper paramWawajiControllerHelper) {
    WawajiControllerChat wawajiControllerChat = this.wawajiControllerChat;
    if (wawajiControllerChat != null)
      wawajiControllerChat.attach(paramWawajiControllerHelper); 
    return this.wawajiControllerChat;
  }
  
  protected WawajiChat registerWawajiHelper(WawajiChatHelper paramWawajiChatHelper) {
    WawajiChat wawajiChat = this.wawajiChat;
    if (wawajiChat != null)
      wawajiChat.attach(paramWawajiChatHelper); 
    return this.wawajiChat;
  }
  
  protected WawajiChat registerWawajiResultReceiveHelper(WawajiResultReceiveHelper paramWawajiResultReceiveHelper) {
    WawajiChat wawajiChat = this.wawajiChat;
    if (wawajiChat != null)
      wawajiChat.attachResultCallback(paramWawajiResultReceiveHelper); 
    return this.wawajiChat;
  }
  
  public void resendMsg(final ChattingModel msgData, final SessionProfileModel profileM) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("resendMsg(), msgData:");
      stringBuilder.append(msgData);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("sendMsg() running, msgData:");
              stringBuilder.append(msgData);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.sendMsg(msgData, profileM, true, null); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("resendMsg() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void resendMsg(final ChattingModel msgData, final SessionProfileModel profileM, final MsgPreProcesser msgPreProcess) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("resendMsg(), msgData:");
      stringBuilder.append(msgData);
      stringBuilder.append(", msgPreProcess:");
      stringBuilder.append(msgPreProcess);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("sendMsg() running, msgData:");
              stringBuilder.append(msgData);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.sendMsg(msgData, profileM, true, msgPreProcess); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("resendMsg() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void resume() {
    if (debug)
      Log.v("Chat_ChatManager", "resume()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "resume() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.connector != null)
              ChatManager.this.connector.resume(); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("resume() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void resumeLive(final short sessionType, final long sessionId) {
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.resumeLive(sessionType, sessionId); 
          }
        });
  }
  
  public void retractOneMessage(final short sessionType, final long sessionId, final long messageId, final RetractionListener callbackListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("retractOneMessage(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", messageId:");
      stringBuilder.append(messageId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("retractOneMessage() running, sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.retractOneMessage(sessionType, sessionId, messageId, callbackListener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("retractOneMessage() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void runChatSyncTask(Runnable paramRunnable) {
    this.executor.execute(paramRunnable);
  }
  
  public void sendMsg(final ChattingModel msgData, final SessionProfileModel profileM) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendMsg(), msgData:");
      stringBuilder.append(msgData);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    msgData.msgLocalId = 0L;
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("sendMsg() running, msgData:");
              stringBuilder.append(msgData);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.sendMsg(msgData, profileM, false, null); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("sendMsg() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void sendMsg(final ChattingModel msgData, final SessionProfileModel profileM, final MsgPreProcesser msgPreProcess) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendMsg(), msgData:");
      stringBuilder.append(msgData);
      stringBuilder.append(", msgPreProcess:");
      stringBuilder.append(msgPreProcess);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    msgData.msgLocalId = 0L;
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("sendMsg() running, msgData:");
              stringBuilder.append(msgData);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.sendMsg(msgData, profileM, false, msgPreProcess); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("sendMsg() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public boolean sessionExist(String paramString) {
    Chat chat = this.chat;
    return (chat != null) ? chat.sessionList.containsKey(paramString) : false;
  }
  
  public void setServerInfo(String paramString, int paramInt1, int paramInt2, DnsManager paramDnsManager, boolean paramBoolean1, boolean paramBoolean2) {
    chatHostAddr = paramString;
    chatHostPort = paramInt1;
    chatBackupPort = paramInt2;
    dnsManager = paramDnsManager;
    isDnsManagerPrior = paramBoolean1;
    isSSL = paramBoolean2;
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setServerInfo(), chatHostAddr:");
      stringBuilder.append(paramString);
      stringBuilder.append(", chatHostPort:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(", chatBackupPort:");
      stringBuilder.append(paramInt2);
      stringBuilder.append(", isSSL:");
      stringBuilder.append(paramBoolean2);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
  }
  
  public void setSessionSetting(final short sessionType, final long sessionId, final SessionSettingBaseModel sessionSettingModel) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setSessionSetting(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setSessionSetting() running sessionType:");
                stringBuilder.append(sessionType);
                stringBuilder.append(", sessionId:");
                stringBuilder.append(sessionId);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null)
                ChatManager.this.chat.setSessionSetting(sessionType, sessionId, sessionSettingModel); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setSessionSetting() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void start(final long uid, final String encryUid, final String encryToken) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start(), uid:");
      stringBuilder.append(uid);
      stringBuilder.append(", encryUid:");
      stringBuilder.append(encryUid);
      stringBuilder.append(", encryToken:");
      stringBuilder.append(encryToken);
      stringBuilder.append(", chatHostAddr:");
      stringBuilder.append(chatHostAddr);
      stringBuilder.append(", chatHostPort:");
      stringBuilder.append(chatHostPort);
      stringBuilder.append(", chatBackupPort:");
      stringBuilder.append(chatBackupPort);
      stringBuilder.append(", isSSL:");
      stringBuilder.append(isSSL);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("start() running, uid:");
              stringBuilder.append(uid);
              stringBuilder.append(", encryToken:");
              stringBuilder.append(encryToken);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.stopped) {
              ChatManager.userInfo.uid = uid;
              ChatManager.userInfo.encryUid = encryUid;
              ChatManager.userInfo.encryToken = encryToken;
              ChatManager.this.heart.start();
              ChatManager.this.chat.start();
              ChatManager.this.connector.start();
              ChatManager.this.stopped = false;
              if (Build.VERSION.SDK_INT >= 21)
                PingCheckerJobServer.startServer(ChatManager.context); 
            } 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("start() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void startJoinLive(final short sessionType, final long sessionId, final long invitedUid) {
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.startJoinLive(sessionType, sessionId, invitedUid); 
          }
        });
  }
  
  public void stop() {
    if (debug)
      Log.v("Chat_ChatManager", "stop()"); 
    this.stopped = true;
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "stop() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.connector != null) {
              ChatManager.this.heart.stop();
              ChatManager.this.chat.stop();
              if (ChatManager.this.liveChat != null)
                ChatManager.this.liveChat.stop(); 
              ChatManager.this.connector.stop();
            } 
            ChatManager.this.stopped = true;
            if (Build.VERSION.SDK_INT >= 21)
              PingCheckerJobServer.stopServer(ChatManager.context); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("stop() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void stopTalkForeverInLiveChat(final short sessionType, final long sessionId, final long uid) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stopTalkForeverInLiveChat(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", uid:");
      stringBuilder.append(uid);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "stopTalkForeverInLiveChat() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.stopTalkSomebodyForever(sessionType, sessionId, uid); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("stopTalkForeverInLiveChat() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void stopTalkInLiveChat(final short sessionType, final long sessionId, final long uid, final boolean enable) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stopTalkInLiveChat(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", uid:");
      stringBuilder.append(uid);
      stringBuilder.append(", enable:");
      stringBuilder.append(enable);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "stopTalkInLiveChat() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.stopTalkSomebody(sessionType, sessionId, uid, enable); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("stopTalkInLiveChat() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void switchRoomChat(final long roomId) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("switchRoomChat(), roomId:");
      stringBuilder.append(roomId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("switchRoomChat() start, roomId:");
                stringBuilder.append(roomId);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.roomChat != null)
                ChatManager.this.roomChat.switchRoomId(roomId); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("switchRoomChat() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void syncMsg() {
    if (debug)
      Log.v("Chat_ChatManager", "syncMsg()"); 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null)
                ChatManager.this.chat.retrySyncMsg(false); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("syncMsg() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                stringBuilder.append(" result: ");
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void triggleSessionListNotify() {
    if (debug)
      Log.v("Chat_ChatManager", "triggleSessionListNotify()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.triggleSessionListNotify();
          }
        });
  }
  
  public void unregisterAudioRoomChatListener(final AudioRoomChatInfoListener audioChatInfoListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterAudioRoomChatListener(), audioChatInfoListener:");
      stringBuilder.append(audioChatInfoListener.hashCode());
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "unregisterAudioRoomChatListener() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.audioRoomChat != null)
              ChatManager.this.audioRoomChat.unregisterAudioRoomChatListener(audioChatInfoListener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("unregisterAudioRoomChatListener() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  protected void unregisterFlashVideoHelper(FlashVideoHelper paramFlashVideoHelper) {
    FlashVideo flashVideo = this.flashVideo;
    if (flashVideo != null)
      flashVideo.detach(paramFlashVideoHelper); 
  }
  
  public void unregisterIMStatusListener(final IMStatusListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterIMStatusListener(), listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.unregisterIMStatusListener(listener);
          }
        });
  }
  
  public void unregisterLiveChatListener(final short sessionType, final long sessionId, final LiveChatInfoListener liveChatInfoListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterLiveChatListener(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "unregisterLiveChatListener() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.unregisterLiveChatListener(sessionType, sessionId, liveChatInfoListener); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("unregisterLiveChatListener() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void unregisterMsgContentListener(final short sessionType, final long sessionId, final MsgContentListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterMsgContentListener(), sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.unregisterMsgContentListener(sessionType, sessionId, listener);
          }
        });
  }
  
  public void unregisterSessionListener(final SessionListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterSessionListener(), listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.unregisterSessionListener(listener);
          }
        });
  }
  
  public void unregisterSessionListener(final short sessionType, final long sessionId, final SingleSessionListener listener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterSessionListener, sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", listener:");
      stringBuilder.append(listener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            ChatManager.this.chat.unregisterSessionListener(sessionType, sessionId, listener);
          }
        });
  }
  
  public void unregisterTipsListener(ChatTipsListener paramChatTipsListener) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterTipsListener(), ChatTipsListener:");
      stringBuilder.append(paramChatTipsListener);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    if (this.tipsListener == paramChatTipsListener)
      this.tipsListener = null; 
  }
  
  protected void unregisterVideoChatHelper(VideoChatHelper paramVideoChatHelper) {
    VideoChat videoChat = this.videoChat;
    if (videoChat != null)
      videoChat.detach(paramVideoChatHelper); 
  }
  
  protected void unregisterWawajiControllerHelper(WawajiControllerHelper paramWawajiControllerHelper) {
    WawajiControllerChat wawajiControllerChat = this.wawajiControllerChat;
    if (wawajiControllerChat != null)
      wawajiControllerChat.detach(paramWawajiControllerHelper); 
  }
  
  protected void unregisterWawajiHelper(WawajiChatHelper paramWawajiChatHelper) {
    WawajiChat wawajiChat = this.wawajiChat;
    if (wawajiChat != null)
      wawajiChat.detach(paramWawajiChatHelper); 
  }
  
  protected void unregisterWawajiResultReceiveHelper(WawajiResultReceiveHelper paramWawajiResultReceiveHelper) {
    WawajiChat wawajiChat = this.wawajiChat;
    if (wawajiChat != null)
      wawajiChat.detachResultCallback(paramWawajiResultReceiveHelper); 
  }
  
  public void updateAllSessionSetting(final Map<String, Object> keyValues) {
    if (debug)
      Log.v("Chat_ChatManager", "updateAllSessionSetting()"); 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              if (ChatManager.debug)
                Log.v("Chat_ChatManager", "updateAllSessionSetting()==running"); 
              long l = SystemClock.uptimeMillis();
              int i = -1;
              if (ChatManager.this.chat != null)
                i = ChatManager.this.chat.updateAllSessionSetting(keyValues); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("updateAllSessionSetting() result:");
                stringBuilder.append(i);
                Log.v("Chat_ChatManager", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("updateAllSessionSetting() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void updateLiveChatInfo(final short sessionType, final long sessionId) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateLiveChatInfo(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "updateLiveChatInfo() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.liveChat != null)
              ChatManager.this.liveChat.updateLiveChatInfo(sessionType, sessionId); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateLiveChatInfo() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateMsgForTextTranslateInit(final int sessionType, final long sessionId) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateMsgForTextTranslateInit(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(",sessionId:");
      stringBuilder.append(sessionId);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateMsgForTextTranslateInit() running sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(",sessionId:");
              stringBuilder.append(sessionId);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateMsgForTextTranslateInit(sessionType, sessionId); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateMsgForTextTranslateInit() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateMsgOneData(final ChattingModel msgData) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateMsgState(), msgData:");
      stringBuilder.append(msgData);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateMsgState() running, msgData:");
              stringBuilder.append(msgData);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateMsgOneData(msgData); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateMsgState() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateMsgState(final ChattingModel msgData, final short newState) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateMsgState(), msgData:");
      stringBuilder.append(msgData);
      stringBuilder.append(", newState:");
      stringBuilder.append(newState);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateMsgState() running, msgData:");
              stringBuilder.append(msgData);
              stringBuilder.append(", newState:");
              stringBuilder.append(newState);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateMsgState(msgData, newState); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateMsgState() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateRelationSessionSetting(final short sessionType, final long sessionId, final Map<String, Object> keyValues) {
    if (debug)
      Log.v("Chat_ChatManager", "updateRelationSessionSetting()"); 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              if (ChatManager.debug)
                Log.v("Chat_ChatManager", "updateRelationSessionSetting()===running"); 
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null)
                ChatManager.this.chat.updateRelationSessionSetting(sessionType, sessionId, keyValues); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("updateRelationSessionSetting() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void updateRelationSessionSettingListDb(final List<SessionSettingBaseModel> modelList) {
    if (debug)
      Log.v("Chat_ChatManager", "updateRelationSessionSettingListDb()"); 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              if (ChatManager.debug)
                Log.v("Chat_ChatManager", "updateRelationSessionSettingListDb()===running"); 
              long l = SystemClock.uptimeMillis();
              int i = -1;
              if (ChatManager.this.chat != null)
                i = ChatManager.this.chat.updateRelationSessionSettingListDb(modelList); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("updateRelationSessionSettingListDb() result:");
                stringBuilder.append(i);
                Log.v("Chat_ChatManager", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("updateRelationSessionSettingListDb() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void updateSessionDraft(final short sessionType, final long sessionId, final String draft) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateSessionDraft(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", draft:");
      stringBuilder.append(draft);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionDraft() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", draft:");
              stringBuilder.append(draft);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateSessionDraft(sessionType, sessionId, draft); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionDraft() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateSessionFriend(final short sessionType, final long sessionId, final int friend) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateSessionFriend(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", friend:");
      stringBuilder.append(friend);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionFriend() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", friend:");
              stringBuilder.append(friend);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateSessionFriend(sessionType, sessionId, friend); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionFriend() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateSessionInfoData(final short sessionType, final long sessionId, final SessionProfileModel profileM) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateSessionInfoData(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", profileM:");
      stringBuilder.append(profileM);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionInfoData() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", profileM:");
              stringBuilder.append(profileM);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateSessionInfoData(sessionType, sessionId, profileM); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionInfoData() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateSessionLieTop(final short sessionType, final long sessionId, final int lieTop) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateSessionLieTop(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", lieTop:");
      stringBuilder.append(lieTop);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionLieTop() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", lieTop:");
              stringBuilder.append(lieTop);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateSessionLieTop(sessionType, sessionId, lieTop); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionLieTop() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateSessionNoReadNum(final short sessionType, final long sessionId, final int noReadCount) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateSessionNoReadNum(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", noReadCount:");
      stringBuilder.append(noReadCount);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("updateSessionNoReadNum() start, sessionType:");
                stringBuilder.append(sessionType);
                stringBuilder.append(", sessionId:");
                stringBuilder.append(sessionId);
                stringBuilder.append(", noReadCount:");
                stringBuilder.append(noReadCount);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
              long l = SystemClock.uptimeMillis();
              if (ChatManager.this.chat != null)
                ChatManager.this.chat.updateSessionNoReadCount(sessionType, sessionId, noReadCount); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("updateSessionNoReadNum() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void updateSessionOnLineState(final List<Pair<Long, Integer>> sessionPairs) {
    if (debug)
      Log.v("Chat_ChatManager", "updataSessionPLine()"); 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug)
              Log.v("Chat_ChatManager", "updataSessionPLine() running"); 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateSessionOnLineState(sessionPairs); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updataSessionPLine() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateSessionSetting(final short sessionType, final long sessionId, final Map<String, Object> keyValues) {
    if (debug)
      Log.v("Chat_ChatManager", "updateSessionSetting()"); 
    if (!this.stopped)
      this.executor.execute(new Runnable() {
            public void run() {
              if (ChatManager.debug)
                Log.v("Chat_ChatManager", "updateSessionSetting()==running"); 
              long l = SystemClock.uptimeMillis();
              int i = -1;
              if (ChatManager.this.chat != null)
                i = ChatManager.this.chat.updateSessionSetting(sessionType, sessionId, keyValues); 
              if (ChatManager.debug) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("updateSessionSetting() result:");
                stringBuilder.append(i);
                Log.v("Chat_ChatManager", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("updateSessionSetting() takes ");
                stringBuilder.append(SystemClock.uptimeMillis() - l);
                Log.v("Chat_ChatManager", stringBuilder.toString());
              } 
            }
          }); 
  }
  
  public void updateSessionTopGift(final short sessionType, final long sessionId, final long expireTime, final float totalMoney) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateSessionTopGift(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", expireTime:");
      stringBuilder.append(expireTime);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionTopGift() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", expireTime:");
              stringBuilder.append(expireTime);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateSessionTopGift(sessionType, sessionId, expireTime, totalMoney); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionTopGift() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateSessionUnreadGiftCnt(final short sessionType, final long sessionId, final int unreadCnt, final long msgId) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateSessionUnreadGiftCnt(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", unreadCnt:");
      stringBuilder.append(unreadCnt);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionUnreadGiftCnt() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", unreadCnt:");
              stringBuilder.append(unreadCnt);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updateSessionUnreadGiftCnt(sessionType, sessionId, unreadCnt, msgId); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSessionUnreadGiftCnt() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateSesssionStatus(final short sessionType, final long sessionId, final int sessionStatus) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateSesssionStatus(), sessionType:");
      stringBuilder.append(sessionType);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(sessionId);
      stringBuilder.append(", sessionStatus:");
      stringBuilder.append(sessionStatus);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    this.executor.execute(new Runnable() {
          public void run() {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSesssionStatus() running, sessionType:");
              stringBuilder.append(sessionType);
              stringBuilder.append(", sessionId:");
              stringBuilder.append(sessionId);
              stringBuilder.append(", sessionStatus:");
              stringBuilder.append(sessionStatus);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
            long l = SystemClock.uptimeMillis();
            if (ChatManager.this.chat != null)
              ChatManager.this.chat.updataSessionStatus(sessionType, sessionId, sessionStatus); 
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updateSesssionStatus() takes ");
              stringBuilder.append(SystemClock.uptimeMillis() - l);
              Log.v("Chat_ChatManager", stringBuilder.toString());
            } 
          }
        });
  }
  
  public void updateUserToken(String paramString) {
    if (debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateUserToken(), encryToken:");
      stringBuilder.append(paramString);
      Log.v("Chat_ChatManager", stringBuilder.toString());
    } 
    userInfo.encryToken = paramString;
  }
  
  public enum ClientType {
    CHINA, INTERNATIONAL;
    
    static {
    
    }
  }
  
  static class SingletonCreator {
    public static final ChatManager instance = new ChatManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\ChatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */