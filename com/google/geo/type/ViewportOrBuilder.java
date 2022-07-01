package com.google.geo.type;

import com.google.protobuf.MessageOrBuilder;
import com.google.type.LatLng;
import com.google.type.LatLngOrBuilder;

public interface ViewportOrBuilder extends MessageOrBuilder {
  LatLng getHigh();
  
  LatLngOrBuilder getHighOrBuilder();
  
  LatLng getLow();
  
  LatLngOrBuilder getLowOrBuilder();
  
  boolean hasHigh();
  
  boolean hasLow();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\geo\type\ViewportOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */