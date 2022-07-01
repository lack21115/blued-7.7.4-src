package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import org.json.JSONException;
import org.json.JSONObject;

public class WatermarkSetting {
  public static final float CUSTOM_POSITION_NOT_SET = -1.0F;
  
  public static final String TAG = "WatermarkSetting";
  
  public boolean inJustDecodeBounds = true;
  
  public int mAlpha = 255;
  
  public Context mContext;
  
  public float mCustomPositionX = -1.0F;
  
  public float mCustomPositionY = -1.0F;
  
  public boolean mIsCustomSizeSet = false;
  
  public Bitmap mResourceBitmap;
  
  public int mResourceId = -1;
  
  public String mResourcePath = null;
  
  public Bitmap mTempBmp;
  
  public int mWatermarkHeight = 64;
  
  public WATERMARK_LOCATION mWatermarkLocation = WATERMARK_LOCATION.NORTH_EAST;
  
  public WATERMARK_SIZE mWatermarkSize = WATERMARK_SIZE.MEDIUM;
  
  public int mWatermarkWidth = 64;
  
  public WatermarkSetting(Context paramContext) {
    setContext(paramContext);
  }
  
  @Deprecated
  public WatermarkSetting(Context paramContext, int paramInt1, WATERMARK_LOCATION paramWATERMARK_LOCATION, int paramInt2) {
    this(paramContext, paramInt1, paramWATERMARK_LOCATION, (WATERMARK_SIZE)null, paramInt2);
  }
  
  @Deprecated
  public WatermarkSetting(Context paramContext, int paramInt1, WATERMARK_LOCATION paramWATERMARK_LOCATION, WATERMARK_SIZE paramWATERMARK_SIZE, int paramInt2) {
    deprecatedInit(paramContext, paramWATERMARK_LOCATION, paramWATERMARK_SIZE, paramInt2);
    setResourceId(paramInt1);
  }
  
  @Deprecated
  public WatermarkSetting(Context paramContext, String paramString, WATERMARK_LOCATION paramWATERMARK_LOCATION, WATERMARK_SIZE paramWATERMARK_SIZE, int paramInt) {
    deprecatedInit(paramContext, paramWATERMARK_LOCATION, paramWATERMARK_SIZE, paramInt);
    setResourcePath(paramString);
  }
  
  @Deprecated
  private void deprecatedInit(Context paramContext, WATERMARK_LOCATION paramWATERMARK_LOCATION, WATERMARK_SIZE paramWATERMARK_SIZE, int paramInt) {
    setContext(paramContext);
    setLocation(paramWATERMARK_LOCATION);
    setSize(paramWATERMARK_SIZE);
    setAlpha(paramInt);
  }
  
  private Bitmap getBitmap(int paramInt1, int paramInt2) {
    Bitmap bitmap = this.mResourceBitmap;
    if (bitmap != null)
      return h.a(bitmap, paramInt1, paramInt2); 
    if (this.mResourceId != -1)
      return h.a(this.mContext.getResources(), this.mResourceId, paramInt1, paramInt2); 
    String str = this.mResourcePath;
    return (str != null) ? h.a(str, paramInt1, paramInt2) : null;
  }
  
  private void setContext(Context paramContext) {
    if (paramContext != null) {
      this.mContext = paramContext.getApplicationContext();
      return;
    } 
    throw new IllegalArgumentException("Illegal context.");
  }
  
  private void setWidthAndHeight(Bitmap paramBitmap) {
    if (this.mIsCustomSizeSet)
      return; 
    if (this.inJustDecodeBounds) {
      this.mWatermarkWidth = 64;
    } else {
      this.mWatermarkWidth = h.a(paramBitmap.getWidth());
    } 
    int i = Math.round((this.mWatermarkWidth * paramBitmap.getHeight()) * 1.0F / paramBitmap.getWidth());
    this.mWatermarkHeight = i;
    this.mWatermarkHeight = h.a(i);
  }
  
  public Pair<Float, Float> calculateWHRatio(int paramInt1, int paramInt2) {
    float f1;
    float f2;
    if (this.mIsCustomSizeSet) {
      int i = this.mWatermarkWidth;
      f2 = 1.0F;
      if (i < paramInt1) {
        f1 = i / paramInt1;
      } else {
        f1 = 1.0F;
      } 
      paramInt1 = this.mWatermarkHeight;
      if (paramInt1 < paramInt2)
        f2 = paramInt1 / paramInt2; 
      return new Pair(Float.valueOf(f1), Float.valueOf(f2));
    } 
    float f3 = getBmpWidth() / getBmpHeight();
    if (WATERMARK_SIZE.MEDIUM == getWatermarkSize()) {
      f1 = 0.3F;
    } else if (WATERMARK_SIZE.SMALL == getWatermarkSize()) {
      f1 = 0.2F;
    } else {
      f1 = 0.4F;
    } 
    if (paramInt1 < paramInt2) {
      f2 = paramInt1 / paramInt2 * f1;
      f1 *= f3;
    } else {
      f3 = f3 * f1 * paramInt2 / paramInt1;
      f2 = f1;
      f1 = f3;
    } 
    return new Pair(Float.valueOf(f1 / 2.0F), Float.valueOf(f2 / 2.0F));
  }
  
  public int getAlpha() {
    return this.mAlpha;
  }
  
  public int getBmpHeight() {
    return this.mWatermarkHeight;
  }
  
  public int getBmpWidth() {
    return this.mWatermarkWidth;
  }
  
  public float getCustomPositionX() {
    return this.mCustomPositionX;
  }
  
  public float getCustomPositionY() {
    return this.mCustomPositionY;
  }
  
  public Bitmap getSWWatermakBitmap(int paramInt1, int paramInt2) {
    if (this.mContext == null)
      return null; 
    boolean bool = this.inJustDecodeBounds;
    int j = 64;
    if (bool) {
      i = 64;
    } else {
      i = -1;
    } 
    if (!this.inJustDecodeBounds)
      j = -1; 
    Bitmap bitmap2 = getBitmap(i, j);
    if (bitmap2 == null)
      return null; 
    setWidthAndHeight(bitmap2);
    Pair<Float, Float> pair = calculateWHRatio(paramInt1, paramInt2);
    int i = h.a(paramInt1 * ((Float)pair.first).floatValue());
    j = h.a(paramInt2 * ((Float)pair.second).floatValue());
    Bitmap bitmap1 = getBitmap(paramInt1, paramInt2);
    if (bitmap1 == null)
      return null; 
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("create scaled bitmap original width:");
    stringBuilder.append(bitmap1.getWidth());
    stringBuilder.append(" height:");
    stringBuilder.append(bitmap1.getHeight());
    stringBuilder.append(" scale to width:");
    stringBuilder.append(i);
    stringBuilder.append(" height:");
    stringBuilder.append(j);
    e.c("WatermarkSetting", stringBuilder.toString());
    this.mTempBmp = Bitmap.createScaledBitmap(bitmap1, i, j, true);
    if (!bitmap1.isRecycled())
      bitmap1.recycle(); 
    return this.mTempBmp;
  }
  
  public Bitmap getWatermarkBitmap() {
    if (this.mContext != null) {
      byte b1;
      boolean bool = this.inJustDecodeBounds;
      byte b2 = 64;
      if (bool) {
        b1 = 64;
      } else {
        b1 = -1;
      } 
      if (!this.inJustDecodeBounds)
        b2 = -1; 
      Bitmap bitmap = getBitmap(b1, b2);
      if (bitmap == null)
        return null; 
      setWidthAndHeight(bitmap);
      e e = e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mWatermarkWidth:");
      stringBuilder.append(this.mWatermarkWidth);
      stringBuilder.append(",mWatermarkHeight:");
      stringBuilder.append(this.mWatermarkHeight);
      e.c("WatermarkSetting", stringBuilder.toString());
      return Bitmap.createScaledBitmap(bitmap, this.mWatermarkWidth, this.mWatermarkHeight, true);
    } 
    return null;
  }
  
  public WATERMARK_LOCATION getWatermarkLocation() {
    return this.mWatermarkLocation;
  }
  
  public WATERMARK_SIZE getWatermarkSize() {
    return this.mWatermarkSize;
  }
  
  public boolean isCustomPositionSet() {
    return (this.mCustomPositionX != -1.0F || this.mCustomPositionY != -1.0F);
  }
  
  public void release() {
    Bitmap bitmap = this.mTempBmp;
    if (bitmap != null && !bitmap.isRecycled())
      this.mTempBmp.recycle(); 
    this.mTempBmp = null;
  }
  
  public WatermarkSetting setAlpha(int paramInt) {
    if (paramInt >= 0 && paramInt <= 255) {
      this.mAlpha = paramInt;
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("alpha value should be [0...255]:");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public WatermarkSetting setCustomPosition(float paramFloat1, float paramFloat2) {
    if (paramFloat1 >= 0.0F && paramFloat1 <= 1.0F && paramFloat2 >= 0.0F && paramFloat2 <= 1.0F) {
      this.mCustomPositionX = paramFloat1;
      this.mCustomPositionY = paramFloat2;
      this.mWatermarkLocation = null;
      return this;
    } 
    throw new IllegalArgumentException("position values MUST be [0.0f-1.0f]");
  }
  
  public WatermarkSetting setCustomSize(int paramInt1, int paramInt2) {
    this.mWatermarkWidth = paramInt1;
    this.mWatermarkHeight = paramInt2;
    this.mIsCustomSizeSet = true;
    return this;
  }
  
  public WatermarkSetting setInJustDecodeBoundsEnabled(boolean paramBoolean) {
    this.inJustDecodeBounds = paramBoolean;
    return this;
  }
  
  public WatermarkSetting setLocation(WATERMARK_LOCATION paramWATERMARK_LOCATION) {
    if (paramWATERMARK_LOCATION != null) {
      this.mWatermarkLocation = paramWATERMARK_LOCATION;
      this.mCustomPositionX = -1.0F;
      this.mCustomPositionY = -1.0F;
      return this;
    } 
    throw new IllegalArgumentException("Illegal watermark location.");
  }
  
  public WatermarkSetting setResourceBitmap(Bitmap paramBitmap) {
    if (paramBitmap != null) {
      this.mResourceBitmap = paramBitmap;
      this.mResourceId = -1;
      this.mResourcePath = null;
      return this;
    } 
    throw new IllegalArgumentException("Illegal resource bitmap");
  }
  
  public WatermarkSetting setResourceId(int paramInt) {
    if (paramInt >= 0) {
      this.mResourceId = paramInt;
      this.mResourcePath = null;
      this.mResourceBitmap = null;
      return this;
    } 
    throw new IllegalArgumentException("Illegal resource id.");
  }
  
  public WatermarkSetting setResourcePath(String paramString) {
    if (paramString != null) {
      this.mResourcePath = paramString;
      this.mResourceId = -1;
      this.mResourceBitmap = null;
      return this;
    } 
    throw new IllegalArgumentException("Illegal resource path.");
  }
  
  public WatermarkSetting setSize(WATERMARK_SIZE paramWATERMARK_SIZE) {
    if (paramWATERMARK_SIZE != null) {
      this.mWatermarkSize = paramWATERMARK_SIZE;
      return this;
    } 
    this.mWatermarkSize = WATERMARK_SIZE.MEDIUM;
    return this;
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("Size", this.mWatermarkSize);
      jSONObject.put("PositionX", this.mCustomPositionX);
      jSONObject.put("PositionY", this.mCustomPositionY);
      jSONObject.put("WatermarkLocation", this.mWatermarkLocation);
      jSONObject.put("Alpha", this.mAlpha);
      jSONObject.put("JustDecodeBounds", this.inJustDecodeBounds);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
  
  public enum WATERMARK_LOCATION {
    NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST;
    
    static {
      WATERMARK_LOCATION wATERMARK_LOCATION = new WATERMARK_LOCATION("SOUTH_EAST", 3);
      SOUTH_EAST = wATERMARK_LOCATION;
      $VALUES = new WATERMARK_LOCATION[] { NORTH_WEST, NORTH_EAST, SOUTH_WEST, wATERMARK_LOCATION };
    }
  }
  
  public enum WATERMARK_SIZE {
    LARGE, MEDIUM, SMALL;
    
    static {
      WATERMARK_SIZE wATERMARK_SIZE = new WATERMARK_SIZE("SMALL", 2);
      SMALL = wATERMARK_SIZE;
      $VALUES = new WATERMARK_SIZE[] { LARGE, MEDIUM, wATERMARK_SIZE };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\WatermarkSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */