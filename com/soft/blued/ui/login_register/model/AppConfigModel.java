package com.soft.blued.ui.login_register.model;

import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.live.model.LiveTabModel;
import java.util.List;

public class AppConfigModel extends UserBasicModel {
  public int ad_close_pop;
  
  public int allow_selected_setting;
  
  public String black_allowed_count;
  
  public String black_count;
  
  public CallBubbleTest call_bubble_test;
  
  public int call_count;
  
  public int can_not_modify;
  
  public int chat_box_is_show;
  
  public int chat_sdk_type = 1;
  
  public int complete_rate;
  
  public String default_home_tabs;
  
  public int eros_alt;
  
  public int expand_safety_tips = 0;
  
  public int force_expand_msg_safe_tip = 0;
  
  public List<List<String>> home_menu;
  
  public List<NearbyPeopleTabModel> home_tabs;
  
  public int index_is_complete_rate;
  
  public Indexing_top_bar indexing_top_bar;
  
  public int is_android_paid;
  
  public int is_call_open;
  
  public int is_hide_group_graph;
  
  public int is_live_tx_player = 0;
  
  public int is_open_call_sure_box;
  
  public int is_open_fans_club;
  
  public int is_open_logout;
  
  public int is_show_group_burn_after_reading;
  
  public int is_user_reactive;
  
  public int live_allowed_time;
  
  public int live_gift_show_type;
  
  public List<LiveTabModel> live_tabs;
  
  public int live_tabs_ab_test;
  
  public int message_ice_breaking;
  
  public int message_is_complete_rate;
  
  public int message_push_box;
  
  public int nearby_online_time_ui;
  
  public int nearby_recommend_live_ui;
  
  public String new_gift_key;
  
  public int oneclick;
  
  public int push_box_frequency;
  
  public int quietly_call_allow;
  
  public RedDotSign red_dot_sign;
  
  public int selected_not_vip_show_type;
  
  public int show_half_invisible;
  
  public int show_home_guide;
  
  public int show_msg_box_guide;
  
  public int show_msg_list_src;
  
  public int show_msg_src;
  
  public int show_net_error_toast;
  
  public int show_search_face;
  
  public String show_star_dialog_button_bad;
  
  public String show_star_dialog_button_praise;
  
  public int show_star_dialog_count;
  
  public String show_star_dialog_text;
  
  public int show_star_dialog_text_type;
  
  public String show_star_dialog_title;
  
  public DiscoveryBubble ticktocks_bubble;
  
  public Tip tips = new Tip();
  
  public FeedPromotion tt_promotion;
  
  public int use_new_visitor_vip_guide = 1;
  
  public int users_call_filter;
  
  public List<BluedAlbum> vip_avatars;
  
  public VIPRight vip_split;
  
  public static interface AD_CLOSE_POP_TYPE {
    public static final int EVERY_TIME = 2;
    
    public static final int HIDE = 0;
    
    public static final int ONE_TIME_PER_DAY = 1;
  }
  
  public class CallBubbleTest {
    public int group;
    
    public String text;
  }
  
  public static class DiscoveryBubble {
    public String bubble_code;
    
    public String bubble_pic;
    
    public String url;
  }
  
  public static class FeedPromotion {
    public String btn;
    
    public int discount_money;
    
    public String discount_text;
    
    public long duration;
    
    public String img;
    
    public int open;
    
    public int origin_money;
    
    public List<String> subhead;
    
    public String subtitle;
    
    public String text;
    
    public String title;
    
    public int type;
  }
  
  public static interface HOME_TOP_TAB_ID {
    public static final int FEEDS = 2;
    
    public static final int FRIENDS = 1;
    
    public static final int GROUPS = 3;
  }
  
  public class Indexing_top_bar {
    public int default_show;
    
    public List<Integer> sort;
  }
  
  public class RedDotSign {
    public String code;
    
    public int is_open;
  }
  
  public class Tip {
    public String link;
    
    public String text;
  }
  
  public static class VIPRight {
    public int is_advanced_recently_view;
    
    public int is_change_blued_icon;
    
    public int is_chat_backgrounds;
    
    public int is_chat_shadow;
    
    public int is_filter_ads;
    
    public int is_filter_vip;
    
    public int is_find_on_map;
    
    public int is_global_view_secretly;
    
    public int is_hide_city_settled;
    
    public int is_hide_distance;
    
    public int is_hide_last_operate;
    
    public int is_hide_vip_look;
    
    public int is_high_invisible;
    
    public int is_improve_backlist;
    
    public int is_improve_grouplist;
    
    public int is_invisible_all;
    
    public int is_invisible_half;
    
    public int is_secretly_followed;
    
    public int is_show_vip_page;
    
    public int is_top_feed_views;
    
    public int is_traceless_access;
    
    public int is_view_secretly;
    
    public int is_vip_mark;
    
    public int is_vip_more_avatar;
    
    public int is_vip_red_name;
    
    public int is_vip_select;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\model\AppConfigModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */