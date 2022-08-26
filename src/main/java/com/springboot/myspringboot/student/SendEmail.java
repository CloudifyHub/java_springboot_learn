package com.springboot.myspringboot.student;


import okhttp3.*;

import java.io.IOException;

public class SendEmail {

    public void sendEmail(String emailBody) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, emailBody);
        Request request = new Request.Builder()
                .url("https://api.sendgrid.com/v3/mail/send")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer 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")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }


}




