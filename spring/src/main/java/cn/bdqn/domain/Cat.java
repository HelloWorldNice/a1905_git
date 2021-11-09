package cn.bdqn.domain;

import java.util.*;

public class Cat {

    private String[] arrs;

    private List<String> arrList;

    private Set<String> arrSet;

    private Map<String,Object> arrMap;

    private Properties props;

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setArrMap(Map<String, Object> arrMap) {
        this.arrMap = arrMap;
    }

    public void setArrSet(Set<String> arrSet) {
        this.arrSet = arrSet;
    }

    public void setArrList(List<String> arrList) {
        this.arrList = arrList;
    }

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "arrs=" + Arrays.toString(arrs) +
                ", arrList=" + arrList +
                ", arrSet=" + arrSet +
                ", arrMap=" + arrMap +
                ", props=" + props +
                '}';
    }
}
