package com.soft.blued.ui.mine.model;

import android.text.TextUtils;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.user.model.UserInfoEntity;
import java.util.List;

public class MineEntryInfo {
  public String black_allowed_count;
  
  public String black_count;
  
  public VipInfo broadcast;
  
  public Columns columns;
  
  public ImgBanner img_banner;
  
  public int rich_level;
  
  public List<TvBanner> text_banner;
  
  public UserInfoEntity user;
  
  public String getVipCenterUrl() {
    VipInfo vipInfo = this.broadcast;
    return (vipInfo != null && !TextUtils.isEmpty(vipInfo.url)) ? this.broadcast.url : BluedHttpUrl.g();
  }
  
  public static class Columns {
    public List<MineEntryInfo.ColumnsItem> anchors;
    
    public List<MineEntryInfo.ColumnsItem> health;
    
    public List<MineEntryInfo.ColumnsItem> others;
    
    public List<MineEntryInfo.ColumnsItem> service;
  }
  
  public static class ColumnsExtra {
    public static final String TYPE_ANCHOR_LEVEL = "anchor_level";
    
    public static final String TYPE_CALL_ORDERS = "call_orders";
    
    public static final String TYPE_CHARGE = "charge";
    
    public static final String TYPE_RICH_LEVEL = "rich_level";
    
    public static final String TYPE_SHADOW = "shadow";
    
    public String anchor_level;
    
    public long beans;
    
    public int rich_level;
    
    public int show_new_icon;
    
    public int times;
    
    public String type;
  }
  
  public static class ColumnsItem {
    public MineEntryInfo.ColumnsExtra extra;
    
    public String icon;
    
    public String id;
    
    public int is_highlight;
    
    public String item_key;
    
    public String key;
    
    public String recommend_icon;
    
    public String recommend_text;
    
    public String title;
    
    public String url;
  }
  
  public static class ImgBanner extends BluedADExtra {
    public String img;
    
    public String link;
  }
  
  public static class TvBanner {
    public String content;
    
    public String content_color;
    
    public String id;
    
    public String link;
    
    public String title;
    
    public String title_color;
  }
  
  public static class VipBroadcast {
    public String text;
    
    public int type;
    
    public String url;
  }
  
  public static class VipInfo {
    public String btn;
    
    public List<MineEntryInfo.VipBroadcast> carousels;
    
    public int expire_type;
    
    public int is_broadcast_test;
    
    public int is_vip_annual;
    
    public String title;
    
    public String url;
    
    public int vip_exp_lvl;
    
    public int vip_grade;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\model\MineEntryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */