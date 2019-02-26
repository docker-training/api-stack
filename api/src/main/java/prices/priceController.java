package prices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/demo")
@Api(value="demoapi", description="A demo API block")
public class priceController {

    @ApiOperation(value = "Fetch the price corresponding to a product", response = Iterable.class)
    @RequestMapping(value = "/price", method = RequestMethod.GET)
    public Prices price(@RequestParam(value="name", defaultValue="widget") String name) {
        return new Prices(name);
    }
}
