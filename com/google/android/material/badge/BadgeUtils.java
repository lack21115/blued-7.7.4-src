package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.internal.ParcelableSparseArray;

public class BadgeUtils {
  public static final boolean a;
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
  
  public static SparseArray<BadgeDrawable> a(Context paramContext, ParcelableSparseArray paramParcelableSparseArray) {
    SparseArray<BadgeDrawable> sparseArray = new SparseArray(paramParcelableSparseArray.size());
    int i = 0;
    while (i < paramParcelableSparseArray.size()) {
      int j = paramParcelableSparseArray.keyAt(i);
      BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState)paramParcelableSparseArray.valueAt(i);
      if (savedState != null) {
        sparseArray.put(j, BadgeDrawable.a(paramContext, savedState));
        i++;
        continue;
      } 
      throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
    } 
    return sparseArray;
  }
  
  public static ParcelableSparseArray a(SparseArray<BadgeDrawable> paramSparseArray) {
    ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
    int i = 0;
    while (i < paramSparseArray.size()) {
      int j = paramSparseArray.keyAt(i);
      BadgeDrawable badgeDrawable = (BadgeDrawable)paramSparseArray.valueAt(i);
      if (badgeDrawable != null) {
        parcelableSparseArray.put(j, badgeDrawable.a());
        i++;
        continue;
      } 
      throw new IllegalArgumentException("badgeDrawable cannot be null");
    } 
    return parcelableSparseArray;
  }
  
  public static void a(Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    paramRect.set((int)(paramFloat1 - paramFloat3), (int)(paramFloat2 - paramFloat4), (int)(paramFloat1 + paramFloat3), (int)(paramFloat2 + paramFloat4));
  }
  
  public static void a(BadgeDrawable paramBadgeDrawable, View paramView, FrameLayout paramFrameLayout) {
    c(paramBadgeDrawable, paramView, paramFrameLayout);
    if (a) {
      paramFrameLayout.setForeground(paramBadgeDrawable);
      return;
    } 
    paramView.getOverlay().add(paramBadgeDrawable);
  }
  
  public static void b(BadgeDrawable paramBadgeDrawable, View paramView, FrameLayout paramFrameLayout) {
    if (paramBadgeDrawable == null)
      return; 
    if (a) {
      paramFrameLayout.setForeground(null);
      return;
    } 
    paramView.getOverlay().remove(paramBadgeDrawable);
  }
  
  public static void c(BadgeDrawable paramBadgeDrawable, View paramView, FrameLayout paramFrameLayout) {
    View view;
    Rect rect = new Rect();
    if (a) {
      FrameLayout frameLayout = paramFrameLayout;
    } else {
      view = paramView;
    } 
    view.getDrawingRect(rect);
    paramBadgeDrawable.setBounds(rect);
    paramBadgeDrawable.a(paramView, (ViewGroup)paramFrameLayout);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\badge\BadgeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */