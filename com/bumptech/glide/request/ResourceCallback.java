package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

public interface ResourceCallback {
  void a(GlideException paramGlideException);
  
  void a(Resource<?> paramResource, DataSource paramDataSource);
  
  Object h();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\ResourceCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */