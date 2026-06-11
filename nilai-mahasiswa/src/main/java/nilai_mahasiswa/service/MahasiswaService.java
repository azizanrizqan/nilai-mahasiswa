package nilai_mahasiswa.service;

import nilai_mahasiswa.entity.Mahasiswa;
import nilai_mahasiswa.repository.MahasiswaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaService {

    private final MahasiswaRepository repository;

    public MahasiswaService(MahasiswaRepository repository) {
        this.repository = repository;
    }

    private String hitungGrade(int nilai) {
        if (nilai >= 85) return "A";
        if (nilai >= 75) return "B";
        if (nilai >= 65) return "C";
        if (nilai >= 50) return "D";
        return "E";
    }

    public Mahasiswa save(Mahasiswa mahasiswa) {
        mahasiswa.setGrade(hitungGrade(mahasiswa.getNilai()));
        return repository.save(mahasiswa);
    }

    public List<Mahasiswa> findAll() {
        return repository.findAll();
    }

    public Mahasiswa findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Mahasiswa update(Long id, Mahasiswa mahasiswaBaru) {

        Mahasiswa mahasiswa = repository.findById(id).orElse(null);

        if (mahasiswa != null) {
            mahasiswa.setNim(mahasiswaBaru.getNim());
            mahasiswa.setNama(mahasiswaBaru.getNama());
            mahasiswa.setNilai(mahasiswaBaru.getNilai());
            mahasiswa.setGrade(hitungGrade(mahasiswaBaru.getNilai()));

            return repository.save(mahasiswa);
        }

        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}