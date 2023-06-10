package com.codingrecipe.member.controller;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "login";
    }

//    @Autowired
//    private OkHttpClient client;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/test")
    public String getRecentlyPlayedGames(Model model) throws IOException {
        // 최근에 플레이한 게임 가져오기
        String userId = "76561198406181016";  // Steam 사용자 ID를 여기에 입력하세요
        String apiKey = "DF5327BBE24F8A2E1DDA5BDE0FB1819C"; // Steam API 키를 여기에 입력하세요
        String url = "https://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v1/?key=" + apiKey + "&steamid=" + userId + "&format=json";


        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        //try (Response response = client.newCall(request).execute()) {
            //String jsonData = response.body().string();
            Map<String, Object> data = mapper.readValue(result, Map.class);
            Map<String, Object> responseMap = (Map<String, Object>) data.get("response");
            Object gamesObject = responseMap.get("games");
            model.addAttribute("games", gamesObject);

            // 게임 세부 정보 가져오기
//            Map<String, Object> gamesMap = (Map<String, Object>) model.getAttribute("games");
//            for (Map.Entry<String, Object> entry : gamesMap.entrySet()) {
//                String appid = entry.getKey();
//                String appDetailsUrl = "https://store.steampowered.com/api/appdetails?appids=" + appid;
//                Request appDetailsRequest = new Request.Builder().url(appDetailsUrl).build();
//                try (Response appDetailsResponse = client.newCall(appDetailsRequest).execute()) {
//                    String appDetailsJsonData = appDetailsResponse.body().string();
//                    Map<String, Object> appDetailsData = mapper.readValue(appDetailsJsonData, Map.class);
//                    Map<String, Object> appDetailsMap = (Map<String, Object>) appDetailsData.get(appid);
//                    gamesMap.put(appid, appDetailsMap.get("data"));
//                }
//            }
        //}

        return "index";
    }
}
