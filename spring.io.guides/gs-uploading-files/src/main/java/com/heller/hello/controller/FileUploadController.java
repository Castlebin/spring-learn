package com.heller.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String provideUploadInfo() {
        return "Your can upload a file by posting to the same URL.";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleFileUpload(String name, MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();

                return "You successfully uploaded " + name + "!";
            } catch (IOException e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}
