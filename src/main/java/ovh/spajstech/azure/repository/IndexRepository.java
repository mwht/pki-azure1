package ovh.spajstech.azure.repository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRepository {


    @GetMapping("/")
    public String getIndex()
    {
        return "Index";
    }
}
