package com.blued.android.chat;

import android.database.sqlite.SQLiteDatabase;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.module.chat.ModuleChatConfig;
import com.blued.android.module.chat.manager.SessionDataManager;
import com.blued.android.module.chat.model.SessionSetting;
import com.soft.blued.db.BluedBaseDataHelper;
import com.soft.blued.db.ChattingDao;
import com.soft.blued.db.SessionDao;
import com.soft.blued.db.model.ChattingModelDB;
import com.soft.blued.db.model.SessionModelDB;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatDBImpl implements DBOper {
  private static final String TAG = "Chat_DB";
  
  public ChatDBImpl() {
    ModuleChatConfig.getInstance().setSessionSettingDBOperImpl(new SessionSettingDBImpl());
  }
  
  public void changeAllMsgType(short paramShort1, short paramShort2) {
    ChattingDao.a().a(paramShort1, paramShort2);
    SessionDao.a().a(paramShort1, paramShort2);
  }
  
  public SessionSettingBaseModel createSessionSetting(short paramShort, long paramLong, SessionSettingBaseModel paramSessionSettingBaseModel) {
    return (SessionSettingBaseModel)DataTransform.transform(SessionDataManager.getInstance().createSessionSetting(paramShort, paramLong, DataTransform.transform(paramSessionSettingBaseModel)));
  }
  
  public void deleteAllSessionSetting() {
    SessionDataManager.getInstance().deleteAllSessionSetting();
  }
  
  public void deleteChattingForAll() {
    ChattingDao.a().d();
  }
  
  public void deleteChattingForOne(int paramInt, long paramLong) {
    ChattingDao.a().b(paramInt, paramLong);
  }
  
  public void deleteNoGroupSessionSetting(short paramShort, long paramLong) {
    SessionDataManager.getInstance().deleteNoGroupSessionSettingModel(paramShort, paramLong);
  }
  
  public void deleteSessionAndChattingForAll() {
    SessionDao.a().d();
    ChattingDao.a().d();
    SessionDataManager.getInstance().deleteSessionForAll();
  }
  
  public void deleteSessionAndChattingForOne(int paramInt, long paramLong) {
    SessionDao.a().a(paramInt, paramLong);
    ChattingDao.a().b(paramInt, paramLong);
    SessionDataManager.getInstance().deleteSessionForOne((short)paramInt, paramLong);
  }
  
  public void deleteSessionForAll() {
    SessionDao.a().d();
    SessionDataManager.getInstance().deleteSessionForAll();
  }
  
  public void deleteSessionForOne(int paramInt, long paramLong) {
    SessionDao.a().a(paramInt, paramLong);
    SessionDataManager.getInstance().deleteSessionForOne((short)paramInt, paramLong);
  }
  
  public void deleteSessionSetting(short paramShort, long paramLong) {
    SessionDataManager.getInstance().deleteSessionSettingModel(paramShort, paramLong);
  }
  
  public void failedAllSendingMsg(long paramLong) {
    SessionDao.a().e();
    ChattingDao.a().c();
  }
  
  public ChattingModel findMsgData(short paramShort, long paramLong1, long paramLong2, long paramLong3) {
    return DataTransform.transform(ChattingDao.a().a(paramShort, paramLong1, paramLong2, paramLong3));
  }
  
  public List<ChattingModel> getMsgList(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, boolean paramBoolean) {
    return paramBoolean ? DataTransform.transformMessage(ChattingDao.a().a(paramInt1, paramLong2, paramLong3, paramLong4, paramLong5, paramInt2)) : DataTransform.transformMessage(ChattingDao.a().b(paramInt1, paramLong2, paramLong3, paramLong4, paramLong5, paramInt2));
  }
  
  public SQLiteDatabase getReadDatabase() {
    return BluedBaseDataHelper.a().getReadableDatabase();
  }
  
  public ChattingModel getSendingMsgData(short paramShort, long paramLong1, long paramLong2) {
    return DataTransform.transform(ChattingDao.a().a(paramLong2, paramShort, paramLong1));
  }
  
  public List<SessionModel> getSessionList() {
    List<SessionModel> list = DataTransform.transformSession(SessionDao.a().c());
    SessionDataManager.getInstance().setSessionList(list);
    return list;
  }
  
  public SessionSettingBaseModel getSessionSetting(short paramShort, long paramLong) {
    return (SessionSettingBaseModel)DataTransform.transform(SessionDataManager.getInstance().getOneSessionSetting(paramShort, paramLong));
  }
  
  public Map<String, SessionSettingBaseModel> getSessionSettingList() {
    Map map = SessionDataManager.getInstance().getSessionSettingMap();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (map != null)
      for (Map.Entry entry : map.entrySet())
        hashMap.put(entry.getKey(), DataTransform.transform((SessionSetting)entry.getValue()));  
    return (Map)hashMap;
  }
  
  public Set<Long> getSessionUnreadedIds(int paramInt, long paramLong1, long paramLong2) {
    return ChattingDao.a().a(paramInt, paramLong1, paramLong2);
  }
  
  public void ignoredNoReadNumAll() {
    SessionDao.a().g();
  }
  
  public void insertChattingData(ChattingModel paramChattingModel) {
    ChattingModelDB chattingModelDB = DataTransform.transform(paramChattingModel);
    if (ChattingDao.a().a(chattingModelDB) > 0)
      paramChattingModel.dbId = chattingModelDB.dbId; 
  }
  
  public void insertMsgList(List<ChattingModel> paramList) {
    if (paramList != null && paramList.size() > 0) {
      Iterator<ChattingModel> iterator = paramList.iterator();
      while (iterator.hasNext())
        insertChattingData(iterator.next()); 
    } 
  }
  
  public int insertMsgListFromBackup(List<ChattingModel> paramList) {
    return ChattingDao.a().a(paramList);
  }
  
  public int insertSessionList(List<SessionModel> paramList) {
    return SessionDao.a().a(paramList);
  }
  
  public void readedAllMsg(short paramShort, long paramLong1, long paramLong2) {
    ChattingDao.a().a(paramShort, paramLong1, paramLong2);
  }
  
  public void saveMessage(ChattingModel paramChattingModel) {
    ChattingDao.a().a(DataTransform.transform(paramChattingModel));
  }
  
  public void saveSession(SessionModel paramSessionModel) {
    SessionModelDB sessionModelDB = DataTransform.transform(paramSessionModel);
    if (SessionDao.a().a(sessionModelDB) > 0) {
      paramSessionModel.dbId = sessionModelDB.dbId;
      SessionDataManager.getInstance().saveSession(paramSessionModel);
    } 
  }
  
  public void updateAllLastMsgContentNull() {
    SessionDao.a().f();
  }
  
  public int updateAllSessionSetting(Map<String, Object> paramMap) {
    return SessionDataManager.getInstance().updateAllSessionSetting(paramMap);
  }
  
  public void updateChattingModel(ChattingModel paramChattingModel) {
    ChattingDao.a().b(DataTransform.transform(paramChattingModel));
  }
  
  public void updateMsgForTextTranslateInit(int paramInt, long paramLong) {
    ChattingDao.a().a(paramInt, paramLong);
  }
  
  public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> paramList) {
    return SessionDataManager.getInstance().updateRelationSessionSettingListDb(paramList);
  }
  
  public int updateSendingMsgId(long paramLong1, int paramInt, long paramLong2, long paramLong3) {
    return ChattingDao.a().a(paramLong1, paramInt, paramLong2, paramLong3);
  }
  
  public void updateSession(SessionModel paramSessionModel) {
    SessionDao.a().b(DataTransform.transform(paramSessionModel));
    SessionDataManager.getInstance().updateSession(paramSessionModel);
  }
  
  public int updateSessionSetting(short paramShort, long paramLong, Map<String, Object> paramMap) {
    return SessionDataManager.getInstance().updateSessionSetting(paramShort, paramLong, paramMap);
  }
  
  public void updateSessionSetting(short paramShort, long paramLong, SessionSettingBaseModel paramSessionSettingBaseModel) {
    SessionDataManager.getInstance().updataSessionSetting(paramShort, paramLong, DataTransform.transform(paramSessionSettingBaseModel));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\ChatDBImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */