package com.ufuk.itextpdf.Controller;

import com.ufuk.itextpdf.Service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("pdf")
@RequiredArgsConstructor
public class PdfController {
    private final PdfService pdfService;

    @GetMapping("create")
    public void pdfCreate() throws Exception {
        pdfService.getpdf();
    }
}
