package com.rubydev.justnow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yogiwisesa on 14/04/17.
 */

public class Provider {
    private List<String> providerList = new ArrayList<>();

    public Provider(List<String> providerList) {
        this.providerList = providerList;
    }

    public List<String> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<String> providerList) {
        this.providerList = providerList;
    }
}
