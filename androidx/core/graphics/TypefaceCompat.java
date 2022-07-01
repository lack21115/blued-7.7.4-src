package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;

public class TypefaceCompat {
  private static final TypefaceCompatBaseImpl a;
  
  private static final LruCache<String, Typeface> b = new LruCache(16);
  
  private static Typeface a(Context paramContext, Typeface paramTypeface, int paramInt) {
    FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry = a.a(paramTypeface);
    return (fontFamilyFilesResourceEntry == null) ? null : a.createFromFontFamilyFilesResourceEntry(paramContext, fontFamilyFilesResourceEntry, paramContext.getResources(), paramInt);
  }
  
  private static String a(Resources paramResources, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramResources.getResourcePackageName(paramInt1));
    stringBuilder.append("-");
    stringBuilder.append(paramInt1);
    stringBuilder.append("-");
    stringBuilder.append(paramInt2);
    return stringBuilder.toString();
  }
  
  public static Typeface create(Context paramContext, Typeface paramTypeface, int paramInt) {
    if (paramContext != null) {
      if (Build.VERSION.SDK_INT < 21) {
        Typeface typeface = a(paramContext, paramTypeface, paramInt);
        if (typeface != null)
          return typeface; 
      } 
      return Typeface.create(paramTypeface, paramInt);
    } 
    throw new IllegalArgumentException("Context cannot be null");
  }
  
  public static Typeface createFromFontInfo(Context paramContext, CancellationSignal paramCancellationSignal, FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt) {
    return a.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, paramInt);
  }
  
  public static Typeface createFromResourcesFamilyXml(Context paramContext, FontResourcesParserCompat.FamilyResourceEntry paramFamilyResourceEntry, Resources paramResources, int paramInt1, int paramInt2, ResourcesCompat.FontCallback paramFontCallback, Handler paramHandler, boolean paramBoolean) {
    Typeface typeface;
    FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry;
    if (paramFamilyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
      byte b;
      providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry)paramFamilyResourceEntry;
      boolean bool = false;
      if (paramBoolean ? (providerResourceEntry.getFetchStrategy() == 0) : (paramFontCallback == null))
        bool = true; 
      if (paramBoolean) {
        b = providerResourceEntry.getTimeout();
      } else {
        b = -1;
      } 
      typeface = FontsContractCompat.getFontSync(paramContext, providerResourceEntry.getRequest(), paramFontCallback, paramHandler, bool, b, paramInt2);
    } else {
      Typeface typeface1 = a.createFromFontFamilyFilesResourceEntry((Context)typeface, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)providerResourceEntry, paramResources, paramInt2);
      typeface = typeface1;
      if (paramFontCallback != null)
        if (typeface1 != null) {
          paramFontCallback.callbackSuccessAsync(typeface1, paramHandler);
          typeface = typeface1;
        } else {
          paramFontCallback.callbackFailAsync(-3, paramHandler);
          typeface = typeface1;
        }  
    } 
    if (typeface != null)
      b.put(a(paramResources, paramInt1, paramInt2), typeface); 
    return typeface;
  }
  
  public static Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2) {
    Typeface typeface = a.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (typeface != null) {
      String str = a(paramResources, paramInt1, paramInt2);
      b.put(str, typeface);
    } 
    return typeface;
  }
  
  public static Typeface findFromCache(Resources paramResources, int paramInt1, int paramInt2) {
    return (Typeface)b.get(a(paramResources, paramInt1, paramInt2));
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 29) {
      a = new TypefaceCompatApi29Impl();
    } else if (Build.VERSION.SDK_INT >= 28) {
      a = new TypefaceCompatApi28Impl();
    } else if (Build.VERSION.SDK_INT >= 26) {
      a = new TypefaceCompatApi26Impl();
    } else if (Build.VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.isUsable()) {
      a = new TypefaceCompatApi24Impl();
    } else if (Build.VERSION.SDK_INT >= 21) {
      a = new TypefaceCompatApi21Impl();
    } else {
      a = new TypefaceCompatBaseImpl();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\TypefaceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */