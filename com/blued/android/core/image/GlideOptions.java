package com.blued.android.core.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

public final class GlideOptions extends RequestOptions implements Cloneable {
  public GlideOptions a() {
    return (GlideOptions)super.l();
  }
  
  public GlideOptions a(float paramFloat) {
    return (GlideOptions)super.b(paramFloat);
  }
  
  public GlideOptions a(int paramInt) {
    return (GlideOptions)super.h(paramInt);
  }
  
  public GlideOptions a(int paramInt1, int paramInt2) {
    return (GlideOptions)super.b(paramInt1, paramInt2);
  }
  
  public GlideOptions a(Drawable paramDrawable) {
    return (GlideOptions)super.b(paramDrawable);
  }
  
  public GlideOptions a(Priority paramPriority) {
    return (GlideOptions)super.b(paramPriority);
  }
  
  public GlideOptions a(Key paramKey) {
    return (GlideOptions)super.b(paramKey);
  }
  
  public <Y> GlideOptions a(Option<Y> paramOption, Y paramY) {
    return (GlideOptions)super.b(paramOption, paramY);
  }
  
  public GlideOptions a(Transformation<Bitmap> paramTransformation) {
    return (GlideOptions)super.b(paramTransformation);
  }
  
  public GlideOptions a(DiskCacheStrategy paramDiskCacheStrategy) {
    return (GlideOptions)super.b(paramDiskCacheStrategy);
  }
  
  public GlideOptions a(DownsampleStrategy paramDownsampleStrategy) {
    return (GlideOptions)super.b(paramDownsampleStrategy);
  }
  
  public GlideOptions a(BaseRequestOptions<?> paramBaseRequestOptions) {
    return (GlideOptions)super.b(paramBaseRequestOptions);
  }
  
  public GlideOptions a(Class<?> paramClass) {
    return (GlideOptions)super.b(paramClass);
  }
  
  public GlideOptions a(boolean paramBoolean) {
    return (GlideOptions)super.f(paramBoolean);
  }
  
  @SafeVarargs
  public final GlideOptions a(Transformation<Bitmap>... paramVarArgs) {
    return (GlideOptions)super.b((Transformation[])paramVarArgs);
  }
  
  public GlideOptions b() {
    return (GlideOptions)super.k();
  }
  
  public GlideOptions b(int paramInt) {
    return (GlideOptions)super.g(paramInt);
  }
  
  public GlideOptions b(boolean paramBoolean) {
    return (GlideOptions)super.e(paramBoolean);
  }
  
  public GlideOptions c() {
    return (GlideOptions)super.j();
  }
  
  public GlideOptions c(int paramInt) {
    return (GlideOptions)super.f(paramInt);
  }
  
  public GlideOptions c(boolean paramBoolean) {
    return (GlideOptions)super.d(paramBoolean);
  }
  
  public GlideOptions d() {
    return (GlideOptions)super.i();
  }
  
  public GlideOptions d(int paramInt) {
    return (GlideOptions)super.e(paramInt);
  }
  
  public GlideOptions e() {
    return (GlideOptions)super.h();
  }
  
  public GlideOptions f() {
    return (GlideOptions)super.g();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\GlideOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */