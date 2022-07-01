package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;

public class DividerGridItemDecoration extends RecyclerView.ItemDecoration implements BluedSkinSupportable {
  private static final int[] a = new int[] { 16843284 };
  
  private RecyclerView b;
  
  private Drawable c;
  
  private Paint d;
  
  private Context e;
  
  private int f = 2;
  
  private int g = 2131100881;
  
  public DividerGridItemDecoration(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    this.e = paramRecyclerView.getContext();
    this.b = paramRecyclerView;
    this.f = paramInt1;
    this.g = paramInt2;
    this.d = new Paint(1);
    this.d.setColor(BluedSkinUtils.a(this.e, paramInt2));
    this.d.setStyle(Paint.Style.FILL);
  }
  
  private int a(RecyclerView paramRecyclerView) {
    RecyclerView.LayoutManager layoutManager = paramRecyclerView.getLayoutManager();
    return (layoutManager instanceof GridLayoutManager) ? ((GridLayoutManager)layoutManager).getSpanCount() : ((layoutManager instanceof StaggeredGridLayoutManager) ? ((StaggeredGridLayoutManager)layoutManager).getSpanCount() : -1);
  }
  
  private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {
    RecyclerView.LayoutManager layoutManager = paramRecyclerView.getLayoutManager();
    if (layoutManager instanceof GridLayoutManager) {
      if ((paramInt1 + 1) % paramInt2 == 0)
        return true; 
    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
      if (((StaggeredGridLayoutManager)layoutManager).getOrientation() == 1) {
        if ((paramInt1 + 1) % paramInt2 == 0)
          return true; 
      } else if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        return true;
      } 
    } 
    return false;
  }
  
  private boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {
    RecyclerView.LayoutManager layoutManager = paramRecyclerView.getLayoutManager();
    if (layoutManager instanceof GridLayoutManager) {
      int i = paramInt3 % paramInt2;
      if (i != 0) {
        paramInt2 = paramInt3 - i;
      } else {
        paramInt2 = paramInt3 - paramInt2;
      } 
      if (paramInt1 >= paramInt2)
        return true; 
    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
      if (((StaggeredGridLayoutManager)layoutManager).getOrientation() == 1) {
        int i = paramInt3 % paramInt2;
        if (i != 0) {
          paramInt2 = paramInt3 - i;
        } else {
          paramInt2 = paramInt3 - paramInt2;
        } 
        if (paramInt1 >= paramInt2)
          return true; 
      } else if ((paramInt1 + 1) % paramInt2 == 0) {
        return true;
      } 
    } 
    return false;
  }
  
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView) {
    int j = paramRecyclerView.getChildCount();
    for (int i = 0; i < j; i++) {
      View view = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
      int k = view.getLeft() - layoutParams.leftMargin - this.f;
      int m = view.getRight() + layoutParams.rightMargin + this.f;
      int n = view.getBottom() + layoutParams.bottomMargin;
      int i1 = this.f + n;
      Drawable drawable = this.c;
      if (drawable != null) {
        drawable.setBounds(k, n, m, i1);
        this.c.draw(paramCanvas);
      } 
      Paint paint = this.d;
      if (paint != null)
        paramCanvas.drawRect(k, n, m, i1, paint); 
    } 
  }
  
  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView) {
    int j = paramRecyclerView.getChildCount();
    for (int i = 0; i < j; i++) {
      View view = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
      int k = view.getTop() - layoutParams.topMargin - this.f;
      int m = view.getBottom() + layoutParams.bottomMargin;
      int n = view.getRight() + layoutParams.rightMargin;
      int i1 = this.f + n;
      Drawable drawable = this.c;
      if (drawable != null) {
        drawable.setBounds(n, k, i1, m);
        this.c.draw(paramCanvas);
      } 
      Paint paint = this.d;
      if (paint != null)
        paramCanvas.drawRect(n, k, i1, m, paint); 
    } 
  }
  
  public void g() {
    Paint paint = this.d;
    if (paint != null && this.b != null) {
      paint.setColor(BluedSkinUtils.a(this.e, this.g));
      this.b.invalidateItemDecorations();
    } 
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView) {
    int i = a(paramRecyclerView);
    int j = paramRecyclerView.getAdapter().getItemCount();
    if (b(paramRecyclerView, paramInt, i, j)) {
      if (!a(paramRecyclerView, paramInt, i, j)) {
        paramRect.set(0, 0, this.f, 0);
        return;
      } 
      return;
    } 
    if (!a(paramRecyclerView, paramInt, i, j)) {
      paramInt = this.f;
      paramRect.set(0, 0, paramInt, paramInt);
      return;
    } 
    paramRect.set(0, 0, 0, this.f);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    a(paramCanvas, paramRecyclerView);
    b(paramCanvas, paramRecyclerView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\DividerGridItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */