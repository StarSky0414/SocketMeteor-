package controller;

import bean.AdapterResponseBean;

/**
 * 适配器接口
 */
abstract public class AdapterI {
    String json;
    public void setAdapterResponseBean(String json) {
        this.json = json;
    }

    abstract public AdapterResponseBean getAdapterResponse();

}
