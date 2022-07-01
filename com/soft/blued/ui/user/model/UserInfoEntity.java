package com.soft.blued.ui.user.model;

import com.blued.android.core.BlueAppLocal;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.utils.DistanceUtils;
import java.io.Serializable;
import java.util.List;

public class UserInfoEntity extends UserBasicModel implements Serializable {
  public int access_private_photos;
  
  public _ads_activity ads_activity;
  
  public List<BluedADExtra> ads_banner;
  
  public List<BluedAlbum> album;
  
  public int allow_active;
  
  public int allow_show_reports = 0;
  
  public int anchor;
  
  public int anchor_level;
  
  public _anchor_type anchor_type;
  
  public String astro = "";
  
  public int avatar_audited = -1;
  
  public String avatar_pid = "";
  
  public String background_photo;
  
  public int background_photo_auditing;
  
  public List<AnchorMedal> badge;
  
  public String birthday = "";
  
  public String black_allowed_count = "";
  
  public String black_count = "";
  
  public String blood_type = "";
  
  public String chinese_zodiac = "";
  
  public String city_settled = "";
  
  public String education = "";
  
  public String ethnicity = "";
  
  public String followed_count = "";
  
  public String followers_count = "";
  
  public String friends_count = "";
  
  public String game_description;
  
  public String game_url;
  
  public String groups_count = "";
  
  public List<BluedGroupLists> groups_info;
  
  public String health_prpe_use_situation;
  
  public int health_test_info_show;
  
  public String health_test_result;
  
  public String health_test_time;
  
  public int history;
  
  public String hometown = "";
  
  public String ihate = "";
  
  public String ilike = "";
  
  public String in_blacklist = "";
  
  public String industry = "";
  
  public String is_access_followers = "";
  
  public String is_access_follows = "";
  
  public String is_access_groups = "";
  
  public int is_locked = 0;
  
  public int is_manager;
  
  public String last_login = "";
  
  public String last_offline = "";
  
  public String live;
  
  public _live livelist;
  
  public _liveshow liveshow;
  
  public _match_activity match_activity;
  
  public String mate = "";
  
  public String my_ticktocks_count = "";
  
  public String nickname_limit;
  
  public int privacy_photos_has_locked;
  
  public String province = "";
  
  public String qq = "";
  
  public String red_ribbon = "";
  
  public String red_ribbon_link = "";
  
  public int registration_time;
  
  public String relationship = "";
  
  public int rich_level;
  
  public int secretly_followed_status;
  
  public String status = "";
  
  public UserTagAll tags;
  
  public int vbadge_hide_profile;
  
  public VerifyStatus[] verify;
  
  public List<BluedAlbum> vip_avatars;
  
  public String vip_url;
  
  public VoiceBroadcast voice_broadcast;
  
  public String weibo = "";
  
  public String weixin = "";
  
  public UserInfoEntity() {}
  
  public UserInfoEntity(UserBasicModel paramUserBasicModel) {
    if (paramUserBasicModel == null)
      return; 
    this.uid = paramUserBasicModel.uid;
    this.email = paramUserBasicModel.email;
    this.name = paramUserBasicModel.name;
    this.height = paramUserBasicModel.height;
    this.weight = paramUserBasicModel.weight;
    this.last_operate = paramUserBasicModel.last_operate;
    this.location = DistanceUtils.a(paramUserBasicModel.distance, BlueAppLocal.c(), true);
    this.avatar = paramUserBasicModel.avatar;
    this.hot = paramUserBasicModel.hot;
    this.description = paramUserBasicModel.description;
    this.role = paramUserBasicModel.role;
    this.age = paramUserBasicModel.age;
    this.online_state = paramUserBasicModel.online_state;
    this.distance = paramUserBasicModel.distance;
    this.photos_count = paramUserBasicModel.photos_count;
    this.note = paramUserBasicModel.note;
    this.vbadge = paramUserBasicModel.vbadge;
    this.is_recommend = paramUserBasicModel.is_recommend;
    this.blued_pic = paramUserBasicModel.blued_pic;
    this.weekstar = paramUserBasicModel.weekstar;
    this.game_type = paramUserBasicModel.game_type;
    this.is_call = paramUserBasicModel.is_call;
    this.vip_grade = paramUserBasicModel.vip_grade;
    this.vip_exp_lvl = paramUserBasicModel.vip_exp_lvl;
    this.is_vip_annual = paramUserBasicModel.is_vip_annual;
    this.is_hide_last_operate = paramUserBasicModel.is_hide_last_operate;
    this.is_hide_distance = paramUserBasicModel.is_hide_distance;
    this.is_hide_city_settled = paramUserBasicModel.is_hide_city_settled;
    this.is_invisible_half = paramUserBasicModel.is_invisible_half;
    this.is_invisible_all = paramUserBasicModel.is_invisible_all;
    this.is_show_vip_page = paramUserBasicModel.is_show_vip_page;
    this.is_traceless_access = paramUserBasicModel.is_traceless_access;
    this.is_global_view_secretly = paramUserBasicModel.is_global_view_secretly;
    this.is_find_on_map = paramUserBasicModel.is_find_on_map;
    this.is_hide_vip_look = paramUserBasicModel.is_hide_vip_look;
    this.is_shadow = paramUserBasicModel.is_shadow;
  }
  
  public class CityKeys {
    public String latitude = "";
    
    public String longitude = "";
    
    public String name = "";
  }
  
  public class VoiceBroadcast {
    public String room_id;
    
    public String room_name;
    
    public String room_type;
    
    public String uid;
  }
  
  public class _ads_activity extends BluedADExtra {
    public String title;
  }
  
  public class _anchor_type {
    public int aid;
    
    public String name;
  }
  
  public class _fans {
    public String pic;
    
    public String sort;
    
    public String vbadge;
  }
  
  public class _live {
    public UserInfoEntity._fans[] consume_list;
    
    public int livetop;
    
    public UserInfoEntity._rich_list rich_list;
    
    public long total_beans;
    
    public long week_totaltime;
  }
  
  public class _liveshow {
    public String avatar = "";
    
    public String description = "";
    
    public int liked = 0;
    
    public int realtime_count = 0;
    
    public Long session_id;
    
    public Short session_type;
    
    public String start_time = "";
    
    public int watch_count = 0;
  }
  
  public class _match_activity {
    public String[] click_url;
    
    public String icon;
    
    public String match_activity_text;
    
    public String[] show_url;
    
    public String url;
  }
  
  public class _rich_list {
    public int all;
    
    public int day;
    
    public int week;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\UserInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */