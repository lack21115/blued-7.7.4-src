package com.blued.android.sdk.model;

public class UserModel {
  public int age;
  
  public String avatar;
  
  public String city_settled;
  
  public String height;
  
  public String name;
  
  public int relationship = 0;
  
  public String uid;
  
  public int weight;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[uid:");
    stringBuilder.append(this.uid);
    stringBuilder.append(", avatar:");
    stringBuilder.append(this.avatar);
    stringBuilder.append(", name:");
    stringBuilder.append(this.name);
    stringBuilder.append(", age:");
    stringBuilder.append(this.age);
    stringBuilder.append(", height:");
    stringBuilder.append(this.height);
    stringBuilder.append(", weight:");
    stringBuilder.append(this.weight);
    stringBuilder.append(", city_settled:");
    stringBuilder.append(this.city_settled);
    stringBuilder.append(", relationship:");
    stringBuilder.append(this.relationship);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\model\UserModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */