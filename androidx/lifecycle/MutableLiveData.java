package androidx.lifecycle;

public class MutableLiveData<T> extends LiveData<T> {
  public MutableLiveData() {}
  
  public MutableLiveData(T paramT) {
    super(paramT);
  }
  
  public void postValue(T paramT) {
    super.postValue(paramT);
  }
  
  public void setValue(T paramT) {
    super.setValue(paramT);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\lifecycle\MutableLiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */