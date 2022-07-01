package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DocumentationOrBuilder extends MessageOrBuilder {
  String getDocumentationRootUrl();
  
  ByteString getDocumentationRootUrlBytes();
  
  String getOverview();
  
  ByteString getOverviewBytes();
  
  Page getPages(int paramInt);
  
  int getPagesCount();
  
  List<Page> getPagesList();
  
  PageOrBuilder getPagesOrBuilder(int paramInt);
  
  List<? extends PageOrBuilder> getPagesOrBuilderList();
  
  DocumentationRule getRules(int paramInt);
  
  int getRulesCount();
  
  List<DocumentationRule> getRulesList();
  
  DocumentationRuleOrBuilder getRulesOrBuilder(int paramInt);
  
  List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList();
  
  String getSummary();
  
  ByteString getSummaryBytes();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\DocumentationOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */