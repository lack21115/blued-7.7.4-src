package com.blued.android.module.shortvideo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.shortvideo.R;

public class StvItemDecoration extends RecyclerView.ItemDecoration {
  private int a = -7829368;
  
  private int b = 1;
  
  private int c = 0;
  
  private boolean d = true;
  
  private int e = 1;
  
  private ColorDrawable f;
  
  public StvItemDecoration(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.divder);
    this.a = typedArray.getColor(R.styleable.divder_stv_divider_color, this.a);
    this.b = (int)typedArray.getDimension(R.styleable.divder_stv_thickness, this.b);
    this.c = typedArray.getInt(R.styleable.divder_stv_orientation, 0);
    this.d = typedArray.getBoolean(R.styleable.divder_stv_draw_side, true);
    this.e = typedArray.getInt(R.styleable.divder_stv_grid_col_num, 1);
    this.f = new ColorDrawable(this.a);
    typedArray.recycle();
  }
  
  private void a(Canvas paramCanvas, RecyclerView paramRecyclerView) {
    int k = paramRecyclerView.getChildCount();
    View view = paramRecyclerView.getChildAt(0);
    int m = this.c;
    int j = 1;
    int i = 1;
    if (m == 1) {
      j = paramRecyclerView.getLeft();
      m = paramRecyclerView.getRight();
      while (i < k) {
        int n = view.getBottom();
        int i1 = this.b / 2;
        int i2 = view.getBottom();
        int i3 = this.b / 2;
        this.f.setBounds(j, n - i1, m, i2 + i3);
        this.f.draw(paramCanvas);
        if (this.d && i == 0) {
          n = view.getTop();
          i1 = this.b / 2;
          i2 = view.getTop();
          i3 = this.b / 2;
          this.f.setBounds(j, n - i1, m, i2 + i3);
          this.f.draw(paramCanvas);
        } 
        view = paramRecyclerView.getChildAt(i);
        i++;
      } 
    } else if (m == 0) {
      m = view.getTop();
      int n = view.getBottom();
      for (i = j; i < k; i++) {
        j = view.getRight();
        int i1 = this.b / 2;
        int i2 = view.getRight();
        int i3 = this.b / 2;
        this.f.setBounds(j - i1, m, i2 + i3, n);
        this.f.draw(paramCanvas);
        if (this.d && i == 0) {
          j = view.getLeft();
          i1 = this.b / 2;
          i2 = view.getLeft();
          i3 = this.b / 2;
          this.f.setBounds(j - i1, m, i2 + i3, n);
          this.f.draw(paramCanvas);
        } 
        view = paramRecyclerView.getChildAt(i);
      } 
    } 
  }
  
  private void b(Canvas paramCanvas, RecyclerView paramRecyclerView) {
    int i = paramRecyclerView.getChildCount();
    int m = this.e;
    int k = i / m;
    int j = 0;
    if (i % m == 0) {
      i = 0;
    } else {
      i = 1;
    } 
    k = k - 1 + i;
    m = paramRecyclerView.getLeft() + this.b / 2;
    int n = paramRecyclerView.getRight() - this.b / 2;
    for (i = 0; i < k; i++) {
      View view = paramRecyclerView.getChildAt(this.e * i);
      if (view != null) {
        int i1 = view.getBottom();
        int i2 = view.getBottom();
        int i3 = this.b;
        this.f.setBounds(m, i1, n, i2 + i3);
        this.f.draw(paramCanvas);
        if (this.d)
          if (i == 0) {
            i1 = view.getTop();
            i2 = this.b;
            i3 = view.getTop();
            this.f.setBounds(m, i1 - i2, n, i3);
            this.f.draw(paramCanvas);
          } else if (i == k - 1) {
            i1 = view.getBottom();
            i2 = view.getBottom();
            i3 = this.b;
            this.f.setBounds(m, i1, n, i2 + i3);
            this.f.draw(paramCanvas);
          }  
      } 
    } 
    k = paramRecyclerView.getTop();
    m = paramRecyclerView.getBottom();
    for (i = j; i < this.e; i++) {
      View view = paramRecyclerView.getChildAt(i);
      if (view != null) {
        j = view.getRight();
        n = view.getRight();
        int i1 = this.b;
        this.f.setBounds(j, k, n + i1, m);
        this.f.draw(paramCanvas);
        if (this.d)
          if (i == 0) {
            j = view.getLeft();
            n = this.b;
            i1 = view.getLeft();
            this.f.setBounds(j - n, k, i1, m);
            this.f.draw(paramCanvas);
          } else if (i == this.e - 1) {
            j = view.getRight();
            n = view.getRight();
            i1 = this.b;
            this.f.setBounds(j, k, n + i1, m);
            this.f.draw(paramCanvas);
          }  
      } 
    } 
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    int i = this.c;
    if (i == 1) {
      i = this.b;
      paramRect.set(0, i / 2, 0, i / 2);
      return;
    } 
    if (i == 0) {
      i = this.b;
      paramRect.set(i / 2, 0, i / 2, 0);
      return;
    } 
    i = this.b;
    paramRect.set(i / 2, i / 2, i / 2, i / 2);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int i = this.c;
    if (i == 0 || i == 1) {
      a(paramCanvas, paramRecyclerView);
      return;
    } 
    if (i == 2) {
      b(paramCanvas, paramRecyclerView);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\widget\StvItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */