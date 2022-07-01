package com.soft.blued.user;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Common;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.ui.find.model.HomeTopTabModel;
import com.soft.blued.ui.find.model.NearbyFeedCity;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.login_register.model.MarketPraiseGuide;
import com.soft.blued.ui.login_register.model.NearbyPeopleTabModel;
import com.soft.blued.user.Observer.BluedConfigDataObserver;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class BluedConfig {
  private static volatile BluedConfig a;
  
  private static long d = 5000L;
  
  private AppConfigModel b;
  
  private long c = 0L;
  
  private Gson e;
  
  private BluedConfig() {
    String str = BluedPreferences.D();
    this.e = (new GsonBuilder()).disableHtmlEscaping().create();
    if (!StringUtils.e(str)) {
      this.b = (AppConfigModel)this.e.fromJson(str, AppConfigModel.class);
      return;
    } 
    this.b = new AppConfigModel();
  }
  
  public static BluedConfig b() {
    // Byte code:
    //   0: ldc com/soft/blued/user/BluedConfig
    //   2: monitorenter
    //   3: getstatic com/soft/blued/user/BluedConfig.a : Lcom/soft/blued/user/BluedConfig;
    //   6: ifnonnull -> 19
    //   9: new com/soft/blued/user/BluedConfig
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/soft/blued/user/BluedConfig.a : Lcom/soft/blued/user/BluedConfig;
    //   19: getstatic com/soft/blued/user/BluedConfig.a : Lcom/soft/blued/user/BluedConfig;
    //   22: astore_0
    //   23: ldc com/soft/blued/user/BluedConfig
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/soft/blued/user/BluedConfig
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public AppConfigModel.CallBubbleTest A() {
    return this.b.call_bubble_test;
  }
  
  public boolean B() {
    return (this.b.chat_box_is_show == 1);
  }
  
  public int C() {
    return this.b.complete_rate;
  }
  
  public boolean D() {
    return (this.b.show_half_invisible == 1);
  }
  
  public int E() {
    return this.b.ad_close_pop;
  }
  
  public String F() {
    return this.b.new_gift_key;
  }
  
  public boolean G() {
    return (this.b.nearby_recommend_live_ui == 1);
  }
  
  public boolean H() {
    return (this.b.show_msg_list_src == 1);
  }
  
  public boolean I() {
    return (this.b.quietly_call_allow == 1);
  }
  
  public boolean J() {
    return (this.b.live_gift_show_type != 2);
  }
  
  public int K() {
    return this.b.nearby_online_time_ui;
  }
  
  public boolean L() {
    return (this.b.users_call_filter == 1);
  }
  
  public Gson a() {
    return this.e;
  }
  
  public List<NearbyPeopleTabModel> a(Context paramContext) {
    if (this.b.home_tabs != null && this.b.home_tabs.size() > 0)
      return (ArrayList)((ArrayList)this.b.home_tabs).clone(); 
    this.b.home_tabs = new ArrayList();
    this.b.home_tabs.add(new NearbyPeopleTabModel(paramContext.getResources().getString(2131756196), "nearby"));
    this.b.home_tabs.add(new NearbyPeopleTabModel(paramContext.getResources().getString(2131756566), "online"));
    this.b.home_tabs.add(new NearbyPeopleTabModel(paramContext.getResources().getString(2131758798), "integrate"));
    this.b.home_tabs.add(new NearbyPeopleTabModel(paramContext.getResources().getString(2131759220), "newbie"));
    return (ArrayList)((ArrayList)this.b.home_tabs).clone();
  }
  
  public boolean a(UpdateBluedConfigListner paramUpdateBluedConfigListner) {
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    if (l2 == 0L || l1 - l2 >= d) {
      this.c = l1;
      AppHttpUtils.a();
      AppHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<AppConfigModel>>(this, null, paramUpdateBluedConfigListner) {
            boolean a = false;
            
            protected void a(BluedEntityA<AppConfigModel> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
                BluedConfig.a(this.c, (AppConfigModel)param1BluedEntityA.getSingleData());
                int i = (BluedConfig.a(this.c)).show_net_error_toast;
                boolean bool = true;
                if (i != 1)
                  bool = false; 
                BluedHttpUtils.a(bool);
                if (UserInfo.a().i() != null) {
                  UserInfo.a().i().setVip_avatars((BluedConfig.a(this.c)).vip_avatars);
                  (UserInfo.a().i()).vip_grade = (BluedConfig.a(this.c)).vip_grade;
                  Common common = BluedStatistics.a();
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append((BluedConfig.a(this.c)).vip_grade);
                  stringBuilder.append("");
                  common.l(stringBuilder.toString());
                  UserInfo.a().i().setBlackCount((BluedConfig.a(this.c)).black_count);
                  UserInfo.a().i().setBlackMax((BluedConfig.a(this.c)).black_allowed_count);
                  (UserInfo.a().i()).is_invisible_all = (BluedConfig.a(this.c)).is_invisible_all;
                  (UserInfo.a().i()).chat_sdk_type = (BluedConfig.a(this.c)).chat_sdk_type;
                  (UserInfo.a().i()).is_user_reactive = (BluedConfig.a(this.c)).is_user_reactive;
                } 
                BluedConfigDataObserver.a().b();
                if ((BluedConfig.a(this.c)).ticktocks_bubble != null && !TextUtils.isEmpty((BluedConfig.a(this.c)).ticktocks_bubble.bubble_pic))
                  ImageFileLoader.a(null).a((BluedConfig.a(this.c)).ticktocks_bubble.bubble_pic).a(); 
                try {
                  BluedPreferences.e(AppInfo.f().toJson(param1BluedEntityA.getSingleData()));
                  return;
                } catch (Exception exception) {
                  return;
                } 
              } 
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              this.a = true;
              return super.onUIFailure(param1Int, param1String);
            }
            
            public void onUIFinish() {
              BluedConfig.UpdateBluedConfigListner updateBluedConfigListner = this.b;
              if (updateBluedConfigListner != null)
                if (this.a) {
                  updateBluedConfigListner.b();
                } else {
                  updateBluedConfigListner.a();
                }  
              this.a = false;
              super.onUIFinish();
            }
            
            public void onUIStart() {
              super.onUIStart();
            }
          });
      return true;
    } 
    return false;
  }
  
  public List<List<String>> b(Context paramContext) {
    if (this.b.home_menu != null && this.b.home_menu.size() > 0)
      return (ArrayList)((ArrayList)this.b.home_menu).clone(); 
    if (this.b.home_menu == null)
      this.b.home_menu = new ArrayList(); 
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add("nearby");
    this.b.home_menu.add(arrayList);
    arrayList = new ArrayList<String>();
    arrayList.add("online");
    this.b.home_menu.add(arrayList);
    return (ArrayList)((ArrayList)this.b.home_menu).clone();
  }
  
  public boolean b(UpdateBluedConfigListner paramUpdateBluedConfigListner) {
    this.c = 0L;
    return a(paramUpdateBluedConfigListner);
  }
  
  public AppConfigModel c() {
    return this.b;
  }
  
  public List<HomeTopTabModel> c(Context paramContext) {
    ArrayList<HomeTopTabModel> arrayList = new ArrayList();
    if (this.b.indexing_top_bar != null && this.b.indexing_top_bar.sort != null && this.b.indexing_top_bar.sort.size() > 0)
      for (int i = 0; i < this.b.indexing_top_bar.sort.size(); i++) {
        String str;
        int j = ((Integer)this.b.indexing_top_bar.sort.get(i)).intValue();
        if (j != 1) {
          if (j != 2) {
            str = "";
          } else {
            str = NearbyFeedCity.getCityTitle(paramContext, BluedPreferences.dA());
          } 
        } else {
          str = paramContext.getResources().getString(2131756505);
        } 
        if (!TextUtils.isEmpty(str))
          arrayList.add(new HomeTopTabModel(j, str)); 
      }  
    if (arrayList.size() == 0) {
      arrayList.add(new HomeTopTabModel(1, paramContext.getResources().getString(2131756505)));
      arrayList.add(new HomeTopTabModel(2, paramContext.getResources().getString(2131755963)));
    } 
    return arrayList;
  }
  
  public void d() {
    this.c = 0L;
    e();
  }
  
  public boolean e() {
    return a((UpdateBluedConfigListner)null);
  }
  
  public boolean f() {
    return (this.b.show_search_face == 1);
  }
  
  public boolean g() {
    return (this.b.live_allowed_time == 1);
  }
  
  public AppConfigModel.Tip h() {
    return this.b.tips;
  }
  
  public AppConfigModel.DiscoveryBubble i() {
    return this.b.ticktocks_bubble;
  }
  
  public AppConfigModel.VIPRight j() {
    return (this.b.vip_split == null) ? new AppConfigModel.VIPRight() : this.b.vip_split;
  }
  
  public AppConfigModel.VIPRight k() {
    AppConfigModel.VIPRight vIPRight = new AppConfigModel.VIPRight();
    vIPRight.is_hide_last_operate = this.b.is_hide_last_operate;
    vIPRight.is_global_view_secretly = this.b.is_global_view_secretly;
    vIPRight.is_hide_distance = this.b.is_hide_distance;
    vIPRight.is_hide_city_settled = this.b.is_hide_city_settled;
    vIPRight.is_invisible_half = this.b.is_invisible_half;
    vIPRight.is_invisible_all = this.b.is_invisible_all;
    vIPRight.is_show_vip_page = this.b.is_show_vip_page;
    vIPRight.is_traceless_access = this.b.is_traceless_access;
    vIPRight.is_hide_vip_look = this.b.is_hide_vip_look;
    vIPRight.is_filter_ads = this.b.is_filter_ads;
    return vIPRight;
  }
  
  public boolean l() {
    if (this.b.is_hide_group_graph == 1) {
      AppMethods.d(2131758314);
      return true;
    } 
    return false;
  }
  
  public boolean m() {
    return (this.b.is_show_group_burn_after_reading == 0);
  }
  
  public AppConfigModel.FeedPromotion n() {
    return this.b.tt_promotion;
  }
  
  public boolean o() {
    return (this.b.is_call_open == 1);
  }
  
  public int p() {
    return this.b.is_call;
  }
  
  public int q() {
    return this.b.call_count;
  }
  
  public int r() {
    return (this.b.indexing_top_bar != null) ? this.b.indexing_top_bar.default_show : 1;
  }
  
  public boolean s() {
    return (this.b.is_open_logout == 1);
  }
  
  public boolean t() {
    return (this.b.expand_safety_tips == 1);
  }
  
  public boolean u() {
    return (this.b.can_not_modify == 1);
  }
  
  public boolean v() {
    return (this.b.show_msg_src == 1);
  }
  
  public MarketPraiseGuide w() {
    MarketPraiseGuide marketPraiseGuide = new MarketPraiseGuide();
    marketPraiseGuide.content = this.b.show_star_dialog_text;
    marketPraiseGuide.title = this.b.show_star_dialog_title;
    marketPraiseGuide.cancel = this.b.show_star_dialog_button_bad;
    marketPraiseGuide.confirm = this.b.show_star_dialog_button_praise;
    marketPraiseGuide.count = this.b.show_star_dialog_count;
    marketPraiseGuide.type = this.b.show_star_dialog_text_type;
    return marketPraiseGuide;
  }
  
  public boolean x() {
    return (this.b.is_live_tx_player == 1);
  }
  
  public boolean y() {
    return (this.b.index_is_complete_rate == 1);
  }
  
  public boolean z() {
    return (this.b.message_is_complete_rate == 1);
  }
  
  public static interface UpdateBluedConfigListner {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\user\BluedConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */