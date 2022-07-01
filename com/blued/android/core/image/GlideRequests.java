package com.blued.android.core.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;

public class GlideRequests extends RequestManager {
  public GlideRequests(Glide paramGlide, Lifecycle paramLifecycle, RequestManagerTreeNode paramRequestManagerTreeNode, Context paramContext) {
    super(paramGlide, paramLifecycle, paramRequestManagerTreeNode, paramContext);
  }
  
  public GlideRequest<Bitmap> a() {
    return (GlideRequest<Bitmap>)super.f();
  }
  
  public <ResourceType> GlideRequest<ResourceType> a(Class<ResourceType> paramClass) {
    return new GlideRequest<ResourceType>(this.a, this, paramClass, this.b);
  }
  
  public GlideRequest<Drawable> a(Integer paramInteger) {
    return (GlideRequest<Drawable>)super.b(paramInteger);
  }
  
  public GlideRequest<Drawable> a(String paramString) {
    return (GlideRequest<Drawable>)super.b(paramString);
  }
  
  public void a(RequestOptions paramRequestOptions) {
    if (paramRequestOptions instanceof GlideOptions) {
      super.a(paramRequestOptions);
      return;
    } 
    super.a((new GlideOptions()).a((BaseRequestOptions<?>)paramRequestOptions));
  }
  
  public GlideRequest<Drawable> b() {
    return (GlideRequest<Drawable>)super.e();
  }
  
  public GlideRequest<File> c() {
    return (GlideRequest<File>)super.d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\GlideRequests.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */