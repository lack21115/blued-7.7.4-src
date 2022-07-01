package com.blued.android.module.live_china.model;

import android.util.Log;
import com.chad.library.adapter.base.entity.MultiItemEntity;

public class LiveFunctionModel implements MultiItemEntity {
  public static final int FUNCTION_BEAUTY = 0;
  
  public static final int FUNCTION_CAMERA = 1;
  
  public static final int FUNCTION_FLASH = 3;
  
  public static final int FUNCTION_GESTURE = 5;
  
  public static final int FUNCTION_MIRROR = 2;
  
  public static final int FUNCTION_MUSIC = 9;
  
  public static final int FUNCTION_SHOP = 7;
  
  public static final int FUNCTION_STICKER = 6;
  
  public static final int FUNCTION_TITLE = 4;
  
  public static final int FUNCTION_TOP_CARD = 8;
  
  public static final int ITEM_TYPE_NORMAL = 0;
  
  public static final int ITEM_TYPE_TOP_CARD = 1;
  
  public int count;
  
  public int dot;
  
  public int function_type;
  
  public int icon;
  
  public int item_type;
  
  public String name;
  
  public LiveFunctionModel(int paramInt1, String paramString, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("function_type:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" name:");
    stringBuilder.append(paramString);
    Log.i("==abc", stringBuilder.toString());
    this.function_type = paramInt1;
    this.name = paramString;
    this.icon = paramInt2;
  }
  
  public LiveFunctionModel(int paramInt1, String paramString, int paramInt2, int paramInt3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("function_type:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" name:");
    stringBuilder.append(paramString);
    stringBuilder.append(" dot:");
    stringBuilder.append(paramInt3);
    Log.i("==abc", stringBuilder.toString());
    this.function_type = paramInt1;
    this.name = paramString;
    this.icon = paramInt2;
    this.dot = paramInt3;
  }
  
  public LiveFunctionModel(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("function_type:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" name:");
    stringBuilder.append(paramString);
    stringBuilder.append(" dot:");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" count:");
    stringBuilder.append(paramInt4);
    Log.i("==abc", stringBuilder.toString());
    this.function_type = paramInt1;
    this.name = paramString;
    this.icon = paramInt2;
    this.dot = paramInt3;
    this.count = paramInt4;
  }
  
  public int getItemType() {
    return this.item_type;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveFunctionModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */