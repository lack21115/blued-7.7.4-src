package com.blued.android.core.imagecache;

import android.graphics.drawable.Drawable;
import com.blued.android.core.imagecache.view.RecyclingImageView;

public interface ImageLoadingListener {
  void a(int paramInt1, int paramInt2);
  
  void a(String paramString, RecyclingImageView paramRecyclingImageView, LoadOptions paramLoadOptions);
  
  void a(String paramString, RecyclingImageView paramRecyclingImageView, LoadOptions paramLoadOptions, Drawable paramDrawable, boolean paramBoolean);
  
  void a(String paramString, RecyclingImageView paramRecyclingImageView, LoadOptions paramLoadOptions, FailReason paramFailReason);
  
  boolean a();
  
  void b(String paramString, RecyclingImageView paramRecyclingImageView, LoadOptions paramLoadOptions);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\ImageLoadingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */