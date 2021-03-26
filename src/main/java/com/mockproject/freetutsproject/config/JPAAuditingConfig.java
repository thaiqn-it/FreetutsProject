package com.mockproject.freetutsproject.config;

//@Configuration
//@EnableJpaAuditing (auditorAwareRef = "AuditorProvider")
public class JPAAuditingConfig {
//    @Bean
//    public AuditorAware<AdminEntity> AuditorProvider(){
//        return new AuditorAwareImpl();
//    }
//
//    public static class AuditorAwareImpl implements AuditorAware<AdminEntity>{
//
//        @Autowired
//        private AdminRepository adminRepository;
//
//        @Override
//        public Optional<AdminEntity> getCurrentAuditor() {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            if (authentication == null){
//                return Optional.empty();
//            }
//            System.out.println(authentication.getName());
//            System.out.println(adminRepository == null);
//            AdminEntity admin = adminRepository.findByUsernameAndAvailableTrue(authentication.getName());
//            System.out.println(admin.getFullname());
//            return Optional.ofNullable(admin);
//        }
//    }

}
