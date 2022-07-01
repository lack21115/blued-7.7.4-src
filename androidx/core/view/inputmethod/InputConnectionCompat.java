package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

public final class InputConnectionCompat {
  public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
  
  static boolean a(String paramString, Bundle paramBundle, OnCommitContentListener paramOnCommitContentListener) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean commitContent(InputConnection paramInputConnection, EditorInfo paramEditorInfo, InputContentInfoCompat paramInputContentInfoCompat, int paramInt, Bundle paramBundle) {
    String str;
    ClipDescription clipDescription = paramInputContentInfoCompat.getDescription();
    String[] arrayOfString = EditorInfoCompat.getContentMimeTypes(paramEditorInfo);
    int j = arrayOfString.length;
    boolean bool = false;
    int i = 0;
    while (true) {
      if (i < j) {
        if (clipDescription.hasMimeType(arrayOfString[i])) {
          i = 1;
          break;
        } 
        i++;
        continue;
      } 
      i = 0;
      break;
    } 
    if (i == 0)
      return false; 
    if (Build.VERSION.SDK_INT >= 25)
      return paramInputConnection.commitContent((InputContentInfo)paramInputContentInfoCompat.unwrap(), paramInt, paramBundle); 
    j = EditorInfoCompat.a(paramEditorInfo);
    if (j != 2) {
      i = bool;
      if (j != 3) {
        i = bool;
        if (j != 4)
          return false; 
      } 
    } else {
      i = 1;
    } 
    Bundle bundle = new Bundle();
    if (i != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    } 
    bundle.putParcelable(str, (Parcelable)paramInputContentInfoCompat.getContentUri());
    if (i != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    } 
    bundle.putParcelable(str, (Parcelable)paramInputContentInfoCompat.getDescription());
    if (i != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    } 
    bundle.putParcelable(str, (Parcelable)paramInputContentInfoCompat.getLinkUri());
    if (i != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    } 
    bundle.putInt(str, paramInt);
    if (i != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    } 
    bundle.putParcelable(str, (Parcelable)paramBundle);
    if (i != 0) {
      str = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    } else {
      str = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    } 
    return paramInputConnection.performPrivateCommand(str, bundle);
  }
  
  public static InputConnection createWrapper(InputConnection paramInputConnection, EditorInfo paramEditorInfo, OnCommitContentListener paramOnCommitContentListener) {
    if (paramInputConnection != null) {
      if (paramEditorInfo != null) {
        if (paramOnCommitContentListener != null)
          return (InputConnection)((Build.VERSION.SDK_INT >= 25) ? new InputConnectionWrapper(paramInputConnection, false, paramOnCommitContentListener) {
              public boolean commitContent(InputContentInfo param1InputContentInfo, int param1Int, Bundle param1Bundle) {
                return this.a.onCommitContent(InputContentInfoCompat.wrap(param1InputContentInfo), param1Int, param1Bundle) ? true : super.commitContent(param1InputContentInfo, param1Int, param1Bundle);
              }
            } : (((EditorInfoCompat.getContentMimeTypes(paramEditorInfo)).length == 0) ? paramInputConnection : new InputConnectionWrapper(paramInputConnection, false, paramOnCommitContentListener) {
              public boolean performPrivateCommand(String param1String, Bundle param1Bundle) {
                return InputConnectionCompat.a(param1String, param1Bundle, this.a) ? true : super.performPrivateCommand(param1String, param1Bundle);
              }
            })); 
        throw new IllegalArgumentException("onCommitContentListener must be non-null");
      } 
      throw new IllegalArgumentException("editorInfo must be non-null");
    } 
    throw new IllegalArgumentException("inputConnection must be non-null");
  }
  
  public static interface OnCommitContentListener {
    boolean onCommitContent(InputContentInfoCompat param1InputContentInfoCompat, int param1Int, Bundle param1Bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\inputmethod\InputConnectionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */