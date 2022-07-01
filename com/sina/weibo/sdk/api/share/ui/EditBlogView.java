package com.sina.weibo.sdk.api.share.ui;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditBlogView extends EditText {
  private boolean canSelectionChanged = true;
  
  private int count;
  
  private Context ctx;
  
  private List<OnSelectionListener> listeners;
  
  private OnEnterListener mOnEnterListener;
  
  public EditBlogView(Context paramContext) {
    super(paramContext);
    init();
  }
  
  public EditBlogView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public EditBlogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init() {
    this.ctx = getContext();
    this.listeners = new ArrayList<OnSelectionListener>();
  }
  
  public int correctPosition(int paramInt) {
    if (paramInt == -1)
      return paramInt; 
    Editable editable = getText();
    if (paramInt >= editable.length())
      return paramInt; 
    Object[] arrayOfObject = editable.getSpans(paramInt, paramInt, ImageSpan.class);
    int i = paramInt;
    if (arrayOfObject != null) {
      i = paramInt;
      if (arrayOfObject.length != 0) {
        i = paramInt;
        if (paramInt != editable.getSpanStart(arrayOfObject[0]))
          i = editable.getSpanEnd(arrayOfObject[0]); 
      } 
    } 
    return i;
  }
  
  public void enableSelectionChanged(boolean paramBoolean) {
    this.canSelectionChanged = paramBoolean;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return (InputConnection)new InputConnectionWrapper(super.onCreateInputConnection(paramEditorInfo), false) {
        public boolean commitText(CharSequence param1CharSequence, int param1Int) {
          Editable editable = EditBlogView.this.getEditableText();
          new String(editable.toString());
          int i = Selection.getSelectionStart((CharSequence)editable);
          int j = Selection.getSelectionEnd((CharSequence)editable);
          if (i != -1 && j != -1) {
            int n = EditBlogView.this.correctPosition(i);
            int k = EditBlogView.this.correctPosition(j);
            int i1 = n;
            int m = k;
            if (n > k) {
              m = n;
              i1 = k;
            } 
            if (i1 != i || m != j)
              Selection.setSelection((Spannable)editable, i1, m); 
            if (i1 != m)
              EditBlogView.this.getText().delete(i1, m); 
          } 
          return super.commitText(param1CharSequence, param1Int);
        }
        
        public boolean setComposingText(CharSequence param1CharSequence, int param1Int) {
          Editable editable = EditBlogView.this.getEditableText();
          new String(editable.toString());
          int i = Selection.getSelectionStart((CharSequence)editable);
          int j = Selection.getSelectionEnd((CharSequence)editable);
          if (i != -1 && j != -1) {
            int n = EditBlogView.this.correctPosition(i);
            int k = EditBlogView.this.correctPosition(j);
            int i1 = n;
            int m = k;
            if (n > k) {
              m = n;
              i1 = k;
            } 
            if (i1 != i || m != j)
              Selection.setSelection((Spannable)editable, i1, m); 
            if (i1 != m)
              EditBlogView.this.getText().delete(i1, m); 
          } 
          return super.setComposingText(param1CharSequence, param1Int);
        }
      };
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 66) {
      OnEnterListener onEnterListener = this.mOnEnterListener;
      if (onEnterListener != null)
        onEnterListener.onEnterKey(); 
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2) {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (this.canSelectionChanged) {
      List<OnSelectionListener> list = this.listeners;
      if (list != null) {
        if (list.isEmpty())
          return; 
        Iterator<OnSelectionListener> iterator = this.listeners.iterator();
        while (true) {
          if (!iterator.hasNext())
            return; 
          ((OnSelectionListener)iterator.next()).onSelectionChanged(paramInt1, paramInt2);
        } 
      } 
    } 
  }
  
  public void setOnEnterListener(OnEnterListener paramOnEnterListener) {
    this.mOnEnterListener = paramOnEnterListener;
  }
  
  public void setOnSelectionListener(OnSelectionListener paramOnSelectionListener) {
    this.listeners.add(paramOnSelectionListener);
  }
  
  public static interface OnEnterListener {
    void onEnterKey();
  }
  
  public static interface OnSelectionListener {
    void onSelectionChanged(int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\shar\\ui\EditBlogView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */