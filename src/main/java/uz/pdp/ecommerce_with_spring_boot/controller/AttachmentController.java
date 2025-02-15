package uz.pdp.ecommerce_with_spring_boot.controller;

import java.io.IOException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.ecommerce_with_spring_boot.entity.Attachment;
import uz.pdp.ecommerce_with_spring_boot.entity.AttachmentContent;
import uz.pdp.ecommerce_with_spring_boot.repo.AttachmentRepository;
import uz.pdp.ecommerce_with_spring_boot.repo.AttachmentContentRepository;

@RestController
@MultipartConfig
@RequestMapping("/file")
public class AttachmentController {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    public AttachmentController(AttachmentRepository attachmentRepository,
                                AttachmentContentRepository attachmentContentRepository) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentContentRepository = attachmentContentRepository;
    }

    @GetMapping("/{attachmentId}")
    public void getAttachment(@PathVariable("attachmentId") Integer attachmentId,
                              HttpServletResponse response) throws IOException {
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachmentId(attachmentId);
        response.getOutputStream()
                .write(attachmentContent.getContent());
    }

    @PostMapping
    public Integer upload(@RequestParam MultipartFile file) throws IOException {
        Attachment attachment = Attachment.builder()
                .filename(file.getOriginalFilename())
                .build();
        AttachmentContent attachmentContent = AttachmentContent
                .builder()
                .content(file.getBytes())
                .attachment(attachment)
                .build();

        attachmentRepository.save(attachment);
        attachmentContentRepository.save(attachmentContent);

        return attachment.getId();
    }
}