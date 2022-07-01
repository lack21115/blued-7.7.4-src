package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

public class TextDrawableHelper {
  private final TextPaint a = new TextPaint(1);
  
  private final TextAppearanceFontCallback b = new TextAppearanceFontCallback(this) {
      public void a(int param1Int) {
        TextDrawableHelper.a(this.a, true);
        TextDrawableHelper.TextDrawableDelegate textDrawableDelegate = TextDrawableHelper.a(this.a).get();
        if (textDrawableDelegate != null)
          textDrawableDelegate.e(); 
      }
      
      public void a(Typeface param1Typeface, boolean param1Boolean) {
        if (param1Boolean)
          return; 
        TextDrawableHelper.a(this.a, true);
        TextDrawableHelper.TextDrawableDelegate textDrawableDelegate = TextDrawableHelper.a(this.a).get();
        if (textDrawableDelegate != null)
          textDrawableDelegate.e(); 
      }
    };
  
  private float c;
  
  private boolean d = true;
  
  private WeakReference<TextDrawableDelegate> e = new WeakReference<TextDrawableDelegate>(null);
  
  private TextAppearance f;
  
  public TextDrawableHelper(TextDrawableDelegate paramTextDrawableDelegate) {
    a(paramTextDrawableDelegate);
  }
  
  private float a(CharSequence paramCharSequence) {
    return (paramCharSequence == null) ? 0.0F : this.a.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public float a(String paramString) {
    if (!this.d)
      return this.c; 
    this.c = a(paramString);
    this.d = false;
    return this.c;
  }
  
  public TextPaint a() {
    return this.a;
  }
  
  public void a(Context paramContext) {
    this.f.b(paramContext, this.a, this.b);
  }
  
  public void a(TextDrawableDelegate paramTextDrawableDelegate) {
    this.e = new WeakReference<TextDrawableDelegate>(paramTextDrawableDelegate);
  }
  
  public void a(TextAppearance paramTextAppearance, Context paramContext) {
    if (this.f != paramTextAppearance) {
      this.f = paramTextAppearance;
      if (paramTextAppearance != null) {
        paramTextAppearance.c(paramContext, this.a, this.b);
        TextDrawableDelegate textDrawableDelegate1 = this.e.get();
        if (textDrawableDelegate1 != null)
          this.a.drawableState = textDrawableDelegate1.getState(); 
        paramTextAppearance.b(paramContext, this.a, this.b);
        this.d = true;
      } 
      TextDrawableDelegate textDrawableDelegate = this.e.get();
      if (textDrawableDelegate != null) {
        textDrawableDelegate.e();
        textDrawableDelegate.onStateChange(textDrawableDelegate.getState());
      } 
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public TextAppearance b() {
    return this.f;
  }
  
  public static interface TextDrawableDelegate {
    void e();
    
    int[] getState();
    
    boolean onStateChange(int[] param1ArrayOfint);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\TextDrawableHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */