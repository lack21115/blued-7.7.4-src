package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.util.LruCache;

public final class TypefaceCompat {
  private static final LruCache sTypefaceCache = new LruCache(16);
  
  private static final TypefaceCompat$TypefaceCompatImpl sTypefaceCompatImpl;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static Typeface createFromFontInfo(Context paramContext, CancellationSignal paramCancellationSignal, FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt) {
    return sTypefaceCompatImpl.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, paramInt);
  }
  
  public static Typeface createFromResourcesFamilyXml(Context paramContext, FontResourcesParserCompat.FamilyResourceEntry paramFamilyResourceEntry, Resources paramResources, int paramInt1, int paramInt2, ResourcesCompat.FontCallback paramFontCallback, Handler paramHandler, boolean paramBoolean) {
    Typeface typeface;
    FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry;
    if (paramFamilyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
      byte b;
      providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry)paramFamilyResourceEntry;
      boolean bool = false;
      if (paramBoolean ? (providerResourceEntry.mStrategy == 0) : (paramFontCallback == null))
        bool = true; 
      if (paramBoolean) {
        b = providerResourceEntry.mTimeoutMs;
      } else {
        b = -1;
      } 
      typeface = FontsContractCompat.getFontSync(paramContext, providerResourceEntry.mRequest, paramFontCallback, paramHandler, bool, b, paramInt2);
    } else {
      Typeface typeface1 = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry((Context)typeface, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)providerResourceEntry, paramResources, paramInt2);
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
      sTypefaceCache.put(createResourceUid(paramResources, paramInt1, paramInt2), typeface); 
    return typeface;
  }
  
  public static Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2) {
    Typeface typeface = sTypefaceCompatImpl.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (typeface != null) {
      String str = createResourceUid(paramResources, paramInt1, paramInt2);
      sTypefaceCache.put(str, typeface);
    } 
    return typeface;
  }
  
  private static String createResourceUid(Resources paramResources, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramResources.getResourcePackageName(paramInt1));
    stringBuilder.append("-");
    stringBuilder.append(paramInt1);
    stringBuilder.append("-");
    stringBuilder.append(paramInt2);
    return stringBuilder.toString();
  }
  
  public static Typeface findFromCache(Resources paramResources, int paramInt1, int paramInt2) {
    return (Typeface)sTypefaceCache.get(createResourceUid(paramResources, paramInt1, paramInt2));
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 26) {
      sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
    } else if (Build.VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.isUsable()) {
      sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
    } else if (Build.VERSION.SDK_INT >= 21) {
      sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
    } else {
      sTypefaceCompatImpl = new TypefaceCompatBaseImpl();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\TypefaceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */