package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.model.LiveRecommendModel;
import java.util.ArrayList;
import java.util.List;

public class LiveHorizontalRecommendAdapter extends BaseQuickAdapter<LiveRecommendModel, BaseViewHolder> {
  public int a = 0;
  
  private Context b;
  
  private IRequestHost c;
  
  private List<String> d = new ArrayList<String>();
  
  public LiveHorizontalRecommendAdapter(IRequestHost paramIRequestHost, Context paramContext, int paramInt) {
    super(2131493563, null);
    this.b = paramContext;
    this.c = paramIRequestHost;
    this.a = paramInt;
  }
  
  public void a() {
    if (this.n != null) {
      this.d.clear();
      this.n.clear();
      notifyDataSetChanged();
    } 
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveRecommendModel paramLiveRecommendModel) {
    if (paramBaseViewHolder != null) {
      if (!this.d.contains(paramLiveRecommendModel.lid)) {
        this.d.add(paramLiveRecommendModel.lid);
        EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, "follow_maybe", paramLiveRecommendModel.lid, paramLiveRecommendModel.uid);
      } 
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297489);
      if (!TextUtils.isEmpty(paramLiveRecommendModel.avatar))
        ImageLoader.a(this.c, paramLiveRecommendModel.avatar).a(imageView); 
      imageView.setOnClickListener(new View.OnClickListener(this, paramLiveRecommendModel) {
            public void onClick(View param1View) {
              String str1;
              int i = this.b.a;
              if (i != 0) {
                if (i == 1)
                  InstantLog.b("square_live_click", this.a.uid); 
              } else {
                InstantLog.b("live_followed_hori_recommend_click", this.a.uid);
              } 
              EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, "follow_maybe", this.a.lid, this.a.uid);
              if (this.b.a == 1) {
                str1 = this.a.source;
              } else {
                str1 = "live_followed_hori_recommend";
              } 
              ArrayList<LiveRoomData> arrayList = new ArrayList();
              for (i = 0; i < LiveHorizontalRecommendAdapter.a(this.b).size(); i++) {
                boolean bool;
                String str = EncryptTool.a(((LiveRecommendModel)LiveHorizontalRecommendAdapter.b(this.b).get(i)).uid);
                long l = Long.parseLong(EncryptTool.a(((LiveRecommendModel)LiveHorizontalRecommendAdapter.c(this.b).get(i)).lid));
                if (((LiveRecommendModel)LiveHorizontalRecommendAdapter.d(this.b).get(i)).liveType == 1) {
                  bool = true;
                } else {
                  bool = false;
                } 
                arrayList.add(new LiveRoomData(l, bool, str1, str, ((LiveRecommendModel)LiveHorizontalRecommendAdapter.e(this.b).get(i)).name, ((LiveRecommendModel)LiveHorizontalRecommendAdapter.f(this.b).get(i)).avatar, ((LiveRecommendModel)LiveHorizontalRecommendAdapter.g(this.b).get(i)).vbadge));
              } 
              String str2 = EncryptTool.a(this.a.uid);
              String str3 = EncryptTool.a(this.a.lid);
              if (this.a.liveType == 1) {
                i = 1;
              } else {
                i = 0;
              } 
              LiveRoomData liveRoomData = new LiveRoomData(Long.parseLong(str3), i, str1, str2, this.a.name, this.a.avatar, this.a.vbadge);
              LiveRoomInfoChannel.a(LiveHorizontalRecommendAdapter.h(this.b), liveRoomData, -1, arrayList);
            }
          });
      paramBaseViewHolder.a(2131301088, paramLiveRecommendModel.name);
      if (paramLiveRecommendModel.liveType == 1) {
        paramBaseViewHolder.b(2131300969, 2131757760);
      } else if (paramLiveRecommendModel.link_type == 1) {
        paramBaseViewHolder.b(2131300969, 2131757763);
      } else if (paramLiveRecommendModel.link_type == 2) {
        paramBaseViewHolder.b(2131300969, 2131757762);
      } else {
        paramBaseViewHolder.b(2131300969, 2131757761);
      } 
      if (!paramLiveRecommendModel.isShowed) {
        int i = this.a;
        if (i != 0) {
          if (i == 1)
            InstantLog.b("square_live_show", paramLiveRecommendModel.uid); 
        } else {
          InstantLog.b("live_followed_hori_recommend_show", paramLiveRecommendModel.uid);
        } 
        paramLiveRecommendModel.isShowed = true;
      } 
      paramBaseViewHolder.a(2131297457, new View.OnClickListener(this, paramLiveRecommendModel) {
            public void onClick(View param1View) {
              LiveHttpUtils.a(this.a.uid);
              LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.b;
              liveHorizontalRecommendAdapter.notifyItemRemoved(LiveHorizontalRecommendAdapter.i(liveHorizontalRecommendAdapter).indexOf(this.a));
              LiveHorizontalRecommendAdapter.j(this.b).remove(this.a);
              if (LiveHorizontalRecommendAdapter.k(this.b).size() == 0) {
                this.b.notifyDataSetChanged();
                LiveEventBus.get("delete_all_recommend_user").post("");
              } else {
                AppInfo.n().postDelayed(new Runnable(this) {
                      public void run() {
                        this.a.b.notifyDataSetChanged();
                      }
                    },  420L);
              } 
              if (LiveRoomPreferences.D()) {
                LiveRoomPreferences.E();
                AppMethods.a(LiveHorizontalRecommendAdapter.h(this.b).getString(2131757638));
              } 
            }
          });
    } 
  }
  
  public static interface LIVE_RECOMMEND_FROM {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\LiveHorizontalRecommendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */