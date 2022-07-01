package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class TypefaceCompatBaseImpl {
  private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> a = new ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry>();
  
  private FontResourcesParserCompat.FontFileResourceEntry a(FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, int paramInt) {
    return a(paramFontFamilyFilesResourceEntry.getEntries(), paramInt, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>(this) {
          public int getWeight(FontResourcesParserCompat.FontFileResourceEntry param1FontFileResourceEntry) {
            return param1FontFileResourceEntry.getWeight();
          }
          
          public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry param1FontFileResourceEntry) {
            return param1FontFileResourceEntry.isItalic();
          }
        });
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, StyleExtractor<T> paramStyleExtractor) {
    // Byte code:
    //   0: iload_1
    //   1: iconst_1
    //   2: iand
    //   3: ifne -> 13
    //   6: sipush #400
    //   9: istore_3
    //   10: goto -> 17
    //   13: sipush #700
    //   16: istore_3
    //   17: iload_1
    //   18: iconst_2
    //   19: iand
    //   20: ifeq -> 29
    //   23: iconst_1
    //   24: istore #8
    //   26: goto -> 32
    //   29: iconst_0
    //   30: istore #8
    //   32: aload_0
    //   33: arraylength
    //   34: istore #7
    //   36: aconst_null
    //   37: astore #9
    //   39: iconst_0
    //   40: istore_1
    //   41: ldc 2147483647
    //   43: istore #4
    //   45: iload_1
    //   46: iload #7
    //   48: if_icmpge -> 137
    //   51: aload_0
    //   52: iload_1
    //   53: aaload
    //   54: astore #10
    //   56: aload_2
    //   57: aload #10
    //   59: invokeinterface getWeight : (Ljava/lang/Object;)I
    //   64: iload_3
    //   65: isub
    //   66: invokestatic abs : (I)I
    //   69: istore #6
    //   71: aload_2
    //   72: aload #10
    //   74: invokeinterface isItalic : (Ljava/lang/Object;)Z
    //   79: iload #8
    //   81: if_icmpne -> 90
    //   84: iconst_0
    //   85: istore #5
    //   87: goto -> 93
    //   90: iconst_1
    //   91: istore #5
    //   93: iload #6
    //   95: iconst_2
    //   96: imul
    //   97: iload #5
    //   99: iadd
    //   100: istore #6
    //   102: aload #9
    //   104: ifnull -> 118
    //   107: iload #4
    //   109: istore #5
    //   111: iload #4
    //   113: iload #6
    //   115: if_icmple -> 126
    //   118: aload #10
    //   120: astore #9
    //   122: iload #6
    //   124: istore #5
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_1
    //   130: iload #5
    //   132: istore #4
    //   134: goto -> 45
    //   137: aload #9
    //   139: areturn
  }
  
  private void a(Typeface paramTypeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry) {
    long l = b(paramTypeface);
    if (l != 0L)
      this.a.put(Long.valueOf(l), paramFontFamilyFilesResourceEntry); 
  }
  
  private static long b(Typeface paramTypeface) {
    if (paramTypeface == null)
      return 0L; 
    try {
      Field field = Typeface.class.getDeclaredField("native_instance");
      field.setAccessible(true);
      return ((Number)field.get(paramTypeface)).longValue();
    } catch (NoSuchFieldException noSuchFieldException) {
      Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", noSuchFieldException);
      return 0L;
    } catch (IllegalAccessException illegalAccessException) {
      Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", illegalAccessException);
      return 0L;
    } 
  }
  
  protected Typeface a(Context paramContext, InputStream paramInputStream) {
    File file = TypefaceCompatUtil.getTempFile(paramContext);
    if (file == null)
      return null; 
    try {
      boolean bool = TypefaceCompatUtil.copyToFile(file, paramInputStream);
      if (!bool)
        return null; 
      return Typeface.createFromFile(file.getPath());
    } catch (RuntimeException runtimeException) {
      return null;
    } finally {
      file.delete();
    } 
  }
  
  FontResourcesParserCompat.FontFamilyFilesResourceEntry a(Typeface paramTypeface) {
    long l = b(paramTypeface);
    return (l == 0L) ? null : this.a.get(Long.valueOf(l));
  }
  
  protected FontsContractCompat.FontInfo a(FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt) {
    return a(paramArrayOfFontInfo, paramInt, new StyleExtractor<FontsContractCompat.FontInfo>(this) {
          public int getWeight(FontsContractCompat.FontInfo param1FontInfo) {
            return param1FontInfo.getWeight();
          }
          
          public boolean isItalic(FontsContractCompat.FontInfo param1FontInfo) {
            return param1FontInfo.isItalic();
          }
        });
  }
  
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt) {
    FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = a(paramFontFamilyFilesResourceEntry, paramInt);
    if (fontFileResourceEntry == null)
      return null; 
    Typeface typeface = TypefaceCompat.createFromResourcesFontFile(paramContext, paramResources, fontFileResourceEntry.getResourceId(), fontFileResourceEntry.getFileName(), paramInt);
    a(typeface, paramFontFamilyFilesResourceEntry);
    return typeface;
  }
  
  public Typeface createFromFontInfo(Context paramContext, CancellationSignal paramCancellationSignal, FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt) {
    int i = paramArrayOfFontInfo.length;
    Context context = null;
    if (i < 1)
      return null; 
    null = a(paramArrayOfFontInfo, paramInt);
    try {
      InputStream inputStream1;
      FontsContractCompat.FontInfo[] arrayOfFontInfo;
      InputStream inputStream2 = paramContext.getContentResolver().openInputStream(null.getUri());
      try {
        return typeface;
      } catch (IOException iOException) {
      
      } finally {
        paramArrayOfFontInfo = null;
        inputStream1 = inputStream2;
      } 
      TypefaceCompatUtil.closeQuietly(inputStream1);
      throw arrayOfFontInfo;
    } catch (IOException iOException) {
    
    } finally {
      paramContext = context;
      TypefaceCompatUtil.closeQuietly((Closeable)paramContext);
    } 
    TypefaceCompatUtil.closeQuietly((Closeable)paramCancellationSignal);
    return null;
  }
  
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2) {
    File file = TypefaceCompatUtil.getTempFile(paramContext);
    if (file == null)
      return null; 
    try {
      boolean bool = TypefaceCompatUtil.copyToFile(file, paramResources, paramInt1);
      if (!bool)
        return null; 
      return Typeface.createFromFile(file.getPath());
    } catch (RuntimeException runtimeException) {
      return null;
    } finally {
      file.delete();
    } 
  }
  
  static interface StyleExtractor<T> {
    int getWeight(T param1T);
    
    boolean isItalic(T param1T);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\TypefaceCompatBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */