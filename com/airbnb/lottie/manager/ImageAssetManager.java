package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ImageAssetManager {
  private static final Object a = new Object();
  
  private final Context b;
  
  private String c;
  
  private ImageAssetDelegate d;
  
  private final Map<String, LottieImageAsset> e;
  
  public ImageAssetManager(Drawable.Callback paramCallback, String paramString, ImageAssetDelegate paramImageAssetDelegate, Map<String, LottieImageAsset> paramMap) {
    this.c = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      paramString = this.c;
      if (paramString.charAt(paramString.length() - 1) != '/') {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append('/');
        this.c = stringBuilder.toString();
      } 
    } 
    if (!(paramCallback instanceof View)) {
      Logger.b("LottieDrawable must be inside of a view for images to work.");
      this.e = new HashMap<String, LottieImageAsset>();
      this.b = null;
      return;
    } 
    this.b = ((View)paramCallback).getContext();
    this.e = paramMap;
    a(paramImageAssetDelegate);
  }
  
  private Bitmap a(String paramString, Bitmap paramBitmap) {
    synchronized (a) {
      ((LottieImageAsset)this.e.get(paramString)).a(paramBitmap);
      return paramBitmap;
    } 
  }
  
  public Bitmap a(String paramString) {
    Bitmap bitmap1;
    byte[] arrayOfByte;
    LottieImageAsset lottieImageAsset = this.e.get(paramString);
    if (lottieImageAsset == null)
      return null; 
    Bitmap bitmap2 = lottieImageAsset.c();
    if (bitmap2 != null)
      return bitmap2; 
    ImageAssetDelegate imageAssetDelegate = this.d;
    if (imageAssetDelegate != null) {
      bitmap1 = imageAssetDelegate.a(lottieImageAsset);
      if (bitmap1 != null)
        a(paramString, bitmap1); 
      return bitmap1;
    } 
    String str = bitmap1.b();
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inScaled = true;
    options.inDensity = 160;
    if (str.startsWith("data:") && str.indexOf("base64,") > 0)
      try {
        arrayOfByte = Base64.decode(str.substring(str.indexOf(',') + 1), 0);
        return a(paramString, BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, options));
      } catch (IllegalArgumentException illegalArgumentException) {
        Logger.a("data URL did not have correct base64 format.", illegalArgumentException);
        return null;
      }  
    try {
      if (!TextUtils.isEmpty(this.c)) {
        AssetManager assetManager = this.b.getAssets();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append((String)arrayOfByte);
        InputStream inputStream = assetManager.open(stringBuilder.toString());
        return a((String)illegalArgumentException, BitmapFactory.decodeStream(inputStream, null, options));
      } 
      throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
    } catch (IOException iOException) {
      Logger.a("Unable to open asset.", iOException);
      return null;
    } 
  }
  
  public void a(ImageAssetDelegate paramImageAssetDelegate) {
    this.d = paramImageAssetDelegate;
  }
  
  public boolean a(Context paramContext) {
    return ((paramContext == null && this.b == null) || this.b.equals(paramContext));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\manager\ImageAssetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */