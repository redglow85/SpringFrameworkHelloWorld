package com.helloworld.bootrest.controller;

import com.helloworld.bootrest.dto.AddRequest;
import com.helloworld.bootrest.dto.AddResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RpcController {

    @PostMapping("/rpc/add")
    public AddResponse add(@RequestBody AddRequest request) {
        return new AddResponse(request.getA() + request.getB());
    }
}


