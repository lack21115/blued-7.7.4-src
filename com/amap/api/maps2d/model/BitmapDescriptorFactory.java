package com.amap.api.maps2d.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import com.amap.api.mapcore2d.cm;

public final class BitmapDescriptorFactory {
  public static final float HUE_AZURE = 210.0F;
  
  public static final float HUE_BLUE = 240.0F;
  
  public static final float HUE_CYAN = 180.0F;
  
  public static final float HUE_GREEN = 120.0F;
  
  public static final float HUE_MAGENTA = 300.0F;
  
  public static final float HUE_ORANGE = 30.0F;
  
  public static final float HUE_RED = 0.0F;
  
  public static final float HUE_ROSE = 330.0F;
  
  public static final float HUE_VIOLET = 270.0F;
  
  public static final float HUE_YELLOW = 60.0F;
  
  private static Bitmap a(View paramView) {
    try {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      return paramView.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
    } finally {
      paramView = null;
      cm.a((Throwable)paramView, "BitmapDescriptorFactory", "getViewBitmap");
    } 
  }
  
  public static BitmapDescriptor defaultMarker() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      return fromAsset(stringBuilder.toString());
    } finally {
      Exception exception = null;
      cm.a(exception, "BitmapDescriptorFactory", "defaultMarker");
    } 
  }
  
  public static BitmapDescriptor defaultMarker(float paramFloat) {
    int i = (int)(paramFloat + 15.0F);
    try {
    
    } finally {
      Exception exception = null;
      cm.a(exception, "BitmapDescriptorFactory", "defaultMarker");
    } 
    String str = "";
    if (paramFloat == 0.0F) {
      str = "RED";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("2d.png");
      return fromAsset(stringBuilder1.toString());
    } 
    if (paramFloat == 30.0F) {
      str = "ORANGE";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("2d.png");
      return fromAsset(stringBuilder1.toString());
    } 
    if (paramFloat == 60.0F) {
      str = "YELLOW";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("2d.png");
      return fromAsset(stringBuilder1.toString());
    } 
    if (paramFloat == 120.0F) {
      str = "GREEN";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("2d.png");
      return fromAsset(stringBuilder1.toString());
    } 
    if (paramFloat == 180.0F) {
      str = "CYAN";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("2d.png");
      return fromAsset(stringBuilder1.toString());
    } 
    if (paramFloat == 210.0F) {
      str = "AZURE";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("2d.png");
      return fromAsset(stringBuilder1.toString());
    } 
    if (paramFloat == 240.0F) {
      str = "BLUE";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("2d.png");
      return fromAsset(stringBuilder1.toString());
    } 
    if (paramFloat == 270.0F) {
      str = "VIOLET";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("2d.png");
      return fromAsset(stringBuilder1.toString());
    } 
    if (paramFloat == 300.0F) {
      str = "MAGENTAV";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("2d.png");
      return fromAsset(stringBuilder1.toString());
    } 
    if (paramFloat == 330.0F)
      str = "ROSE"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("2d.png");
    return fromAsset(stringBuilder.toString());
  }
  
  public static BitmapDescriptor fromAsset(String paramString) {
    try {
      return fromBitmap(cm.a(paramString));
    } finally {
      paramString = null;
      cm.a((Throwable)paramString, "BitmapDescriptorFactory", "fromAsset");
    } 
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap) {
    if (paramBitmap == null)
      return null; 
    try {
      return new BitmapDescriptor(paramBitmap);
    } finally {
      paramBitmap = null;
      cm.a((Throwable)paramBitmap, "BitmapDescriptorFactory", "fromBitmap");
    } 
  }
  
  public static BitmapDescriptor fromFile(String paramString) {
    try {
      return null;
    } finally {
      paramString = null;
      cm.a((Throwable)paramString, "BitmapDescriptorFactory", "fromFile");
    } 
  }
  
  public static BitmapDescriptor fromPath(String paramString) {
    try {
      return fromBitmap(BitmapFactory.decodeFile(paramString));
    } finally {
      paramString = null;
      cm.a((Throwable)paramString, "BitmapDescriptorFactory", "fromPath");
    } 
  }
  
  public static BitmapDescriptor fromResource(int paramInt) {
    try {
      return (context != null) ? fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(paramInt))) : null;
    } finally {
      Exception exception = null;
      cm.a(exception, "BitmapDescriptorFactory", "fromResource");
    } 
  }
  
  public static BitmapDescriptor fromView(View paramView) {
    try {
      return null;
    } finally {
      paramView = null;
      cm.a((Throwable)paramView, "BitmapDescriptorFactory", "fromView");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\BitmapDescriptorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */