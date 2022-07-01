package com.blued.android.module.chat.db;

import android.util.Pair;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.module.chat.model.SessionSetting;
import java.util.List;
import java.util.Map;

public interface SessionSettingDBOper {
  SessionSetting createSessionSetting(short paramShort, long paramLong, SessionSetting paramSessionSetting);
  
  int deleteAllSessionSetting();
  
  int deleteNoGroupSessionSetting(short paramShort, long paramLong);
  
  void deleteSessionAndChattingWithSetting(List<Pair<Short, Long>> paramList);
  
  void deleteSessionAndChattingWithSetting(short paramShort, long paramLong);
  
  int deleteSessionSetting(short paramShort, long paramLong);
  
  SessionSetting getOneSessionSetting(short paramShort, long paramLong);
  
  Map<String, SessionSetting> getSessionSettingMap();
  
  int updataSessionSetting(SessionSetting paramSessionSetting);
  
  int updateAllSessionSetting(Map<String, Object> paramMap);
  
  void updateFollower(long paramLong, int paramInt);
  
  void updateRelationSessionSettingList(List<SessionSetting> paramList);
  
  int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> paramList);
  
  int updateSessionSetting(short paramShort, long paramLong, Map<String, Object> paramMap);
  
  void updateSessionSetting(SessionSetting paramSessionSetting);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\db\SessionSettingDBOper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */