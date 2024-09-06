package mi_gestion_tareas_api.repositorio;

import mi_gestion_tareas_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTask extends JpaRepository<Task, Long> {
}
