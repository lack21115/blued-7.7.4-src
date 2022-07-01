package com.blued.android.module.chat.manager;

import android.os.Handler;
import android.util.Pair;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.contract.IChatRelationDataListener;
import com.blued.android.module.chat.http.ModuleChatHttpUtils;
import com.blued.android.module.chat.model.SessionRelationModel;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.chat.utils.ListUtils;
import com.blued.android.module.chat.utils.PreferencesUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ChatRelationDataManager {
  private static ChatRelationDataManager instance;
  
  private String TAG = "@@@ module_chat_ChatRelationDataManager";
  
  private long lastUpdateTime = 0L;
  
  public static ChatRelationDataManager getInstance() {
    if (instance == null)
      instance = new ChatRelationDataManager(); 
    return instance;
  }
  
  private void updateFinish(final UpdateRelationCallback callback, final int code, final String errorStr) {
    Handler handler = AppInfo.n();
    if (handler != null)
      handler.postDelayed(new Runnable() {
            public void run() {
              ChatRelationDataManager.UpdateRelationCallback updateRelationCallback = callback;
              if (updateRelationCallback != null)
                updateRelationCallback.finish(code, errorStr); 
            }
          }1000L); 
  }
  
  public void registerChatRelationDataListener(IChatRelationDataListener paramIChatRelationDataListener) {
    ChatRelationDataListenerManager.getInstance().registerChatRelationDataListener(paramIChatRelationDataListener);
  }
  
  public void unRegisterChatRelationDataListener(IChatRelationDataListener paramIChatRelationDataListener) {
    ChatRelationDataListenerManager.getInstance().unRegisterChatRelationDataListener(paramIChatRelationDataListener);
  }
  
  @Deprecated
  public void updateRelationData(SessionModel paramSessionModel) {
    if (paramSessionModel == null) {
      Logger.b(this.TAG, new Object[] { "updateRelationData() session == null !!!" });
      return;
    } 
    SingleRelationRunnable singleRelationRunnable = new SingleRelationRunnable(paramSessionModel.sessionId);
    AppInfo.n().postDelayed(singleRelationRunnable, 1000L);
  }
  
  public void updateRelationData(UpdateRelationCallback paramUpdateRelationCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 41
    //   6: aload_0
    //   7: aload_1
    //   8: sipush #404
    //   11: ldc 'callback == null !!!'
    //   13: invokespecial updateFinish : (Lcom/blued/android/module/chat/manager/ChatRelationDataManager$UpdateRelationCallback;ILjava/lang/String;)V
    //   16: invokestatic m : ()Z
    //   19: ifeq -> 38
    //   22: aload_0
    //   23: getfield TAG : Ljava/lang/String;
    //   26: iconst_1
    //   27: anewarray java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: ldc 'callback == null !!!'
    //   34: aastore
    //   35: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: getfield lastUpdateTime : J
    //   45: lconst_0
    //   46: lcmp
    //   47: ifeq -> 100
    //   50: invokestatic currentTimeMillis : ()J
    //   53: aload_0
    //   54: getfield lastUpdateTime : J
    //   57: lsub
    //   58: ldc2_w 300000
    //   61: lcmp
    //   62: ifge -> 100
    //   65: aload_0
    //   66: aload_1
    //   67: sipush #201
    //   70: ldc '更新关系数据，时间未到5分钟'
    //   72: invokespecial updateFinish : (Lcom/blued/android/module/chat/manager/ChatRelationDataManager$UpdateRelationCallback;ILjava/lang/String;)V
    //   75: invokestatic m : ()Z
    //   78: ifeq -> 97
    //   81: aload_0
    //   82: getfield TAG : Ljava/lang/String;
    //   85: iconst_1
    //   86: anewarray java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: ldc '更新关系数据，时间未到5分钟'
    //   93: aastore
    //   94: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: invokestatic getInstance : ()Lcom/blued/android/module/chat/manager/SessionDataManager;
    //   103: invokevirtual getAllUids : ()Ljava/util/List;
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull -> 151
    //   111: aload_2
    //   112: invokeinterface size : ()I
    //   117: ifgt -> 123
    //   120: goto -> 151
    //   123: aload_0
    //   124: invokestatic currentTimeMillis : ()J
    //   127: putfield lastUpdateTime : J
    //   130: invokestatic a : ()Lcom/blued/android/framework/pool/ThreadManager;
    //   133: new com/blued/android/module/chat/manager/ChatRelationDataManager$1
    //   136: dup
    //   137: aload_0
    //   138: ldc 'update_chat_relation_thread'
    //   140: aload_2
    //   141: aload_1
    //   142: invokespecial <init> : (Lcom/blued/android/module/chat/manager/ChatRelationDataManager;Ljava/lang/String;Ljava/util/List;Lcom/blued/android/module/chat/manager/ChatRelationDataManager$UpdateRelationCallback;)V
    //   145: invokevirtual a : (Lcom/blued/android/framework/pool/ThreadExecutor;)V
    //   148: aload_0
    //   149: monitorexit
    //   150: return
    //   151: aload_0
    //   152: aload_1
    //   153: sipush #404
    //   156: ldc '未更新关系数据：sessions == null || allUids.size() <= 0'
    //   158: invokespecial updateFinish : (Lcom/blued/android/module/chat/manager/ChatRelationDataManager$UpdateRelationCallback;ILjava/lang/String;)V
    //   161: invokestatic m : ()Z
    //   164: ifeq -> 183
    //   167: aload_0
    //   168: getfield TAG : Ljava/lang/String;
    //   171: iconst_1
    //   172: anewarray java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: ldc '未更新关系数据：sessions == null || allUids.size() <= 0'
    //   179: aastore
    //   180: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_0
    //   184: monitorexit
    //   185: return
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Exception table:
    //   from	to	target	type
    //   6	38	186	finally
    //   41	97	186	finally
    //   100	107	186	finally
    //   111	120	186	finally
    //   123	148	186	finally
    //   151	183	186	finally
  }
  
  static class SingleRelationRunnable implements Runnable {
    private String TAG = "@@@ module_chat_SingleRelationRunnable";
    
    private long mUid;
    
    public SingleRelationRunnable(long param1Long) {
      this.mUid = param1Long;
    }
    
    public void run() {
      long l = this.mUid;
      ModuleChatHttpUtils.getInstance().getChatRelationData(new BluedUIHttpResponse<BluedEntity<SessionRelationModel, BluedEntityBaseExtra>>() {
            public boolean onUIFailure(int param2Int, String param2String) {
              if (AppInfo.m())
                Logger.b(ChatRelationDataManager.SingleRelationRunnable.this.TAG, new Object[] { "返回关系数据 statusCode:", Integer.valueOf(param2Int), " | errorMessage:", param2String }); 
              return super.onUIFailure(param2Int, param2String);
            }
            
            public void onUIUpdate(BluedEntity<SessionRelationModel, BluedEntityBaseExtra> param2BluedEntity) {
              if (AppInfo.m())
                Logger.b(ChatRelationDataManager.SingleRelationRunnable.this.TAG, new Object[] { "返回关系数据 request()" }); 
              if (param2BluedEntity != null && param2BluedEntity.data != null && param2BluedEntity.data.size() > 0) {
                if (AppInfo.m())
                  Logger.b(ChatRelationDataManager.SingleRelationRunnable.this.TAG, new Object[] { "size:", Integer.valueOf(param2BluedEntity.data.size()) }); 
                for (SessionRelationModel sessionRelationModel : param2BluedEntity.data) {
                  if (AppInfo.m())
                    Logger.b(ChatRelationDataManager.SingleRelationRunnable.this.TAG, new Object[] { "sessionRelationModel:", sessionRelationModel.toString() }); 
                  SessionSetting sessionSetting = SessionDataManager.getInstance().getSSModel((short)2, sessionRelationModel.getUid());
                  if (sessionSetting != null) {
                    sessionSetting.copySessionRelation(sessionRelationModel);
                    if (AppInfo.m())
                      Logger.b(ChatRelationDataManager.SingleRelationRunnable.this.TAG, new Object[] { "sessionSetting:", sessionSetting.toString() }); 
                    if (sessionRelationModel.getDelete() == 1) {
                      SessionDataManager.getInstance().deleteSessionAndChattingWithSetting(sessionSetting.getSessionType(), sessionSetting.getSessionId());
                      ArrayList<Pair> arrayList = new ArrayList();
                      arrayList.add(new Pair(Short.valueOf(sessionSetting.getSessionType()), Long.valueOf(sessionSetting.getSessionId())));
                      ChatRelationDataListenerManager.getInstance().onDeleteSessions((List)arrayList);
                    } else {
                      SessionDataManager.getInstance().updateSessionSetting(sessionSetting);
                    } 
                    if (sessionSetting.getSessionId() == ChatRelationDataManager.SingleRelationRunnable.this.mUid) {
                      Vector<Pair> vector = new Vector();
                      vector.add(new Pair(Long.valueOf(sessionSetting.getSessionId()), Integer.valueOf(sessionSetting.getOnline())));
                      SessionDataManager.getInstance().updateOnLineState((List)vector);
                    } 
                    continue;
                  } 
                  if (AppInfo.m())
                    Logger.b(ChatRelationDataManager.SingleRelationRunnable.this.TAG, new Object[] { "sessionSetting == null !!!" }); 
                } 
              } 
            }
          }new Long[] { Long.valueOf(l) });
    }
  }
  
  class null extends BluedUIHttpResponse<BluedEntity<SessionRelationModel, BluedEntityBaseExtra>> {
    public boolean onUIFailure(int param1Int, String param1String) {
      if (AppInfo.m())
        Logger.b(this.this$0.TAG, new Object[] { "返回关系数据 statusCode:", Integer.valueOf(param1Int), " | errorMessage:", param1String }); 
      return super.onUIFailure(param1Int, param1String);
    }
    
    public void onUIUpdate(BluedEntity<SessionRelationModel, BluedEntityBaseExtra> param1BluedEntity) {
      if (AppInfo.m())
        Logger.b(this.this$0.TAG, new Object[] { "返回关系数据 request()" }); 
      if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
        if (AppInfo.m())
          Logger.b(this.this$0.TAG, new Object[] { "size:", Integer.valueOf(param1BluedEntity.data.size()) }); 
        for (SessionRelationModel sessionRelationModel : param1BluedEntity.data) {
          if (AppInfo.m())
            Logger.b(this.this$0.TAG, new Object[] { "sessionRelationModel:", sessionRelationModel.toString() }); 
          SessionSetting sessionSetting = SessionDataManager.getInstance().getSSModel((short)2, sessionRelationModel.getUid());
          if (sessionSetting != null) {
            sessionSetting.copySessionRelation(sessionRelationModel);
            if (AppInfo.m())
              Logger.b(this.this$0.TAG, new Object[] { "sessionSetting:", sessionSetting.toString() }); 
            if (sessionRelationModel.getDelete() == 1) {
              SessionDataManager.getInstance().deleteSessionAndChattingWithSetting(sessionSetting.getSessionType(), sessionSetting.getSessionId());
              ArrayList<Pair> arrayList = new ArrayList();
              arrayList.add(new Pair(Short.valueOf(sessionSetting.getSessionType()), Long.valueOf(sessionSetting.getSessionId())));
              ChatRelationDataListenerManager.getInstance().onDeleteSessions((List)arrayList);
            } else {
              SessionDataManager.getInstance().updateSessionSetting(sessionSetting);
            } 
            if (sessionSetting.getSessionId() == this.this$0.mUid) {
              Vector<Pair> vector = new Vector();
              vector.add(new Pair(Long.valueOf(sessionSetting.getSessionId()), Integer.valueOf(sessionSetting.getOnline())));
              SessionDataManager.getInstance().updateOnLineState((List)vector);
            } 
            continue;
          } 
          if (AppInfo.m())
            Logger.b(this.this$0.TAG, new Object[] { "sessionSetting == null !!!" }); 
        } 
      } 
    }
  }
  
  public static interface UpdateRelationCallback {
    void finish(int param1Int, String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\manager\ChatRelationDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */