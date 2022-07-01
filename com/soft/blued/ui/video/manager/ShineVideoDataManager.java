package com.soft.blued.ui.video.manager;

import android.text.TextUtils;
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

public class ShineVideoDataManager {
  private static ShineVideoDataManager a;
  
  private List<IShineVideoDataDownloadListner> b = new ArrayList<IShineVideoDataDownloadListner>();
  
  private List<BluedIngSelfFeed> c = new ArrayList<BluedIngSelfFeed>();
  
  private Set<String> d = new HashSet<String>();
  
  private int e = 1;
  
  private int f = 30;
  
  private IRequestHost g;
  
  private int h = -1;
  
  private boolean i = true;
  
  private boolean j = true;
  
  private BluedIngSelfFeed k = new BluedIngSelfFeed();
  
  private boolean l = false;
  
  private boolean m = false;
  
  private BluedUIHttpResponse n = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this, "shineVideoList", this.g) {
      public boolean a = false;
      
      protected void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
        super.onUICache((BluedEntity)param1BluedEntityA);
        if (ShineVideoDataManager.b(this.b) == 1) {
          ShineVideoDataManager.c(this.b).clear();
          ShineVideoDataManager.d(this.b).clear();
          if (ShineVideoDataManager.e(this.b) && ShineVideoDataManager.f(this.b) != null)
            ShineVideoDataManager.d(this.b).add(ShineVideoDataManager.f(this.b)); 
        } 
        List<BluedIngSelfFeed> list = ShineVideoDataManager.a(this.b, param1BluedEntityA);
        ShineVideoDataManager.d(this.b).addAll(list);
        if (ShineVideoDataManager.a(this.b) != null && ShineVideoDataManager.a(this.b).size() > 0)
          for (int i = 0; i < ShineVideoDataManager.a(this.b).size(); i++)
            ((ShineVideoDataManager.IShineVideoDataDownloadListner)ShineVideoDataManager.a(this.b).get(i)).b(list);  
      }
      
      protected void b(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
        if (ShineVideoDataManager.b(this.b) == 1) {
          ShineVideoDataManager.c(this.b).clear();
          ShineVideoDataManager.d(this.b).clear();
          if (ShineVideoDataManager.e(this.b) && ShineVideoDataManager.f(this.b) != null)
            ShineVideoDataManager.d(this.b).add(ShineVideoDataManager.f(this.b)); 
        } 
        int i = 0;
        Logger.b("ShineVideoDataManager", new Object[] { "onUIUpdate:", Integer.valueOf(ShineVideoDataManager.b(this.b)) });
        if (param1BluedEntityA != null) {
          ShineVideoDataManager.b(this.b, param1BluedEntityA.hasMore());
          List<BluedIngSelfFeed> list = ShineVideoDataManager.a(this.b, param1BluedEntityA);
          ShineVideoDataManager.d(this.b).addAll(list);
          if (ShineVideoDataManager.a(this.b) != null && ShineVideoDataManager.a(this.b).size() > 0)
            while (i < ShineVideoDataManager.a(this.b).size()) {
              ((ShineVideoDataManager.IShineVideoDataDownloadListner)ShineVideoDataManager.a(this.b).get(i)).a(param1BluedEntityA.hasMore(), list);
              i++;
            }  
        } 
      }
      
      public void onSuccess(String param1String) {
        super.onSuccess(param1String);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (ShineVideoDataManager.b(this.b) > 1)
          ShineVideoDataManager.g(this.b); 
        Logger.b("ShineVideoDataManager", new Object[] { "onHandleError:", Integer.valueOf(ShineVideoDataManager.b(this.b)) });
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        ShineVideoDataManager.a(this.b, true);
        if (ShineVideoDataManager.a(this.b) != null && ShineVideoDataManager.a(this.b).size() > 0)
          for (int i = 0; i < ShineVideoDataManager.a(this.b).size(); i++)
            ((ShineVideoDataManager.IShineVideoDataDownloadListner)ShineVideoDataManager.a(this.b).get(i)).a(this.a);  
      }
      
      public void onUIStart() {
        int i = 0;
        this.a = false;
        ShineVideoDataManager.a(this.b, false);
        if (ShineVideoDataManager.a(this.b) != null && ShineVideoDataManager.a(this.b).size() > 0)
          while (i < ShineVideoDataManager.a(this.b).size()) {
            ((ShineVideoDataManager.IShineVideoDataDownloadListner)ShineVideoDataManager.a(this.b).get(i)).onStart();
            i++;
          }  
        super.onUIStart();
      }
    };
  
  public static ShineVideoDataManager a() {
    if (a == null)
      a = new ShineVideoDataManager(); 
    return a;
  }
  
  private List<BluedIngSelfFeed> a(BluedEntityA<BluedIngSelfFeed> paramBluedEntityA) {
    ArrayList<BluedIngSelfFeed> arrayList = new ArrayList();
    if (paramBluedEntityA != null && paramBluedEntityA.data != null && paramBluedEntityA.data.size() > 0)
      for (int i = 0; i < paramBluedEntityA.data.size(); i++) {
        Set<String> set = this.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((BluedIngSelfFeed)paramBluedEntityA.data.get(i)).feed_id);
        stringBuilder.append(((BluedIngSelfFeed)paramBluedEntityA.data.get(i)).is_ads);
        if (!set.contains(stringBuilder.toString())) {
          arrayList.add(paramBluedEntityA.data.get(i));
          set = this.d;
          stringBuilder = new StringBuilder();
          stringBuilder.append(((BluedIngSelfFeed)paramBluedEntityA.data.get(i)).feed_id);
          stringBuilder.append(((BluedIngSelfFeed)paramBluedEntityA.data.get(i)).is_ads);
          set.add(stringBuilder.toString());
        } 
      }  
    return arrayList;
  }
  
  public void a(int paramInt) {
    this.h = paramInt;
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed == null)
      return; 
    int i = 0;
    this.l = false;
    this.m = false;
    Iterator<BluedIngSelfFeed> iterator = this.c.iterator();
    while (iterator.hasNext()) {
      if (TextUtils.equals(((BluedIngSelfFeed)iterator.next()).feed_id, paramBluedIngSelfFeed.feed_id)) {
        this.h = i;
        break;
      } 
      i++;
    } 
    this.k = paramBluedIngSelfFeed;
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBluedIngSelfFeed == null)
      return; 
    this.l = true;
    this.m = paramBoolean2;
    if (paramBoolean1)
      this.h = 0; 
    if (paramBoolean2) {
      this.k = paramBluedIngSelfFeed;
      return;
    } 
    if (this.c.size() > 0 && TextUtils.equals(paramBluedIngSelfFeed.feed_id, ((BluedIngSelfFeed)this.c.get(0)).feed_id))
      this.c.remove(0); 
    ArrayList<BluedIngSelfFeed> arrayList = new ArrayList();
    arrayList.add(paramBluedIngSelfFeed);
    this.c.addAll(0, arrayList);
    this.k = this.c.get(0);
  }
  
  public void a(IShineVideoDataDownloadListner paramIShineVideoDataDownloadListner) {
    this.b.add(paramIShineVideoDataDownloadListner);
  }
  
  public void a(String paramString1, String paramString2) {
    Logger.b("ShineVideoDataManager", new Object[] { "notifyAttentionChanged:", paramString1 });
    List<BluedIngSelfFeed> list = this.c;
    if (list == null)
      return; 
    for (BluedIngSelfFeed bluedIngSelfFeed : list) {
      if (TextUtils.equals(bluedIngSelfFeed.feed_id, paramString1)) {
        bluedIngSelfFeed.relationship = paramString2;
        c(bluedIngSelfFeed);
        break;
      } 
    } 
  }
  
  public void a(boolean paramBoolean, IRequestHost paramIRequestHost) {
    if (this.m)
      return; 
    this.g = paramIRequestHost;
    if (paramBoolean) {
      this.e = 1;
    } else {
      this.e++;
    } 
    FlashVideoHttpUtils.a(this.n, this.e, this.f, "", paramIRequestHost);
  }
  
  public List<BluedIngSelfFeed> b() {
    if (this.m) {
      ArrayList<BluedIngSelfFeed> arrayList = new ArrayList();
      arrayList.add(this.k);
      return arrayList;
    } 
    return this.c;
  }
  
  public void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    a(paramBluedIngSelfFeed, false, this.m);
  }
  
  public void b(IShineVideoDataDownloadListner paramIShineVideoDataDownloadListner) {
    this.b.remove(paramIShineVideoDataDownloadListner);
  }
  
  public BluedIngSelfFeed c() {
    return this.k;
  }
  
  public void c(BluedIngSelfFeed paramBluedIngSelfFeed) {
    int i = 0;
    Logger.b("ShineVideoDataManager", new Object[] { "notifyDataHasChanged" });
    List<IShineVideoDataDownloadListner> list = this.b;
    if (list != null && list.size() > 0)
      while (i < this.b.size()) {
        ((IShineVideoDataDownloadListner)this.b.get(i)).c(this.c);
        ((IShineVideoDataDownloadListner)this.b.get(i)).a(paramBluedIngSelfFeed);
        i++;
      }  
  }
  
  public void c(IShineVideoDataDownloadListner paramIShineVideoDataDownloadListner) {
    b(paramIShineVideoDataDownloadListner);
    if (this.l && !this.m) {
      if (this.c.size() > 0)
        this.c.remove(0); 
      List<IShineVideoDataDownloadListner> list = this.b;
      if (list != null && list.size() > 0)
        for (int i = 0; i < this.b.size(); i++)
          ((IShineVideoDataDownloadListner)this.b.get(i)).a(this.j, this.c);  
    } 
    this.l = false;
    this.m = false;
  }
  
  public void d() {
    if (this.l && !this.m) {
      this.c.clear();
      this.c.add(this.k);
      a(true, (IRequestHost)null);
    } 
  }
  
  public void d(BluedIngSelfFeed paramBluedIngSelfFeed) {
    BluedIngSelfFeed bluedIngSelfFeed;
    int i = 0;
    Logger.b("ShineVideoDataManager", new Object[] { "notifyDataHasRemove" });
    List<BluedIngSelfFeed> list1 = this.c;
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
      this.c.remove(bluedIngSelfFeed); 
    List<IShineVideoDataDownloadListner> list = this.b;
    if (list != null && list.size() > 0)
      while (i < this.b.size()) {
        ((IShineVideoDataDownloadListner)this.b.get(i)).b(paramBluedIngSelfFeed);
        i++;
      }  
  }
  
  public boolean e() {
    return this.l;
  }
  
  public int f() {
    return this.e;
  }
  
  public boolean g() {
    return this.i;
  }
  
  public boolean h() {
    return this.j;
  }
  
  public BluedUIHttpResponse i() {
    return this.n;
  }
  
  public int j() {
    return this.h;
  }
  
  public static interface IShineVideoDataDownloadListner {
    void a(BluedIngSelfFeed param1BluedIngSelfFeed);
    
    void a(boolean param1Boolean);
    
    void a(boolean param1Boolean, List<BluedIngSelfFeed> param1List);
    
    void b(BluedIngSelfFeed param1BluedIngSelfFeed);
    
    void b(List<BluedIngSelfFeed> param1List);
    
    void c(List<BluedIngSelfFeed> param1List);
    
    void onStart();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\manager\ShineVideoDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */