package com.soft.blued.db;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.user.UserInfo;
import java.util.List;
import java.util.Map;

public class SessionSettingDao {
  public static String a = "SessionSettingDao";
  
  private static SessionSettingDao b;
  
  private Dao<SessionSettingModel, Integer> c;
  
  public static SessionSettingDao a() {
    // Byte code:
    //   0: getstatic com/soft/blued/db/SessionSettingDao.b : Lcom/soft/blued/db/SessionSettingDao;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/db/SessionSettingDao
    //   8: monitorenter
    //   9: getstatic com/soft/blued/db/SessionSettingDao.b : Lcom/soft/blued/db/SessionSettingDao;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/db/SessionSettingDao
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/db/SessionSettingDao.b : Lcom/soft/blued/db/SessionSettingDao;
    //   25: ldc com/soft/blued/db/SessionSettingDao
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/db/SessionSettingDao
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/db/SessionSettingDao.b : Lcom/soft/blued/db/SessionSettingDao;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public int a(List<SessionSettingBaseModel> paramList) {
    try {
      this.c.callBatchTasks(new -$$Lambda$SessionSettingDao$kyRcrpHgs5L6WGO9Kc-UCY3JExY(this, paramList));
      return 1;
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int a(Map<String, Object> paramMap) {
    if (paramMap != null)
      try {
        UpdateBuilder updateBuilder = b().updateBuilder();
        updateBuilder.where().and().eq("loadName", UserInfo.a().i().getUid());
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
          String str = (String)entry.getKey();
          if (!TextUtils.isEmpty(str))
            updateBuilder.updateColumnValue(str, entry.getValue()); 
        } 
        return updateBuilder.update();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return -1;
  }
  
  public int a(short paramShort, long paramLong) {
    try {
      DeleteBuilder deleteBuilder = b().deleteBuilder();
      deleteBuilder.where().eq("loadName", UserInfo.a().i().getUid()).and().eq("sessionId", Long.valueOf(paramLong)).and().eq("sessionType", Short.valueOf(paramShort)).and().ne("sessionType", Short.valueOf((short)3)).and().ne("sessionType", Short.valueOf((short)1)).and().ne("sessionId", Integer.valueOf(2)).and().isNull("chatBgUri");
      return deleteBuilder.delete();
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int a(short paramShort, long paramLong, Map<String, Object> paramMap) {
    if (paramMap != null) {
      try {
        if (a(paramShort, paramLong) == null) {
          SessionSettingModel sessionSettingModel = new SessionSettingModel();
          sessionSettingModel.setSessionType(paramShort);
          sessionSettingModel.setSessionId(paramLong);
          sessionSettingModel.updateValues(paramMap);
          if (a(sessionSettingModel) != null)
            return 1; 
        } else {
          UpdateBuilder updateBuilder = b().updateBuilder();
          updateBuilder.where().eq("sessionType", Short.valueOf(paramShort)).and().eq("sessionId", Long.valueOf(paramLong)).and().eq("loadName", UserInfo.a().i().getUid());
          for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            String str = (String)entry.getKey();
            if (!TextUtils.isEmpty(str))
              updateBuilder.updateColumnValue(str, entry.getValue()); 
          } 
          return updateBuilder.update();
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        return -1;
      } 
    } else {
      return -1;
    } 
    return -1;
  }
  
  public SessionSettingModel a(int paramInt, long paramLong) {
    try {
      List<SessionSettingModel> list = b().queryBuilder().where().eq("sessionType", Integer.valueOf(paramInt)).and().eq("sessionId", Long.valueOf(paramLong)).and().eq("loadName", UserInfo.a().i().getUid()).query();
      return (list.size() > 0) ? list.get(0) : null;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public SessionSettingModel a(SessionSettingModel paramSessionSettingModel) {
    if (paramSessionSettingModel != null)
      try {
        paramSessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
        b().create(paramSessionSettingModel);
        return paramSessionSettingModel;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return null;
  }
  
  public int b(SessionSettingModel paramSessionSettingModel) {
    if (paramSessionSettingModel != null)
      try {
        paramSessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
        return b().update(paramSessionSettingModel);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return -1;
  }
  
  public int b(short paramShort, long paramLong) {
    try {
      DeleteBuilder deleteBuilder = b().deleteBuilder();
      deleteBuilder.where().eq("loadName", UserInfo.a().i().getUid()).and().eq("sessionId", Long.valueOf(paramLong)).and().eq("sessionType", Short.valueOf(paramShort)).and().isNull("chatBgUri");
      return deleteBuilder.delete();
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public Dao<SessionSettingModel, Integer> b() {
    try {
      if (this.c == null)
        this.c = BluedBaseDataHelper.a().getDao(SessionSettingModel.class); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.c;
  }
  
  public Map<String, SessionSettingModel> c() {
    try {
      ArrayMap<String, SessionSettingModel> arrayMap = new ArrayMap();
      List list = b().queryBuilder().where().eq("loadName", UserInfo.a().i().getUid()).query();
      if (list != null) {
        if (list.size() > 0)
          for (SessionSettingModel sessionSettingModel : list)
            arrayMap.put(SessionHeader.getSessionKey(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId()), sessionSettingModel);  
        return (Map<String, SessionSettingModel>)arrayMap;
      } 
      return null;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public int d() {
    try {
      DeleteBuilder deleteBuilder = b().deleteBuilder();
      deleteBuilder.where().eq("loadName", UserInfo.a().i().getUid()).and().ne("sessionType", Short.valueOf((short)3)).and().ne("sessionType", Short.valueOf((short)1)).and().ne("sessionId", Integer.valueOf(2)).and().isNull("chatBgUri");
      return deleteBuilder.delete();
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\SessionSettingDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */