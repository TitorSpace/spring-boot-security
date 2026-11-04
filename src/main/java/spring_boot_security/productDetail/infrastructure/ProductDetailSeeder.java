package spring_boot_security.productDetail.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
@RequiredArgsConstructor
@Profile("!test & !prod")
public class ProductDetailSeeder implements CommandLineRunner {

    private final QueryProductDetailRepository queryProductDetailRepository;
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {

        long count = queryProductDetailRepository.count();

        if (count == 0) {

            Resource resource = resourceLoader.getResource("classpath:products_details.json");

            List<ProductDetailEntity> productDetailEntities = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
            });

            queryProductDetailRepository.saveAll(productDetailEntities);
        }

    }
}
