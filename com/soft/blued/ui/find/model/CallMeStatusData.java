package com.soft.blued.ui.find.model;

import java.io.Serializable;
import java.util.List;

public class CallMeStatusData implements Serializable {
  public int call_status;
  
  public int countdown;
  
  public String free_bubble;
  
  public int free_count;
  
  public int is_quietly;
  
  public float multiples;
  
  public int pay_count;
  
  public int promote_person_num;
  
  public List<Visitor> visitors;
  
  public int visits;
  
  public static class Visitor implements Serializable {
    public String avatar;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\CallMeStatusData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */