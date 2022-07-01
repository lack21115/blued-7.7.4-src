package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
  public GifDrawableResource(GifDrawable paramGifDrawable) {
    super(paramGifDrawable);
  }
  
  public Class<GifDrawable> a() {
    return GifDrawable.class;
  }
  
  public int b() {
    return ((GifDrawable)this.d).a();
  }
  
  public void c() {
    ((GifDrawable)this.d).stop();
    ((GifDrawable)this.d).g();
  }
  
  public void d() {
    ((GifDrawable)this.d).b().prepareToDraw();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\gif\GifDrawableResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */