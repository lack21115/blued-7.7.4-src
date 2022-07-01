package com.soft.blued.ui.msg.model;

import java.util.List;

public class MsgContentTranslatedEntity {
  public String from;
  
  public String to;
  
  public List<TranslateResult> trans_result;
  
  public class TranslateResult {
    public String dst;
    
    public String src;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MsgContentTranslatedEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */