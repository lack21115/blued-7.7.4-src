package com.idlefish.flutterboost;

import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;

class XInputConnectionAdaptor extends BaseInputConnection {
  private final View a;
  
  private final int b;
  
  private final TextInputChannel c;
  
  private final Editable d;
  
  private int e;
  
  private InputMethodManager f;
  
  private final Layout g;
  
  public XInputConnectionAdaptor(View paramView, int paramInt, TextInputChannel paramTextInputChannel, Editable paramEditable) {
    super(paramView, true);
    this.a = paramView;
    this.b = paramInt;
    this.c = paramTextInputChannel;
    this.d = paramEditable;
    this.e = 0;
    this.g = (Layout)new DynamicLayout((CharSequence)this.d, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.f = (InputMethodManager)paramView.getContext().getSystemService("input_method");
  }
  
  private static int a(int paramInt, Editable paramEditable) {
    int i = Math.max(0, Math.min(paramEditable.length(), paramInt));
    if (i != paramInt) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Text selection index was clamped (");
      stringBuilder.append(paramInt);
      stringBuilder.append("->");
      stringBuilder.append(i);
      stringBuilder.append(") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
      Log.d("flutter", stringBuilder.toString());
    } 
    return i;
  }
  
  private void a() {
    if (this.e > 0)
      return; 
    int i = Selection.getSelectionStart((CharSequence)this.d);
    int j = Selection.getSelectionEnd((CharSequence)this.d);
    int k = BaseInputConnection.getComposingSpanStart((Spannable)this.d);
    int m = BaseInputConnection.getComposingSpanEnd((Spannable)this.d);
    this.f.updateSelection(this.a, i, j, k, m);
    this.c.updateEditingState(this.b, this.d.toString(), i, j, k, m);
  }
  
  public boolean beginBatchEdit() {
    this.e++;
    return super.beginBatchEdit();
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt) {
    boolean bool = super.commitText(paramCharSequence, paramInt);
    a();
    return bool;
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2) {
    if (Selection.getSelectionStart((CharSequence)this.d) == -1)
      return true; 
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    a();
    return bool;
  }
  
  public boolean endBatchEdit() {
    boolean bool = super.endBatchEdit();
    this.e--;
    a();
    return bool;
  }
  
  public Editable getEditable() {
    return this.d;
  }
  
  public boolean performEditorAction(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 4) {
              if (paramInt != 5) {
                if (paramInt != 7) {
                  this.c.done(this.b);
                  return true;
                } 
                this.c.previous(this.b);
                return true;
              } 
              this.c.next(this.b);
              return true;
            } 
            this.c.send(this.b);
            return true;
          } 
          this.c.search(this.b);
          return true;
        } 
        this.c.go(this.b);
        return true;
      } 
      this.c.newline(this.b);
      return true;
    } 
    this.c.unspecifiedAction(this.b);
    return true;
  }
  
  public boolean sendKeyEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0)
      if (paramKeyEvent.getKeyCode() == 67) {
        int i = a(Selection.getSelectionStart((CharSequence)this.d), this.d);
        int j = a(Selection.getSelectionEnd((CharSequence)this.d), this.d);
        if (j > i) {
          Selection.setSelection((Spannable)this.d, i);
          this.d.delete(i, j);
          a();
          return true;
        } 
        if (i > 0) {
          Layout layout = this.g;
          if (layout.isRtlCharAt(layout.getLineForOffset(i))) {
            try {
              Selection.extendRight((Spannable)this.d, this.g);
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
              Selection.setSelection((Spannable)this.d, i, i - 1);
            } 
          } else {
            Selection.extendLeft((Spannable)this.d, this.g);
          } 
          i = a(Selection.getSelectionStart((CharSequence)this.d), this.d);
          j = a(Selection.getSelectionEnd((CharSequence)this.d), this.d);
          Selection.setSelection((Spannable)this.d, Math.min(i, j));
          this.d.delete(Math.min(i, j), Math.max(i, j));
          a();
          return true;
        } 
      } else {
        if (indexOutOfBoundsException.getKeyCode() == 21) {
          int j = Math.max(Selection.getSelectionStart((CharSequence)this.d) - 1, 0);
          setSelection(j, j);
          return true;
        } 
        if (indexOutOfBoundsException.getKeyCode() == 22) {
          int j = Math.min(Selection.getSelectionStart((CharSequence)this.d) + 1, this.d.length());
          setSelection(j, j);
          return true;
        } 
        int i = indexOutOfBoundsException.getUnicodeChar();
        if (i != 0) {
          int j = Math.max(0, Selection.getSelectionStart((CharSequence)this.d));
          int k = Math.max(0, Selection.getSelectionEnd((CharSequence)this.d));
          if (k != j)
            this.d.delete(j, k); 
          this.d.insert(j, String.valueOf((char)i));
          i = j + 1;
          setSelection(i, i);
        } 
        return true;
      }  
    return false;
  }
  
  public boolean setComposingRegion(int paramInt1, int paramInt2) {
    boolean bool = super.setComposingRegion(paramInt1, paramInt2);
    a();
    return bool;
  }
  
  public boolean setComposingText(CharSequence paramCharSequence, int paramInt) {
    boolean bool;
    if (paramCharSequence.length() == 0) {
      bool = super.commitText(paramCharSequence, paramInt);
    } else {
      bool = super.setComposingText(paramCharSequence, paramInt);
    } 
    a();
    return bool;
  }
  
  public boolean setSelection(int paramInt1, int paramInt2) {
    boolean bool = super.setSelection(paramInt1, paramInt2);
    a();
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\XInputConnectionAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */