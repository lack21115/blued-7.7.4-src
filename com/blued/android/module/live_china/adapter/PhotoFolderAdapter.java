package com.blued.android.module.live_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import java.util.List;

public class PhotoFolderAdapter extends BaseAdapter {
  private List<String> a;
  
  public PhotoFolderAdapter(List<String> paramList) {
    this.a = paramList;
  }
  
  public String a(int paramInt) {
    return this.a.get(paramInt);
  }
  
  public int getCount() {
    List<String> list = this.a;
    return (list == null) ? 0 : list.size();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    PhotoHolder photoHolder;
    if (paramView == null) {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.item_photo_folder_layout, paramViewGroup, false);
      photoHolder = new PhotoHolder();
      paramView.setTag(photoHolder);
      photoHolder.a = (TextView)paramView.findViewById(R.id.tv_folder_name);
    } else {
      photoHolder = (PhotoHolder)paramView.getTag();
    } 
    photoHolder.a.setText(this.a.get(paramInt));
    return paramView;
  }
  
  static class PhotoHolder {
    public TextView a;
    
    private PhotoHolder() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\PhotoFolderAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */