package com.soft.blued.ui.find.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.utils.ADClosePopOptionsUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PeopleListQuickAdapter extends PeopleGridQuickAdapter {
  public PeopleListQuickAdapter(List<UserFindResult> paramList, Activity paramActivity, IRequestHost paramIRequestHost, String paramString, RecyclerView paramRecyclerView) {
    super(paramList, paramActivity, paramIRequestHost, paramString, paramRecyclerView);
  }
  
  private void a(UserFindResult paramUserFindResult, int paramInt) {
    if (paramUserFindResult != null && !paramUserFindResult.isShowAdVisited) {
      EventTrackGuy.a(GuyProtos.Event.AD_PRE_ROW_SHOW, this.b, paramInt);
      paramUserFindResult.isShowAdVisited = true;
    } 
  }
  
  protected void a(View paramView, UserFindResult paramUserFindResult) {
    String str1;
    if (paramUserFindResult.live > 0) {
      UserRelationshipUtils.a(this.a, (UserBasicModel)paramUserFindResult, paramUserFindResult.live, this.b, "home_online", paramUserFindResult.recommend_type, paramUserFindResult.userPositionReal + 1);
      return;
    } 
    if (paramUserFindResult.is_have_chatroom > 0 && paramUserFindResult.chatroom != null && !TextUtils.isEmpty(paramUserFindResult.chatroom.room_id)) {
      YYRoomInfoManager.d().a((BaseFragmentActivity)this.a, paramUserFindResult.chatroom.room_id, "nearby_chat_room");
      return;
    } 
    boolean bool = TextUtils.isEmpty(paramUserFindResult.redirect_url);
    String str2 = "";
    if (!bool) {
      LiveUtils.a("home_online", paramUserFindResult.recommend_type, paramUserFindResult.userPositionReal + 1);
      WebViewShowInfoFragment.a(this.a, paramUserFindResult.redirect_url, "", false, 9);
      return;
    } 
    if (paramUserFindResult.is_invisible_half == 1 && (((UserInfo.a().i()).vip_grade != 2 && (UserInfo.a().i()).vip_grade != 1) || (BluedConfig.b().j()).is_invisible_half == 0)) {
      PayUtils.a(this.a, 3, "setting_half_invisible");
      return;
    } 
    LogData logData = new LogData();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserFindResult.is_call);
    stringBuilder.append("");
    logData.u = stringBuilder.toString();
    logData.k = "1";
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
    if (paramUserFindResult.is_shadow == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    logData.C = bool;
    if (paramUserFindResult.is_quietly == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    logData.E = bool;
    if ("nearby".equals(this.b)) {
      strangerSource1 = MessageProtos.StrangerSource.DISTANCE_SORT;
    } else if ("online".equals(this.b)) {
      strangerSource1 = MessageProtos.StrangerSource.ONLINE_TIME_SORT;
    } else if ("newbie".equals(this.b)) {
      strangerSource1 = MessageProtos.StrangerSource.FRIEND_NEARBY_NEW_FACE;
    } else if ("tag_user".equals(this.b)) {
      strangerSource1 = MessageProtos.StrangerSource.FRIEND_NEARBY_PERSONAL_NEARBY;
      str2 = b();
    } else {
      strangerSource1 = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
    } 
    if (MapFindManager.a().b())
      strangerSource1 = MessageProtos.StrangerSource.MAP_FIND; 
    MessageProtos.StrangerSource strangerSource2 = strangerSource1;
    if (paramUserFindResult.is_shadow == 1)
      strangerSource2 = MessageProtos.StrangerSource.SHADOW_SOURCE; 
    MessageProtos.StrangerSource strangerSource1 = strangerSource2;
    if (paramUserFindResult.is_call == 1)
      if ("integrate".equalsIgnoreCase(this.b)) {
        strangerSource1 = MessageProtos.StrangerSource.APPRECIATE_CALL_COMPLEX;
      } else {
        strangerSource1 = strangerSource2;
        if ("online".equalsIgnoreCase(this.b))
          strangerSource1 = MessageProtos.StrangerSource.APPRECIATE_CALL_ONLINE; 
      }  
    if (paramUserFindResult.is_eco_user == 1) {
      UserInfoFragmentNew.a(this.a, paramUserFindResult.uid);
      return;
    } 
    Context context = this.a;
    String str3 = this.b;
    if (paramUserFindResult.live > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    UserInfoFragmentNew.a(context, (UserBasicModel)paramUserFindResult, str3, bool, paramView, logData, new MsgSourceEntity(strangerSource1, str2));
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    a(paramUserFindResult, paramBaseViewHolder.getAdapterPosition() - o());
    if (paramBaseViewHolder != null) {
      int i = paramBaseViewHolder.getItemViewType();
      if (i != 11) {
        if (i != 13) {
          if (i != 14) {
            b(paramBaseViewHolder, paramUserFindResult);
            return;
          } 
          g(paramBaseViewHolder, paramUserFindResult);
          return;
        } 
        f(paramBaseViewHolder, paramUserFindResult);
        return;
      } 
      e(paramBaseViewHolder, paramUserFindResult);
    } 
  }
  
  public void b(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297362);
    TextView textView7 = (TextView)paramBaseViewHolder.d(2131299358);
    TextView textView6 = (TextView)paramBaseViewHolder.d(2131296943);
    TextView textView5 = (TextView)paramBaseViewHolder.d(2131299415);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131296426);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131297368);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131301755);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131299959);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297575);
    ImageView imageView4 = (ImageView)paramBaseViewHolder.d(2131297536);
    ImageView imageView5 = (ImageView)paramBaseViewHolder.d(2131298138);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297447);
    View view = paramBaseViewHolder.d(2131298064);
    ImageView imageView6 = (ImageView)paramBaseViewHolder.d(2131297470);
    ImageView imageView7 = (ImageView)paramBaseViewHolder.d(2131297512);
    TextView textView8 = (TextView)paramBaseViewHolder.d(2131297545);
    TextView textView9 = (TextView)paramBaseViewHolder.d(2131297451);
    LinearLayout linearLayout = (LinearLayout)paramBaseViewHolder.d(2131299013);
    if (paramUserFindResult.is_eco_user == 1) {
      imageView6.setVisibility(0);
    } else {
      imageView6.setVisibility(8);
    } 
    imageView1.setVisibility(0);
    UserRelationshipUtils.b(imageView1, paramUserFindResult.vbadge, 4, 8);
    imageView4.setVisibility(0);
    imageView7.setVisibility(8);
    if (paramUserFindResult.is_reactive_recommend == 1) {
      textView8.setVisibility(0);
    } else {
      textView8.setVisibility(8);
    } 
    if (paramUserFindResult.call_tip == 1) {
      textView8.setVisibility(8);
      imageView5.setVisibility(0);
    } else {
      imageView5.setVisibility(8);
    } 
    if (paramUserFindResult.is_have_chatroom == 1) {
      imageView5.setVisibility(8);
      textView8.setVisibility(8);
      textView9.setVisibility(0);
    } else {
      textView9.setVisibility(8);
    } 
    if (paramUserFindResult.live > 0) {
      imageView4.setVisibility(8);
      imageView5.setVisibility(8);
      textView8.setVisibility(8);
      textView9.setVisibility(8);
      imageView7.setVisibility(0);
    } else if (!TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
      imageView4.setVisibility(8);
      imageView5.setVisibility(8);
      textView8.setVisibility(8);
      textView9.setVisibility(8);
    } else if (paramUserFindResult.online_state == 1) {
      imageView4.setImageDrawable(BluedSkinUtils.b(this.a, 2131234365));
    } else {
      imageView4.setImageDrawable(BluedSkinUtils.b(this.a, 2131234364));
    } 
    if (!TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
      ImageLoader.a(this.s, paramUserFindResult.list_avatar).a(2131234356).c().a(imageView2);
    } else {
      String str;
      if (paramUserFindResult.is_invisible_half == 1) {
        str = paramUserFindResult.avatar;
      } else {
        str = AvatarUtils.a(0, paramUserFindResult.avatar);
      } 
      ImageLoader.a(this.s, str).a(2131234356).c().a(imageView2);
    } 
    UserRelationshipUtils.a(imageView3, (UserBasicModel)paramUserFindResult);
    if (!TextUtils.isEmpty(paramUserFindResult.note)) {
      textView7.setText(paramUserFindResult.note);
    } else if (!TextUtils.isEmpty(paramUserFindResult.name)) {
      textView7.setText(paramUserFindResult.name);
    } else {
      textView7.setText("");
    } 
    UserRelationshipUtils.a(this.a, textView7, (UserBasicModel)paramUserFindResult);
    if (!TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
      textView6.setVisibility(8);
      textView5.setVisibility(8);
      linearLayout.setVisibility(8);
    } else {
      String str;
      textView6.setVisibility(0);
      textView5.setVisibility(0);
      linearLayout.setVisibility(0);
      if (StringUtils.e(paramUserFindResult.distanceStr)) {
        str = paramUserFindResult.distance;
      } else {
        str = paramUserFindResult.distanceStr;
      } 
      if (!TextUtils.isEmpty(str)) {
        textView6.setText(str);
      } else {
        textView6.setText("");
      } 
      DistanceUtils.a(this.a, textView6, (UserBasicModel)paramUserFindResult, 1);
      if (StringUtils.e(paramUserFindResult.last_operate_str)) {
        str = paramUserFindResult.last_operate;
      } else {
        str = paramUserFindResult.last_operate_str;
      } 
      if (!TextUtils.isEmpty(str)) {
        textView5.setText(str);
      } else {
        textView5.setText("");
      } 
      TypefaceUtils.a(this.a, textView5, paramUserFindResult.is_hide_last_operate, 1);
      if (paramUserFindResult.vbadge == 5) {
        linearLayout.setVisibility(8);
      } else {
        linearLayout.setVisibility(0);
        if (!TextUtils.isEmpty(paramUserFindResult.age)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramUserFindResult.age);
          stringBuilder.append(this.a.getResources().getString(2131755267));
          textView1.setText(stringBuilder.toString());
        } else {
          textView1.setText("");
        } 
        if (!TextUtils.isEmpty(paramUserFindResult.height)) {
          textView2.setText(paramUserFindResult.height);
        } else {
          textView2.setText("");
        } 
        if (!TextUtils.isEmpty(paramUserFindResult.weight)) {
          textView3.setText(paramUserFindResult.weight);
        } else {
          textView3.setText("");
        } 
      } 
    } 
    if (TextUtils.isEmpty(paramUserFindResult.description)) {
      textView4.setText("");
      textView4.setVisibility(8);
    } else {
      textView4.setVisibility(0);
      textView4.setText(paramUserFindResult.description);
    } 
    view.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, paramBaseViewHolder, paramUserFindResult, imageView2) {
            public void onClick(View param1View) {
              LiveEventBus.get("is_click_on_header").post(Boolean.valueOf(true));
              this.d.c(this.a, this.b);
              this.d.a((View)this.c, this.b);
            }
          }));
    d(paramBaseViewHolder, paramUserFindResult);
  }
  
  public void c() {
    b(10, 2131493624);
    b(11, 2131493623);
    b(13, 2131493620);
    b(14, 2131493620);
    b(15, 2131493620);
  }
  
  protected void c(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    String str1;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    LogData logData = new LogData();
    logData.J = "click_position";
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBaseViewHolder.getAdapterPosition() - o());
    stringBuilder.append("");
    logData.l = stringBuilder.toString();
    logData.g = this.b;
    logData.c = paramUserFindResult.uid;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserFindResult.is_call);
    stringBuilder.append("");
    logData.u = stringBuilder.toString();
    logData.k = "1";
    InstantLog.a(logData);
    if ((BluedPreferences.Y().equals("0-max") ^ true) != 0) {
      InstantLog.g("personal_page", "1");
    } else {
      InstantLog.g("personal_page", "0");
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
    GuyProtos.Event event = GuyProtos.Event.NEARBY_FRIEND_USER_PHOTO_CLICK;
    str2 = AppInfo.f().toJson(map);
    GuyProtos.SortType sortType = EventTrackGuy.c(this.b);
    GuyProtos.ShowType showType = GuyProtos.ShowType.LIST_SHOW;
    boolean bool = MapFindManager.a().b();
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
    if (paramUserFindResult.is_reactive_recommend == 1) {
      bool5 = true;
    } else {
      bool5 = false;
    } 
    EventTrackGuy.a(event, str2, sortType, showType, bool, bool1, bool2, bool3, str3, bool4, false, bool5, i - j, paramUserFindResult.recommend_type);
    if (paramUserFindResult.live > 0 || !TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
      event = GuyProtos.Event.ONLINE_LIVE_USER_CLICK;
      i = paramUserFindResult.live;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramUserFindResult.uid);
      stringBuilder1.append("");
      EventTrackGuy.a(event, String.valueOf(i), stringBuilder1.toString(), paramUserFindResult.recommend_type, paramUserFindResult.userPositionReal + 1);
    } 
    if (paramUserFindResult.is_have_chatroom > 0 && paramUserFindResult.chatroom != null)
      EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_CHATROOM_CLICK, paramUserFindResult.uid, paramUserFindResult.chatroom.room_id, paramUserFindResult.chatroom.uid); 
  }
  
  protected void d(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    if (!paramUserFindResult.isShowUrlVisited) {
      if (paramBaseViewHolder != null) {
        if (paramUserFindResult.live > 0 || !TextUtils.isEmpty(paramUserFindResult.redirect_url)) {
          GuyProtos.Event event = GuyProtos.Event.ONLINE_LIVE_USER_SHOW;
          int i = paramUserFindResult.live;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramUserFindResult.uid);
          stringBuilder.append("");
          EventTrackGuy.a(event, String.valueOf(i), stringBuilder.toString(), paramUserFindResult.recommend_type, paramUserFindResult.userPositionReal + 1);
        } 
        if (paramUserFindResult.is_have_chatroom > 0 && paramUserFindResult.chatroom != null)
          EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_CHATROOM_SHOW, paramUserFindResult.uid, paramUserFindResult.chatroom.room_id, paramUserFindResult.chatroom.uid); 
      } 
      if (!StringUtils.e(paramUserFindResult.uid)) {
        String str1;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.e);
        stringBuilder2.append("-");
        stringBuilder2.append(paramUserFindResult.uid);
        this.e = stringBuilder2.toString();
        if (paramUserFindResult.is_call == 1) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.f);
          stringBuilder2.append("-");
          stringBuilder2.append(paramUserFindResult.uid);
          this.f = stringBuilder2.toString();
        } 
        if (InstantLog.a(this.b, this.e, this.f, 1)) {
          this.e = "";
          this.f = "";
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
        if (paramUserFindResult.is_reactive_recommend == 1) {
          str1 = "1";
        } else {
          str1 = "0";
        } 
        map.put("ai", str1);
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
          str1 = str2;
        } else {
          str1 = "0";
        } 
        map.put("cq", str1);
        map.put("auto", "0");
        map.put("rt", paramUserFindResult.recommend_type);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(i - j);
        stringBuilder1.append("");
        map.put("n", stringBuilder1.toString());
        this.r.add(map);
        if (this.r.size() == 5) {
          EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_PHOTO_DRAW, AppInfo.f().toJson(this.r), EventTrackGuy.c(this.b), GuyProtos.ShowType.LIST_SHOW, MapFindManager.a().b());
          this.r.clear();
        } 
        paramUserFindResult.isShowUrlVisited = true;
        if (this.v != null)
          this.v.a(); 
      } 
    } 
  }
  
  public void e(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    ((BannerADView)paramBaseViewHolder.d(2131296495)).a(this.s, (BluedADExtra)paramUserFindResult, ADConstants.AD_POSITION.d, new BannerADView.ADListener(this, paramUserFindResult) {
          public void a() {
            PeopleListQuickAdapter.a(this.b).remove(this.a);
            this.b.A();
          }
          
          public void b() {
            PeopleListQuickAdapter.b(this.b).remove(this.a);
            this.b.A();
          }
        });
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)paramBaseViewHolder.d(2131296495).getLayoutParams();
    layoutParams.rightMargin = 0;
    paramBaseViewHolder.d(2131296495).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void f(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    ((BluedADConstraintLayout)paramBaseViewHolder.d(2131296537)).setADData((BluedADExtra)paramUserFindResult);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131299358);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131300489);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131300704);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297457);
    ((ImageView)paramBaseViewHolder.d(2131297570)).setVisibility(8);
    if (paramUserFindResult.is_show_adm_icon == 1) {
      textView2.setVisibility(0);
    } else {
      textView2.setVisibility(4);
    } 
    if (paramUserFindResult.can_close == 1) {
      imageView2.setVisibility(0);
      imageView2.setOnClickListener(new -$$Lambda$PeopleListQuickAdapter$z8GpD7Iso8CT46CIg3XfY36pwhs(this, paramUserFindResult, imageView2));
    } else {
      imageView2.setVisibility(8);
    } 
    ImageLoader.a(this.s, paramUserFindResult.avatar).a(2131234356).c().a(imageView1);
    textView1.setText(paramUserFindResult.name);
    textView3.setText(paramUserFindResult.description);
  }
  
  public void g(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    paramUserFindResult.is_show_adm_icon = 1;
    paramUserFindResult.can_close = 1;
    f(paramBaseViewHolder, paramUserFindResult);
    ((BluedADConstraintLayout)paramBaseViewHolder.d(2131296537)).a((BluedADExtra)paramUserFindResult, -$$Lambda$PeopleListQuickAdapter$taPAapIlpl9bQDfMmJVgQn_gra4.INSTANCE);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297362);
    ImageLoader.a(this.s, paramUserFindResult.avatar).a(2131234356).c().a(imageView);
    ((ImageView)paramBaseViewHolder.d(2131297570)).setVisibility(0);
    if (paramUserFindResult.ttNativeAdData != null) {
      ArrayList<View> arrayList = new ArrayList();
      arrayList.add(paramBaseViewHolder.d(2131298064));
      paramUserFindResult.ttNativeAdData.registerViewForInteraction((ViewGroup)paramBaseViewHolder.d(2131298064), arrayList, arrayList, new TTNativeAd.AdInteractionListener(this, paramUserFindResult) {
            public void onAdClicked(View param1View, TTNativeAd param1TTNativeAd) {
              FindHttpUtils.a(this.a.click_url);
            }
            
            public void onAdCreativeClick(View param1View, TTNativeAd param1TTNativeAd) {
              FindHttpUtils.a(this.a.click_url);
            }
            
            public void onAdShow(TTNativeAd param1TTNativeAd) {}
          });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\PeopleListQuickAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */