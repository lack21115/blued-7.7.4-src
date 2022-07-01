package com.google.rpc;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface HelpOrBuilder extends MessageOrBuilder {
  Help.Link getLinks(int paramInt);
  
  int getLinksCount();
  
  List<Help.Link> getLinksList();
  
  Help.LinkOrBuilder getLinksOrBuilder(int paramInt);
  
  List<? extends Help.LinkOrBuilder> getLinksOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\HelpOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */