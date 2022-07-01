package com.blued.android.module.chat.manager;

import android.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.StableSessionListListener;
import com.blued.android.module.chat.contract.FilterSessionListListener;
import com.blued.android.module.chat.db.SessionSettingDBOper;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.chat.utils.FilterTools;
import com.blued.android.module.chat.utils.ListUtils;
import com.blued.android.module.chat.utils.PreferencesUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class SessionDataManager extends StableSessionListListener {
  private static String TAG = "@@@ module_chat_SessionDataManager";
  
  private static SessionDataManager instance;
  
  private List<Long> allPrivateUids = new Vector<Long>();
  
  private Map<String, SessionSetting> allSSModels = new ConcurrentHashMap<String, SessionSetting>();
  
  private Map<String, SessionModel> filterExceptHasNoReadList = new ConcurrentHashMap<String, SessionModel>();
  
  private Map<String, SessionModel> filterSessionModels = new ConcurrentHashMap<String, SessionModel>();
  
  private volatile boolean isRegistSessionListListener = false;
  
  private List<FilterSessionListListener> listeners = new Vector<FilterSessionListListener>();
  
  private SessionSettingDBOper mDBOper;
  
  private void addPrivateUid(long paramLong) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "addPrivateUid() | 已缓存的UID:", this.allPrivateUids.toString() }); 
    if (!this.allPrivateUids.contains(Long.valueOf(paramLong))) {
      this.allPrivateUids.add(0, Long.valueOf(paramLong));
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "缓存UID：", Long.valueOf(paramLong) }); 
    } 
  }
  
  private void checkFilterExceptNoReadList(String paramString, SessionModel paramSessionModel) {
    if (paramSessionModel != null) {
      if (AppInfo.m()) {
        Logger.a(TAG, new Object[] { "checkFilterExceptNoReadList() | sessionKey:", paramString });
        Logger.a(TAG, new Object[] { "checkFilterExceptNoReadList() | SessionModel:", paramSessionModel.toString() });
      } 
      if (paramSessionModel.noReadMsgCount > 0) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "添加到未读消息列表!!! | sessionKey:", paramString }); 
        this.filterExceptHasNoReadList.put(paramString, paramSessionModel);
        return;
      } 
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "未读消息数小于等于0 | sessionKey:", paramString }); 
      if (this.filterExceptHasNoReadList.containsKey(paramString)) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "未读消息列表中包含,并从列表中移除 | sessionKey:", paramString }); 
        this.filterExceptHasNoReadList.remove(paramString);
      } 
    } 
  }
  
  private void checkFilterList(SessionSetting paramSessionSetting) {
    checkFilterList(paramSessionSetting, true);
  }
  
  private void checkFilterList(SessionSetting paramSessionSetting, boolean paramBoolean) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "checkFilterList()" }); 
    if (!MsgFilterManager.getInstance().isFilterSwitchOpen()) {
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "筛选为开关关闭" }); 
      return;
    } 
    if (paramSessionSetting != null) {
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "SessionType : ", Short.valueOf(paramSessionSetting.getSessionType()) }); 
      if (paramSessionSetting.getSessionType() == 2) {
        String str = SessionHeader.getSessionKey(paramSessionSetting.getSessionType(), paramSessionSetting.getSessionId());
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "sessionKey:", str }); 
        SessionModel sessionModel = ChatManager.getInstance().getSnapSessionModel(paramSessionSetting.getSessionType(), paramSessionSetting.getSessionId());
        if (sessionModel != null) {
          if (FilterTools.checkCondition(paramSessionSetting, PreferencesUtils.getInitiatorSwitch(), PreferencesUtils.getFollowerSwitch(), PreferencesUtils.getNearbySwitch())) {
            addFilterSessionModel(sessionModel, paramBoolean);
          } else {
            deleteFilterSessionModels(paramSessionSetting.getSessionType(), paramSessionSetting.getSessionId(), paramBoolean);
          } 
          checkFilterExceptNoReadList(str, sessionModel);
          return;
        } 
        if (AppInfo.m()) {
          Logger.a(TAG, new Object[] { "SessionModel == null !!!" });
          return;
        } 
      } 
    } else if (AppInfo.m()) {
      Logger.a(TAG, new Object[] { "checkFilterList() | ssm == null !!!" });
    } 
  }
  
  private void checkFilterList(short paramShort, long paramLong) {
    checkFilterList(getSSModel(paramShort, paramLong), true);
  }
  
  private void checkFilterList(short paramShort, long paramLong, boolean paramBoolean) {
    checkFilterList(getSSModel(paramShort, paramLong), paramBoolean);
  }
  
  private void clearPrivateUids() {
    this.allPrivateUids.clear();
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "clearPrivateUids()" }); 
  }
  
  private void deleteFilterExceptNoReadList(short paramShort, long paramLong) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "deleteFilterExceptNoReadList() | sessionKey:", str }); 
    if (this.filterExceptHasNoReadList.containsKey(str))
      this.filterExceptHasNoReadList.remove(str); 
  }
  
  private void deletePrivateUid(long paramLong) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "deletePrivateUid() | 已缓存的UID：", this.allPrivateUids.toString() }); 
    if (this.allPrivateUids.contains(Long.valueOf(paramLong))) {
      this.allPrivateUids.remove(Long.valueOf(paramLong));
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "移除UID：", Long.valueOf(paramLong) }); 
    } 
  }
  
  public static SessionDataManager getInstance() {
    if (instance == null)
      instance = new SessionDataManager(); 
    return instance;
  }
  
  private void removeSSModel(short paramShort, long paramLong) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "removeSSModel() | sessionKey:", str }); 
    if (this.allSSModels.containsKey(str)) {
      this.allSSModels.remove(str);
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "allSSModels中包含:", str, ",并且移除" }); 
    } 
    deleteFilterExceptNoReadList(paramShort, paramLong);
    if (paramShort == 2) {
      deletePrivateUid(paramLong);
      deleteFilterSessionModels(paramShort, paramLong, true);
    } 
  }
  
  private void setAllPrivateUids(List<Long> paramList) {
    clearPrivateUids();
    this.allPrivateUids.addAll(paramList);
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "setAllPrivateUids() | privateUids:", this.allPrivateUids.toString() }); 
  }
  
  private void updateAllSSModel(Map<String, Object> paramMap) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "updateAllSSModel(keyValues)" }); 
    for (SessionSetting sessionSetting : this.allSSModels.values()) {
      if (sessionSetting != null) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "updateAllSSModel(keyValues) | befor:", sessionSetting.toString() }); 
        sessionSetting.updateValues(paramMap);
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "updateAllSSModel(keyValues) | after:", sessionSetting.toString() }); 
        checkFilterList(sessionSetting, false);
      } 
    } 
    notifySessionListChanged();
  }
  
  private void updateSSModel(SessionSetting paramSessionSetting) {
    if (paramSessionSetting != null)
      updateSSModel(paramSessionSetting.getSessionType(), paramSessionSetting.getSessionId(), paramSessionSetting); 
  }
  
  private void updateSSModel(short paramShort, long paramLong, SessionSetting paramSessionSetting) {
    if (paramSessionSetting != null) {
      String str = SessionHeader.getSessionKey(paramShort, paramLong);
      if (AppInfo.m()) {
        Logger.a(TAG, new Object[] { "updateSSModel(ss) | sessionKey:", str });
        Logger.a(TAG, new Object[] { "updateSSModel(ss) | SessionSetting:", paramSessionSetting.toString() });
      } 
      this.allSSModels.put(str, paramSessionSetting);
      checkFilterList(paramSessionSetting);
    } 
  }
  
  private void updateSSModel(short paramShort, long paramLong, Map<String, Object> paramMap) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    if (AppInfo.m()) {
      Logger.a(TAG, new Object[] { "updateSSModel(keyValues) | sessionKey:", str });
      Logger.a(TAG, new Object[] { "updateSSModel(keyValues) | keyValues", paramMap.toString() });
    } 
    SessionSetting sessionSetting = this.allSSModels.get(str);
    if (sessionSetting != null) {
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "updateSSModel(keyValues) | befor:", sessionSetting.toString() }); 
      sessionSetting.updateValues(paramMap);
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "updateSSModel(keyValues) | after:", sessionSetting.toString() }); 
      checkFilterList(paramShort, paramLong);
      return;
    } 
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "updateSSModel(keyValues) | SessionSetting == null !!!" }); 
  }
  
  public void addFilterSessionModel(SessionModel paramSessionModel) {
    addFilterSessionModel(paramSessionModel, true);
  }
  
  public void addFilterSessionModel(SessionModel paramSessionModel, boolean paramBoolean) {
    if (paramSessionModel != null) {
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "addFilterSessionModel()  SessionModel:", paramSessionModel.toString() }); 
      String str = SessionHeader.getSessionKey(paramSessionModel.sessionType, paramSessionModel.sessionId);
      if (!this.filterSessionModels.containsKey(str)) {
        if (AppInfo.m()) {
          String str1 = TAG;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("筛选集合中不包含，添加到筛选集合中:");
          stringBuilder.append(str);
          Logger.a(str1, new Object[] { stringBuilder.toString() });
        } 
        this.filterSessionModels.put(str, paramSessionModel);
        if (paramBoolean) {
          notifySessionListChanged();
          return;
        } 
      } else if (AppInfo.m()) {
        Logger.a(TAG, new Object[] { "筛选集合包含:", str, " ！！！" });
      } 
    } 
  }
  
  public void addFilterSessionModel(short paramShort, long paramLong) {
    addFilterSessionModel(paramShort, paramLong, true);
  }
  
  public void addFilterSessionModel(short paramShort, long paramLong, boolean paramBoolean) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "addFilterSessionModel() sessionType:", Short.valueOf(paramShort), " | sessionId:", Long.valueOf(paramLong) }); 
    addFilterSessionModel(ChatManager.getInstance().getSnapSessionModel(paramShort, paramLong), paramBoolean);
  }
  
  public void clearFilterSessionModel(boolean paramBoolean) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "clearFilterSessionModel()" }); 
    this.filterSessionModels.clear();
    if (paramBoolean)
      notifySessionListChanged(); 
  }
  
  public SessionSetting createSessionSetting(short paramShort, long paramLong, SessionSetting paramSessionSetting) {
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      paramSessionSetting = sessionSettingDBOper.createSessionSetting(paramShort, paramLong, paramSessionSetting);
      if (paramSessionSetting != null) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "createSessionSetting(ss) | ", paramSessionSetting.toString() }); 
        updateSSModel(paramSessionSetting);
        return paramSessionSetting;
      } 
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "createSessionSetting(ss) 失败 ！！！" }); 
      return paramSessionSetting;
    } 
    return null;
  }
  
  public int deleteAllSessionSetting() {
    byte b;
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      int i = sessionSettingDBOper.deleteAllSessionSetting();
      b = i;
      if (i > 0) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "deleteAllSessionSetting() | result:", Integer.valueOf(i) }); 
        this.allSSModels.clear();
        clearPrivateUids();
        clearFilterSessionModel(true);
        return i;
      } 
    } else {
      b = -1;
    } 
    return b;
  }
  
  public void deleteFilterSessionModels(short paramShort, long paramLong) {
    deleteFilterSessionModels(paramShort, paramLong, true);
  }
  
  public void deleteFilterSessionModels(short paramShort, long paramLong, boolean paramBoolean) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "deleteFilterSessionModels()  sessionKey:", str }); 
    if (this.filterSessionModels.containsKey(str)) {
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "deleteFilterSessionModels() 筛选列表中包含:", str }); 
      this.filterSessionModels.remove(str);
      if (paramBoolean) {
        notifySessionListChanged();
        return;
      } 
    } else if (AppInfo.m()) {
      Logger.a(TAG, new Object[] { "deleteFilterSessionModels() 筛选列表中不包含: ", str, " ！！！！" });
    } 
  }
  
  public int deleteNoGroupSessionSettingModel(short paramShort, long paramLong) {
    byte b;
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      int i = sessionSettingDBOper.deleteNoGroupSessionSetting(paramShort, paramLong);
      b = i;
      if (i > 0) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "deleteNoGroupSessionSettingModel() | sessionType:", Short.valueOf(paramShort), " | sessionId:", Long.valueOf(paramLong) }); 
        removeSSModel(paramShort, paramLong);
        return i;
      } 
    } else {
      b = -1;
    } 
    return b;
  }
  
  public void deleteSessionAndChattingWithSetting(List<Pair<Short, Long>> paramList) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "deleteSessionAndChattingWithSetting()" }); 
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null)
      sessionSettingDBOper.deleteSessionAndChattingWithSetting(paramList); 
  }
  
  public void deleteSessionAndChattingWithSetting(short paramShort, long paramLong) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "deleteSessionAndChattingWithSetting() | sessionType:", Short.valueOf(paramShort), " | sessionId:", Long.valueOf(paramLong) }); 
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null)
      sessionSettingDBOper.deleteSessionAndChattingWithSetting(paramShort, paramLong); 
  }
  
  public void deleteSessionForAll() {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "deleteSessionForAll()" }); 
    clearPrivateUids();
    this.filterExceptHasNoReadList.clear();
    clearFilterSessionModel(true);
  }
  
  public void deleteSessionForOne(short paramShort, long paramLong) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "deleteSessionForOne() | sessionType:", Short.valueOf(paramShort), " | sessionId:", Long.valueOf(paramLong) }); 
    deleteFilterExceptNoReadList(paramShort, paramLong);
    if (paramShort == 2) {
      deletePrivateUid(paramLong);
      deleteFilterSessionModels(paramShort, paramLong);
    } 
  }
  
  public int deleteSessionSettingModel(short paramShort, long paramLong) {
    byte b;
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      int i = sessionSettingDBOper.deleteSessionSetting(paramShort, paramLong);
      b = i;
      if (i > 0) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "deleteSessionSettingModel() | sessionType:", Short.valueOf(paramShort), " | sessionId:", Long.valueOf(paramLong) }); 
        removeSSModel(paramShort, paramLong);
        return i;
      } 
    } else {
      b = -1;
    } 
    return b;
  }
  
  public List<Long> getAllUids() {
    Vector<Long> vector = new Vector();
    vector.addAll(this.allPrivateUids);
    return vector;
  }
  
  public SessionSetting getOneSessionSetting(short paramShort, long paramLong) {
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      SessionSetting sessionSetting = sessionSettingDBOper.getOneSessionSetting(paramShort, paramLong);
      if (sessionSetting != null) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "getOneSessionSetting() | ", sessionSetting.toString() }); 
        updateSSModel(paramShort, paramLong, sessionSetting);
        return sessionSetting;
      } 
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "getOneSessionSetting() | SessionSetting == null ！！！" }); 
      return sessionSetting;
    } 
    return null;
  }
  
  public SessionSetting getSSModel(String paramString) {
    return this.allSSModels.get(paramString);
  }
  
  public SessionSetting getSSModel(short paramShort, long paramLong) {
    String str = SessionHeader.getSessionKey(paramShort, paramLong);
    return this.allSSModels.get(str);
  }
  
  public Map<String, SessionSetting> getSessionSettingMap() {
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      Map<String, SessionSetting> map = sessionSettingDBOper.getSessionSettingMap();
      for (SessionSetting sessionSetting : map.values()) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "获取SessionSetting() | ", sessionSetting.toString() }); 
        updateSSModel(sessionSetting);
      } 
      return map;
    } 
    return null;
  }
  
  public void init(SessionSettingDBOper paramSessionSettingDBOper) {
    this.mDBOper = paramSessionSettingDBOper;
  }
  
  public void notifySessionListChanged() {
    if (MsgFilterManager.getInstance().isFilterSwitchOpen()) {
      final ArrayList copySessionList = new ArrayList();
      final ArrayList copyFilterExceptNoReadSessionList = new ArrayList();
      arrayList1.addAll(this.filterSessionModels.values());
      arrayList2.addAll(this.filterExceptHasNoReadList.values());
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "notifySessionListChanged(), session size:", Integer.valueOf(arrayList1.size()), ", listener size:", Integer.valueOf(arrayList1.size()) }); 
      AppInfo.n().post(new Runnable() {
            public void run() {
              Iterator<FilterSessionListListener> iterator = SessionDataManager.this.listeners.iterator();
              while (iterator.hasNext())
                ((FilterSessionListListener)iterator.next()).onUISessionDataChanged(copySessionList, copyFilterExceptNoReadSessionList); 
            }
          });
    } 
  }
  
  public void notifySessionListChanged(final FilterSessionListListener listener) {
    if (MsgFilterManager.getInstance().isFilterSwitchOpen()) {
      final ArrayList copySessionList = new ArrayList();
      final ArrayList copyFilterExceptNoReadSessionList = new ArrayList();
      arrayList1.addAll(this.filterSessionModels.values());
      arrayList2.addAll(this.filterExceptHasNoReadList.values());
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "notifySessionListChanged(), session size:", Integer.valueOf(arrayList1.size()), ", listener size:", Integer.valueOf(arrayList1.size()) }); 
      AppInfo.n().post(new Runnable() {
            public void run() {
              listener.onUISessionDataChanged(copySessionList, copyFilterExceptNoReadSessionList);
            }
          });
    } 
  }
  
  public void onUISessionDataChanged(List<SessionModel> paramList) {
    if (MsgFilterManager.getInstance().isFilterSwitchOpen()) {
      if (PreferencesUtils.getUpdateFinish()) {
        this.filterExceptHasNoReadList.clear();
        this.filterSessionModels.clear();
        boolean bool1 = PreferencesUtils.getInitiatorSwitch();
        boolean bool2 = PreferencesUtils.getFollowerSwitch();
        boolean bool3 = PreferencesUtils.getNearbySwitch();
        for (SessionModel sessionModel : paramList) {
          String str = SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId);
          if (FilterTools.checkCondition(getSSModel(str), bool1, bool2, bool3)) {
            this.filterSessionModels.put(str, sessionModel);
            continue;
          } 
          if (sessionModel.noReadMsgCount > 0)
            this.filterExceptHasNoReadList.put(str, sessionModel); 
        } 
        notifySessionListChanged();
        return;
      } 
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "onUISessionDataChanged(), 没有更新过关系数据，走更新关系数据逻辑" }); 
      ChatRelationDataManager.getInstance().updateRelationData(new ChatRelationDataManager.UpdateRelationCallback() {
            public void finish(int param1Int, String param1String) {
              if (param1Int == 200) {
                if (AppInfo.m())
                  Logger.a(SessionDataManager.TAG, new Object[] { "onUISessionDataChanged(), 更新关系成功,主动筛选" }); 
                MsgFilterManager.getInstance().filterData();
              } 
            }
          });
    } 
  }
  
  public void registerFilterSessionListListener(FilterSessionListListener paramFilterSessionListListener) {
    if (!this.listeners.contains(paramFilterSessionListListener)) {
      this.listeners.add(paramFilterSessionListListener);
      notifySessionListChanged(paramFilterSessionListListener);
    } 
    if (!this.isRegistSessionListListener) {
      this.isRegistSessionListListener = true;
      ChatManager.getInstance().registerSessionListener((SessionListener)this);
    } 
  }
  
  public void saveSession(SessionModel paramSessionModel) {
    if (paramSessionModel != null) {
      if (paramSessionModel.sessionType == 2) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "saveSession(session) | ", paramSessionModel.toString() }); 
        addPrivateUid(paramSessionModel.sessionId);
        ChatRelationDataManager.getInstance().updateRelationData(paramSessionModel);
        return;
      } 
    } else if (AppInfo.m()) {
      Logger.a(TAG, new Object[] { "saveSession(session) | session == null !!! " });
    } 
  }
  
  public void setSessionList(List<SessionModel> paramList) {
    if (paramList == null) {
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "setSessionList() | sessionList == null !!!" }); 
      return;
    } 
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "setSessionList() | sessionList.size(): ", Integer.valueOf(paramList.size()) }); 
    if (paramList.size() > 0) {
      ArrayList<SessionModel> arrayList = new ArrayList();
      arrayList.addAll(paramList);
      ListUtils.sortSessionModelList(arrayList);
      paramList = new ArrayList<SessionModel>();
      for (SessionModel sessionModel : arrayList) {
        if (sessionModel.sessionType == 2)
          paramList.add(Long.valueOf(sessionModel.sessionId)); 
      } 
      setAllPrivateUids((List)paramList);
    } 
  }
  
  public void unRegisterFilterSessionListListener(FilterSessionListListener paramFilterSessionListListener) {
    if (this.listeners.contains(paramFilterSessionListListener))
      this.listeners.remove(paramFilterSessionListListener); 
  }
  
  public void unRegisterSessionListener() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield isRegistSessionListListener : Z
    //   6: ifeq -> 21
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield isRegistSessionListListener : Z
    //   14: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   17: aload_0
    //   18: invokevirtual unregisterSessionListener : (Lcom/blued/android/chat/listener/SessionListener;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	24	finally
  }
  
  public int updataSessionSetting(short paramShort, long paramLong, SessionSetting paramSessionSetting) {
    byte b;
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      int i = sessionSettingDBOper.updataSessionSetting(paramSessionSetting);
      b = i;
      if (i > 0) {
        if (AppInfo.m()) {
          String str = TAG;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("updataSessionSetting(ss) | ");
          stringBuilder.append(paramSessionSetting.toString());
          Logger.a(str, new Object[] { stringBuilder.toString() });
        } 
        updateSSModel(paramShort, paramLong, paramSessionSetting);
        return i;
      } 
    } else {
      b = -1;
    } 
    return b;
  }
  
  public int updateAllSessionSetting(Map<String, Object> paramMap) {
    byte b;
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      int i = sessionSettingDBOper.updateAllSessionSetting(paramMap);
      b = i;
      if (i > 0) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "updateAllSessionSetting(keyValues) | ", paramMap.toString() }); 
        updateAllSSModel(paramMap);
        return i;
      } 
    } else {
      b = -1;
    } 
    return b;
  }
  
  public void updateFollower(long paramLong, int paramInt) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "updateFollower() | uid:", Long.valueOf(paramLong), " | follower:", Integer.valueOf(paramInt) }); 
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null)
      sessionSettingDBOper.updateFollower(paramLong, paramInt); 
  }
  
  public void updateOnLineState(List<Pair<Long, Integer>> paramList) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "updateOnLineState() | onlineStatusPairs:", paramList.toString() }); 
    ChatManager.getInstance().updateSessionOnLineState(paramList);
  }
  
  public void updateRelationSessionSettingList(List<SessionSetting> paramList) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "updateRelationSessionSettingList" }); 
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null)
      sessionSettingDBOper.updateRelationSessionSettingList(paramList); 
  }
  
  public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> paramList) {
    byte b;
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      b = sessionSettingDBOper.updateRelationSessionSettingListDb(paramList);
    } else {
      b = -1;
    } 
    if (AppInfo.m()) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateRelationSessionSettingListDb  result: ");
      stringBuilder.append(b);
      Logger.a(str, new Object[] { stringBuilder.toString() });
    } 
    return b;
  }
  
  public void updateSession(SessionModel paramSessionModel) {
    if (paramSessionModel == null) {
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "updateSession(session) | session == null !!!" }); 
      return;
    } 
    if (paramSessionModel.sessionType == 2) {
      if (AppInfo.m())
        Logger.a(TAG, new Object[] { "updateSession(session) | ", paramSessionModel.toString() }); 
      addPrivateUid(paramSessionModel.sessionId);
    } 
  }
  
  public int updateSessionSetting(short paramShort, long paramLong, Map<String, Object> paramMap) {
    byte b;
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null) {
      int i = sessionSettingDBOper.updateSessionSetting(paramShort, paramLong, paramMap);
      b = i;
      if (i > 0) {
        if (AppInfo.m())
          Logger.a(TAG, new Object[] { "updateSessionSetting(keyValues) | ", paramMap.toString() }); 
        updateSSModel(paramShort, paramLong, paramMap);
        return i;
      } 
    } else {
      b = -1;
    } 
    return b;
  }
  
  public void updateSessionSetting(SessionSetting paramSessionSetting) {
    if (AppInfo.m())
      Logger.a(TAG, new Object[] { "updateSessionSetting() | SessionSetting:", paramSessionSetting.toString() }); 
    SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
    if (sessionSettingDBOper != null)
      sessionSettingDBOper.updateSessionSetting(paramSessionSetting); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\manager\SessionDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */