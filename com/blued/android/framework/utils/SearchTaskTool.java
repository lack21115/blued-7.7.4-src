package com.blued.android.framework.utils;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchTaskTool implements TextWatcher, TextView.OnEditorActionListener {
  private long a = 500L;
  
  private List<TaskListener> b;
  
  private EditText c;
  
  private String d;
  
  private Handler e = new Handler(new Handler.Callback(this) {
        public boolean handleMessage(Message param1Message) {
          if (param1Message.obj != null) {
            String str = param1Message.obj.toString();
            if (param1Message.what == 1)
              SearchTaskTool.a(this.a, str); 
          } 
          return false;
        }
      });
  
  public SearchTaskTool(EditText paramEditText) {
    this.c = paramEditText;
    b();
  }
  
  private void a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      this.d = paramString.replaceAll("\\r\\n", "").replaceAll("\\n", "");
    } else {
      this.d = "";
    } 
    List<TaskListener> list = this.b;
    if (list != null && list.size() > 0) {
      Iterator<TaskListener> iterator = this.b.iterator();
      while (iterator.hasNext())
        ((TaskListener)iterator.next()).a(paramString); 
    } 
  }
  
  private void a(String paramString, long paramLong) {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (!bool)
      str = paramString.replaceAll("\\r\\n", "").replaceAll("\\n", ""); 
    if (TextUtils.isEmpty(this.d) || !str.equals(this.d)) {
      List<TaskListener> list = this.b;
      if (list != null && list.size() > 0) {
        Handler handler = this.e;
        if (handler == null)
          return; 
        handler.removeMessages(1);
        Message message = this.e.obtainMessage();
        message.what = 1;
        message.obj = paramString;
        if (paramLong > 0L) {
          this.e.sendMessageDelayed(message, paramLong);
          return;
        } 
        this.e.sendMessage(message);
      } 
    } 
  }
  
  private void b() {
    this.b = new ArrayList<TaskListener>();
    EditText editText = this.c;
    if (editText != null)
      editText.addTextChangedListener(this); 
  }
  
  private void b(String paramString) {
    a(paramString, 0L);
  }
  
  public void a() {
    Handler handler = this.e;
    if (handler != null)
      handler.removeMessages(1); 
  }
  
  public void a(long paramLong) {
    this.a = paramLong;
  }
  
  public void a(TaskListener paramTaskListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/List;
    //   6: ifnull -> 20
    //   9: aload_0
    //   10: getfield b : Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface add : (Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	23	finally
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      EditText editText = this.c;
      if (editText != null)
        editText.setOnEditorActionListener(this); 
    } 
  }
  
  public void afterTextChanged(Editable paramEditable) {
    if (!TextUtils.isEmpty(paramEditable.toString())) {
      a(paramEditable.toString(), this.a);
      return;
    } 
    b(paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 3 || paramInt == 6 || (paramKeyEvent != null && paramKeyEvent.getKeyCode() == 0)) {
      b(paramTextView.getText().toString());
      return true;
    } 
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static interface TaskListener {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\SearchTaskTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */