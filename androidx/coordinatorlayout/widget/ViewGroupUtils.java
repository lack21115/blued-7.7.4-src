package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ViewGroupUtils {
  private static final ThreadLocal<Matrix> a = new ThreadLocal<Matrix>();
  
  private static final ThreadLocal<RectF> b = new ThreadLocal<RectF>();
  
  static void a(ViewGroup paramViewGroup, View paramView, Rect paramRect) {
    Matrix matrix = a.get();
    if (matrix == null) {
      matrix = new Matrix();
      a.set(matrix);
    } else {
      matrix.reset();
    } 
    a((ViewParent)paramViewGroup, paramView, matrix);
    RectF rectF2 = b.get();
    RectF rectF1 = rectF2;
    if (rectF2 == null) {
      rectF1 = new RectF();
      b.set(rectF1);
    } 
    rectF1.set(paramRect);
    matrix.mapRect(rectF1);
    paramRect.set((int)(rectF1.left + 0.5F), (int)(rectF1.top + 0.5F), (int)(rectF1.right + 0.5F), (int)(rectF1.bottom + 0.5F));
  }
  
  private static void a(ViewParent paramViewParent, View paramView, Matrix paramMatrix) {
    ViewParent viewParent = paramView.getParent();
    if (viewParent instanceof View && viewParent != paramViewParent) {
      View view = (View)viewParent;
      a(paramViewParent, view, paramMatrix);
      paramMatrix.preTranslate(-view.getScrollX(), -view.getScrollY());
    } 
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    if (!paramView.getMatrix().isIdentity())
      paramMatrix.preConcat(paramView.getMatrix()); 
  }
  
  public static void getDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect) {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    a(paramViewGroup, paramView, paramRect);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\coordinatorlayout\widget\ViewGroupUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */