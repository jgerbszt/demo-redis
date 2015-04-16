package pl.javour;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoRepository demoRepository;

    @Autowired
    public DemoController(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @RequestMapping(value="/entries/{key}", method=RequestMethod.PUT)
    public String put(@PathVariable String key, @RequestBody String value) {
        demoRepository.put(key, value);
        return "DONE";
    }
    
    @RequestMapping(value="/entries/{key}", method=RequestMethod.GET)
    public String get(@PathVariable String key) {
        return demoRepository.get(key);
    }
    
    @RequestMapping(value="/entries", method=RequestMethod.GET)
    public Map<String, String> getAll() {
        return demoRepository.getAll();
    }
}
