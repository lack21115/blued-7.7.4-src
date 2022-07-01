package com.soft.blued.customview;

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
  
  public SpacesItemDecoration(int paramInt) {
    this.d = paramInt;
    this.c = paramInt;
    this.b = paramInt;
    this.a = paramInt;
  }
  
  public SpacesItemDecoration(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 != -1) {
      if (paramInt3 <= paramInt2)
        return 9; 
      if (paramInt1 < paramInt2)
        return 5; 
      if (paramInt1 % paramInt2 == 0)
        return 6; 
      if (++paramInt1 % paramInt2 == 0)
        return 7; 
      int i = paramInt3 % paramInt2;
      if (i == 0) {
        if (paramInt3 - paramInt1 < paramInt2)
          return 8; 
      } else if (paramInt3 - paramInt1 < i) {
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramBoolean3;
    this.h = paramBoolean4;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual getAdapter : ()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    //   4: astore #4
    //   6: aload #4
    //   8: ifnull -> 420
    //   11: aload #4
    //   13: invokevirtual getItemCount : ()I
    //   16: istore #5
    //   18: aload_0
    //   19: aload_3
    //   20: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView;)I
    //   23: istore #6
    //   25: aload_3
    //   26: aload_2
    //   27: invokevirtual getChildAdapterPosition : (Landroid/view/View;)I
    //   30: istore #7
    //   32: aload_0
    //   33: getfield m : I
    //   36: istore #8
    //   38: iconst_0
    //   39: istore #10
    //   41: iload #8
    //   43: iconst_5
    //   44: if_icmpeq -> 132
    //   47: iload #5
    //   49: iconst_1
    //   50: if_icmpne -> 77
    //   53: iload #8
    //   55: iconst_1
    //   56: if_icmpne -> 68
    //   59: iconst_0
    //   60: istore #9
    //   62: iconst_0
    //   63: istore #11
    //   65: goto -> 229
    //   68: iconst_1
    //   69: istore #9
    //   71: iconst_1
    //   72: istore #11
    //   74: goto -> 401
    //   77: iload #7
    //   79: ifne -> 103
    //   82: iload #8
    //   84: iconst_1
    //   85: if_icmpne -> 97
    //   88: iconst_0
    //   89: istore #9
    //   91: iconst_0
    //   92: istore #11
    //   94: goto -> 389
    //   97: iconst_1
    //   98: istore #9
    //   100: goto -> 398
    //   103: aload_3
    //   104: aload_2
    //   105: invokevirtual getChildAdapterPosition : (Landroid/view/View;)I
    //   108: iload #5
    //   110: iconst_1
    //   111: isub
    //   112: if_icmpne -> 395
    //   115: aload_0
    //   116: getfield m : I
    //   119: iconst_1
    //   120: if_icmpne -> 126
    //   123: goto -> 235
    //   126: iconst_0
    //   127: istore #9
    //   129: goto -> 71
    //   132: aload_0
    //   133: iload #7
    //   135: iload #6
    //   137: iload #5
    //   139: invokespecial a : (III)I
    //   142: tableswitch default -> 176, 5 -> 337, 6 -> 294, 7 -> 258, 8 -> 235, 9 -> 179
    //   176: goto -> 395
    //   179: aload_0
    //   180: iload #7
    //   182: iload #6
    //   184: iload #5
    //   186: invokespecial b : (III)I
    //   189: istore #5
    //   191: iload #5
    //   193: iconst_1
    //   194: if_icmpeq -> 215
    //   197: iload #5
    //   199: iconst_2
    //   200: if_icmpeq -> 209
    //   203: iconst_0
    //   204: istore #9
    //   206: goto -> 221
    //   209: iconst_1
    //   210: istore #9
    //   212: goto -> 221
    //   215: iconst_0
    //   216: istore #9
    //   218: iconst_1
    //   219: istore #10
    //   221: iload #9
    //   223: istore #11
    //   225: iload #10
    //   227: istore #9
    //   229: iconst_1
    //   230: istore #10
    //   232: goto -> 244
    //   235: iconst_0
    //   236: istore #9
    //   238: iconst_0
    //   239: istore #11
    //   241: iconst_0
    //   242: istore #10
    //   244: iconst_1
    //   245: istore #13
    //   247: iload #10
    //   249: istore #12
    //   251: iload #13
    //   253: istore #10
    //   255: goto -> 407
    //   258: aload_0
    //   259: iload #7
    //   261: iload #6
    //   263: iload #5
    //   265: invokespecial b : (III)I
    //   268: iconst_4
    //   269: if_icmpne -> 278
    //   272: iconst_1
    //   273: istore #9
    //   275: goto -> 281
    //   278: iconst_0
    //   279: istore #9
    //   281: iload #9
    //   283: istore #10
    //   285: iconst_0
    //   286: istore #9
    //   288: iconst_1
    //   289: istore #11
    //   291: goto -> 331
    //   294: aload_0
    //   295: iload #7
    //   297: iload #6
    //   299: iload #5
    //   301: invokespecial b : (III)I
    //   304: iconst_3
    //   305: if_icmpne -> 314
    //   308: iconst_1
    //   309: istore #9
    //   311: goto -> 317
    //   314: iconst_0
    //   315: istore #9
    //   317: iconst_1
    //   318: istore #12
    //   320: iconst_0
    //   321: istore #11
    //   323: iload #9
    //   325: istore #10
    //   327: iload #12
    //   329: istore #9
    //   331: iconst_0
    //   332: istore #12
    //   334: goto -> 407
    //   337: aload_0
    //   338: iload #7
    //   340: iload #6
    //   342: iload #5
    //   344: invokespecial b : (III)I
    //   347: istore #5
    //   349: iload #5
    //   351: iconst_1
    //   352: if_icmpeq -> 379
    //   355: iload #5
    //   357: iconst_2
    //   358: if_icmpeq -> 370
    //   361: iconst_0
    //   362: istore #9
    //   364: iconst_0
    //   365: istore #10
    //   367: goto -> 385
    //   370: iconst_0
    //   371: istore #9
    //   373: iconst_1
    //   374: istore #10
    //   376: goto -> 385
    //   379: iconst_1
    //   380: istore #9
    //   382: goto -> 364
    //   385: iload #10
    //   387: istore #11
    //   389: iconst_1
    //   390: istore #12
    //   392: goto -> 404
    //   395: iconst_0
    //   396: istore #9
    //   398: iconst_0
    //   399: istore #11
    //   401: iconst_0
    //   402: istore #12
    //   404: iconst_0
    //   405: istore #10
    //   407: aload_0
    //   408: aload_1
    //   409: iload #9
    //   411: iload #11
    //   413: iload #12
    //   415: iload #10
    //   417: invokespecial a : (Landroid/graphics/Rect;ZZZZ)V
    //   420: return
  }
  
  static interface ItemPos {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\SpacesItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */