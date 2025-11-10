package ma.fstt.commandeservice.openFeign;
import ma.fstt.commandeservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCTS-SERVICE")
public interface ProductFeignClient {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);

}