package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
  private int mInflatedId;
  
  private WeakReference mInflatedViewRef;
  
  private LayoutInflater mInflater;
  
  private int mLayoutResource = 0;
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewStubCompat, paramInt, 0);
    this.mInflatedId = typedArray.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
    this.mLayoutResource = typedArray.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
    setId(typedArray.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
    typedArray.recycle();
    setVisibility(8);
    setWillNotDraw(true);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas) {}
  
  @SuppressLint({"MissingSuperCall"})
  public final void draw(Canvas paramCanvas) {}
  
  protected final void onMeasure(int paramInt1, int paramInt2) {
    setMeasuredDimension(0, 0);
  }
  
  public final void setVisibility(int paramInt) {
    if (this.mInflatedViewRef != null) {
      View view = this.mInflatedViewRef.get();
      if (view != null) {
        view.setVisibility(paramInt);
        return;
      } 
      throw new IllegalStateException("setVisibility called on un-referenced view");
    } 
    super.setVisibility(paramInt);
    if (paramInt == 0 || paramInt == 4) {
      ViewParent viewParent = getParent();
      if (viewParent != null && viewParent instanceof ViewGroup) {
        if (this.mLayoutResource != 0) {
          LayoutInflater layoutInflater;
          ViewGroup viewGroup = (ViewGroup)viewParent;
          if (this.mInflater != null) {
            layoutInflater = this.mInflater;
          } else {
            layoutInflater = LayoutInflater.from(getContext());
          } 
          View view = layoutInflater.inflate(this.mLayoutResource, viewGroup, false);
          if (this.mInflatedId != -1)
            view.setId(this.mInflatedId); 
          paramInt = viewGroup.indexOfChild(this);
          viewGroup.removeViewInLayout(this);
          ViewGroup.LayoutParams layoutParams = getLayoutParams();
          if (layoutParams != null) {
            viewGroup.addView(view, paramInt, layoutParams);
          } else {
            viewGroup.addView(view, paramInt);
          } 
          this.mInflatedViewRef = new WeakReference<View>(view);
          return;
        } 
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
      } 
      throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ViewStubCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */