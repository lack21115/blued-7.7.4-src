package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zad extends zaa {
  private WeakReference<ImageManager.OnImageLoadedListener> zac;
  
  public zad(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri) {
    super(paramUri, 0);
    Asserts.checkNotNull(paramOnImageLoadedListener);
    this.zac = new WeakReference<ImageManager.OnImageLoadedListener>(paramOnImageLoadedListener);
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zad))
      return false; 
    paramObject = paramObject;
    ImageManager.OnImageLoadedListener onImageLoadedListener1 = this.zac.get();
    ImageManager.OnImageLoadedListener onImageLoadedListener2 = ((zad)paramObject).zac.get();
    return (onImageLoadedListener2 != null && onImageLoadedListener1 != null && Objects.equal(onImageLoadedListener2, onImageLoadedListener1) && Objects.equal(((zad)paramObject).zaa, this.zaa));
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.zaa });
  }
  
  protected final void zaa(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (!paramBoolean2) {
      ImageManager.OnImageLoadedListener onImageLoadedListener = this.zac.get();
      if (onImageLoadedListener != null)
        onImageLoadedListener.onImageLoaded(this.zaa.zaa, paramDrawable, paramBoolean3); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\images\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */