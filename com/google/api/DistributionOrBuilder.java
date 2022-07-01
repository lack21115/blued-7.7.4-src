package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DistributionOrBuilder extends MessageOrBuilder {
  long getBucketCounts(int paramInt);
  
  int getBucketCountsCount();
  
  List<Long> getBucketCountsList();
  
  Distribution.BucketOptions getBucketOptions();
  
  Distribution.BucketOptionsOrBuilder getBucketOptionsOrBuilder();
  
  long getCount();
  
  Distribution.Exemplar getExemplars(int paramInt);
  
  int getExemplarsCount();
  
  List<Distribution.Exemplar> getExemplarsList();
  
  Distribution.ExemplarOrBuilder getExemplarsOrBuilder(int paramInt);
  
  List<? extends Distribution.ExemplarOrBuilder> getExemplarsOrBuilderList();
  
  double getMean();
  
  Distribution.Range getRange();
  
  Distribution.RangeOrBuilder getRangeOrBuilder();
  
  double getSumOfSquaredDeviation();
  
  boolean hasBucketOptions();
  
  boolean hasRange();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\DistributionOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */