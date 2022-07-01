package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

class CursorFilter extends Filter {
  CursorFilterClient a;
  
  CursorFilter(CursorFilterClient paramCursorFilterClient) {
    this.a = paramCursorFilterClient;
  }
  
  public CharSequence convertResultToString(Object paramObject) {
    return this.a.convertToString((Cursor)paramObject);
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence) {
    Cursor cursor = this.a.runQueryOnBackgroundThread(paramCharSequence);
    Filter.FilterResults filterResults = new Filter.FilterResults();
    if (cursor != null) {
      filterResults.count = cursor.getCount();
      filterResults.values = cursor;
      return filterResults;
    } 
    filterResults.count = 0;
    filterResults.values = null;
    return filterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults) {
    Cursor cursor = this.a.getCursor();
    if (paramFilterResults.values != null && paramFilterResults.values != cursor)
      this.a.changeCursor((Cursor)paramFilterResults.values); 
  }
  
  static interface CursorFilterClient {
    void changeCursor(Cursor param1Cursor);
    
    CharSequence convertToString(Cursor param1Cursor);
    
    Cursor getCursor();
    
    Cursor runQueryOnBackgroundThread(CharSequence param1CharSequence);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cursoradapter\widget\CursorFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */