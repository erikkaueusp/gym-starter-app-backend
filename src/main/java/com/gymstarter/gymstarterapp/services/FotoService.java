package com.gymstarter.gymstarterapp.services;

import com.gymstarter.gymstarterapp.FormAluno;
import com.gymstarter.gymstarterapp.utils.ManipulaImagem;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FotoService {


    private final Path root = Paths.get("uploads");

    private void init() {
        try {
            if(Files.exists(root)) {
                System.out.println("Diretório já existe");
            } else {
            Files.createDirectory(root);
            }

        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public String save(MultipartFile file, FormAluno formAluno) {
        this.init();
        try {
            Files.copy(resizeImage(file), this.root.resolve(formAluno.getNome() + ".jpeg"));
            String caminhoImagem = root.toAbsolutePath().resolve(formAluno.getNome() + ".jpeg").toString();
            return caminhoImagem;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    private InputStream resizeImage(MultipartFile file) throws IOException {
        BufferedImage imBuff = ImageIO.read(file.getInputStream());
        if(imBuff.getHeight() > 400 || imBuff.getWidth()> 400) {
            BufferedImage bufferedImage = ManipulaImagem.resizeImage(imBuff, 400, 400);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpeg", os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
            return is;
        } else {
            return file.getInputStream();
        }
    }
//    @Override
//    public Resource load(String filename) {
//        try {
//            Path file = root.resolve(filename);
//            Resource resource = new UrlResource(file.toUri());
//            if (resource.exists() || resource.isReadable()) {
//                return resource;
//            } else {
//                throw new RuntimeException("Could not read the file!");
//            }
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("Error: " + e.getMessage());
//        }
//    }
//    @Override
//    public void deleteAll() {
//        FileSystemUtils.deleteRecursively(root.toFile());
//    }
//    @Override
//    public Stream<Path> loadAll() {
//        try {
//            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
//        } catch (IOException e) {
//            throw new RuntimeException("Could not load the files!");
//        }
//    }
}

