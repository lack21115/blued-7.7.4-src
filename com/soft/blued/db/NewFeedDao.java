package com.soft.blued.db;

import com.j256.ormlite.dao.Dao;
import com.soft.blued.db.model.NewFeedModel;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;
import java.util.List;

public class NewFeedDao {
  private static NewFeedDao a;
  
  private Dao<NewFeedModel, Integer> b;
  
  public static NewFeedDao a() {
    // Byte code:
    //   0: getstatic com/soft/blued/db/NewFeedDao.a : Lcom/soft/blued/db/NewFeedDao;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/db/NewFeedDao
    //   8: monitorenter
    //   9: getstatic com/soft/blued/db/NewFeedDao.a : Lcom/soft/blued/db/NewFeedDao;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/db/NewFeedDao
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/db/NewFeedDao.a : Lcom/soft/blued/db/NewFeedDao;
    //   25: ldc com/soft/blued/db/NewFeedDao
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/db/NewFeedDao
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/db/NewFeedDao.a : Lcom/soft/blued/db/NewFeedDao;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(NewFeedModel paramNewFeedModel) {
    try {
      b().create(paramNewFeedModel);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public Dao<NewFeedModel, Integer> b() {
    try {
      if (this.b == null)
        this.b = BluedBaseDataHelper.a().getDao(NewFeedModel.class); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.b;
  }
  
  public void b(NewFeedModel paramNewFeedModel) {
    try {
      b().update(paramNewFeedModel);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public List<NewFeedModel> c() {
    try {
      return b().queryBuilder().where().eq("loadName", UserInfo.a().i().getUid()).query();
    } catch (Exception exception) {
      exception.printStackTrace();
      return new ArrayList<NewFeedModel>();
    } 
  }
  
  public void c(NewFeedModel paramNewFeedModel) {
    try {
      b().delete(paramNewFeedModel);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\NewFeedDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */