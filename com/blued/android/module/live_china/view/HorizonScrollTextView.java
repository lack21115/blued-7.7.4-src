package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.AppMethods;

public class HorizonScrollTextView extends AppCompatTextView implements View.OnClickListener {
  public boolean a = false;
  
  private Context b;
  
  private float c = 0.0F;
  
  private float d = 0.0F;
  
  private float e = 0.0F;
  
  private float f = 0.0F;
  
  private String g = "";
  
  private Paint h;
  
  private Bitmap i;
  
  private OnScrollListener j;
  
  public HorizonScrollTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    c();
    this.b = paramContext;
  }
  
  public HorizonScrollTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
    this.b = paramContext;
  }
  
  private void c() {
    setOnClickListener(this);
  }
  
  public void a() {
    this.a = true;
    invalidate();
  }
  
  public void b() {
    this.a = false;
    invalidate();
  }
  
  public void onClick(View paramView) {
    if (this.a) {
      b();
      return;
    } 
    a();
  }
  
  public void onDraw(Canvas paramCanvas) {
    paramCanvas.drawBitmap(this.i, this.f, 0.0F, this.h);
    paramCanvas.drawText(this.g, this.d, this.e, this.h);
    if (!this.a)
      return; 
    this.d -= 3.0F;
    this.f -= 3.0F;
    if (this.d <= -this.c) {
      this.d = (this.i.getWidth() + AppMethods.a(8));
      this.f = 0.0F;
      b();
      OnScrollListener onScrollListener = this.j;
      if (onScrollListener != null)
        onScrollListener.a(); 
    } 
    invalidate();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.d = savedState.b;
    this.a = savedState.a;
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.b = this.d;
    savedState.a = this.a;
    return (Parcelable)savedState;
  }
  
  public void setOnScrollListener(OnScrollListener paramOnScrollListener) {
    this.j = paramOnScrollListener;
  }
  
  public static interface OnScrollListener {
    void a();
  }
  
  public static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public HorizonScrollTextView.SavedState a(Parcel param2Parcel) {
          return new HorizonScrollTextView.SavedState(param2Parcel);
        }
        
        public HorizonScrollTextView.SavedState[] a(int param2Int) {
          return new HorizonScrollTextView.SavedState[param2Int];
        }
      };
    
    public boolean a = false;
    
    public float b = 0.0F;
    
    private SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      param1Parcel.readBooleanArray(null);
      this.b = param1Parcel.readFloat();
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeBooleanArray(new boolean[] { this.a });
      param1Parcel.writeFloat(this.b);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public HorizonScrollTextView.SavedState a(Parcel param1Parcel) {
      return new HorizonScrollTextView.SavedState(param1Parcel);
    }
    
    public HorizonScrollTextView.SavedState[] a(int param1Int) {
      return new HorizonScrollTextView.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\HorizonScrollTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */