package nilai_mahasiswa.repository;

import nilai_mahasiswa.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    
}
