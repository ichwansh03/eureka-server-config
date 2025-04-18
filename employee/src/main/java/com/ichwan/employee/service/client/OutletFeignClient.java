package com.ichwan.employee.service.client;

import com.ichwan.employee.dto.client.OutletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("outlet")
public interface OutletFeignClient {

    //call controller method from client
    @GetMapping(value="/api/fetch", consumes="application/json")
    public ResponseEntity<OutletDto> fetchOutletDetail(@RequestParam String phone);
}
