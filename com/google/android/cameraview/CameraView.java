package com.google.android.cameraview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class CameraView extends FrameLayout {
  CameraViewImpl a;
  
  private final CallbackBridge c;
  
  private boolean d;
  
  private final DisplayOrientationDetector e;
  
  public CameraView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public CameraView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {
      this.c = null;
      this.e = null;
      return;
    } 
    PreviewImpl previewImpl = a(paramContext);
    this.c = new CallbackBridge(this);
    this.a = new Camera1(this.c, previewImpl);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CameraView, paramInt, R.style.Widget_CameraView);
    this.d = typedArray.getBoolean(R.styleable.CameraView_android_adjustViewBounds, false);
    setFacing(typedArray.getInt(R.styleable.CameraView_facing, 0));
    String str = typedArray.getString(R.styleable.CameraView_aspectRatio);
    if (str != null) {
      setAspectRatio(AspectRatio.a(str));
    } else {
      setAspectRatio(Constants.a);
    } 
    setAutoFocus(typedArray.getBoolean(R.styleable.CameraView_autoFocus, true));
    setFlash(typedArray.getInt(R.styleable.CameraView_flash, 3));
    typedArray.recycle();
    this.e = new DisplayOrientationDetector(this, paramContext) {
        public void a(int param1Int) {
          this.a.a.c(param1Int);
        }
      };
  }
  
  private PreviewImpl a(Context paramContext) {
    return (PreviewImpl)((Build.VERSION.SDK_INT < 14) ? new SurfaceViewPreview(paramContext, (ViewGroup)this) : new TextureViewPreview(paramContext, (ViewGroup)this));
  }
  
  public void a(Callback paramCallback) {
    this.c.a(paramCallback);
  }
  
  public void b() {
    if (!this.a.a()) {
      Parcelable parcelable = onSaveInstanceState();
      this.a = new Camera1(this.c, a(getContext()));
      onRestoreInstanceState(parcelable);
      this.a.a();
    } 
  }
  
  public void c() {
    this.a.b();
  }
  
  public boolean d() {
    return this.a.d();
  }
  
  public void e() {
    this.a.j();
  }
  
  public boolean getAdjustViewBounds() {
    return this.d;
  }
  
  public AspectRatio getAspectRatio() {
    return this.a.g();
  }
  
  public boolean getAutoFocus() {
    return this.a.h();
  }
  
  public int getFacing() {
    return this.a.e();
  }
  
  public int getFlash() {
    return this.a.i();
  }
  
  public Set<AspectRatio> getSupportedAspectRatios() {
    return this.a.f();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (!isInEditMode())
      this.e.a(ViewCompat.getDisplay((View)this)); 
  }
  
  protected void onDetachedFromWindow() {
    if (!isInEditMode())
      this.e.a(); 
    super.onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (isInEditMode()) {
      super.onMeasure(paramInt1, paramInt2);
      return;
    } 
    if (this.d) {
      if (!d()) {
        this.c.c();
        super.onMeasure(paramInt1, paramInt2);
        return;
      } 
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt2);
      if (i == 1073741824 && j != 1073741824) {
        AspectRatio aspectRatio = getAspectRatio();
        if (b || aspectRatio != null) {
          int m = (int)(View.MeasureSpec.getSize(paramInt1) * aspectRatio.c());
          int k = m;
          if (j == Integer.MIN_VALUE)
            k = Math.min(m, View.MeasureSpec.getSize(paramInt2)); 
          super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(k, 1073741824));
        } else {
          throw new AssertionError();
        } 
      } else if (i != 1073741824 && j == 1073741824) {
        AspectRatio aspectRatio = getAspectRatio();
        if (b || aspectRatio != null) {
          int m = (int)(View.MeasureSpec.getSize(paramInt2) * aspectRatio.c());
          int k = m;
          if (i == Integer.MIN_VALUE)
            k = Math.min(m, View.MeasureSpec.getSize(paramInt1)); 
          super.onMeasure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), paramInt2);
        } else {
          throw new AssertionError();
        } 
      } else {
        super.onMeasure(paramInt1, paramInt2);
      } 
    } else {
      super.onMeasure(paramInt1, paramInt2);
    } 
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    AspectRatio aspectRatio2 = getAspectRatio();
    AspectRatio aspectRatio1 = aspectRatio2;
    if (this.e.b() % 180 == 0)
      aspectRatio1 = aspectRatio2.d(); 
    if (b || aspectRatio1 != null) {
      if (paramInt2 < aspectRatio1.b() * paramInt1 / aspectRatio1.a()) {
        this.a.o().measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1 * aspectRatio1.b() / aspectRatio1.a(), 1073741824));
        return;
      } 
      this.a.o().measure(View.MeasureSpec.makeMeasureSpec(aspectRatio1.a() * paramInt2 / aspectRatio1.b(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      return;
    } 
    throw new AssertionError();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    setFacing(savedState.a);
    setAspectRatio(savedState.b);
    setAutoFocus(savedState.c);
    setFlash(savedState.d);
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = getFacing();
    savedState.b = getAspectRatio();
    savedState.c = getAutoFocus();
    savedState.d = getFlash();
    return (Parcelable)savedState;
  }
  
  public void setAdjustViewBounds(boolean paramBoolean) {
    if (this.d != paramBoolean) {
      this.d = paramBoolean;
      requestLayout();
    } 
  }
  
  public void setAspectRatio(AspectRatio paramAspectRatio) {
    if (this.a.a(paramAspectRatio))
      requestLayout(); 
  }
  
  public void setAutoFocus(boolean paramBoolean) {
    this.a.a(paramBoolean);
  }
  
  public void setFacing(int paramInt) {
    this.a.a(paramInt);
  }
  
  public void setFlash(int paramInt) {
    this.a.b(paramInt);
  }
  
  public static abstract class Callback {
    public void a(CameraView param1CameraView) {}
    
    public void a(CameraView param1CameraView, byte[] param1ArrayOfbyte) {}
    
    public void b(CameraView param1CameraView) {}
  }
  
  class CallbackBridge implements CameraViewImpl.Callback {
    private final ArrayList<CameraView.Callback> b = new ArrayList<CameraView.Callback>();
    
    private boolean c;
    
    CallbackBridge(CameraView this$0) {}
    
    public void a() {
      if (this.c) {
        this.c = false;
        this.a.requestLayout();
      } 
      Iterator<CameraView.Callback> iterator = this.b.iterator();
      while (iterator.hasNext())
        ((CameraView.Callback)iterator.next()).a(this.a); 
    }
    
    public void a(CameraView.Callback param1Callback) {
      this.b.add(param1Callback);
    }
    
    public void a(byte[] param1ArrayOfbyte) {
      Iterator<CameraView.Callback> iterator = this.b.iterator();
      while (iterator.hasNext())
        ((CameraView.Callback)iterator.next()).a(this.a, param1ArrayOfbyte); 
    }
    
    public void b() {
      Iterator<CameraView.Callback> iterator = this.b.iterator();
      while (iterator.hasNext())
        ((CameraView.Callback)iterator.next()).b(this.a); 
    }
    
    public void c() {
      this.c = true;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Facing {}
  
  public static @interface Flash {}
  
  public static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
          public CameraView.SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
            return new CameraView.SavedState(param2Parcel, param2ClassLoader);
          }
          
          public CameraView.SavedState[] a(int param2Int) {
            return new CameraView.SavedState[param2Int];
          }
        });
    
    int a;
    
    AspectRatio b;
    
    boolean c;
    
    int d;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel);
      boolean bool;
      this.a = param1Parcel.readInt();
      this.b = (AspectRatio)param1Parcel.readParcelable(param1ClassLoader);
      if (param1Parcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.c = bool;
      this.d = param1Parcel.readInt();
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
      param1Parcel.writeParcelable(this.b, 0);
      param1Parcel.writeByte((byte)this.c);
      param1Parcel.writeInt(this.d);
    }
  }
  
  static final class null implements ParcelableCompatCreatorCallbacks<SavedState> {
    public CameraView.SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new CameraView.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public CameraView.SavedState[] a(int param1Int) {
      return new CameraView.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\CameraView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */