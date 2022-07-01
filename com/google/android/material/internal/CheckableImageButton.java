package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
  private static final int[] a = new int[] { 16842912 };
  
  private boolean b;
  
  private boolean c = true;
  
  private boolean d = true;
  
  public CheckableImageButton(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    ViewCompat.setAccessibilityDelegate((View)this, new AccessibilityDelegateCompat(this) {
          public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
            super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
            param1AccessibilityEvent.setChecked(this.a.isChecked());
          }
          
          public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
            param1AccessibilityNodeInfoCompat.setCheckable(this.a.a());
            param1AccessibilityNodeInfoCompat.setChecked(this.a.isChecked());
          }
        });
  }
  
  public boolean a() {
    return this.c;
  }
  
  public boolean isChecked() {
    return this.b;
  }
  
  public int[] onCreateDrawableState(int paramInt) {
    return this.b ? mergeDrawableStates(super.onCreateDrawableState(paramInt + a.length), a) : super.onCreateDrawableState(paramInt);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    setChecked(savedState.a);
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.b;
    return (Parcelable)savedState;
  }
  
  public void setCheckable(boolean paramBoolean) {
    if (this.c != paramBoolean) {
      this.c = paramBoolean;
      sendAccessibilityEvent(0);
    } 
  }
  
  public void setChecked(boolean paramBoolean) {
    if (this.c && this.b != paramBoolean) {
      this.b = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    } 
  }
  
  public void setPressable(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public void setPressed(boolean paramBoolean) {
    if (this.d)
      super.setPressed(paramBoolean); 
  }
  
  public void toggle() {
    setChecked(this.b ^ true);
  }
  
  static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public CheckableImageButton.SavedState a(Parcel param2Parcel) {
          return new CheckableImageButton.SavedState(param2Parcel, null);
        }
        
        public CheckableImageButton.SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new CheckableImageButton.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public CheckableImageButton.SavedState[] a(int param2Int) {
          return new CheckableImageButton.SavedState[param2Int];
        }
      };
    
    boolean a;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      a(param1Parcel);
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    private void a(Parcel param1Parcel) {
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.a = bool;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public CheckableImageButton.SavedState a(Parcel param1Parcel) {
      return new CheckableImageButton.SavedState(param1Parcel, null);
    }
    
    public CheckableImageButton.SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new CheckableImageButton.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public CheckableImageButton.SavedState[] a(int param1Int) {
      return new CheckableImageButton.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\CheckableImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */