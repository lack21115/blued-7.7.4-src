package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

public abstract class CustomTarget<T> implements Target<T> {
  private final int a;
  
  private final int b;
  
  private Request c;
  
  public CustomTarget() {
    this(-2147483648, -2147483648);
  }
  
  public CustomTarget(int paramInt1, int paramInt2) {
    if (Util.a(paramInt1, paramInt2)) {
      this.a = paramInt1;
      this.b = paramInt2;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" and height: ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final Request a() {
    return this.c;
  }
  
  public void a(Drawable paramDrawable) {}
  
  public final void a(Request paramRequest) {
    this.c = paramRequest;
  }
  
  public final void a(SizeReadyCallback paramSizeReadyCallback) {
    paramSizeReadyCallback.a(this.a, this.b);
  }
  
  public void b(Drawable paramDrawable) {}
  
  public final void b(SizeReadyCallback paramSizeReadyCallback) {}
  
  public void o_() {}
  
  public void p_() {}
  
  public void q_() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\CustomTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */