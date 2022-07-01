package com.blued.android.framework.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatEditText;
import com.blued.android.framework.utils.SearchTaskTool;

public class SearchEditText extends AppCompatEditText {
  private SearchTaskTool a;
  
  public SearchEditText(Context paramContext) {
    this(paramContext, null);
  }
  
  public SearchEditText(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.editTextStyle);
  }
  
  public SearchEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setInputType(1);
    this.a = new SearchTaskTool((EditText)this);
  }
  
  public void a() {
    SearchTaskTool searchTaskTool = this.a;
    if (searchTaskTool != null)
      searchTaskTool.a(); 
  }
  
  public void a(SearchTaskTool.TaskListener paramTaskListener) {
    SearchTaskTool searchTaskTool = this.a;
    if (searchTaskTool != null)
      searchTaskTool.a(paramTaskListener); 
  }
  
  public void setDelaymillis(long paramLong) {
    SearchTaskTool searchTaskTool = this.a;
    if (searchTaskTool != null)
      searchTaskTool.a(paramLong); 
  }
  
  public void setEditorActionListener(boolean paramBoolean) {
    SearchTaskTool searchTaskTool = this.a;
    if (searchTaskTool != null)
      searchTaskTool.a(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SearchEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */