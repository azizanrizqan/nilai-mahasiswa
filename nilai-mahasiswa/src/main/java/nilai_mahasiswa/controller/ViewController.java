package nilai_mahasiswa.controller;

import nilai_mahasiswa.service.MahasiswaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final MahasiswaService service;

    public ViewController(MahasiswaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("listMahasiswa", service.findAll());
        return "index";
    }
}