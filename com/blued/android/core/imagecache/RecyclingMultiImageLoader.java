package com.blued.android.core.imagecache;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.imagecache.view.RecyclingImageView;

public class RecyclingMultiImageLoader {
  private RecyclingImageView a;
  
  private String[] b;
  
  private LoadOptions c;
  
  private ImageLoadingListener d;
  
  private int e = -1;
  
  private String f;
  
  private Drawable g = null;
  
  private FailReason h;
  
  private Handler i = null;
  
  private void a() {
    LoadOptions loadOptions = new LoadOptions(this.c);
    loadOptions.h = false;
    int i = ++this.e;
    String[] arrayOfString = this.b;
    if (i < arrayOfString.length) {
      String str = arrayOfString[i];
      RecyclingImageLoader.a(this.a, str, loadOptions, new ImageLoadingListener(this) {
            public void a(int param1Int1, int param1Int2) {
              if (RecyclingMultiImageLoader.b(this.a) != null)
                RecyclingMultiImageLoader.b(this.a).a(param1Int1, param1Int2); 
            }
            
            public void a(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions) {}
            
            public void a(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions, Drawable param1Drawable, boolean param1Boolean) {
              RecyclingMultiImageLoader.a(this.a, param1String);
              RecyclingMultiImageLoader.a(this.a, param1Drawable);
              RecyclingMultiImageLoader.c(this.a);
            }
            
            public void a(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions, FailReason param1FailReason) {
              RecyclingMultiImageLoader.a(this.a);
            }
            
            public boolean a() {
              return (RecyclingMultiImageLoader.b(this.a) != null) ? RecyclingMultiImageLoader.b(this.a).a() : false;
            }
            
            public void b(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions) {
              RecyclingMultiImageLoader.b(this.a).b(param1String, param1RecyclingImageView, param1LoadOptions);
            }
          });
      return;
    } 
    this.e = -1;
    b();
  }
  
  public static void a(RecyclingImageView paramRecyclingImageView, String[] paramArrayOfString, LoadOptions paramLoadOptions, ImageLoadingListener paramImageLoadingListener) {
    if (paramArrayOfString != null && paramArrayOfString.length > 0) {
      LoadOptions loadOptions = paramLoadOptions;
      if (paramLoadOptions == null)
        loadOptions = new LoadOptions(); 
      ImageLoadingListener imageLoadingListener = paramImageLoadingListener;
      if (paramImageLoadingListener == null)
        imageLoadingListener = RecyclingImageLoader.a; 
      ImageLoadEngine.a((ImageView)paramRecyclingImageView, "");
      int j = paramArrayOfString.length;
      int i;
      for (i = 0; i < j; i++) {
        String str = paramArrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          imageLoadingListener.a(str, paramRecyclingImageView, loadOptions);
          Drawable drawable = RecyclingImageLoader.a(RecyclingUtils.a(str, loadOptions));
          if (drawable != null) {
            imageLoadingListener.a(str, paramRecyclingImageView, loadOptions, drawable, true);
            return;
          } 
        } 
      } 
      RecyclingMultiImageLoader recyclingMultiImageLoader = new RecyclingMultiImageLoader();
      recyclingMultiImageLoader.i = new Handler();
      recyclingMultiImageLoader.a = paramRecyclingImageView;
      recyclingMultiImageLoader.b = paramArrayOfString;
      recyclingMultiImageLoader.c = loadOptions;
      recyclingMultiImageLoader.d = imageLoadingListener;
      recyclingMultiImageLoader.a();
      return;
    } 
    throw new IllegalArgumentException("参数异常");
  }
  
  private void b() {
    if (this.c.h) {
      String[] arrayOfString = this.b;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j) {
        String str = arrayOfString[i];
        RecyclingUtils.Scheme scheme = RecyclingUtils.Scheme.a(str);
        if (scheme != RecyclingUtils.Scheme.a && scheme != RecyclingUtils.Scheme.b) {
          i++;
          continue;
        } 
        RecyclingImageLoader.a(this.a, str, this.c, new ImageLoadingListener(this) {
              public void a(int param1Int1, int param1Int2) {
                if (RecyclingMultiImageLoader.b(this.a) != null)
                  RecyclingMultiImageLoader.b(this.a).a(param1Int1, param1Int2); 
              }
              
              public void a(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions) {}
              
              public void a(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions, Drawable param1Drawable, boolean param1Boolean) {
                RecyclingMultiImageLoader.a(this.a, param1String);
                RecyclingMultiImageLoader.a(this.a, param1Drawable);
                RecyclingMultiImageLoader.c(this.a);
              }
              
              public void a(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions, FailReason param1FailReason) {
                RecyclingMultiImageLoader.a(this.a, param1FailReason);
                RecyclingMultiImageLoader.c(this.a);
              }
              
              public boolean a() {
                return (RecyclingMultiImageLoader.b(this.a) != null) ? RecyclingMultiImageLoader.b(this.a).a() : false;
              }
              
              public void b(String param1String, RecyclingImageView param1RecyclingImageView, LoadOptions param1LoadOptions) {
                RecyclingMultiImageLoader.b(this.a).b(param1String, param1RecyclingImageView, param1LoadOptions);
              }
            });
        return;
      } 
      this.h = new FailReason(FailReason.FailType.j, null);
      c();
      return;
    } 
    this.h = new FailReason(FailReason.FailType.j, null);
    c();
  }
  
  private void c() {
    Drawable drawable = this.g;
    if (drawable != null) {
      ImageLoadingListener imageLoadingListener = this.d;
      String str = this.f;
      RecyclingImageView recyclingImageView = this.a;
      LoadOptions loadOptions = this.c;
      imageLoadingListener.a(str, recyclingImageView, loadOptions, drawable, loadOptions.g);
      return;
    } 
    this.d.a(null, this.a, this.c, this.h);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\RecyclingMultiImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */