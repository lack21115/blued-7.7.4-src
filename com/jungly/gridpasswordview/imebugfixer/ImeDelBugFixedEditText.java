package com.jungly.gridpasswordview.imebugfixer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

public class ImeDelBugFixedEditText extends EditText {
  private OnDelKeyEventListener a;
  
  public ImeDelBugFixedEditText(Context paramContext) {
    super(paramContext);
  }
  
  public ImeDelBugFixedEditText(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public ImeDelBugFixedEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return (InputConnection)new ZanyInputConnection(this, super.onCreateInputConnection(paramEditorInfo), true);
  }
  
  public void setDelKeyEventListener(OnDelKeyEventListener paramOnDelKeyEventListener) {
    this.a = paramOnDelKeyEventListener;
  }
  
  public static interface OnDelKeyEventListener {
    void a();
  }
  
  class ZanyInputConnection extends InputConnectionWrapper {
    public ZanyInputConnection(ImeDelBugFixedEditText this$0, InputConnection param1InputConnection, boolean param1Boolean) {
      super(param1InputConnection, param1Boolean);
    }
    
    public boolean deleteSurroundingText(int param1Int1, int param1Int2) {
      return (param1Int1 == 1 && param1Int2 == 0) ? ((sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67)))) : super.deleteSurroundingText(param1Int1, param1Int2);
    }
    
    public boolean sendKeyEvent(KeyEvent param1KeyEvent) {
      if (param1KeyEvent.getAction() == 0 && param1KeyEvent.getKeyCode() == 67 && ImeDelBugFixedEditText.a(this.a) != null) {
        ImeDelBugFixedEditText.a(this.a).a();
        return true;
      } 
      return super.sendKeyEvent(param1KeyEvent);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jungly\gridpasswordview\imebugfixer\ImeDelBugFixedEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */