package com.soft.blued.ui.video.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.FlashVideoHttpUtils;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserInfoVideoDataManager {
  private static UserInfoVideoDataManager b;
  
  public boolean a = true;
  
  private List<IShineVideoDataDownloadListner> c = new ArrayList<IShineVideoDataDownloadListner>();
  
  private List<BluedIngSelfFeed> d = new ArrayList<BluedIngSelfFeed>();
  
  private List<BluedIngSelfFeed> e = new ArrayList<BluedIngSelfFeed>();
  
  private Set<String> f = new HashSet<String>();
  
  private int g = 0;
  
  private int h = 0;
  
  private int i = 30;
  
  private int j = 30;
  
  private IRequestHost k;
  
  private int l = -1;
  
  private boolean m = true;
  
  private boolean n = true;
  
  private BluedIngSelfFeed o = new BluedIngSelfFeed();
  
  private BluedUIHttpResponse p = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this, "shineVideoList", this.k) {
      public boolean a = false;
      
      protected void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
        if (UserInfoVideoDataManager.a(this.b) == 1) {
          UserInfoVideoDataManager.b(this.b).clear();
          UserInfoVideoDataManager.c(this.b).clear();
        } 
        if (param1BluedEntityA != null) {
          UserInfoVideoDataManager.b(this.b, param1BluedEntityA.hasMore());
          List<BluedIngSelfFeed> list = UserInfoVideoDataManager.a(this.b, param1BluedEntityA);
          UserInfoVideoDataManager.c(this.b).addAll(list);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("user下载成功：");
          stringBuilder.append(UserInfoVideoDataManager.c(this.b).size());
          stringBuilder.append(" -- isHasMore:");
          stringBuilder.append(UserInfoVideoDataManager.d(this.b));
          Log.v("drb", stringBuilder.toString());
          if (UserInfoVideoDataManager.e(this.b) != null && UserInfoVideoDataManager.e(this.b).size() > 0)
            for (int i = 0; i < UserInfoVideoDataManager.e(this.b).size(); i++)
              ((UserInfoVideoDataManager.IShineVideoDataDownloadListner)UserInfoVideoDataManager.e(this.b).get(i)).a(param1BluedEntityA.hasMore(), list);  
          if (!UserInfoVideoDataManager.d(this.b)) {
            UserInfoVideoDataManager userInfoVideoDataManager = this.b;
            userInfoVideoDataManager.a = false;
            UserInfoVideoDataManager.a(userInfoVideoDataManager, UserInfoVideoDataManager.f(userInfoVideoDataManager));
            return;
          } 
          this.b.a = true;
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (UserInfoVideoDataManager.a(this.b) > 1)
          UserInfoVideoDataManager.g(this.b); 
        Log.v("drb", "getUserInfoVideoCallBack onUIFailure");
        return true;
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        UserInfoVideoDataManager.a(this.b, true);
        if (UserInfoVideoDataManager.e(this.b) != null && UserInfoVideoDataManager.e(this.b).size() > 0)
          for (int i = 0; i < UserInfoVideoDataManager.e(this.b).size(); i++)
            ((UserInfoVideoDataManager.IShineVideoDataDownloadListner)UserInfoVideoDataManager.e(this.b).get(i)).a(this.a);  
      }
      
      public void onUIStart() {
        super.onUIStart();
        UserInfoVideoDataManager.a(this.b, false);
      }
    };
  
  private BluedUIHttpResponse q = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this, "shineVideoList", this.k) {
      public boolean a = false;
      
      protected void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
        if (param1BluedEntityA != null) {
          UserInfoVideoDataManager.b(this.b, param1BluedEntityA.hasMore());
          List<BluedIngSelfFeed> list = UserInfoVideoDataManager.a(this.b, param1BluedEntityA);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("ai下载成功：");
          stringBuilder.append(param1BluedEntityA.data.size());
          Log.v("drb", stringBuilder.toString());
          UserInfoVideoDataManager.c(this.b).addAll(list);
          if (UserInfoVideoDataManager.e(this.b) != null && UserInfoVideoDataManager.e(this.b).size() > 0)
            for (int i = 0; i < UserInfoVideoDataManager.e(this.b).size(); i++)
              ((UserInfoVideoDataManager.IShineVideoDataDownloadListner)UserInfoVideoDataManager.e(this.b).get(i)).a(param1BluedEntityA.hasMore(), list);  
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (UserInfoVideoDataManager.h(this.b) > 1)
          UserInfoVideoDataManager.i(this.b); 
        Log.v("drb", "getAiVideoCallBack onUIFailure");
        return true;
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        UserInfoVideoDataManager.a(this.b, true);
        if (UserInfoVideoDataManager.e(this.b) != null && UserInfoVideoDataManager.e(this.b).size() > 0)
          for (int i = 0; i < UserInfoVideoDataManager.e(this.b).size(); i++)
            ((UserInfoVideoDataManager.IShineVideoDataDownloadListner)UserInfoVideoDataManager.e(this.b).get(i)).a(this.a);  
      }
      
      public void onUIStart() {
        super.onUIStart();
        UserInfoVideoDataManager.a(this.b, false);
      }
    };
  
  public static UserInfoVideoDataManager a() {
    if (b == null)
      b = new UserInfoVideoDataManager(); 
    return b;
  }
  
  private List<BluedIngSelfFeed> a(BluedEntityA<BluedIngSelfFeed> paramBluedEntityA) {
    ArrayList<BluedIngSelfFeed> arrayList = new ArrayList();
    if (paramBluedEntityA != null && paramBluedEntityA.data != null && paramBluedEntityA.data.size() > 0)
      for (int i = 0; i < paramBluedEntityA.data.size(); i++) {
        BluedIngSelfFeed bluedIngSelfFeed = paramBluedEntityA.data.get(i);
        if (!this.f.contains(bluedIngSelfFeed.feed_id)) {
          if (bluedIngSelfFeed.isRepost()) {
            arrayList.add(bluedIngSelfFeed.repost);
          } else {
            arrayList.add(bluedIngSelfFeed);
          } 
          this.f.add(bluedIngSelfFeed.feed_id);
        } 
      }  
    return arrayList;
  }
  
  private void c(IRequestHost paramIRequestHost) {
    this.k = paramIRequestHost;
    this.g++;
    FlashVideoHttpUtils.a(this.q, this.g, this.i, "", paramIRequestHost);
  }
  
  public void a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setCurrentViewedPosition:");
    stringBuilder.append(this.l);
    Log.v("drb", stringBuilder.toString());
    this.l = paramInt;
  }
  
  public void a(IRequestHost paramIRequestHost) {
    Log.v("drb", "startDownloadForUser");
    this.k = paramIRequestHost;
    this.h++;
    FlashVideoHttpUtils.a(this.p, this.h, this.j, this.o.feed_uid, this.o.feed_id, paramIRequestHost);
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed == null)
      return; 
    d();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("id:");
    stringBuilder.append(paramBluedIngSelfFeed.feed_uid);
    stringBuilder.append("currentViewedPosition:");
    stringBuilder.append(this.l);
    Log.v("drb", stringBuilder.toString());
    this.d.clear();
    this.l = 0;
    this.o = paramBluedIngSelfFeed;
    this.d.add(this.o);
    this.f.add(this.o.feed_id);
    b(this.k);
  }
  
  public void a(IShineVideoDataDownloadListner paramIShineVideoDataDownloadListner) {
    this.c.add(paramIShineVideoDataDownloadListner);
  }
  
  public void a(String paramString1, String paramString2) {
    Logger.b("UserInfoVideoDataManager", new Object[] { "notifyAttentionChanged:", paramString1 });
    List<BluedIngSelfFeed> list = this.d;
    if (list == null)
      return; 
    for (BluedIngSelfFeed bluedIngSelfFeed : list) {
      if (TextUtils.equals(bluedIngSelfFeed.feed_id, paramString1)) {
        bluedIngSelfFeed.relationship = paramString2;
        b(bluedIngSelfFeed);
        break;
      } 
    } 
  }
  
  public List<BluedIngSelfFeed> b() {
    for (int i = 0; i < this.d.size(); i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getData:");
      stringBuilder.append(i);
      stringBuilder.append(" -- ");
      stringBuilder.append(((BluedIngSelfFeed)this.d.get(i)).feed_content);
      Log.v("drb", stringBuilder.toString());
    } 
    return this.d;
  }
  
  public void b(IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startDownload hasUserInfoData:");
    stringBuilder.append(this.a);
    Log.v("drb", stringBuilder.toString());
    if (this.a) {
      a(paramIRequestHost);
      return;
    } 
    c(paramIRequestHost);
  }
  
  public void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    int i = 0;
    Logger.b("UserInfoVideoDataManager", new Object[] { "notifyDataHasChanged" });
    List<IShineVideoDataDownloadListner> list = this.c;
    if (list != null && list.size() > 0)
      while (i < this.c.size()) {
        ((IShineVideoDataDownloadListner)this.c.get(i)).b(this.d);
        ((IShineVideoDataDownloadListner)this.c.get(i)).a(paramBluedIngSelfFeed);
        i++;
      }  
  }
  
  public void b(IShineVideoDataDownloadListner paramIShineVideoDataDownloadListner) {
    this.c.remove(paramIShineVideoDataDownloadListner);
  }
  
  public BluedIngSelfFeed c() {
    return this.o;
  }
  
  public void c(BluedIngSelfFeed paramBluedIngSelfFeed) {
    BluedIngSelfFeed bluedIngSelfFeed;
    int i = 0;
    Logger.b("UserInfoVideoDataManager", new Object[] { "notifyDataHasRemove" });
    List<BluedIngSelfFeed> list1 = this.d;
    if (list1 == null)
      return; 
    if (paramBluedIngSelfFeed == null)
      return; 
    List list2 = null;
    Iterator<BluedIngSelfFeed> iterator = list1.iterator();
    while (true) {
      list1 = list2;
      if (iterator.hasNext()) {
        bluedIngSelfFeed = iterator.next();
        if (TextUtils.equals(bluedIngSelfFeed.feed_id, paramBluedIngSelfFeed.feed_id))
          break; 
        continue;
      } 
      break;
    } 
    if (bluedIngSelfFeed != null)
      this.d.remove(bluedIngSelfFeed); 
    List<IShineVideoDataDownloadListner> list = this.c;
    if (list != null && list.size() > 0)
      while (i < this.c.size()) {
        ((IShineVideoDataDownloadListner)this.c.get(i)).b(paramBluedIngSelfFeed);
        i++;
      }  
  }
  
  public void d() {
    this.a = true;
    this.n = true;
    this.g = 0;
    this.h = 0;
  }
  
  public boolean e() {
    return this.m;
  }
  
  public boolean f() {
    return this.n;
  }
  
  public int g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getCurrentViewdPosition:");
    stringBuilder.append(this.l);
    Log.v("drb", stringBuilder.toString());
    return this.l;
  }
  
  public static interface IShineVideoDataDownloadListner {
    void a(BluedIngSelfFeed param1BluedIngSelfFeed);
    
    void a(boolean param1Boolean);
    
    void a(boolean param1Boolean, List<BluedIngSelfFeed> param1List);
    
    void b(BluedIngSelfFeed param1BluedIngSelfFeed);
    
    void b(List<BluedIngSelfFeed> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\manager\UserInfoVideoDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */