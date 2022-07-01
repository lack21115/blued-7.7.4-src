package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface QuotaOrBuilder extends MessageOrBuilder {
  QuotaLimit getLimits(int paramInt);
  
  int getLimitsCount();
  
  List<QuotaLimit> getLimitsList();
  
  QuotaLimitOrBuilder getLimitsOrBuilder(int paramInt);
  
  List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList();
  
  MetricRule getMetricRules(int paramInt);
  
  int getMetricRulesCount();
  
  List<MetricRule> getMetricRulesList();
  
  MetricRuleOrBuilder getMetricRulesOrBuilder(int paramInt);
  
  List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\QuotaOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */