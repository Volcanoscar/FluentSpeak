package com.aaron.fluentspeak.http;

import android.app.ProgressDialog;
import android.content.Context;

import com.aaron.fluentspeak.R;
import com.aaron.fluentspeak.http.parse.JsonParse;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

/**
 * Created on 下午1:39.
 * 请求回调
 * @param <T> BaseResult
 * @author ran.huang
 * @version 1.0.0
 */
public abstract class RequestCallback<T extends BaseResult> extends AsyncHttpResponseHandler {
    private ProgressDialog mProgressDialog;
    private Context mContext;
    private Class<T> mCls;

    /**
     * Constructor
     * @param context 上下文资源
     * @param cls Class<T>
     */
    public RequestCallback(Context context, Class<T> cls) {
        mContext = context;
        mCls = cls;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String response = new String(responseBody);
        T t = new JsonParse<T>(mCls).parse(response);
        /**TODO 在此添加网络数据缓存逻辑(可根据url的唯一标识来进行内存缓存和文件缓存)*/
        onSuccess(t);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        onFailure(statusCode);
    }

    @Override
    public void onStart() {
        super.onStart();
        showDialog(mContext);
    }

    @Override
    public void onFinish() {
        super.onFinish();
        dissmissDialog();
    }

    private void showDialog(Context context) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
        }
        mProgressDialog.setMessage(context.getString(R.string.request_loading));
        mProgressDialog.show();
    }

    private void dissmissDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * 请求成功
     * @param result T extends BaseResult
     */
    public abstract void onSuccess(T result);

    /**
     * 请求失败
     * @param statusCode 错误码
     */
    public abstract void onFailure(int statusCode);
}
