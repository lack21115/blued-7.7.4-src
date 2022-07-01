package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.live_china.manager.RecommendDataListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveRecommendModel;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.live.view.RecommendLoadMoreView;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LiveFollowListItemAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private Context b;
  
  private IRequestHost c;
  
  private List<BluedLiveListData> d;
  
  private LoadOptions e;
  
  private final int f = 2;
  
  private BaseQuickAdapter.RequestLoadMoreListener g;
  
  private LiveHorizontalRecommendAdapter h;
  
  private RecommendDataListener i;
  
  private HashSet<String> j = new HashSet<String>();
  
  public LiveFollowListItemAdapter(IRequestHost paramIRequestHost, Context paramContext, List<BluedLiveListData> paramList) {
    this.b = paramContext;
    this.c = paramIRequestHost;
    this.d = paramList;
    this.a = LayoutInflater.from(paramContext);
    this.e = new LoadOptions();
    LoadOptions loadOptions = this.e;
    loadOptions.d = 2131232977;
    loadOptions.b = 2131232977;
  }
  
  public List<BluedLiveListData> a() {
    ArrayList<BluedLiveListData> arrayList = new ArrayList();
    for (int i = 0; i < this.d.size(); i++) {
      if (((BluedLiveListData)this.d.get(i)).livetype != 0)
        arrayList.add(this.d.get(i)); 
    } 
    return arrayList;
  }
  
  public void a(RecommendDataListener paramRecommendDataListener) {
    this.i = paramRecommendDataListener;
  }
  
  public void a(BaseQuickAdapter.RequestLoadMoreListener paramRequestLoadMoreListener) {
    this.g = paramRequestLoadMoreListener;
  }
  
  public void a(List<LiveRecommendModel> paramList) {
    LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.h;
    if (liveHorizontalRecommendAdapter == null)
      return; 
    int j = liveHorizontalRecommendAdapter.n().size();
    if (paramList != null && paramList.size() > 0) {
      for (int k = 0; k < paramList.size(); k++) {
        LiveRecommendModel liveRecommendModel = paramList.get(k);
        if (!this.j.contains(liveRecommendModel.uid)) {
          this.h.n().add(liveRecommendModel);
          this.j.add(liveRecommendModel.uid);
        } 
      } 
      this.h.notifyDataSetChanged();
    } 
    int i = this.h.n().size();
    if (j == i) {
      d();
      e();
    } 
    Logger.a("drb", new Object[] { "oldCount = ", Integer.valueOf(j), "--newCount = ", Integer.valueOf(i) });
  }
  
  public void a(boolean paramBoolean) {
    LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.h;
    if (liveHorizontalRecommendAdapter != null)
      liveHorizontalRecommendAdapter.c(paramBoolean); 
  }
  
  public LiveHorizontalRecommendAdapter b() {
    return this.h;
  }
  
  public void c() {
    for (int i = 0; i < this.d.size(); i++) {
      BluedLiveListData bluedLiveListData = this.d.get(i);
      if (bluedLiveListData.recommendType == 1) {
        this.d.remove(bluedLiveListData);
        break;
      } 
    } 
    notifyDataSetChanged();
  }
  
  public void d() {
    LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.h;
    if (liveHorizontalRecommendAdapter != null)
      liveHorizontalRecommendAdapter.l(); 
  }
  
  public void e() {
    LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.h;
    if (liveHorizontalRecommendAdapter != null)
      liveHorizontalRecommendAdapter.b(true); 
  }
  
  public int getCount() {
    List<BluedLiveListData> list = this.d;
    return (list != null) ? list.size() : 0;
  }
  
  public Object getItem(int paramInt) {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt) {
    return ((BluedLiveListData)this.d.get(paramInt)).recommendType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    int i = getItemViewType(paramInt);
    if (paramView == null) {
      if (i != 0) {
        if (i == 1)
          paramView = this.a.inflate(2131494096, paramViewGroup, false); 
      } else {
        paramView = this.a.inflate(2131493560, paramViewGroup, false);
      } 
      viewHolder = new ViewHolder(this, paramView, i);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    BluedLiveListData bluedLiveListData = this.d.get(paramInt);
    if (i != 0) {
      if (i != 1)
        return paramView; 
      Logger.a("drb", new Object[] { "item.liveRecommendModelList = ", Integer.valueOf(bluedLiveListData.liveRecommendModelList.size()) });
      this.j.clear();
      this.h.a();
      for (paramInt = 0; paramInt < bluedLiveListData.liveRecommendModelList.size(); paramInt++) {
        LiveRecommendModel liveRecommendModel = bluedLiveListData.liveRecommendModelList.get(paramInt);
        if (!this.j.contains(liveRecommendModel.uid)) {
          this.h.a(liveRecommendModel);
          this.j.add(liveRecommendModel.uid);
        } 
      } 
      this.h.notifyDataSetChanged();
      if (this.h.n() != null && this.h.n().size() <= 0) {
        viewHolder.m.setVisibility(8);
        viewHolder.n.setVisibility(8);
        viewHolder.j.setVisibility(8);
        return paramView;
      } 
      viewHolder.m.setVisibility(0);
      viewHolder.n.setVisibility(0);
      viewHolder.j.setVisibility(0);
      return paramView;
    } 
    ImageLoader.a(this.c, bluedLiveListData.anchor.avatar).a(2131232977).a(viewHolder.a);
    if (bluedLiveListData.livetype == 0) {
      viewHolder.f.setVisibility(0);
    } else {
      viewHolder.f.setVisibility(8);
    } 
    try {
      viewHolder.d.setVisibility(0);
      viewHolder.h.setVisibility(8);
      viewHolder.i.setVisibility(8);
      if (bluedLiveListData.livetype == 0) {
        String str = TimeAndDateUtils.a(this.b, TimeAndDateUtils.b(bluedLiveListData.live_starttime));
        viewHolder.d.setText(String.format(this.b.getResources().getString(2131757437), new Object[] { str }));
      } else {
        String str = TimeAndDateUtils.h(this.b, TimeAndDateUtils.b(bluedLiveListData.live_starttime));
        viewHolder.d.setText(String.format(this.b.getResources().getString(2131757441), new Object[] { str }));
        if (bluedLiveListData.link_type == 1) {
          viewHolder.h.setVisibility(0);
          viewHolder.h.setImageResource(2131233123);
        } else if (bluedLiveListData.link_type == 2) {
          viewHolder.h.setVisibility(0);
          viewHolder.h.setImageResource(2131233119);
        } 
        if (bluedLiveListData.anchor_level >= 80)
          LiveUtils.a(this.b, viewHolder.i, bluedLiveListData.anchor_level, false); 
      } 
    } catch (Exception exception) {
      viewHolder.d.setVisibility(8);
    } 
    if (bluedLiveListData.livetype == 2) {
      viewHolder.e.setText(2131757138);
    } else if (!TextUtils.isEmpty(bluedLiveListData.top_count)) {
      TextView textView = viewHolder.e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b.getString(2131757139));
      stringBuilder.append(" ");
      stringBuilder.append(AreaUtils.a(this.b, bluedLiveListData.top_count));
      stringBuilder.append(" ");
      stringBuilder.append(this.b.getString(2131757140));
      textView.setText(stringBuilder.toString());
    } else {
      TextView textView = viewHolder.e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b.getString(2131757139));
      stringBuilder.append(" ");
      stringBuilder.append(this.b.getString(2131757140));
      textView.setText(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(bluedLiveListData.anchor.name)) {
      viewHolder.c.setText(bluedLiveListData.anchor.name);
      return paramView;
    } 
    viewHolder.c.setText("");
    return paramView;
  }
  
  public int getViewTypeCount() {
    return 2;
  }
  
  class ViewHolder {
    ImageView a;
    
    LinearLayout b;
    
    TextView c;
    
    TextView d;
    
    TextView e;
    
    TextView f;
    
    ImageView g;
    
    ImageView h;
    
    ImageView i;
    
    PullToRefreshRecyclerView j;
    
    RecyclerView k;
    
    LinearLayout l;
    
    View m;
    
    TextView n;
    
    public ViewHolder(LiveFollowListItemAdapter this$0, View param1View, int param1Int) {
      LinearLayoutManager linearLayoutManager;
      if (param1Int != 0) {
        if (param1Int != 1)
          return; 
        this.j = (PullToRefreshRecyclerView)param1View.findViewById(2131298572);
        this.l = (LinearLayout)param1View.findViewById(2131299586);
        this.m = param1View.findViewById(2131301688);
        this.n = (TextView)param1View.findViewById(2131301240);
        this.k = (RecyclerView)this.j.getRefreshableView();
        LiveFollowListItemAdapter.a(this$0, new LiveHorizontalRecommendAdapter(LiveFollowListItemAdapter.a(this$0), LiveFollowListItemAdapter.b(this$0), 0));
        LiveFollowListItemAdapter.c(this$0).clear();
        linearLayoutManager = new LinearLayoutManager(LiveFollowListItemAdapter.b(this$0));
        linearLayoutManager.setOrientation(0);
        this.k.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.k.setAdapter((RecyclerView.Adapter)LiveFollowListItemAdapter.d(this$0));
        LiveFollowListItemAdapter.d(this$0).a((LoadMoreView)new RecommendLoadMoreView());
        LiveFollowListItemAdapter.d(this$0).a(new BaseQuickAdapter.RequestLoadMoreListener(this, this$0) {
              public void onLoadMoreRequested() {
                Logger.a("drb", new Object[] { "ViewHolder onLoadMoreRequested" });
                if (LiveFollowListItemAdapter.e(this.b.o) != null)
                  LiveFollowListItemAdapter.e(this.b.o).onLoadMoreRequested(); 
              }
            }this.k);
        return;
      } 
      this.b = (LinearLayout)linearLayoutManager.findViewById(2131298917);
      this.a = (ImageView)linearLayoutManager.findViewById(2131300980);
      this.c = (TextView)linearLayoutManager.findViewById(2131300982);
      this.d = (TextView)linearLayoutManager.findViewById(2131300978);
      this.e = (TextView)linearLayoutManager.findViewById(2131300979);
      this.f = (TextView)linearLayoutManager.findViewById(2131300994);
      this.g = (ImageView)linearLayoutManager.findViewById(2131297835);
      this.h = (ImageView)linearLayoutManager.findViewById(2131298656);
      this.i = (ImageView)linearLayoutManager.findViewById(2131298577);
    }
  }
  
  class null implements BaseQuickAdapter.RequestLoadMoreListener {
    null(LiveFollowListItemAdapter this$0, LiveFollowListItemAdapter param1LiveFollowListItemAdapter) {}
    
    public void onLoadMoreRequested() {
      Logger.a("drb", new Object[] { "ViewHolder onLoadMoreRequested" });
      if (LiveFollowListItemAdapter.e(this.b.o) != null)
        LiveFollowListItemAdapter.e(this.b.o).onLoadMoreRequested(); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\LiveFollowListItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */