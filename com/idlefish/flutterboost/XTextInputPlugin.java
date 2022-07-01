package com.idlefish.flutterboost;

import android.os.Build;
import android.provider.Settings;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public class XTextInputPlugin {
  private static XTextInputPlugin l;
  
  private View a;
  
  private InputMethodManager b;
  
  private TextInputChannel c;
  
  private InputTarget d = new InputTarget(InputTarget.Type.a, 0);
  
  private TextInputChannel.Configuration e;
  
  private Editable f;
  
  private boolean g;
  
  private InputConnection h;
  
  private PlatformViewsController i;
  
  private boolean j;
  
  private boolean k;
  
  public XTextInputPlugin(DartExecutor paramDartExecutor, PlatformViewsController paramPlatformViewsController) {
    this.c = new TextInputChannel(paramDartExecutor);
    this.c.requestExistingInputState();
    this.i = paramPlatformViewsController;
  }
  
  private static int a(TextInputChannel.InputType paramInputType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TextInputChannel.TextCapitalization paramTextCapitalization) {
    if (paramInputType.type == TextInputChannel.TextInputType.DATETIME)
      return 4; 
    if (paramInputType.type == TextInputChannel.TextInputType.NUMBER) {
      char c = '\002';
      if (paramInputType.isSigned)
        c = 'ဂ'; 
      int k = c;
      if (paramInputType.isDecimal)
        k = c | 0x2000; 
      return k;
    } 
    if (paramInputType.type == TextInputChannel.TextInputType.PHONE)
      return 3; 
    int i = 1;
    if (paramInputType.type == TextInputChannel.TextInputType.MULTILINE) {
      i = 131073;
    } else if (paramInputType.type == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
      i = 33;
    } else if (paramInputType.type == TextInputChannel.TextInputType.URL) {
      i = 17;
    } else if (paramInputType.type == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
      i = 145;
    } 
    if (paramBoolean1) {
      i = 0x80000 | i | 0x80;
    } else {
      int k = i;
      if (paramBoolean2)
        k = i | 0x8000; 
      if (!paramBoolean3) {
        i = 0x80000 | k;
      } else {
        i = k;
      } 
    } 
    if (paramTextCapitalization == TextInputChannel.TextCapitalization.CHARACTERS)
      return i | 0x1000; 
    if (paramTextCapitalization == TextInputChannel.TextCapitalization.WORDS)
      return i | 0x2000; 
    int j = i;
    if (paramTextCapitalization == TextInputChannel.TextCapitalization.SENTENCES)
      j = i | 0x4000; 
    return j;
  }
  
  public static XTextInputPlugin a(DartExecutor paramDartExecutor, PlatformViewsController paramPlatformViewsController) {
    XTextInputPlugin xTextInputPlugin = l;
    if (xTextInputPlugin != null)
      return xTextInputPlugin; 
    l = new XTextInputPlugin(paramDartExecutor, paramPlatformViewsController);
    return l;
  }
  
  private void a(int paramInt) {
    this.a.requestFocus();
    this.d = new InputTarget(InputTarget.Type.c, paramInt);
    this.b.restartInput(this.a);
    this.g = false;
  }
  
  private void a(TextInputChannel.TextEditState paramTextEditState) {
    int i = paramTextEditState.selectionStart;
    int j = paramTextEditState.selectionEnd;
    if (i >= 0 && i <= this.f.length() && j >= 0 && j <= this.f.length()) {
      Selection.setSelection((Spannable)this.f, i, j);
      return;
    } 
    Selection.removeSelection((Spannable)this.f);
  }
  
  private void c(View paramView) {
    paramView.requestFocus();
    this.b.showSoftInput(paramView, 0);
  }
  
  private void d(View paramView) {
    this.b.hideSoftInputFromWindow(paramView.getApplicationWindowToken(), 0);
  }
  
  private boolean d() {
    if (this.b.getCurrentInputMethodSubtype() != null && Build.VERSION.SDK_INT >= 21) {
      if (!Build.MANUFACTURER.equals("samsung"))
        return false; 
      String str = Settings.Secure.getString(this.a.getContext().getContentResolver(), "default_input_method");
      return (str == null) ? false : str.contains("Samsung");
    } 
    return false;
  }
  
  private void e() {
    if (this.d.a == InputTarget.Type.c)
      return; 
    this.d = new InputTarget(InputTarget.Type.a, 0);
    b();
  }
  
  public InputConnection a(View paramView, EditorInfo paramEditorInfo) {
    int i;
    if (this.d.a == InputTarget.Type.a) {
      this.h = null;
      return null;
    } 
    if (this.d.a == InputTarget.Type.c) {
      if (this.k)
        return this.h; 
      this.h = this.i.getPlatformViewById(Integer.valueOf(this.d.b)).onCreateInputConnection(paramEditorInfo);
      return this.h;
    } 
    paramEditorInfo.inputType = a(this.e.inputType, this.e.obscureText, this.e.autocorrect, this.e.enableSuggestions, this.e.textCapitalization);
    paramEditorInfo.imeOptions = 33554432;
    if (this.e.inputAction == null) {
      if ((0x20000 & paramEditorInfo.inputType) != 0) {
        i = 1;
      } else {
        i = 6;
      } 
    } else {
      i = this.e.inputAction.intValue();
    } 
    if (this.e.actionLabel != null) {
      paramEditorInfo.actionLabel = this.e.actionLabel;
      paramEditorInfo.actionId = i;
    } 
    paramEditorInfo.imeOptions = i | paramEditorInfo.imeOptions;
    XInputConnectionAdaptor xInputConnectionAdaptor = new XInputConnectionAdaptor(paramView, this.d.b, this.c, this.f);
    paramEditorInfo.initialSelStart = Selection.getSelectionStart((CharSequence)this.f);
    paramEditorInfo.initialSelEnd = Selection.getSelectionEnd((CharSequence)this.f);
    this.h = (InputConnection)xInputConnectionAdaptor;
    return this.h;
  }
  
  public InputMethodManager a() {
    return this.b;
  }
  
  void a(int paramInt, TextInputChannel.Configuration paramConfiguration) {
    this.d = new InputTarget(InputTarget.Type.b, paramInt);
    this.e = paramConfiguration;
    this.f = Editable.Factory.getInstance().newEditable("");
    this.g = true;
    b();
  }
  
  public void a(View paramView) {
    View view = this.a;
    if (view != null && view.hashCode() == paramView.hashCode())
      this.a = null; 
  }
  
  void a(View paramView, TextInputChannel.TextEditState paramTextEditState) {
    if (!this.j && !this.g && paramTextEditState.text.equals(this.f.toString())) {
      a(paramTextEditState);
      this.b.updateSelection(this.a, Math.max(Selection.getSelectionStart((CharSequence)this.f), 0), Math.max(Selection.getSelectionEnd((CharSequence)this.f), 0), BaseInputConnection.getComposingSpanStart((Spannable)this.f), BaseInputConnection.getComposingSpanEnd((Spannable)this.f));
      return;
    } 
    Editable editable = this.f;
    editable.replace(0, editable.length(), paramTextEditState.text);
    a(paramTextEditState);
    this.b.restartInput(paramView);
    this.g = false;
  }
  
  public void b() {
    this.k = false;
  }
  
  public void b(View paramView) {
    this.a = paramView;
    this.b = (InputMethodManager)paramView.getContext().getSystemService("input_method");
    this.c.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler(this) {
          public void clearClient() {
            XTextInputPlugin.b(this.a);
          }
          
          public void hide() {
            XTextInputPlugin xTextInputPlugin = this.a;
            XTextInputPlugin.b(xTextInputPlugin, XTextInputPlugin.a(xTextInputPlugin));
          }
          
          public void setClient(int param1Int, TextInputChannel.Configuration param1Configuration) {
            this.a.a(param1Int, param1Configuration);
          }
          
          public void setEditingState(TextInputChannel.TextEditState param1TextEditState) {
            XTextInputPlugin xTextInputPlugin = this.a;
            xTextInputPlugin.a(XTextInputPlugin.a(xTextInputPlugin), param1TextEditState);
          }
          
          public void setPlatformViewClient(int param1Int) {
            XTextInputPlugin.a(this.a, param1Int);
          }
          
          public void show() {
            XTextInputPlugin xTextInputPlugin = this.a;
            XTextInputPlugin.a(xTextInputPlugin, XTextInputPlugin.a(xTextInputPlugin));
          }
        });
    this.j = d();
  }
  
  public InputConnection c() {
    return this.h;
  }
  
  static class InputTarget {
    Type a;
    
    int b;
    
    public InputTarget(Type param1Type, int param1Int) {
      this.a = param1Type;
      this.b = param1Int;
    }
    
    enum Type {
      a, b, c;
    }
  }
  
  enum Type {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\XTextInputPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */