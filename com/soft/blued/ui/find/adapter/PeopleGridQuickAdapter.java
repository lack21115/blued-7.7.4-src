package com.soft.blued.ui.find.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.manager.LiveListAutoPlay;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.live.view.LiveAutoPlayView;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PeopleGridQuickAdapter extends BaseMultiItemQuickAdapter<UserFindResult, BaseViewHolder> implements LiveListAutoPlay {
  private boolean A = false;
  
  private boolean B = true;
  
  public Context a;
  
  public String b;
  
  public int c;
  
  public int d;
  
  public String e = "";
  
  public String f = "";
  
  public LoadOptions g;
  
  public boolean h = true;
  
  public int i;
  
  public int o;
  
  public boolean p = false;
  
  public int q = 0;
  
  public List<Map<String, String>> r = new ArrayList<Map<String, String>>();
  
  protected IRequestHost s;
  
  public RecyclerView t;
  
  public MessageProtos.SortType u = MessageProtos.SortType.UNKNOWN_SORT_TYPE;
  
  protected OnDrawPeopleListener v;
  
  private int w;
  
  private HashSet<String> x = new HashSet<String>();
  
  private String y = "";
  
  private LiveAutoPlayView z;
  
  public PeopleGridQuickAdapter(List<UserFindResult> paramList, Activity paramActivity, IRequestHost paramIRequestHost, String paramString, RecyclerView paramRecyclerView) {
    super(paramList);
    this.a = (Context)paramActivity;
    this.b = paramString;
    this.t = paramRecyclerView;
    paramRecyclerView.setRecyclerListener(new RecyclerView.RecyclerListener(this, paramIRequestHost) {
          public void onViewRecycled(RecyclerView.ViewHolder param1ViewHolder) {
            BaseViewHolder baseViewHolder = (BaseViewHolder)param1ViewHolder;
            ImageLoader.a(this.a, (ImageView)baseViewHolder.d(2131297512));
          }
        });
    this.i = DensityUtils.a(this.a, 3.0F);
    this.o = (this.a.getResources().getDisplayMetrics()).widthPixels;
    this.d = a(this.a);
    a();
    this.w = this.c - DensityUtils.a(this.a, 15.0F) - DensityUtils.a(this.a, 12.0F);
    this.s = paramIRequestHost;
    this.g = new LoadOptions();
    LoadOptions loadOptions = this.g;
    loadOptions.l = false;
    loadOptions.d = 2131231368;
    loadOptions.b = 2131231368;
    int i = this.o;
    loadOptions.a(i >> 1, i >> 1);
    c();
  }
  
  private void E() {
    List list = n();
    if (list != null) {
      int i = 0;
      for (UserFindResult userFindResult : list) {
        if (userFindResult != null && userFindResult.getItemType() == 10) {
          userFindResult.userPositionReal = i;
          i++;
        } 
      } 
    } 
  }
  
  private void F() {
    LiveAutoPlayView liveAutoPlayView = this.z;
    if (liveAutoPlayView != null && this.B)
      liveAutoPlayView.a(); 
  }
  
  public static int a(Context paramContext) {
    return 3;
  }
  
  private void a(List<UserFindResult> paramList) {
    if (paramList != null) {
      Iterator<UserFindResult> iterator = paramList.iterator();
      while (iterator.hasNext()) {
        UserFindResult userFindResult = iterator.next();
        if (a(userFindResult)) {
          iterator.remove();
          continue;
        } 
        this.x.add(userFindResult.uid);
      } 
    } 
  }
  
  private boolean a(UserFindResult paramUserFindResult) {
    return (paramUserFindResult == null) ? true : this.x.contains(paramUserFindResult.uid);
  }
  
  private boolean b(UserFindResult paramUserFindResult) {
    return (this.A && paramUserFindResult.live > 0 && !TextUtils.isEmpty(paramUserFindResult.live_url));
  }
  
  public void A() {
    RecyclerView recyclerView = this.t;
    if (recyclerView != null && recyclerView.isComputingLayout()) {
      this.t.post(new -$$Lambda$NJ4rwsxqkinPn894O2O8tO_p1yg(this));
      return;
    } 
    notifyDataSetChanged();
  }
  
  public boolean B() {
    this.z = null;
    RecyclerView.LayoutManager layoutManager = e().getLayoutManager();
    if (layoutManager instanceof GridLayoutManager) {
      GridLayoutManager gridLayoutManager = (GridLayoutManager)layoutManager;
      int i = gridLayoutManager.findFirstCompletelyVisibleItemPosition() - o();
      int j = gridLayoutManager.findLastCompletelyVisibleItemPosition() - o();
      if (this.n != null && i <= j) {
        if (j >= this.n.size())
          return false; 
        while (i < j) {
          UserFindResult userFindResult = this.n.get(i);
          if (userFindResult.getItemType() == 10 && this.A && userFindResult.live > 0 && !TextUtils.isEmpty(userFindResult.live_url)) {
            View view = gridLayoutManager.findViewByPosition(o() + i);
            if (view != null) {
              this.z = (LiveAutoPlayView)view.findViewById(2131297361);
              if (this.z != null) {
                BluedLiveListData bluedLiveListData = new BluedLiveListData();
                bluedLiveListData.lid = String.valueOf(userFindResult.live);
                bluedLiveListData.live_play = userFindResult.live_url;
                LiveAutoPlayView liveAutoPlayView1 = this.z;
                i = this.c;
                liveAutoPlayView1.a(this, bluedLiveListData, "", i, i);
                this.z.setVisibility(0);
                break;
              } 
            } 
          } 
          i++;
        } 
      } else {
        return false;
      } 
    } 
    LiveAutoPlayView liveAutoPlayView = this.z;
    if (liveAutoPlayView != null && liveAutoPlayView.d() && this.z.getHeight() != 0) {
      F();
      return true;
    } 
    return false;
  }
  
  public void C() {
    LiveAutoPlayView liveAutoPlayView = this.z;
    if (liveAutoPlayView != null)
      liveAutoPlayView.b(); 
  }
  
  public void D() {
    if (!B())
      C(); 
  }
  
  public void a() {
    this.c = (this.o - this.i * this.d - DensityUtils.a(this.a, 3.0F)) / this.d;
  }
  
  public void a(int paramInt, UserFindResult paramUserFindResult) {
    if (!a(paramUserFindResult)) {
      super.a(paramInt, paramUserFindResult);
      E();
      this.x.add(paramUserFindResult.uid);
    } 
  }
  
  protected void a(View paramView, UserFindResult paramUserFindResult) {
    int i = paramUserFindResult.live;
    boolean bool = true;
    if (i > 0) {
      UserRelationshipUtils.a(this.a, (UserBasicModel)paramUserFindResult, paramUserFindResult.live, this.b, "home_online", paramUserFindResult.recommend_type, paramUserFindResult.userPositionReal + 1);
      return;
    } 
    if (paramUserFindResult.is_have_chatroom > 0 && paramUserFindResult.chatroom != null && !TextUtils.isEmpty(paramUserFindResult.chatroom.room_id)) {
      YYRoomInfoManager.d().a((BaseFragmentActivity)this.a, paramUserFindResult.chatroom.room_id, "nearby_chat_room");
      return;
    } 
    if (!TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
      LiveUtils.a("home_online", paramUserFindResult.recommend_type, paramUserFindResult.userPositionReal + 1);
      WebViewShowInfoFragment.a(this.a, paramUserFindResult.redirect_url, "", false, 9);
      return;
    } 
    if (paramUserFindResult.is_invisible_half == 1 && (((UserInfo.a().i()).vip_grade != 2 && (UserInfo.a().i()).vip_grade != 1) || (BluedConfig.b().j()).is_invisible_half == 0)) {
      PayUtils.a(this.a, 3, "user_half_invisible");
      return;
    } 
    if (paramUserFindResult.live <= 0)
      bool = false; 
    a(paramUserFindResult, paramView, bool, 0);
  }
  
  public void a(MessageProtos.SortType paramSortType) {
    this.u = paramSortType;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    if (paramBaseViewHolder != null) {
      if (paramBaseViewHolder.getItemViewType() != 11) {
        b(paramBaseViewHolder, paramUserFindResult);
        return;
      } 
      e(paramBaseViewHolder, paramUserFindResult);
    } 
  }
  
  public void a(OnDrawPeopleListener paramOnDrawPeopleListener) {
    this.v = paramOnDrawPeopleListener;
  }
  
  protected void a(UserFindResult paramUserFindResult, View paramView, boolean paramBoolean, int paramInt) {
    if (this.h) {
      String str1;
      MessageProtos.StrangerSource strangerSource1;
      boolean bool2 = false;
      this.h = false;
      LogData logData = new LogData();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      String str2 = "";
      stringBuilder.append("");
      logData.k = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramUserFindResult.is_call);
      stringBuilder.append("");
      logData.u = stringBuilder.toString();
      logData.w = this.b;
      if (StringUtils.e(paramUserFindResult.distanceStr)) {
        str1 = paramUserFindResult.distance;
      } else {
        str1 = paramUserFindResult.distanceStr;
      } 
      logData.x = str1;
      if (StringUtils.e(paramUserFindResult.last_operate_str)) {
        str1 = paramUserFindResult.last_operate;
      } else {
        str1 = paramUserFindResult.last_operate_str;
      } 
      logData.y = str1;
      logData.z = paramUserFindResult.additional_tag_type;
      logData.A = paramUserFindResult.selected_tag;
      if (paramUserFindResult.is_shadow == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      logData.C = bool1;
      boolean bool1 = bool2;
      if (paramUserFindResult.is_quietly == 1)
        bool1 = true; 
      logData.E = bool1;
      if ("nearby".equals(this.b)) {
        strangerSource1 = MessageProtos.StrangerSource.DISTANCE_SORT;
      } else if ("online".equals(this.b)) {
        strangerSource1 = MessageProtos.StrangerSource.ONLINE_TIME_SORT;
      } else if ("newbie".equals(this.b)) {
        strangerSource1 = MessageProtos.StrangerSource.FRIEND_NEARBY_NEW_FACE;
      } else if ("tag_user".equals(this.b)) {
        strangerSource1 = MessageProtos.StrangerSource.FRIEND_NEARBY_PERSONAL_NEARBY;
        str2 = this.y;
      } else {
        strangerSource1 = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
      } 
      if (MapFindManager.a().b())
        strangerSource1 = MessageProtos.StrangerSource.MAP_FIND; 
      if (paramUserFindResult.is_shadow == 1)
        strangerSource1 = MessageProtos.StrangerSource.SHADOW_SOURCE; 
      MessageProtos.StrangerSource strangerSource2 = strangerSource1;
      if (paramUserFindResult.is_call == 1)
        if ("integrate".equalsIgnoreCase(this.b)) {
          strangerSource2 = MessageProtos.StrangerSource.APPRECIATE_CALL_COMPLEX;
        } else {
          strangerSource2 = strangerSource1;
          if ("online".equalsIgnoreCase(this.b))
            strangerSource2 = MessageProtos.StrangerSource.APPRECIATE_CALL_ONLINE; 
        }  
      if (paramUserFindResult.is_eco_user == 1) {
        UserInfoFragmentNew.a(this.a, paramUserFindResult.uid);
      } else {
        UserInfoFragmentNew.a(this.a, (UserBasicModel)paramUserFindResult, this.b, paramBoolean, paramView, logData, new MsgSourceEntity(strangerSource2, str2));
      } 
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              this.a.h = true;
            }
          },  300L);
    } 
  }
  
  public void a(String paramString) {
    this.y = paramString;
  }
  
  public void a(Collection<? extends UserFindResult> paramCollection) {
    paramCollection = new ArrayList<UserFindResult>(paramCollection);
    a((List)paramCollection);
    super.a(paramCollection);
    E();
    c(true);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean) {
    this.A = paramBoolean;
  }
  
  public String b() {
    return this.y;
  }
  
  public void b(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    FrameLayout frameLayout = (FrameLayout)paramBaseViewHolder.d(2131297133);
    GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams)frameLayout.getLayoutParams();
    int i = this.c;
    layoutParams.width = i;
    layoutParams.height = i;
    i = this.i;
    layoutParams.bottomMargin = i;
    layoutParams.rightMargin = i;
    frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131300020);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131301088);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131299416);
    ImageView imageView4 = (ImageView)paramBaseViewHolder.d(2131297288);
    ImageView imageView5 = (ImageView)paramBaseViewHolder.d(2131297581);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131297545);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131297451);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297512);
    ImageView imageView6 = (ImageView)paramBaseViewHolder.d(2131297575);
    imageView6.setVisibility(8);
    imageView5.setVisibility(8);
    imageView6.setVisibility(0);
    UserRelationshipUtils.b(imageView6, paramUserFindResult.vbadge, 4, 8);
    UserRelationshipUtils.b(imageView5, (UserBasicModel)paramUserFindResult);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("maxWidth = ");
    stringBuilder.append(this.w);
    Log.e("adapter", stringBuilder.toString());
    textView1.setMaxWidth(this.w);
    ImageView imageView7 = (ImageView)paramBaseViewHolder.d(2131297470);
    if (paramUserFindResult.is_eco_user == 1) {
      imageView7.setVisibility(0);
      imageView5.setVisibility(8);
      imageView6.setVisibility(8);
    } else {
      imageView7.setVisibility(8);
    } 
    View view = paramBaseViewHolder.d(2131297448);
    imageView1.setVisibility(0);
    view.setVisibility(0);
    imageView1.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.c));
    FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams)view.getLayoutParams();
    layoutParams1.height = this.c * 2 / 5;
    layoutParams1.width = -1;
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    if (!TextUtils.isEmpty(paramUserFindResult.note)) {
      textView1.setText(paramUserFindResult.note);
    } else if (!TextUtils.isEmpty(paramUserFindResult.name)) {
      textView1.setText(paramUserFindResult.name);
    } else {
      textView1.setText("");
    } 
    if (!TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
      ImageLoader.a(this.s, paramUserFindResult.avatar).a(2131231368).a(imageView1);
    } else {
      String str;
      if (paramUserFindResult.is_invisible_half == 1) {
        str = paramUserFindResult.avatar;
      } else if ("selected".equalsIgnoreCase(this.b)) {
        str = AvatarUtils.a(3, paramUserFindResult.avatar);
      } else {
        str = AvatarUtils.a(2, paramUserFindResult.avatar);
      } 
      ImageLoader.a(this.s, str).a(2131231368).a(imageView1);
    } 
    LiveAutoPlayView liveAutoPlayView = (LiveAutoPlayView)paramBaseViewHolder.d(2131297361);
    if (b(paramUserFindResult)) {
      liveAutoPlayView.setVisibility(0);
    } else {
      liveAutoPlayView.setVisibility(8);
    } 
    imageView3.setVisibility(0);
    imageView2.setVisibility(8);
    if (paramUserFindResult.call_tip == 1) {
      imageView4.setVisibility(0);
    } else {
      imageView4.setVisibility(8);
    } 
    if (paramUserFindResult.is_reactive_recommend == 1) {
      textView3.setVisibility(0);
    } else {
      textView3.setVisibility(8);
    } 
    if (paramUserFindResult.is_have_chatroom == 1) {
      textView4.setVisibility(0);
    } else {
      textView4.setVisibility(8);
    } 
    if (paramUserFindResult.live > 0) {
      imageView3.setVisibility(8);
      imageView4.setVisibility(8);
      textView3.setVisibility(8);
      textView4.setVisibility(8);
      imageView2.setVisibility(0);
      FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams)imageView2.getLayoutParams();
      layoutParams2.width = DensityUtils.a(this.a, 43.0F);
      layoutParams2.height = DensityUtils.a(this.a, 15.0F);
      imageView2.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
      ImageLoader.c(this.s, "live_icon_anim.png").d(paramBaseViewHolder.hashCode()).e(-1).a(imageView2);
    } else if (!TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
      imageView3.setVisibility(8);
      imageView4.setVisibility(8);
      textView3.setVisibility(8);
      textView4.setVisibility(8);
    } else if (paramUserFindResult.online_state == 1) {
      imageView3.setImageResource(2131234360);
    } else {
      imageView3.setImageResource(2131234359);
    } 
    i = -1;
    if (!TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
      textView2.setVisibility(8);
    } else {
      textView2.setVisibility(0);
      String str = this.b;
      switch (str.hashCode()) {
        case 492822833:
          if (str.equals("integrate"))
            i = 1; 
          break;
        case -1012222381:
          if (str.equals("online"))
            i = 0; 
          break;
        case -1048842402:
          if (str.equals("newbie"))
            i = 2; 
          break;
        case -1049482625:
          if (str.equals("nearby"))
            i = 3; 
          break;
      } 
      if (i != 0) {
        if (i != 1 && i != 2) {
          if (StringUtils.e(paramUserFindResult.distanceStr)) {
            str = paramUserFindResult.distance;
          } else {
            str = paramUserFindResult.distanceStr;
          } 
          if (!TextUtils.isEmpty(str)) {
            textView2.setText(str);
            textView2.setVisibility(0);
          } else {
            textView2.setText("");
            textView2.setVisibility(8);
          } 
          DistanceUtils.a(this.a, textView2, (UserBasicModel)paramUserFindResult, 1);
        } else {
          textView2.setVisibility(8);
        } 
      } else {
        if (StringUtils.e(paramUserFindResult.last_operate_str)) {
          str = paramUserFindResult.last_operate;
        } else {
          str = paramUserFindResult.last_operate_str;
        } 
        if (!TextUtils.isEmpty(str)) {
          textView2.setVisibility(0);
          textView2.setText(str);
        } else {
          textView2.setVisibility(8);
          textView2.setText("");
        } 
        TypefaceUtils.a(this.a, textView2, paramUserFindResult.is_hide_last_operate, 1);
      } 
    } 
    imageView1.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, paramBaseViewHolder, paramUserFindResult, imageView1) {
            public void onClick(View param1View) {
              LiveEventBus.get("is_click_on_header").post(Boolean.valueOf(true));
              if (this.a.getAdapterPosition() != -1) {
                this.d.c(this.a, this.b);
                this.d.a((View)this.c, this.b);
              } 
            }
          }));
    d(paramBaseViewHolder, paramUserFindResult);
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
  
  public void c() {
    b(10, 2131493382);
    b(11, 2131493623);
  }
  
  public void c(RecyclerView paramRecyclerView) {
    this.t = paramRecyclerView;
  }
  
  protected void c(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    String str1;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    int i = paramBaseViewHolder.getAdapterPosition();
    int j = o();
    LogData logData = new LogData();
    logData.J = "click_position";
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramBaseViewHolder.getAdapterPosition() / this.d);
    stringBuilder2.append("");
    logData.l = stringBuilder2.toString();
    logData.g = this.b;
    logData.c = paramUserFindResult.uid;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramUserFindResult.is_call);
    stringBuilder1.append("");
    logData.u = stringBuilder1.toString();
    logData.k = "0";
    InstantLog.a(logData);
    if ((BluedPreferences.Y().equals("0-max") ^ true) != 0) {
      InstantLog.g("personal_page", "1");
    } else {
      InstantLog.g("personal_page", "0");
    } 
    Map<String, String> map = BluedHttpTools.a();
    map.put("u", paramUserFindResult.uid);
    int k = paramUserFindResult.is_hide_distance;
    String str2 = "-1";
    if (k == 1) {
      str1 = "-1";
    } else if (StringUtils.e(paramUserFindResult.distanceStr)) {
      str1 = paramUserFindResult.distance;
    } else {
      str1 = paramUserFindResult.distanceStr;
    } 
    map.put("d", str1);
    if (paramUserFindResult.is_hide_last_operate == 1) {
      str1 = str2;
    } else {
      str1 = paramUserFindResult.last_operate_time_stamp;
    } 
    map.put("t", str1);
    GuyProtos.Event event = GuyProtos.Event.NEARBY_FRIEND_USER_PHOTO_CLICK;
    str2 = AppInfo.f().toJson(map);
    GuyProtos.SortType sortType = EventTrackGuy.c(this.b);
    GuyProtos.ShowType showType = GuyProtos.ShowType.PALACE_SHOW;
    boolean bool6 = MapFindManager.a().b();
    if (paramUserFindResult.is_shadow == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramUserFindResult.is_call == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramUserFindResult.live > 0) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    String str3 = paramUserFindResult.lt;
    if (paramUserFindResult.is_quietly == 1) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    boolean bool7 = b(paramUserFindResult);
    if (paramUserFindResult.is_reactive_recommend == 1) {
      bool5 = true;
    } else {
      bool5 = false;
    } 
    EventTrackGuy.a(event, str2, sortType, showType, bool6, bool1, bool2, bool3, str3, bool4, bool7, bool5, i - j, paramUserFindResult.recommend_type);
    if (paramUserFindResult.live > 0 || !TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
      event = GuyProtos.Event.ONLINE_LIVE_USER_CLICK;
      i = paramUserFindResult.live;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramUserFindResult.uid);
      stringBuilder.append("");
      EventTrackGuy.a(event, String.valueOf(i), stringBuilder.toString(), paramUserFindResult.recommend_type, paramUserFindResult.userPositionReal + 1);
    } 
    if (paramUserFindResult.is_have_chatroom > 0 && paramUserFindResult.chatroom != null)
      EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_CHATROOM_CLICK, paramUserFindResult.uid, paramUserFindResult.chatroom.room_id, paramUserFindResult.chatroom.uid); 
  }
  
  public void c(List<UserFindResult> paramList) {
    List<UserFindResult> list = paramList;
    if (paramList == null)
      list = new ArrayList<UserFindResult>(); 
    this.x.clear();
    a(list);
    if (this.n != null && this.n.size() > 0) {
      this.n.clear();
      this.n.addAll(list);
    } else {
      this.n = new ArrayList();
      this.n.addAll(list);
    } 
    int i = 0;
    this.q = 0;
    for (UserFindResult userFindResult : list) {
      if (userFindResult.getItemType() == 10 && userFindResult.live > 0) {
        userFindResult.positionReal = i;
        i++;
      } 
    } 
    E();
    c(true);
    notifyDataSetChanged();
  }
  
  protected void d(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    if (!paramUserFindResult.isShowUrlVisited) {
      String str1;
      paramUserFindResult.isShowUrlVisited = true;
      if (paramBaseViewHolder != null) {
        if (paramUserFindResult.live > 0 || !TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
          GuyProtos.Event event = GuyProtos.Event.ONLINE_LIVE_USER_SHOW;
          int m = paramUserFindResult.live;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramUserFindResult.uid);
          stringBuilder1.append("");
          EventTrackGuy.a(event, String.valueOf(m), stringBuilder1.toString(), paramUserFindResult.recommend_type, paramUserFindResult.userPositionReal + 1);
        } 
        if (paramUserFindResult.is_have_chatroom > 0 && paramUserFindResult.chatroom != null)
          EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_CHATROOM_SHOW, paramUserFindResult.uid, paramUserFindResult.chatroom.room_id, paramUserFindResult.chatroom.uid); 
      } 
      if (!StringUtils.e(paramUserFindResult.uid)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.e);
        stringBuilder1.append("-");
        stringBuilder1.append(paramUserFindResult.uid);
        this.e = stringBuilder1.toString();
        if (paramUserFindResult.is_call == 1) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.f);
          stringBuilder1.append("-");
          stringBuilder1.append(paramUserFindResult.uid);
          this.f = stringBuilder1.toString();
        } 
        if (d()) {
          if (InstantLog.b(this.e))
            this.e = ""; 
        } else if (InstantLog.a(this.b, this.e, this.f, 0)) {
          this.e = "";
          this.f = "";
        } 
      } 
      int i = paramBaseViewHolder.getAdapterPosition();
      int j = o();
      Map<String, String> map = BluedHttpTools.a();
      map.put("u", paramUserFindResult.uid);
      int k = paramUserFindResult.is_hide_distance;
      String str2 = "-1";
      if (k == 1) {
        str1 = "-1";
      } else if (StringUtils.e(paramUserFindResult.distanceStr)) {
        str1 = paramUserFindResult.distance;
      } else {
        str1 = paramUserFindResult.distanceStr;
      } 
      map.put("d", str1);
      if (paramUserFindResult.is_hide_last_operate == 1) {
        str1 = str2;
      } else {
        str1 = paramUserFindResult.last_operate_time_stamp;
      } 
      map.put("t", str1);
      k = paramUserFindResult.is_shadow;
      str2 = "1";
      if (k == 1) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      map.put("shadow", str1);
      if (paramUserFindResult.is_call == 1) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      map.put("call", str1);
      if (paramUserFindResult.live > 0) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      map.put("live", str1);
      map.put("lt", paramUserFindResult.lt);
      if (paramUserFindResult.is_quietly == 1) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      map.put("cq", str1);
      if (b(paramUserFindResult)) {
        str1 = str2;
      } else {
        str1 = "0";
      } 
      map.put("auto", str1);
      map.put("rt", paramUserFindResult.recommend_type);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i - j);
      stringBuilder.append("");
      map.put("n", stringBuilder.toString());
      this.r.add(map);
      if (this.r.size() == 15) {
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_PHOTO_DRAW, AppInfo.f().toJson(this.r), EventTrackGuy.c(this.b), GuyProtos.ShowType.PALACE_SHOW, MapFindManager.a().b());
        this.r.clear();
      } 
      OnDrawPeopleListener onDrawPeopleListener = this.v;
      if (onDrawPeopleListener != null)
        onDrawPeopleListener.a(); 
    } 
  }
  
  protected boolean d() {
    return "msg_hello_detail".equals(this.b);
  }
  
  public RecyclerView e() {
    return this.t;
  }
  
  public void e(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    Logger.c("ljx_ad", new Object[] { " bindADView" });
    ((BannerADView)paramBaseViewHolder.d(2131296495)).a(this.s, (BluedADExtra)paramUserFindResult, ADConstants.AD_POSITION.c, new BannerADView.ADListener(this, paramUserFindResult) {
          public void a() {
            PeopleGridQuickAdapter.a(this.b).remove(this.a);
            this.b.A();
          }
          
          public void b() {
            PeopleGridQuickAdapter.b(this.b).remove(this.a);
            this.b.A();
          }
        });
  }
  
  public void e(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  public void f(boolean paramBoolean) {
    LiveAutoPlayView liveAutoPlayView = this.z;
    if (liveAutoPlayView != null)
      liveAutoPlayView.a(paramBoolean); 
  }
  
  public static interface OnDrawPeopleListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\PeopleGridQuickAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */