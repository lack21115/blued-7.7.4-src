package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
  static final ItemTouchUIUtil a = new ItemTouchUIUtilImpl();
  
  private static float a(RecyclerView paramRecyclerView, View paramView) {
    int j = paramRecyclerView.getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j) {
      float f1;
      View view = paramRecyclerView.getChildAt(i);
      if (view == paramView) {
        f1 = f;
      } else {
        float f2 = ViewCompat.getElevation(view);
        f1 = f;
        if (f2 > f)
          f1 = f2; 
      } 
      i++;
      f = f1;
    } 
    return f;
  }
  
  public void clearView(View paramView) {
    if (Build.VERSION.SDK_INT >= 21) {
      Object object = paramView.getTag(R.id.item_touch_helper_previous_elevation);
      if (object instanceof Float)
        ViewCompat.setElevation(paramView, ((Float)object).floatValue()); 
      paramView.setTag(R.id.item_touch_helper_previous_elevation, null);
    } 
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 21 && paramBoolean && paramView.getTag(R.id.item_touch_helper_previous_elevation) == null) {
      float f = ViewCompat.getElevation(paramView);
      ViewCompat.setElevation(paramView, a(paramRecyclerView, paramView) + 1.0F);
      paramView.setTag(R.id.item_touch_helper_previous_elevation, Float.valueOf(f));
    } 
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean) {}
  
  public void onSelected(View paramView) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\ItemTouchUIUtilImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */