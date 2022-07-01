package com.soft.blued.ui.msg.model;

import com.blued.das.message.MessageProtos;
import java.io.Serializable;

public class MsgSourceEntity implements Serializable {
  private String content;
  
  private int type;
  
  public MsgSourceEntity(MessageProtos.StrangerSource paramStrangerSource) {
    this.type = paramStrangerSource.getNumber();
    this.content = "";
  }
  
  public MsgSourceEntity(MessageProtos.StrangerSource paramStrangerSource, String paramString) {
    this.type = paramStrangerSource.getNumber();
    this.content = paramString;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public MessageProtos.StrangerSource getType() {
    MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.forNumber(this.type);
    return (strangerSource != null) ? strangerSource : MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
  }
  
  public void setContent(String paramString) {
    this.content = paramString;
  }
  
  public void setType(int paramInt) {
    this.type = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MsgSourceEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */