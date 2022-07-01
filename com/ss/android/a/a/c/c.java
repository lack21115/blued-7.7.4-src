package com.ss.android.a.a.c;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

public class c {
  public Context a;
  
  public String b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public boolean f = true;
  
  public Drawable g;
  
  public b h;
  
  public View i;
  
  public int j;
  
  private c(a parama) {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.i = parama.a;
    this.j = parama.b;
  }
  
  public static final class a {
    public View a;
    
    public int b;
    
    private Context c;
    
    private String d;
    
    private String e;
    
    private String f;
    
    private String g;
    
    private boolean h;
    
    private Drawable i;
    
    private c.b j;
    
    public a(Context param1Context) {
      this.c = param1Context;
    }
    
    public a a(int param1Int) {
      this.b = param1Int;
      return this;
    }
    
    public a a(Drawable param1Drawable) {
      this.i = param1Drawable;
      return this;
    }
    
    public a a(c.b param1b) {
      this.j = param1b;
      return this;
    }
    
    public a a(String param1String) {
      this.d = param1String;
      return this;
    }
    
    public a a(boolean param1Boolean) {
      this.h = param1Boolean;
      return this;
    }
    
    public c a() {
      return new c(this);
    }
    
    public a b(String param1String) {
      this.e = param1String;
      return this;
    }
    
    public a c(String param1String) {
      this.f = param1String;
      return this;
    }
    
    public a d(String param1String) {
      this.g = param1String;
      return this;
    }
  }
  
  public static interface b {
    void a(DialogInterface param1DialogInterface);
    
    void b(DialogInterface param1DialogInterface);
    
    void c(DialogInterface param1DialogInterface);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\a\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */