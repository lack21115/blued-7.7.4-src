package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;

class GhostViewPort extends ViewGroup implements GhostView {
  ViewGroup a;
  
  View b;
  
  final View c;
  
  int d;
  
  private Matrix e;
  
  private final ViewTreeObserver.OnPreDrawListener f = new ViewTreeObserver.OnPreDrawListener(this) {
      public boolean onPreDraw() {
        ViewCompat.postInvalidateOnAnimation((View)this.a);
        if (this.a.a != null && this.a.b != null) {
          this.a.a.endViewTransition(this.a.b);
          ViewCompat.postInvalidateOnAnimation((View)this.a.a);
          GhostViewPort ghostViewPort = this.a;
          ghostViewPort.a = null;
          ghostViewPort.b = null;
        } 
        return true;
      }
    };
  
  GhostViewPort(View paramView) {
    super(paramView.getContext());
    this.c = paramView;
    setWillNotDraw(false);
    setLayerType(2, null);
  }
  
  static GhostViewPort a(View paramView) {
    return (GhostViewPort)paramView.getTag(R.id.ghost_view);
  }
  
  static void a(View paramView1, View paramView2) {
    ViewUtils.a(paramView2, paramView2.getLeft(), paramView2.getTop(), paramView2.getLeft() + paramView1.getWidth(), paramView2.getTop() + paramView1.getHeight());
  }
  
  static void a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix) {
    ViewGroup viewGroup = (ViewGroup)paramView.getParent();
    paramMatrix.reset();
    ViewUtils.a((View)viewGroup, paramMatrix);
    paramMatrix.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
    ViewUtils.b((View)paramViewGroup, paramMatrix);
  }
  
  static void a(View paramView, GhostViewPort paramGhostViewPort) {
    paramView.setTag(R.id.ghost_view, paramGhostViewPort);
  }
  
  static GhostViewPort b(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix) {
    if (paramView.getParent() instanceof ViewGroup) {
      Matrix matrix1;
      GhostViewPort ghostViewPort1;
      Matrix matrix2;
      GhostViewHolder ghostViewHolder = GhostViewHolder.a(paramViewGroup);
      GhostViewPort ghostViewPort3 = a(paramView);
      byte b = 0;
      GhostViewPort ghostViewPort2 = ghostViewPort3;
      int i = b;
      if (ghostViewPort3 != null) {
        GhostViewHolder ghostViewHolder1 = (GhostViewHolder)ghostViewPort3.getParent();
        ghostViewPort2 = ghostViewPort3;
        i = b;
        if (ghostViewHolder1 != ghostViewHolder) {
          i = ghostViewPort3.d;
          ghostViewHolder1.removeView((View)ghostViewPort3);
          ghostViewPort2 = null;
        } 
      } 
      if (ghostViewPort2 == null) {
        GhostViewHolder ghostViewHolder1;
        matrix2 = paramMatrix;
        if (paramMatrix == null) {
          matrix2 = new Matrix();
          a(paramView, paramViewGroup, matrix2);
        } 
        ghostViewPort1 = new GhostViewPort(paramView);
        ghostViewPort1.a(matrix2);
        if (ghostViewHolder == null) {
          ghostViewHolder1 = new GhostViewHolder(paramViewGroup);
        } else {
          ghostViewHolder.a();
          ghostViewHolder1 = ghostViewHolder;
        } 
        a((View)paramViewGroup, (View)ghostViewHolder1);
        a((View)paramViewGroup, (View)ghostViewPort1);
        ghostViewHolder1.a(ghostViewPort1);
        ghostViewPort1.d = i;
        GhostViewPort ghostViewPort = ghostViewPort1;
      } else {
        matrix1 = matrix2;
        if (ghostViewPort1 != null) {
          matrix2.a((Matrix)ghostViewPort1);
          matrix1 = matrix2;
        } 
      } 
      ((GhostViewPort)matrix1).d++;
      return (GhostViewPort)matrix1;
    } 
    throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
  }
  
  static void b(View paramView) {
    GhostViewPort ghostViewPort = a(paramView);
    if (ghostViewPort != null) {
      ghostViewPort.d--;
      if (ghostViewPort.d <= 0)
        ((GhostViewHolder)ghostViewPort.getParent()).removeView((View)ghostViewPort); 
    } 
  }
  
  void a(Matrix paramMatrix) {
    this.e = paramMatrix;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    a(this.c, this);
    this.c.getViewTreeObserver().addOnPreDrawListener(this.f);
    ViewUtils.a(this.c, 4);
    if (this.c.getParent() != null)
      ((View)this.c.getParent()).invalidate(); 
  }
  
  protected void onDetachedFromWindow() {
    this.c.getViewTreeObserver().removeOnPreDrawListener(this.f);
    ViewUtils.a(this.c, 0);
    a(this.c, (GhostViewPort)null);
    if (this.c.getParent() != null)
      ((View)this.c.getParent()).invalidate(); 
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    CanvasUtils.a(paramCanvas, true);
    paramCanvas.setMatrix(this.e);
    ViewUtils.a(this.c, 0);
    this.c.invalidate();
    ViewUtils.a(this.c, 4);
    drawChild(paramCanvas, this.c, getDrawingTime());
    CanvasUtils.a(paramCanvas, false);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void reserveEndViewTransition(ViewGroup paramViewGroup, View paramView) {
    this.a = paramViewGroup;
    this.b = paramView;
  }
  
  public void setVisibility(int paramInt) {
    super.setVisibility(paramInt);
    if (a(this.c) == this) {
      if (paramInt == 0) {
        paramInt = 4;
      } else {
        paramInt = 0;
      } 
      ViewUtils.a(this.c, paramInt);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\GhostViewPort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */