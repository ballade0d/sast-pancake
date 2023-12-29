package fun.sast.sastpancake.controller;

import fun.sast.sastpancake.pojo.Pancake;
import fun.sast.sastpancake.pojo.ResultData;
import fun.sast.sastpancake.service.PancakeService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class PancakeController {

    @Resource
    private PancakeService pancakeService;

    @GetMapping("/pancake")
    public ResultData getPancake() {
        return pancakeService.getPancake();
    }

    @PutMapping("/pancake")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResultData putPancake(@RequestBody Pancake pancake) {
        return pancakeService.putPancake(pancake);
    }

    @PostMapping("/pancake/{pancake_id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResultData postPancake(@PathVariable("pancake_id") int pancakeId) {
        return pancakeService.postPancake(pancakeId);
    }

    @DeleteMapping("/pancake/{pancake_id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResultData deletePancake(@PathVariable("pancake_id") int pancakeId) {
        return pancakeService.deletePancake(pancakeId);
    }
}
