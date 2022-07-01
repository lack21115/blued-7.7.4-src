package com.soft.blued.ui.video.observer;

import java.util.ArrayList;

public class PLVideoObserver {
  private static PLVideoObserver a = new PLVideoObserver();
  
  private ArrayList<IPLVideoObserver> b = new ArrayList<IPLVideoObserver>();
  
  public static interface IPLVideoObserver {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\observer\PLVideoObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */