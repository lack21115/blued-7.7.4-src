package com.blued.android.module.shortvideo.observer;

import java.util.ArrayList;

public class PLVideoObserver {
  private static PLVideoObserver a = new PLVideoObserver();
  
  private ArrayList<IPLVideoObserver> b = new ArrayList<IPLVideoObserver>();
  
  public static interface IPLVideoObserver {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\observer\PLVideoObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */