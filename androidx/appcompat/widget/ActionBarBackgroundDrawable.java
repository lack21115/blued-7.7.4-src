package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class ActionBarBackgroundDrawable extends Drawable {
  final ActionBarContainer a;
  
  public ActionBarBackgroundDrawable(ActionBarContainer paramActionBarContainer) {
    this.a = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.a.d) {
      if (this.a.c != null) {
        this.a.c.draw(paramCanvas);
        return;
      } 
    } else {
      if (this.a.a != null)
        this.a.a.draw(paramCanvas); 
      if (this.a.b != null && this.a.e)
        this.a.b.draw(paramCanvas); 
    } 
  }
  
  public int getOpacity() {
    return 0;
  }
  
  public void getOutline(Outline paramOutline) {
    if (this.a.d) {
      if (this.a.c != null) {
        this.a.c.getOutline(paramOutline);
        return;
      } 
    } else if (this.a.a != null) {
      this.a.a.getOutline(paramOutline);
    } 
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ActionBarBackgroundDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */