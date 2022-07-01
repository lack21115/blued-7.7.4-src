package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R;
import com.google.android.gms.common.util.DeviceProperties;

public final class zax extends Button {
  public zax(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  private zax(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, null, 16842824);
  }
  
  private static int zaa(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt1 != 0) {
      if (paramInt1 != 1) {
        if (paramInt1 == 2)
          return paramInt4; 
        StringBuilder stringBuilder = new StringBuilder(33);
        stringBuilder.append("Unknown color scheme: ");
        stringBuilder.append(paramInt1);
        throw new IllegalStateException(stringBuilder.toString());
      } 
      return paramInt3;
    } 
    return paramInt2;
  }
  
  public final void zaa(Resources paramResources, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder;
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    int i = (int)((paramResources.getDisplayMetrics()).density * 48.0F + 0.5F);
    setMinHeight(i);
    setMinWidth(i);
    i = zaa(paramInt2, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light);
    int j = zaa(paramInt2, R.drawable.common_google_signin_btn_text_dark, R.drawable.common_google_signin_btn_text_light, R.drawable.common_google_signin_btn_text_light);
    if (paramInt1 != 0 && paramInt1 != 1) {
      if (paramInt1 != 2) {
        stringBuilder = new StringBuilder(32);
        stringBuilder.append("Unknown button size: ");
        stringBuilder.append(paramInt1);
        throw new IllegalStateException(stringBuilder.toString());
      } 
    } else {
      i = j;
    } 
    Drawable drawable = DrawableCompat.wrap(stringBuilder.getDrawable(i));
    DrawableCompat.setTintList(drawable, stringBuilder.getColorStateList(R.color.common_google_signin_btn_tint));
    DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_ATOP);
    setBackgroundDrawable(drawable);
    setTextColor(Preconditions.<ColorStateList>checkNotNull(stringBuilder.getColorStateList(zaa(paramInt2, R.color.common_google_signin_btn_text_dark, R.color.common_google_signin_btn_text_light, R.color.common_google_signin_btn_text_light))));
    if (paramInt1 != 0) {
      if (paramInt1 != 1) {
        if (paramInt1 == 2) {
          setText(null);
        } else {
          stringBuilder = new StringBuilder(32);
          stringBuilder.append("Unknown button size: ");
          stringBuilder.append(paramInt1);
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } else {
        setText(stringBuilder.getString(R.string.common_signin_button_text_long));
      } 
    } else {
      setText(stringBuilder.getString(R.string.common_signin_button_text));
    } 
    setTransformationMethod(null);
    if (DeviceProperties.isWearable(getContext()))
      setGravity(19); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */