package com.online.demo.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

@Configuration
public class SpringDataSolrConfig {

    @Autowired
    private SolrClient solrClient;

    @Bean
    public SolrTemplate getSolrTemplate(){

        SolrTemplate solrTemplate = new SolrTemplate(solrClient);

        return solrTemplate;
    }

}
