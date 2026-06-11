package nilai_mahasiswa.controller;

import nilai_mahasiswa.entity.Mahasiswa;
import nilai_mahasiswa.service.MahasiswaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tambah")
    public String tambahForm(Model model) {

        model.addAttribute(
                "mahasiswa",
                new Mahasiswa()
        );

        return "form";
    }

    @PostMapping("/simpan")
    public String simpan(
            @ModelAttribute Mahasiswa mahasiswa) {

        service.save(mahasiswa);

        return "redirect:/";
    }
    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editForm(
        @PathVariable Long id,
        Model model) {

        model.addAttribute(
            "mahasiswa",
            service.findById(id)
     );

        return "edit";
    }

    @PostMapping("/update/{id}")
    public String update(
        @PathVariable Long id,
        @ModelAttribute Mahasiswa mahasiswa) {

        service.update(id, mahasiswa);

        return "redirect:/";
    }
}