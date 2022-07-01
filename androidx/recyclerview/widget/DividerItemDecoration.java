package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
  public static final int HORIZONTAL = 0;
  
  public static final int VERTICAL = 1;
  
  private static final int[] a = new int[] { 16843284 };
  
  private Drawable b;
  
  private int c;
  
  private final Rect d = new Rect();
  
  public DividerItemDecoration(Context paramContext, int paramInt) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(a);
    this.b = typedArray.getDrawable(0);
    if (this.b == null)
      Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()"); 
    typedArray.recycle();
    setOrientation(paramInt);
  }
  
  private void a(Canvas paramCanvas, RecyclerView paramRecyclerView) {
    boolean bool;
    int i;
    paramCanvas.save();
    boolean bool1 = paramRecyclerView.getClipToPadding();
    int j = 0;
    if (bool1) {
      bool = paramRecyclerView.getPaddingLeft();
      i = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      paramCanvas.clipRect(bool, paramRecyclerView.getPaddingTop(), i, paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
    } else {
      i = paramRecyclerView.getWidth();
      bool = false;
    } 
    int k = paramRecyclerView.getChildCount();
    while (j < k) {
      View view = paramRecyclerView.getChildAt(j);
      paramRecyclerView.getDecoratedBoundsWithMargins(view, this.d);
      int m = this.d.bottom + Math.round(view.getTranslationY());
      int n = this.b.getIntrinsicHeight();
      this.b.setBounds(bool, m - n, i, m);
      this.b.draw(paramCanvas);
      j++;
    } 
    paramCanvas.restore();
  }
  
  private void b(Canvas paramCanvas, RecyclerView paramRecyclerView) {
    boolean bool;
    int i;
    paramCanvas.save();
    boolean bool1 = paramRecyclerView.getClipToPadding();
    int j = 0;
    if (bool1) {
      bool = paramRecyclerView.getPaddingTop();
      i = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
      paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), bool, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), i);
    } else {
      i = paramRecyclerView.getHeight();
      bool = false;
    } 
    int k = paramRecyclerView.getChildCount();
    while (j < k) {
      View view = paramRecyclerView.getChildAt(j);
      paramRecyclerView.getLayoutManager().getDecoratedBoundsWithMargins(view, this.d);
      int m = this.d.right + Math.round(view.getTranslationX());
      int n = this.b.getIntrinsicWidth();
      this.b.setBounds(m - n, bool, m, i);
      this.b.draw(paramCanvas);
      j++;
    } 
    paramCanvas.restore();
  }
  
  public Drawable getDrawable() {
    return this.b;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    Drawable drawable = this.b;
    if (drawable == null) {
      paramRect.set(0, 0, 0, 0);
      return;
    } 
    if (this.c == 1) {
      paramRect.set(0, 0, 0, drawable.getIntrinsicHeight());
      return;
    } 
    paramRect.set(0, 0, drawable.getIntrinsicWidth(), 0);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    if (paramRecyclerView.getLayoutManager() != null) {
      if (this.b == null)
        return; 
      if (this.c == 1) {
        a(paramCanvas, paramRecyclerView);
        return;
      } 
      b(paramCanvas, paramRecyclerView);
    } 
  }
  
  public void setDrawable(Drawable paramDrawable) {
    if (paramDrawable != null) {
      this.b = paramDrawable;
      return;
    } 
    throw new IllegalArgumentException("Drawable cannot be null.");
  }
  
  public void setOrientation(int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      this.c = paramInt;
      return;
    } 
    throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\DividerItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */