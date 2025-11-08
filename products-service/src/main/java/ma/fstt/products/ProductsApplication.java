package ma.fstt.products;

import ma.fstt.products.entities.Product;
import ma.fstt.products.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}




	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder()
					.nom("phone")
				 	.prix(1000.0)
					.stock(10)
					.build());
			productRepository.save(Product.builder()
					.nom("tele")
					.prix(10000.0)
					.stock(102	)
					.build());


		};
	}
}
