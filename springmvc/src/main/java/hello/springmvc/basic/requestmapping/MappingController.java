package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private final Logger log = LoggerFactory.getLogger(MappingController.class);

    @RequestMapping(value = {"/hello-basic", "hello-go"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("helloBasic");
        return "OK";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String helloBasicV2() {
        log.info("helloBasicV2");
        return "OK";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "OK";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "OK";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug ( ! = )
     * prams= {"mode=debug", "data=good"}
     *
     * @return
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "OK";
    }

    /**
     * 파라미터로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug ( ! = )
     *
     * @return
     */
    @GetMapping(value = "/mapping-param", headers = "mode=debug")
    public String mappingHeaders() {
        log.info("mappingHeaders");
        return "OK";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     * @return
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "OK";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces="text/html"
     * produces="!text/html"
     * produces="text/*"
     * produces="*\/*"
     * @return
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "OK";
    }
}
