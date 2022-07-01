package com.bytedance.sdk.openadsdk;

import org.json.JSONObject;

public class AdSlot {
  public static final int TYPE_BANNER = 1;
  
  public static final int TYPE_CACHED_SPLASH = 4;
  
  public static final int TYPE_DRAW_FEED = 9;
  
  public static final int TYPE_FEED = 5;
  
  public static final int TYPE_FULL_SCREEN_VIDEO = 8;
  
  public static final int TYPE_INTERACTION_AD = 2;
  
  public static final int TYPE_REWARD_VIDEO = 7;
  
  public static final int TYPE_SPLASH = 3;
  
  private String a;
  
  private int b;
  
  private int c;
  
  private float d;
  
  private float e;
  
  private int f;
  
  private boolean g;
  
  private String h;
  
  private int i;
  
  private String j;
  
  private String k;
  
  private int l;
  
  private int m;
  
  private boolean n = true;
  
  private AdSlot() {}
  
  public static int getPosition(int paramInt) {
    switch (paramInt) {
      default:
        return 3;
      case 3:
      case 4:
      case 7:
      case 8:
        return 5;
      case 2:
        return 4;
      case 1:
        break;
    } 
    return 2;
  }
  
  public int getAdCount() {
    return this.f;
  }
  
  public String getCodeId() {
    return this.a;
  }
  
  public float getExpressViewAcceptedHeight() {
    return this.e;
  }
  
  public float getExpressViewAcceptedWidth() {
    return this.d;
  }
  
  public int getImgAcceptedHeight() {
    return this.c;
  }
  
  public int getImgAcceptedWidth() {
    return this.b;
  }
  
  public String getMediaExtra() {
    return this.j;
  }
  
  public int getNativeAdType() {
    return this.m;
  }
  
  public int getOrientation() {
    return this.l;
  }
  
  public int getRewardAmount() {
    return this.i;
  }
  
  public String getRewardName() {
    return this.h;
  }
  
  public String getUserID() {
    return this.k;
  }
  
  public boolean isAutoPlay() {
    return this.n;
  }
  
  public boolean isSupportDeepLink() {
    return this.g;
  }
  
  public void setAdCount(int paramInt) {
    this.f = paramInt;
  }
  
  public void setNativeAdType(int paramInt) {
    this.m = paramInt;
  }
  
  public JSONObject toJsonObj() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("mCodeId", this.a);
      jSONObject.put("mIsAutoPlay", this.n);
      jSONObject.put("mImgAcceptedWidth", this.b);
      jSONObject.put("mImgAcceptedHeight", this.c);
      jSONObject.put("mExpressViewAcceptedWidth", this.d);
      jSONObject.put("mExpressViewAcceptedHeight", this.e);
      jSONObject.put("mAdCount", this.f);
      jSONObject.put("mSupportDeepLink", this.g);
      jSONObject.put("mRewardName", this.h);
      jSONObject.put("mRewardAmount", this.i);
      jSONObject.put("mMediaExtra", this.j);
      jSONObject.put("mUserID", this.k);
      jSONObject.put("mOrientation", this.l);
      jSONObject.put("mNativeAdType", this.m);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AdSlot{mCodeId='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", mImgAcceptedWidth=");
    stringBuilder.append(this.b);
    stringBuilder.append(", mImgAcceptedHeight=");
    stringBuilder.append(this.c);
    stringBuilder.append(", mExpressViewAcceptedWidth=");
    stringBuilder.append(this.d);
    stringBuilder.append(", mExpressViewAcceptedHeight=");
    stringBuilder.append(this.e);
    stringBuilder.append(", mAdCount=");
    stringBuilder.append(this.f);
    stringBuilder.append(", mSupportDeepLink=");
    stringBuilder.append(this.g);
    stringBuilder.append(", mRewardName='");
    stringBuilder.append(this.h);
    stringBuilder.append('\'');
    stringBuilder.append(", mRewardAmount=");
    stringBuilder.append(this.i);
    stringBuilder.append(", mMediaExtra='");
    stringBuilder.append(this.j);
    stringBuilder.append('\'');
    stringBuilder.append(", mUserID='");
    stringBuilder.append(this.k);
    stringBuilder.append('\'');
    stringBuilder.append(", mOrientation=");
    stringBuilder.append(this.l);
    stringBuilder.append(", mNativeAdType=");
    stringBuilder.append(this.m);
    stringBuilder.append(", mIsAutoPlay=");
    stringBuilder.append(this.n);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static class Builder {
    private String a;
    
    private int b = 640;
    
    private int c = 320;
    
    private boolean d;
    
    private int e = 1;
    
    private String f;
    
    private int g;
    
    private String h;
    
    private String i;
    
    private int j;
    
    private int k;
    
    private float l;
    
    private float m;
    
    private boolean n = true;
    
    public AdSlot build() {
      AdSlot adSlot = new AdSlot();
      AdSlot.a(adSlot, this.a);
      AdSlot.a(adSlot, this.e);
      AdSlot.a(adSlot, this.d);
      AdSlot.b(adSlot, this.b);
      AdSlot.c(adSlot, this.c);
      AdSlot.a(adSlot, this.l);
      AdSlot.b(adSlot, this.m);
      AdSlot.b(adSlot, this.f);
      AdSlot.d(adSlot, this.g);
      AdSlot.c(adSlot, this.h);
      AdSlot.d(adSlot, this.i);
      AdSlot.e(adSlot, this.j);
      AdSlot.f(adSlot, this.k);
      AdSlot.b(adSlot, this.n);
      return adSlot;
    }
    
    public Builder setAdCount(int param1Int) {
      this.e = param1Int;
      return this;
    }
    
    public Builder setCodeId(String param1String) {
      this.a = param1String;
      return this;
    }
    
    public Builder setExpressViewAcceptedSize(float param1Float1, float param1Float2) {
      this.l = param1Float1;
      this.m = param1Float2;
      return this;
    }
    
    public Builder setImageAcceptedSize(int param1Int1, int param1Int2) {
      this.b = param1Int1;
      this.c = param1Int2;
      return this;
    }
    
    public Builder setIsAutoPlay(boolean param1Boolean) {
      this.n = param1Boolean;
      return this;
    }
    
    public Builder setMediaExtra(String param1String) {
      this.h = param1String;
      return this;
    }
    
    public Builder setNativeAdType(int param1Int) {
      this.k = param1Int;
      return this;
    }
    
    public Builder setOrientation(int param1Int) {
      this.j = param1Int;
      return this;
    }
    
    public Builder setRewardAmount(int param1Int) {
      this.g = param1Int;
      return this;
    }
    
    public Builder setRewardName(String param1String) {
      this.f = param1String;
      return this;
    }
    
    public Builder setSupportDeepLink(boolean param1Boolean) {
      this.d = param1Boolean;
      return this;
    }
    
    public Builder setUserID(String param1String) {
      this.i = param1String;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\AdSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */