package com.dmm.controller;

import com.dmm.server.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/26 19:54
 * @motto The more learn, the more found his ignorance.
 */
@RestController
public class DemoController {

    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }

    @RequestMapping("/test/{toUserId}")
    public ResponseEntity<String> testToWeb(String message, @PathVariable String toUserId, HttpSession session) throws IOException {
        message="的妈妈们";
        WebSocketServer.aa(message);
        session.setAttribute("toUserId",message);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public Object sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("toUserId"));
        return map;
    }

}

