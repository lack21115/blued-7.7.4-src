package com.soft.blued.ui.live.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.model.UserBasicModel;
import java.util.List;

public class BluedLiveListData extends BluedADExtra implements MultiItemEntity {
  public static final int SCREEN_HORIZONTAL = 1;
  
  public static final int SCREEN_VERTICAL = 0;
  
  public UserBasicModel anchor = new UserBasicModel();
  
  public int anchor_level;
  
  public String auth;
  
  public String[] badges;
  
  public String description;
  
  public String distance;
  
  public String end_time;
  
  public String game_id;
  
  public String game_name;
  
  public boolean hasOfficialList;
  
  public boolean hasPKList;
  
  public boolean hasRedList;
  
  public int hb;
  
  public LiveHotListDiversion hot_diversion;
  
  public List<BluedLiveListData> hotpk_list;
  
  public String id;
  
  public String imgurl;
  
  public String imgurl_small;
  
  public int is_distance;
  
  public int is_exist_na_page;
  
  public int is_hot;
  
  public int is_recommend;
  
  public int is_top;
  
  public String lid;
  
  public String liked;
  
  public int link_type;
  
  public List<LiveRecommendModel> liveRecommendModelList;
  
  public int liveType;
  
  public String live_play;
  
  public String live_starttime;
  
  public int livetype;
  
  public String mComeCode;
  
  public String pic_url;
  
  public int pk;
  
  public int position;
  
  public int positionReal;
  
  public String realtime_count;
  
  public int recommendType;
  
  public String rtmp_live_urls;
  
  public int screen_pattern;
  
  public String sort;
  
  public String source;
  
  public String start_time;
  
  public String stream_id;
  
  public String stream_json;
  
  public String title;
  
  public String top_card;
  
  public String top_card_img;
  
  public String top_count;
  
  public String top_icon;
  
  public String type;
  
  public String uid;
  
  public String url;
  
  public String watch_count;
  
  public BluedLiveListData() {}
  
  public BluedLiveListData(String paramString, UserBasicModel paramUserBasicModel) {
    this.lid = paramString;
  }
  
  public int getItemType() {
    return this.liveType;
  }
  
  public static interface LINK_TYPE {
    public static final int BEAR = 7;
    
    public static final int BLIND_DATE = 3;
    
    public static final int FASHION = 8;
    
    public static final int FOLLOWER = 4;
    
    public static final int GROUP = 2;
    
    public static final int NEARBY = 5;
    
    public static final int NORMAL = 0;
    
    public static final int PK = 1;
    
    public static final int STRONG = 6;
  }
  
  public static interface LIVE_LINK_TYPE {
    public static final int BLIND_DATE = 4;
    
    public static final int CONNECTION = 3;
    
    public static final int GROUP = 2;
    
    public static final int NORMAL = 0;
    
    public static final int PK = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\model\BluedLiveListData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */