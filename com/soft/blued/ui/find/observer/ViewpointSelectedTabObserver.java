package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.List;

public class ViewpointSelectedTabObserver {
  private static ViewpointSelectedTabObserver a = new ViewpointSelectedTabObserver();
  
  private List<IViewpointSelectedTabObserver> b = new ArrayList<IViewpointSelectedTabObserver>();
  
  public static interface IViewpointSelectedTabObserver {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\observer\ViewpointSelectedTabObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */