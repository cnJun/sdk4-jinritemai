package com.sdk4.jinritemai.model.response;

import com.sdk4.jinritemai.DoudianResponse;
import com.sdk4.jinritemai.model.bean.DoudianShopCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoudianShopGetShopCategoryResponse extends DoudianResponse<List<DoudianShopCategory>> {
}
