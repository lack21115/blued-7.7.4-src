package com.blued.android.sdk.model;

public class RelationshipModel {
  public int relationship;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[relationship:");
    stringBuilder.append(this.relationship);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\model\RelationshipModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */