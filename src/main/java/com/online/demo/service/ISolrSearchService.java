package com.online.demo.service;

import com.online.demo.entity.TContent;

import java.util.List;
import java.util.Map;

public interface ISolrSearchService {

    public int addOrUpdateContentToSolr(TContent content);

    public int addOrUpdateContentListToSolr(List<TContent> contentList);

    public int deleteContentById(int id);

    public int deleteContentByIdList(List<Integer> idList);

    public List<TContent> findContentByConditions(Map<String, String> conditions);




}
