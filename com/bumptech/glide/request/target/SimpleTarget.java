package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

@Deprecated
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
  private final int a;
  
  private final int b;
  
  public SimpleTarget() {
    this(-2147483648, -2147483648);
  }
  
  public SimpleTarget(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final void a(SizeReadyCallback paramSizeReadyCallback) {
    if (Util.a(this.a, this.b)) {
      paramSizeReadyCallback.a(this.a, this.b);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
    stringBuilder.append(this.a);
    stringBuilder.append(" and height: ");
    stringBuilder.append(this.b);
    stringBuilder.append(", either provide dimensions in the constructor or call override()");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void b(SizeReadyCallback paramSizeReadyCallback) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\SimpleTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */