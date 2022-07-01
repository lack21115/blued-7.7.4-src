package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

public final class ViewParentCompat {
  private static ViewParentCompat$ViewParentCompatBaseImpl IMPL = new ViewParentCompat$ViewParentCompatBaseImpl();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return IMPL.onNestedFling(paramViewParent, paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2) {
    return IMPL.onNestedPreFling(paramViewParent, paramView, paramFloat1, paramFloat2);
  }
  
  public static void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
    if (!(paramViewParent instanceof NestedScrollingParent2) && paramInt3 == 0)
      IMPL.onNestedPreScroll(paramViewParent, paramView, paramInt1, paramInt2, paramArrayOfint); 
  }
  
  public static void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (!(paramViewParent instanceof NestedScrollingParent2) && paramInt5 == 0)
      IMPL.onNestedScroll(paramViewParent, paramView, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public static void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2) {
    if (!(paramViewParent instanceof NestedScrollingParent2) && paramInt2 == 0)
      IMPL.onNestedScrollAccepted(paramViewParent, paramView1, paramView2, paramInt1); 
  }
  
  public static boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2) {
    return (paramViewParent instanceof NestedScrollingParent2) ? ((NestedScrollingParent2)paramViewParent).onStartNestedScroll$6516cd99() : ((paramInt2 == 0) ? IMPL.onStartNestedScroll(paramViewParent, paramView1, paramView2, paramInt1) : false);
  }
  
  public static void onStopNestedScroll(ViewParent paramViewParent, View paramView, int paramInt) {
    if (!(paramViewParent instanceof NestedScrollingParent2) && paramInt == 0)
      IMPL.onStopNestedScroll(paramViewParent, paramView); 
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new ViewParentCompat$ViewParentCompatApi21Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new ViewParentCompat$ViewParentCompatApi19Impl();
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ViewParentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */