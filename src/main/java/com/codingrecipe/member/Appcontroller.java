package com.codingrecipe.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@Controller
public class Appcontroller {

//    @Autowired
//    private OkHttpClient client;
//
//    @Autowired
//    private ObjectMapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(Appcontroller.class, args);
    }
/*
    @GetMapping("/")
    public String getRecentlyPlayedGames(Model model) throws IOException {
        // 최근에 플레이한 게임 가져오기
        String userId = "7E3C339E0AA90817C17EFCEE79D844E0";  // Steam 사용자 ID를 여기에 입력하세요
        String apiKey = "76561198217968237"; // Steam API 키를 여기에 입력하세요
        String url = "https://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v1/?key=" + apiKey + "&steamid=" + userId + "&format=json";
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            String jsonData = response.body().string();
            Map<String, Object> data = mapper.readValue(jsonData, Map.class);
            Map<String, Object> responseMap = (Map<String, Object>) data.get("response");
            Object gamesObject = responseMap.get("games");
            model.addAttribute("games", gamesObject);

            // 게임 세부 정보 가져오기
            Map<String, Object> gamesMap = (Map<String, Object>) model.getAttribute("games");
            for (Map.Entry<String, Object> entry : gamesMap.entrySet()) {
                String appid = entry.getKey();
                String appDetailsUrl = "https://store.steampowered.com/api/appdetails?appids=" + appid;
                Request appDetailsRequest = new Request.Builder().url(appDetailsUrl).build();
                try (Response appDetailsResponse = client.newCall(appDetailsRequest).execute()) {
                    String appDetailsJsonData = appDetailsResponse.body().string();
                    Map<String, Object> appDetailsData = mapper.readValue(appDetailsJsonData, Map.class);
                    Map<String, Object> appDetailsMap = (Map<String, Object>) appDetailsData.get(appid);
                    gamesMap.put(appid, appDetailsMap.get("data"));
                }
            }
        }

        return "index";
    }*/
}
