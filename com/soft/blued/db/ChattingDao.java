package com.soft.blued.db;

import android.database.Cursor;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.DataTransform;
import com.blued.android.chat.model.ChattingModel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.soft.blued.db.model.ChattingModelDB;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ChattingDao {
  private static ChattingDao b;
  
  private String a = ChattingDao.class.getSimpleName();
  
  private Dao<ChattingModelDB, Integer> c;
  
  public static ChattingDao a() {
    // Byte code:
    //   0: getstatic com/soft/blued/db/ChattingDao.b : Lcom/soft/blued/db/ChattingDao;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/db/ChattingDao
    //   8: monitorenter
    //   9: getstatic com/soft/blued/db/ChattingDao.b : Lcom/soft/blued/db/ChattingDao;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/db/ChattingDao
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/db/ChattingDao.b : Lcom/soft/blued/db/ChattingDao;
    //   25: ldc com/soft/blued/db/ChattingDao
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/db/ChattingDao
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/db/ChattingDao.b : Lcom/soft/blued/db/ChattingDao;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public int a(int paramInt, long paramLong) {
    UpdateBuilder updateBuilder = b().updateBuilder();
    try {
      updateBuilder.updateColumnValue("msgTextTranslateIsShow", Integer.valueOf(0));
      updateBuilder.updateColumnValue("msgTextTranslateContent", "");
      updateBuilder.updateColumnValue("msgTextTranslateStatus", Integer.valueOf(0));
      Where where = updateBuilder.where();
      where.and(where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), where.eq("sessionType", Integer.valueOf(paramInt)), new Where[] { where.eq("sessionId", Long.valueOf(paramLong)), where.eq("msgTextTranslateStatus", Short.valueOf((short)1)) });
      return updateBuilder.update();
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int a(long paramLong1, int paramInt, long paramLong2, long paramLong3) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("update ChattingModel set msgId='");
      stringBuilder.append(paramLong1);
      stringBuilder.append("' where loadName='");
      stringBuilder.append(ChatManager.userInfo.uid);
      stringBuilder.append("' and sessionType='");
      stringBuilder.append(paramInt);
      stringBuilder.append("' and sessionId='");
      stringBuilder.append(paramLong2);
      stringBuilder.append("' and msgStateCode='");
      stringBuilder.append(1);
      stringBuilder.append("' and msgLocalId>'");
      stringBuilder.append(paramLong3);
      stringBuilder.append("'");
      String str = stringBuilder.toString();
      return b().executeRaw(str, new String[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int a(ChattingModelDB paramChattingModelDB) {
    try {
      paramChattingModelDB.getMsgExtra();
      return b().create(paramChattingModelDB);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int a(List<ChattingModel> paramList) {
    try {
      this.c.callBatchTasks(new -$$Lambda$ChattingDao$MYVrvE2a_0uswSelTs2INFtputE(this, paramList));
      return 1;
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int a(short paramShort, long paramLong1, long paramLong2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update ChattingModel set msgStateCode='3' where loadName='");
    stringBuilder.append(ChatManager.userInfo.uid);
    stringBuilder.append("' and sessionType='");
    stringBuilder.append(paramShort);
    stringBuilder.append("' and sessionId='");
    stringBuilder.append(paramLong1);
    stringBuilder.append("' and msgId<='");
    stringBuilder.append(paramLong2);
    stringBuilder.append("' and msgStateCode='");
    stringBuilder.append(2);
    stringBuilder.append("'");
    String str = stringBuilder.toString();
    try {
      return b().executeRaw(str, new String[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int a(short paramShort1, short paramShort2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update ChattingModel set msgType ='");
    stringBuilder.append(paramShort2);
    stringBuilder.append("' where loadName='");
    stringBuilder.append(ChatManager.userInfo.uid);
    stringBuilder.append("' and msgType='");
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
  
  public Cursor a(String paramString, long paramLong, short paramShort) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select chat.msgTimestamp, chat.msgContent, chat.msgStateCode, chat.msgId, chat.msgLocalId, chat.avatar, chat.nickName, chat.fromId, chat.vBadge, chat.fromHideVipLook, chat.fromVipAnnual,chat.fromVipExpLvl, chat.fromVipGrade, chat.id from ChattingModel chat where (chat.sessionId = ");
    stringBuilder.append(paramLong);
    stringBuilder.append(" and chat.msgContent like '%");
    stringBuilder.append(paramString);
    stringBuilder.append("%' and chat.msgType = ");
    stringBuilder.append(1);
    stringBuilder.append(" and chat.sessionType = ");
    stringBuilder.append(paramShort);
    stringBuilder.append(" and chat.msgIsDelete = 0) order by chat.msgTimestamp desc");
    paramString = stringBuilder.toString();
    return BluedBaseDataHelper.a().getReadableDatabase().rawQuery(paramString, null);
  }
  
  public ChattingModelDB a(long paramLong1, short paramShort, long paramLong2) {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      Where where = queryBuilder.where();
      where.and(where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), where.eq("msgLocalId", Long.valueOf(paramLong1)), new Where[] { where.eq("sessionType", Short.valueOf(paramShort)), where.eq("sessionId", Long.valueOf(paramLong2)) });
      List<ChattingModelDB> list = queryBuilder.query();
      return (list != null && list.size() > 0) ? list.get(0) : null;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public ChattingModelDB a(short paramShort, long paramLong1, long paramLong2, long paramLong3) {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      Where where = queryBuilder.where();
      where.and(where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), where.eq("sessionType", Short.valueOf(paramShort)), new Where[] { where.eq("sessionId", Long.valueOf(paramLong1)), where.eq("msgId", Long.valueOf(paramLong2)), where.eq("msgLocalId", Long.valueOf(paramLong3)) });
      List<ChattingModelDB> list = queryBuilder.query();
      return (list != null && list.size() > 0) ? list.get(0) : null;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public List<ChattingModelDB> a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      Where where = queryBuilder.where();
      if (paramLong2 == 0L && paramLong3 == 0L && paramLong4 == 0L) {
        where.and(where.eq("sessionType", Integer.valueOf(paramInt)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[] { where.eq("sessionId", Long.valueOf(paramLong1)) });
      } else {
        where.and(where.eq("sessionType", Integer.valueOf(paramInt)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[] { where.eq("sessionId", Long.valueOf(paramLong1)), where.or(where.lt("msgId", Long.valueOf(paramLong2)), where.and(where.eq("msgId", Long.valueOf(paramLong2)), where.lt("msgLocalId", Long.valueOf(paramLong3)), new Where[0]), new Where[] { where.and(where.eq("msgId", Integer.valueOf(0)), where.lt("msgLocalId", Long.valueOf(paramLong3)), new Where[0]), where.and(where.eq("msgId", Integer.valueOf(0)), where.eq("msgLocalId", Integer.valueOf(0)), new Where[] { where.lt("msgTimestamp", Long.valueOf(paramLong4)) }) }) });
      } 
      queryBuilder.orderBy("msgId", false);
      queryBuilder.orderBy("msgLocalId", false);
      queryBuilder.orderBy("msgTimestamp", false);
      queryBuilder.limit(Long.valueOf(paramLong5));
      return queryBuilder.query();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public Set<Long> a(int paramInt, long paramLong1, long paramLong2) {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      Where where = queryBuilder.where();
      where.and(where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), where.eq("sessionType", Integer.valueOf(paramInt)), new Where[] { where.eq("sessionId", Long.valueOf(paramLong1)), where.notIn("fromId", new Object[] { Long.valueOf(ChatManager.userInfo.uid) }), where.eq("msgStateCode", Short.valueOf((short)4)) });
      queryBuilder.limit(Long.valueOf(paramLong2));
      List list = queryBuilder.query();
      HashSet<Long> hashSet = new HashSet();
      Iterator iterator = list.iterator();
      while (iterator.hasNext())
        hashSet.add(Long.valueOf(((ChattingModelDB)iterator.next()).msgId)); 
      return hashSet;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public int b(int paramInt, long paramLong) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("delete from ChattingModel  where sessionType='");
      stringBuilder.append(paramInt);
      stringBuilder.append("' and loadName='");
      stringBuilder.append(ChatManager.userInfo.uid);
      stringBuilder.append("' and sessionId='");
      stringBuilder.append(paramLong);
      stringBuilder.append("'");
      String str = stringBuilder.toString();
      return b().executeRaw(str, new String[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int b(ChattingModelDB paramChattingModelDB) {
    try {
      return b().update(paramChattingModelDB);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public Dao<ChattingModelDB, Integer> b() {
    try {
      if (this.c == null)
        this.c = BluedBaseDataHelper.a().getDao(ChattingModelDB.class); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.c;
  }
  
  public List<ChattingModelDB> b(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      Where where = queryBuilder.where();
      if (paramLong2 == 0L && paramLong3 == 0L && paramLong4 == 0L) {
        where.and(where.eq("sessionType", Integer.valueOf(paramInt)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[] { where.eq("sessionId", Long.valueOf(paramLong1)) });
      } else {
        where.and(where.eq("sessionType", Integer.valueOf(paramInt)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[] { where.eq("sessionId", Long.valueOf(paramLong1)), where.or(where.ge("msgId", Long.valueOf(paramLong2)), where.and(where.eq("msgId", Integer.valueOf(0)), where.ge("msgLocalId", Long.valueOf(paramLong3)), new Where[0]), new Where[] { where.and(where.eq("msgId", Integer.valueOf(0)), where.eq("msgLocalId", Integer.valueOf(0)), new Where[] { where.ge("msgTimestamp", Long.valueOf(paramLong4)) }) }) });
      } 
      queryBuilder.orderBy("msgId", true);
      queryBuilder.orderBy("msgLocalId", true);
      queryBuilder.orderBy("msgTimestamp", true);
      queryBuilder.limit(Long.valueOf(paramLong5));
      return queryBuilder.query();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public int c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update ChattingModel set msgStateCode ='6' where loadName='");
    stringBuilder.append(ChatManager.userInfo.uid);
    stringBuilder.append("' and msgStateCode='");
    stringBuilder.append(1);
    stringBuilder.append("' and fromId='");
    stringBuilder.append(ChatManager.userInfo.uid);
    stringBuilder.append("'");
    String str = stringBuilder.toString();
    try {
      return b().executeRaw(str, new String[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
  
  public int d() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("delete from ChattingModel  where loadName='");
      stringBuilder.append(ChatManager.userInfo.uid);
      stringBuilder.append("'");
      String str = stringBuilder.toString();
      return b().executeRaw(str, new String[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      return -1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\ChattingDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */