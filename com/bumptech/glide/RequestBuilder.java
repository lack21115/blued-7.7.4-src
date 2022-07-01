package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements ModelTypes<RequestBuilder<TranscodeType>>, Cloneable {
  protected static final RequestOptions a = (RequestOptions)((RequestOptions)((RequestOptions)(new RequestOptions()).b(DiskCacheStrategy.c)).b(Priority.d)).d(true);
  
  private final Context b;
  
  private final RequestManager c;
  
  private final Class<TranscodeType> d;
  
  private final Glide e;
  
  private final GlideContext f;
  
  private TransitionOptions<?, ? super TranscodeType> g;
  
  private Object h;
  
  private List<RequestListener<TranscodeType>> i;
  
  private RequestBuilder<TranscodeType> j;
  
  private RequestBuilder<TranscodeType> k;
  
  private Float l;
  
  private boolean m = true;
  
  private boolean n;
  
  private boolean o;
  
  public RequestBuilder(Glide paramGlide, RequestManager paramRequestManager, Class<TranscodeType> paramClass, Context paramContext) {
    this.e = paramGlide;
    this.c = paramRequestManager;
    this.d = paramClass;
    this.b = paramContext;
    this.g = paramRequestManager.c(paramClass);
    this.f = paramGlide.e();
    a(paramRequestManager.k());
    c((BaseRequestOptions<?>)paramRequestManager.l());
  }
  
  private Priority a(Priority paramPriority) {
    int i = null.b[paramPriority.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i == 3 || i == 4)
          return Priority.a; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unknown priority: ");
        stringBuilder.append(D());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return Priority.b;
    } 
    return Priority.c;
  }
  
  private RequestBuilder<TranscodeType> a(Object paramObject) {
    this.h = paramObject;
    this.n = true;
    return this;
  }
  
  private Request a(Object paramObject, Target<TranscodeType> paramTarget, RequestListener<TranscodeType> paramRequestListener, BaseRequestOptions<?> paramBaseRequestOptions, RequestCoordinator paramRequestCoordinator, TransitionOptions<?, ? super TranscodeType> paramTransitionOptions, Priority paramPriority, int paramInt1, int paramInt2, Executor paramExecutor) {
    Context context = this.b;
    GlideContext glideContext = this.f;
    return (Request)SingleRequest.a(context, glideContext, paramObject, this.h, this.d, paramBaseRequestOptions, paramInt1, paramInt2, paramPriority, paramTarget, paramRequestListener, this.i, paramRequestCoordinator, glideContext.c(), paramTransitionOptions.b(), paramExecutor);
  }
  
  private Request a(Object paramObject, Target<TranscodeType> paramTarget, RequestListener<TranscodeType> paramRequestListener, RequestCoordinator paramRequestCoordinator, TransitionOptions<?, ? super TranscodeType> paramTransitionOptions, Priority paramPriority, int paramInt1, int paramInt2, BaseRequestOptions<?> paramBaseRequestOptions, Executor paramExecutor) {
    ErrorRequestCoordinator errorRequestCoordinator1;
    ErrorRequestCoordinator errorRequestCoordinator2;
    if (this.k != null) {
      errorRequestCoordinator2 = new ErrorRequestCoordinator(paramObject, paramRequestCoordinator);
      errorRequestCoordinator1 = errorRequestCoordinator2;
    } else {
      ErrorRequestCoordinator errorRequestCoordinator = null;
      errorRequestCoordinator2 = errorRequestCoordinator1;
      errorRequestCoordinator1 = errorRequestCoordinator;
    } 
    Request request = b(paramObject, paramTarget, paramRequestListener, (RequestCoordinator)errorRequestCoordinator2, paramTransitionOptions, paramPriority, paramInt1, paramInt2, paramBaseRequestOptions, paramExecutor);
    if (errorRequestCoordinator1 == null)
      return request; 
    int k = this.k.E();
    int m = this.k.G();
    int j = k;
    int i = m;
    if (Util.a(paramInt1, paramInt2)) {
      j = k;
      i = m;
      if (!this.k.F()) {
        j = paramBaseRequestOptions.E();
        i = paramBaseRequestOptions.G();
      } 
    } 
    RequestBuilder<TranscodeType> requestBuilder = this.k;
    errorRequestCoordinator1.a(request, requestBuilder.a(paramObject, paramTarget, paramRequestListener, (RequestCoordinator)errorRequestCoordinator1, requestBuilder.g, requestBuilder.D(), j, i, this.k, paramExecutor));
    return (Request)errorRequestCoordinator1;
  }
  
  private <Y extends Target<TranscodeType>> Y a(Y paramY, RequestListener<TranscodeType> paramRequestListener, BaseRequestOptions<?> paramBaseRequestOptions, Executor paramExecutor) {
    Preconditions.a(paramY);
    if (this.n) {
      Request request1 = b((Target<TranscodeType>)paramY, paramRequestListener, paramBaseRequestOptions, paramExecutor);
      Request request2 = paramY.a();
      if (request1.a(request2) && !a(paramBaseRequestOptions, request2)) {
        if (!((Request)Preconditions.a(request2)).d())
          request2.a(); 
        return paramY;
      } 
      this.c.a((Target<?>)paramY);
      paramY.a(request1);
      this.c.a((Target<?>)paramY, request1);
      return paramY;
    } 
    throw new IllegalArgumentException("You must call #load() before calling #into()");
  }
  
  private void a(List<RequestListener<Object>> paramList) {
    Iterator<RequestListener<Object>> iterator = paramList.iterator();
    while (iterator.hasNext())
      c((RequestListener<TranscodeType>)iterator.next()); 
  }
  
  private boolean a(BaseRequestOptions<?> paramBaseRequestOptions, Request paramRequest) {
    return (!paramBaseRequestOptions.A() && paramRequest.e());
  }
  
  private Request b(Target<TranscodeType> paramTarget, RequestListener<TranscodeType> paramRequestListener, BaseRequestOptions<?> paramBaseRequestOptions, Executor paramExecutor) {
    return a(new Object(), paramTarget, paramRequestListener, (RequestCoordinator)null, this.g, paramBaseRequestOptions.D(), paramBaseRequestOptions.E(), paramBaseRequestOptions.G(), paramBaseRequestOptions, paramExecutor);
  }
  
  private Request b(Object paramObject, Target<TranscodeType> paramTarget, RequestListener<TranscodeType> paramRequestListener, RequestCoordinator paramRequestCoordinator, TransitionOptions<?, ? super TranscodeType> paramTransitionOptions, Priority paramPriority, int paramInt1, int paramInt2, BaseRequestOptions<?> paramBaseRequestOptions, Executor paramExecutor) {
    ThumbnailRequestCoordinator thumbnailRequestCoordinator;
    Request request;
    RequestBuilder<TranscodeType> requestBuilder1;
    RequestBuilder<TranscodeType> requestBuilder2 = this.j;
    if (requestBuilder2 != null) {
      if (!this.o) {
        Priority priority;
        TransitionOptions<?, ? super TranscodeType> transitionOptions = requestBuilder2.g;
        if (requestBuilder2.m)
          transitionOptions = paramTransitionOptions; 
        if (this.j.C()) {
          priority = this.j.D();
        } else {
          priority = a(paramPriority);
        } 
        int k = this.j.E();
        int m = this.j.G();
        int j = k;
        int i = m;
        if (Util.a(paramInt1, paramInt2)) {
          j = k;
          i = m;
          if (!this.j.F()) {
            j = paramBaseRequestOptions.E();
            i = paramBaseRequestOptions.G();
          } 
        } 
        thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(paramObject, paramRequestCoordinator);
        request = a(paramObject, paramTarget, paramRequestListener, paramBaseRequestOptions, (RequestCoordinator)thumbnailRequestCoordinator, paramTransitionOptions, paramPriority, paramInt1, paramInt2, paramExecutor);
        this.o = true;
        requestBuilder1 = this.j;
        paramObject = requestBuilder1.a(paramObject, paramTarget, paramRequestListener, (RequestCoordinator)thumbnailRequestCoordinator, transitionOptions, priority, j, i, requestBuilder1, paramExecutor);
        this.o = false;
        thumbnailRequestCoordinator.a(request, (Request)paramObject);
        return (Request)thumbnailRequestCoordinator;
      } 
      throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
    } 
    if (this.l != null) {
      thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(paramObject, (RequestCoordinator)thumbnailRequestCoordinator);
      thumbnailRequestCoordinator.a(a(paramObject, paramTarget, paramRequestListener, paramBaseRequestOptions, (RequestCoordinator)thumbnailRequestCoordinator, (TransitionOptions<?, ? super TranscodeType>)request, (Priority)requestBuilder1, paramInt1, paramInt2, paramExecutor), a(paramObject, paramTarget, paramRequestListener, paramBaseRequestOptions.l().b(this.l.floatValue()), (RequestCoordinator)thumbnailRequestCoordinator, (TransitionOptions<?, ? super TranscodeType>)request, a((Priority)requestBuilder1), paramInt1, paramInt2, paramExecutor));
      return (Request)thumbnailRequestCoordinator;
    } 
    return a(paramObject, paramTarget, paramRequestListener, paramBaseRequestOptions, (RequestCoordinator)thumbnailRequestCoordinator, (TransitionOptions<?, ? super TranscodeType>)request, (Priority)requestBuilder1, paramInt1, paramInt2, paramExecutor);
  }
  
  public <Y extends Target<TranscodeType>> Y a(Y paramY) {
    return a(paramY, (RequestListener<?>)null, Executors.a());
  }
  
  <Y extends Target<TranscodeType>> Y a(Y paramY, RequestListener<TranscodeType> paramRequestListener, Executor paramExecutor) {
    return a(paramY, paramRequestListener, this, paramExecutor);
  }
  
  public ViewTarget<ImageView, TranscodeType> a(ImageView paramImageView) {
    Util.a();
    Preconditions.a(paramImageView);
    if (!n() && m() && paramImageView.getScaleType() != null) {
      BaseRequestOptions<?> baseRequestOptions;
      switch (null.a[paramImageView.getScaleType().ordinal()]) {
        case 6:
          baseRequestOptions = super.l().i();
          return a(this.f.a(paramImageView, this.d), (RequestListener<?>)null, baseRequestOptions, Executors.a());
        case 3:
        case 4:
        case 5:
          baseRequestOptions = super.l().j();
          return a(this.f.a(paramImageView, this.d), (RequestListener<?>)null, baseRequestOptions, Executors.a());
        case 2:
          baseRequestOptions = super.l().i();
          return a(this.f.a(paramImageView, this.d), (RequestListener<?>)null, baseRequestOptions, Executors.a());
        case 1:
          baseRequestOptions = super.l().k();
          return a(this.f.a(paramImageView, this.d), (RequestListener<?>)null, baseRequestOptions, Executors.a());
      } 
    } 
    RequestBuilder<?> requestBuilder = this;
    return a(this.f.a(paramImageView, this.d), (RequestListener<?>)null, requestBuilder, Executors.a());
  }
  
  public RequestBuilder<TranscodeType> b(Uri paramUri) {
    return a(paramUri);
  }
  
  public RequestBuilder<TranscodeType> b(RequestBuilder<TranscodeType> paramRequestBuilder) {
    this.j = paramRequestBuilder;
    return this;
  }
  
  public RequestBuilder<TranscodeType> b(TransitionOptions<?, ? super TranscodeType> paramTransitionOptions) {
    this.g = (TransitionOptions<?, ? super TranscodeType>)Preconditions.a(paramTransitionOptions);
    this.m = false;
    return this;
  }
  
  public RequestBuilder<TranscodeType> b(File paramFile) {
    return a(paramFile);
  }
  
  public RequestBuilder<TranscodeType> b(Integer paramInteger) {
    return a(paramInteger).c((BaseRequestOptions<?>)RequestOptions.c(AndroidResourceSignature.a(this.b)));
  }
  
  public RequestBuilder<TranscodeType> b(Object paramObject) {
    return a(paramObject);
  }
  
  public RequestBuilder<TranscodeType> b(String paramString) {
    return a(paramString);
  }
  
  public RequestBuilder<TranscodeType> c(BaseRequestOptions<?> paramBaseRequestOptions) {
    Preconditions.a(paramBaseRequestOptions);
    return (RequestBuilder<TranscodeType>)super.b(paramBaseRequestOptions);
  }
  
  public RequestBuilder<TranscodeType> c(RequestListener<TranscodeType> paramRequestListener) {
    if (paramRequestListener != null) {
      if (this.i == null)
        this.i = new ArrayList<RequestListener<TranscodeType>>(); 
      this.i.add(paramRequestListener);
    } 
    return this;
  }
  
  public FutureTarget<TranscodeType> c(int paramInt1, int paramInt2) {
    RequestFutureTarget requestFutureTarget = new RequestFutureTarget(paramInt1, paramInt2);
    return (FutureTarget<TranscodeType>)a(requestFutureTarget, (RequestListener<?>)requestFutureTarget, Executors.b());
  }
  
  public RequestBuilder<TranscodeType> d(RequestListener<TranscodeType> paramRequestListener) {
    this.i = null;
    return c(paramRequestListener);
  }
  
  public RequestBuilder<TranscodeType> e() {
    RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder)super.l();
    requestBuilder.g = (TransitionOptions<?, ? super TranscodeType>)requestBuilder.g.a();
    return requestBuilder;
  }
  
  public FutureTarget<TranscodeType> f() {
    return c(-2147483648, -2147483648);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\RequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */