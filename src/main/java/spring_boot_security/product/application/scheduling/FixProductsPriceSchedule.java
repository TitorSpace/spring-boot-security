package spring_boot_security.product.application.scheduling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring_boot_security.product.domain.port.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j //Genera logs
public class FixProductsPriceSchedule {

    private final ProductRepository productRepository;

//    @Scheduled(fixedRate = 5000)
//    public void fixProductPrice() {
//        log.info("Fixing products price");
//
//        productRepository.findAll().forEach(product -> {
//            product.setPrice(product.getPrice() * 1.1);
//            productRepository.upsert(product);
//        });
//
//        log.info("Finished fixing products price");
//    }
}
