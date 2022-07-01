package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

public final class InputContentInfoCompat {
  private final InputContentInfoCompatImpl a;
  
  public InputContentInfoCompat(Uri paramUri1, ClipDescription paramClipDescription, Uri paramUri2) {
    if (Build.VERSION.SDK_INT >= 25) {
      this.a = new InputContentInfoCompatApi25Impl(paramUri1, paramClipDescription, paramUri2);
      return;
    } 
    this.a = new InputContentInfoCompatBaseImpl(paramUri1, paramClipDescription, paramUri2);
  }
  
  private InputContentInfoCompat(InputContentInfoCompatImpl paramInputContentInfoCompatImpl) {
    this.a = paramInputContentInfoCompatImpl;
  }
  
  public static InputContentInfoCompat wrap(Object paramObject) {
    return (paramObject == null) ? null : ((Build.VERSION.SDK_INT < 25) ? null : new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(paramObject)));
  }
  
  public Uri getContentUri() {
    return this.a.getContentUri();
  }
  
  public ClipDescription getDescription() {
    return this.a.getDescription();
  }
  
  public Uri getLinkUri() {
    return this.a.getLinkUri();
  }
  
  public void releasePermission() {
    this.a.releasePermission();
  }
  
  public void requestPermission() {
    this.a.requestPermission();
  }
  
  public Object unwrap() {
    return this.a.getInputContentInfo();
  }
  
  static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {
    final InputContentInfo a;
    
    InputContentInfoCompatApi25Impl(Uri param1Uri1, ClipDescription param1ClipDescription, Uri param1Uri2) {
      this.a = new InputContentInfo(param1Uri1, param1ClipDescription, param1Uri2);
    }
    
    InputContentInfoCompatApi25Impl(Object param1Object) {
      this.a = (InputContentInfo)param1Object;
    }
    
    public Uri getContentUri() {
      return this.a.getContentUri();
    }
    
    public ClipDescription getDescription() {
      return this.a.getDescription();
    }
    
    public Object getInputContentInfo() {
      return this.a;
    }
    
    public Uri getLinkUri() {
      return this.a.getLinkUri();
    }
    
    public void releasePermission() {
      this.a.releasePermission();
    }
    
    public void requestPermission() {
      this.a.requestPermission();
    }
  }
  
  static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {
    private final Uri a;
    
    private final ClipDescription b;
    
    private final Uri c;
    
    InputContentInfoCompatBaseImpl(Uri param1Uri1, ClipDescription param1ClipDescription, Uri param1Uri2) {
      this.a = param1Uri1;
      this.b = param1ClipDescription;
      this.c = param1Uri2;
    }
    
    public Uri getContentUri() {
      return this.a;
    }
    
    public ClipDescription getDescription() {
      return this.b;
    }
    
    public Object getInputContentInfo() {
      return null;
    }
    
    public Uri getLinkUri() {
      return this.c;
    }
    
    public void releasePermission() {}
    
    public void requestPermission() {}
  }
  
  static interface InputContentInfoCompatImpl {
    Uri getContentUri();
    
    ClipDescription getDescription();
    
    Object getInputContentInfo();
    
    Uri getLinkUri();
    
    void releasePermission();
    
    void requestPermission();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\inputmethod\InputContentInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */