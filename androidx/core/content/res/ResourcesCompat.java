package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat {
  private static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, FontCallback paramFontCallback, Handler paramHandler, boolean paramBoolean) {
    StringBuilder stringBuilder;
    Resources resources = paramContext.getResources();
    resources.getValue(paramInt1, paramTypedValue, true);
    Typeface typeface = a(paramContext, resources, paramTypedValue, paramInt1, paramInt2, paramFontCallback, paramHandler, paramBoolean);
    if (typeface == null) {
      if (paramFontCallback != null)
        return typeface; 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Font resource ID #0x");
      stringBuilder.append(Integer.toHexString(paramInt1));
      stringBuilder.append(" could not be retrieved.");
      throw new Resources.NotFoundException(stringBuilder.toString());
    } 
    return (Typeface)stringBuilder;
  }
  
  private static Typeface a(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, FontCallback paramFontCallback, Handler paramHandler, boolean paramBoolean) {
    StringBuilder stringBuilder;
    String str;
    if (paramTypedValue.string != null) {
      str = paramTypedValue.string.toString();
      if (!str.startsWith("res/")) {
        if (paramFontCallback != null)
          paramFontCallback.callbackFailAsync(-3, paramHandler); 
        return null;
      } 
      Typeface typeface = TypefaceCompat.findFromCache(paramResources, paramInt1, paramInt2);
      if (typeface != null) {
        if (paramFontCallback != null)
          paramFontCallback.callbackSuccessAsync(typeface, paramHandler); 
        return typeface;
      } 
      try {
        if (str.toLowerCase().endsWith(".xml")) {
          FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry = FontResourcesParserCompat.parse((XmlPullParser)paramResources.getXml(paramInt1), paramResources);
          if (familyResourceEntry == null) {
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (paramFontCallback != null) {
              paramFontCallback.callbackFailAsync(-3, paramHandler);
              return null;
            } 
          } else {
            return TypefaceCompat.createFromResourcesFamilyXml(paramContext, familyResourceEntry, paramResources, paramInt1, paramInt2, paramFontCallback, paramHandler, paramBoolean);
          } 
        } else {
          Typeface typeface1 = TypefaceCompat.createFromResourcesFontFile(paramContext, paramResources, paramInt1, str, paramInt2);
          if (paramFontCallback != null) {
            if (typeface1 != null) {
              paramFontCallback.callbackSuccessAsync(typeface1, paramHandler);
              return typeface1;
            } 
            paramFontCallback.callbackFailAsync(-3, paramHandler);
          } 
          return typeface1;
        } 
      } catch (XmlPullParserException xmlPullParserException) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to parse xml resource ");
        stringBuilder.append(str);
        Log.e("ResourcesCompat", stringBuilder.toString(), (Throwable)xmlPullParserException);
        if (paramFontCallback != null)
          paramFontCallback.callbackFailAsync(-3, paramHandler); 
        return null;
      } catch (IOException iOException) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to read xml resource ");
        stringBuilder.append(str);
        Log.e("ResourcesCompat", stringBuilder.toString(), iOException);
      } 
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Resource \"");
      stringBuilder1.append(stringBuilder.getResourceName(paramInt1));
      stringBuilder1.append("\" (");
      stringBuilder1.append(Integer.toHexString(paramInt1));
      stringBuilder1.append(") is not a Font: ");
      stringBuilder1.append(str);
      throw new Resources.NotFoundException(stringBuilder1.toString());
    } 
    return null;
  }
  
  public static int getColor(Resources paramResources, int paramInt, Resources.Theme paramTheme) throws Resources.NotFoundException {
    return (Build.VERSION.SDK_INT >= 23) ? paramResources.getColor(paramInt, paramTheme) : paramResources.getColor(paramInt);
  }
  
  public static ColorStateList getColorStateList(Resources paramResources, int paramInt, Resources.Theme paramTheme) throws Resources.NotFoundException {
    return (Build.VERSION.SDK_INT >= 23) ? paramResources.getColorStateList(paramInt, paramTheme) : paramResources.getColorStateList(paramInt);
  }
  
  public static Drawable getDrawable(Resources paramResources, int paramInt, Resources.Theme paramTheme) throws Resources.NotFoundException {
    return (Build.VERSION.SDK_INT >= 21) ? paramResources.getDrawable(paramInt, paramTheme) : paramResources.getDrawable(paramInt);
  }
  
  public static Drawable getDrawableForDensity(Resources paramResources, int paramInt1, int paramInt2, Resources.Theme paramTheme) throws Resources.NotFoundException {
    return (Build.VERSION.SDK_INT >= 21) ? paramResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme) : ((Build.VERSION.SDK_INT >= 15) ? paramResources.getDrawableForDensity(paramInt1, paramInt2) : paramResources.getDrawable(paramInt1));
  }
  
  public static float getFloat(Resources paramResources, int paramInt) {
    TypedValue typedValue = new TypedValue();
    paramResources.getValue(paramInt, typedValue, true);
    if (typedValue.type == 4)
      return typedValue.getFloat(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Resource ID #0x");
    stringBuilder.append(Integer.toHexString(paramInt));
    stringBuilder.append(" type #0x");
    stringBuilder.append(Integer.toHexString(typedValue.type));
    stringBuilder.append(" is not valid");
    throw new Resources.NotFoundException(stringBuilder.toString());
  }
  
  public static Typeface getFont(Context paramContext, int paramInt) throws Resources.NotFoundException {
    return paramContext.isRestricted() ? null : a(paramContext, paramInt, new TypedValue(), 0, null, null, false);
  }
  
  public static Typeface getFont(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, FontCallback paramFontCallback) throws Resources.NotFoundException {
    return paramContext.isRestricted() ? null : a(paramContext, paramInt1, paramTypedValue, paramInt2, paramFontCallback, null, true);
  }
  
  public static void getFont(Context paramContext, int paramInt, FontCallback paramFontCallback, Handler paramHandler) throws Resources.NotFoundException {
    Preconditions.checkNotNull(paramFontCallback);
    if (paramContext.isRestricted()) {
      paramFontCallback.callbackFailAsync(-4, paramHandler);
      return;
    } 
    a(paramContext, paramInt, new TypedValue(), 0, paramFontCallback, paramHandler, false);
  }
  
  public static abstract class FontCallback {
    public final void callbackFailAsync(int param1Int, Handler param1Handler) {
      Handler handler = param1Handler;
      if (param1Handler == null)
        handler = new Handler(Looper.getMainLooper()); 
      handler.post(new Runnable(this, param1Int) {
            public void run() {
              this.b.onFontRetrievalFailed(this.a);
            }
          });
    }
    
    public final void callbackSuccessAsync(Typeface param1Typeface, Handler param1Handler) {
      Handler handler = param1Handler;
      if (param1Handler == null)
        handler = new Handler(Looper.getMainLooper()); 
      handler.post(new Runnable(this, param1Typeface) {
            public void run() {
              this.b.onFontRetrieved(this.a);
            }
          });
    }
    
    public abstract void onFontRetrievalFailed(int param1Int);
    
    public abstract void onFontRetrieved(Typeface param1Typeface);
  }
  
  class null implements Runnable {
    null(ResourcesCompat this$0, Typeface param1Typeface) {}
    
    public void run() {
      this.b.onFontRetrieved(this.a);
    }
  }
  
  class null implements Runnable {
    null(ResourcesCompat this$0, int param1Int) {}
    
    public void run() {
      this.b.onFontRetrievalFailed(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\content\res\ResourcesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */