package com.soft.blued.db;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.DataTransform;
import com.blued.android.chat.model.SessionModel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.soft.blued.db.model.SessionModelDB;
import java.sql.SQLException;
import java.util.List;

public class SessionDao {
  private static SessionDao a;
  
  private Dao<SessionModelDB, Integer> b;
  
  public static SessionDao a() {
    // Byte code:
    //   0: getstatic com/soft/blued/db/SessionDao.a : Lcom/soft/blued/db/SessionDao;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/db/SessionDao
    //   8: monitorenter
    //   9: getstatic com/soft/blued/db/SessionDao.a : Lcom/soft/blued/db/SessionDao;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/db/SessionDao
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/db/SessionDao.a : Lcom/soft/blued/db/SessionDao;
    //   25: ldc com/soft/blued/db/SessionDao
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/db/SessionDao
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/db/SessionDao.a : Lcom/soft/blued/db/SessionDao;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public int a(int paramInt, long paramLong) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("delete from SessionModel  where sessionType='");
      stringBuilder.append(paramInt);
      stringBuilder.append("' and sessionId='");
      stringBuilder.append(paramLong);
      stringBuilder.append("' and loadName='");
      stringBuilder.append(ChatManager.userInfo.uid);
      stringBuilder.append("'");
      String str = stringBuilder.toString();
      return b().executeRaw(str, new String[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int a(SessionModelDB paramSessionModelDB) {
    try {
      return b().create(paramSessionModelDB);
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
      return -1;
    } 
  }
  
  public int a(List<SessionModel> paramList) {
    try {
      this.b.callBatchTasks(new -$$Lambda$SessionDao$uucJc4Ipx172L2XOWKS3q280vnk(this, paramList));
      return 1;
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int a(short paramShort1, short paramShort2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update SessionModel set lastMsgType ='");
    stringBuilder.append(paramShort2);
    stringBuilder.append("' where loadName='");
    stringBuilder.append(ChatManager.userInfo.uid);
    stringBuilder.append("' and lastMsgType='");
    stringBuilder.append(paramShort1);
    stringBuilder.append("'");
    String str = stringBuilder.toString();
    try {
      return b().executeRaw(str, new String[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int b(SessionModelDB paramSessionModelDB) {
    try {
      return b().update(paramSessionModelDB);
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
      return -1;
    } 
  }
  
  public Dao<SessionModelDB, Integer> b() {
    try {
      if (this.b == null)
        this.b = BluedBaseDataHelper.a().getDao(SessionModelDB.class); 
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
    } 
    return this.b;
  }
  
  public List<SessionModelDB> c() {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      queryBuilder.where().eq("loadName", Long.valueOf(ChatManager.userInfo.uid));
      queryBuilder.orderBy("lastMsgTime", false);
      return queryBuilder.query();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public int d() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("delete from SessionModel where loadName='");
      stringBuilder.append(ChatManager.userInfo.uid);
      stringBuilder.append("'");
      String str = stringBuilder.toString();
      return b().executeRaw(str, new String[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int e() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update SessionModel set lastMsgStateCode='6' where loadName='");
    stringBuilder.append(ChatManager.userInfo.uid);
    stringBuilder.append("' and lastMsgStateCode='");
    stringBuilder.append(1);
    stringBuilder.append("'");
    String str = stringBuilder.toString();
    try {
      return b().executeRaw(str, new String[0]);
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
      return -1;
    } 
  }
  
  public void f() {
    UpdateBuilder updateBuilder = b().updateBuilder();
    try {
      updateBuilder.updateColumnValue("noReadMsgCount", Integer.valueOf(0));
      updateBuilder.updateColumnValue("lastMsgId", Integer.valueOf(0));
      updateBuilder.updateColumnValue("lastMsgType", Integer.valueOf(0));
      updateBuilder.updateColumnValue("lastMsgLocalId", Integer.valueOf(0));
      updateBuilder.updateColumnValue("lastMsgContent", "");
      updateBuilder.updateColumnValue("lastMsgStateCode", Short.valueOf((short)0));
      updateBuilder.updateColumnValue("lastMsgFromId", Integer.valueOf(0));
      updateBuilder.updateColumnValue("lastMsgFromNickname", "");
      updateBuilder.updateColumnValue("lastMsgFromAvatar", "");
      updateBuilder.updateColumnValue("lastMsgDistance", "");
      updateBuilder.where().eq("loadName", Long.valueOf(ChatManager.userInfo.uid));
      updateBuilder.update();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void g() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("update SessionModel set noReadMsgCount='0' where loadName='");
      stringBuilder.append(ChatManager.userInfo.uid);
      stringBuilder.append("'");
      String str = stringBuilder.toString();
      b().executeRaw(str, new String[0]);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\SessionDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */