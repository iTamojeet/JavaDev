package com.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

public class Test {
    static void main() {
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        ResponseCreateParams params = new ResponseCreateParams.Builder()
                .input("You work in tinder as a software engineer. How does it feel?")
                .model("gpt-5.4")
                .build();

        Response response = client.responses().create(params);
        StringBuffer sb = new StringBuffer();

        response.output().stream()
                .map(Object::toString)
                .forEach(str -> {
                    int start = str.indexOf("text=") + 5;
                    int end = str.indexOf(", type=output_text");
                    if (start > 4 && end > start) {
                        sb.append(str, start, end);
                    }
                });

        System.out.print(sb.toString());
    }
}
