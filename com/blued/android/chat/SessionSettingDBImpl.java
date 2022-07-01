package com.blued.android.chat;

import android.util.Pair;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.module.chat.db.SessionSettingDBOper;
import com.blued.android.module.chat.model.SessionSetting;
import com.soft.blued.db.SessionSettingDao;
import com.soft.blued.db.model.SessionSettingModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SessionSettingDBImpl implements SessionSettingDBOper {
  public static final String TAG = "SS_DB";
  
  public SessionSetting createSessionSetting(short paramShort, long paramLong, SessionSetting paramSessionSetting) {
    SessionSettingModel sessionSettingModel;
    if (paramSessionSetting == null) {
      sessionSettingModel = new SessionSettingModel();
      sessionSettingModel.setSessionType(paramShort);
      sessionSettingModel.setSessionId(paramLong);
    } else {
      sessionSettingModel = DataTransform.transform((SessionSetting)sessionSettingModel);
    } 
    return DataTransform.transform(SessionSettingDao.a().a(sessionSettingModel));
  }
  
  public int deleteAllSessionSetting() {
    return SessionSettingDao.a().d();
  }
  
  public int deleteNoGroupSessionSetting(short paramShort, long paramLong) {
    return SessionSettingDao.a().a(paramShort, paramLong);
  }
  
  public void deleteSessionAndChattingWithSetting(List<Pair<Short, Long>> paramList) {
    ChatManager.getInstance().deleteSessionAndChattingWithSetting(paramList);
  }
  
  public void deleteSessionAndChattingWithSetting(short paramShort, long paramLong) {
    ChatManager.getInstance().deleteSessionAndChattingWithSetting(Short.valueOf(paramShort), paramLong);
  }
  
  public int deleteSessionSetting(short paramShort, long paramLong) {
    return SessionSettingDao.a().b(paramShort, paramLong);
  }
  
  public SessionSetting getOneSessionSetting(short paramShort, long paramLong) {
    return DataTransform.transform(SessionSettingDao.a().a(paramShort, paramLong));
  }
  
  public Map<String, SessionSetting> getSessionSettingMap() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Map map = SessionSettingDao.a().c();
    if (map != null)
      for (Map.Entry entry : map.entrySet())
        hashMap.put(entry.getKey(), DataTransform.transform((SessionSettingModel)entry.getValue()));  
    return (Map)hashMap;
  }
  
  public int updataSessionSetting(SessionSetting paramSessionSetting) {
    SessionSettingModel sessionSettingModel = DataTransform.transform(paramSessionSetting);
    return SessionSettingDao.a().b(sessionSettingModel);
  }
  
  public int updateAllSessionSetting(Map<String, Object> paramMap) {
    return SessionSettingDao.a().a(paramMap);
  }
  
  public void updateFollower(long paramLong, int paramInt) {
    if (ChatManager.getInstance().getSnapSessionModel((short)2, paramLong) != null) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("follower", Integer.valueOf(paramInt));
      ChatManager.getInstance().updateSessionSetting((short)2, paramLong, (Map)hashMap);
    } 
  }
  
  public void updateRelationSessionSettingList(List<SessionSetting> paramList) {
    for (SessionSetting sessionSetting : paramList) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("nearby", Integer.valueOf(sessionSetting.getNearby()));
      hashMap.put("online", Integer.valueOf(sessionSetting.getOnline()));
      hashMap.put("follower", Integer.valueOf(sessionSetting.getFollower()));
      hashMap.put("initiator", Integer.valueOf(sessionSetting.getInitiator()));
      ChatManager.getInstance().updateRelationSessionSetting(sessionSetting.getSessionType(), sessionSetting.getSessionId(), (Map)hashMap);
    } 
    ArrayList<SessionSettingModel> arrayList = new ArrayList();
    Iterator<SessionSetting> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(DataTransform.transform(iterator.next())); 
    ChatManager.getInstance().updateRelationSessionSettingListDb((List)arrayList);
  }
  
  public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> paramList) {
    return SessionSettingDao.a().a(paramList);
  }
  
  public int updateSessionSetting(short paramShort, long paramLong, Map<String, Object> paramMap) {
    return SessionSettingDao.a().a(paramShort, paramLong, paramMap);
  }
  
  public void updateSessionSetting(SessionSetting paramSessionSetting) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("nearby", Integer.valueOf(paramSessionSetting.getNearby()));
    hashMap.put("online", Integer.valueOf(paramSessionSetting.getOnline()));
    hashMap.put("follower", Integer.valueOf(paramSessionSetting.getFollower()));
    hashMap.put("initiator", Integer.valueOf(paramSessionSetting.getInitiator()));
    ChatManager.getInstance().updateSessionSetting(paramSessionSetting.getSessionType(), paramSessionSetting.getSessionId(), (Map)hashMap);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\SessionSettingDBImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */