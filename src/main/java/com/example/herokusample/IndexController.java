package com.example.herokusample;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final UserMapper userMapper;
    private final DataSourceProperties dataSourceProperties;

    public IndexController(UserMapper userMapper, DataSourceProperties dataSourceProperties) {
        this.userMapper = userMapper;
        this.dataSourceProperties = dataSourceProperties;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userList", userMapper.selectAll());
        model.addAttribute("dataSource", dataSourceProperties);
        return "index";
    }
}
