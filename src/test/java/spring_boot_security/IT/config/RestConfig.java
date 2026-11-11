//package spring_boot_security.IT.config;

//@Configuration
//public class RestConfig {
//
//    @Value("${jwt.token}")
//    private String token;
//
//    @Bean
//    public TestRestTemplate restTemplate() {
//        return new TestRestTemplate(new RestTemplateBuilder()
//                .defaultHeader("Authorization", "Bearer ".concat(token))
//                .connectTimeout(Duration.ofSeconds(10))
//                .rootUri("http://localhost:8080")
//        );
//    }
//}