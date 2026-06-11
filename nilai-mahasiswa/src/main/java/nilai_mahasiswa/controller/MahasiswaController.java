package nilai_mahasiswa.controller;

import nilai_mahasiswa.entity.Mahasiswa;
import nilai_mahasiswa.service.MahasiswaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

    private final MahasiswaService service;

    public MahasiswaController(MahasiswaService service) {
        this.service = service;
    }

    @PostMapping
    public Mahasiswa tambah(@RequestBody Mahasiswa mahasiswa) {
        return service.save(mahasiswa);
    }

    @GetMapping
    public List<Mahasiswa> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mahasiswa getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Mahasiswa update(
            @PathVariable Long id,
            @RequestBody Mahasiswa mahasiswa) {

        return service.update(id, mahasiswa);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);
        return "Data berhasil dihapus";
    }
}