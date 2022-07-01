package org.chromium.content_public.browser;

import java.util.ArrayList;

public class AccessibilitySnapshotNode {
  public int bgcolor;
  
  public boolean bold;
  
  public ArrayList children = new ArrayList();
  
  public String className;
  
  public int color;
  
  public int endSelection;
  
  public boolean hasSelection;
  
  public boolean hasStyle;
  
  public int height;
  
  public boolean isRootNode;
  
  public boolean italic;
  
  public boolean lineThrough;
  
  public int startSelection;
  
  public String text;
  
  public float textSize;
  
  public boolean underline;
  
  public int width;
  
  public int x;
  
  public int y;
  
  public AccessibilitySnapshotNode(String paramString1, String paramString2) {
    this.text = paramString1;
    this.className = paramString2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\AccessibilitySnapshotNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */