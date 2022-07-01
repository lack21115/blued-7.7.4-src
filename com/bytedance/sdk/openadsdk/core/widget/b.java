package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ab;

public class b extends AlertDialog {
  private TextView a;
  
  private TextView b;
  
  private Button c;
  
  private Button d;
  
  private Context e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private Drawable j;
  
  private a k;
  
  public b(Context paramContext) {
    super(paramContext, ab.g(paramContext, "tt_custom_dialog"));
    this.e = paramContext;
  }
  
  private void a() {
    this.a = (TextView)findViewById(ab.e(this.e, "tt_install_title"));
    this.b = (TextView)findViewById(ab.e(this.e, "tt_install_content"));
    this.c = (Button)findViewById(ab.e(this.e, "tt_install_btn_yes"));
    this.d = (Button)findViewById(ab.e(this.e, "tt_install_btn_no"));
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.dismiss();
            if (b.a(this.a) != null)
              b.a(this.a).a((Dialog)this.a); 
          }
        });
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.dismiss();
            if (b.a(this.a) != null)
              b.a(this.a).b((Dialog)this.a); 
          }
        });
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Landroid/widget/TextView;
    //   4: astore #5
    //   6: aload #5
    //   8: ifnull -> 128
    //   11: aload #5
    //   13: aload_0
    //   14: getfield f : Ljava/lang/String;
    //   17: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   20: aload_0
    //   21: getfield j : Landroid/graphics/drawable/Drawable;
    //   24: astore #5
    //   26: aload #5
    //   28: ifnull -> 128
    //   31: aload #5
    //   33: invokevirtual getIntrinsicWidth : ()I
    //   36: istore_3
    //   37: aload_0
    //   38: getfield j : Landroid/graphics/drawable/Drawable;
    //   41: invokevirtual getIntrinsicHeight : ()I
    //   44: istore #4
    //   46: aload_0
    //   47: getfield e : Landroid/content/Context;
    //   50: ldc 45.0
    //   52: invokestatic c : (Landroid/content/Context;F)I
    //   55: istore_1
    //   56: iload_3
    //   57: iload_1
    //   58: if_icmpgt -> 68
    //   61: iload_3
    //   62: istore_2
    //   63: iload_3
    //   64: iload_1
    //   65: if_icmpge -> 70
    //   68: iload_1
    //   69: istore_2
    //   70: iload #4
    //   72: iload_1
    //   73: if_icmpgt -> 85
    //   76: iload #4
    //   78: istore_3
    //   79: iload #4
    //   81: iload_1
    //   82: if_icmpge -> 87
    //   85: iload_1
    //   86: istore_3
    //   87: aload_0
    //   88: getfield j : Landroid/graphics/drawable/Drawable;
    //   91: iconst_0
    //   92: iconst_0
    //   93: iload_2
    //   94: iload_3
    //   95: invokevirtual setBounds : (IIII)V
    //   98: aload_0
    //   99: getfield a : Landroid/widget/TextView;
    //   102: aload_0
    //   103: getfield j : Landroid/graphics/drawable/Drawable;
    //   106: aconst_null
    //   107: aconst_null
    //   108: aconst_null
    //   109: invokevirtual setCompoundDrawables : (Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   112: aload_0
    //   113: getfield a : Landroid/widget/TextView;
    //   116: aload_0
    //   117: getfield e : Landroid/content/Context;
    //   120: ldc 10.0
    //   122: invokestatic c : (Landroid/content/Context;F)I
    //   125: invokevirtual setCompoundDrawablePadding : (I)V
    //   128: aload_0
    //   129: getfield b : Landroid/widget/TextView;
    //   132: astore #5
    //   134: aload #5
    //   136: ifnull -> 148
    //   139: aload #5
    //   141: aload_0
    //   142: getfield g : Ljava/lang/String;
    //   145: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   148: aload_0
    //   149: getfield c : Landroid/widget/Button;
    //   152: astore #5
    //   154: aload #5
    //   156: ifnull -> 168
    //   159: aload #5
    //   161: aload_0
    //   162: getfield h : Ljava/lang/String;
    //   165: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   168: aload_0
    //   169: getfield d : Landroid/widget/Button;
    //   172: astore #5
    //   174: aload #5
    //   176: ifnull -> 188
    //   179: aload #5
    //   181: aload_0
    //   182: getfield i : Ljava/lang/String;
    //   185: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   188: return
  }
  
  public b a(DialogInterface.OnCancelListener paramOnCancelListener) {
    setOnCancelListener(paramOnCancelListener);
    return this;
  }
  
  public b a(Drawable paramDrawable) {
    this.j = paramDrawable;
    return this;
  }
  
  public b a(a parama) {
    this.k = parama;
    return this;
  }
  
  public b a(String paramString) {
    this.f = paramString;
    return this;
  }
  
  public b b(String paramString) {
    this.g = paramString;
    return this;
  }
  
  public b c(String paramString) {
    this.h = paramString;
    return this;
  }
  
  public b d(String paramString) {
    this.i = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(ab.f(this.e, "tt_install_dialog_layout"));
    setCanceledOnTouchOutside(true);
    a();
  }
  
  public void show() {
    super.show();
    b();
  }
  
  public static interface a {
    void a(Dialog param1Dialog);
    
    void b(Dialog param1Dialog);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */