package com.blued.android.core.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;

public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
  GlideRequest(Glide paramGlide, RequestManager paramRequestManager, Class<TranscodeType> paramClass, Context paramContext) {
    super(paramGlide, paramRequestManager, paramClass, paramContext);
  }
  
  public GlideRequest<TranscodeType> a() {
    return (GlideRequest<TranscodeType>)super.k();
  }
  
  public GlideRequest<TranscodeType> a(float paramFloat) {
    return (GlideRequest<TranscodeType>)super.b(paramFloat);
  }
  
  public GlideRequest<TranscodeType> a(int paramInt) {
    return (GlideRequest<TranscodeType>)super.h(paramInt);
  }
  
  public GlideRequest<TranscodeType> a(int paramInt1, int paramInt2) {
    return (GlideRequest<TranscodeType>)super.b(paramInt1, paramInt2);
  }
  
  public GlideRequest<TranscodeType> a(Drawable paramDrawable) {
    return (GlideRequest<TranscodeType>)super.b(paramDrawable);
  }
  
  public GlideRequest<TranscodeType> a(Uri paramUri) {
    return (GlideRequest<TranscodeType>)super.b(paramUri);
  }
  
  public GlideRequest<TranscodeType> a(Priority paramPriority) {
    return (GlideRequest<TranscodeType>)super.b(paramPriority);
  }
  
  public GlideRequest<TranscodeType> a(RequestBuilder<TranscodeType> paramRequestBuilder) {
    return (GlideRequest<TranscodeType>)super.b(paramRequestBuilder);
  }
  
  public GlideRequest<TranscodeType> a(TransitionOptions<?, ? super TranscodeType> paramTransitionOptions) {
    return (GlideRequest<TranscodeType>)super.b(paramTransitionOptions);
  }
  
  public GlideRequest<TranscodeType> a(Key paramKey) {
    return (GlideRequest<TranscodeType>)super.b(paramKey);
  }
  
  public <Y> GlideRequest<TranscodeType> a(Option<Y> paramOption, Y paramY) {
    return (GlideRequest<TranscodeType>)super.b(paramOption, paramY);
  }
  
  public GlideRequest<TranscodeType> a(Transformation<Bitmap> paramTransformation) {
    return (GlideRequest<TranscodeType>)super.b(paramTransformation);
  }
  
  public GlideRequest<TranscodeType> a(DiskCacheStrategy paramDiskCacheStrategy) {
    return (GlideRequest<TranscodeType>)super.b(paramDiskCacheStrategy);
  }
  
  public GlideRequest<TranscodeType> a(DownsampleStrategy paramDownsampleStrategy) {
    return (GlideRequest<TranscodeType>)super.b(paramDownsampleStrategy);
  }
  
  public GlideRequest<TranscodeType> a(BaseRequestOptions<?> paramBaseRequestOptions) {
    return (GlideRequest<TranscodeType>)super.c(paramBaseRequestOptions);
  }
  
  public GlideRequest<TranscodeType> a(RequestListener<TranscodeType> paramRequestListener) {
    return (GlideRequest<TranscodeType>)super.d(paramRequestListener);
  }
  
  public GlideRequest<TranscodeType> a(File paramFile) {
    return (GlideRequest<TranscodeType>)super.b(paramFile);
  }
  
  public GlideRequest<TranscodeType> a(Class<?> paramClass) {
    return (GlideRequest<TranscodeType>)super.b(paramClass);
  }
  
  public GlideRequest<TranscodeType> a(Integer paramInteger) {
    return (GlideRequest<TranscodeType>)super.b(paramInteger);
  }
  
  public GlideRequest<TranscodeType> a(Object paramObject) {
    return (GlideRequest<TranscodeType>)super.b(paramObject);
  }
  
  public GlideRequest<TranscodeType> a(String paramString) {
    return (GlideRequest<TranscodeType>)super.b(paramString);
  }
  
  public GlideRequest<TranscodeType> a(boolean paramBoolean) {
    return (GlideRequest<TranscodeType>)super.f(paramBoolean);
  }
  
  public GlideRequest<TranscodeType> a(Transformation<Bitmap>... paramVarArgs) {
    return (GlideRequest<TranscodeType>)super.b((Transformation[])paramVarArgs);
  }
  
  public GlideRequest<TranscodeType> b() {
    return (GlideRequest<TranscodeType>)super.j();
  }
  
  public GlideRequest<TranscodeType> b(int paramInt) {
    return (GlideRequest<TranscodeType>)super.g(paramInt);
  }
  
  public GlideRequest<TranscodeType> b(RequestListener<TranscodeType> paramRequestListener) {
    return (GlideRequest<TranscodeType>)super.c(paramRequestListener);
  }
  
  public GlideRequest<TranscodeType> b(boolean paramBoolean) {
    return (GlideRequest<TranscodeType>)super.e(paramBoolean);
  }
  
  public GlideRequest<TranscodeType> c() {
    return (GlideRequest<TranscodeType>)super.i();
  }
  
  public GlideRequest<TranscodeType> c(int paramInt) {
    return (GlideRequest<TranscodeType>)super.f(paramInt);
  }
  
  public GlideRequest<TranscodeType> c(boolean paramBoolean) {
    return (GlideRequest<TranscodeType>)super.d(paramBoolean);
  }
  
  public GlideRequest<TranscodeType> d() {
    return (GlideRequest<TranscodeType>)super.e();
  }
  
  public GlideRequest<TranscodeType> d(int paramInt) {
    return (GlideRequest<TranscodeType>)super.e(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\GlideRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */