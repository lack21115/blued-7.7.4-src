package org.chromium.ui.base;

import java.util.Locale;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.ui.R;

public class LocalizationUtils {
  private static Boolean sIsLayoutRtl;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String getDefaultCompressedPakLocaleForLanguage(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual hashCode : ()I
    //   4: istore_1
    //   5: iload_1
    //   6: sipush #3241
    //   9: if_icmpeq -> 57
    //   12: iload_1
    //   13: sipush #3588
    //   16: if_icmpeq -> 43
    //   19: iload_1
    //   20: sipush #3886
    //   23: if_icmpeq -> 29
    //   26: goto -> 71
    //   29: aload_0
    //   30: ldc 'zh'
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 71
    //   38: iconst_2
    //   39: istore_1
    //   40: goto -> 73
    //   43: aload_0
    //   44: ldc 'pt'
    //   46: invokevirtual equals : (Ljava/lang/Object;)Z
    //   49: ifeq -> 71
    //   52: iconst_1
    //   53: istore_1
    //   54: goto -> 73
    //   57: aload_0
    //   58: ldc 'en'
    //   60: invokevirtual equals : (Ljava/lang/Object;)Z
    //   63: ifeq -> 71
    //   66: iconst_0
    //   67: istore_1
    //   68: goto -> 73
    //   71: iconst_m1
    //   72: istore_1
    //   73: iload_1
    //   74: tableswitch default -> 100, 0 -> 108, 1 -> 105, 2 -> 102
    //   100: aload_0
    //   101: areturn
    //   102: ldc 'zh-CN'
    //   104: areturn
    //   105: ldc 'pt-PT'
    //   107: areturn
    //   108: ldc 'en-US'
    //   110: areturn
  }
  
  @CalledByNative
  private static String getDisplayNameForLocale(Locale paramLocale1, Locale paramLocale2) {
    return paramLocale1.getDisplayName(paramLocale2);
  }
  
  @CalledByNative
  private static Locale getJavaLocale(String paramString1, String paramString2, String paramString3) {
    return new Locale(paramString1, paramString2, paramString3);
  }
  
  public static String getUiLanguageStringForCompressedPak() {
    String str = ContextUtils.sApplicationContext.getResources().getString(R.string.current_detected_ui_locale_name);
    int i = str.indexOf('-');
    return (i > 0) ? str.substring(0, i) : str;
  }
  
  @CalledByNative
  public static boolean isLayoutRtl() {
    if (sIsLayoutRtl == null) {
      int i = ApiCompatibilityUtils.getLayoutDirection(ContextUtils.sApplicationContext.getResources().getConfiguration());
      boolean bool = true;
      if (i != 1)
        bool = false; 
      sIsLayoutRtl = Boolean.valueOf(bool);
    } 
    return sIsLayoutRtl.booleanValue();
  }
  
  private static native int nativeGetFirstStrongCharacterDirection(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\LocalizationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */