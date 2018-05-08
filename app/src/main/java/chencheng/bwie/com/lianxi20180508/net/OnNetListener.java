package chencheng.bwie.com.lianxi20180508.net;

/**
 * Created by dell on 2018/5/8.
 */

public interface OnNetListener<T> {
   //成功
    public void onSuccess(T t);
//失败
    public void onFailure(Exception e);
}
