package com.blued.android.module.shortvideo.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
  private int a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private boolean e = false;
  
  private boolean f = false;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m = 0;
  
  private int n = -1;
  
  public SpacesItemDecoration(int paramInt1, int paramInt2) {
    this(paramInt1, paramInt2, -1);
  }
  
  public SpacesItemDecoration(int paramInt1, int paramInt2, int paramInt3) {
    this.d = paramInt2;
    this.c = paramInt2;
    this.b = paramInt2;
    this.a = paramInt2;
    a(paramInt1);
    this.n = paramInt3;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 != -1) {
      if (paramInt3 <= paramInt2 && this.n - 1 <= paramInt2)
        return 9; 
      if (paramInt1 < paramInt2)
        return 5; 
      if (paramInt1 % paramInt2 == 0)
        return 6; 
      int i = paramInt1 + 1;
      if (i % paramInt2 == 0)
        return 7; 
      paramInt1 = this.n;
      if (paramInt1 != -1)
        paramInt3 = paramInt1; 
      paramInt1 = paramInt3 % paramInt2;
      if (paramInt1 == 0) {
        if (paramInt3 - i < paramInt2)
          return 8; 
      } else if (paramInt3 - i < paramInt1) {
        return 8;
      } 
    } 
    return 10;
  }
  
  private int a(RecyclerView paramRecyclerView) {
    RecyclerView.LayoutManager layoutManager = paramRecyclerView.getLayoutManager();
    return (layoutManager instanceof GridLayoutManager) ? ((GridLayoutManager)layoutManager).getSpanCount() : ((layoutManager instanceof StaggeredGridLayoutManager) ? ((StaggeredGridLayoutManager)layoutManager).getSpanCount() : -1);
  }
  
  private void a(Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    if (paramBoolean1) {
      if (this.e)
        paramRect.left = this.a + this.i; 
    } else {
      paramRect.left = this.a;
    } 
    if (paramBoolean2) {
      if (this.g)
        paramRect.right = this.c + this.j; 
    } else {
      paramRect.right = this.c;
    } 
    if (paramBoolean3) {
      if (this.f)
        paramRect.top = this.b + this.k; 
    } else {
      paramRect.top = this.b;
    } 
    if (paramBoolean4) {
      if (this.h) {
        paramRect.bottom = this.d + this.l;
        return;
      } 
    } else {
      paramRect.bottom = this.d;
    } 
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 != -1)
      if (paramInt1 < paramInt2) {
        if (paramInt1 == 0)
          return 1; 
        if (paramInt1 == paramInt2 - 1)
          return 2; 
      } else if (paramInt1 % paramInt2 == 0) {
        if (paramInt3 - paramInt1 + 1 < paramInt2)
          return 3; 
      } else if (++paramInt1 % paramInt2 == 0 && paramInt3 == paramInt1) {
        return 4;
      }  
    return 10;
  }
  
  public void a(int paramInt) {
    if (paramInt == 0 || paramInt == 1 || paramInt == 5) {
      this.m = paramInt;
      return;
    } 
    throw new IllegalArgumentException("invalid orientation");
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.i = paramInt1;
    this.k = paramInt2;
    this.j = paramInt3;
    this.l = paramInt4;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    this.e = paramBoolean1;
    this.g = paramBoolean2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    RecyclerView.Adapter adapter = paramRecyclerView.getAdapter();
    if (adapter != null) {
      int i = adapter.getItemCount();
      int j = a(paramRecyclerView);
      int k = paramRecyclerView.getChildAdapterPosition(paramView);
      int m = this.m;
      boolean bool4 = false;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = true;
      if (m != 5) {
        j = this.n;
        if (j != -1)
          i = j; 
        if (i == 1) {
          if (this.m == 1) {
            boolean bool5 = true;
          } else {
            boolean bool5 = false;
            bool1 = false;
            bool2 = true;
            bool4 = bool5;
            boolean bool6 = bool1;
            bool5 = bool2;
            bool1 = bool3;
            bool2 = bool4;
            bool3 = bool6;
          } 
        } else {
          if (k == 0) {
            if (this.m == 1) {
              boolean bool5 = true;
            } else {
              boolean bool5 = false;
              bool1 = false;
              bool2 = true;
              bool3 = false;
            } 
          } else {
            if (paramRecyclerView.getChildAdapterPosition(paramView) == i - 1) {
              if (this.m == 1) {
                boolean bool5 = false;
              } else {
                boolean bool5 = false;
                bool1 = false;
                bool2 = bool4;
                bool4 = bool5;
                boolean bool6 = bool1;
                bool5 = bool2;
                bool1 = bool3;
                bool2 = bool4;
                bool3 = bool6;
              } 
            } else {
              boolean bool5 = false;
              bool1 = false;
            } 
            bool1 = true;
          } 
          bool1 = false;
        } 
      } else {
        boolean bool5;
        switch (a(k, j, i)) {
          default:
            bool5 = false;
            bool1 = false;
            bool2 = false;
            bool3 = false;
            break;
          case 9:
            i = b(k, j, i);
            if (i != 1) {
              if (i != 2) {
                bool5 = false;
              } else {
                bool5 = true;
              } 
            } else {
              bool5 = false;
              bool1 = true;
            } 
            bool2 = bool5;
            bool5 = bool1;
            bool3 = true;
            bool1 = bool2;
            bool2 = bool3;
            bool3 = true;
            break;
          case 8:
            bool5 = false;
            bool1 = false;
            bool2 = false;
            bool3 = true;
            break;
          case 7:
            if (b(k, j, i) == 4) {
              bool5 = true;
            } else {
              bool5 = false;
            } 
            bool3 = bool5;
            bool5 = false;
            bool1 = true;
            bool2 = false;
            break;
          case 6:
            if (b(k, j, i) == 3) {
              bool5 = true;
            } else {
              bool5 = false;
            } 
            bool2 = true;
            bool1 = false;
            bool3 = bool5;
            bool5 = bool2;
            bool2 = false;
            break;
          case 5:
            i = b(k, j, i);
            if (i != 1) {
              if (i != 2) {
                bool5 = false;
              } else {
                bool5 = false;
                bool1 = true;
                bool2 = true;
              } 
            } else {
              bool5 = true;
            } 
            bool1 = false;
            bool2 = true;
        } 
        a(paramRect, bool5, bool1, bool2, bool3);
      } 
    } else {
      return;
    } 
    boolean bool = true;
  }
  
  static interface ItemPos {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\widget\SpacesItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */