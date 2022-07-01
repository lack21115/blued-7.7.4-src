package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.observer.AlbumViewObserver;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.user.adapter.AlbumAdapterNew;
import com.soft.blued.ui.user.model.AlbumDataForJsonParse;
import com.soft.blued.ui.user.model.AlbumFlow;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.ui.user.observer.AlbumDataObserver;
import com.soft.blued.ui.user.observer.UserinfoFeedScrollObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserinfoFragmentAlbumTab extends BaseFragment implements AlbumViewObserver.IAblumViewObserver, AlbumDataObserver.IAlbumObserver {
  public Context d;
  
  public View e;
  
  public SmartRefreshLayout f;
  
  public RecyclerView g;
  
  public UserBasicModel h;
  
  private NoDataAndLoadFailView i;
  
  private int j = 1;
  
  private int k = 20;
  
  private boolean l = true;
  
  private AlbumAdapterNew m;
  
  private AlbumForDataTrans n;
  
  private int o = 3;
  
  private View p;
  
  private boolean q = true;
  
  public static UserinfoFragmentAlbumTab a(UserBasicModel paramUserBasicModel) {
    UserinfoFragmentAlbumTab userinfoFragmentAlbumTab = new UserinfoFragmentAlbumTab();
    Bundle bundle = new Bundle();
    bundle.putSerializable("user", (Serializable)paramUserBasicModel);
    userinfoFragmentAlbumTab.setArguments(bundle);
    return userinfoFragmentAlbumTab;
  }
  
  private void a(BluedEntityA<AlbumDataForJsonParse> paramBluedEntityA) {
    this.l = paramBluedEntityA.hasMore();
    if (paramBluedEntityA.hasData()) {
      ArrayList<AlbumFlow> arrayList = new ArrayList();
      for (AlbumDataForJsonParse albumDataForJsonParse : paramBluedEntityA.data) {
        if (albumDataForJsonParse.feed != null) {
          boolean bool = "1".equals(albumDataForJsonParse.feed.is_videos);
          int i = 0;
          if (bool && albumDataForJsonParse.feed.feed_videos != null && albumDataForJsonParse.feed.feed_videos.length > 0) {
            AlbumFlow albumFlow = albumDataForJsonParse.feed;
            albumFlow.album_pic = albumDataForJsonParse.feed.feed_videos[0];
            arrayList.add(albumFlow);
            continue;
          } 
          if (albumDataForJsonParse.feed.feed_pics != null) {
            String[] arrayOfString = albumDataForJsonParse.feed.feed_pics;
            int j = arrayOfString.length;
            while (i < j) {
              String str = arrayOfString[i];
              AlbumFlow albumFlow = (AlbumFlow)albumDataForJsonParse.feed.clone();
              albumFlow.album_pic = str;
              arrayList.add(albumFlow);
              i++;
            } 
          } 
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setListData mPage:");
      stringBuilder.append(this.j);
      stringBuilder.append(" -- ");
      stringBuilder.append(arrayList.size());
      Log.v("drb", stringBuilder.toString());
      if (this.j == 1) {
        this.m.c(arrayList);
        this.n.data.clear();
        a(this.m.n());
        AlbumViewDataManager.a().a(paramBluedEntityA.hasMore());
        return;
      } 
      this.m.a(arrayList);
      a(this.m.n());
      AlbumViewDataManager.a().a(paramBluedEntityA.hasMore(), this.n.data);
      return;
    } 
    if (this.m.n().size() == 0)
      this.m.c(new ArrayList()); 
  }
  
  private void a(List<AlbumFlow> paramList) {
    this.n.data.clear();
    for (AlbumFlow albumFlow : paramList) {
      if (!albumFlow.showApply)
        this.n.data.add((AlbumFlow)albumFlow.clone()); 
    } 
  }
  
  private void m() {
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, this.o);
    this.g.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.m.notifyDataSetChanged();
  }
  
  public void a() {
    a(false);
  }
  
  public void a(String paramString) {
    if (!StringUtils.e(paramString)) {
      AlbumForDataTrans albumForDataTrans = this.n;
      if (albumForDataTrans != null) {
        Iterator iterator = albumForDataTrans.data.iterator();
        while (iterator.hasNext()) {
          if (paramString.equals(((AlbumFlow)iterator.next()).feed_id))
            iterator.remove(); 
        } 
      } 
    } 
  }
  
  public void a(boolean paramBoolean) {
    UserBasicModel userBasicModel = this.h;
    if (userBasicModel != null) {
      if (StringUtils.e(userBasicModel.uid))
        return; 
      if (paramBoolean) {
        this.j = 1;
      } else {
        this.j++;
      } 
      if (!this.l) {
        int i = this.j;
        if (i != 1) {
          this.j = i - 1;
          return;
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("getAlbumFlowList mPage:");
      stringBuilder1.append(this.j);
      Log.v("drb", stringBuilder1.toString());
      BluedUIHttpResponse<BluedEntityA<AlbumDataForJsonParse>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<AlbumDataForJsonParse>>(this, (IRequestHost)w_()) {
          boolean a = false;
          
          protected void a(BluedEntityA<AlbumDataForJsonParse> param1BluedEntityA) {
            UserinfoFragmentAlbumTab.a(this.b, param1BluedEntityA);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            AlbumViewDataManager.a().c();
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            UserinfoFragmentAlbumTab.c(this.b).setVisibility(8);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("albumAdapterNew.getItemCount():");
            stringBuilder.append(UserinfoFragmentAlbumTab.b(this.b).getItemCount());
            Log.v("drb", stringBuilder.toString());
            if (UserinfoFragmentAlbumTab.b(this.b).getItemCount() == 0) {
              if (this.a) {
                Log.v("drb", "showFail");
                UserinfoFragmentAlbumTab.d(this.b).b();
              } else {
                Log.v("drb", "showNodata");
                UserinfoFragmentAlbumTab.d(this.b).a();
              } 
            } else {
              UserinfoFragmentAlbumTab.d(this.b).c();
            } 
            boolean bool = false;
            this.a = false;
            if (UserinfoFragmentAlbumTab.e(this.b)) {
              this.b.f.b(true);
            } else {
              this.b.f.b(false);
            } 
            this.b.f.g();
            this.b.f.h();
            if (UserinfoFragmentAlbumTab.b(this.b).n().size() > 0)
              bool = true; 
            ((UserInfoFragmentNew)this.b.getParentFragment()).d(bool);
          }
          
          public void onUIStart() {
            super.onUIStart();
            if (UserinfoFragmentAlbumTab.b(this.b).getItemCount() == 0)
              UserinfoFragmentAlbumTab.c(this.b).setVisibility(0); 
          }
        };
      String str1 = this.h.uid;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.j);
      stringBuilder2.append("");
      String str2 = stringBuilder2.toString();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.k);
      stringBuilder3.append("");
      UserHttpUtils.a(bluedUIHttpResponse, str1, "", str2, stringBuilder3.toString(), (IRequestHost)w_());
    } 
  }
  
  public void a(boolean paramBoolean, String paramString) {
    if (this.m != null && !StringUtils.e(paramString)) {
      if (paramBoolean) {
        this.m.d(paramString);
        a(paramString);
        return;
      } 
      Iterator iterator = this.m.n().iterator();
      while (iterator.hasNext()) {
        if (paramString.equals(((AlbumFlow)iterator.next()).pid))
          iterator.remove(); 
      } 
      this.m.notifyDataSetChanged();
    } 
  }
  
  public void k() {
    this.p = this.e.findViewById(2131299159);
    this.i = (NoDataAndLoadFailView)this.e.findViewById(2131299395);
    this.i.c();
    this.i.setImageScale(0.8F);
    this.i.setTopSpace(DensityUtils.a(this.d, 58.0F));
    this.i.setOnTouchEvent(false);
    this.f = (SmartRefreshLayout)this.e.findViewById(2131299616);
    this.f.c(false);
    this.g = (RecyclerView)this.e.findViewById(2131299605);
    this.m = new AlbumAdapterNew(this.d, w_());
    FeedMethods.a((LifecycleOwner)getActivity(), (IFeedDataObserver)this.m);
    this.g.setAdapter((RecyclerView.Adapter)this.m);
    this.m.d(true);
    this.g.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            super.onScrollStateChanged(param1RecyclerView, param1Int);
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            if (UserinfoFragmentAlbumTab.a(this.a)) {
              UserinfoFeedScrollObserver.a().a(param1RecyclerView, param1Int1, param1Int2);
              UserinfoFragmentAlbumTab.a(this.a, false);
            } 
          }
        });
    this.m.c(false);
    this.f.a(new OnLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            this.a.a(false);
          }
        });
    this.m.a(new -$$Lambda$UserinfoFragmentAlbumTab$KHoU96jFLfrV4knndB1hXO8yPT4(this));
    a(true);
  }
  
  public void l() {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493344, paramViewGroup, false);
      this.h = (UserBasicModel)getArguments().getSerializable("user");
      if (this.h == null) {
        this.h = new UserBasicModel();
        this.h.uid = (UserInfo.a().i()).uid;
      } 
      this.n = new AlbumForDataTrans();
      k();
      m();
      AlbumViewObserver.a().a(this);
      AlbumDataObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    AlbumViewObserver.a().b(this);
    AlbumDataObserver.a().b(this);
  }
  
  public void onPause() {
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\UserinfoFragmentAlbumTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */