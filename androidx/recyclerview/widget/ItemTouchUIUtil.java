package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

public interface ItemTouchUIUtil {
  void clearView(View paramView);
  
  void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  void onSelected(View paramView);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\ItemTouchUIUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */