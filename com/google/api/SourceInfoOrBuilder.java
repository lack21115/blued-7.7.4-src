package com.google.api;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface SourceInfoOrBuilder extends MessageOrBuilder {
  Any getSourceFiles(int paramInt);
  
  int getSourceFilesCount();
  
  List<Any> getSourceFilesList();
  
  AnyOrBuilder getSourceFilesOrBuilder(int paramInt);
  
  List<? extends AnyOrBuilder> getSourceFilesOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\SourceInfoOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */