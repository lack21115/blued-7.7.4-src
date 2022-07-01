package com.soft.blued.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.blued.android.core.AppInfo;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableUtils;
import com.soft.blued.db.model.ChattingModelDB;
import com.soft.blued.db.model.NewFeedModel;
import com.soft.blued.db.model.SessionModelDB;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.db.model.UserAccountsModel;
import com.soft.blued.utils.Logger;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class BluedBaseDataHelper extends OrmLiteSqliteOpenHelper {
  public static final Class[] a = new Class[] { UserAccountsModel.class, SessionModelDB.class, ChattingModelDB.class, SessionSettingModel.class, NewFeedModel.class };
  
  public static BluedBaseDataHelper b;
  
  private String c = BluedBaseDataHelper.class.getName();
  
  public BluedBaseDataHelper(Context paramContext, String paramString) {
    super(paramContext, paramString, null, 40029);
  }
  
  private void A(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(1, "hasReply", "INTEGER");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(1);
      return;
    } 
  }
  
  private void B(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(1, "secretLookStatus", "INTEGER");
      a(1, "vipExpLvl", "INTEGER");
    } catch (Exception exception) {
      exception.printStackTrace();
      a(1);
    } 
    try {
      a(2, "fromVipExpLvl", "INTEGER");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(2);
      return;
    } 
  }
  
  private void C(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "videoTaskID", "TEXT");
      a(4, "music_id", "TEXT");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(4);
      return;
    } 
  }
  
  private void D(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "is_anonym", "INTEGER");
      a(4, "anonym_comment", "INTEGER");
      a(4, "anonym_avatar", "INTEGER");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(4);
      return;
    } 
  }
  
  private void E(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "is_join_circle", "INTEGER");
      a(4, "join_circle_id", "INTEGER");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(4);
      return;
    } 
  }
  
  private void F(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "repost_also_comment", "INTEGER");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(4);
      return;
    } 
  }
  
  private void G(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "join_circle_title", "TEXT");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(4);
      return;
    } 
  }
  
  private void H(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "circle_header", "TEXT");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(4);
      return;
    } 
  }
  
  public static BluedBaseDataHelper a() {
    // Byte code:
    //   0: getstatic com/soft/blued/db/BluedBaseDataHelper.b : Lcom/soft/blued/db/BluedBaseDataHelper;
    //   3: ifnonnull -> 42
    //   6: ldc com/soft/blued/db/BluedBaseDataHelper
    //   8: monitorenter
    //   9: getstatic com/soft/blued/db/BluedBaseDataHelper.b : Lcom/soft/blued/db/BluedBaseDataHelper;
    //   12: ifnonnull -> 30
    //   15: new com/soft/blued/db/BluedBaseDataHelper
    //   18: dup
    //   19: invokestatic d : ()Landroid/content/Context;
    //   22: ldc 'blued2015.db'
    //   24: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   27: putstatic com/soft/blued/db/BluedBaseDataHelper.b : Lcom/soft/blued/db/BluedBaseDataHelper;
    //   30: ldc com/soft/blued/db/BluedBaseDataHelper
    //   32: monitorexit
    //   33: goto -> 42
    //   36: astore_0
    //   37: ldc com/soft/blued/db/BluedBaseDataHelper
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    //   42: getstatic com/soft/blued/db/BluedBaseDataHelper.b : Lcom/soft/blued/db/BluedBaseDataHelper;
    //   45: areturn
    // Exception table:
    //   from	to	target	type
    //   9	30	36	finally
    //   30	33	36	finally
    //   37	40	36	finally
  }
  
  private void a(int paramInt) {
    try {
      TransactionManager.callInTransaction((ConnectionSource)this.connectionSource, new Callable<Void>(this, paramInt) {
            public Void a() throws Exception {
              TableUtils.dropTable((ConnectionSource)BluedBaseDataHelper.a(this.b), BluedBaseDataHelper.a[this.a], true);
              TableUtils.createTable((ConnectionSource)BluedBaseDataHelper.b(this.b), BluedBaseDataHelper.a[this.a]);
              return null;
            }
          });
      return;
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
      return;
    } 
  }
  
  private void a(int paramInt, String paramString1, String paramString2) throws SQLException {
    paramString1 = String.format("ALTER TABLE %s ADD COLUMN %s %s;", new Object[] { b(paramInt), paramString1, paramString2 });
    a().getDao(a[paramInt]).executeRawNoArgs(paramString1);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase) {
    try {
      TableUtils.createTable((ConnectionSource)this.connectionSource, NewFeedModel.class);
      SessionDao.a().b().executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN vBadge INTEGER;");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
      return;
    } 
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource) {
    try {
      TransactionManager.callInTransaction(paramConnectionSource, new Callable<Void>(this, paramConnectionSource) {
            public Void a() throws Exception {
              for (int i = 0; i < BluedBaseDataHelper.a.length; i++)
                TableUtils.dropTable(this.a, BluedBaseDataHelper.a[i], true); 
              return null;
            }
          });
      onCreate(paramSQLiteDatabase, paramConnectionSource);
      return;
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
      return;
    } 
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString) {
    Cursor cursor1 = null;
    Cursor cursor2 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    try {
      Cursor cursor = paramSQLiteDatabase.rawQuery(String.format("SELECT * FROM %s LIMIT 0", new Object[] { b(paramInt) }), null);
      boolean bool = bool1;
      if (cursor != null) {
        cursor2 = cursor;
        cursor1 = cursor;
        paramInt = cursor.getColumnIndex(paramString);
        bool = bool1;
        if (paramInt != -1)
          bool = true; 
      } 
      bool1 = bool;
      if (cursor != null) {
        bool1 = bool;
        if (!cursor.isClosed()) {
          cursor.close();
          return bool;
        } 
      } 
    } catch (Exception exception) {
      cursor2 = cursor1;
      Logger.e(this.c, new Object[] { "checkColumnExists1...", exception });
      bool1 = bool3;
      if (cursor1 != null) {
        bool1 = bool3;
        if (!cursor1.isClosed()) {
          Cursor cursor = cursor1;
          boolean bool = bool2;
          cursor.close();
          return bool;
        } 
      } 
    } finally {}
    return bool1;
  }
  
  private String b(int paramInt) throws SQLException {
    return DatabaseTableConfig.fromClass((ConnectionSource)this.connectionSource, a[paramInt]).getTableName();
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase) {
    try {
      Dao<UserAccountsModel, Integer> dao = UserAccountsVDao.a().b();
      dao.executeRawNoArgs("ALTER TABLE UserAccountsModel ADD COLUMN loginType INTEGER;");
      dao.executeRawNoArgs("ALTER TABLE UserAccountsModel ADD COLUMN accessToken TEXT;");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
      return;
    } 
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase) {
    try {
      ChattingDao.a().b().executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN vBadge INTEGER;");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
      return;
    } 
  }
  
  private void d(SQLiteDatabase paramSQLiteDatabase) {
    try {
      Dao<ChattingModelDB, Integer> dao = ChattingDao.a().b();
      dao.executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN msgVideoCoverUrlLocal TEXT;");
      dao.executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN msgTextTranslateIsShow INTEGER;");
      dao.executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN msgTextTranslateContent TEXT;");
      dao.executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN msgTextTranslateStatus INTEGER;");
      SessionDao.a().b().executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN maxRcvOppMsgId LONG;");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
      return;
    } 
  }
  
  private void e(SQLiteDatabase paramSQLiteDatabase) {
    try {
      SessionDao.a().b().executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN lastMsgExtra TEXT;");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
      return;
    } 
  }
  
  private void f(SQLiteDatabase paramSQLiteDatabase) {
    try {
      Dao<SessionModelDB, Integer> dao = SessionDao.a().b();
      dao.executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN online INTEGER;");
      dao.executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN lastMsgOnline INTEGER;");
      ChattingDao.a().b().executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN online INTEGER;");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
      return;
    } 
  }
  
  private void g(SQLiteDatabase paramSQLiteDatabase) {
    try {
      Dao<SessionModelDB, Integer> dao = SessionDao.a().b();
      dao.executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN draft TEXT;");
      dao.executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN sessionStatus INTEGER;");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
      return;
    } 
  }
  
  private void h(SQLiteDatabase paramSQLiteDatabase) {
    Dao<NewFeedModel, Integer> dao = NewFeedDao.a().b();
    try {
      dao.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN isForwardHeader INTEGER;");
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
    } 
    try {
      dao.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN isAds INTEGER;");
      dao.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN allowComments INTEGER;");
      dao.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN isRepost INTEGER;");
      dao.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN forwardContent TEXT;");
      dao.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN forwardName TEXT;");
      dao.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN forwardImage TEXT;");
      dao.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN feedId TEXT;");
      dao.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN framesData TEXT;");
      return;
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
      return;
    } 
  }
  
  private void i(SQLiteDatabase paramSQLiteDatabase) {
    try {
      NewFeedDao.a().b().executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN address TEXT;");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
      return;
    } 
  }
  
  private void j(SQLiteDatabase paramSQLiteDatabase) {
    try {
      SessionDao.a().b().executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN lastMsgFromApp INTEGER;");
      ChattingDao.a().b().executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN app INTEGER;");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(paramSQLiteDatabase, (ConnectionSource)this.connectionSource);
      return;
    } 
  }
  
  private void k(SQLiteDatabase paramSQLiteDatabase) {
    try {
      if (!a(paramSQLiteDatabase, 4, "extraJSON")) {
        a(4, "extraJSON", "TEXT");
        a(4, "is_url", "INTEGER");
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      a(4);
    } 
  }
  
  private void l(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(1, "vipGrade", "INTEGER");
      a(1, "vipAnnual", "INTEGER");
    } catch (Exception exception) {
      a(1);
    } 
    try {
      a(2, "fromVipGrade", "INTEGER");
      a(2, "fromVipAnnual", "INTEGER");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(2);
      return;
    } 
  }
  
  private void m(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "duration", "REAL");
      return;
    } catch (Exception exception) {
      a(4);
      return;
    } 
  }
  
  private void n(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "reading_scope", "INTEGER");
      return;
    } catch (Exception exception) {
      a(4);
      return;
    } 
  }
  
  private void o(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(3, "chatBgUri", "TEXT");
      return;
    } catch (Exception exception) {
      a(3);
      return;
    } 
  }
  
  private void p(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(3, "nearby", "INTEGER");
      a(3, "online", "INTEGER");
      a(3, "follower", "INTEGER");
      a(3, "initiator", "INTEGER");
      return;
    } catch (Exception exception) {
      a(3);
      return;
    } 
  }
  
  private void q(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(1, "hideVipLook", "INTEGER");
    } catch (Exception exception) {
      a(1);
    } 
    try {
      a(2, "fromHideVipLook", "INTEGER");
      return;
    } catch (Exception exception) {
      a(2);
    } 
  }
  
  private void r(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "is_vote", "INTEGER");
      return;
    } catch (Exception exception) {
      a(4);
      return;
    } 
  }
  
  private void s(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "is_super_topics", "INTEGER");
    } catch (Exception exception) {
      a(4);
    } 
    try {
      a(4, "super_did", "TEXT");
    } catch (Exception exception) {
      a(4);
    } 
    try {
      a(4, "super_topics_avatar", "TEXT");
    } catch (Exception exception) {
      a(4);
    } 
    try {
      a(4, "super_topics_name", "TEXT");
    } catch (Exception exception) {
      a(4);
    } 
    try {
      a(1, "sourceFrom", "INTEGER");
      return;
    } catch (Exception exception) {
      a(1);
    } 
  }
  
  private void t(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(1, "lieTop", "INTEGER");
      return;
    } catch (Exception exception) {
      a(1);
      return;
    } 
  }
  
  private void u(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(0, "aliasUserId", "TEXT");
      a(1, "unreadGiftCnt", "INTEGER");
      a(1, "lastGiftMsgId", "LONG");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      a(0);
      return;
    } 
  }
  
  private void v(SQLiteDatabase paramSQLiteDatabase) {
    if (!a(paramSQLiteDatabase, 0, "aliasUserId")) {
      try {
        a(0, "aliasUserId", "TEXT");
      } catch (Exception exception) {
        exception.printStackTrace();
        a(0);
      } 
      try {
        a(1, "unreadGiftCnt", "INTEGER");
        a(1, "lastGiftMsgId", "LONG");
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        a(1);
      } 
    } 
  }
  
  private void w(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "circle_id", "TEXT");
    } catch (Exception exception) {
      a(4);
    } 
    try {
      a(4, "circle_title", "TEXT");
    } catch (Exception exception) {
      a(4);
    } 
    try {
      a(1, "friend", "INTEGER");
      return;
    } catch (Exception exception) {
      a(1);
    } 
  }
  
  private void x(SQLiteDatabase paramSQLiteDatabase) {
    if (!a(paramSQLiteDatabase, 1, "expireTime")) {
      try {
        a(1, "expireTime", "LONG");
        a(1, "totalMoney", "FLOAT");
      } catch (Exception exception) {
        a(1);
      } 
      try {
        a(4, "is_circle_comment", "INTEGER");
        return;
      } catch (Exception exception) {
        a(4);
      } 
    } 
  }
  
  private void y(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "is_attention_show_dot", "INTEGER");
    } catch (Exception exception) {
      a(4);
    } 
    try {
      a(1, "maxMsgId", "LONG");
    } catch (Exception exception) {
      a(1);
    } 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("UPDATE ");
      stringBuilder.append(b(1));
      stringBuilder.append(" SET maxMsgId = lastMsgId");
      paramSQLiteDatabase.execSQL(String.format(stringBuilder.toString(), new Object[0]));
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
    } 
    Logger.e("maxMsgId", new Object[] { "updateDB25" });
  }
  
  private void z(SQLiteDatabase paramSQLiteDatabase) {
    try {
      a(4, "is_posts_vote", "INTEGER");
      a(4, "posts_vote_title", "TEXT");
      a(4, "option", "TEXT");
      a(4, "share_posting_id", "TEXT");
    } catch (Exception exception) {
      a(4);
    } 
    Logger.e("maxMsgId", new Object[] { "updateDB26" });
  }
  
  public String b() {
    return AppInfo.d().getDatabasePath("blued2015.db").getPath();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource) {
    try {
      TransactionManager.callInTransaction(paramConnectionSource, new Callable<Void>(this, paramConnectionSource) {
            public Void a() throws Exception {
              for (int i = 0; i < BluedBaseDataHelper.a.length; i++)
                TableUtils.createTable(this.a, BluedBaseDataHelper.a[i]); 
              return null;
            }
          });
      return;
    } catch (SQLException sQLException) {
      Logger.e(BluedBaseDataHelper.class.getName(), new Object[] { "Unable to create datbases", sQLException });
      return;
    } 
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource, int paramInt1, int paramInt2) {
    Logger.b(this.c, new Object[] { "数据库升级: oldVersion==", Integer.valueOf(paramInt1), "，newVersion==", Integer.valueOf(paramInt2) });
    switch (paramInt1) {
      default:
        return;
      case 40000:
        a(paramSQLiteDatabase);
      case 40001:
        b(paramSQLiteDatabase);
      case 40002:
        c(paramSQLiteDatabase);
      case 40003:
        d(paramSQLiteDatabase);
      case 40004:
        e(paramSQLiteDatabase);
      case 40005:
        f(paramSQLiteDatabase);
      case 40006:
        g(paramSQLiteDatabase);
      case 40007:
        h(paramSQLiteDatabase);
      case 40008:
        i(paramSQLiteDatabase);
      case 40009:
        j(paramSQLiteDatabase);
      case 40010:
        k(paramSQLiteDatabase);
        l(paramSQLiteDatabase);
      case 40011:
        m(paramSQLiteDatabase);
      case 40012:
        n(paramSQLiteDatabase);
      case 40013:
        o(paramSQLiteDatabase);
      case 40014:
        p(paramSQLiteDatabase);
      case 40015:
        q(paramSQLiteDatabase);
      case 40016:
        r(paramSQLiteDatabase);
      case 40017:
        s(paramSQLiteDatabase);
      case 40018:
        t(paramSQLiteDatabase);
      case 40019:
        u(paramSQLiteDatabase);
      case 40020:
        v(paramSQLiteDatabase);
      case 40021:
        w(paramSQLiteDatabase);
      case 40022:
      case 40023:
        x(paramSQLiteDatabase);
      case 40024:
        y(paramSQLiteDatabase);
      case 40025:
        z(paramSQLiteDatabase);
      case 40026:
        A(paramSQLiteDatabase);
      case 40027:
        B(paramSQLiteDatabase);
      case 40028:
        C(paramSQLiteDatabase);
      case 40029:
        D(paramSQLiteDatabase);
      case 40030:
        E(paramSQLiteDatabase);
      case 40031:
        F(paramSQLiteDatabase);
      case 40032:
        G(paramSQLiteDatabase);
        break;
      case 40033:
        break;
    } 
    H(paramSQLiteDatabase);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\BluedBaseDataHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */