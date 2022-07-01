package com.soft.blued.ui.live.manager;

import java.util.ArrayList;

public class LivingCountRefreshObserver {
  private static LivingCountRefreshObserver a = new LivingCountRefreshObserver();
  
  private ArrayList<ILivingCountRefreshObserver> b = new ArrayList<ILivingCountRefreshObserver>();
  
  public static interface ILivingCountRefreshObserver {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\manager\LivingCountRefreshObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */