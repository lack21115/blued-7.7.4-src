package com.soft.blued.view.tip;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class CommonDialog extends Dialog {
  private static int b = 2131820806;
  
  private Activity a;
  
  private String c;
  
  private String d;
  
  private TextView e;
  
  private TextView f;
  
  private Button g;
  
  private Button h;
  
  private ScrollView i;
  
  private String j;
  
  private String k;
  
  private View.OnClickListener l;
  
  private View.OnClickListener m;
  
  private int n;
  
  private CancelDialogListener o;
  
  private boolean p;
  
  public void cancel() {
    super.cancel();
    CancelDialogListener cancelDialogListener = this.o;
    if (cancelDialogListener != null)
      cancelDialogListener.a(); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492938);
    setCanceledOnTouchOutside(this.p);
    this.g = (Button)findViewById(2131296804);
    this.h = (Button)findViewById(2131296806);
    this.f = (TextView)findViewById(2131296808);
    this.e = (TextView)findViewById(2131296805);
    this.i = (ScrollView)findViewById(2131296807);
    int i = this.n;
    if (i > 0) {
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i);
      this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    this.g.setText(this.j);
    this.h.setText(this.k);
    this.f.setText(this.d);
    this.e.setText(this.c);
    if (this.l == null) {
      this.g.setVisibility(8);
    } else {
      this.g.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              CommonDialog.a(this.a).setEnabled(false);
              if (CommonDialog.b(this.a) == null)
                return; 
              if (!CommonDialog.b(this.a).isFinishing() && this.a.isShowing())
                this.a.dismiss(); 
              if (CommonDialog.c(this.a) != null)
                CommonDialog.c(this.a).onClick(param1View); 
            }
          });
    } 
    this.h.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CommonDialog.d(this.a).setEnabled(false);
            if (CommonDialog.b(this.a) == null)
              return; 
            if (!CommonDialog.b(this.a).isFinishing() && this.a.isShowing())
              this.a.dismiss(); 
            if (CommonDialog.e(this.a) != null)
              CommonDialog.e(this.a).onClick(param1View); 
          }
        });
  }
  
  public static interface CancelDialogListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\CommonDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */