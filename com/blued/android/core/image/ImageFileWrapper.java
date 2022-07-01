package com.blued.android.core.image;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.http.HttpRequestListener;
import com.blued.android.core.image.util.ExecutorUtils;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class ImageFileWrapper {
  private RequestBuilder a;
  
  private IRequestHost b;
  
  private FutureTarget<File> c;
  
  private String d = "";
  
  private boolean e = false;
  
  private boolean f = false;
  
  private String g = "";
  
  private String h = "";
  
  private Object i = null;
  
  private ImageFileLoader.OnLoadFileListener j;
  
  private ImageSize k = null;
  
  protected ImageFileWrapper(IRequestHost paramIRequestHost, RequestBuilder paramRequestBuilder) {
    this.b = paramIRequestHost;
    this.a = paramRequestBuilder;
  }
  
  private void a(boolean paramBoolean, Object paramObject) {
    if (this.j != null)
      AppInfo.n().post(new Runnable(this, paramBoolean, paramObject) {
            public void run() {
              if (ImageFileWrapper.a(this.c) != null && (ImageFileWrapper.b(this.c) == null || ImageFileWrapper.b(this.c).isActive())) {
                if (this.a) {
                  ImageFileWrapper.a(this.c).onUIFinish((File)this.b, null);
                  return;
                } 
                ImageFileWrapper.a(this.c).onUIFinish(null, (Exception)this.b);
              } 
            }
          }); 
  }
  
  private Runnable d() {
    return new Runnable(this) {
        public void run() {
          StringBuilder stringBuilder1;
          Object object = null;
          try {
            stringBuilder1 = (StringBuilder)ImageFileWrapper.c(this.a).get();
            try {
              if (ImageLoader.a()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("load:");
                stringBuilder.append(stringBuilder1.getPath());
                Log.c("IMAGE", stringBuilder.toString());
              } 
              Object object1 = null;
              File file = (File)stringBuilder1;
            } catch (Exception null) {}
          } catch (Exception exception1) {
            stringBuilder1 = null;
          } 
          StringBuilder stringBuilder2 = stringBuilder1;
          Exception exception2 = exception1;
          if (ImageLoader.a()) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("load:");
            stringBuilder2.append(exception1.toString());
            Log.d("IMAGE", stringBuilder2.toString());
            exception2 = exception1;
            stringBuilder2 = stringBuilder1;
          } 
        }
      };
  }
  
  private void e(String paramString) {
    this.d = paramString;
    this.e = true;
  }
  
  public ImageFileWrapper a(ImageFileLoader.OnLoadFileListener paramOnLoadFileListener) {
    this.j = paramOnLoadFileListener;
    return this;
  }
  
  public ImageFileWrapper a(ImageLoadResult paramImageLoadResult) {
    if (paramImageLoadResult != null)
      this.a.d((RequestListener)new HttpRequestListener(paramImageLoadResult)); 
    return this;
  }
  
  public ImageFileWrapper a(ImageSize paramImageSize) {
    this.k = paramImageSize;
    return this;
  }
  
  public ImageFileWrapper a(Integer paramInteger) {
    e(String.valueOf(paramInteger));
    this.a.b(paramInteger);
    return this;
  }
  
  public ImageFileWrapper a(Object paramObject) {
    this.i = paramObject;
    return this;
  }
  
  public ImageFileWrapper a(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    this.f = true;
    e(str);
    this.a.b(str);
    return this;
  }
  
  public ImageFileWrapper a(String paramString1, String paramString2) {
    String str = paramString1;
    if (paramString1 == null)
      str = ""; 
    paramString1 = paramString2;
    if (paramString2 == null)
      paramString1 = ""; 
    this.g = str;
    this.a.b(paramString1);
    this.a.b(ImageLoaderOptions.a, str);
    return this;
  }
  
  public void a() {
    boolean bool1 = this.e;
    boolean bool = false;
    if (bool1) {
      if (TextUtils.isEmpty(this.d)) {
        a(false, new Exception("load url is empty!"));
        return;
      } 
    } else {
      if (TextUtils.isEmpty(this.g)) {
        a(false, new Exception("Local source image path is empty!"));
        return;
      } 
      if (!(new File(this.g)).exists()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't find local image at ");
        stringBuilder.append(this.g);
        a(false, new Exception(stringBuilder.toString()));
        return;
      } 
    } 
    int i = c();
    synchronized (ImageFileLoader.a(this.f)) {
      LinkedHashSet<ImageFileWrapper> linkedHashSet2 = null.get(Integer.valueOf(i));
      LinkedHashSet<ImageFileWrapper> linkedHashSet1 = linkedHashSet2;
      if (linkedHashSet2 == null) {
        linkedHashSet1 = new LinkedHashSet();
        null.put(Integer.valueOf(i), linkedHashSet1);
        bool = true;
      } 
      linkedHashSet1.add(this);
      if (bool) {
        this.c = this.a.f();
        if (this.f) {
          ExecutorUtils.a(i, d());
          return;
        } 
        ExecutorUtils.b(i, d());
      } 
      return;
    } 
  }
  
  public ImageFileWrapper b(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    e(str);
    this.a.b(str);
    this.a.e(true);
    return this;
  }
  
  protected void b() {
    FutureTarget<File> futureTarget = this.c;
    if (futureTarget != null) {
      futureTarget.cancel(false);
      ImageLoader.a(this.b).a((Target)this.c);
    } 
  }
  
  protected int c() {
    String str;
    Object object = this.i;
    if (this.e) {
      str = this.d;
    } else {
      str = this.g;
    } 
    return ImageFileLoader.a(object, str);
  }
  
  public ImageFileWrapper c(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    this.g = str;
    this.a.b(str);
    return this;
  }
  
  public ImageFileWrapper d(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    this.h = str;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\ImageFileWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */