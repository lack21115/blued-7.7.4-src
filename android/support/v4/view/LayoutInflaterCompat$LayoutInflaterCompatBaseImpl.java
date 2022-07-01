package android.support.v4.view;

import android.view.LayoutInflater;

class LayoutInflaterCompat$LayoutInflaterCompatBaseImpl {
  public void setFactory2(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2) {
    paramLayoutInflater.setFactory2(paramFactory2);
    LayoutInflater.Factory factory = paramLayoutInflater.getFactory();
    if (factory instanceof LayoutInflater.Factory2) {
      LayoutInflaterCompat.forceSetFactory2(paramLayoutInflater, (LayoutInflater.Factory2)factory);
      return;
    } 
    LayoutInflaterCompat.forceSetFactory2(paramLayoutInflater, paramFactory2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\LayoutInflaterCompat$LayoutInflaterCompatBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */