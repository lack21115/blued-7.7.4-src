package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.manager.LiveListAutoPlay;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveHotListDiversion;
import com.soft.blued.ui.live.utils.LiveListDataUtils;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.live.view.LiveAutoPlayView;
import com.soft.blued.ui.live.view.PKLiveHorizontalView;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveListAdapter extends BaseMultiItemQuickAdapter<BluedLiveListData, BaseViewHolder> implements LiveListAutoPlay {
  private Context a;
  
  private IRequestHost b;
  
  private LayoutInflater c;
  
  private LoadOptions d;
  
  private List<BluedLiveListData> e;
  
  private List<String> f;
  
  private int g;
  
  private int h;
  
  private boolean i;
  
  private boolean o;
  
  private int p;
  
  private String q;
  
  private String r;
  
  private LiveAutoPlayView s;
  
  private LiveAutoPlayView t;
  
  private boolean u = true;
  
  private List<String> v = new ArrayList<String>();
  
  public LiveListAdapter(IRequestHost paramIRequestHost, Context paramContext, boolean paramBoolean, int paramInt, String paramString) {
    super(new ArrayList());
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.i = paramBoolean;
    this.p = paramInt;
    this.q = paramString;
    this.c = LayoutInflater.from(this.a);
    this.e = new ArrayList<BluedLiveListData>();
    this.f = new ArrayList<String>();
    this.d = new LoadOptions();
    LoadOptions loadOptions = this.d;
    loadOptions.d = 2131232977;
    loadOptions.b = 2131232977;
    paramInt = AppInfo.l;
    this.g = (paramInt - DensityUtils.a(paramContext, 26.0F)) / 3;
    this.h = (paramInt - DensityUtils.a(paramContext, 23.0F)) / 2;
    c();
    if (TextUtils.isEmpty(paramString) || TextUtils.equals(paramString, "0")) {
      this.r = "live_list_hot";
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tag_");
    stringBuilder.append(paramString);
    this.r = stringBuilder.toString();
  }
  
  private void A() {
    LiveAutoPlayView liveAutoPlayView = this.s;
    if (liveAutoPlayView != null && liveAutoPlayView.d()) {
      liveAutoPlayView = this.s;
      if (liveAutoPlayView != null)
        liveAutoPlayView.c(); 
    } 
    liveAutoPlayView = this.t;
    if (liveAutoPlayView != null && this.u)
      liveAutoPlayView.a(); 
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData, boolean paramBoolean) {
    int i;
    int j;
    if (TextUtils.equals(this.q, "12")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("tabId:");
      stringBuilder.append(this.q);
      Log.i("==abc", stringBuilder.toString());
      EventTrackLive.a(LiveProtos.Event.LIVE_RECOMMEND_SHOW, paramBluedLiveListData.lid, paramBluedLiveListData.uid);
    } 
    if (!this.v.contains(paramBluedLiveListData.lid)) {
      this.v.add(paramBluedLiveListData.lid);
      EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, this.q, paramBluedLiveListData.lid, paramBluedLiveListData.uid);
    } 
    View view = paramBaseViewHolder.d(2131298657);
    GridLayoutManager.LayoutParams layoutParams1 = (GridLayoutManager.LayoutParams)view.getLayoutParams();
    layoutParams1.width = AppInfo.l / 2;
    layoutParams1.height = AppInfo.l / 2;
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    int k = DensityUtils.a(this.a, 3.0F);
    if (paramBluedLiveListData.position == 0) {
      i = DensityUtils.a(this.a, 10.0F);
      j = DensityUtils.a(this.a, 1.5F);
    } else {
      i = DensityUtils.a(this.a, 1.5F);
      j = DensityUtils.a(this.a, 10.0F);
    } 
    view = view.findViewById(2131296343);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
    layoutParams.leftMargin = i;
    layoutParams.topMargin = 0;
    layoutParams.rightMargin = j;
    layoutParams.bottomMargin = k;
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131296342);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297856);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131300537);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131300975);
    textView1 = (TextView)paramBaseViewHolder.d(2131301479);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297283);
    ImageView imageView4 = (ImageView)paramBaseViewHolder.d(2131297805);
    ImageView imageView5 = (ImageView)paramBaseViewHolder.d(2131297807);
    ImageView imageView6 = (ImageView)paramBaseViewHolder.d(2131297895);
    ImageView imageView7 = (ImageView)paramBaseViewHolder.d(2131297896);
    LiveAutoPlayView liveAutoPlayView = (LiveAutoPlayView)paramBaseViewHolder.d(2131297172);
    liveAutoPlayView.a(this, paramBluedLiveListData, this.r, layoutParams1.width, layoutParams1.height);
    if (paramBluedLiveListData.positionReal == 0 && paramBoolean)
      this.s = liveAutoPlayView; 
    if (TextUtils.equals(this.q, "13")) {
      if (paramBluedLiveListData.position == 0) {
        imageView6.setVisibility(0);
        imageView7.setVisibility(8);
      } else {
        imageView6.setVisibility(8);
        imageView7.setVisibility(0);
      } 
    } else {
      imageView6.setVisibility(8);
      imageView7.setVisibility(8);
    } 
    if ((TextUtils.equals(this.q, "13") || TextUtils.equals(this.q, "14")) && paramBluedLiveListData.positionReal == 0)
      this.s = null; 
    LiveHotListDiversion liveHotListDiversion = paramBluedLiveListData.hot_diversion;
    if (liveHotListDiversion != null) {
      EventTrackLive.b(LiveProtos.Event.LIVE_TASK_COLLECTION_PAGE_SHOW, liveHotListDiversion.link);
      ImageLoader.a(this.b, liveHotListDiversion.pic).a(2131232977).a(imageView1);
      textView1.setText(liveHotListDiversion.title);
      imageView1.setOnClickListener(new View.OnClickListener(this, liveHotListDiversion) {
            public void onClick(View param1View) {
              FindHttpUtils.a(this.a.click_url);
              LiveUtils.a("", "", 0);
              WebViewShowInfoFragment.a(LiveListAdapter.b(this.b), this.a.link, "", false, 9);
              EventTrackLive.b(LiveProtos.Event.HOT_LIVE_H5_LINK_CLICK, this.a.link);
              EventTrackLive.b(LiveProtos.Event.LIVE_TASK_COLLECTION_PAGE_CLICK, this.a.link);
            }
          });
      imageView5.setVisibility(8);
      textView2.setVisibility(8);
      imageView4.setVisibility(8);
      if (!paramBluedLiveListData.isShowUrlVisited) {
        FindHttpUtils.a(liveHotListDiversion.show_url);
        paramBluedLiveListData.isShowUrlVisited = true;
      } 
      paramBaseViewHolder.b(2131298621, false);
      paramBaseViewHolder.b(2131298577, false);
      return;
    } 
    textView2.setVisibility(0);
    imageView4.setVisibility(0);
    if (paramBluedLiveListData.hb > 0) {
      imageView3.setVisibility(0);
      imageView3.setImageResource(2131233115);
    } else if (paramBluedLiveListData.link_type == 1) {
      imageView3.setVisibility(0);
      imageView3.setImageResource(2131233123);
      if (paramBluedLiveListData.positionReal == 0)
        this.s = null; 
    } else if (paramBluedLiveListData.link_type == 2) {
      imageView3.setVisibility(0);
      imageView3.setImageResource(2131233119);
      if (paramBluedLiveListData.positionReal == 0)
        this.s = null; 
    } else if (paramBluedLiveListData.link_type == 4) {
      if (TextUtils.equals(this.q, "11")) {
        imageView3.setVisibility(0);
        imageView3.setImageResource(2131233120);
      } else {
        imageView3.setVisibility(8);
      } 
      if (paramBluedLiveListData.positionReal == 0)
        this.s = null; 
    } else {
      imageView3.setVisibility(8);
    } 
    ImageLoader.a(this.b, paramBluedLiveListData.pic_url).a(2131232977).a(imageView1);
    if (!TextUtils.isEmpty(paramBluedLiveListData.realtime_count)) {
      textView2.setText(StringUtils.a(Long.valueOf(paramBluedLiveListData.realtime_count).longValue()));
    } else {
      textView2.setText("");
    } 
    if (paramBluedLiveListData.anchor != null) {
      i = paramBluedLiveListData.screen_pattern;
      String str1 = paramBluedLiveListData.anchor.avatar;
      String str2 = paramBluedLiveListData.pic_url;
      str2 = paramBluedLiveListData.lid;
      String str4 = paramBluedLiveListData.anchor.name;
      String str3 = paramBluedLiveListData.uid;
      j = paramBluedLiveListData.anchor.vbadge;
      LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(str2, 0L), i, this.r, str3, str4, str1, j);
      liveRoomData.live_url = paramBluedLiveListData.live_play;
      imageView1.setOnClickListener(new View.OnClickListener(this, paramBluedLiveListData, str2, str3, liveRoomData) {
            public void onClick(View param1View) {
              if (this.a.positionReal == 0 && TextUtils.equals(LiveListAdapter.a(this.e), "0"))
                if (this.a.link_type == 1) {
                  EventTrackLive.a(LiveProtos.Event.LIVE_HOT_FIRST_ROOM_CLICK, this.b, this.c, LiveProtos.EnterType.PK);
                } else if (this.a.link_type == 2) {
                  EventTrackLive.a(LiveProtos.Event.LIVE_HOT_FIRST_ROOM_CLICK, this.b, this.c, LiveProtos.EnterType.FRIEND);
                } else {
                  EventTrackLive.a(LiveProtos.Event.LIVE_HOT_FIRST_ROOM_CLICK, this.b, this.c, LiveProtos.EnterType.COMMON);
                }  
              if (this.a.is_exist_na_page == 1 && this.a.is_hot != 1 && this.a.is_top != 1 && TextUtils.isEmpty(this.a.top_icon))
                EventTrackLive.a(LiveProtos.Event.LIVE_TASK_NEW_KING_CLICK, this.a.lid, this.a.uid); 
              if (TextUtils.equals(LiveListAdapter.a(this.e), "12"))
                EventTrackLive.a(LiveProtos.Event.LIVE_RECOMMEND_CLICK, this.a.lid, this.a.uid); 
              EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, LiveListAdapter.a(this.e), this.a.lid, this.a.uid);
              LiveRoomInfoChannel.a(LiveListAdapter.b(this.e), this.d, -1, LiveRoomInfoChannel.a(LiveListDataUtils.a(LiveListAdapter.c(this.e)), LiveListAdapter.d(this.e)));
            }
          });
      if (!TextUtils.isEmpty(paramBluedLiveListData.title)) {
        textView1.setText(paramBluedLiveListData.title);
      } else if (!TextUtils.isEmpty(paramBluedLiveListData.anchor.name)) {
        textView1.setText(paramBluedLiveListData.anchor.name);
      } else {
        textView1.setText("");
      } 
    } 
    if (paramBluedLiveListData.is_distance == 1) {
      paramBaseViewHolder.b(2131298778, true);
      if (paramBluedLiveListData.anchor.is_hide_distance == 1) {
        paramBaseViewHolder.b(2131300715, 2131757302);
        paramBaseViewHolder.b(2131297750, true);
        UserRelationshipUtils.a((ImageView)paramBaseViewHolder.d(2131297750), paramBluedLiveListData.anchor);
      } else {
        paramBaseViewHolder.a(2131300715, DistanceUtils.a(paramBluedLiveListData.distance, BlueAppLocal.c(), false));
        paramBaseViewHolder.b(2131297750, false);
      } 
    } else {
      paramBaseViewHolder.b(2131298778, false);
    } 
    if (paramBluedLiveListData.anchor_level >= 80) {
      LiveUtils.a(this.a, (ImageView)paramBaseViewHolder.d(2131298577), paramBluedLiveListData.anchor_level, false);
    } else {
      paramBaseViewHolder.b(2131298577, false);
    } 
    if (paramBluedLiveListData.is_recommend == 1) {
      paramBaseViewHolder.b(2131298574, true);
      paramBaseViewHolder.b(2131298318, false);
      paramBaseViewHolder.b(2131298478, false);
      paramBaseViewHolder.b(2131298621, false);
      paramBaseViewHolder.b(2131298476, false);
    } else if (paramBluedLiveListData.is_top == 1) {
      paramBaseViewHolder.b(2131298574, false);
      paramBaseViewHolder.b(2131298318, true);
      paramBaseViewHolder.b(2131298478, false);
      paramBaseViewHolder.b(2131298621, false);
      paramBaseViewHolder.b(2131298476, false);
    } else if (!TextUtils.isEmpty(paramBluedLiveListData.top_icon)) {
      paramBaseViewHolder.b(2131298574, false);
      paramBaseViewHolder.b(2131298318, false);
      paramBaseViewHolder.b(2131298478, true);
      paramBaseViewHolder.b(2131298621, false);
      paramBaseViewHolder.b(2131298476, false);
    } else if (paramBluedLiveListData.is_hot == 1) {
      paramBaseViewHolder.b(2131298574, false);
      paramBaseViewHolder.b(2131298318, false);
      paramBaseViewHolder.b(2131298478, false);
      paramBaseViewHolder.b(2131298621, true);
      paramBaseViewHolder.b(2131298476, false);
    } else if (paramBluedLiveListData.is_exist_na_page == 1) {
      paramBaseViewHolder.b(2131298574, false);
      paramBaseViewHolder.b(2131298318, false);
      paramBaseViewHolder.b(2131298478, false);
      paramBaseViewHolder.b(2131298621, false);
      paramBaseViewHolder.b(2131298476, true);
    } else {
      paramBaseViewHolder.b(2131298574, false);
      paramBaseViewHolder.b(2131298318, false);
      paramBaseViewHolder.b(2131298478, false);
      paramBaseViewHolder.b(2131298621, false);
      paramBaseViewHolder.b(2131298476, false);
    } 
    if (!paramBluedLiveListData.isShowUrlVisited) {
      String str1;
      FindHttpUtils.a(paramBluedLiveListData.show_url);
      i = this.p;
      String str2 = paramBluedLiveListData.uid;
      String str3 = paramBluedLiveListData.lid;
      String str4 = this.q;
      if (paramBluedLiveListData.link_type == 1) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      InstantLog.a(i, str2, str3, str4, str1, paramBluedLiveListData.realtime_count);
      paramBluedLiveListData.isShowUrlVisited = true;
    } 
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {
    if (!this.v.contains(paramBluedLiveListData.lid)) {
      this.v.add(paramBluedLiveListData.lid);
      EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, this.q, paramBluedLiveListData.lid, paramBluedLiveListData.uid);
    } 
    ((PKLiveHorizontalView)paramBaseViewHolder.d(2131298144)).a(this.b, this.e, paramBluedLiveListData, this.o);
  }
  
  private void c() {
    b(0, 2131493765);
    b(1, 2131493758);
    b(2, 2131493763);
    b(3, 2131493759);
    b(4, 2131493764);
    b(5, 2131493766);
    b(6, 2131493755);
    b(7, 2131493760);
    b(8, 2131493756);
    b(9, 2131493757);
    b(10, 2131493765);
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {
    String str;
    if (!this.v.contains(paramBluedLiveListData.lid)) {
      this.v.add(paramBluedLiveListData.lid);
      EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, this.q, paramBluedLiveListData.lid, paramBluedLiveListData.uid);
    } 
    LinearLayout linearLayout1 = (LinearLayout)paramBaseViewHolder.d(2131298257);
    GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams)linearLayout1.getLayoutParams();
    layoutParams.width = this.h;
    layoutParams.bottomMargin = DensityUtils.a(this.a, 3.0F);
    if (paramBluedLiveListData.position == 0) {
      layoutParams.leftMargin = DensityUtils.a(this.a, 10.0F);
      layoutParams.rightMargin = 0;
    } else {
      layoutParams.leftMargin = DensityUtils.a(this.a, 3.0F);
      layoutParams.rightMargin = DensityUtils.a(this.a, 10.0F);
    } 
    linearLayout1.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131296342);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297856);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131300537);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131300975);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131301479);
    ImageView imageView4 = (ImageView)paramBaseViewHolder.d(2131297283);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297805);
    imageView2 = (ImageView)paramBaseViewHolder.d(2131297807);
    FrameLayout frameLayout = (FrameLayout)paramBaseViewHolder.d(2131296343);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131300792);
    LinearLayout linearLayout2 = (LinearLayout)paramBaseViewHolder.d(2131298916);
    LiveAutoPlayView liveAutoPlayView = (LiveAutoPlayView)paramBaseViewHolder.d(2131297172);
    liveAutoPlayView.a(this, paramBluedLiveListData, this.r, layoutParams.width, DensityUtils.a(this.a, 100.0F));
    if (paramBluedLiveListData.positionReal == 0)
      this.s = liveAutoPlayView; 
    if (!TextUtils.isEmpty(paramBluedLiveListData.game_name)) {
      str = paramBluedLiveListData.game_name;
    } else {
      str = "";
    } 
    textView4.setText(str);
    if (!TextUtils.isEmpty(paramBluedLiveListData.title)) {
      textView3.setText(paramBluedLiveListData.title);
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedLiveListData.anchor.name);
      stringBuilder.append(" ");
      stringBuilder.append(this.a.getString(2131757143));
      textView3.setText(stringBuilder.toString());
    } 
    if (paramBluedLiveListData.hb > 0) {
      imageView4.setVisibility(0);
      imageView4.setImageResource(2131233115);
    } else if (paramBluedLiveListData.link_type == 1) {
      imageView4.setVisibility(0);
      imageView4.setImageResource(2131233123);
    } else if (paramBluedLiveListData.link_type == 2) {
      imageView4.setVisibility(0);
      imageView4.setImageResource(2131233119);
    } else {
      imageView4.setVisibility(8);
    } 
    ImageLoader.a(this.b, paramBluedLiveListData.pic_url).a(2131232977).a(imageView3);
    if (!TextUtils.isEmpty(paramBluedLiveListData.realtime_count)) {
      textView2.setText(StringUtils.a(Long.valueOf(paramBluedLiveListData.realtime_count).longValue()));
    } else {
      textView2.setText("");
    } 
    if (paramBluedLiveListData.anchor != null) {
      int i = paramBluedLiveListData.screen_pattern;
      str = paramBluedLiveListData.anchor.avatar;
      String str1 = paramBluedLiveListData.pic_url;
      String str2 = paramBluedLiveListData.lid;
      String str3 = paramBluedLiveListData.anchor.name;
      str1 = paramBluedLiveListData.uid;
      int j = paramBluedLiveListData.anchor.vbadge;
      LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(str2, 0L), i, this.r, str1, str3, str, j);
      liveRoomData.live_url = paramBluedLiveListData.live_play;
      linearLayout1.setOnClickListener(new View.OnClickListener(this, paramBluedLiveListData, liveRoomData) {
            public void onClick(View param1View) {
              EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, LiveListAdapter.a(this.c), this.a.lid, this.a.uid);
              LiveRoomInfoChannel.a(LiveListAdapter.b(this.c), this.b, -1, LiveRoomInfoChannel.a(LiveListAdapter.c(this.c), LiveListAdapter.d(this.c)));
            }
          });
      linearLayout2.setOnClickListener(new View.OnClickListener(this, str1) {
            public void onClick(View param1View) {
              UserInfoFragmentNew.a(LiveListAdapter.b(this.b), this.a, "");
            }
          });
      if (!TextUtils.isEmpty(paramBluedLiveListData.anchor.name)) {
        textView1.setText(paramBluedLiveListData.anchor.name);
      } else {
        textView1.setText("");
      } 
    } 
    if (!paramBluedLiveListData.isShowUrlVisited) {
      String str1 = paramBluedLiveListData.uid;
      String str2 = paramBluedLiveListData.lid;
      String str3 = this.q;
      if (paramBluedLiveListData.link_type == 1) {
        str = "1";
      } else {
        str = "0";
      } 
      InstantLog.a(2, str1, str2, str3, str, paramBluedLiveListData.realtime_count);
      paramBluedLiveListData.isShowUrlVisited = true;
    } 
  }
  
  private void d() {
    LiveAutoPlayView liveAutoPlayView = this.t;
    if (liveAutoPlayView != null && liveAutoPlayView.d()) {
      liveAutoPlayView = this.t;
      if (liveAutoPlayView != null)
        liveAutoPlayView.c(); 
    } 
    liveAutoPlayView = this.s;
    if (liveAutoPlayView != null && this.u)
      liveAutoPlayView.a(); 
  }
  
  private void d(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {}
  
  private void e(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {}
  
  private void f(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {
    if (!this.v.contains(paramBluedLiveListData.lid)) {
      this.v.add(paramBluedLiveListData.lid);
      EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, "official", paramBluedLiveListData.lid, paramBluedLiveListData.uid);
    } 
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131296342);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297856);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131300537);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131300975);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131301479);
    ImageView imageView4 = (ImageView)paramBaseViewHolder.d(2131297283);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297805);
    imageView2 = (ImageView)paramBaseViewHolder.d(2131297807);
    LinearLayout linearLayout = (LinearLayout)paramBaseViewHolder.d(2131298916);
    if (paramBluedLiveListData.hb > 0) {
      imageView4.setVisibility(0);
      imageView4.setImageResource(2131233115);
    } else if (paramBluedLiveListData.link_type == 1) {
      imageView4.setVisibility(0);
      imageView4.setImageResource(2131233123);
    } else if (paramBluedLiveListData.link_type == 2) {
      imageView4.setVisibility(0);
      imageView4.setImageResource(2131233119);
    } else {
      imageView4.setVisibility(8);
    } 
    ImageLoader.a(this.b, paramBluedLiveListData.pic_url).a(2131232977).a(imageView1);
    if (!TextUtils.isEmpty(paramBluedLiveListData.realtime_count)) {
      textView3.setText(StringUtils.a(Long.valueOf(paramBluedLiveListData.realtime_count).longValue()));
    } else {
      textView3.setText("");
    } 
    if (paramBluedLiveListData.screen_pattern == 1) {
      if (BlueAppLocal.d()) {
        if (DeviceUtils.a()) {
          imageView3.setImageResource(2131232558);
        } else {
          imageView3.setImageResource(2131232560);
        } 
      } else {
        imageView3.setImageResource(2131232559);
      } 
      imageView3.setVisibility(0);
    } else {
      imageView3.setVisibility(8);
    } 
    if (paramBluedLiveListData.anchor_level >= 80) {
      LiveUtils.a(this.a, (ImageView)paramBaseViewHolder.d(2131298577), paramBluedLiveListData.anchor_level, false);
    } else {
      paramBaseViewHolder.b(2131298577, false);
    } 
    if (paramBluedLiveListData.anchor != null) {
      int i = paramBluedLiveListData.screen_pattern;
      String str1 = paramBluedLiveListData.anchor.avatar;
      String str2 = paramBluedLiveListData.pic_url;
      String str3 = paramBluedLiveListData.lid;
      String str4 = paramBluedLiveListData.anchor.name;
      str2 = paramBluedLiveListData.uid;
      int j = paramBluedLiveListData.anchor.vbadge;
      LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(str3, 0L), i, "official_live", str2, str4, str1, j);
      liveRoomData.live_url = paramBluedLiveListData.live_play;
      imageView1.setOnClickListener(new View.OnClickListener(this, paramBluedLiveListData, liveRoomData) {
            public void onClick(View param1View) {
              EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, "official", this.a.lid, this.a.uid);
              LiveRoomInfoChannel.a(LiveListAdapter.b(this.c), this.b, -1, LiveRoomInfoChannel.a(LiveListDataUtils.a(LiveListAdapter.c(this.c)), "official_live"));
            }
          });
      linearLayout.setOnClickListener(new View.OnClickListener(this, str2) {
            public void onClick(View param1View) {
              UserInfoFragmentNew.a(LiveListAdapter.b(this.b), this.a, "");
            }
          });
      if (!TextUtils.isEmpty(paramBluedLiveListData.title)) {
        textView1.setText(paramBluedLiveListData.title);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedLiveListData.anchor.name);
      stringBuilder.append(" ");
      stringBuilder.append(this.a.getString(2131757143));
      textView1.setText(stringBuilder.toString());
    } 
  }
  
  private void g(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {
    if (!this.v.contains(paramBluedLiveListData.lid)) {
      this.v.add(paramBluedLiveListData.lid);
      EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, "red", paramBluedLiveListData.lid, paramBluedLiveListData.uid);
    } 
    ViewGroup viewGroup = (ViewGroup)paramBaseViewHolder.d(2131298589);
    GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams)viewGroup.getLayoutParams();
    layoutParams.height = this.g;
    layoutParams.topMargin = DensityUtils.a(this.a, 0.0F);
    layoutParams.bottomMargin = DensityUtils.a(this.a, 3.0F);
    if (paramBluedLiveListData.position == 0) {
      layoutParams.leftMargin = DensityUtils.a(this.a, 10.0F);
      layoutParams.rightMargin = 0;
    } else if (paramBluedLiveListData.position == 1) {
      layoutParams.leftMargin = DensityUtils.a(this.a, 3.0F);
      layoutParams.rightMargin = DensityUtils.a(this.a, 3.0F);
    } else if (paramBluedLiveListData.position == 2) {
      layoutParams.leftMargin = 0;
      layoutParams.rightMargin = DensityUtils.a(this.a, 10.0F);
    } 
    viewGroup.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131296342);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297856);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131300537);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131300975);
    textView1 = (TextView)paramBaseViewHolder.d(2131301479);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297283);
    ImageView imageView4 = (ImageView)paramBaseViewHolder.d(2131297805);
    imageView4 = (ImageView)paramBaseViewHolder.d(2131297807);
    LiveAutoPlayView liveAutoPlayView = (LiveAutoPlayView)paramBaseViewHolder.d(2131297172);
    liveAutoPlayView.a(this, paramBluedLiveListData, this.r, this.g, DensityUtils.a(this.a, 121.0F));
    if (paramBluedLiveListData.positionReal == 0)
      this.t = liveAutoPlayView; 
    if (paramBluedLiveListData.hb > 0) {
      imageView3.setVisibility(0);
      imageView3.setImageResource(2131233115);
    } else if (paramBluedLiveListData.link_type == 1) {
      imageView3.setVisibility(0);
      imageView3.setImageResource(2131233123);
      if (paramBluedLiveListData.positionReal == 0)
        this.t = null; 
    } else if (paramBluedLiveListData.link_type == 2) {
      imageView3.setVisibility(0);
      imageView3.setImageResource(2131233119);
      if (paramBluedLiveListData.positionReal == 0)
        this.t = null; 
    } else {
      imageView3.setVisibility(8);
    } 
    ImageLoader.a(this.b, paramBluedLiveListData.pic_url).a(2131232977).a(imageView2);
    if (!TextUtils.isEmpty(paramBluedLiveListData.realtime_count)) {
      textView2.setText(StringUtils.a(Long.valueOf(paramBluedLiveListData.realtime_count).longValue()));
    } else {
      textView2.setText("");
    } 
    if (paramBluedLiveListData.anchor_level >= 80) {
      LiveUtils.a(this.a, (ImageView)paramBaseViewHolder.d(2131298577), paramBluedLiveListData.anchor_level, false);
    } else {
      paramBaseViewHolder.b(2131298577, false);
    } 
    if (paramBluedLiveListData.anchor != null) {
      int i = paramBluedLiveListData.screen_pattern;
      String str1 = paramBluedLiveListData.anchor.avatar;
      String str2 = paramBluedLiveListData.pic_url;
      str2 = paramBluedLiveListData.lid;
      String str3 = paramBluedLiveListData.anchor.name;
      viewGroup.setOnClickListener(new View.OnClickListener(this, paramBluedLiveListData, str2, paramBluedLiveListData.uid, i, str3, str1, paramBluedLiveListData.anchor.vbadge) {
            public void onClick(View param1View) {
              if (this.a.positionReal == 0 && TextUtils.equals(LiveListAdapter.a(this.h), "0"))
                if (this.a.link_type == 1) {
                  EventTrackLive.a(LiveProtos.Event.LIVE_FAVORITE_FIRST_ROOM_CLICK, this.b, this.c, LiveProtos.EnterType.PK);
                } else if (this.a.link_type == 2) {
                  EventTrackLive.a(LiveProtos.Event.LIVE_FAVORITE_FIRST_ROOM_CLICK, this.b, this.c, LiveProtos.EnterType.FRIEND);
                } else {
                  EventTrackLive.a(LiveProtos.Event.LIVE_FAVORITE_FIRST_ROOM_CLICK, this.b, this.c, LiveProtos.EnterType.COMMON);
                }  
              EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_CLICK, "red", this.a.lid, this.a.uid);
              ArrayList<BluedLiveListData> arrayList = new ArrayList();
              for (BluedLiveListData bluedLiveListData : LiveListAdapter.e(this.h)) {
                if (bluedLiveListData.liveType == 0 || bluedLiveListData.liveType == 1 || bluedLiveListData.liveType == 2)
                  arrayList.add(bluedLiveListData); 
              } 
              LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(this.b, 0L), this.d, "red_board", this.c, this.e, this.f, this.g);
              liveRoomData.live_url = this.a.live_play;
              LiveRoomInfoChannel.a(LiveListAdapter.b(this.h), liveRoomData, -1, LiveRoomInfoChannel.a(LiveListDataUtils.a(arrayList), "red_board"));
              InstantLog.b("click_live_hot", this.c);
            }
          });
      if (!TextUtils.isEmpty(paramBluedLiveListData.anchor.name)) {
        textView1.setText(paramBluedLiveListData.anchor.name);
      } else {
        textView1.setText("");
      } 
    } 
    if (!paramBluedLiveListData.isShowUrlVisited) {
      String str1;
      String str2 = paramBluedLiveListData.uid;
      String str3 = paramBluedLiveListData.lid;
      String str4 = this.q;
      if (paramBluedLiveListData.link_type == 1) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      InstantLog.a(3, str2, str3, str4, str1, paramBluedLiveListData.realtime_count);
      paramBluedLiveListData.isShowUrlVisited = true;
    } 
  }
  
  public boolean B() {
    LiveAutoPlayView liveAutoPlayView = this.t;
    if (liveAutoPlayView != null && liveAutoPlayView.d()) {
      liveAutoPlayView = this.s;
      if (liveAutoPlayView != null && liveAutoPlayView.d() && this.t.getHeight() != 0 && this.s.getHeight() != 0) {
        int[] arrayOfInt = new int[2];
        this.t.getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[1];
        this.s.getLocationOnScreen(arrayOfInt);
        int j = arrayOfInt[1];
        if (Math.abs(i + this.t.getHeight() - AppInfo.m / 2) < Math.abs(j + this.s.getHeight() - AppInfo.m / 2)) {
          Log.i("xpp", "prepareToPlayIfHave 1");
          A();
          return true;
        } 
        Log.i("xpp", "prepareToPlayIfHave 2");
        d();
        return true;
      } 
    } 
    liveAutoPlayView = this.t;
    if (liveAutoPlayView != null && liveAutoPlayView.d()) {
      Log.i("xpp", "prepareToPlayIfHave 3");
      A();
      return true;
    } 
    liveAutoPlayView = this.s;
    if (liveAutoPlayView != null && liveAutoPlayView.d()) {
      Log.i("xpp", "prepareToPlayIfHave 4");
      d();
      return true;
    } 
    return false;
  }
  
  public void a() {
    LiveAutoPlayView liveAutoPlayView = this.t;
    if (liveAutoPlayView != null)
      liveAutoPlayView.b(); 
    liveAutoPlayView = this.s;
    if (liveAutoPlayView != null)
      liveAutoPlayView.b(); 
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedLiveListData paramBluedLiveListData) {
    if (paramBaseViewHolder != null) {
      int i = paramBaseViewHolder.getItemViewType();
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 5) {
                if (i != 6) {
                  if (i != 7) {
                    if (i != 10)
                      return; 
                    a(paramBaseViewHolder, paramBluedLiveListData, false);
                    return;
                  } 
                  b(paramBaseViewHolder, paramBluedLiveListData);
                  return;
                } 
                c(paramBaseViewHolder, paramBluedLiveListData);
                return;
              } 
              e(paramBaseViewHolder, paramBluedLiveListData);
              return;
            } 
            d(paramBaseViewHolder, paramBluedLiveListData);
            return;
          } 
          g(paramBaseViewHolder, paramBluedLiveListData);
          return;
        } 
        f(paramBaseViewHolder, paramBluedLiveListData);
        return;
      } 
      a(paramBaseViewHolder, paramBluedLiveListData, true);
    } 
  }
  
  public void a(List<BluedLiveListData> paramList) {
    a(paramList, false);
  }
  
  public void a(List<BluedLiveListData> paramList, boolean paramBoolean) {
    int i = this.n.size();
    this.n.clear();
    if (paramList != null)
      for (int j = 0; j < paramList.size(); j++) {
        if (!TextUtils.isEmpty(((BluedLiveListData)paramList.get(j)).lid) && !this.f.contains(((BluedLiveListData)paramList.get(j)).lid)) {
          this.f.add(((BluedLiveListData)paramList.get(j)).lid);
          this.e.add(paramList.get(j));
        } 
      }  
    this.n.addAll(LiveListDataUtils.a(this.e, this.i));
    if (i == this.n.size() && !paramBoolean)
      c(false); 
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  public void b() {
    if (!B())
      a(); 
  }
  
  public void c(List<BluedLiveListData> paramList) {
    this.f.clear();
    this.e.clear();
    this.v.clear();
    a(paramList, true);
  }
  
  public void e(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public void f(boolean paramBoolean) {
    LiveAutoPlayView liveAutoPlayView = this.t;
    if (liveAutoPlayView != null)
      liveAutoPlayView.a(paramBoolean); 
    liveAutoPlayView = this.s;
    if (liveAutoPlayView != null)
      liveAutoPlayView.a(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\LiveListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */