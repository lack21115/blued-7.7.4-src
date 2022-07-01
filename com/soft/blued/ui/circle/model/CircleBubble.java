package com.soft.blued.ui.circle.model;

import android.text.TextUtils;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;

public class CircleBubble extends BluedEntityBaseExtra implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public String bubbleId;
  
  public String bubble_code;
  
  public String img;
  
  public String link;
  
  public String title;
  
  public String getMarkDownLink() {
    if (TextUtils.isEmpty(this.title))
      return ""; 
    if (TextUtils.isEmpty(this.link))
      return this.title; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append(this.title);
    stringBuilder.append("](");
    stringBuilder.append(this.link);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\model\CircleBubble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */