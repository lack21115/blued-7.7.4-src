package org.chromium.ui.display;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import java.util.WeakHashMap;

public class DisplayAndroid {
  private static final DisplayAndroid$DisplayAndroidObserver[] EMPTY_OBSERVER_ARRAY;
  
  int mBitsPerComponent;
  
  int mBitsPerPixel;
  
  public float mDipScale;
  
  public final int mDisplayId;
  
  boolean mIsDisplayServerWideColorGamut;
  
  boolean mIsDisplayWideColorGamut;
  
  private final WeakHashMap mObservers;
  
  public int mRotation;
  
  public Point mSize;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  protected DisplayAndroid(int paramInt) {
    this.mDisplayId = paramInt;
    this.mObservers = new WeakHashMap<Object, Object>();
    this.mSize = new Point();
  }
  
  public static float getAndroidUIScaling() {
    return 1.0F;
  }
  
  public static DisplayAndroid getNonMultiDisplay(Context paramContext) {
    Display display = DisplayAndroidManager.getDefaultDisplayForContext(paramContext);
    DisplayAndroidManager displayAndroidManager = DisplayAndroidManager.getInstance();
    int i = display.getDisplayId();
    DisplayAndroid displayAndroid2 = (DisplayAndroid)displayAndroidManager.mIdMap.get(i);
    DisplayAndroid displayAndroid1 = displayAndroid2;
    if (displayAndroid2 == null)
      displayAndroid1 = displayAndroidManager.addDisplay(display); 
    return displayAndroid1;
  }
  
  private DisplayAndroid$DisplayAndroidObserver[] getObservers() {
    return (DisplayAndroid$DisplayAndroidObserver[])this.mObservers.keySet().toArray((Object[])EMPTY_OBSERVER_ARRAY);
  }
  
  public static void startAccurateListening() {
    (DisplayAndroidManager.getInstance()).mBackend.startAccurateListening();
  }
  
  public static void stopAccurateListening() {
    (DisplayAndroidManager.getInstance()).mBackend.stopAccurateListening();
  }
  
  public final void addObserver(DisplayAndroid$DisplayAndroidObserver paramDisplayAndroid$DisplayAndroidObserver) {
    this.mObservers.put(paramDisplayAndroid$DisplayAndroidObserver, null);
  }
  
  public final void removeObserver(DisplayAndroid$DisplayAndroidObserver paramDisplayAndroid$DisplayAndroidObserver) {
    this.mObservers.remove(paramDisplayAndroid$DisplayAndroidObserver);
  }
  
  protected final void update(Point paramPoint, Float paramFloat, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Boolean paramBoolean1, Boolean paramBoolean2) {
    int i;
    int j;
    int k;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    if (paramPoint != null && !this.mSize.equals(paramPoint)) {
      j = 1;
    } else {
      j = 0;
    } 
    if (paramFloat != null && this.mDipScale != paramFloat.floatValue()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramInteger1 != null && this.mBitsPerPixel != paramInteger1.intValue()) {
      k = 1;
    } else {
      k = 0;
    } 
    if (paramInteger2 != null && this.mBitsPerComponent != paramInteger2.intValue()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramInteger3 != null && this.mRotation != paramInteger3.intValue()) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramBoolean1 != null && this.mIsDisplayWideColorGamut != paramBoolean1.booleanValue()) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramBoolean2 != null && this.mIsDisplayServerWideColorGamut != paramBoolean2.booleanValue()) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    if (j || i || k || bool1 || bool2 || bool3 || bool4) {
      bool5 = true;
    } else {
      bool5 = false;
    } 
    if (!bool5)
      return; 
    if (j)
      this.mSize = paramPoint; 
    if (i)
      this.mDipScale = paramFloat.floatValue(); 
    if (k)
      this.mBitsPerPixel = paramInteger1.intValue(); 
    if (bool1)
      this.mBitsPerComponent = paramInteger2.intValue(); 
    if (bool2)
      this.mRotation = paramInteger3.intValue(); 
    if (bool3)
      this.mIsDisplayWideColorGamut = paramBoolean1.booleanValue(); 
    if (bool4)
      this.mIsDisplayServerWideColorGamut = paramBoolean2.booleanValue(); 
    DisplayAndroidManager.getInstance().updateDisplayOnNativeSide(this);
    if (bool2) {
      DisplayAndroid$DisplayAndroidObserver[] arrayOfDisplayAndroid$DisplayAndroidObserver = getObservers();
      k = arrayOfDisplayAndroid$DisplayAndroidObserver.length;
      for (j = 0; j < k; j++)
        arrayOfDisplayAndroid$DisplayAndroidObserver[j].onRotationChanged(this.mRotation); 
    } 
    if (i) {
      DisplayAndroid$DisplayAndroidObserver[] arrayOfDisplayAndroid$DisplayAndroidObserver = getObservers();
      j = arrayOfDisplayAndroid$DisplayAndroidObserver.length;
      for (i = 0; i < j; i++)
        arrayOfDisplayAndroid$DisplayAndroidObserver[i].onDIPScaleChanged(this.mDipScale); 
    } 
  }
  
  public final void updateIsDisplayServerWideColorGamut(Boolean paramBoolean) {
    update(null, null, null, null, null, null, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\display\DisplayAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */