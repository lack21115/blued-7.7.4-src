package com.soft.blued.ui.find.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.List;

public class VisitorCountExtra extends BluedEntityBaseExtra {
  public long history;
  
  public List<_history_track> history_track;
  
  public long increase;
  
  public String label;
  
  public int new_user;
  
  public int ratio;
  
  public int show_shadow_btn;
  
  public long today;
  
  public int visitors_is_complete_rate;
  
  public static class _history_track {
    public long count;
    
    public String date;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\VisitorCountExtra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */