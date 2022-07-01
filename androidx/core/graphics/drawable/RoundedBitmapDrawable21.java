package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
  protected RoundedBitmapDrawable21(Resources paramResources, Bitmap paramBitmap) {
    super(paramResources, paramBitmap);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2) {
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
  }
  
  public void getOutline(Outline paramOutline) {
    a();
    paramOutline.setRoundRect(this.b, getCornerRadius());
  }
  
  public boolean hasMipMap() {
    return (this.a != null && this.a.hasMipMap());
  }
  
  public void setMipMap(boolean paramBoolean) {
    if (this.a != null) {
      this.a.setHasMipMap(paramBoolean);
      invalidateSelf();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\drawable\RoundedBitmapDrawable21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */