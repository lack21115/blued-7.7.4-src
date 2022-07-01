package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import java.util.ArrayList;

public class TTDislikeListView extends ListView {
  private k a;
  
  private AdapterView.OnItemClickListener b;
  
  private AdapterView.OnItemClickListener c = new AdapterView.OnItemClickListener(this) {
      public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
        if (this.a.getAdapter() != null && this.a.getAdapter().getItem(param1Int) != null && this.a.getAdapter().getItem(param1Int) instanceof FilterWord) {
          FilterWord filterWord = (FilterWord)this.a.getAdapter().getItem(param1Int);
          if (!filterWord.hasSecondOptions()) {
            ArrayList<FilterWord> arrayList = new ArrayList();
            arrayList.add(filterWord);
            if (TTDislikeListView.a(this.a) != null)
              d.a(TTDislikeListView.a(this.a), arrayList); 
          } 
          try {
            return;
          } finally {
            param1AdapterView = null;
          } 
        } 
        throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
      }
    };
  
  public TTDislikeListView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public TTDislikeListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TTDislikeListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    super.setOnItemClickListener(this.c);
  }
  
  public void setMaterialMeta(k paramk) {
    this.a = paramk;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.b = paramOnItemClickListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\dislike\TTDislikeListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */