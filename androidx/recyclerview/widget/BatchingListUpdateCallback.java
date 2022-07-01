package androidx.recyclerview.widget;

public class BatchingListUpdateCallback implements ListUpdateCallback {
  final ListUpdateCallback a;
  
  int b = 0;
  
  int c = -1;
  
  int d = -1;
  
  Object e = null;
  
  public BatchingListUpdateCallback(ListUpdateCallback paramListUpdateCallback) {
    this.a = paramListUpdateCallback;
  }
  
  public void dispatchLastEvent() {
    int i = this.b;
    if (i == 0)
      return; 
    if (i != 1) {
      if (i != 2) {
        if (i == 3)
          this.a.onChanged(this.c, this.d, this.e); 
      } else {
        this.a.onRemoved(this.c, this.d);
      } 
    } else {
      this.a.onInserted(this.c, this.d);
    } 
    this.e = null;
    this.b = 0;
  }
  
  public void onChanged(int paramInt1, int paramInt2, Object paramObject) {
    if (this.b == 3) {
      int i = this.c;
      int j = this.d;
      if (paramInt1 <= i + j) {
        int k = paramInt1 + paramInt2;
        if (k >= i && this.e == paramObject) {
          this.c = Math.min(paramInt1, i);
          this.d = Math.max(j + i, k) - this.c;
          return;
        } 
      } 
    } 
    dispatchLastEvent();
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramObject;
    this.b = 3;
  }
  
  public void onInserted(int paramInt1, int paramInt2) {
    if (this.b == 1) {
      int i = this.c;
      if (paramInt1 >= i) {
        int j = this.d;
        if (paramInt1 <= i + j) {
          this.d = j + paramInt2;
          this.c = Math.min(paramInt1, i);
          return;
        } 
      } 
    } 
    dispatchLastEvent();
    this.c = paramInt1;
    this.d = paramInt2;
    this.b = 1;
  }
  
  public void onMoved(int paramInt1, int paramInt2) {
    dispatchLastEvent();
    this.a.onMoved(paramInt1, paramInt2);
  }
  
  public void onRemoved(int paramInt1, int paramInt2) {
    if (this.b == 2) {
      int i = this.c;
      if (i >= paramInt1 && i <= paramInt1 + paramInt2) {
        this.d += paramInt2;
        this.c = paramInt1;
        return;
      } 
    } 
    dispatchLastEvent();
    this.c = paramInt1;
    this.d = paramInt2;
    this.b = 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\BatchingListUpdateCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */