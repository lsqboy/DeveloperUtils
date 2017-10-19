/**
 * Copyright 2016 JustWayward Team
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wktx.app.ztecoordinatorlayout.wifi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.wktx.app.ztecoordinatorlayout.R;
import com.wktx.app.ztecoordinatorlayout.utils.NetworkUtils;


public class WifiBookActivity extends AppCompatActivity {
    TextView mTvWifiName;
    TextView mTvWifiIp;
    TextView tvRetry;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, WifiBookActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_book);
        mTvWifiName = (TextView) findViewById(R.id.mTvWifiName);
        mTvWifiIp = (TextView) findViewById(R.id.mTvWifiIp);
        tvRetry = (TextView) findViewById(R.id.tvRetry);
        initDatas();
    }

    public void initDatas() {
        String wifiname = NetworkUtils.getConnectWifiSsid(this);
        if (!TextUtils.isEmpty(wifiname)) {
            mTvWifiName.setText(wifiname.replace("\"", ""));
        } else {
            mTvWifiName.setText("Unknow");
        }

        String wifiIp = NetworkUtils.getConnectWifiIp(this);
        if (!TextUtils.isEmpty(wifiIp)) {
            tvRetry.setVisibility(View.GONE);
            mTvWifiIp.setText("http://" + NetworkUtils.getConnectWifiIp(this) + ":" + Defaults.getPort());
            // 启动wifi传书服务器
            ServerRunner.startServer();
        } else {
            mTvWifiIp.setText("请开启Wifi并重试");
            tvRetry.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onBackPressed() {
        if (ServerRunner.serverIsRunning) {
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("确定要关闭？Wifi传书将会中断！")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ServerRunner.stopServer();
    }
}
