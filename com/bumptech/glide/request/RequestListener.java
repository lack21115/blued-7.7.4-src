package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

public interface RequestListener<R> {
  boolean a(GlideException paramGlideException, Object paramObject, Target<R> paramTarget, boolean paramBoolean);
  
  boolean a(R paramR, Object paramObject, Target<R> paramTarget, DataSource paramDataSource, boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\RequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */