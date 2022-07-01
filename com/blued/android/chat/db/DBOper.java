package com.blued.android.chat.db;

import android.database.sqlite.SQLiteDatabase;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DBOper {
  public static final DBOper EmptyDBOper = new DBOper() {
      public void changeAllMsgType(short param1Short1, short param1Short2) {}
      
      public SessionSettingBaseModel createSessionSetting(short param1Short, long param1Long, SessionSettingBaseModel param1SessionSettingBaseModel) {
        return null;
      }
      
      public void deleteAllSessionSetting() {}
      
      public void deleteChattingForAll() {}
      
      public void deleteChattingForOne(int param1Int, long param1Long) {}
      
      public void deleteNoGroupSessionSetting(short param1Short, long param1Long) {}
      
      public void deleteSessionAndChattingForAll() {}
      
      public void deleteSessionAndChattingForOne(int param1Int, long param1Long) {}
      
      public void deleteSessionForAll() {}
      
      public void deleteSessionForOne(int param1Int, long param1Long) {}
      
      public void deleteSessionSetting(short param1Short, long param1Long) {}
      
      public void failedAllSendingMsg(long param1Long) {}
      
      public ChattingModel findMsgData(short param1Short, long param1Long1, long param1Long2, long param1Long3) {
        return null;
      }
      
      public List<ChattingModel> getMsgList(long param1Long1, int param1Int1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, int param1Int2, boolean param1Boolean) {
        return null;
      }
      
      public SQLiteDatabase getReadDatabase() {
        return null;
      }
      
      public ChattingModel getSendingMsgData(short param1Short, long param1Long1, long param1Long2) {
        return null;
      }
      
      public List<SessionModel> getSessionList() {
        return null;
      }
      
      public SessionSettingBaseModel getSessionSetting(short param1Short, long param1Long) {
        return null;
      }
      
      public Map<String, SessionSettingBaseModel> getSessionSettingList() {
        return null;
      }
      
      public Set<Long> getSessionUnreadedIds(int param1Int, long param1Long1, long param1Long2) {
        return null;
      }
      
      public void ignoredNoReadNumAll() {}
      
      public void insertChattingData(ChattingModel param1ChattingModel) {}
      
      public void insertMsgList(List<ChattingModel> param1List) {}
      
      public int insertMsgListFromBackup(List<ChattingModel> param1List) {
        return -1;
      }
      
      public int insertSessionList(List<SessionModel> param1List) {
        return -1;
      }
      
      public void readedAllMsg(short param1Short, long param1Long1, long param1Long2) {}
      
      public void saveSession(SessionModel param1SessionModel) {}
      
      public void updateAllLastMsgContentNull() {}
      
      public int updateAllSessionSetting(Map<String, Object> param1Map) {
        return -1;
      }
      
      public void updateChattingModel(ChattingModel param1ChattingModel) {}
      
      public void updateMsgForTextTranslateInit(int param1Int, long param1Long) {}
      
      public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> param1List) {
        return -1;
      }
      
      public int updateSendingMsgId(long param1Long1, int param1Int, long param1Long2, long param1Long3) {
        return -1;
      }
      
      public void updateSession(SessionModel param1SessionModel) {}
      
      public int updateSessionSetting(short param1Short, long param1Long, Map<String, Object> param1Map) {
        return -1;
      }
      
      public void updateSessionSetting(short param1Short, long param1Long, SessionSettingBaseModel param1SessionSettingBaseModel) {}
    };
  
  void changeAllMsgType(short paramShort1, short paramShort2);
  
  SessionSettingBaseModel createSessionSetting(short paramShort, long paramLong, SessionSettingBaseModel paramSessionSettingBaseModel);
  
  void deleteAllSessionSetting();
  
  void deleteChattingForAll();
  
  void deleteChattingForOne(int paramInt, long paramLong);
  
  void deleteNoGroupSessionSetting(short paramShort, long paramLong);
  
  void deleteSessionAndChattingForAll();
  
  void deleteSessionAndChattingForOne(int paramInt, long paramLong);
  
  void deleteSessionForAll();
  
  void deleteSessionForOne(int paramInt, long paramLong);
  
  void deleteSessionSetting(short paramShort, long paramLong);
  
  void failedAllSendingMsg(long paramLong);
  
  ChattingModel findMsgData(short paramShort, long paramLong1, long paramLong2, long paramLong3);
  
  List<ChattingModel> getMsgList(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, boolean paramBoolean);
  
  SQLiteDatabase getReadDatabase();
  
  ChattingModel getSendingMsgData(short paramShort, long paramLong1, long paramLong2);
  
  List<SessionModel> getSessionList();
  
  SessionSettingBaseModel getSessionSetting(short paramShort, long paramLong);
  
  Map<String, SessionSettingBaseModel> getSessionSettingList();
  
  Set<Long> getSessionUnreadedIds(int paramInt, long paramLong1, long paramLong2);
  
  void ignoredNoReadNumAll();
  
  void insertChattingData(ChattingModel paramChattingModel);
  
  void insertMsgList(List<ChattingModel> paramList);
  
  int insertMsgListFromBackup(List<ChattingModel> paramList);
  
  int insertSessionList(List<SessionModel> paramList);
  
  void readedAllMsg(short paramShort, long paramLong1, long paramLong2);
  
  void saveSession(SessionModel paramSessionModel);
  
  void updateAllLastMsgContentNull();
  
  int updateAllSessionSetting(Map<String, Object> paramMap);
  
  void updateChattingModel(ChattingModel paramChattingModel);
  
  void updateMsgForTextTranslateInit(int paramInt, long paramLong);
  
  int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> paramList);
  
  int updateSendingMsgId(long paramLong1, int paramInt, long paramLong2, long paramLong3);
  
  void updateSession(SessionModel paramSessionModel);
  
  int updateSessionSetting(short paramShort, long paramLong, Map<String, Object> paramMap);
  
  void updateSessionSetting(short paramShort, long paramLong, SessionSettingBaseModel paramSessionSettingBaseModel);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\db\DBOper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */