package androidx.core.graphics;

import android.graphics.Rect;

public final class Insets {
  public static final Insets NONE = new Insets(0, 0, 0, 0);
  
  public final int bottom;
  
  public final int left;
  
  public final int right;
  
  public final int top;
  
  private Insets(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.left = paramInt1;
    this.top = paramInt2;
    this.right = paramInt3;
    this.bottom = paramInt4;
  }
  
  public static Insets of(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramInt1 == 0 && paramInt2 == 0 && paramInt3 == 0 && paramInt4 == 0) ? NONE : new Insets(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static Insets of(Rect paramRect) {
    return of(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public static Insets wrap(android.graphics.Insets paramInsets) {
    return of(paramInsets.left, paramInsets.top, paramInsets.right, paramInsets.bottom);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.bottom != ((Insets)paramObject).bottom) ? false : ((this.left != ((Insets)paramObject).left) ? false : ((this.right != ((Insets)paramObject).right) ? false : (!(this.top != ((Insets)paramObject).top))));
    } 
    return false;
  }
  
  public int hashCode() {
    return ((this.left * 31 + this.top) * 31 + this.right) * 31 + this.bottom;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Insets{left=");
    stringBuilder.append(this.left);
    stringBuilder.append(", top=");
    stringBuilder.append(this.top);
    stringBuilder.append(", right=");
    stringBuilder.append(this.right);
    stringBuilder.append(", bottom=");
    stringBuilder.append(this.bottom);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\Insets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */