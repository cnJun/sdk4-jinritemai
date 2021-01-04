package com.sdk4.jinritemai.model.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoudianSpec {
    /**
     * 规格id
     */
    private Long id;

    /**
     * 规格名称
     */
    private String name;

    /**
     * 规格信息
     */
    private List<Spec> specs;

    @Getter
    @Setter
    public static class Spec extends SpecValue {
        private Long id;
        private Long specId;
        private String name;
        private Long pid;
        private Integer isLeaf;
        private List<SpecValue> values;
    }

    @Getter
    @Setter
    public static class SpecValue {
        private Long id;
        private Long specId;
        private String name;
        private Long pid;
        private Integer isLeaf;
        private Integer status;
    }
}
