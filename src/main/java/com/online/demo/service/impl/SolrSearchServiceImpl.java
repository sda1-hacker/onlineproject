package com.online.demo.service.impl;

import com.online.demo.entity.TContent;
import com.online.demo.service.ISolrSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SolrSearchServiceImpl implements ISolrSearchService {

    @Autowired
    public SolrTemplate solrTemplate;

    @Override
    public int addOrUpdateContentToSolr(TContent content) {
        return 0;
    }

    @Override
    public int addOrUpdateContentListToSolr(List<TContent> contentList) {
        return 0;
    }

    @Override
    public int deleteContentById(int id) {
        return 0;
    }

    @Override
    public int deleteContentByIdList(List<Integer> idList) {
        return 0;
    }

    @Override
    public List<TContent> findContentByConditions(Map<String, String> conditions) {
        return null;
    }
}
