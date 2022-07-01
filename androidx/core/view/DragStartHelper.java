package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

public class DragStartHelper {
  private final View a;
  
  private final OnDragStartListener b;
  
  private int c;
  
  private int d;
  
  private boolean e;
  
  private final View.OnLongClickListener f = new View.OnLongClickListener(this) {
      public boolean onLongClick(View param1View) {
        return this.a.onLongClick(param1View);
      }
    };
  
  private final View.OnTouchListener g = new View.OnTouchListener(this) {
      public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
        return this.a.onTouch(param1View, param1MotionEvent);
      }
    };
  
  public DragStartHelper(View paramView, OnDragStartListener paramOnDragStartListener) {
    this.a = paramView;
    this.b = paramOnDragStartListener;
  }
  
  public void attach() {
    this.a.setOnLongClickListener(this.f);
    this.a.setOnTouchListener(this.g);
  }
  
  public void detach() {
    this.a.setOnLongClickListener(null);
    this.a.setOnTouchListener(null);
  }
  
  public void getTouchPosition(Point paramPoint) {
    paramPoint.set(this.c, this.d);
  }
  
  public boolean onLongClick(View paramView) {
    return this.b.onDragStart(paramView, this);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if (k != 0) {
      if (k != 1)
        if (k != 2) {
          if (k != 3)
            return false; 
        } else {
          if (MotionEventCompat.isFromSource(paramMotionEvent, 8194)) {
            if ((paramMotionEvent.getButtonState() & 0x1) == 0)
              return false; 
            if (this.e)
              return false; 
            if (this.c == i && this.d == j)
              return false; 
            this.c = i;
            this.d = j;
            this.e = this.b.onDragStart(paramView, this);
            return this.e;
          } 
          return false;
        }  
      this.e = false;
      return false;
    } 
    this.c = i;
    this.d = j;
    return false;
  }
  
  public static interface OnDragStartListener {
    boolean onDragStart(View param1View, DragStartHelper param1DragStartHelper);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\DragStartHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */