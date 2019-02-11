package controller;

import bean.AdapterResponseBean;
import bean.SyncMessageRequestBean;
import bean.SyncTrendsBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.entity.TrendsEntity;
import db.mysql.provider.TrendsSyncProviderBaseMapper;

import java.util.List;

public class SyncTrendsController extends AdapterI{

    private SyncTrendsBean resolveJson(){
        SyncTrendsBean syncTrendsBean = JSONObject.parseObject(json, SyncTrendsBean.class);
        return syncTrendsBean;
    }

    @Override
    public AdapterResponseBean getAdapterResponse() {
        return null;
    }

//    @Override
//    public AdapterResponseBean getAdapterResponse() {
//        SyncTrendsBean syncTrendsBean = resolveJson();
//        String locatTrendsId = syncTrendsBean.getLocatTrendsId();
//        TrendsSyncProviderBaseMapper trendsSyncProviderBaseMapper = new TrendsSyncProviderBaseMapper();
//        List<TrendsEntity> trendsEntities = trendsSyncProviderBaseMapper.syncTrendsContent(locatTrendsId);
//        String s = JSONObject.toJSONString(trendsEntities);
//        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("1", s);
//        return adapterResponseBean;
//    }
}
