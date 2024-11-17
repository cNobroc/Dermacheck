package pe.edu.upc.dermacheck.serviceinterfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IUploadService {
    void init() throws IOException;
    String store(MultipartFile file) throws IOException;
    Resource loadAsResource(String filename);
}