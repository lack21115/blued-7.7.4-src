package com.blued.android.module.media.selector.observer;

import java.util.ArrayList;

public class ScaleChangeObserver {
  private static ScaleChangeObserver a = new ScaleChangeObserver();
  
  private ArrayList<IScaleChangeObserver> b = new ArrayList<IScaleChangeObserver>();
  
  public static interface IScaleChangeObserver {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\observer\ScaleChangeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */