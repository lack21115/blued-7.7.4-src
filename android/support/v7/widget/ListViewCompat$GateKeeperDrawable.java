package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.drawable.DrawableWrapper;

final class ListViewCompat$GateKeeperDrawable extends DrawableWrapper {
  boolean mEnabled = true;
  
  public ListViewCompat$GateKeeperDrawable(Drawable paramDrawable) {
    super(paramDrawable);
  }
  
  public final void draw(Canvas paramCanvas) {
    if (this.mEnabled)
      super.draw(paramCanvas); 
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2) {
    if (this.mEnabled)
      super.setHotspot(paramFloat1, paramFloat2); 
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.mEnabled)
      super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public final boolean setState(int[] paramArrayOfint) {
    return this.mEnabled ? super.setState(paramArrayOfint) : false;
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    return this.mEnabled ? super.setVisible(paramBoolean1, paramBoolean2) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ListViewCompat$GateKeeperDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */