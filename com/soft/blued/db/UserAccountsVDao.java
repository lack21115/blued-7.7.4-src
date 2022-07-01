package com.soft.blued.db;

import android.text.TextUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.soft.blued.db.model.UserAccountsModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserAccountsVDao {
  private static UserAccountsVDao a;
  
  private Dao<UserAccountsModel, Integer> b;
  
  private String c;
  
  public static UserAccountsVDao a() {
    // Byte code:
    //   0: getstatic com/soft/blued/db/UserAccountsVDao.a : Lcom/soft/blued/db/UserAccountsVDao;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/db/UserAccountsVDao
    //   8: monitorenter
    //   9: getstatic com/soft/blued/db/UserAccountsVDao.a : Lcom/soft/blued/db/UserAccountsVDao;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/db/UserAccountsVDao
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/db/UserAccountsVDao.a : Lcom/soft/blued/db/UserAccountsVDao;
    //   25: ldc com/soft/blued/db/UserAccountsVDao
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/db/UserAccountsVDao
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/db/UserAccountsVDao.a : Lcom/soft/blued/db/UserAccountsVDao;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public UserAccountsModel a(int paramInt) {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      queryBuilder.where().eq("loginType", Integer.valueOf(paramInt));
      queryBuilder.orderBy("lastHandleTime", false);
      List<UserAccountsModel> list = queryBuilder.query();
      if (list != null && list.size() > 0)
        return list.get(0); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public UserAccountsModel a(String paramString) {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      queryBuilder.where().eq("uid", paramString);
      List<UserAccountsModel> list = queryBuilder.query();
      if (list != null && list.size() > 0)
        return list.get(0); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public void a(UserAccountsModel paramUserAccountsModel) {
    try {
      Dao<UserAccountsModel, Integer> dao = b();
      QueryBuilder queryBuilder = dao.queryBuilder();
      queryBuilder.where().eq("uid", paramUserAccountsModel.getUid());
      List<UserAccountsModel> list = queryBuilder.query();
      if (list != null && list.size() > 0) {
        UserAccountsModel userAccountsModel = list.get(0);
        userAccountsModel.setLoginresult(paramUserAccountsModel.getLoginresult());
        userAccountsModel.setUid(paramUserAccountsModel.getUid());
        userAccountsModel.setUsername(paramUserAccountsModel.getUsername());
        userAccountsModel.setLastHandleTime(paramUserAccountsModel.getLastHandleTime());
        userAccountsModel.setAccessToken(paramUserAccountsModel.getAccessToken());
        userAccountsModel.setLoginType(paramUserAccountsModel.getLoginType());
        if (!TextUtils.isEmpty(paramUserAccountsModel.getAliasUserId()))
          userAccountsModel.setAliasUserId(paramUserAccountsModel.getAliasUserId()); 
        dao.update(userAccountsModel);
        return;
      } 
      dao.create(paramUserAccountsModel);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public Dao<UserAccountsModel, Integer> b() {
    try {
      if (this.b == null)
        this.b = BluedBaseDataHelper.a().getDao(UserAccountsModel.class); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.b;
  }
  
  public void b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      Dao<UserAccountsModel, Integer> dao = b();
      List<UserAccountsModel> list = dao.queryForAll();
      if (list != null && list.size() > 0) {
        UserAccountsModel userAccountsModel = list.get(0);
        userAccountsModel.setLoginresult(paramString);
        dao.update(userAccountsModel);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public UserAccountsModel c() {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      queryBuilder.orderBy("lastHandleTime", false);
      List<UserAccountsModel> list = queryBuilder.query();
      if (list != null && list.size() > 0)
        return list.get(0); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public void c(String paramString) {
    if (!StringUtils.e(paramString)) {
      if (StringUtils.e(this.c))
        return; 
      UserAccountsModel userAccountsModel = a().a(paramString);
      if (userAccountsModel != null) {
        userAccountsModel.setAccessToken(this.c);
        try {
          a().b().update(userAccountsModel);
        } catch (SQLException sQLException) {
          sQLException.printStackTrace();
        } 
      } 
      this.c = null;
    } 
  }
  
  public UserAccountsModel d() {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      queryBuilder.where().eq("loginType", Integer.valueOf(0)).or().eq("loginType", Integer.valueOf(1));
      queryBuilder.orderBy("lastHandleTime", false);
      List<UserAccountsModel> list = queryBuilder.query();
      if (list != null && list.size() > 0)
        return list.get(0); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public void e() {
    try {
      QueryBuilder queryBuilder = b().queryBuilder();
      queryBuilder.where().eq("uid", UserInfo.a().i().getUid());
      List<UserAccountsModel> list = queryBuilder.query();
      if (list != null && list.size() > 0) {
        UserAccountsModel userAccountsModel = list.get(0);
        userAccountsModel.setAccessToken("");
        this.b.update(userAccountsModel);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void f() {
    try {
      if (!StringUtils.e(BluedPreferences.bk())) {
        UserAccountsModel userAccountsModel = new UserAccountsModel();
        userAccountsModel.setExtra("");
        userAccountsModel.setLoginresult("");
        userAccountsModel.setUid("");
        userAccountsModel.setUsername(BluedPreferences.bk());
        userAccountsModel.setLastHandleTime(System.currentTimeMillis());
        userAccountsModel.setLoginType(BluedPreferences.bl());
        userAccountsModel.setAccessToken("");
        a().a(userAccountsModel);
        BluedPreferences.J("");
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public CopyOnWriteArrayList<UserAccountsModel> g() {
    CopyOnWriteArrayList<UserAccountsModel> copyOnWriteArrayList = new CopyOnWriteArrayList();
    try {
      Dao<UserAccountsModel, Integer> dao = b();
      if (dao == null)
        return copyOnWriteArrayList; 
      QueryBuilder queryBuilder = dao.queryBuilder();
      queryBuilder.orderBy("lastHandleTime", false);
      List list = queryBuilder.query();
      TypeUtils.a(list);
      queryBuilder = null;
      for (UserAccountsModel userAccountsModel : list) {
        QueryBuilder queryBuilder1;
        if (userAccountsModel.getUid().equals((UserInfo.a().i()).uid)) {
          userAccountsModel.setBluedLoginResult(UserInfo.a().i());
          copyOnWriteArrayList.add(0, userAccountsModel);
          UserAccountsModel userAccountsModel1 = userAccountsModel;
        } else {
          queryBuilder1 = queryBuilder;
          if (queryBuilder != null) {
            queryBuilder1 = queryBuilder;
            if (!TextUtils.isEmpty(queryBuilder.getAliasUserId())) {
              queryBuilder1 = queryBuilder;
              if (queryBuilder.getAliasUserId().equals(userAccountsModel.getUid())) {
                userAccountsModel.setBluedLoginResult(UserInfo.a().a(userAccountsModel));
                copyOnWriteArrayList.add(userAccountsModel);
                queryBuilder1 = queryBuilder;
              } 
            } 
          } 
        } 
        int i = copyOnWriteArrayList.size();
        queryBuilder = queryBuilder1;
        if (i == 2)
          return copyOnWriteArrayList; 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return copyOnWriteArrayList;
  }
  
  public void h() {
    this.c = UserInfo.a().d();
    UserInfo.a().a(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\db\UserAccountsVDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */