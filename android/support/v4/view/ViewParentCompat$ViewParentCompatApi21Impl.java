package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

final class ViewParentCompat$ViewParentCompatApi21Impl extends ViewParentCompat$ViewParentCompatApi19Impl {
  public final boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    try {
      return paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedFling");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return false;
    } 
  }
  
  public final boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2) {
    try {
      return paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedPreFling");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return false;
    } 
  }
  
  public final void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    try {
      paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfint);
      return;
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedPreScroll");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return;
    } 
  }
  
  public final void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    try {
      paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedScroll");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return;
    } 
  }
  
  public final void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    try {
      paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt);
      return;
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedScrollAccepted");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return;
    } 
  }
  
  public final boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    try {
      return paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onStartNestedScroll");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return false;
    } 
  }
  
  public final void onStopNestedScroll(ViewParent paramViewParent, View paramView) {
    try {
      paramViewParent.onStopNestedScroll(paramView);
      return;
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onStopNestedScroll");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ViewParentCompat$ViewParentCompatApi21Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */