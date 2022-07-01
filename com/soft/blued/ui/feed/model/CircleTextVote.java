package com.soft.blued.ui.feed.model;

import java.io.Serializable;

public class CircleTextVote implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public int count;
  
  public String option;
  
  public boolean select = false;
  
  public CircleTextVote() {}
  
  public CircleTextVote(String paramString) {
    this.option = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\CircleTextVote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */