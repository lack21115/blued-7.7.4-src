package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.live_china.manager.RecommendDataListener;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.model.LiveRecommendModel;
import java.util.ArrayList;
import java.util.List;

public class LiveFollowRecommendAdapter extends BaseQuickAdapter<LiveRecommendModel, BaseViewHolder> {
  public int a;
  
  public int b;
  
  private LoadOptions c;
  
  private ImageView d;
  
  private ImageView e;
  
  private ImageView f;
  
  private TextView g;
  
  private ImageView h;
  
  private Context i;
  
  private IRequestHost o;
  
  private List<LiveRecommendModel> p = new ArrayList<LiveRecommendModel>();
  
  private FrameLayout q;
  
  private List<String> r = new ArrayList<String>();
  
  private RecommendDataListener s;
  
  public LiveFollowRecommendAdapter(IRequestHost paramIRequestHost, Context paramContext) {
    super(2131493583, null);
    this.i = paramContext;
    this.o = paramIRequestHost;
    this.c = new LoadOptions();
    this.c.a((int)this.i.getResources().getDimension(2131165502), (int)this.i.getResources().getDimension(2131165501));
    LoadOptions loadOptions = this.c;
    loadOptions.b = 2131234356;
    loadOptions.d = 2131234356;
    this.a = (AppInfo.l - DensityUtils.a(paramContext, 16.0F)) / 3;
    this.b = this.a / 54 * 73;
  }
  
  public String a() {
    return (this.n != null && this.n.size() > 0) ? ((LiveRecommendModel)this.n.get(this.n.size() - 1)).uid : "";
  }
  
  public void a(RecommendDataListener paramRecommendDataListener) {
    this.s = paramRecommendDataListener;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveRecommendModel paramLiveRecommendModel) {
    if (paramBaseViewHolder != null && paramLiveRecommendModel != null) {
      if (!this.r.contains(paramLiveRecommendModel.lid)) {
        this.r.add(paramLiveRecommendModel.lid);
        EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, "follow_default", paramLiveRecommendModel.lid, paramLiveRecommendModel.uid);
      } 
      this.d = (ImageView)paramBaseViewHolder.d(2131300980);
      this.e = (ImageView)paramBaseViewHolder.d(2131297513);
      this.f = (ImageView)paramBaseViewHolder.d(2131297457);
      this.g = (TextView)paramBaseViewHolder.d(2131301088);
      this.h = (ImageView)paramBaseViewHolder.d(2131297516);
      this.q = (FrameLayout)paramBaseViewHolder.d(2131299752);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.q.getLayoutParams();
      layoutParams.width = this.a;
      layoutParams.height = this.b;
      this.q.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      ImageLoader.a(this.o, paramLiveRecommendModel.avatar).a(2131234356).c().a(this.d);
      this.g.setText(paramLiveRecommendModel.name);
      if (paramLiveRecommendModel.liveType == 1) {
        this.h.setVisibility(0);
      } else {
        this.h.setVisibility(8);
      } 
      this.d.setOnClickListener(new View.OnClickListener(this, paramLiveRecommendModel) {
            public void onClick(View param1View) {
              String str1 = EncryptTool.a(this.a.uid);
              String str2 = EncryptTool.a(this.a.lid);
              ArrayList<LiveRoomData> arrayList = new ArrayList();
              int i = 0;
              while (true) {
                int j = LiveFollowRecommendAdapter.a(this.b).size();
                boolean bool = true;
                if (i < j) {
                  String str = EncryptTool.a(((LiveRecommendModel)LiveFollowRecommendAdapter.b(this.b).get(i)).uid);
                  long l = Long.parseLong(EncryptTool.a(((LiveRecommendModel)LiveFollowRecommendAdapter.c(this.b).get(i)).lid));
                  if (((LiveRecommendModel)LiveFollowRecommendAdapter.d(this.b).get(i)).liveType == 1) {
                    bool = true;
                  } else {
                    bool = false;
                  } 
                  arrayList.add(new LiveRoomData(l, bool, "live_followed_grid_recommend", str, ((LiveRecommendModel)LiveFollowRecommendAdapter.e(this.b).get(i)).name, ((LiveRecommendModel)LiveFollowRecommendAdapter.f(this.b).get(i)).avatar, ((LiveRecommendModel)LiveFollowRecommendAdapter.g(this.b).get(i)).vbadge));
                  i++;
                  continue;
                } 
                if (this.a.liveType == 1) {
                  i = bool;
                } else {
                  i = 0;
                } 
                LiveRoomData liveRoomData = new LiveRoomData(Long.parseLong(str2), i, "live_followed_grid_recommend", str1, this.a.name, this.a.avatar, this.a.vbadge);
                LiveRoomInfoChannel.a(LiveFollowRecommendAdapter.h(this.b), liveRoomData, -1, arrayList);
                EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, "follow_default", this.a.lid, this.a.uid);
                EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOWED_GRID_RECOMMEND_CLICK, this.a.lid, this.a.uid);
                InstantLog.b("live_followed_grid_recommend_click", this.a.uid);
                return;
              } 
            }
          });
      this.f.setOnClickListener(new View.OnClickListener(this, paramLiveRecommendModel) {
            public void onClick(View param1View) {
              LiveFollowRecommendAdapter.i(this.b).remove(this.a);
              if (LiveFollowRecommendAdapter.j(this.b).size() > 0)
                LiveFollowRecommendAdapter.k(this.b).add(LiveFollowRecommendAdapter.j(this.b).remove(0)); 
              LiveHttpUtils.a(this.a.uid);
              if (LiveFollowRecommendAdapter.l(this.b).size() == 0 && LiveFollowRecommendAdapter.m(this.b) != null)
                LiveFollowRecommendAdapter.m(this.b).a(); 
              this.b.notifyDataSetChanged();
              if (LiveRoomPreferences.B()) {
                LiveRoomPreferences.C();
                AppMethods.a(LiveFollowRecommendAdapter.h(this.b).getString(2131757638));
              } 
            }
          });
      if (!paramLiveRecommendModel.isShowed) {
        EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOWED_GRID_RECOMMEND_SHOW, paramLiveRecommendModel.lid, paramLiveRecommendModel.uid);
        InstantLog.b("live_followed_grid_recommend_show", paramLiveRecommendModel.uid);
      } 
      paramLiveRecommendModel.isShowed = true;
      if (paramLiveRecommendModel.link_type == 1) {
        this.e.setImageResource(2131233243);
        return;
      } 
      if (paramLiveRecommendModel.link_type == 2) {
        this.e.setImageResource(2131233141);
        return;
      } 
      this.e.setImageResource(2131233283);
    } 
  }
  
  public void a(List<LiveRecommendModel> paramList) {
    this.p.clear();
    this.r.clear();
    ArrayList arrayList = new ArrayList();
    for (int i = 0; i < paramList.size(); i++) {
      if (i < 9) {
        arrayList.add(paramList.get(i));
      } else {
        this.p.add(paramList.get(i));
      } 
    } 
    c(arrayList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\LiveFollowRecommendAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */