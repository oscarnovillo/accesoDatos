/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienteweb;

import java.io.File;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author profesor
 */
public class FormUpload {

    public static void main(String[] args) throws IOException {

        String url = "http://localhost:8080/mavenprojectWeb/upload";
        File file = new File("/home/profesor/Imágenes/img1.png");

        MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();

        multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        multipartEntity.addTextBody("destination", "../");
        multipartEntity.addBinaryBody("file", file);


        HttpPost post = new HttpPost(url);
        post.setEntity(multipartEntity.build());

        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(post);
        String html = EntityUtils.toString(response.getEntity());

        System.out.println(html);

    }

}
