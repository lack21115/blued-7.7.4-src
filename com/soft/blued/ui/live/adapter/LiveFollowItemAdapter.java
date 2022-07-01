package com.soft.blued.ui.live.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.log.trackUtils.EventTrackLive;
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

public class LiveFollowItemAdapter extends BaseMultiItemQuickAdapter<BluedLiveListData, BaseViewHolder> {
  private IRequestHost a;
  
  private HashSet<String> b = new HashSet<String>();
  
  private List<LiveRecommendModel> c;
  
  private LiveHorizontalRecommendAdapter d;
  
  private int e = 0;
  
  private BaseQuickAdapter.RequestLoadMoreListener f;
  
  private List<String> g = new ArrayList<String>();
  
  public LiveFollowItemAdapter(BaseFragment paramBaseFragment) {
    super(new ArrayList());
    this.a = (IRequestHost)paramBaseFragment.w_();
    this.k = paramBaseFragment.getContext();
    b(0, 2131493560);
    b(1, 2131494096);
  }
  
  private String a(int paramInt) {
    return this.k.getResources().getString(paramInt);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder) {
    PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView)paramBaseViewHolder.d(2131298572);
    LinearLayout linearLayout = (LinearLayout)paramBaseViewHolder.d(2131299586);
    View view = paramBaseViewHolder.d(2131301688);
    TextView textView = (TextView)paramBaseViewHolder.d(2131301240);
    RecyclerView recyclerView = (RecyclerView)pullToRefreshRecyclerView.getRefreshableView();
    this.d = new LiveHorizontalRecommendAdapter(this.a, this.k, 0);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.k);
    linearLayoutManager.setOrientation(0);
    recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    recyclerView.setAdapter((RecyclerView.Adapter)this.d);
    this.d.a((LoadMoreView)new RecommendLoadMoreView());
    BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener = this.f;
    if (requestLoadMoreListener != null)
      this.d.a(requestLoadMoreListener, recyclerView); 
    for (int i = 0; i < this.c.size(); i++) {
      LiveRecommendModel liveRecommendModel = this.c.get(i);
      if (!this.b.contains(liveRecommendModel.uid)) {
        this.d.a(liveRecommendModel);
        this.b.add(liveRecommendModel.uid);
      } 
    } 
    this.d.notifyDataSetChanged();
    List<LiveRecommendModel> list = this.c;
    if (list != null && list.isEmpty()) {
      view.setVisibility(8);
      textView.setVisibility(8);
      pullToRefreshRecyclerView.setVisibility(8);
      return;
    } 
    view.setVisibility(0);
    textView.setVisibility(0);
    pullToRefreshRecyclerView.setVisibility(0);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {
    if (!this.g.contains(paramBluedLiveListData.lid)) {
      this.g.add(paramBluedLiveListData.lid);
      EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, "follow_list", paramBluedLiveListData.lid, paramBluedLiveListData.uid);
    } 
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131300980);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131300994);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131300978);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131298656);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131298577);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131300979);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131300982);
    ImageLoader.a(this.a, paramBluedLiveListData.anchor.avatar).a(2131232977).a(imageView3);
    if (paramBluedLiveListData.livetype == 0) {
      textView4.setVisibility(0);
    } else {
      textView4.setVisibility(8);
    } 
    try {
      String str;
      textView3.setVisibility(0);
      imageView1.setVisibility(8);
      imageView2.setVisibility(8);
      if (paramBluedLiveListData.livetype == 0) {
        str = TimeAndDateUtils.a(this.k, TimeAndDateUtils.b(paramBluedLiveListData.live_starttime));
        textView3.setText(String.format(a(2131757437), new Object[] { str }));
      } else {
        String str1 = TimeAndDateUtils.h(this.k, TimeAndDateUtils.b(paramBluedLiveListData.live_starttime));
        textView3.setText(String.format(a(2131757441), new Object[] { str1 }));
        if (paramBluedLiveListData.link_type == 1) {
          str.setVisibility(0);
          str.setImageResource(2131233123);
        } else if (paramBluedLiveListData.link_type == 2) {
          str.setVisibility(0);
          str.setImageResource(2131233119);
        } 
        if (paramBluedLiveListData.anchor_level >= 80)
          LiveUtils.a(this.k, imageView2, paramBluedLiveListData.anchor_level, false); 
      } 
    } catch (Exception exception) {
      textView3.setVisibility(8);
    } 
    if (paramBluedLiveListData.livetype == 2) {
      textView2.setText(2131757138);
    } else if (!TextUtils.isEmpty(paramBluedLiveListData.top_count)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a(2131757139));
      stringBuilder.append(" ");
      stringBuilder.append(AreaUtils.a(this.k, paramBluedLiveListData.top_count));
      stringBuilder.append(" ");
      stringBuilder.append(a(2131757140));
      textView2.setText(stringBuilder.toString());
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a(2131757139));
      stringBuilder.append(" ");
      stringBuilder.append(a(2131757140));
      textView2.setText(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(paramBluedLiveListData.anchor.name)) {
      textView1.setText(paramBluedLiveListData.anchor.name);
      return;
    } 
    textView1.setText("");
  }
  
  public List<BluedLiveListData> a() {
    ArrayList<BluedLiveListData> arrayList = new ArrayList();
    for (BluedLiveListData bluedLiveListData : n()) {
      if (bluedLiveListData.livetype != 0 && bluedLiveListData.liveType == 0)
        arrayList.add(bluedLiveListData); 
    } 
    return arrayList;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {
    LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter;
    int i = paramBaseViewHolder.getItemViewType();
    if (i != 0) {
      if (i != 1)
        return; 
      this.e = n().indexOf(paramBluedLiveListData);
      String str = j;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("recommendListIndex = ");
      stringBuilder.append(this.e);
      Logger.e(str, new Object[] { stringBuilder.toString() });
      this.b.clear();
      this.c = paramBluedLiveListData.liveRecommendModelList;
      liveHorizontalRecommendAdapter = this.d;
      if (liveHorizontalRecommendAdapter != null)
        liveHorizontalRecommendAdapter.a(); 
      b(paramBaseViewHolder);
      return;
    } 
    b(paramBaseViewHolder, (BluedLiveListData)liveHorizontalRecommendAdapter);
  }
  
  public void a(List<BluedLiveListData> paramList) {
    this.g.clear();
    c(paramList);
  }
  
  public void a(boolean paramBoolean) {
    LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.d;
    if (liveHorizontalRecommendAdapter == null)
      return; 
    liveHorizontalRecommendAdapter.c(paramBoolean);
  }
  
  public List<BluedLiveListData> b() {
    ArrayList<BluedLiveListData> arrayList = new ArrayList();
    for (BluedLiveListData bluedLiveListData : n()) {
      if (bluedLiveListData.liveType == 0)
        arrayList.add(bluedLiveListData); 
    } 
    return arrayList;
  }
  
  public void b(BaseQuickAdapter.RequestLoadMoreListener paramRequestLoadMoreListener) {
    this.f = paramRequestLoadMoreListener;
  }
  
  public void b(List<LiveRecommendModel> paramList) {
    LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.d;
    if (liveHorizontalRecommendAdapter == null)
      return; 
    int i = liveHorizontalRecommendAdapter.n().size();
    if (paramList != null && paramList.size() > 0) {
      for (int j = 0; j < paramList.size(); j++) {
        LiveRecommendModel liveRecommendModel = paramList.get(j);
        if (!this.b.contains(liveRecommendModel.uid)) {
          this.d.n().add(liveRecommendModel);
          this.b.add(liveRecommendModel.uid);
        } 
      } 
      this.d.notifyDataSetChanged();
    } 
    if (i == this.d.n().size()) {
      this.d.l();
      this.d.k();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\LiveFollowItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */