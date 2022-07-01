package com.baidu.mobads;

public enum AdSize {
  Banner(0),
  FeedH5TemplateNative(0),
  FeedNative(0),
  InterstitialForVideoBeforePlay(0),
  InterstitialForVideoPausePlay(0),
  InterstitialGame(0),
  InterstitialOther(0),
  InterstitialReader(0),
  InterstitialRefresh(0),
  PrerollVideoNative(0),
  RewardVideo(0),
  Square(1);
  
  private int a;
  
  static {
    InterstitialGame = new AdSize("InterstitialGame", 2, 6);
    InterstitialReader = new AdSize("InterstitialReader", 3, 7);
    InterstitialRefresh = new AdSize("InterstitialRefresh", 4, 9);
    InterstitialOther = new AdSize("InterstitialOther", 5, 10);
    InterstitialForVideoBeforePlay = new AdSize("InterstitialForVideoBeforePlay", 6, 12);
    InterstitialForVideoPausePlay = new AdSize("InterstitialForVideoPausePlay", 7, 13);
    RewardVideo = new AdSize("RewardVideo", 8, 14);
    PrerollVideoNative = new AdSize("PrerollVideoNative", 9, 15);
    FeedNative = new AdSize("FeedNative", 10, 16);
    FeedH5TemplateNative = new AdSize("FeedH5TemplateNative", 11, 17);
    b = new AdSize[] { 
        Banner, Square, InterstitialGame, InterstitialReader, InterstitialRefresh, InterstitialOther, InterstitialForVideoBeforePlay, InterstitialForVideoPausePlay, RewardVideo, PrerollVideoNative, 
        FeedNative, FeedH5TemplateNative };
  }
  
  AdSize(int paramInt1) {
    this.a = paramInt1;
  }
  
  public int getValue() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\AdSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */