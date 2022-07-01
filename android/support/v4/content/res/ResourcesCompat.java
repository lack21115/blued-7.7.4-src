package android.support.v4.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.graphics.TypefaceCompat;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat {
  public static Typeface loadFont(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, ResourcesCompat$FontCallback paramResourcesCompat$FontCallback, Handler paramHandler, boolean paramBoolean) {
    StringBuilder stringBuilder;
    String str;
    if (paramTypedValue.string != null) {
      str = paramTypedValue.string.toString();
      if (!str.startsWith("res/")) {
        if (paramResourcesCompat$FontCallback != null)
          paramResourcesCompat$FontCallback.callbackFailAsync(-3, paramHandler); 
        return null;
      } 
      Typeface typeface = TypefaceCompat.findFromCache(paramResources, paramInt1, paramInt2);
      if (typeface != null) {
        if (paramResourcesCompat$FontCallback != null)
          paramResourcesCompat$FontCallback.callbackSuccessAsync(typeface, paramHandler); 
        return typeface;
      } 
      try {
        if (str.toLowerCase().endsWith(".xml")) {
          FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry = FontResourcesParserCompat.parse((XmlPullParser)paramResources.getXml(paramInt1), paramResources);
          if (fontResourcesParserCompat$FamilyResourceEntry == null) {
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (paramResourcesCompat$FontCallback != null) {
              paramResourcesCompat$FontCallback.callbackFailAsync(-3, paramHandler);
              return null;
            } 
          } else {
            return TypefaceCompat.createFromResourcesFamilyXml(paramContext, fontResourcesParserCompat$FamilyResourceEntry, paramResources, paramInt1, paramInt2, paramResourcesCompat$FontCallback, paramHandler, paramBoolean);
          } 
        } else {
          Typeface typeface1 = TypefaceCompat.createFromResourcesFontFile(paramContext, paramResources, paramInt1, str, paramInt2);
          if (paramResourcesCompat$FontCallback != null) {
            if (typeface1 != null) {
              paramResourcesCompat$FontCallback.callbackSuccessAsync(typeface1, paramHandler);
              return typeface1;
            } 
            paramResourcesCompat$FontCallback.callbackFailAsync(-3, paramHandler);
          } 
          return typeface1;
        } 
      } catch (XmlPullParserException xmlPullParserException) {
        stringBuilder = new StringBuilder("Failed to parse xml resource ");
        stringBuilder.append(str);
        Log.e("ResourcesCompat", stringBuilder.toString(), (Throwable)xmlPullParserException);
        if (paramResourcesCompat$FontCallback != null)
          paramResourcesCompat$FontCallback.callbackFailAsync(-3, paramHandler); 
        return null;
      } catch (IOException iOException) {
        stringBuilder = new StringBuilder("Failed to read xml resource ");
        stringBuilder.append(str);
        Log.e("ResourcesCompat", stringBuilder.toString(), iOException);
      } 
    } else {
      StringBuilder stringBuilder1 = new StringBuilder("Resource \"");
      stringBuilder1.append(stringBuilder.getResourceName(paramInt1));
      stringBuilder1.append("\" (");
      stringBuilder1.append(Integer.toHexString(paramInt1));
      stringBuilder1.append(") is not a Font: ");
      stringBuilder1.append(str);
      throw new Resources.NotFoundException(stringBuilder1.toString());
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\content\res\ResourcesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */