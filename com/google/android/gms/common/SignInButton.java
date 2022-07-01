package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.base.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.common.internal.zay;
import com.google.android.gms.dynamic.RemoteCreator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
  public static final int COLOR_AUTO = 2;
  
  public static final int COLOR_DARK = 0;
  
  public static final int COLOR_LIGHT = 1;
  
  public static final int SIZE_ICON_ONLY = 2;
  
  public static final int SIZE_STANDARD = 0;
  
  public static final int SIZE_WIDE = 1;
  
  private int zaa;
  
  private int zab;
  
  private View zac;
  
  private View.OnClickListener zad = null;
  
  public SignInButton(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.SignInButton, 0, 0);
    try {
      this.zaa = typedArray.getInt(R.styleable.SignInButton_buttonSize, 0);
      this.zab = typedArray.getInt(R.styleable.SignInButton_colorScheme, 2);
      typedArray.recycle();
      return;
    } finally {
      typedArray.recycle();
    } 
  }
  
  public final void onClick(View paramView) {
    View.OnClickListener onClickListener = this.zad;
    if (onClickListener != null && paramView == this.zac)
      onClickListener.onClick((View)this); 
  }
  
  public final void setColorScheme(int paramInt) {
    setStyle(this.zaa, paramInt);
  }
  
  public final void setEnabled(boolean paramBoolean) {
    super.setEnabled(paramBoolean);
    this.zac.setEnabled(paramBoolean);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener) {
    this.zad = paramOnClickListener;
    View view = this.zac;
    if (view != null)
      view.setOnClickListener(this); 
  }
  
  @Deprecated
  public final void setScopes(Scope[] paramArrayOfScope) {
    setStyle(this.zaa, this.zab);
  }
  
  public final void setSize(int paramInt) {
    setStyle(paramInt, this.zab);
  }
  
  public final void setStyle(int paramInt1, int paramInt2) {
    this.zaa = paramInt1;
    this.zab = paramInt2;
    Context context = getContext();
    View view = this.zac;
    if (view != null)
      removeView(view); 
    try {
      this.zac = zay.zaa(context, this.zaa, this.zab);
    } catch (com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException remoteCreatorException) {
      Log.w("SignInButton", "Sign in button not found, using placeholder instead");
      paramInt1 = this.zaa;
      paramInt2 = this.zab;
      zax zax = new zax(context);
      zax.zaa(context.getResources(), paramInt1, paramInt2);
      this.zac = (View)zax;
    } 
    addView(this.zac);
    this.zac.setEnabled(isEnabled());
    this.zac.setOnClickListener(this);
  }
  
  @Deprecated
  public final void setStyle(int paramInt1, int paramInt2, Scope[] paramArrayOfScope) {
    setStyle(paramInt1, paramInt2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ButtonSize {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ColorScheme {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\SignInButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */