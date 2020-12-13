package com.online.demo.service.impl;

import com.online.demo.common.CommonStr;
import com.online.demo.entity.TContent;
import com.online.demo.service.ISolrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.HighlightQuery;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SolrServiceImpl implements ISolrService {

    @Autowired
    public SolrTemplate solrTemplate;

    // 添加一条
    @Override
    public int addOrUpdateContentToSolr(TContent content) {
        if (content == null) {
            return 1;
        }

        UpdateResponse response = solrTemplate.saveBean(CommonStr.COLLECTION_CONTENT, content);
        solrTemplate.commit(CommonStr.COLLECTION_CONTENT);

        return response.getStatus();
    }

    // 添加多条
    @Override
    public int addOrUpdateContentListToSolr(List<TContent> contentList) {
        if (contentList == null || contentList.size() == 0) {
            return 0;
        }

        for (TContent content : contentList) {
            UpdateResponse response = solrTemplate.saveBean(CommonStr.COLLECTION_CONTENT, content);
            if (response.getStatus() != 0) {
                log.info("content 插入失败{}");
                continue;
            }
        }
        solrTemplate.commit(CommonStr.COLLECTION_CONTENT);
        return 1;
    }

    // 根据id删除
    @Override
    public int deleteContentById(String id) {

        UpdateResponse response = solrTemplate.deleteByIds(CommonStr.COLLECTION_CONTENT, id);

        return response.getStatus();
    }

    // 根据id删除多个
    @Override
    public int deleteContentByIdList(List<String> idList) {

        UpdateResponse response = solrTemplate.deleteByIds(CommonStr.COLLECTION_CONTENT, idList);

        return response.getStatus();
    }

    // 条件查询  -- 显示高亮信息
    @Override
    public List<TContent> findContentByConditions(Map<String, String> conditions) {

        HighlightQuery query = new SimpleHighlightQuery();
        HighlightOptions highlightOptions = new HighlightOptions().addField("item_title");
        highlightOptions.addField("item_type");

        // <em style='color:black'> xxxxxx </em>
        highlightOptions.setSimplePrefix("<em style='color:black'>");
        highlightOptions.setSimplePostfix("</em>");

        // 查询关键字
        Criteria criteria = new Criteria("item_keywords").is(conditions.get("keywords"));
        query.addCriteria(criteria);

        return null;
    }
}
