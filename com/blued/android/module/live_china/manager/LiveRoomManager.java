package com.blued.android.module.live_china.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.model.FirstChargeGift;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomViewerModel;
import com.blued.android.module.live_china.model.LiveTaskModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LiveRoomManager {
  private static volatile LiveRoomManager b;
  
  public LiveRoomData a;
  
  private final LiveRoomData c = new LiveRoomData();
  
  private LiveFansInfoModel d;
  
  private LiveLiangModel e;
  
  private short f = 4;
  
  private int g;
  
  private final List<ProfileData> h = new ArrayList<ProfileData>();
  
  private final List<ProfileData> i = new ArrayList<ProfileData>();
  
  private int j;
  
  private LiveTaskModel k;
  
  private final List<ChattingModel> l = new ArrayList<ChattingModel>();
  
  private final List<ChattingModel> m = new ArrayList<ChattingModel>();
  
  private final List<ChattingModel> n = new ArrayList<ChattingModel>();
  
  private boolean o = false;
  
  private int p;
  
  private FirstChargeGift q;
  
  private boolean r = false;
  
  private Handler s = new Handler(this, Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        if (LiveRoomManager.a(this.a).size() != 0) {
          LiveRoomManager.b(this.a);
          return;
        } 
        if (this.a.b() != 0L)
          this.a.v(); 
      }
    };
  
  private void D() {
    LogUtils.c("start");
    y();
  }
  
  private void E() {
    ChattingModel chattingModel = x();
    if (chattingModel == null) {
      y();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("send ");
    stringBuilder.append(chattingModel.msgType);
    stringBuilder.append(", ");
    stringBuilder.append(chattingModel.msgContent);
    LogUtils.c(stringBuilder.toString());
    if (chattingModel.msgMapExtra == null)
      chattingModel.msgMapExtra = new HashMap<Object, Object>(); 
    chattingModel.msgMapExtra.put("is_history_data", Integer.valueOf(1));
    LiveEventBusUtil.a(chattingModel);
    y();
  }
  
  public static LiveRoomManager a() {
    // Byte code:
    //   0: ldc com/blued/android/module/live_china/manager/LiveRoomManager
    //   2: monitorenter
    //   3: getstatic com/blued/android/module/live_china/manager/LiveRoomManager.b : Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   6: ifnonnull -> 19
    //   9: new com/blued/android/module/live_china/manager/LiveRoomManager
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/blued/android/module/live_china/manager/LiveRoomManager.b : Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   19: ldc com/blued/android/module/live_china/manager/LiveRoomManager
    //   21: monitorexit
    //   22: getstatic com/blued/android/module/live_china/manager/LiveRoomManager.b : Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   25: areturn
    //   26: astore_0
    //   27: ldc com/blued/android/module/live_china/manager/LiveRoomManager
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	26	finally
    //   19	22	26	finally
    //   27	30	26	finally
  }
  
  public int A() {
    return this.p;
  }
  
  public boolean B() {
    return (this.p == 1);
  }
  
  public boolean C() {
    return this.r;
  }
  
  public void a(double paramDouble) {
    if (paramDouble >= 0.0D)
      this.c.beans_count = paramDouble; 
  }
  
  public void a(double paramDouble1, double paramDouble2) {
    a(paramDouble1);
    b(paramDouble2);
    LiveEventBusUtil.a();
  }
  
  public void a(int paramInt) {
    this.p = paramInt;
  }
  
  public void a(long paramLong, int paramInt) {
    Iterator<ProfileData> iterator = this.i.iterator();
    while (iterator.hasNext()) {
      ProfileData profileData = iterator.next();
      if (profileData == null) {
        iterator.remove();
        continue;
      } 
      if (profileData.uid == paramLong) {
        iterator.remove();
        break;
      } 
    } 
    this.j = paramInt;
    LiveSetDataObserver.a().q();
    LiveSetDataObserver.a().r();
  }
  
  public void a(long paramLong, List<LiveRoomViewerModel> paramList, int paramInt) {
    if (paramLong != b())
      return; 
    this.i.clear();
    for (LiveRoomViewerModel liveRoomViewerModel : paramList) {
      ProfileData profileData = new ProfileData();
      profileData.uid = liveRoomViewerModel.uid;
      profileData.avatar = liveRoomViewerModel.avatar;
      profileData.vBadge = liveRoomViewerModel.vbadge;
      profileData.liangId = liveRoomViewerModel.liang_id;
      profileData.liangType = liveRoomViewerModel.liang_type;
      this.i.add(profileData);
    } 
    this.j = paramInt;
    LiveSetDataObserver.a().q();
    LiveSetDataObserver.a().r();
  }
  
  public void a(ProfileData paramProfileData, int paramInt) {
    if (paramProfileData == null)
      return; 
    Iterator<ProfileData> iterator = this.i.iterator();
    while (iterator.hasNext()) {
      ProfileData profileData = iterator.next();
      if (profileData == null) {
        iterator.remove();
        continue;
      } 
      if (profileData.uid == paramProfileData.uid) {
        iterator.remove();
        break;
      } 
    } 
    this.i.add(0, paramProfileData);
    this.j = paramInt;
    LiveSetDataObserver.a().q();
    LiveSetDataObserver.a().r();
  }
  
  public void a(ChattingModel paramChattingModel) {
    this.l.add(paramChattingModel);
  }
  
  public void a(FirstChargeGift paramFirstChargeGift) {
    this.q = paramFirstChargeGift;
    LiveEventBusUtil.a(paramFirstChargeGift);
  }
  
  public void a(LiveFansInfoModel paramLiveFansInfoModel) {
    this.d = paramLiveFansInfoModel;
  }
  
  public void a(LiveLiangModel paramLiveLiangModel) {
    this.e = paramLiveLiangModel;
  }
  
  public void a(LiveRoomData paramLiveRoomData) {
    if (paramLiveRoomData != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("roomId: ");
      stringBuilder.append(paramLiveRoomData.lid);
      LogUtils.c(stringBuilder.toString());
      this.c.copyModel(paramLiveRoomData);
      this.e = new LiveLiangModel();
      this.e.liang_type = paramLiveRoomData.liang_type;
      this.e.liang_id = paramLiveRoomData.liang_id;
      LiveDataManager.a().a(paramLiveRoomData.lid);
    } 
  }
  
  public void a(LiveTaskModel paramLiveTaskModel) {
    this.k = paramLiveTaskModel;
  }
  
  public void a(List<ProfileData> paramList) {
    this.h.clear();
    if (paramList != null)
      this.h.addAll(paramList); 
  }
  
  public void a(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  public long b() {
    return this.c.lid;
  }
  
  public void b(double paramDouble) {
    if (paramDouble > this.c.beans_current_count)
      this.c.beans_current_count = paramDouble; 
  }
  
  public void b(ChattingModel paramChattingModel) {
    this.n.add(paramChattingModel);
  }
  
  public void b(LiveRoomData paramLiveRoomData) {
    if (paramLiveRoomData == null) {
      this.a = null;
      return;
    } 
    this.a = new LiveRoomData();
    ReflectionUtils.a(paramLiveRoomData, this.a);
  }
  
  public void b(List<ChattingModel> paramList) {
    if (paramList == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("data size:");
    stringBuilder.append(paramList.size());
    LogUtils.c(stringBuilder.toString());
    this.m.clear();
    this.m.addAll(paramList);
    D();
  }
  
  public void b(boolean paramBoolean) {
    this.r = paramBoolean;
  }
  
  public String c() {
    return String.valueOf(this.c.lid);
  }
  
  public long d() {
    return (this.c.profile != null) ? this.c.profile.getUid() : 0L;
  }
  
  public String e() {
    return (this.c.profile != null) ? this.c.profile.uid : "";
  }
  
  public short f() {
    return this.f;
  }
  
  public void g() {
    this.c.reset();
    this.f = 4;
    this.g = 0;
    this.h.clear();
    this.i.clear();
    this.k = null;
    this.p = 0;
    LiveDataManager.a().b();
    u();
  }
  
  public LiveRoomData h() {
    return this.c;
  }
  
  public LiveFansInfoModel i() {
    return this.d;
  }
  
  public LiveLiangModel j() {
    return this.e;
  }
  
  public boolean k() {
    return (this.c.level >= 5);
  }
  
  public boolean l() {
    return (this.c.profile == null || this.c.profile.getUid() <= 0L);
  }
  
  public double m() {
    return this.c.beans_count;
  }
  
  public double n() {
    return this.c.beans_current_count;
  }
  
  public int o() {
    return this.j;
  }
  
  public List<ProfileData> p() {
    return this.i;
  }
  
  public List<ProfileData> q() {
    return this.h;
  }
  
  public LiveTaskModel r() {
    return this.k;
  }
  
  public LiveRoomData s() {
    return this.a;
  }
  
  public List<ChattingModel> t() {
    return this.l;
  }
  
  public void u() {
    this.s.removeCallbacksAndMessages(null);
    this.l.clear();
    this.n.clear();
    this.m.clear();
    this.o = false;
  }
  
  public void v() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onHistoryCompleted duration data size:");
    stringBuilder.append(this.n.size());
    LogUtils.c(stringBuilder.toString());
    this.o = false;
    if (this.n.size() != 0) {
      Iterator<ChattingModel> iterator = this.n.iterator();
      while (iterator.hasNext())
        LiveEventBusUtil.a(iterator.next()); 
    } 
  }
  
  public boolean w() {
    return this.o;
  }
  
  public ChattingModel x() {
    return (this.m.size() > 0) ? this.m.remove(0) : null;
  }
  
  public void y() {
    Handler handler = this.s;
    if (handler != null)
      handler.sendEmptyMessageDelayed(1, 500L); 
  }
  
  public FirstChargeGift z() {
    return this.q;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\LiveRoomManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */