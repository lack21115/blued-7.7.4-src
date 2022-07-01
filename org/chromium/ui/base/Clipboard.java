package org.chromium.ui.base;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.RecordUserAction;
import org.chromium.ui.R;
import org.chromium.ui.widget.Toast;

public class Clipboard implements ClipboardManager.OnPrimaryClipChangedListener {
  @SuppressLint({"StaticFieldLeak"})
  private static Clipboard sInstance;
  
  private final ClipboardManager mClipboardManager = (ClipboardManager)ContextUtils.sApplicationContext.getSystemService("clipboard");
  
  private final Context mContext = ContextUtils.sApplicationContext;
  
  private Clipboard() {
    this.mClipboardManager.addPrimaryClipChangedListener(this);
  }
  
  @CalledByNative
  private void clear() {
    setPrimaryClipNoException(ClipData.newPlainText(null, null));
  }
  
  @CalledByNative
  private String getCoercedText() {
    try {
      return this.mClipboardManager.getPrimaryClip().getItemAt(0).coerceToText(this.mContext).toString();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  @CalledByNative
  private String getHTMLText() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mClipboardManager : Landroid/content/ClipboardManager;
    //   4: invokevirtual getPrimaryClip : ()Landroid/content/ClipData;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual getDescription : ()Landroid/content/ClipDescription;
    //   12: astore #4
    //   14: aload #4
    //   16: ldc 'text/html'
    //   18: invokevirtual hasMimeType : (Ljava/lang/String;)Z
    //   21: ifeq -> 33
    //   24: aload_3
    //   25: iconst_0
    //   26: invokevirtual getItemAt : (I)Landroid/content/ClipData$Item;
    //   29: invokevirtual getHtmlText : ()Ljava/lang/String;
    //   32: areturn
    //   33: aload #4
    //   35: ldc 'text/plain'
    //   37: invokevirtual hasMimeType : (Ljava/lang/String;)Z
    //   40: ifeq -> 139
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual getItemAt : (I)Landroid/content/ClipData$Item;
    //   48: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   51: astore_3
    //   52: aload_3
    //   53: instanceof android/text/Spanned
    //   56: ifne -> 61
    //   59: aconst_null
    //   60: areturn
    //   61: aload_3
    //   62: checkcast android/text/Spanned
    //   65: astore_3
    //   66: iconst_1
    //   67: istore_2
    //   68: iconst_0
    //   69: istore_1
    //   70: iload_1
    //   71: iconst_3
    //   72: if_icmpge -> 151
    //   75: iconst_3
    //   76: anewarray java/lang/Class
    //   79: dup
    //   80: iconst_0
    //   81: ldc android/text/style/CharacterStyle
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: ldc android/text/style/ParagraphStyle
    //   88: aastore
    //   89: dup
    //   90: iconst_2
    //   91: ldc android/text/style/UpdateAppearance
    //   93: aastore
    //   94: iload_1
    //   95: aaload
    //   96: astore #4
    //   98: aload_3
    //   99: iconst_m1
    //   100: aload_3
    //   101: invokeinterface length : ()I
    //   106: aload #4
    //   108: invokeinterface nextSpanTransition : (IILjava/lang/Class;)I
    //   113: aload_3
    //   114: invokeinterface length : ()I
    //   119: if_icmpge -> 144
    //   122: iload_2
    //   123: istore_1
    //   124: goto -> 127
    //   127: iload_1
    //   128: ifeq -> 139
    //   131: aload_3
    //   132: iconst_0
    //   133: invokestatic toHtml : (Landroid/text/Spanned;I)Ljava/lang/String;
    //   136: astore_3
    //   137: aload_3
    //   138: areturn
    //   139: aconst_null
    //   140: areturn
    //   141: astore_3
    //   142: aconst_null
    //   143: areturn
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -> 70
    //   151: iconst_0
    //   152: istore_1
    //   153: goto -> 127
    // Exception table:
    //   from	to	target	type
    //   0	33	141	java/lang/Exception
    //   33	59	141	java/lang/Exception
    //   61	66	141	java/lang/Exception
    //   75	122	141	java/lang/Exception
    //   131	137	141	java/lang/Exception
  }
  
  @CalledByNative
  public static Clipboard getInstance() {
    if (sInstance == null)
      sInstance = new Clipboard(); 
    return sInstance;
  }
  
  private native long nativeInit();
  
  private native void nativeOnPrimaryClipChanged(long paramLong);
  
  @CalledByNative
  private void setHTMLText(String paramString1, String paramString2) {
    setPrimaryClipNoException(ClipData.newHtmlText("html", paramString2, paramString1));
  }
  
  private void setPrimaryClipNoException(ClipData paramClipData) {
    try {
      this.mClipboardManager.setPrimaryClip(paramClipData);
      return;
    } catch (Exception exception) {
      String str = this.mContext.getString(R.string.copy_to_clipboard_failure_message);
      (Toast.makeText(this.mContext, str, 0)).mToast.show();
      return;
    } 
  }
  
  public void onPrimaryClipChanged() {
    RecordUserAction.record("MobileClipboardChanged");
    long l = nativeInit();
    if (l != 0L)
      nativeOnPrimaryClipChanged(l); 
  }
  
  @CalledByNative
  public void setText(String paramString) {
    setPrimaryClipNoException(ClipData.newPlainText("text", paramString));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\Clipboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */