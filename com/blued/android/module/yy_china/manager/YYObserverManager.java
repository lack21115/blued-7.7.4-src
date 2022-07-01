package com.blued.android.module.yy_china.manager;

import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.observer.AudienceCountObserver;
import com.blued.android.module.yy_china.observer.AudiencesChangedObserver;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.observer.GiftBeansObserver;
import com.blued.android.module.yy_china.observer.GiftObserver;
import com.blued.android.module.yy_china.observer.IMMessageObserver;
import com.blued.android.module.yy_china.observer.RoleStatusObserver;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.observer.WaittingCountObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class YYObserverManager {
  private List<AudienceCountObserver> a = new ArrayList<AudienceCountObserver>();
  
  private List<FollowStatusObserver> b = new ArrayList<FollowStatusObserver>();
  
  private List<IMMessageObserver> c = new ArrayList<IMMessageObserver>();
  
  private List<WaittingCountObserver> d = new ArrayList<WaittingCountObserver>();
  
  private List<RoleStatusObserver> e = new ArrayList<RoleStatusObserver>();
  
  private List<AudiencesChangedObserver> f = new ArrayList<AudiencesChangedObserver>();
  
  private List<SeatChangedObserver> g = new ArrayList<SeatChangedObserver>();
  
  private List<GiftBeansObserver> h = new ArrayList<GiftBeansObserver>();
  
  private List<GiftObserver> i = new ArrayList<GiftObserver>();
  
  private YYObserverManager() {}
  
  public static YYObserverManager a() {
    return Manager.a;
  }
  
  public void a(int paramInt) {
    List<AudienceCountObserver> list = this.a;
    if (list == null)
      return; 
    Iterator<AudienceCountObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((AudienceCountObserver)iterator.next()).a(paramInt); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    List<SeatChangedObserver> list = this.g;
    if (list == null)
      return; 
    Iterator<SeatChangedObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((SeatChangedObserver)iterator.next()).a(paramInt1, paramInt2); 
  }
  
  public void a(YYImModel paramYYImModel) {
    List<IMMessageObserver> list = this.c;
    if (list == null)
      return; 
    Iterator<IMMessageObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((IMMessageObserver)iterator.next()).a(paramYYImModel); 
  }
  
  public void a(YYImModel paramYYImModel, boolean paramBoolean) {
    List<GiftObserver> list = this.i;
    if (list == null)
      return; 
    Iterator<GiftObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((GiftObserver)iterator.next()).a(paramYYImModel, paramBoolean); 
  }
  
  public void a(AudienceCountObserver paramAudienceCountObserver) {
    List<AudienceCountObserver> list = this.a;
    if (list == null)
      return; 
    list.add(paramAudienceCountObserver);
  }
  
  public void a(AudiencesChangedObserver paramAudiencesChangedObserver) {
    List<AudiencesChangedObserver> list = this.f;
    if (list == null)
      return; 
    list.add(paramAudiencesChangedObserver);
  }
  
  public void a(FollowStatusObserver paramFollowStatusObserver) {
    List<FollowStatusObserver> list = this.b;
    if (list == null)
      return; 
    list.add(paramFollowStatusObserver);
  }
  
  public void a(GiftBeansObserver paramGiftBeansObserver) {
    List<GiftBeansObserver> list = this.h;
    if (list == null)
      return; 
    list.add(paramGiftBeansObserver);
  }
  
  public void a(GiftObserver paramGiftObserver) {
    List<GiftObserver> list = this.i;
    if (list == null)
      return; 
    list.add(paramGiftObserver);
  }
  
  public void a(IMMessageObserver paramIMMessageObserver) {
    List<IMMessageObserver> list = this.c;
    if (list == null)
      return; 
    list.add(paramIMMessageObserver);
  }
  
  public void a(RoleStatusObserver paramRoleStatusObserver) {
    List<RoleStatusObserver> list = this.e;
    if (list == null)
      return; 
    list.add(paramRoleStatusObserver);
  }
  
  public void a(SeatChangedObserver paramSeatChangedObserver) {
    List<SeatChangedObserver> list = this.g;
    if (list == null)
      return; 
    list.add(paramSeatChangedObserver);
  }
  
  public void a(WaittingCountObserver paramWaittingCountObserver) {
    List<WaittingCountObserver> list = this.d;
    if (list == null)
      return; 
    list.add(paramWaittingCountObserver);
  }
  
  public void a(String paramString) {
    List<RoleStatusObserver> list = this.e;
    if (list == null)
      return; 
    Iterator<RoleStatusObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((RoleStatusObserver)iterator.next()).a(paramString); 
  }
  
  public void a(String paramString1, String paramString2) {
    List<FollowStatusObserver> list = this.b;
    if (list == null)
      return; 
    Iterator<FollowStatusObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((FollowStatusObserver)iterator.next()).a(paramString1, paramString2); 
  }
  
  public void a(List<YYAudienceModel> paramList) {
    List<AudiencesChangedObserver> list = this.f;
    if (list == null)
      return; 
    Iterator<AudiencesChangedObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((AudiencesChangedObserver)iterator.next()).a(paramList); 
  }
  
  public void b() {
    this.a.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.h.clear();
    this.i.clear();
  }
  
  public void b(int paramInt) {
    List<WaittingCountObserver> list = this.d;
    if (list == null)
      return; 
    Iterator<WaittingCountObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((WaittingCountObserver)iterator.next()).a(paramInt); 
  }
  
  public void b(AudienceCountObserver paramAudienceCountObserver) {
    List<AudienceCountObserver> list = this.a;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.a.remove(paramAudienceCountObserver);
    } 
  }
  
  public void b(AudiencesChangedObserver paramAudiencesChangedObserver) {
    List<AudiencesChangedObserver> list = this.f;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.f.remove(paramAudiencesChangedObserver);
    } 
  }
  
  public void b(FollowStatusObserver paramFollowStatusObserver) {
    List<FollowStatusObserver> list = this.b;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.b.remove(paramFollowStatusObserver);
    } 
  }
  
  public void b(GiftBeansObserver paramGiftBeansObserver) {
    List<GiftBeansObserver> list = this.h;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.h.remove(paramGiftBeansObserver);
    } 
  }
  
  public void b(IMMessageObserver paramIMMessageObserver) {
    List<IMMessageObserver> list = this.c;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.c.remove(paramIMMessageObserver);
    } 
  }
  
  public void b(RoleStatusObserver paramRoleStatusObserver) {
    List<RoleStatusObserver> list = this.e;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.e.remove(paramRoleStatusObserver);
    } 
  }
  
  public void b(SeatChangedObserver paramSeatChangedObserver) {
    List<SeatChangedObserver> list = this.g;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.g.remove(paramSeatChangedObserver);
    } 
  }
  
  public void b(WaittingCountObserver paramWaittingCountObserver) {
    List<WaittingCountObserver> list = this.d;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.d.remove(paramWaittingCountObserver);
    } 
  }
  
  public void b(String paramString) {
    List<GiftBeansObserver> list = this.h;
    if (list == null)
      return; 
    Iterator<GiftBeansObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((GiftBeansObserver)iterator.next()).a(paramString); 
  }
  
  public void b(List<YYSeatMemberModel> paramList) {
    List<SeatChangedObserver> list = this.g;
    if (list == null)
      return; 
    Iterator<SeatChangedObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((SeatChangedObserver)iterator.next()).b(paramList); 
  }
  
  public void c(int paramInt) {
    List<RoleStatusObserver> list = this.e;
    if (list == null)
      return; 
    Iterator<RoleStatusObserver> iterator = list.iterator();
    while (iterator.hasNext())
      ((RoleStatusObserver)iterator.next()).a(paramInt); 
  }
  
  public static class Manager {
    public static YYObserverManager a = new YYObserverManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\manager\YYObserverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */