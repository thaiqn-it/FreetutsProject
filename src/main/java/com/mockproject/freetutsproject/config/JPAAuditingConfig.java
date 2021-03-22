package com.mockproject.freetutsproject.config;

import com.mockproject.freetutsproject.entity.AdminEntity;
import com.mockproject.freetutsproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing (auditorAwareRef = "AuditorProvider")
public class JPAAuditingConfig {

    @Bean
    public AuditorAware<AdminEntity> AuditorProvider(){
        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<AdminEntity>{

        @Autowired
        private AdminRepository adminRepository;

        @Override
        public Optional<AdminEntity> getCurrentAuditor() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null){
                return Optional.empty();
            }
            AdminEntity admin = adminRepository.findByUsername(authentication.getName());
            return Optional.of(admin);
        }
    }

}
