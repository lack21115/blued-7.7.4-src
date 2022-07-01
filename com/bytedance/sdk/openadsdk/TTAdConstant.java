package com.bytedance.sdk.openadsdk;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TTAdConstant {
  public static final int AD_TYPE_COMMON_VIDEO = 0;
  
  public static final int AD_TYPE_PLAYABLE = 2;
  
  public static final int AD_TYPE_PLAYABLE_VIDEO = 1;
  
  public static final int AD_TYPE_UNKNOWN = -1;
  
  public static final int FALLBACK_TYPE_DOWNLOAD = 2;
  
  public static final int FALLBACK_TYPE_LANDING_PAGE = 1;
  
  public static final int HORIZONTAL = 2;
  
  public static final int IMAGE_MODE_GROUP_IMG = 4;
  
  public static final int IMAGE_MODE_LARGE_IMG = 3;
  
  public static final int IMAGE_MODE_SMALL_IMG = 2;
  
  public static final int IMAGE_MODE_UNKNOWN = -1;
  
  public static final int IMAGE_MODE_VERTICAL_IMG = 16;
  
  public static final int IMAGE_MODE_VIDEO = 5;
  
  public static final int IMAGE_MODE_VIDEO_VERTICAL = 15;
  
  public static final int INTERACTION_TYPE_BROWSER = 2;
  
  public static final int INTERACTION_TYPE_DIAL = 5;
  
  public static final int INTERACTION_TYPE_DOWNLOAD = 4;
  
  public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
  
  public static final int INTERACTION_TYPE_UNKNOWN = -1;
  
  public static final String MULTI_PROCESS_DATA = "multi_process_data";
  
  public static final String MULTI_PROCESS_MATERIALMETA = "multi_process_materialmeta";
  
  public static final int NETWORK_STATE_2G = 2;
  
  public static final int NETWORK_STATE_3G = 3;
  
  public static final int NETWORK_STATE_4G = 5;
  
  public static final int NETWORK_STATE_MOBILE = 1;
  
  public static final int NETWORK_STATE_WIFI = 4;
  
  public static final String TAG = "TT_AD_SDK";
  
  public static final int TITLE_BAR_THEME_DARK = 1;
  
  public static final int TITLE_BAR_THEME_LIGHT = 0;
  
  public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
  
  public static final int VERTICAL = 1;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NATIVE_AD_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NETWORK_STATE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ORIENTATION_STATE {}
  
  public enum RitScenes {
    CUSTOMIZE_SCENES("customize_scenes"),
    GAME_FINISH_REWARDS("customize_scenes"),
    GAME_GIFT_BONUS("customize_scenes"),
    GAME_MORE_OPPORTUNITIES("customize_scenes"),
    GAME_REDUCE_WAITING("customize_scenes"),
    GAME_START_BONUS("customize_scenes"),
    HOME_GET_BONUS("customize_scenes"),
    HOME_GET_PROPS("customize_scenes"),
    HOME_GIFT_BONUS("customize_scenes"),
    HOME_OPEN_BONUS("home_open_bonus"),
    HOME_SVIP_BONUS("home_svip_bonus"),
    HOME_TRY_PROPS("home_svip_bonus");
    
    final String a;
    
    static {
      HOME_GET_BONUS = new RitScenes("HOME_GET_BONUS", 5, "home_get_bonus");
      HOME_GIFT_BONUS = new RitScenes("HOME_GIFT_BONUS", 6, "home_gift_bonus");
      GAME_START_BONUS = new RitScenes("GAME_START_BONUS", 7, "game_start_bonus");
      GAME_REDUCE_WAITING = new RitScenes("GAME_REDUCE_WAITING", 8, "geme_reduce_waiting");
      GAME_MORE_OPPORTUNITIES = new RitScenes("GAME_MORE_OPPORTUNITIES", 9, "game_more_opportunities");
      GAME_FINISH_REWARDS = new RitScenes("GAME_FINISH_REWARDS", 10, "game_finish_rewards");
      GAME_GIFT_BONUS = new RitScenes("GAME_GIFT_BONUS", 11, "game_gift_bonus");
      b = new RitScenes[] { 
          CUSTOMIZE_SCENES, HOME_OPEN_BONUS, HOME_SVIP_BONUS, HOME_GET_PROPS, HOME_TRY_PROPS, HOME_GET_BONUS, HOME_GIFT_BONUS, GAME_START_BONUS, GAME_REDUCE_WAITING, GAME_MORE_OPPORTUNITIES, 
          GAME_FINISH_REWARDS, GAME_GIFT_BONUS };
    }
    
    RitScenes(String param1String1) {
      this.a = param1String1;
    }
    
    public String getScenesName() {
      return this.a;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TITLE_BAR_THEME {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTAdConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */