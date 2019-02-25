package com.example.wechat;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

/**
 * @author chxbca
 */
public class ImageController {

    @GetMapping("/showVideo")
    public ResponseEntity<byte[]> showVideo(@RequestParam("name") String name) throws Exception {
        File video = new File(name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("image/png"));
        headers.setCacheControl("s-maxage=2592000, max-age=2592000");
        return new ResponseEntity<>(FileUtils.readFileToByteArray(video), headers, HttpStatus.OK);
    }

}
