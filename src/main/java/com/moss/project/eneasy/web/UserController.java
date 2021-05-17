package com.moss.project.eneasy.web;

import com.moss.project.eneasy.dto.UserDto;
import com.moss.project.eneasy.entity.Topic;
import com.moss.project.eneasy.exception.UserAlreadyExistException;
import com.moss.project.eneasy.service.TopicService;
import com.moss.project.eneasy.service.UserService;
import com.moss.project.eneasy.web.request.AddTopicRequest;
import com.moss.project.eneasy.web.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Taner YILDIRIM
 */

@RestController
@RequestMapping(value = "/user")
@Api(value = "/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/registerUser")
    @ApiOperation(value = "Register user")
    public ResponseEntity<BaseResponse<Long>> registerUser(@ApiParam(value = "Register User", required = true) @RequestBody UserDto userDto) {
        Long id = userService.registerNewUserAccount(userDto);
        return ResponseEntity.ok(new BaseResponse<Long>(id));
    }

    @GetMapping("/existEmail")
    @ApiOperation(value = "Register user")
    public ResponseEntity<BaseResponse<Long>> existEmail(@RequestParam(value = "email") String email) throws UserAlreadyExistException {
        userService.existEmail(email);
        return ResponseEntity.ok(new BaseResponse<String>("OK"));
    }

    @GetMapping("/existUsername")
    @ApiOperation(value = "Register user")
    public ResponseEntity<BaseResponse<Long>> existUsername(@RequestParam(value = "username") String username) throws UserAlreadyExistException {
        userService.existUsername(username);
        return ResponseEntity.ok(new BaseResponse<String>("OK"));
    }
}