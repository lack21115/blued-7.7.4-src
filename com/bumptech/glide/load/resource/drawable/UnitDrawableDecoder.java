package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
  public Resource<Drawable> a(Drawable paramDrawable, int paramInt1, int paramInt2, Options paramOptions) {
    return NonOwnedDrawableResource.a(paramDrawable);
  }
  
  public boolean a(Drawable paramDrawable, Options paramOptions) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\drawable\UnitDrawableDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */