package controller;

import bean.AdapterResponseBean;

public class SafeController extends AdapterI {

    public AdapterResponseBean getAdapterResponse() {
        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("sessionFail","The Session is Fail ,Android to LoginActive !","");
        return  adapterResponseBean;
    }
}
