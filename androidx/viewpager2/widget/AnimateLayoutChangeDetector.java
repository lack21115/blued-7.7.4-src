package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class AnimateLayoutChangeDetector {
  private static final ViewGroup.MarginLayoutParams a = new ViewGroup.MarginLayoutParams(-1, -1);
  
  private LinearLayoutManager b;
  
  static {
    a.setMargins(0, 0, 0, 0);
  }
  
  AnimateLayoutChangeDetector(LinearLayoutManager paramLinearLayoutManager) {
    this.b = paramLinearLayoutManager;
  }
  
  private static boolean a(View paramView) {
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
      if (layoutTransition != null && layoutTransition.isChangingLayout())
        return true; 
      int j = viewGroup.getChildCount();
      for (int i = 0; i < j; i++) {
        if (a(viewGroup.getChildAt(i)))
          return true; 
      } 
    } 
    return false;
  }
  
  private boolean b() {
    int k = this.b.getChildCount();
    if (k == 0)
      return true; 
    if (this.b.getOrientation() == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    int[][] arrayOfInt = (int[][])Array.newInstance(int.class, new int[] { k, 2 });
    int j = 0;
    while (j < k) {
      View view = this.b.getChildAt(j);
      if (view != null) {
        int m;
        int n;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
          marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
        } else {
          marginLayoutParams = a;
        } 
        int[] arrayOfInt1 = arrayOfInt[j];
        if (i) {
          m = view.getLeft();
          n = marginLayoutParams.leftMargin;
        } else {
          m = view.getTop();
          n = marginLayoutParams.topMargin;
        } 
        arrayOfInt1[0] = m - n;
        arrayOfInt1 = arrayOfInt[j];
        if (i) {
          m = view.getRight();
          n = marginLayoutParams.rightMargin;
        } else {
          m = view.getBottom();
          n = marginLayoutParams.bottomMargin;
        } 
        arrayOfInt1[1] = m + n;
        j++;
        continue;
      } 
      throw new IllegalStateException("null view contained in the view hierarchy");
    } 
    Arrays.sort(arrayOfInt, (Comparator)new Comparator<int[]>(this) {
          public int compare(int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
            return param1ArrayOfint1[0] - param1ArrayOfint2[0];
          }
        });
    int i;
    for (i = 1; i < k; i++) {
      if (arrayOfInt[i - 1][1] != arrayOfInt[i][0])
        return false; 
    } 
    i = arrayOfInt[0][1];
    j = arrayOfInt[0][0];
    return (arrayOfInt[0][0] <= 0) ? (!(arrayOfInt[k - 1][1] < i - j)) : false;
  }
  
  private boolean c() {
    int j = this.b.getChildCount();
    for (int i = 0; i < j; i++) {
      if (a(this.b.getChildAt(i)))
        return true; 
    } 
    return false;
  }
  
  boolean a() {
    return ((!b() || this.b.getChildCount() <= 1) && c());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\widget\AnimateLayoutChangeDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */