package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager {
  private final MutablePair<String> a = new MutablePair();
  
  private final Map<MutablePair<String>, Typeface> b = new HashMap<MutablePair<String>, Typeface>();
  
  private final Map<String, Typeface> c = new HashMap<String, Typeface>();
  
  private final AssetManager d;
  
  private FontAssetDelegate e;
  
  private String f = ".ttf";
  
  public FontAssetManager(Drawable.Callback paramCallback, FontAssetDelegate paramFontAssetDelegate) {
    this.e = paramFontAssetDelegate;
    if (!(paramCallback instanceof View)) {
      Logger.b("LottieDrawable must be inside of a view for images to work.");
      this.d = null;
      return;
    } 
    this.d = ((View)paramCallback).getContext().getAssets();
  }
  
  private Typeface a(Typeface paramTypeface, String paramString) {
    boolean bool;
    boolean bool1 = paramString.contains("Italic");
    boolean bool2 = paramString.contains("Bold");
    if (bool1 && bool2) {
      bool = true;
    } else if (bool1) {
      bool = true;
    } else if (bool2) {
      bool = true;
    } else {
      bool = false;
    } 
    return (paramTypeface.getStyle() == bool) ? paramTypeface : Typeface.create(paramTypeface, bool);
  }
  
  private Typeface a(String paramString) {
    Typeface typeface1 = this.c.get(paramString);
    if (typeface1 != null)
      return typeface1; 
    typeface1 = null;
    FontAssetDelegate fontAssetDelegate1 = this.e;
    if (fontAssetDelegate1 != null)
      typeface1 = fontAssetDelegate1.a(paramString); 
    FontAssetDelegate fontAssetDelegate2 = this.e;
    Typeface typeface2 = typeface1;
    if (fontAssetDelegate2 != null) {
      typeface2 = typeface1;
      if (typeface1 == null) {
        String str = fontAssetDelegate2.b(paramString);
        typeface2 = typeface1;
        if (str != null)
          typeface2 = Typeface.createFromAsset(this.d, str); 
      } 
    } 
    typeface1 = typeface2;
    if (typeface2 == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("fonts/");
      stringBuilder.append(paramString);
      stringBuilder.append(this.f);
      String str = stringBuilder.toString();
      typeface1 = Typeface.createFromAsset(this.d, str);
    } 
    this.c.put(paramString, typeface1);
    return typeface1;
  }
  
  public Typeface a(String paramString1, String paramString2) {
    this.a.a(paramString1, paramString2);
    Typeface typeface2 = this.b.get(this.a);
    if (typeface2 != null)
      return typeface2; 
    Typeface typeface1 = a(a(paramString1), paramString2);
    this.b.put(this.a, typeface1);
    return typeface1;
  }
  
  public void a(FontAssetDelegate paramFontAssetDelegate) {
    this.e = paramFontAssetDelegate;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\manager\FontAssetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */