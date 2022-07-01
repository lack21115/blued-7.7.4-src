package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExpandedLinearLayoutManager extends LinearLayoutManager {
  private int a = -1;
  
  public ExpandedLinearLayoutManager(Context paramContext) {
    super(paramContext);
  }
  
  public ExpandedLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private int[] a(RecyclerView.Recycler paramRecycler, int paramInt) {
    try {
      View view = paramRecycler.getViewForPosition(paramInt);
      measureChildWithMargins(view, 0, 0);
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
      paramInt = getDecoratedMeasuredWidth(view);
      int i = layoutParams.leftMargin;
      int j = layoutParams.rightMargin;
      int k = getDecoratedMeasuredHeight(view);
      int m = layoutParams.bottomMargin;
      int n = layoutParams.topMargin;
      return new int[] { paramInt + i + j, k + m + n };
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_3
    //   1: invokestatic getMode : (I)I
    //   4: istore #9
    //   6: iload #4
    //   8: invokestatic getMode : (I)I
    //   11: istore #10
    //   13: iload_3
    //   14: invokestatic getSize : (I)I
    //   17: istore #6
    //   19: iload #4
    //   21: invokestatic getSize : (I)I
    //   24: istore #5
    //   26: aload_0
    //   27: getfield a : I
    //   30: iflt -> 53
    //   33: aload_0
    //   34: invokevirtual getItemCount : ()I
    //   37: istore #4
    //   39: aload_0
    //   40: getfield a : I
    //   43: istore_3
    //   44: iload_3
    //   45: istore #7
    //   47: iload #4
    //   49: iload_3
    //   50: if_icmpge -> 59
    //   53: aload_0
    //   54: invokevirtual getItemCount : ()I
    //   57: istore #7
    //   59: iconst_0
    //   60: istore #8
    //   62: iconst_0
    //   63: istore #4
    //   65: iconst_0
    //   66: istore_3
    //   67: iload #8
    //   69: iload #7
    //   71: if_icmpge -> 145
    //   74: aload_0
    //   75: aload_1
    //   76: iload #8
    //   78: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$Recycler;I)[I
    //   81: astore_2
    //   82: aload_2
    //   83: ifnull -> 144
    //   86: aload_2
    //   87: arraylength
    //   88: iconst_2
    //   89: if_icmpeq -> 93
    //   92: return
    //   93: aload_0
    //   94: invokevirtual getOrientation : ()I
    //   97: ifne -> 119
    //   100: iload_3
    //   101: aload_2
    //   102: iconst_0
    //   103: iaload
    //   104: iadd
    //   105: istore_3
    //   106: iload #4
    //   108: aload_2
    //   109: iconst_1
    //   110: iaload
    //   111: invokestatic max : (II)I
    //   114: istore #4
    //   116: goto -> 135
    //   119: iload #4
    //   121: aload_2
    //   122: iconst_1
    //   123: iaload
    //   124: iadd
    //   125: istore #4
    //   127: iload_3
    //   128: aload_2
    //   129: iconst_0
    //   130: iaload
    //   131: invokestatic max : (II)I
    //   134: istore_3
    //   135: iload #8
    //   137: iconst_1
    //   138: iadd
    //   139: istore #8
    //   141: goto -> 67
    //   144: return
    //   145: iload #10
    //   147: ldc 1073741824
    //   149: if_icmpne -> 156
    //   152: iload #5
    //   154: istore #4
    //   156: iload #9
    //   158: ldc 1073741824
    //   160: if_icmpne -> 166
    //   163: iload #6
    //   165: istore_3
    //   166: aload_0
    //   167: invokevirtual getOrientation : ()I
    //   170: iconst_1
    //   171: if_icmpne -> 191
    //   174: iload_3
    //   175: iload #6
    //   177: if_icmple -> 191
    //   180: iload #6
    //   182: istore #7
    //   184: iload #4
    //   186: istore #6
    //   188: goto -> 226
    //   191: iload #4
    //   193: istore #6
    //   195: iload_3
    //   196: istore #7
    //   198: aload_0
    //   199: invokevirtual getOrientation : ()I
    //   202: ifne -> 226
    //   205: iload #4
    //   207: istore #6
    //   209: iload_3
    //   210: istore #7
    //   212: iload #4
    //   214: iload #5
    //   216: if_icmple -> 226
    //   219: iload_3
    //   220: istore #7
    //   222: iload #5
    //   224: istore #6
    //   226: aload_0
    //   227: iload #7
    //   229: iload #6
    //   231: invokevirtual setMeasuredDimension : (II)V
    //   234: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ExpandedLinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */