package com.soft.blued.ui.find.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.das.guy.GuyProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.ab_test.models.ShortEntranceExtra;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.model.AdvertFloatExtra;
import com.soft.blued.ui.find.model.AdvertFloatModel;
import com.soft.blued.ui.find.model.CallHelloModel;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.FindDataExtra;
import com.soft.blued.ui.find.model.FindRecommendData;
import com.soft.blued.ui.find.model.FindRecommendExtra;
import com.soft.blued.ui.find.model.JoyEntryModel;
import com.soft.blued.ui.find.model.NearbyChatRoomModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.CallHelloObserver;
import com.soft.blued.ui.find.observer.FloatRedBagViewScrollObserver;
import com.soft.blued.ui.find.observer.NearbyPeopleTabSelectedObserver;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.find.observer.PeopleDataObserver;
import com.soft.blued.ui.find.observer.SetModelObserver;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.live.model.LiveTwoFloorModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.List;

public class NearbyPeoplePresenter extends MvpPresenter implements CallHelloObserver.ICallHelloObserver, FloatRedBagViewScrollObserver.IFloatRedBagViewScrollObserver, NearbyPeopleTabSelectedObserver.INearbyPeopleTabSelectedObserver, PeopleDataObserver.IFriendsDataRefreshObserver, SetModelObserver.ISetModelObserver {
  public boolean h;
  
  public AdvertFloatModel i;
  
  public String j = null;
  
  public int k;
  
  public int l;
  
  public int m = 0;
  
  public int n = 1;
  
  public boolean o = true;
  
  public boolean p;
  
  public boolean q = false;
  
  public List<UserFindResult> r;
  
  public BluedUIHttpResponse s = new BluedUIHttpResponse<BluedEntity<JoyEntryModel, ShortEntranceExtra>>(this, "joy_enter_btest", v()) {
      public void onUICache(BluedEntity<JoyEntryModel, ShortEntranceExtra> param1BluedEntity) {
        super.onUICache(param1BluedEntity);
        if (param1BluedEntity != null)
          this.a.a("entry_data_cache", param1BluedEntity.extra, false); 
      }
      
      public void onUIUpdate(BluedEntity<JoyEntryModel, ShortEntranceExtra> param1BluedEntity) {
        if (param1BluedEntity != null)
          this.a.a("entry_data", param1BluedEntity.extra, false); 
      }
    };
  
  public BluedEntity<FindRecommendData, FindRecommendExtra> t;
  
  private int u = 60;
  
  private FilterEntity v = new FilterEntity();
  
  private Observer<String> w = new Observer<String>(this) {
      public void a(String param1String) {
        this.a.a(" header_two_level", false);
      }
    };
  
  private BluedUIHttpResponse<BluedEntityA<LiveTwoFloorModel>> x = new BluedUIHttpResponse<BluedEntityA<LiveTwoFloorModel>>(this, v()) {
      protected void a(BluedEntityA<LiveTwoFloorModel> param1BluedEntityA) {
        if (param1BluedEntityA != null) {
          if (param1BluedEntityA.hasData()) {
            this.a.a("two_level", param1BluedEntityA.data);
            return;
          } 
          this.a.b("two_level_no_data");
          return;
        } 
        this.a.b("two_level_no_data");
      }
    };
  
  private IRequestHost v() {
    return (IRequestHost)((h() instanceof BaseFragmentActivity) ? ((BaseFragmentActivity)h()).a() : null);
  }
  
  public BluedUIHttpResponse a(IFetchDataListener paramIFetchDataListener, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("nearby_user_");
    stringBuilder.append(this.j);
    return new BluedUIHttpResponse<BluedEntity<UserFindResult, FindDataExtra>>(this, stringBuilder.toString(), v(), paramString, paramIFetchDataListener) {
        public void onUICache(BluedEntity<UserFindResult, FindDataExtra> param1BluedEntity) {
          super.onUICache(param1BluedEntity);
          if (param1BluedEntity != null) {
            this.c.a("people_data", param1BluedEntity.data, false);
            this.c.a("people_data_extra_cache", param1BluedEntity.extra, false);
          } 
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean) {
            NearbyPeoplePresenter nearbyPeoplePresenter = this.c;
            nearbyPeoplePresenter.n--;
          } 
          if (!this.c.p) {
            IFetchDataListener iFetchDataListener1 = this.b;
            if (iFetchDataListener1 != null)
              iFetchDataListener1.b(); 
          } 
          IFetchDataListener iFetchDataListener = this.b;
          if (iFetchDataListener != null)
            iFetchDataListener.a(param1Boolean); 
        }
        
        public void onUIStart() {
          super.onUIStart();
          NearbyPeoplePresenter nearbyPeoplePresenter = this.c;
          nearbyPeoplePresenter.m++;
        }
        
        public void onUIUpdate(BluedEntity<UserFindResult, FindDataExtra> param1BluedEntity) {
          String str = NearbyPeoplePresenter.class.getSimpleName();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("people onUIUpdate=====");
          stringBuilder.append(param1BluedEntity.data.size());
          Logger.c(str, new Object[] { stringBuilder.toString() });
          if (!TextUtils.isEmpty(this.c.j) && this.c.j.equals(this.a)) {
            if (param1BluedEntity != null) {
              this.c.a("people_data", param1BluedEntity.data, false);
              this.c.a("people_data_extra", param1BluedEntity.extra, false);
              this.c.a("refresh_num_plus", false);
              this.c.a(" show_chat_room", Integer.valueOf(10));
              this.c.p = param1BluedEntity.hasMore();
            } else {
              this.c.p = false;
            } 
            if (!this.c.g().isActive())
              this.c.r = param1BluedEntity.data; 
          } 
        }
        
        public BluedEntity<UserFindResult, FindDataExtra> parseData(String param1String) {
          BluedEntity<UserFindResult, FindDataExtra> bluedEntity = super.parseData(param1String);
          if (bluedEntity != null && bluedEntity.hasData())
            for (int i = 0; i < bluedEntity.data.size(); i++) {
              ((UserFindResult)bluedEntity.data.get(i)).distanceStr = DistanceUtils.a(((UserFindResult)bluedEntity.data.get(i)).distance, BlueAppLocal.c(), false);
              ((UserFindResult)bluedEntity.data.get(i)).last_operate_time_stamp = ((UserFindResult)bluedEntity.data.get(i)).last_operate;
              ((UserFindResult)bluedEntity.data.get(i)).last_operate_str = TimeAndDateUtils.a((Context)this.c.h(), TimeAndDateUtils.b(((UserFindResult)bluedEntity.data.get(i)).last_operate));
            }  
          return bluedEntity;
        }
      };
  }
  
  public void a(int paramInt) {
    a("notify_model", Integer.valueOf(paramInt), false);
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.l = PeopleGridQuickAdapter.a((Context)h());
    m();
    this.k = BluedPreferences.I();
    a(this.k);
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    PeopleDataObserver.a().a(this);
    SetModelObserver.a().a(this);
    FloatRedBagViewScrollObserver.a().a(this);
    NearbyPeopleTabSelectedObserver.a().a(this);
    CallHelloObserver.a().a(this, paramLifecycleOwner.getLifecycle());
    Log.v("drb", "onRegisterLiveListener");
    paramLifecycleOwner.getLifecycle().addObserver(new LifecycleObserver(this, paramLifecycleOwner) {
          @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
          public void onDestroy() {
            Log.v("drb", "unRegistorObserver");
            PeopleDataObserver.a().b(this.b);
            SetModelObserver.a().b(this.b);
            FloatRedBagViewScrollObserver.a().b(this.b);
            NearbyPeopleTabSelectedObserver.a().b(this.b);
            LiveEventBus.get("live_back_to_two_level", String.class).removeObserver(NearbyPeoplePresenter.a(this.b));
            this.a.getLifecycle().removeObserver(this);
          }
        });
    if (HomeActivity.c != null) {
      NearbyViewModel nearbyViewModel = (NearbyViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(NearbyViewModel.class);
      LiveEventBus.get("map_find_click", Boolean.class).observeForever(new -$$Lambda$NearbyPeoplePresenter$Wrn0Xt9Re5IRXWgEJmCQF51meMw(this));
      nearbyViewModel.b.observe(paramLifecycleOwner, new Observer<Void>(this) {
            public void a(Void param1Void) {
              this.a.a("list_mode", false);
            }
          });
    } 
    LiveEventBus.get("skin_blued", Boolean.class).observe(paramLifecycleOwner, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            this.a.a("sort_by_view", false);
          }
        });
    LiveEventBus.get("live_float_dismiss", String.class).observe(paramLifecycleOwner, new -$$Lambda$NearbyPeoplePresenter$c32nbp6nK2I0MooX-2PxsHoh-pU(this));
    LiveEventBus.get("live_back_to_two_level", String.class).observeForever(this.w);
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    Log.v("drb", "onFetchData");
    this.n = 1;
    c(paramIFetchDataListener);
    n();
  }
  
  public void a(CallMeStatusData paramCallMeStatusData) {
    a("set_call_data_update", paramCallMeStatusData);
  }
  
  public void a(String paramString) {
    a("selected_tab", paramString);
  }
  
  public void a(boolean paramBoolean) {
    FindHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<NearbyChatRoomModel>>(this, v(), paramBoolean) {
          protected void a(BluedEntityA<NearbyChatRoomModel> param1BluedEntityA) {
            NearbyChatRoomModel nearbyChatRoomModel = (NearbyChatRoomModel)param1BluedEntityA.getSingleData();
            this.b.a(" show_chat_room", nearbyChatRoomModel);
            if (this.a && nearbyChatRoomModel != null && nearbyChatRoomModel.show) {
              EventTrackGuy.b(GuyProtos.Event.NEARBY_CHATROOM_ENTRY_SHOW);
              Log.v("drb", "上抛埋点");
            } 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
        });
  }
  
  public void a(boolean paramBoolean, String paramString) {
    CallHelloModel callHelloModel = new CallHelloModel();
    callHelloModel.isShowCount = paramBoolean;
    callHelloModel.count = paramString;
    a("count_update", callHelloModel);
  }
  
  public void b(int paramInt) {
    CallHelloModel callHelloModel = new CallHelloModel();
    callHelloModel.countDown = paramInt;
    a("set_time_update", callHelloModel);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.n++;
    c(paramIFetchDataListener);
  }
  
  public void c(int paramInt) {
    this.k = paramInt;
    BluedPreferences.a(paramInt);
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    String str;
    int i = this.u;
    int j = this.n;
    this.v.sort_by = this.j;
    if (MapFindManager.a().b()) {
      this.v.longitude = (MapFindManager.a().c()).a;
      this.v.latitude = (MapFindManager.a().c()).b;
      this.v.source = "map";
    } else {
      this.v.longitude = BluedPreferences.s();
      this.v.latitude = BluedPreferences.t();
      this.v.source = null;
    } 
    FilterEntity filterEntity2 = this.v;
    filterEntity2.nickName = "";
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.u);
    stringBuilder2.append("");
    filterEntity2.limit = stringBuilder2.toString();
    filterEntity2 = this.v;
    filterEntity2.column = this.l;
    filterEntity2.scroll_type = BluedPreferences.C();
    FilterEntity filterEntity3 = this.v;
    if (UserInfo.a().i() == null) {
      str = "";
    } else {
      str = UserInfo.a().i().getCustom();
    } 
    filterEntity3.custom = str;
    FilterEntity filterEntity1 = this.v;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(i * (j - 1));
    stringBuilder1.append("");
    filterEntity1.start = stringBuilder1.toString();
    if (h() != null)
      NearbyHttpUtils.a((Context)h(), a(paramIFetchDataListener, this.j), this.v, "", v()); 
  }
  
  public void k() {
    Log.v("drb", "onFetchCache");
    this.s.refresh();
    a((IFetchDataListener)null, this.j).refresh();
  }
  
  public void m() {
    NearbyHttpUtils.a(new BluedUIHttpResponse<BluedEntity<AdvertFloatModel, AdvertFloatExtra>>(this, v()) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {}
          
          public void onUIUpdate(BluedEntity<AdvertFloatModel, AdvertFloatExtra> param1BluedEntity) {
            // Byte code:
            //   0: iconst_1
            //   1: istore_2
            //   2: aload_1
            //   3: ifnull -> 43
            //   6: aload_1
            //   7: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
            //   10: ifnull -> 43
            //   13: aload_1
            //   14: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
            //   17: checkcast com/soft/blued/ui/find/model/AdvertFloatExtra
            //   20: getfield is_after_splash : I
            //   23: iconst_1
            //   24: if_icmpne -> 30
            //   27: goto -> 45
            //   30: invokestatic bC : ()Z
            //   33: ifne -> 39
            //   36: goto -> 45
            //   39: iconst_0
            //   40: invokestatic C : (Z)V
            //   43: iconst_0
            //   44: istore_2
            //   45: iload_2
            //   46: ifeq -> 217
            //   49: aload_1
            //   50: ifnull -> 217
            //   53: aload_1
            //   54: getfield data : Ljava/util/List;
            //   57: ifnull -> 217
            //   60: aload_1
            //   61: getfield data : Ljava/util/List;
            //   64: invokeinterface size : ()I
            //   69: ifle -> 217
            //   72: aload_0
            //   73: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   76: aload_1
            //   77: getfield data : Ljava/util/List;
            //   80: iconst_0
            //   81: invokeinterface get : (I)Ljava/lang/Object;
            //   86: checkcast com/soft/blued/ui/find/model/AdvertFloatModel
            //   89: putfield i : Lcom/soft/blued/ui/find/model/AdvertFloatModel;
            //   92: aload_0
            //   93: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   96: getfield i : Lcom/soft/blued/ui/find/model/AdvertFloatModel;
            //   99: ifnull -> 217
            //   102: aload_0
            //   103: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   106: getfield i : Lcom/soft/blued/ui/find/model/AdvertFloatModel;
            //   109: getfield images : Lcom/soft/blued/ui/find/model/AdvertFloatModel$ImageModel;
            //   112: ifnull -> 217
            //   115: getstatic com/blued/android/core/AppInfo.l : I
            //   118: sipush #720
            //   121: if_icmplt -> 150
            //   124: aload_0
            //   125: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   128: getfield i : Lcom/soft/blued/ui/find/model/AdvertFloatModel;
            //   131: aload_0
            //   132: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   135: getfield i : Lcom/soft/blued/ui/find/model/AdvertFloatModel;
            //   138: getfield images : Lcom/soft/blued/ui/find/model/AdvertFloatModel$ImageModel;
            //   141: getfield _795x1020 : Ljava/lang/String;
            //   144: putfield advert_pic : Ljava/lang/String;
            //   147: goto -> 173
            //   150: aload_0
            //   151: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   154: getfield i : Lcom/soft/blued/ui/find/model/AdvertFloatModel;
            //   157: aload_0
            //   158: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   161: getfield i : Lcom/soft/blued/ui/find/model/AdvertFloatModel;
            //   164: getfield images : Lcom/soft/blued/ui/find/model/AdvertFloatModel$ImageModel;
            //   167: getfield _530x680 : Ljava/lang/String;
            //   170: putfield advert_pic : Ljava/lang/String;
            //   173: aload_0
            //   174: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   177: invokestatic b : (Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;)Lcom/blued/android/core/net/IRequestHost;
            //   180: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;)Lcom/blued/android/core/image/ImageFileWrapper;
            //   183: aload_0
            //   184: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   187: getfield i : Lcom/soft/blued/ui/find/model/AdvertFloatModel;
            //   190: getfield advert_pic : Ljava/lang/String;
            //   193: invokevirtual a : (Ljava/lang/String;)Lcom/blued/android/core/image/ImageFileWrapper;
            //   196: new com/soft/blued/ui/find/presenter/NearbyPeoplePresenter$5$1
            //   199: dup
            //   200: aload_0
            //   201: aload_0
            //   202: getfield a : Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;
            //   205: invokestatic b : (Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter;)Lcom/blued/android/core/net/IRequestHost;
            //   208: invokespecial <init> : (Lcom/soft/blued/ui/find/presenter/NearbyPeoplePresenter$5;Lcom/blued/android/core/net/IRequestHost;)V
            //   211: invokevirtual a : (Lcom/blued/android/core/image/ImageLoadResult;)Lcom/blued/android/core/image/ImageFileWrapper;
            //   214: invokevirtual a : ()V
            //   217: return
          }
        }v());
  }
  
  public void n() {
    NearbyHttpUtils.a(this.s, v(), UserInfo.a().i().getUid(), "full_index");
  }
  
  public void o() {
    Log.v("drb", "getMakeFriendRecommend -- ");
    FindHttpUtils.b(new BluedUIHttpResponse<BluedEntity<FindRecommendData, FindRecommendExtra>>(this, v()) {
          public void onUIFinish() {
            this.a.b("make_friend_recommend");
            super.onUIFinish();
          }
          
          public void onUIUpdate(BluedEntity<FindRecommendData, FindRecommendExtra> param1BluedEntity) {
            if (param1BluedEntity.hasData() || param1BluedEntity.extra != null)
              this.a.t = param1BluedEntity; 
          }
        }v());
  }
  
  public void p() {
    a("people_data_refresh", false);
  }
  
  public void q() {
    b("home_refresh");
  }
  
  public void r() {
    LiveHttpUtils.a(2, this.x, v());
  }
  
  public FilterEntity s() {
    return this.v;
  }
  
  public boolean t() {
    return (this.k == 0);
  }
  
  public boolean u() {
    return (this.k == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\presenter\NearbyPeoplePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */