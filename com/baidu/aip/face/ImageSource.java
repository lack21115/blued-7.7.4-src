package com.baidu.aip.face;

import com.baidu.aip.ImageFrame;
import java.util.ArrayList;

public class ImageSource {
  private ArrayList<OnFrameAvailableListener> listeners = new ArrayList<OnFrameAvailableListener>();
  
  public void addOnFrameAvailableListener(OnFrameAvailableListener paramOnFrameAvailableListener) {
    this.listeners.add(paramOnFrameAvailableListener);
  }
  
  public ImageFrame borrowImageFrame() {
    return new ImageFrame();
  }
  
  protected ArrayList<OnFrameAvailableListener> getListeners() {
    return this.listeners;
  }
  
  public void removeOnFrameAvailableListener(OnFrameAvailableListener paramOnFrameAvailableListener) {
    if (paramOnFrameAvailableListener != null)
      this.listeners.remove(paramOnFrameAvailableListener); 
  }
  
  public void setPreviewView(PreviewView paramPreviewView) {}
  
  public void start() {}
  
  public void stop() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\ImageSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */