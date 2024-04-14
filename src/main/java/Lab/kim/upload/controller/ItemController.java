package Lab.kim.upload.controller;

import Lab.kim.upload.domain.Item;
import Lab.kim.upload.domain.ItemRepository;
import Lab.kim.upload.domain.UploadFile;
import Lab.kim.upload.file.FileStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final FileStore fileStore;

    @GetMapping("/items/new")
    public String newItem(@ModelAttribute ItemForm form) {
        return "item-form";
    }

    @PostMapping("/items/new")
    public String saveItem(@ModelAttribute ItemForm form, RedirectAttributes ra) throws IOException {
        UploadFile attachFile = fileStore.storeFile(form.getAttachFile());
        List<UploadFile> imageFiles = fileStore.storeFiles(form.getImageFiles());

        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setAttachFile(attachFile);
        item.setImageFiles(imageFiles);
        Item save = itemRepository.save(item);

        ra.addAttribute("itemId", save.getId());
        return "redirect:/items/{itemId}";
    }
    @GetMapping("/items/{id}")
    public String items(@PathVariable Long id, Model model) {
        Item item = itemRepository.findById(id);
        model.addAttribute("item", item);
        return "item-view";
    }
    //이미지는 바이트 코드로 되어있기 때문에 ResponseBody를 사용해서 바이트코드로 이미지를 반환한다.
    @ResponseBody
    @GetMapping("/images/{filename}")
    public UrlResource downloadImage(@PathVariable String filename) throws MalformedURLException {
        //UrlResource를 해주는 이유
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }
    @GetMapping("/attach/{itemId}")
    public ResponseEntity<UrlResource> downloadAttach(@PathVariable Long itemId) throws MalformedURLException {
        Item item = itemRepository.findById(itemId);
        String storeFileName = item.getAttachFile().getStoreFileName();
        String uploadFileName = item.getAttachFile().getUploadFileName();

        UrlResource urlResource = new UrlResource("file:" + fileStore.getFullPath(storeFileName));
        log.info("urlResource: {}", urlResource);

        //특수문자 및 한글파일 깨지지 않게하기 위해
        String encodedFilename = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
        log.info("encodedFilename: {}", encodedFilename);
        //실제 파일을 다운로드 받기 위해
        /*String contentDisposition = "attachment; filename=\"" + uploadFileName + "\"";*/
        String contentDisposition = "attachment; filename=\"" + encodedFilename + "\"";
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition).body(urlResource);
    }
}
