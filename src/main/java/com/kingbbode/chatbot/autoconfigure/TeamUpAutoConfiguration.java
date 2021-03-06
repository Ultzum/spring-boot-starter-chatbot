package com.kingbbode.chatbot.autoconfigure;

import com.kingbbode.chatbot.autoconfigure.common.interfaces.MemberService;
import com.kingbbode.chatbot.autoconfigure.messenger.teamup.*;
import com.kingbbode.chatbot.autoconfigure.messenger.teamup.message.MessageService;
import com.kingbbode.chatbot.autoconfigure.messenger.teamup.templates.template.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by YG on 2017-07-10.
 */
@Configuration
@ConditionalOnProperty(prefix = "chatbot.teamup", name = "enabled", havingValue = "true")
@EnableConfigurationProperties({TeamUpProperties.class})
public class TeamUpAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TeamUpEventSensor teamUpEventSensor(){
        return new TeamUpEventSensor();
    }

    @Bean
    @ConditionalOnMissingBean
    public TeamUpTokenManager teamUpTokenManager(){
        return new TeamUpTokenManager();
    }

    @Bean
    @ConditionalOnMissingBean
    public TeamUpDispatcher teamUpDispatcher(){
        return new TeamUpDispatcher();
    }

    @Bean
    @ConditionalOnMissingBean
    public MessageService messageService(){
        return new MessageService();
    }

    @Bean
    @ConditionalOnMissingBean
    public Oauth2Template oauth2Template(){
        return new Oauth2Template();
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthTemplate authTemplate(){
        return new AuthTemplate();
    }

    @Bean
    @ConditionalOnMissingBean
    public EdgeTemplate edgeTemplate(){
        return new EdgeTemplate();
    }

    @Bean
    @ConditionalOnMissingBean
    public EventTemplate eventTemplate(){
        return new EventTemplate();
    }

    @Bean
    @ConditionalOnMissingBean
    public FileTemplate fileTemplate(){
        return new FileTemplate();
    }
    
    @Bean
    @ConditionalOnMissingBean
    public TeamUpMemberCached teamUpMemberCached(){
        return new TeamUpMemberCached();
    }

    @Bean(name = "teamUpMemberService")
    @ConditionalOnMissingBean
    public MemberService teamUpMemberService(){
        return new TeamUpMemberService();
    }
}
