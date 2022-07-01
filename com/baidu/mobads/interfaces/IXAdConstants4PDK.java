package com.baidu.mobads.interfaces;

public interface IXAdConstants4PDK {
  public static final String EVENT_ERROR = "EVENT_ERROR";
  
  public static final String EVENT_REQUEST_COMPLETE = "EVENT_REQUEST_COMPLETE";
  
  public static final String EVENT_REQUEST_CONTENT_VIDEO_PAUSE = "EVENT_REQUEST_CONTENT_VIDEO_PAUSE";
  
  public static final String EVENT_REQUEST_CONTENT_VIDEO_RESUME = "EVENT_REQUEST_CONTENT_VIDEO_RESUME";
  
  public static final String EVENT_SLOT_CLICKED = "EVENT_SLOT_CLICKED";
  
  public static final String EVENT_SLOT_ENDED = "EVENT_SLOT_ENDED";
  
  public static final String EVENT_SLOT_PRELOADED = "EVENT_SLOT_PRELOADED";
  
  public static final String EVENT_SLOT_STARTED = "EVENT_SLOT_STARTED";
  
  public enum ActivityState {
    CREATE("CREATE"),
    DESTROY("CREATE"),
    PAUSE("CREATE"),
    RESTART("CREATE"),
    RESUME("CREATE"),
    START("START"),
    STOP("START");
    
    private final String a;
    
    static {
      PAUSE = new ActivityState("PAUSE", 3, "PAUSE");
      RESUME = new ActivityState("RESUME", 4, "RESUME");
      STOP = new ActivityState("STOP", 5, "STOP");
      DESTROY = new ActivityState("DESTROY", 6, "DESTROY");
      b = new ActivityState[] { CREATE, START, RESTART, PAUSE, RESUME, STOP, DESTROY };
    }
    
    ActivityState(String param1String1) {
      this.a = param1String1;
    }
    
    public static ActivityState parse(String param1String) {
      for (ActivityState activityState : values()) {
        if (activityState.a.equalsIgnoreCase(param1String))
          return activityState; 
      } 
      return null;
    }
    
    public String getValue() {
      return this.a;
    }
  }
  
  public enum ScreenSizeMode {
    NORMAL("normal"),
    FULL_SCREEN("START");
    
    private final String a;
    
    static {
    
    }
    
    ScreenSizeMode(String param1String1) {
      this.a = param1String1;
    }
    
    public static ScreenSizeMode parse(String param1String) {
      for (ScreenSizeMode screenSizeMode : values()) {
        if (screenSizeMode.a.equalsIgnoreCase(param1String))
          return screenSizeMode; 
      } 
      return null;
    }
    
    public String getValue() {
      return this.a;
    }
  }
  
  public enum SlotState {
    COMPLETED("normal"),
    ERROR("normal"),
    IDEL("idel"),
    LOADED("idel"),
    LOADING("loading"),
    PAUSED("loading"),
    PLAYING("loading");
    
    private final String a;
    
    static {
      PAUSED = new SlotState("PAUSED", 4, "paused");
      COMPLETED = new SlotState("COMPLETED", 5, "completed");
      ERROR = new SlotState("ERROR", 6, "error");
      b = new SlotState[] { IDEL, LOADING, LOADED, PLAYING, PAUSED, COMPLETED, ERROR };
    }
    
    SlotState(String param1String1) {
      this.a = param1String1;
    }
    
    public static SlotState parse(String param1String) {
      for (SlotState slotState : values()) {
        if (slotState.a.equalsIgnoreCase(param1String))
          return slotState; 
      } 
      return null;
    }
    
    public String getValue() {
      return this.a;
    }
  }
  
  public enum SlotType {
    SLOT_TYPE_JSSDK("jssdk"),
    SLOT_TYPE_MIDROLL("jssdk"),
    SLOT_TYPE_OVERLAY("jssdk"),
    SLOT_TYPE_PAUSE_ROLL("jssdk"),
    SLOT_TYPE_POSTROLL("jssdk"),
    SLOT_TYPE_PREROLL("jssdk"),
    SLOT_TYPE_REWARD_VIDEO("jssdk"),
    SLOT_TYPE_SPLASH("jssdk"),
    SLOT_TYPE_BANNER("loading"),
    SLOT_TYPE_CPU("loading"),
    SLOT_TYPE_FEEDS("loading"),
    SLOT_TYPE_INTERSTITIAL("loading");
    
    private final String a;
    
    static {
      SLOT_TYPE_BANNER = new SlotType("SLOT_TYPE_BANNER", 2, "banner");
      SLOT_TYPE_SPLASH = new SlotType("SLOT_TYPE_SPLASH", 3, "rsplash");
      SLOT_TYPE_INTERSTITIAL = new SlotType("SLOT_TYPE_INTERSTITIAL", 4, "int");
      SLOT_TYPE_FEEDS = new SlotType("SLOT_TYPE_FEEDS", 5, "feed");
      SLOT_TYPE_REWARD_VIDEO = new SlotType("SLOT_TYPE_REWARD_VIDEO", 6, "rvideo");
      SLOT_TYPE_PREROLL = new SlotType("SLOT_TYPE_PREROLL", 7, "preroll");
      SLOT_TYPE_MIDROLL = new SlotType("SLOT_TYPE_MIDROLL", 8, "midroll");
      SLOT_TYPE_POSTROLL = new SlotType("SLOT_TYPE_POSTROLL", 9, "postroll");
      SLOT_TYPE_OVERLAY = new SlotType("SLOT_TYPE_OVERLAY", 10, "overlay");
      SLOT_TYPE_PAUSE_ROLL = new SlotType("SLOT_TYPE_PAUSE_ROLL", 11, "pauseroll");
      b = new SlotType[] { 
          SLOT_TYPE_JSSDK, SLOT_TYPE_CPU, SLOT_TYPE_BANNER, SLOT_TYPE_SPLASH, SLOT_TYPE_INTERSTITIAL, SLOT_TYPE_FEEDS, SLOT_TYPE_REWARD_VIDEO, SLOT_TYPE_PREROLL, SLOT_TYPE_MIDROLL, SLOT_TYPE_POSTROLL, 
          SLOT_TYPE_OVERLAY, SLOT_TYPE_PAUSE_ROLL };
    }
    
    SlotType(String param1String1) {
      this.a = param1String1;
    }
    
    public static SlotType parse(String param1String) {
      for (SlotType slotType : values()) {
        if (slotType.a.equalsIgnoreCase(param1String))
          return slotType; 
      } 
      return null;
    }
    
    public String getValue() {
      return this.a;
    }
  }
  
  public enum VideoAssetPlayMode {
    VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED"),
    VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED");
    
    private final String a;
    
    VideoAssetPlayMode(String param1String1) {
      this.a = param1String1;
    }
    
    public static VideoAssetPlayMode parse(String param1String) {
      for (VideoAssetPlayMode videoAssetPlayMode : values()) {
        if (videoAssetPlayMode.a.equalsIgnoreCase(param1String))
          return videoAssetPlayMode; 
      } 
      return null;
    }
    
    public String getValue() {
      return this.a;
    }
  }
  
  public enum VideoState {
    IDLE("IDLE"),
    PAUSED("IDLE"),
    COMPLETED("VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED"),
    PLAYING("PLAYING");
    
    private final String a;
    
    static {
      COMPLETED = new VideoState("COMPLETED", 3, "COMPLETED");
      b = new VideoState[] { IDLE, PLAYING, PAUSED, COMPLETED };
    }
    
    VideoState(String param1String1) {
      this.a = param1String1;
    }
    
    public static VideoState parse(String param1String) {
      for (VideoState videoState : values()) {
        if (videoState.a.equalsIgnoreCase(param1String))
          return videoState; 
      } 
      return null;
    }
    
    public String getValue() {
      return this.a;
    }
  }
  
  public enum VisitorAction {
    PAUSE_BUTTON_CLICKED("PAUSE_BUTTON_CLICKED"),
    RESUME_BUTTON_CLICKED("RESUME_BUTTON_CLICKED");
    
    private final String a;
    
    VisitorAction(String param1String1) {
      this.a = param1String1;
    }
    
    public static VisitorAction parse(String param1String) {
      for (VisitorAction visitorAction : values()) {
        if (visitorAction.a.equalsIgnoreCase(param1String))
          return visitorAction; 
      } 
      return null;
    }
    
    public String getValue() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdConstants4PDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */