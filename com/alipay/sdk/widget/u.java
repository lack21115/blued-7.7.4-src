package com.alipay.sdk.widget;

import java.util.Iterator;
import java.util.Stack;

public class u {
  private Stack<p> a = new Stack<p>();
  
  public p a() {
    return this.a.pop();
  }
  
  public void a(p paramp) {
    this.a.push(paramp);
  }
  
  public boolean b() {
    return this.a.isEmpty();
  }
  
  public void c() {
    if (b())
      return; 
    Iterator<p> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((p)iterator.next()).a(); 
    this.a.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widge\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */