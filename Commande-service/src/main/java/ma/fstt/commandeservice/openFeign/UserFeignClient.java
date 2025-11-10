package ma.fstt.commandeservice.openFeign;

import ma.fstt.commandeservice.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);
}